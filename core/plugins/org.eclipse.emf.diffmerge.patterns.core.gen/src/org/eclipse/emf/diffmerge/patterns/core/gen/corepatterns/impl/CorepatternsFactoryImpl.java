/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorepatternsFactoryImpl extends EFactoryImpl implements CorepatternsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CorepatternsFactory init() {
		try {
			CorepatternsFactory theCorepatternsFactory = (CorepatternsFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.eclipse.com/emf/diffmerge/patterns/core/1.0.0");  //$NON-NLS-1$
			if (theCorepatternsFactory != null) {
				return theCorepatternsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CorepatternsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorepatternsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CorepatternsPackage.COMPOSITE_LOCATION: return createCompositeLocation();
			case CorepatternsPackage.PATTERN_REPOSITORY: return createPatternRepository();
			case CorepatternsPackage.PATTERN_ROLE_BINDING: return createPatternRoleBinding();
			case CorepatternsPackage.PATTERN_ROLE_SYMBOL: return createPatternRoleSymbol();
			case CorepatternsPackage.PATTERN_SYMBOL: return createPatternSymbol();
			case CorepatternsPackage.PATTERN_VERSION: return createPatternVersion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternRoleBinding createPatternRoleBinding() {
		PatternRoleBindingImpl patternRoleBinding = new PatternRoleBindingImpl();
		return patternRoleBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternSymbol createPatternSymbol() {
		PatternSymbolImpl patternSymbol = new PatternSymbolImpl();
		return patternSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternRoleSymbol createPatternRoleSymbol() {
		PatternRoleSymbolImpl patternRoleSymbol = new PatternRoleSymbolImpl();
		return patternRoleSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternVersion createPatternVersion() {
		PatternVersionImpl patternVersion = new PatternVersionImpl();
		return patternVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeLocation createCompositeLocation() {
		CompositeLocationImpl compositeLocation = new CompositeLocationImpl();
		return compositeLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternRepository createPatternRepository() {
		PatternRepositoryImpl patternRepository = new PatternRepositoryImpl();
		return patternRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorepatternsPackage getCorepatternsPackage() {
		return (CorepatternsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CorepatternsPackage getPackage() {
		return CorepatternsPackage.eINSTANCE;
	}

} //CorepatternsFactoryImpl
