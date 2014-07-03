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
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateCreationWizard;
import org.eclipse.jface.window.Window;


/**
 * An action for creating a new template.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public abstract class AbstractCreateTemplateAction<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
SemanticRepresentationType, GraphicalNodeType>
extends AbstractPersistentSelectionAction<DiagramElementType, DiagramType> {

  /** Dialog and Wizard factory */
  private IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  SemanticRepresentationType, GraphicalNodeType> _factory = (IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
      SemanticRepresentationType, GraphicalNodeType>)PatternsUIPlugin.getDefault().getDialogAndWizardFactory();


  /**
   * Constructor
   */
  public AbstractCreateTemplateAction() {
    super();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    PatternWizardDialog dialog = new PatternWizardDialog(getShell(),
        instantiateTemplateCreationWizard(selection_p));
    int answer = dialog.open();
    if (Window.OK == answer) {
      if (dialog.isSuccessful()) {
        UIUtil.informSuccess(getShell());
      } else {
        UIUtil.informError(getShell());
      }
    }
  }

  protected AbstractTemplateCreationWizard<ColorType, DiagramElementType, 
  DiagramType, GraphicalContainerType, SemanticRepresentationType, GraphicalNodeType>
  instantiateTemplateCreationWizard(List<Object> selection_p){
    AbstractGenericTypeUtil genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
    if(genericTypeUtil != null && _factory != null){
      return _factory.instantiateTemplateCreationWizard(selection_p, 
          (List<Object>) getFilteredSelection(genericTypeUtil.getGraphicalPartTypeClass()));
    }
    return null;
  }



}
