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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.PatternApplicationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
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
	  IStructuredSelection selection = getSelection();
	  PatternWizardDialog wizardDialog = new PatternWizardDialog(
	      getShell(), new PatternApplicationWizard(selection_p,
	          _diagramUtil.getDiagramFromSelection(selection_p == null? null: selection.toList())));
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
