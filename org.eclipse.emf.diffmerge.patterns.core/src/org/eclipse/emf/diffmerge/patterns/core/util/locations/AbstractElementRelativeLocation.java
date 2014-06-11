/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
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
   * @param pattern_p a non-null element
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
