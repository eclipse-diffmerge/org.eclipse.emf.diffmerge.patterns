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

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternVersionImpl#getPatternSymbol <em>Pattern Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternVersionImpl extends AbstractVersionedElementImpl implements PatternVersion {
	/**
	 * The cached value of the '{@link #getPatternSymbol() <em>Pattern Symbol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternSymbol()
	 * @generated
	 * @ordered
	 */
	protected PatternSymbol patternSymbol;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternVersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorepatternsPackage.Literals.PATTERN_VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternSymbol getPatternSymbol() {
		return patternSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPatternSymbol(PatternSymbol newPatternSymbol, NotificationChain msgs) {
		PatternSymbol oldPatternSymbol = patternSymbol;
		patternSymbol = newPatternSymbol;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL, oldPatternSymbol, newPatternSymbol);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternSymbol(PatternSymbol newPatternSymbol) {
		if (newPatternSymbol != patternSymbol) {
			NotificationChain msgs = null;
			if (patternSymbol != null)
				msgs = ((InternalEObject)patternSymbol).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL, null, msgs);
			if (newPatternSymbol != null)
				msgs = ((InternalEObject)newPatternSymbol).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL, null, msgs);
			msgs = basicSetPatternSymbol(newPatternSymbol, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL, newPatternSymbol, newPatternSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL:
				return basicSetPatternSymbol(null, msgs);
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
			case CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL:
				return getPatternSymbol();
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
			case CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL:
				setPatternSymbol((PatternSymbol)newValue);
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
			case CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL:
				setPatternSymbol((PatternSymbol)null);
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
			case CorepatternsPackage.PATTERN_VERSION__PATTERN_SYMBOL:
				return patternSymbol != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternVersionImpl
