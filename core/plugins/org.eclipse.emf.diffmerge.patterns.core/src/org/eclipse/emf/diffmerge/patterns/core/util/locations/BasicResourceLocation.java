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
package org.eclipse.emf.diffmerge.patterns.core.util.locations;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation;


/**
 * A simple implementation of IResourceLocation.
 * @author Olivier Constant
 */
public class BasicResourceLocation implements IResourceLocation {
  
  /** The resource */
  private final Resource _resource;
  
  /**
   * Constructor
   * @param resource_p the non-null resource
   */
  public BasicResourceLocation(Resource resource_p) {
    _resource = resource_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#getAtomicContents()
   */
  public List<IAtomicLocation> getAtomicContents() {
    return Collections.singletonList((IAtomicLocation)this);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation#getResource()
   */
  public Resource getResource() {
    return _resource;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   */
  public boolean supportsAddition() {
    return true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   */
  public boolean supportsMerge() {
    return false;
  }
  
  /**
   * @see java.lang.Object#toString()
   */
  @Override
  @SuppressWarnings("nls")
  public String toString() {
    return getClass().getSimpleName() + ": " + getResource();
  }
  
}
