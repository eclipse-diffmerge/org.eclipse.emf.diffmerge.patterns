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
package org.eclipse.emf.diffmerge.patterns.core.util.locations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation;


/**
 * A simple implementation of ICompositeLocation.
 * @author Olivier Constant
 */
public class BasicCompositeLocation implements ICompositeLocation {
  
  /** The sub-locations */
  private final List<IAtomicLocation> _locations;
  
  /**
   * Constructor
   */
  public BasicCompositeLocation() {
    _locations = new ArrayList<IAtomicLocation>();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#getAtomicContents()
   */
  public List<IAtomicLocation> getAtomicContents() {
    return Collections.unmodifiableList(getOwnedLocations());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation#getOwnedLocations()
   */
  public List<IAtomicLocation> getOwnedLocations() {
    return _locations;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   */
  public boolean supportsAddition() {
    List<? extends IAtomicLocation> locations = getOwnedLocations();
    if (locations.isEmpty())
      return false;
    for (IAtomicLocation child : locations) {
      if (!child.supportsAddition())
        return false;
    }
    return true;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   */
  public boolean supportsMerge() {
    List<? extends IAtomicLocation> locations = getOwnedLocations();
    if (locations.isEmpty())
      return false;
    for (IAtomicLocation child : locations) {
      if (!child.supportsMerge())
        return false;
    }
    return true;
  }

}
