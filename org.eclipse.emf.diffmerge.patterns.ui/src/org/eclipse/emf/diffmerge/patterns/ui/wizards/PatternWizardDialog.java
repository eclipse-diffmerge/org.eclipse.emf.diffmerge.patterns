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
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;


/**
 * A wizard dialog shaped for handling template patterns and their contents/bindings.
 * @author Olivier Constant
 */
public class PatternWizardDialog extends WizardDialog {
  
  /** Whether the Cancel button must be disabled */
  private final boolean _disableCancel;
  
  /**
   * Constructor
   * @param shell_p a non-null shell
   * @param selection_p the initial selection of elements to use as template elements
   */
  public PatternWizardDialog(Shell shell_p, AbstractPatternWizard<?> wizard_p) {
    this(shell_p, wizard_p, false, null);
  }
  
  /**
   * Constructor
   * @param shell_p a non-null shell
   * @param selection_p the initial selection of elements to use as template elements
   * @param hideCancel_p whether the Cancel button must be disabled
   * @param location_p an optional absolute position for the dialog
   */
  public PatternWizardDialog(Shell shell_p, AbstractPatternWizard<?> wizard_p,
      boolean hideCancel_p, Point location_p) {
    super(shell_p, wizard_p);
    _disableCancel = hideCancel_p;
    setHelpAvailable(false);
    setPageSize(700, SWT.DEFAULT);
    create();
    if (location_p != null)
      getShell().setLocation(location_p);
  }
  
  /**
   * Return whether the wizard completed successfully
   */
  public boolean isSuccessful() {
    return ((AbstractPatternWizard<?>)getWizard()).isSuccessful();
  }
  
  /**
   * @see org.eclipse.jface.wizard.WizardDialog#createContents(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createContents(Composite parent_p) {
    Control result = super.createContents(parent_p);
    if (_disableCancel) {
      Button cancelButton = getButton(IDialogConstants.CANCEL_ID);
      if (cancelButton != null)
        cancelButton.setEnabled(false);
    }

    return result;
  }
  
}
