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


import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.Messages;


/**
 * An abstract model operation that wraps another one and performs additional treatment
 * for graphical concerns in a certain diagram.
 * @param E the type parameter of this operation
 * @param F the type parameter of the wrapped operation
 * @author O. CONSTANT
 * @author S. TURKI
 */
public abstract class AbstractGraphicalWrappingOperation<T, F, DiagramType> 
extends AbstractModelOperation<T> {

  /** The optional wrapped operation */
  private final IModelOperation<? extends F> _operation;

  /** The optional diagram for graphical concerns */
  private final DiagramType _diagram;

  /**
   * Constructor
   * @param operation_p a potentially null operation to wrap
   * @param diagram_p an optional diagram to refresh
   */
  public AbstractGraphicalWrappingOperation(IModelOperation<? extends F> operation_p, 
      DiagramType diagram_p) {
    super(
        operation_p != null? operation_p.getName(): Messages.AbstractViewpointWrappingOperation_Refresh,
            operation_p != null? operation_p.getResourceSet(): null,
                operation_p != null? operation_p.isDirtying(): true,
                    operation_p != null? operation_p.isReadOnly(): false,
                        operation_p != null? operation_p.isExpensive(): false,
                            diagram_p, diagram_p);
    _operation = operation_p;
    _diagram = diagram_p;
  }

  /**
   * Return the diagram for handling graphical concerns
   * @return a potentially null diagram
   */
  public DiagramType getDiagram() {
    return _diagram;
  }

  /**
   * Return the operation being wrapped
   * @return a potentially null operation
   */
  protected IModelOperation<? extends F> getWrappedOperation() {
    return _operation;
  }

}
