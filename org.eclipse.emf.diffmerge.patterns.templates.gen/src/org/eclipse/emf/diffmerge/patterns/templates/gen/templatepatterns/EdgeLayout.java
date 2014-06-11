/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinewidth <em>Linewidth</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinecolor <em>Linecolor</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getOwnedStyle <em>Owned Style</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getBeginFontStyle <em>Begin Font Style</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getEndFontStyle <em>End Font Style</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getCenterFontStyle <em>Center Font Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout()
 * @model
 * @generated
 */
public interface EdgeLayout extends Layout, ShapeLayout {
	/**
	 * Returns the value of the '<em><b>Bendpoints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bendpoints</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout_Bendpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<EdgeBendpoint> getBendpoints();

	/**
	 * Returns the value of the '<em><b>Linewidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linewidth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linewidth</em>' attribute.
	 * @see #setLinewidth(int)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout_Linewidth()
	 * @model
	 * @generated
	 */
	int getLinewidth();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinewidth <em>Linewidth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linewidth</em>' attribute.
	 * @see #getLinewidth()
	 * @generated
	 */
	void setLinewidth(int value);

	/**
	 * Returns the value of the '<em><b>Linecolor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linecolor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linecolor</em>' attribute.
	 * @see #setLinecolor(int)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout_Linecolor()
	 * @model
	 * @generated
	 */
	int getLinecolor();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinecolor <em>Linecolor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linecolor</em>' attribute.
	 * @see #getLinecolor()
	 * @generated
	 */
	void setLinecolor(int value);

	/**
	 * Returns the value of the '<em><b>Owned Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Style</em>' containment reference.
	 * @see #setOwnedStyle(EdgeStyle)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout_OwnedStyle()
	 * @model containment="true"
	 * @generated
	 */
	EdgeStyle getOwnedStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getOwnedStyle <em>Owned Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Style</em>' containment reference.
	 * @see #getOwnedStyle()
	 * @generated
	 */
	void setOwnedStyle(EdgeStyle value);

	/**
	 * Returns the value of the '<em><b>Begin Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin Font Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin Font Style</em>' containment reference.
	 * @see #setBeginFontStyle(TemplateFontStyle)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout_BeginFontStyle()
	 * @model containment="true"
	 * @generated
	 */
	TemplateFontStyle getBeginFontStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getBeginFontStyle <em>Begin Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin Font Style</em>' containment reference.
	 * @see #getBeginFontStyle()
	 * @generated
	 */
	void setBeginFontStyle(TemplateFontStyle value);

	/**
	 * Returns the value of the '<em><b>End Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Font Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Font Style</em>' containment reference.
	 * @see #setEndFontStyle(TemplateFontStyle)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout_EndFontStyle()
	 * @model containment="true"
	 * @generated
	 */
	TemplateFontStyle getEndFontStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getEndFontStyle <em>End Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Font Style</em>' containment reference.
	 * @see #getEndFontStyle()
	 * @generated
	 */
	void setEndFontStyle(TemplateFontStyle value);

	/**
	 * Returns the value of the '<em><b>Center Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Center Font Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Center Font Style</em>' containment reference.
	 * @see #setCenterFontStyle(TemplateFontStyle)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getEdgeLayout_CenterFontStyle()
	 * @model containment="true"
	 * @generated
	 */
	TemplateFontStyle getCenterFontStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getCenterFontStyle <em>Center Font Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Center Font Style</em>' containment reference.
	 * @see #getCenterFontStyle()
	 * @generated
	 */
	void setCenterFontStyle(TemplateFontStyle value);

} // EdgeLayout
