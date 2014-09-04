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
import java.util.List;

import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicCompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementLocation;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.diffmerge.util.structures.FArrayList;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * A data structure which contains all useful data for applying a template on a pattern under
 * construction/update.
 * @author Olivier Constant
 */
public class TemplateUsageSpecification extends AbstractBijectiveTemplatePatternSpecification {
  
  /** The non-null specification of the pattern creation/update process */
  private final AbstractModifiableTemplatePatternSpecification _data;
  
  /** Whether strict template compatibility must be enforced */
  private boolean _strictCompatibility;
  
  
  /**
   * Constructor
   * @param data_p the specification of the pattern creation/update process
   */
  public TemplateUsageSpecification(AbstractModifiableTemplatePatternSpecification data_p) {
    super();
    _data = data_p;
    _strictCompatibility = true;
  }
  
  /**
   * Return the application of the template to elements in the context of the
   * target pattern
   * Precondition: isComplete()
   * @return a non-null application
   */
  public IPatternApplication computeApplication() {
    EObject primaryTargetPattern = getTargetElement();
    EObject primaryTargetModel = _data.getCounterpart(primaryTargetPattern, true);
    BasicPatternApplication result =
      new BasicPatternApplication(getPattern(), primaryTargetModel);
    boolean first = true;
    for (TemplatePatternRole role : getPattern().getRoles()) {
      if (first) {
        // Primary role
        first = false;
        BasicElementLocation location = new BasicElementLocation(primaryTargetModel);
        result.setLocation(role, location);
      } else {
        // Secondary role
        List<EObject> derived = null;
        BasicCompositeLocation location = null;
        if (role.getMergeDerivationRule() != null && !role.getTemplateElements().isEmpty()) {
          derived = role.getMergeDerivationRule().deriveCandidateElements(result);
          if (derived != null) {
            location = new BasicCompositeLocation();
            for (EObject derivedElement : derived) {
              IElementLocation elementLocation = new BasicElementLocation(derivedElement);
              location.getOwnedLocations().add(elementLocation);
            }
          }
        }
        result.setLocation(role, location);
      }
    }
    return result;
  }
  
