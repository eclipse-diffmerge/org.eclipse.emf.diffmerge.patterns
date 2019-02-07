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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.ecore.EObject;


/**
 * A modifiable specification of a template pattern.
 * @author Olivier Constant
 */
public interface IModifiableTemplatePatternSpecification extends IBijectiveTemplatePatternSpecification {
  
  /**
   * Return whether modifications of the pattern image are accepted
   */
  boolean acceptNewPatternImage();
  
  /**
   * Create and return a new role in the pattern
   * @param roleName_p a non-null name for the role
   * @return a non-null role if operation is allowed, null otherwise
   */
  TemplatePatternRole addRole(String roleName_p);
  
  /**
   * Return the scope of the elements related to the pattern within the model
   * @return a non-null model scope
   */
  ITreeDataScope<EObject> getModelScope();
  
  /**
   * Return the scope of the template elements within the template pattern
   * @return a non-null model scope
   */
  ITreeDataScope<EObject> getPatternScope();
  
  /**
   * Return whether layout data must be included in the pattern
   */
  boolean includeLayoutData();
  
  /**
   * Remove the given role from the pattern
   * @param role_p a non-null role of the pattern being constructed
   */
  void removeRole(TemplatePatternRole role_p);
  
  /**
   * Specify whether the pattern image can be changed
   */
  void setAcceptNewPatternImage(boolean accept_p);
  
  /**
   * Specify whether layout data must be included in the pattern
   */
  void setIncludeLayoutData(boolean include_p);
  
}
