/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.AbstractInstanceExplorerView;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * An action for displaying the Pattern Instance Explorer.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class ShowInInstanceExplorerViewAction extends AbstractModelBasedAction {

  /**
   * Constructor
   */
  public ShowInInstanceExplorerViewAction() {
    super();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    IWorkbenchPart part = getPart();
    if (part != null && part.getSite() != null) {
      IWorkbenchPage page = part.getSite().getPage();
      try {
        IViewPart vPart = page.showView(getID());
        if (vPart instanceof AbstractInstanceExplorerView) {
          ((AbstractInstanceExplorerView)vPart).setInput(
              new StructuredSelection(selection_p));
        }
      } catch (PartInitException e) {
        // Do nothing
      }
    }
  }

  /**
   * Return the view ID
   * @return a String
   */
  protected String getID(){
    IUIExtender uiExtender = PatternsUIPlugin.getDefault().getSemanticUIUtil();
    return uiExtender.getInstanceExplorerViewID();
  }


}
