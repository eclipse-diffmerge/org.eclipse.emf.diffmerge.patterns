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

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QName Based Derivation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.QNameBasedDerivationRuleImpl#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QNameBasedDerivationRuleImpl extends AbstractRoleDerivationRuleImpl implements QNameBasedDerivationRule {
	/**
	 * The cached value of the '{@link #getNames() <em>Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> names;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QNameBasedDerivationRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.QNAME_BASED_DERIVATION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getNames() {
		if (names == null) {
			names = new EDataTypeUniqueEList<String>(String.class, this, TemplatepatternsPackage.QNAME_BASED_DERIVATION_RULE__NAMES);
		}
		return names;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.QNAME_BASED_DERIVATION_RULE__NAMES:
				return getNames();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatepatternsPackage.QNAME_BASED_DERIVATION_RULE__NAMES:
				getNames().clear();
				getNames().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TemplatepatternsPackage.QNAME_BASED_DERIVATION_RULE__NAMES:
				getNames().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TemplatepatternsPackage.QNAME_BASED_DERIVATION_RULE__NAMES:
				return names != null && !names.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (names: "); //$NON-NLS-1$
		result.append(names);
		result.append(')');
		return result.toString();
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleDerivationRuleImpl#deriveCandidateElements(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   */
  @Override
  public EList<EObject> deriveCandidateElements(IPatternApplication context_p) {
    // TODO Implement this using an extension point for handling QNames
    return ECollections.emptyEList();
  }

} //QNameBasedDerivationRuleImpl
