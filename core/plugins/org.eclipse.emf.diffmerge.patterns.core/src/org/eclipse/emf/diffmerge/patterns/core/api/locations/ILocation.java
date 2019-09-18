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
package org.eclipse.emf.diffmerge.patterns.core.api.locations;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;


/**
 * A location somewhere in a model which may contribute to the definition of
 * a pattern application.
 * @author Olivier Constant
 */
public interface ILocation extends IPatternInstanceMarker {
  
  /**
   * Return the atomic locations which are contained or represented by this location
   * @return a non-null, potentially empty, unmodifiable list
   */
  List<? extends IAtomicLocation> getAtomicContents();
  
  /**
   * Return whether the location may be used for adding elements
   */
  boolean supportsAddition();
  
  /**
   * Return whether the location may be used for merging elements
   */
  boolean supportsMerge();
  
}
