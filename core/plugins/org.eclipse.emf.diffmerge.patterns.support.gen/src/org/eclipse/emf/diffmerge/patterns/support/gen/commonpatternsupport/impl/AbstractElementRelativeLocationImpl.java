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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Element Relative Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractElementRelativeLocationImpl extends AbstractIDBasedAtomicLocationImpl implements AbstractElementRelativeLocation {

  /**
   * A cache for the element
   * @generated NOT
   */
  private transient EObject _element = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AbstractElementRelativeLocationImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonpatternsupportPackage.Literals.ABSTRACT_ELEMENT_RELATIVE_LOCATION;
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.util.locations.AbstractElementRelativeLocation#getElement()
   * @generated NOT
   */
  public EObject getElement(Object context_p) {
    // Set in cache if needed
    if (getElementId() != null && _element == null){
      IIdProvider idProvider = CorePatternsPlugin.getDefault().getIdProvider();
      if(idProvider != null){
        _element = idProvider.getByIdInContext(getElementId(), this);
        if(_element == null)
          _element = idProvider.getByIdInContext(getElementId(), context_p);
      }   
    }

    // Result is null if element is not in a model
    EObject result = null;
    if (_element != null &&
        CorePatternsPlugin.getDefault().getDeleteOperationProvider().isInModel(_element))
      result = _element;
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.util.locations.AbstractElementRelativeLocation#getElement()
   * @generated NOT
   */
  public EObject getElement() {
    // Set in cache if needed
    if (getElementId() != null && _element == null){
      IIdProvider idProvider = CorePatternsPlugin.getDefault().getIdProvider();
      if(idProvider != null){
        _element = idProvider.getByIdInContext(getElementId(), this);
      }   
    }

    // Result is null if element is not in a model
    EObject result = null;
    if (_element != null &&
        CorePatternsPlugin.getDefault().getDeleteOperationProvider().isInModel(_element))
      result = _element;
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl.AbstractIDBasedAtomicLocationImpl#setElementId(java.lang.String)
   * @generated NOT
   */
  @Override
  public void setElementId(String newElementId) {
    super.setElementId(newElementId);
    // Enforce consistency with element
    _element = null;
  }


} //AbstractElementRelativeLocationImpl
