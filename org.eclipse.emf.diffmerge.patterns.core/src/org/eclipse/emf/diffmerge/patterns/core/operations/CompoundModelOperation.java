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
package org.eclipse.emf.diffmerge.patterns.core.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * A model operation that consists of several sub-operations.
 * Its execution returns an unmodifiable list of the results of all sub-executions
 * where null values have been filtered out.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class CompoundModelOperation<T> extends AbstractModelOperation<List<T>> {

  /** The non-null list of sub-operations */
  private final List<IModelOperation<? extends T>> _subOperations;

  /**
   * Constructor
   * @param name_p an optional name for the operation
   * @param subOperations_p a non-null list of sub-operations
   */
  public CompoundModelOperation(String name_p,
      List<? extends IModelOperation<? extends T>> subOperations_p, ResourceSet rset_p, 
          Object targetContext_p, Object sourceContext_p) {
    super(name_p, rset_p, isDirtying(subOperations_p), isReadOnly(subOperations_p),
        isExpensive(subOperations_p), targetContext_p, sourceContext_p);
    _subOperations = new ArrayList<IModelOperation<? extends T>>(subOperations_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#getWorkAmount()
   */
  @Override
  protected int getWorkAmount() {
    int result = IProgressMonitor.UNKNOWN;
    for (IModelOperation<?> subOperation : _subOperations) {
      if (subOperation instanceof AbstractModelOperation<?>) {
        int current = ((AbstractModelOperation<?>)subOperation).getWorkAmount();
        if (current != IProgressMonitor.UNKNOWN) {
          if (result == IProgressMonitor.UNKNOWN)
            result = current;
          else
            result += current;
        }
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected List<T> run() {
    List<T> result = new ModelsUtil.RList<T>();
    for (IModelOperation<? extends T> subOperation : _subOperations) {
      @SuppressWarnings("unchecked")
      T localResult = call((AbstractModelOperation<T>)subOperation);
      if (localResult != null)
        result.add(localResult);
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#call(org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation)
   */
  @Override
  public <U> U call(AbstractModelOperation<? extends U> operation_p) {
    operation_p.setModelEnvironment(getModelEnvironment());
    return operation_p.run(getMonitor());
  }

  /**
   * Return whether the set of the given operations all together is dirtying
   * @param subOperations_p a non-null, potentially empty list
   */
  private static boolean isDirtying(List<? extends IModelOperation<?>> subOperations_p) {
    for (IModelOperation<?> subOperation : subOperations_p) {
      if (subOperation.isDirtying())
        return true;
    }
    return false;
  }

  /**
   * Return whether the set of the given operations all together is expensive
   * @param subOperations_p a non-null, potentially empty list
   */
  private static boolean isExpensive(List<? extends IModelOperation<?>> subOperations_p) {
    for (IModelOperation<?> subOperation : subOperations_p) {
      if (subOperation.isExpensive())
        return true;
    }
    return false;
  }

  /**
   * Return whether the set of the given operations all together is read-only
   * @param subOperations_p a non-null, potentially empty list
   */
  private static boolean isReadOnly(List<? extends IModelOperation<?>> subOperations_p) {
    for (IModelOperation<?> subOperation : subOperations_p) {
      if (!subOperation.isReadOnly())
        return false;
    }
    return true;
  }

}
