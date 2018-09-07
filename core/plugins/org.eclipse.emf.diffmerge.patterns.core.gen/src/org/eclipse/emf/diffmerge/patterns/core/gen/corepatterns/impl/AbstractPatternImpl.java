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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicPatternSymbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl#getLastModificationStamp <em>Last Modification Stamp</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl#getExecutionEnvironments <em>Execution Environments</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl#isTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractPatternImpl extends AbstractNamedElementImpl implements AbstractPattern {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuthors() <em>Authors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthors()
	 * @generated
	 * @ordered
	 */
	protected EList<String> authors;

	/**
	 * The default value of the '{@link #getLastModificationStamp() <em>Last Modification Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModificationStamp()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_MODIFICATION_STAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastModificationStamp() <em>Last Modification Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModificationStamp()
	 * @generated
	 * @ordered
	 */
	protected String lastModificationStamp = LAST_MODIFICATION_STAMP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecutionEnvironments() <em>Execution Environments</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionEnvironments()
	 * @generated
	 * @ordered
	 */
	protected EList<String> executionEnvironments;

	/**
	 * The default value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEMPLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected boolean template = TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorepatternsPackage.Literals.ABSTRACT_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAuthors() {
		if (authors == null) {
			authors = new EDataTypeUniqueEList<String>(String.class, this, CorepatternsPackage.ABSTRACT_PATTERN__AUTHORS);
		}
		return authors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastModificationStamp() {
		return lastModificationStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModificationStamp(String newLastModificationStamp) {
		String oldLastModificationStamp = lastModificationStamp;
		lastModificationStamp = newLastModificationStamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP, oldLastModificationStamp, lastModificationStamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExecutionEnvironments() {
		if (executionEnvironments == null) {
			executionEnvironments = new EDataTypeUniqueEList<String>(String.class, this, CorepatternsPackage.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS);
		}
		return executionEnvironments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(boolean newTemplate) {
		boolean oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN__TEMPLATE, oldTemplate, template));
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern#getRole(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol)
	 * @generated NOT
	 */
	public AbstractPatternRole getRole(IPatternRoleSymbol symbol) {
	  for (IPatternRole role : getRoles()) {
	    if (role instanceof AbstractPatternRole &&
	        role.getId().equals(symbol.getRoleId()))
	      return (AbstractPatternRole)role;
	  }
	  return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION:
				return getDescription();
			case CorepatternsPackage.ABSTRACT_PATTERN__VERSION:
				return getVersion();
			case CorepatternsPackage.ABSTRACT_PATTERN__AUTHORS:
				return getAuthors();
			case CorepatternsPackage.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP:
				return getLastModificationStamp();
			case CorepatternsPackage.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS:
				return getExecutionEnvironments();
			case CorepatternsPackage.ABSTRACT_PATTERN__TEMPLATE:
				return isTemplate();
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
			case CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__VERSION:
				setVersion((String)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__AUTHORS:
				getAuthors().clear();
				getAuthors().addAll((Collection<? extends String>)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP:
				setLastModificationStamp((String)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS:
				getExecutionEnvironments().clear();
				getExecutionEnvironments().addAll((Collection<? extends String>)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__TEMPLATE:
				setTemplate((Boolean)newValue);
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
			case CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__AUTHORS:
				getAuthors().clear();
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP:
				setLastModificationStamp(LAST_MODIFICATION_STAMP_EDEFAULT);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS:
				getExecutionEnvironments().clear();
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN__TEMPLATE:
				setTemplate(TEMPLATE_EDEFAULT);
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
			case CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorepatternsPackage.ABSTRACT_PATTERN__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CorepatternsPackage.ABSTRACT_PATTERN__AUTHORS:
				return authors != null && !authors.isEmpty();
			case CorepatternsPackage.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP:
				return LAST_MODIFICATION_STAMP_EDEFAULT == null ? lastModificationStamp != null : !LAST_MODIFICATION_STAMP_EDEFAULT.equals(lastModificationStamp);
			case CorepatternsPackage.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS:
				return executionEnvironments != null && !executionEnvironments.isEmpty();
			case CorepatternsPackage.ABSTRACT_PATTERN__TEMPLATE:
				return template != TEMPLATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IDescribedElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractDescribedElement.class) {
			switch (derivedFeatureID) {
				case CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION: return CorepatternsPackage.ABSTRACT_DESCRIBED_ELEMENT__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == IVersionedElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractVersionedElement.class) {
			switch (derivedFeatureID) {
				case CorepatternsPackage.ABSTRACT_PATTERN__VERSION: return CorepatternsPackage.ABSTRACT_VERSIONED_ELEMENT__VERSION;
				default: return -1;
			}
		}
		if (baseClass == IPattern.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IDescribedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractDescribedElement.class) {
			switch (baseFeatureID) {
				case CorepatternsPackage.ABSTRACT_DESCRIBED_ELEMENT__DESCRIPTION: return CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == IVersionedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractVersionedElement.class) {
			switch (baseFeatureID) {
				case CorepatternsPackage.ABSTRACT_VERSIONED_ELEMENT__VERSION: return CorepatternsPackage.ABSTRACT_PATTERN__VERSION;
				default: return -1;
			}
		}
		if (baseClass == IPattern.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", version: "); //$NON-NLS-1$
		result.append(version);
		result.append(", authors: "); //$NON-NLS-1$
		result.append(authors);
		result.append(", lastModificationStamp: "); //$NON-NLS-1$
		result.append(lastModificationStamp);
		result.append(", executionEnvironments: "); //$NON-NLS-1$
		result.append(executionEnvironments);
		result.append(", template: "); //$NON-NLS-1$
		result.append(template);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#getRepository()
	 * @generated NOT
	 */
	public IPatternRepository getRepository() {
	  IPatternRepository result = null;
	  EObject container = eContainer();
	  if (container instanceof IPatternRepository)
	    result = (IPatternRepository)container;
	  return result;
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#getSymbol()
   * @generated NOT
   */
  public IPatternSymbol getSymbol() {
    IPatternSymbol result = null;
    IPatternRepository repository = getRepository();
    if (repository != null) {
      String repositoryId = repository.getId();
      String patternId = getId();
      if (repositoryId != null && patternId != null)
        result = new BasicPatternSymbol(
            repositoryId, patternId, getName(), EcoreUtil.getURI(this).toString());
    }
    return result;
  }

} //AbstractPatternImpl
