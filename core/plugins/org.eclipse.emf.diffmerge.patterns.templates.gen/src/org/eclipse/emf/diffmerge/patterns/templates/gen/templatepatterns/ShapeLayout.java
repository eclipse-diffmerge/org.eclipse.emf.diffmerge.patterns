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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shape Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout#getFontStyle <em>Font Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getShapeLayout()
 * @model abstract="true"
 * @generated
 */
public interface ShapeLayout extends Layout {
	/**
	 * Returns the value of the '<em><b>Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Style</em>' containment reference.
	 * @see #setFontStyle(TemplateFontStyle)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getShapeLayout_FontStyle()
	 * @model containment="true"
	 * @generated
	 */
	TemplateFontStyle getFontStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout#getFontStyle <em>Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Style</em>' containment reference.
	 * @see #getFontStyle()
	 * @generated
	 */
	void setFontStyle(TemplateFontStyle value);

} // ShapeLayout
