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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;


/**
 * A dialog that displays a table of given elements with additional information in a
 * given number of columns and allows the user to select one or several elements.
 * @author Olivier Constant
 */
public abstract class AbstractTableChoiceDialog<T> extends MessageDialog {
	
  /** The possible kinds of selection */
  public static enum SelectionKind {
    /** Single selection */
    SINGLE,
    /** Multiple selection */
    MULTI,
    /** Multiple selection based on check boxes */
    MULTI_CHECK
  }
  
  /** The default width for columns */
  protected static final int DEFAULT_COLUMN_WIDTH = 240;
  
  /** The width margin of the window in addition to the width of the columns */
  protected static final int WIDTH_INCREMENT = 40;
  
  /** The non-null list of elements to choose from */
	protected final List<T> _originalList;
	
  /** The kind of selection */
  private final SelectionKind _selectionKind;
  
	/** The viewer for the central table */
	protected TableViewer _viewer;
	
  /** The selection */
  private IStructuredSelection _selection;
  
  /** Utility class instance used to call type-related services from the graphical framework (Sirius for example) */
  protected AbstractGenericTypeUtil _genericTypeUtil;
  
  /** Utility class instance used to call diagram-related services from the graphical framework (Sirius for example) */
  protected AbstractDiagramUtil _diagramUtil;

  /** Dialog and Wizard factory */
  protected IPatternDialogAndWizardFactory _dialogAndWizardFactory;
  
  /** Operation factory */
  protected IPatternOperationFactory _operationFactory;
	
	
	/**
	 * Constructor
	 * @param parentShell_p the shell for this dialog
	 * @param dialogTitle_p the optional dialog title
	 * @param dialogMessage_p the dialog message
	 * @param elements_p the list of elements to choose from
	 * @param selectionKind_p the kind of selection
	 */
	public AbstractTableChoiceDialog(Shell parentShell_p, String dialogTitle_p, String dialogMessage_p,
			Collection<? extends T> elements_p, SelectionKind selectionKind_p) {
	  this(parentShell_p, dialogTitle_p, dialogMessage_p, MessageDialog.QUESTION,
	      elements_p, selectionKind_p, true);
	}
	
  /**
   * Constructor
   * @param parentShell_p the shell for this dialog
   * @param dialogTitle_p the optional dialog title
   * @param dialogMessage_p the dialog message
   * @param iconKind_p the code for the icon (e.g., {@link MessageDialog#QUESTION})
   * @param elements_p the list of elements to choose from
   * @param selectionKind_p the kind of selection
   * @param canConfirm_p whether an OK button must b present
   */
  public AbstractTableChoiceDialog(Shell parentShell_p, String dialogTitle_p, String dialogMessage_p,
      int iconKind_p, Collection<? extends T> elements_p, SelectionKind selectionKind_p,
      boolean canConfirm_p) {
    super(parentShell_p, dialogTitle_p != null? dialogTitle_p: CorePatternsPlugin.getDefault().getLabel(),
      null, dialogMessage_p, iconKind_p, 
      canConfirm_p? new String[] {IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL}:
        new String[] {IDialogConstants.CLOSE_LABEL}, 0);
    _genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
    _diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    _dialogAndWizardFactory = PatternsUIPlugin.getDefault().getDialogAndWizardFactory();
    _operationFactory = PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    _originalList = new ArrayList<T>(elements_p);
    _selectionKind = selectionKind_p;
    _selection = null;
    setShellStyle(getShellStyle() | SWT.RESIZE);
  }
  
  /**
   * @see org.eclipse.jface.dialogs.Dialog#close()
   */
  @Override
  public boolean close() {
    rememberSelection();
    return super.close();
  }
  
	/**
	 * We override this method to introduce a slight change: we wrap the custom control
	 * into a scrolled composite to circumvent the fact that the custom control (a table)
	 * does not seem to take SWT.V_SCROLL into account.
	 * @see org.eclipse.jface.dialogs.MessageDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent_p) {
	  // Create message area
	  createMessageArea(parent_p);
	  // Create the top level composite for the dialog area
    ScrolledComposite composite = new ScrolledComposite(parent_p, SWT.V_SCROLL);
	  GridLayout layout = new GridLayout();
	  layout.marginHeight = 0;
	  layout.marginWidth = 0;
	  composite.setLayout(layout);
	  GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	  data.horizontalSpan = Integer.MAX_VALUE;
	  composite.setLayoutData(data);
	  // Allow subclasses to add custom controls
	  Control customArea = createCustomArea(composite);
    composite.setContent(customArea);
    composite.setExpandHorizontal(true);
    composite.setExpandVertical(true);
	  return composite;
	}
	
	/**
	 * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
	 */
  @Override
  protected Control createCustomArea(Composite parent_p) {
    Table result = createTable(parent_p);
    _viewer = new TableViewer(result);
    _viewer.setContentProvider(new ArrayContentProvider());
    _viewer.setLabelProvider(getLabelProvider());
    _viewer.setInput(_originalList);
    selectFirst();
		return result;
	}
  
