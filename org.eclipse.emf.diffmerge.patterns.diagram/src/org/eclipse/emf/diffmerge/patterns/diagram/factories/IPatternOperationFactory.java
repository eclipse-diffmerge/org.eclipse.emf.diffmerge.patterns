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
package org.eclipse.emf.diffmerge.patterns.diagram.factories;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractDisplayOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractPatternWithLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;

/**
 * A factory that will instantiate the proper operations depending of the design environment
 * The design environment (unique in the platform) must provide his own factory
 * @author Skander TURKI
 */
public interface IPatternOperationFactory {

  /**
   * Instantiates an operation that is responsible for creating a pattern and an instance.
   * @return a non-null AbstractPatternWithLayoutOperation  (must be a concrete CreatePatternAndInstanceOperation)
   */
  AbstractPatternWithLayoutOperation<?> instantiateCreatePatternAndInstanceOperation(
      TemplatePatternCreationSpecification data_p, List<Object> modelContext_p, Object patternSideContext_p);

  /**
   * Instantiates an operation that is responsible of representing a given set of semantic elements in a given diagram.
   * @return a non-null AbstractDisplayOperation (must be a concrete DisplayOperation)
   */
  AbstractDisplayOperation instantiateDisplayOperation(Collection<? extends EObject> semanticElements_p,
      Object diagram_p, boolean refresh_p);

  /**
   * Instantiates an operation that wraps an operation on a pattern instance and may perform different
   * kinds of refresh on a diagram to reflect the effect of the wrapped operation.
   * @return a non-null AbstractGraphicalWrappingInstanceOperation (must be a concrete GraphicalWrappingInstanceOperation)
   */
  AbstractGraphicalWrappingInstanceOperation<IPatternInstance> instantiateGraphicalWrappingInstanceOperation(
      IModelOperation<? extends IPatternInstance> operation_p,
      Object diagram_p, RefreshRequestKind refreshRequest_p);

  /**
   * Instantiates an operation that wraps an operation on a pattern instance and may perform different
   * kinds of refresh on a diagram to reflect the effect of the wrapped operation.
   * @return a non-null AbstractGraphicalWrappingInstanceOperation (must be a concrete GraphicalWrappingInstanceOperation)
   */
  public AbstractGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>> 
  instantiateGraphicalWrappingInstanceOperation(IModelOperation<List<IPatternInstance>> operations_p,
      Object diagram_p, RefreshRequestKind refreshRequest_p, boolean signatureDifferentiator);
  
  /**
   * Instantiates an operation that wraps an operation on a pattern instance and may perform different
   * kinds of refresh on a diagram to reflect the effect of the wrapped operation.
   * @return a non-null AbstractGraphicalWrappingInstanceOperation (must be a concrete GraphicalWrappingInstanceOperation)
   */
  AbstractGraphicalWrappingInstanceOperation<IEvaluationStatus> instantiateGraphicalWrappingInstanceOperation(
      InstanceOperation operation_p, IPatternInstance instance_p,
      Object diagram_p, RefreshRequestKind refreshRequest_p);

  
  /**
   * Instantiates an operation for highlighting diagram elements based on specific criteria on semantic elements.
   * @return a non-null AbstractFilteredGraphicalUpdateOperation (must be a concrete HighlightOperation)
   */
  AbstractFilteredGraphicalUpdateOperation instantiateHighlightOperation(Object diagram_p, 
      Collection<? extends IPatternInstance> instances_p, RGB color_p, int borderSize_p, 
      boolean coverEdges_p, boolean coverNodes_p, boolean coverPorts_p);

  /**
   * Instantiates an operation that is responsible of representing a given set of semantic elements in a given diagram.
   * @return a non-null AbstractFilteredGraphicalUpdateOperation (must be a concrete LayoutReuseOperation)
   */
  AbstractFilteredGraphicalUpdateOperation instantiateLayoutReuseOperation(Collection<Object> diagramElements_p,  
      IPatternInstance instance_p, Map<Object, Point> initialElementsLocationsMap_p,
      Map<Object, Object> elementsContainersMap_p, int vx_p, int vy_p,
      boolean updateLayout_p, boolean updateStyle_p, Object modelSideContext_p);

  /**
   * Instantiates an operation that is responsible of representing a given set of semantic elements in a given diagram.
   * @return a non-null AbstractFilteredGraphicalUpdateOperation (must be a concrete LayoutReuseOperation)
   */
  AbstractFilteredGraphicalUpdateOperation instantiateLayoutReuseOperation(Object diagram_p, IPatternInstance instance_p, 
      Map<Object, Point> initialElementsLocationsMap_p, Map<Object, Object> elementsContainersMap_p,
      int vx_p, int vy_p, boolean updateLayout_p, boolean updateStyle_p, Object modelSideContext_p);
  
  /**
   * Instantiates an operation for restoring diagram elements based on specific criteria on semantic elements.
   * @return a non-null AbstractFilteredGraphicalUpdateOperation (must be a concrete RestoreOperation)
   */
  AbstractFilteredGraphicalUpdateOperation instantiateRestoreOperation(Object diagram_p, Collection<? extends IPatternInstance> instances_p);

  /**
   * Instantiates an operation that is responsible for updating a pattern and an instance.
   * @return a non-null AbstractPatternWithLayoutOperation (must be a concrete UpdatePatternInCatalogOperation)
   */
  AbstractPatternWithLayoutOperation<?> instantiateUpdatePatternInCatalogOperation(TemplatePatternUpdateSpecification data_p, List<Object> context_p);

}
