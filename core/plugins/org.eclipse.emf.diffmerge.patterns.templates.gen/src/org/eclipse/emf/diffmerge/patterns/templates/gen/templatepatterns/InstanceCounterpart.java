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

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Counterpart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getTemplateId <em>Template Id</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getMultipart <em>Multipart</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getInstanceCounterpart()
 * @model
 * @generated
 */
public interface InstanceCounterpart extends AbstractIdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Template Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Id</em>' attribute.
	 * @see #setTemplateId(String)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getInstanceCounterpart_TemplateId()
	 * @model required="true"
	 * @generated
	 */
	String getTemplateId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getTemplateId <em>Template Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Id</em>' attribute.
	 * @see #getTemplateId()
	 * @generated
	 */
	void setTemplateId(String value);

	/**
	 * Returns the value of the '<em><b>Multipart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multipart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multipart</em>' attribute.
	 * @see #setMultipart(String)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getInstanceCounterpart_Multipart()
	 * @model required="true"
	 * @generated
	 */
	String getMultipart();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getMultipart <em>Multipart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multipart</em>' attribute.
	 * @see #getMultipart()
	 * @generated
	 */
	void setMultipart(String value);

} // InstanceCounterpart
