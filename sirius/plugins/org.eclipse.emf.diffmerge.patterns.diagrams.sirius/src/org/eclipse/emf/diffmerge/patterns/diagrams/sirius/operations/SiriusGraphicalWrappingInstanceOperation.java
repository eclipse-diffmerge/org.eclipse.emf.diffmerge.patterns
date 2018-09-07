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

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation;


/**
 * A Sirius-specific model operation that wraps an operation on a pattern instance and may perform different
 * kinds of refresh on a diagram to reflect the effect of the wrapped operation.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SiriusGraphicalWrappingInstanceOperation<F> extends AbstractGraphicalWrappingInstanceOperation<F>{

  /**
   * Constructor
   * @param operation_p a potentially null operation to wrap
   * @param diagram_p an optional diagram where refresh can happen
   * @param refreshRequest_p the non-null refresh request for this operation
   */
  public SiriusGraphicalWrappingInstanceOperation(
      IModelOperation<? extends F> operation_p, Object diagram_p, RefreshRequestKind refreshRequest_p) {
    super(operation_p, diagram_p, refreshRequest_p);
  }

  /**
   * Constructor
   * @param operation_p a potentially null operation to wrap
   * @param instance_p an optional pattern instance to refresh
   * @param diagram_p an optional diagram where refresh can happen
   * @param refreshRequest_p the non-null refresh request for this operation
   */
  public SiriusGraphicalWrappingInstanceOperation(IModelOperation<? extends F> operation_p,
      IPatternInstance instance_p, Object diagram_p, RefreshRequestKind refreshRequest_p){
    super(operation_p, instance_p, diagram_p, refreshRequest_p);
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation#refreshDiagram()
   */
  @Override
  protected void refreshDiagram() {
    //Let Sirius handle this
    //getDiagram().refresh();
  }

}
