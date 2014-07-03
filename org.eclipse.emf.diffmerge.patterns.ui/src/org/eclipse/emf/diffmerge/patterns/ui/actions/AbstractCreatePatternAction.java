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

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.creation.AbstractPatternCreationWizard;
import org.eclipse.jface.window.Window;



/**
 * An action for creating a new pattern.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public abstract class AbstractCreatePatternAction<DiagramElementType> 
extends AbstractPersistentSelectionAction<DiagramElementType> {


  /** Dialog and Wizard factory */
  private IPatternDialogAndWizardFactory<DiagramElementType> 
    _factory = (IPatternDialogAndWizardFactory<DiagramElementType>)
      PatternsUIPlugin.getDefault().getDialogAndWizardFactory();



  /**
   * Constructor
   */
  public AbstractCreatePatternAction() {
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
   * @return
   */
  protected PatternWizardDialog instantiatePatternWizardDialog(List<Object> selection_p){
    AbstractGenericTypeUtil genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
    if(genericTypeUtil != null && _factory != null){
      TemplatePatternCreationSpecification patternCreationSpecification = 
          TemplatePatternsEnginePlugin.getDefault().newPatternCreationData(false, selection_p, 
              PatternsUIPlugin.getDefault().getModelEnvironmentUI().getEnvironments());

      AbstractPatternCreationWizard<DiagramElementType> wizard 
          = _factory.instantiatePatternCreationWizard(selection_p, 
              (List<Object>) getFilteredSelection(genericTypeUtil.getGraphicalPartTypeClass()),
                patternCreationSpecification, false);
      return _factory.instantiatePatternWizardDialog(getShell(), wizard);
    }
    return null;
  }

}
