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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.dialogs;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.InstancePanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.views.SiriusInstanceExplorerView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.swt.widgets.Shell;

/**
 * A Sirius-specific dialog that displays a list of pattern instances 
 * and allows the user to select one and perform actions on it.
 * @author Olivier Constant
 * @author Skander TURKI
 */
public class SiriusInstancePanelDialog 
extends InstancePanelDialog<DDiagramElement, DDiagram, DContainer>{

  /**
   * Constructor
   */
  public SiriusInstancePanelDialog(Shell parentShell_p,
      EObject referenceElement_p, List<? extends IPatternInstance> instances_p,
      DDiagram diagram_p, List<Object> graphicalContext_p) {
    super(parentShell_p, referenceElement_p, instances_p, diagram_p,
        graphicalContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.InstancePanelDialog#getInstanceExplorerViewID()
   */
  @Override
  protected String getInstanceExplorerViewID() {
    return SiriusInstanceExplorerView.ID;
  }

}
