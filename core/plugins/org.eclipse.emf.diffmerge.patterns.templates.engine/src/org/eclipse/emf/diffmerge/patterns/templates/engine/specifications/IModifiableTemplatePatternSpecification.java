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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


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
  IModelScope getModelScope();
  
  /**
   * Return the scope of the template elements within the template pattern
   * @return a non-null model scope
   */
  IModelScope getPatternScope();
  
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
