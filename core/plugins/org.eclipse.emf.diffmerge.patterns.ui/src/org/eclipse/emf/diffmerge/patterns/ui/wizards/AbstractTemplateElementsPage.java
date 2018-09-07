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
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.RoleBindingViewer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


/**
 * A wizard page for specifying the contents of a template pattern 
 * @author Olivier Constant
 */
public abstract class AbstractTemplateElementsPage
<T extends AbstractBijectiveTemplatePatternSpecification>
extends AbstractRoleSelectionPage<T> {
  
  /** The viewer over the template elements, non-null after createControls has been called */
  public ModelSubsetViewer _templateElementsViewer;

  /**
   * Constructor
   * @param title_p a non-null title for the page
   * @param defaultMessage_p an optional message for the page
   * @param data_p the non-null data for the pattern
   */
  protected AbstractTemplateElementsPage(String title_p, String defaultMessage_p, T data_p) {
    super("ContentsPage", title_p, //$NON-NLS-1$
        defaultMessage_p != null? defaultMessage_p:
          Messages.AbstractTemplateElementsPage_Message,
    data_p, false);
  }
  
  /**
   * Return whether edition is allowed or if the data being displayed is read-only
   */
  protected boolean allowEdition() {
    return false;
  }
  
  /**
   * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  public void createControl(Composite parent_p) {
    final Composite mainComposite = new Composite(parent_p, SWT.NONE);
    setControl(mainComposite);
    Layout mainCompositeLayout = new GridLayout(2, false);
    mainComposite.setLayout(mainCompositeLayout);
    setDefaultMessage();
    _templateElementsViewer = createTemplateElementControls(mainComposite);
    createRoleControls(mainComposite, allowEdition());
  }
  
  /**
   * Create the "unique" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  protected MenuItem createIsUniqueItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.CHECK);
    result.setText(Messages.AbstractTemplateElementsPage_Unique);
    result.setEnabled(false);
    result.setSelection(true);
    // Enabled state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        IStructuredSelection selection = (IStructuredSelection)event.getSelection();
        boolean enable = allowEdition() && !selection.isEmpty();
        if (enable) {
          EObject selected = (EObject)selection.getFirstElement();
          enable = !getData().isInstanceRelated(selected) &&
            getData().getCounterpart(selected, false) != null;
        }
        result.setEnabled(enable);
      }
    });
    // Selected state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        Object selected = viewer_p.getSelection().getFirstElement();
        if (selected instanceof EObject) {
          EObject selectedElement = (EObject)selected;
          EObject templateElement = getData().getCounterpart(selectedElement, false);
          boolean select = !getData().getPattern().getMultiElements().contains(templateElement);
          result.setSelection(select);
        }
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        @SuppressWarnings("unchecked")
        Iterator<Object> it = viewer_p.getSelection().iterator();
        boolean first = true;
        while (it.hasNext()) {
          Object selected = it.next();
          if (selected instanceof EObject) {
            EObject selectedElement = (EObject)selected;
            EObject templateElement = getData().getCounterpart(selectedElement, false);
            if (templateElement != null) {
              List<EObject> multiElements = getData().getPattern().getMultiElements();
              boolean previouslySelected = !multiElements.contains(templateElement);
              if (previouslySelected)
                multiElements.add(templateElement);
              else
                multiElements.remove(templateElement);
              if (first)
                result.setSelection(!previouslySelected);
              else
                first = false;
            }
          }
        }
        viewer_p.refresh();
      }
    });
    return result;
  }
  
  /**
   * Create controls for editing the element/role mapping
   * in the given menu for the given model viewer
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   */
  protected void createMappingControls(Menu menu_p, ModelSubsetViewer viewer_p) {
    // Nothing by default
  }
  
  /**
   * Create controls for navigating the elements in the given menu for the given model viewer
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   */
  protected void createNavigationControls(Menu menu_p, ModelSubsetViewer viewer_p) {
    // Nothing by default
  }
  
  /**
   * Create and return a model viewer which allows identifying the binding to roles
   * @param parent_p a non-null composite
   * @return a non-null model viewer
   */
  protected ModelSubsetViewer createModelViewer(Composite parent_p) {
    final ModelSubsetViewer resultViewer = new RoleBindingViewer(
        parent_p, true, false) {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        int result = ModelSubsetViewer.SORT | ModelSubsetViewer.EXPAND |
            ModelSubsetViewer.COLLAPSE;
        if (AbstractTemplateElementsPage.this.showParentsCheckbox())
          result = result | ModelSubsetViewer.SHOW_PARENTS;
        return result;
      }
    };
    resultViewer.setInput(getData());
    return resultViewer;
  }
  
  /**
   * Create controls for editing the model scope in the given menu
   * for the given model viewer
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   */
  protected void createScopeModificationControls(Menu menu_p, ModelSubsetViewer viewer_p) {
    // Nothing by default
  }
  
  /**
   * Create the controls related to template elements within the given composite
   * @param parent_p a non-null composite
   * @return a non-null viewer
   */
  protected ModelSubsetViewer createTemplateElementControls(Composite parent_p) {
    // Group
    Group contentsGroup = createTemplateElementsGroup(parent_p);
    // Tree viewer
    final ModelSubsetViewer result = createModelViewer(contentsGroup);
    // Popup menus
    final Menu menu = new Menu(result.getTreeViewer().getTree());
    createNavigationControls(menu, result);
    if (allowEdition())
      createMappingControls(menu, result);
    createIsUniqueItem(menu, result);
    if (allowEdition())
      createScopeModificationControls(menu, result);
    result.getTreeViewer().getTree().setMenu(menu);
    return result;
  }
  
  /**
   * Create and return the group for template elements
   * @param parent_p a non-null composite
   * @return a non-null group
   */
  protected Group createTemplateElementsGroup(Composite parent_p) {
    return createGroup(parent_p, getElementsGroupName(), true, 1);
  }
  
  /**
   * Return the name of the graphical group for the elements being displayed
   * @return a non-null string
   */
  protected String getElementsGroupName() {
    return Messages.AbstractTemplateElementsPage_TemplateElements;
  }
  
  /**
   * Return whether the "show parents" check box must be shown graphically
   */
  public boolean showParentsCheckbox() {
    return true;
  }
  
}
