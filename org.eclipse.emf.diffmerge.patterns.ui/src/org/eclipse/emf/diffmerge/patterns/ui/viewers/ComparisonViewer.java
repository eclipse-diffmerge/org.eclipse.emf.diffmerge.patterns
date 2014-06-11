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
package org.eclipse.emf.diffmerge.patterns.ui.viewers;

import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.diffmerge.api.IComparison;
import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IAttributeValuePresence;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.diff.IReferenceValuePresence;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternComparison;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;


/**
 * A viewer for a comparison between subsets of models
 * @author O. CONSTANT
 */
public class ComparisonViewer extends ModelSubsetViewer {
  
  /** The non-null comparison being represented */
  private IComparison _comparison;
  
  /**
   * Constructor
   * @param parent_p the non-null graphical owner
   * @param multipleSelection_p whether multiple selection is allowed
   * @param showParents_p whether the parents must be initially shown
   */
  public ComparisonViewer(Composite parent_p, boolean multipleSelection_p,
      boolean showParents_p) {
    super(parent_p, multipleSelection_p, showParents_p);
  }
  
  /**
   * Return the comparison represented by this viewer
   * @return a non-null comparison
   */
  protected IComparison getComparison() {
    return _comparison;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getForegroundColor(org.eclipse.emf.ecore.EObject, org.eclipse.swt.graphics.Color)
   */
  @Override
  protected Color getForegroundColor(EObject element_p, Color defaultColor_p) {
    Color result;
    if (hasBeenAdded(element_p))
      result = UIUtil.getColor(SWT.COLOR_BLUE);
    else if (hasBeenRemoved(element_p))
      result = UIUtil.getColor(SWT.COLOR_RED);
    else if (hasBeenModified(element_p))
      result = UIUtil.getColor(SWT.COLOR_DARK_MAGENTA);
    else
      result = super.getForegroundColor(element_p, defaultColor_p);
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getParent(java.lang.Object)
   */
  @Override
  protected Object getParent(Object element_p) {
    Object result = null;
    if (element_p instanceof EObject) {
      // Non-default behavior for elements present in reference only
      // and whose container is present in both sides
      EObject element = (EObject)element_p;
      IMatch match = _comparison.getMapping().getMatchFor(element, Role.REFERENCE);
      if (match != null && match.isPartial()) {
        IMatch containerMatch = _comparison.getContainerOf(match, Role.REFERENCE);
        if (containerMatch != null && !containerMatch.isPartial())
          result = containerMatch.get(Role.TARGET);
      }
    }
    if(result == null)
      result = super.getParent(element_p);
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getText(org.eclipse.emf.ecore.EObject, java.lang.String)
   */
  @Override
  protected String getText(EObject element_p, String defaultText_p) {
    String result = defaultText_p;
    if (result != null) {
      if (hasBeenAdded(element_p))
        result = "+ " + defaultText_p; //$NON-NLS-1$
      else if (hasBeenRemoved(element_p))
        result = "- " + defaultText_p; //$NON-NLS-1$
      else if (hasBeenModified(element_p))
        result = "> " + defaultText_p; //$NON-NLS-1$
    }
    return result;
  }
  
  /**
   * Return the elements to show via the viewer
   * @param comparison_p a non-null comparison
   * @return a non-null, potentially empty, unmodifiable collection
   */
  protected Collection<EObject> getValidElements(IComparison comparison_p) {
    Collection<EObject> result = new FOrderedSet<EObject>();
    result.addAll(comparison_p.getScope(Role.TARGET).getAllContentsAsSet());
    TreeIterator<IMatch> it = comparison_p.getAllContents(Role.REFERENCE);
    while (it.hasNext()) {
      IMatch match = it.next();
      if (match.isPartial())
        result.add(match.get(Role.REFERENCE));
    }
    return result;
  }
  
  /**
   * Return whether the given element is an addition in the comparison
   * @param element_p a non-null element
   */
  protected boolean hasBeenAdded(EObject element_p) {
    boolean result = false;
    IMatch match = _comparison.getMapping().getMatchFor(element_p,
        TemplatePatternApplicationComparison.getApplicationRole());
    if (match != null)
      result = match.isPartial();
    return result;
  }
  
  /**
   * Return whether the given element has technical differences in the comparison
   * @param element_p a non-null element
   */
  protected boolean hasBeenModified(EObject element_p) {
    boolean result = false;
    IMatch match = _comparison.getMapping().getMatchFor(element_p,
        TemplatePatternApplicationComparison.getApplicationRole());
    if (match != null)
      result = !match.isPartial() && hasModificationDifference(match);
    return result;
  }
  
  /**
   * Return whether the given element is a deletion in the comparison
   * @param element_p a non-null element
   */
  protected boolean hasBeenRemoved(EObject element_p) {
    boolean result = false;
    IMatch match = _comparison.getMapping().getMatchFor(element_p,
        TemplatePatternComparison.getPatternRole());
    if (match != null)
      result = match.isPartial();
    return result;
  }
  
  /**
   * Return whether the given match has differences which are such that it can
   * be considered as modified
   * @param match_p a non-null match
   */
  protected boolean hasModificationDifference(IMatch match_p) {
    if (match_p.getOwnershipDifference(Role.TARGET) != null)
      return true;
    for (IDifference diff : match_p.getRelatedDifferences()) {
      if (isModificationDifference(diff))
        return true;
    }
    return false;
  }
  
  /**
   * Return whether the given difference can be considered as a modification
   * of the corresponding element
   * @param diff_p a non-null difference
   */
  protected boolean isModificationDifference(IDifference diff_p) {
    if (diff_p instanceof IAttributeValuePresence)
      return true;
    if (diff_p instanceof IReferenceValuePresence) {
      EReference ref = ((IReferenceValuePresence)diff_p).getFeature();
      if (!ref.isContainment())
        return true;
    }
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#setInput(java.lang.Object)
   */
  @Override
  public void setInput(Object input_p) {
    if (input_p instanceof IComparison) {
      _comparison = (IComparison)input_p;
      super.setInput(getValidElements(_comparison));
    } else {
      super.setInput(input_p);
    }
  }
  
}
