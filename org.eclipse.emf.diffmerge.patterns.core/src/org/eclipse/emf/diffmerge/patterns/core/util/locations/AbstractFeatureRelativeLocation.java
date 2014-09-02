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
package org.eclipse.emf.diffmerge.patterns.core.util.locations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * A partial implementation of locations which are relative to a feature of an element.
 * @author Olivier Constant
 */
public abstract class AbstractFeatureRelativeLocation extends AbstractElementRelativeLocation {
  
  /** The feature */
  private final EStructuralFeature _feature;
  
  /**
   * Constructor
   * @param pattern_p a non-null pattern
   * @param feature_p a non-null feature
   */
  protected AbstractFeatureRelativeLocation(EObject element_p, EStructuralFeature feature_p) {
    super(element_p);
    assert feature_p != null;
    _feature = feature_p;
  }
  
  /**
   * Return the feature to which this location is relative
   * @return a non-null feature
   */
  protected EStructuralFeature getFeature() {
    return _feature;
  }
  
  /**
   * @see java.lang.Object#toString()
   */
  @Override
  @SuppressWarnings("nls")
  public String toString() {
    return getClass().getSimpleName() + ": " + getFeature().getName() + " on " + getElement();
  }
  
}
