/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;

/**
 * A modifiable specification of the application of a template pattern.
 * @author Olivier Constant
 */
public class TemplatePatternApplicationSpecification extends AbstractMultiRoleSelection implements IMultiRoleBasedSpecification {

  /** The potentially null application */
  private BasicPatternApplication _application;

  /** The non-null, non-empty list of selected elements */
  private final List<EObject> _modelElements;

  /** Whether the instance must be unfolded when created */
  private boolean _unfoldWhenDone;

  /** Whether the instance must be displayed when created */
  private boolean _displayWhenDone;

  /** Whether predefined layout data must be used if present in the pattern */
  private boolean _reuseLayout;

  // SKANDER::BEGIN
  /** Whether predefined style data must be used if present in the pattern */
  private boolean _reuseStyle;
  // SKANDER::END

  /** The number of instances to create */
  private int _numberOfApplications;

  /** The multiplicity of the instance */
  private int _multiplicity;

  /** The naming rule for the unfolded elements */
  private String _namingRule;

  /**
   * Constructor
   * @param pattern_p a non-null pattern
   * @param initialSelection_p a non-null, non-empty list of elements
   */
  public TemplatePatternApplicationSpecification(List<? extends Object> initialSelection_p) {
    _application = null;
    _modelElements = new FOrderedSet<EObject>();
    for(Object obj : initialSelection_p){
      if(obj instanceof EObject){
        _modelElements.add((EObject) obj);
      }
    }
    _unfoldWhenDone = true;
    _reuseLayout = true;
    _reuseStyle = true;
    _displayWhenDone = true;
    _numberOfApplications = 1;
    _multiplicity = 1;
    _namingRule = NamingUtil.getNeutralRenamingRule();
  }

  /**
   * Initialize the given application based on the given selected elements
   * @param application_p a non-null application
   * @param elements_p a non-null, non-empty collection
   */
  private void applyDefaultAssociation(BasicPatternApplication application_p, Collection<? extends EObject> elements_p) {
    Iterator<? extends EObject> it = elements_p.iterator();
    while (!application_p.isComplete() && it.hasNext()) {
      EObject current = it.next();
      applyDefaultAssociation(application_p, current);
    }
  }

  /**
   * Initialize the given application based on the given element
   * @param application_p a non-null application
   * @param element_p a non-null element
   */
  private void applyDefaultAssociation(BasicPatternApplication application_p, EObject element_p) {
    ISemanticRuleProvider ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(element_p);
    for (TemplatePatternRole role : getPattern().getRoles()) {
      if (!application_p.isCompleteOn(role) && role.acceptsAddition()) {
        EClass type = ModelsUtil.getCommonType(role.getTemplateElements());
        if (type != null) {
          List<EReference> containments = ruleProvider.getReferencesForAddition(element_p, type, true, true);
          if(containments != null){
        	  if (containments.size() == 1) {
                  EReference containment = containments.get(0);
                  if (ruleProvider.supportsAdditionOf(element_p, containment, role.getTemplateElements(), true)) {
                    IReferenceLocation location = new BasicReferenceLocation(element_p, containment);
                    application_p.setLocation(role, location);
                  }
              }
          } 
        }
      }
    }
  }

  /**
   * Return the roles to which the given model element is mapped for addition, if any
   * @param modelElement_p a non-null element within the model scope
   * @return a non-null, potentially empty, unmodifiable list
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<TemplatePatternRole> getAdditionRolesOf(EObject modelElement_p) {
    List<TemplatePatternRole> result;
    if (getApplication() != null) {
      result = (List) getApplication().getAdditionRolesOf(modelElement_p);
    } else {
      result = Collections.emptyList();
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#getAllElements()
   */
  public Collection<EObject> getAllElements() {
    return ModelsUtil.getAllContents(getSelectedElements(), true, null);
  }

  /**
   * Return all applicable addition locations for the given element and the given role
   * @param role_p a potentially null role
   * @param element_p a non-null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public Collection<IReferenceLocation> getApplicableAdditionLocations(TemplatePatternRole role_p, EObject element_p) {
    Collection<IReferenceLocation> result = new ArrayList<IReferenceLocation>();
    if ((role_p != null) && role_p.acceptsAddition()) {
      if (role_p.getAdditionKind() == AdditionKind.PREFERRED_CONTAINMENT) {
        // Preferred containment only
        EReference preferred = role_p.getPreferredContainment();
        if (element_p.eClass().getEAllContainments().contains(preferred)) {
          IReferenceLocation location = new BasicReferenceLocation(element_p, preferred);
          result.add(location);
        }
      } else {
        // Any compatible containment
        EClass requirement = ModelsUtil.getCommonType(role_p.getTemplateElements());
        ISemanticRuleProvider ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(element_p);
        List<EReference> references = ruleProvider.getReferencesForAddition(element_p, requirement, true, true);
        if(references != null){
        	for (EReference reference : references) {
        		IReferenceLocation location = new BasicReferenceLocation(element_p, reference);
                result.add(location);
            }	
        } 
      }
    }
    return Collections.unmodifiableCollection(result);
  }

  /**
   * Return an applicable merge location for the given element and the given role, if possible
   * @param role_p a potentially null role
   * @param element_p a non-null element
   * @return a potentially null location
   */
  public IElementLocation getApplicableMergeLocation(TemplatePatternRole role_p, EObject element_p) {
    IElementLocation result = null;
    if ((role_p != null) && role_p.acceptsMerge()) {
      BasicElementLocation location = new BasicElementLocation(element_p);
      if (role_p.checkApplicability(location, getApplication()).isOk()) {
        result = location;
      }
    }
    return result;
  }

