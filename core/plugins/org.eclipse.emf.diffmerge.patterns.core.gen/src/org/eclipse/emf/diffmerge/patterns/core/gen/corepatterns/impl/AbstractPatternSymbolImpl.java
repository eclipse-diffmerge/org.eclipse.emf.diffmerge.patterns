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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Pattern Symbol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternSymbolImpl#getRepositoryId <em>Repository Id</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternSymbolImpl#getPatternId <em>Pattern Id</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternSymbolImpl#getLastPath <em>Last Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractPatternSymbolImpl extends AbstractNamedElementImpl implements AbstractPatternSymbol {
	/**
	 * The default value of the '{@link #getRepositoryId() <em>Repository Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryId()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryId() <em>Repository Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryId()
	 * @generated
	 * @ordered
	 */
	protected String repositoryId = REPOSITORY_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPatternId() <em>Pattern Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternId()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPatternId() <em>Pattern Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternId()
	 * @generated
	 * @ordered
	 */
	protected String patternId = PATTERN_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastPath() <em>Last Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastPath() <em>Last Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastPath()
	 * @generated
	 * @ordered
	 */
	protected String lastPath = LAST_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractPatternSymbolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorepatternsPackage.Literals.ABSTRACT_PATTERN_SYMBOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryId() {
		return repositoryId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryId(String newRepositoryId) {
		String oldRepositoryId = repositoryId;
		repositoryId = newRepositoryId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID, oldRepositoryId, repositoryId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPatternId() {
		return patternId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternId(String newPatternId) {
		String oldPatternId = patternId;
		patternId = newPatternId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__PATTERN_ID, oldPatternId, patternId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastPath() {
		return lastPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastPath(String newLastPath) {
		String oldLastPath = lastPath;
		lastPath = newLastPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__LAST_PATH, oldLastPath, lastPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID:
				return getRepositoryId();
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__PATTERN_ID:
				return getPatternId();
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__LAST_PATH:
				return getLastPath();
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
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID:
				setRepositoryId((String)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__PATTERN_ID:
				setPatternId((String)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__LAST_PATH:
				setLastPath((String)newValue);
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
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID:
				setRepositoryId(REPOSITORY_ID_EDEFAULT);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__PATTERN_ID:
				setPatternId(PATTERN_ID_EDEFAULT);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__LAST_PATH:
				setLastPath(LAST_PATH_EDEFAULT);
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
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID:
				return REPOSITORY_ID_EDEFAULT == null ? repositoryId != null : !REPOSITORY_ID_EDEFAULT.equals(repositoryId);
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__PATTERN_ID:
				return PATTERN_ID_EDEFAULT == null ? patternId != null : !PATTERN_ID_EDEFAULT.equals(patternId);
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__LAST_PATH:
				return LAST_PATH_EDEFAULT == null ? lastPath != null : !LAST_PATH_EDEFAULT.equals(lastPath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (repositoryId: "); //$NON-NLS-1$
		result.append(repositoryId);
		result.append(", patternId: "); //$NON-NLS-1$
		result.append(patternId);
		result.append(", lastPath: "); //$NON-NLS-1$
		result.append(lastPath);
		result.append(')');
		return result.toString();
	}

} //AbstractPatternSymbolImpl
