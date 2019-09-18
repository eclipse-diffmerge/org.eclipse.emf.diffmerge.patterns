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
package org.eclipse.emf.diffmerge.patterns.core.util.locations;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;



/**
 * A simple implementation of IMappingElementLocation.
 * @author Olivier Constant
 */
public class BasicElementMappingLocation implements IElementMappingLocation {
  
  /** The <pattern element, model element> mapping */
  private final EMap<EObject, EObject> _mapping;
  
  /**
   * Default constructor
   */
  public BasicElementMappingLocation() {
    _mapping = new ModelsUtil.RMap<EObject, EObject>();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#getAtomicContents()
   */
  public List<IAtomicLocation> getAtomicContents() {
    return Collections.singletonList((IAtomicLocation)this);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation#getElement(org.eclipse.emf.ecore.EObject)
   */
  public EObject getElement(EObject patternElement_p) {
    return _mapping.get(patternElement_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation#getModelElements()
   */
  public Collection<EObject> getModelElements() {
    return _mapping.values();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation#getPatternElements(IPattern)
   */
  public Collection<EObject> getPatternElements(IPattern pattern_p) {
    return _mapping.keySet();
  }
  
  /**
   * Map the given elements
   * @param patternElement_p a non-null element
   * @param modelElement_p a non-null element
   */
  public void map(EObject patternElement_p, EObject modelElement_p) {
    _mapping.put(patternElement_p, modelElement_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   */
  public boolean supportsAddition() {
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   */
  public boolean supportsMerge() {
    return true;
  }
  
}
