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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory
 * @model kind="package"
 * @generated
 */
public interface CommonpatternsupportPackage extends EPackage {
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "commonpatternsupport"; //$NON-NLS-1$

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://org.eclipse.emf.patterns/support/1.0.0"; //$NON-NLS-1$

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "org.eclipse.emf.diffmerge.patterns.support"; //$NON-NLS-1$

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  CommonpatternsupportPackage eINSTANCE = org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceSetImpl <em>Common Pattern Instance Set</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceSetImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getCommonPatternInstanceSet()
	 * @generated
	 */
  int COMMON_PATTERN_INSTANCE_SET = 0;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE_SET__ID = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;

  /**
	 * The feature id for the '<em><b>Owned Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Common Pattern Instance Set</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE_SET_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceImpl <em>Common Pattern Instance</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getCommonPatternInstance()
	 * @generated
	 */
  int COMMON_PATTERN_INSTANCE = 1;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE__ID = CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ID;

  /**
	 * The feature id for the '<em><b>Folded</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE__FOLDED = CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__FOLDED;

  /**
	 * The feature id for the '<em><b>Role Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE__ROLE_BINDINGS = CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS;

  /**
	 * The feature id for the '<em><b>Pattern Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE__PATTERN_VERSION = CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION;

  /**
	 * The feature id for the '<em><b>Pattern Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE__PATTERN_DATA = CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA;

  /**
	 * The number of structural features of the '<em>Common Pattern Instance</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COMMON_PATTERN_INSTANCE_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractIDBasedAtomicLocationImpl <em>Abstract ID Based Atomic Location</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractIDBasedAtomicLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getAbstractIDBasedAtomicLocation()
	 * @generated
	 */
  int ABSTRACT_ID_BASED_ATOMIC_LOCATION = 6;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_ID_BASED_ATOMIC_LOCATION__ID = CorepatternsPackage.ABSTRACT_ATOMIC_LOCATION__ID;

  /**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_ID_BASED_ATOMIC_LOCATION__ELEMENT_ID = CorepatternsPackage.ABSTRACT_ATOMIC_LOCATION_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Abstract ID Based Atomic Location</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_ID_BASED_ATOMIC_LOCATION_FEATURE_COUNT = CorepatternsPackage.ABSTRACT_ATOMIC_LOCATION_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ResourceLocationImpl <em>Resource Location</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ResourceLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getResourceLocation()
	 * @generated
	 */
  int RESOURCE_LOCATION = 2;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESOURCE_LOCATION__ID = ABSTRACT_ID_BASED_ATOMIC_LOCATION__ID;

  /**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESOURCE_LOCATION__ELEMENT_ID = ABSTRACT_ID_BASED_ATOMIC_LOCATION__ELEMENT_ID;

  /**
	 * The number of structural features of the '<em>Resource Location</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESOURCE_LOCATION_FEATURE_COUNT = ABSTRACT_ID_BASED_ATOMIC_LOCATION_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractElementRelativeLocationImpl <em>Abstract Element Relative Location</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractElementRelativeLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getAbstractElementRelativeLocation()
	 * @generated
	 */
  int ABSTRACT_ELEMENT_RELATIVE_LOCATION = 7;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_ELEMENT_RELATIVE_LOCATION__ID = ABSTRACT_ID_BASED_ATOMIC_LOCATION__ID;

  /**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_ELEMENT_RELATIVE_LOCATION__ELEMENT_ID = ABSTRACT_ID_BASED_ATOMIC_LOCATION__ELEMENT_ID;

  /**
	 * The number of structural features of the '<em>Abstract Element Relative Location</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_ELEMENT_RELATIVE_LOCATION_FEATURE_COUNT = ABSTRACT_ID_BASED_ATOMIC_LOCATION_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementLocationImpl <em>Element Location</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getElementLocation()
	 * @generated
	 */
  int ELEMENT_LOCATION = 3;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_LOCATION__ID = ABSTRACT_ELEMENT_RELATIVE_LOCATION__ID;

  /**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_LOCATION__ELEMENT_ID = ABSTRACT_ELEMENT_RELATIVE_LOCATION__ELEMENT_ID;

  /**
	 * The number of structural features of the '<em>Element Location</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_LOCATION_FEATURE_COUNT = ABSTRACT_ELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 0;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AttributeLocationImpl <em>Attribute Location</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AttributeLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getAttributeLocation()
	 * @generated
	 */
  int ATTRIBUTE_LOCATION = 4;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ATTRIBUTE_LOCATION__ID = ABSTRACT_ELEMENT_RELATIVE_LOCATION__ID;

