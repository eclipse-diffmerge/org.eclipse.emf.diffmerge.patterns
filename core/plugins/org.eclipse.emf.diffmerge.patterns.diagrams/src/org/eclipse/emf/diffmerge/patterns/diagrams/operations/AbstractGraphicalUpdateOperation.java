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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;


/**
 * A graphical update operation
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractGraphicalUpdateOperation {

  /**
   * Update the given representation
   * @param decorator_p a non-null Object
   */
  public abstract void update(Object decorator_p, boolean isMerged);
  
}
