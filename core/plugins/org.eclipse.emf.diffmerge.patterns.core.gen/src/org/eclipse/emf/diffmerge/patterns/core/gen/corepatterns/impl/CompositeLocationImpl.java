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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.CompositeLocationImpl#getOwnedLocations <em>Owned Locations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeLocationImpl extends AbstractLocationImpl implements CompositeLocation {
	/**
	 * The cached value of the '{@link #getOwnedLocations() <em>Owned Locations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLocations()
	 * @generated
	 * @ordered
	 */
	protected EList<IAtomicLocation> ownedLocations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorepatternsPackage.Literals.COMPOSITE_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAtomicLocation> getOwnedLocations() {
		if (ownedLocations == null) {
			ownedLocations = new EObjectContainmentEList<IAtomicLocation>(IAtomicLocation.class, this, CorepatternsPackage.COMPOSITE_LOCATION__OWNED_LOCATIONS);
		}
		return ownedLocations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorepatternsPackage.COMPOSITE_LOCATION__OWNED_LOCATIONS:
				return ((InternalEList<?>)getOwnedLocations()).basicRemove(otherEnd, msgs);
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
			case CorepatternsPackage.COMPOSITE_LOCATION__OWNED_LOCATIONS:
				return getOwnedLocations();
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
			case CorepatternsPackage.COMPOSITE_LOCATION__OWNED_LOCATIONS:
				getOwnedLocations().clear();
				getOwnedLocations().addAll((Collection<? extends IAtomicLocation>)newValue);
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
			case CorepatternsPackage.COMPOSITE_LOCATION__OWNED_LOCATIONS:
				getOwnedLocations().clear();
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
			case CorepatternsPackage.COMPOSITE_LOCATION__OWNED_LOCATIONS:
				return ownedLocations != null && !ownedLocations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#getAtomicContents()
   * @generated NOT
   */
  public List<? extends IAtomicLocation> getAtomicContents() {
    return Collections.unmodifiableList(getOwnedLocations());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   * @generated NOT
   */
  public boolean supportsAddition() {
    List<? extends IAtomicLocation> locations = getOwnedLocations();
    if (locations.isEmpty())
      return false;
    for (IAtomicLocation child : locations) {
      if (!child.supportsAddition())
        return false;
    }
    return true;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   * @generated NOT
   */
  public boolean supportsMerge() {
    List<? extends IAtomicLocation> locations = getOwnedLocations();
    if (locations.isEmpty())
      return false;
    for (IAtomicLocation child : locations) {
      if (!child.supportsMerge())
        return false;
    }
    return true;
  }
  
} //CompositeLocationImpl
