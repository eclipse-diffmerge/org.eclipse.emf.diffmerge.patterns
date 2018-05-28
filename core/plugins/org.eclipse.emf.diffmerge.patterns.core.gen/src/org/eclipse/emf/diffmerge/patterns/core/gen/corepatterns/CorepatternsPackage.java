/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsFactory
 * @model kind="package"
 * @generated
 */
public interface CorepatternsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "corepatterns"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.com/emf/diffmerge/patterns/core/1.0.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.diffmerge.patterns.core"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorepatternsPackage eINSTANCE = org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl <em>Abstract Identified Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractIdentifiedElement()
	 * @generated
	 */
	int ABSTRACT_IDENTIFIED_ELEMENT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractNamedElementImpl <em>Abstract Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractNamedElementImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractNamedElement()
	 * @generated
	 */
	int ABSTRACT_NAMED_ELEMENT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl <em>Abstract Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPattern()
	 * @generated
	 */
	int ABSTRACT_PATTERN = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl <em>Abstract Pattern Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternInstance()
	 * @generated
	 */
	int ABSTRACT_PATTERN_INSTANCE = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternRoleImpl <em>Abstract Pattern Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternRoleImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternRole()
	 * @generated
	 */
	int ABSTRACT_PATTERN_ROLE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractRoleRelativeElementImpl <em>Abstract Role Relative Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractRoleRelativeElementImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractRoleRelativeElement()
	 * @generated
	 */
	int ABSTRACT_ROLE_RELATIVE_ELEMENT = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleBindingImpl <em>Pattern Role Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleBindingImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternRoleBinding()
	 * @generated
	 */
	int PATTERN_ROLE_BINDING = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternSymbolImpl <em>Abstract Pattern Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternSymbolImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternSymbol()
	 * @generated
	 */
	int ABSTRACT_PATTERN_SYMBOL = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternSymbolImpl <em>Pattern Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternSymbolImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternSymbol()
	 * @generated
	 */
	int PATTERN_SYMBOL = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleSymbolImpl <em>Pattern Role Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleSymbolImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternRoleSymbol()
	 * @generated
	 */
	int PATTERN_ROLE_SYMBOL = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractVersionedElementImpl <em>Abstract Versioned Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractVersionedElementImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractVersionedElement()
	 * @generated
	 */
	int ABSTRACT_VERSIONED_ELEMENT = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternVersionImpl <em>Pattern Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternVersionImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternVersion()
	 * @generated
	 */
	int PATTERN_VERSION = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractLocationImpl <em>Abstract Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractLocation()
	 * @generated
	 */
	int ABSTRACT_LOCATION = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CompositeLocationImpl <em>Composite Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CompositeLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getCompositeLocation()
	 * @generated
	 */
	int COMPOSITE_LOCATION = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternDataImpl <em>Abstract Pattern Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternDataImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternData()
	 * @generated
	 */
	int ABSTRACT_PATTERN_DATA = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractAtomicLocationImpl <em>Abstract Atomic Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractAtomicLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractAtomicLocation()
	 * @generated
	 */
	int ABSTRACT_ATOMIC_LOCATION = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractDescribedElementImpl <em>Abstract Described Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractDescribedElementImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractDescribedElement()
	 * @generated
	 */
	int ABSTRACT_DESCRIBED_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IDENTIFIED_ELEMENT__ID = PredefinedPackage.IIDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Identified Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT = PredefinedPackage.IIDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCATION__ID = ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The number of structural features of the '<em>Abstract Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_LOCATION_FEATURE_COUNT = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_LOCATION__ID = ABSTRACT_LOCATION__ID;

	/**
	 * The feature id for the '<em><b>Owned Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_LOCATION__OWNED_LOCATIONS = ABSTRACT_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_LOCATION_FEATURE_COUNT = ABSTRACT_LOCATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMED_ELEMENT__ID = ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRepositoryImpl <em>Pattern Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRepositoryImpl
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternRepository()
	 * @generated
	 */
	int PATTERN_REPOSITORY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMED_ELEMENT__NAME = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REPOSITORY__ID = ABSTRACT_NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REPOSITORY__NAME = ABSTRACT_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REPOSITORY__PATTERNS = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_REPOSITORY_FEATURE_COUNT = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_RELATIVE_ELEMENT__ID = ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Role Symbol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Role Relative Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ROLE_RELATIVE_ELEMENT_FEATURE_COUNT = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_BINDING__ID = ABSTRACT_ROLE_RELATIVE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Role Symbol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_BINDING__ROLE_SYMBOL = ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_BINDING__LOCATION = ABSTRACT_ROLE_RELATIVE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Role Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_BINDING_FEATURE_COUNT = ABSTRACT_ROLE_RELATIVE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_SYMBOL__ID = ABSTRACT_NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_SYMBOL__NAME = ABSTRACT_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Repository Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_SYMBOL__PATTERN_ID = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Last Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_SYMBOL__LAST_PATH = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Pattern Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_SYMBOL_FEATURE_COUNT = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_SYMBOL__ID = ABSTRACT_PATTERN_SYMBOL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_SYMBOL__NAME = ABSTRACT_PATTERN_SYMBOL__NAME;

	/**
	 * The feature id for the '<em><b>Repository Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_SYMBOL__REPOSITORY_ID = ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID;

	/**
	 * The feature id for the '<em><b>Pattern Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_SYMBOL__PATTERN_ID = ABSTRACT_PATTERN_SYMBOL__PATTERN_ID;

	/**
	 * The feature id for the '<em><b>Last Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_SYMBOL__LAST_PATH = ABSTRACT_PATTERN_SYMBOL__LAST_PATH;

	/**
	 * The feature id for the '<em><b>Role Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_SYMBOL__ROLE_ID = ABSTRACT_PATTERN_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Role Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ROLE_SYMBOL_FEATURE_COUNT = ABSTRACT_PATTERN_SYMBOL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SYMBOL__ID = ABSTRACT_PATTERN_SYMBOL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SYMBOL__NAME = ABSTRACT_PATTERN_SYMBOL__NAME;

	/**
	 * The feature id for the '<em><b>Repository Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SYMBOL__REPOSITORY_ID = ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID;

	/**
	 * The feature id for the '<em><b>Pattern Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SYMBOL__PATTERN_ID = ABSTRACT_PATTERN_SYMBOL__PATTERN_ID;

	/**
	 * The feature id for the '<em><b>Last Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SYMBOL__LAST_PATH = ABSTRACT_PATTERN_SYMBOL__LAST_PATH;

	/**
	 * The number of structural features of the '<em>Pattern Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_SYMBOL_FEATURE_COUNT = ABSTRACT_PATTERN_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VERSIONED_ELEMENT__ID = ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VERSIONED_ELEMENT__VERSION = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Versioned Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VERSIONED_ELEMENT_FEATURE_COUNT = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VERSION__ID = ABSTRACT_VERSIONED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VERSION__VERSION = ABSTRACT_VERSIONED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Pattern Symbol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VERSION__PATTERN_SYMBOL = ABSTRACT_VERSIONED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VERSION_FEATURE_COUNT = ABSTRACT_VERSIONED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATOMIC_LOCATION__ID = ABSTRACT_LOCATION__ID;

	/**
	 * The number of structural features of the '<em>Abstract Atomic Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATOMIC_LOCATION_FEATURE_COUNT = ABSTRACT_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DESCRIBED_ELEMENT__ID = ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DESCRIBED_ELEMENT__DESCRIPTION = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Described Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DESCRIBED_ELEMENT_FEATURE_COUNT = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__ID = ABSTRACT_NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__NAME = ABSTRACT_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__DESCRIPTION = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__VERSION = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__AUTHORS = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Modification Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Execution Environments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN__TEMPLATE = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Abstract Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_FEATURE_COUNT = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_INSTANCE__ID = ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Folded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_INSTANCE__FOLDED = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pattern Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pattern Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Pattern Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_INSTANCE_FEATURE_COUNT = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_ROLE__ID = ABSTRACT_NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_ROLE__NAME = ABSTRACT_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_ROLE__DESCRIPTION = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Pattern Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_ROLE_FEATURE_COUNT = ABSTRACT_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_DATA__ID = ABSTRACT_IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_DATA__INSTANCE = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Pattern Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PATTERN_DATA_FEATURE_COUNT = ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance <em>Abstract Pattern Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pattern Instance</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance
	 * @generated
	 */
	EClass getAbstractPatternInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getRoleBindings <em>Role Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Role Bindings</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getRoleBindings()
	 * @see #getAbstractPatternInstance()
	 * @generated
	 */
	EReference getAbstractPatternInstance_RoleBindings();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternVersion <em>Pattern Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern Version</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternVersion()
	 * @see #getAbstractPatternInstance()
	 * @generated
	 */
	EReference getAbstractPatternInstance_PatternVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#isFolded <em>Folded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Folded</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#isFolded()
	 * @see #getAbstractPatternInstance()
	 * @generated
	 */
	EAttribute getAbstractPatternInstance_Folded();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternData <em>Pattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern Data</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance#getPatternData()
	 * @see #getAbstractPatternInstance()
	 * @generated
	 */
	EReference getAbstractPatternInstance_PatternData();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole <em>Abstract Pattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pattern Role</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole
	 * @generated
	 */
	EClass getAbstractPatternRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding <em>Pattern Role Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Role Binding</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding
	 * @generated
	 */
	EClass getPatternRoleBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding#getLocation()
	 * @see #getPatternRoleBinding()
	 * @generated
	 */
	EReference getPatternRoleBinding_Location();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol <em>Pattern Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Symbol</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol
	 * @generated
	 */
	EClass getPatternSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol <em>Pattern Role Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Role Symbol</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol
	 * @generated
	 */
	EClass getPatternRoleSymbol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol#getRoleId <em>Role Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role Id</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol#getRoleId()
	 * @see #getPatternRoleSymbol()
	 * @generated
	 */
	EAttribute getPatternRoleSymbol_RoleId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion <em>Pattern Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Version</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion
	 * @generated
	 */
	EClass getPatternVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion#getPatternSymbol <em>Pattern Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern Symbol</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion#getPatternSymbol()
	 * @see #getPatternVersion()
	 * @generated
	 */
	EReference getPatternVersion_PatternSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation <em>Composite Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation
	 * @generated
	 */
	EClass getCompositeLocation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation#getOwnedLocations <em>Owned Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Locations</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation#getOwnedLocations()
	 * @see #getCompositeLocation()
	 * @generated
	 */
	EReference getCompositeLocation_OwnedLocations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository <em>Pattern Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Repository</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository
	 * @generated
	 */
	EClass getPatternRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Patterns</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository#getPatterns()
	 * @see #getPatternRepository()
	 * @generated
	 */
	EReference getPatternRepository_Patterns();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement <em>Abstract Identified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Identified Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement
	 * @generated
	 */
	EClass getAbstractIdentifiedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement#getId()
	 * @see #getAbstractIdentifiedElement()
	 * @generated
	 */
	EAttribute getAbstractIdentifiedElement_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement <em>Abstract Versioned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Versioned Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement
	 * @generated
	 */
	EClass getAbstractVersionedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement#getVersion()
	 * @see #getAbstractVersionedElement()
	 * @generated
	 */
	EAttribute getAbstractVersionedElement_Version();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol <em>Abstract Pattern Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pattern Symbol</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol
	 * @generated
	 */
	EClass getAbstractPatternSymbol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getRepositoryId <em>Repository Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Id</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getRepositoryId()
	 * @see #getAbstractPatternSymbol()
	 * @generated
	 */
	EAttribute getAbstractPatternSymbol_RepositoryId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getPatternId <em>Pattern Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern Id</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getPatternId()
	 * @see #getAbstractPatternSymbol()
	 * @generated
	 */
	EAttribute getAbstractPatternSymbol_PatternId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getLastPath <em>Last Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Path</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol#getLastPath()
	 * @see #getAbstractPatternSymbol()
	 * @generated
	 */
	EAttribute getAbstractPatternSymbol_LastPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement <em>Abstract Role Relative Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Role Relative Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement
	 * @generated
	 */
	EClass getAbstractRoleRelativeElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement#getRoleSymbol <em>Role Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role Symbol</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement#getRoleSymbol()
	 * @see #getAbstractRoleRelativeElement()
	 * @generated
	 */
	EReference getAbstractRoleRelativeElement_RoleSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData <em>Abstract Pattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pattern Data</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData
	 * @generated
	 */
	EClass getAbstractPatternData();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Instance</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData#getInstance()
	 * @see #getAbstractPatternData()
	 * @generated
	 */
	EReference getAbstractPatternData_Instance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation <em>Abstract Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation
	 * @generated
	 */
	EClass getAbstractLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement <em>Abstract Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Named Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement
	 * @generated
	 */
	EClass getAbstractNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement#getName()
	 * @see #getAbstractNamedElement()
	 * @generated
	 */
	EAttribute getAbstractNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern <em>Abstract Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pattern</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern
	 * @generated
	 */
	EClass getAbstractPattern();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Authors</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getAuthors()
	 * @see #getAbstractPattern()
	 * @generated
	 */
	EAttribute getAbstractPattern_Authors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getLastModificationStamp <em>Last Modification Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Modification Stamp</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getLastModificationStamp()
	 * @see #getAbstractPattern()
	 * @generated
	 */
	EAttribute getAbstractPattern_LastModificationStamp();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getExecutionEnvironments <em>Execution Environments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Execution Environments</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getExecutionEnvironments()
	 * @see #getAbstractPattern()
	 * @generated
	 */
	EAttribute getAbstractPattern_ExecutionEnvironments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#isTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#isTemplate()
	 * @see #getAbstractPattern()
	 * @generated
	 */
	EAttribute getAbstractPattern_Template();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractAtomicLocation <em>Abstract Atomic Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Atomic Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractAtomicLocation
	 * @generated
	 */
	EClass getAbstractAtomicLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement <em>Abstract Described Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Described Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement
	 * @generated
	 */
	EClass getAbstractDescribedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement#getDescription()
	 * @see #getAbstractDescribedElement()
	 * @generated
	 */
	EAttribute getAbstractDescribedElement_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CorepatternsFactory getCorepatternsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl <em>Abstract Pattern Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternInstance()
		 * @generated
		 */
		EClass ABSTRACT_PATTERN_INSTANCE = eINSTANCE.getAbstractPatternInstance();

		/**
		 * The meta object literal for the '<em><b>Role Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS = eINSTANCE.getAbstractPatternInstance_RoleBindings();

		/**
		 * The meta object literal for the '<em><b>Pattern Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION = eINSTANCE.getAbstractPatternInstance_PatternVersion();

		/**
		 * The meta object literal for the '<em><b>Folded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN_INSTANCE__FOLDED = eINSTANCE.getAbstractPatternInstance_Folded();

		/**
		 * The meta object literal for the '<em><b>Pattern Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA = eINSTANCE.getAbstractPatternInstance_PatternData();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternRoleImpl <em>Abstract Pattern Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternRoleImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternRole()
		 * @generated
		 */
		EClass ABSTRACT_PATTERN_ROLE = eINSTANCE.getAbstractPatternRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleBindingImpl <em>Pattern Role Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleBindingImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternRoleBinding()
		 * @generated
		 */
		EClass PATTERN_ROLE_BINDING = eINSTANCE.getPatternRoleBinding();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_ROLE_BINDING__LOCATION = eINSTANCE.getPatternRoleBinding_Location();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternSymbolImpl <em>Pattern Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternSymbolImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternSymbol()
		 * @generated
		 */
		EClass PATTERN_SYMBOL = eINSTANCE.getPatternSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleSymbolImpl <em>Pattern Role Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRoleSymbolImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternRoleSymbol()
		 * @generated
		 */
		EClass PATTERN_ROLE_SYMBOL = eINSTANCE.getPatternRoleSymbol();

		/**
		 * The meta object literal for the '<em><b>Role Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_ROLE_SYMBOL__ROLE_ID = eINSTANCE.getPatternRoleSymbol_RoleId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternVersionImpl <em>Pattern Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternVersionImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternVersion()
		 * @generated
		 */
		EClass PATTERN_VERSION = eINSTANCE.getPatternVersion();

		/**
		 * The meta object literal for the '<em><b>Pattern Symbol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_VERSION__PATTERN_SYMBOL = eINSTANCE.getPatternVersion_PatternSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CompositeLocationImpl <em>Composite Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CompositeLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getCompositeLocation()
		 * @generated
		 */
		EClass COMPOSITE_LOCATION = eINSTANCE.getCompositeLocation();

		/**
		 * The meta object literal for the '<em><b>Owned Locations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_LOCATION__OWNED_LOCATIONS = eINSTANCE.getCompositeLocation_OwnedLocations();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRepositoryImpl <em>Pattern Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRepositoryImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getPatternRepository()
		 * @generated
		 */
		EClass PATTERN_REPOSITORY = eINSTANCE.getPatternRepository();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_REPOSITORY__PATTERNS = eINSTANCE.getPatternRepository_Patterns();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl <em>Abstract Identified Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractIdentifiedElement()
		 * @generated
		 */
		EClass ABSTRACT_IDENTIFIED_ELEMENT = eINSTANCE.getAbstractIdentifiedElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_IDENTIFIED_ELEMENT__ID = eINSTANCE.getAbstractIdentifiedElement_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractVersionedElementImpl <em>Abstract Versioned Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractVersionedElementImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractVersionedElement()
		 * @generated
		 */
		EClass ABSTRACT_VERSIONED_ELEMENT = eINSTANCE.getAbstractVersionedElement();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VERSIONED_ELEMENT__VERSION = eINSTANCE.getAbstractVersionedElement_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternSymbolImpl <em>Abstract Pattern Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternSymbolImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternSymbol()
		 * @generated
		 */
		EClass ABSTRACT_PATTERN_SYMBOL = eINSTANCE.getAbstractPatternSymbol();

		/**
		 * The meta object literal for the '<em><b>Repository Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID = eINSTANCE.getAbstractPatternSymbol_RepositoryId();

		/**
		 * The meta object literal for the '<em><b>Pattern Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN_SYMBOL__PATTERN_ID = eINSTANCE.getAbstractPatternSymbol_PatternId();

		/**
		 * The meta object literal for the '<em><b>Last Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN_SYMBOL__LAST_PATH = eINSTANCE.getAbstractPatternSymbol_LastPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractRoleRelativeElementImpl <em>Abstract Role Relative Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractRoleRelativeElementImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractRoleRelativeElement()
		 * @generated
		 */
		EClass ABSTRACT_ROLE_RELATIVE_ELEMENT = eINSTANCE.getAbstractRoleRelativeElement();

		/**
		 * The meta object literal for the '<em><b>Role Symbol</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL = eINSTANCE.getAbstractRoleRelativeElement_RoleSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternDataImpl <em>Abstract Pattern Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternDataImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPatternData()
		 * @generated
		 */
		EClass ABSTRACT_PATTERN_DATA = eINSTANCE.getAbstractPatternData();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PATTERN_DATA__INSTANCE = eINSTANCE.getAbstractPatternData_Instance();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractLocationImpl <em>Abstract Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractLocation()
		 * @generated
		 */
		EClass ABSTRACT_LOCATION = eINSTANCE.getAbstractLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractNamedElementImpl <em>Abstract Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractNamedElementImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractNamedElement()
		 * @generated
		 */
		EClass ABSTRACT_NAMED_ELEMENT = eINSTANCE.getAbstractNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_NAMED_ELEMENT__NAME = eINSTANCE.getAbstractNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl <em>Abstract Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractPattern()
		 * @generated
		 */
		EClass ABSTRACT_PATTERN = eINSTANCE.getAbstractPattern();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN__AUTHORS = eINSTANCE.getAbstractPattern_Authors();

		/**
		 * The meta object literal for the '<em><b>Last Modification Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP = eINSTANCE.getAbstractPattern_LastModificationStamp();

		/**
		 * The meta object literal for the '<em><b>Execution Environments</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS = eINSTANCE.getAbstractPattern_ExecutionEnvironments();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PATTERN__TEMPLATE = eINSTANCE.getAbstractPattern_Template();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractAtomicLocationImpl <em>Abstract Atomic Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractAtomicLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractAtomicLocation()
		 * @generated
		 */
		EClass ABSTRACT_ATOMIC_LOCATION = eINSTANCE.getAbstractAtomicLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractDescribedElementImpl <em>Abstract Described Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractDescribedElementImpl
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl#getAbstractDescribedElement()
		 * @generated
		 */
		EClass ABSTRACT_DESCRIBED_ELEMENT = eINSTANCE.getAbstractDescribedElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_DESCRIBED_ELEMENT__DESCRIPTION = eINSTANCE.getAbstractDescribedElement_Description();

	}

} //CorepatternsPackage
