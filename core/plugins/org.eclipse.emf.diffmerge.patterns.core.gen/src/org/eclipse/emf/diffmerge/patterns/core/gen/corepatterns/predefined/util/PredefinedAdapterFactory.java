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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.*;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage
 * @generated
 */
public class PredefinedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PredefinedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PredefinedPackage.eINSTANCE;
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
	protected PredefinedSwitch<Adapter> modelSwitch =
		new PredefinedSwitch<Adapter>() {
			@Override
			public Adapter caseIDescribedElement(IDescribedElement object) {
				return createIDescribedElementAdapter();
			}
			@Override
			public Adapter caseIIdentifiedElement(IIdentifiedElement object) {
				return createIIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseINamedElement(INamedElement object) {
				return createINamedElementAdapter();
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
			public Adapter caseIPatternBasedBijection(IPatternBasedBijection object) {
				return createIPatternBasedBijectionAdapter();
			}
			@Override
			public Adapter caseIPatternBasedFunction(IPatternBasedFunction object) {
				return createIPatternBasedFunctionAdapter();
			}
			@Override
			public Adapter caseIPatternConformityStatus(IPatternConformityStatus object) {
				return createIPatternConformityStatusAdapter();
			}
			@Override
			public Adapter caseIPatternData(IPatternData object) {
				return createIPatternDataAdapter();
			}
			@Override
			public Adapter caseIPatternInstance(IPatternInstance object) {
				return createIPatternInstanceAdapter();
			}
			@Override
			public Adapter caseIPatternInstanceMarker(IPatternInstanceMarker object) {
				return createIPatternInstanceMarkerAdapter();
			}
			@Override
			public Adapter caseIPatternRepository(IPatternRepository object) {
				return createIPatternRepositoryAdapter();
			}
			@Override
			public Adapter caseIPatternRole(IPatternRole object) {
				return createIPatternRoleAdapter();
			}
			@Override
			public Adapter caseIPatternRoleSymbol(IPatternRoleSymbol object) {
				return createIPatternRoleSymbolAdapter();
			}
			@Override
			public Adapter caseIPatternSymbol(IPatternSymbol object) {
				return createIPatternSymbolAdapter();
			}
			@Override
			public Adapter caseIPatternVersion(IPatternVersion object) {
				return createIPatternVersionAdapter();
			}
			@Override
			public Adapter caseIVersionedElement(IVersionedElement object) {
				return createIVersionedElementAdapter();
			}
			@Override
			public Adapter caseIAtomicLocation(IAtomicLocation object) {
				return createIAtomicLocationAdapter();
			}
			@Override
			public Adapter caseIAttributeLocation(IAttributeLocation object) {
				return createIAttributeLocationAdapter();
			}
			@Override
			public Adapter caseICompositeLocation(ICompositeLocation object) {
				return createICompositeLocationAdapter();
			}
			@Override
			public Adapter caseIElementLocation(IElementLocation object) {
				return createIElementLocationAdapter();
			}
			@Override
			public Adapter caseIElementRelativeLocation(IElementRelativeLocation object) {
				return createIElementRelativeLocationAdapter();
			}
			@Override
			public Adapter caseILocation(ILocation object) {
				return createILocationAdapter();
			}
			@Override
			public Adapter caseIReferenceLocation(IReferenceLocation object) {
				return createIReferenceLocationAdapter();
			}
			@Override
			public Adapter caseIResourceLocation(IResourceLocation object) {
				return createIResourceLocationAdapter();
			}
			@Override
			public Adapter caseIElementMappingLocation(IElementMappingLocation object) {
				return createIElementMappingLocationAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection <em>IPattern Based Bijection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection
	 * @generated
	 */
	public Adapter createIPatternBasedBijectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction <em>IPattern Based Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction
	 * @generated
	 */
	public Adapter createIPatternBasedFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus <em>IPattern Conformity Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus
	 * @generated
	 */
	public Adapter createIPatternConformityStatusAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker <em>IPattern Instance Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker
	 * @generated
	 */
	public Adapter createIPatternInstanceMarkerAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation <em>IElement Relative Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation
	 * @generated
	 */
	public Adapter createIElementRelativeLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation <em>IElement Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation
	 * @generated
	 */
	public Adapter createIElementLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation <em>IReference Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation
	 * @generated
	 */
	public Adapter createIReferenceLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation <em>IAttribute Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation
	 * @generated
	 */
	public Adapter createIAttributeLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation <em>IResource Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation
	 * @generated
	 */
	public Adapter createIResourceLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation <em>IElement Mapping Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation
	 * @generated
	 */
	public Adapter createIElementMappingLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
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

} //PredefinedAdapterFactory
