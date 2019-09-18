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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Role Derivation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractRoleDerivationRuleImpl extends AbstractRoleSpecificationImpl implements AbstractRoleDerivationRule {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractRoleDerivationRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.ABSTRACT_ROLE_DERIVATION_RULE;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule#deriveCandidateElements(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   * @generated NOT
	 */
	public abstract EList<EObject> deriveCandidateElements(IPatternApplication context);

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification#getRole()
   * @generated NOT
   */
	@Override
  public TemplatePatternRole getRole() {
    return (TemplatePatternRole)eContainer();
  }

} //AbstractRoleDerivationRuleImpl
