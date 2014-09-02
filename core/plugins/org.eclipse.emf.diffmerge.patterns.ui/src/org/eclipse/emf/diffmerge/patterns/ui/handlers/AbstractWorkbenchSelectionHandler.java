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
          activePart = page.getActiveEditor();
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
   * Handles selection from active workbench part.
   * @param selection_p
   * @param activePart_p
   */
  protected abstract Object handleSelection(ISelection selection_p, IWorkbenchPart activePart_p);

}
