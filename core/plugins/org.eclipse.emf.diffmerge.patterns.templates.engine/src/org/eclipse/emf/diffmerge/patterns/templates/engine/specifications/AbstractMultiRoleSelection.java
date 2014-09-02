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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * An straightforward implementation of IMultiRoleSelection.
 * @author Olivier Constant
 */
public abstract class AbstractMultiRoleSelection extends AbstractTemplatePatternSelection
implements IMultiRoleSelection {
  
  /** The non-null set of roles which are selected */
  private final Collection<TemplatePatternRole> _selectedRoles;
  
  /** The observers */
  private final Collection<IRolesChangedListener> _listeners;
  
  
  /**
   * Constructor
   */
  public AbstractMultiRoleSelection() {
    _selectedRoles = new HashSet<TemplatePatternRole>();
    _listeners = new HashSet<IRolesChangedListener>();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection#addSelectedRolesListener(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener)
   */
  public void addSelectedRolesListener(IRolesChangedListener listener_p) {
    _listeners.add(listener_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection#getRoles()
   */
  public Collection<TemplatePatternRole> getRoles() {
    return _selectedRoles;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection#setRole(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
   */
  public void setRoles(Collection<? extends TemplatePatternRole> roles_p) {
    _selectedRoles.clear();
    _selectedRoles.addAll(roles_p);
    for (IRolesChangedListener listener : _listeners)
      listener.rolesChanged(roles_p);
  }
  
}
