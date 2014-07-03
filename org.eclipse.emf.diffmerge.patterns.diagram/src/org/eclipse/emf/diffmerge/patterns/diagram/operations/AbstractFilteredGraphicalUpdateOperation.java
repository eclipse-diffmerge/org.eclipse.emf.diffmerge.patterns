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
package org.eclipse.emf.diffmerge.patterns.diagram.operations;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.util.ModelsUtil;

/**
 * An operation for altering diagram elements based on specific criteria on semantic elements.
 * @author O. CONSTANT
 * @author S. TURKI
 */
public abstract class AbstractFilteredGraphicalUpdateOperation<DiagramType, DiagramElementType> 
extends AbstractModelOperation<Collection<Object>> {

  /**
   * The [non-null iff _diagramElements is null] diagram in which update must occur
   */
  protected final DiagramType _diagram;

  /**
   * The [non-null iff _diagram is null], potentially empty set of diagram elements to update
   */
  protected final Collection<? extends DiagramElementType> _diagramElements;

  /**
   * The [non-null iff _diagramElements is null] filter for semantic elements whose representation must be updated
   */
  private final ModelsUtil.IElementFilter _filter;


  /** Instance of inner class used to simulate multiple inheritance for leaf operations*/
  protected AbstractGraphicalUpdateOperation<DiagramType> _innerGraphicalOperation;

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagram_p the non-null diagram to update
   * @param filter_p the non-null filter for semantic elements whose representation must be updated
   */
  protected AbstractFilteredGraphicalUpdateOperation(String name_p, DiagramType diagram_p, 
      ModelsUtil.IElementFilter filter_p, boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, null, isDirtying_p, false, true, diagram_p, sourceContext_p);
    _diagram = diagram_p;
    _filter = filter_p;
    _diagramElements = null;
  }

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagramElements_p the non-null, potentially empty set of diagram elements to update
   */
  protected AbstractFilteredGraphicalUpdateOperation(String name_p, 
      Collection<? extends DiagramElementType> diagramElements_p, 
      boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, null, isDirtying_p, false, true, diagramElements_p, sourceContext_p);
    _diagram = null;
    _filter = null;
    _diagramElements = diagramElements_p;
  }

  /**
   * Update the given decorator if relevant
   * @param decorator_p a non-null semantic decorator
   * @return whether the decorator was actually updated
   */
  protected final boolean checkUpdate(Object decorator_p, boolean isMerged) {
    boolean result = false;
    if (mustBeUpdated(decorator_p)) {
      update(decorator_p, isMerged);
      result = true;
    }
    return result;
  }

  /**
   * Return the diagram in which update must occur
   * @return a non-null diagram
   */
  public final DiagramType getDiagram() {
    return _diagram;
  }

  /**
   * Return the filter for the semantic elements whose representation must be updated
   * @return a non-null filter
   */
  protected final ModelsUtil.IElementFilter getFilter() {
    return _filter;
  }

  /**
   * Return whether the given decorator must be updated
   * @param decorator_p a non-null semantic decorator
   */
  protected abstract boolean mustBeUpdated(Object decorator_p);


  /**
   * Update the given decorator
   * @param decorator_p a non-null semantic decorator
   */
  protected abstract void update(Object decorator_p, boolean isMerged);


  /**
   * Returns a list of all diagram elements in the given roots.
   * @param roots_p
   * @return
   */
  protected abstract List<DiagramElementType> getAllDiagramElements(Collection<? extends DiagramElementType> roots_p);


}
