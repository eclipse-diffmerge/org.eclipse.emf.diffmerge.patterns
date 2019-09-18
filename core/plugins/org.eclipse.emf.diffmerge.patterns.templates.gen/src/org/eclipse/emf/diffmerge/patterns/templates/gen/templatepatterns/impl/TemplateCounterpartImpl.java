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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Counterpart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateCounterpartImpl#getInstanceParts <em>Instance Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateCounterpartImpl extends AbstractIdentifiedElementImpl implements TemplateCounterpart {
	/**
	 * The cached value of the '{@link #getInstanceParts() <em>Instance Parts</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceParts()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> instanceParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateCounterpartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.TEMPLATE_COUNTERPART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getInstanceParts() {
		if (instanceParts == null) {
			instanceParts = new EcoreEMap<String,String>(TemplatepatternsPackage.Literals.INSTANCE_PART, InstancePartImpl.class, this, TemplatepatternsPackage.TEMPLATE_COUNTERPART__INSTANCE_PARTS);
		}
		return instanceParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_COUNTERPART__INSTANCE_PARTS:
				return ((InternalEList<?>)getInstanceParts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_COUNTERPART__INSTANCE_PARTS:
				if (coreType) return getInstanceParts();
				else return getInstanceParts().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_COUNTERPART__INSTANCE_PARTS:
				((EStructuralFeature.Setting)getInstanceParts()).set(newValue);
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
			case TemplatepatternsPackage.TEMPLATE_COUNTERPART__INSTANCE_PARTS:
				getInstanceParts().clear();
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
			case TemplatepatternsPackage.TEMPLATE_COUNTERPART__INSTANCE_PARTS:
				return instanceParts != null && !instanceParts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TemplateCounterpartImpl
