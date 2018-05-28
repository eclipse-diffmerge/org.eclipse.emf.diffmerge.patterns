/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shape Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ShapeLayoutImpl#getFontStyle <em>Font Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ShapeLayoutImpl extends LayoutImpl implements ShapeLayout {
	/**
	 * The cached value of the '{@link #getFontStyle() <em>Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontStyle()
	 * @generated
	 * @ordered
	 */
	protected TemplateFontStyle fontStyle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapeLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.SHAPE_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateFontStyle getFontStyle() {
		return fontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFontStyle(TemplateFontStyle newFontStyle, NotificationChain msgs) {
		TemplateFontStyle oldFontStyle = fontStyle;
		fontStyle = newFontStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE, oldFontStyle, newFontStyle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontStyle(TemplateFontStyle newFontStyle) {
		if (newFontStyle != fontStyle) {
			NotificationChain msgs = null;
			if (fontStyle != null)
				msgs = ((InternalEObject)fontStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE, null, msgs);
			if (newFontStyle != null)
				msgs = ((InternalEObject)newFontStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE, null, msgs);
			msgs = basicSetFontStyle(newFontStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE, newFontStyle, newFontStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE:
				return basicSetFontStyle(null, msgs);
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
			case TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE:
				return getFontStyle();
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
			case TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE:
				setFontStyle((TemplateFontStyle)newValue);
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
			case TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE:
				setFontStyle((TemplateFontStyle)null);
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
			case TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE:
				return fontStyle != null;
		}
		return super.eIsSet(featureID);
	}

} //ShapeLayoutImpl
