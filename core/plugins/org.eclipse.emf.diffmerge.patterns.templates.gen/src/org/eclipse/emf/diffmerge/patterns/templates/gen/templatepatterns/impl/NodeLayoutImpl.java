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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl#getContainedFontStyles <em>Contained Font Styles</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl#getOwnedStyle <em>Owned Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeLayoutImpl extends ShapeLayoutImpl implements NodeLayout {
	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final int X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected int x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final int Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected int y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainedFontStyles() <em>Contained Font Styles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedFontStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateFontStyle> containedFontStyles;

	/**
	 * The cached value of the '{@link #getOwnedStyle() <em>Owned Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStyle()
	 * @generated
	 * @ordered
	 */
	protected NodeStyle ownedStyle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.NODE_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_LAYOUT__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_LAYOUT__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_LAYOUT__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_LAYOUT__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateFontStyle> getContainedFontStyles() {
		if (containedFontStyles == null) {
			containedFontStyles = new EObjectContainmentEList<TemplateFontStyle>(TemplateFontStyle.class, this, TemplatepatternsPackage.NODE_LAYOUT__CONTAINED_FONT_STYLES);
		}
		return containedFontStyles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeStyle getOwnedStyle() {
		return ownedStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedStyle(NodeStyle newOwnedStyle, NotificationChain msgs) {
		NodeStyle oldOwnedStyle = ownedStyle;
		ownedStyle = newOwnedStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE, oldOwnedStyle, newOwnedStyle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedStyle(NodeStyle newOwnedStyle) {
		if (newOwnedStyle != ownedStyle) {
			NotificationChain msgs = null;
			if (ownedStyle != null)
				msgs = ((InternalEObject)ownedStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE, null, msgs);
			if (newOwnedStyle != null)
				msgs = ((InternalEObject)newOwnedStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE, null, msgs);
			msgs = basicSetOwnedStyle(newOwnedStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE, newOwnedStyle, newOwnedStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.NODE_LAYOUT__CONTAINED_FONT_STYLES:
				return ((InternalEList<?>)getContainedFontStyles()).basicRemove(otherEnd, msgs);
			case TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE:
				return basicSetOwnedStyle(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("boxing")
  @Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.NODE_LAYOUT__X:
				return getX();
			case TemplatepatternsPackage.NODE_LAYOUT__Y:
				return getY();
			case TemplatepatternsPackage.NODE_LAYOUT__HEIGHT:
				return getHeight();
			case TemplatepatternsPackage.NODE_LAYOUT__WIDTH:
				return getWidth();
			case TemplatepatternsPackage.NODE_LAYOUT__CONTAINED_FONT_STYLES:
				return getContainedFontStyles();
			case TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE:
				return getOwnedStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings({ "boxing", "unchecked" })
  @Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatepatternsPackage.NODE_LAYOUT__X:
				setX((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__Y:
				setY((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__WIDTH:
				setWidth((Integer)newValue);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__CONTAINED_FONT_STYLES:
				getContainedFontStyles().clear();
				getContainedFontStyles().addAll((Collection<? extends TemplateFontStyle>)newValue);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE:
				setOwnedStyle((NodeStyle)newValue);
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
			case TemplatepatternsPackage.NODE_LAYOUT__X:
				setX(X_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__Y:
				setY(Y_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__CONTAINED_FONT_STYLES:
				getContainedFontStyles().clear();
				return;
			case TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE:
				setOwnedStyle((NodeStyle)null);
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
			case TemplatepatternsPackage.NODE_LAYOUT__X:
				return x != X_EDEFAULT;
			case TemplatepatternsPackage.NODE_LAYOUT__Y:
				return y != Y_EDEFAULT;
			case TemplatepatternsPackage.NODE_LAYOUT__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case TemplatepatternsPackage.NODE_LAYOUT__WIDTH:
				return width != WIDTH_EDEFAULT;
			case TemplatepatternsPackage.NODE_LAYOUT__CONTAINED_FONT_STYLES:
				return containedFontStyles != null && !containedFontStyles.isEmpty();
			case TemplatepatternsPackage.NODE_LAYOUT__OWNED_STYLE:
				return ownedStyle != null;
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
		result.append(" (x: "); //$NON-NLS-1$
		result.append(x);
		result.append(", y: "); //$NON-NLS-1$
		result.append(y);
		result.append(", height: "); //$NON-NLS-1$
		result.append(height);
		result.append(", width: "); //$NON-NLS-1$
		result.append(width);
		result.append(')');
		return result.toString();
	}

} //NodeLayoutImpl
