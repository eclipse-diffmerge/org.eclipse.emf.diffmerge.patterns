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


import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;


/**
 * A simple implementation of IMultiElementLocation.
 * @author Olivier Constant
 */
public class BasicElementLocation extends AbstractElementRelativeLocation implements IElementLocation {
  
  /**
   * Constructor
   * @param element_p a non-null element
   */
  public BasicElementLocation(EObject element_p) {
    super(element_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   */
  public boolean supportsAddition() {
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   */
  public boolean supportsMerge() {
    return true;
  }
  
  /**
   * @see java.lang.Object#toString()
   */
  @Override
  @SuppressWarnings("nls")
  public String toString() {
    return getClass().getSimpleName() + ": " + getElement();
  }
  
}
