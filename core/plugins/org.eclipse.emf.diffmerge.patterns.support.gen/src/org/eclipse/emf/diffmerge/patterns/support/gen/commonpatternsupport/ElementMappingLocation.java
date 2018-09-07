/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Mapping Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getElementMappingLocation()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IElementMappingLocation"
 * @generated
 */
public interface ElementMappingLocation extends AbstractIDBasedAtomicLocation, IElementMappingLocation {
  /**
	 * Returns the value of the '<em><b>Mapping</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation},
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mapping</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' map.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getElementMappingLocation_Mapping()
	 * @model mapType="org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation>"
	 * @generated
	 */
  EMap<String, ElementLocation> getMapping();

} // ElementMappingLocation
