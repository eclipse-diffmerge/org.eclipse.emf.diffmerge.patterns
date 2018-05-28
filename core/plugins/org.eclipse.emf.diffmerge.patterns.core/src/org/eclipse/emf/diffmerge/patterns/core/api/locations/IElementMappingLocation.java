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

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;

/**
 * A location which maps a set of model elements.
 * @author Olivier Constant
 */
public interface IElementMappingLocation extends IAtomicLocation {
  
  /**
   * Return the model element which is mapped to the given pattern element
   * @return a potentially null element
   */
  EObject getElement(EObject patternElement_p);
  
  /**
   * Return the set of model elements which are mapped by this location
   * @return a non-null, potentially empty collection
   */
  Collection<EObject> getModelElements();
  
  /**
   * Return the set of pattern elements which are mapped by this location in the context
   * of the given pattern
   * @param pattern_p a potentially null pattern
   * @return a non-null, potentially empty collection
   */
  Collection<EObject> getPatternElements(IPattern pattern_p);
  
}
