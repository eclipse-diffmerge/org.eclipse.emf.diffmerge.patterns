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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.misc;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.misc.AbstractPatternImageBuilderJob;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;


/**
 * A job for computing the image of a pattern and notifying for completion.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SiriusPatternImageBuilderJob<T extends ITemplatePatternBasedSpecification> 
extends AbstractPatternImageBuilderJob{

  /**
   * Constructor
     * @param wizard_p a non-null wizard
     * @param imageSpecification_p a potentially null image specification
     * @param updatePattern_p whether the pattern must be updated with the new image
   */
  public SiriusPatternImageBuilderJob(AbstractPatternWizard<T> wizard_p,
      String imageSpecification_p, boolean updatePattern_p) {
    super(wizard_p, imageSpecification_p, updatePattern_p);
  }
  
  /**
   * Constructor
   * @param wizard_p a non-null wizard
   * @param graphicalContext_p a potentially null list of contextual GEF elements
   * @param updatePattern_p whether the pattern must be updated with the new image
   */
  public SiriusPatternImageBuilderJob(AbstractPatternWizard<T> wizard_p,
      List<Object> graphicalContext_p, boolean updatePattern_p) {
    super(wizard_p, graphicalContext_p, updatePattern_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.misc.AbstractPatternImageBuilderJob#exportToSVG(java.util.List)
   */
  @Override
  protected String exportToSVG(List<Object> graphicalContext_p) {
    AbstractDiagramUtil diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    if(diagramUtil != null){
      return diagramUtil.exportToSVG(graphicalContext_p);
    }
    return null;
  }
  
}
