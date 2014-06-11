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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * An observable object dealing with the selection of several pattern roles.
 * @author O. CONSTANT
 */
public interface IMultiRoleSelection extends IPatternProvider {
  
  /**
   * An interface for observers which are concerned with the roles currently selected
   */
  public static interface IRolesChangedListener {
    /**
     * Notifies that the selected roles changed
     * @param newRoles_p a non-null, potentially empty collection
     */
    void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p);
  }
  
  
  /**
   * Add a listener on the selected role
   * @param listener_p a non-null listener
   */
  void addSelectedRolesListener(IRolesChangedListener listener_p);
  
  /**
   * Refinement by covariance of IPatternProvider.getPattern()
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider#getPattern()
   */
  TemplatePattern getPattern();
  
  /**
   * Return the selected roles
   * @return a potentially null role
   */
  Collection<TemplatePatternRole> getRoles();
  
  /**
   * Set the selected roles
   * @param pattern_p a non-null, potentially empty collection
   */
  void setRoles(Collection<? extends TemplatePatternRole> roles_p);
  
}
