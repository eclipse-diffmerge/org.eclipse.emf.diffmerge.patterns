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
package org.eclipse.emf.diffmerge.patterns.core.api;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;


/**
 * A specification of data related to a given pattern.
 * @author Olivier Constant
 */
public interface IPatternBasedSpecification extends IPatternProvider, IUserScopeProvider {
  
  /**
   * Return the roles played by the given model element, if any
   * @param modelElement_p a non-null element within the model scope
   * @return a non-null, potentially empty, unmodifiable list
   */
  Collection<? extends IPatternRole> getRolesOf(EObject modelElement_p);
  
  /**
   * Return whether this specification is complete and ready for usage
   */
  boolean isComplete();
  
}
