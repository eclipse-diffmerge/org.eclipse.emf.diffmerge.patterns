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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getLastModificationStamp <em>Last Modification Stamp</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getExecutionEnvironments <em>Execution Environments</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#isTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPattern()
 * @model abstract="true" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPattern"
 * @generated
 */
public interface AbstractPattern extends AbstractNamedElement, AbstractDescribedElement, AbstractVersionedElement, IPattern {
	/**
	 * Returns the value of the '<em><b>Authors</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' attribute list.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPattern_Authors()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getAuthors();

	/**
	 * Returns the value of the '<em><b>Last Modification Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Modification Stamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modification Stamp</em>' attribute.
	 * @see #setLastModificationStamp(String)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPattern_LastModificationStamp()
	 * @model required="true"
	 * @generated
	 */
	String getLastModificationStamp();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getLastModificationStamp <em>Last Modification Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modification Stamp</em>' attribute.
	 * @see #getLastModificationStamp()
	 * @generated
	 */
	void setLastModificationStamp(String value);

	/**
	 * Returns the value of the '<em><b>Execution Environments</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Metamodel UR Is</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Environments</em>' attribute list.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPattern_ExecutionEnvironments()
	 * @model
	 * @generated
	 */
	EList<String> getExecutionEnvironments();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' attribute.
	 * @see #setTemplate(boolean)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractPattern_Template()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#isTemplate <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' attribute.
	 * @see #isTemplate()
	 * @generated
	 */
	void setTemplate(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model symbolType="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternRoleSymbol" symbolRequired="true"
	 * @generated
	 */
	AbstractPatternRole getRole(IPatternRoleSymbol symbol);

} // AbstractPattern
