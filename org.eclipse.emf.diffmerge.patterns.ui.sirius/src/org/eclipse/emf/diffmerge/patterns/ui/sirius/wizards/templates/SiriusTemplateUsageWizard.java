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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.templates;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateUsageWizard;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;


/**
 * A Sirius-specific wizard for applying a template in the creation/update process of a pattern.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusTemplateUsageWizard 
extends AbstractTemplateUsageWizard<DDiagramElement, DDiagram>{

  public SiriusTemplateUsageWizard(
      AbstractModifiableTemplatePatternSpecification data_p) {
    super(data_p);
  }

}