  /**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ATTRIBUTE_LOCATION__ELEMENT_ID = ABSTRACT_ELEMENT_RELATIVE_LOCATION__ELEMENT_ID;

  /**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ATTRIBUTE_LOCATION__ATTRIBUTE = ABSTRACT_ELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Attribute Location</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ATTRIBUTE_LOCATION_FEATURE_COUNT = ABSTRACT_ELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ReferenceLocationImpl <em>Reference Location</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ReferenceLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getReferenceLocation()
	 * @generated
	 */
  int REFERENCE_LOCATION = 5;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_LOCATION__ID = ABSTRACT_ELEMENT_RELATIVE_LOCATION__ID;

  /**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_LOCATION__ELEMENT_ID = ABSTRACT_ELEMENT_RELATIVE_LOCATION__ELEMENT_ID;

  /**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_LOCATION__REFERENCE = ABSTRACT_ELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Reference Location</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_LOCATION_FEATURE_COUNT = ABSTRACT_ELEMENT_RELATIVE_LOCATION_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingLocationImpl <em>Element Mapping Location</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingLocationImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getElementMappingLocation()
	 * @generated
	 */
  int ELEMENT_MAPPING_LOCATION = 8;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_MAPPING_LOCATION__ID = ABSTRACT_ID_BASED_ATOMIC_LOCATION__ID;

  /**
	 * The feature id for the '<em><b>Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_MAPPING_LOCATION__ELEMENT_ID = ABSTRACT_ID_BASED_ATOMIC_LOCATION__ELEMENT_ID;

  /**
	 * The feature id for the '<em><b>Mapping</b></em>' map.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_MAPPING_LOCATION__MAPPING = ABSTRACT_ID_BASED_ATOMIC_LOCATION_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>Element Mapping Location</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_MAPPING_LOCATION_FEATURE_COUNT = ABSTRACT_ID_BASED_ATOMIC_LOCATION_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingEntryImpl <em>Element Mapping Entry</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingEntryImpl
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getElementMappingEntry()
	 * @generated
	 */
  int ELEMENT_MAPPING_ENTRY = 9;

  /**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_MAPPING_ENTRY__KEY = 0;

  /**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_MAPPING_ENTRY__VALUE = 1;

  /**
	 * The number of structural features of the '<em>Element Mapping Entry</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ELEMENT_MAPPING_ENTRY_FEATURE_COUNT = 2;

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet <em>Common Pattern Instance Set</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Pattern Instance Set</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet
	 * @generated
	 */
  EClass getCommonPatternInstanceSet();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet#getOwnedInstances <em>Owned Instances</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Instances</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet#getOwnedInstances()
	 * @see #getCommonPatternInstanceSet()
	 * @generated
	 */
  EReference getCommonPatternInstanceSet_OwnedInstances();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance <em>Common Pattern Instance</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Pattern Instance</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance
	 * @generated
	 */
  EClass getCommonPatternInstance();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ResourceLocation <em>Resource Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ResourceLocation
	 * @generated
	 */
  EClass getResourceLocation();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation <em>Element Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation
	 * @generated
	 */
  EClass getElementLocation();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation <em>Attribute Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation
	 * @generated
	 */
  EClass getAttributeLocation();

  /**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation#getAttribute()
	 * @see #getAttributeLocation()
	 * @generated
	 */
  EReference getAttributeLocation_Attribute();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation <em>Reference Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation
	 * @generated
	 */
  EClass getReferenceLocation();

  /**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation#getReference()
	 * @see #getReferenceLocation()
	 * @generated
	 */
  EReference getReferenceLocation_Reference();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation <em>Abstract ID Based Atomic Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract ID Based Atomic Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation
	 * @generated
	 */
  EClass getAbstractIDBasedAtomicLocation();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation#getElementId <em>Element Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Id</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation#getElementId()
	 * @see #getAbstractIDBasedAtomicLocation()
	 * @generated
	 */
  EAttribute getAbstractIDBasedAtomicLocation_ElementId();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractElementRelativeLocation <em>Abstract Element Relative Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Element Relative Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractElementRelativeLocation
	 * @generated
	 */
  EClass getAbstractElementRelativeLocation();

