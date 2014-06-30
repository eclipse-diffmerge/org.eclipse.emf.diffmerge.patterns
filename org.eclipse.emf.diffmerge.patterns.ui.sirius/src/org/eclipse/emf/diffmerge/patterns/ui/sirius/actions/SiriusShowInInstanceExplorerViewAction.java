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

import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractShowInInstanceExplorerViewAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.views.SiriusInstanceExplorerView;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;

/**
 * A Sirius-specific action for displaying the Pattern Instance Explorer.
 * @author Skander TURKI
 */
public class SiriusShowInInstanceExplorerViewAction 
  extends AbstractShowInInstanceExplorerViewAction<DDiagramElement, DDiagram, 
    SiriusInstanceExplorerView, IGraphicalEditPart>{

  /**
   * 
   * @return
   */
  @Override
  protected String getID(){
    return SiriusInstanceExplorerView.getID();
  }
  
}
