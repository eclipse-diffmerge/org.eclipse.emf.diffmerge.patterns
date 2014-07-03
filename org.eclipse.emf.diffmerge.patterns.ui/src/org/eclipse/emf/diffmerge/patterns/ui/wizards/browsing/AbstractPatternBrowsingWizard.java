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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternBrowsingSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternPageFactory;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.CompositeWizardPage;


/**
 * A wizard for browsing pattern repositories.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public abstract class AbstractPatternBrowsingWizard<DiagramElementType, 
DiagramType, GraphicalContainerType, GraphicalNodeType> extends
AbstractPatternWizard<TemplatePatternBrowsingSpecification> {

  /**
   * Constructor
   * @param context_p a non-null object to use as context
   */
  public AbstractPatternBrowsingWizard(Object context_p) {
    super(new TemplatePatternBrowsingSpecification(context_p));
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doAddPages()
   */
  @Override
  public void doAddPages() {
    List<AbstractPatternPage<AbstractBijectiveTemplatePatternSpecification>> subPages =
        new ArrayList<AbstractPatternPage<AbstractBijectiveTemplatePatternSpecification>>();
    subPages.add(instantiatePatternBrowsingPresentationPage(getData()));
    subPages.add(new PatternBrowsingElementsPage(getData()));
    subPages.add(new PatternBrowsingRolesPage(getData()));
    CompositeWizardPage<AbstractBijectiveTemplatePatternSpecification> compositePage =
        new CompositeWizardPage<AbstractBijectiveTemplatePatternSpecification>(
            "mainComposite", //$NON-NLS-1$
            Messages.PatternBrowsingWizard_Title,
            Messages.PatternBrowsingWizard_Message,
            getData(), false, subPages);
    addPage(compositePage);
    setWindowTitle(Messages.PatternBrowsingWizard_Header);
  }

  protected AbstractPatternBrowsingPresentationPage<DiagramElementType, 
  DiagramType, GraphicalContainerType, GraphicalNodeType> 
  instantiatePatternBrowsingPresentationPage(TemplatePatternBrowsingSpecification data_p){
    AbstractPatternPageFactory<DiagramElementType, DiagramType, GraphicalContainerType, GraphicalNodeType>
    factory = PatternsUIPlugin.getDefault().getPageFactory();
    if(factory != null){
      return factory.instantiatePatternBrowsingPresentationPage(data_p);
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

  @SuppressWarnings("unchecked")
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternBrowsingSpecification> wizard_p,  
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
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternBrowsingSpecification> wizard_p,  
      String imageSpecification_p, boolean updatePattern_p){
    IPatternJobFactory factory = 
        (IPatternJobFactory) PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, imageSpecification_p, updatePattern_p);
    }
    return null;
  }

}
