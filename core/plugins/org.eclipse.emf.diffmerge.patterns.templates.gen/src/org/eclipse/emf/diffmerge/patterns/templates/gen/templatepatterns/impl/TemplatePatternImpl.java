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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternImpl;
import org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine;
import org.eclipse.emf.diffmerge.patterns.templates.gen.TemplatePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl#getTemplateElements <em>Template Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl#getMultiElements <em>Multi Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternImpl#getLayoutData <em>Layout Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplatePatternImpl extends AbstractPatternImpl implements TemplatePattern {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplatePatternRole> roles;

	/**
	 * The cached value of the '{@link #getTemplateElements() <em>Template Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> templateElements;

	/**
	 * The cached value of the '{@link #getMultiElements() <em>Multi Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> multiElements;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected ImageSpecification image;

	/**
	 * The cached value of the '{@link #getLayoutData() <em>Layout Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutData()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, Layout> layoutData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.TEMPLATE_PATTERN;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageSpecification getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImage(ImageSpecification newImage, NotificationChain msgs) {
		ImageSpecification oldImage = image;
		image = newImage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE, oldImage, newImage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(ImageSpecification newImage) {
		if (newImage != image) {
			NotificationChain msgs = null;
			if (image != null)
				msgs = ((InternalEObject)image).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE, null, msgs);
			if (newImage != null)
				msgs = ((InternalEObject)newImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE, null, msgs);
			msgs = basicSetImage(newImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE, newImage, newImage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<EObject, Layout> getLayoutData() {
		if (layoutData == null) {
			layoutData = new EcoreEMap<EObject,Layout>(TemplatepatternsPackage.Literals.LAYOUT_ENTRY, LayoutEntryImpl.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN__LAYOUT_DATA);
		}
		return layoutData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplatePatternRole> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentWithInverseEList<TemplatePatternRole>(TemplatePatternRole.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES, TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__PATTERN);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTemplateElements() {
		if (templateElements == null) {
			templateElements = new EObjectContainmentEList<EObject>(EObject.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN__TEMPLATE_ELEMENTS);
		}
		return templateElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getMultiElements() {
		if (multiElements == null) {
			multiElements = new EObjectResolvingEList<EObject>(EObject.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN__MULTI_ELEMENTS);
		}
		return multiElements;
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRoles()).basicAdd(otherEnd, msgs);
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN__TEMPLATE_ELEMENTS:
				return ((InternalEList<?>)getTemplateElements()).basicRemove(otherEnd, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE:
				return basicSetImage(null, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN__LAYOUT_DATA:
				return ((InternalEList<?>)getLayoutData()).basicRemove(otherEnd, msgs);
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES:
				return getRoles();
			case TemplatepatternsPackage.TEMPLATE_PATTERN__TEMPLATE_ELEMENTS:
				return getTemplateElements();
			case TemplatepatternsPackage.TEMPLATE_PATTERN__MULTI_ELEMENTS:
				return getMultiElements();
			case TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE:
				return getImage();
			case TemplatepatternsPackage.TEMPLATE_PATTERN__LAYOUT_DATA:
				if (coreType) return getLayoutData();
				else return getLayoutData().map();
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends TemplatePatternRole>)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__TEMPLATE_ELEMENTS:
				getTemplateElements().clear();
				getTemplateElements().addAll((Collection<? extends EObject>)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__MULTI_ELEMENTS:
				getMultiElements().clear();
				getMultiElements().addAll((Collection<? extends EObject>)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE:
				setImage((ImageSpecification)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__LAYOUT_DATA:
				((EStructuralFeature.Setting)getLayoutData()).set(newValue);
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES:
				getRoles().clear();
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__TEMPLATE_ELEMENTS:
				getTemplateElements().clear();
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__MULTI_ELEMENTS:
				getMultiElements().clear();
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE:
				setImage((ImageSpecification)null);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__LAYOUT_DATA:
				getLayoutData().clear();
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
			case TemplatepatternsPackage.TEMPLATE_PATTERN__ROLES:
				return roles != null && !roles.isEmpty();
			case TemplatepatternsPackage.TEMPLATE_PATTERN__TEMPLATE_ELEMENTS:
				return templateElements != null && !templateElements.isEmpty();
			case TemplatepatternsPackage.TEMPLATE_PATTERN__MULTI_ELEMENTS:
				return multiElements != null && !multiElements.isEmpty();
			case TemplatepatternsPackage.TEMPLATE_PATTERN__IMAGE:
				return image != null;
			case TemplatepatternsPackage.TEMPLATE_PATTERN__LAYOUT_DATA:
				return layoutData != null && !layoutData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

		/**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#checkConformance(IPatternApplication, List)
   * @generated NOT
   */
  public IPatternConformityStatus checkConformance(IPatternApplication application_p, List<EStructuralFeature> ignoredFeatures_p) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine == null)
      return TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return engine.checkConformance(this, application_p, ignoredFeatures_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#createDataFor(IPatternInstance, Object)
   * @generated NOT
   */
  public IPatternData createDataFor(IPatternInstance instance_p, Object context_p) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine == null)
      return null;
    return engine.createPatternData(this, instance_p, context_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#fold(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance)
   * @generated NOT
   */
  public IModelTransformationStatus fold(IPatternInstance instance_p) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine == null)
      return TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return engine.fold(this, instance_p);
  }
  
  /**
   * Return whether the given template element is kept unique at unfolding time
   * @param element_p a non-null element
   * @generated NOT
   */
  public boolean isUnique(EObject element_p) {
    return getMultiElements().isEmpty() || !EcoreUtil.isAncestor(getMultiElements(), element_p) ;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#unfold(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance)
   * @generated NOT
   */
  public IModelTransformationStatus unfold(IPatternInstance instance_p) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine == null)
      return TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return engine.unfold(this, instance_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#updateModel(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification)
   * @generated NOT
   */
  public IModelTransformationStatus updateModel(IPatternInstance instance_p,
      IModelUpdateSpecification specification_p) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine == null)
      return TemplatePatternsPlugin.getDefault().getNoEngineStatus();
    return engine.updateModel(this, instance_p, specification_p);
  }

} //TemplatePatternImpl
