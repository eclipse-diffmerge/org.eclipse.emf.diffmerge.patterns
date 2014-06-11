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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Common Pattern Instance Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet#getOwnedInstances <em>Owned Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getCommonPatternInstanceSet()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternInstanceMarker"
 * @generated
 */
public interface CommonPatternInstanceSet extends AbstractIdentifiedElement, IPatternInstanceMarker {
  /**
	 * Returns the value of the '<em><b>Owned Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Instances</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Instances</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#getCommonPatternInstanceSet_OwnedInstances()
	 * @model containment="true"
	 * @generated
	 */
  EList<CommonPatternInstance> getOwnedInstances();

} // CommonPatternInstanceSet
