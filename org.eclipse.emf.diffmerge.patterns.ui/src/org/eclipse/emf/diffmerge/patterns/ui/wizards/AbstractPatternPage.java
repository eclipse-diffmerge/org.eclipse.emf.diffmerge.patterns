/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;


/**
 * An abstract wizard page which provides reusable GUI features for template patterns.
 * @param T the type of the data being built via the page
 * @author O. CONSTANT
 */
public abstract class AbstractPatternPage<T extends ITemplatePatternBasedSpecification>
extends WizardPage {
  
  /**
   * A listener of page validations.
   */
  public static interface IPageValidatedListener {
    /**
     * Notify that the given page has been validated, resulting in the given error message
     * @param page_p a non-null wizard page
     * @param validationMessage_p the potentially null new validation message of page_p
     */
    void pageValidated(AbstractPatternPage<?> page_p, String validationMessage_p);
    
    /**
     * Notify that the given page has updated its message
     * @param page_p a non-null wizard page
     * @param newMessage_p a potentially null message
     * @param newType_p the message type
     */
    void messageUpdated(AbstractPatternPage<?> page_p, String newMessage_p, int newType_p);
  }
  
  
  /** A non-null default message for the page */
  private final String _defaultMessage;
  
  /** The data under construction */
  private final T _data;
  
  /** Whether the page must be completed before the Next button can be clicked */
  private final boolean _isBlocking;
  
  /** A non-null, potentially empty set of page validation listeners */
  private final Set<IPageValidatedListener> _validationListeners;
  
  /** Utility class instance used to call diagram-related services from the graphical framework (Sirius for example) */
  protected AbstractDiagramUtil _diagramUtil;
  
  /**
   * Constructor
   * @param pageName_p the non-null name of the page
   * @param pageTitle_p the optional title of the page
   * @param defaultMessage_p a non-null message for the page
   * @param data_p the non-null data under construction
   * @param isBlocking_p whether the page must be completed before the Next button can be clicked
   */
  protected AbstractPatternPage(String pageName_p, String pageTitle_p,
      String defaultMessage_p, T data_p, boolean isBlocking_p) {
    super(pageName_p, pageTitle_p, null);
    _diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    _data = data_p;
    _isBlocking = isBlocking_p;
    setPageComplete(!_isBlocking);
    _defaultMessage = defaultMessage_p;
    _validationListeners = new HashSet<IPageValidatedListener>();
  }
  
  /**
   * Create and return a new empty control in the given composite
   * @param parent_p a non-null composite
   * @return a non-null control
   */
  protected Control addEmptyControl(Composite parent_p) {
    return new Label(parent_p, SWT.NONE);
  }
  
  /**
   * Register the given validation listener to this page
   * @param listener_p a non-null object
   */
  public void addValidationListener(IPageValidatedListener listener_p) {
    _validationListeners.add(listener_p);
  }
  
  /**
   * Create and return a new group widget in the given composite with the given title
   * @param parent_p a non-null composite
   * @param title_p a non-null string
   * @param isHorizontalFill_p whether all horizontal space must be grabbed by the group
   * @param columns_p the number of columns within the group
   * @return a non-null group
   */
  protected Group createGroup(Composite parent_p, String title_p, boolean isHorizontalFill_p,
      int columns_p) {
    Group result = new Group(parent_p, SWT.NONE);
    GridData data = new GridData(
        isHorizontalFill_p? SWT.FILL: SWT.NONE, SWT.FILL, isHorizontalFill_p, true);
    result.setLayoutData(data);
    result.setText(title_p);
    Layout layout = new GridLayout(columns_p, false);
    result.setLayout(layout);
    return result;
  }
  
  /**
   * Return a single string obtained by concatenation of the given lines and commas
   * @param lines_p a non-null list of strings
   * @return a non-null, potentially empty string
   */
  protected String getMultiEntryString(Iterable<String> lines_p) {
    StringBuilder builder = new StringBuilder();
    boolean isFirst = true;
    for (String line : lines_p) {
      if (isFirst) isFirst = false; else builder.append(", "); //$NON-NLS-1$
      builder.append(line);
    }
    return builder.toString();
  }
  
  /**
   * @see org.eclipse.jface.wizard.WizardPage#getWizard()
   */
  @Override
  @SuppressWarnings("unchecked")
  public AbstractPatternWizard<T> getWizard() {
    return (AbstractPatternWizard<T>)super.getWizard();
  }
  
  /**
   * Enable or disable the given composite and its children
   * @param composite_p a non-null composite
   * @param enable_p whether or not to enable
   * @param deep_p whether the scope of the operation extends to all children of every depth
   */
  public void enableAll(Composite composite_p, boolean enable_p, boolean deep_p) {
    enableAll(composite_p, enable_p, deep_p, Collections.<Control>emptySet(),
        Collections.<Control>emptySet());
  }
  
  /**
   * Enable or disable the given control and its children if relevant
   * @param control_p a non-null control
   * @param enable_p whether or not to enable
   * @param deep_p whether the scope of the operation extends to all children of every depth
   * @param alwaysEnabled_p a collection of elements to keep enabled
   * @param alwaysDisabled_p a collection of elements to keep disabled
   */
  protected void enableAll(Control control_p, boolean enable_p, boolean deep_p,
      Collection<? extends Control> alwaysEnabled_p,
      Collection<? extends Control> alwaysDisabled_p) {
    if (alwaysEnabled_p.contains(control_p))
      control_p.setEnabled(true);
    else if (alwaysDisabled_p.contains(control_p))
      control_p.setEnabled(false);
    else
      control_p.setEnabled(enable_p);
    if (deep_p && control_p instanceof Composite) {
      for (Control child : ((Composite)control_p).getChildren()) {
        enableAll(child, enable_p, deep_p, alwaysEnabled_p, alwaysDisabled_p);
      }
    }
  }
  
  /**
   * Finish the current row of the given composite with blank space or with the last control
   * @param parent_p a non-null composite
   * @param extendLastControl_p whether the last control should be extended to finish the row
   */
  protected void finishRow(Composite parent_p, boolean extendLastControl_p) {
    int remaining = getRemainingColumns(parent_p);
    if (remaining > 0 || extendLastControl_p) {
      Control[] controls = parent_p.getChildren();
      Control lastControl;
      if (controls.length > 0 && extendLastControl_p)
        lastControl = controls[controls.length-1];
      else
        lastControl = addEmptyControl(parent_p);
      GridData gd;
      if (lastControl.getLayoutData() instanceof GridData) {
        gd = (GridData)lastControl.getLayoutData();
      } else {
        gd = new GridData();
        lastControl.setLayoutData(gd);
      }
      gd.horizontalAlignment = GridData.FILL;
      gd.horizontalSpan = remaining + 1; // +1 for including control
      gd.grabExcessHorizontalSpace = true;
      lastControl.setLayoutData(gd);
    }
  }
  
  /**
   * Return the data under construction
   * @return a non-null object representing the data
   */
  public T getData() {
    return _data;
  }
  
  /**
   * Return the number of remaining columns in the last row of the given composite
   * @param parent_p a non-null composite assumed to have a grid layout
   * @return a positive integer or 0
   */
  protected int getRemainingColumns(Composite parent_p) {
    int result = 0;
    Layout layout = parent_p.getLayout();
    if (layout instanceof GridLayout) {
      int width = ((GridLayout)layout).numColumns;
      int used = 0;
      for (Control child : parent_p.getChildren()) {
        Object data = child.getLayoutData();
        if (data instanceof GridData)
          used += ((GridData)data).horizontalSpan;
        else
          used++;
      }
      result = used % width;
    }
    return result;
  }
  
  /**
   * Return an error message corresponding to the current state of the page
   * @return a potentially null string, where null means page is complete
   */
  protected String getValidationMessage() {
    return null;
  }
  
  /**
   * Return whether the page must be blocked even though no error messages
   * are being issued
   */
  protected boolean blockWithoutErrorMessages() {
    return false;
  }
  
  /**
   * Return a non-null string which is identical to the given string if not null,
   * or otherwise empty
   * @param string_p a potentially null string
   * @return a non-null string
   */
  protected String nonNull(String string_p) {
    return string_p == null? "": string_p; //$NON-NLS-1$
  }
  
  /**
   * Select the content of the given text widget
   * @param text_p a non-null text widget
   */
  protected void selectTextContent(Text text_p) {
    text_p.setFocus();
    text_p.setSelection(0, text_p.getText().length());
  }
  
  /**
   * Set the current default message so that it appears when the page passes validation
   */
  protected final void setDefaultMessage() {
    setMessage(_defaultMessage);
  }
  
  /**
   * @see org.eclipse.jface.wizard.WizardPage#setMessage(java.lang.String, int)
   */
  @Override
  public void setMessage(String newMessage_p, int newType_p) {
    super.setMessage(newMessage_p, newType_p);
    for (IPageValidatedListener listener : _validationListeners) {
      listener.messageUpdated(this, newMessage_p, newType_p);
    }
  }
  
  /**
   * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
   */
  @Override
  public void setVisible(boolean visible_p) {
    super.setVisible(visible_p);
    validate();
  }
  
  /**
   * Update the error messages being displayed according to the current state of the page
   */
  public void validate() {
    String validationMessage = getValidationMessage();
    setErrorMessage(validationMessage);
    if (_isBlocking)
      setPageComplete(validationMessage == null && !blockWithoutErrorMessages());
    try {
      IWizardContainer container = getWizard().getContainer();
      if (container instanceof WizardDialog)
        ((WizardDialog)container).updateButtons();
    } catch (NullPointerException e) {
      // Too early: buttons not created yet - Just give up
    }
    for (IPageValidatedListener listener : _validationListeners) {
      listener.pageValidated(this, validationMessage);
    }
  }
  
  
  /**
   * A custom selection which can be distinguished from selections generated by user interactions
   */
  protected static class NonUserSelection extends StructuredSelection {
    /**
     * Factory method
     * @param element_p a potentially null element
     * @return a non-null instance
     */
    public static NonUserSelection newInstance(Object element_p) {
      return element_p == null? new NonUserSelection(): new NonUserSelection(element_p);
    }
    /**
     * Constructor
     * @param element_p a non-null object
     */
    private NonUserSelection(Object element_p) {
      super(element_p);
    }
    /**
     * Constructor
     */
    private NonUserSelection() {
      super();
    }
  }
  
}
