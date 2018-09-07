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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Pattern Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getNamingRule <em>Naming Rule</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getInstanceIds <em>Instance Ids</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getTemplateIds <em>Template Ids</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getUnfoldedIds <em>Unfolded Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternData()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternBasedFunction"
 * @generated
 */
public interface TemplatePatternData extends AbstractPatternData, IPatternBasedFunction {

	/**
	 * Returns the value of the '<em><b>Instance Ids</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Ids</em>' map.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternData_InstanceIds()
	 * @model mapType="org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceIdEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart>"
	 * @generated
	 */
	EMap<String, InstanceCounterpart> getInstanceIds();

	/**
	 * Returns the value of the '<em><b>Naming Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Naming Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Naming Rule</em>' attribute.
	 * @see #setNamingRule(String)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternData_NamingRule()
	 * @model
	 * @generated
	 */
	String getNamingRule();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getNamingRule <em>Naming Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Naming Rule</em>' attribute.
	 * @see #getNamingRule()
	 * @generated
	 */
	void setNamingRule(String value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see #setMultiplicity(int)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternData_Multiplicity()
	 * @model required="true"
	 * @generated
	 */
	int getMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Template Ids</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Ids</em>' map.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternData_TemplateIds()
	 * @model mapType="org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateIdEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart>"
	 * @generated
	 */
	EMap<String, TemplateCounterpart> getTemplateIds();

	/**
	 * Returns the value of the '<em><b>Unfolded Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unfolded Ids</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unfolded Ids</em>' attribute list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternData_UnfoldedIds()
	 * @model
	 * @generated
	 */
	EList<String> getUnfoldedIds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clear();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clearUnfolded();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EObject> getInstanceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	EList<String> getMultiparts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model instanceElementRequired="true"
	 * @generated
	 */
	void markAsUnfolded(EObject instanceElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model keepUserNamesRequired="true"
	 * @generated
	 */
	void rename(String newNamingRule, boolean keepUserNames);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" instanceElementRequired="true"
	 * @generated
	 */
	boolean wasUnfolded(EObject instanceElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model elementRequired="true"
	 * @generated
	 */
	String getMultipartOf(EObject element);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model instanceElement_pRequired="true"
	 * @generated
	 */
	EList<TemplatePatternRole> getRolesOf(EObject instanceElement_p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 * @generated
	 */
	boolean isInMultipart(EObject element, String multipart);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" elementRequired="true"
	 * @generated
	 */
	boolean isInOtherMultipart(EObject element, String multipart);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model instanceElementRequired="true" templateElementRequired="true" multipartRequired="true"
	 * @generated
	 */
	void map(EObject instanceElement, EObject templateElement, String multipart);
} // TemplatePatternData
