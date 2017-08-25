/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;
import org.eclipse.emf.diffmerge.structures.common.FArrayList;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;


/**
 * An operation for representing a given set of semantic elements in a given Melody diagram.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractDisplayOperation 
extends AbstractModelOperation<Collection<Object>> {
  
  /** The non-null set of roots of the elements to display */
  protected final Collection<EObject> _semanticRoots;
  
  /** The non-null diagram in which to display the instance */
  protected Object _diagram;
  
  
  /** Whether the diagram must be finally refreshed (required for displaying edges) */
  private final boolean _refresh;
  
  /** The non-null set of graphical nodes created */
  private final Collection<Object> _output;
  
  /**
   * Constructor
   * @param semanticElements_p the elements to represent in diagram_p, their containment trees included
   * @param diagram_p the diagram to update
   * @param refresh_p whether the diagram should be refreshed at the end in order to
   *        display edges
   */
  public AbstractDisplayOperation(Collection<? extends EObject> semanticElements_p,
      Object diagram_p, boolean refresh_p) {
    super(Messages.ViewpointDisplayOperation_Name, null, true, false, true, diagram_p, null);
    _semanticRoots = new FOrderedSet<EObject>();
    _semanticRoots.addAll(ModelsUtil.getRoots(semanticElements_p));
    _diagram = diagram_p;
    _refresh = refresh_p;
    _output = new FOrderedSet<Object>();
  }
  
  /**
   * Refreshes diagram
   */
  protected abstract void refreshDiagram();
  
  /**
   * Convert a parametric collection to another one by filtering out all
   * elements which do not conform to the given type
   * @param elements_p a non-null iterable
   * @param type_p a non-null type
   * @return a non-null, potentially empty, modifiable collection
   */
  public static <T> List<T> filter(Iterable<?> elements_p, Class<T> type_p) {
    List<T> result = new FArrayList<T>();
    for (Object current : elements_p) {
      if (type_p.isInstance(current))
        result.add(type_p.cast(current));
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected Collection<Object> run() {
    _output.addAll(updateDiagram(_diagram));
    if (_refresh)
      refreshDiagram();
    return Collections.unmodifiableCollection(_output);
  }
  
  /**
   * Update the diagram by creating graphical elements
   * @param diagram_p a non-null diagram
   * @return a non-null, potentially empty, unmodifiable set of the nodes created
   */
  protected abstract Collection<Object> updateDiagram(Object diagram_p);
  
}
