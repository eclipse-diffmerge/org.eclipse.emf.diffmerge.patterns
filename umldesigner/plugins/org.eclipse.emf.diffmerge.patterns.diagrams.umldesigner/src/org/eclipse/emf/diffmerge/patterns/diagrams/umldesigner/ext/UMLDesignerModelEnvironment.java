/*********************************************************************
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.ext;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.util.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.extensions.AbstractSiriusModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogResourceHelper;
import org.eclipse.emf.diffmerge.patterns.support.contributions.BasicPatternSupport;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.resource.UMLResource;


/**
 * A model environment for UMLDesigner.
 * @author Skander Turki
 */
public class UMLDesignerModelEnvironment extends AbstractSiriusModelEnvironment {
  
  /**
   * Constructor
   */
  public UMLDesignerModelEnvironment() {
    super();
  }
  
  /**
   * Create and return an instance set located in a resource of the given URI in the given
   * resource set
   * @param uri_p a non-null URI
   * @param resourceSet_p a non-null resource set
   * @return a potentially null instance set
   */
  protected CommonPatternInstanceSet createInstanceSet(final URI uri_p, ResourceSet resourceSet_p) {
    CommonPatternInstanceSet result = null;
    resourceSet_p.getPackageRegistry().put(
        CommonpatternsupportPackage.eNS_URI, CommonpatternsupportPackage.eINSTANCE);
    AbstractModelOperation<Object> operation = new AbstractModelOperation<Object>(
        "Create Instance Set Operation", resourceSet_p, false, false, true, resourceSet_p, resourceSet_p){ //$NON-NLS-1$
      /**
       * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
       */
      @Override
      protected Object run() {
        Resource resource = getResourceSet().createResource(uri_p);
        CommonPatternInstanceSet set =
            CommonpatternsupportFactory.eINSTANCE.createCommonPatternInstanceSet();
        resource.getContents().add(set);
        ResourcesUtil.makePersistent(resource);
        return set;
      }
    };
    CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
    if(!resourceSet_p.getResources().isEmpty()){
      for(Resource res : resourceSet_p.getResources()){
        if(!res.getContents().isEmpty() &&
            res.getContents().get(0) instanceof CommonPatternInstanceSet){
          result = (CommonPatternInstanceSet) res.getContents().get(0);
          break;
        }
      }
    }
    return result;
  }
  
  /**
   * Ensure that the given instance set is covered by the Sirius session that encompasses
   * a resource of the given URI, if any
   * @param instanceSet_p a non-null instance set
   * @param uri_p a non-null URI
   */
  protected void ensureInSession(CommonPatternInstanceSet instanceSet_p, URI uri_p) {
    Resource instanceSetResource = instanceSet_p.eResource();
    Session session = getExistingSession(uri_p);
    if (session != null && !session.getSemanticResources().contains(instanceSetResource)) {
      AddSemanticResourceCommand command = new AddSemanticResourceCommand(
          session, instanceSetResource.getURI(), new NullProgressMonitor());
      session.getTransactionalEditingDomain().getCommandStack().execute(command);
    }
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getEditingDomain(org.eclipse.emf.ecore.EObject)
   */
  public EditingDomain getEditingDomain(EObject context_p) {
    if(context_p instanceof IIdentifiedElement) {
      return getCommonCatalogEditingDomain();
    }
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
        return getCommonCatalogEditingDomain();
      }
      domain = getExistingEditingDomain(file_p);
    }
    return domain;
  }
  
  /**
   * Try to find an existing editing domain for the given IFile
   * @param file_p a potentially null IFile
   * @return a potentially null editing domain
   */
  protected EditingDomain getExistingEditingDomain(IFile file_p) {
    EditingDomain result = null;
    if(file_p != null){
      URI fileUri = URI.createURI(file_p.getFullPath().toString());
      Session existingSession = getExistingSession(fileUri);
      if (existingSession != null) {
        result = existingSession.getTransactionalEditingDomain();
      }
    }
    return result;
  }
  
  /**
   * Try to find an existing session for the given URI
   * @param uri_p a non-null URI
   * @return a potentially null session
   */
  protected Session getExistingSession(URI uri_p) {
    Session result = null;
      Collection<Session> sessions = SessionManager.INSTANCE.getSessions();
      for(Session session : sessions){
        EditingDomain candidate = session.getTransactionalEditingDomain();
        Resource res = candidate.getResourceSet().getResource(uri_p, false);
        if(res != null){
          result = session;
          break;
        }
      }
    return result;
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
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#isAppropriatePatternSupport(org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport)
   */
  public boolean isAppropriatePatternSupport(IPatternSupport support_p) {
    return support_p instanceof BasicPatternSupport;
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
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getOrCreateInstanceSetForModelResource(org.eclipse.emf.ecore.resource.Resource)
   */
  public IPatternInstanceMarker getOrCreateInstanceSetForModelResource(
      Resource resource_p) {
    CommonPatternInstanceSet result = null;
    if(resource_p != null){
      ResourceSet modelRSet = resource_p.getResourceSet();
      modelRSet.getPackageRegistry().put(
          CommonpatternsupportPackage.eNS_URI, CommonpatternsupportPackage.eINSTANCE);
      final URI insResURI = URI.createURI(
          resource_p.getURI().trimFileExtension().toString() + "." + CommonpatternsupportPackage.eNAME); //$NON-NLS-1$
      try {
        Resource patRes = modelRSet.getResource(insResURI, true);
        patRes.load(null);
        if(!patRes.getContents().isEmpty() &&
            patRes.getContents().get(0) instanceof CommonPatternInstanceSet){
          result = (CommonPatternInstanceSet)patRes.getContents().get(0);
        }
      } catch (IllegalStateException e) {
        //continue;
        e.printStackTrace();
      } catch (Exception e) {
        //continue;
      }
      if (result == null) {
        result = createInstanceSet(insResURI, modelRSet);
      }
      if (result != null) {
        ensureInSession(result, resource_p.getURI());
      }
    }
    return result;
  }
  
  /**
   * Load the given file into the editing domain of the common catalog
   * @param file_p a non-null file
   */
  protected Resource loadCatalog(IFile file_p) {
    Resource res = null;
    @SuppressWarnings("deprecation")
    URI uri = URI.createPlatformResourceURI(file_p.getFullPath().toString());
    ResourceSet rset = getCommonCatalogEditingDomain().getResourceSet();
    if(rset!= null){  
      res = rset.getResource(uri, true);
    } 
    return res;
  }
  
}
