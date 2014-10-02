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

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * A model environment allows accessing (reading/modifying) a model according
 * to a specific infrastructure.
 * @author Olivier Constant
 * @author Skander Turki
 */
public interface IModelEnvironment {

  /**
   * Allow the caller to abort, assuming it is an IModelOperation.
   */
  void abortOperation();

  /**
   * Asynchronously execute the given operation with the given characteristics
   * @param operation_p the non-null operation to execute
   */
  void asyncExecute(IModelOperation<?> operation_p);

  /**
   * Execute the given operation with the given characteristics
   * @param operation_p the non-null operation to execute
   * @param E the type of the result of the execution
   * @return the result of the execution of this operation, or null if none
   */
  <E> E execute(IModelOperation<E> operation_p);

  /**
   * Return the editing domain for the given element
   * @param a potentially null EObject
   * @return a potentially null editing domain
   */
  EditingDomain getEditingDomain(EObject context_p);

  /**
   * Return the editing domain for the given IFile
   * In some actions like OpenCatalogAction, we need to be able to find the editing domain of the catalog given an IFile.
   * In some modelers a unique editing domain holds all the resources but in other cases each project may have its own editing domain.
   * We also may have a project with only catalogs, in which case we need to get or create an editing domain for the resource.
   * @param a potentially null IFile
   * @return a potentially null editing domain
   */
  EditingDomain getEditingDomain(IFile context_p);

  /**
   * Returns the common editing domain used for all pattern catalogs
   * @return a potentially null TransactionalEditingDomain
   */
  TransactionalEditingDomain getCommonCatalogEditingDomain();
  
  /**
   * Return an inverse cross referencer that covers the context
   * of the given element, if any
   * @param element_p a potentially null element
   * @return a potentially null object
   */
  ECrossReferenceAdapter getInverseCrossReferencer(EObject element_p);

  /**
   * Return whether the given resource is related to a user model
   * @param resource_p a non-null resource
   */
  boolean isModelResource(Resource resource_p);

  /**
   * Checks if the given Object is a model element of the modeling language that is used.
   * @param object_p a non-null Object
   */
  boolean isModelElement(Object object_p);

  /**
   * Returns, from the given resource set, the resource which is referenced by the given pattern instances encoder.
   * @param rset_p a non-null resource set
   * @param set_p a non-null pattern instances encoder (by default a CommonPatternInstanceSet)
   * @return a potentially-null resource
   */
  Resource getModelResourceFromInstanceSet(IPatternInstanceMarker set_p);

  /**
   * Returns, from the given resource, the IPatternInstanceMarker which is the pattern instances
   * encoder for the given Resource. If the encoder is not found, a new one is created.
   * @param resource_p a non-null Resource, should be the model resource
   * @return a potentially-null IPatternInstanceMarker
   */
  IPatternInstanceMarker getOrCreateInstanceSetForModelResource(Resource resource_p);

  /**
   * Creates a Resource for a pattern catalog 
   * @param uri a non null URI
   * @return a non null Resource
   */
  Resource createPatternCatalogResource(URI uri);

  /**
   * A job for asynchronous execution of a model operation
   */
  public static class ModelAccessJob extends Job {
    /** The non-null operation executed by the job */
    private final IModelOperation<?> _operation;
    /**
     * Constructor
     * @param operation_p a non-null model operation
     */
    public ModelAccessJob(IModelOperation<?> operation_p) {
      super(operation_p.getName());
      _operation = operation_p;
    }
    /**
     * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    protected IStatus run(IProgressMonitor monitor_p) {
      _operation.getModelEnvironment().execute(_operation);
      return Status.OK_STATUS;
    }
  }

  /**
   * An IModelEnvironment may override other Environments so that only one IModelEnvironment is active
   * on the platform. The DefaultModelEnvironment should be overridden if not appropriate.
   * @return
   */
  Collection<? extends Class<?>> getOverridenClasses();

  /** 
   * To allow co-existance of different pattern supports (BasicPatternSupport, EmdePatternSupport, etc.),
   * the modeler's environment (rules) provider will tell us for each registered pattern support if it is appropriate for the modeller.
   * only one pattern support should return true
   */
  boolean isAppropriatePatternSupport(IPatternSupport o);

}
