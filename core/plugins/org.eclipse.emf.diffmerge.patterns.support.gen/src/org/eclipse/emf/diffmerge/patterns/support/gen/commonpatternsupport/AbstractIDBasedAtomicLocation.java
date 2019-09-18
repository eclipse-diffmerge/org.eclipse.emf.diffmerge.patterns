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

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractAtomicLocation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract ID Based Atomic Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation#getElementId <em>Element Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getAbstractIDBasedAtomicLocation()
 * @model abstract="true"
 * @generated
 */
public interface AbstractIDBasedAtomicLocation extends AbstractAtomicLocation {
  /**
	 * Returns the value of the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Id</em>' attribute.
	 * @see #setElementId(String)
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getAbstractIDBasedAtomicLocation_ElementId()
	 * @model required="true"
	 * @generated
	 */
  String getElementId();

  /**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation#getElementId <em>Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Id</em>' attribute.
	 * @see #getElementId()
	 * @generated
	 */
  void setElementId(String value);

} // AbstractIDBasedAtomicLocation
