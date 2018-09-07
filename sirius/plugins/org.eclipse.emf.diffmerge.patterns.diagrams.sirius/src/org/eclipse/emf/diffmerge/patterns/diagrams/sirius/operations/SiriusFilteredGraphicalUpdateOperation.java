/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagrams.misc.InstanceBasedFilter;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.SiriusUtil;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;


/**
 * A Sirius-specific operation for altering diagram elements based on 
 * specific criteria on semantic elements.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class SiriusFilteredGraphicalUpdateOperation extends AbstractFilteredGraphicalUpdateOperation{

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagram_p the non-null diagram to update
   * @param instances_p a non-null set of pattern instances
   * @param isDirtying_p whether the operation is dirtying
   * @param sourceContext_p an optional context object for the source side of the operation
   */
  protected SiriusFilteredGraphicalUpdateOperation(String name_p, Object diagram_p, 
      Collection<? extends IPatternInstance> instances_p, 
      boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, diagram_p, new InstanceBasedFilter(instances_p), isDirtying_p, sourceContext_p);
  }

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagram_p the non-null diagram to update
   * @param instance_p a non-null pattern instance
   * @param isDirtying_p whether the operation is dirtying
   * @param sourceContext_p an optional context object for the source side of the operation
   */
  protected SiriusFilteredGraphicalUpdateOperation(String name_p, Object diagram_p, 
      IPatternInstance instance_p, boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, diagram_p, new InstanceBasedFilter(instance_p), isDirtying_p, sourceContext_p);
  }

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagramElements_p the non-null, potentially empty set of diagram elements to update
   */
  protected SiriusFilteredGraphicalUpdateOperation(String name_p, 
      Collection<Object> diagramElements_p, boolean isDirtying_p, Object sourceContext_p) {
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
    Collection<?> toUpdate = _diagramElements != null ? getAllDiagramElements(_diagramElements) : _diagramUtil.getDiagramElements(_diagram);
    
    // Start the update
    // Diagram
    if (_diagram instanceof DSemanticDecorator) {
      updated = checkUpdate(_diagram, false);
      if (updated) {
        result.add(_diagram);
      }
    }
    // Diagram elements
    for (Object diagramElement : toUpdate) {
      if(diagramElement instanceof DDiagramElement){
        updated = checkUpdate(diagramElement, false);
        if (updated) {
          result.add(diagramElement);
        } 
      }
    }
    return Collections.unmodifiableCollection(result);
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation#mustBeUpdated(java.lang.Object)
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
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation#getAllDiagramElements(java.util.Collection)
   */
  @Override
  protected List<Object> getAllDiagramElements(Collection<Object> roots_p) {
    return SiriusUtil.getAllDiagramElements(roots_p);
  }

}
