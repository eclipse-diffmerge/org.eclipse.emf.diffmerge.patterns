/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonpatternsupportFactoryImpl extends EFactoryImpl implements CommonpatternsupportFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static CommonpatternsupportFactory init() {
		try {
			CommonpatternsupportFactory theCommonpatternsupportFactory = (CommonpatternsupportFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.eclipse.emf.patterns/support/1.0.0");  //$NON-NLS-1$
			if (theCommonpatternsupportFactory != null) {
				return theCommonpatternsupportFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommonpatternsupportFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CommonpatternsupportFactoryImpl() {
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
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET: return createCommonPatternInstanceSet();
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE: return createCommonPatternInstance();
			case CommonpatternsupportPackage.RESOURCE_LOCATION: return createResourceLocation();
			case CommonpatternsupportPackage.ELEMENT_LOCATION: return createElementLocation();
			case CommonpatternsupportPackage.ATTRIBUTE_LOCATION: return createAttributeLocation();
			case CommonpatternsupportPackage.REFERENCE_LOCATION: return createReferenceLocation();
			case CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION: return createElementMappingLocation();
			case CommonpatternsupportPackage.ELEMENT_MAPPING_ENTRY: return (EObject)createElementMappingEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CommonPatternInstanceSet createCommonPatternInstanceSet() {
		CommonPatternInstanceSetImpl commonPatternInstanceSet = new CommonPatternInstanceSetImpl();
		return commonPatternInstanceSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CommonPatternInstance createCommonPatternInstance() {
		CommonPatternInstanceImpl commonPatternInstance = new CommonPatternInstanceImpl();
		return commonPatternInstance;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ResourceLocation createResourceLocation() {
		ResourceLocationImpl resourceLocation = new ResourceLocationImpl();
		return resourceLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ElementLocation createElementLocation() {
		ElementLocationImpl elementLocation = new ElementLocationImpl();
		return elementLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AttributeLocation createAttributeLocation() {
		AttributeLocationImpl attributeLocation = new AttributeLocationImpl();
		return attributeLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ReferenceLocation createReferenceLocation() {
		ReferenceLocationImpl referenceLocation = new ReferenceLocationImpl();
		return referenceLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ElementMappingLocation createElementMappingLocation() {
		ElementMappingLocationImpl elementMappingLocation = new ElementMappingLocationImpl();
		return elementMappingLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Map.Entry<String, ElementLocation> createElementMappingEntry() {
		ElementMappingEntryImpl elementMappingEntry = new ElementMappingEntryImpl();
		return elementMappingEntry;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CommonpatternsupportPackage getCommonpatternsupportPackage() {
		return (CommonpatternsupportPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @SuppressWarnings("javadoc")
  @Deprecated
  public static CommonpatternsupportPackage getPackage() {
		return CommonpatternsupportPackage.eINSTANCE;
	}

} //CommonpatternsupportFactoryImpl
