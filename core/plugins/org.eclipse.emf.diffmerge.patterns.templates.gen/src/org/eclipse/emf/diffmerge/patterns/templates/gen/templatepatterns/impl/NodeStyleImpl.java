/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl#getBordercolor <em>Bordercolor</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl#getBordersize <em>Bordersize</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl#getShapecolor <em>Shapecolor</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl#getTransparency <em>Transparency</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl#getBackgroundcolor <em>Backgroundcolor</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl#getForegroundcolor <em>Foregroundcolor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeStyleImpl extends StyleImpl implements NodeStyle {
	/**
	 * The default value of the '{@link #getBordercolor() <em>Bordercolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBordercolor()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDERCOLOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBordercolor() <em>Bordercolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBordercolor()
	 * @generated
	 * @ordered
	 */
	protected int bordercolor = BORDERCOLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getBordersize() <em>Bordersize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBordersize()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDERSIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBordersize() <em>Bordersize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBordersize()
	 * @generated
	 * @ordered
	 */
	protected int bordersize = BORDERSIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShapecolor() <em>Shapecolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShapecolor()
	 * @generated
	 * @ordered
	 */
	protected static final int SHAPECOLOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getShapecolor() <em>Shapecolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShapecolor()
	 * @generated
	 * @ordered
	 */
	protected int shapecolor = SHAPECOLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransparency() <em>Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransparency()
	 * @generated
	 * @ordered
	 */
	protected static final int TRANSPARENCY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTransparency() <em>Transparency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransparency()
	 * @generated
	 * @ordered
	 */
	protected int transparency = TRANSPARENCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackgroundcolor() <em>Backgroundcolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundcolor()
	 * @generated
	 * @ordered
	 */
	protected static final int BACKGROUNDCOLOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBackgroundcolor() <em>Backgroundcolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundcolor()
	 * @generated
	 * @ordered
	 */
	protected int backgroundcolor = BACKGROUNDCOLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getForegroundcolor() <em>Foregroundcolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundcolor()
	 * @generated
	 * @ordered
	 */
	protected static final int FOREGROUNDCOLOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getForegroundcolor() <em>Foregroundcolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundcolor()
	 * @generated
	 * @ordered
	 */
	protected int foregroundcolor = FOREGROUNDCOLOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.NODE_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBordercolor() {
		return bordercolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBordercolor(int newBordercolor) {
		int oldBordercolor = bordercolor;
		bordercolor = newBordercolor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_STYLE__BORDERCOLOR, oldBordercolor, bordercolor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBordersize() {
		return bordersize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBordersize(int newBordersize) {
		int oldBordersize = bordersize;
		bordersize = newBordersize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_STYLE__BORDERSIZE, oldBordersize, bordersize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getShapecolor() {
		return shapecolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShapecolor(int newShapecolor) {
		int oldShapecolor = shapecolor;
		shapecolor = newShapecolor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_STYLE__SHAPECOLOR, oldShapecolor, shapecolor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTransparency() {
		return transparency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransparency(int newTransparency) {
		int oldTransparency = transparency;
		transparency = newTransparency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_STYLE__TRANSPARENCY, oldTransparency, transparency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBackgroundcolor() {
		return backgroundcolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundcolor(int newBackgroundcolor) {
		int oldBackgroundcolor = backgroundcolor;
		backgroundcolor = newBackgroundcolor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_STYLE__BACKGROUNDCOLOR, oldBackgroundcolor, backgroundcolor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getForegroundcolor() {
		return foregroundcolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundcolor(int newForegroundcolor) {
		int oldForegroundcolor = foregroundcolor;
		foregroundcolor = newForegroundcolor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_STYLE__FOREGROUNDCOLOR, oldForegroundcolor, foregroundcolor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.NODE_STYLE__BORDERCOLOR:
				return getBordercolor();
			case TemplatepatternsPackage.NODE_STYLE__BORDERSIZE:
				return getBordersize();
			case TemplatepatternsPackage.NODE_STYLE__SHAPECOLOR:
				return getShapecolor();
			case TemplatepatternsPackage.NODE_STYLE__TRANSPARENCY:
				return getTransparency();
			case TemplatepatternsPackage.NODE_STYLE__BACKGROUNDCOLOR:
				return getBackgroundcolor();
			case TemplatepatternsPackage.NODE_STYLE__FOREGROUNDCOLOR:
				return getForegroundcolor();
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
			case TemplatepatternsPackage.NODE_STYLE__BORDERCOLOR:
				setBordercolor((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_STYLE__BORDERSIZE:
				setBordersize((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_STYLE__SHAPECOLOR:
				setShapecolor((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_STYLE__TRANSPARENCY:
				setTransparency((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_STYLE__BACKGROUNDCOLOR:
				setBackgroundcolor((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_STYLE__FOREGROUNDCOLOR:
				setForegroundcolor((Integer)newValue);
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
			case TemplatepatternsPackage.NODE_STYLE__BORDERCOLOR:
				setBordercolor(BORDERCOLOR_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_STYLE__BORDERSIZE:
				setBordersize(BORDERSIZE_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_STYLE__SHAPECOLOR:
				setShapecolor(SHAPECOLOR_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_STYLE__TRANSPARENCY:
				setTransparency(TRANSPARENCY_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_STYLE__BACKGROUNDCOLOR:
				setBackgroundcolor(BACKGROUNDCOLOR_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_STYLE__FOREGROUNDCOLOR:
				setForegroundcolor(FOREGROUNDCOLOR_EDEFAULT);
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
			case TemplatepatternsPackage.NODE_STYLE__BORDERCOLOR:
				return bordercolor != BORDERCOLOR_EDEFAULT;
			case TemplatepatternsPackage.NODE_STYLE__BORDERSIZE:
				return bordersize != BORDERSIZE_EDEFAULT;
			case TemplatepatternsPackage.NODE_STYLE__SHAPECOLOR:
				return shapecolor != SHAPECOLOR_EDEFAULT;
			case TemplatepatternsPackage.NODE_STYLE__TRANSPARENCY:
				return transparency != TRANSPARENCY_EDEFAULT;
			case TemplatepatternsPackage.NODE_STYLE__BACKGROUNDCOLOR:
				return backgroundcolor != BACKGROUNDCOLOR_EDEFAULT;
			case TemplatepatternsPackage.NODE_STYLE__FOREGROUNDCOLOR:
				return foregroundcolor != FOREGROUNDCOLOR_EDEFAULT;
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
		result.append(" (bordercolor: "); //$NON-NLS-1$
		result.append(bordercolor);
		result.append(", bordersize: "); //$NON-NLS-1$
		result.append(bordersize);
		result.append(", shapecolor: "); //$NON-NLS-1$
		result.append(shapecolor);
		result.append(", transparency: "); //$NON-NLS-1$
		result.append(transparency);
		result.append(", backgroundcolor: "); //$NON-NLS-1$
		result.append(backgroundcolor);
		result.append(", foregroundcolor: "); //$NON-NLS-1$
		result.append(foregroundcolor);
		result.append(')');
		return result.toString();
	}

} //NodeStyleImpl
