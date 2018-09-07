/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
 * An executable operation whose result is typed.
 * @param <T> the type of the result
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractOperation<T> {
  
  /**
   * Executes operation
   * @return a potentially null object
   */
  protected abstract T execute();
  
}
