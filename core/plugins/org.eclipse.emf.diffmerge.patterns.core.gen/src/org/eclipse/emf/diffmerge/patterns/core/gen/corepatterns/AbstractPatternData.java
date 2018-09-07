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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Pattern Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData#getInstance <em>Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternData()
 * @model abstract="true" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternData"
 * @generated
 */
public interface AbstractPatternData extends AbstractIdentifiedElement, IPatternData {

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternData <em>Pattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' container reference.
	 * @see #setInstance(AbstractPatternInstance)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternData_Instance()
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternData
	 * @model opposite="patternData" required="true" transient="false"
	 * @generated
	 */
	AbstractPatternInstance getInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData#getInstance <em>Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' container reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(AbstractPatternInstance value);
} // AbstractPatternData
