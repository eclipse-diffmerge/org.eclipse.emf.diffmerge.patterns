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
package org.eclipse.emf.diffmerge.patterns.core.operations;

import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.core.Messages;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicModelUpdateSpecification;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * A generic model transformation operation that operates on a pattern instance.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class InstanceOperation extends AbstractModelOperation<IEvaluationStatus> {

  /**
   * Kinds of operations which can be applied onto a pattern instance 
   */
  public static enum InstanceOperationKind {
    /** The instance check operation */
    CHECK,
    /** The instance soft delete operation */
    DELETE,
    /** The instance hard delete operation */
    DELETE_WITH_ELEMENTS,
    /** The instance folding operation */
    FOLD,
    /** The instance unfolding operation */
    UNFOLD,
    /** The instance update operation */
    UPDATE
  }

  /** The non-null pattern instance on which the operation applies */
  private final IPatternInstance _instance;

  /** The non-null kind of the operation */
  private final InstanceOperationKind _kind;

  /** An optional specification for the operation */
  private Object _specification;


  /**
   * Constructor
   * @param instance_p the non-null application from which the instance must be created
   * @param kind_p a non-null operation kind
   * @param specification_p an optional specification for the operation
   */
  public InstanceOperation(IPatternInstance instance_p,
      InstanceOperationKind kind_p, Object specification_p, Object targetContext_p, Object sourceContext_p) {
    super(Messages.InstanceOperation_Name, null, true, false, false, targetContext_p, sourceContext_p);
    _instance = instance_p;
    _kind = kind_p;
    _specification = specification_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected IEvaluationStatus run() {
    IEvaluationStatus result;
    switch (_kind) {
    case DELETE_WITH_ELEMENTS: result = _instance.delete(false); break;
    case DELETE: result = _instance.delete(true); break;
    case FOLD: result = _instance.fold(); break;
    case UNFOLD: result = _instance.unfold(); break;
    case UPDATE: result = _instance.update(_specification instanceof IPattern.IModelUpdateSpecification?
        (IPattern.IModelUpdateSpecification)_specification: new BasicModelUpdateSpecification()); break;
    default: result = _instance.checkConformance(_specification instanceof BasicModelUpdateSpecification?
        ((BasicModelUpdateSpecification)_specification).getFeaturesToIgnore(): Collections.<EStructuralFeature>emptyList());
    }
    return result;
  }

}
