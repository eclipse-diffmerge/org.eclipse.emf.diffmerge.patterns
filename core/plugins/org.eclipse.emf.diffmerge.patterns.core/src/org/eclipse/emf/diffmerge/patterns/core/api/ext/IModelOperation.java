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
package org.eclipse.emf.diffmerge.patterns.core.api.ext;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * This interface defines operations on models which may be time-consuming.
 * @author Olivier Constant
 * @author Skander Turki
 */
public interface IModelOperation<T> extends INamedElement {

  /**
   * Return the model accessor of this operation
   * @return a model accessor which is not null if the operation has started being executed
   */
  IModelEnvironment getModelEnvironment();

  /**
   * Return the resource set onto which this operation is applied
   * @return a resource set (can exceptionally be null if useless)
   */
  ResourceSet getResourceSet();
  
  /**
   * Returns the _targetContext Object. 
   * It should be an object from which the target editing domain can be navigated to.
   * @return a potentially null Object
   */
  Object getTargetContext();

  /**
   * Returns the _sourceContext Object. 
   * It should be an object from which the source's editing domain can be navigated to.
   * @return a potentially null Object
   */
  public Object getSourceContext();
  
  /**
   * Return whether the operation must be considered dirtying w.r.t. editors
   * opened on the model
   */
  boolean isDirtying();

  /**
   * Return whether the operation may be computationally expensive
   */
  boolean isExpensive();

  /**
   * Return whether the operation is read-only w.r.t. the model
   */
  boolean isReadOnly();

  /**
   * Execute this operation reporting progress
   * @param monitor_p the progress monitor to use for reporting progress to the user.
         It is the caller's responsibility to call done() on the given monitor.
         Accepts null, indicating that no progress should be reported and that the operation
         cannot be canceled.
   * @return the result of the execution of this operation, or null if none
   */
  T run(IProgressMonitor monitor_p);
}
