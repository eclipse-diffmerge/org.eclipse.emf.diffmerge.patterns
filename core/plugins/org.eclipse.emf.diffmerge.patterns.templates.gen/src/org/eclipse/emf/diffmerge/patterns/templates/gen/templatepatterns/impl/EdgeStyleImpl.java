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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl#getLinestyle <em>Linestyle</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl#getRoutingstyle <em>Routingstyle</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl#getTargetarrow <em>Targetarrow</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl#getSourcearrow <em>Sourcearrow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeStyleImpl extends StyleImpl implements EdgeStyle {
	/**
	 * The default value of the '{@link #getLinestyle() <em>Linestyle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinestyle()
	 * @generated
	 * @ordered
	 */
	protected static final String LINESTYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinestyle() <em>Linestyle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinestyle()
	 * @generated
	 * @ordered
	 */
	protected String linestyle = LINESTYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoutingstyle() <em>Routingstyle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingstyle()
	 * @generated
	 * @ordered
	 */
	protected static final String ROUTINGSTYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoutingstyle() <em>Routingstyle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutingstyle()
	 * @generated
	 * @ordered
	 */
	protected String routingstyle = ROUTINGSTYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetarrow() <em>Targetarrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetarrow()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGETARROW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetarrow() <em>Targetarrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetarrow()
	 * @generated
	 * @ordered
	 */
	protected String targetarrow = TARGETARROW_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourcearrow() <em>Sourcearrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcearrow()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCEARROW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourcearrow() <em>Sourcearrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcearrow()
	 * @generated
	 * @ordered
	 */
	protected String sourcearrow = SOURCEARROW_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.EDGE_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinestyle() {
		return linestyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinestyle(String newLinestyle) {
		String oldLinestyle = linestyle;
		linestyle = newLinestyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_STYLE__LINESTYLE, oldLinestyle, linestyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoutingstyle() {
		return routingstyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutingstyle(String newRoutingstyle) {
		String oldRoutingstyle = routingstyle;
		routingstyle = newRoutingstyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_STYLE__ROUTINGSTYLE, oldRoutingstyle, routingstyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetarrow() {
		return targetarrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetarrow(String newTargetarrow) {
		String oldTargetarrow = targetarrow;
		targetarrow = newTargetarrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_STYLE__TARGETARROW, oldTargetarrow, targetarrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourcearrow() {
		return sourcearrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcearrow(String newSourcearrow) {
		String oldSourcearrow = sourcearrow;
		sourcearrow = newSourcearrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_STYLE__SOURCEARROW, oldSourcearrow, sourcearrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.EDGE_STYLE__LINESTYLE:
				return getLinestyle();
			case TemplatepatternsPackage.EDGE_STYLE__ROUTINGSTYLE:
				return getRoutingstyle();
			case TemplatepatternsPackage.EDGE_STYLE__TARGETARROW:
				return getTargetarrow();
			case TemplatepatternsPackage.EDGE_STYLE__SOURCEARROW:
				return getSourcearrow();
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
			case TemplatepatternsPackage.EDGE_STYLE__LINESTYLE:
				setLinestyle((String)newValue);
				return;
			case TemplatepatternsPackage.EDGE_STYLE__ROUTINGSTYLE:
				setRoutingstyle((String)newValue);
				return;
			case TemplatepatternsPackage.EDGE_STYLE__TARGETARROW:
				setTargetarrow((String)newValue);
				return;
			case TemplatepatternsPackage.EDGE_STYLE__SOURCEARROW:
				setSourcearrow((String)newValue);
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
			case TemplatepatternsPackage.EDGE_STYLE__LINESTYLE:
				setLinestyle(LINESTYLE_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_STYLE__ROUTINGSTYLE:
				setRoutingstyle(ROUTINGSTYLE_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_STYLE__TARGETARROW:
				setTargetarrow(TARGETARROW_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_STYLE__SOURCEARROW:
				setSourcearrow(SOURCEARROW_EDEFAULT);
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
			case TemplatepatternsPackage.EDGE_STYLE__LINESTYLE:
				return LINESTYLE_EDEFAULT == null ? linestyle != null : !LINESTYLE_EDEFAULT.equals(linestyle);
			case TemplatepatternsPackage.EDGE_STYLE__ROUTINGSTYLE:
				return ROUTINGSTYLE_EDEFAULT == null ? routingstyle != null : !ROUTINGSTYLE_EDEFAULT.equals(routingstyle);
			case TemplatepatternsPackage.EDGE_STYLE__TARGETARROW:
				return TARGETARROW_EDEFAULT == null ? targetarrow != null : !TARGETARROW_EDEFAULT.equals(targetarrow);
			case TemplatepatternsPackage.EDGE_STYLE__SOURCEARROW:
				return SOURCEARROW_EDEFAULT == null ? sourcearrow != null : !SOURCEARROW_EDEFAULT.equals(sourcearrow);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (linestyle: "); //$NON-NLS-1$
		result.append(linestyle);
		result.append(", routingstyle: "); //$NON-NLS-1$
		result.append(routingstyle);
		result.append(", targetarrow: "); //$NON-NLS-1$
		result.append(targetarrow);
		result.append(", sourcearrow: "); //$NON-NLS-1$
		result.append(sourcearrow);
		result.append(')');
		return result.toString();
	}

} //EdgeStyleImpl
