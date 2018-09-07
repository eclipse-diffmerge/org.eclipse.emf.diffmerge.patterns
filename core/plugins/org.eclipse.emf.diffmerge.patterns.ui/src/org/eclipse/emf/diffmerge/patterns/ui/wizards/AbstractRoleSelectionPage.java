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

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.providers.NameBasedLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleBasedPage;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A wizard page which provides controls for selecting a single role among those
 * of a template pattern. 
 * @author Olivier Constant
 */
public abstract class AbstractRoleSelectionPage<T extends IRoleBasedSpecification>
extends AbstractRoleBasedPage<T> {
  
  /** Whether this page has already been shown to the user */
  private boolean _alreadyShown;
  
  /**
   * Constructor
   * @param pageName_p the non-null name of the page
   * @param pageTitle_p the optional title of the page
   * @param defaultMessage_p a non-null default message for the page
   * @param data_p the non-null data under construction
   * @param isBlocking_p whether the page must be completed before the Next button can be clicked
   */
  public AbstractRoleSelectionPage(String pageName_p, String pageTitle_p,
      String defaultMessage_p, T data_p, boolean isBlocking_p) {
    super(pageName_p, pageTitle_p, defaultMessage_p, data_p, isBlocking_p);
    _alreadyShown = false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#getValidationMessage()
   */
  @Override
  protected String getValidationMessage() {
    String result = null;
    IPattern pattern = getData().getPattern();
    if (pattern != null && pattern.getRoles().isEmpty())
      result = Messages.AbstractRoleSelectionPage_RoleRequirement;
    else if (!NamingUtil.haveUniqueNames(getRoles()))
      result = Messages.AbstractRoleSelectionPage_RoleNameUniqueness;
    else if (pattern != null){
      for (IPatternRole role : pattern.getRoles()) {
        if (role instanceof TemplatePatternRole &&
            ((TemplatePatternRole)role).getTemplateElements().isEmpty()) {
          result = String.format(
              Messages.AbstractRoleSelectionPage_RoleNonEmptiness, role.getName());
          break;
        }
      }
    }
    return result;
  }
  
  /**
   * Create the "role down" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createMoveRoleDownButton(Composite parent_p) {
    // Down button
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractRoleSelectionPage_Down);
    result.setEnabled(false);
    result.setLayoutData(createButtonLayoutData());
    // Behavior of down button
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null) {
          List<TemplatePatternRole> roles = getRoles();
          int index = roles.indexOf(role);
          roles.remove(index);
          roles.add(index+1, role);
          getData().roleUpdated();
          validate();
        }
      }
    });
    return result;
  }
  
  /**
   * Create the "role up" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createMoveRoleUpButton(Composite parent_p) {
    // Up button
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractRoleSelectionPage_Up);
    result.setEnabled(false);
    result.setLayoutData(createButtonLayoutData());
    // Behavior of up button
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null) {
          List<TemplatePatternRole> roles = getRoles();
          int index = roles.indexOf(role);
          roles.remove(index);
          roles.add(index-1, role);
          getData().roleUpdated();
          validate();
        }
      }
    });
    return result;
  }
  
  /**
   * Create the controls related to role management within the given composite
   * @param parent_p a non-null composite
   * @param allowEdition_p whether the roles may be modified via the UI
   * @return a non-null control encompassing all the widgets concerned
   */
  protected Composite createRoleControls(Composite parent_p, boolean allowEdition_p) {
    // *** Group
    Group result = createGroup(parent_p, Messages.AbstractRoleSelectionPage_Roles, false, 2);
    if (allowEdition_p)
      createRoleAdditionControls(result);
    createRoleList(result);
    if (allowEdition_p) {
      final Button deleteButton = createRoleDeletionButton(result);
      final Button renameButton = createRoleRenamingButton(result);
      final Button upButton = createMoveRoleUpButton(result);
      final Button downButton = createMoveRoleDownButton(result);
      // Behavior: button enabled state according to active role
      getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
        /**
         * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
         */
        public void roleChanged(TemplatePatternRole newRole_p) {
          deleteButton.setEnabled(newRole_p != null);
          renameButton.setEnabled(newRole_p != null);
          if (newRole_p != null) {
            List<?> roles = getRoles();
            int index = roles.indexOf(newRole_p);
            upButton.setEnabled(index > 0);
            downButton.setEnabled(index < roles.size()-1);
          } else {
            upButton.setEnabled(false);
            downButton.setEnabled(false);
          }
        }
      });
    }
    return result;
  }
  
  /**
   * Create the controls related to the addition of new roles
   * @param parent_p a non-null composite
   */
  private void createRoleAdditionControls(Composite parent_p) {
    // Add button
    final Button addButton = new Button(parent_p, SWT.PUSH);
    addButton.setText(Messages.AbstractRoleSelectionPage_Add);
    addButton.setLayoutData(createButtonLayoutData());
    // Behavior of add button
    addButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        String name = promptForRoleName("newRole"); //$NON-NLS-1$
        if (name != null) {
          ((IModifiableTemplatePatternSpecification)getData()).addRole(name);
          getData().roleUpdated();
          validate();
        }
      }
    });
  }
  
  /**
   * Create the "delete role" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createRoleDeletionButton(Composite parent_p) {
    // Button creation
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractRoleSelectionPage_Delete);
    result.setEnabled(false);
    result.setLayoutData(createButtonLayoutData());
    // Behavior of delete button
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null) {
          boolean confirmed = MessageDialog.openConfirm(getShell(),
              Messages.AbstractRoleSelectionPage_DeleteRoleTitle,
              Messages.AbstractRoleSelectionPage_DeleteRole + " '" + role.getName() + "'?");  //$NON-NLS-1$//$NON-NLS-2$
          if (confirmed) {
            ((IModifiableTemplatePatternSpecification)getData()).removeRole(role);
            getData().roleUpdated();
            validate();
          }
        }
      }
    });
    return result;
  }
  
  /**
   * Create the "rename role" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createRoleRenamingButton(Composite parent_p) {
    // Rename button
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractRoleSelectionPage_RenameRole);
    result.setEnabled(false);
    result.setLayoutData(createButtonLayoutData());
    // Behavior of rename button
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null) {
          InputDialog inDiag = new InputDialog(getShell(), Messages.AbstractRoleSelectionPage_RenameRoleTitle,
              Messages.AbstractRoleSelectionPage_NewRoleName, role.getName(), null);
          int answer = inDiag.open();
          if (Window.OK == answer) {
            String newName = inDiag.getValue();
            role.setName(newName);
            getData().roleUpdated();
            validate();
          }
        }
      }
    });
    return result;
  }
  
  /**
   * Create the list representing the roles of the pattern
   * @param parent_p a non-null composite
   * @return a non-null list viewer
   */
  private ListViewer createRoleList(Composite parent_p) {
    final org.eclipse.swt.widgets.List rolesList =
      new org.eclipse.swt.widgets.List(parent_p, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
    GridData listData = new GridData(SWT.FILL, SWT.FILL, true, true);
    listData.verticalSpan = 5;
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
      public void selectionChanged(SelectionChangedEvent event_p) {
        IStructuredSelection selection = (IStructuredSelection)event_p.getSelection();
        if (!(selection instanceof NonUserSelection))
          getData().setRole((TemplatePatternRole)selection.getFirstElement());
      }
    });
    // Update
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        IStructuredSelection selection = (IStructuredSelection)result.getSelection();
        if (!(selection.isEmpty() && newRole_p == null ||
            !selection.isEmpty() && selection.getFirstElement() == newRole_p))
          result.setSelection(NonUserSelection.newInstance(newRole_p));
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
          getData().setRole(null);
        }
      });
    return result;
  }
  
  /**
   * Prompt the user for a role name based on the given default name
   * @param defaultName_p an optional default name
   * @return a potentially null string
   */
  public String promptForRoleName(String defaultName_p) {
    String roleName = null;
    final String EMPTY = ""; //$NON-NLS-1$
    String defaultName = defaultName_p != null? defaultName_p: EMPTY;
    IInputValidator validator = new IInputValidator() {
      /**
       * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
       */
      public String isValid(String newText_p) {
        String result = null;
        if (newText_p == null || newText_p.length() == 0)
          result = EMPTY; // No explicit message because validation is obvious
        return result;
      }
    };
    InputDialog dialog = new InputDialog(getShell(), Messages.AbstractRoleSelectionPage_AddRoleTitle,
        Messages.AbstractRoleSelectionPage_AddRoleDescription, defaultName, validator);
    int answer = dialog.open();
    if (Window.OK == answer)
      roleName = dialog.getValue();
    return roleName;
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
      if (getData().getRole() == null) {
        List<TemplatePatternRole> roles = getRoles();
        if (!roles.isEmpty())
          _rolesViewer.setSelection(new StructuredSelection(roles.get(0)));
      }
    }
  }
  
}
