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
