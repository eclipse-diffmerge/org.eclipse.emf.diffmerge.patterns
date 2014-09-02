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
package org.eclipse.emf.diffmerge.patterns.ui.viewers;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;


/**
 * A viewer for a pattern-based comparison between subsets of models.
 * @author Olivier Constant
 */
public class PatternUpdateComparisonViewer extends ComparisonViewer {

  /** The non-null comparison-based specification of a template pattern */
  private TemplatePatternUpdateSpecification _data;

  /** The reference element's editing domain */
  protected EditingDomain _editingDomain;

  /**
   * Constructor
   * @param parent_p the non-null graphical owner
   * @param multipleSelection_p whether multiple selection is allowed
   * @param showParents_p whether the parents must be initially shown
   */
  public PatternUpdateComparisonViewer(Composite parent_p, EditingDomain editingDomain_p,
      boolean multipleSelection_p, boolean showParents_p) {
    super(parent_p, multipleSelection_p, showParents_p);
    addFilter(UIUtil.INSTANCE_VIEWER_FILTER);
    _editingDomain = editingDomain_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ComparisonViewer#getComparison()
   */
  @Override
  protected TemplatePatternComparison getComparison() {
    return (TemplatePatternComparison)super.getComparison();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getFont(org.eclipse.emf.ecore.EObject, org.eclipse.swt.graphics.Font)
   */
  @Override
  protected Font getFont(EObject element_p, Font defaultFont_p) {
    Font result = null;
    Collection<TemplatePatternRole> roles = _data.getRolesOf(element_p);
    if (roles.contains(_data.getRole()))
      result = UIUtil.getBoundElementFont(defaultFont_p);
    else if (!roles.isEmpty() || hasBeenAdded(element_p) || hasBeenRemoved(element_p) ||
        hasBeenModified(element_p))
      result = UIUtil.getBold(defaultFont_p);
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getText(org.eclipse.emf.ecore.EObject, java.lang.String)
   */
  @Override
  protected String getText(EObject element_p, String defaultText_p) {
    String result = defaultText_p;
    if (result != null && _data.hasDependencies(element_p))
      result = UIUtil.markAsDependentElement(result);
    result = super.getText(element_p, result);
    if (result != null) {
      Collection<TemplatePatternRole> roles = _data.getRolesOf(element_p);
      if (isMultiple(element_p))
        result = UIUtil.markAsMultipleElement(result);
      if (!roles.isEmpty())
        result = UIUtil.markAsBoundElement(
            result, roles, Collections.<TemplatePatternRole>emptyList());
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
      EObject attempt = _data.getCounterpart(element_p, false);
      if (attempt != null)
        templateElement = attempt;
      result = _data.getPattern().getMultiElements().contains(templateElement);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ComparisonViewer#setInput(java.lang.Object)
   */
  @Override
  public void setInput(Object input_p) {
    if (input_p instanceof TemplatePatternUpdateSpecification) {
      _data = (TemplatePatternUpdateSpecification)input_p;
      _data.addSelectedRoleListener(
          new IRoleSelection.IRoleChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
             */
            public void roleChanged(TemplatePatternRole newRole_p) {
              refresh();
            }
          });
      super.setInput(_data.getVisualizationComparison());
    } else {
      super.setInput(input_p);
    }
  }

}
