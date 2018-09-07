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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * A partial implementation of AbstractHandler.
 * @author Skander Turki
 */
public abstract class AbstractWorkbenchSelectionHandler  extends AbstractHandler{

  /**
   * 
   * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  public Object execute(ExecutionEvent event_p) throws ExecutionException {
    IWorkbenchPart activePart = null;
    IWorkbench workbench = PlatformUI.getWorkbench();
    if(workbench != null){
      IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
      if(window != null){
        IWorkbenchPage page = window.getActivePage();
        if(page != null){
          activePart = page.getActivePart();
          if (activePart != null){
            //Action called from a diagram
            IWorkbenchPartSite site = activePart.getSite();
            if(site != null){
              ISelectionProvider provider = site.getSelectionProvider();
              if(provider != null){
                handleSelection(provider.getSelection(), activePart);
              }
            }
          }else{
            //Aciton called from the model explorer
            IWorkbenchPartReference ref = page.getActivePartReference();
            if(ref instanceof IViewReference){
              IViewPart part = ((IViewReference)ref).getView(true);
              if(part != null){
                IWorkbenchPartSite site = part.getViewSite();
                if(site != null){
                  ISelectionProvider provider = site.getSelectionProvider();
                  if(provider != null){
                    handleSelection(provider.getSelection(), activePart);
                  }
                }
              }  
            }
          }
        }
      }
    }  
    return null;
  }

  /**
   * Returns the active workbench window
   */
  protected IWorkbenchWindow getWorkbenchWindow() {
    IWorkbench workbench = PlatformUI.getWorkbench();
    if(workbench != null){
      return workbench.getActiveWorkbenchWindow();
    }
    return null;
  }

  /**
   * Handle selection from the active workbench part
   * @param selection_p a potentially null selection
   * @param activePart_p a potentially null part
   */
  protected abstract Object handleSelection(ISelection selection_p, IWorkbenchPart activePart_p);

}
