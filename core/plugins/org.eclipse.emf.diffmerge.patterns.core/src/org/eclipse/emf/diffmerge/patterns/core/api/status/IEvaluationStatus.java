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
