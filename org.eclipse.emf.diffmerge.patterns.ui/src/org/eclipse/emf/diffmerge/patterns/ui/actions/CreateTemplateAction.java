/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.TemplateCreationWizard;
import org.eclipse.jface.window.Window;


/**
 * An action for creating a new template.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class CreateTemplateAction extends AbstractPersistentSelectionAction {

  /**
   * Constructor
   */
  public CreateTemplateAction() {
    super();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    PatternWizardDialog dialog = new PatternWizardDialog(getShell(),
        new TemplateCreationWizard(selection_p,(List<Object>) getFilteredSelection(_genericTypeUtil.getGraphicalPartTypeClass())));
    int answer = dialog.open();
    if (Window.OK == answer) {
      if (dialog.isSuccessful()) {
        UIUtil.informSuccess(getShell());
      } else {
        UIUtil.informError(getShell());
      }
    }
  }


}
