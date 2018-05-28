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
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification.ITemplateElementsChangedListener;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog.SelectionKind;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.ElementInclusionDialog;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.RoleChoiceDialog;
import org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI;
import org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.RoleBindingViewer;
import org.eclipse.emf.diffmerge.structures.common.FHashSet;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


/**
 * A wizard page for specifying the content of a template pattern and modifying it.
 * @author Olivier Constant
 */
public abstract class AbstractModifiableTemplateElementsPage
<T extends AbstractModifiableTemplatePatternSpecification>
extends AbstractTemplateElementsPage<T> {

  /** The default message for the page */
  static final String DEFAULT_MESSAGE =
      Messages.AbstractModifiableTemplateElementsPage_Prompt;

  /**
   * A semantic rule provider used to collect semantic rules contributed by viewpoints
   */
  ISemanticRuleProvider _ruleProvider;

  /**
   * Constructor
   * @param title_p a non-null title for the page
   * @param data_p the non-null data for the pattern
   */
  protected AbstractModifiableTemplateElementsPage(String title_p, T data_p) {
    this(title_p, DEFAULT_MESSAGE, data_p);
  }

  /**
   * Constructor
   * @param title_p a non-null title for the page
   * @param message_p a non-null message for the page
   * @param data_p the non-null data for the pattern
   */
  protected AbstractModifiableTemplateElementsPage(String title_p, String message_p, T data_p) {
    super(title_p, message_p, data_p);
    EObject context = null;
    try{
      context = data_p.getModelScope().getContents().get(0);
    }
    catch(Exception ex){
      //Nothing
    }
    if(context != null){
      _ruleProvider =
          TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(context);

    }
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#allowEdition()
   */
  @Override
  protected boolean allowEdition() {
    return true;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createControl(Composite parent_p) {
    super.createControl(parent_p);
    createSpecificControls();
  }

  /**
   * Creates specific controls.
   */
  protected Composite createSpecificControls(){
    Composite buttonComposite = new Composite((Composite)getControl(), SWT.NONE);
    buttonComposite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    GridLayout layout = new GridLayout(2, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    buttonComposite.setLayout(layout);
    createIncludeAllDependenciesButton(buttonComposite);
    createIncludeAllInstancesButton(buttonComposite);
    return buttonComposite;
  }

  /**
   * Given a set of elements to add to the pattern, determine whether their children
   * should be recursively included, prompting the user if needed
   * @param elements_p a non-null, potentially empty set of elements
   */
  protected boolean checkAddChildren(Collection<? extends EObject> elements_p) {
    boolean addChildren = true;
    boolean mustAskUser = false;
    Iterator<? extends EObject> it = elements_p.iterator();
    while (!mustAskUser && it.hasNext()) {
      if (!it.next().eContents().isEmpty())
        mustAskUser = true;
    }
    if (mustAskUser)
      addChildren = MessageDialog.openQuestion(
          getShell(), CorePatternsPlugin.getDefault().getLabel(),
          Messages.AbstractModifiableTemplateElementsPage_IncludeChildrenPrompt);
    return addChildren;
  }

  /**
   * Create the "add to scope" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createAddToScopeItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_Include);
    result.setEnabled(true);
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        final IModelScope modelScope = getData().getModelScope();
        EObject root = EcoreUtil.getRootContainer(getData().getScopeElement());
        ElementInclusionDialog dialog = new ElementInclusionDialog(
            getShell(), null, root, modelScope.getContents(), modelScope);
        int answer = dialog.open();
        if (Window.OK == answer) {
          Collection<EObject> choices = dialog.getChoice();
          if (choices != null) {
            boolean addChildren = checkAddChildren(choices);
            getData().addElements(choices, addChildren, false);
          }
        }
      }
    });
    return result;
  }

  /**
   * Create and return a button for dependency management
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createIncludeAllDependenciesButton(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_IncludeAllDependencies);
    result.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    boolean hasDep = getData().hasDependencies();
    result.setEnabled(hasDep);
    if (hasDep)
      setDependenciesMessage();
    // Enabled state
    getData().addSelectedPatternListener(new IPatternChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
       */
      public void patternChanged(TemplatePattern newPattern_p) {
        boolean hasDependencies = getData().hasDependencies();
        result.setEnabled(hasDependencies);
        if (hasDependencies)
          setDependenciesMessage();
        else
          setMessage(DEFAULT_MESSAGE);
      }
    });
    getData().addTemplateElementsChangedListener(new ITemplateElementsChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification.ITemplateElementsChangedListener#templateElementsChanged()
       */
      public void templateElementsChanged() {
        boolean hasDependencies = getData().hasDependencies();
        result.setEnabled(hasDependencies);
        if (hasDependencies)
          setDependenciesMessage();
        else
          setMessage(DEFAULT_MESSAGE);
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        Collection<EObject> dependencies = getData().getDependencies();
        promptAndAddDependencies(dependencies);
      }
    });
    return result;
  }

  /**
   * Create and return a button for including pattern instances
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createIncludeAllInstancesButton(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_IncludeInstancesLabel);
    result.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    boolean hasInst = getData().hasRelatedInstances();
    result.setEnabled(hasInst);
    // Enabled state
    getData().addSelectedPatternListener(new IPatternChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
       */
      public void patternChanged(TemplatePattern newPattern_p) {
        boolean hasInstances = getData().hasRelatedInstances();
        result.setEnabled(hasInstances);
      }
    });
    getData().addTemplateElementsChangedListener(new ITemplateElementsChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification.ITemplateElementsChangedListener#templateElementsChanged()
       */
      public void templateElementsChanged() {
        boolean hasInstances = getData().hasRelatedInstances();
        result.setEnabled(hasInstances);
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        Collection<AbstractPatternInstance> instances = getData().getRelatedInstances();
        promptAndAddInstances(instances);
      }
    });
    result.setVisible(false); // Not working yet
    return result;
  }

  /**
   * Create and return a menu item for local dependency management
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createIncludeDependenciesItem(final Menu menu_p,
      final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_IncludeDependencies);
    result.setEnabled(false);
    // Enabled state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        @SuppressWarnings("unchecked")
        List<EObject> selection = ((IStructuredSelection)event.getSelection()).toList();
        result.setEnabled(getData().hasDependencies(selection));
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        @SuppressWarnings("unchecked")
        List<EObject> selection = viewer_p.getSelection().toList();
        Collection<EObject> dependencies = getData().getDependencies(selection);
        promptAndAddDependencies(dependencies);
      }
    });
    return result;
  }

  /**
   * Create and return a menu item for adding the parents of the selected elements
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createIncludeParentItem(final Menu menu_p,
      final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_IncludeParent);
    result.setEnabled(false);
    // Enabled state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        @SuppressWarnings("unchecked")
        List<EObject> selection = ((IStructuredSelection)event.getSelection()).toList();
        selection = getData().filterNonModelNonInstanceElements(selection);
        boolean enable = false;
        for (EObject selected : selection) {
          EObject parent = selected.eContainer();
          if (parent != null && !getData().isInModelScope(parent)) {
            enable = true;
            break;
          }
        }
        result.setEnabled(enable);
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        @SuppressWarnings("unchecked")
        List<EObject> selection = viewer_p.getSelection().toList();
        selection = getData().filterNonModelNonInstanceElements(selection);
        Set<EObject> parents = new FHashSet<EObject>();
        for (EObject selected : selection) {
          EObject parent = selected.eContainer();
          if (parent != null && !getData().isInModelScope(parent))
            parents.add(parent);
        }
        IModelScope modelScope = getData().getModelScope();
        ElementInclusionDialog dialog = new ElementInclusionDialog(
            getShell(), null, parents, parents, modelScope);
        int answer = dialog.open();
        if (Window.OK == answer) {
          Collection<EObject> choices = dialog.getChoice();
          if (choices != null) {
            boolean addChildren = checkAddChildren(choices);
            getData().addElements(choices, addChildren, true);
          }
        }
      }
    });
    return result;
  }

  /**
   * Create the "create role" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createCreateRoleItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_CreateRole);
    result.setEnabled(false);
    // Enabled state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        @SuppressWarnings("unchecked")
        List<EObject> selection = ((IStructuredSelection)event.getSelection()).toList();
        selection = getData().filterNonModelNonInstanceElements(selection);
        result.setEnabled(!selection.isEmpty());
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
        List<EObject> selection = viewer_p.getSelection().toList();
        selection = getData().filterNonModelNonInstanceElements(selection);
        if (!selection.isEmpty()) {
          String defaultName;
          if (selection.size() > 1) {
            EClass type = ModelsUtil.getCommonType(selection);
            defaultName = getData().getRoleNameForType(type);
          } else {
            defaultName = getData().getText(selection.get(0));
          }
          String roleName = promptForRoleName(defaultName);
          if (roleName != null) {
            getData().addRoleFor(roleName, selection);
            validate();
            viewer_p.refresh();
          }
        }
      }
    });
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createMappingControls(org.eclipse.swt.widgets.Menu, org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer)
   */
  @Override
  protected void createMappingControls(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    createMapToCurrentRoleItem(menu_p, viewer_p);
    createMapToSomeRoleItem(menu_p, viewer_p);
    createCreateRoleItem(menu_p, viewer_p);
    createRemoveMappingItem(menu_p, viewer_p);
    new MenuItem(menu_p, SWT.SEPARATOR);
  }

  /**
   * Create the "map to role..." menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createMapToSomeRoleItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_MapToRole);
    result.setEnabled(false);
    // Enabled state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        @SuppressWarnings("unchecked")
        List<EObject> selection = ((IStructuredSelection)event.getSelection()).toList();
        selection = getData().filterNonModelNonInstanceElements(selection);
        result.setEnabled(!selection.isEmpty());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        RoleChoiceDialog dialog = new RoleChoiceDialog(getShell(), null, null,
            getData().getPattern(), SelectionKind.SINGLE);
        int answer = dialog.open();
        if (Window.OK == answer) {
          IPatternRole selectedRole = dialog.getChoice();
          if (selectedRole instanceof TemplatePatternRole) {
            @SuppressWarnings("unchecked")
            List<EObject> selection = viewer_p.getSelection().toList();
            selection = getData().filterNonModelNonInstanceElements(selection);
            for (EObject selectedElement : selection) {
              getData().mapToRole((TemplatePatternRole)selectedRole, selectedElement);
            }
            validate();
            viewer_p.refresh();
          }
        }
      }
    });
    return result;
  }

  /**
   * Create the "map to current role" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createMapToCurrentRoleItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_MapToCurrentRole);
    result.setEnabled(false);
    // Enabled state
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        boolean enable = newRole_p != null;
        if (enable) {
          @SuppressWarnings("unchecked")
          List<EObject> selection = viewer_p.getSelection().toList();
          selection = getData().filterNonModelNonInstanceElements(selection);
          enable = !selection.isEmpty();
        }
        result.setEnabled(enable);
      }
    });
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        boolean enable = getData().getRole() != null;
        if (enable) {
          @SuppressWarnings("unchecked")
          List<EObject> selection = viewer_p.getSelection().toList();
          selection = getData().filterNonModelNonInstanceElements(selection);
          enable = !selection.isEmpty();
        }
        result.setEnabled(enable);
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole currentRole = getData().getRole();
        for (Object selected : viewer_p.getSelection().toList()) {
          if (selected instanceof EObject) {
            EObject selectedElement = (EObject)selected;
            if (getData().isInModelScope(selectedElement))
              getData().mapToRole(currentRole, selectedElement);
          }
        }
        validate();
        viewer_p.refresh();
      }
    });
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createModelViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected ModelSubsetViewer createModelViewer(Composite parent_p) {  
    final ModelSubsetViewer resultViewer = new RoleBindingViewer(
        parent_p, true, false) {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.RoleBindingViewer#getText(org.eclipse.emf.ecore.EObject, java.lang.String)
       */
      @Override
      protected String getText(EObject element_p, String defaultText_p) {
        String result = defaultText_p;
        if (_ruleProvider != null) {
          String prefix = _ruleProvider.getPrefixText(element_p);
          if(!"".equals(prefix)){ //$NON-NLS-1$
            prefix = "(" + prefix  + ")_" ; //$NON-NLS-1$ //$NON-NLS-2$
          }
          result = prefix + result;
        } else {
          result = "?_" + result; //$NON-NLS-1$
        }
        if (AbstractModifiableTemplateElementsPage.this.getData().hasDependencies(element_p))
          result = UIUtil.markAsDependentElement(result);
        result = super.getText(element_p, result);
        return result;
      }
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        int result = ModelSubsetViewer.SORT | ModelSubsetViewer.EXPAND |
            ModelSubsetViewer.COLLAPSE;
        if (AbstractModifiableTemplateElementsPage.this.showParentsCheckbox())
          result = result | ModelSubsetViewer.SHOW_PARENTS;
        return result;
      }
    };
    resultViewer.setInput(getData());
    getData().addTemplateElementsChangedListener(
        new AbstractModifiableTemplatePatternSpecification.ITemplateElementsChangedListener() {
          /**
           * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification.ITemplateElementsChangedListener#templateElementsChanged()
           */
          public void templateElementsChanged() {
            resultViewer.setInput(getData());
            validate();
          }
        });
    return resultViewer;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createNavigationControls(org.eclipse.swt.widgets.Menu, org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer)
   */
  @Override
  protected void createNavigationControls(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    IUIExtender uiExtender =
      PatternsUIPlugin.getDefault().getSemanticUIUtil();
    if (uiExtender != null) {
      boolean created = uiExtender.createNavigationItems(menu_p, viewer_p);
      if (created)
        new MenuItem(menu_p, SWT.SEPARATOR);
    }
  }

  /**
   * Create the "remove from scope" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createRemoveFromScopeItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_Exclude);
    result.setEnabled(false);
    // Enabled state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        @SuppressWarnings("unchecked")
        List<EObject> selection = ((IStructuredSelection)event.getSelection()).toList();
        selection = getData().filterNonModelElements(selection);
        result.setEnabled(!selection.isEmpty());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        Collection<EObject> selectedElements = new FOrderedSet<EObject>();
        @SuppressWarnings("unchecked")
        Iterator<Object> it = viewer_p.getSelection().iterator();
        boolean childrenInvolved = false;
        while (it.hasNext()) {
          Object selected = it.next();
          if (selected instanceof EObject) {
            EObject selectedElement = (EObject)selected;
            if (getData().isInModelScope(selectedElement)) {
              selectedElements.add(selectedElement);
              if (!selectedElement.eContents().isEmpty() &&
                  !getData().isInstanceRelated(selectedElement))
                childrenInvolved = true;
            }
          }
        }
        if (!selectedElements.isEmpty() &&
            getData().getModelScope() instanceof FilteredModelScope) {
          boolean proceed = true;
          boolean removeChildren = true;
          if (childrenInvolved) {
            MessageDialog dialog = new MessageDialog(getShell(),
                CorePatternsPlugin.getDefault().getLabel(), null,
                Messages.AbstractModifiableTemplateElementsPage_ExcludeChildrenPrompt,
                MessageDialog.QUESTION,
                new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL,
              IDialogConstants.CANCEL_LABEL }, 2);
            int answer = dialog.open();
            proceed = answer != 2;
            removeChildren = answer == 0;
          } else {
            String message;
            if (selectedElements.size() == 1){
              IModelEnvironmentUI me = PatternsUIPlugin.getDefault().getModelEnvironmentUI();
              message = String.format(
                  Messages.AbstractModifiableTemplateElementsPage_ConfirmExcludeOne,
                  me.getText(selectedElements.iterator().next()));
            }   
            else
              message = String.format(
                  Messages.AbstractModifiableTemplateElementsPage_ConfirmExcludeMany,
                  Integer.valueOf(selectedElements.size()));
            proceed = MessageDialog.openConfirm(
                getShell(), CorePatternsPlugin.getDefault().getLabel(), message);
          }
          if (proceed)
            getData().removeElements(selectedElements, removeChildren);
        }
      }
    });
    return result;
  }

  /**
   * Create the "remove mapping" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createRemoveMappingItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.AbstractModifiableTemplateElementsPage_RemoveMapping);
    result.setEnabled(false);
    // Enabled state
    viewer_p.addSelectionListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = false;
        @SuppressWarnings("unchecked")
        List<EObject> selection = viewer_p.getSelection().toList();
        selection = getData().filterNonModelElements(selection);
        for (EObject selectedElement : selection) {
          Collection<TemplatePatternRole> roles = getData().getRolesOf(selectedElement);
          if (!roles.isEmpty()) {
            enable = true;
            break;
          }
        }
        result.setEnabled(enable);
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
        List<EObject> selection = viewer_p.getSelection().toList();
        selection = getData().filterNonModelElements(selection);
        for (EObject selectedElement : selection) {
          getData().removeFromRole(selectedElement);
        }
        validate();
        viewer_p.refresh();
      }
    });
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createScopeModificationControls(org.eclipse.swt.widgets.Menu, org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer)
   */
  @Override
  protected void createScopeModificationControls(Menu menu_p, ModelSubsetViewer viewer_p) {
    new MenuItem(menu_p, SWT.SEPARATOR);
    createRemoveFromScopeItem(menu_p, viewer_p);
    createAddToScopeItem(menu_p, viewer_p);
    createIncludeDependenciesItem(menu_p, viewer_p);
    createIncludeParentItem(menu_p, viewer_p);
  }

  /**
   * Prompt the user for adding dependency elements among the given ones
   * @param dependencies_p a non-null, potentially empty collection
   */
  protected void promptAndAddDependencies(Collection<? extends EObject> dependencies_p) {
    if (!dependencies_p.isEmpty()) {
      IModelScope modelScope = getData().getModelScope();
      ElementInclusionDialog dialog = new ElementInclusionDialog(
          getShell(), Messages.AbstractModifiableTemplateElementsPage_SelectDependencies,
          dependencies_p, dependencies_p, modelScope);
      int answer = dialog.open();
      if (Window.OK == answer) {
        Collection<EObject> choices = dialog.getChoice();
        if (choices != null) {
          boolean addChildren = checkAddChildren(choices);
          getData().addElements(choices, addChildren, true);
        }
      }
    }
  }

  /**
   * Prompt the user for adding dependency elements among the given ones
   * @param instances_p a non-null, potentially empty collection
   */
  protected void promptAndAddInstances(
      Collection<? extends AbstractPatternInstance> instances_p) {
    if (!instances_p.isEmpty()) {
      IModelScope modelScope = getData().getModelScope();
      ElementInclusionDialog dialog = new ElementInclusionDialog(
          getShell(), Messages.AbstractModifiableTemplateElementsPage_IncludeInstancesPrompt,
          instances_p, instances_p, modelScope);
      int answer = dialog.open();
      if (Window.OK == answer) {
        Collection<EObject> choices = dialog.getChoice();
        if (choices != null) {
          getData().addElements(choices, true, false);
        }
      }
    }
  }

  /**
   * Update the page message according to the fact that dependencies exist
   */
  protected void setDependenciesMessage() {
    setMessage(
        Messages.AbstractModifiableTemplateElementsPage_WarnDependencies,
        WARNING);
  }

}
