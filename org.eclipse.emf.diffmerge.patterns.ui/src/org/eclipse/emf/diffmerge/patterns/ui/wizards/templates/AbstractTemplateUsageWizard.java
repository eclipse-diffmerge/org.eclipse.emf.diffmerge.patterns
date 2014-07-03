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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.templates;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternPageFactory;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.CompositeWizardPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.PatternBrowsingElementsPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateUsagePresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.TemplateCreationRolesPage;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplateUsageSpecification;


/**
 * A wizard for applying a template in the creation/update process of a pattern.
 * @author O. CONSTANT
 */
public abstract class AbstractTemplateUsageWizard<DiagramElementType, DiagramType, GraphicalContainerType>
extends
AbstractPatternWizard<TemplateUsageSpecification> {

  /**
   * Constructor
   * @param data_p a non-null specification of the pattern under creation/update
   */
  public AbstractTemplateUsageWizard(AbstractModifiableTemplatePatternSpecification data_p) {
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
      //subPages.add(new AbstractTemplateUsagePresentationPage<GraphicalPartType>(getData()));
      subPages.add(instantiateTemplateUsagePresentationPage(getData()));
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
      addPage(instantiateTemplateUsagePresentationPage(getData()));
      //addPage(new AbstractTemplateUsagePresentationPage<GraphicalPartType>(getData()));
    }
    setWindowTitle(Messages.TemplateUsageWizard_Header);
  }

  /**
   * 
   * @param data_p
   * @return
   */
  protected AbstractTemplateUsagePresentationPage<DiagramElementType, DiagramType, GraphicalContainerType>
  instantiateTemplateUsagePresentationPage(TemplateUsageSpecification data_p){
    AbstractPatternPageFactory<DiagramElementType, DiagramType, GraphicalContainerType>
    factory = PatternsUIPlugin.getDefault().getPageFactory();
    if(factory != null){
      return factory.instantiateTemplateUsagePresentationPage(data_p);
    }
    return null;
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

  @SuppressWarnings("unchecked")
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplateUsageSpecification> wizard_p,  
      List<Object> context_p, boolean updatePattern_p){
    IPatternJobFactory factory = 
        (IPatternJobFactory) PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, context_p, updatePattern_p);
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplateUsageSpecification> wizard_p,  
      String imageSpecification_p, boolean updatePattern_p){
    IPatternJobFactory factory = 
        (IPatternJobFactory) PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, imageSpecification_p, updatePattern_p);
    }
    return null;
  }

}
