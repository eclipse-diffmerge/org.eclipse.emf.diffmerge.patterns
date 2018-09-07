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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * An observable object dealing with the selection of a pattern role.
 * @author Olivier Constant
 */
public interface IRoleSelection extends IPatternProvider {
  
  /**
   * An interface for observers which are concerned with the role currently selected
   */
  public static interface IRoleChangedListener {
    /**
     * Notifies that the selected role changed
     * @param newRole_p a potentially null role
     */
    void roleChanged(TemplatePatternRole newRole_p);
  }
  
  
  /**
   * Add a listener on the selected role
   * @param listener_p a non-null listener
   */
  void addSelectedRoleListener(IRoleChangedListener listener_p);
  
  /**
   * Refinement by covariance of IPatternProvider.getPattern()
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider#getPattern()
   */
  TemplatePattern getPattern();
  
  /**
   * Return the selected role
   * @return a potentially null role
   */
  TemplatePatternRole getRole();
  
  /**
   * Notify that the selected role was not changed but updated
   */
  void roleUpdated();
  
  /**
   * Set the selected role
   * @param role_p a potentially null role
   */
  void setRole(TemplatePatternRole role_p);
  
}
