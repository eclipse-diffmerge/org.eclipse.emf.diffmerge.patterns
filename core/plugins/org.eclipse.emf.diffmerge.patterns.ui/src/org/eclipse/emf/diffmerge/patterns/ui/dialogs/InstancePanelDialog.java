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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation.InstanceOperationKind;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicModelUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.diagrams.misc.HighlightingSpecification;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.BasicRGB;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.CloseCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.engine.operations.RenameTemplateInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin.ImageID;
import org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.AbstractInstanceExplorerView;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.update.PatternUpdateWizard;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedImage.Point;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/**
 * A dialog that displays a list of pattern instances and allows the user to select one and perform actions on it.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class InstancePanelDialog extends InstanceChoiceDialog {
  
  /** The width of push buttons */
  private static final int BUTTON_WIDTH = 120;

  /** An optional diagram for graphical operations */
  protected final Object _diagram;

  /** Whether the instance must be unfolded graphically */
  protected boolean _graphicalUnfolding;

  /** Whether the renaming operation should preserve user names */
  protected boolean _keepUserNames;

  /** Whether pattern layout must be reused when instance is updated */
  protected boolean _reuseLayoutAtUpdate;

  /** Whether pattern layout must be reused when instance is updated */
  protected boolean _reuseStyleAtUpdate;

  /** Whether elements added during instance update should be shown */
  protected boolean _showUpdateAdditions;

  /** Whether conformity details should be shown when conformity is being checked */
  protected static boolean __showConformityDetails = false;

  /** The non-null renaming rule */
  protected String _namingRule;

  /** The non-null highlighting specification */
  protected final HighlightingSpecification _highlightingSpecification;

  /** The non-null, potentially empty, unmodifiable list of contextual GEF elements */
  protected final List<Object> _graphicalContext;

  /** Whether the global state of pattern-related elements changed */
  private boolean _globalPatternStateChanged;

  /** Features to ignore selected by the user */
  protected static List<EStructuralFeature> _selectedFeaturesToIgnore;

  /** Optional features that can be ignored by the user */
  protected Set<EStructuralFeature> _optionalFeaturesToIgnore;

  /** Whether instance update must be destructive */
  protected boolean _destructiveInstanceUpdate;

  /** Map that links each check box to its corresponding EStructuralFeature */
  protected HashMap<Button, EStructuralFeature> _structuralFeaturesCheckBoxesMap;

  /**
   * Constructor
   * @param parentShell_p the shell for this dialog
   * @param referenceElement_p the optional element to use as a reference for displaying roles
   * @param instances_p the non-null, non-empty set of instances to choose from
   * @param diagram_p an optional diagram for graphical operations
   * @param graphicalContext_p a non-null, potentially empty list of GEF elements
   */
  public InstancePanelDialog(Shell parentShell_p, EObject referenceElement_p,
      List<? extends IPatternInstance> instances_p, Object diagram_p, List<Object> graphicalContext_p) {
    super(parentShell_p, Messages.InstancePanelDialog_Header, Messages.InstancePanelDialog_Message,
        MessageDialog.QUESTION, referenceElement_p, instances_p, SelectionKind.MULTI, false);
    _diagram = diagram_p;
    _graphicalUnfolding = true;
    _keepUserNames = true;
    _showUpdateAdditions = true;
    _reuseLayoutAtUpdate = true;
    _reuseStyleAtUpdate = true;
    _namingRule = ""; //$NON-NLS-1$
    _highlightingSpecification = new HighlightingSpecification();
    _graphicalContext = Collections.unmodifiableList(graphicalContext_p);
    _globalPatternStateChanged = false;
    _optionalFeaturesToIgnore = new LinkedHashSet<EStructuralFeature>();
    _destructiveInstanceUpdate = false;
  }

  /**
   * Return the ID of an instance explorer view 
   * @return a non null String
   */
  protected String getInstanceExplorerViewID() {
    IUIExtender uiExtender = PatternsUIPlugin.getDefault().getSemanticUIUtil();
    return uiExtender.getInstanceExplorerViewID();
  }

  /**
   * @see org.eclipse.jface.dialogs.Dialog#close()
   */
  @Override
  public boolean close() {
    boolean result = super.close();
    if (globalPatternStateChanged()) {
      AbstractInstanceExplorerView view = getInstanceExplorerView();
      if (view != null) {
        view.refreshCurrent();
      }
    }
    return result;
  }

  /**
   * Close the catalogs of the selected instances
   */
  protected void closeCurrentCatalog() {
    List<IPatternInstance> instances = getSelectedInstances();
    Collection<PatternRepository> catalogs = new FOrderedSet<PatternRepository>();
    for (IPatternInstance instance : instances) {
      IPattern pattern = instance.getPattern();
      if ((pattern != null) && (pattern.getRepository() instanceof PatternRepository)) {
        PatternRepository catalog = (PatternRepository) pattern.getRepository();
        catalogs.add(catalog);
      }
    }
    if (!catalogs.isEmpty()) {
      Iterator<PatternRepository> it = catalogs.iterator();
      while(it.hasNext()){
        PatternRepository current = it.next();
        CloseCatalogOperation operation = new CloseCatalogOperation(current);
        executeOperation(operation);
      }
      notifyGlobalPatternStateChanged();
      _viewer.refresh(true);
      refresh();
    }
  }

  /**
   * Create the area where the buttons for instance operations are located
   * @param parent_p a non-null composite
   */
  private void createButtonsArea(Composite parent_p) {
    // Life-cycle
    Group lifeCycleGroup = new Group(parent_p, SWT.NONE);
    lifeCycleGroup.setText(Messages.InstancePanelDialog_LifeCycle);
    lifeCycleGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    lifeCycleGroup.setLayout(new GridLayout(2, false));
    // Life-cycle contents
    createFoldUnfoldRow(lifeCycleGroup);
    createRenamingRow(lifeCycleGroup);
    createDeleteRow(lifeCycleGroup);
    // Synchronization
    Group syncGroup = new Group(parent_p, SWT.NONE);
    syncGroup.setText(Messages.InstancePanelDialog_Synchronization);
    syncGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    syncGroup.setLayout(new GridLayout(1, false));

    // Synchronization contents
    createIgnoredFeaturesGroup(syncGroup);
    createSynchronizationButtons(syncGroup);
    // Representation
    Group repGroup = new Group(parent_p, SWT.NONE);
    repGroup.setText(Messages.InstancePanelDialog_Representation);
    repGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    repGroup.setLayout(new GridLayout(2, false));
    // Representation contents
    createShowRow(repGroup);
    // SKANDER::BEGIN
    createReuseLayoutAndStyleRow(repGroup);
    // SKANDER::END
    createHighlightRow(repGroup);
    createRestoreRow(repGroup);
  }

  /**
   * Creates the group of controls that are used for synchronization
   * @param group_p a non-null group
   */
  private void createSynchronizationButtons(Group group_p) {
    Composite composite = createEmptyComposite(group_p, 2);
    createCheckRow(composite);
    createUpdateInstanceRow(composite);
    createUpdatePatternRow(composite);
  }

  /**
   * Creates, under synchronization group, a sub-group containing the check boxes used to select the features to ignore
   * @param syncGroup_p a non-null group
   */
  private void createIgnoredFeaturesGroup(Group syncGroup_p) {
    initializeIgnoredFeaturesCollections();
    // Group
    Group ignoredFeatureGroup = new Group(syncGroup_p, SWT.NONE);
    ignoredFeatureGroup.setText(Messages.InstancePanelDialog_SynchronizationOptions);
    ignoredFeatureGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    if(_optionalFeaturesToIgnore != null){
      ignoredFeatureGroup.setLayout(new GridLayout(_optionalFeaturesToIgnore.size(), false));
    }else{
      ignoredFeatureGroup.setLayout(new GridLayout(10, false));
    }
    // create check boxes for optional features to ignore
    for(EStructuralFeature feature : _optionalFeaturesToIgnore){
      createIgnoredFeatureCheckBox(ignoredFeatureGroup, feature);
    }
  }

  /**
   * Creates a check box for each optional ignored feature
   * @param ignoredFeatureGroup_p a non-null SWT Group
   * @param feature_p a non-null EStructuralFeature
   * @return a non-null button
   */
  private Button createIgnoredFeatureCheckBox(Group ignoredFeatureGroup_p, EStructuralFeature feature_p){
    final Button ignoreName = new Button(ignoredFeatureGroup_p, SWT.CHECK);
    ignoreName.setText(toUserFriendlyString(feature_p.getName().toLowerCase()));
    ignoreName.setSelection(isIgnoredFeature(_selectedFeaturesToIgnore, feature_p));
    if(_structuralFeaturesCheckBoxesMap == null){
      _structuralFeaturesCheckBoxesMap = new HashMap<Button, EStructuralFeature>();
    }
    _structuralFeaturesCheckBoxesMap.put(ignoreName, feature_p);
    ignoreName.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @SuppressWarnings("synthetic-access")
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        if(_structuralFeaturesCheckBoxesMap != null){
          EStructuralFeature feature = _structuralFeaturesCheckBoxesMap.get(ignoreName);
          if(feature != null){
            updateSelectedFeatures(ignoreName, _selectedFeaturesToIgnore, feature);
          }
        }    
      }
    });
    return ignoreName;
  }


  /**
   * Transforms the first character of a lower-cased string to upper case
   * @param lowerCase_p a non-null string
   * @return a non-null string
   */
  private String toUserFriendlyString(String lowerCase_p) {
    String result = ""; //$NON-NLS-1$
    result+= lowerCase_p.substring(0, 1).toUpperCase();
    result+= lowerCase_p.substring(1, lowerCase_p.length());
    return result;
  }

  /**
   * Update the list of selected features to ignore according to the given button state
   * @param button_p a non-null button 
   * @param selectedFeaturesToIgnore_p a non-null, potentially empty list
   * @param feature_p a non-null feature
   */
  private void updateSelectedFeatures(Button button_p,
      List<EStructuralFeature> selectedFeaturesToIgnore_p, EStructuralFeature feature_p) {
    if(button_p.isEnabled()){
      if(!selectedFeaturesToIgnore_p.contains(feature_p)){
        selectedFeaturesToIgnore_p.add(feature_p);
      }else{
        selectedFeaturesToIgnore_p.remove(feature_p);
      }  
    }
  }
  
  /**
   * Return whether the given feature is ignored according to the given set of ignored features
   * @param ignoredFeatures_p a non-null collection
   * @param feature_p a potentially null feature
   */
  private boolean isIgnoredFeature(Collection<EStructuralFeature> ignoredFeatures_p, EStructuralFeature feature_p){
    return ignoredFeatures_p.contains(feature_p);
  }
  
  /**
   * Create the row for instance conformity checking
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createCheckRow(Composite parent_p) {
    // Check button
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_Check);
    // Composite
    Composite composite = createEmptyComposite(parent_p, 3);
    // Label
    final Label label = new Label(composite, SWT.NONE);
    label.setText(Messages.InstancePanelDialog_Conformity);
    // Check result text
    final Text checkText = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
    checkText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    // Show details check-box
    final Button showDetails = new Button(composite, SWT.CHECK);
    showDetails.setText(Messages.InstancePanelDialog_ShowDetails);
    showDetails.setSelection(__showConformityDetails);
    // Check result text: Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = isApplicable(InstanceOperationKind.CHECK);
        result.setEnabled(enable);
        label.setEnabled(enable);
        showDetails.setEnabled(enable);
        checkText.setText(""); //$NON-NLS-1$
        checkText.setEnabled(enable);
      }
    });
    // Check result text: Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        BasicModelUpdateSpecification specification =
            new BasicModelUpdateSpecification(false, _selectedFeaturesToIgnore);
        IEvaluationStatus status = executeInstanceOperation(
            getSelectedInstance(), InstanceOperationKind.CHECK,
            RefreshRequestKind.NONE, false, false, false, specification);
        if (status == null) {
          MessageDialog.openError(getShell(), Messages.InstancePanelDialog_CheckFailedTitle,
              Messages.InstancePanelDialog_CheckFailedMessage);
        } else {
          String singleLineMessage = status.getDescription();
          final String SPACE = " "; //$NON-NLS-1$
          singleLineMessage = singleLineMessage.replaceAll("\n", SPACE); //$NON-NLS-1$
          singleLineMessage = singleLineMessage.replaceAll("\r", SPACE); //$NON-NLS-1$
          singleLineMessage = singleLineMessage.replaceAll("\t", SPACE); //$NON-NLS-1$
          checkText.setText(singleLineMessage);
          if (__showConformityDetails) {
            InstanceConformityDialog dialog = new InstanceConformityDialog(
                getShell(), singleLineMessage, getSelectedInstance(), _referenceElement, _selectedFeaturesToIgnore);
            dialog.open();
          }
        }
      }
    });
    // Show details check-box: Execution
    showDetails.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        __showConformityDetails = showDetails.getSelection();
      }
    });
    return result;
  }

  /**
   * Create and return the "close catalog" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createCloseCatalogMenuItem(Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.InstancePanelDialog_CloseCatalog);
    // Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        Collection<IPatternInstance> instances = getSelectedInstances();
        boolean enable = false;
        for (IPatternInstance instance : instances) {
          if (instance.getPattern() != null) {
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
        closeCurrentCatalog();
      }
    });
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createCustomArea(Composite parent_p) {
    // Overall composite
    Composite result = new Composite(parent_p, SWT.NONE);
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    result.setLayout(layout);
    // Table
    Control selectionTable = super.createCustomArea(result);
    GridData dataMain = new GridData(SWT.FILL, SWT.FILL, true, true);
    selectionTable.setLayoutData(dataMain);
    enhanceSelectionTable(selectionTable);
    // Buttons
    createButtonsArea(result);
    selectAll();
    return result;
  }

  /**
   * Create and return the button for instance deletion
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createDeleteButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_Delete);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        List<IPatternInstance> instances = getSelectedInstances();
        if (!instances.isEmpty()) {
          final Collection<Object> wrapper = new LinkedList<Object>(); // Empty = keep elements
          wrapper.add(new Object());
          MessageDialog dialog =
              new MessageDialog(getShell(), CorePatternsPlugin.getDefault().getLabel(), null,
                  Messages.InstancePanelDialog_DeleteExplanation,
                  MessageDialog.QUESTION, new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL }, 0) {
            /**
             * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
             */
            @Override
            protected Control createCustomArea(Composite innerParent_p) {
              final Button checkButton = new Button(innerParent_p, SWT.CHECK);
              checkButton.setText(Messages.InstancePanelDialog_KeepElements);
              checkButton.setSelection(wrapper.isEmpty());
              checkButton.addSelectionListener(new SelectionAdapter() {
                /**
                 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
                 */
                @Override
                public void widgetSelected(SelectionEvent se_p) {
                  if (wrapper.isEmpty()) {
                    wrapper.add(new Object());
                  } else {
                    wrapper.clear();
                  }
                }
              });
              return checkButton;
            }
          };
          int answer = dialog.open();
          if (Window.OK == answer) {
            InstanceOperationKind operationKind =
                wrapper.isEmpty() ? InstanceOperationKind.DELETE : InstanceOperationKind.DELETE_WITH_ELEMENTS;
            RefreshRequestKind refreshKind =
                operationKind == InstanceOperationKind.DELETE_WITH_ELEMENTS ? RefreshRequestKind.DIAGRAM : RefreshRequestKind.NONE;
            List<IEvaluationStatus> statuses = executeInstanceOperations(
                instances, operationKind, refreshKind, false, false, false, null);
            int nb = Math.min(statuses.size(), instances.size());
            for (int i = 0; i < nb; i++) {
              if (statuses.get(i).isOk()) {
                _originalList.remove(instances.get(i));
              }
            }
            notifyGlobalPatternStateChanged();
            _viewer.refresh();
          }
        }
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled(isApplicable(InstanceOperationKind.DELETE));
      }
    });
    return result;
  }

  /**
   * Create the row for instance deletion
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createDeleteRow(Composite parent_p) {
    Button result = createDeleteButton(parent_p);
    new Label(parent_p, SWT.NONE);
    return result;
  }

  /**
   * Create and return a composite with neutral (margin-free) grid layout
   * @param parent_p a non-null composite
   * @param columns_p the number of columns in its layout
   * @return a non-null composite
   */
  protected Composite createEmptyComposite(Composite parent_p, int columns_p) {
    Composite result = new Composite(parent_p, SWT.NONE);
    result.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    GridLayout layout = new GridLayout(columns_p, false);
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    result.setLayout(layout);
    return result;
  }

  /**
   * Create and return the button for folding/unfolding
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createFoldUnfoldButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        InstanceOperationKind operationKind = getFoldingOperationKind();
        RefreshRequestKind refreshKind;
        if ((InstanceOperationKind.UNFOLD == operationKind) && _graphicalUnfolding) {
          refreshKind = RefreshRequestKind.INSTANCE;
        } else {
          refreshKind = RefreshRequestKind.DIAGRAM;
        }
        executeInstanceOperations(
            getSelectedInstances(), operationKind, refreshKind, _reuseLayoutAtUpdate, _reuseStyleAtUpdate, false, null);
        notifyGlobalPatternStateChanged();
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        InstanceOperationKind operationKind = getFoldingOperationKind();
        // Enabled state
        result.setEnabled(isApplicable(operationKind));
        // Caption
        String caption;
        if (InstanceOperationKind.UNFOLD == operationKind) {
          caption = Messages.InstancePanelDialog_Unfold;
        } else {
          caption = Messages.InstancePanelDialog_Fold;
        }
        result.setText(caption);
      }
    });
    return result;
  }

  /**
   * Create and return the check-box for graphical unfolding
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createGraphicalUnfoldingCheckbox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.InstancePanelDialog_ShowUnfolded);
    result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    result.setSelection(_graphicalUnfolding);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        _graphicalUnfolding = !_graphicalUnfolding;
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled(isApplicable(InstanceOperationKind.UNFOLD));
      }
    });
    return result;
  }

  /**
   * Create a row for folding/unfolding
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createFoldUnfoldRow(Composite parent_p) {
    Button result = createFoldUnfoldButton(parent_p);
    createGraphicalUnfoldingCheckbox(parent_p);
    return result;
  }

  /**
   * Create and return the button for highlighting an instance
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createHighlightButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_Highlight);
    result.setEnabled(_diagram != null);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        _highlightingSpecification.setAsDefault();
        CorePatternsPlugin
        .getDefault()
        .getModelEnvironment()
        .execute(
            _operationFactory.instantiateHighlightOperation(_diagram, getSelectedInstances(),
                _highlightingSpecification.color, 3, _highlightingSpecification.coverEdges,
                _highlightingSpecification.coverNodes, _highlightingSpecification.coverPorts));
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled((_diagram != null) && !getSelectedInstances().isEmpty());
      }
    });
    return result;
  }


  /**
   * Create the row for "highlight instance"
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createHighlightRow(Composite parent_p) {
    final Button result = createHighlightButton(parent_p);
    // Composite
    Composite composite = createEmptyComposite(parent_p, 5);
    // Color button
    final ColorSelector colorButton = new ColorSelector(composite);
    BasicRGB currentColor = _highlightingSpecification.color;
    colorButton.setColorValue(currentColor == null? new RGB(0, 0, 0):
      new RGB(currentColor.red, currentColor.green, currentColor.blue));
    colorButton.addListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event_p) {
        if (event_p.getNewValue() instanceof RGB) {
          RGB newColor = (RGB) event_p.getNewValue();
          _highlightingSpecification.color =
              new BasicRGB(newColor.red, newColor.green, newColor.blue);
        }
      }
    });
    // Nodes check-box
    final Button coverNodesButton = new Button(composite, SWT.CHECK);
    coverNodesButton.setText(Messages.InstancePanelDialog_Nodes);
    coverNodesButton.setSelection(_highlightingSpecification.coverNodes);
    // Ports check-box
    final Button coverPortsButton = new Button(composite, SWT.CHECK);
    coverPortsButton.setText(Messages.InstancePanelDialog_Ports);
    coverPortsButton.setSelection(_highlightingSpecification.coverPorts);
    // Edges check-box
    final Button coverEdgesButton = new Button(composite, SWT.CHECK);
    coverEdgesButton.setText(Messages.InstancePanelDialog_Edges);
    coverEdgesButton.setSelection(_highlightingSpecification.coverEdges);
    // Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = (_diagram != null) && !getSelectedInstances().isEmpty();
        colorButton.setEnabled(enable);
        coverNodesButton.setEnabled(enable);
        coverPortsButton.setEnabled(enable);
        coverEdgesButton.setEnabled(enable);
      }
    });
    coverNodesButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _highlightingSpecification.coverNodes = coverNodesButton.getSelection();
      }
    });
    coverPortsButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _highlightingSpecification.coverPorts = coverPortsButton.getSelection();
      }
    });
    coverEdgesButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _highlightingSpecification.coverEdges = coverEdgesButton.getSelection();
      }
    });
    return result;
  }

  /**
   * Create and return the button for restoring the layout
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createReuseLayoutButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_RestoreLayout);
    result.setEnabled(_diagram != null);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        List<IPatternInstance> instances = getSelectedInstances();
        List<AbstractFilteredGraphicalUpdateOperation> operations =
            new ArrayList<AbstractFilteredGraphicalUpdateOperation>(instances.size());
        for (IPatternInstance instance : instances) {
          operations.add(_operationFactory.instantiateLayoutReuseOperation(
              _diagram, instance, new HashMap<Object, Point>(), new HashMap<Object, Object>(),
              0, 0, _reuseLayoutAtUpdate, false, _diagram));
        }
        if(!operations.isEmpty()){
          IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
          if(env != null){
            for(AbstractFilteredGraphicalUpdateOperation current : operations){
              env.execute(current);
            }
          } 
        }
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled(isLayoutReusePossible());
      }
    });
    return result;
  }

  /**
   * Create and return the button for restoring the style
   * @param parent_p a non-null composite
   */
  private void createReuseStyleButton(Composite parent_p) {
    // Nodes check-box
    final Button reuseStyleButton = new Button(parent_p, SWT.CHECK);
    reuseStyleButton.setText(Messages.InstancePanelDialog_RestoreStyle);
    reuseStyleButton.setSelection(_reuseStyleAtUpdate);
    reuseStyleButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _reuseStyleAtUpdate = reuseStyleButton.getSelection();
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        reuseStyleButton.setEnabled(isLayoutReusePossible());
      }
    });
  }

  /**
   * Create the row for "restore layout"
   * @param parent_p a non-null composite
   */
  private void createReuseLayoutAndStyleRow(Composite parent_p) {
    // reuse layout button
    createReuseLayoutButton(parent_p);
    new Label(parent_p, SWT.NONE);

  }

  /**
   * Create and return the "open catalog" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createOpenCatalogMenuItem(Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.InstancePanelDialog_OpenCatalog);
    // Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        Collection<IPatternInstance> instances = getSelectedInstances();
        boolean enable = false;
        for (IPatternInstance instance : instances) {
          if (instance.getPattern() == null) {
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
        resolvePatterns();
      }
    });
    return result;
  }

  /**
   * Create and return the "open catalog" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createShowInInstanceExplorerMenuItem(Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.InstancePanelDialog_ShowInView);
    result.setImage(PatternsUIPlugin.getDefault().getImage(ImageID.PATTERN));
    // Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled(!_viewer.getSelection().isEmpty());
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        AbstractInstanceExplorerView view = null;
        try {
          view = (AbstractInstanceExplorerView)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
              getInstanceExplorerViewID());
        } catch (Exception e) {
          // Nothing
        }
        if (view != null) {
          view.setInput(_viewer.getSelection());
        }
      }
    });
    return result;
  }

  /**
   * Create a new push button with specific characteristics
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createPushButton(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
    data.widthHint = BUTTON_WIDTH;
    result.setLayoutData(data);
    return result;
  }

  /**
   * Create and return the button for instance renaming
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createRenamingButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_Rename);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        IPatternInstance instance = getSelectedInstance();
        if (instance != null) {
          RenameTemplateInstanceOperation coreOperation = new RenameTemplateInstanceOperation(
              instance, _namingRule, _keepUserNames, _diagram);
          AbstractGraphicalWrappingInstanceOperation<IPatternInstance> wholeOperation =
              _operationFactory.instantiateGraphicalWrappingInstanceOperation(
                  coreOperation, instance, _diagram, RefreshRequestKind.DIAGRAM);
          executeOperation(wholeOperation);
        }
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        IPatternInstance instance = getSelectedInstance();
        // Enabled state
        boolean valid = (instance != null) && (instance.getPatternData() instanceof TemplatePatternData);
        result.setEnabled(valid);
      }
    });
    return result;
  }

  /**
   * Create and return the text field for the renaming rule
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Text createRenamingConfigurationRow(Composite parent_p) {
    // Composite
    Composite composite = createEmptyComposite(parent_p, 2);
    // Check-box
    createRenamingPreservationCheckbox(composite);
    // Text field
    Text result = createRenamingText(composite);
    return result;
  }

  /**
   * Create and return the "keep user names" check-box for instance renaming
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createRenamingPreservationCheckbox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.InstancePanelDialog_KeepUserNames);
    result.setSelection(_keepUserNames);
    // Selection
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _keepUserNames = result.getSelection();
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        IPatternInstance instance = getSelectedInstance();
        // Enabled state
        boolean valid = (instance != null) && (instance.getPatternData() instanceof TemplatePatternData) &&
            (instance.getPattern() != null);
        result.setEnabled(valid);
        if ((instance != null) && (instance.getPattern() == null)) {
          result.setSelection(true);
        }
      }
    });
    return result;
  }

  /**
   * Create the row for instance renaming
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createRenamingRow(Composite parent_p) {
    final Button result = createRenamingButton(parent_p);
    createRenamingConfigurationRow(parent_p);
    return result;
  }

  /**
   * Create and return the text field for the renaming rule
   * @param parent_p a non-null composite
   * @return a non-null text field
   */
  private Text createRenamingText(Composite parent_p) {
    final Text result = new Text(parent_p, SWT.BORDER);
    result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    // Modification
    result.addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      public void modifyText(ModifyEvent e_p) {
        _namingRule = result.getText();
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        // Enabled state
        boolean valid = !getSelectedInstances().isEmpty();
        result.setEnabled(valid);
        // Text content
        if (valid) {
          String newText = NamingUtil.getNeutralRenamingRule();
          TemplatePatternData data = TemplatePatternsUtil.getPatternData(getSelectedInstance());
          if (data != null) {
            newText = data.getNamingRule();
            if (newText == null) {
              newText = ""; //$NON-NLS-1$
            }
          }
          result.setText(newText);
        } else {
          result.setText(""); //$NON-NLS-1$
        }
      }
    });
    return result;
  }

  /**
   * Create and return the button for restoring an instance
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createRestoreButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_Reset);
    result.setEnabled(_diagram != null);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        CorePatternsPlugin.getDefault().getModelEnvironment().execute(
            _operationFactory.instantiateRestoreOperation(_diagram, getSelectedInstances()));
        if (_reuseStyleAtUpdate) {
          List<IPatternInstance> instances = getSelectedInstances();
          List<AbstractFilteredGraphicalUpdateOperation> operations =
              new ArrayList<AbstractFilteredGraphicalUpdateOperation>(instances.size());
          for (IPatternInstance instance : instances) {
            operations.add(_operationFactory.instantiateLayoutReuseOperation(
                _diagram, instance, Collections.<Object, Point>emptyMap(),
                Collections.emptyMap(), 0, 0, false, _reuseStyleAtUpdate, _diagram));
          }
          if(!operations.isEmpty()){
            IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
            if(env != null){
              for(AbstractFilteredGraphicalUpdateOperation current : operations){
                env.execute(current);
              }
            } 
          }
        }
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled((_diagram != null) && !getSelectedInstances().isEmpty());
      }
    });
    return result;
  }

  /**
   * Create the row for "restore instance"
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createRestoreRow(Composite parent_p) {
    Button result = createRestoreButton(parent_p);
    // reuse style button
    Composite spacecomposite = createEmptyComposite(parent_p, 2);
    createReuseStyleButton(spacecomposite);
    new Label(spacecomposite, SWT.NONE);
    return result;
  }

  /**
   * Create the row for "show instance"
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createShowRow(Composite parent_p) {
    // Button
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_Show);
    result.setSelection(_diagram != null);
    // Composite
    Composite composite = createEmptyComposite(parent_p, 2);
    // Label
    final Label label = new Label(composite, SWT.NONE);
    label.setText(Messages.InstancePanelDialog_Status);
    // Status text
    final Text showText = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
    showText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = (_diagram != null) && !getSelectedInstances().isEmpty();
        result.setEnabled(enable);
        label.setEnabled(enable);
        showText.setText(""); //$NON-NLS-1$
        showText.setEnabled(enable);
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        List<AbstractGraphicalWrappingInstanceOperation<IEvaluationStatus>> subOperations =
            new FOrderedSet<AbstractGraphicalWrappingInstanceOperation<IEvaluationStatus>>();
        for (IPatternInstance instance : getSelectedInstances()) {
          AbstractGraphicalWrappingInstanceOperation<IEvaluationStatus> subOperation =
              _operationFactory.instantiateGraphicalWrappingInstanceOperation(
                  (InstanceOperation)null, instance, _diagram, RefreshRequestKind.INSTANCE);
          subOperations.add(subOperation);
        }
        if (!subOperations.isEmpty()) {
          if (!subOperations.isEmpty()){
            IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
            if (env != null){
              for (AbstractGraphicalWrappingInstanceOperation<?> current : subOperations){
                env.execute(current);
              }
            } 
          }
          int created = 0;
          for (AbstractGraphicalWrappingInstanceOperation<?> subOperation : subOperations) {
            created += subOperation.getNewDiagramElements().size();
          }
          String status =
              created == 0 ? Messages.InstancePanelDialog_Unchanged : String.format(
                  Messages.InstancePanelDialog_CreatedNodes, Integer.valueOf(created));
          showText.setText(status);
        }
      }
    });
    return result;
  }
  
  /**
   * Create and return the "update instance" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createUpdateInstanceButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_UpdateInstance);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        if(_selectedFeaturesToIgnore != null){
          BasicModelUpdateSpecification specification =
              new BasicModelUpdateSpecification(_destructiveInstanceUpdate, _selectedFeaturesToIgnore);
          InstanceOperationKind operationKind = InstanceOperationKind.UPDATE;
          RefreshRequestKind refreshKind = _showUpdateAdditions ? RefreshRequestKind.INSTANCE : RefreshRequestKind.DIAGRAM;
          List<IEvaluationStatus> statuses =
              executeInstanceOperations(getSelectedInstances(), operationKind, refreshKind,
                  _reuseLayoutAtUpdate, _reuseStyleAtUpdate, false, specification);
          notifyGlobalPatternStateChanged();
          int nbChangesMade = 0;
          int nbCandidateChanges = 0;
          for (IEvaluationStatus status : statuses) {
            if (status instanceof IModelTransformationStatus) {
              IModelTransformationStatus mts = (IModelTransformationStatus) status;
              if (mts.getNbChangesMade() > -1) {
                nbChangesMade += mts.getNbChangesMade();
              }
              if (mts.getNbCandidateChanges() > -1) {
                nbCandidateChanges += mts.getNbCandidateChanges();
              }
            }
          }
          int nbRemaining = Math.max(0, nbCandidateChanges - nbChangesMade);
          MessageDialog.openInformation(getShell(), Messages.InstancePanelDialog_InstanceUpdateHeader,
              String.format(Messages.InstancePanelDialog_InstanceUpdateSynthesis, Integer.valueOf(nbChangesMade),
                  Integer.valueOf(nbRemaining)));
        }  
      }

    });
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        InstanceOperationKind operationKind = InstanceOperationKind.UPDATE;
        result.setEnabled(isApplicable(operationKind));
      }  });
    return result;
  }

  /**
   * Create and return the "destructive" check-box for instance update
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createUpdateInstanceDestructiveCheckbox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.InstancePanelDialog_Destructive);
    result.setSelection(_destructiveInstanceUpdate);
    // Selection
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _destructiveInstanceUpdate = result.getSelection();
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = isApplicable(InstanceOperationKind.UPDATE);
        result.setEnabled(enable);
      }
    });
    return result;
  }

  /**
   * Create the row for instance update
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createUpdateInstanceRow(Composite parent_p) {
    Button result = createUpdateInstanceButton(parent_p);
    Composite composite = createEmptyComposite(parent_p, 3);
    createUpdateInstanceShowCheckbox(composite);
    createUpdateInstanceDestructiveCheckbox(composite);
    return result;
  }


  /**
   * Initializes the local list containing features to ignore and the features selected by default
   */
  private void initializeIgnoredFeaturesCollections(){
    _optionalFeaturesToIgnore = new LinkedHashSet<EStructuralFeature>();
    List<IPatternInstance> instances = getSelectedInstances();
    if (!instances.isEmpty()) {
      for(IPatternInstance instance : instances){
        for(EObject obj : instance.getElements()){
          ISemanticRuleProvider provider =
              TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(obj);
          if (provider != null)
            if(provider.getOptionalMergeFeatures() != null){
              _optionalFeaturesToIgnore.addAll(provider.getOptionalMergeFeatures());
            }
          if(_selectedFeaturesToIgnore == null){
            _selectedFeaturesToIgnore = new LinkedList<EStructuralFeature>();
            if(provider != null && provider.getDefaultOptionalMergeFeatures() != null){
              for(EStructuralFeature feature : provider.getDefaultOptionalMergeFeatures()){
                if(!_selectedFeaturesToIgnore.contains(feature)){
                  _selectedFeaturesToIgnore.add(feature);
                }
              }
            }
          }
        }
      }
    }
  }

  /**
   * Create and return the button for pattern update
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createUpdatePatternButton(Composite parent_p) {
    final Button result = createPushButton(parent_p);
    result.setText(Messages.InstancePanelDialog_UpdatePattern);
    // Action
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        IPatternInstance instance = getSelectedInstance();
        if (instance != null) {
          updatePattern(instance);
        }
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        result.setEnabled(isPatternUpdateApplicable());
      }
    });
    return result;
  }

  /**
   * Create and return the "show additions" check-box for instance update
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createUpdateInstanceShowCheckbox(Composite parent_p) {
    // SHOW ADDITIONS
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.InstancePanelDialog_ShowAdditions);
    result.setSelection(_showUpdateAdditions);
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = isApplicable(InstanceOperationKind.UPDATE);
        result.setEnabled(enable);
      }
    });
    // REUSE LAYOUT
    final Button reuseLayout = new Button(parent_p, SWT.CHECK);
    reuseLayout.setText(Messages.InstancePanelDialog_ReuseLayoutAtUpdate);
    reuseLayout.setSelection(_reuseLayoutAtUpdate);
    // Selection: Reuse layout
    reuseLayout.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _reuseLayoutAtUpdate = result.getSelection();
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = isApplicable(InstanceOperationKind.UPDATE) && _showUpdateAdditions && isLayoutReusePossible();
        reuseLayout.setEnabled(enable);
      }
    });
    reuseLayout.setVisible(false);
    // Selection: Show additions
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _showUpdateAdditions = result.getSelection();
        boolean enableLayoutReuse = isApplicable(InstanceOperationKind.UPDATE) &&
            _showUpdateAdditions && isLayoutReusePossible();
        reuseLayout.setEnabled(enableLayoutReuse);
      }
    });
    return result;
  }

  /**
   * Create the row for pattern update
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createUpdatePatternRow(Composite parent_p) {
    Button result = createUpdatePatternButton(parent_p);
    new Label(parent_p, SWT.NONE);
    return result;
  }

  /**
   * Add behavior and menus to the instance selection table
   * @param selectionTable_p a non-null control
   */
  private void enhanceSelectionTable(Control selectionTable_p) {
    Menu menu = new Menu(getShell());
    selectionTable_p.setMenu(menu);
    createOpenCatalogMenuItem(menu);
    createCloseCatalogMenuItem(menu);
    new MenuItem(menu, SWT.SEPARATOR);
    createShowInInstanceExplorerMenuItem(menu);
    selectionTable_p.addMouseListener(new MouseListener() {
      /**
       * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
       */
      public void mouseUp(MouseEvent e_p) {
        // Nothing to do
      }

      /**
       * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
       */
      public void mouseDown(MouseEvent e_p) {
        // Nothing to do
      }

      /**
       * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
       */
      public void mouseDoubleClick(MouseEvent e_p) {
        resolvePatterns();
      }
    });
  }

  /**
   * Execute an instance operation of the given kind on the given instance with the given refresh specification
   * @param instances_p a non-null, potentially empty list of instances
   * @param operationKind_p a potentially null operation kind
   * @param requestKind_p a non-null refresh request kind
   * @param reuseLayout_p whether pattern layout must be applied on new graphical elements if applicable
   * @param verbose_p whether abnormal result information must be notified to the user
   * @return a non-null, potentially empty, unmodifiable list
   */
  @SuppressWarnings("unchecked")
  protected List<IEvaluationStatus> executeInstanceOperations(
      final List<? extends IPatternInstance> instances_p, final InstanceOperationKind operationKind_p,
      final RefreshRequestKind requestKind_p, boolean reuseLayout_p, boolean reuseStyle_p,
      boolean verbose_p, Object specification_p) {
    List<IEvaluationStatus> result = new ArrayList<IEvaluationStatus>();
    List<IModelOperation<? extends IEvaluationStatus>> instanceOperations =
        new FOrderedSet<IModelOperation<? extends IEvaluationStatus>>();
    if (!instances_p.isEmpty()) {
      // For diagram refresh, factor out the refresh in the end
      boolean delegateDiagramRefresh = requestKind_p == RefreshRequestKind.DIAGRAM;
      // Build sub-operations
      IPatternInstance last = instances_p.get(instances_p.size() - 1);
      for (IPatternInstance instance : instances_p) {
        RefreshRequestKind subRequestKind =
            (delegateDiagramRefresh && (instance != last)) ? RefreshRequestKind.NONE : requestKind_p;
        if (isApplicable(operationKind_p, instance)) {
          instanceOperations.add(getInstanceOperation(instance, operationKind_p, subRequestKind, specification_p));
        }
      }
    }
    if (!instanceOperations.isEmpty()) {
      // Build compound operation
      if (!instanceOperations.isEmpty()){
        IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
        if (env != null){
          for (IModelOperation<?> current : instanceOperations){
            Object obj = env.execute(current);
            if(obj instanceof Collection){
              result.addAll((Collection<IEvaluationStatus>)obj);
            } else if (obj instanceof IEvaluationStatus) {
              result.add((IEvaluationStatus)obj);
            }
          }
        } 
      }
      if (reuseLayout_p || reuseStyle_p) {
        reuseAppearanceOnAdditions(instanceOperations, reuseLayout_p, reuseStyle_p);
      }
      IEvaluationStatus localResult = result.isEmpty() ? null : result.get(0);
      if (verbose_p && (localResult != null) && (!localResult.isOk() || localResult.hasWarnings())) {
        UIUtil.informFromStatus(localResult, getShell());
      }
      refresh();
    }
    return result;
  }

  /**
   * Execute an instance operation of the given kind on the given instance with the given refresh specification
   * @param instance_p a non-null instance
   * @param operationKind_p a potentially null operation kind
   * @param requestKind_p a non-null refresh request kind
   * @param reuseLayout_p whether pattern layout must be reused if possible
   * @param verbose_p whether abnormal result information must be notified to the user
   * @return a potentially null status
   */
  protected IEvaluationStatus executeInstanceOperation(IPatternInstance instance_p,
      InstanceOperationKind operationKind_p, RefreshRequestKind requestKind_p,
      boolean reuseLayout_p, boolean reuseStyle_p, boolean verbose_p, Object specification_p) {
    List<IEvaluationStatus> allResults = executeInstanceOperations(
            Collections.singletonList(instance_p), operationKind_p, requestKind_p,
            reuseLayout_p, reuseStyle_p, verbose_p, specification_p);
    IEvaluationStatus result = allResults.isEmpty() ? null : allResults.get(0);
    return result;
  }

  /**
   * Execute the given model operation using the registered model accessor
   * @param operation_p a non-null operation
   * @return the result of the execution
   */
  protected final <E> E executeOperation(final IModelOperation<E> operation_p) {
    final List<E> wrapper = new ArrayList<E>(1);
    BusyIndicator.showWhile(getContents().getDisplay(), new Runnable() {
      public void run() {
        E result = CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation_p);
        wrapper.add(result);
      }
    });
    return wrapper.get(0);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#getColumnWidth(int)
   */
  @Override
  protected int getColumnWidth(int columnNb_p) {
    return 200;
  }

  /**
   * Return the folding/unfolding operation kind which can be performed on the current instance
   * @return a non-null operation kind
   */
  protected InstanceOperationKind getFoldingOperationKind() {
    InstanceOperationKind result;
    if (isApplicable(InstanceOperationKind.UNFOLD)) {
      result = InstanceOperationKind.UNFOLD;
    } else {
      result = InstanceOperationKind.FOLD;
    }
    return result;
  }

  /**
   * Create and return an instance operation of the given kind on the given instance with the given refresh specification
   * @param instance_p a non-null instance
   * @param operationKind_p a potentially null operation kind
   * @param requestKind_p a non-null refresh request kind
   * @return a non-null instance operation
   */
  protected IModelOperation<? extends IEvaluationStatus> getInstanceOperation(
      IPatternInstance instance_p, InstanceOperationKind operationKind_p,
      RefreshRequestKind requestKind_p, Object specification_p) {
    IModelOperation<? extends IEvaluationStatus> result = null;
    InstanceOperation operation = null;
    if (operationKind_p != null) {
      operation = new InstanceOperation(instance_p, operationKind_p, specification_p, _diagram, null);
    }
    result = _operationFactory.instantiateGraphicalWrappingInstanceOperation(operation, instance_p, _diagram, requestKind_p);
    return result;
  }

  /**
   * @see Window#getInitialSize()
   */
  @Override
  protected org.eclipse.swt.graphics.Point getInitialSize() {
    super.getInitialSize();
    return getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
  }

  /**
   * Return the instance explorer view if present in the current page
   * @return a potentially null instance explorer view
   */
  protected AbstractInstanceExplorerView getInstanceExplorerView() {
    AbstractInstanceExplorerView result = null;
    try {
      result = (AbstractInstanceExplorerView) 
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(getInstanceExplorerViewID());
    } catch (Exception e) {
      // Nothing
    }
    return result;
  }

  /**
   * Return the currently selected instance if there is only one, null otherwise
   * @return a potentially null instance
   */
  protected IPatternInstance getSelectedInstance() {
    IPatternInstance result = null;
    List<IPatternInstance> selection = getSelectedInstances();
    if (selection.size() == 1) {
      result = selection.get(0);
    }
    return result;
  }

  /**
   * Return the currently selected instances
   * @return a non-null, potentially empty, unmodifiable list
   */
  @SuppressWarnings({ "cast", "unchecked" })
  protected List<IPatternInstance> getSelectedInstances() {
    IStructuredSelection selection = (IStructuredSelection) _viewer.getSelection();
    // We know the type is correct
    return (List<IPatternInstance>) selection.toList();
  }

  /**
   * Return whether the instance operation of the given kind is applicable
   * @param operationKind_p a non-null operation kind
   */
  protected boolean isApplicable(InstanceOperationKind operationKind_p) {
    boolean result;
    if (InstanceOperationKind.CHECK == operationKind_p) {
      IPatternInstance instance = getSelectedInstance();
      result = (instance != null) && isApplicable(operationKind_p, instance);
    } else {
      result = false;
      List<IPatternInstance> instances = getSelectedInstances();
      for (IPatternInstance instance : instances) {
        if (isApplicable(operationKind_p, instance)) {
          result = true;
          break;
        }
      }
    }
    return result;
  }

  /**
   * Return whether the usage of this dialog triggered a change in the global state of pattern-related elements
   */
  public boolean globalPatternStateChanged() {
    return _globalPatternStateChanged;
  }

  /**
   * Return whether the instance operation of the given kind is applicable on the given instance
   * @param operationKind_p a non-null operation kind
   * @param instance_p a non-null instance
   */
  protected boolean isApplicable(InstanceOperationKind operationKind_p, IPatternInstance instance_p) {
    boolean result = false;
    boolean patternIsKnown = instance_p.getPattern() != null;
    switch (operationKind_p) {
    case UNFOLD:
      result = patternIsKnown && instance_p.isFolded();
      break;
    case FOLD:
    case UPDATE:
      result = patternIsKnown && !instance_p.isFolded();
      break;
    case CHECK:
      result = patternIsKnown;
      break;
    case DELETE:
    case DELETE_WITH_ELEMENTS:
      result = true;
      break;
    }
    return result;
  }

  /**
   * Return whether the current selection allows the reuse of pattern layout
   */
  protected boolean isLayoutReusePossible() {
    boolean result = _diagram != null;
    if (result) {
      List<IPatternInstance> selected = getSelectedInstances();
      result = !selected.isEmpty();
      if (result && (selected.size() == 1)) {
        IPatternInstance instance = selected.get(0);
        result = isLayoutReusePossibleOn(instance);
      }
    }
    return result;
  }

  /**
   * Return whether the given instance supports the reuse of pattern layout
   * @param instance_p a non-null pattern instance
   */
  protected boolean isLayoutReusePossibleOn(IPatternInstance instance_p) {
    boolean result = false;
    if (instance_p.getPattern() instanceof TemplatePattern) {
      TemplatePattern pattern = (TemplatePattern) instance_p.getPattern();
      result = !pattern.getLayoutData().isEmpty();
    }
    return result;
  }

  /**
   * Return whether pattern update is applicable
   */
  protected boolean isPatternUpdateApplicable() {
    IPatternInstance instance = getSelectedInstance();
    return (instance != null) && (instance.getPattern() != null);
  }

  /**
   * Notify that the usage of this dialog triggered a change in the global state of pattern-related elements
   */
  protected void notifyGlobalPatternStateChanged() {
    _globalPatternStateChanged = true;
  }

  /**
   * Refresh all controls
   */
  protected void refresh() {
    _viewer.refresh(true);
    List<IPatternInstance> instances = getSelectedInstances();
    IStructuredSelection newSelection = new StructuredSelection(instances);
    _viewer.setSelection(newSelection);
  }

  /**
   * Try and resolve the pattern of the current instance, if needed
   * @return whether the pattern was actually resolved
   */
  protected boolean resolvePatterns() {
    boolean result = false;
    List<IPatternInstance> instances = getSelectedInstances();
    if (!instances.isEmpty()) {
      result = UIUtil.resolvePatternWithUser(getShell(), instances);
    }
    if (result) {
      notifyGlobalPatternStateChanged();
      _viewer.refresh(true);
      refresh();
    }
    return result;
  }

  /**
   * Apply pattern layout on graphical elements created by the given operations
   * @param executedOperations_p a non-null, potentially empty set
   */
  protected void reuseAppearanceOnAdditions(Collection<? extends IModelOperation<?>> executedOperations_p,
      boolean reuseLayout_p, boolean reuseStyle_p) {
    List<AbstractFilteredGraphicalUpdateOperation> newOperations =
        new ArrayList<AbstractFilteredGraphicalUpdateOperation>();
    for (IModelOperation<?> executedOperation : executedOperations_p) {
      if (executedOperation instanceof AbstractGraphicalWrappingInstanceOperation) {
        AbstractGraphicalWrappingInstanceOperation<?> executedViewpointOperation =
            (AbstractGraphicalWrappingInstanceOperation<?>) executedOperation;
        IPatternInstance instance = executedViewpointOperation.getInstance();
        Collection<Object> diagramElements = executedViewpointOperation.getNewDiagramElements();
        if ((instance != null) && !diagramElements.isEmpty()) {
          AbstractFilteredGraphicalUpdateOperation newOperation = 
              _operationFactory.instantiateLayoutReuseOperation(
                  diagramElements, instance, null, null, 0, 0, reuseLayout_p, reuseStyle_p, _diagram);
          newOperations.add(newOperation);
        }
      }
    }
    if (!newOperations.isEmpty()) {
      if(!newOperations.isEmpty()){
        IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
        if (env != null){
          for (IModelOperation<?> current : newOperations){
            env.execute(current);
          }
        } 
      }
    }
  }

  /**
   * Update the pattern of the given instance from the instance
   * @param instance_p a non-null instance
   */
  protected void updatePattern(IPatternInstance instance_p) {
    PatternWizardDialog dialog = new PatternWizardDialog(
        getShell(), new PatternUpdateWizard(instance_p, _referenceElement, _graphicalContext, _selectedFeaturesToIgnore));
    int answer = dialog.open();
    if (Window.OK == answer) {
      if (dialog.isSuccessful()) {
        UIUtil.informSuccess(getShell());
        refresh();
      } else {
        UIUtil.informError(getShell());
      }
    }
  }

}
