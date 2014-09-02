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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;


/**
 * A dialog that displays a list of reference locations and allows the user to select one
 * of them.
 * @author Olivier Constant
 */
public class ContainmentChoiceDialog extends AbstractTableChoiceDialog<IReferenceLocation> {
	
  /** The reference to select initially */
  private final IReferenceLocation _defaultSelection;
  
	/**
	 * Constructor
	 * @param parentShell_p the shell for this dialog
	 * @param dialogTitle_p the optional dialog title
	 * @param dialogMessage_p the dialog message
	 * @param elements_p the set of elements to choose from
	 * @param defaultSelection the optional element to select initially
	 * Precondition: elements_p.contains(defaultSelection)
	 */
	public ContainmentChoiceDialog(Shell parentShell_p, String dialogTitle_p,
	    String dialogMessage_p, Collection<? extends IReferenceLocation> elements_p,
	    IReferenceLocation defaultSelection) {
	  super(parentShell_p, dialogTitle_p, dialogMessage_p, elements_p, SelectionKind.SINGLE);
	  _defaultSelection = defaultSelection;
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
	 */
  @Override
  protected Control createCustomArea(Composite parent_p) {
    Control result = super.createCustomArea(parent_p);
    if (_defaultSelection != null)
      _viewer.setSelection(new StructuredSelection(_defaultSelection));
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#getColumnContentsFor(java.lang.Object)
   */
  @Override
  protected String getColumnText(IReferenceLocation element_p, int columnIndex_p) {
    switch(columnIndex_p) {
      case 0: return element_p.getReference().getName();
      default: return ""; //$NON-NLS-1$
    }
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#getColumnHeaders()
   */
  @Override
  protected List<String> getColumnHeaders() {
    return Arrays.asList(Messages.ContainmentChoiceDialog_Containment);
  }
  
}
