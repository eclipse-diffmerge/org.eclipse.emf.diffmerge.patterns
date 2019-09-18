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


/**
 * Feedback about the level of conformity of an application to its pattern.
 * @author Olivier Constant
 */
public interface IPatternConformityStatus extends IEvaluationStatus {
  
  /**
   * Return the number of values which are in the model and not in the pattern
   */
  int getExtraValues();
  
  /**
   * Return the number of values which are in the pattern and not in the model
   */
  int getMissingValues();
  
}
