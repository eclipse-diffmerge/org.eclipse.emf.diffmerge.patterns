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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.update;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractPatternWithLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.CompositeWizardPage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * A wizard for updating an existing pattern from one of its instances.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class PatternUpdateWizard extends AbstractPatternWizard<TemplatePatternUpdateSpecification> {

  /**
   * Constructor
   * @param instance_p a non-null instance of the template pattern to update
   * @param referenceElement_p an optional element to use as a reference for multipart
   * @param graphicalContext_p a non-null, potentially empty list of GEF elements
   */
  public PatternUpdateWizard(IPatternInstance instance_p, EObject referenceElement_p,
      List<Object> graphicalContext_p, List<EStructuralFeature> featuresToIgnore_p) {
    super(new TemplatePatternUpdateSpecification(
        instance_p, referenceElement_p, featuresToIgnore_p), graphicalContext_p, true);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doAddPages()
   */
  @Override
  public void doAddPages() {
    List<AbstractPatternPage<TemplatePatternUpdateSpecification>> subPages =
        new ArrayList<AbstractPatternPage<TemplatePatternUpdateSpecification>>();
    subPages.add(new PatternUpdatePresentationPage(getData()));
    subPages.add(new PatternUpdateElementsPage(getData()));
    subPages.add(new PatternUpdateRolesPage(getData()));
    CompositeWizardPage<TemplatePatternUpdateSpecification> compositePage =
        new CompositeWizardPage<TemplatePatternUpdateSpecification>(
            "mainComposite", //$NON-NLS-1$
            Messages.PatternUpdateWizard_Title,
            Messages.PatternUpdateWizard_Message,
            getData(), false, subPages);
    addPage(compositePage);
    setWindowTitle(Messages.PatternUpdateWizard_Header);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doPerformFinish()
   */
  @Override
  protected boolean doPerformFinish() {
    boolean result = false;
    IPatternOperationFactory factory = PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    if(factory != null){
      AbstractPatternWithLayoutOperation<?> operation =
          factory.instantiateUpdatePatternInCatalogOperation(getData(), getGraphicalContext());
      Object returned = CorePatternsPlugin.getDefault().getModelEnvironment().execute(
          operation);
      result = returned != null;
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.util.List, boolean)
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternUpdateSpecification> wizard_p,  
      List<Object> context_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, context_p, updatePattern_p);
    }
    return null;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.lang.String, boolean)
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternUpdateSpecification> wizard_p,  
      String imageSpecification_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, imageSpecification_p, updatePattern_p);
    }
    return null;
  }

}
