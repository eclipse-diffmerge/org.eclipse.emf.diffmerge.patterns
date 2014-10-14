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
package org.eclipse.emf.diffmerge.patterns.support.environment;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.support.PatternSupportPlugin;
import org.eclipse.emf.diffmerge.patterns.support.contributions.BasicPatternSupport;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;
import org.eclipse.emf.diffmerge.patterns.support.resources.DefaultPatternsXMIResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


/**
 * A default model environment.
 * @see IModelEnvironment
 * @author Olivier Constant
 * @author Skander Turki
 */
public class DefaultModelEnvironment implements IModelEnvironment{
  
  /** The editing domain dedicated to pattern catalogs */
  private TransactionalEditingDomain _patternCatalogCommonEditingDomain;
  
  /** The ID suffix for the editing domain dedicated to pattern catalogs */
  private static String CATALOG_COMMON_EDITING_DOMAIN_ID_END = "Catalogs_Common_Editing_Domain"; //$NON-NLS-1$
  
  
  /**
   * Constructor
   */
  public DefaultModelEnvironment(){
    ResourceSet rset = new ResourceSetImpl();
    _patternCatalogCommonEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
    String edID = PatternSupportPlugin.getDefault().getPluginId() + '.' + CATALOG_COMMON_EDITING_DOMAIN_ID_END;
    _patternCatalogCommonEditingDomain.setID(edID);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#abortOperation()
   */
  public void abortOperation() {
    // Do nothing
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
  public <E> E execute(IModelOperation<E> operation_p) {
    if (operation_p instanceof AbstractModelOperation<?>)
      ((AbstractModelOperation<?>)operation_p).setModelEnvironment(this);
    return operation_p.run(null);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getEditingDomain(org.eclipse.emf.ecore.EObject)
   */
  public EditingDomain getEditingDomain(EObject context_p) {
    return AdapterFactoryEditingDomain.getEditingDomainFor(context_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getEditingDomain(org.eclipse.emf.ecore.EObject)
   */
  public EditingDomain getEditingDomain(IFile context_p) {
    return AdapterFactoryEditingDomain.getEditingDomainFor(context_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getInverseCrossReferencer(org.eclipse.emf.ecore.EObject)
   */
  public ECrossReferenceAdapter getInverseCrossReferencer(EObject element_p) {
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#isModelResource(org.eclipse.emf.ecore.resource.Resource)
   */
  public boolean isModelResource(Resource resource_p) {
    boolean result = true;
    URI uri = resource_p.getURI();
    if (uri != null) {
      String extension = uri.fileExtension();
      result = !EcorePackage.eNAME.equals(extension);
    }
    return result;
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#isModelElement(java.lang.Object)
   */
  public boolean isModelElement(Object object_p) {
    return object_p instanceof EObject;
  }
  
  /**
   * By default, the first resource that has the same name as the pattern instances resource 
   * with different file extensions, is returned, in the same resourceSet.
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getModelResourceFromInstanceSet(org.eclipse.emf.ecore.resource.ResourceSet, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker)
   */
  public Resource getModelResourceFromInstanceSet(IPatternInstanceMarker set_p) {
    if(set_p instanceof CommonPatternInstanceSet){
      CommonPatternInstanceSet set = (CommonPatternInstanceSet)set_p;
      ResourceSet rset = set.eResource().getResourceSet();
      if(rset != null){
        for(Resource res: rset.getResources()){
          if(!res.getURI().fileExtension().equals(CommonpatternsupportPackage.eNAME)
              && res.getURI().trimFileExtension().equals(set.eResource().getURI().trimFileExtension())){
            return res;
          }
        }
      }   
    }
    return null;
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getOrCreateInstanceSetForModelResource(org.eclipse.emf.ecore.resource.Resource)
   */
  public IPatternInstanceMarker getOrCreateInstanceSetForModelResource(Resource resource_p) {
    if(resource_p != null){
      ResourceSet rset = resource_p.getResourceSet();
      for(Resource res: rset.getResources()){
        if(res.getURI().fileExtension() != null && res.getURI().fileExtension().equals(CommonpatternsupportPackage.eNAME)
            && res.getURI().trimFileExtension().equals(resource_p.getURI().trimFileExtension())){
          if(res.getContents().get(0) instanceof CommonPatternInstanceSet)
            return (CommonPatternInstanceSet)res.getContents().get(0);
        }
      }
      //Not found: Create a new one
      URI modelURI = resource_p.getURI();
      @SuppressWarnings("deprecation")
      URI defaultInstanceSetURI = URI.createPlatformResourceURI(modelURI.trimFileExtension().toPlatformString(true)+ 
          "." + CommonpatternsupportPackage.eNAME); //$NON-NLS-1$


      rset.getPackageRegistry().put(CommonpatternsupportPackage.eNS_URI, CommonpatternsupportPackage.eINSTANCE);
      Resource resource = rset.createResource(defaultInstanceSetURI);
      CommonPatternInstanceSet newset = CommonpatternsupportFactory.eINSTANCE.createCommonPatternInstanceSet();
      resource.getContents().add(newset);
//      try {
//        resource.save(null);
//        return newset;
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#createPatternCatalogResource(org.eclipse.emf.common.util.URI)
   */
  public Resource createPatternCatalogResource(URI uri) {
    return new DefaultPatternsXMIResource(uri);
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#isAppropriatePatternSupport(org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport)
   */
  public boolean isAppropriatePatternSupport(IPatternSupport o) {
    return o instanceof BasicPatternSupport;
  }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getCommonCatalogEditingDomain()
   */
  public TransactionalEditingDomain getCommonCatalogEditingDomain(){
    return _patternCatalogCommonEditingDomain; 
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment#getOverridenClasses()
   */
  public Collection<? extends Class<?>> getOverridenClasses() {
    return new ArrayList<Class<?>>();
  }
  
}
