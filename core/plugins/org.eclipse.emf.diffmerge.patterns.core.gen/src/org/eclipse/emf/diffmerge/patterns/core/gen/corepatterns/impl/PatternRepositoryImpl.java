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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.PatternRepositoryImpl#getPatterns <em>Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternRepositoryImpl extends AbstractNamedElementImpl implements PatternRepository {
	/**
	 * The cached value of the '{@link #getPatterns() <em>Patterns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatterns()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractPattern> patterns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorepatternsPackage.Literals.PATTERN_REPOSITORY;
	}

	/**
   * Return the path (URI) where the repository is located
   * @return a potentially null string
   * @generated NOT
   */
  public String getPath() {
    String result = null;
    URI uri = EcoreUtil.getURI(this);
    if (uri != null)
      result = uri.toString();
    return result;
  }
  
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractPattern> getPatterns() {
		if (patterns == null) {
			patterns = new EObjectContainmentEList<AbstractPattern>(AbstractPattern.class, this, CorepatternsPackage.PATTERN_REPOSITORY__PATTERNS);
		}
		return patterns;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository#getPattern(org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol)
	 * @generated NOT
	 */
	public AbstractPattern getPattern(IPatternSymbol symbol) {
	  AbstractPattern result = null;
	  // This implementation assumes that a pattern repository is not fragmented
	  Resource resource = eResource();
	  if (resource != null) {
	    EObject identified = resource.getEObject(symbol.getPatternId());
	    if (identified instanceof AbstractPattern)
	      result = (AbstractPattern)identified;
	  }
	  return result;
	}

	/**
	 * Return the first pattern that has the given name
	 * @param name a non-null string
	 * @return a potentially null pattern
	 * @generated NOT
	 */
	public AbstractPattern getPatternByName(String name) {
	  for (AbstractPattern pattern : getPatterns()) {
	    if (name.equals(pattern.getName()))
	      return pattern;
	  }
	  return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorepatternsPackage.PATTERN_REPOSITORY__PATTERNS:
				return ((InternalEList<?>)getPatterns()).basicRemove(otherEnd, msgs);
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
			case CorepatternsPackage.PATTERN_REPOSITORY__PATTERNS:
				return getPatterns();
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
			case CorepatternsPackage.PATTERN_REPOSITORY__PATTERNS:
				getPatterns().clear();
				getPatterns().addAll((Collection<? extends AbstractPattern>)newValue);
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
			case CorepatternsPackage.PATTERN_REPOSITORY__PATTERNS:
				getPatterns().clear();
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
			case CorepatternsPackage.PATTERN_REPOSITORY__PATTERNS:
				return patterns != null && !patterns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PatternRepositoryImpl
