/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.viewers;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;


/**
 * A viewer for a subset of a model which is related to pattern. 
 * @author Olivier Constant
 */
public class RoleBindingViewer extends ModelSubsetViewer {
  
  /** The non-null specification of the pattern */
  private ITemplatePatternBasedSpecification _data;
  
  /**
   * Constructor
   * @param parent_p the graphical owner
   * @param multipleSelection_p whether multiple selection is allowed
   * @param showParents_p whether the "show parents" check box must be checked initially
   */
  public RoleBindingViewer(Composite parent_p, boolean multipleSelection_p, boolean showParents_p) {
    super(parent_p, multipleSelection_p, showParents_p);
    addFilter(UIUtil.INSTANCE_VIEWER_FILTER);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getFont(org.eclipse.emf.ecore.EObject, org.eclipse.swt.graphics.Font)
   */
  @Override
  protected Font getFont(EObject element_p, Font defaultFont_p) {
    Font result = null;
    Collection<TemplatePatternRole> roles = _data.getRolesOf(element_p);
    if (!roles.isEmpty()) {
      boolean useBoundElementRepresentation =
        _data instanceof IRoleSelection && roles.contains(((IRoleSelection)_data).getRole());
      if (!useBoundElementRepresentation && _data instanceof IMultiRoleSelection) {
        Collection<TemplatePatternRole> intersection = new FOrderedSet<TemplatePatternRole>(
            _data.getRolesOf(element_p));
        intersection.retainAll(((IMultiRoleSelection)_data).getRoles());
        useBoundElementRepresentation = !intersection.isEmpty();
      }
      result = useBoundElementRepresentation? UIUtil.getBoundElementFont(defaultFont_p):
        UIUtil.getBold(defaultFont_p);
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getText(org.eclipse.emf.ecore.EObject, java.lang.String)
   */
  @Override
  protected String getText(EObject element_p, String defaultText_p) {
    String result = super.getText(element_p, defaultText_p);
    if (result != null) {
      Collection<TemplatePatternRole> roles = _data.getRolesOf(element_p);
      Collection<TemplatePatternRole> additionRoles;
      if (_data instanceof TemplatePatternApplicationSpecification)
        additionRoles = ((TemplatePatternApplicationSpecification)_data).getAdditionRolesOf(
            element_p);
      else
        additionRoles = Collections.emptyList();
      if (isMultiple(element_p))
        result = UIUtil.markAsMultipleElement(result);
      result = UIUtil.markAsBoundElement(result, roles, additionRoles);
    }
    return result;
  }
  
  /**
   * Return whether the given element must be marked as multiple
   * @param element_p a non-null element
   */
  private boolean isMultiple(EObject element_p) {
    boolean result = false;
    if (_data.getPattern() != null) {
      EObject templateElement = element_p;
      if (_data instanceof IBijectiveTemplatePatternSpecification) {
        IBijectiveTemplatePatternSpecification bijection =
          (IBijectiveTemplatePatternSpecification)_data;
        EObject attempt = bijection.getCounterpart(element_p, false);
        if (attempt != null)
          templateElement = attempt;
      }
      result = _data.getPattern().getMultiElements().contains(templateElement);
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#setInput(java.lang.Object)
   */
  @Override
  public void setInput(Object input_p) {
    if (input_p instanceof ITemplatePatternBasedSpecification) {
      _data = (ITemplatePatternBasedSpecification)input_p;
      if (_data instanceof IRoleSelection)
        ((IRoleSelection)_data).addSelectedRoleListener(
            new IRoleSelection.IRoleChangedListener() {
              /**
               * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
               */
              public void roleChanged(TemplatePatternRole newRole_p) {
                refresh();
              }
            });
      if (_data instanceof IMultiRoleSelection)
        ((IMultiRoleSelection)_data).addSelectedRolesListener(
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
             */
            new IMultiRoleSelection.IRolesChangedListener() {
              public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
                refresh();
              }
            });
      super.setInput(_data.getAllElements());
    } else {
      super.setInput(input_p);
    }
  }
  
}
