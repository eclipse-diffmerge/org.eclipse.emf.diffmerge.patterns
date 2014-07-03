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
package org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.misc.InstanceBasedFilter;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.SiriusUtil;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

/**
 * A Sirius-specific operation for altering diagram elements based on 
 * specific criteria on semantic elements.
 * @author Olivier Constant
 * @author Skander TURKI
 */
public abstract class SiriusFilteredGraphicalUpdateOperation 
extends AbstractFilteredGraphicalUpdateOperation<DDiagram, DDiagramElement>{

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagram_p the non-null diagram to update
   * @param filter_p the non-null filter for semantic elements whose representation must be updated
   */
  protected SiriusFilteredGraphicalUpdateOperation(String name_p, DDiagram diagram_p, 
      Collection<? extends IPatternInstance> instances_p, 
      boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, diagram_p, new InstanceBasedFilter(instances_p), isDirtying_p, sourceContext_p);
  }

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagram_p the non-null diagram to update
   * @param filter_p the non-null filter for semantic elements whose representation must be updated
   */
  protected SiriusFilteredGraphicalUpdateOperation(String name_p, DDiagram diagram_p, 
      IPatternInstance instance_p, boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, diagram_p, new InstanceBasedFilter(instance_p), isDirtying_p, sourceContext_p);
  }

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagramElements_p the non-null, potentially empty set of diagram elements to update
   */
  protected SiriusFilteredGraphicalUpdateOperation(String name_p, 
      Collection<? extends DDiagramElement> diagramElements_p, boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, diagramElements_p, isDirtying_p, sourceContext_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  public Collection<Object> run() {
    Collection<Object> result = new FOrderedSet<Object>();
    boolean updated = false;
    // Diagram elements
    Collection<? extends DDiagramElement> toUpdate = _diagramElements != null ? getAllDiagramElements(_diagramElements) : _diagram.getDiagramElements();

    // Start the update
    // Diagram
    if (_diagram instanceof DSemanticDecorator) {
      updated = checkUpdate((DSemanticDecorator) _diagram, false);
      if (updated) {
        result.add((DSemanticDecorator) _diagram);
      }
    }
    // Diagram elements
    for (DDiagramElement diagramElement : toUpdate) {
      updated = checkUpdate(diagramElement, false);
      if (updated) {
        result.add(diagramElement);
      }
    }
    return Collections.unmodifiableCollection(result);
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractFilteredGraphicalUpdateOperation#mustBeUpdated(java.lang.Object)
   */
  @Override
  protected boolean mustBeUpdated(Object decorator_p) {
    if(decorator_p instanceof DSemanticDecorator){
      boolean result = true;
      if (getFilter() != null) {
        result = false;
        EObject semanticElement = ((DSemanticDecorator)decorator_p).getTarget();
        if (semanticElement != null) {
          result = getFilter().accepts(semanticElement);
        }
      }
      return result;
    }
    return false;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractFilteredGraphicalUpdateOperation#getAllDiagramElements(java.util.Collection)
   */
  @Override
  protected List<DDiagramElement> getAllDiagramElements(
      Collection<? extends DDiagramElement> roots_p) {
    return SiriusUtil.getAllDiagramElements(roots_p);
  }

}
