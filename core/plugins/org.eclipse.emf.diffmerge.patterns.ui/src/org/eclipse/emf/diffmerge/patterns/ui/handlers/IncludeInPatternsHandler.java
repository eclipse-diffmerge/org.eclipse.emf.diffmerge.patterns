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
package org.eclipse.emf.diffmerge.patterns.ui.handlers;

import org.eclipse.emf.diffmerge.patterns.ui.actions.AddToPersistentSelectionAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;


/**
 * The handler for the "include in patterns" command.
 * @author Skander Turki
 */
public class IncludeInPatternsHandler extends AbstractWorkbenchSelectionHandler {

  /**
   * @see AbstractWorkbenchSelectionHandler#handleSelection(ISelection, IWorkbenchPart)
   */
  @Override
  protected Object handleSelection(ISelection selection_p, IWorkbenchPart activePart_p) {
    IWorkbenchWindow window = getWorkbenchWindow();
    if (window != null) {
      IWorkbenchPage page = window.getActivePage();
      if (page != null) {
        IWorkbenchPart part = page.getActivePart();
        if (part != null) {
          AddToPersistentSelectionAction action =  new AddToPersistentSelectionAction();
          action.setActivePart(null, part);
          action.selectionChanged(null, selection_p);
          action.run(null);
        }
      }
    }
    return null;
  }

}
