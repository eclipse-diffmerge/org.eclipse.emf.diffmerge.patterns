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
package org.eclipse.emf.diffmerge.patterns.core.api.ext;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A provider of ID-based services
 * @author Olivier Constant
 * @author S. TURKI
 */
public interface IIdProvider {

  /**
   * Whether the provider is contributed by the main modeler, not a viewpoint (an extension).
   * @return
   */
  boolean isMainModel();

  /**
   * Return a new unique ID for the given element
   * @return a non-null string
   */
  String getNewIdFor(EObject element_p);

  /**
   * Return whether the given newly-added element must be given a new intrinsic ID.
   * @param element_p a non-null element
   * @param scope_p a non-null scope to which the element is being added by copy
   */
  boolean requiresNewIntrinsicID(EObject element_p, Object scope_p);

  /**
   * Return the ID of the given element as defined within this framework, if any
   * @param element_p a potentially null element
   * @param editingDomain_p a potentially null editing domain
   * @return a potentially null string
   */
  String getId(EObject element_p, EditingDomain editingDomain_p);

  /**
   * Return the element with the given ID in the context of the given scope of resources
   * Postcondition: scope_p is not modified
   * @param id_p a potentially null string
   * @param scope_p a non-null collection of resources
   * @return a potentially null element
   */
  EObject getById(String id_p, Collection<? extends Resource> scope_p);

  /**
   * Return the element with the given ID within the context defined by the given element,
   * ranging from its resource to its resource set if available
   * @param id_p a potentially null string
   * @param context_p a potentially null pattern application
   * @return a potentially null element
   */
  EObject getByIdInContext(String id_p, Object context_p);

  /**
   * Return the element with the given ID within the exact resource of the given element
   * @param id_p a potentially null string
   * @param context_p a potentially null element
   * @return a potentially null element
   */
  EObject getByIdInResource(String id_p, EObject context_p);

  /**
   * Whether the IDProvider is applicable to the given element
   * @param element_p a non-null EObject
   * @return a boolean
   */
  boolean isApplicableTo(EObject element_p);

}
