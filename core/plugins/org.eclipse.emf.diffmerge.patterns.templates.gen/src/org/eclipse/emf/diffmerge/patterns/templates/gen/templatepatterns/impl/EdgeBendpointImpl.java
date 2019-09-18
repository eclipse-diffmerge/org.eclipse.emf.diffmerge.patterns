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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Bendpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl#getSourceX <em>Source X</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl#getSourceY <em>Source Y</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl#getTargetX <em>Target X</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl#getTargetY <em>Target Y</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeBendpointImpl extends AbstractIdentifiedElementImpl implements EdgeBendpoint {
	/**
	 * The default value of the '{@link #getSourceX() <em>Source X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceX()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSourceX() <em>Source X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceX()
	 * @generated
	 * @ordered
	 */
	protected int sourceX = SOURCE_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceY() <em>Source Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceY()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSourceY() <em>Source Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceY()
	 * @generated
	 * @ordered
	 */
	protected int sourceY = SOURCE_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetX() <em>Target X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetX()
	 * @generated
	 * @ordered
	 */
	protected static final int TARGET_X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTargetX() <em>Target X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetX()
	 * @generated
	 * @ordered
	 */
	protected int targetX = TARGET_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetY() <em>Target Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetY()
	 * @generated
	 * @ordered
	 */
	protected static final int TARGET_Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTargetY() <em>Target Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetY()
	 * @generated
	 * @ordered
	 */
	protected int targetY = TARGET_Y_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeBendpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.EDGE_BENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSourceX() {
		return sourceX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceX(int newSourceX) {
		int oldSourceX = sourceX;
		sourceX = newSourceX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_X, oldSourceX, sourceX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSourceY() {
		return sourceY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceY(int newSourceY) {
		int oldSourceY = sourceY;
		sourceY = newSourceY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_Y, oldSourceY, sourceY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTargetX() {
		return targetX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetX(int newTargetX) {
		int oldTargetX = targetX;
		targetX = newTargetX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_X, oldTargetX, targetX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTargetY() {
		return targetY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetY(int newTargetY) {
		int oldTargetY = targetY;
		targetY = newTargetY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_Y, oldTargetY, targetY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_X:
				return getSourceX();
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_Y:
				return getSourceY();
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_X:
				return getTargetX();
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_Y:
				return getTargetY();
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
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_X:
				setSourceX((Integer)newValue);
				return;
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_Y:
				setSourceY((Integer)newValue);
				return;
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_X:
				setTargetX((Integer)newValue);
				return;
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_Y:
				setTargetY((Integer)newValue);
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
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_X:
				setSourceX(SOURCE_X_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_Y:
				setSourceY(SOURCE_Y_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_X:
				setTargetX(TARGET_X_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_Y:
				setTargetY(TARGET_Y_EDEFAULT);
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
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_X:
				return sourceX != SOURCE_X_EDEFAULT;
			case TemplatepatternsPackage.EDGE_BENDPOINT__SOURCE_Y:
				return sourceY != SOURCE_Y_EDEFAULT;
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_X:
				return targetX != TARGET_X_EDEFAULT;
			case TemplatepatternsPackage.EDGE_BENDPOINT__TARGET_Y:
				return targetY != TARGET_Y_EDEFAULT;
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
		result.append(" (sourceX: "); //$NON-NLS-1$
		result.append(sourceX);
		result.append(", sourceY: "); //$NON-NLS-1$
		result.append(sourceY);
		result.append(", targetX: "); //$NON-NLS-1$
		result.append(targetX);
		result.append(", targetY: "); //$NON-NLS-1$
		result.append(targetY);
		result.append(')');
		return result.toString();
	}

} //EdgeBendpointImpl
