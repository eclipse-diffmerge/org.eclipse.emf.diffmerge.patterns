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
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.providers.NameBasedLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A wizard page which provides controls for selecting multiple roles among those
 * of a template pattern. 
 * @author Olivier Constant
 */
public abstract class AbstractMultiRoleSelectionPage<T extends IMultiRoleBasedSpecification>
extends AbstractRoleBasedPage<T> {
  
  /** Whether this page has been already show to the user */
  private boolean _alreadyShown;
  
  /**
   * Constructor
   * @param pageName_p the non-null name of the page
   * @param pageTitle_p the optional title of the page
   * @param defaultMessage_p a non-null default message for the page
   * @param data_p the non-null data under construction
   * @param isBlocking_p whether the page must be completed before the Next button can be clicked
   */
  public AbstractMultiRoleSelectionPage(String pageName_p, String pageTitle_p,
      String defaultMessage_p, T data_p, boolean isBlocking_p) {
    super(pageName_p, pageTitle_p, defaultMessage_p, data_p, isBlocking_p);
    _alreadyShown = false;
  }
  
  /**
   * Create the controls related to role management within the given composite
   * @param parent_p a non-null composite
   * @param allowEdition_p whether the roles may be modified via the UI
   * @return a non-null control encompassing all the widgets concerned
   */
  protected Composite createRoleControls(Composite parent_p, boolean allowEdition_p) {
    // *** Group
    Group result = createGroup(parent_p, Messages.AbstractMultiRoleSelectionPage_Roles, false, 2);
    createRoleList(result);
    return result;
  }
  
  /**
   * Create the list representing the roles of the pattern
   * @param parent_p a non-null composite
   * @return a non-null list viewer
   */
  private ListViewer createRoleList(Composite parent_p) {
    final org.eclipse.swt.widgets.List rolesList =
      new org.eclipse.swt.widgets.List(parent_p, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
    GridData listData = new GridData(SWT.FILL, SWT.FILL, true, true);
    listData.verticalSpan = 4;
    listData.widthHint = 150;
    rolesList.setLayoutData(listData);
    // Viewer
    final ListViewer result = new ListViewer(rolesList);
    _rolesViewer = result;
    result.setContentProvider(new IStructuredContentProvider() {
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
       */
      public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
        // Nothing needed
      }
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#dispose()
       */
      public void dispose() {
        // Nothing needed
      }
      /**
       * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
       */
      public Object[] getElements(Object inputElement_p) {
        Object[] elements = new Object[0];
        if (inputElement_p instanceof IPatternProvider) {
          IPatternProvider input = (IPatternProvider)inputElement_p;
          if (input.getPattern() != null)
            elements = input.getPattern().getRoles().toArray();
        }
        return elements;
      }
    });
    result.setInput(getData());
    result.setLabelProvider(
        new RoleViewerLabelProvider(NameBasedLabelProvider.getInstance()));
    // Selection
    result.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      @SuppressWarnings("unchecked")
      public void selectionChanged(SelectionChangedEvent event_p) {
        IStructuredSelection selection = (IStructuredSelection)event_p.getSelection();
        if (!(selection instanceof NonUserSelection))
          getData().setRoles(selection.toList());
      }
    });
    // Update
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        IStructuredSelection selection = (IStructuredSelection)result.getSelection();
        if (!selection.toList().equals(newRoles_p))
          result.setSelection(NonUserSelection.newInstance(newRoles_p));
        result.refresh(true);
      }
    });
    // Pattern update
    if (getData() instanceof ITemplatePatternSelection)
      ((ITemplatePatternSelection)getData()).addSelectedPatternListener(
          new ITemplatePatternSelection.IPatternChangedListener() {
        /**
         * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
         */
        public void patternChanged(TemplatePattern newPattern_p) {
          result.setInput(getData());
          getData().setRoles(Collections.<TemplatePatternRole>emptyList());
        }
      });
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#setVisible(boolean)
   */
  @Override
  public void setVisible(boolean visible_p) {
    super.setVisible(visible_p);
    // Select first role initially if available
    if (!_alreadyShown) {
      _alreadyShown = true;
      if (getData().getRoles().isEmpty()) {
        List<TemplatePatternRole> roles = getRoles();
        if (!roles.isEmpty())
          _rolesViewer.setSelection(new StructuredSelection(roles.get(0)));
      }
    }
  }
  
}
