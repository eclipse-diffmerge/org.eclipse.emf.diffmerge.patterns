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
