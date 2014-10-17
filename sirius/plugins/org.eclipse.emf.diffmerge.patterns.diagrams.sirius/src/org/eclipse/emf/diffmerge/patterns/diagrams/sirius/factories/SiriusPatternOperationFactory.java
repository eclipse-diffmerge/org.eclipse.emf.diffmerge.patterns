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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.factories;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractDisplayOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractPatternWithLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusCreatePatternAndInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusDisplayOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusHighlightOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusLayoutReuseOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusRestoreOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusUpdatePatternInCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;


/**
 * A Sirius-specific factory that will instantiate the proper operations depending of the design environment
 * @author Skander Turki
 *
 */
public class SiriusPatternOperationFactory implements IPatternOperationFactory{

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateCreatePatternAndInstanceOperation(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification, java.util.List)
   */
  public AbstractPatternWithLayoutOperation<?> instantiateCreatePatternAndInstanceOperation(
      TemplatePatternCreationSpecification data_p,
      List<Object> modelContext_p, Object patternContext_p) {
    return new SiriusCreatePatternAndInstanceOperation(data_p, modelContext_p, patternContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateDisplayOperation(java.util.Collection, java.lang.Object, boolean)
   */
  public AbstractDisplayOperation instantiateDisplayOperation(
      Collection<? extends EObject> semanticElements_p, Object diagram_p,
      boolean refresh_p) {
    return new SiriusDisplayOperation(semanticElements_p, diagram_p, refresh_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateGraphicalWrappingInstanceOperation(org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation, java.lang.Object, org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind)
   */
  public AbstractGraphicalWrappingInstanceOperation<IPatternInstance> 
  instantiateGraphicalWrappingInstanceOperation(
      IModelOperation<? extends IPatternInstance> operation_p,
      Object diagram_p, RefreshRequestKind refreshRequest_p) {
    return  new SiriusGraphicalWrappingInstanceOperation<IPatternInstance>(operation_p, diagram_p, refreshRequest_p);
  }


  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateGraphicalWrappingInstanceOperation(org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation, java.lang.Object, org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind, boolean)
   */
  public AbstractGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>> 
  instantiateGraphicalWrappingInstanceOperation(
      IModelOperation<List<IPatternInstance>> operations_p,
      Object diagram_p, RefreshRequestKind refreshRequest_p, boolean signatureDifferentiator) {
    return  new SiriusGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>>(operations_p, diagram_p, refreshRequest_p);
  }


  /**
   * A Sirius-specific factory that will instantiate the proper operations depending of the design environment
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateGraphicalWrappingInstanceOperation(org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.lang.Object, org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind)
   */
  public AbstractGraphicalWrappingInstanceOperation<IEvaluationStatus> 
  instantiateGraphicalWrappingInstanceOperation(
      InstanceOperation operation_p, IPatternInstance instance_p,
      Object diagram_p, RefreshRequestKind refreshRequest_p) {
    return new SiriusGraphicalWrappingInstanceOperation<IEvaluationStatus>(operation_p, instance_p, diagram_p, refreshRequest_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateHighlightOperation(java.lang.Object, java.util.Collection, org.eclipse.swt.graphics.RGB, int, boolean, boolean, boolean)
   */
  public AbstractFilteredGraphicalUpdateOperation 
  instantiateHighlightOperation(
      Object diagram_p, Collection<? extends IPatternInstance> instances_p,
      RGB color_p, int borderSize_p, boolean coverEdges_p,
      boolean coverNodes_p, boolean coverPorts_p) {
    return  new SiriusHighlightOperation(diagram_p, instances_p, color_p, borderSize_p, coverEdges_p,
        coverNodes_p, coverPorts_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateLayoutReuseOperation(java.util.Collection, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.util.Map, java.util.Map, boolean, boolean)
   */
  public AbstractFilteredGraphicalUpdateOperation instantiateLayoutReuseOperation(Collection<Object> diagramElements_p, IPatternInstance instance_p,
      Map<Object, Point> initialElementsLocationsMap_p, Map<Object, Object> elementsContainersMap_p,
      int vx_p, int vy_p, boolean updateLayout_p, boolean updateStyle_p,  Object modelSideContext_p) {
    return  new SiriusLayoutReuseOperation(diagramElements_p, instance_p, initialElementsLocationsMap_p, elementsContainersMap_p, vx_p, vy_p, updateLayout_p, updateStyle_p, modelSideContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateLayoutReuseOperation(java.lang.Object, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.util.Map, java.util.Map, boolean, boolean)
   */
  public AbstractFilteredGraphicalUpdateOperation instantiateLayoutReuseOperation(Object diagram_p, IPatternInstance instance_p,
      Map<Object, Point> initialElementsLocationsMap_p, Map<Object, Object> elementsContainersMap_p,
      int vx_p, int vy_p, boolean updateLayout_p, boolean updateStyle_p, Object modelSideContext_p) {
    return  new SiriusLayoutReuseOperation(diagram_p, instance_p, initialElementsLocationsMap_p, elementsContainersMap_p, vx_p, vy_p, updateLayout_p, updateStyle_p, modelSideContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateRestoreOperation(java.lang.Object, java.util.Collection)
   */
  public AbstractFilteredGraphicalUpdateOperation instantiateRestoreOperation(
      Object diagram_p, Collection<? extends IPatternInstance> instances_p) {
    return new SiriusRestoreOperation(diagram_p, instances_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory#instantiateUpdatePatternInCatalogOperation(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification, java.util.List)
   */
  public AbstractPatternWithLayoutOperation<?> instantiateUpdatePatternInCatalogOperation(TemplatePatternUpdateSpecification data_p,
      List<Object> context_p) {
    return new SiriusUpdatePatternInCatalogOperation(data_p, context_p, data_p.getOriginalPattern());
  }



}
