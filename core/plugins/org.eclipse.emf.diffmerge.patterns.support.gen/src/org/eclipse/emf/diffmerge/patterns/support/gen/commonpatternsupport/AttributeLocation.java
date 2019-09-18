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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getAttributeLocation()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractElementRelativeLocation org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IAttributeLocation"
 * @generated
 */
public interface AttributeLocation extends AbstractElementRelativeLocation, IAttributeLocation {
  /**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getAttributeLocation_Attribute()
	 * @model required="true"
	 * @generated
	 */
  EAttribute getAttribute();

  /**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
  void setAttribute(EAttribute value);

} // AttributeLocation
