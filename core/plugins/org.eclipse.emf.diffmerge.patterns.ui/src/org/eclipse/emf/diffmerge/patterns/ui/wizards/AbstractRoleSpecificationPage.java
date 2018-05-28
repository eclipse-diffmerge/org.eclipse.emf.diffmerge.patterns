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
import java.util.HashSet;

import org.eclipse.emf.diffmerge.patterns.templates.ocl.OclPatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.OclInputMessageDialog;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;


/**
 * A wizard page representing the characteristics of pattern roles.
 * @author Olivier Constant
 */
public abstract class AbstractRoleSpecificationPage
<T extends AbstractBijectiveTemplatePatternSpecification>
extends AbstractRoleSelectionPage<T> {
  
  /** A representation of the absence of data */
  static final String NO_DATA = Messages.AbstractRoleSpecificationPage_None;
  
  /** The controls which must remain enabled */
  protected final Collection<Control> _alwaysEnabled;

  /** The controls which must remain disabled */
  protected final Collection<Control> _alwaysDisabled;
  
  /**
   * Constructor
   * @param pageTitle_p the optional title of the page
   * @param defaultMessage_p a non-null default message for the page
   * @param data_p the specification of the pattern
   * @param isBlocking_p whether the page must be completed before the Next button can be clicked
   */
  public AbstractRoleSpecificationPage(String pageTitle_p, String defaultMessage_p,
      T data_p, boolean isBlocking_p) {
    super("RolesPage", pageTitle_p, defaultMessage_p, data_p, isBlocking_p); //$NON-NLS-1$
    _alwaysEnabled = new HashSet<Control>();
    _alwaysDisabled = new HashSet<Control>();
  }
  
  /**
   * Create the lines for addition specification
   * @param parent_p a non-null composite
   */
  protected void createAdditionGroup(final Composite parent_p) {
    final Composite additionComposite = createGroup(parent_p, Messages.AbstractRoleSpecificationPage_ApplyAdd, true, 3);
    fillLineWith(additionComposite);
    // Allow application by addition
    createAllowAdditionButton(additionComposite);
    if (!showSimplifiedInterface()) {
      // Preferred containment
      createPreferredContainmentLine(additionComposite);
    }
    // Container derivation rule
    createContainerDerivationLine(additionComposite);
  }
  
  /**
   * Create and return the "allow addition" check box
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createAllowAdditionButton(final Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.AbstractRoleSpecificationPage_AllowApplyAdd);
    fillLineWith(result);
    // Modify views from input
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        AdditionKind kind = getData().getRole().getAdditionKind();
        if (kind == AdditionKind.FORBIDDEN)
          getData().getRole().setAdditionKind(AdditionKind.ANY_CONTAINMENT);
        else
          getData().getRole().setAdditionKind(AdditionKind.FORBIDDEN);
        enableAll(parent_p, result.getSelection(), true);
        parent_p.setEnabled(true);
        result.setEnabled(true);
      }
    });
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        if (newRole_p != null) {
          boolean allowAddition = newRole_p.getAdditionKind() != AdditionKind.FORBIDDEN;
          result.setSelection(allowAddition);
          if (allowAddition) {
            enableAll(parent_p, true, true, _alwaysEnabled, _alwaysDisabled);
          } else {
            enableAll(parent_p, false, true);
            parent_p.setEnabled(true);
            result.setEnabled(!isReadOnly());
          }
        }
      }
    });
    if (isReadOnly())
      _alwaysDisabled.add(result);
    return result;
  }
  
  /**
   * Create the line for specifying role conformity constraints
   * @param parent_p a non-null composite
   */
  protected void createConformityLine(final Composite parent_p) {
    // 1. Label
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractRoleSpecificationPage_ConformityConstraint);
    // 2. Text
    final Text conformityConstraint = new Text(parent_p, SWT.BORDER);
    conformityConstraint.setEditable(false);
    GridData conformityConstraintData = new GridData(SWT.FILL, SWT.TOP, true, false);
    conformityConstraint.setLayoutData(conformityConstraintData);
    // 3. Button
    final Button conformityConstraintButton = new Button(parent_p, SWT.PUSH);
    conformityConstraintButton.setText("..."); //$NON-NLS-1$
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        String toSet = NO_DATA;
        if (newRole_p != null)
          toSet = getConformityConstraint(newRole_p);
        conformityConstraint.setText(getOclLabel(toSet));
      }
    });
    // Button execution
    conformityConstraintButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null) {
          if (role.getTemplateElements().isEmpty()) {
            MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(),
                Messages.AbstractRoleSpecificationPage_EmptyRole);
          } else {
            try {
              EObject context = role.getTemplateElements().get(0);
              EObject modelContext = getData().getCounterpart(context, true);
              OclInputMessageDialog dialog = new OclInputMessageDialog(getShell(), Messages.AbstractRoleSpecificationPage_ConformityConstraint,
                  Messages.AbstractRoleSpecificationPage_PromptOCLConstraint,
                  modelContext, role, getData(), getConformityConstraint(role), !isReadOnly()) {
                /**
                 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.OclInputMessageDialog#isValid(org.eclipse.ocl.ecore.OCLExpression, java.lang.Object)
                 */
                @Override
                protected boolean isValid(OCLExpression parsedExpression_p, Object evaluationResult_p) {
                  Object type = parsedExpression_p.getType();
                  return type == getInterpreter().getStandardLibrary().getBoolean();
                }
              };
              int answer = dialog.open();
              if (Window.OK == answer) {
                String newValue = dialog.getExpression();
                setConformityConstraint(role, newValue);
                conformityConstraint.setText(getOclLabel(newValue));
              }
            } catch (NoClassDefFoundError e) {
              warnOCLAbsent();
            }
          }
        }
      }
    });
  }
  
  /**
   * Create the controls for scope derivation for addition
   * @param parent_p a non-null composite
   */
  protected void createContainerDerivationLine(final Composite parent_p) {
    // 1. Label
    new Label(parent_p, SWT.NONE).setText(
        Messages.AbstractRoleSpecificationPage_ContainerDerivation + ':');
    // 2. Text
    final Text containerDerivationRule = new Text(parent_p, SWT.BORDER);
    containerDerivationRule.setEditable(false);
    GridData containerDerivationRuleData = new GridData(SWT.FILL, SWT.TOP, true, false);
    containerDerivationRule.setLayoutData(containerDerivationRuleData);
    // 3. Button
    final Button containerDerivationRuleButton = new Button(parent_p, SWT.PUSH);
    containerDerivationRuleButton.setText("..."); //$NON-NLS-1$
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        String toSet = NO_DATA;
        if (newRole_p != null) {
          toSet = getAdditionDerivationRule(newRole_p);
        }
        containerDerivationRule.setText(getOclLabel(toSet));
      }
    });
    // Button execution
    containerDerivationRuleButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null) {
          if (role.getTemplateElements().isEmpty()) {
            MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(),
                Messages.AbstractRoleSpecificationPage_EmptyRole);
          } else {
            try {
              EObject context = role.getTemplateElements().get(0);
              EObject modelContext = getData().getCounterpart(context, true);
              OclInputMessageDialog dialog = new OclInputMessageDialog(getShell(), Messages.AbstractRoleSpecificationPage_ContainerDerivation,
                  Messages.AbstractRoleSpecificationPage_PromptOCLQuery,
                  modelContext, role, getData(), getAdditionDerivationRule(role), !isReadOnly());
              int answer = dialog.open();
              if (Window.OK == answer) {
                String newValue = dialog.getExpression();
                setAdditionDerivationRule(role, newValue);
                containerDerivationRule.setText(getOclLabel(newValue));
                getData().roleUpdated();
                validate();
              }
            } catch (NoClassDefFoundError e) {
              warnOCLAbsent();
            }
          }
        }
      }
    });
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
    createRoleControls(mainComposite, !isReadOnly());
    createRoleDetailsControls(mainComposite);
  }
  
  /**
   * Create the line for specifying the description of the role
   * @param parent_p a non-null composite
   */
  protected void createDescriptionLine(final Composite parent_p) {
    // 1. Label
    Label label = new Label(parent_p, SWT.NONE);
    label.setText(Messages.AbstractRoleSpecificationPage_Description);
    GridData labelData = new GridData();
    labelData.verticalAlignment = SWT.TOP;
    label.setLayoutData(labelData);
    // 2. Text
    Text text = createDescriptionText(parent_p);
    GridData textData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2);
    text.setLayoutData(textData);
    addEmptyControl(parent_p);
  }
  
  /**
   * Create and return the text for role description
   * @param parent_p a non-null composite
   * @return a non-null text
   */
  protected Text createDescriptionText(final Composite parent_p) {
    final Text descriptionText = new Text(
        parent_p, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
    // Update data from input
    descriptionText.addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      public void modifyText(ModifyEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null && !isReadOnly()) {
          String value = descriptionText.getText();
          role.setDescription(value);
        }
      }
    });
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        if (newRole_p != null)
          descriptionText.setText(newRole_p.getDescription());
      }
    });
    if (isReadOnly())
      descriptionText.setEditable(false);
    return descriptionText;
  }
  
  /**
   * Create The line for specifying role exclusiveness
   * @param parent_p a non-null composite
   */
  protected void createExclusiveRoleLine(final Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.AbstractRoleSpecificationPage_ExclusiveTarget);
    // Update data from input
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().getRole().setExclusive(!getData().getRole().isExclusive());
      }
    });
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        if (newRole_p != null) {
          result.setSelection(newRole_p.isExclusive());
        }
      }
    });
    fillLineWith(result);
    if (isReadOnly())
      _alwaysDisabled.add(result);
  }
  
  /**
   * Create the lines for the specification of general characteristics of the role
   * @param parent_p a non-null composite
   */
  protected void createGeneralGroup(final Composite parent_p) {
    final Composite generalComposite = createGroup(parent_p, Messages.AbstractRoleSpecificationPage_GeneralProperties, true, 3);
    // Description
    createDescriptionLine(generalComposite);
    // Conformity
    createConformityLine(generalComposite);
  }
  
  /**
   * Create and return the check button for mandatory containment
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createMandatoryContainmentButton(final Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.AbstractRoleSpecificationPage_Mandatory);
    // Update data from input
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        AdditionKind kind = getData().getRole().getAdditionKind();
        if (kind == AdditionKind.PREFERRED_CONTAINMENT)
          getData().getRole().setAdditionKind(AdditionKind.ANY_CONTAINMENT);
        else
          getData().getRole().setAdditionKind(AdditionKind.PREFERRED_CONTAINMENT);
      }
    });
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        if (newRole_p != null) {
          boolean mandatoryContainment =
            newRole_p.getAdditionKind() == AdditionKind.PREFERRED_CONTAINMENT;
          result.setSelection(mandatoryContainment);
        }
      }
    });
    if (isReadOnly())
      _alwaysDisabled.add(result);
    return result;
  }
  
  /**
   * Create the controls for the applicability scope for merge
   * @param parent_p a non-null composite
   */
  protected void createMergeApplicabilityScopeLine(final Composite parent_p) {
    // 1. Label
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractRoleSpecificationPage_TargetType);
    // 2. Text
    final Text mergeApplicabilityScope = new Text(parent_p, SWT.BORDER);
    mergeApplicabilityScope.setEditable(false);
    GridData mergeApplicabilityScopeData = new GridData(SWT.FILL, SWT.TOP, true, false);
    mergeApplicabilityScope.setLayoutData(mergeApplicabilityScopeData);
    // 3. Button
