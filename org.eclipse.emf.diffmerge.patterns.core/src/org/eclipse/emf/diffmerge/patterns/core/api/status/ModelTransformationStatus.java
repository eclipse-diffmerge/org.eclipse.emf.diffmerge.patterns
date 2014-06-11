/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.core.api.status;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;


/**
 * An implementation of IModelTransformationStatus.
 * @author Olivier Constant
 */
public class ModelTransformationStatus extends AbstractStatus
implements IModelTransformationStatus {
  
  /** The non-null collection of elements which have been added */
  private final Collection<EObject> _addedElements;
  
  /** The non-null collection of elements which have been deleted */
  private final Collection<EObject> _deletedElements;
  
  /** Whether the model transformation is aborted */
  private boolean _isAborted;
  
  /** The number of changes made */
  private int _nbChangesMade;
  
  /** The original number of possible changes */
  private int _nbCandidateChanges;
  
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param description_p a potentially null user-friendly description
   */
  public ModelTransformationStatus(boolean isOk_p, String description_p) {
    this(isOk_p, false, description_p);
  }
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @param description_p a potentially null user-friendly description
   */
  public ModelTransformationStatus(boolean isOk_p, boolean hasWarnings_p, String description_p) {
    this(isOk_p, hasWarnings_p, description_p, false);
  }
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @param description_p a potentially null user-friendly description
   * @param mutable_p whether this status can be modified
   */
  public ModelTransformationStatus(boolean isOk_p, boolean hasWarnings_p, String description_p,
      boolean mutable_p) {
    super(isOk_p, hasWarnings_p, description_p, mutable_p);
    _addedElements = new ModelsUtil.ROrderedSet<EObject>();
    _deletedElements = new ModelsUtil.ROrderedSet<EObject>();
    _isAborted = false;
    _nbChangesMade = -1;
    _nbCandidateChanges = -1;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getAddedElements()
   */
  public Collection<EObject> getAddedElements() {
    return isMutable()? _addedElements: Collections.unmodifiableCollection(_addedElements);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getNbCandidateChanges()
   */
  public int getNbCandidateChanges() {
    return _nbCandidateChanges;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getNbChangesMade()
   */
  public int getNbChangesMade() {
    return _nbChangesMade;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#getDeletedElements()
   */
  public Collection<EObject> getDeletedElements() {
    return isMutable()? _deletedElements: Collections.unmodifiableCollection(_deletedElements);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus#isAborted()
   */
  public boolean isAborted() {
    return _isAborted;
  }
  
  /**
   * Set whether the model transformation was aborted
   */
  public void setAborted(boolean aborted_p) {
    if (isMutable())
      _isAborted = aborted_p;
  }
  
  /**
   * Set the original number of possible changes
   * @param nb_p a positive integer or -1 if information is not available
   */
  public void setNbCandidateChanges(int nb_p) {
    if (isMutable())
      _nbCandidateChanges = nb_p;
  }
  
  /**
   * Set the number of changes that have been made
   * @param nb_p a positive integer or -1 if information is not available
   */
  public void setNbChangesMade(int nb_p) {
    if (isMutable())
      _nbChangesMade = nb_p;
  }
  
}
