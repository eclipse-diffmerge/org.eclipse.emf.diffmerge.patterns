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
package org.eclipse.emf.diffmerge.patterns.core.api;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;


/**
 * A pattern defines, via a list of roles, a conformity relation w.r.t. its applications
 * and model transformations for unfolding, re-folding and updating its instances. 
 * @author Olivier Constant
 */
public interface IPattern extends IIdentifiedElement, INamedElement, IDescribedElement,
ICollaborativeElement {
  
  /**
   * Check conformity of the given application of this pattern modulo the given
   * set of features to ignore
   * @param application_p a non-null application of this pattern
   * @param ignoredFeatures_p a non-null, potentially empty set
   * @return a non-null status about conformity
   * @generated NOT
   */
  IPatternConformityStatus checkConformance(IPatternApplication application_p,
      List<EStructuralFeature> ignoredFeatures_p);
  
  /**
   * Return new pattern-specific data for the given instance if relevant.
   * This method must be called every time an instance of the pattern is created.
   * @param instance_p a non-null instance of this pattern
   * @param context_p a potentially null context element
   * @return pattern data or null if none is relevant
   */
  IPatternData createDataFor(IPatternInstance instance_p, Object context_p);
  
  /**
   * Fold the given application of this pattern
   * @param instance_p a non-null instance of this pattern
   * @return a non-null status about the operation
   */
  IModelTransformationStatus fold(IPatternInstance instance_p);
  
  /**
   * Return the possible execution environments for this pattern (user-level)
   * @return a non-null, potentially empty, unmodifiable list
   */
  List<String> getExecutionEnvironments();
  
  /**
   * Return the repository to which this pattern belongs, if any
   * @return a potentially null repository
   */
  IPatternRepository getRepository();
  
  /**
   * Return the role of this pattern which is identified by the given symbol
   * @param symbol_p a non-null role symbol
   * @return a role of this pattern or null if there is no such role
   */
  IPatternRole getRole(IPatternRoleSymbol symbol_p);
  
  /**
   * Return the roles of this pattern
   * @return a non-null, non-empty, unmodifiable list of roles
   */
  List<? extends IPatternRole> getRoles();
  
  /**
   * Return a pattern symbol which refers to this pattern
   * @return a non-null pattern symbol
   */
  IPatternSymbol getSymbol();
  
  /**
   * Return whether this pattern can be used as template for creating other patterns
   */
  boolean isTemplate();
  
  /**
   * Unfold the given instance
   * @param instance_p a non-null instance of this pattern
   * @return a non-null status about the operation
   */
  IModelTransformationStatus unfold(IPatternInstance instance_p);
  
  /**
   * Update a model according to the given application of this pattern and the given specification
   * @param instance_p a non-null instance of this pattern
   * @param specification_p a non-null object
   * @return a non-null status about the operation
   */
  IModelTransformationStatus updateModel(IPatternInstance instance_p,
      IModelUpdateSpecification specification_p);
  
  
  /**
   * A specification of how a model should be updated according to a pattern
   * and its application on the model.
   */
  interface IModelUpdateSpecification {
    /**
     * Return whether update should be destructive, that is,
     * model elements and values are allowed to be deleted
     */
    boolean isDestructive();
    /**
     * Return the set of features to exclude from update
     * @return a non-null, potentially empty collection
     */
    List<EStructuralFeature> getFeaturesToIgnore();
  }
  
}
