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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Role Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol#getRoleId <em>Role Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getPatternRoleSymbol()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternRoleSymbol"
 * @generated
 */
public interface PatternRoleSymbol extends AbstractPatternSymbol, IPatternRoleSymbol {
	/**
	 * Returns the value of the '<em><b>Role Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Id</em>' attribute.
	 * @see #setRoleId(String)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getPatternRoleSymbol_RoleId()
	 * @model required="true"
	 * @generated
	 */
	String getRoleId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol#getRoleId <em>Role Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Id</em>' attribute.
	 * @see #getRoleId()
	 * @generated
	 */
	void setRoleId(String value);

} // PatternRoleSymbol
