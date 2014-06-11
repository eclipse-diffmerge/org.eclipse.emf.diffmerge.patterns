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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.util;

import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage
 * @generated
 */
public class CommonpatternsupportAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static CommonpatternsupportPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CommonpatternsupportAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CommonpatternsupportPackage.eINSTANCE;
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
  protected CommonpatternsupportSwitch<Adapter> modelSwitch =
    new CommonpatternsupportSwitch<Adapter>() {
			@Override
			public Adapter caseCommonPatternInstanceSet(CommonPatternInstanceSet object) {
				return createCommonPatternInstanceSetAdapter();
			}
			@Override
			public Adapter caseCommonPatternInstance(CommonPatternInstance object) {
				return createCommonPatternInstanceAdapter();
			}
			@Override
			public Adapter caseResourceLocation(ResourceLocation object) {
				return createResourceLocationAdapter();
			}
			@Override
			public Adapter caseElementLocation(ElementLocation object) {
				return createElementLocationAdapter();
			}
			@Override
			public Adapter caseAttributeLocation(AttributeLocation object) {
				return createAttributeLocationAdapter();
			}
			@Override
			public Adapter caseReferenceLocation(ReferenceLocation object) {
				return createReferenceLocationAdapter();
			}
			@Override
			public Adapter caseAbstractIDBasedAtomicLocation(AbstractIDBasedAtomicLocation object) {
				return createAbstractIDBasedAtomicLocationAdapter();
			}
			@Override
			public Adapter caseAbstractElementRelativeLocation(AbstractElementRelativeLocation object) {
				return createAbstractElementRelativeLocationAdapter();
			}
			@Override
			public Adapter caseElementMappingLocation(ElementMappingLocation object) {
				return createElementMappingLocationAdapter();
			}
			@Override
			public Adapter caseElementMappingEntry(Map.Entry<String, ElementLocation> object) {
				return createElementMappingEntryAdapter();
			}
			@Override
			public Adapter caseIIdentifiedElement(IIdentifiedElement object) {
				return createIIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseAbstractIdentifiedElement(AbstractIdentifiedElement object) {
				return createAbstractIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseIPatternInstanceMarker(IPatternInstanceMarker object) {
				return createIPatternInstanceMarkerAdapter();
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
			public Adapter caseAbstractPatternInstance(AbstractPatternInstance object) {
				return createAbstractPatternInstanceAdapter();
			}
			@Override
			public Adapter caseILocation(ILocation object) {
				return createILocationAdapter();
			}
			@Override
			public Adapter caseAbstractLocation(AbstractLocation object) {
				return createAbstractLocationAdapter();
			}
			@Override
			public Adapter caseIAtomicLocation(IAtomicLocation object) {
				return createIAtomicLocationAdapter();
			}
			@Override
			public Adapter caseAbstractAtomicLocation(AbstractAtomicLocation object) {
				return createAbstractAtomicLocationAdapter();
			}
			@Override
			public Adapter caseIResourceLocation(IResourceLocation object) {
				return createIResourceLocationAdapter();
			}
			@Override
			public Adapter caseIElementRelativeLocation(IElementRelativeLocation object) {
				return createIElementRelativeLocationAdapter();
			}
			@Override
			public Adapter caseIElementLocation(IElementLocation object) {
				return createIElementLocationAdapter();
			}
			@Override
			public Adapter caseIAttributeLocation(IAttributeLocation object) {
				return createIAttributeLocationAdapter();
			}
			@Override
			public Adapter caseIReferenceLocation(IReferenceLocation object) {
				return createIReferenceLocationAdapter();
			}
			@Override
			public Adapter caseIElementMappingLocation(IElementMappingLocation object) {
				return createIElementMappingLocationAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet <em>Common Pattern Instance Set</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet
	 * @generated
	 */
  public Adapter createCommonPatternInstanceSetAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance <em>Common Pattern Instance</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance
	 * @generated
	 */
  public Adapter createCommonPatternInstanceAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ResourceLocation <em>Resource Location</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ResourceLocation
	 * @generated
	 */
  public Adapter createResourceLocationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation <em>Element Location</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation
	 * @generated
	 */
  public Adapter createElementLocationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation <em>Attribute Location</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation
	 * @generated
	 */
  public Adapter createAttributeLocationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation <em>Reference Location</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation
	 * @generated
	 */
  public Adapter createReferenceLocationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation <em>Abstract ID Based Atomic Location</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation
	 * @generated
	 */
  public Adapter createAbstractIDBasedAtomicLocationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractElementRelativeLocation <em>Abstract Element Relative Location</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractElementRelativeLocation
	 * @generated
	 */
  public Adapter createAbstractElementRelativeLocationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation <em>Element Mapping Location</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation
	 * @generated
	 */
  public Adapter createElementMappingLocationAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Element Mapping Entry</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
  public Adapter createElementMappingEntryAdapter() {
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

} //CommonpatternsupportAdapterFactory
