/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.core.api;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;


/**
 * The application of a pattern at a specific location.
 * @author Olivier Constant
 */
public interface IPatternApplication extends IPatternBasedSpecification, IPatternInstanceMarker {
  
  /**
   * Check conformity of the model w.r.t. the pattern of this application.
   * @param application_p a non-null application of this pattern
   * @param ignoredFeatures_p a non-null, potentially empty set of features to ignore
   * @return a non-null status about conformity
   */
  IPatternConformityStatus checkConformance(List<EStructuralFeature> ignoredFeatures_p);
  
  /**
   * Return the location associated to the given role of the pattern.
   * @param role_p a non-null role of pattern getPattern()
   * @return a potentially null location
   */
  ILocation getLocation(IPatternRole role_p);
  
  /**
   * Return all the locations of this application.
   * @return a non-null, non-empty, unmodifiable collection
   */
  Collection<? extends ILocation> getLocations();
  
  /**
   * Return whether this application is complete for the given role
   * @param role_p a non-null role of pattern getPattern()
   */
  boolean isCompleteOn(IPatternRole role_p);
  
  /**
   * Return whether this application is complete for no role
   */
  boolean isEmpty();
  
}
