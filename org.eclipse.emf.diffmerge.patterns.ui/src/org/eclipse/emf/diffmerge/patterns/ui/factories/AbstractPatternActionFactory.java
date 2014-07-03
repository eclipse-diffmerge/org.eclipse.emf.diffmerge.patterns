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

import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractAddToPersistentSelectionAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractApplyPatternAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractBrowseCatalogAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractCreatePatternAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractCreateTemplateAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractHighlightAllPatternsInstancesAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractManageInstanceAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractResetPersistentSelectionAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractShowInInstanceExplorerViewAction;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.AbstractInstanceExplorerView;


/**
 * A factory that will instantiate the proper actions depending of the design environment
 * The design environment (unique in the platform) must provide his own factory
 * @author Skander TURKI
 */
public abstract class AbstractPatternActionFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
GraphicalNodeType,
InstanceExplorerViewType extends AbstractInstanceExplorerView, SemanticRepresentationType> {

  /**
   * A static getter for the currently installed PatternActionFactory in the environment
   * @return a potentially-null IPatternAcitonFactory
   */
  public static AbstractPatternActionFactory<?, ?, ?, ? ,? ,?, ?> getInstance(){
    return PatternsUIPlugin.getDefault().getActionFactory();  
  }

  /**
   * Instantiates a new ApplyPatternAction
   * @return a non-null AbstractApplyPatternAction
   */
  public abstract AbstractApplyPatternAction<ColorType, DiagramElementType, 
  DiagramType, GraphicalContainerType, SemanticRepresentationType, GraphicalNodeType>
  instantiateApplyPatternAction();


  /**
   * Instantiates a new BrowseCatalogAction
   * @return a non-null AbstractBrowseCatalogAction
   */
  public abstract AbstractBrowseCatalogAction<ColorType, DiagramElementType, DiagramType, 
  GraphicalContainerType, SemanticRepresentationType, GraphicalNodeType>
  instantiateBrowseCatalogAction();


  /**
   * Instantiates a new CreatePatternAction
   * @return a non-null AbstractCreatePatternAction
   */
  public abstract AbstractCreatePatternAction<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  SemanticRepresentationType, GraphicalNodeType> instantiateCreatePatternAction();


  /**
   * Instantiates a new CreateTemplateAction
   * @return a non-null AbstractCreateTemplateAction
   */
  public abstract AbstractCreateTemplateAction<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  SemanticRepresentationType, GraphicalNodeType> 
  instantiateCreateTemplateAction();


  /**
   * Instantiates a new HighlightAllPatternsInstancesAction
   * @return a non-null AbstractHighlightAllPatternsInstancesAction
   */
  public abstract AbstractHighlightAllPatternsInstancesAction<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  SemanticRepresentationType, GraphicalNodeType>
  instantiateHighlightAllPatternsInstancesAction();


  /**
   * Instantiates a new AddToPersistentSelectionAction
   * @return a non-null AbstractAddToPersistentSelectionAction
   */
  public abstract AbstractAddToPersistentSelectionAction<DiagramElementType, DiagramType> 
  instantiateAddToPersistentSelectionAction();

  /**
   * Instantiates a new ManageInstanceAction
   * @return a non-null AbstractManageInstanceAction
   */
  public abstract AbstractManageInstanceAction<ColorType, DiagramElementType, GraphicalContainerType, 
  DiagramType, SemanticRepresentationType, GraphicalNodeType> 
  instantiateManageInstanceAction();


  /**
   * Instantiates a new ResetPersistentSelectionAction
   * @return a non-null AbstractResetPersistentSelectionAction
   */
  public abstract AbstractResetPersistentSelectionAction<DiagramElementType, DiagramType>  
  instantiateResetPersistentSelectionAction();


  /**
   * Instantiates a new ShowInInstanceExplorerViewAction
   * @return a non-null AbstractShowInInstanceExplorerViewAction
   */
  public abstract AbstractShowInInstanceExplorerViewAction<DiagramElementType, DiagramType, InstanceExplorerViewType> 
  instantiateShowInInstanceExplorerViewAction();

}
