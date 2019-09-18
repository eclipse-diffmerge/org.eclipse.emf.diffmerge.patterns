/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl;


import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractIdentifiedElementImpl;


import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Pattern Instance Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.CommonPatternInstanceSetImpl#getOwnedInstances <em>Owned Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommonPatternInstanceSetImpl extends AbstractIdentifiedElementImpl implements CommonPatternInstanceSet {
  /**
	 * The cached value of the '{@link #getOwnedInstances() <em>Owned Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOwnedInstances()
	 * @generated
	 * @ordered
	 */
  protected EList<CommonPatternInstance> ownedInstances;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CommonPatternInstanceSetImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonpatternsupportPackage.Literals.COMMON_PATTERN_INSTANCE_SET;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<CommonPatternInstance> getOwnedInstances() {
		if (ownedInstances == null) {
			ownedInstances = new EObjectContainmentEList<CommonPatternInstance>(CommonPatternInstance.class, this, CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES);
		}
		return ownedInstances;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES:
				return ((InternalEList<?>)getOwnedInstances()).basicRemove(otherEnd, msgs);
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
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES:
				return getOwnedInstances();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES:
				getOwnedInstances().clear();
				getOwnedInstances().addAll((Collection<? extends CommonPatternInstance>)newValue);
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
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES:
				getOwnedInstances().clear();
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
			case CommonpatternsupportPackage.COMMON_PATTERN_INSTANCE_SET__OWNED_INSTANCES:
				return ownedInstances != null && !ownedInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
   
    if (baseClass == IPatternInstanceMarker.class) {
      switch (derivedFeatureID) {
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
   
    if (baseClass == IPatternInstanceMarker.class) {
      switch (baseFeatureID) {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }
  
} //CommonPatternInstanceSetImpl
