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
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractPatternWithLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.CompositeWizardPage;


/**
 * A wizard for creating a new template.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class TemplateCreationWizard extends AbstractPatternWizard<TemplatePatternCreationSpecification> {

  /**
   * Constructor
   * @param sources_p the elements from which the pattern must be created
   * @param graphicalContext_p a non-null, potentially empty list of GEF elements
   */
  public TemplateCreationWizard(List<? extends Object> sources_p,
      List<Object> graphicalContext_p) {
    super(TemplatePatternsEnginePlugin.getDefault().newPatternCreationData(
        true, sources_p, PatternsUIPlugin.getDefault().getModelEnvironmentUI().getEnvironments()),
        graphicalContext_p, true);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doAddPages()
   */
  @Override
  public void doAddPages() {
    getData().initializeRoles();
    List<AbstractPatternPage<? extends AbstractBijectiveTemplatePatternSpecification>> subPages =
        new ArrayList<AbstractPatternPage<? extends AbstractBijectiveTemplatePatternSpecification>>();
    subPages.add(new TemplateCreationPresentationPage(getData()));
    subPages.add(new TemplateCreationElementsPage(getData()));
    subPages.add(new TemplateCreationRolesPage(getData()));
    CompositeWizardPage<AbstractBijectiveTemplatePatternSpecification> compositePage =
        new CompositeWizardPage<AbstractBijectiveTemplatePatternSpecification>(
            "mainComposite", //$NON-NLS-1$
            Messages.TemplateCreationWizard_Header,
            Messages.TemplateCreationWizard_Message,
            getData(), false, subPages);
    addPage(compositePage);
    setWindowTitle(Messages.TemplateCreationWizard_Title);
    computePatternImageFromGraphicalContext(true);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doPerformFinish()
   */
  @Override
  protected boolean doPerformFinish() {
    boolean result = false;
    IPatternOperationFactory factory = PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    if(factory != null){
      AbstractPatternWithLayoutOperation<?> operation = factory.instantiateCreatePatternAndInstanceOperation(getData(), getGraphicalContext(), getData().getRepository());
      Object returned = CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
      result = returned != null;
    }
    return result;
  }

  /**
   * Instantiates a pattern image builder job
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternCreationSpecification> wizard_p,  
      List<Object> context_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, context_p, updatePattern_p);
    }
    return null;
  }

  /**
   * Instantiates a pattern image builder job
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternCreationSpecification> wizard_p,  
      String imageSpecification_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, imageSpecification_p, updatePattern_p);
    }
    return null;
  }

}
