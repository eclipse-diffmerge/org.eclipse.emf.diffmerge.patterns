/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.core.api.locations;

import org.eclipse.emf.ecore.EObject;

/**
 * A location which is relative to a specific model element.
 * @author Olivier Constant
 */
public interface IElementRelativeLocation extends IAtomicLocation {
  
  /**
   * Return the model element to which this location is relative
   * @param context_p a potentially-null context object
   * @return a potentially null element, where null means ill-formed 
   */
  EObject getElement(Object context_p);
  
  /**
   * Return the model element to which this location is relative
   * @return a potentially null element, where null means ill-formed 
   */
  EObject getElement();
}
