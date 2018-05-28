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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.impl.PredefinedPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorepatternsPackageImpl extends EPackageImpl implements CorepatternsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPatternInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPatternRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternRoleBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternRoleSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractIdentifiedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractVersionedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPatternSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRoleRelativeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPatternDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractAtomicLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractDescribedElementEClass = null;

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
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CorepatternsPackageImpl() {
		super(eNS_URI, CorepatternsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CorepatternsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CorepatternsPackage init() {
		if (isInited) return (CorepatternsPackage)EPackage.Registry.INSTANCE.getEPackage(CorepatternsPackage.eNS_URI);

		// Obtain or create and register package
		CorepatternsPackageImpl theCorepatternsPackage = (CorepatternsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CorepatternsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CorepatternsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PredefinedPackageImpl thePredefinedPackage = (PredefinedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PredefinedPackage.eNS_URI) instanceof PredefinedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PredefinedPackage.eNS_URI) : PredefinedPackage.eINSTANCE);

		// Create package meta-data objects
		theCorepatternsPackage.createPackageContents();
		thePredefinedPackage.createPackageContents();

		// Initialize created meta-data
		theCorepatternsPackage.initializePackageContents();
		thePredefinedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCorepatternsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CorepatternsPackage.eNS_URI, theCorepatternsPackage);
		return theCorepatternsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPatternInstance() {
		return abstractPatternInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPatternInstance_RoleBindings() {
		return (EReference)abstractPatternInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPatternInstance_PatternVersion() {
		return (EReference)abstractPatternInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPatternInstance_Folded() {
		return (EAttribute)abstractPatternInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPatternInstance_PatternData() {
		return (EReference)abstractPatternInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPatternRole() {
		return abstractPatternRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternRoleBinding() {
		return patternRoleBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternRoleBinding_Location() {
		return (EReference)patternRoleBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternSymbol() {
		return patternSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternRoleSymbol() {
		return patternRoleSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternRoleSymbol_RoleId() {
		return (EAttribute)patternRoleSymbolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternVersion() {
		return patternVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternVersion_PatternSymbol() {
		return (EReference)patternVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeLocation() {
		return compositeLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeLocation_OwnedLocations() {
		return (EReference)compositeLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternRepository() {
		return patternRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternRepository_Patterns() {
		return (EReference)patternRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractIdentifiedElement() {
		return abstractIdentifiedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractIdentifiedElement_Id() {
		return (EAttribute)abstractIdentifiedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractVersionedElement() {
		return abstractVersionedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractVersionedElement_Version() {
		return (EAttribute)abstractVersionedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPatternSymbol() {
		return abstractPatternSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPatternSymbol_RepositoryId() {
		return (EAttribute)abstractPatternSymbolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPatternSymbol_PatternId() {
		return (EAttribute)abstractPatternSymbolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPatternSymbol_LastPath() {
		return (EAttribute)abstractPatternSymbolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRoleRelativeElement() {
		return abstractRoleRelativeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractRoleRelativeElement_RoleSymbol() {
		return (EReference)abstractRoleRelativeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPatternData() {
		return abstractPatternDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPatternData_Instance() {
		return (EReference)abstractPatternDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLocation() {
		return abstractLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNamedElement() {
		return abstractNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractNamedElement_Name() {
		return (EAttribute)abstractNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPattern() {
		return abstractPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPattern_Authors() {
		return (EAttribute)abstractPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPattern_LastModificationStamp() {
		return (EAttribute)abstractPatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPattern_ExecutionEnvironments() {
		return (EAttribute)abstractPatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPattern_Template() {
		return (EAttribute)abstractPatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractAtomicLocation() {
		return abstractAtomicLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractDescribedElement() {
		return abstractDescribedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractDescribedElement_Description() {
		return (EAttribute)abstractDescribedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorepatternsFactory getCorepatternsFactory() {
		return (CorepatternsFactory)getEFactoryInstance();
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
		compositeLocationEClass = createEClass(COMPOSITE_LOCATION);
		createEReference(compositeLocationEClass, COMPOSITE_LOCATION__OWNED_LOCATIONS);

		patternRepositoryEClass = createEClass(PATTERN_REPOSITORY);
		createEReference(patternRepositoryEClass, PATTERN_REPOSITORY__PATTERNS);

		patternRoleBindingEClass = createEClass(PATTERN_ROLE_BINDING);
		createEReference(patternRoleBindingEClass, PATTERN_ROLE_BINDING__LOCATION);

		patternRoleSymbolEClass = createEClass(PATTERN_ROLE_SYMBOL);
		createEAttribute(patternRoleSymbolEClass, PATTERN_ROLE_SYMBOL__ROLE_ID);

		patternSymbolEClass = createEClass(PATTERN_SYMBOL);

		patternVersionEClass = createEClass(PATTERN_VERSION);
		createEReference(patternVersionEClass, PATTERN_VERSION__PATTERN_SYMBOL);

		abstractAtomicLocationEClass = createEClass(ABSTRACT_ATOMIC_LOCATION);

		abstractDescribedElementEClass = createEClass(ABSTRACT_DESCRIBED_ELEMENT);
		createEAttribute(abstractDescribedElementEClass, ABSTRACT_DESCRIBED_ELEMENT__DESCRIPTION);

		abstractIdentifiedElementEClass = createEClass(ABSTRACT_IDENTIFIED_ELEMENT);
		createEAttribute(abstractIdentifiedElementEClass, ABSTRACT_IDENTIFIED_ELEMENT__ID);

		abstractLocationEClass = createEClass(ABSTRACT_LOCATION);

		abstractNamedElementEClass = createEClass(ABSTRACT_NAMED_ELEMENT);
		createEAttribute(abstractNamedElementEClass, ABSTRACT_NAMED_ELEMENT__NAME);

		abstractPatternEClass = createEClass(ABSTRACT_PATTERN);
		createEAttribute(abstractPatternEClass, ABSTRACT_PATTERN__AUTHORS);
		createEAttribute(abstractPatternEClass, ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP);
		createEAttribute(abstractPatternEClass, ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS);
		createEAttribute(abstractPatternEClass, ABSTRACT_PATTERN__TEMPLATE);

		abstractPatternInstanceEClass = createEClass(ABSTRACT_PATTERN_INSTANCE);
		createEAttribute(abstractPatternInstanceEClass, ABSTRACT_PATTERN_INSTANCE__FOLDED);
		createEReference(abstractPatternInstanceEClass, ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS);
		createEReference(abstractPatternInstanceEClass, ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION);
		createEReference(abstractPatternInstanceEClass, ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA);

		abstractPatternRoleEClass = createEClass(ABSTRACT_PATTERN_ROLE);

		abstractPatternDataEClass = createEClass(ABSTRACT_PATTERN_DATA);
		createEReference(abstractPatternDataEClass, ABSTRACT_PATTERN_DATA__INSTANCE);

		abstractPatternSymbolEClass = createEClass(ABSTRACT_PATTERN_SYMBOL);
		createEAttribute(abstractPatternSymbolEClass, ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID);
		createEAttribute(abstractPatternSymbolEClass, ABSTRACT_PATTERN_SYMBOL__PATTERN_ID);
		createEAttribute(abstractPatternSymbolEClass, ABSTRACT_PATTERN_SYMBOL__LAST_PATH);

		abstractRoleRelativeElementEClass = createEClass(ABSTRACT_ROLE_RELATIVE_ELEMENT);
		createEReference(abstractRoleRelativeElementEClass, ABSTRACT_ROLE_RELATIVE_ELEMENT__ROLE_SYMBOL);

		abstractVersionedElementEClass = createEClass(ABSTRACT_VERSIONED_ELEMENT);
		createEAttribute(abstractVersionedElementEClass, ABSTRACT_VERSIONED_ELEMENT__VERSION);
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
		PredefinedPackage thePredefinedPackage = (PredefinedPackage)EPackage.Registry.INSTANCE.getEPackage(PredefinedPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(thePredefinedPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeLocationEClass.getESuperTypes().add(this.getAbstractLocation());
		compositeLocationEClass.getESuperTypes().add(thePredefinedPackage.getICompositeLocation());
		patternRepositoryEClass.getESuperTypes().add(this.getAbstractNamedElement());
		patternRepositoryEClass.getESuperTypes().add(thePredefinedPackage.getIPatternRepository());
		patternRoleBindingEClass.getESuperTypes().add(this.getAbstractRoleRelativeElement());
		patternRoleSymbolEClass.getESuperTypes().add(this.getAbstractPatternSymbol());
		patternRoleSymbolEClass.getESuperTypes().add(thePredefinedPackage.getIPatternRoleSymbol());
		patternSymbolEClass.getESuperTypes().add(this.getAbstractPatternSymbol());
		patternVersionEClass.getESuperTypes().add(this.getAbstractVersionedElement());
		patternVersionEClass.getESuperTypes().add(thePredefinedPackage.getIPatternVersion());
		abstractAtomicLocationEClass.getESuperTypes().add(this.getAbstractLocation());
		abstractAtomicLocationEClass.getESuperTypes().add(thePredefinedPackage.getIAtomicLocation());
		abstractDescribedElementEClass.getESuperTypes().add(this.getAbstractIdentifiedElement());
		abstractDescribedElementEClass.getESuperTypes().add(thePredefinedPackage.getIDescribedElement());
		abstractIdentifiedElementEClass.getESuperTypes().add(thePredefinedPackage.getIIdentifiedElement());
		abstractLocationEClass.getESuperTypes().add(this.getAbstractIdentifiedElement());
		abstractLocationEClass.getESuperTypes().add(thePredefinedPackage.getILocation());
		abstractNamedElementEClass.getESuperTypes().add(this.getAbstractIdentifiedElement());
		abstractNamedElementEClass.getESuperTypes().add(thePredefinedPackage.getINamedElement());
		abstractPatternEClass.getESuperTypes().add(this.getAbstractNamedElement());
		abstractPatternEClass.getESuperTypes().add(this.getAbstractDescribedElement());
		abstractPatternEClass.getESuperTypes().add(this.getAbstractVersionedElement());
		abstractPatternEClass.getESuperTypes().add(thePredefinedPackage.getIPattern());
		abstractPatternInstanceEClass.getESuperTypes().add(this.getAbstractIdentifiedElement());
		abstractPatternInstanceEClass.getESuperTypes().add(thePredefinedPackage.getIPatternInstance());
		abstractPatternRoleEClass.getESuperTypes().add(this.getAbstractNamedElement());
		abstractPatternRoleEClass.getESuperTypes().add(this.getAbstractDescribedElement());
		abstractPatternRoleEClass.getESuperTypes().add(thePredefinedPackage.getIPatternRole());
		abstractPatternDataEClass.getESuperTypes().add(this.getAbstractIdentifiedElement());
		abstractPatternDataEClass.getESuperTypes().add(thePredefinedPackage.getIPatternData());
		abstractPatternSymbolEClass.getESuperTypes().add(this.getAbstractNamedElement());
		abstractPatternSymbolEClass.getESuperTypes().add(thePredefinedPackage.getIPatternSymbol());
		abstractRoleRelativeElementEClass.getESuperTypes().add(this.getAbstractIdentifiedElement());
		abstractVersionedElementEClass.getESuperTypes().add(this.getAbstractIdentifiedElement());
		abstractVersionedElementEClass.getESuperTypes().add(thePredefinedPackage.getIVersionedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(compositeLocationEClass, CompositeLocation.class, "CompositeLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCompositeLocation_OwnedLocations(), thePredefinedPackage.getIAtomicLocation(), null, "ownedLocations", null, 0, -1, CompositeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(patternRepositoryEClass, PatternRepository.class, "PatternRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPatternRepository_Patterns(), this.getAbstractPattern(), null, "patterns", null, 0, -1, PatternRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(patternRepositoryEClass, theEcorePackage.getEString(), "getPath", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(patternRepositoryEClass, this.getAbstractPattern(), "getPattern", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePredefinedPackage.getIPatternSymbol(), "symbol", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(patternRepositoryEClass, this.getAbstractPattern(), "getPatternByName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(patternRoleBindingEClass, PatternRoleBinding.class, "PatternRoleBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPatternRoleBinding_Location(), this.getAbstractLocation(), null, "location", null, 1, 1, PatternRoleBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(patternRoleSymbolEClass, PatternRoleSymbol.class, "PatternRoleSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPatternRoleSymbol_RoleId(), ecorePackage.getEString(), "roleId", null, 1, 1, PatternRoleSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(patternSymbolEClass, PatternSymbol.class, "PatternSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(patternVersionEClass, PatternVersion.class, "PatternVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPatternVersion_PatternSymbol(), this.getPatternSymbol(), null, "patternSymbol", null, 1, 1, PatternVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractAtomicLocationEClass, AbstractAtomicLocation.class, "AbstractAtomicLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(abstractDescribedElementEClass, AbstractDescribedElement.class, "AbstractDescribedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractDescribedElement_Description(), theEcorePackage.getEString(), "description", null, 1, 1, AbstractDescribedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractIdentifiedElementEClass, AbstractIdentifiedElement.class, "AbstractIdentifiedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractIdentifiedElement_Id(), theEcorePackage.getEString(), "id", null, 1, 1, AbstractIdentifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractLocationEClass, AbstractLocation.class, "AbstractLocation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(abstractNamedElementEClass, AbstractNamedElement.class, "AbstractNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractNamedElement_Name(), theEcorePackage.getEString(), "name", null, 1, 1, AbstractNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractPatternEClass, AbstractPattern.class, "AbstractPattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractPattern_Authors(), theEcorePackage.getEString(), "authors", null, 1, -1, AbstractPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractPattern_LastModificationStamp(), theEcorePackage.getEString(), "lastModificationStamp", null, 1, 1, AbstractPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractPattern_ExecutionEnvironments(), theEcorePackage.getEString(), "executionEnvironments", null, 0, -1, AbstractPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractPattern_Template(), theEcorePackage.getEBoolean(), "template", "false", 1, 1, AbstractPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = addEOperation(abstractPatternEClass, this.getAbstractPatternRole(), "getRole", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePredefinedPackage.getIPatternRoleSymbol(), "symbol", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractPatternInstanceEClass, AbstractPatternInstance.class, "AbstractPatternInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractPatternInstance_Folded(), theEcorePackage.getEBoolean(), "folded", null, 1, 1, AbstractPatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractPatternInstance_RoleBindings(), this.getPatternRoleBinding(), null, "roleBindings", null, 1, -1, AbstractPatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractPatternInstance_PatternVersion(), this.getPatternVersion(), null, "patternVersion", null, 1, 1, AbstractPatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractPatternInstance_PatternData(), this.getAbstractPatternData(), this.getAbstractPatternData_Instance(), "patternData", null, 0, 1, AbstractPatternInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(abstractPatternInstanceEClass, null, "setLocation", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePredefinedPackage.getIPatternRole(), "role", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getAbstractLocation(), "location", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractPatternRoleEClass, AbstractPatternRole.class, "AbstractPatternRole", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(abstractPatternDataEClass, AbstractPatternData.class, "AbstractPatternData", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractPatternData_Instance(), this.getAbstractPatternInstance(), this.getAbstractPatternInstance_PatternData(), "instance", null, 1, 1, AbstractPatternData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractPatternSymbolEClass, AbstractPatternSymbol.class, "AbstractPatternSymbol", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractPatternSymbol_RepositoryId(), ecorePackage.getEString(), "repositoryId", null, 1, 1, AbstractPatternSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractPatternSymbol_PatternId(), ecorePackage.getEString(), "patternId", null, 1, 1, AbstractPatternSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractPatternSymbol_LastPath(), ecorePackage.getEString(), "lastPath", null, 0, 1, AbstractPatternSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractRoleRelativeElementEClass, AbstractRoleRelativeElement.class, "AbstractRoleRelativeElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractRoleRelativeElement_RoleSymbol(), this.getPatternRoleSymbol(), null, "roleSymbol", null, 1, 1, AbstractRoleRelativeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractVersionedElementEClass, AbstractVersionedElement.class, "AbstractVersionedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractVersionedElement_Version(), theEcorePackage.getEString(), "version", null, 1, 1, AbstractVersionedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //CorepatternsPackageImpl
