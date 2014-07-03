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
package org.eclipse.emf.diffmerge.patterns.diagram.sirius.factories;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractDisplayOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractPatternWithLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations.SiriusCreatePatternAndInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations.SiriusDisplayOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations.SiriusGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations.SiriusHighlightOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations.SiriusLayoutReuseOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations.SiriusRestoreOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations.SiriusUpdatePatternInCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;


/**
 * A Sirius-specific factory that will instantiate the proper operations depending of the design environment
 * @author Skander TURKI
 *
 */
public class SiriusPatternOperationFactory implements IPatternOperationFactory<AbstractDNode, DDiagramElement, DDiagram, DContainer, DSemanticDecorator>{

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateCreatePatternAndInstanceOperation(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification, java.util.List)
   */
  public AbstractPatternWithLayoutOperation<?> instantiateCreatePatternAndInstanceOperation(
      TemplatePatternCreationSpecification data_p,
      List<Object> modelContext_p, Object patternContext_p) {
    return new SiriusCreatePatternAndInstanceOperation(data_p, modelContext_p, patternContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateDisplayOperation(java.util.Collection, java.lang.Object, boolean)
   */
  public AbstractDisplayOperation<AbstractDNode, DDiagram> instantiateDisplayOperation(
      Collection<? extends EObject> semanticElements_p, DDiagram diagram_p,
      boolean refresh_p) {
    return new SiriusDisplayOperation(semanticElements_p, diagram_p, refresh_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateGraphicalWrappingInstanceOperation(org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation, java.lang.Object, org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind)
   */
  public AbstractGraphicalWrappingInstanceOperation<IPatternInstance, DDiagram, DDiagramElement, AbstractDNode> 
  instantiateGraphicalWrappingInstanceOperation(
      IModelOperation<? extends IPatternInstance> operation_p,
      DDiagram diagram_p, RefreshRequestKind refreshRequest_p) {
    return  new SiriusGraphicalWrappingInstanceOperation<IPatternInstance>(operation_p, diagram_p, refreshRequest_p);
  }


  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateGraphicalWrappingInstanceOperation(org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation, java.lang.Object, org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind, boolean)
   */
  public AbstractGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>, DDiagram, DDiagramElement, AbstractDNode> 
  instantiateGraphicalWrappingInstanceOperation(
      IModelOperation<List<IPatternInstance>> operations_p,
      DDiagram diagram_p, RefreshRequestKind refreshRequest_p, boolean signatureDifferentiator) {
    return  new SiriusGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>>(operations_p, diagram_p, refreshRequest_p);
  }


  /**
   * A Sirius-specific factory that will instantiate the proper operations depending of the design environment
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateGraphicalWrappingInstanceOperation(org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.lang.Object, org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind)
   */
  public AbstractGraphicalWrappingInstanceOperation<IEvaluationStatus, DDiagram, DDiagramElement, AbstractDNode> 
  instantiateGraphicalWrappingInstanceOperation(
      InstanceOperation operation_p, IPatternInstance instance_p,
      DDiagram diagram_p, RefreshRequestKind refreshRequest_p) {
    return new SiriusGraphicalWrappingInstanceOperation<IEvaluationStatus>(operation_p, instance_p, diagram_p, refreshRequest_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateHighlightOperation(java.lang.Object, java.util.Collection, org.eclipse.swt.graphics.RGB, int, boolean, boolean, boolean)
   */
  public AbstractFilteredGraphicalUpdateOperation<DSemanticDecorator, DDiagram, DDiagramElement> 
  instantiateHighlightOperation(
      DDiagram diagram_p, Collection<? extends IPatternInstance> instances_p,
      RGB color_p, int borderSize_p, boolean coverEdges_p,
      boolean coverNodes_p, boolean coverPorts_p) {
    return  new SiriusHighlightOperation(diagram_p, instances_p, color_p, borderSize_p, coverEdges_p,
        coverNodes_p, coverPorts_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateLayoutReuseOperation(java.util.Collection, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.util.Map, java.util.Map, boolean, boolean)
   */
  public AbstractFilteredGraphicalUpdateOperation<DSemanticDecorator, DDiagram, DDiagramElement> 
  instantiateLayoutReuseOperation(
      Collection<DDiagramElement> diagramElements_p, IPatternInstance instance_p,
      Map<DDiagramElement, Point> initialElementsLocationsMap_p,
      Map<DDiagramElement, DContainer> elementsContainersMap_p,
      int vx_p, int vy_p,
      boolean updateLayout_p, boolean updateStyle_p,
      Object modelSideContext_p) {
    return  new SiriusLayoutReuseOperation(diagramElements_p, instance_p, initialElementsLocationsMap_p, elementsContainersMap_p, vx_p, vy_p, updateLayout_p, updateStyle_p, modelSideContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateLayoutReuseOperation(java.lang.Object, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.util.Map, java.util.Map, boolean, boolean)
   */
  public AbstractFilteredGraphicalUpdateOperation<DSemanticDecorator, DDiagram, DDiagramElement> 
  instantiateLayoutReuseOperation(
      DDiagram diagram_p, IPatternInstance instance_p,
      Map<DDiagramElement, Point> initialElementsLocationsMap_p,
      Map<DDiagramElement, DContainer> elementsContainersMap_p,
      int vx_p, int vy_p,
      boolean updateLayout_p, boolean updateStyle_p,
      Object modelSideContext_p) {
    return  new SiriusLayoutReuseOperation(diagram_p, instance_p, initialElementsLocationsMap_p, elementsContainersMap_p, vx_p, vy_p, updateLayout_p, updateStyle_p, modelSideContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateRestoreOperation(java.lang.Object, java.util.Collection)
   */
  public AbstractFilteredGraphicalUpdateOperation<DSemanticDecorator, DDiagram, DDiagramElement> 
  instantiateRestoreOperation(
      DDiagram diagram_p, Collection<? extends IPatternInstance> instances_p) {
    return new SiriusRestoreOperation(diagram_p, instances_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory#instantiateUpdatePatternInCatalogOperation(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification, java.util.List)
   */
  public AbstractPatternWithLayoutOperation<?> 
  instantiateUpdatePatternInCatalogOperation(
      TemplatePatternUpdateSpecification data_p,
      List<Object> context_p) {
    return new SiriusUpdatePatternInCatalogOperation(data_p, context_p, data_p.getOriginalPattern());
  }



}
