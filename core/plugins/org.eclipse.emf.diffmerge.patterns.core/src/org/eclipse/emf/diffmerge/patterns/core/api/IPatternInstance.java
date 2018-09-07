/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.core.api;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;


/**
 * A pattern instance is an application of a certain version of a given pattern
 * which can be unfolded, re-folded and updated.
 * @author Olivier Constant
 */
public interface IPatternInstance extends IPatternApplication {
  
  /**
   * Delete this instance, optionally preserving the elements of the instance
   * @param keepElements_p whether the elements of the instance must be preserved
   */
  IModelTransformationStatus delete(boolean keepElements_p);
  
  /**
   * Fold this instance
   * @return a non-null status about the operation
   */
  IModelTransformationStatus fold();
  
  /**
   * Return the elements that belong to the instance
   * @return a non-null, potentially empty, unmodifiable list
   */
  List<EObject> getElements();
  
  /**
   * Return the pattern-specific data of the instance
   * @return pattern data or null if there exists no such data
   */
  IPatternData getPatternData();
  
  /**
   * Return the version of the pattern to which this instance is relative
   * @return a non-null pattern version
   */
  IPatternVersion getPatternVersion();
  
  /**
   * Return whether the instance has been deleted
   */
  boolean isDeleted();
  
  /**
   * Return whether this instance is folded
   */
  boolean isFolded();
  
  /**
   * Unfold this instance
   * @return a non-null status about the operation
   */
  IModelTransformationStatus unfold();
  
  /**
   * Update this instance
   * Post: the pattern version of this instance is up-to-date if the operation is successful
   * @param specification_p a specification of the update
   * @return a non-null status about the operation
   */
  IModelTransformationStatus update(IModelUpdateSpecification specification_p);
  
}
