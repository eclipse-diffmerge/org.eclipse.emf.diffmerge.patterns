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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine;
import org.eclipse.emf.diffmerge.patterns.templates.gen.TemplatePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Textual Role Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleConstraintImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TextualRoleConstraintImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextualRoleConstraintImpl extends AbstractTextualQueryImpl implements TextualRoleConstraint {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextualRoleConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.TEXTUAL_ROLE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatePatternRole getRole() {
		if (eContainerFeatureID() != TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE) return null;
		return (TemplatePatternRole)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRole(TemplatePatternRole newRole, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRole, TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(TemplatePatternRole newRole) {
		if (newRole != eInternalContainer() || (eContainerFeatureID() != TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE && newRole != null)) {
			if (EcoreUtil.isAncestor(this, newRole))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRole != null)
				msgs = ((InternalEObject)newRole).eInverseAdd(this, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS, TemplatePatternRole.class, msgs);
			msgs = basicSetRole(newRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE, newRole, newRole));
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint#check(org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation)
	 * @generated NOT
	 */
	public IPatternConformityStatus check(ILocation location) {
    List<? extends IAtomicLocation> atomicLocations = location.getAtomicContents();
    for (IAtomicLocation atomicLocation : atomicLocations) {
      if (atomicLocation instanceof IElementLocation) {
        IElementLocation elementLocation = (IElementLocation)atomicLocation;
        EObject element = elementLocation.getElement();
        if (element != null) {
          IPatternConformityStatus status = checkElement(element);
          if (!status.isOk())
            return status;
        }
      } else if (atomicLocation instanceof IElementMappingLocation) {
        IElementMappingLocation mappingLocation = (IElementMappingLocation)atomicLocation;
        IPatternRole role = getRole();
        if (role != null && role.getPattern() != null) {
          Collection<EObject> patternElements =
            mappingLocation.getPatternElements(role.getPattern());
          List<EObject> modelElements = new ModelsUtil.RList<EObject>();
          for (EObject patternElement : patternElements) {
            EObject modelElement = mappingLocation.getElement(patternElement);
            if (modelElement != null)
              modelElements.add(modelElement);
          }
          IPatternConformityStatus status = checkElements(modelElements);
          if (!status.isOk())
            return status;
        }
      }
    }
    return new SimpleStatus(true, getSpecification());
	}
	
  /**
   * Check whether the given element conforms to this constraint
   * @param element_p a non-null element
   * @return a non-null status
   * @generated NOT
   */
  private IPatternConformityStatus checkElement(EObject element_p) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine == null)
      return TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return engine.checkConstraint(this, element_p);
  }
  
  /**
   * Check whether the given collection of elements conforms to this constraint
   * @param elements_p a non-null collection
   * @return a non-null status
   * @generated NOT
   */
  private IPatternConformityStatus checkElements(Collection<? extends EObject> elements_p) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine == null)
      return TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return engine.checkConstraintOnCollection(this, elements_p);
  }
  
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRole((TemplatePatternRole)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE:
				return basicSetRole(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE:
				return eInternalContainer().eInverseRemove(this, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS, TemplatePatternRole.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ID:
				return getId();
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE:
				return getRole();
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
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ID:
				setId((String)newValue);
				return;
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE:
				setRole((TemplatePatternRole)newValue);
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
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ID:
				setId(ID_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE:
				setRole((TemplatePatternRole)null);
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
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE:
				return getRole() != null;
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
		if (baseClass == IIdentifiedElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractIdentifiedElement.class) {
			switch (derivedFeatureID) {
				case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ID: return CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID;
				default: return -1;
			}
		}
		if (baseClass == AbstractRoleSpecification.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractRoleConstraint.class) {
			switch (derivedFeatureID) {
				case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE: return TemplatepatternsPackage.ABSTRACT_ROLE_CONSTRAINT__ROLE;
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
		if (baseClass == IIdentifiedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractIdentifiedElement.class) {
			switch (baseFeatureID) {
				case CorepatternsPackage.ABSTRACT_IDENTIFIED_ELEMENT__ID: return TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ID;
				default: return -1;
			}
		}
		if (baseClass == AbstractRoleSpecification.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractRoleConstraint.class) {
			switch (baseFeatureID) {
				case TemplatepatternsPackage.ABSTRACT_ROLE_CONSTRAINT__ROLE: return TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT__ROLE;
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
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //TextualRoleConstraintImpl
