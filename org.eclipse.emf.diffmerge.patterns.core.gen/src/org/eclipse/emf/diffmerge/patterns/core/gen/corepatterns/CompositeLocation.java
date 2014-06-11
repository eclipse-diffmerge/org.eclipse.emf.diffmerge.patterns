/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation#getOwnedLocations <em>Owned Locations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getCompositeLocation()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.ICompositeLocation"
 * @generated
 */
public interface CompositeLocation extends AbstractLocation, ICompositeLocation {
	/**
	 * Returns the value of the '<em><b>Owned Locations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Locations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Locations</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getCompositeLocation_OwnedLocations()
	 * @model type="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IAtomicLocation" containment="true"
	 * @generated
	 */
	EList<IAtomicLocation> getOwnedLocations();

} // CompositeLocation
