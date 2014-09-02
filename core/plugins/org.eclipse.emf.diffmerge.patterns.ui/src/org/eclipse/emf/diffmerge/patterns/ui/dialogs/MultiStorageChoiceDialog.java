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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


/**
 * An extension of {@link StorageChoiceDialog} with additional controls for
 * specifying the storage of multiple elements.
 * @author Olivier Constant
 */
public class MultiStorageChoiceDialog extends StorageChoiceDialog {
	
  /**
   * Kinds of storage in the context of multiple elements
   */
  public static enum MultiStorageKind {
    CURRENT_ONLY, ALL_SIMILAR, ALL_COMPATIBLE
  }
  
  /** The storage kind lastly used */
  protected static MultiStorageKind __lastStorageKind = MultiStorageKind.ALL_SIMILAR;
  
  /** The selected storage kind */
  private MultiStorageKind _storageKind;
  
  
  /**
   * Constructor.
   * @param parentShell_p the non-null shell for this dialog
   * @param message_p an optional prompt message to display (default if null)
   * @param proposed_p the non-null set of proposed containers
   * @param target_p the non-null element whose storage is looked for
   */
  public MultiStorageChoiceDialog(Shell parentShell_p, String message_p,
      List<? extends EObject> proposed_p, EObject target_p) {
     super(parentShell_p, message_p, proposed_p, Collections.singletonList(target_p));
     _storageKind = __lastStorageKind;
  }
  
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
	 */
  @Override
  protected Control createCustomArea(Composite parent_p) {
    Control result = super.createCustomArea(parent_p);
    // Group
    Group applyGroup = new Group(parent_p, SWT.NONE);
    GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
    applyGroup.setLayoutData(gd);
    GridLayout layout = new GridLayout(4, false);
    applyGroup.setLayout(layout);
    new Label(applyGroup, SWT.NONE).setText(Messages.MultiStorageChoiceDialog_Target);
    // Button: current element
    Button elementButton = new Button(applyGroup, SWT.RADIO);
    elementButton.setText(Messages.MultiStorageChoiceDialog_Current);
    elementButton.setSelection(_storageKind == MultiStorageKind.CURRENT_ONLY);
    elementButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        setStorageKind(MultiStorageKind.CURRENT_ONLY);
      }
    });
    // Button: similar elements
    Button similarButton = new Button(applyGroup, SWT.RADIO);
    similarButton.setText(Messages.MultiStorageChoiceDialog_Similar);
    similarButton.setSelection(_storageKind == MultiStorageKind.ALL_SIMILAR);
    similarButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        setStorageKind(MultiStorageKind.ALL_SIMILAR);
      }
    });
    // Button: compatible elements
    Button compatibleButton = new Button(applyGroup, SWT.RADIO);
    compatibleButton.setText(Messages.MultiStorageChoiceDialog_Compatible);
    compatibleButton.setSelection(_storageKind == MultiStorageKind.ALL_COMPATIBLE);
    compatibleButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        setStorageKind(MultiStorageKind.ALL_COMPATIBLE);
      }
    });
    return result;
  }
  
  /**
   * Return the storage kind selected by the user
   * @return a non-null storage kind
   */
  public MultiStorageKind getStorageKind() {
    return _storageKind;
  }
  
  /**
   * @see org.eclipse.jface.window.Window#open()
   */
  @Override
  public int open() {
    int result = super.open();
    if (Window.OK == result)
      __lastStorageKind = getStorageKind();
    return result;
  }
  
  /**
   * Set the storage kind of this dialog
   * @param kind_p a non-null storage kind
   */
  protected void setStorageKind(MultiStorageKind kind_p) {
    _storageKind = kind_p;
  }
  
}
