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

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Font Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl#getColor <em>Color</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl#isBold <em>Bold</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl#isItalic <em>Italic</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl#isUnderline <em>Underline</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl#isStrikethrough <em>Strikethrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateFontStyleImpl extends EObjectImpl implements TemplateFontStyle {
	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected int color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #isBold() <em>Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBold()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOLD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBold() <em>Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBold()
	 * @generated
	 * @ordered
	 */
	protected boolean bold = BOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #isItalic() <em>Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isItalic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ITALIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isItalic() <em>Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isItalic()
	 * @generated
	 * @ordered
	 */
	protected boolean italic = ITALIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isUnderline() <em>Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnderline()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNDERLINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnderline() <em>Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnderline()
	 * @generated
	 * @ordered
	 */
	protected boolean underline = UNDERLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #isStrikethrough() <em>Strikethrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrikethrough()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STRIKETHROUGH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStrikethrough() <em>Strikethrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrikethrough()
	 * @generated
	 * @ordered
	 */
	protected boolean strikethrough = STRIKETHROUGH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateFontStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.TEMPLATE_FONT_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(int newColor) {
		int oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_FONT_STYLE__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_FONT_STYLE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_FONT_STYLE__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBold() {
		return bold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBold(boolean newBold) {
		boolean oldBold = bold;
		bold = newBold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_FONT_STYLE__BOLD, oldBold, bold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isItalic() {
		return italic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItalic(boolean newItalic) {
		boolean oldItalic = italic;
		italic = newItalic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_FONT_STYLE__ITALIC, oldItalic, italic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnderline() {
		return underline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnderline(boolean newUnderline) {
		boolean oldUnderline = underline;
		underline = newUnderline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_FONT_STYLE__UNDERLINE, oldUnderline, underline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStrikethrough() {
		return strikethrough;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrikethrough(boolean newStrikethrough) {
		boolean oldStrikethrough = strikethrough;
		strikethrough = newStrikethrough;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_FONT_STYLE__STRIKETHROUGH, oldStrikethrough, strikethrough));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__COLOR:
				return getColor();
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__NAME:
				return getName();
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__HEIGHT:
				return getHeight();
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__BOLD:
				return isBold();
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__ITALIC:
				return isItalic();
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__UNDERLINE:
				return isUnderline();
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__STRIKETHROUGH:
				return isStrikethrough();
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
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__COLOR:
				setColor((Integer)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__NAME:
				setName((String)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__BOLD:
				setBold((Boolean)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__ITALIC:
				setItalic((Boolean)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__UNDERLINE:
				setUnderline((Boolean)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__STRIKETHROUGH:
				setStrikethrough((Boolean)newValue);
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
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__BOLD:
				setBold(BOLD_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__ITALIC:
				setItalic(ITALIC_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__UNDERLINE:
				setUnderline(UNDERLINE_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__STRIKETHROUGH:
				setStrikethrough(STRIKETHROUGH_EDEFAULT);
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
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__COLOR:
				return color != COLOR_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__BOLD:
				return bold != BOLD_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__ITALIC:
				return italic != ITALIC_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__UNDERLINE:
				return underline != UNDERLINE_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE__STRIKETHROUGH:
				return strikethrough != STRIKETHROUGH_EDEFAULT;
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
		result.append(" (color: "); //$NON-NLS-1$
		result.append(color);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", height: "); //$NON-NLS-1$
		result.append(height);
		result.append(", bold: "); //$NON-NLS-1$
		result.append(bold);
		result.append(", italic: "); //$NON-NLS-1$
		result.append(italic);
		result.append(", underline: "); //$NON-NLS-1$
		result.append(underline);
		result.append(", strikethrough: "); //$NON-NLS-1$
		result.append(strikethrough);
		result.append(')');
		return result.toString();
	}

} //TemplateFontStyleImpl
