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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.browsing;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;

/**
 * A Sirius-specific wizard for browsing pattern repositories.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusPatternBrowsingWizard 
extends AbstractPatternBrowsingWizard<RGBValues, DDiagramElement, DDiagram, DContainer, AbstractDNode>{
  
  /**
   * Constructor
   * @param context_p a non-null object to use as context
   * @param pattern_p a potentially null pattern to browse first
   */
  public SiriusPatternBrowsingWizard(Object context_p, TemplatePattern pattern_p) {
    this(context_p, pattern_p != null? pattern_p.getRepository(): null);
    getData().setPattern(pattern_p);
  }
  
  /**
   * Constructor
   * @param context_p a non-null object to use as context
   * @param repository_p a potentially null repository to browse first
   */
  public SiriusPatternBrowsingWizard(Object context_p, IPatternRepository repository_p) {
    super(context_p);
    getData().setRepository(repository_p);
  }
  
}
