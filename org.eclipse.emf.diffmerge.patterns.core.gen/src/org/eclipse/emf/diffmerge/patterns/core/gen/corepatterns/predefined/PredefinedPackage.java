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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedFactory
 * @model kind="package"
 * @generated
 */
public interface PredefinedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "predefined"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.com/emf/diffmerge/patterns/core/predefined"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.diffmerge.patterns.core.predefined"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PredefinedPackage eINSTANCE = org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement <em>IDescribed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIDescribedElement()
	 * @generated
	 */
	int IDESCRIBED_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>IDescribed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIBED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement <em>IIdentified Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIIdentifiedElement()
	 * @generated
	 */
	int IIDENTIFIED_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>IIdentified Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IIDENTIFIED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.INamedElement <em>INamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getINamedElement()
	 * @generated
	 */
	int INAMED_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>INamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INAMED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPattern <em>IPattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPattern()
	 * @generated
	 */
	int IPATTERN = 3;

	/**
	 * The number of structural features of the '<em>IPattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication <em>IPattern Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternApplication()
	 * @generated
	 */
	int IPATTERN_APPLICATION = 4;

	/**
	 * The number of structural features of the '<em>IPattern Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_APPLICATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection <em>IPattern Based Bijection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternBasedBijection()
	 * @generated
	 */
	int IPATTERN_BASED_BIJECTION = 5;

	/**
	 * The number of structural features of the '<em>IPattern Based Bijection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_BASED_BIJECTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction <em>IPattern Based Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternBasedFunction()
	 * @generated
	 */
	int IPATTERN_BASED_FUNCTION = 6;

	/**
	 * The number of structural features of the '<em>IPattern Based Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_BASED_FUNCTION_FEATURE_COUNT = IPATTERN_BASED_BIJECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus <em>IPattern Conformity Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternConformityStatus()
	 * @generated
	 */
	int IPATTERN_CONFORMITY_STATUS = 7;

	/**
	 * The number of structural features of the '<em>IPattern Conformity Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_CONFORMITY_STATUS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement <em>IVersioned Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIVersionedElement()
	 * @generated
	 */
	int IVERSIONED_ELEMENT = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion <em>IPattern Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternVersion()
	 * @generated
	 */
	int IPATTERN_VERSION = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance <em>IPattern Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternInstance()
	 * @generated
	 */
	int IPATTERN_INSTANCE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository <em>IPattern Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternRepository()
	 * @generated
	 */
	int IPATTERN_REPOSITORY = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternData <em>IPattern Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternData
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternData()
	 * @generated
	 */
	int IPATTERN_DATA = 8;

	/**
	 * The number of structural features of the '<em>IPattern Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_DATA_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>IPattern Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_INSTANCE_FEATURE_COUNT = IPATTERN_APPLICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker <em>IPattern Instance Marker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternInstanceMarker()
	 * @generated
	 */
	int IPATTERN_INSTANCE_MARKER = 10;

	/**
	 * The number of structural features of the '<em>IPattern Instance Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_INSTANCE_MARKER_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>IPattern Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_REPOSITORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole <em>IPattern Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternRole()
	 * @generated
	 */
	int IPATTERN_ROLE = 12;

	/**
	 * The number of structural features of the '<em>IPattern Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_ROLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol <em>IPattern Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternSymbol()
	 * @generated
	 */
	int IPATTERN_SYMBOL = 14;

	/**
	 * The number of structural features of the '<em>IPattern Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_SYMBOL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol <em>IPattern Role Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternRoleSymbol()
	 * @generated
	 */
	int IPATTERN_ROLE_SYMBOL = 13;

	/**
	 * The number of structural features of the '<em>IPattern Role Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_ROLE_SYMBOL_FEATURE_COUNT = IPATTERN_SYMBOL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IPattern Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPATTERN_VERSION_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>IVersioned Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVERSIONED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation <em>ILocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getILocation()
	 * @generated
	 */
	int ILOCATION = 22;

	/**
	 * The number of structural features of the '<em>ILocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILOCATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation <em>IComposite Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getICompositeLocation()
	 * @generated
	 */
	int ICOMPOSITE_LOCATION = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation <em>IAtomic Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIAtomicLocation()
	 * @generated
	 */
	int IATOMIC_LOCATION = 17;

	/**
	 * The number of structural features of the '<em>IAtomic Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IATOMIC_LOCATION_FEATURE_COUNT = ILOCATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation <em>IElement Relative Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIElementRelativeLocation()
	 * @generated
	 */
	int IELEMENT_RELATIVE_LOCATION = 21;

	/**
	 * The number of structural features of the '<em>IElement Relative Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IELEMENT_RELATIVE_LOCATION_FEATURE_COUNT = IATOMIC_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation <em>IElement Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIElementLocation()
	 * @generated
	 */
	int IELEMENT_LOCATION = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation <em>IReference Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIReferenceLocation()
	 * @generated
	 */
	int IREFERENCE_LOCATION = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation <em>IAttribute Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIAttributeLocation()
	 * @generated
	 */
	int IATTRIBUTE_LOCATION = 18;

	/**
	 * The number of structural features of the '<em>IAttribute Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IATTRIBUTE_LOCATION_FEATURE_COUNT = IELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IComposite Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOMPOSITE_LOCATION_FEATURE_COUNT = ILOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IElement Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IELEMENT_LOCATION_FEATURE_COUNT = IELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IReference Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREFERENCE_LOCATION_FEATURE_COUNT = IELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation <em>IResource Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIResourceLocation()
	 * @generated
	 */
	int IRESOURCE_LOCATION = 24;

	/**
	 * The number of structural features of the '<em>IResource Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_LOCATION_FEATURE_COUNT = IATOMIC_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation <em>IElement Mapping Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIElementMappingLocation()
	 * @generated
	 */
	int IELEMENT_MAPPING_LOCATION = 25;

	/**
	 * The number of structural features of the '<em>IElement Mapping Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IELEMENT_MAPPING_LOCATION_FEATURE_COUNT = IATOMIC_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 26;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement <em>IDescribed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDescribed Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement"
	 * @generated
	 */
	EClass getIDescribedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement <em>IIdentified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IIdentified Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement"
	 * @generated
	 */
	EClass getIIdentifiedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.INamedElement <em>INamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>INamed Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.INamedElement"
	 * @generated
	 */
	EClass getINamedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPattern <em>IPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPattern"
	 * @generated
	 */
	EClass getIPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication <em>IPattern Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Application</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication"
	 * @generated
	 */
	EClass getIPatternApplication();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection <em>IPattern Based Bijection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Based Bijection</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection"
	 * @generated
	 */
	EClass getIPatternBasedBijection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction <em>IPattern Based Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Based Function</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternBasedBijection"
	 * @generated
	 */
	EClass getIPatternBasedFunction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus <em>IPattern Conformity Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Conformity Status</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus"
	 * @generated
	 */
	EClass getIPatternConformityStatus();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement <em>IVersioned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IVersioned Element</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement"
	 * @generated
	 */
	EClass getIVersionedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion <em>IPattern Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Version</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion"
	 * @generated
	 */
	EClass getIPatternVersion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance <em>IPattern Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Instance</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternApplication"
	 * @generated
	 */
	EClass getIPatternInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker <em>IPattern Instance Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Instance Marker</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker"
	 * @generated
	 */
	EClass getIPatternInstanceMarker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository <em>IPattern Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Repository</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository"
	 * @generated
	 */
	EClass getIPatternRepository();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternData <em>IPattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Data</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternData
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternData"
	 * @generated
	 */
	EClass getIPatternData();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole <em>IPattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Role</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole"
	 * @generated
	 */
	EClass getIPatternRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol <em>IPattern Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Symbol</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol"
	 * @generated
	 */
	EClass getIPatternSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol <em>IPattern Role Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPattern Role Symbol</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternSymbol"
	 * @generated
	 */
	EClass getIPatternRoleSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation <em>ILocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ILocation</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation"
	 * @generated
	 */
	EClass getILocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation <em>IComposite Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IComposite Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.ILocation"
	 * @generated
	 */
	EClass getICompositeLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation <em>IAtomic Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAtomic Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.ILocation"
	 * @generated
	 */
	EClass getIAtomicLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation <em>IElement Relative Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IElement Relative Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IAtomicLocation"
	 * @generated
	 */
	EClass getIElementRelativeLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation <em>IElement Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IElement Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IElementRelativeLocation"
	 * @generated
	 */
	EClass getIElementLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation <em>IReference Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IReference Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IElementRelativeLocation"
	 * @generated
	 */
	EClass getIReferenceLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation <em>IAttribute Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAttribute Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IElementRelativeLocation"
	 * @generated
	 */
	EClass getIAttributeLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation <em>IResource Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IResource Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IAtomicLocation"
	 * @generated
	 */
	EClass getIResourceLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation <em>IElement Mapping Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IElement Mapping Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation
	 * @model instanceClass="org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IAtomicLocation"
	 * @generated
	 */
	EClass getIElementMappingLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @model instanceClass="org.eclipse.emf.ecore.resource.Resource"
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PredefinedFactory getPredefinedFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement <em>IDescribed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIDescribedElement()
		 * @generated
		 */
		EClass IDESCRIBED_ELEMENT = eINSTANCE.getIDescribedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement <em>IIdentified Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIIdentifiedElement()
		 * @generated
		 */
		EClass IIDENTIFIED_ELEMENT = eINSTANCE.getIIdentifiedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.INamedElement <em>INamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getINamedElement()
		 * @generated
		 */
		EClass INAMED_ELEMENT = eINSTANCE.getINamedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPattern <em>IPattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPattern()
		 * @generated
		 */
		EClass IPATTERN = eINSTANCE.getIPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication <em>IPattern Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternApplication()
		 * @generated
		 */
		EClass IPATTERN_APPLICATION = eINSTANCE.getIPatternApplication();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection <em>IPattern Based Bijection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternBasedBijection()
		 * @generated
		 */
		EClass IPATTERN_BASED_BIJECTION = eINSTANCE.getIPatternBasedBijection();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction <em>IPattern Based Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternBasedFunction()
		 * @generated
		 */
		EClass IPATTERN_BASED_FUNCTION = eINSTANCE.getIPatternBasedFunction();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus <em>IPattern Conformity Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternConformityStatus()
		 * @generated
		 */
		EClass IPATTERN_CONFORMITY_STATUS = eINSTANCE.getIPatternConformityStatus();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement <em>IVersioned Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIVersionedElement()
		 * @generated
		 */
		EClass IVERSIONED_ELEMENT = eINSTANCE.getIVersionedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion <em>IPattern Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternVersion()
		 * @generated
		 */
		EClass IPATTERN_VERSION = eINSTANCE.getIPatternVersion();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance <em>IPattern Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternInstance()
		 * @generated
		 */
		EClass IPATTERN_INSTANCE = eINSTANCE.getIPatternInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker <em>IPattern Instance Marker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternInstanceMarker()
		 * @generated
		 */
		EClass IPATTERN_INSTANCE_MARKER = eINSTANCE.getIPatternInstanceMarker();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository <em>IPattern Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternRepository()
		 * @generated
		 */
		EClass IPATTERN_REPOSITORY = eINSTANCE.getIPatternRepository();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternData <em>IPattern Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternData
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternData()
		 * @generated
		 */
		EClass IPATTERN_DATA = eINSTANCE.getIPatternData();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole <em>IPattern Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternRole()
		 * @generated
		 */
		EClass IPATTERN_ROLE = eINSTANCE.getIPatternRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol <em>IPattern Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternSymbol()
		 * @generated
		 */
		EClass IPATTERN_SYMBOL = eINSTANCE.getIPatternSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol <em>IPattern Role Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIPatternRoleSymbol()
		 * @generated
		 */
		EClass IPATTERN_ROLE_SYMBOL = eINSTANCE.getIPatternRoleSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation <em>ILocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getILocation()
		 * @generated
		 */
		EClass ILOCATION = eINSTANCE.getILocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation <em>IComposite Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getICompositeLocation()
		 * @generated
		 */
		EClass ICOMPOSITE_LOCATION = eINSTANCE.getICompositeLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation <em>IAtomic Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIAtomicLocation()
		 * @generated
		 */
		EClass IATOMIC_LOCATION = eINSTANCE.getIAtomicLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation <em>IElement Relative Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIElementRelativeLocation()
		 * @generated
		 */
		EClass IELEMENT_RELATIVE_LOCATION = eINSTANCE.getIElementRelativeLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation <em>IElement Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIElementLocation()
		 * @generated
		 */
		EClass IELEMENT_LOCATION = eINSTANCE.getIElementLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation <em>IReference Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIReferenceLocation()
		 * @generated
		 */
		EClass IREFERENCE_LOCATION = eINSTANCE.getIReferenceLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation <em>IAttribute Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIAttributeLocation()
		 * @generated
		 */
		EClass IATTRIBUTE_LOCATION = eINSTANCE.getIAttributeLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation <em>IResource Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIResourceLocation()
		 * @generated
		 */
		EClass IRESOURCE_LOCATION = eINSTANCE.getIResourceLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation <em>IElement Mapping Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getIElementMappingLocation()
		 * @generated
		 */
		EClass IELEMENT_MAPPING_LOCATION = eINSTANCE.getIElementMappingLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.resource.Resource
		 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

	}

} //PredefinedPackage
