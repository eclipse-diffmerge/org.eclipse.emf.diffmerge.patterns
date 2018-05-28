/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.handlers;

import org.eclipse.emf.diffmerge.patterns.ui.actions.BrowseCatalogAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;


/**
 * The handler for the "browse catalogs" command.
 * @author Skander Turki
 */
public class BrowseCatalogHandler extends AbstractWorkbenchSelectionHandler {

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
          BrowseCatalogAction action = new BrowseCatalogAction();
          action.setActivePart(null, part);
          action.selectionChanged(null, selection_p);
          action.run(null);
        }
      }
    }
    return null;
  }

}
