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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.util.PatternsInstancesUIUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;


/**
 * A dialog that is used to highlight pattern instances in the current diagram
 * @author Skander Turki
 * @author Olivier Constant
 */
public abstract class HighlightAllPatternsInstancesPanelDialog extends AbstractHighlightAllPatternsInstancesPanelDialog {

  /** The diagram from which the dialog has been called */
  Object _diagram;

  /** Color to use for the highlight */
  Object _color;

  /** Whether nodes should be highlighted or not */
  boolean _highlightNodes;

  /** Whether edges should be highlighted or not */
  boolean _highlightEdges;

  /** Whether ports should be highlighted or not */
  boolean _highlightPorts;

  /** Whether pattern layout must be reused when instance is updated */
  protected boolean _reuseStyleAtUpdate;

  /** The width of push buttons */
  private static final int BUTTON_WIDTH = 110;

  /**
   * A dialog that is used to highlight pattern instances in the current diagram
   * @param instances_p a non-null set of IPatternInstance elements to highlight
   * @param diagram_p a non-null Object; the current diagram
   * @param parentShell_p a non-null shell
   * @param dialogTitle_p a message used as the dialog title
   * @param dialogMessage_p a message used as an information to the user about this dialog
   */
  public HighlightAllPatternsInstancesPanelDialog(Set<IPatternInstance> instances_p, Object diagram_p, Shell parentShell_p, String dialogTitle_p,
      String dialogMessage_p) {
    super(parentShell_p, instances_p);
    _diagram = diagram_p;
    _color = instantiateColorObject(255, 0, 0);
    _highlightNodes = true;
    _highlightPorts = true;
    _highlightEdges = true;
    _reuseStyleAtUpdate = true;
  }

  protected abstract Object instantiateColorObject(int R, int G,int B);
  protected abstract Object convertSWTRGBToColor(RGB swtColor_p);
  protected abstract RGB convertColorToSWTRGB(Object color_p);
  protected abstract int colorRed(Object color_p);
  protected abstract int colorGreen(Object color_p);
  protected abstract int colorBlue(Object color_p);

