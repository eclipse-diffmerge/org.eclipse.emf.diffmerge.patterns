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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.update;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.update.AbstractPatternUpdateWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.viewpoint.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;

/**
 * A Sirius-specific wizard for updating an existing pattern from one of its instances.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusPatternUpdateWizard 
extends AbstractPatternUpdateWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>{

  public SiriusPatternUpdateWizard(IPatternInstance instance_p,
      EObject referenceElement_p,
      List<? extends IGraphicalEditPart> graphicalContext_p,
      List<EStructuralFeature> featuresToIgnore_p) {
    super(instance_p, referenceElement_p, graphicalContext_p, featuresToIgnore_p);
  }

}
