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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Id Based Derivation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.IdBasedDerivationRuleImpl#getElementId <em>Element Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdBasedDerivationRuleImpl extends AbstractRoleDerivationRuleImpl implements IdBasedDerivationRule {
  /**
   * The default value of the '{@link #getElementId() <em>Element Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementId()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElementId() <em>Element Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementId()
   * @generated
   * @ordered
   */
  protected String elementId = ELEMENT_ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IdBasedDerivationRuleImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TemplatepatternsPackage.Literals.ID_BASED_DERIVATION_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElementId() {
    return elementId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElementId(String newElementId) {
    String oldElementId = elementId;
    elementId = newElementId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.ID_BASED_DERIVATION_RULE__ELEMENT_ID, oldElementId, elementId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case TemplatepatternsPackage.ID_BASED_DERIVATION_RULE__ELEMENT_ID:
      return getElementId();
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
    case TemplatepatternsPackage.ID_BASED_DERIVATION_RULE__ELEMENT_ID:
      setElementId((String)newValue);
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
    case TemplatepatternsPackage.ID_BASED_DERIVATION_RULE__ELEMENT_ID:
      setElementId(ELEMENT_ID_EDEFAULT);
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
    case TemplatepatternsPackage.ID_BASED_DERIVATION_RULE__ELEMENT_ID:
      return ELEMENT_ID_EDEFAULT == null ? elementId != null : !ELEMENT_ID_EDEFAULT.equals(elementId);
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
    result.append(" (elementId: "); //$NON-NLS-1$
    result.append(elementId);
    result.append(')');
    return result.toString();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleDerivationRuleImpl#deriveCandidateElements(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   * @generated NOT
   */
  @Override
  public EList<EObject> deriveCandidateElements(IPatternApplication context_p) {
    EObject found = CorePatternsPlugin.getDefault().getIdProvider().getByIdInContext(getElementId(), context_p.getScopeElement());
    EList<EObject> result;
    if (found != null) {
      result = new BasicEList<EObject>();
      result.add(found);
      result = ECollections.unmodifiableEList(result);
    } else {
      result = ECollections.emptyEList();
    }
    return result;
  }

} //IdBasedDerivationRuleImpl
