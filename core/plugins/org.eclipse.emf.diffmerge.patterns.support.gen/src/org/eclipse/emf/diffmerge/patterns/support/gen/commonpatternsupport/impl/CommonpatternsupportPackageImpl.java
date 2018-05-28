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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ResourceLocation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("nls")
public class CommonpatternsupportPackageImpl extends EPackageImpl implements CommonpatternsupportPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass commonPatternInstanceSetEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass commonPatternInstanceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass resourceLocationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass elementLocationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass attributeLocationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass referenceLocationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass abstractIDBasedAtomicLocationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass abstractElementRelativeLocationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass elementMappingLocationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass elementMappingEntryEClass = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private CommonpatternsupportPackageImpl() {
		super(eNS_URI, CommonpatternsupportFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CommonpatternsupportPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static CommonpatternsupportPackage init() {
		if (isInited) return (CommonpatternsupportPackage)EPackage.Registry.INSTANCE.getEPackage(CommonpatternsupportPackage.eNS_URI);

		// Obtain or create and register package
		CommonpatternsupportPackageImpl theCommonpatternsupportPackage = (CommonpatternsupportPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommonpatternsupportPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommonpatternsupportPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorepatternsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCommonpatternsupportPackage.createPackageContents();

		// Initialize created meta-data
		theCommonpatternsupportPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommonpatternsupportPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommonpatternsupportPackage.eNS_URI, theCommonpatternsupportPackage);
		return theCommonpatternsupportPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCommonPatternInstanceSet() {
		return commonPatternInstanceSetEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getCommonPatternInstanceSet_OwnedInstances() {
		return (EReference)commonPatternInstanceSetEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCommonPatternInstance() {
		return commonPatternInstanceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getResourceLocation() {
		return resourceLocationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getElementLocation() {
		return elementLocationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAttributeLocation() {
		return attributeLocationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getAttributeLocation_Attribute() {
		return (EReference)attributeLocationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getReferenceLocation() {
		return referenceLocationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getReferenceLocation_Reference() {
		return (EReference)referenceLocationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAbstractIDBasedAtomicLocation() {
		return abstractIDBasedAtomicLocationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getAbstractIDBasedAtomicLocation_ElementId() {
		return (EAttribute)abstractIDBasedAtomicLocationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAbstractElementRelativeLocation() {
		return abstractElementRelativeLocationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getElementMappingLocation() {
		return elementMappingLocationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getElementMappingLocation_Mapping() {
		return (EReference)elementMappingLocationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getElementMappingEntry() {
		return elementMappingEntryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getElementMappingEntry_Key() {
		return (EAttribute)elementMappingEntryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getElementMappingEntry_Value() {
		return (EReference)elementMappingEntryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CommonpatternsupportFactory getCommonpatternsupportFactory() {
		return (CommonpatternsupportFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		commonPatternInstanceSetEClass = createEClass(COMMON_PATTERN_INSTANCE_SET);
		createEReference(commonPatternInstanceSetEClass, COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES);

		commonPatternInstanceEClass = createEClass(COMMON_PATTERN_INSTANCE);

		resourceLocationEClass = createEClass(RESOURCE_LOCATION);

		elementLocationEClass = createEClass(ELEMENT_LOCATION);

		attributeLocationEClass = createEClass(ATTRIBUTE_LOCATION);
		createEReference(attributeLocationEClass, ATTRIBUTE_LOCATION__ATTRIBUTE);

		referenceLocationEClass = createEClass(REFERENCE_LOCATION);
		createEReference(referenceLocationEClass, REFERENCE_LOCATION__REFERENCE);

		abstractIDBasedAtomicLocationEClass = createEClass(ABSTRACT_ID_BASED_ATOMIC_LOCATION);
		createEAttribute(abstractIDBasedAtomicLocationEClass, ABSTRACT_ID_BASED_ATOMIC_LOCATION__ELEMENT_ID);

		abstractElementRelativeLocationEClass = createEClass(ABSTRACT_ELEMENT_RELATIVE_LOCATION);

		elementMappingLocationEClass = createEClass(ELEMENT_MAPPING_LOCATION);
		createEReference(elementMappingLocationEClass, ELEMENT_MAPPING_LOCATION__MAPPING);

		elementMappingEntryEClass = createEClass(ELEMENT_MAPPING_ENTRY);
		createEAttribute(elementMappingEntryEClass, ELEMENT_MAPPING_ENTRY__KEY);
		createEReference(elementMappingEntryEClass, ELEMENT_MAPPING_ENTRY__VALUE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorepatternsPackage theCorepatternsPackage = (CorepatternsPackage)EPackage.Registry.INSTANCE.getEPackage(CorepatternsPackage.eNS_URI);
		PredefinedPackage thePredefinedPackage = (PredefinedPackage)EPackage.Registry.INSTANCE.getEPackage(PredefinedPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		commonPatternInstanceSetEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		commonPatternInstanceSetEClass.getESuperTypes().add(thePredefinedPackage.getIPatternInstanceMarker());
		commonPatternInstanceEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractPatternInstance());
		resourceLocationEClass.getESuperTypes().add(this.getAbstractIDBasedAtomicLocation());
		resourceLocationEClass.getESuperTypes().add(thePredefinedPackage.getIResourceLocation());
		elementLocationEClass.getESuperTypes().add(this.getAbstractElementRelativeLocation());
		elementLocationEClass.getESuperTypes().add(thePredefinedPackage.getIElementLocation());
		attributeLocationEClass.getESuperTypes().add(this.getAbstractElementRelativeLocation());
		attributeLocationEClass.getESuperTypes().add(thePredefinedPackage.getIAttributeLocation());
		referenceLocationEClass.getESuperTypes().add(this.getAbstractElementRelativeLocation());
		referenceLocationEClass.getESuperTypes().add(thePredefinedPackage.getIReferenceLocation());
		abstractIDBasedAtomicLocationEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractAtomicLocation());
		abstractElementRelativeLocationEClass.getESuperTypes().add(this.getAbstractIDBasedAtomicLocation());
		abstractElementRelativeLocationEClass.getESuperTypes().add(thePredefinedPackage.getIElementRelativeLocation());
		elementMappingLocationEClass.getESuperTypes().add(this.getAbstractIDBasedAtomicLocation());
		elementMappingLocationEClass.getESuperTypes().add(thePredefinedPackage.getIElementMappingLocation());

		// Initialize classes and features; add operations and parameters
		initEClass(commonPatternInstanceSetEClass, CommonPatternInstanceSet.class, "CommonPatternInstanceSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommonPatternInstanceSet_OwnedInstances(), this.getCommonPatternInstance(), null, "ownedInstances", null, 0, -1, CommonPatternInstanceSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commonPatternInstanceEClass, CommonPatternInstance.class, "CommonPatternInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceLocationEClass, ResourceLocation.class, "ResourceLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementLocationEClass, ElementLocation.class, "ElementLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeLocationEClass, AttributeLocation.class, "AttributeLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeLocation_Attribute(), theEcorePackage.getEAttribute(), null, "attribute", null, 1, 1, AttributeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceLocationEClass, ReferenceLocation.class, "ReferenceLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceLocation_Reference(), theEcorePackage.getEReference(), null, "reference", null, 1, 1, ReferenceLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractIDBasedAtomicLocationEClass, AbstractIDBasedAtomicLocation.class, "AbstractIDBasedAtomicLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractIDBasedAtomicLocation_ElementId(), theEcorePackage.getEString(), "elementId", null, 1, 1, AbstractIDBasedAtomicLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractElementRelativeLocationEClass, AbstractElementRelativeLocation.class, "AbstractElementRelativeLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementMappingLocationEClass, ElementMappingLocation.class, "ElementMappingLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementMappingLocation_Mapping(), this.getElementMappingEntry(), null, "mapping", null, 0, -1, ElementMappingLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementMappingEntryEClass, Map.Entry.class, "ElementMappingEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementMappingEntry_Key(), theEcorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementMappingEntry_Value(), this.getElementLocation(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CommonpatternsupportPackageImpl
