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

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository#getPatterns <em>Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getPatternRepository()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternRepository"
 * @generated
 */
public interface PatternRepository extends AbstractNamedElement, IPatternRepository {
	/**
	 * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Patterns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Patterns</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getPatternRepository_Patterns()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractPattern> getPatterns();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model symbolType="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternSymbol" symbolRequired="true"
	 * @generated
	 */
	AbstractPattern getPattern(IPatternSymbol symbol);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	AbstractPattern getPatternByName(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getPath();

} // PatternRepository
