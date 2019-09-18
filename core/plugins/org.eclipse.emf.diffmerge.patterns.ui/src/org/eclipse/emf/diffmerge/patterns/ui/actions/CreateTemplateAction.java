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

import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.TemplateCreationWizard;
import org.eclipse.jface.window.Window;


/**
 * An action for creating a new template.
 * @author Olivier Constant
 * @author Skander Turki
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
  @SuppressWarnings("unchecked")
  protected void coreRun(List<Object> selection_p) {
    PatternWizardDialog dialog = new PatternWizardDialog(getShell(),
        new TemplateCreationWizard(
            selection_p,
            (List<Object>)getFilteredSelection(_genericTypeUtil.getGraphicalPartTypeClass())));
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
