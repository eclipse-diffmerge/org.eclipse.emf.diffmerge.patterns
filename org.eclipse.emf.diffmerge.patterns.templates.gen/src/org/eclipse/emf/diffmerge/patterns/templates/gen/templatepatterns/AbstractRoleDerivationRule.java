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

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Role Derivation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getAbstractRoleDerivationRule()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRoleDerivationRule extends AbstractRoleSpecification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model contextType="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternApplication" contextRequired="true"
	 * @generated
	 */
	EList<EObject> deriveCandidateElements(IPatternApplication context);

} // AbstractRoleDerivationRule
