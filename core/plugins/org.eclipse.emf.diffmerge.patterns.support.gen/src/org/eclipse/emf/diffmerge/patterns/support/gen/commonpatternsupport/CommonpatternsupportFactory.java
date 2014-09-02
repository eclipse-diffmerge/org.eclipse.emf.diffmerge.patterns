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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage
 * @generated
 */
public interface CommonpatternsupportFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  CommonpatternsupportFactory eINSTANCE = org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Common Pattern Instance Set</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Common Pattern Instance Set</em>'.
	 * @generated
	 */
  CommonPatternInstanceSet createCommonPatternInstanceSet();

  /**
	 * Returns a new object of class '<em>Common Pattern Instance</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Common Pattern Instance</em>'.
	 * @generated
	 */
  CommonPatternInstance createCommonPatternInstance();

  /**
	 * Returns a new object of class '<em>Resource Location</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Location</em>'.
	 * @generated
	 */
  ResourceLocation createResourceLocation();

  /**
	 * Returns a new object of class '<em>Element Location</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Location</em>'.
	 * @generated
	 */
  ElementLocation createElementLocation();

  /**
	 * Returns a new object of class '<em>Attribute Location</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Location</em>'.
	 * @generated
	 */
  AttributeLocation createAttributeLocation();

  /**
	 * Returns a new object of class '<em>Reference Location</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Location</em>'.
	 * @generated
	 */
  ReferenceLocation createReferenceLocation();

  /**
	 * Returns a new object of class '<em>Element Mapping Location</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Mapping Location</em>'.
	 * @generated
	 */
  ElementMappingLocation createElementMappingLocation();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  CommonpatternsupportPackage getCommonpatternsupportPackage();

} //CommonpatternsupportFactory