  /**
	 * Returns the meta object for class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation <em>Element Mapping Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Mapping Location</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation
	 * @generated
	 */
  EClass getElementMappingLocation();

  /**
	 * Returns the meta object for the map '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Mapping</em>'.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation#getMapping()
	 * @see #getElementMappingLocation()
	 * @generated
	 */
  EReference getElementMappingLocation_Mapping();

  /**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Element Mapping Entry</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Mapping Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation" valueContainment="true" valueRequired="true"
	 * @generated
	 */
  EClass getElementMappingEntry();

  /**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getElementMappingEntry()
	 * @generated
	 */
  EAttribute getElementMappingEntry_Key();

  /**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getElementMappingEntry()
	 * @generated
	 */
  EReference getElementMappingEntry_Value();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  CommonpatternsupportFactory getCommonpatternsupportFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals {
    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceSetImpl <em>Common Pattern Instance Set</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceSetImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getCommonPatternInstanceSet()
		 * @generated
		 */
    EClass COMMON_PATTERN_INSTANCE_SET = eINSTANCE.getCommonPatternInstanceSet();

    /**
		 * The meta object literal for the '<em><b>Owned Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES = eINSTANCE.getCommonPatternInstanceSet_OwnedInstances();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceImpl <em>Common Pattern Instance</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getCommonPatternInstance()
		 * @generated
		 */
    EClass COMMON_PATTERN_INSTANCE = eINSTANCE.getCommonPatternInstance();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ResourceLocationImpl <em>Resource Location</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ResourceLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getResourceLocation()
		 * @generated
		 */
    EClass RESOURCE_LOCATION = eINSTANCE.getResourceLocation();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementLocationImpl <em>Element Location</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getElementLocation()
		 * @generated
		 */
    EClass ELEMENT_LOCATION = eINSTANCE.getElementLocation();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AttributeLocationImpl <em>Attribute Location</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AttributeLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getAttributeLocation()
		 * @generated
		 */
    EClass ATTRIBUTE_LOCATION = eINSTANCE.getAttributeLocation();

    /**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ATTRIBUTE_LOCATION__ATTRIBUTE = eINSTANCE.getAttributeLocation_Attribute();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ReferenceLocationImpl <em>Reference Location</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ReferenceLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getReferenceLocation()
		 * @generated
		 */
    EClass REFERENCE_LOCATION = eINSTANCE.getReferenceLocation();

    /**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference REFERENCE_LOCATION__REFERENCE = eINSTANCE.getReferenceLocation_Reference();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractIDBasedAtomicLocationImpl <em>Abstract ID Based Atomic Location</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractIDBasedAtomicLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getAbstractIDBasedAtomicLocation()
		 * @generated
		 */
    EClass ABSTRACT_ID_BASED_ATOMIC_LOCATION = eINSTANCE.getAbstractIDBasedAtomicLocation();

    /**
		 * The meta object literal for the '<em><b>Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ABSTRACT_ID_BASED_ATOMIC_LOCATION__ELEMENT_ID = eINSTANCE.getAbstractIDBasedAtomicLocation_ElementId();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractElementRelativeLocationImpl <em>Abstract Element Relative Location</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractElementRelativeLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getAbstractElementRelativeLocation()
		 * @generated
		 */
    EClass ABSTRACT_ELEMENT_RELATIVE_LOCATION = eINSTANCE.getAbstractElementRelativeLocation();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingLocationImpl <em>Element Mapping Location</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingLocationImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getElementMappingLocation()
		 * @generated
		 */
    EClass ELEMENT_MAPPING_LOCATION = eINSTANCE.getElementMappingLocation();

    /**
		 * The meta object literal for the '<em><b>Mapping</b></em>' map feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ELEMENT_MAPPING_LOCATION__MAPPING = eINSTANCE.getElementMappingLocation_Mapping();

    /**
		 * The meta object literal for the '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingEntryImpl <em>Element Mapping Entry</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingEntryImpl
		 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonpatternsupportPackageImpl#getElementMappingEntry()
		 * @generated
		 */
    EClass ELEMENT_MAPPING_ENTRY = eINSTANCE.getElementMappingEntry();

    /**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ELEMENT_MAPPING_ENTRY__KEY = eINSTANCE.getElementMappingEntry_Key();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference ELEMENT_MAPPING_ENTRY__VALUE = eINSTANCE.getElementMappingEntry_Value();

  }

} //CommonpatternsupportPackage
