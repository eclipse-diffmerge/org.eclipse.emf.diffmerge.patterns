/*********************************************************************
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.delete;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.Messages;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;


/**
 * A delete action that is specific to UMLDesigner and to the implementation 
 * of patterns and pattern instances that is specified by the current UMLDesignerModelEnvironment.
 * @author Skander Turki
 */
public class UMLDesignerDeleteAction extends DeleteAction{
  
  /** The non-null editing domain */
  private EditingDomain _editingDomain;
  
  /**
   * Constructor.
   * @param editingDomain_p a non-null editing domain
   */
  public UMLDesignerDeleteAction(EditingDomain editingDomain_p) {
    super(editingDomain_p, true);
    _editingDomain = editingDomain_p;
  }
  
  /**
   * @see org.eclipse.emf.edit.ui.action.DeleteAction#createCommand(java.util.Collection)
   */
  @Override
  public Command createCommand(Collection<?> selection_p) {
    return new UMLDesignerDeleteCommand(_editingDomain, selection_p);
  }
  
  /**
   * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#run()
   */
  @Override
  public void run() {
    // Get it into a runnable.
    IRunnableWithProgress runnable = new IRunnableWithProgress() {
      /**
       * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
       */
      @SuppressWarnings("synthetic-access")
      public void run(IProgressMonitor monitor_p) throws InvocationTargetException, InterruptedException {
        monitor_p.beginTask(Messages.UMLDesignerDeleteCommand_Label, IProgressMonitor.UNKNOWN);
        command.execute();
      }
    };
    try {
      new ProgressMonitorDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell()).run(false, false, runnable);
    } catch (Exception exception_p) {
      // Harsh times.
      throw new RuntimeException(exception_p);
    }
  }
  
}
