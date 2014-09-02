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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage
 * @generated
 */
public interface TemplatepatternsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TemplatepatternsFactory eINSTANCE = org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Template Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Pattern</em>'.
	 * @generated
	 */
	TemplatePattern createTemplatePattern();

	/**
	 * Returns a new object of class '<em>Template Pattern Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Pattern Data</em>'.
	 * @generated
	 */
	TemplatePatternData createTemplatePatternData();

	/**
	 * Returns a new object of class '<em>Template Pattern Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Pattern Role</em>'.
	 * @generated
	 */
	TemplatePatternRole createTemplatePatternRole();

	/**
	 * Returns a new object of class '<em>Id Based Derivation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Id Based Derivation Rule</em>'.
	 * @generated
	 */
	IdBasedDerivationRule createIdBasedDerivationRule();

	/**
	 * Returns a new object of class '<em>QName Based Derivation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QName Based Derivation Rule</em>'.
	 * @generated
	 */
	QNameBasedDerivationRule createQNameBasedDerivationRule();

	/**
	 * Returns a new object of class '<em>Textual Role Derivation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Textual Role Derivation Rule</em>'.
	 * @generated
	 */
	TextualRoleDerivationRule createTextualRoleDerivationRule();

	/**
	 * Returns a new object of class '<em>Textual Role Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Textual Role Constraint</em>'.
	 * @generated
	 */
	TextualRoleConstraint createTextualRoleConstraint();

	/**
	 * Returns a new object of class '<em>Instance Counterpart</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Counterpart</em>'.
	 * @generated
	 */
	InstanceCounterpart createInstanceCounterpart();

	/**
	 * Returns a new object of class '<em>Template Counterpart</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Counterpart</em>'.
	 * @generated
	 */
	TemplateCounterpart createTemplateCounterpart();

	/**
	 * Returns a new object of class '<em>Image Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Specification</em>'.
	 * @generated
	 */
	ImageSpecification createImageSpecification();

	/**
	 * Returns a new object of class '<em>Node Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Layout</em>'.
	 * @generated
	 */
	NodeLayout createNodeLayout();

	/**
	 * Returns a new object of class '<em>Edge Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Layout</em>'.
	 * @generated
	 */
	EdgeLayout createEdgeLayout();

	/**
	 * Returns a new object of class '<em>Edge Bendpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Bendpoint</em>'.
	 * @generated
	 */
	EdgeBendpoint createEdgeBendpoint();

	/**
	 * Returns a new object of class '<em>Template Font Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Font Style</em>'.
	 * @generated
	 */
	TemplateFontStyle createTemplateFontStyle();

	/**
	 * Returns a new object of class '<em>Node Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Style</em>'.
	 * @generated
	 */
	NodeStyle createNodeStyle();

	/**
	 * Returns a new object of class '<em>Edge Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge Style</em>'.
	 * @generated
	 */
	EdgeStyle createEdgeStyle();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TemplatepatternsPackage getTemplatepatternsPackage();

} //TemplatepatternsFactory
