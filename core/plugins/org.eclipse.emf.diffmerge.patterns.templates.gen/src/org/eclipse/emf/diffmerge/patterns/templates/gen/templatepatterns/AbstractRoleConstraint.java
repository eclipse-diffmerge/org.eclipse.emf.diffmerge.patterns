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

import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Role Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getAbstractRoleConstraint()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRoleConstraint extends AbstractRoleSpecification {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' container reference.
	 * @see #setRole(TemplatePatternRole)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getAbstractRoleConstraint_Role()
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	TemplatePatternRole getRole();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint#getRole <em>Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' container reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(TemplatePatternRole value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternConformityStatus" required="true" locationType="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.ILocation"
	 * @generated
	 */
	IPatternConformityStatus check(ILocation location);

} // AbstractRoleConstraint
