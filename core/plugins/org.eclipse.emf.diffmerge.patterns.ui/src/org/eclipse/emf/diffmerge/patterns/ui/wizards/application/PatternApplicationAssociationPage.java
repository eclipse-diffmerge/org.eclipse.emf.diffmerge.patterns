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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.application;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.ContainmentChoiceDialog;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.ElementMappingDialog;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.MergeTargetChoiceDialog;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.StorageChoiceDialog;
import org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.RoleBindingViewer;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractMultiRoleSelectionPage;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter;
import org.eclipse.emf.diffmerge.util.structures.FArrayList;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;



/**
 * A wizard page for applying an existing pattern.
 * @author Olivier Constant
 */
public class PatternApplicationAssociationPage 
extends AbstractMultiRoleSelectionPage<TemplatePatternApplicationSpecification> {

  /** A trivial enumeration for evaluation status of derivation rules */
  protected static enum RuleEvaluationStatus {
    OK, FAILURE, CANCEL
  }

  /**
   * A trivial structure that groups together a status and a set of elements returned by a rule evaluation
   */
  protected static class RuleEvaluationResult {
    final private RuleEvaluationStatus _status;
    final private List<EObject> _elements;

    /**
     * Constructor
     * @param status_p a non-null status which is FAILURE or CANCEL
     */
    public RuleEvaluationResult(RuleEvaluationStatus status_p) {
      _status = status_p;
      _elements = null;
    }

    /**
     * Constructor
     * @param status_p a non-null status
     */
    public RuleEvaluationResult(List<EObject> elements_p) {
      _status = RuleEvaluationStatus.OK;
      _elements = elements_p;
    }

    /**
     * Return the status of the evaluation
     * @return a non-null status
     */
    public RuleEvaluationStatus getStatus() {
      return _status;
    }

    /**
     * Return the elements returned by the evaluation
     * @return a potentially null collection
     */
    public List<EObject> getElements() {
      return _elements;
    }

    /**
     * Return whether this evaluation result is OK
     */
    public boolean isOK() {
      return getStatus() == RuleEvaluationStatus.OK;
    }
  }

  /** The number of columns in the layout of the page */
  private static final int COLUMNS_NB = 3;

  /** A viewer over the elements selected by the user, non-null after createControl has been called */
  protected ModelSubsetViewer _modelViewer;

  /** A text field for entering a multiplicity, non-null after createControl has been called */
  protected Text _multiplicityText;

  /** A text field for entering a number of instances, non-null after createControl has been called */
  protected Text _numberText;

  /** An optional diagram where application occurs */
  protected final Object _diagram;

  /**
   * Constructor
   * @param data_p the non-null pattern application to be defined
   * @param diagram_p an optional diagram where application occurs
   */
  public PatternApplicationAssociationPage(TemplatePatternApplicationSpecification data_p, Object diagram_p) {
    super("ApplicationPage", Messages.PatternApplicationAssociationPage_Header, //$NON-NLS-1$
          Messages.PatternApplicationAssociationPage_Message, data_p, true);
    _diagram = diagram_p;
  }

  /**
   * Return whether the "show instance" option should be available
   */
  protected boolean isShowInstanceEnabled() { 
    return _diagramUtil.isShowInstanceEnabled(_diagram);
  }
  
  /**
   * Create the "use for addition" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createAddMenuItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_AddRole);
    result.setEnabled(false);
    // Enabled state
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        result.setEnabled(computeAdditionMenuItemEnabled(viewer_p));
      }
    });
    viewer_p.getClientViewer().addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled(computeAdditionMenuItemEnabled(viewer_p));
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        Object selected = viewer_p.getSelection().getFirstElement();
        if (selected instanceof EObject) {
          EObject selectedElement = (EObject) selected;
          for (TemplatePatternRole role : getData().getRoles()) {
            setAdditionFromContainer(role, selectedElement);
          }
        }
      }
    });
    return result;
  }

  /**
   * Create the "Derive addition" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createDeriveAdditionMenuItem(final Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_DeriveAdd);
    result.setEnabled(false);
    // Enabled state
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        result.setEnabled(computeDeriveAdditionMenuItemEnabled());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        String ruleText = ""; //$NON-NLS-1$
        List<EObject> derivedList = Collections.emptyList();
        for (TemplatePatternRole role : getData().getRoles()) {
          ruleText = ((TextualRoleDerivationRule) role.getAdditionDerivationRule()).getSpecification();
          derivedList = deriveForAddition(role).getElements();
        }
        if (getData().getRoles().size() >= 1) {
          if (derivedList.isEmpty()) {
            MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(), Messages.PatternApplicationAssociationPage_RuleReturnsNone + '\n'
                                                                                            + ruleText);
          } else if (derivedList.size() > 1) {
            MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(), Messages.PatternApplicationAssociationPage_RuleReturnsMany + '\n'
                                                                                            + ruleText);
          } else {
            // Size == 1
            EObject target = derivedList.get(0);
            String targetName = DiscriminatingLabelProvider.getInstance().getText(target);
            MessageDialog.openInformation(getShell(), CorePatternsPlugin.getDefault().getLabel(), Messages.PatternApplicationAssociationPage_ComputedContainer
                                                                                                  + ' ' + targetName);
          }
        }
      }
    });
    return result;
  }

  /**
   * Create and return a menu item for automating the completion of the role mapping, giving priority to merge
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createGuessAddMenuItem(final Menu menu_p) {
    MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_GuessAdd);
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        guessMappingFromUI(false);
      }
    });
    return result;
  }

  /**
   * Create and return a menu item for automating the completion of the role mapping, giving priority to merge
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createGuessMergeMenuItem(final Menu menu_p) {
    MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_GuessMerge);
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        guessMappingFromUI(true);
      }
    });
    return result;
  }

  /**
   * Create the "Derive merge" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createDeriveMergeMenuItem(final Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_DeriveMerge);
    result.setEnabled(false);
    // Enabled state
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        result.setEnabled(computeDeriveMergeMenuItemEnabled());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        List<EObject> derivedList = Collections.emptyList();
        for (TemplatePatternRole role : getData().getRoles()) {
          derivedList = deriveForMerge(role).getElements();
          if (derivedList == null) {
            _modelViewer.refresh();
            getRolesViewer().refresh();
            getRolesViewer().setSelection(getRolesViewer().getSelection());
            validate();
            return;
          }
        }
        if (getData().getRoles().size() == 1) {
          TemplatePatternRole role = getData().getRoles().iterator().next();
          if (!role.isGeneric()) {
            if (derivedList.isEmpty()) {
              String ruleText = ((TextualRoleDerivationRule) role.getMergeDerivationRule()).getSpecification();
              MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(), "No element is computed by the rule:" + '\n' + ruleText); //$NON-NLS-1$
            } else {
              EObject firstTarget = derivedList.get(0);
              String targetName = DiscriminatingLabelProvider.getInstance().getText(firstTarget);
              String feedback;
              if (derivedList.size() > 1) {
                feedback = String.format(Messages.PatternApplicationAssociationPage_RuleResultMany, Integer.valueOf(derivedList.size()), targetName);
              } else {
                feedback = Messages.PatternApplicationAssociationPage_RuleResultTarget + targetName;
              }
              MessageDialog.openInformation(getShell(), CorePatternsPlugin.getDefault().getLabel(), feedback);
            }
          }
        }
        _modelViewer.refresh();
        getRolesViewer().refresh();
        getRolesViewer().setSelection(getRolesViewer().getSelection());
        validate();
      }
    });
    return result;
  }

  /**
   * Create the "Add in..." menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createFindContainerMenuItem(final Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_AddIn);
    result.setEnabled(true);
    // Enabled state
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        result.setEnabled(computeFindContainerMenuItemEnabled());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        Collection<EObject> templateElements = new FOrderedSet<EObject>();
        for (TemplatePatternRole role : getData().getRoles()) {
          templateElements.addAll(role.getTemplateElements());
        }
        Object scopeElement = getData().getScopeElement();
        if (scopeElement instanceof EObject) {
          String message;
          if (getData().getRoles().size() == 1) {
            message = String.format(Messages.PatternApplicationAssociationPage_SelectContainerSingleRole, getData().getRoles().iterator().next().getName());
          } else {
            message = Messages.PatternApplicationAssociationPage_SelectContainerManyRoles;
          }
          ISemanticRuleProvider ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(scopeElement);
          List<EObject> candidateContainers = ruleProvider.getPossibleContainersInContext(scopeElement, templateElements);
          if(candidateContainers == null){
        	  candidateContainers = new ArrayList<EObject>();
          }
          StorageChoiceDialog dialog = new StorageChoiceDialog(getShell(), message, candidateContainers, templateElements);
          int answer = dialog.open();
          if (Window.OK == answer) {
            IReferenceLocation location = dialog.getChoice();
            if (location != null) {
              for (TemplatePatternRole role : getData().getRoles()) {
                getData().getApplication().setLocation(role, location);
              }
              EObject container = location.getElement();
              getData().getSelectedElements().add(container);
              _modelViewer.setInput(getData());
              getRolesViewer().refresh();
              getRolesViewer().setSelection(getRolesViewer().getSelection());
              validate();
            }
          }
        }
      }
    });
    return result;
  }

  /**
   * Create the "Merge with..." menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createFindMergeTargetMenuItem(final Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_MergeWith);
    result.setEnabled(true);
    // Enabled state
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        result.setEnabled(computeFindMergeTargetMenuItemEnabled());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        final Object scopeElement = getData().getScopeElement();
        if ((scopeElement instanceof EObject) && (getData().getRoles().size() == 1)) {
          TemplatePatternRole role = getData().getRoles().iterator().next();
          final List<EObject> templateElements = role.getTemplateElements();
          ILocation location = null;
          if (templateElements.size() == 1) {
            // Unique element
            EClass mergeType = templateElements.get(0).eClass();
            String message = String.format(Messages.PatternApplicationAssociationPage_SelectMerge, role.getName());
            MergeTargetChoiceDialog dialog = new MergeTargetChoiceDialog(getShell(), message, (EObject) scopeElement, mergeType);
            int answer = dialog.open();
            if (Window.OK == answer) {
              location = dialog.getChoice();
            }
          } else {
            // Generic role: Perform detailed merge
            final List<EObject> candidates = new FArrayList<EObject>();
            try {
              PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
                /**
                 * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
                 */
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                  final Set<EClass> types = new HashSet<EClass>();
                  for (EObject templateElement : templateElements) {
                    types.add(templateElement.eClass());
                  }
                  candidates.addAll(ModelsUtil.getAllContents(EcoreUtil.getRootContainer((EObject) scopeElement), true, new IElementFilter() {
                    /**
                     * @see org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter#accepts(org.eclipse.emf.ecore.EObject)
                     */
                    public boolean accepts(EObject element_p) {
                      return types.contains(element_p.eClass());
                    }
                  }));
                }
              });
            } catch (Exception e) {
              // Proceed
            }
            ElementMappingDialog dialog = new ElementMappingDialog(getShell(), role, candidates);
            if (Window.OK == dialog.open()) {
              location = dialog.getResult();
            }
          }
          if (location != null) {
            boolean mergeMappingExists = false;
            EObject selectedElement = null;
            if(location instanceof BasicElementLocation){
            	selectedElement = ((BasicElementLocation) location).getElement();
            }else if(location instanceof BasicElementMappingLocation){
            	Iterator<EObject> it = ((BasicElementMappingLocation) location).getModelElements().iterator();
            	if(it.hasNext()){
            		selectedElement = it.next();
            	}
            }
            if(selectedElement != null){
            	 List<IPatternRole> mergeRoles = new ArrayList<IPatternRole>(getData().getApplication().getRolesOf(selectedElement));
                 mergeRoles.removeAll(getData().getApplication().getAdditionRolesOf(selectedElement));
                 int n = mergeRoles.size();
                 if (n > 0) {
                   mergeMappingExists = true;
                   MessageDialog.openInformation(getShell(), null,
                       Messages.PatternApplicationAssociationPage_UniqueAssociationByMerge + " " + //$NON-NLS-1$
                          mergeRoles.get(0).getName());
                 }	
                 if (!mergeMappingExists) {
                     getData().getApplication().setLocation(role, location);
                   }
                   extendSelectedElements(location);
                   _modelViewer.setInput(getData());
                   getRolesViewer().refresh();
                   getRolesViewer().setSelection(getRolesViewer().getSelection());
                   validate();
            }
          }
        }
      }
    });
    return result;
  }

  /**
   * Create the "reset role" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createResetMenuItem(final Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_ResetRole);
    result.setEnabled(true);
    // Enabled state
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        result.setEnabled(computeResetMenuItemEnabled());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        for (TemplatePatternRole role : getData().getRoles()) {
          getData().getApplication().setLocation(role, null);
        }
        result.setEnabled(false);
        _modelViewer.refresh();
        getRolesViewer().refresh();
        getRolesViewer().setSelection(getRolesViewer().getSelection());
        validate();
      }
    });
    return result;
  }

  /**
   * Create and return a menu item for resetting the whole role mapping
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createResetAllMenuItem(final Menu menu_p) {
    MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_ResetAllRoles);
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        for (TemplatePatternRole role : getData().getPattern().getRoles()) {
          getData().getApplication().setLocation(role, null);
        }
        getRolesViewer().refresh();
        getRolesViewer().setSelection(getRolesViewer().getSelection());
        _modelViewer.refresh();
        validate();
      }
    });
    return result;
  }

  /**
   * Return whether the "add" menu item should be enabled
   * @param viewer_p a non-null viewer on the model elements
   */
  protected boolean computeAdditionMenuItemEnabled(final ModelSubsetViewer viewer_p) {
    boolean result = false;
    if ((viewer_p.getSelection() != null) && (viewer_p.getSelection().size() == 1) && !getData().getRoles().isEmpty()) {
      Object selected = viewer_p.getSelection().getFirstElement();
      if (selected instanceof EObject) {
        EObject selectedElement = (EObject) selected;
        result = true;
        for (TemplatePatternRole role : getData().getRoles()) {
          if (getData().isAssigned(role) || getData().getApplicableAdditionLocations(role, selectedElement).isEmpty()) {
            result = false;
            break;
          }
        }
      }
    }
    return result;
  }

  /**
   * Return whether the "derive addition container" menu item should be enabled
   */
  protected boolean computeDeriveAdditionMenuItemEnabled() {
    if (getData().getRoles().isEmpty()) {
      return false;
    }
    for (TemplatePatternRole role : getData().getRoles()) {
      if (!role.acceptsAddition() || (role.getAdditionDerivationRule() == null)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Return whether the "derive merge" menu item should be enabled
   */
  protected boolean computeDeriveMergeMenuItemEnabled() {
    if (getData().getRoles().isEmpty()) {
      return false;
    }
    for (TemplatePatternRole role : getData().getRoles()) {
      if (!role.acceptsMerge() || (role.getMergeDerivationRule() == null)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Return whether the "Add in..." menu item should be enabled
   */
  protected boolean computeFindContainerMenuItemEnabled() {
    Collection<? extends TemplatePatternRole> roles = getData().getRoles();
    if (roles.isEmpty()) {
      return false;
    }
    for (TemplatePatternRole role : roles) {
      if (!role.acceptsAddition()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Return whether the "Merge with..." menu item should be enabled
   */
  protected boolean computeFindMergeTargetMenuItemEnabled() {
    boolean result = false;
    Collection<? extends TemplatePatternRole> roles = getData().getRoles();
    if (roles.size() == 1) {
      TemplatePatternRole role = roles.iterator().next();
      result = role.acceptsMerge() && ((role.getTemplateElements().size() < 2) || role.isGeneric());
    }
    return result;
  }

  /**
   * Return whether the "merge" menu item should be enabled
   * @param viewer_p a non-null viewer on the model elements
   */
  protected boolean computeMergeMenuItemEnabled(final ModelSubsetViewer viewer_p) {
    boolean result = false;
    if ((viewer_p.getSelection() != null) && (viewer_p.getSelection().size() == 1) && !getData().getRoles().isEmpty()) {
      Object selected = viewer_p.getSelection().getFirstElement();
      if (selected instanceof EObject) {
        EObject selectedElement = (EObject) selected;
        result = true;
        for (TemplatePatternRole role : getData().getRoles()) {
          IAtomicLocation location = getData().getApplicableMergeLocation(role, selectedElement);
          if (location == null) {
            result = false;
            break;
          }
        }
      }
    }
    return result;
  }

  /**
   * Return whether the "reset" menu item should be enabled
   */
  protected boolean computeResetMenuItemEnabled() {
    boolean result;
    Collection<? extends TemplatePatternRole> roles = getData().getRoles();
    if (roles.isEmpty()) {
      result = false;
    } else if (roles.size() > 1) {
      result = true;
    } else {
      result = getData().isAssigned(roles.iterator().next());
    }
    return result;
  }

  /**
   * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  public void createControl(Composite parent_p) {
    final Composite mainComposite = new Composite(parent_p, SWT.NONE);
    setControl(mainComposite);
    GridLayout mainCompositeLayout = new GridLayout(COLUMNS_NB, false);
    mainCompositeLayout.makeColumnsEqualWidth = true;
    mainComposite.setLayout(mainCompositeLayout);
    setDefaultMessage();
    // Left part
    createPatternPart(mainComposite);
    // Middle part
    Composite rolesComposite = createRoleControls(mainComposite, false);
    ((GridData) rolesComposite.getLayoutData()).horizontalAlignment = SWT.FILL;
    // Right part
    _modelViewer = createModelPart(mainComposite);
    // Bottom part
    createInitializationControls(mainComposite);
    // Additional menus
    final Menu menu = new Menu(getRolesViewer().getControl());
    createResetMenuItem(menu);
    createFindMergeTargetMenuItem(menu);
    createFindContainerMenuItem(menu);
    new MenuItem(menu, SWT.SEPARATOR);
    createDeriveMergeMenuItem(menu);
    createDeriveAdditionMenuItem(menu);
    new MenuItem(menu, SWT.SEPARATOR);
    createResetAllMenuItem(menu);
    createGuessMergeMenuItem(menu);
    createGuessAddMenuItem(menu);
    getRolesViewer().getControl().setMenu(menu);
  }

  /**
   * Create the "use for merge" menu item
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return a non-null menu item
   */
  private MenuItem createMergeMenuItem(final Menu menu_p, final ModelSubsetViewer viewer_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_MergeWithRole);
    result.setEnabled(false);
    // Enabled state
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        result.setEnabled(computeMergeMenuItemEnabled(viewer_p));
      }
    });
    viewer_p.getClientViewer().addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled(computeMergeMenuItemEnabled(viewer_p));
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        Object selected = viewer_p.getSelection().getFirstElement();
        if (selected instanceof EObject) {
          EObject selectedElement = (EObject) selected;
          for (TemplatePatternRole role : getData().getRoles()) {
            IAtomicLocation location = getData().getApplicableMergeLocation(role, selectedElement);
            if (location != null) {
              // SKANDER::START OK!
              // The rule to enforce is that a model element should not be mapped to more than one role in merge mode
              boolean mergeMappingExists = false;
              List<IPatternRole> mergeRoles = new ArrayList<IPatternRole>(getData().getApplication().getRolesOf(selectedElement));
              mergeRoles.removeAll(getData().getApplication().getAdditionRolesOf(selectedElement));
              int n = mergeRoles.size();
              if (n > 0) {
                mergeMappingExists = true;
                MessageDialog.openInformation(getShell(), null,
                    Messages.PatternApplicationAssociationPage_UniqueAssociationByMerge + " " + //$NON-NLS-1$
                        mergeRoles.get(0).getName());
              }
              if (!mergeMappingExists) {
                getData().getApplication().setLocation(role, location);
              }
              // SKANDER::END
            }
          }
          viewer_p.refresh();
          getRolesViewer().refresh();
          getRolesViewer().setSelection(getRolesViewer().getSelection());
          validate();
        }
      }
    });
    return result;
  }

  /**
   * Create a viewer and return on the selection in the current model
   * @param parent_p a non-null composite
   * @return a non-null viewer
   */
  private ModelSubsetViewer createModelPart(Composite parent_p) {
    final Group modelGroup = createGroup(parent_p, Messages.PatternApplicationAssociationPage_Selected, true, 1);
    final ModelSubsetViewer modelViewer = new RoleBindingViewer(modelGroup, false, false) {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        return ModelSubsetViewer.SHOW_PARENTS;
      }
    };
    modelViewer.setInput(getData());
    final Menu menu = new Menu(modelViewer.getClientViewer().getTree());
    createMergeMenuItem(menu, modelViewer);
    createAddMenuItem(menu, modelViewer);
    modelViewer.getClientViewer().getTree().setMenu(menu);
    return modelViewer;
  }

  /**
   * Create a viewer on pattern content w.r.t. the selected role
   * @param parent_p a non-null composite
   */
  private void createPatternPart(Composite parent_p) {
    final Group patternGroup = createGroup(parent_p, Messages.PatternApplicationAssociationPage_RoleContents, true, 1);
    final Group descriptionGroup = createGroup(patternGroup, Messages.PatternApplicationAssociationPage_Description, true, 1);
    final Text descriptionText = new Text(descriptionGroup, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
    descriptionText.setEditable(false);
    GridData textData = new GridData(SWT.FILL, SWT.FILL, true, true);
    descriptionText.setLayoutData(textData);
    final ModelSubsetViewer resultViewer = new ModelSubsetViewer(patternGroup, false, false) {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getExpandDepth()
       */
      @Override
      protected int getExpandDepth() {
        return 2;
      }

      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        return ModelSubsetViewer.NONE;
      }
    };
    getData().addSelectedRolesListener(new IMultiRoleSelection.IRolesChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IMultiRoleSelection.IRolesChangedListener#rolesChanged(java.util.Collection)
       */
      public void rolesChanged(Collection<? extends TemplatePatternRole> newRoles_p) {
        String newDescription = newRoles_p.size() == 1 ? newRoles_p.iterator().next().getDescription() : ""; //$NON-NLS-1$
        java.util.List<EObject> newElements = new FOrderedSet<EObject>();
        for (TemplatePatternRole newRole : newRoles_p) {
          newElements.addAll(newRole.getTemplateElements());
        }
        descriptionText.setText(newDescription);
        resultViewer.setInput(ModelsUtil.getAllContents(newElements, true, null));
      }
    });
    resultViewer.getClientViewer().getControl().setEnabled(true);
  }

  /**
   * Derive the given role for merge if possible
   * @param role_p a non-null role
   * @return a non-null evaluation result
   */
  protected RuleEvaluationResult deriveForMerge(TemplatePatternRole role_p) {
    RuleEvaluationResult result;
    List<EObject> evalResult = role_p.getMergeDerivationRule().deriveCandidateElements(getData().getApplication());
    if (evalResult != null) {
      if (role_p.isGeneric()) {
        // Perform detailed merge
        ElementMappingDialog dialog = new ElementMappingDialog(getShell(), role_p, evalResult);
        if (Window.OK == dialog.open()) {
          getData().getApplication().setLocation(role_p, dialog.getResult());

          result = new RuleEvaluationResult(evalResult);
        } else {
          result = new RuleEvaluationResult(RuleEvaluationStatus.CANCEL);
        }
      } else {
        // Template elements are multiple: treat as such
        if (!evalResult.isEmpty()) {
          getData().getApplication().setLocation(role_p, null);
          for (EObject target : evalResult) {
            IElementLocation location = new BasicElementLocation(target);
            getData().getApplication().addLocation(role_p, location);
          }
          result = new RuleEvaluationResult(evalResult);
        } else {
          result = new RuleEvaluationResult(RuleEvaluationStatus.FAILURE);
        }
      }
    } else {
      result = new RuleEvaluationResult(RuleEvaluationStatus.FAILURE);
    }
    return result;
  }

  /**
   * Create and return the controls for the "display when done" property in the given composite
   * @param parent_p a non-null composite
   * @return a non-null check box
   * -- SKANDER
   */
  private Button createDisplayControls(Composite parent_p) {
    // Definition: "Show" button
    final Button result = new Button(parent_p, SWT.CHECK);
    GridData data = new GridData(SWT.LEFT, SWT.TOP, true, false);
    result.setLayoutData(data);
    boolean showInstanceAvailable = isShowInstanceEnabled();
    getData().setDisplayWhenDone(showInstanceAvailable);
    result.setEnabled(showInstanceAvailable);
    result.setText(Messages.PatternApplicationAssociationPage_ShowInstance);
    result.setSelection(getData().mustDisplayWhenDone());
    // Definition: "Layout" button
    final Button layoutCheckbox = new Button(parent_p, SWT.CHECK);
    GridData dataLayoutCheckbox = new GridData(SWT.LEFT, SWT.TOP, true, false);
    layoutCheckbox.setLayoutData(dataLayoutCheckbox);
    layoutCheckbox.setEnabled(getData().mayReuseLayoutAndStyle());
    layoutCheckbox.setText(Messages.PatternApplicationAssociationPage_ReuseLayout);
    layoutCheckbox.setSelection(getData().mustReuseLayout());
    layoutCheckbox.setEnabled(showInstanceAvailable);
    //
    new Label(parent_p, SWT.None);
    // Definition: "reuse style" checkbox
    final Button styleCheckbox = new Button(parent_p, SWT.CHECK);
    GridData dataStyleCheckbox = new GridData(SWT.LEFT, SWT.TOP, true, false);
    styleCheckbox.setLayoutData(dataStyleCheckbox);
    styleCheckbox.setEnabled(getData().mayReuseLayoutAndStyle());
    styleCheckbox.setText(Messages.PatternApplicationAssociationPage_ReuseStyle);
    styleCheckbox.setSelection(getData().mustReuseStyle());
    styleCheckbox.setEnabled(showInstanceAvailable);
    // Behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        getData().setDisplayWhenDone(!getData().mustDisplayWhenDone());
      }
    });
    layoutCheckbox.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        getData().setReuseLayout(layoutCheckbox.getSelection());
      }
    });
    //
    styleCheckbox.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        getData().setReuseStyle(styleCheckbox.getSelection());
      }
    });
    // Update
    getData().addSelectedPatternListener(new IPatternChangedListener() {
      /**
       * @see IPatternChangedListener#patternChanged(TemplatePattern)
       */
      public void patternChanged(TemplatePattern newPattern_p) {
        boolean layoutIsPresent = getData().mayReuseLayoutAndStyle();
        layoutCheckbox.setEnabled(getData().mustDisplayWhenDone() && layoutIsPresent);
        layoutCheckbox.setSelection(layoutIsPresent && getData().mustReuseLayout());
        styleCheckbox.setEnabled(getData().mustDisplayWhenDone() && layoutIsPresent);
        styleCheckbox.setSelection(layoutIsPresent && getData().mustReuseStyle());
      }
    });
    return result;
  }

  /**
   * Create and return the controls for setting up the instance
   * @param parent_p a non-null composite
   * @return a non-null check box
   */
  private Composite createInitializationControls(Composite parent_p) {
    Group result = new Group(parent_p, SWT.NONE);
    result.setText(Messages.PatternApplicationAssociationPage_Initialization);
    GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);
    data.horizontalSpan = COLUMNS_NB;
    result.setLayoutData(data);
    GridLayout layout = new GridLayout(2, true);
    result.setLayout(layout);
    _numberText = createNumberControls(result);
    _multiplicityText = createMultiplicityControls(result);
    createUnfoldControls(result);
    createDisplayControls(result);
    return result;
  }

  /**
   * Create the controls for setting up the multiplicity of the instance
   * @param parent_p a non-null composite
   * @return a non-null text field
   */
  private Text createMultiplicityControls(Composite parent_p) {
    // Composite
    Composite composite = new Composite(parent_p, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
    GridLayout layout = new GridLayout(3, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    composite.setLayout(layout);
    // Label
    final Label label = new Label(composite, SWT.NONE);
    label.setText(Messages.PatternApplicationAssociationPage_Multiplicity);
    boolean mustEnable = (getData().getPattern() != null) && !getData().getPattern().getMultiElements().isEmpty();
    label.setEnabled(mustEnable);
    // Text
    final Text result = new Text(composite, SWT.SINGLE | SWT.BORDER);
    GridData data = new GridData();
    data.widthHint = 20;
    result.setLayoutData(data);
    final String defaultMultiplicity = String.valueOf(getData().getMultiplicity());
    result.setText(defaultMultiplicity);
    result.setEnabled(mustEnable);
    result.setToolTipText(Messages.PatternApplicationAssociationPage_MultiplicityTooltip);
    // Data update
    result.addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      public void modifyText(ModifyEvent e_p) {
        try {
          int multiplicity = Integer.parseInt(result.getText());
          getData().setMultiplicity(multiplicity);
        } catch (NumberFormatException e) {
          // Do nothing
        }
        validate();
      }
    });
    // Enabled state
    getData().addSelectedPatternListener(new IPatternChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
       */
      public void patternChanged(TemplatePattern newPattern_p) {
        boolean enable = (newPattern_p != null) && !newPattern_p.getMultiElements().isEmpty();
        label.setEnabled(enable);
        result.setEnabled(enable);
        if (!enable) {
          result.setText(defaultMultiplicity);
        }
      }
    });
    return result;
  }

  /**
   * Create the controls for setting up the multiplicity of the instance
   * @param parent_p a non-null composite
   * @return a non-null text field
   */
  private Text createNumberControls(Composite parent_p) {
    // Composite
    Composite composite = new Composite(parent_p, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
    GridLayout layout = new GridLayout(3, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    composite.setLayout(layout);
    // Label
    final Label label = new Label(composite, SWT.NONE);
    label.setText(Messages.PatternApplicationAssociationPage_NumberOfInstancesLabel);
    // Text
    final Text result = new Text(composite, SWT.SINGLE | SWT.BORDER);
    GridData data = new GridData();
    data.widthHint = 20;
    result.setLayoutData(data);
    final String defaultNumber = String.valueOf(getData().getNumberOfApplications());
    result.setText(defaultNumber);
    result.setToolTipText(Messages.PatternApplicationAssociationPage_NumberOfInstancesTooltip);
    // Data update
    result.addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      public void modifyText(ModifyEvent e_p) {
        try {
          int number = Integer.parseInt(result.getText());
          getData().setNumberOfApplications(number);
        } catch (NumberFormatException e) {
          // Do nothing
        }
        validate();
      }
    });
    return result;
  }

  /**
   * Create and return the controls for the "unfold when done" property in the given composite
   * @param parent_p a non-null composite
   * @return a non-null check box
   */
  private Button createUnfoldControls(Composite parent_p) {
    // Unfold check box
    Button result = new Button(parent_p, SWT.CHECK);
    GridData data = new GridData(SWT.LEFT, SWT.TOP, true, false);
    result.setLayoutData(data);
    result.setText(Messages.PatternApplicationAssociationPage_UnfoldInstance);
    result.setSelection(getData().mustUnfoldWhenDone());
    // Naming rule area
    final Composite nrComposite = new Composite(parent_p, SWT.NONE);
    GridData nrcData = new GridData(SWT.FILL, SWT.TOP, true, false);
    nrComposite.setLayoutData(nrcData);
    GridLayout nrLayout = new GridLayout(3, false);
    nrLayout.marginHeight = 0;
    nrLayout.marginWidth = 0;
    nrComposite.setLayout(nrLayout);
    // Naming rule content: Label
    Label nrLabel = new Label(nrComposite, SWT.NONE);
    nrLabel.setText(Messages.PatternApplicationAssociationPage_NamingRule);
    // Naming rule content: Text
    final Text nrText = new Text(nrComposite, SWT.SINGLE | SWT.BORDER);
    GridData nrtData = new GridData(SWT.FILL, SWT.FILL, true, false);
    nrText.setLayoutData(nrtData);
    nrText.setText(getData().getNamingRule());
    nrText.setToolTipText(String.format(Messages.PatternApplicationAssociationPage_NamingRuleTooltip, NamingUtil.getNeutralRenamingRule(),
        NamingUtil.getIndexSymbol()));
    // Naming rule content: "propose" check box
    final Button nrPropose = new Button(nrComposite, SWT.PUSH);
    nrPropose.setText(Messages.PatternApplicationAssociationPage_Propose);
    // Check box behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        boolean newUnfold = !getData().mustUnfoldWhenDone();
        getData().setUnfoldWhenDone(newUnfold);
        enableAll(nrComposite, newUnfold, true);
      }
    });
    // Naming rule text behavior
    nrText.addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      public void modifyText(ModifyEvent e_p) {
        getData().setNamingRule(nrText.getText());
      }
    });
    // "Propose" check box behavior
    nrPropose.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        String namingRule;
        if (hasSignificantNumber()) {
          namingRule = NamingUtil.getSymbolicIndexedName();
        } else {
          namingRule = NamingUtil.proposeNamingRule(getData().getApplication());
        }
        if (namingRule == null) {
          namingRule = NamingUtil.getNeutralRenamingRule();
        }
        if (!namingRule.equals(getData().getNamingRule())) {
          nrText.setText(namingRule);
        }
      }
    });
    return result;
  }

  /**
   * Derive the given role for addition if possible
   * @param role_p a non-null role
   * @return a non-null evaluation result
   */
  protected RuleEvaluationResult deriveForAddition(TemplatePatternRole role_p) {
    RuleEvaluationResult result;
    List<EObject> evalResult = role_p.getAdditionDerivationRule().deriveCandidateElements(getData().getApplication());
    if ((evalResult != null) && (evalResult.size() == 1)) {
      setAdditionFromContainer(role_p, evalResult.get(0));
      result = new RuleEvaluationResult(evalResult);
    } else {
      result = new RuleEvaluationResult(RuleEvaluationStatus.FAILURE);
    }
    return result;
  }

  /**
   * Update the graphical list of selected elements according to the elements at the given location
   * @param location_p a non-null location
   */
  protected void extendSelectedElements(ILocation location_p) {
    List<EObject> targets = LocationsUtil.getMergeTargets(location_p);
    List<EObject> involved = LocationsUtil.getInvolvedElements(location_p);
    List<EObject> set = new FOrderedSet<EObject>();
    set.addAll(getData().getSelectedElements());
    set.addAll(targets);
    set.addAll(involved);
    set = ModelsUtil.getRoots(set);
    getData().getSelectedElements().clear();
    getData().getSelectedElements().addAll(set);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSelectionPage#getTextForRole(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole,
   *      java.lang.String)
   */
  @Override
  protected String getTextForRole(TemplatePatternRole role_p, String defaultLabel_p) {
    String result = defaultLabel_p;
    if (!getData().isAssigned(role_p)) {
      if (role_p.isDerivable(true) || role_p.isDerivable(false)) {
        result = UIUtil.markAsDerivableRole(result);
      }
      result = UIUtil.markAsFreeRole(result);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#getValidationMessage()
   */
  @Override
  protected String getValidationMessage() {
    String result = super.getValidationMessage();
    if ((result == null) && (_multiplicityText != null) && (_numberText != null)) {
      try {
        int multiplicity = Integer.parseInt(_multiplicityText.getText());
        int number = Integer.parseInt(_numberText.getText());
        if ((multiplicity < 1) || (number < 1)) {
          result = Messages.PatternApplicationAssociationPage_MultiplicityPositive;
        }
      } catch (NumberFormatException e) {
        result = Messages.PatternApplicationAssociationPage_MultiplicityInteger;
      }
    }
    return result;
  }

  /**
   * Try and find a global role mapping and notify the user
   * @param mergeFirst_p whether merge should take priority over addition
   */
  protected void guessMappingFromUI(boolean mergeFirst_p) {
    RuleEvaluationResult result = new RuleEvaluationResult(RuleEvaluationStatus.OK);
    TemplatePatternRole faultyRole = null;
    for (TemplatePatternRole role : getData().getPattern().getRoles()) {
      if (getData().getApplication().getLocation(role) == null) {
        result = mergeFirst_p ? guessMergeBasedMappingFor(role) : guessAdditionBasedMappingFor(role);
        if (result.getStatus() == RuleEvaluationStatus.FAILURE) {
          faultyRole = role;
        }
        if (result.isOK()) {
          ILocation location = getData().getApplication().getLocation(role);
          if (location != null) {
            extendSelectedElements(location);
          }
        } else {
          break;
        }
      }
    }
    _modelViewer.setInput(getData());
    getRolesViewer().refresh();
    getRolesViewer().setSelection(getRolesViewer().getSelection());
    _modelViewer.refresh();
    validate();
    final String title = getWizard().getWindowTitle();
    if (result.isOK()) {
      MessageDialog.openInformation(getShell(), title, Messages.PatternApplicationAssociationPage_GuessOK);
    } else if (faultyRole != null) {
      MessageDialog.openWarning(getShell(), title, String.format(Messages.PatternApplicationAssociationPage_GuessFailed, faultyRole.getName()));
    }
  }

  /**
   * Try and find a mapping for the given role, giving priority to addition
   * @param role_p a non-null role
   * @return whether the attempt was successful
   */
  protected RuleEvaluationResult guessAdditionBasedMappingFor(TemplatePatternRole role_p) {
    RuleEvaluationResult result = new RuleEvaluationResult(RuleEvaluationStatus.FAILURE);
    // Try and derive for addition
    boolean derivableForAddition = role_p.isDerivable(false);
    if (derivableForAddition) {
      result = deriveForAddition(role_p);
    }
    if (!result.isOK()) {
      // Try and derive for merge
      boolean derivableForMerge = role_p.isDerivable(true);
      if (derivableForMerge) {
        result = deriveForMerge(role_p);
      }
      if (!result.isOK() && guessContainerFromSelection(role_p)) {
        // Try and find a container among the elements selected
        result = new RuleEvaluationResult(RuleEvaluationStatus.OK);
      }
      // Try and find a container among the containers of the elements (added or merged)
      if (!result.isOK() && guessContainerFromApplication(role_p)) {
        result = new RuleEvaluationResult(RuleEvaluationStatus.OK);
      }
      // Try and find a merge target among the elements selected
      if (!result.isOK() && guessMergeTargetFromSelection(role_p)) {
        result = new RuleEvaluationResult(RuleEvaluationStatus.OK);
      }
    }
    return result;
  }

  /**
   * Try and find a mapping for the given role, giving priority to merge
   * @param role_p a non-null role
   * @return a non-null evaluation result
   */
  protected RuleEvaluationResult guessMergeBasedMappingFor(TemplatePatternRole role_p) {
    RuleEvaluationResult result = new RuleEvaluationResult(RuleEvaluationStatus.FAILURE);
    // Try and derive for merge
    boolean derivableForMerge = role_p.isDerivable(true);
    if (derivableForMerge) {
      result = deriveForMerge(role_p);
    }
    if (!result.isOK()) {
      // Try and derive for addition
      boolean derivableForAddition = role_p.isDerivable(false);
      if (derivableForAddition) {
        result = deriveForAddition(role_p);
      }
      // Try and find a merge target among the elements selected
      if (!result.isOK() && !derivableForMerge && !derivableForAddition) {
        // Try and find a container among the containers of the elements (added or merged)
        if (guessMergeTargetFromSelection(role_p) || guessContainerFromApplication(role_p)) {
          result = new RuleEvaluationResult(RuleEvaluationStatus.OK);
        }
      }
    }
    return result;
  }

  /**
   * Try and find a container for the given role based on the current application
   * @param role_p a non-null role
   * @return whether the attempt was successful
   */
  protected boolean guessContainerFromApplication(TemplatePatternRole role_p) {
    boolean result = false;
    if (role_p.acceptsAddition() && (role_p.getTemplateElements().size() == 1)) {
      EObject templateElement = role_p.getTemplateElements().get(0);
      BasicPatternApplication application = getData().getApplication();
      Iterator<TemplatePatternRole> it = role_p.getPattern().getRoles().iterator();
      // Try locations associated to previous roles
      ISemanticRuleProvider ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(getData().getScopeElement());
      while (!result && it.hasNext()) {
        TemplatePatternRole previousRole = it.next();
        if (previousRole == role_p) {
          break; // Current role reached: failure
        }
        ILocation location = application.getLocation(previousRole);
        if (location != null) {
          EObject candidateContainer = null;
          EReference candidateContainment = null;
          IAtomicLocation atomicLocation = location.getAtomicContents().get(0);
          if (atomicLocation instanceof IReferenceLocation) {
            // Reference location: try it
            candidateContainer = ((IReferenceLocation) atomicLocation).getElement();
            candidateContainment = ((IReferenceLocation) atomicLocation).getReference();
            if (!ruleProvider.supportsAdditionOf(candidateContainer, candidateContainment, templateElement, true)) {
              candidateContainment = null;
            }
          } else if (atomicLocation instanceof IElementLocation) {
            // Element location for merge: try its container
            EObject mergeTarget = ((IElementLocation) atomicLocation).getElement();
            candidateContainer = mergeTarget.eContainer();
          }
          if ((candidateContainer != null) && (candidateContainment == null)) {
            // We have a container but no reference: try and find one
            List<EReference> candidateContainments = ruleProvider.getReferencesForAddition(candidateContainer, templateElement.eClass(), true, true);
            if(candidateContainments != null){
            	 if (!candidateContainments.isEmpty()) {
                     candidateContainment = candidateContainments.get(0);
                 }
            }
          }
          if ((candidateContainer != null) && (candidateContainment != null)) {
            // We have a container and a reference: success
            BasicReferenceLocation referenceLocation = new BasicReferenceLocation(candidateContainer, candidateContainment);
            application.setLocation(role_p, referenceLocation);
            result = true;
          }
        }
      }
    }
    return result;
  }

  /**
   * Try and find an addition target for the given role based on the user selection
   * @param role_p a non-null role
   * @return whether the attempt was successful
   */
  protected boolean guessContainerFromSelection(TemplatePatternRole role_p) {
    boolean result = false;
    if (role_p.acceptsAddition()) {
      BasicPatternApplication application = getData().getApplication();
      Iterator<EObject> selectionIt = getData().getSelectedElements().iterator();
      while (selectionIt.hasNext() && !result) {
        EObject selectedElement = selectionIt.next();
        Iterator<EReference> containmentsIt = selectedElement.eClass().getEAllContainments().iterator();
        while (containmentsIt.hasNext() && !result) {
          EReference containment = containmentsIt.next();
          IReferenceLocation candidateLocation = new BasicReferenceLocation(selectedElement, containment);
          if (role_p.checkApplicability(candidateLocation, application).isOk() && (!role_p.isExclusive() || application.getRolesOf(selectedElement).isEmpty())) {
            application.setLocation(role_p, candidateLocation);
            result = true;
          }
        }
      }
    }
    return result;
  }

  /**
   * Try and find a merge target for the given role based on the user selection
   * @param role_p a non-null role
   * @return whether the attempt was successful
   */
  protected boolean guessMergeTargetFromSelection(TemplatePatternRole role_p) {
    boolean result = false;
    if (role_p.acceptsMerge()) {
      BasicPatternApplication application = getData().getApplication();
      for (EObject selectedElement : getData().getSelectedElements()) {
        IElementLocation elementLocation = new BasicElementLocation(selectedElement);
        if (role_p.checkApplicability(elementLocation, application).isOk() && (!role_p.isExclusive() || application.getRolesOf(selectedElement).isEmpty())) {
          application.setLocation(role_p, elementLocation);
          result = true;
          break;
        }
      }
    }
    return result;
  }

  /**
   * Return whether the number of instances to create is greater than 1
   */
  protected boolean hasSignificantNumber() {
    boolean result = false;
    if (_numberText != null) {
      try {
        int number = Integer.parseInt(_numberText.getText());
        if (number > 1) {
          result = true;
        }
      } catch (NumberFormatException e) {
        // Proceed
      }
    }
    return result;
  }



  /**
   * Handle the given element as a container for addition on the given role
   * @param role_p a non-null role
   * @param container_p a non-null element
   */
  protected void setAdditionFromContainer(TemplatePatternRole role_p, EObject container_p) {
    Collection<IReferenceLocation> locations = getData().getApplicableAdditionLocations(role_p, container_p);
    IAtomicLocation location = null;
    if (locations.size() == 1) {
      location = locations.iterator().next();
    } else if (!locations.isEmpty()) {
      IReferenceLocation defaultSelection = null;
      EReference preferred = role_p.getPreferredContainment();
      if (preferred != null) {
        for (IReferenceLocation current : locations) {
          if (current.getReference() == preferred) {
            defaultSelection = current;
            break;
          }
        }
      }
      ContainmentChoiceDialog dialog =
          new ContainmentChoiceDialog(getShell(), null, Messages.PatternApplicationAssociationPage_PromptForContainment, locations, defaultSelection);
      int answer = dialog.open();
      if (Window.OK == answer) {
        location = dialog.getChoice();
      }
    }
    if (location != null) {
      // Mapping by addition
      getData().getApplication().setLocation(role_p, location);
      _modelViewer.refresh();
      getRolesViewer().refresh();
      getRolesViewer().setSelection(getRolesViewer().getSelection());
      validate();
    }
  }

}
