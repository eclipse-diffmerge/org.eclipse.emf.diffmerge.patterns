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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;


/**
 * A dialog that displays the list of roles of a given pattern.
 * @author O. CONSTANT
 */
public class RoleChoiceDialog extends AbstractTableChoiceDialog<IPatternRole> {
	
	/**
	 * Constructor
	 * @param parentShell_p the shell for this dialog
	 * @param dialogTitle_p the optional dialog title
	 * @param dialogMessage_p the optional dialog message
	 * @param pattern_p the non-null pattern whose roles are to be selected
	 * @param selectionKind_p the kind of selection
	 */
	public RoleChoiceDialog(Shell parentShell_p, String dialogTitle_p, String dialogMessage_p,
			IPattern pattern_p, SelectionKind selectionKind_p) {
		super(parentShell_p, dialogTitle_p,
		    dialogMessage_p != null? dialogMessage_p: Messages.RoleChoiceDialog_Prompt,
		    pattern_p.getRoles(), selectionKind_p);
	}
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#getColumnContentsFor(java.lang.Object)
   */
  @Override
  protected String getColumnText(IPatternRole role_p, int columnIndex_p) {
    return role_p.getName();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#getColumnHeaders()
   */
  @Override
  protected List<String> getColumnHeaders() {
    return Arrays.asList(Messages.RoleChoiceDialog_Role);
  }
  
}
