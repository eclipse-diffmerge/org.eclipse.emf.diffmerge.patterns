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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ResourceLocation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ResourceLocationImpl extends AbstractIDBasedAtomicLocationImpl implements ResourceLocation {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ResourceLocationImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonpatternsupportPackage.Literals.RESOURCE_LOCATION;
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation#getResource()
   * @generated NOT
   */
  public Resource getResource() {
    Resource result = null;
    Resource ownResource = eResource();
    if (ownResource != null && ownResource.getResourceSet() != null) {
      ResourceSet rs = eResource().getResourceSet();
      try {
        URI uri = URI.createURI(getElementId());
        result = rs.getResource(uri, false);
      } catch (Exception e) {
        // Failure: return null
      }
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   * @generated NOT
   */
  public boolean supportsAddition() {
    return true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   * @generated NOT
   */
  public boolean supportsMerge() {
    return false;
  }
  
} //ResourceLocationImpl
