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

import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractManageInstanceAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.viewpoint.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;

/**
 * A Sirius-specific action which opens the dialog for managing pattern instances.
 * @author Skander TURKI
 */
public class SiriusManageInstanceAction extends AbstractManageInstanceAction<RGBValues, DDiagramElement, IGraphicalEditPart, DContainer, DDiagram, DSemanticDecorator, AbstractDNode>{

  // Only specifies generic types for Sirius

}
