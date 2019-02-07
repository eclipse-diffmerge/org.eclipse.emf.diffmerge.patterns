/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.diffmerge.generic.api.IMatch;
import org.eclipse.emf.diffmerge.generic.api.Role;
import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationScope.PatternInstanceMarkerFilter;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternContentScope;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternDiffPolicy;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternMatchPolicy;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternMergePolicy;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


/**
 * A data structure which contains the data for creating a template pattern
 * from existing model elements.
 * @author Olivier Constant
 */
public class TemplatePatternCreationSpecification extends AbstractModifiableTemplatePatternSpecification {
  
  /** The default version for a new pattern */
  private static final String INITIAL_VERSION = "1" + VERSION_SEPARATOR + "0"; //$NON-NLS-1$ //$NON-NLS-2$
  
  /** Whether the pattern is a template */
  private final boolean _isTemplate;
  
  /** A non-null, potentially empty, unmodifiable list of the compatible tool environments */
  private final List<String> _currentEnvironments;
  
  /** Whether the roles of the pattern have been initialized */
  private boolean _hasInitializedRoles;
  
  
  /**
   * Constructor
   * @param isTemplate_p whether the pattern is a template
   * @param sources_p the elements from which the pattern must be created
   * @param currentEnvironments_p a non-null, potentially empty, unmodifiable list of the
   *        compatible tool environments
   */
  public TemplatePatternCreationSpecification(boolean isTemplate_p,
      List<? extends Object> sources_p, List<String> currentEnvironments_p) {
    super(true, !isTemplate_p, (sources_p.isEmpty())? null :
      (
          (sources_p.get(0) instanceof EObject)? null : (EObject)sources_p.get(0)
       ));
    setPattern(TemplatepatternsFactory.eINSTANCE.createTemplatePattern());
    _isTemplate = isTemplate_p;
    _currentEnvironments = currentEnvironments_p;
    initializePattern(sources_p);
    initializeComparison(sources_p);
    _hasInitializedRoles = false;
  }
  
  /**
   * Return the containment which holds all the source elements of the given role, if any
   * @param role_p a non-null role
   * @return a potentially null containment
   */
  public EReference getCommonContainment(TemplatePatternRole role_p) {
    EReference result = null;
    for (EObject templateElement : role_p.getTemplateElements()) {
      EObject sourceElement = getCounterpart(templateElement, true);
      if (sourceElement != null && sourceElement.eContainmentFeature() != null) {
        EReference containment = sourceElement.eContainmentFeature();
        if (result == null)
          result = containment;
        else if (result != containment)
          return null;
      }
    }
    return result;
  }
  
  /**
   * Return whether the pattern under construction had its roles initialized
   */
  public boolean hasInitializedRoles() {
    return _hasInitializedRoles;
  }
  
  /**
   * Initialize the comparison between source elements and template elements
   * @param sources_p the elements from which the pattern must be created (non-null)
   */
  private void initializeComparison(List<? extends Object> sources_p) {
    List<EObject> casted = new ArrayList<EObject>();
    for(Object obj : sources_p){
      if(obj instanceof EObject){
        casted.add((EObject)obj);
      }
    }
    FilteredModelScope sourceScope = new FilteredModelScope(casted);
    sourceScope.build(new PatternInstanceMarkerFilter());
    newComparison(new TemplatePatternComparison(getPattern(),
        new TemplatePatternContentScope(getPattern()), sourceScope));
  }
  
  /**
   * Initialize the resulting pattern
   * @param sources_p the elements from which the pattern must be created (non-null)
   */
  private void initializePattern(List<? extends Object> sources_p) {
    TemplatePattern pattern = getPattern();
    String defaultName = null;
    if (!sources_p.isEmpty() && sources_p.get(0) instanceof EObject)
      defaultName = getText((EObject)sources_p.get(0));
    pattern.setName(defaultName == null? "": defaultName); //$NON-NLS-1$
    pattern.setTemplate(_isTemplate);
    pattern.setVersion(INITIAL_VERSION);
    pattern.getExecutionEnvironments().addAll(_currentEnvironments);
    String userName = System.getenv("USERNAME"); //$NON-NLS-1$
    if (userName != null)
      pattern.getAuthors().add(userName);
  }
  
