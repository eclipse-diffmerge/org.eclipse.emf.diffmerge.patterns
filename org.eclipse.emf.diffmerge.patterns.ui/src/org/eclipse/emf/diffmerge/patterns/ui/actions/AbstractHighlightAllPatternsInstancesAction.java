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
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractHighlightAllPatternsInstancesPanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;

/**
 * An action that opens a dialog box that highlights all patterns instances in the current diagram
 * @author S. TURKI
 * @author Skander TURKI
 */
public abstract class AbstractHighlightAllPatternsInstancesAction<DiagramElementType, DiagramType, GraphicalContainerType> 
extends AbstractModelBasedAction<DiagramElementType, DiagramType> {

  protected DiagramType _diagram;
  
  /** Dialog and Wizard factory */
  private IPatternDialogAndWizardFactory<DiagramElementType, DiagramType, GraphicalContainerType> 
    _factory = (IPatternDialogAndWizardFactory<DiagramElementType, DiagramType, GraphicalContainerType>)
        PatternsUIPlugin.getDefault().getDialogAndWizardFactory();
  
  /**
   * Runs the action by opening the dialog box that is used to highlight all patterns instances in the current diagram {@inheritDoc}
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    if (!selection_p.isEmpty() && selection_p.get(0) instanceof EObject) {
      _diagram = getDiagramFromSelection(getSelection());
      Set<IPatternInstance> instances = getPresentInstances(_diagram, (EObject)selection_p.get(0), getShell());
      if (instances != null) {
        if (instances.isEmpty()) {
          MessageDialog.openInformation(getShell(), CorePatternsPlugin.getDefault().getLabel(),
              Messages.HighlightAllPatternsInstancesAction_NoElementInInstance);
        } else {
          Object context = selection_p.get(0);
          EditingDomain domain = null;
          if(context instanceof IFile){
            domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((IFile)context);
          }else if(context instanceof EObject){
            domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((EObject)context);
          }
          if (domain != null) {
            AbstractHighlightAllPatternsInstancesPanelDialog dialog = instantiateHighlightAllPatternsInstancesPanelDialog(instances, selection_p);   
            dialog.open();
          }
        }
      }
    }
  }
  
  /**
   * Returns present instances in diagram
   * @return
   */
  protected abstract Set<IPatternInstance> getPresentInstances(DiagramType context_p, EObject element_p, Shell shell_p);
  
  /**
   * Returns current diagram from selection
   * @return
   */
  protected abstract DiagramType getDiagramFromSelection(IStructuredSelection selection_p);
  
 /**
  *  
  * @param instances_p
  * @param selection_p
  * @return
  */
  protected AbstractHighlightAllPatternsInstancesPanelDialog 
  instantiateHighlightAllPatternsInstancesPanelDialog(Set<IPatternInstance> instances_p, List<Object> selection_p) {
   return _factory.instantiateHighlightAllPatternsInstancesPanelDialog(instances_p, 
       selection_p, _diagram, getShell(), Messages.HighlightAllPatternsInstances_DialogTitle,
       Messages.HighlightAllPatternsInstances_DialogMessage);
  }
  
 }
