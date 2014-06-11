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

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternBrowsingSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplateUsageSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationAssociationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.creation.AbstractPatternCreationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateCreationPresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateUsagePresentationPage;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.update.AbstractPatternUpdatePresentationPage;

/**
 * A factory that instantiates UI pages. 
 * and allows the user to select one and perform actions on it.
 * @author Skander TURKI
 */
public abstract class AbstractPatternPageFactory<ColorType, DiagramElementType, 
DiagramType, GraphicalContainerType, GraphicalPartType, SemanticRepresentationType, GraphicalNodeType>
 {
  
  public abstract AbstractTemplateUsagePresentationPage<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  GraphicalPartType, SemanticRepresentationType, GraphicalNodeType> instantiateTemplateUsagePresentationPage(
      TemplateUsageSpecification data_p);
   

  public abstract AbstractTemplateCreationPresentationPage<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  GraphicalPartType, SemanticRepresentationType, GraphicalNodeType> instantiateTemplateCreationPresentationPage(
      TemplatePatternCreationSpecification data_p);

  public abstract AbstractPatternUpdatePresentationPage<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  GraphicalPartType, SemanticRepresentationType, GraphicalNodeType> instantiatePatternUpdatePresentationPage(
      AbstractModifiableTemplatePatternSpecification data_p);
  
  public abstract AbstractPatternCreationPresentationPage<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  GraphicalPartType, SemanticRepresentationType, GraphicalNodeType> instantiatePatternCreationPresentationPage(
      TemplatePatternCreationSpecification data_p);

  
  public abstract AbstractPatternBrowsingPresentationPage<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  GraphicalPartType, SemanticRepresentationType, GraphicalNodeType> instantiatePatternBrowsingPresentationPage(
      TemplatePatternBrowsingSpecification data_p);


  public abstract AbstractPatternApplicationPresentationPage<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  GraphicalPartType, SemanticRepresentationType, GraphicalNodeType> instantiatePatternApplicationPresentationPage(
      TemplatePatternApplicationSpecification data_p);
  
  
  public abstract AbstractPatternApplicationAssociationPage<DiagramType> 
  instantiatePatternApplicationAssociationPage(
      TemplatePatternApplicationSpecification data_p, DiagramType diagram_p);
  
}
