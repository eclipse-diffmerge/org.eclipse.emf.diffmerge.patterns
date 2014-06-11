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

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Pattern Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getRepositoryId <em>Repository Id</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getPatternId <em>Pattern Id</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getLastPath <em>Last Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternSymbol()
 * @model abstract="true" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternSymbol"
 * @generated
 */
public interface AbstractPatternSymbol extends AbstractNamedElement, IPatternSymbol {
	/**
	 * Returns the value of the '<em><b>Repository Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Id</em>' attribute.
	 * @see #setRepositoryId(String)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternSymbol_RepositoryId()
	 * @model required="true"
	 * @generated
	 */
	String getRepositoryId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getRepositoryId <em>Repository Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Id</em>' attribute.
	 * @see #getRepositoryId()
	 * @generated
	 */
	void setRepositoryId(String value);

	/**
	 * Returns the value of the '<em><b>Pattern Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Id</em>' attribute.
	 * @see #setPatternId(String)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternSymbol_PatternId()
	 * @model required="true"
	 * @generated
	 */
	String getPatternId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getPatternId <em>Pattern Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Id</em>' attribute.
	 * @see #getPatternId()
	 * @generated
	 */
	void setPatternId(String value);

	/**
	 * Returns the value of the '<em><b>Last Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Path</em>' attribute.
	 * @see #setLastPath(String)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternSymbol_LastPath()
	 * @model
	 * @generated
	 */
	String getLastPath();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getLastPath <em>Last Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Path</em>' attribute.
	 * @see #getLastPath()
	 * @generated
	 */
	void setLastPath(String value);

} // AbstractPatternSymbol
