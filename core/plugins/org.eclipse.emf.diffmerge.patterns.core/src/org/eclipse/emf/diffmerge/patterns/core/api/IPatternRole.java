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
package org.eclipse.emf.diffmerge.patterns.core.api;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IRoleApplicabilityStatus;


/**
 * A role in a pattern defines applicability constraints with which locations have to comply
 * for the pattern to be applicable.
 * @author Olivier Constant
 */
public interface IPatternRole extends IIdentifiedElement, INamedElement, IDescribedElement,
IPatternInstanceMarker {
  
  /**
   * Check whether the role is applicable to the given location
   * @param location_p a potentially null location
   * @return a non-null status
   */
  IRoleApplicabilityStatus checkApplicability(ILocation location_p,
      IPatternApplication context_p);
  
  /**
   * Check whether all constraints of the role are satisfied by the given location
   * in the context of the given pattern application.
   * Only locations bound to previous roles of the pattern in the given application
   * can be used to compute applicability.
   * @param location_p a potentially null location
   * @param context_p a non-null pattern application
   * @return a non-null status
   */
  IRoleApplicabilityStatus checkCompleteApplicability(ILocation location_p,
      IPatternApplication context_p);
  
  /**
   * Try and derive candidate locations from the given pattern application.
   * Only locations bound to previous roles of the pattern in the given
   * application can be used to derive locations for this role.
   * @param context_p a non-null application of the pattern
   * @param forAddition_p whether the locations must be derived in the perspective of
   *        adding elements or in the perspective of binding them
   * @return a potentially null (in case of failure), potentially empty list
   */
  List<ILocation> deriveCandidateLocations(IPatternApplication context_p, boolean forAddition_p);
  
  /**
   * Return the pattern to which the role belongs
   * @return a non-null pattern
   */
  IPattern getPattern();
  
  /**
   * Return a symbol which refers to this pattern role
   * @return a non-null pattern role symbol
   */
  IPatternRoleSymbol getSymbol();
  
  /**
   * Return whether the role supports mixed merge/addition behavior
   */
  boolean isGeneric();
  
}
