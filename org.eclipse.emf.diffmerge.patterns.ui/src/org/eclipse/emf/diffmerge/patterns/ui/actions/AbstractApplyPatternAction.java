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

import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;


/**
 * An action for applying an existing pattern in a model.
 * It must be sub-classed for the designer
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public abstract class AbstractApplyPatternAction<ColorType, DiagramElementType, 
DiagramType, GraphicalContainerType, SemanticRepresentationType, GraphicalNodeType>
extends AbstractModelBasedAction<DiagramElementType, DiagramType> {
  
	/**
	 * Constructor
	 */
	public AbstractApplyPatternAction() {
	  super();
	}
	
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
	 */
	@Override
	protected void coreRun(List<Object> selection_p) {
	  PatternWizardDialog wizardDialog = new PatternWizardDialog(
	      getShell(), instantiatePatternApplicationWizard(selection_p));
	  int wizardAnswer = wizardDialog.open();
	  if (Window.OK == wizardAnswer) {
	    if (wizardDialog.isSuccessful()) {
	      UIUtil.informSuccess(getShell());
	    } else {
	      UIUtil.informError(getShell());
	    }
	  }
	}
	
	/**
	 * Returns a AbstractPatternApplicationWizard that is specific to the designer
	 * @return a non-null AbstractPatternApplicationWizard
	 */
	protected AbstractPatternApplicationWizard<ColorType, DiagramElementType, 
	DiagramType, GraphicalContainerType, SemanticRepresentationType, GraphicalNodeType>
	instantiatePatternApplicationWizard(List<Object> selection_p){
	  AbstractDiagramUtil<DiagramElementType, DiagramType> diagramUtil = (AbstractDiagramUtil<DiagramElementType, DiagramType>) PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
	  IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
	  SemanticRepresentationType, GraphicalNodeType> _factory = (IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
	      SemanticRepresentationType, GraphicalNodeType>)PatternsUIPlugin.getDefault().getDialogAndWizardFactory();
	  if(diagramUtil != null && _factory != null){
      return _factory.instantiatePatternApplicationWizard(selection_p, diagramUtil.getDiagramFromSelection(getSelection()));
    }
	  return null;
	}
	
}
