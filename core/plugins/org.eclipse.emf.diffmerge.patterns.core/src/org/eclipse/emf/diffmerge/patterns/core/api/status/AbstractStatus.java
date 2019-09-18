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
package org.eclipse.emf.diffmerge.patterns.core.api.status;

import org.eclipse.emf.diffmerge.patterns.core.Messages;


/**
 * An abstract base class for status.
 * @author Olivier Constant
 */
public abstract class AbstractStatus implements IEvaluationStatus {
  
  /** Whether the status corresponds to a complete success */
  private final boolean _isOk;
  
  /** Whether warnings have been issued */
  private final boolean _hasWarnings;
  
  /** The optional user-friendly description of the status */
  protected final String _description;
  
  /** Whether this status may be modified */
  private boolean _mutable;
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param description_p a potentially null user-friendly description
   */
  public AbstractStatus(boolean isOk_p, String description_p) {
    this(isOk_p, false, description_p);
  }
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @param description_p a potentially null user-friendly description
   */
  public AbstractStatus(boolean isOk_p, boolean hasWarnings_p, String description_p) {
    this(isOk_p, hasWarnings_p, description_p, false);
  }
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @param description_p a potentially null user-friendly description
   * @param mutable_p whether this status can be modified
   */
  public AbstractStatus(boolean isOk_p, boolean hasWarnings_p, String description_p,
      boolean mutable_p) {
    _isOk = isOk_p;
    _description = description_p;
    _hasWarnings = hasWarnings_p;
    _mutable = mutable_p;
  }
  
  /**
   * Permanently make this status non-mutable
   */
  public void freeze() {
    _mutable = false;
  }
  
  /**
   * Return a default description for the given characteristics of the status
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @return a non-null string
   */
  private String getDefaultDescription(boolean isOk_p, boolean hasWarnings_p) {
    String result;
    if (isOk_p)
      if (hasWarnings_p)
        result = Messages.BasicStatus_Warnings;
      else
        result = Messages.BasicStatus_Success;
    else
      result = Messages.BasicStatus_Failure;
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement#getDescription()
   */
  public String getDescription() {
    String result = _description;
    if (result == null || result.length() == 0)
      result = getDefaultDescription(_isOk, _hasWarnings);
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus#hasWarnings()
   */
  public boolean hasWarnings() {
    return _hasWarnings;
  }
  
  /**
   * Return whether the state of this status can be modified
   */
  public boolean isMutable() {
    return _mutable;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus#isOk()
   */
  public boolean isOk() {
    return _isOk;
  }
  
}
