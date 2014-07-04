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

/**
 * A job for computing the image of a pattern and notifying for completion
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusPatternImageBuilderJob<T extends ITemplatePatternBasedSpecification> 
extends AbstractPatternImageBuilderJob{

  public SiriusPatternImageBuilderJob(AbstractPatternWizard<T> wizard_p,
      String imageSpecification_p, boolean updatePattern_p) {
    super(wizard_p, imageSpecification_p, updatePattern_p);
  }

  public SiriusPatternImageBuilderJob(AbstractPatternWizard<T> wizard_p,
      List<Object> graphicalContext_p, boolean updatePattern_p) {
    super(wizard_p, graphicalContext_p, updatePattern_p);
  }

  @Override
  protected String exportToSVG(List<Object> graphicalContext_p) {
    AbstractDiagramUtil diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    if(diagramUtil != null){
      return diagramUtil.exportToSVG(graphicalContext_p);
    }
    return null;
  }

}