  /**
   * Create and return the central table for this dialog
   * @param parent_p a non-null containing composite
   * @return a non-null table
   */
  protected Table createTable(Composite parent_p) {
    int style = SWT.BORDER | SWT.FULL_SELECTION;
    switch (_selectionKind) {
      case MULTI_CHECK:
        style = style | SWT.CHECK | SWT.HIDE_SELECTION;
        break;
      case MULTI:
        style = style | SWT.MULTI;
        break;
      default:
    }
    Table result = new Table(parent_p, style);
    List<String> headers = getColumnHeaders();
    int nbCol = getColumnsNumber();
    for (int i = 0; i < nbCol; i++) {
      TableColumn fCol = new TableColumn(result, SWT.LEFT);
      String header = (i < headers.size())? headers.get(i): ""; //$NON-NLS-1$
      fCol.setText(header);
      int colWidth = getColumnWidth(i);
      fCol.setWidth(colWidth > 0? colWidth: 0);
    }
    result.setLinesVisible(true);
    result.setHeaderVisible(true);
    return result;
  }
  
  /**
   * Return the text to display in the given column for the given element
   * @param element_p a non-null element belonging to the list to choose from
   * @param columnIndex_p the index of the column
   * @return a non-null list of strings whose size is usually the number of columns
   */
  protected abstract String getColumnText(T element_p, int columnIndex_p);
	
  /**
   * Return the text to display in the different columns as headers
   * @return a non-null list of strings whose size is usually the number of columns
   */
  protected abstract List<String> getColumnHeaders();
  
  /**
   * Return the number of columns to display in the table
   */
  protected int getColumnsNumber() {
    // Override if needed
    return getColumnHeaders().size();
  }
  
  /**
   * Return the width of the given column
   * @param columnNb_p a positive int or 0
   */
  protected int getColumnWidth(int columnNb_p) {
    // Override if needed
    return DEFAULT_COLUMN_WIDTH;
  }
  
	/**
	 * Return all the elements which have been selected by the user
	 * @return a non-null, potentially empty, unmodifiable list
	 */
	@SuppressWarnings("unchecked")
  public List<T> getChoices() {
		return _selection == null? Collections.emptyList():
		  Collections.unmodifiableList(_selection.toList());
	}
	
	/**
	 * Return the first element, if any, which has been chosen by the user
	 * @return a potentially null element
	 */
  @SuppressWarnings("unchecked")
  public T getChoice() {
    T result = null;
    if (_selection != null && !_selection.isEmpty())
      result =(T)_selection.getFirstElement();
    return result;
	}
	
  /**
   * @see org.eclipse.jface.dialogs.Dialog#getInitialSize()
   */
  @Override
  protected Point getInitialSize() {
    Point result = super.getInitialSize();
    int sum = 0;
    for (int i=0; i<getColumnsNumber(); i++) {
      sum += getColumnWidth(i);
    }
    result.x = sum + WIDTH_INCREMENT;
    return result;
  }
  
  /**
   * Return a label provider for the table viewer
   * @return a non-null label provider
   */
  protected ILabelProvider getLabelProvider() {
    return new TableLabelProvider();
  }
  
  /**
   * Select all elements
   */
  protected void selectAll() {
    _viewer.setSelection(new StructuredSelection(_originalList));
  }
  
  /**
   * Select the first element
   */
  protected void selectFirst() {
    if (_viewer.getTable().getItemCount() > 0)
      _viewer.setSelection(new StructuredSelection(_viewer.getElementAt(0)));
  }
  
  /**
   * Store the selected elements in local variable
   */
  private void rememberSelection() {
    if (SelectionKind.MULTI_CHECK == _selectionKind) {
      // Yes, we have to do that... *sigh*
      List<Object> allChecked = new ArrayList<Object>();
      for (TableItem item : _viewer.getTable().getItems()) {
        if (item.getChecked())
          allChecked.add(item.getData());
      }
      _selection = new StructuredSelection(allChecked);
    } else {
      _selection = (IStructuredSelection)_viewer.getSelection();
    }
  }
  
  
  /**
   * A table label provider for the table viewer
   */
  protected class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
    /**
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     */
    @SuppressWarnings("unchecked")
    public String getColumnText(Object element_p, int columnIndex_p) {
      return AbstractTableChoiceDialog.this.getColumnText((T)element_p, columnIndex_p);
    }
    /**
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
     */
    public Image getColumnImage(Object element_p, int columnIndex_p) {
      return getImage(element_p);
    }
  }
  
}
