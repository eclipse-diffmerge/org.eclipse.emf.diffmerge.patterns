/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.factories;

import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;


/**
 * A factory that will instantiate the proper jobs depending of the design environment.
 * The design environment (unique in the platform) must provide his own factory.
 * @author Skander Turki
 */
public interface IPatternJobFactory {
  
  /**
   * Instantiates a job for computing the image of a pattern and notifying for completion
   */
  <TemplateSpecificationType 
  extends ITemplatePatternBasedSpecification> Job instantiatePatternImageBuilderJob(
      AbstractPatternWizard<TemplateSpecificationType> wizard_p,
      List<Object> context_p, boolean updatePattern_p);
  
  /**
   * Instantiates a job for computing the image of a pattern and notifying for completion
   */
  <TemplateSpecificationType 
  extends ITemplatePatternBasedSpecification> Job instantiatePatternImageBuilderJob(
      AbstractPatternWizard<TemplateSpecificationType> wizard_p,
      String imageSpecification_p, boolean updatePattern_p); 
  
}
