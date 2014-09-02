/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id Based Derivation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule#getElementId <em>Element Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getIdBasedDerivationRule()
 * @model
 * @generated
 */
public interface IdBasedDerivationRule extends AbstractRoleDerivationRule {
	/**
	 * Returns the value of the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Id</em>' attribute.
	 * @see #setElementId(String)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getIdBasedDerivationRule_ElementId()
	 * @model required="true"
	 * @generated
	 */
	String getElementId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule#getElementId <em>Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Id</em>' attribute.
	 * @see #getElementId()
	 * @generated
	 */
	void setElementId(String value);

} // IdBasedDerivationRule
