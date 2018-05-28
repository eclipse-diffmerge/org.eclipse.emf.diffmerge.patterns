/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.extensions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.SiriusPatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusCreatePatternAndInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.support.environment.DefaultModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.support.resources.DefaultPatternsXMIResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;


/**
 * A default model environment for Sirius-based modelers.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractSiriusModelEnvironment implements IModelEnvironment {
  
  /** The editing domain dedicated to pattern catalogs */
  private TransactionalEditingDomain _patternCatalogCommonEditingDomain;
  
  /** The ID suffix for the editing domain dedicated to pattern catalogs */
  private static String CATALOG_COMMON_EDITING_DOMAIN_ID_END = "Catalogs_Common_Editing_Domain"; //$NON-NLS-1$
  
  
  /**
   * Constructor
   */
  public AbstractSiriusModelEnvironment(){
    ResourceSet rset = new ResourceSetImpl();
    _patternCatalogCommonEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
    String edID = SiriusPatternsPlugin.PLUGIN_ID + '.' + CATALOG_COMMON_EDITING_DOMAIN_ID_END;
    _patternCatalogCommonEditingDomain.setID(edID);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#abortOperation()
   */
  public void abortOperation() {
    throw new OperationCanceledException();
  }
  
  /**
   * The navigation to the editing domain associated with the context is realized differently
   * depending on the type of the context.
   * This method tries to find the appropriate Object that should be used in this navigation.
   * @param context_p a potentially null Object. 
   * @return a potentially null Object
   */
  protected Object adaptContext(Object context_p) {
    Object context = context_p;
    if (context instanceof Collection)
      context = ((Collection<?>) context).iterator().next();
    if (context instanceof EditPart)
      context = ((EditPart)context).getModel();
    if (context instanceof ResourceSet){
      if (!((ResourceSet)context).getResources().isEmpty())
        context = ((ResourceSet)context).getResources().get(0);
    }
    if (context instanceof Resource){
      if (!((Resource)context).getContents().isEmpty())
        context = ((Resource)context).getContents().get(0);
    }
    return context;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#asyncExecute(org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation)
   */
  public void asyncExecute(IModelOperation<?> operation_p) {
    if (operation_p instanceof AbstractModelOperation<?>)
      ((AbstractModelOperation<?>)operation_p).setModelEnvironment(this);
    ModelAccessJob job = new ModelAccessJob(operation_p);
    job.schedule();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#createPatternCatalogResource(org.eclipse.emf.common.util.URI)
   */
  public Resource createPatternCatalogResource(URI uri) {
    return new DefaultPatternsXMIResource(uri);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#execute(org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation)
   */
  public <E> E execute(final IModelOperation<E> operation_p) {
    if (operation_p instanceof AbstractModelOperation){
      Object context = null;
      EditingDomain domain = null;
      if (operation_p instanceof SiriusCreatePatternAndInstanceOperation) {
        SiriusCreatePatternAndInstanceOperation sop = (SiriusCreatePatternAndInstanceOperation)operation_p;
        context = adaptContext(sop.getPatternSideContext());
      } else {
        AbstractModelOperation<E> op = (AbstractModelOperation<E>)operation_p;
        op.setModelEnvironment(this);
        context = adaptContext(op.getTargetContext());
      }
      if (context instanceof EditingDomain)
        domain = (EditingDomain)context;
      if(domain == null)
        if(context instanceof IPatternInstanceMarker) //is a pattern catalog context
          domain = AdapterFactoryEditingDomain.getEditingDomainFor(context);
        else if(context instanceof AbstractIdentifiedElement) //is a pattern catalog context
          domain = getEditingDomain((AbstractIdentifiedElement)context);
        else
          domain = AdapterFactoryEditingDomain.getEditingDomainFor(context);
      if (domain instanceof TransactionalEditingDomain){
        OperationWithResultCommand<E> cmd = new OperationWithResultCommand<E>(domain.getResourceSet(), operation_p);
        domain.getCommandStack().execute(cmd);
        return cmd.getOperationResult();
      }}
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getCommonCatalogEditingDomain()
   */
  public TransactionalEditingDomain getCommonCatalogEditingDomain(){
    return _patternCatalogCommonEditingDomain;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getInverseCrossReferencer(org.eclipse.emf.ecore.EObject)
   */
  public ECrossReferenceAdapter getInverseCrossReferencer(EObject element_p) {
    ECrossReferenceAdapter result = null;
    if (element_p != null) {
      Session session = SessionManager.INSTANCE.getSession(element_p);
      if (session != null)
        result = session.getSemanticCrossReferencer();
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getOverridenClasses()
   */
  public Collection<? extends Class<?>> getOverridenClasses() {
    List<Class<?>> lst = new ArrayList<Class<?>>();
    lst.add(DefaultModelEnvironment.class);
    return lst;
  }
  
  
  /**
   * A command that wraps an operation and provides a result.
   */
  private class OperationWithResultCommand<E> extends ChangeCommand{
    /** The non-null operation to execute*/
    private IModelOperation<E> _operation;
    /** The potentially null result of the operation */
    private E _result = null;
    /**
     * Constructor
     * @param recordSet_p a non-null resource set
     * @param operation_p a non-null operation to execute
     */
    protected OperationWithResultCommand(ResourceSet recordSet_p, IModelOperation<E> operation_p) {
      super(recordSet_p);
      _operation = operation_p;
    }
    /**
     * @see org.eclipse.emf.edit.command.ChangeCommand#doExecute()
     */
    @Override
    protected void doExecute() {
      _result = _operation.run(null);
    }
    /**
     * Return the result of the execution of the operation
     * @return a potentially null object
     */
    public E getOperationResult(){
      return _result;
    }
  }
  
}
