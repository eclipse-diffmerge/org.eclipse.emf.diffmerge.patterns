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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Pattern Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#isFolded <em>Folded</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getRoleBindings <em>Role Bindings</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternVersion <em>Pattern Version</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternData <em>Pattern Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternInstance()
 * @model abstract="true" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternInstance"
 * @generated
 */
public interface AbstractPatternInstance extends AbstractIdentifiedElement, IPatternInstance {
	/**
	 * Returns the value of the '<em><b>Role Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Bindings</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternInstance_RoleBindings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PatternRoleBinding> getRoleBindings();

	/**
	 * Returns the value of the '<em><b>Pattern Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Version</em>' containment reference.
	 * @see #setPatternVersion(PatternVersion)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternInstance_PatternVersion()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PatternVersion getPatternVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternVersion <em>Pattern Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Version</em>' containment reference.
	 * @see #getPatternVersion()
	 * @generated
	 */
	void setPatternVersion(PatternVersion value);

	/**
	 * Returns the value of the '<em><b>Folded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folded</em>' attribute.
	 * @see #setFolded(boolean)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternInstance_Folded()
	 * @model required="true"
	 * @generated
	 */
	boolean isFolded();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#isFolded <em>Folded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Folded</em>' attribute.
	 * @see #isFolded()
	 * @generated
	 */
	void setFolded(boolean value);

	/**
	 * Returns the value of the '<em><b>Pattern Data</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Data</em>' containment reference.
	 * @see #setPatternData(AbstractPatternData)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPatternInstance_PatternData()
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData#getInstance
	 * @model opposite="instance" containment="true"
	 * @generated
	 */
	AbstractPatternData getPatternData();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternData <em>Pattern Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Data</em>' containment reference.
	 * @see #getPatternData()
	 * @generated
	 */
	void setPatternData(AbstractPatternData value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model roleType="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternRole" roleRequired="true"
	 * @generated
	 */
	void setLocation(IPatternRole role, AbstractLocation location);

} // AbstractPatternInstance
