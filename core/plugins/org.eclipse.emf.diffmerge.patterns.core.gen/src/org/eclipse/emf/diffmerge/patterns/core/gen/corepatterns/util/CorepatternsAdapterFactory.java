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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.util;

import org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage
 * @generated
 */
public class CorepatternsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorepatternsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorepatternsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CorepatternsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorepatternsSwitch<Adapter> modelSwitch =
		new CorepatternsSwitch<Adapter>() {
			@Override
			public Adapter caseCompositeLocation(CompositeLocation object) {
				return createCompositeLocationAdapter();
			}
			@Override
			public Adapter casePatternRepository(PatternRepository object) {
				return createPatternRepositoryAdapter();
			}
			@Override
			public Adapter casePatternRoleBinding(PatternRoleBinding object) {
				return createPatternRoleBindingAdapter();
			}
			@Override
			public Adapter casePatternRoleSymbol(PatternRoleSymbol object) {
				return createPatternRoleSymbolAdapter();
			}
			@Override
			public Adapter casePatternSymbol(PatternSymbol object) {
				return createPatternSymbolAdapter();
			}
			@Override
			public Adapter casePatternVersion(PatternVersion object) {
				return createPatternVersionAdapter();
			}
			@Override
			public Adapter caseAbstractAtomicLocation(AbstractAtomicLocation object) {
				return createAbstractAtomicLocationAdapter();
			}
			@Override
			public Adapter caseAbstractDescribedElement(AbstractDescribedElement object) {
				return createAbstractDescribedElementAdapter();
			}
			@Override
			public Adapter caseAbstractIdentifiedElement(AbstractIdentifiedElement object) {
				return createAbstractIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseAbstractLocation(AbstractLocation object) {
				return createAbstractLocationAdapter();
			}
			@Override
			public Adapter caseAbstractNamedElement(AbstractNamedElement object) {
				return createAbstractNamedElementAdapter();
			}
			@Override
			public Adapter caseAbstractPattern(AbstractPattern object) {
				return createAbstractPatternAdapter();
			}
			@Override
			public Adapter caseAbstractPatternInstance(AbstractPatternInstance object) {
				return createAbstractPatternInstanceAdapter();
			}
			@Override
			public Adapter caseAbstractPatternRole(AbstractPatternRole object) {
				return createAbstractPatternRoleAdapter();
			}
			@Override
			public Adapter caseAbstractPatternData(AbstractPatternData object) {
				return createAbstractPatternDataAdapter();
			}
			@Override
			public Adapter caseAbstractPatternSymbol(AbstractPatternSymbol object) {
				return createAbstractPatternSymbolAdapter();
			}
			@Override
			public Adapter caseAbstractRoleRelativeElement(AbstractRoleRelativeElement object) {
				return createAbstractRoleRelativeElementAdapter();
			}
			@Override
			public Adapter caseAbstractVersionedElement(AbstractVersionedElement object) {
				return createAbstractVersionedElementAdapter();
			}
			@Override
			public Adapter caseIIdentifiedElement(IIdentifiedElement object) {
				return createIIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseILocation(ILocation object) {
				return createILocationAdapter();
			}
			@Override
			public Adapter caseICompositeLocation(ICompositeLocation object) {
				return createICompositeLocationAdapter();
			}
			@Override
			public Adapter caseINamedElement(INamedElement object) {
				return createINamedElementAdapter();
			}
			@Override
			public Adapter caseIPatternRepository(IPatternRepository object) {
				return createIPatternRepositoryAdapter();
			}
			@Override
			public Adapter caseIPatternSymbol(IPatternSymbol object) {
				return createIPatternSymbolAdapter();
			}
			@Override
			public Adapter caseIPatternRoleSymbol(IPatternRoleSymbol object) {
				return createIPatternRoleSymbolAdapter();
			}
			@Override
			public Adapter caseIVersionedElement(IVersionedElement object) {
				return createIVersionedElementAdapter();
			}
			@Override
			public Adapter caseIPatternVersion(IPatternVersion object) {
				return createIPatternVersionAdapter();
			}
			@Override
			public Adapter caseIAtomicLocation(IAtomicLocation object) {
				return createIAtomicLocationAdapter();
			}
			@Override
			public Adapter caseIDescribedElement(IDescribedElement object) {
				return createIDescribedElementAdapter();
			}
			@Override
			public Adapter caseIPattern(IPattern object) {
				return createIPatternAdapter();
			}
			@Override
			public Adapter caseIPatternApplication(IPatternApplication object) {
				return createIPatternApplicationAdapter();
			}
			@Override
			public Adapter caseIPatternInstance(IPatternInstance object) {
				return createIPatternInstanceAdapter();
			}
			@Override
			public Adapter caseIPatternRole(IPatternRole object) {
				return createIPatternRoleAdapter();
			}
			@Override
			public Adapter caseIPatternData(IPatternData object) {
				return createIPatternDataAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance <em>Abstract Pattern Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance
	 * @generated
	 */
	public Adapter createAbstractPatternInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole <em>Abstract Pattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole
	 * @generated
	 */
	public Adapter createAbstractPatternRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding <em>Pattern Role Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding
	 * @generated
	 */
	public Adapter createPatternRoleBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol <em>Pattern Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol
	 * @generated
	 */
	public Adapter createPatternSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol <em>Pattern Role Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol
	 * @generated
	 */
	public Adapter createPatternRoleSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion <em>Pattern Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion
	 * @generated
	 */
	public Adapter createPatternVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation <em>Composite Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation
	 * @generated
	 */
	public Adapter createCompositeLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository <em>Pattern Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository
	 * @generated
	 */
	public Adapter createPatternRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement <em>Abstract Identified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement
	 * @generated
	 */
	public Adapter createAbstractIdentifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement <em>Abstract Versioned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement
	 * @generated
	 */
	public Adapter createAbstractVersionedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol <em>Abstract Pattern Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol
	 * @generated
	 */
	public Adapter createAbstractPatternSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement <em>Abstract Role Relative Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractRoleRelativeElement
	 * @generated
	 */
	public Adapter createAbstractRoleRelativeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData <em>Abstract Pattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData
	 * @generated
	 */
	public Adapter createAbstractPatternDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation <em>Abstract Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation
	 * @generated
	 */
	public Adapter createAbstractLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement <em>Abstract Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement
	 * @generated
	 */
	public Adapter createAbstractNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern <em>Abstract Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern
	 * @generated
	 */
	public Adapter createAbstractPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractAtomicLocation <em>Abstract Atomic Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractAtomicLocation
	 * @generated
	 */
	public Adapter createAbstractAtomicLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement <em>Abstract Described Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement
	 * @generated
	 */
	public Adapter createAbstractDescribedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement <em>IIdentified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement
	 * @generated
	 */
	public Adapter createIIdentifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.INamedElement <em>INamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement
	 * @generated
	 */
	public Adapter createINamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository <em>IPattern Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository
	 * @generated
	 */
	public Adapter createIPatternRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPattern <em>IPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern
	 * @generated
	 */
	public Adapter createIPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication <em>IPattern Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication
	 * @generated
	 */
	public Adapter createIPatternApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance <em>IPattern Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance
	 * @generated
	 */
	public Adapter createIPatternInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole <em>IPattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole
	 * @generated
	 */
	public Adapter createIPatternRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol <em>IPattern Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol
	 * @generated
	 */
	public Adapter createIPatternSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol <em>IPattern Role Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol
	 * @generated
	 */
	public Adapter createIPatternRoleSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement <em>IVersioned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement
	 * @generated
	 */
	public Adapter createIVersionedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion <em>IPattern Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion
	 * @generated
	 */
	public Adapter createIPatternVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation <em>ILocation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation
	 * @generated
	 */
	public Adapter createILocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation <em>IComposite Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation
	 * @generated
	 */
	public Adapter createICompositeLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternData <em>IPattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternData
	 * @generated
	 */
	public Adapter createIPatternDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation <em>IAtomic Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation
	 * @generated
	 */
	public Adapter createIAtomicLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement <em>IDescribed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement
	 * @generated
	 */
	public Adapter createIDescribedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CorepatternsAdapterFactory
