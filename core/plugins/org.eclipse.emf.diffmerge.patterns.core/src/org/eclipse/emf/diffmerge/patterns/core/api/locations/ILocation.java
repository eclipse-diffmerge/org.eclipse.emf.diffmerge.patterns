/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
