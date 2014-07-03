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

import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractAddToPersistentSelectionAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractApplyPatternAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractBrowseCatalogAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractCreatePatternAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractCreateTemplateAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractHighlightAllPatternsInstancesAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractManageInstanceAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractResetPersistentSelectionAction;
import org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractShowInInstanceExplorerViewAction;
import org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusAddToPersistentSelectionAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusApplyPatternAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusBrowseCatalogAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusCreatePatternAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusCreateTemplateAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusHighlightAllPatternsInstancesAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusManageInstanceAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusResetPersistentSelectionAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.actions.SiriusShowInInstanceExplorerViewAction;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.views.SiriusInstanceExplorerView;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;



/**
 * A Sirius-specific factory for actions contributed through the extension point (actionFactory)
 * @author Skander TURKI
 *
 */
public class SiriusPatternActionFactory extends AbstractPatternActionFactory<DDiagramElement, DDiagram, 
DContainer, SiriusInstanceExplorerView>{

/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateApplyPatternAction()
 */
  @Override
  public AbstractApplyPatternAction<DDiagramElement, DDiagram, DContainer>
  instantiateApplyPatternAction() {
    return new SiriusApplyPatternAction();
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateAbstractBrowseCatalogAction()
   */
  @Override
  public AbstractBrowseCatalogAction<DDiagramElement, DDiagram, DContainer> 
  instantiateBrowseCatalogAction() {
    return new SiriusBrowseCatalogAction();
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateCreatePatternAction()
   */
  @Override
  public AbstractCreatePatternAction<DDiagramElement, DDiagram, DContainer> 
  instantiateCreatePatternAction() {
    return new SiriusCreatePatternAction();
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateCreateTemplateAction()
   */
  @Override
  public AbstractCreateTemplateAction<DDiagramElement, DDiagram, DContainer> 
  instantiateCreateTemplateAction() {
    return new SiriusCreateTemplateAction();
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateHighlightAllPatternsInstancesAction()
   */
  @Override
  public AbstractHighlightAllPatternsInstancesAction<DDiagramElement, DDiagram, DContainer> 
    instantiateHighlightAllPatternsInstancesAction() {
    return  new SiriusHighlightAllPatternsInstancesAction();
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateAddToPersistentSelectionAction()
   */
  @Override
  public AbstractAddToPersistentSelectionAction<DDiagramElement, DDiagram> 
  instantiateAddToPersistentSelectionAction() {
    return new SiriusAddToPersistentSelectionAction();
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateManageInstanceAction()
   */
  @Override
  public AbstractManageInstanceAction<DDiagramElement, DContainer, DDiagram> 
  instantiateManageInstanceAction() {
    return  new SiriusManageInstanceAction();
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateResetPersistentSelectionAction()
   */
  @Override
  public AbstractResetPersistentSelectionAction<DDiagramElement, DDiagram>  
  instantiateResetPersistentSelectionAction() {
    return new SiriusResetPersistentSelectionAction();
  }
  
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory#instantiateShowInInstanceExplorerViewAction()
   */
  @Override
  public AbstractShowInInstanceExplorerViewAction<DDiagramElement, DDiagram, SiriusInstanceExplorerView> 
  instantiateShowInInstanceExplorerViewAction() {
    return  new SiriusShowInInstanceExplorerViewAction();
  }
}
