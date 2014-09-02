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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Mapping Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.ElementMappingLocationImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementMappingLocationImpl extends AbstractIDBasedAtomicLocationImpl implements ElementMappingLocation {
  /**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' map.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
  protected EMap<String, ElementLocation> mapping;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ElementMappingLocationImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonpatternsupportPackage.Literals.ELEMENT_MAPPING_LOCATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EMap<String, ElementLocation> getMapping() {
		if (mapping == null) {
			mapping = new EcoreEMap<String,ElementLocation>(CommonpatternsupportPackage.Literals.ELEMENT_MAPPING_ENTRY, ElementMappingEntryImpl.class, this, CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION__MAPPING);
		}
		return mapping;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION__MAPPING:
				return ((InternalEList<?>)getMapping()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION__MAPPING:
				if (coreType) return getMapping();
				else return getMapping().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION__MAPPING:
				((EStructuralFeature.Setting)getMapping()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION__MAPPING:
				getMapping().clear();
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CommonpatternsupportPackage.ELEMENT_MAPPING_LOCATION__MAPPING:
				return mapping != null && !mapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   * @generated NOT
   */
  public boolean supportsAddition() {
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   * @generated NOT
   */
  public boolean supportsMerge() {
    return true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation#getElement(org.eclipse.emf.ecore.EObject)
   * @generated NOT
   */
  public EObject getElement(EObject patternElement_p) {
    EObject result = null;
    String patternElementId = CorePatternsPlugin.getDefault().getIdProvider().getId(patternElement_p, 
        AdapterFactoryEditingDomain.getEditingDomainFor(patternElement_p));
    ElementLocation location = getMapping().get(patternElementId);
    if (location != null)
      result = location.getElement();
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation#getModelElements()
   * @generated NOT
   */
  public Collection<EObject> getModelElements() {
    List<EObject> result = new ModelsUtil.ROrderedSet<EObject>();
    for (ElementLocation elementLocation : getMapping().values()) {
      EObject modelElement = elementLocation.getElement();
      if (modelElement != null)
        result.add(modelElement);
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation#getPatternElements(IPattern)
   * @generated NOT
   */
  public Collection<EObject> getPatternElements(IPattern pattern_p) {
    List<EObject> result = new ModelsUtil.ROrderedSet<EObject>();
    if (pattern_p instanceof EObject) {
      for (String patternElementId : getMapping().keySet()) {
        EObject mappedElement = CorePatternsPlugin.getDefault().getIdProvider().getByIdInResource(patternElementId, (EObject)pattern_p);
        if (mappedElement != null)
          result.add(mappedElement);
      }
    }
    return Collections.unmodifiableList(result);
  }
  
} //ElementMappingLocationImpl
