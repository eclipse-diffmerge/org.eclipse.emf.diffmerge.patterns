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
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.util.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations.SiriusCreatePatternAndInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogResourceHelper;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.CreateCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.OpenCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.support.contributions.BasicPatternSupport;
import org.eclipse.emf.diffmerge.patterns.support.environment.DefaultModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.diffmerge.patterns.support.resources.DefaultPatternsXMIResource;
import org.eclipse.emf.diffmerge.ui.EMFDiffMergeUIPlugin;
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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.resource.UMLResource;


/**
 * A model environment for UMLDesigner.
 * @author Skander Turki
 */
public class UMLDesignerModelEnvironment implements IModelEnvironment{

  private TransactionalEditingDomain _patternCatalogCommonEditingDomain;
  private static String CATALOG_COMMON_EDITING_DOMAIN_ID = "Catalogs_Common_Editing_Domain"; //$NON-NLS-1$


  /**
   * Constructor
   */
  public UMLDesignerModelEnvironment() {
    ResourceSet rset = new ResourceSetImpl();
    _patternCatalogCommonEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
    _patternCatalogCommonEditingDomain.setID(CATALOG_COMMON_EDITING_DOMAIN_ID);
    if (_patternCatalogCommonEditingDomain instanceof AdapterFactoryEditingDomain)
      ((AdapterFactoryEditingDomain) _patternCatalogCommonEditingDomain).setAdapterFactory(
          EMFDiffMergeUIPlugin.getDefault().getAdapterFactoryLabelProvider().getAdapterFactory());
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#abortOperation()
   */
  public void abortOperation() {
    throw new OperationCanceledException();
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
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#execute(org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation)
   */
  public <E> E execute(final IModelOperation<E> operation_p) {
    if (operation_p instanceof AbstractModelOperation){
      Object context = null;
      EditingDomain domain = null;

      // List<Resource> hackedResources = new ArrayList<Resource>();
      if(operation_p instanceof CreateCatalogOperation){
        CreateCatalogOperation cop = (CreateCatalogOperation)operation_p;
        if(cop.getTargetContext() instanceof TransactionalEditingDomain)
          domain = (EditingDomain) cop.getTargetContext();
      } if(operation_p instanceof OpenCatalogOperation){
        OpenCatalogOperation oop = (OpenCatalogOperation)operation_p;
        if(oop.getTargetContext() instanceof TransactionalEditingDomain)
          domain = (EditingDomain) oop.getTargetContext();
      } else if(operation_p instanceof SiriusCreatePatternAndInstanceOperation) {
        SiriusCreatePatternAndInstanceOperation sop = (SiriusCreatePatternAndInstanceOperation)operation_p;
        context = adaptContext(sop.getPatternSideContext());
      } else {
        AbstractModelOperation<E> op = (AbstractModelOperation<E>)operation_p;
        op.setModelEnvironment(this);
        context = adaptContext(op.getTargetContext());
      }
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
   * The navigation to the editing domain associated with the context is realized differently depending on the type of the context.
   * This method tries to find the appropriate Object that should be used in this navigation.
   * @param context a potentially null Object. 
   * @return a potentially null Object
   */
  private Object adaptContext(Object context_p) {
    Object context = context_p;
    if(context instanceof EObject)
      return context;
    if(context instanceof ResourceSet){
      if(!((ResourceSet)context).getResources().isEmpty())
        context = ((ResourceSet)context).getResources().get(0);
    }
    if(context instanceof Resource){
      if(!((Resource)context).getContents().isEmpty())
        context = ((Resource)context).getContents().get(0);
    }
    if(context instanceof Collection){
      context = ((Collection<?>) context).iterator().next();
    }
    if(context instanceof EditPart){
      context = ((EditPart)context).getModel();
    }
    return context;
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
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#isModelResource(org.eclipse.emf.ecore.resource.Resource)
   */
  public boolean isModelResource(Resource resource_p) {
    return resource_p instanceof UMLResource;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#isModelElement(java.lang.Object)
   */
  public boolean isModelElement(Object object_p) {
    return object_p instanceof CommonPatternInstance ||
        object_p instanceof Element;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getModelResourceFromInstanceSet(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker)
   */
  public Resource getModelResourceFromInstanceSet(IPatternInstanceMarker set_p) {
    if(set_p instanceof CommonPatternInstanceSet){
      CommonPatternInstanceSet set = (CommonPatternInstanceSet)set_p;
      URI modelUri = URI.createURI(set.eResource().getURI().trimFileExtension().toString() + "." + "uml"); //$NON-NLS-1$ //$NON-NLS-2$
      // Instance set and user model are assumed to belong to the same resource set
      if (set_p instanceof EObject) {
        Resource resource = ((EObject)set_p).eResource();
        if(resource != null){
          ResourceSet modelRSet = resource.getResourceSet();
          if(modelRSet != null){
            for(Resource res : modelRSet.getResources()){
              if(res.getURI()!= null && res.getURI().toPlatformString(true)!= null 
                  && res.getURI().toString().equals(modelUri.toString())){
                return res;
              }
            }
          }
        }
      }    
    }
    return null;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getOrCreateInstanceSetForModelResource(org.eclipse.emf.ecore.resource.Resource)
   */
  public IPatternInstanceMarker getOrCreateInstanceSetForModelResource(
      Resource resource_p) {
    if(resource_p != null){
      ResourceSet modelRSet = resource_p.getResourceSet();
      modelRSet.getPackageRegistry().put(CommonpatternsupportPackage.eNS_URI, CommonpatternsupportPackage.eINSTANCE);
      final URI insResURI = URI.createURI(resource_p.getURI().trimFileExtension().toString() + "." + CommonpatternsupportPackage.eNAME); //$NON-NLS-1$
      Resource patRes = null;
      try {
        patRes = modelRSet.getResource(insResURI, true);
        patRes.load(null);
        if(!patRes.getContents().isEmpty() && (patRes.getContents().get(0) instanceof CommonPatternInstanceSet)){
          return (CommonPatternInstanceSet)patRes.getContents().get(0);
        }
      } catch (IllegalStateException e) {
        //continue;
        e.printStackTrace();
      } catch (Exception e) {
        //continue;
      }
      //Not found: Create a new one

      modelRSet.getPackageRegistry().put(CommonpatternsupportPackage.eNS_URI, CommonpatternsupportPackage.eINSTANCE);
      AbstractModelOperation<Object> operation = new AbstractModelOperation<Object>(
          "Create Instance Set Operation", modelRSet, false, false, true, modelRSet, modelRSet){ //$NON-NLS-1$
        /**
         * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
         */
        @Override
        protected Object run() {
          Resource resource = getResourceSet().createResource(insResURI);
          CommonPatternInstanceSet set = CommonpatternsupportFactory.eINSTANCE.createCommonPatternInstanceSet();
          resource.getContents().add(set);
          ResourcesUtil.makePersistent(resource);
          return set;
        }

      };
      CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
      if(!modelRSet.getResources().isEmpty()){
        for(Resource res : modelRSet.getResources()){
          if(!res.getContents().isEmpty() && (res.getContents().get(0) instanceof CommonPatternInstanceSet)){
            return (CommonPatternInstanceSet) res.getContents().get(0);
          }
        }
      }
    }
    return null;
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
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#createPatternCatalogResource(org.eclipse.emf.common.util.URI)
   */
  public Resource createPatternCatalogResource(URI uri) {
    return new DefaultPatternsXMIResource(uri);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#isAppropriatePatternSupport(org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport)
   */
  public boolean isAppropriatePatternSupport(IPatternSupport o) {
    return o instanceof BasicPatternSupport;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getEditingDomain(org.eclipse.emf.ecore.EObject)
   */
  public EditingDomain getEditingDomain(EObject context_p) {
    if(context_p instanceof IIdentifiedElement)
      return _patternCatalogCommonEditingDomain;
    return AdapterFactoryEditingDomain.getEditingDomainFor(context_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getEditingDomain(org.eclipse.core.resources.IFile)
   */
  public EditingDomain getEditingDomain(IFile file_p) {
    EditingDomain domain = null;
    if(file_p != null){
      if(file_p.getFileExtension().equals(PatternCatalogResourceHelper.PATTERN_CATALOG_FILE_EXTENSION)){
        loadCatalog(file_p);
        return _patternCatalogCommonEditingDomain;
      }
      domain = getExistingEditingDomain(file_p);
    }
    return domain;
  }


  /**
   * Tries to find an existing editing domain for the given IFile
   * @param file_p a potentially null IFile
   * @return a potentially null editing domain
   */
  private EditingDomain getExistingEditingDomain(IFile file_p) {
    EditingDomain result = null;
    if(file_p != null){
      Collection<Session> sessions = SessionManager.INSTANCE.getSessions();
      for(Session session : sessions){
        EditingDomain candidate = session.getTransactionalEditingDomain();
        Resource res = candidate.getResourceSet().getResource(URI.createURI(file_p.getFullPath().toString()), true);
        if(res != null){
          result = candidate;
          break;
        }
      }
    }
    return result;
  }

  /**
   * load the given file into the common catalogs' editing domain
   * @param file_p a non-null file
   */
  private Resource loadCatalog(IFile file_p) {
    Resource res = null;
    @SuppressWarnings("deprecation")
    URI uri = URI.createPlatformResourceURI(file_p.getFullPath().toString());
    ResourceSet rset = getCommonCatalogEditingDomain().getResourceSet();
    if(rset!= null){  
      res = rset.getResource(uri, true);
    } 
    return res;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getCommonCatalogEditingDomain()
   */
  public TransactionalEditingDomain getCommonCatalogEditingDomain(){
    if(_patternCatalogCommonEditingDomain == null){
      ResourceSet rset = new ResourceSetImpl();
      _patternCatalogCommonEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
      _patternCatalogCommonEditingDomain.setID(CATALOG_COMMON_EDITING_DOMAIN_ID);
    }
    return _patternCatalogCommonEditingDomain; 
  }



  /**
   * An operation that supports undo/redo
   * @author Skander TURKI
   *
   * @param <E>
   */
  private class OperationWithResultCommand<E> extends ChangeCommand{

    /**
     * Constructor
     */
    protected OperationWithResultCommand(ResourceSet recordSet_p, IModelOperation<E>  operation_p) {
      super(recordSet_p);
      _operation = operation_p;
    }

    /** the operation to execute*/
    IModelOperation<E> _operation;

    /** result of the operation */
    E _result = null;


    /**
     * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
     */
    @Override
    protected void doExecute() {
      _result = _operation.run(null);
    }

    /**
     * @return result
     */
    public E getOperationResult(){
      return _result;
    }

  }


}
