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
