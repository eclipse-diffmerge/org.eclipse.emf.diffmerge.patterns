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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Textual Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractTextualQueryImpl#getSpecification
 * <em>Specification</em>}</li>
 * <li>
 * {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractTextualQueryImpl#getLanguage
 * <em>Language</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractTextualQueryImpl extends EObjectImpl implements
    AbstractTextualQuery {
  /**
   * The default value of the '{@link #getSpecification()
   * <em>Specification</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected static final String SPECIFICATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSpecification() <em>Specification</em>}
   * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected String specification = SPECIFICATION_EDEFAULT;

  /**
   * The default value of the '{@link #getLanguage() <em>Language</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLanguage()
   * @generated
   * @ordered
   */
  protected static final String LANGUAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLanguage() <em>Language</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getLanguage()
   * @generated
   * @ordered
   */
  protected String language = LANGUAGE_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected AbstractTextualQueryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TemplatepatternsPackage.Literals.ABSTRACT_TEXTUAL_QUERY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getSpecification() {
    return specification;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setSpecification(String newSpecification) {
    String oldSpecification = specification;
    specification = newSpecification;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__SPECIFICATION,
          oldSpecification, specification));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getLanguage() {
    return language;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setLanguage(String newLanguage) {
    String oldLanguage = language;
    language = newLanguage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__LANGUAGE,
          oldLanguage, language));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__SPECIFICATION:
      return getSpecification();
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__LANGUAGE:
      return getLanguage();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__SPECIFICATION:
      setSpecification((String) newValue);
      return;
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__LANGUAGE:
      setLanguage((String) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__SPECIFICATION:
      setSpecification(SPECIFICATION_EDEFAULT);
      return;
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__LANGUAGE:
      setLanguage(LANGUAGE_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__SPECIFICATION:
      return SPECIFICATION_EDEFAULT == null ? specification != null
          : !SPECIFICATION_EDEFAULT.equals(specification);
    case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY__LANGUAGE:
      return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT
          .equals(language);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (specification: "); //$NON-NLS-1$
    result.append(specification);
    result.append(", language: "); //$NON-NLS-1$
    result.append(language);
    result.append(')');
    return result.toString();
  }

} // AbstractTextualQueryImpl
