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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.actions;

import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractHighlightAllPatternsInstancesAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.util.SiriusPatternsInstancesUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.swt.widgets.Shell;

/**
 * A Sirius-specific action for highlighting all pattern instances in a diagram. 
 * @author Skander TURKI
 */
public class SiriusHighlightAllPatternsInstancesAction 
extends AbstractHighlightAllPatternsInstancesAction<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
DSemanticDecorator, AbstractDNode>{

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractHighlightAllPatternsInstancesAction#getPresentInstances(java.lang.Object, org.eclipse.emf.ecore.EObject, org.eclipse.swt.widgets.Shell)
   */
  @Override
  protected Set<IPatternInstance> getPresentInstances(DDiagram context_p,
      EObject element_p, Shell shell_p) {
    return SiriusPatternsInstancesUtil.getPresentInstances(context_p, element_p, shell_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractHighlightAllPatternsInstancesAction#getDiagramFromSelection(org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  protected DDiagram getDiagramFromSelection(IStructuredSelection selection_p) {
    AbstractDiagramUtil<DDiagramElement, DDiagram, IGraphicalEditPart> diagramUtil = (AbstractDiagramUtil<DDiagramElement, DDiagram, IGraphicalEditPart>) PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    if(diagramUtil != null){
      return diagramUtil.getDiagramFromSelection(selection_p);
    }
    return null;
  }

}
