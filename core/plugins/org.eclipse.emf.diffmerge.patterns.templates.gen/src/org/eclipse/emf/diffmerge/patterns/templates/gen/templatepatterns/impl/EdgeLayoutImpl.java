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

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getFontStyle <em>Font Style</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getLinewidth <em>Linewidth</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getLinecolor <em>Linecolor</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getOwnedStyle <em>Owned Style</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getBeginFontStyle <em>Begin Font Style</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getEndFontStyle <em>End Font Style</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl#getCenterFontStyle <em>Center Font Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeLayoutImpl extends LayoutImpl implements EdgeLayout {
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
	 * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<EdgeBendpoint> bendpoints;

	/**
	 * The default value of the '{@link #getLinewidth() <em>Linewidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinewidth()
	 * @generated
	 * @ordered
	 */
	protected static final int LINEWIDTH_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getLinewidth() <em>Linewidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinewidth()
	 * @generated
	 * @ordered
	 */
	protected int linewidth = LINEWIDTH_EDEFAULT;
	/**
	 * The default value of the '{@link #getLinecolor() <em>Linecolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinecolor()
	 * @generated
	 * @ordered
	 */
	protected static final int LINECOLOR_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getLinecolor() <em>Linecolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinecolor()
	 * @generated
	 * @ordered
	 */
	protected int linecolor = LINECOLOR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getOwnedStyle() <em>Owned Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStyle()
	 * @generated
	 * @ordered
	 */
	protected EdgeStyle ownedStyle;
	/**
	 * The cached value of the '{@link #getBeginFontStyle() <em>Begin Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginFontStyle()
	 * @generated
	 * @ordered
	 */
	protected TemplateFontStyle beginFontStyle;
	/**
	 * The cached value of the '{@link #getEndFontStyle() <em>End Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndFontStyle()
	 * @generated
	 * @ordered
	 */
	protected TemplateFontStyle endFontStyle;
	/**
	 * The cached value of the '{@link #getCenterFontStyle() <em>Center Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCenterFontStyle()
	 * @generated
	 * @ordered
	 */
	protected TemplateFontStyle centerFontStyle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.EDGE_LAYOUT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE, oldFontStyle, newFontStyle);
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
				msgs = ((InternalEObject)fontStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE, null, msgs);
			if (newFontStyle != null)
				msgs = ((InternalEObject)newFontStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE, null, msgs);
			msgs = basicSetFontStyle(newFontStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE, newFontStyle, newFontStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdgeBendpoint> getBendpoints() {
		if (bendpoints == null) {
			bendpoints = new EObjectContainmentEList<EdgeBendpoint>(EdgeBendpoint.class, this, TemplatepatternsPackage.EDGE_LAYOUT__BENDPOINTS);
		}
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLinewidth() {
		return linewidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinewidth(int newLinewidth) {
		int oldLinewidth = linewidth;
		linewidth = newLinewidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__LINEWIDTH, oldLinewidth, linewidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLinecolor() {
		return linecolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinecolor(int newLinecolor) {
		int oldLinecolor = linecolor;
		linecolor = newLinecolor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__LINECOLOR, oldLinecolor, linecolor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeStyle getOwnedStyle() {
		return ownedStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedStyle(EdgeStyle newOwnedStyle, NotificationChain msgs) {
		EdgeStyle oldOwnedStyle = ownedStyle;
		ownedStyle = newOwnedStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE, oldOwnedStyle, newOwnedStyle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedStyle(EdgeStyle newOwnedStyle) {
		if (newOwnedStyle != ownedStyle) {
			NotificationChain msgs = null;
			if (ownedStyle != null)
				msgs = ((InternalEObject)ownedStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE, null, msgs);
			if (newOwnedStyle != null)
				msgs = ((InternalEObject)newOwnedStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE, null, msgs);
			msgs = basicSetOwnedStyle(newOwnedStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE, newOwnedStyle, newOwnedStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateFontStyle getBeginFontStyle() {
		return beginFontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBeginFontStyle(TemplateFontStyle newBeginFontStyle, NotificationChain msgs) {
		TemplateFontStyle oldBeginFontStyle = beginFontStyle;
		beginFontStyle = newBeginFontStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE, oldBeginFontStyle, newBeginFontStyle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeginFontStyle(TemplateFontStyle newBeginFontStyle) {
		if (newBeginFontStyle != beginFontStyle) {
			NotificationChain msgs = null;
			if (beginFontStyle != null)
				msgs = ((InternalEObject)beginFontStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE, null, msgs);
			if (newBeginFontStyle != null)
				msgs = ((InternalEObject)newBeginFontStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE, null, msgs);
			msgs = basicSetBeginFontStyle(newBeginFontStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE, newBeginFontStyle, newBeginFontStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateFontStyle getEndFontStyle() {
		return endFontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndFontStyle(TemplateFontStyle newEndFontStyle, NotificationChain msgs) {
		TemplateFontStyle oldEndFontStyle = endFontStyle;
		endFontStyle = newEndFontStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE, oldEndFontStyle, newEndFontStyle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndFontStyle(TemplateFontStyle newEndFontStyle) {
		if (newEndFontStyle != endFontStyle) {
			NotificationChain msgs = null;
			if (endFontStyle != null)
				msgs = ((InternalEObject)endFontStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE, null, msgs);
			if (newEndFontStyle != null)
				msgs = ((InternalEObject)newEndFontStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE, null, msgs);
			msgs = basicSetEndFontStyle(newEndFontStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE, newEndFontStyle, newEndFontStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateFontStyle getCenterFontStyle() {
		return centerFontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCenterFontStyle(TemplateFontStyle newCenterFontStyle, NotificationChain msgs) {
		TemplateFontStyle oldCenterFontStyle = centerFontStyle;
		centerFontStyle = newCenterFontStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE, oldCenterFontStyle, newCenterFontStyle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCenterFontStyle(TemplateFontStyle newCenterFontStyle) {
		if (newCenterFontStyle != centerFontStyle) {
			NotificationChain msgs = null;
			if (centerFontStyle != null)
				msgs = ((InternalEObject)centerFontStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE, null, msgs);
			if (newCenterFontStyle != null)
				msgs = ((InternalEObject)newCenterFontStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE, null, msgs);
			msgs = basicSetCenterFontStyle(newCenterFontStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE, newCenterFontStyle, newCenterFontStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE:
				return basicSetFontStyle(null, msgs);
			case TemplatepatternsPackage.EDGE_LAYOUT__BENDPOINTS:
				return ((InternalEList<?>)getBendpoints()).basicRemove(otherEnd, msgs);
			case TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE:
				return basicSetOwnedStyle(null, msgs);
			case TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE:
				return basicSetBeginFontStyle(null, msgs);
			case TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE:
				return basicSetEndFontStyle(null, msgs);
			case TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE:
				return basicSetCenterFontStyle(null, msgs);
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
			case TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE:
				return getFontStyle();
			case TemplatepatternsPackage.EDGE_LAYOUT__BENDPOINTS:
				return getBendpoints();
			case TemplatepatternsPackage.EDGE_LAYOUT__LINEWIDTH:
				return getLinewidth();
			case TemplatepatternsPackage.EDGE_LAYOUT__LINECOLOR:
				return getLinecolor();
			case TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE:
				return getOwnedStyle();
			case TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE:
				return getBeginFontStyle();
			case TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE:
				return getEndFontStyle();
			case TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE:
				return getCenterFontStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE:
				setFontStyle((TemplateFontStyle)newValue);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__BENDPOINTS:
				getBendpoints().clear();
				getBendpoints().addAll((Collection<? extends EdgeBendpoint>)newValue);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__LINEWIDTH:
				setLinewidth((Integer)newValue);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__LINECOLOR:
				setLinecolor((Integer)newValue);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE:
				setOwnedStyle((EdgeStyle)newValue);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE:
				setBeginFontStyle((TemplateFontStyle)newValue);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE:
				setEndFontStyle((TemplateFontStyle)newValue);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE:
				setCenterFontStyle((TemplateFontStyle)newValue);
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
			case TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE:
				setFontStyle((TemplateFontStyle)null);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__BENDPOINTS:
				getBendpoints().clear();
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__LINEWIDTH:
				setLinewidth(LINEWIDTH_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__LINECOLOR:
				setLinecolor(LINECOLOR_EDEFAULT);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE:
				setOwnedStyle((EdgeStyle)null);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE:
				setBeginFontStyle((TemplateFontStyle)null);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE:
				setEndFontStyle((TemplateFontStyle)null);
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE:
				setCenterFontStyle((TemplateFontStyle)null);
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
			case TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE:
				return fontStyle != null;
			case TemplatepatternsPackage.EDGE_LAYOUT__BENDPOINTS:
				return bendpoints != null && !bendpoints.isEmpty();
			case TemplatepatternsPackage.EDGE_LAYOUT__LINEWIDTH:
				return linewidth != LINEWIDTH_EDEFAULT;
			case TemplatepatternsPackage.EDGE_LAYOUT__LINECOLOR:
				return linecolor != LINECOLOR_EDEFAULT;
			case TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE:
				return ownedStyle != null;
			case TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE:
				return beginFontStyle != null;
			case TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE:
				return endFontStyle != null;
			case TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE:
				return centerFontStyle != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ShapeLayout.class) {
			switch (derivedFeatureID) {
				case TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE: return TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ShapeLayout.class) {
			switch (baseFeatureID) {
				case TemplatepatternsPackage.SHAPE_LAYOUT__FONT_STYLE: return TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (linewidth: "); //$NON-NLS-1$
		result.append(linewidth);
		result.append(", linecolor: "); //$NON-NLS-1$
		result.append(linecolor);
		result.append(')');
		return result.toString();
	}

} //EdgeLayoutImpl
