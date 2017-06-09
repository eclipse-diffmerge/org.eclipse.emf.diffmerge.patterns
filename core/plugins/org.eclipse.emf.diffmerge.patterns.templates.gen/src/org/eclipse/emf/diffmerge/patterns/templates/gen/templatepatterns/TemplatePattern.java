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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getTemplateElements <em>Template Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getMultiElements <em>Multi Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getLayoutData <em>Layout Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePattern()
 * @model
 * @generated
 */
public interface TemplatePattern extends AbstractPattern {

	/**
	 * Returns the value of the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' containment reference.
	 * @see #setImage(ImageSpecification)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePattern_Image()
	 * @model containment="true"
	 * @generated
	 */
	ImageSpecification getImage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getImage <em>Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' containment reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(ImageSpecification value);

	/**
	 * Returns the value of the '<em><b>Layout Data</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EObject},
	 * and the value is of type {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Data</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Data</em>' map.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePattern_LayoutData()
	 * @model mapType="org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.LayoutEntry<org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout>"
	 * @generated
	 */
	EMap<EObject, Layout> getLayoutData();

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePattern_Roles()
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPattern
	 * @model opposite="pattern" containment="true" required="true"
	 * @generated
	 */
	EList<TemplatePatternRole> getRoles();

	/**
	 * Returns the value of the '<em><b>Template Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Elements</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePattern_TemplateElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getTemplateElements();

	/**
	 * Returns the value of the '<em><b>Multi Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Elements</em>' reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePattern_MultiElements()
	 * @model
	 * @generated
	 */
	EList<EObject> getMultiElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 * @generated
	 */
	boolean isUnique(EObject element);

} // TemplatePattern
