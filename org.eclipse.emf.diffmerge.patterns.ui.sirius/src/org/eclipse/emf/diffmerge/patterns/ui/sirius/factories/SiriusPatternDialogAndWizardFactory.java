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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.factories;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.InstancePanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.dialogs.SiriusHighlightAllPatternsInstancesPanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.dialogs.SiriusInstancePanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.application.SiriusPatternApplicationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.browsing.SiriusPatternBrowsingWizard;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.creation.SiriusPatternCreationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.templates.SiriusTemplateCreationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.templates.SiriusTemplateUsageWizard;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.update.SiriusPatternUpdateWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.creation.AbstractPatternCreationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateCreationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateUsageWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.update.AbstractPatternUpdateWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.viewpoint.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.swt.widgets.Shell;


/**
 * A Sirius-specific factory that will instantiate the proper dialogs and wizards depending on the design environment
 * @author Skander TURKI
 *
 */
public class SiriusPatternDialogAndWizardFactory 
implements IPatternDialogAndWizardFactory<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
DSemanticDecorator, AbstractDNode>{

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiateHighlightAllPatternsInstancesPanelDialog(java.util.Set, java.util.List, java.lang.Object, org.eclipse.swt.widgets.Shell, java.lang.String, java.lang.String)
   */
  public SiriusHighlightAllPatternsInstancesPanelDialog instantiateHighlightAllPatternsInstancesPanelDialog(
      Set<IPatternInstance> instances_p, List<Object> selection_p, DDiagram diagram_p, Shell shell_p, 
      String dialogTitle_p, String dialogMessage_p) {
    return   new SiriusHighlightAllPatternsInstancesPanelDialog(instances_p, diagram_p, shell_p, 
        dialogTitle_p, dialogMessage_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiateInstancePanelDialog(java.util.List, org.eclipse.emf.ecore.EObject, java.lang.Object, java.util.List, org.eclipse.swt.widgets.Shell)
   */
  public InstancePanelDialog<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
  DSemanticDecorator, AbstractDNode> 
  instantiateInstancePanelDialog(List<IPatternInstance> instances_p, EObject referenceElement_p, 
      DDiagram diagram_p, List<? extends IGraphicalEditPart> graphicalContext_p, Shell shell_p) {
    return new SiriusInstancePanelDialog(shell_p, referenceElement_p, instances_p, 
        diagram_p, graphicalContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
   */
  public AbstractPatternBrowsingWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>
  instantiatePatternBrowsingWizard(
      EObject context_p, TemplatePattern pattern_p) {
    return new SiriusPatternBrowsingWizard(context_p, pattern_p) ;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
   */
  public AbstractPatternBrowsingWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>
  instantiatePatternBrowsingWizard(
      EObject context_p, IPatternRepository repository_p) {
    return new SiriusPatternBrowsingWizard(context_p, repository_p) ;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(java.lang.Object, org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
   */
  public AbstractPatternBrowsingWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>
  instantiatePatternBrowsingWizard(
      Object context_p, IPatternRepository repository_p) {
    return new SiriusPatternBrowsingWizard(context_p, repository_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiateTemplateCreationWizard(java.util.List, java.util.List)
   */
  public AbstractTemplateCreationWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>
  instantiateTemplateCreationWizard(
      List<Object> selection_p, List<? extends IGraphicalEditPart> graphicalContext_p) {
    return new SiriusTemplateCreationWizard(selection_p, graphicalContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(org.eclipse.emf.ecore.resource.ResourceSet, org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
   */
  public AbstractPatternBrowsingWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>
  instantiatePatternBrowsingWizard(
      ResourceSet rset_p, IPatternRepository repository_p) {
    return new SiriusPatternBrowsingWizard(rset_p, repository_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternUpdateWizard(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, org.eclipse.emf.ecore.EObject, java.util.List, java.util.List)
   */
  public AbstractPatternUpdateWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>
  instantiatePatternUpdateWizard(
      IPatternInstance instance_p, EObject referenceElement_p,
      List<? extends IGraphicalEditPart> graphicalContext_p,
      List<EStructuralFeature> featuresToIgnore_p) {
    return new SiriusPatternUpdateWizard(instance_p, referenceElement_p, graphicalContext_p, featuresToIgnore_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternWizardDialog(org.eclipse.swt.widgets.Shell, org.eclipse.emf.diffmerge.patterns.ui.wizards.creation.AbstractPatternCreationWizard)
   */
  public PatternWizardDialog 
  instantiatePatternWizardDialog(Shell shell_p, AbstractPatternCreationWizard<RGBValues, DDiagramElement, DDiagram, DContainer, 
      IGraphicalEditPart, DSemanticDecorator, AbstractDNode> _wizard) {
    return new PatternWizardDialog(shell_p, _wizard);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiateTemplateUsageWizard(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification)
   */
  public AbstractTemplateUsageWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode>
  instantiateTemplateUsageWizard(
      AbstractModifiableTemplatePatternSpecification data_p) {
    return new SiriusTemplateUsageWizard(data_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternCreationWizard(java.util.List, java.util.List, org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification)
   */
  public AbstractPatternCreationWizard<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode> 
  instantiatePatternCreationWizard(
      List<Object> selection_p,
      List<? extends IGraphicalEditPart> graphicalContext_p, 
      TemplatePatternCreationSpecification patternCreationSpecification_p,
      boolean createNextBackButtons_p) {
    return new SiriusPatternCreationWizard(selection_p, graphicalContext_p, 
        patternCreationSpecification_p, createNextBackButtons_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternApplicationWizard(java.util.List, java.lang.Object)
   */
  public AbstractPatternApplicationWizard<RGBValues, DDiagramElement, DDiagram, 
  DContainer, IGraphicalEditPart, DSemanticDecorator, AbstractDNode> 
  instantiatePatternApplicationWizard(
      List<Object> selection_p, DDiagram diagram_p) {
    return new SiriusPatternApplicationWizard(selection_p, diagram_p);
  }

}
