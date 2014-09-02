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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory
 * @model kind="package"
 * @generated
 */
public interface TemplatepatternsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "templatepatterns"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.com/emf/diffmerge/patterns/templates/1.0.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.diffmerge.patterns.templates"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TemplatepatternsPackage eINSTANCE = org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl <em>Template Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplatePattern()
	 * @generated
	 */
	int TEMPLATE_PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__ID = CorepatternsPackage.ABSTRACT_PATTERN__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__NAME = CorepatternsPackage.ABSTRACT_PATTERN__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__DESCRIPTION = CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__VERSION = CorepatternsPackage.ABSTRACT_PATTERN__VERSION;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__AUTHORS = CorepatternsPackage.ABSTRACT_PATTERN__AUTHORS;

	/**
	 * The feature id for the '<em><b>Last Modification Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__LAST_MODIFICATION_STAMP = CorepatternsPackage.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP;

	/**
	 * The feature id for the '<em><b>Execution Environments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__EXECUTION_ENVIRONMENTS = CorepatternsPackage.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__TEMPLATE = CorepatternsPackage.ABSTRACT_PATTERN__TEMPLATE;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__ROLES = CorepatternsPackage.ABSTRACT_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__TEMPLATE_ELEMENTS = CorepatternsPackage.ABSTRACT_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multi Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__MULTI_ELEMENTS = CorepatternsPackage.ABSTRACT_PATTERN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__IMAGE = CorepatternsPackage.ABSTRACT_PATTERN_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Layout Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN__LAYOUT_DATA = CorepatternsPackage.ABSTRACT_PATTERN_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Template Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_PATTERN_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl <em>Template Pattern Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplatePatternData()
	 * @generated
	 */
	int TEMPLATE_PATTERN_DATA = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA__ID = CorepatternsPackage.ABSTRACT_PATTERN_DATA__ID;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA__INSTANCE = CorepatternsPackage.ABSTRACT_PATTERN_DATA__INSTANCE;

	/**
	 * The feature id for the '<em><b>Naming Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA__NAMING_RULE = CorepatternsPackage.ABSTRACT_PATTERN_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA__MULTIPLICITY = CorepatternsPackage.ABSTRACT_PATTERN_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instance Ids</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA__INSTANCE_IDS = CorepatternsPackage.ABSTRACT_PATTERN_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Template Ids</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA__TEMPLATE_IDS = CorepatternsPackage.ABSTRACT_PATTERN_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unfolded Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA__UNFOLDED_IDS = CorepatternsPackage.ABSTRACT_PATTERN_DATA_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Template Pattern Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_DATA_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_PATTERN_DATA_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl <em>Template Pattern Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplatePatternRole()
	 * @generated
	 */
	int TEMPLATE_PATTERN_ROLE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__ID = CorepatternsPackage.ABSTRACT_PATTERN_ROLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__NAME = CorepatternsPackage.ABSTRACT_PATTERN_ROLE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__DESCRIPTION = CorepatternsPackage.ABSTRACT_PATTERN_ROLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Addition Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__ADDITION_KIND = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__CONSTRAINTS = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__EXCLUSIVE = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__PATTERN = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Addition Derivation Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Merge Derivation Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Preferred Containment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Template Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Template Pattern Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PATTERN_ROLE_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_PATTERN_ROLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleSpecificationImpl <em>Abstract Role Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleSpecificationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractRoleSpecification()
	 * @generated
	 */
	int ABSTRACT_ROLE_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_SPECIFICATION__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Abstract Role Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_SPECIFICATION_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleConstraintImpl <em>Abstract Role Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleConstraintImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractRoleConstraint()
	 * @generated
	 */
	int ABSTRACT_ROLE_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_CONSTRAINT__ID = ABSTRACT_ROLE_SPECIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_CONSTRAINT__ROLE = ABSTRACT_ROLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Role Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_CONSTRAINT_FEATURE_COUNT = ABSTRACT_ROLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleDerivationRuleImpl <em>Abstract Role Derivation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleDerivationRuleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractRoleDerivationRule()
	 * @generated
	 */
	int ABSTRACT_ROLE_DERIVATION_RULE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_DERIVATION_RULE__ID = ABSTRACT_ROLE_SPECIFICATION__ID;

	/**
	 * The number of structural features of the '<em>Abstract Role Derivation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_DERIVATION_RULE_FEATURE_COUNT = ABSTRACT_ROLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.IdBasedDerivationRuleImpl <em>Id Based Derivation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.IdBasedDerivationRuleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getIdBasedDerivationRule()
	 * @generated
	 */
	int ID_BASED_DERIVATION_RULE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_BASED_DERIVATION_RULE__ID = ABSTRACT_ROLE_DERIVATION_RULE__ID;

	/**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_BASED_DERIVATION_RULE__ELEMENT_ID = ABSTRACT_ROLE_DERIVATION_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Id Based Derivation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_BASED_DERIVATION_RULE_FEATURE_COUNT = ABSTRACT_ROLE_DERIVATION_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.QNameBasedDerivationRuleImpl <em>QName Based Derivation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.QNameBasedDerivationRuleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getQNameBasedDerivationRule()
	 * @generated
	 */
	int QNAME_BASED_DERIVATION_RULE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNAME_BASED_DERIVATION_RULE__ID = ABSTRACT_ROLE_DERIVATION_RULE__ID;

	/**
	 * The feature id for the '<em><b>Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNAME_BASED_DERIVATION_RULE__NAMES = ABSTRACT_ROLE_DERIVATION_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>QName Based Derivation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QNAME_BASED_DERIVATION_RULE_FEATURE_COUNT = ABSTRACT_ROLE_DERIVATION_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractTextualQueryImpl <em>Abstract Textual Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractTextualQueryImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractTextualQuery()
	 * @generated
	 */
	int ABSTRACT_TEXTUAL_QUERY = 8;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTUAL_QUERY__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTUAL_QUERY__LANGUAGE = 1;

	/**
	 * The number of structural features of the '<em>Abstract Textual Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTUAL_QUERY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleDerivationRuleImpl <em>Textual Role Derivation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleDerivationRuleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTextualRoleDerivationRule()
	 * @generated
	 */
	int TEXTUAL_ROLE_DERIVATION_RULE = 9;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_DERIVATION_RULE__SPECIFICATION = ABSTRACT_TEXTUAL_QUERY__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_DERIVATION_RULE__LANGUAGE = ABSTRACT_TEXTUAL_QUERY__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_DERIVATION_RULE__ID = ABSTRACT_TEXTUAL_QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Textual Role Derivation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_DERIVATION_RULE_FEATURE_COUNT = ABSTRACT_TEXTUAL_QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleConstraintImpl <em>Textual Role Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleConstraintImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTextualRoleConstraint()
	 * @generated
	 */
	int TEXTUAL_ROLE_CONSTRAINT = 10;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_CONSTRAINT__SPECIFICATION = ABSTRACT_TEXTUAL_QUERY__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_CONSTRAINT__LANGUAGE = ABSTRACT_TEXTUAL_QUERY__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_CONSTRAINT__ID = ABSTRACT_TEXTUAL_QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_CONSTRAINT__ROLE = ABSTRACT_TEXTUAL_QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Textual Role Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_ROLE_CONSTRAINT_FEATURE_COUNT = ABSTRACT_TEXTUAL_QUERY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateCounterpartImpl <em>Template Counterpart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateCounterpartImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplateCounterpart()
	 * @generated
	 */
	int TEMPLATE_COUNTERPART = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstancePartImpl <em>Instance Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstancePartImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getInstancePart()
	 * @generated
	 */
	int INSTANCE_PART = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceCounterpartImpl <em>Instance Counterpart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceCounterpartImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getInstanceCounterpart()
	 * @generated
	 */
	int INSTANCE_COUNTERPART = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COUNTERPART__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Template Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COUNTERPART__TEMPLATE_ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multipart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COUNTERPART__MULTIPART = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Counterpart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COUNTERPART_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceIdEntryImpl <em>Instance Id Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceIdEntryImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getInstanceIdEntry()
	 * @generated
	 */
	int INSTANCE_ID_ENTRY = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ID_ENTRY__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ID_ENTRY__KEY = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ID_ENTRY__VALUE = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Id Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_ID_ENTRY_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateIdEntryImpl <em>Template Id Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateIdEntryImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplateIdEntry()
	 * @generated
	 */
	int TEMPLATE_ID_ENTRY = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_ID_ENTRY__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_ID_ENTRY__KEY = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_ID_ENTRY__VALUE = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Template Id Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_ID_ENTRY_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_COUNTERPART__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Instance Parts</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_COUNTERPART__INSTANCE_PARTS = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Counterpart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_COUNTERPART_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PART__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PART__KEY = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PART__VALUE = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PART_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ImageSpecificationImpl <em>Image Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ImageSpecificationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getImageSpecification()
	 * @generated
	 */
	int IMAGE_SPECIFICATION = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SPECIFICATION__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SPECIFICATION__CONTENTS = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SPECIFICATION_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutEntryImpl <em>Layout Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutEntryImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getLayoutEntry()
	 * @generated
	 */
	int LAYOUT_ENTRY = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_ENTRY__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_ENTRY__KEY = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_ENTRY__VALUE = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Layout Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_ENTRY_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutImpl <em>Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getLayout()
	 * @generated
	 */
	int LAYOUT = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ShapeLayoutImpl <em>Shape Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ShapeLayoutImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getShapeLayout()
	 * @generated
	 */
	int SHAPE_LAYOUT = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_LAYOUT__ID = LAYOUT__ID;

	/**
	 * The feature id for the '<em><b>Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_LAYOUT__FONT_STYLE = LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shape Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_LAYOUT_FEATURE_COUNT = LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl <em>Node Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getNodeLayout()
	 * @generated
	 */
	int NODE_LAYOUT = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__ID = SHAPE_LAYOUT__ID;

	/**
	 * The feature id for the '<em><b>Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__FONT_STYLE = SHAPE_LAYOUT__FONT_STYLE;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__X = SHAPE_LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__Y = SHAPE_LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__HEIGHT = SHAPE_LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__WIDTH = SHAPE_LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Contained Font Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__CONTAINED_FONT_STYLES = SHAPE_LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Owned Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__OWNED_STYLE = SHAPE_LAYOUT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Node Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT_FEATURE_COUNT = SHAPE_LAYOUT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl <em>Edge Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getEdgeLayout()
	 * @generated
	 */
	int EDGE_LAYOUT = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__ID = LAYOUT__ID;

	/**
	 * The feature id for the '<em><b>Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__FONT_STYLE = LAYOUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bendpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__BENDPOINTS = LAYOUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Linewidth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__LINEWIDTH = LAYOUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Linecolor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__LINECOLOR = LAYOUT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__OWNED_STYLE = LAYOUT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Begin Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__BEGIN_FONT_STYLE = LAYOUT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>End Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__END_FONT_STYLE = LAYOUT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Center Font Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT__CENTER_FONT_STYLE = LAYOUT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Edge Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_LAYOUT_FEATURE_COUNT = LAYOUT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl <em>Edge Bendpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getEdgeBendpoint()
	 * @generated
	 */
	int EDGE_BENDPOINT = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BENDPOINT__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Source X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BENDPOINT__SOURCE_X = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BENDPOINT__SOURCE_Y = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BENDPOINT__TARGET_X = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BENDPOINT__TARGET_Y = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Edge Bendpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_BENDPOINT_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl <em>Template Font Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplateFontStyle()
	 * @generated
	 */
	int TEMPLATE_FONT_STYLE = 23;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE__COLOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE__HEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE__BOLD = 3;

	/**
	 * The feature id for the '<em><b>Italic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE__ITALIC = 4;

	/**
	 * The feature id for the '<em><b>Underline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE__UNDERLINE = 5;

	/**
	 * The feature id for the '<em><b>Strikethrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE__STRIKETHROUGH = 6;

	/**
	 * The number of structural features of the '<em>Template Font Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FONT_STYLE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.StyleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 24;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl <em>Node Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getNodeStyle()
	 * @generated
	 */
	int NODE_STYLE = 25;

	/**
	 * The feature id for the '<em><b>Bordercolor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_STYLE__BORDERCOLOR = STYLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bordersize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_STYLE__BORDERSIZE = STYLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Shapecolor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_STYLE__SHAPECOLOR = STYLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transparency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_STYLE__TRANSPARENCY = STYLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Backgroundcolor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_STYLE__BACKGROUNDCOLOR = STYLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Foregroundcolor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_STYLE__FOREGROUNDCOLOR = STYLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Node Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_STYLE_FEATURE_COUNT = STYLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl <em>Edge Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getEdgeStyle()
	 * @generated
	 */
	int EDGE_STYLE = 26;

	/**
	 * The feature id for the '<em><b>Linestyle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_STYLE__LINESTYLE = STYLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Routingstyle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_STYLE__ROUTINGSTYLE = STYLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targetarrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_STYLE__TARGETARROW = STYLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sourcearrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_STYLE__SOURCEARROW = STYLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Edge Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_STYLE_FEATURE_COUNT = STYLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind <em>Addition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAdditionKind()
	 * @generated
	 */
	int ADDITION_KIND = 27;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern <em>Template Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Pattern</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern
	 * @generated
	 */
	EClass getTemplatePattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Image</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getImage()
	 * @see #getTemplatePattern()
	 * @generated
	 */
	EReference getTemplatePattern_Image();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getLayoutData <em>Layout Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Layout Data</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getLayoutData()
	 * @see #getTemplatePattern()
	 * @generated
	 */
	EReference getTemplatePattern_LayoutData();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Roles</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getRoles()
	 * @see #getTemplatePattern()
	 * @generated
	 */
	EReference getTemplatePattern_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getTemplateElements <em>Template Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Elements</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getTemplateElements()
	 * @see #getTemplatePattern()
	 * @generated
	 */
	EReference getTemplatePattern_TemplateElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getMultiElements <em>Multi Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multi Elements</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern#getMultiElements()
	 * @see #getTemplatePattern()
	 * @generated
	 */
	EReference getTemplatePattern_MultiElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData <em>Template Pattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Pattern Data</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData
	 * @generated
	 */
	EClass getTemplatePatternData();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getInstanceIds <em>Instance Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Instance Ids</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getInstanceIds()
	 * @see #getTemplatePatternData()
	 * @generated
	 */
	EReference getTemplatePatternData_InstanceIds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getNamingRule <em>Naming Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Naming Rule</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getNamingRule()
	 * @see #getTemplatePatternData()
	 * @generated
	 */
	EAttribute getTemplatePatternData_NamingRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getMultiplicity()
	 * @see #getTemplatePatternData()
	 * @generated
	 */
	EAttribute getTemplatePatternData_Multiplicity();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getTemplateIds <em>Template Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Template Ids</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getTemplateIds()
	 * @see #getTemplatePatternData()
	 * @generated
	 */
	EReference getTemplatePatternData_TemplateIds();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getUnfoldedIds <em>Unfolded Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Unfolded Ids</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getUnfoldedIds()
	 * @see #getTemplatePatternData()
	 * @generated
	 */
	EAttribute getTemplatePatternData_UnfoldedIds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole <em>Template Pattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Pattern Role</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole
	 * @generated
	 */
	EClass getTemplatePatternRole();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionKind <em>Addition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Addition Kind</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionKind()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EAttribute getTemplatePatternRole_AdditionKind();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Pattern</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPattern()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EReference getTemplatePatternRole_Pattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionDerivationRule <em>Addition Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Addition Derivation Rule</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getAdditionDerivationRule()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EReference getTemplatePatternRole_AdditionDerivationRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getMergeDerivationRule <em>Merge Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Merge Derivation Rule</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getMergeDerivationRule()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EReference getTemplatePatternRole_MergeDerivationRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPreferredContainment <em>Preferred Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Preferred Containment</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getPreferredContainment()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EReference getTemplatePatternRole_PreferredContainment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getTemplateElements <em>Template Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Template Elements</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getTemplateElements()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EReference getTemplatePatternRole_TemplateElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification <em>Abstract Role Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Role Specification</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification
	 * @generated
	 */
	EClass getAbstractRoleSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#isExclusive <em>Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exclusive</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#isExclusive()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EAttribute getTemplatePatternRole_Exclusive();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole#getConstraints()
	 * @see #getTemplatePatternRole()
	 * @generated
	 */
	EReference getTemplatePatternRole_Constraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint <em>Abstract Role Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Role Constraint</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint
	 * @generated
	 */
	EClass getAbstractRoleConstraint();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Role</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint#getRole()
	 * @see #getAbstractRoleConstraint()
	 * @generated
	 */
	EReference getAbstractRoleConstraint_Role();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule <em>Abstract Role Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Role Derivation Rule</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule
	 * @generated
	 */
	EClass getAbstractRoleDerivationRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule <em>Id Based Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id Based Derivation Rule</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule
	 * @generated
	 */
	EClass getIdBasedDerivationRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule#getElementId <em>Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Id</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule#getElementId()
	 * @see #getIdBasedDerivationRule()
	 * @generated
	 */
	EAttribute getIdBasedDerivationRule_ElementId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule <em>QName Based Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QName Based Derivation Rule</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule
	 * @generated
	 */
	EClass getQNameBasedDerivationRule();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule#getNames <em>Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Names</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule#getNames()
	 * @see #getQNameBasedDerivationRule()
	 * @generated
	 */
	EAttribute getQNameBasedDerivationRule_Names();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery <em>Abstract Textual Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Textual Query</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery
	 * @generated
	 */
	EClass getAbstractTextualQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery#getSpecification()
	 * @see #getAbstractTextualQuery()
	 * @generated
	 */
	EAttribute getAbstractTextualQuery_Specification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery#getLanguage()
	 * @see #getAbstractTextualQuery()
	 * @generated
	 */
	EAttribute getAbstractTextualQuery_Language();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule <em>Textual Role Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Textual Role Derivation Rule</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule
	 * @generated
	 */
	EClass getTextualRoleDerivationRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint <em>Textual Role Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Textual Role Constraint</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint
	 * @generated
	 */
	EClass getTextualRoleConstraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart <em>Template Counterpart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Counterpart</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart
	 * @generated
	 */
	EClass getTemplateCounterpart();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart#getInstanceParts <em>Instance Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Instance Parts</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart#getInstanceParts()
	 * @see #getTemplateCounterpart()
	 * @generated
	 */
	EReference getTemplateCounterpart_InstanceParts();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Instance Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Part</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true"
	 * @generated
	 */
	EClass getInstancePart();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getInstancePart()
	 * @generated
	 */
	EAttribute getInstancePart_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getInstancePart()
	 * @generated
	 */
	EAttribute getInstancePart_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification <em>Image Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Specification</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification
	 * @generated
	 */
	EClass getImageSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contents</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification#getContents()
	 * @see #getImageSpecification()
	 * @generated
	 */
	EAttribute getImageSpecification_Contents();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Layout Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.eclipse.emf.ecore.EObject" keyRequired="true"
	 *        valueType="org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getLayoutEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getLayoutEntry()
	 * @generated
	 */
	EReference getLayoutEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getLayoutEntry()
	 * @generated
	 */
	EReference getLayoutEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout
	 * @generated
	 */
	EClass getLayout();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout <em>Node Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Layout</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout
	 * @generated
	 */
	EClass getNodeLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getX()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EAttribute getNodeLayout_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getY()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EAttribute getNodeLayout_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getHeight()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EAttribute getNodeLayout_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getWidth()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EAttribute getNodeLayout_Width();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getContainedFontStyles <em>Contained Font Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Font Styles</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getContainedFontStyles()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EReference getNodeLayout_ContainedFontStyles();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getOwnedStyle <em>Owned Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout#getOwnedStyle()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EReference getNodeLayout_OwnedStyle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout <em>Edge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Layout</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout
	 * @generated
	 */
	EClass getEdgeLayout();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getBendpoints <em>Bendpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bendpoints</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getBendpoints()
	 * @see #getEdgeLayout()
	 * @generated
	 */
	EReference getEdgeLayout_Bendpoints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinewidth <em>Linewidth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linewidth</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinewidth()
	 * @see #getEdgeLayout()
	 * @generated
	 */
	EAttribute getEdgeLayout_Linewidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinecolor <em>Linecolor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linecolor</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getLinecolor()
	 * @see #getEdgeLayout()
	 * @generated
	 */
	EAttribute getEdgeLayout_Linecolor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getOwnedStyle <em>Owned Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getOwnedStyle()
	 * @see #getEdgeLayout()
	 * @generated
	 */
	EReference getEdgeLayout_OwnedStyle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getBeginFontStyle <em>Begin Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Begin Font Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getBeginFontStyle()
	 * @see #getEdgeLayout()
	 * @generated
	 */
	EReference getEdgeLayout_BeginFontStyle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getEndFontStyle <em>End Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Font Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getEndFontStyle()
	 * @see #getEdgeLayout()
	 * @generated
	 */
	EReference getEdgeLayout_EndFontStyle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getCenterFontStyle <em>Center Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Center Font Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout#getCenterFontStyle()
	 * @see #getEdgeLayout()
	 * @generated
	 */
	EReference getEdgeLayout_CenterFontStyle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint <em>Edge Bendpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Bendpoint</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint
	 * @generated
	 */
	EClass getEdgeBendpoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getSourceX <em>Source X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source X</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getSourceX()
	 * @see #getEdgeBendpoint()
	 * @generated
	 */
	EAttribute getEdgeBendpoint_SourceX();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getSourceY <em>Source Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Y</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getSourceY()
	 * @see #getEdgeBendpoint()
	 * @generated
	 */
	EAttribute getEdgeBendpoint_SourceY();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getTargetX <em>Target X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target X</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getTargetX()
	 * @see #getEdgeBendpoint()
	 * @generated
	 */
	EAttribute getEdgeBendpoint_TargetX();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getTargetY <em>Target Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Y</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint#getTargetY()
	 * @see #getEdgeBendpoint()
	 * @generated
	 */
	EAttribute getEdgeBendpoint_TargetY();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout <em>Shape Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shape Layout</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout
	 * @generated
	 */
	EClass getShapeLayout();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout#getFontStyle <em>Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Font Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout#getFontStyle()
	 * @see #getShapeLayout()
	 * @generated
	 */
	EReference getShapeLayout_FontStyle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle <em>Template Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Font Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle
	 * @generated
	 */
	EClass getTemplateFontStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#getColor()
	 * @see #getTemplateFontStyle()
	 * @generated
	 */
	EAttribute getTemplateFontStyle_Color();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#getName()
	 * @see #getTemplateFontStyle()
	 * @generated
	 */
	EAttribute getTemplateFontStyle_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#getHeight()
	 * @see #getTemplateFontStyle()
	 * @generated
	 */
	EAttribute getTemplateFontStyle_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isBold <em>Bold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bold</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isBold()
	 * @see #getTemplateFontStyle()
	 * @generated
	 */
	EAttribute getTemplateFontStyle_Bold();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isItalic <em>Italic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Italic</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isItalic()
	 * @see #getTemplateFontStyle()
	 * @generated
	 */
	EAttribute getTemplateFontStyle_Italic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isUnderline <em>Underline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Underline</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isUnderline()
	 * @see #getTemplateFontStyle()
	 * @generated
	 */
	EAttribute getTemplateFontStyle_Underline();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isStrikethrough <em>Strikethrough</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strikethrough</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle#isStrikethrough()
	 * @see #getTemplateFontStyle()
	 * @generated
	 */
	EAttribute getTemplateFontStyle_Strikethrough();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle <em>Node Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle
	 * @generated
	 */
	EClass getNodeStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getBordercolor <em>Bordercolor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bordercolor</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getBordercolor()
	 * @see #getNodeStyle()
	 * @generated
	 */
	EAttribute getNodeStyle_Bordercolor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getBordersize <em>Bordersize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bordersize</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getBordersize()
	 * @see #getNodeStyle()
	 * @generated
	 */
	EAttribute getNodeStyle_Bordersize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getShapecolor <em>Shapecolor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shapecolor</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getShapecolor()
	 * @see #getNodeStyle()
	 * @generated
	 */
	EAttribute getNodeStyle_Shapecolor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getTransparency <em>Transparency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transparency</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getTransparency()
	 * @see #getNodeStyle()
	 * @generated
	 */
	EAttribute getNodeStyle_Transparency();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getBackgroundcolor <em>Backgroundcolor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backgroundcolor</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getBackgroundcolor()
	 * @see #getNodeStyle()
	 * @generated
	 */
	EAttribute getNodeStyle_Backgroundcolor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getForegroundcolor <em>Foregroundcolor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Foregroundcolor</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle#getForegroundcolor()
	 * @see #getNodeStyle()
	 * @generated
	 */
	EAttribute getNodeStyle_Foregroundcolor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle <em>Edge Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Style</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle
	 * @generated
	 */
	EClass getEdgeStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getLinestyle <em>Linestyle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linestyle</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getLinestyle()
	 * @see #getEdgeStyle()
	 * @generated
	 */
	EAttribute getEdgeStyle_Linestyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getRoutingstyle <em>Routingstyle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Routingstyle</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getRoutingstyle()
	 * @see #getEdgeStyle()
	 * @generated
	 */
	EAttribute getEdgeStyle_Routingstyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getTargetarrow <em>Targetarrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Targetarrow</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getTargetarrow()
	 * @see #getEdgeStyle()
	 * @generated
	 */
	EAttribute getEdgeStyle_Targetarrow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getSourcearrow <em>Sourcearrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sourcearrow</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle#getSourcearrow()
	 * @see #getEdgeStyle()
	 * @generated
	 */
	EAttribute getEdgeStyle_Sourcearrow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart <em>Instance Counterpart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Counterpart</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart
	 * @generated
	 */
	EClass getInstanceCounterpart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getTemplateId <em>Template Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template Id</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getTemplateId()
	 * @see #getInstanceCounterpart()
	 * @generated
	 */
	EAttribute getInstanceCounterpart_TemplateId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getMultipart <em>Multipart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multipart</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart#getMultipart()
	 * @see #getInstanceCounterpart()
	 * @generated
	 */
	EAttribute getInstanceCounterpart_Multipart();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Instance Id Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Id Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getInstanceIdEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getInstanceIdEntry()
	 * @generated
	 */
	EAttribute getInstanceIdEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getInstanceIdEntry()
	 * @generated
	 */
	EReference getInstanceIdEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Template Id Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Id Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart" valueContainment="true" valueRequired="true"
	 * @generated
	 */
	EClass getTemplateIdEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getTemplateIdEntry()
	 * @generated
	 */
	EAttribute getTemplateIdEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getTemplateIdEntry()
	 * @generated
	 */
	EReference getTemplateIdEntry_Value();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind <em>Addition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Addition Kind</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind
	 * @generated
	 */
	EEnum getAdditionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TemplatepatternsFactory getTemplatepatternsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl <em>Template Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplatePattern()
		 * @generated
		 */
		EClass TEMPLATE_PATTERN = eINSTANCE.getTemplatePattern();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN__IMAGE = eINSTANCE.getTemplatePattern_Image();

		/**
		 * The meta object literal for the '<em><b>Layout Data</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN__LAYOUT_DATA = eINSTANCE.getTemplatePattern_LayoutData();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN__ROLES = eINSTANCE.getTemplatePattern_Roles();

		/**
		 * The meta object literal for the '<em><b>Template Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN__TEMPLATE_ELEMENTS = eINSTANCE.getTemplatePattern_TemplateElements();

		/**
		 * The meta object literal for the '<em><b>Multi Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN__MULTI_ELEMENTS = eINSTANCE.getTemplatePattern_MultiElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl <em>Template Pattern Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplatePatternData()
		 * @generated
		 */
		EClass TEMPLATE_PATTERN_DATA = eINSTANCE.getTemplatePatternData();

		/**
		 * The meta object literal for the '<em><b>Instance Ids</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_DATA__INSTANCE_IDS = eINSTANCE.getTemplatePatternData_InstanceIds();

		/**
		 * The meta object literal for the '<em><b>Naming Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PATTERN_DATA__NAMING_RULE = eINSTANCE.getTemplatePatternData_NamingRule();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PATTERN_DATA__MULTIPLICITY = eINSTANCE.getTemplatePatternData_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Template Ids</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_DATA__TEMPLATE_IDS = eINSTANCE.getTemplatePatternData_TemplateIds();

		/**
		 * The meta object literal for the '<em><b>Unfolded Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PATTERN_DATA__UNFOLDED_IDS = eINSTANCE.getTemplatePatternData_UnfoldedIds();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl <em>Template Pattern Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplatePatternRole()
		 * @generated
		 */
		EClass TEMPLATE_PATTERN_ROLE = eINSTANCE.getTemplatePatternRole();

		/**
		 * The meta object literal for the '<em><b>Addition Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PATTERN_ROLE__ADDITION_KIND = eINSTANCE.getTemplatePatternRole_AdditionKind();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_ROLE__PATTERN = eINSTANCE.getTemplatePatternRole_Pattern();

		/**
		 * The meta object literal for the '<em><b>Addition Derivation Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE = eINSTANCE.getTemplatePatternRole_AdditionDerivationRule();

		/**
		 * The meta object literal for the '<em><b>Merge Derivation Rule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE = eINSTANCE.getTemplatePatternRole_MergeDerivationRule();

		/**
		 * The meta object literal for the '<em><b>Preferred Containment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT = eINSTANCE.getTemplatePatternRole_PreferredContainment();

		/**
		 * The meta object literal for the '<em><b>Template Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS = eINSTANCE.getTemplatePatternRole_TemplateElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleSpecificationImpl <em>Abstract Role Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleSpecificationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractRoleSpecification()
		 * @generated
		 */
		EClass ABSTRACT_ROLE_SPECIFICATION = eINSTANCE.getAbstractRoleSpecification();

		/**
		 * The meta object literal for the '<em><b>Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_PATTERN_ROLE__EXCLUSIVE = eINSTANCE.getTemplatePatternRole_Exclusive();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_PATTERN_ROLE__CONSTRAINTS = eINSTANCE.getTemplatePatternRole_Constraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleConstraintImpl <em>Abstract Role Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleConstraintImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractRoleConstraint()
		 * @generated
		 */
		EClass ABSTRACT_ROLE_CONSTRAINT = eINSTANCE.getAbstractRoleConstraint();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ROLE_CONSTRAINT__ROLE = eINSTANCE.getAbstractRoleConstraint_Role();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleDerivationRuleImpl <em>Abstract Role Derivation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractRoleDerivationRuleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractRoleDerivationRule()
		 * @generated
		 */
		EClass ABSTRACT_ROLE_DERIVATION_RULE = eINSTANCE.getAbstractRoleDerivationRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.IdBasedDerivationRuleImpl <em>Id Based Derivation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.IdBasedDerivationRuleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getIdBasedDerivationRule()
		 * @generated
		 */
		EClass ID_BASED_DERIVATION_RULE = eINSTANCE.getIdBasedDerivationRule();

		/**
		 * The meta object literal for the '<em><b>Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_BASED_DERIVATION_RULE__ELEMENT_ID = eINSTANCE.getIdBasedDerivationRule_ElementId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.QNameBasedDerivationRuleImpl <em>QName Based Derivation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.QNameBasedDerivationRuleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getQNameBasedDerivationRule()
		 * @generated
		 */
		EClass QNAME_BASED_DERIVATION_RULE = eINSTANCE.getQNameBasedDerivationRule();

		/**
		 * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QNAME_BASED_DERIVATION_RULE__NAMES = eINSTANCE.getQNameBasedDerivationRule_Names();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractTextualQueryImpl <em>Abstract Textual Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.AbstractTextualQueryImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAbstractTextualQuery()
		 * @generated
		 */
		EClass ABSTRACT_TEXTUAL_QUERY = eINSTANCE.getAbstractTextualQuery();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TEXTUAL_QUERY__SPECIFICATION = eINSTANCE.getAbstractTextualQuery_Specification();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TEXTUAL_QUERY__LANGUAGE = eINSTANCE.getAbstractTextualQuery_Language();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleDerivationRuleImpl <em>Textual Role Derivation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleDerivationRuleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTextualRoleDerivationRule()
		 * @generated
		 */
		EClass TEXTUAL_ROLE_DERIVATION_RULE = eINSTANCE.getTextualRoleDerivationRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleConstraintImpl <em>Textual Role Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleConstraintImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTextualRoleConstraint()
		 * @generated
		 */
		EClass TEXTUAL_ROLE_CONSTRAINT = eINSTANCE.getTextualRoleConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateCounterpartImpl <em>Template Counterpart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateCounterpartImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplateCounterpart()
		 * @generated
		 */
		EClass TEMPLATE_COUNTERPART = eINSTANCE.getTemplateCounterpart();

		/**
		 * The meta object literal for the '<em><b>Instance Parts</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_COUNTERPART__INSTANCE_PARTS = eINSTANCE.getTemplateCounterpart_InstanceParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstancePartImpl <em>Instance Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstancePartImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getInstancePart()
		 * @generated
		 */
		EClass INSTANCE_PART = eINSTANCE.getInstancePart();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_PART__KEY = eINSTANCE.getInstancePart_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_PART__VALUE = eINSTANCE.getInstancePart_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ImageSpecificationImpl <em>Image Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ImageSpecificationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getImageSpecification()
		 * @generated
		 */
		EClass IMAGE_SPECIFICATION = eINSTANCE.getImageSpecification();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_SPECIFICATION__CONTENTS = eINSTANCE.getImageSpecification_Contents();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutEntryImpl <em>Layout Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutEntryImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getLayoutEntry()
		 * @generated
		 */
		EClass LAYOUT_ENTRY = eINSTANCE.getLayoutEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_ENTRY__KEY = eINSTANCE.getLayoutEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_ENTRY__VALUE = eINSTANCE.getLayoutEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutImpl <em>Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.LayoutImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getLayout()
		 * @generated
		 */
		EClass LAYOUT = eINSTANCE.getLayout();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl <em>Node Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeLayoutImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getNodeLayout()
		 * @generated
		 */
		EClass NODE_LAYOUT = eINSTANCE.getNodeLayout();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LAYOUT__X = eINSTANCE.getNodeLayout_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LAYOUT__Y = eINSTANCE.getNodeLayout_Y();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LAYOUT__HEIGHT = eINSTANCE.getNodeLayout_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LAYOUT__WIDTH = eINSTANCE.getNodeLayout_Width();

		/**
		 * The meta object literal for the '<em><b>Contained Font Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_LAYOUT__CONTAINED_FONT_STYLES = eINSTANCE.getNodeLayout_ContainedFontStyles();

		/**
		 * The meta object literal for the '<em><b>Owned Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_LAYOUT__OWNED_STYLE = eINSTANCE.getNodeLayout_OwnedStyle();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl <em>Edge Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeLayoutImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getEdgeLayout()
		 * @generated
		 */
		EClass EDGE_LAYOUT = eINSTANCE.getEdgeLayout();

		/**
		 * The meta object literal for the '<em><b>Bendpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_LAYOUT__BENDPOINTS = eINSTANCE.getEdgeLayout_Bendpoints();

		/**
		 * The meta object literal for the '<em><b>Linewidth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_LAYOUT__LINEWIDTH = eINSTANCE.getEdgeLayout_Linewidth();

		/**
		 * The meta object literal for the '<em><b>Linecolor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_LAYOUT__LINECOLOR = eINSTANCE.getEdgeLayout_Linecolor();

		/**
		 * The meta object literal for the '<em><b>Owned Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_LAYOUT__OWNED_STYLE = eINSTANCE.getEdgeLayout_OwnedStyle();

		/**
		 * The meta object literal for the '<em><b>Begin Font Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_LAYOUT__BEGIN_FONT_STYLE = eINSTANCE.getEdgeLayout_BeginFontStyle();

		/**
		 * The meta object literal for the '<em><b>End Font Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_LAYOUT__END_FONT_STYLE = eINSTANCE.getEdgeLayout_EndFontStyle();

		/**
		 * The meta object literal for the '<em><b>Center Font Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_LAYOUT__CENTER_FONT_STYLE = eINSTANCE.getEdgeLayout_CenterFontStyle();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl <em>Edge Bendpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeBendpointImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getEdgeBendpoint()
		 * @generated
		 */
		EClass EDGE_BENDPOINT = eINSTANCE.getEdgeBendpoint();

		/**
		 * The meta object literal for the '<em><b>Source X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_BENDPOINT__SOURCE_X = eINSTANCE.getEdgeBendpoint_SourceX();

		/**
		 * The meta object literal for the '<em><b>Source Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_BENDPOINT__SOURCE_Y = eINSTANCE.getEdgeBendpoint_SourceY();

		/**
		 * The meta object literal for the '<em><b>Target X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_BENDPOINT__TARGET_X = eINSTANCE.getEdgeBendpoint_TargetX();

		/**
		 * The meta object literal for the '<em><b>Target Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_BENDPOINT__TARGET_Y = eINSTANCE.getEdgeBendpoint_TargetY();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ShapeLayoutImpl <em>Shape Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.ShapeLayoutImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getShapeLayout()
		 * @generated
		 */
		EClass SHAPE_LAYOUT = eINSTANCE.getShapeLayout();

		/**
		 * The meta object literal for the '<em><b>Font Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHAPE_LAYOUT__FONT_STYLE = eINSTANCE.getShapeLayout_FontStyle();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl <em>Template Font Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateFontStyleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplateFontStyle()
		 * @generated
		 */
		EClass TEMPLATE_FONT_STYLE = eINSTANCE.getTemplateFontStyle();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_FONT_STYLE__COLOR = eINSTANCE.getTemplateFontStyle_Color();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_FONT_STYLE__NAME = eINSTANCE.getTemplateFontStyle_Name();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_FONT_STYLE__HEIGHT = eINSTANCE.getTemplateFontStyle_Height();

		/**
		 * The meta object literal for the '<em><b>Bold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_FONT_STYLE__BOLD = eINSTANCE.getTemplateFontStyle_Bold();

		/**
		 * The meta object literal for the '<em><b>Italic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_FONT_STYLE__ITALIC = eINSTANCE.getTemplateFontStyle_Italic();

		/**
		 * The meta object literal for the '<em><b>Underline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_FONT_STYLE__UNDERLINE = eINSTANCE.getTemplateFontStyle_Underline();

		/**
		 * The meta object literal for the '<em><b>Strikethrough</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_FONT_STYLE__STRIKETHROUGH = eINSTANCE.getTemplateFontStyle_Strikethrough();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.StyleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl <em>Node Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.NodeStyleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getNodeStyle()
		 * @generated
		 */
		EClass NODE_STYLE = eINSTANCE.getNodeStyle();

		/**
		 * The meta object literal for the '<em><b>Bordercolor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_STYLE__BORDERCOLOR = eINSTANCE.getNodeStyle_Bordercolor();

		/**
		 * The meta object literal for the '<em><b>Bordersize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_STYLE__BORDERSIZE = eINSTANCE.getNodeStyle_Bordersize();

		/**
		 * The meta object literal for the '<em><b>Shapecolor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_STYLE__SHAPECOLOR = eINSTANCE.getNodeStyle_Shapecolor();

		/**
		 * The meta object literal for the '<em><b>Transparency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_STYLE__TRANSPARENCY = eINSTANCE.getNodeStyle_Transparency();

		/**
		 * The meta object literal for the '<em><b>Backgroundcolor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_STYLE__BACKGROUNDCOLOR = eINSTANCE.getNodeStyle_Backgroundcolor();

		/**
		 * The meta object literal for the '<em><b>Foregroundcolor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_STYLE__FOREGROUNDCOLOR = eINSTANCE.getNodeStyle_Foregroundcolor();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl <em>Edge Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.EdgeStyleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getEdgeStyle()
		 * @generated
		 */
		EClass EDGE_STYLE = eINSTANCE.getEdgeStyle();

		/**
		 * The meta object literal for the '<em><b>Linestyle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_STYLE__LINESTYLE = eINSTANCE.getEdgeStyle_Linestyle();

		/**
		 * The meta object literal for the '<em><b>Routingstyle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_STYLE__ROUTINGSTYLE = eINSTANCE.getEdgeStyle_Routingstyle();

		/**
		 * The meta object literal for the '<em><b>Targetarrow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_STYLE__TARGETARROW = eINSTANCE.getEdgeStyle_Targetarrow();

		/**
		 * The meta object literal for the '<em><b>Sourcearrow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE_STYLE__SOURCEARROW = eINSTANCE.getEdgeStyle_Sourcearrow();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceCounterpartImpl <em>Instance Counterpart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceCounterpartImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getInstanceCounterpart()
		 * @generated
		 */
		EClass INSTANCE_COUNTERPART = eINSTANCE.getInstanceCounterpart();

		/**
		 * The meta object literal for the '<em><b>Template Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_COUNTERPART__TEMPLATE_ID = eINSTANCE.getInstanceCounterpart_TemplateId();

		/**
		 * The meta object literal for the '<em><b>Multipart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_COUNTERPART__MULTIPART = eINSTANCE.getInstanceCounterpart_Multipart();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceIdEntryImpl <em>Instance Id Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.InstanceIdEntryImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getInstanceIdEntry()
		 * @generated
		 */
		EClass INSTANCE_ID_ENTRY = eINSTANCE.getInstanceIdEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_ID_ENTRY__KEY = eINSTANCE.getInstanceIdEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_ID_ENTRY__VALUE = eINSTANCE.getInstanceIdEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateIdEntryImpl <em>Template Id Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplateIdEntryImpl
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getTemplateIdEntry()
		 * @generated
		 */
		EClass TEMPLATE_ID_ENTRY = eINSTANCE.getTemplateIdEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_ID_ENTRY__KEY = eINSTANCE.getTemplateIdEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_ID_ENTRY__VALUE = eINSTANCE.getTemplateIdEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind <em>Addition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind
		 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatepatternsPackageImpl#getAdditionKind()
		 * @generated
		 */
		EEnum ADDITION_KIND = eINSTANCE.getAdditionKind();

	}

} //TemplatepatternsPackage