  /**
   * Return the pattern application being built
   * @return a non-null application
   */
  public BasicPatternApplication getApplication() {
    return _application;
  }

  /**
   * Return the expected multiplicity of the instance
   */
  public int getMultiplicity() {
    return _multiplicity;
  }

  /**
   * Return how many times the pattern must be applied
   */
  public int getNumberOfApplications() {
    return _numberOfApplications;
  }

  /**
   * Return the naming rule for the unfolded elements
   * @return a non-null string
   */
  public String getNamingRule() {
    return _namingRule;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#getRolesOf(org.eclipse.emf.ecore.EObject)
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<TemplatePatternRole> getRolesOf(EObject modelElement_p) {
    List<TemplatePatternRole> result;
    if (getApplication() != null) {
      result = (List) getApplication().getRolesOf(modelElement_p);
    } else {
      result = Collections.emptyList();
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IUserScopeProvider#getScopeElement()
   */
  public Object getScopeElement() {
    return getSelectedElements().isEmpty() ? getApplication().getScopeElement() : getSelectedElements().get(0);
  }

  /**
   * Return the elements selected for the application
   * @return a non-null, modifiable list
   */
  public List<EObject> getSelectedElements() {
    return _modelElements;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#isAcceptable(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
   */
  public boolean isAcceptable(TemplatePattern pattern_p) {
    return true;
  }

  /**
   * Return whether a significant location is assigned to the given role in the current application
   * @param role_p a non-null role
   */
  public boolean isAssigned(TemplatePatternRole role_p) {
    boolean result = false;
    if (getApplication() != null) {
      ILocation location = getApplication().getLocation(role_p);
      if (location != null) {
        result = !location.getAtomicContents().isEmpty();
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedSpecification#isComplete()
   */
  public boolean isComplete() {
    return (_application != null) && isMergeComplete(_application);
  }

  /**
   * Return whether the given application is complete on roles which do not accept addition
   * @param application_p a non-null application
   */
  private boolean isMergeComplete(IPatternApplication application_p) {
    for (TemplatePatternRole role : getPattern().getRoles()) {
      if (!role.acceptsAddition() && !application_p.isCompleteOn(role)) {
        return false;
      }
    }
    return true;
  }


  /**
   * Return whether predefined layout data is present
   * -- SKANDER
   */
  public boolean mayReuseLayoutAndStyle() {
    return (getPattern() != null) && !getPattern().getLayoutData().isEmpty();
  }


  /**
   * Return whether the instance must be displayed when created
   */
  public boolean mustDisplayWhenDone() {
    return _displayWhenDone;
  }

  /**
   * Return whether predefined layout data must be used if present
   */
  public boolean mustReuseLayout() {
    return _reuseLayout;
  }

  /**
   * Return whether predefined style data must be used if present
   * -- SKANDER
   */
  public boolean mustReuseStyle() {
    return _reuseStyle;
  }
  
  /**
   * Return whether the instance must be unfolded when created
   */
  public boolean mustUnfoldWhenDone() {
    return _unfoldWhenDone;
  }

  /**
   * Specify whether the instance must be displayed when created
   * @param display_p whether to display
   */
  public void setDisplayWhenDone(boolean display_p) {
    _displayWhenDone = display_p;
  }

  /**
   * Set the expected multiplicity of the instance
   * @param multiplicity_p a strictly positive integer
   */
  public void setMultiplicity(int multiplicity_p) {
    _multiplicity = multiplicity_p;
  }

  /**
   * Set how many times the pattern must be applied
   * @param number_p a strictly positive integer
   */
  public void setNumberOfApplications(int number_p) {
    _numberOfApplications = number_p;
  }

  /**
   * Set the naming rule for the unfolded elements
   * @param namingRule_p a non-null string
   */
  public void setNamingRule(String namingRule_p) {
    _namingRule = namingRule_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractTemplatePatternSelection#setPattern(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
   */
  @Override
  public void setPattern(TemplatePattern pattern_p) {
    EObject scopeElement = _modelElements.get(0);
    _application = pattern_p == null ? null : new BasicPatternApplication(pattern_p, scopeElement);
    _reuseLayout = (pattern_p != null) && !pattern_p.getLayoutData().isEmpty();
    _reuseStyle = (pattern_p != null) && !pattern_p.getLayoutData().isEmpty();
    super.setPattern(pattern_p);
    if ((_application != null) && applicationByAdditionEnabled(pattern_p)) {
      applyDefaultAssociation(_application, _modelElements);
    }
  }

  /**
   * Return whether the given pattern can be entirely applied by addition
   * @param pattern_p a non-null pattern
   */
  private boolean applicationByAdditionEnabled(TemplatePattern pattern_p) {
    for (TemplatePatternRole role : pattern_p.getRoles()) {
      if (!role.acceptsAddition()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Specify whether to reuse layout data if present in the pattern
   * @param reuse_p whether to reuse layout data
   */
  public void setReuseLayout(boolean reuse_p) {
    _reuseLayout = reuse_p;
  }

  /**
   * Specify whether to reuse style data if present in the pattern
   * @param reuse_p whether to reuse style data
   * -- SKANDER
   */
  public void setReuseStyle(boolean reuse_p) {
    _reuseStyle = reuse_p;
  }

  /**
   * Specify whether the instance must be unfolded when created
   * @param unfold_p whether to unfold
   */
  public void setUnfoldWhenDone(boolean unfold_p) {
    _unfoldWhenDone = unfold_p;
  }

}
