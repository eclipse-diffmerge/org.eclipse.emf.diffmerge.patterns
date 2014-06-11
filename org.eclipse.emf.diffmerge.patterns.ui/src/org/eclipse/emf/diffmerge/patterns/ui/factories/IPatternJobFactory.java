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
package org.eclipse.emf.diffmerge.patterns.ui.factories;

import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;

/**
 * A factory that will instantiate the proper jobs depending of the design environment
 * The design environment (unique in the platform) must provide his own factory
 * @author Skander TURKI
 */
public interface IPatternJobFactory<GraphicalPartType> {

  /**
   * Instantiates a job for computing the image of a pattern and notifying for completion
   */
  <TemplateSpecificationType 
  extends ITemplatePatternBasedSpecification> Job instantiatePatternImageBuilderJob(
      AbstractPatternWizard<TemplateSpecificationType, GraphicalPartType> wizard_p,
      List<? extends GraphicalPartType> context_p, boolean updatePattern_p);


  /**
   * Instantiates a job for computing the image of a pattern and notifying for completion
   */
  <TemplateSpecificationType 
  extends ITemplatePatternBasedSpecification> Job instantiatePatternImageBuilderJob(
      AbstractPatternWizard<TemplateSpecificationType, GraphicalPartType> wizard_p,
      String imageSpecification_p, boolean updatePattern_p); 

}
