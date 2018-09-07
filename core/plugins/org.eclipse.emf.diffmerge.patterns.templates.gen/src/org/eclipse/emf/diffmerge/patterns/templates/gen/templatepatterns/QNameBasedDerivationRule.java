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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QName Based Derivation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getQNameBasedDerivationRule()
 * @model
 * @generated
 */
public interface QNameBasedDerivationRule extends AbstractRoleDerivationRule {
	/**
	 * Returns the value of the '<em><b>Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Names</em>' attribute list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getQNameBasedDerivationRule_Names()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getNames();

} // QNameBasedDerivationRule
