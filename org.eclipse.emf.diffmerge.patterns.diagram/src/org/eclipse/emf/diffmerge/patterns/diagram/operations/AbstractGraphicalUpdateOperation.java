/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.diagram.operations;


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
