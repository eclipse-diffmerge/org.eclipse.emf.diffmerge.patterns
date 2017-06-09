/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.templates;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplateUsageSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.CompositeWizardPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.PatternBrowsingElementsPage;


/**
 * A wizard for applying a template in the creation/update process of a pattern.
 * @author Olivier Constant
 */
public class TemplateUsageWizard extends AbstractPatternWizard<TemplateUsageSpecification> {

  /**
   * Constructor
   * @param data_p a non-null specification of the pattern under creation/update
   */
  public TemplateUsageWizard(AbstractModifiableTemplatePatternSpecification data_p) {
    super(new TemplateUsageSpecification(data_p));
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doAddPages()
   */
  @Override
  public void doAddPages() {
    if (showPatternContent()) {
      List<AbstractPatternPage<? extends AbstractBijectiveTemplatePatternSpecification>> subPages =
          new ArrayList<AbstractPatternPage<? extends AbstractBijectiveTemplatePatternSpecification>>();
      subPages.add(new TemplateUsagePresentationPage(getData()));
      subPages.add(new PatternBrowsingElementsPage(getData()));
      subPages.add(new TemplateCreationRolesPage(getData()) {
        /**
         * 
         * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage#isReadOnly()
         */
        @Override
        protected boolean isReadOnly() {
          return true;
        }
      });
      CompositeWizardPage<AbstractBijectiveTemplatePatternSpecification> compositePage =
          new CompositeWizardPage<AbstractBijectiveTemplatePatternSpecification>(
              "mainComposite", //$NON-NLS-1$
              Messages.TemplateUsageWizard_Title,
              Messages.TemplateUsageWizard_Message,
              getData(), false, subPages);
      addPage(compositePage);
    } else {
      addPage(new TemplateUsagePresentationPage(getData()));
    }
    setWindowTitle(Messages.TemplateUsageWizard_Header);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doPerformFinish()
   */
  @Override
  protected boolean doPerformFinish() {
    return true;
  }

  /**
   * Return whether the whole content of the pattern must be shown to the user
   */
  protected boolean showPatternContent() {
    return true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.util.List, boolean)
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplateUsageSpecification> wizard_p,  
      List<Object> context_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, context_p, updatePattern_p);
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.lang.String, boolean)
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplateUsageSpecification> wizard_p,  
      String imageSpecification_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, imageSpecification_p, updatePattern_p);
    }
    return null;
  }

}
