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
package org.eclipse.emf.diffmerge.patterns.core.api.status;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.Messages;


/**
 * A class for diverse predefined status.
 * @author Olivier Constant
 */
public class SimpleStatus extends AbstractStatus implements
IModelTransformationStatus, IPatternConformityStatus, IRoleApplicabilityStatus {
  
  /** An instance representing success */
  public static final SimpleStatus SUCCESS = new SimpleStatus(true, false, null);
  
  /** An instance representing failure due to an unknown pattern */
  public static final SimpleStatus NO_PATTERN_FAILURE = new SimpleStatus(
      false, false, Messages.BasicStatus_NoPattern);
  
  /** An instance representing failure due to a folded instance */
  public static final SimpleStatus FOLDED_FAILURE = new SimpleStatus(
      false, false, Messages.BasicStatus_FoldedInstance);
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param description_p a potentially null user-friendly description
   */
  public SimpleStatus(boolean isOk_p, String description_p) {
    super(isOk_p, description_p);
  }
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @param description_p a potentially null user-friendly description
   */
  public SimpleStatus(boolean isOk_p, boolean hasWarnings_p, String description_p) {
    super(isOk_p, hasWarnings_p, description_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getAddedElements()
   */
  public Collection<EObject> getAddedElements() {
    return Collections.emptyList();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getDeletedElements()
   */
  public Collection<EObject> getDeletedElements() {
    return Collections.emptyList();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus#getExtraValues()
   */
  public int getExtraValues() {
    return 0;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus#getMissingValues()
   */
  public int getMissingValues() {
    return 0;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getNbCandidateChanges()
   */
  public int getNbCandidateChanges() {
    return -1;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getNbChangesMade()
   */
  public int getNbChangesMade() {
    return -1;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#isAborted()
   */
  public boolean isAborted() {
    return false;
  }
  
}
