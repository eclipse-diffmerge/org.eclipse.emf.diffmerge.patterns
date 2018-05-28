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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage
 * @generated
 */
public class CorepatternsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorepatternsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorepatternsSwitch() {
		if (modelPackage == null) {
			modelPackage = CorepatternsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CorepatternsPackage.COMPOSITE_LOCATION: {
				CompositeLocation compositeLocation = (CompositeLocation)theEObject;
				T result = caseCompositeLocation(compositeLocation);
				if (result == null) result = caseAbstractLocation(compositeLocation);
				if (result == null) result = caseICompositeLocation(compositeLocation);
				if (result == null) result = caseAbstractIdentifiedElement(compositeLocation);
				if (result == null) result = caseILocation(compositeLocation);
				if (result == null) result = caseIIdentifiedElement(compositeLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.PATTERN_REPOSITORY: {
				PatternRepository patternRepository = (PatternRepository)theEObject;
				T result = casePatternRepository(patternRepository);
				if (result == null) result = caseAbstractNamedElement(patternRepository);
				if (result == null) result = caseIPatternRepository(patternRepository);
				if (result == null) result = caseAbstractIdentifiedElement(patternRepository);
				if (result == null) result = caseINamedElement(patternRepository);
				if (result == null) result = caseIIdentifiedElement(patternRepository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.PATTERN_ROLE_BINDING: {
				PatternRoleBinding patternRoleBinding = (PatternRoleBinding)theEObject;
				T result = casePatternRoleBinding(patternRoleBinding);
				if (result == null) result = caseAbstractRoleRelativeElement(patternRoleBinding);
				if (result == null) result = caseAbstractIdentifiedElement(patternRoleBinding);
				if (result == null) result = caseIIdentifiedElement(patternRoleBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.PATTERN_ROLE_SYMBOL: {
				PatternRoleSymbol patternRoleSymbol = (PatternRoleSymbol)theEObject;
				T result = casePatternRoleSymbol(patternRoleSymbol);
				if (result == null) result = caseAbstractPatternSymbol(patternRoleSymbol);
				if (result == null) result = caseIPatternRoleSymbol(patternRoleSymbol);
				if (result == null) result = caseAbstractNamedElement(patternRoleSymbol);
				if (result == null) result = caseIPatternSymbol(patternRoleSymbol);
				if (result == null) result = caseAbstractIdentifiedElement(patternRoleSymbol);
				if (result == null) result = caseINamedElement(patternRoleSymbol);
				if (result == null) result = caseIIdentifiedElement(patternRoleSymbol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.PATTERN_SYMBOL: {
				PatternSymbol patternSymbol = (PatternSymbol)theEObject;
				T result = casePatternSymbol(patternSymbol);
				if (result == null) result = caseAbstractPatternSymbol(patternSymbol);
				if (result == null) result = caseAbstractNamedElement(patternSymbol);
				if (result == null) result = caseIPatternSymbol(patternSymbol);
				if (result == null) result = caseAbstractIdentifiedElement(patternSymbol);
				if (result == null) result = caseINamedElement(patternSymbol);
				if (result == null) result = caseIIdentifiedElement(patternSymbol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.PATTERN_VERSION: {
				PatternVersion patternVersion = (PatternVersion)theEObject;
				T result = casePatternVersion(patternVersion);
				if (result == null) result = caseAbstractVersionedElement(patternVersion);
				if (result == null) result = caseIPatternVersion(patternVersion);
				if (result == null) result = caseAbstractIdentifiedElement(patternVersion);
				if (result == null) result = caseIVersionedElement(patternVersion);
				if (result == null) result = caseIIdentifiedElement(patternVersion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_ATOMIC_LOCATION: {
				AbstractAtomicLocation abstractAtomicLocation = (AbstractAtomicLocation)theEObject;
				T result = caseAbstractAtomicLocation(abstractAtomicLocation);
				if (result == null) result = caseAbstractLocation(abstractAtomicLocation);
				if (result == null) result = caseIAtomicLocation(abstractAtomicLocation);
				if (result == null) result = caseAbstractIdentifiedElement(abstractAtomicLocation);
				if (result == null) result = caseILocation(abstractAtomicLocation);
				if (result == null) result = caseIIdentifiedElement(abstractAtomicLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_DESCRIBED_ELEMENT: {
				AbstractDescribedElement abstractDescribedElement = (AbstractDescribedElement)theEObject;
				T result = caseAbstractDescribedElement(abstractDescribedElement);
				if (result == null) result = caseAbstractIdentifiedElement(abstractDescribedElement);
				if (result == null) result = caseIDescribedElement(abstractDescribedElement);
				if (result == null) result = caseIIdentifiedElement(abstractDescribedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT: {
				AbstractIdentifiedElement abstractIdentifiedElement = (AbstractIdentifiedElement)theEObject;
				T result = caseAbstractIdentifiedElement(abstractIdentifiedElement);
				if (result == null) result = caseIIdentifiedElement(abstractIdentifiedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_LOCATION: {
				AbstractLocation abstractLocation = (AbstractLocation)theEObject;
				T result = caseAbstractLocation(abstractLocation);
				if (result == null) result = caseAbstractIdentifiedElement(abstractLocation);
				if (result == null) result = caseILocation(abstractLocation);
				if (result == null) result = caseIIdentifiedElement(abstractLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_NAMED_ELEMENT: {
				AbstractNamedElement abstractNamedElement = (AbstractNamedElement)theEObject;
				T result = caseAbstractNamedElement(abstractNamedElement);
				if (result == null) result = caseAbstractIdentifiedElement(abstractNamedElement);
				if (result == null) result = caseINamedElement(abstractNamedElement);
				if (result == null) result = caseIIdentifiedElement(abstractNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_PATTERN: {
				AbstractPattern abstractPattern = (AbstractPattern)theEObject;
				T result = caseAbstractPattern(abstractPattern);
				if (result == null) result = caseAbstractNamedElement(abstractPattern);
				if (result == null) result = caseAbstractDescribedElement(abstractPattern);
				if (result == null) result = caseAbstractVersionedElement(abstractPattern);
				if (result == null) result = caseIPattern(abstractPattern);
				if (result == null) result = caseAbstractIdentifiedElement(abstractPattern);
				if (result == null) result = caseINamedElement(abstractPattern);
				if (result == null) result = caseIDescribedElement(abstractPattern);
				if (result == null) result = caseIVersionedElement(abstractPattern);
				if (result == null) result = caseIIdentifiedElement(abstractPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE: {
				AbstractPatternInstance abstractPatternInstance = (AbstractPatternInstance)theEObject;
				T result = caseAbstractPatternInstance(abstractPatternInstance);
				if (result == null) result = caseAbstractIdentifiedElement(abstractPatternInstance);
				if (result == null) result = caseIPatternInstance(abstractPatternInstance);
				if (result == null) result = caseIIdentifiedElement(abstractPatternInstance);
				if (result == null) result = caseIPatternApplication(abstractPatternInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_PATTERN_ROLE: {
				AbstractPatternRole abstractPatternRole = (AbstractPatternRole)theEObject;
				T result = caseAbstractPatternRole(abstractPatternRole);
				if (result == null) result = caseAbstractNamedElement(abstractPatternRole);
				if (result == null) result = caseAbstractDescribedElement(abstractPatternRole);
				if (result == null) result = caseIPatternRole(abstractPatternRole);
				if (result == null) result = caseAbstractIdentifiedElement(abstractPatternRole);
				if (result == null) result = caseINamedElement(abstractPatternRole);
				if (result == null) result = caseIDescribedElement(abstractPatternRole);
				if (result == null) result = caseIIdentifiedElement(abstractPatternRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_PATTERN_DATA: {
				AbstractPatternData abstractPatternData = (AbstractPatternData)theEObject;
				T result = caseAbstractPatternData(abstractPatternData);
				if (result == null) result = caseAbstractIdentifiedElement(abstractPatternData);
				if (result == null) result = caseIPatternData(abstractPatternData);
				if (result == null) result = caseIIdentifiedElement(abstractPatternData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL: {
				AbstractPatternSymbol abstractPatternSymbol = (AbstractPatternSymbol)theEObject;
				T result = caseAbstractPatternSymbol(abstractPatternSymbol);
				if (result == null) result = caseAbstractNamedElement(abstractPatternSymbol);
				if (result == null) result = caseIPatternSymbol(abstractPatternSymbol);
				if (result == null) result = caseAbstractIdentifiedElement(abstractPatternSymbol);
				if (result == null) result = caseINamedElement(abstractPatternSymbol);
				if (result == null) result = caseIIdentifiedElement(abstractPatternSymbol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_ROLE_RELATIVE_ELEMENT: {
				AbstractRoleRelativeElement abstractRoleRelativeElement = (AbstractRoleRelativeElement)theEObject;
				T result = caseAbstractRoleRelativeElement(abstractRoleRelativeElement);
				if (result == null) result = caseAbstractIdentifiedElement(abstractRoleRelativeElement);
				if (result == null) result = caseIIdentifiedElement(abstractRoleRelativeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorepatternsPackage.ABSTRACT_VERSIONED_ELEMENT: {
				AbstractVersionedElement abstractVersionedElement = (AbstractVersionedElement)theEObject;
				T result = caseAbstractVersionedElement(abstractVersionedElement);
				if (result == null) result = caseAbstractIdentifiedElement(abstractVersionedElement);
				if (result == null) result = caseIVersionedElement(abstractVersionedElement);
				if (result == null) result = caseIIdentifiedElement(abstractVersionedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPatternRole(AbstractPatternRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Role Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Role Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternRoleBinding(PatternRoleBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternSymbol(PatternSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Role Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Role Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternRoleSymbol(PatternRoleSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternVersion(PatternVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeLocation(CompositeLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternRepository(PatternRepository object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Versioned Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Versioned Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractVersionedElement(AbstractVersionedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPatternSymbol(AbstractPatternSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Role Relative Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Role Relative Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRoleRelativeElement(AbstractRoleRelativeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPatternData(AbstractPatternData object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNamedElement(AbstractNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPattern(AbstractPattern object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Described Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Described Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDescribedElement(AbstractDescribedElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseINamedElement(INamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternRepository(IPatternRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPattern(IPattern object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternRole(IPatternRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternSymbol(IPatternSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Role Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Role Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternRoleSymbol(IPatternRoleSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVersioned Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVersioned Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVersionedElement(IVersionedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternVersion(IPatternVersion object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>IComposite Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IComposite Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseICompositeLocation(ICompositeLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternData(IPatternData object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>IDescribed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDescribed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDescribedElement(IDescribedElement object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //CorepatternsSwitch
