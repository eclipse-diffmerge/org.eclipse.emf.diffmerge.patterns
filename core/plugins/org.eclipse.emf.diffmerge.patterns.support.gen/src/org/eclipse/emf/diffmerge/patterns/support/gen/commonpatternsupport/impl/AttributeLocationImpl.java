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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AttributeLocationImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeLocationImpl extends AbstractElementRelativeLocationImpl implements AttributeLocation {
  /**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
  protected EAttribute attribute;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AttributeLocationImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonpatternsupportPackage.Literals.ATTRIBUTE_LOCATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommonpatternsupportPackage.ATTRIBUTE_LOCATION__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute basicGetAttribute() {
		return attribute;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAttribute(EAttribute newAttribute) {
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonpatternsupportPackage.ATTRIBUTE_LOCATION__ATTRIBUTE, oldAttribute, attribute));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonpatternsupportPackage.ATTRIBUTE_LOCATION__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonpatternsupportPackage.ATTRIBUTE_LOCATION__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case CommonpatternsupportPackage.ATTRIBUTE_LOCATION__ATTRIBUTE:
				setAttribute((EAttribute)null);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonpatternsupportPackage.ATTRIBUTE_LOCATION__ATTRIBUTE:
				return attribute != null;
		}
		return super.eIsSet(featureID);
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
    return false;
  }
  
} //AttributeLocationImpl
