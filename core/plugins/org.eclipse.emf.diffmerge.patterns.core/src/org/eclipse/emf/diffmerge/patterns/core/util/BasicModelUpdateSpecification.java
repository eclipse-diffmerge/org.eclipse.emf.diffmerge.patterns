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
package org.eclipse.emf.diffmerge.patterns.core.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * An implementation of IModelUpdateSpecification.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class BasicModelUpdateSpecification implements IModelUpdateSpecification {
  
  /** Whether the operation is destructive */
  private boolean _isDestructive;
  
  /** The non-null, potentially empty set of features to ignore */
  private final List<EStructuralFeature> _featuresToIgnore;
  
  
  /**
   * Default constructor
   */
  public BasicModelUpdateSpecification(boolean isDestructive_p,
      List<EStructuralFeature> featuresToIgnore_p) {
    _isDestructive = isDestructive_p;
    _featuresToIgnore = featuresToIgnore_p;
  }
  
  /**
   * Default constructor
   */
  public BasicModelUpdateSpecification() {
    _isDestructive = false;
    _featuresToIgnore = new ArrayList<EStructuralFeature>();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification#isDestructive()
   */
  public boolean isDestructive() {
    return _isDestructive;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification#getFeaturesToIgnore()
   */
  public List<EStructuralFeature> getFeaturesToIgnore() {
    return _featuresToIgnore;
  }
  
}
