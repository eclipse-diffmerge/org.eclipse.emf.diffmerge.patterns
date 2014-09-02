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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.providers.IncludedElementsProvider;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.ISourceProviderService;


/**
 * An action for clearing the persistent selection
 * @author Olivier Constant
 * @author Skander Turki
 */
public class ResetPersistentSelectionAction extends AbstractModelBasedAction {

	/**
	 * Constructor
	 */
	public ResetPersistentSelectionAction() {
	  super();
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
	 */
	@Override
	protected void coreRun(List<Object> selection_p) {
	  PatternsUIPlugin.getDefault().getPersistentSelection().reset();
	  ISourceProviderService sourceProviderService =
      (ISourceProviderService) PlatformUI.getWorkbench().getService(
          ISourceProviderService.class);
    ISourceProvider source = sourceProviderService.getSourceProvider(IncludedElementsProvider.INCLUDED_ELEMENTS_STATE);
    if (source instanceof IncludedElementsProvider) {
      if(!PatternsUIPlugin.getDefault().getPersistentSelection().isEmpty()){
        ((IncludedElementsProvider) source).setVisibility(false);
      }else{
        ((IncludedElementsProvider) source).setVisibility(true);
      }
      
    }
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#mustBeEnabled()
	 */
	@Override
  protected boolean mustBeEnabled() {
    return !PatternsUIPlugin.getDefault().getPersistentSelection().isEmpty();
  }

  
}
