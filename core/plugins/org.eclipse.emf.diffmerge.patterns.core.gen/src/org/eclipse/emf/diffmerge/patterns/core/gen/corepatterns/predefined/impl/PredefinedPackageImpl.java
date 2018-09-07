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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CorepatternsPackageImpl;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedFactory;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PredefinedPackageImpl extends EPackageImpl implements PredefinedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDescribedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iIdentifiedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternBasedBijectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternBasedFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternConformityStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iVersionedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternInstanceMarkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPatternRoleSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iCompositeLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAtomicLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iElementRelativeLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iElementLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iReferenceLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAttributeLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iResourceLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iElementMappingLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

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
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PredefinedPackageImpl() {
		super(eNS_URI, PredefinedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PredefinedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PredefinedPackage init() {
		if (isInited) return (PredefinedPackage)EPackage.Registry.INSTANCE.getEPackage(PredefinedPackage.eNS_URI);

		// Obtain or create and register package
		PredefinedPackageImpl thePredefinedPackage = (PredefinedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PredefinedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PredefinedPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorepatternsPackageImpl theCorepatternsPackage = (CorepatternsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorepatternsPackage.eNS_URI) instanceof CorepatternsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorepatternsPackage.eNS_URI) : CorepatternsPackage.eINSTANCE);

		// Create package meta-data objects
		thePredefinedPackage.createPackageContents();
		theCorepatternsPackage.createPackageContents();

		// Initialize created meta-data
		thePredefinedPackage.initializePackageContents();
		theCorepatternsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePredefinedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PredefinedPackage.eNS_URI, thePredefinedPackage);
		return thePredefinedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDescribedElement() {
		return iDescribedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIIdentifiedElement() {
		return iIdentifiedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINamedElement() {
		return iNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPattern() {
		return iPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternApplication() {
		return iPatternApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternBasedBijection() {
		return iPatternBasedBijectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternBasedFunction() {
		return iPatternBasedFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternConformityStatus() {
		return iPatternConformityStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIVersionedElement() {
		return iVersionedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternVersion() {
		return iPatternVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternInstance() {
		return iPatternInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternInstanceMarker() {
		return iPatternInstanceMarkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternRepository() {
		return iPatternRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternData() {
		return iPatternDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternRole() {
		return iPatternRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternSymbol() {
		return iPatternSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIPatternRoleSymbol() {
		return iPatternRoleSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILocation() {
		return iLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getICompositeLocation() {
		return iCompositeLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAtomicLocation() {
		return iAtomicLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIElementRelativeLocation() {
		return iElementRelativeLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIElementLocation() {
		return iElementLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIReferenceLocation() {
		return iReferenceLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAttributeLocation() {
		return iAttributeLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIResourceLocation() {
		return iResourceLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIElementMappingLocation() {
		return iElementMappingLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedFactory getPredefinedFactory() {
		return (PredefinedFactory)getEFactoryInstance();
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
		iDescribedElementEClass = createEClass(IDESCRIBED_ELEMENT);

		iIdentifiedElementEClass = createEClass(IIDENTIFIED_ELEMENT);

		iNamedElementEClass = createEClass(INAMED_ELEMENT);

		iPatternEClass = createEClass(IPATTERN);

		iPatternApplicationEClass = createEClass(IPATTERN_APPLICATION);

		iPatternBasedBijectionEClass = createEClass(IPATTERN_BASED_BIJECTION);

		iPatternBasedFunctionEClass = createEClass(IPATTERN_BASED_FUNCTION);

		iPatternConformityStatusEClass = createEClass(IPATTERN_CONFORMITY_STATUS);

		iPatternDataEClass = createEClass(IPATTERN_DATA);

		iPatternInstanceEClass = createEClass(IPATTERN_INSTANCE);

		iPatternInstanceMarkerEClass = createEClass(IPATTERN_INSTANCE_MARKER);

		iPatternRepositoryEClass = createEClass(IPATTERN_REPOSITORY);

		iPatternRoleEClass = createEClass(IPATTERN_ROLE);

		iPatternRoleSymbolEClass = createEClass(IPATTERN_ROLE_SYMBOL);

		iPatternSymbolEClass = createEClass(IPATTERN_SYMBOL);

		iPatternVersionEClass = createEClass(IPATTERN_VERSION);

		iVersionedElementEClass = createEClass(IVERSIONED_ELEMENT);

		iAtomicLocationEClass = createEClass(IATOMIC_LOCATION);

		iAttributeLocationEClass = createEClass(IATTRIBUTE_LOCATION);

		iCompositeLocationEClass = createEClass(ICOMPOSITE_LOCATION);

		iElementLocationEClass = createEClass(IELEMENT_LOCATION);

		iElementRelativeLocationEClass = createEClass(IELEMENT_RELATIVE_LOCATION);

		iLocationEClass = createEClass(ILOCATION);

		iReferenceLocationEClass = createEClass(IREFERENCE_LOCATION);

		iResourceLocationEClass = createEClass(IRESOURCE_LOCATION);

		iElementMappingLocationEClass = createEClass(IELEMENT_MAPPING_LOCATION);

		resourceEClass = createEClass(RESOURCE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iPatternBasedFunctionEClass.getESuperTypes().add(this.getIPatternBasedBijection());
		iPatternInstanceEClass.getESuperTypes().add(this.getIPatternApplication());
		iPatternRoleSymbolEClass.getESuperTypes().add(this.getIPatternSymbol());
		iAtomicLocationEClass.getESuperTypes().add(this.getILocation());
		iAttributeLocationEClass.getESuperTypes().add(this.getIElementRelativeLocation());
		iCompositeLocationEClass.getESuperTypes().add(this.getILocation());
		iElementLocationEClass.getESuperTypes().add(this.getIElementRelativeLocation());
		iElementRelativeLocationEClass.getESuperTypes().add(this.getIAtomicLocation());
		iReferenceLocationEClass.getESuperTypes().add(this.getIElementRelativeLocation());
		iResourceLocationEClass.getESuperTypes().add(this.getIAtomicLocation());
		iElementMappingLocationEClass.getESuperTypes().add(this.getIAtomicLocation());

		// Initialize classes and features; add operations and parameters
		initEClass(iDescribedElementEClass, IDescribedElement.class, "IDescribedElement", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iIdentifiedElementEClass, IIdentifiedElement.class, "IIdentifiedElement", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iNamedElementEClass, INamedElement.class, "INamedElement", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternEClass, IPattern.class, "IPattern", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternApplicationEClass, IPatternApplication.class, "IPatternApplication", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternBasedBijectionEClass, IPatternBasedBijection.class, "IPatternBasedBijection", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternBasedFunctionEClass, IPatternBasedFunction.class, "IPatternBasedFunction", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternConformityStatusEClass, IPatternConformityStatus.class, "IPatternConformityStatus", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternDataEClass, IPatternData.class, "IPatternData", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternInstanceEClass, IPatternInstance.class, "IPatternInstance", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternInstanceMarkerEClass, IPatternInstanceMarker.class, "IPatternInstanceMarker", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternRepositoryEClass, IPatternRepository.class, "IPatternRepository", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternRoleEClass, IPatternRole.class, "IPatternRole", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternRoleSymbolEClass, IPatternRoleSymbol.class, "IPatternRoleSymbol", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternSymbolEClass, IPatternSymbol.class, "IPatternSymbol", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPatternVersionEClass, IPatternVersion.class, "IPatternVersion", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iVersionedElementEClass, IVersionedElement.class, "IVersionedElement", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iAtomicLocationEClass, IAtomicLocation.class, "IAtomicLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iAttributeLocationEClass, IAttributeLocation.class, "IAttributeLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iCompositeLocationEClass, ICompositeLocation.class, "ICompositeLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iElementLocationEClass, IElementLocation.class, "IElementLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iElementRelativeLocationEClass, IElementRelativeLocation.class, "IElementRelativeLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iLocationEClass, ILocation.class, "ILocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iReferenceLocationEClass, IReferenceLocation.class, "IReferenceLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iResourceLocationEClass, IResourceLocation.class, "IResourceLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iElementMappingLocationEClass, IElementMappingLocation.class, "IElementMappingLocation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(resourceEClass, Resource.class, "Resource", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
	}

} //PredefinedPackageImpl
