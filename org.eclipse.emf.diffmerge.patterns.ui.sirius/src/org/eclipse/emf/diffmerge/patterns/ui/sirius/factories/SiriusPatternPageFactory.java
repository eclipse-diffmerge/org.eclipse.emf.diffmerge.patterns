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

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternBrowsingSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplateUsageSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternPageFactory;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.application.SiriusPatternApplicationAssociationPage;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.application.SiriusPatternApplicationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.browsing.SiriusPatternBrowsingPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.creation.SiriusPatternCreationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.templates.SiriusTemplateCreationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.templates.SiriusTemplateUsagePresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.update.SiriusPatternUpdatePresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationAssociationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.creation.AbstractPatternCreationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateCreationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateUsagePresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.update.AbstractPatternUpdatePresentationPage;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.viewpoint.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;




/**
 * A Sirius-specific factory that instantiates UI pages. 
 * and allows the user to select one and perform actions on it.
 * @author Skander TURKI
 */
public class SiriusPatternPageFactory 
extends AbstractPatternPageFactory<RGBValues, DDiagramElement, DDiagram, DContainer, 
IGraphicalEditPart, DSemanticDecorator, AbstractDNode>{

  @Override
  public AbstractTemplateUsagePresentationPage<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
  DSemanticDecorator, AbstractDNode> instantiateTemplateUsagePresentationPage(
      TemplateUsageSpecification data_p) {
    return new SiriusTemplateUsagePresentationPage(data_p);
  }
   

  @Override
  public AbstractTemplateCreationPresentationPage<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
  DSemanticDecorator, AbstractDNode> instantiateTemplateCreationPresentationPage(
      TemplatePatternCreationSpecification data_p) {
    return new SiriusTemplateCreationPresentationPage(data_p);
  }

  @Override
  public AbstractPatternUpdatePresentationPage<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
  DSemanticDecorator, AbstractDNode> instantiatePatternUpdatePresentationPage(
      AbstractModifiableTemplatePatternSpecification data_p) {
    return new SiriusPatternUpdatePresentationPage((TemplatePatternUpdateSpecification) data_p);
  }
  
  @Override
  public AbstractPatternCreationPresentationPage<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
  DSemanticDecorator, AbstractDNode> instantiatePatternCreationPresentationPage(
      TemplatePatternCreationSpecification data_p) {
    return new SiriusPatternCreationPresentationPage(data_p);
  }

  
  @Override
  public AbstractPatternBrowsingPresentationPage<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
  DSemanticDecorator, AbstractDNode> instantiatePatternBrowsingPresentationPage(
      TemplatePatternBrowsingSpecification data_p) {
    return new SiriusPatternBrowsingPresentationPage(data_p);
  }


  @Override
  public AbstractPatternApplicationPresentationPage<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
  DSemanticDecorator, AbstractDNode> instantiatePatternApplicationPresentationPage(
      TemplatePatternApplicationSpecification data_p) {
    return new SiriusPatternApplicationPresentationPage(data_p);
  }
  
  
  @Override
  public AbstractPatternApplicationAssociationPage<DDiagram> instantiatePatternApplicationAssociationPage(
      TemplatePatternApplicationSpecification data_p, DDiagram diagram_p) {
    return new SiriusPatternApplicationAssociationPage(data_p, diagram_p);
  }

  
}
