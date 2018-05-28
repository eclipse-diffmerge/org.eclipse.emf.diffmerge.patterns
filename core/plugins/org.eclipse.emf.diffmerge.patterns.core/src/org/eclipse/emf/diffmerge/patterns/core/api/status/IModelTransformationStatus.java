/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.core.api.status;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * Feedback about an attempt to transform a model.
 * @author Olivier Constant
 */
public interface IModelTransformationStatus extends IEvaluationStatus {
  
  /**
   * Return the set of elements which have been added during the operation
   * @return a non-null, potentially empty, unmodifiable collection
   */
  Collection<EObject> getAddedElements();
  
  /**
   * Return the set of elements which have been deleted during the operation
   * @return a non-null, potentially empty, unmodifiable collection
   */
  Collection<EObject> getDeletedElements();
  
  /**
   * Return the original number of possible changes
   * @return a positive integer or -1 if information is not available
   */
  int getNbCandidateChanges();
  
  /**
   * Return the number of changes that have been made
   * @return a positive integer or -1 if information is not available
   */
  int getNbChangesMade();
  
  /**
   * Return whether the model transformation was aborted
   */
  boolean isAborted();
  
}
