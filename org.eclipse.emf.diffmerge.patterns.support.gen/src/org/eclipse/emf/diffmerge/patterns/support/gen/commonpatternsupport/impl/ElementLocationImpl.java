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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ElementLocationImpl extends AbstractElementRelativeLocationImpl implements ElementLocation {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ElementLocationImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonpatternsupportPackage.Literals.ELEMENT_LOCATION;
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   * @generated NOT
   */
  public boolean supportsAddition() {
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   * @generated NOT
   */
  public boolean supportsMerge() {
    return true;
  }
  
} //ElementLocationImpl