  /**
   * Execute the template based on the given computed application and parameters
   * @param application_p a non-null application
   * @param includeChildren_p whether children of collected elements must be included
   * @param deleteRoles_p whether existing roles must be deleted
   * @param excludeElements_p whether existing pattern elements must be excluded 
   * @param overridePrimaryName_p whether to override the name of the primary role
   * @param overridePrimaryDescription_p whether to override the description of the primary role
   * @param includeEmptyRoles_p whether empty template roles must be included
   * @param includeTargetDerivationRules_p whether template collection rules must be converted to pattern target derivation rules
   */
  public void execute(IPatternApplication application_p, boolean includeChildren_p, boolean deleteRoles_p,
      boolean excludeElements_p, boolean overridePrimaryName_p, boolean overridePrimaryDescription_p,
      boolean includeEmptyRoles_p, boolean includeTargetDerivationRules_p) {
    boolean first = true;
    // Pattern elements
    EObject primaryModelElement = _data.getCounterpart(getTargetElement(), true);
    FilteredModelScope modelScope = (FilteredModelScope)_data.getModelScope();
    if (excludeElements_p) {
      for (EObject root : new FArrayList<EObject>(modelScope.getContents(), null)) {
        if (root != primaryModelElement)
          modelScope.removeFromScope(root, true);
      }
    }
    // Pattern roles
    for (TemplatePatternRole patternRole :
        new ArrayList<TemplatePatternRole>(_data.getPattern().getRoles())) {
      if (first) {
        if (overridePrimaryName_p)
          patternRole.setName(application_p.getPattern().getRoles().get(0).getName());
        if (patternRole.getDescription() == null || patternRole.getDescription().length() == 0 ||
            overridePrimaryDescription_p)
          patternRole.setDescription(application_p.getPattern().getRoles().get(0).getDescription());
        first = false;
      } else {
        if (!excludeElements_p && !deleteRoles_p)
          break;
        _data.getPattern().getRoles().remove(patternRole);
      }
    }
    // Template application elements
    first = true;
    for (IPatternRole rawTemplateRole : application_p.getPattern().getRoles()) {
      TemplatePatternRole templateRole = (TemplatePatternRole)rawTemplateRole;
      if (first) {
        first = false;
      } else {
        List<EObject> modelElements;
        ILocation location = application_p.getLocation(templateRole);
        if (location != null)
          modelElements = LocationsUtil.getMergeTargets(location);
        else
          modelElements = Collections.emptyList();
        // Add elements to scope
        for (EObject modelElement : modelElements) {
          modelScope.add(modelElement, includeChildren_p);
        }
      }
    }
    _data.updateComparison();
    // Template roles
    EcoreUtil.Copier treeCopier = new EcoreUtil.Copier(false, false);
    first = true;
    for (IPatternRole rawTemplateRole : application_p.getPattern().getRoles()) {
      TemplatePatternRole templateRole = (TemplatePatternRole)rawTemplateRole;
      if (first) {
        first = false;
      } else {
        List<EObject> modelElements;
        ILocation location = application_p.getLocation(templateRole);
        if (location != null)
          modelElements = LocationsUtil.getMergeTargets(location);
        else
          modelElements = Collections.emptyList();
        if (!modelElements.isEmpty() || includeEmptyRoles_p) {
          // Role
          TemplatePatternRole patternRole = _data.addRole(templateRole.getName());
          patternRole.setDescription(templateRole.getDescription());
          // Role mapping
          for (EObject modelElement : modelElements) {
            _data.mapToRole(patternRole, modelElement);
          }
          // Role properties
          patternRole.setAdditionKind(templateRole.getAdditionKind());
          if (templateRole.getPreferredContainment() != null)
            patternRole.setPreferredContainment(templateRole.getPreferredContainment());
          if (templateRole.getAdditionDerivationRule() != null)
            patternRole.setAdditionDerivationRule(
                (AbstractRoleDerivationRule)treeCopier.copy(templateRole.getAdditionDerivationRule()));
          if (includeTargetDerivationRules_p && templateRole.getMergeDerivationRule() != null)
            patternRole.setMergeDerivationRule(
                (AbstractRoleDerivationRule)treeCopier.copy(templateRole.getMergeDerivationRule()));
        }
      }
    }
    _data.roleUpdated();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IBijectiveTemplatePatternSpecification#getAllElements()
   */
  public Collection<EObject> getAllElements() {
    Collection<EObject> result;
    if (getPattern() != null)
      result = Collections.unmodifiableList(ModelsUtil.getAllContents(
          getPattern().getTemplateElements(), true, null));
    else
      result = Collections.<EObject>emptySet();
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection#getCounterpart(org.eclipse.emf.ecore.EObject, boolean)
   */
  public EObject getCounterpart(EObject element_p, boolean fromPattern_p) {
    return element_p;
  }
  
  /**
  * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#getRolesOf(org.eclipse.emf.ecore.EObject)
  */
  public List<TemplatePatternRole> getRolesOf(EObject modelElement_p) {
    List<TemplatePatternRole> result = new FOrderedSet<TemplatePatternRole>();
    if (getPattern() != null) {
      for (TemplatePatternRole role : getPattern().getRoles()) {
        if (role.getTemplateElements().contains(modelElement_p))
          result.add(role);
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Return the pattern element in the pattern under construction that is the primary
   * target of the template
   * @return a potentially null element
   */
  public EObject getTargetElement() {
   return getPrimaryElement(_data.getPattern());
  }
  
  /**
   * Return the pattern element in the given pattern that is the primary
   * target of the template or template element
   * @param pattern_p a potentially null pattern
   * @return a potentially null element
   */
  public EObject getPrimaryElement(TemplatePattern pattern_p) {
   EObject result = null;
   if (pattern_p != null && !pattern_p.getRoles().isEmpty()) {
     TemplatePatternRole primaryRole = pattern_p.getRoles().get(0);
     if (!primaryRole.getTemplateElements().isEmpty())
       result = primaryRole.getTemplateElements().get(0);
   }
   return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IUserScopeProvider#getScopeElement()
   */
  public Object getScopeElement() {
    return _data.getScopeElement();
  }
  
  /**
   * Return the pattern being created/updated
   * @return a non-null pattern
   */
  public TemplatePattern getTargetPattern() {
    return _data.getPattern();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification#isAcceptable(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
   */
  @Override
  public boolean isAcceptable(TemplatePattern pattern_p) {
    boolean result = pattern_p.isTemplate();
    if (result && isStrictCompatibility()) {
      EObject primaryTemplateElement = getPrimaryElement(pattern_p);
      EObject primaryTarget = getTargetElement();
      result = primaryTarget != null && primaryTemplateElement != null &&
        primaryTarget.eClass() == primaryTemplateElement.eClass();
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IBijectiveTemplatePatternSpecification#isComplete()
   */
  public boolean isComplete() {
    return getPattern() != null;
  }
  
  /**
   * Return whether the given pattern is ready for template usage
   * @param pattern_p  a non-null pattern
   */
  public static boolean isReadyForTemplateUsage(TemplatePattern pattern_p) {
    boolean result = false;
    if (!pattern_p.getRoles().isEmpty()) {
      TemplatePatternRole firstRole = pattern_p.getRoles().get(0);
      result = firstRole.getTemplateElements().size() == 1;
    }
    return result;
  }
  
  /**
   * Return whether strict template compatibility is being enforced 
   */
  public boolean isStrictCompatibility() {
    return _strictCompatibility;
  }
  
  /**
   * Set whether strict template compatibility must be enforced
   * @param strict_p whether strict or not 
   */
  public void setStrictCompatibility(boolean strict_p) {
    _strictCompatibility = strict_p;
    setRepository(getRepository());
  }
  
}
