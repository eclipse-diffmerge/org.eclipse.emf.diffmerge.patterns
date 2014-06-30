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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.misc;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.misc.AbstractPatternImageBuilderJob;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;




/**
 * A job for computing the image of a pattern and notifying for completion
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusPatternImageBuilderJob<T extends ITemplatePatternBasedSpecification> 
extends AbstractPatternImageBuilderJob<IGraphicalEditPart>{

  public SiriusPatternImageBuilderJob(AbstractPatternWizard<T, IGraphicalEditPart> wizard_p,
      String imageSpecification_p, boolean updatePattern_p) {
    super(wizard_p, imageSpecification_p, updatePattern_p);
  }

  public SiriusPatternImageBuilderJob(AbstractPatternWizard<T, IGraphicalEditPart> wizard_p,
      List<? extends IGraphicalEditPart> graphicalContext_p, boolean updatePattern_p) {
    super(wizard_p, graphicalContext_p, updatePattern_p);
  }

  @Override
  protected String exportToSVG(List<? extends IGraphicalEditPart> graphicalContext_p) {
    AbstractDiagramUtil<DDiagramElement, DDiagram, IGraphicalEditPart> diagramUtil = 
        (AbstractDiagramUtil<DDiagramElement, DDiagram, IGraphicalEditPart>) PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    if(diagramUtil != null){
      return diagramUtil.exportToSVG(graphicalContext_p);
    }
    return null;
  }

}
