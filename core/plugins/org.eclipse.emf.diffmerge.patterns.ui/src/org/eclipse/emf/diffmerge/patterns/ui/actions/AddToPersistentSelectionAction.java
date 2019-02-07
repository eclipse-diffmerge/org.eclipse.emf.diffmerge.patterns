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
import org.eclipse.emf.diffmerge.patterns.ui.providers.IncludedElementsProvider;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.ISourceProviderService;


/**
 * An action for adding elements to the persistent selection
 * @author Olivier Constant
 * @author Skander Turki
 */
public class AddToPersistentSelectionAction extends AbstractModelBasedAction {
  
	/**
	 * Constructor
	 */
	public AddToPersistentSelectionAction() {
	  super();
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
	 */
	@Override
	protected void coreRun(List<Object> selection_p) {
	  PatternsUIPlugin.getDefault().getPersistentSelection().addElements(selection_p);
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
	
}
