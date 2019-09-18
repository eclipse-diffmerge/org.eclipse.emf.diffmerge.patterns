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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Role Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractRoleSpecificationImpl extends
    AbstractIdentifiedElementImpl implements AbstractRoleSpecification {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected AbstractRoleSpecificationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TemplatepatternsPackage.Literals.ABSTRACT_ROLE_SPECIFICATION;
  }

  /**
   * Return the role to which this specification is relative
   * 
   * @return a potentially null role
   * @generated NOT
   */
  public abstract TemplatePatternRole getRole();

} // AbstractRoleSpecificationImpl
