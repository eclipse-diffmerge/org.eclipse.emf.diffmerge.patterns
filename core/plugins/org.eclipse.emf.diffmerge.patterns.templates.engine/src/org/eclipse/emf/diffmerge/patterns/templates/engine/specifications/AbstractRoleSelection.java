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

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * An straightforward implementation of IRoleSelection.
 * @author Olivier Constant
 */
public abstract class AbstractRoleSelection extends AbstractTemplatePatternSelection
implements IRoleSelection {
  
  /** The potentially null pattern role which is selected */
  private TemplatePatternRole _selectedRole;
  
  /** The observers */
  private final Collection<IRoleChangedListener> _listeners;
  
  
  /**
   * Constructor
   */
  public AbstractRoleSelection() {
    _listeners = new HashSet<IRoleChangedListener>();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection#addSelectedRoleListener(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener)
   */
  public void addSelectedRoleListener(IRoleChangedListener listener_p) {
    _listeners.add(listener_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection#getRole()
   */
  public TemplatePatternRole getRole() {
    return _selectedRole;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection#roleUpdated()
   */
  public void roleUpdated() {
    setRole(getRole());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection#setRole(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
   */
  public void setRole(TemplatePatternRole role_p) {
    _selectedRole = role_p;
    for (IRoleChangedListener listener : _listeners)
      listener.roleChanged(role_p);
  }
  
}
