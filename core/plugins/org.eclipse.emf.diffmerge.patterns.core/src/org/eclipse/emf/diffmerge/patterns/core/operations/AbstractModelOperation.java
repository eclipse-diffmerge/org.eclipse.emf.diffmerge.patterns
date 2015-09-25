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
package org.eclipse.emf.diffmerge.patterns.core.operations;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.diffmerge.patterns.core.Messages;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * A partial implementation of IModelOperation.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractModelOperation<T> implements IModelOperation<T> {

  /** A default name for operations in case no name is provided */
  private static final String DEFAULT_NAME = Messages.AbstractModelOperation_DefaultName;

  /** The model environment, non-null if the operation has started being executed */
  private IModelEnvironment _modelEnvironment;

  /** The non-null progress monitor for this operation */
  private SubMonitor _monitor;

  /** The non-null name of the operation */
  private final String _name;

  /** The resource set onto which the operation must be applied */
  private final ResourceSet _resourceSet;

  /** Whether the operation must be considered as dirtying w.r.t. editors on the model */
  private final boolean _isDirtying;

  /** Whether the operation must be considered as expensive */
  private final boolean _isExpensive;

  /** Whether the operation is read-only w.r.t. the model */
  private final boolean _isReadOnly;

  /** Context of operation, used to navigate up to the target editing domain and its command stack */
  private final Object _targetContext;

  /** Context of operation, used to navigate up to the source editing domain */
  private final Object _sourceContext;

  /**
   * Constructor
   * @param name_p an optional name
   * @param resourceSet_p the resource set onto which this operation is applied
   * @param isDirtying_p whether the operation must be considered as dirtying w.r.t. editors on the model
   * @param isReadOnly_p whether the operation is read-only w.r.t. the model
   * @param isExpensive_p whether the operation must be considered as expensive
   * @param sourceContext_p an optional context object for the source side of the operation
   * @param targetContext_p an optional context object for the target side of the operation
   */
  protected AbstractModelOperation(String name_p, ResourceSet resourceSet_p,
      boolean isDirtying_p, boolean isReadOnly_p, boolean isExpensive_p,
      Object targetContext_p, Object sourceContext_p) {
    _modelEnvironment = null;
    _monitor = SubMonitor.convert(new NullProgressMonitor());
    _name = name_p != null && name_p.length() > 0 ? name_p: DEFAULT_NAME;
    _resourceSet = resourceSet_p;
    _isDirtying = isDirtying_p;
    _isReadOnly = isReadOnly_p;
    _isExpensive = isExpensive_p;
    _targetContext = targetContext_p;
    _sourceContext = sourceContext_p;
  }


  /**
   * Abort this operation
   */
  protected void abort() {
    if (_modelEnvironment != null)
      _modelEnvironment.abortOperation();
  }

  /**
   * Call the given operation and return its result
   * @param operation_p a non-null operation
   * @return a potentially null object
   */
  public <U> U call(AbstractModelOperation<? extends U> operation_p) {
    operation_p.setModelEnvironment(getModelEnvironment());
    return operation_p.run(getMonitor());
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#getModelEnvironment()
   */
  public IModelEnvironment getModelEnvironment() {
    return _modelEnvironment;
  }

  /**
   * Return a non-null progress monitor for this operation
   */
  protected final SubMonitor getMonitor() {
    return _monitor;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement#getName()
   */
  public String getName() {
    return _name;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#getResourceSet()
   */
  public ResourceSet getResourceSet() {
    return _resourceSet;
  }

  /**
   * Return the total amount of work needed for the operation execution
   */
  protected int getWorkAmount() {
    // Redefine if actually using monitors
    return IProgressMonitor.UNKNOWN;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#isDirtying()
   */
  public boolean isDirtying() {
    return _isDirtying;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#isExpensive()
   */
  public boolean isExpensive() {
    return _isExpensive;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#isReadOnly()
   */
  public boolean isReadOnly() {
    return _isReadOnly;
  }

  /**
   * Execute the operation
   * @return a potentially null object
   */
  protected abstract T run();

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  public T run(IProgressMonitor monitor_p) {
    // Not final to support return-type covariance
    if (monitor_p != null)
      _monitor = SubMonitor.convert(monitor_p, getName(), getWorkAmount());
    _monitor.subTask(getName());
    return run();
  }

  /**
   * Set the model Environment executing this operation
   * @param modelEnvironment_p a non-null model Environment
   */
  public void setModelEnvironment(IModelEnvironment modelEnvironment_p) {
    _modelEnvironment = modelEnvironment_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#getTargetContext()
   */
  public Object getTargetContext(){
    return _targetContext;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation#getSourceContext()
   */
  public Object getSourceContext(){
    return _sourceContext;
  }

}
