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
package org.eclipse.emf.diffmerge.patterns.core.util.locations;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;


/**
 * A partial implementation of locations which are relative to a feature of an element.
 * @author Olivier Constant
 */
public abstract class AbstractElementRelativeLocation implements IElementRelativeLocation {
  
  /** The element */
  private final EObject _element;
  
  /**
   * Constructor
   * @param element_p a non-null element
   */
  protected AbstractElementRelativeLocation(EObject element_p) {
    assert element_p != null;
    _element = element_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#getAtomicContents()
   */
  public List<IAtomicLocation> getAtomicContents() {
    return Collections.singletonList((IAtomicLocation)this);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation#getElement()
   */
  public EObject getElement() {
    return _element;
  }
  
/**
 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation#getElement(java.lang.Object)
 */
  public EObject getElement(Object context_p) {
    return _element;
  }
  
}