//    final Button mergeApplicabilityScopeButton = new Button(parent_p, SWT.PUSH);
//    mergeApplicabilityScopeButton.setText("...");
//    mergeApplicabilityScopeButton.setEnabled(false);
    addEmptyControl(parent_p);
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        if (newRole_p != null) {
          EClass commonClass = ModelsUtil.getCommonType(newRole_p.getTemplateElements());
          mergeApplicabilityScope.setText(commonClass == null? "": commonClass.getName()); //$NON-NLS-1$
        }
      }
    });
  }
  
  /**
   * Create the lines for merge specification
   * @param parent_p a non-null composite
   */
  protected void createMergeGroup(final Composite parent_p) {
    final Composite mergeComposite = createGroup(parent_p, Messages.AbstractRoleSpecificationPage_ApplyMerge, true, 3);
    fillLineWith(mergeComposite);
    if (!showSimplifiedInterface()) {
      // Exclusive target
      createExclusiveRoleLine(mergeComposite);
      // Applicability scope
      createMergeApplicabilityScopeLine(mergeComposite);
    }
    // Target derivation rule
    createTargetDerivationLine(mergeComposite, null);
  }
  
  /**
   * Create the controls for line for preferred containment for addition
   * @param parent_p a non-null composite
   */
  protected void createPreferredContainmentLine(final Composite parent_p) {
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractRoleSpecificationPage_PreferredContainment);
    createPreferredContainmentText(parent_p);
    createMandatoryContainmentButton(parent_p);
  }
  
  /**
   * Create and return the text for preferred containment
   * @param parent_p a non-null composite
   * @return a non-null text
   */
  protected Text createPreferredContainmentText(final Composite parent_p) {
    final Text preferredContainment = new Text(parent_p, SWT.BORDER);
    preferredContainment.setEditable(false);
    GridData preferredContainmentData = new GridData(SWT.FILL, SWT.TOP, true, false);
    preferredContainment.setLayoutData(preferredContainmentData);
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        if (newRole_p != null) {
          EReference containment = getPreferredContainment(newRole_p);
          preferredContainment.setText(containment == null? "": containment.getName()); //$NON-NLS-1$
        }
      }
    });
    return preferredContainment;
  }
  
  /**
   * Create the controls related to template elements within the given composite
   * @param parent_p a non-null composite
   */
  protected void createRoleDetailsControls(Composite parent_p) {
    // Group for role details
    final Group group = createGroup(parent_p, Messages.AbstractRoleSpecificationPage_RoleDetails, true, 3);
    // Disable/enable according to selected role
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        boolean unselected = newRole_p == null;
        if (unselected == group.getEnabled()) {
          boolean enable = !unselected;
          if (enable)
            enableAll(group, true, true, _alwaysEnabled, _alwaysDisabled);
          else
            enableAll(group, false, true);
        }
      }
    });
    // General characteristics
    createGeneralGroup(group);
    // Merge
    createMergeGroup(group);
    // Addition
    createAdditionGroup(group);
    enableAll(group, false, true);
  }
  
  /**
   * Create the controls for scope derivation for merge
   * @param parent_p a non-null composite
   * @param label_p an optional label for the line
   */
  protected void createTargetDerivationLine(final Composite parent_p, String label_p) {
    String label = label_p != null? label_p: Messages.AbstractRoleSpecificationPage_TargetDerivation;
    // 1. Label
    new Label(parent_p, SWT.NONE).setText(label + ':');
    // 2. Text
    final Text mergeDerivationRule = new Text(parent_p, SWT.BORDER);
    mergeDerivationRule.setEditable(false);
    GridData mergeDerivationRuleData = new GridData(SWT.FILL, SWT.TOP, true, false);
    mergeDerivationRule.setLayoutData(mergeDerivationRuleData);
    // 3. Button
    final Button mergeDerivationRuleButton = new Button(parent_p, SWT.PUSH);
    mergeDerivationRuleButton.setText("...");  //$NON-NLS-1$
    // Update view from data
    getData().addSelectedRoleListener(new IRoleSelection.IRoleChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRoleSelection.IRoleChangedListener#roleChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
       */
      public void roleChanged(TemplatePatternRole newRole_p) {
        String toSet = NO_DATA;
        if (newRole_p != null) {
          toSet = getMergeDerivationRule(newRole_p);
        }
        mergeDerivationRule.setText(getOclLabel(toSet));
      }
    });
    // Button execution
    mergeDerivationRuleButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        TemplatePatternRole role = getData().getRole();
        if (role != null) {
          if (role.getTemplateElements().isEmpty()) {
            MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(),
                Messages.AbstractRoleSpecificationPage_EmptyRole);
          } else {
            try {
              EObject context = role.getTemplateElements().get(0);
              EObject modelContext = getData().getCounterpart(context, true);
              OclInputMessageDialog dialog = new OclInputMessageDialog(
                  getShell(), Messages.AbstractRoleSpecificationPage_TargetDerivation,
                  Messages.AbstractRoleSpecificationPage_PromptOCLQueryWithRoles,
                  modelContext, role, getData(), getMergeDerivationRule(role), !isReadOnly());
              int answer = dialog.open();
              if (Window.OK == answer) {
                String newValue = dialog.getExpression();
                setMergeDerivationRule(role, newValue);
                mergeDerivationRule.setText(getOclLabel(newValue));
                getData().roleUpdated();
                validate();
              }
            } catch (NoClassDefFoundError e) {
              warnOCLAbsent();
            }
          }
        }
      }
    });
  }
  
  /**
   * Set the layout data of the given control so that it fills its entire line
   * @param control_p a non-null control
   */
  protected void fillLineWith(Control control_p) {
    GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);
    Composite parent = control_p.getParent();
    Layout parentLayout = parent.getLayout();
    if (parentLayout instanceof GridLayout) {
      GridLayout gridLayout = (GridLayout)parentLayout;
      int nbCol = gridLayout.numColumns;
      data.horizontalSpan = nbCol;
    }
    control_p.setLayoutData(data);
  }
  
  /**
   * Return the OCL addition derivation rule of the given role as string
   * @param role_p a non-null role
   * @return a potentially null string
   */
  protected String getAdditionDerivationRule(TemplatePatternRole role_p) {
    String result = null;
    AbstractRoleDerivationRule rule = role_p.getAdditionDerivationRule();
    if (rule instanceof TextualRoleDerivationRule) {
      TextualRoleDerivationRule textualRule = (TextualRoleDerivationRule)rule;
      result = textualRule.getSpecification();
    }
    return result;
  }
  
  /**
   * Return the OCL conformity constraint of the given role as string
   * @param role_p a non-null role
   * @return a potentially null string
   */
  protected String getConformityConstraint(TemplatePatternRole role_p) {
    String result = null;
    if (!role_p.getConstraints().isEmpty()) {
      TextualRoleConstraint constraint = (TextualRoleConstraint)role_p.getConstraints().get(0);
      result = constraint.getSpecification();
    }
    return result;
  }
  
  /**
   * Return the OCL merge derivation rule of the given role as string
   * @param role_p a non-null role
   * @return a potentially null string
   */
  protected String getMergeDerivationRule(TemplatePatternRole role_p) {
    String result = null;
    AbstractRoleDerivationRule rule = role_p.getMergeDerivationRule();
    if (rule instanceof TextualRoleDerivationRule) {
      TextualRoleDerivationRule textualRule = (TextualRoleDerivationRule)rule;
      result = textualRule.getSpecification();
    }
    return result;
  }
  
  /**
   * Return a label that represents the given OCL specification
   * @param oclSpecification_p a potentially null OCL specification
   * @return a non-null string
   */
  protected String getOclLabel(String oclSpecification_p) {
    String result = oclSpecification_p == null || oclSpecification_p.length() == 0? NO_DATA:
      oclSpecification_p;
    result = result.replaceAll("\r|\n|\t", " ");  //$NON-NLS-1$//$NON-NLS-2$
    return result;
  }
  
  /**
   * Return the preferred containment for the given role
   * @param role_p a non-null role
   * @return a potentially null reference
   */
  protected EReference getPreferredContainment(TemplatePatternRole role_p) {
	  return role_p.getPreferredContainment();
  }
  
  /**
   * Return whether the page is read-only
   */
  protected boolean isReadOnly() {
    return false;
  }
  
  /**
   * Set the addition derivation rule of the given role to the given textual specification
   * @param role_p a non-null role
   * @param specification_p a potentially null textual specification
   */
  protected void setAdditionDerivationRule(TemplatePatternRole role_p, String specification_p) {
    if (specification_p == null ||
        specification_p.trim().length() == 0) {
      role_p.setAdditionDerivationRule(null);
    } else {
      TextualRoleDerivationRule rule = (TextualRoleDerivationRule)role_p.getAdditionDerivationRule();
      if (rule == null) {
        rule = TemplatepatternsFactory.eINSTANCE.createTextualRoleDerivationRule();
        rule.setLanguage(OclPatternsPlugin.getDefault().getLanguage());
        role_p.setAdditionDerivationRule(rule);
      }
      rule.setSpecification(specification_p);
    }
  }
  
  /**
   * Set the conformity constraint of the given role to the given OCL specification
   * @param role_p a non-null role
   * @param oclBody_p a potentially null textual specification of type boolean
   */
  protected void setConformityConstraint(TemplatePatternRole role_p, String oclBody_p) {
    if (oclBody_p == null || oclBody_p.length() == 0) {
      role_p.getConstraints().clear();
    } else {
      TextualRoleConstraint constraint;
      if (role_p.getConstraints().isEmpty()) {
        constraint = TemplatepatternsFactory.eINSTANCE.createTextualRoleConstraint();
        constraint.setLanguage(OclPatternsPlugin.getDefault().getLanguage());
        role_p.getConstraints().add(constraint);
      } else {
        constraint = (TextualRoleConstraint)role_p.getConstraints().get(0);
      }
      constraint.setSpecification(oclBody_p);
    }
  }
  
  /**
   * Set the merge derivation rule of the given role to the given OCL specification
   * @param role_p a non-null role
   * @param specification_p a potentially null textual specification
   */
  protected void setMergeDerivationRule(TemplatePatternRole role_p, String specification_p) {
    if (specification_p == null ||
        specification_p.trim().length() == 0) {
      role_p.setMergeDerivationRule(null);
    } else {
      TextualRoleDerivationRule rule = (TextualRoleDerivationRule)role_p.getMergeDerivationRule();
      if (rule == null) {
        rule = TemplatepatternsFactory.eINSTANCE.createTextualRoleDerivationRule();
        rule.setLanguage(OclPatternsPlugin.getDefault().getLanguage());
        role_p.setMergeDerivationRule(rule);
      }
      rule.setSpecification(specification_p);
    }
  }
  
  /**
   * Return whether the interface should be complete or simplified
   */
  protected boolean showSimplifiedInterface() {
    return true;
  }
  
  /**
   * Warn the user about the absence of optional OCL tools
   */
  protected void warnOCLAbsent() {
    String msg = Messages.AbstractRoleSpecificationPage_WarnOCLAbsence;
    MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(), msg);
  }
  
}
