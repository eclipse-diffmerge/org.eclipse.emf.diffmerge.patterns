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

import org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement;

/**
 * Information about the success or failure of an operation in the context of patterns.
 * @author Olivier Constant
 */
public interface IEvaluationStatus extends IDescribedElement {
  
  /**
   * Return whether warnings have been issued
   */
  boolean hasWarnings();
  
  /**
   * Return whether the operation was successfully and entirely carried out
   */
  boolean isOk();
  
}
