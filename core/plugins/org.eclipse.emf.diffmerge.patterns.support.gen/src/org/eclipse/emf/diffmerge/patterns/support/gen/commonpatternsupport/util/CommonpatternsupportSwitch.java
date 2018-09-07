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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;


import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage
 * @generated
 */
public class CommonpatternsupportSwitch<T> extends Switch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static CommonpatternsupportPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CommonpatternsupportSwitch() {
		if (modelPackage == null) {
			modelPackage = CommonpatternsupportPackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

		/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
		protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET: {
				CommonPatternInstanceSet commonPatternInstanceSet = (CommonPatternInstanceSet)theEObject;
				T result = caseCommonPatternInstanceSet(commonPatternInstanceSet);
				if (result == null) result = caseAbstractIdentifiedElement(commonPatternInstanceSet);
				if (result == null) result = caseIPatternInstanceMarker(commonPatternInstanceSet);
				if (result == null) result = caseIIdentifiedElement(commonPatternInstanceSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE: {
				CommonPatternInstance commonPatternInstance = (CommonPatternInstance)theEObject;
				T result = caseCommonPatternInstance(commonPatternInstance);
				if (result == null) result = caseAbstractPatternInstance(commonPatternInstance);
				if (result == null) result = caseAbstractIdentifiedElement(commonPatternInstance);
				if (result == null) result = caseIPatternInstance(commonPatternInstance);
				if (result == null) result = caseIIdentifiedElement(commonPatternInstance);
				if (result == null) result = caseIPatternApplication(commonPatternInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.RESOURCE_LOCATION: {
				ResourceLocation resourceLocation = (ResourceLocation)theEObject;
				T result = caseResourceLocation(resourceLocation);
				if (result == null) result = caseAbstractIDBasedAtomicLocation(resourceLocation);
				if (result == null) result = caseIResourceLocation(resourceLocation);
				if (result == null) result = caseAbstractAtomicLocation(resourceLocation);
				if (result == null) result = caseAbstractLocation(resourceLocation);
				if (result == null) result = caseIAtomicLocation(resourceLocation);
				if (result == null) result = caseAbstractIdentifiedElement(resourceLocation);
				if (result == null) result = caseILocation(resourceLocation);
				if (result == null) result = caseIIdentifiedElement(resourceLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.ELEMENT_LOCATION: {
				ElementLocation elementLocation = (ElementLocation)theEObject;
				T result = caseElementLocation(elementLocation);
				if (result == null) result = caseAbstractElementRelativeLocation(elementLocation);
				if (result == null) result = caseIElementLocation(elementLocation);
				if (result == null) result = caseAbstractIDBasedAtomicLocation(elementLocation);
				if (result == null) result = caseIElementRelativeLocation(elementLocation);
				if (result == null) result = caseAbstractAtomicLocation(elementLocation);
				if (result == null) result = caseAbstractLocation(elementLocation);
				if (result == null) result = caseIAtomicLocation(elementLocation);
				if (result == null) result = caseAbstractIdentifiedElement(elementLocation);
				if (result == null) result = caseILocation(elementLocation);
				if (result == null) result = caseIIdentifiedElement(elementLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.ATTRIBUTE_LOCATION: {
				AttributeLocation attributeLocation = (AttributeLocation)theEObject;
				T result = caseAttributeLocation(attributeLocation);
				if (result == null) result = caseAbstractElementRelativeLocation(attributeLocation);
				if (result == null) result = caseIAttributeLocation(attributeLocation);
				if (result == null) result = caseAbstractIDBasedAtomicLocation(attributeLocation);
				if (result == null) result = caseIElementRelativeLocation(attributeLocation);
				if (result == null) result = caseAbstractAtomicLocation(attributeLocation);
				if (result == null) result = caseAbstractLocation(attributeLocation);
				if (result == null) result = caseIAtomicLocation(attributeLocation);
				if (result == null) result = caseAbstractIdentifiedElement(attributeLocation);
				if (result == null) result = caseILocation(attributeLocation);
				if (result == null) result = caseIIdentifiedElement(attributeLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.REFERENCE_LOCATION: {
				ReferenceLocation referenceLocation = (ReferenceLocation)theEObject;
				T result = caseReferenceLocation(referenceLocation);
				if (result == null) result = caseAbstractElementRelativeLocation(referenceLocation);
				if (result == null) result = caseIReferenceLocation(referenceLocation);
				if (result == null) result = caseAbstractIDBasedAtomicLocation(referenceLocation);
				if (result == null) result = caseIElementRelativeLocation(referenceLocation);
				if (result == null) result = caseAbstractAtomicLocation(referenceLocation);
				if (result == null) result = caseAbstractLocation(referenceLocation);
				if (result == null) result = caseIAtomicLocation(referenceLocation);
				if (result == null) result = caseAbstractIdentifiedElement(referenceLocation);
				if (result == null) result = caseILocation(referenceLocation);
				if (result == null) result = caseIIdentifiedElement(referenceLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.ABSTRACT_ID_BASED_ATOMIC_LOCATION: {
				AbstractIDBasedAtomicLocation abstractIDBasedAtomicLocation = (AbstractIDBasedAtomicLocation)theEObject;
				T result = caseAbstractIDBasedAtomicLocation(abstractIDBasedAtomicLocation);
				if (result == null) result = caseAbstractAtomicLocation(abstractIDBasedAtomicLocation);
				if (result == null) result = caseAbstractLocation(abstractIDBasedAtomicLocation);
				if (result == null) result = caseIAtomicLocation(abstractIDBasedAtomicLocation);
				if (result == null) result = caseAbstractIdentifiedElement(abstractIDBasedAtomicLocation);
				if (result == null) result = caseILocation(abstractIDBasedAtomicLocation);
				if (result == null) result = caseIIdentifiedElement(abstractIDBasedAtomicLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.ABSTRACT_ELEMENT_RELATIVE_LOCATION: {
				AbstractElementRelativeLocation abstractElementRelativeLocation = (AbstractElementRelativeLocation)theEObject;
				T result = caseAbstractElementRelativeLocation(abstractElementRelativeLocation);
				if (result == null) result = caseAbstractIDBasedAtomicLocation(abstractElementRelativeLocation);
				if (result == null) result = caseIElementRelativeLocation(abstractElementRelativeLocation);
				if (result == null) result = caseAbstractAtomicLocation(abstractElementRelativeLocation);
				if (result == null) result = caseAbstractLocation(abstractElementRelativeLocation);
				if (result == null) result = caseIAtomicLocation(abstractElementRelativeLocation);
				if (result == null) result = caseAbstractIdentifiedElement(abstractElementRelativeLocation);
				if (result == null) result = caseILocation(abstractElementRelativeLocation);
				if (result == null) result = caseIIdentifiedElement(abstractElementRelativeLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION: {
				ElementMappingLocation elementMappingLocation = (ElementMappingLocation)theEObject;
				T result = caseElementMappingLocation(elementMappingLocation);
				if (result == null) result = caseAbstractIDBasedAtomicLocation(elementMappingLocation);
				if (result == null) result = caseIElementMappingLocation(elementMappingLocation);
				if (result == null) result = caseAbstractAtomicLocation(elementMappingLocation);
				if (result == null) result = caseAbstractLocation(elementMappingLocation);
				if (result == null) result = caseIAtomicLocation(elementMappingLocation);
				if (result == null) result = caseAbstractIdentifiedElement(elementMappingLocation);
				if (result == null) result = caseILocation(elementMappingLocation);
				if (result == null) result = caseIIdentifiedElement(elementMappingLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonpatternsupportPackage.ELEMENT_MAPPING_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, ElementLocation> elementMappingEntry = (Map.Entry<String, ElementLocation>)theEObject;
				T result = caseElementMappingEntry(elementMappingEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Common Pattern Instance Set</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Common Pattern Instance Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCommonPatternInstanceSet(CommonPatternInstanceSet object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Common Pattern Instance</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Common Pattern Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCommonPatternInstance(CommonPatternInstance object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseResourceLocation(ResourceLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Element Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseElementLocation(ElementLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAttributeLocation(AttributeLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseReferenceLocation(ReferenceLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract ID Based Atomic Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract ID Based Atomic Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAbstractIDBasedAtomicLocation(AbstractIDBasedAtomicLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Element Relative Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Element Relative Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAbstractElementRelativeLocation(AbstractElementRelativeLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Element Mapping Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Mapping Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseElementMappingLocation(ElementMappingLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Element Mapping Entry</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Mapping Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseElementMappingEntry(Map.Entry<String, ElementLocation> object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IIdentified Element</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IIdentified Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIIdentifiedElement(IIdentifiedElement object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Identified Element</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Identified Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAbstractIdentifiedElement(AbstractIdentifiedElement object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Instance Marker</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Instance Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIPatternInstanceMarker(IPatternInstanceMarker object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Application</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIPatternApplication(IPatternApplication object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Instance</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIPatternInstance(IPatternInstance object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Instance</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAbstractPatternInstance(AbstractPatternInstance object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>ILocation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ILocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseILocation(ILocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAbstractLocation(AbstractLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IAtomic Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAtomic Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIAtomicLocation(IAtomicLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Atomic Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Atomic Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAbstractAtomicLocation(AbstractAtomicLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IResource Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IResource Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIResourceLocation(IResourceLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IElement Relative Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IElement Relative Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIElementRelativeLocation(IElementRelativeLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IElement Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IElement Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIElementLocation(IElementLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IAttribute Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAttribute Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIAttributeLocation(IAttributeLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IReference Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IReference Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIReferenceLocation(IReferenceLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>IElement Mapping Location</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IElement Mapping Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIElementMappingLocation(IElementMappingLocation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
		public T defaultCase(EObject object) {
		return null;
	}

} //CommonpatternsupportSwitch
