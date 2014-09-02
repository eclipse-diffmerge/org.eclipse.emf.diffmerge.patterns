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

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;

/**
 * A dialog that is used to highlight pattern instances in the current diagram
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractHighlightAllPatternsInstancesPanelDialog extends AbstractTableChoiceDialog<IPatternInstance>{

  /** Contains all pattern instances that are selected */
  protected Collection<? extends IPatternInstance> _selectedInstances;
  
  /**
   * Constructor
   * @param parentShell_p
   * @param instances_p
   */
  public AbstractHighlightAllPatternsInstancesPanelDialog(
      Shell parentShell_p,
      Collection<? extends IPatternInstance> instances_p) {
    super(parentShell_p, Messages.HighlightAllPatternsInstances_DialogTitle, Messages.HighlightAllPatternsInstances_DialogMessage, MessageDialog.QUESTION,
        instances_p, SelectionKind.MULTI, false);
    _selectedInstances = instances_p;
  }

}