  /**
   * Initialize the roles of the pattern being constructed (potentially expensive operation)
   */
  public void initializeRoles() {
    getComparison().compute(new TemplatePatternMatchPolicy(null, null, null),
        new TemplatePatternDiffPolicy(), new TemplatePatternMergePolicy(), null);
    mergeDifferences();
    //Initialize virtual resource contents and mappings
    Collection<IMatch<EObject>> completedMatches = getComparison().getMapping().getCompletedMatches(Role.REFERENCE);
    for(IMatch<EObject> match : completedMatches){
      EObject ref = match.get(Role.REFERENCE);
      if(ref != null){
        _noIdsMap.put(ref, match.get(Role.TARGET));
      }
    }
    // Define roles for roots
    Map<ComparableReferenceLocation, List<EObject>> origins =
      new HashMap<ComparableReferenceLocation, List<EObject>>();
    ISemanticRuleProvider ruleProvider = getSemanticRuleProvider();
    List<EObject> contents = getModelScope().getRoots();
    for (EObject root : contents) {
      if (ruleProvider.getOwnershipDerivationLevel(root) == 0 || contents.size() == 1) {
        // Root element requires role creation
        if (root.eContainer() != null) {
          // Group with other roots in same container
          ComparableReferenceLocation location = new ComparableReferenceLocation(
              root.eContainer(), root.eContainmentFeature());
          List<EObject> peerRoots = origins.get(location);
          if (peerRoots == null) {
            peerRoots = new LinkedList<EObject>();
            origins.put(location, peerRoots);
          }
          peerRoots.add(root);
        } else {
          addRoleFor(root);
        }
      }
    }
    for (Entry<ComparableReferenceLocation, List<EObject>> entry :
      origins.entrySet()) {
      addRoleFor(entry.getValue(), entry.getKey());
    }
    // Sort roles alphabetically
    ECollections.sort(getPattern().getRoles(), new Comparator<TemplatePatternRole>() {
      /**
       * @see java.util.Comparator#compare(Object, Object)
       */
      public int compare(TemplatePatternRole o1_p, TemplatePatternRole o2_p) {
        return o1_p.getName().compareTo(o2_p.getName());
      }
    });
    _hasInitializedRoles = true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification#isComplete()
   */
  @Override
  public boolean isComplete() {
    boolean result = super.isComplete() && getRepository() != null;
    if (result && isTemplate()) {
      boolean first = true;
      for (TemplatePatternRole role : getPattern().getRoles()) {
        if (first) {
          first = false;
          result = role.getMergeDerivationRule() == null &&
            role.getTemplateElements().size() == 1;
        } else {
          result = role.getMergeDerivationRule() != null;
        }
        if (!result)
          break;
      }
    }
    return result;
  }
  
  /**
   * Adapt this binding for template patterns to a generic pattern application
   * @return a non-null pattern application
   */
  public IPatternApplication toPatternApplication() {
    BasicPatternApplication result = new BasicPatternApplication(getPattern());
    for (TemplatePatternRole role : getPattern().getRoles()) {
      for (EObject templateElement : role.getTemplateElements()) {
        EObject modelElement = getCounterpart(templateElement, true);
        if (modelElement != null) {
          IAtomicLocation location;
          if (modelElement.eContainer() != null)
            location = new BasicReferenceLocation(
                modelElement.eContainer(), modelElement.eContainmentFeature());
          else
            location = new BasicElementLocation(modelElement);
          result.addLocation(role, location);
        }
      }
    }
    return result;
  }
  
  /**
   * A variant of BasicReferenceLocation where equality is based on contents.
   */
  protected static class ComparableReferenceLocation extends BasicReferenceLocation {
    /**
     * Constructor
     * @param element_p the non-null element of this location
     * @param reference_p the non-null reference of this location
     */
    public ComparableReferenceLocation(EObject element_p, EReference reference_p) {
      super(element_p, reference_p);
    }
    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object_p) {
      boolean result = false;
      if (object_p instanceof ComparableReferenceLocation) {
        ComparableReferenceLocation peer = (ComparableReferenceLocation)object_p;
        result =
          peer.getReference() == getReference() && peer.getElement() == getElement();
      }
      return result;
    }
    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
      return getReference().hashCode() + getElement().hashCode();
    }
  }
  
}
