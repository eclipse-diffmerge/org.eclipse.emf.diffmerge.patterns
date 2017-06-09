/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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

import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.PatternApplicationWizard;
import org.eclipse.jface.window.Window;


/**
 * An action for applying an existing pattern in a model.
 * It must be sub-classed for the designer
 * @author Olivier Constant
 * @author Skander Turki
 */
public class ApplyPatternAction extends AbstractModelBasedAction {
  
	/**
	 * Constructor
	 */
	public ApplyPatternAction() {
	  super();
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
	 */
	@Override
	protected void coreRun(List<Object> selection_p) {
	  PatternWizardDialog wizardDialog = new PatternWizardDialog(
	      getShell(), new PatternApplicationWizard(selection_p, _diagramUtil.getDiagramFromSelection(getSelection())));
	  int wizardAnswer = wizardDialog.open();
	  if (Window.OK == wizardAnswer) {
	    if (wizardDialog.isSuccessful()) {
	      UIUtil.informSuccess(getShell());
	    } else {
	      UIUtil.informError(getShell());
	    }
	  }
	}
	
	
}
