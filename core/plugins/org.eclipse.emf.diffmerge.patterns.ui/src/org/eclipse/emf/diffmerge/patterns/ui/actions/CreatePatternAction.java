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

import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.creation.PatternCreationWizard;
import org.eclipse.jface.window.Window;


/**
 * An action for creating a new pattern.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class CreatePatternAction extends AbstractPersistentSelectionAction {
  
  /**
   * Constructor
   */
  public CreatePatternAction() {
    super();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    PatternWizardDialog dialog = instantiatePatternWizardDialog(selection_p);
    if(dialog != null){
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
  
  /**
   * Instantiates a PatternWizardDialog
   * @return a potentially null object
   */
  protected PatternWizardDialog instantiatePatternWizardDialog(List<Object> selection_p){
    if(_genericTypeUtil != null && _dialogAndWizardFactory != null){
      TemplatePatternCreationSpecification patternCreationSpecification = 
          TemplatePatternsEnginePlugin.getDefault().newPatternCreationData(false, selection_p, 
              PatternsUIPlugin.getDefault().getModelEnvironmentUI().getEnvironments());
      @SuppressWarnings("unchecked")
      PatternCreationWizard wizard = new PatternCreationWizard(selection_p, 
          (List<Object>) getFilteredSelection(_genericTypeUtil.getGraphicalPartTypeClass()),
          patternCreationSpecification, false);
      return new PatternWizardDialog(getShell(), wizard);
    }
    return null;
  }
  
}
