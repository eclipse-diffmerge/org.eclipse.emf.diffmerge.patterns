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
package org.eclipse.emf.diffmerge.patterns.core.util.locations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;


/**
 * A simple implementation of IReferenceLocation.
 * @author Olivier Constant
 */
public class BasicReferenceLocation extends AbstractFeatureRelativeLocation implements IReferenceLocation {
  
  /**
   * Constructor
   * @param element_p the non-null element of this location
   * @param reference_p the non-null reference of this location
   */
  public BasicReferenceLocation(EObject element_p, EReference reference_p) {
    super(element_p, reference_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation#getAttribute()
   */
  public EReference getReference() {
    return (EReference)getFeature();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   */
  public boolean supportsAddition() {
    return getReference().isContainment();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   */
  public boolean supportsMerge() {
    return false;
  }
  
}
