/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractHighlightAllPatternsInstancesPanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.util.PatternsInstancesUIUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;

/**
 * An action that opens a dialog box that highlights all patterns instances in the current diagram
 * @author Skander Turki
 */
public class HighlightAllPatternsInstancesAction extends AbstractModelBasedAction {
  
  /** A potentially null diagram */
  protected Object _diagram;
 
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
   */
  protected Set<IPatternInstance> getPresentInstances(Object graphicalContext_p, EObject element_p, Shell shell_p) {
      Set<IPatternInstance> instances = new HashSet<IPatternInstance>();
      IPatternSupport support = null;
      if( _genericTypeUtil.isInstanceOfDiagramType(graphicalContext_p)){
        if (element_p != null) {
          support = CorePatternsPlugin.getDefault().getPatternSupportFor(element_p);
        }
        if (support == null) {
          PatternsInstancesUIUtil.informNoPatternSupport(shell_p);
        } else if (_genericTypeUtil.isInstanceOfSemanticRepresentationType(graphicalContext_p)) {
            instances.addAll(getIncludedPatternInstances(support, graphicalContext_p));
          }
      }
      return instances;
    }

    
    /**
     * Returns pattern instances included in the semantic decorator
     * @param support_p a non-null IPatternSupport
     * @param semanticDecorator_p a non-null DSemanticDecorator
     * @return a non-null HashSet of IPatternInstance objects
     */
      private Set<IPatternInstance> getIncludedPatternInstances(IPatternSupport support_p,
          Object semanticDecorator_p) {
        Set<IPatternInstance> res = new HashSet<IPatternInstance>();
        List<IPatternInstance> currentElementInstances = support_p.getRelatedInstances(_diagramUtil.getSemanticRepresentationTypeTarget(semanticDecorator_p));
        if (!currentElementInstances.isEmpty()) {
          res.addAll(currentElementInstances);
        }
        if (_genericTypeUtil.isInstanceOfDiagramType(semanticDecorator_p)) {
          for (Object part : _diagramUtil.getDiagramElements(semanticDecorator_p)) {
            res.addAll(getIncludedPatternInstances(support_p, part));
          }
        } else if (_genericTypeUtil.isInstanceOfGraphicalNodeContainerType(semanticDecorator_p)) {
          for (Object part : _diagramUtil.getOwnedDiagramElements(semanticDecorator_p)) {
            if (_genericTypeUtil.isInstanceOfSemanticRepresentationType(part)) {
              res.addAll(getIncludedPatternInstances(support_p, part));
            }
          }
        }
        return res;
      } 

  
  
  /**
   * Return the current diagram from the given selection
   * @param selection_p a potentially null selection
   * @return a potentially null object
   */
  protected Object getDiagramFromSelection(IStructuredSelection selection_p) {
      return _diagramUtil.getDiagramFromSelection(selection_p);
  }
  
 /**
  *  Return a dialog for the "highlight all instances" command
  * @param instances_p a non-null set of pattern instances
  * @param selection_p a potentially null selection
  * @return a potentially null object
  */
  protected AbstractHighlightAllPatternsInstancesPanelDialog 
  instantiateHighlightAllPatternsInstancesPanelDialog(Set<IPatternInstance> instances_p, List<Object> selection_p) {
   return _dialogAndWizardFactory.instantiateHighlightAllPatternsInstancesPanelDialog(instances_p, 
       selection_p, _diagram, getShell(), Messages.HighlightAllPatternsInstances_DialogTitle,
       Messages.HighlightAllPatternsInstances_DialogMessage);
  }
  
 }
