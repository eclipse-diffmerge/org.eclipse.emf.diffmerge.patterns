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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IRoleApplicabilityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternRoleImpl;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementLocation;
import org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine;
import org.eclipse.emf.diffmerge.patterns.templates.gen.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.gen.TemplatePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Pattern Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#getAdditionKind <em>Addition Kind</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#isExclusive <em>Exclusive</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#getAdditionDerivationRule <em>Addition Derivation Rule</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#getMergeDerivationRule <em>Merge Derivation Rule</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#getPreferredContainment <em>Preferred Containment</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternRoleImpl#getTemplateElements <em>Template Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplatePatternRoleImpl extends AbstractPatternRoleImpl implements TemplatePatternRole {
	/**
	 * The default value of the '{@link #getAdditionKind() <em>Addition Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionKind()
	 * @generated
	 * @ordered
	 */
	protected static final AdditionKind ADDITION_KIND_EDEFAULT = AdditionKind.FORBIDDEN;

	/**
	 * The cached value of the '{@link #getAdditionKind() <em>Addition Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionKind()
	 * @generated
	 * @ordered
	 */
	protected AdditionKind additionKind = ADDITION_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRoleConstraint> constraints;

	/**
	 * The default value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXCLUSIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean exclusive = EXCLUSIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdditionDerivationRule() <em>Addition Derivation Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionDerivationRule()
	 * @generated
	 * @ordered
	 */
	protected AbstractRoleDerivationRule additionDerivationRule;

	/**
	 * The cached value of the '{@link #getMergeDerivationRule() <em>Merge Derivation Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergeDerivationRule()
	 * @generated
	 * @ordered
	 */
	protected AbstractRoleDerivationRule mergeDerivationRule;

	/**
	 * The cached value of the '{@link #getPreferredContainment() <em>Preferred Containment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferredContainment()
	 * @generated
	 * @ordered
	 */
	protected EReference preferredContainment;

	/**
	 * The cached value of the '{@link #getTemplateElements() <em>Template Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> templateElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePatternRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditionKind getAdditionKind() {
		return additionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionKind(AdditionKind newAdditionKind) {
		AdditionKind oldAdditionKind = additionKind;
		additionKind = newAdditionKind == null ? ADDITION_KIND_EDEFAULT : newAdditionKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_KIND, oldAdditionKind, additionKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatePattern getPattern() {
		if (eContainerFeatureID() != TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN) return null;
		return (TemplatePattern)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(TemplatePattern newPattern, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPattern, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(TemplatePattern newPattern) {
		if (newPattern != eInternalContainer() || (eContainerFeatureID() != TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN && newPattern != null)) {
			if (EcoreUtil.isAncestor(this, newPattern))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES, TemplatePattern.class, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractRoleDerivationRule getAdditionDerivationRule() {
		return additionDerivationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdditionDerivationRule(AbstractRoleDerivationRule newAdditionDerivationRule, NotificationChain msgs) {
		AbstractRoleDerivationRule oldAdditionDerivationRule = additionDerivationRule;
		additionDerivationRule = newAdditionDerivationRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE, oldAdditionDerivationRule, newAdditionDerivationRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionDerivationRule(AbstractRoleDerivationRule newAdditionDerivationRule) {
		if (newAdditionDerivationRule != additionDerivationRule) {
			NotificationChain msgs = null;
			if (additionDerivationRule != null)
				msgs = ((InternalEObject)additionDerivationRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE, null, msgs);
			if (newAdditionDerivationRule != null)
				msgs = ((InternalEObject)newAdditionDerivationRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE, null, msgs);
			msgs = basicSetAdditionDerivationRule(newAdditionDerivationRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE, newAdditionDerivationRule, newAdditionDerivationRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractRoleDerivationRule getMergeDerivationRule() {
		return mergeDerivationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMergeDerivationRule(AbstractRoleDerivationRule newMergeDerivationRule, NotificationChain msgs) {
		AbstractRoleDerivationRule oldMergeDerivationRule = mergeDerivationRule;
		mergeDerivationRule = newMergeDerivationRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE, oldMergeDerivationRule, newMergeDerivationRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMergeDerivationRule(AbstractRoleDerivationRule newMergeDerivationRule) {
		if (newMergeDerivationRule != mergeDerivationRule) {
			NotificationChain msgs = null;
			if (mergeDerivationRule != null)
				msgs = ((InternalEObject)mergeDerivationRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE, null, msgs);
			if (newMergeDerivationRule != null)
				msgs = ((InternalEObject)newMergeDerivationRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE, null, msgs);
			msgs = basicSetMergeDerivationRule(newMergeDerivationRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE, newMergeDerivationRule, newMergeDerivationRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreferredContainment() {
		if (preferredContainment != null && preferredContainment.eIsProxy()) {
			InternalEObject oldPreferredContainment = (InternalEObject)preferredContainment;
			preferredContainment = (EReference)eResolveProxy(oldPreferredContainment);
			if (preferredContainment != oldPreferredContainment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT, oldPreferredContainment, preferredContainment));
			}
		}
		return preferredContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetPreferredContainment() {
		return preferredContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferredContainment(EReference newPreferredContainment) {
		EReference oldPreferredContainment = preferredContainment;
		preferredContainment = newPreferredContainment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT, oldPreferredContainment, preferredContainment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTemplateElements() {
		if (templateElements == null) {
			templateElements = new EObjectResolvingEList<EObject>(EObject.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS);
		}
		return templateElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExclusive() {
		return exclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExclusive(boolean newExclusive) {
		boolean oldExclusive = exclusive;
		exclusive = newExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__EXCLUSIVE, oldExclusive, exclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRoleConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<AbstractRoleConstraint>(AbstractRoleConstraint.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS, TemplatepatternsPackage.ABSTRACT_ROLE_CONSTRAINT__ROLE);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPattern((TemplatePattern)otherEnd, msgs);
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN:
				return basicSetPattern(null, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE:
				return basicSetAdditionDerivationRule(null, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE:
				return basicSetMergeDerivationRule(null, msgs);
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN:
				return eInternalContainer().eInverseRemove(this, TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES, TemplatePattern.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("boxing")
  @Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_KIND:
				return getAdditionKind();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS:
				return getConstraints();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__EXCLUSIVE:
				return isExclusive();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN:
				return getPattern();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE:
				return getAdditionDerivationRule();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE:
				return getMergeDerivationRule();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT:
				if (resolve) return getPreferredContainment();
				return basicGetPreferredContainment();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS:
				return getTemplateElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "boxing" })
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_KIND:
				setAdditionKind((AdditionKind)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends AbstractRoleConstraint>)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__EXCLUSIVE:
				setExclusive((Boolean)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN:
				setPattern((TemplatePattern)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE:
				setAdditionDerivationRule((AbstractRoleDerivationRule)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE:
				setMergeDerivationRule((AbstractRoleDerivationRule)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT:
				setPreferredContainment((EReference)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS:
				getTemplateElements().clear();
				getTemplateElements().addAll((Collection<? extends EObject>)newValue);
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_KIND:
				setAdditionKind(ADDITION_KIND_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS:
				getConstraints().clear();
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__EXCLUSIVE:
				setExclusive(EXCLUSIVE_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN:
				setPattern((TemplatePattern)null);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE:
				setAdditionDerivationRule((AbstractRoleDerivationRule)null);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE:
				setMergeDerivationRule((AbstractRoleDerivationRule)null);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT:
				setPreferredContainment((EReference)null);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS:
				getTemplateElements().clear();
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_KIND:
				return additionKind != ADDITION_KIND_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__EXCLUSIVE:
				return exclusive != EXCLUSIVE_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN:
				return getPattern() != null;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE:
				return additionDerivationRule != null;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE:
				return mergeDerivationRule != null;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT:
				return preferredContainment != null;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS:
				return templateElements != null && !templateElements.isEmpty();
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
		result.append(" (additionKind: "); //$NON-NLS-1$
		result.append(additionKind);
		result.append(", exclusive: "); //$NON-NLS-1$
		result.append(exclusive);
		result.append(')');
		return result.toString();
	}
	
  /**
   * Return whether this role accepts that its template elements be added
   * @generated NOT
   */
  public boolean acceptsAddition() {
    return getAdditionKind() != AdditionKind.FORBIDDEN;
  }
  
  /**
   * Return whether this role accepts that its template elements be merged
   * @generated NOT
   */
	public boolean acceptsMerge() {
	  return true;
	}
	
  /**
   * Return whether this role can be derived when the pattern is being applied
   * @param forMerge_p whether derivation is considered for application by merge or by addition
   * @generated NOT
   */
  public boolean isDerivable(boolean forMerge_p) {
    return forMerge_p? getMergeDerivationRule() != null: getAdditionDerivationRule() != null;
  }
  
  /**
   * Return whether this role corresponds to more than one element
   * @generated NOT
   */
  public boolean isMany() {
    return getTemplateElements().size() > 1;
  }
  
  /**
	 * Return whether this role requires to be bound to exactly one location
	 * @generated NOT
	 */
	public boolean isUniLocation() {
	  return true;
	}
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole#checkApplicability(org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation, org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   * @generated NOT
   */
  public IRoleApplicabilityStatus checkApplicability(ILocation location_p,
      IPatternApplication context_p) {
    if (location_p == null)
      return checkOptional();
    List<? extends IAtomicLocation> atomicLocations = location_p.getAtomicContents();
    int locationsNb = atomicLocations.size();
    if (acceptsMerge() && location_p.supportsMerge()) {
      // Check merge applicability
      EObject templateElement = getTemplateElements().isEmpty()? null : getTemplateElements().get(0);
      for (IAtomicLocation atomicLocation : atomicLocations) {
        if (atomicLocation instanceof IElementLocation) {
          IRoleApplicabilityStatus atomicStatus = checkAtomicMergeApplicability(
              (IElementLocation)atomicLocation, templateElement);
          if (!atomicStatus.isOk())
            return atomicStatus;
        }
      }
      return SimpleStatus.SUCCESS;
    } else if (acceptsAddition() && location_p.supportsAddition()) {
      // Check addition applicability
      if (locationsNb == 1) {
        IAtomicLocation atomicLocation = atomicLocations.get(0);
        for (EObject templateRoot : getTemplateElements()) {
          IRoleApplicabilityStatus atomicStatus =
            checkAtomicAdditionApplicability(atomicLocation, templateRoot);
          if (!atomicStatus.isOk())
            return atomicStatus;
        }
        return SimpleStatus.SUCCESS;
      }
      return new SimpleStatus(false,
          Messages.TemplatePatternRoleImpl_WrongNumberOfLocations);
    }
    // Inconsistent nature of location w.r.t. role
    return new SimpleStatus(false,
        Messages.TemplatePatternRoleImpl_UnsuitableLocation);
  }
  
	/**
   * Check applicability of a single root template element on an atomic location
   * in the respective of adding the template element.
   * Precondition: location_p.supportsAddition()
   * @param location_p a non-null atomic location which supports addition
   * @param rootTemplateElement_p a non-null element
   * @return a non-null status
   * @generated NOT
   */
  private IRoleApplicabilityStatus checkAtomicAdditionApplicability(
      IAtomicLocation location_p, EObject rootTemplateElement_p) {
    IRoleApplicabilityStatus result;
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine != null)
      result = engine.checkAtomicAdditionApplicability(location_p, rootTemplateElement_p);
    else
      result = TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return result;
  }
  
  /**
   * Check applicability of a single root template element on an atomic location
   * in the perspective of merging the template element
   * @param location_p a non-null atomic location which supports merge
   * @param rootTemplateElement_p a non-null element
   * @return a non-null status
   * @generated NOT
   */
  private IRoleApplicabilityStatus checkAtomicMergeApplicability(
      IElementRelativeLocation location_p, EObject rootTemplateElement_p) {
    IRoleApplicabilityStatus result;
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine != null)
      result = engine.checkAtomicMergeApplicability(location_p, rootTemplateElement_p);
    else
      result = TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole#checkCompleteApplicability(org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation, org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   * @generated NOT
   */
  public IRoleApplicabilityStatus checkCompleteApplicability(ILocation location_p,
      IPatternApplication context_p) {
    IRoleApplicabilityStatus result = null;
    if (isExclusive())
      result = checkExclusiveness(location_p, context_p);
    if (result == null || result.isOk())
      result = checkApplicability(location_p, context_p);
    return result;
  }
  
  /**
   * Return a status stating whether the given location conforms to the constraints
   * of the role
   * @param location_p a potentially null location (null yields a successful status)
   * @return a non-null status
   * @generated NOT
   */
  public IPatternConformityStatus checkConstraints(ILocation location_p) {
    if (location_p != null) {
      for (AbstractRoleConstraint constraint : getConstraints()) {
        IPatternConformityStatus status = constraint.check(location_p);
        if (!status.isOk())
          return status;
      }
    }
    return SimpleStatus.SUCCESS;
  }
  
  /**
   * Return whether the given location conforms to this role being exclusive
   * in the context of the given application
   * @param location_p a potentially null location
   * @param context_p a non-null application
   * @return a non-null status
   * @generated NOT
   */
  private IRoleApplicabilityStatus checkExclusiveness(ILocation location_p,
      IPatternApplication context_p) {
    if (location_p != null && location_p.supportsMerge()) {
      Collection<EObject> locationElements =
        LocationsUtil.getMergeTargets(location_p);
      if (!locationElements.isEmpty()) {
        for (IPatternRole role : context_p.getPattern().getRoles()) {
          if (role != this) {
            ILocation allocated = context_p.getLocation(role);
            for (EObject roleElement :
              LocationsUtil.getMergeTargets(allocated)) {
              if (locationElements.contains(roleElement))
                return new SimpleStatus(false, "Role is exclusive"); //$NON-NLS-1$
            }
          }
        }
      }
    }
    return SimpleStatus.SUCCESS;
  }
  
  /**
   * Return a status stating whether the role can be applied to no location
   * @return a non-null status
   * @generated NOT
   */
  private IRoleApplicabilityStatus checkOptional() {
    IRoleApplicabilityStatus result = new SimpleStatus(false, "Role is not optional"); //$NON-NLS-1$
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole#deriveCandidateLocations(IPatternApplication, boolean)
   * @generated NOT
   */
  public List<ILocation> deriveCandidateLocations(IPatternApplication context_p,
      boolean forAddition_p) {
    List<ILocation> result = new ArrayList<ILocation>();
    AbstractRoleDerivationRule rule = forAddition_p? getAdditionDerivationRule():
      getMergeDerivationRule();
    if (rule != null) {
      List<EObject> derivedElements = rule.deriveCandidateElements(context_p);
      if (derivedElements != null) {
        for (EObject derivedElement : derivedElements) {
          result.add(new BasicElementLocation(derivedElement));
        }
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole#isGeneric()
   * @generated NOT
   */
  public boolean isGeneric() {
    return !getPattern().getMultiElements().containsAll(getTemplateElements());
  }
  
} //TemplatePatternRoleImpl
