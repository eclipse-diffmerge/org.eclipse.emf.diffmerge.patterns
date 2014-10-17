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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.List;

import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.diffdata.EMatch;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.PatternUpdateComparisonViewer;
import org.eclipse.emf.diffmerge.ui.diffuidata.MatchAndFeature;
import org.eclipse.emf.diffmerge.ui.diffuidata.impl.MatchAndFeatureImpl;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.diffmerge.ui.viewers.FeaturesViewer;
import org.eclipse.emf.diffmerge.ui.viewers.FeaturesViewer.FeaturesInput;
import org.eclipse.emf.diffmerge.ui.viewers.ValuesViewer;
import org.eclipse.emf.diffmerge.ui.viewers.ValuesViewer.ValuesInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


/**
 * A dialog for showing details about instance conformity to its pattern.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class InstanceConformityDialog extends MessageDialog {

  /** The differences as a non-null update specification */
  protected final TemplatePatternUpdateSpecification _data;

  /**  The comparison viewer */
  protected PatternUpdateComparisonViewer _differencesViewer;

  /**  Details feature viewer */
  protected FeaturesViewer _detailsViewer;

  /**  Reference values viewer */
  protected ValuesViewer _referenceViewer;

  /**  Target values viewer */
  protected ValuesViewer _targetViewer;

  /** Currently selected elements in the _differencesViewer */
  protected IStructuredSelection _selection;

  /** An EMF diff node */
  EMFDiffNode _diffNode;

  /** detail feature viewer selected match */
  EMatch _selectedMatch;

  /** The sash form that separates the differences viewer from the details */
  private SashForm _sash;

  /** The reference element's editing domain */
  protected EditingDomain _editingDomain;

  /**
   * Constructor
   * @param parentShell_p a non-null shell
   * @param statusOverview_p the non-null short description of the conformity status
   * @param instance_p the non-null instance to evaluate for conformity
   * @param referenceElement_p an optional element to use as a reference for multipart
   */
  public InstanceConformityDialog(Shell parentShell_p, String statusOverview_p,
      IPatternInstance instance_p, EObject referenceElement_p, List<EStructuralFeature> featuresToIgnore_p) {
    super(parentShell_p, Messages.InstanceConformityDialog_Header,
        null, Messages.InstanceConformityDialog_Status + statusOverview_p, MessageDialog.INFORMATION,
        new String[] {IDialogConstants.OK_LABEL}, 0);
    _data = new TemplatePatternUpdateSpecification(instance_p, referenceElement_p, featuresToIgnore_p);
    setShellStyle(getShellStyle() | SWT.RESIZE);
    _editingDomain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(referenceElement_p);
    _diffNode = new EMFDiffNode(_data.getVisualizationComparison(), _editingDomain);
  }

  /**
   * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createCustomArea(Composite parent_p) {
    // Differences group
    final Group differencesGroup = new Group(parent_p, SWT.FILL);
    differencesGroup.setText(getGroupName());
    GridData groupData = new GridData(SWT.FILL, SWT.FILL, true, true);
    groupData.heightHint = 250;
    differencesGroup.setLayoutData(groupData);
    GridLayout groupLayout = new GridLayout(1, false);
    differencesGroup.setLayout(groupLayout);
    //SashForm
    _sash = new SashForm(differencesGroup, SWT.NONE | SWT.VERTICAL | SWT.SMOOTH);
    _sash.setLayout(new FillLayout());
    _sash.setLayoutData(new GridData(GridData.FILL_BOTH));
    // Differences content
    _differencesViewer = new PatternUpdateComparisonViewer(
        _sash, _editingDomain, false, false) {
      /**
       * 
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        return ModelSubsetViewer.SORT | ModelSubsetViewer.EXPAND | ModelSubsetViewer.COLLAPSE
            | ModelSubsetViewer.SHOW_PARENTS;
      }
    };
    _differencesViewer.setInput(getData());
    createDetailsGroup(_sash);
    _sash.setWeights(new int[] {5, 3});
    return differencesGroup;
  }

  /**
   * Creates the group of widgets in the UI related to the details of differences
   */
  private void createDetailsGroup(Composite parent_p) {
    //Details Group
    Group detailsGroup = new Group(parent_p, SWT.FILL);
    detailsGroup.setText(Messages.InstanceConformityDialog_DetailsGroup);
    detailsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    detailsGroup.setLayout(new GridLayout(3, false));
    //Details feature viewer
    createCompositeArea(detailsGroup, Messages.InstanceConformityDialog_DetailsDifferenceGroup, 0);
    //Instance values viewer
    createCompositeArea(detailsGroup, Messages.InstanceConformityDialog_DetailsLeftGroup, 1); 
    //Pattern values viewer
    createCompositeArea(detailsGroup, Messages.InstanceConformityDialog_DetailsRightGroup, 2);
    //Listeners
    createSynchronizationListener();
  }

  /**
   * Creates a composite area. Depending on the role_p, the details FeatureViewer, the target ValuesViewer and the reference ValuesViewer are created.
   * @param parent_p
   * @param message_p
   * @param role_p
   * @return
   */
  private Composite createCompositeArea(Composite parent_p, String message_p, final int role_p){
    Composite composite = createEmptyComposite(parent_p, 1);
    final Label label = new Label(composite, SWT.FILL);
    label.setText(message_p);
    //viewers
    if(role_p == 1){
      _targetViewer = new ValuesViewer(composite, true);
    }else if(role_p == 2){
      _referenceViewer = new ValuesViewer(composite, false);
    }else if(role_p == 0){
      //Details feature viewer
      createDetailsFeatureViewer(composite);
    }
    return composite;
  }

  /**
   * Crates the details feature viewer
   * @param parent_p
   */
  private void createDetailsFeatureViewer(Composite parent_p) {
    _detailsViewer = new FeaturesViewer(parent_p);
    // feature viewer listener
    _detailsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event_p) {
        _targetViewer.setInput(null);
        _referenceViewer.setInput(null);
        ISelection detailSelection = _detailsViewer.getSelection();
        if(detailSelection != null){
          if(detailSelection instanceof StructuredSelection){
            if(!((StructuredSelection)detailSelection).isEmpty()){
              Object obj =((StructuredSelection)detailSelection).getFirstElement();
              if(obj instanceof EStructuralFeature){
                MatchAndFeature maf = new MatchAndFeatureImpl(_selectedMatch, (EStructuralFeature)obj);
                // Target viewer input
                ValuesInput targetInput = new ValuesInput(_diffNode, maf);
                _targetViewer.setInput(targetInput);
                // Reference viewer input
                ValuesInput referenceInput = new ValuesInput(_diffNode, maf);
                _referenceViewer.setInput(referenceInput); 
              }
            }
          }
        } 
      } 
    }
        );
  }

  /**
   * Creates a listener for the details FeatureViewer to update its input when the selection changes in the main differences viewer.
   */
  protected void createSynchronizationListener() {
    // Selection synchronization: Synthesis[user] -> Global
    _differencesViewer.getClientViewer().getTree().addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        _detailsViewer.setInput(null);
        _selection = _differencesViewer.getSelection();
        Object obj = _selection.getFirstElement();
        if(obj != null){
          if(obj instanceof EObject){
            // details feature viewer
            IMatch match = _data.getVisualizationComparison().getMapping().getMatchFor(
                (EObject)obj, Role.TARGET);
            if(match instanceof EMatch){
              _selectedMatch = (EMatch) match;
              FeaturesInput input = new FeaturesInput(_diffNode , _selectedMatch);
              _detailsViewer.setInput(input);
              if(_detailsViewer.getElementAt(0) != null)
                _detailsViewer.setSelection(new StructuredSelection(_detailsViewer.getElementAt(0)));
            }
          }
        }   
      }
    });
  }

  /**
   * Return the non-null update specification containing data about the differences
   */
  private TemplatePatternUpdateSpecification getData() {
    return _data;
  }

  /**
   * Return a name for the differences group
   * @return a non-null string
   */
  private String getGroupName() {
    int nbDiffs = getData().getVisualizationComparison().getRemainingDifferences().size();
    return String.format(Messages.InstanceConformityDialog_Details,
        Integer.valueOf(nbDiffs));
  }

  /**
   * Create and return a composite with neutral (margin-free) grid layout
   * @param parent_p a non-null composite
   * @param columns_p the number of columns in its layout
   * @return a non-null composite
   */
  protected Composite createEmptyComposite(Composite parent_p, int columns_p) {
    Composite result = new Composite(parent_p, SWT.BORDER);
    result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    GridLayout layout = new GridLayout(columns_p, false);
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    result.setLayout(layout);
    return result;
  }

}
