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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.InstancePanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;


/**
 * An action which opens the dialog for managing pattern instances.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public abstract class AbstractManageInstanceAction<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
SemanticRepresentationType, GraphicalNodeType>
extends AbstractModelBasedAction<DiagramElementType, DiagramType> {

  /** Dialog and Wizard factory */
  private IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  SemanticRepresentationType, GraphicalNodeType> _factory = (IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
      SemanticRepresentationType, GraphicalNodeType>)PatternsUIPlugin.getDefault().getDialogAndWizardFactory();


  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractContextualAction#coreRun(java.util.List)
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    if (!selection_p.isEmpty()) {
      Object element = selection_p.get(0);
      if(element instanceof EObject){
        EObject casted = (EObject)element;
        IPatternSupport support = CorePatternsPlugin.getDefault().getPatternSupportFor(casted);
        if (support == null) {
          informNoPatternSupport();
        } else {
          List<IPatternInstance> instances = Collections.emptyList();
          Iterator<Object> it = selection_p.iterator();
          while (instances.isEmpty() && it.hasNext()) {
            Object obj = it.next();
            if(obj instanceof EObject){
              instances = support.getRelatedInstances((EObject)obj);
            }
          }
          if (instances.isEmpty()) {
            MessageDialog.openInformation(getShell(), CorePatternsPlugin.getDefault().getLabel(),
                Messages.ManageInstanceAction_NotInInstance);
          } else {
            InstancePanelDialog<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
            SemanticRepresentationType, GraphicalNodeType> dialog = 
                instantiateInstancePanelDialog(instances, casted);
            if(dialog != null){
              dialog.open();
            }
          }
        }
        
      }
     
    }
  }



  /**
   * Instantiates an instance panel dialog that is specific to the modeling environment
   */
  protected InstancePanelDialog<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  SemanticRepresentationType, GraphicalNodeType>
  instantiateInstancePanelDialog(List<IPatternInstance> instances_p, EObject context_p){
    AbstractDiagramUtil<DiagramElementType, DiagramType> diagramUtil = (AbstractDiagramUtil<DiagramElementType, DiagramType>) PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    AbstractGenericTypeUtil genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
    if(diagramUtil != null && genericTypeUtil != null){
      return _factory.instantiateInstancePanelDialog(instances_p, context_p, diagramUtil.getDiagramFromSelection(getSelection()), 
          (List<Object>)getFilteredSelection(genericTypeUtil.getGraphicalPartTypeClass()) , getShell());
    }
    return null;
  }

}