  /**
   * {@inheritDoc}
   */
  @Override
  protected String getColumnText(IPatternInstance instance_p, int columnIndex_p) {
    if (columnIndex_p == 0) {
      if (instance_p.getPatternData() instanceof AbstractPatternData) {
        AbstractPatternData data = (AbstractPatternData) instance_p.getPatternData();
        return data.getId();
      }
    } else if (columnIndex_p == 1) {
      return PatternsInstancesUIUtil.getInstanceAsText(instance_p);
    } else if (columnIndex_p == 2) {
      return PatternsInstancesUIUtil.getPatternAsText(instance_p);
    }
    return ""; //$NON-NLS-1$
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected List<String> getColumnHeaders() {

    return Arrays.asList(Messages.HighlightAllPatternsInstances_DialogColumnHeaderInstance, Messages.HighlightAllPatternsInstances_DialogColumnHeaderInstance,
        Messages.HighlightAllPatternsInstances_DialogColumnHeaderPattern);
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
        EditingDomain domain = null;
        //Object selection = event_p.getSource();
        List<IPatternInstance> selection = getSelectedInstances();
        if(!selection.isEmpty()){
          EObject context = (EObject)(selection.get(0).getScopeElement());
          domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(context);
        }       
        if (domain != null) {
          CorePatternsPlugin
          .getDefault()
          .getModelEnvironment()
          .execute( _operationFactory.instantiateHighlightOperation(_diagram, getSelectedInstances(), new RGB(colorRed(_color), colorGreen(_color), colorBlue(_color)), 
              3, _highlightEdges,  _highlightNodes, _highlightPorts));
        }
      }
    });
    // Update
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        // NOTHING
      }
    });
    return result;
  }

  /**
   * Create and return the button for unhighlighting an instance. When "reuse Style" is checked, the style is re-applied to the previously highlighted elements.
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createResetHighlightButton(Composite parent_p) {
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
        List<IPatternInstance> instances = getSelectedInstances();
        IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
        if(env != null){
          env.execute(instantiateRestoreOperation(_diagram, instances));
          List<IPatternInstance> instancesWithNoAvailableLayout = getAllInstancesLayoutReuseNotPossible();
          if (_reuseStyleAtUpdate) {
            Set<String> patternsNames = new HashSet<String>();
            String messageCatalogs = ""; //$NON-NLS-1$
            if (instancesWithNoAvailableLayout.size() == instances.size()) {
              messageCatalogs = Messages.HighlightAllPatternsInstances_NoInstanceLayoutAndStyleInformationAvailable;
              messageCatalogs += "\n"; //$NON-NLS-1$
            }
            if (!instancesWithNoAvailableLayout.isEmpty()) {
              messageCatalogs += Messages.HighlightAllPatternsInstances_ConsiderOpeningPatternCatalogs;
              messageCatalogs += "\n"; //$NON-NLS-1$
              for (IPatternInstance instance : instancesWithNoAvailableLayout) {
                patternsNames.add(PatternsInstancesUIUtil.getPatternAsText(instance));
              }
              for (String str : patternsNames) {
                messageCatalogs += str;
                messageCatalogs += "\n"; //$NON-NLS-1$
              }
              MessageDialog.openInformation(getShell(), CorePatternsPlugin.getDefault().getLabel(), messageCatalogs);
            }
            if (_reuseStyleAtUpdate && !(instancesWithNoAvailableLayout.size() == instances.size())) {
              for (IPatternInstance instance : instances) {
                AbstractFilteredGraphicalUpdateOperation lop = _operationFactory.instantiateLayoutReuseOperation(_diagram, instance, 
                    new Hashtable<Object, Point>(), new Hashtable<Object, Object>(), 0, 0, false, _reuseStyleAtUpdate, _diagram);
                env.execute(lop);
              }
            }
          }
        }
      }
    });
    return result;
  }

  /**
   * Instantiates an operation for restoring diagram elements based on specific criteria on semantic elements.
   * @param diagram_p
   * @param instances_p
   * @return
   */
  protected AbstractFilteredGraphicalUpdateOperation instantiateRestoreOperation(Object diagram_p, Collection<? extends IPatternInstance>  instances_p)
  {
    IPatternOperationFactory factory = PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    if(factory != null){
      return factory.instantiateRestoreOperation(diagram_p, instances_p);
    }
    return null;
  }

  /**
   * Returns a list of all instances for which the reuse of pattern layout and style is not possible
   * @return A non-null list of IPatternInstance elements from the selected instances
   */
  protected List<IPatternInstance> getAllInstancesLayoutReuseNotPossible() {
    List<IPatternInstance> result = new ArrayList<IPatternInstance>();
    List<IPatternInstance> selected = getSelectedInstances();
    for (IPatternInstance instance : selected) {
      if (!isLayoutReusePossibleOn(instance)) {
        result.add(instance);
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
   * Return the currently selected instances
   * @return a non-null, potentially empty, unmodifiable list
   */
  @SuppressWarnings("unchecked")
  protected List<IPatternInstance> getSelectedInstances() {
    IStructuredSelection selection = (IStructuredSelection) _viewer.getSelection();
    // We know the type is correct
    return selection.toList();
  }

  /**
   * Create the row for "highlight instance"
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  private Button createHighlightRow(Composite parent_p) {
    final Button highlightButton = createHighlightButton(parent_p);
    // Composite
    Composite composite = createEmptyComposite(parent_p, 6);
    // Color button
    final ColorSelector colorButton = new ColorSelector(composite);
    //colorButton.setColorValue(ColorUtil.convertRGBValuesToRGB(_color));
    colorButton.setColorValue(convertColorToSWTRGB(_color));
    colorButton.addListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event_p) {
        if (event_p.getNewValue() instanceof RGB) {
          _color = convertSWTRGBToColor((RGB) event_p.getNewValue());
          //_color = ColorUtil.convertRGBToRGBValues((RGB) event_p.getNewValue());
        }
      }
    });
    // Nodes check-box
    final Button coverNodesButton = new Button(composite, SWT.CHECK);
    coverNodesButton.setText(Messages.InstancePanelDialog_Nodes);
    coverNodesButton.setSelection(_highlightNodes);
    // Ports check-box
    final Button coverPortsButton = new Button(composite, SWT.CHECK);
    coverPortsButton.setText(Messages.InstancePanelDialog_Ports);
    coverPortsButton.setSelection(_highlightPorts);
    // Edges check-box
    final Button coverEdgesButton = new Button(composite, SWT.CHECK);
    coverEdgesButton.setText(Messages.InstancePanelDialog_Edges);
    coverEdgesButton.setSelection(_highlightEdges);
    // Separator
    final Label separator = new Label(composite, 0);
    separator.setText("          "); //$NON-NLS-1$

    // Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        // Nothing
      }
    });
    // Execution
    coverNodesButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _highlightNodes = coverNodesButton.getSelection();
      }
    });
    coverPortsButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _highlightPorts = coverPortsButton.getSelection();
      }
    });
    coverEdgesButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _highlightEdges = coverEdgesButton.getSelection();
      }
    });
    return highlightButton;
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
    Control selectionControl = super.createCustomArea(result);
    Table selectionTable = null;
    if (selectionControl instanceof Table) {
      selectionTable = (Table) selectionControl;
      selectionTable.setVisible(false);
    }
    GridData dataMain = new GridData(SWT.FILL, SWT.FILL, true, true);
    selectionTable.setLayoutData(dataMain);
    enhanceSelectionTable(selectionTable);
    // Buttons
    createButtonsArea(result);
    selectAll();
    return result;
  }

  /**
   * Create the area where the buttons for instance operations are located
   * @param parent_p a non-null composite
   */
  private void createButtonsArea(Composite parent_p) {
    // Representation
    Group repGroup = new Group(parent_p, SWT.NONE);
    repGroup.setText(Messages.InstancePanelDialog_Representation);
    repGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    repGroup.setLayout(new GridLayout(2, false));
    // Representation contents
    createHighlightRow(repGroup);
    createReuseStyleRow(repGroup);
  }

  /**
   * Add behavior and menus to the instance selection table
   * @param selectionTable_p a non-null control
   */
  private void enhanceSelectionTable(Table selectionTable_p) {
    SelectionListener listener = new SelectionListener() {
      public void widgetSelected(SelectionEvent e_p) {
        // Nothing
      }
      public void widgetDefaultSelected(SelectionEvent e_p) {
        // Nothing
      }
    };
    selectionTable_p.addSelectionListener(listener);
  }

  /**
   * Hides the first column that contains the instance id Return the width of the given column
   * @param columnNb_p a positive int or 0
   */
  @Override
  protected int getColumnWidth(int columnNb_p) {
    if (columnNb_p == 0) {
      return 0;
    }
    return DEFAULT_COLUMN_WIDTH;
  }

  /**
   * Create the button for restoring the style
   * @param parent_p a non-null composite
   */
  private void createReuseStyleRow(Composite parent_p) {
    // Reset Button
    createResetHighlightButton(parent_p);
    // reuse style check box
    createReuseStyleButton(parent_p);
  }

  /**
   * Create the button for restoring the style
   * @param parent_p a non-null composite
   */
  private void createReuseStyleButton(Composite parent_p) {
    // Nodes check-box
    final Button reuseStyleButton = new Button(parent_p, SWT.CHECK);
    reuseStyleButton.setText(Messages.InstancePanelDialog_RestoreStyle);
    reuseStyleButton.setSelection(_reuseStyleAtUpdate);
    // reuseStyleButton.setEnabled(isLayoutReusePossible());
    reuseStyleButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        _reuseStyleAtUpdate = reuseStyleButton.getSelection();
      }
    });
  }

  /**
   * Hides the table containing the list of instances. In case we would allow the user to select instances to highlight remove the y assignment
   * @see org.eclipse.jface.dialog.Dialog#getInitialSize()
   */
  @Override
  protected Point getInitialSize() {
    Point result = super.getInitialSize();
    int sum = 0;
    for (int i = 0; i < getColumnsNumber(); i++) {
      sum += getColumnWidth(i);
    }
    result.x = sum + WIDTH_INCREMENT;
    // y assignment hiding the place reserved for the table
    result.y = 250;
    return result;
  }

}
