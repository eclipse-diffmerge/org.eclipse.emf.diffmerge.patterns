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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.update;

import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.diffdata.EMatch;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification.ITemplateElementsChangedListener;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.PatternUpdateComparisonViewer;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractModifiableTemplateElementsPage;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;


/**
 * A wizard page for updating a new pattern
 * @author Olivier Constant
 * @author Skander Turki
 */
public class PatternUpdateElementsPage
extends AbstractModifiableTemplateElementsPage<TemplatePatternUpdateSpecification> {

  /**  Details feature viewer */
  protected FeaturesViewer _detailsViewer;

  /**  Reference values viewer */
  protected ValuesViewer _referenceViewer;

  /**  Target values viewer */
  protected ValuesViewer _targetViewer;

  /** A model comparison diff node */
  EMFDiffNode _diffNode;

  /** detail feature viewer selected match */
  EMatch _selectedMatch;
  
  /** The reference element's editing domain */
  protected EditingDomain _editingDomain;

  /** Currently selected elements in the _differencesViewer */
  protected IStructuredSelection _selection;

  /** The sash form that separates the differences viewer from the details */
  SashForm _sash;

  /**
   * Constructor
   * @param updateData_p the non-null data for template pattern creation
   */
  public PatternUpdateElementsPage(TemplatePatternUpdateSpecification updateData_p) {
    super(Messages.PatternUpdateElementsPage_Name, updateData_p);
    EObject obj = updateData_p.getScopeElement();
    if(obj != null){
      _editingDomain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(obj);
      _diffNode = new EMFDiffNode(updateData_p.getVisualizationComparison(), _editingDomain);
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createModelViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected ModelSubsetViewer createModelViewer(Composite parent_p) {
    final PatternUpdateComparisonViewer resultViewer = new PatternUpdateComparisonViewer(
        parent_p, _editingDomain, true, false) {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        int result = ModelSubsetViewer.SORT | ModelSubsetViewer.EXPAND |
            ModelSubsetViewer.COLLAPSE;
        if (PatternUpdateElementsPage.this.showParentsCheckbox())
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
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createTemplateElementsGroup(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Group createTemplateElementsGroup(Composite parent_p) {
    final Group result = createGroup(parent_p, getElementsGroupName(), true, 1);
    getData().addTemplateElementsChangedListener(new ITemplateElementsChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification.ITemplateElementsChangedListener#templateElementsChanged()
       */
      public void templateElementsChanged() {
        result.setText(getElementsGroupName());
      }
    });
    return result;
  }



  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#getElementsGroupName()
   */
  @Override
  protected String getElementsGroupName() {
    StringBuilder result = new StringBuilder();
    int nbDiffs = getData().getVisualizationComparison().getRemainingDifferences().size();
    result.append(super.getElementsGroupName());
    result.append(' ');
    result.append('(');
    result.append(nbDiffs);
    result.append(' ');
    if (nbDiffs == 1)
      result.append(Messages.PatternUpdateElementsPage_SingleDiff);
    else
      result.append(Messages.PatternUpdateElementsPage_ManyDiffs);
    result.append(')');
    return result.toString();
  }

  /**
   * Creates specific controls.
   */
  @Override
  protected Composite createSpecificControls(){
    Composite additionalElementComposite = new Composite(_sash, SWT.FILL);
    additionalElementComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    additionalElementComposite.setLayout(layout);
    //Viewers row
    createDetailsGroup(additionalElementComposite);
    _sash.setWeights(new int[] {5, 3});
    return additionalElementComposite;
  }

  /**
   * 
   */
  private void createButtonsGroup(Composite parent_p){
    //Buttons row
    Composite buttonsComposite = new Composite(parent_p, SWT.NONE);
    buttonsComposite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    GridLayout layout2 = new GridLayout(2, false);
    layout2.marginHeight = 0;
    layout2.marginWidth = 0;
    buttonsComposite.setLayout(layout2);
    createIncludeAllDependenciesButton(buttonsComposite);
    createIncludeAllInstancesButton(buttonsComposite);
  }

  /**
   * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createControl(Composite parent_p) {
    final Composite mainComposite = new Composite(parent_p, SWT.FILL);
    setControl(mainComposite);
    Layout mainCompositeLayout = new GridLayout(2, false);
    mainComposite.setLayout(mainCompositeLayout);
    setDefaultMessage();
    _templateElementsViewer = createTemplateElementControls(mainComposite);
    createSpecificControls();
    createButtonsGroup(_sash.getParent());
    createRoleControls(mainComposite, allowEdition());
  }

  /**
   * Create the controls related to template elements within the given composite
   * @param parent_p a non-null composite
   * @return a non-null viewer
   */
  @Override
  protected ModelSubsetViewer createTemplateElementControls(Composite parent_p) {
    // Template Elements Group
    Group contentsGroup = createTemplateElementsGroup(parent_p);
    //SahsForm
    _sash = new SashForm(contentsGroup, SWT.NONE | SWT.VERTICAL | SWT.SMOOTH);
    _sash.setLayout(new FillLayout());
    _sash.setLayoutData(new GridData(GridData.FILL_BOTH));
    //_sash.setBackground(_sash.getDisplay().getSystemColor( SWT.COLOR_GRAY));
    // Tree viewer
    final ModelSubsetViewer result = createModelViewer(_sash);
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
   * Creates a composite area. Depending on the role_p, the details FeatureViewer, the target ValuesViewer
   * and the reference ValuesViewer are created.
   * @param parent_p a non-null composite
   * @param message_p an optional message
   * @param role_p 0 for FeatureViewer, 1 for target ValuesViewer, 2 for reference ValuesViewer
   * @return a non-null composite
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
   * @param parent_p a non-null composite
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
    _templateElementsViewer.getTreeViewer().getTree().addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        _detailsViewer.setInput(null);
        _selection = _templateElementsViewer.getSelection();
        Object obj = _selection.getFirstElement();
        if(obj != null){
          if(obj instanceof EObject){
            // details feature viewer
            IMatch match = getData().getVisualizationComparison().getMapping().getMatchFor(
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
