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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Role Relative Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractRoleRelativeElementImpl#getRoleSymbol <em>Role Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractRoleRelativeElementImpl extends AbstractIdentifiedElementImpl implements AbstractRoleRelativeElement {
	/**
	 * The cached value of the '{@link #getRoleSymbol() <em>Role Symbol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleSymbol()
	 * @generated
	 * @ordered
	 */
	protected PatternRoleSymbol roleSymbol;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractRoleRelativeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorepatternsPackage.Literals.ABSTRACT_ROLE_RELATIVE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternRoleSymbol getRoleSymbol() {
		return roleSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoleSymbol(PatternRoleSymbol newRoleSymbol, NotificationChain msgs) {
		PatternRoleSymbol oldRoleSymbol = roleSymbol;
		roleSymbol = newRoleSymbol;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL, oldRoleSymbol, newRoleSymbol);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleSymbol(PatternRoleSymbol newRoleSymbol) {
		if (newRoleSymbol != roleSymbol) {
			NotificationChain msgs = null;
			if (roleSymbol != null)
				msgs = ((InternalEObject)roleSymbol).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL, null, msgs);
			if (newRoleSymbol != null)
				msgs = ((InternalEObject)newRoleSymbol).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL, null, msgs);
			msgs = basicSetRoleSymbol(newRoleSymbol, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL, newRoleSymbol, newRoleSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL:
				return basicSetRoleSymbol(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL:
				return getRoleSymbol();
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
			case CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL:
				setRoleSymbol((PatternRoleSymbol)newValue);
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
			case CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL:
				setRoleSymbol((PatternRoleSymbol)null);
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
			case CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL:
				return roleSymbol != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractRoleRelativeElementImpl
