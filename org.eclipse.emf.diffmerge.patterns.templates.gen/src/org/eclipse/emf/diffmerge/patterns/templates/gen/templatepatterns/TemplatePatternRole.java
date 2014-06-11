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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Pattern Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionKind <em>Addition Kind</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#isExclusive <em>Exclusive</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionDerivationRule <em>Addition Derivation Rule</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getMergeDerivationRule <em>Merge Derivation Rule</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPreferredContainment <em>Preferred Containment</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getTemplateElements <em>Template Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole()
 * @model
 * @generated
 */
public interface TemplatePatternRole extends AbstractPatternRole {
	/**
	 * Returns the value of the '<em><b>Addition Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addition Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addition Kind</em>' attribute.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind
	 * @see #setAdditionKind(AdditionKind)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_AdditionKind()
	 * @model required="true"
	 * @generated
	 */
	AdditionKind getAdditionKind();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionKind <em>Addition Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Addition Kind</em>' attribute.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind
	 * @see #getAdditionKind()
	 * @generated
	 */
	void setAdditionKind(AdditionKind value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' container reference.
	 * @see #setPattern(TemplatePattern)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_Pattern()
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getRoles
	 * @model opposite="roles" required="true" transient="false"
	 * @generated
	 */
	TemplatePattern getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPattern <em>Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' container reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(TemplatePattern value);

	/**
	 * Returns the value of the '<em><b>Addition Derivation Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addition Derivation Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addition Derivation Rule</em>' containment reference.
	 * @see #setAdditionDerivationRule(AbstractRoleDerivationRule)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_AdditionDerivationRule()
	 * @model containment="true"
	 * @generated
	 */
	AbstractRoleDerivationRule getAdditionDerivationRule();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionDerivationRule <em>Addition Derivation Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Addition Derivation Rule</em>' containment reference.
	 * @see #getAdditionDerivationRule()
	 * @generated
	 */
	void setAdditionDerivationRule(AbstractRoleDerivationRule value);

	/**
	 * Returns the value of the '<em><b>Merge Derivation Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merge Derivation Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merge Derivation Rule</em>' containment reference.
	 * @see #setMergeDerivationRule(AbstractRoleDerivationRule)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_MergeDerivationRule()
	 * @model containment="true"
	 * @generated
	 */
	AbstractRoleDerivationRule getMergeDerivationRule();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getMergeDerivationRule <em>Merge Derivation Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Merge Derivation Rule</em>' containment reference.
	 * @see #getMergeDerivationRule()
	 * @generated
	 */
	void setMergeDerivationRule(AbstractRoleDerivationRule value);

	/**
	 * Returns the value of the '<em><b>Preferred Containment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferred Containment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Containment</em>' reference.
	 * @see #setPreferredContainment(EReference)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_PreferredContainment()
	 * @model
	 * @generated
	 */
	EReference getPreferredContainment();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPreferredContainment <em>Preferred Containment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Containment</em>' reference.
	 * @see #getPreferredContainment()
	 * @generated
	 */
	void setPreferredContainment(EReference value);

	/**
	 * Returns the value of the '<em><b>Template Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Elements</em>' reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_TemplateElements()
	 * @model
	 * @generated
	 */
	EList<EObject> getTemplateElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean acceptsAddition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean acceptsMerge();

	/**
	 * Returns the value of the '<em><b>Exclusive</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusive</em>' attribute.
	 * @see #setExclusive(boolean)
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_Exclusive()
	 * @model default="" required="true"
	 * @generated
	 */
	boolean isExclusive();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#isExclusive <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclusive</em>' attribute.
	 * @see #isExclusive()
	 * @generated
	 */
	void setExclusive(boolean value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getTemplatePatternRole_Constraints()
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint#getRole
	 * @model opposite="role" containment="true"
	 * @generated
	 */
	EList<AbstractRoleConstraint> getConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isMany();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isUniLocation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" forMergeRequired="true"
	 * @generated
	 */
	boolean isDerivable(boolean forMerge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternConformityStatus" required="true" locationType="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.ILocation"
	 * @generated
	 */
	IPatternConformityStatus checkConstraints(ILocation location);

} // TemplatePatternRole
