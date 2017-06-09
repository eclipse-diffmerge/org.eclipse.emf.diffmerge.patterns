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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Role Relative Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement#getRoleSymbol <em>Role Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractRoleRelativeElement()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRoleRelativeElement extends AbstractIdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Role Symbol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Symbol</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Symbol</em>' containment reference.
	 * @see #setRoleSymbol(PatternRoleSymbol)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractRoleRelativeElement_RoleSymbol()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PatternRoleSymbol getRoleSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement#getRoleSymbol <em>Role Symbol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Symbol</em>' containment reference.
	 * @see #getRoleSymbol()
	 * @generated
	 */
	void setRoleSymbol(PatternRoleSymbol value);

} // AbstractRoleRelativeElement
