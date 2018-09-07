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
