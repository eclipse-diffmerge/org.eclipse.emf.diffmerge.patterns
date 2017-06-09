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

import org.eclipse.emf.diffmerge.patterns.core.Messages;


/**
 * An implementation of IPatternConformityStatus.
 * @author Olivier Constant
 */
public class PatternConformityStatus extends AbstractStatus
implements IPatternConformityStatus {
  
  /** The number of values in the application but not in the pattern */
  private int _extraValues;
  
  /** The number of values in the pattern but not in the application */
  private int _missingValues;
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param description_p a potentially null user-friendly description
   */
  public PatternConformityStatus(boolean isOk_p, String description_p) {
    this(isOk_p, false, description_p);
  }
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @param description_p a potentially null user-friendly description
   */
  public PatternConformityStatus(boolean isOk_p, boolean hasWarnings_p, String description_p) {
    this(isOk_p, hasWarnings_p, description_p, false);
  }
  
  /**
   * Constructor
   * @param isOk_p whether the status corresponds to a complete success
   * @param hasWarnings_p whether the status includes warnings
   * @param description_p a potentially null user-friendly description
   * @param mutable_p whether this status can be modified
   */
  public PatternConformityStatus(boolean isOk_p, boolean hasWarnings_p, String description_p,
      boolean mutable_p) {
    super(isOk_p, hasWarnings_p, description_p, mutable_p);
    _missingValues = 0;
    _extraValues = 0;
  }
  
  /**
   * Constructor
   * @param missingValues_p the number of values in the pattern and not in the model
   * @param extraValues_p the number of values in the model and not in the pattern
   */
  public PatternConformityStatus(int missingValues_p, int extraValues_p) {
    super(true, false, null, true);
    _missingValues = missingValues_p;
    _extraValues = extraValues_p;
  }
  
  /**
   * Increase the number of extra values by the given amount
   * @param increment_p an arbitrary number
   */
  public void addExtraValues(int increment_p) {
    if (isMutable())
      _extraValues += increment_p;
  }
  
  /**
   * Increase the number of missing values by the given amount
   * @param increment_p an arbitrary number
   */
  public void addMissingValues(int increment_p) {
    if (isMutable())
      _missingValues += increment_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.AbstractStatus#getDescription()
   */
  @Override
  public String getDescription() {
    String result = _description;
    if (result == null || result.length() == 0) {
      result = getValueBasedDescription();
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus#getExtraValues()
   */
  public int getExtraValues() {
    return _extraValues;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus#getMissingValues()
   */
  public int getMissingValues() {
    return _missingValues;
  }
  
  /**
   * Return a description of the status based on the missing and extra values
   * @return a non-null string
   */
  private String getValueBasedDescription() {
    String result;
    if (_extraValues == 0 && _missingValues == 0) {
      result = Messages.PatternConformityStatus_Conforms;
    } else {
      if (_missingValues == 0)
        result = String.format(Messages.PatternConformityStatus_ConformityExtra,
            Integer.valueOf(_extraValues));
      else
        result = String.format(
            Messages.PatternConformityStatus_NonConformityDetails,
            Integer.valueOf(_missingValues),
            Integer.valueOf(_extraValues));
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.status.AbstractStatus#isOk()
   */
  @Override
  public boolean isOk() {
    return super.isOk() && _extraValues == 0 && _missingValues == 0;
  }
  
}
