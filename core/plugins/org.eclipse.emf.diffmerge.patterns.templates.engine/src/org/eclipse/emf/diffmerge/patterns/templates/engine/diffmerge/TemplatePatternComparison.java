/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.api.IDiffPolicy;
import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.IMatchPolicy;
import org.eclipse.emf.diffmerge.api.IMergePolicy;
import org.eclipse.emf.diffmerge.api.IMergeSelector;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.structures.common.FHashMap;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EObject;


/**
 * A comparison specifically tailored for comparing template patterns to specific model scopes.
 * @author Olivier Constant
 */
public class TemplatePatternComparison extends EComparisonImpl {

  /** The non-null template pattern to compare */
  private final TemplatePattern _pattern;

  /** A non-null map from elements of the evolving role to updated matches */
  private final EMap<EObject, IMatch> _updatedMatches;


  /**
   * Constructor
   * @param pattern_p a non-null template pattern
   * @param patternScope_p a non-null scope for the pattern role
   * @param modelScope_p a non-null scope for the opposite role
   */
  public TemplatePatternComparison(TemplatePattern pattern_p,
      IEditableModelScope patternScope_p, IEditableModelScope modelScope_p) {
    super(modelScope_p, patternScope_p);
    _pattern = pattern_p;
    _updatedMatches = new FHashMap<EObject, IMatch>();
  }

  /**
   * Collect the updated matches after a merge
   */
  protected void collectUpdatedMatches() {
    for (IMatch match : getMapping().getCompletedMatches(getEvolvingRole())) {
      _updatedMatches.put(match.get(getEvolvingRole()), match);
    }
    for (IMatch match : getMapping().getCompletedMatches(getEvolvingRole().opposite())) {
      _updatedMatches.put(match.get(getEvolvingRole()), match);
    }
  }

  /**
   * Return the role whose scope may evolve
   * @return a non-null role
   */
  private static final Role getEvolvingRole() {
    return getPatternRole().opposite();
  }

  /**
   * Return the set of matches which have been updated during the last
   * computation/update
   * @return a non-null, potentially empty, unmodifiable set
   */
  public Collection<IMatch> getLastUpdatedMatches() {
    Collection<IMatch> result = new FOrderedSet<IMatch>();
    result.addAll(getMapping().getCompletedMatches(getPatternRole()));
    result.addAll(getMapping().getCompletedMatches(getPatternRole().opposite()));
    return Collections.unmodifiableCollection(result);
  }

  /**
   * Return the template pattern that is involved in the comparison
   * @return a non-null pattern
   */
  public TemplatePattern getPattern() {
    return _pattern;
  }

  /**
   * Return the comparison role corresponding to the pattern
   * @return a non-null role
   */
  public static Role getPatternRole() {
    return Role.REFERENCE;
  }

  /**
   * Return the set of the matches updated throughout the initial computation and
   * the further updates
   * @return a non-null collection
   */
  public Collection<IMatch> getUpdatedMatches() {
    return _updatedMatches.values();
  }

  /**
   * Update this comparison after modification of the free scope
   * @param noIdsMap_p a potentially null, potentially empty map of copied elements with no semantic IDs to their originals
   */
  public IStatus update(final LinkedHashMap<EObject, EObject> noIdsMap_p) {
    final EMap<EObject, EObject> existingMapping = getMapping().toMap(
        getEvolvingRole().opposite(), getEvolvingRole()); // Pattern to model
    final IMatchPolicy previousMatchPolicy = getLastMatchPolicy();
    final IDiffPolicy previousDiffPolicy = getLastDiffPolicy();
    final IMergePolicy previousMergePolicy = getLastMergePolicy();
    clear(); // Also clears last policies
    IMatchPolicy wrappingMatchPolicy = new DefaultMatchPolicy() {
      /**
       * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy#getMatchID(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.api.scopes.IModelScope)
       */
      @Override
      public Object getMatchID(EObject element_p, IModelScope scope_p){
        EObject idProvider = element_p;
        EObject existingCounterPart = existingMapping.get(element_p);
        if (existingCounterPart != null)
          idProvider = existingCounterPart;
        Object result = previousMatchPolicy.getMatchID(idProvider, scope_p);
        if(result == null && noIdsMap_p != null){
          existingCounterPart = noIdsMap_p.get(element_p);
          result = previousMatchPolicy.getMatchID(existingCounterPart, scope_p);
        }
        return result;
      }
    };
    IStatus result = compute(wrappingMatchPolicy, previousDiffPolicy, previousMergePolicy, null);
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl#merge(java.util.Collection, org.eclipse.emf.diffmerge.api.Role, boolean, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public Collection<IDifference> merge(Collection<? extends IDifference> differences_p,
      Role destination_p, boolean updateReferences_p, IProgressMonitor monitor_p) {
    Collection<IDifference> result =
        super.merge(differences_p, destination_p, updateReferences_p, monitor_p);
    collectUpdatedMatches();
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.api.IComparison#merge(org.eclipse.emf.diffmerge.api.IMergeSelector, boolean, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public Collection<IDifference> merge(IMergeSelector merger_p,
      boolean updateReferences_p, IProgressMonitor monitor_p) {
    Collection<IDifference> result =
        super.merge(merger_p, updateReferences_p, monitor_p);
    collectUpdatedMatches();
    return result;
  }

}
