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
package org.eclipse.emf.diffmerge.patterns.support.contributions;

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * A basic pattern support that handles the instances model as an independent resource having the same
 * name and location as the model resource with a specific extension.
 * By default, we assume that the resource(s) containing the model and the resource containing the
 * pattern instances are in the same resource set. If this is not the case, this class must be extended. 
 * @author Skander Turki
 */
public class BasicPatternSupport extends DefaultPatternSupport{
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.support.contributions.basic.DefaultPatternSupport#getInstanceSet(org.eclipse.emf.ecore.resource.Resource, boolean)
   */
  @Override
  protected CommonPatternInstanceSet getInstanceSet(Resource resource_p,
      boolean createIfAbsent_p) {
    CommonPatternInstanceSet result = null;
    if(resource_p != null){
      if(resource_p.getURI().fileExtension().equals("patterninstances")){ //$NON-NLS-1$
        if(resource_p.getContents().isEmpty()){
          CommonPatternInstanceSet set = CommonpatternsupportFactory.eINSTANCE.createCommonPatternInstanceSet();
          resource_p.getContents().add(set);
          ResourcesUtil.makePersistent(resource_p);
          return set;
        }
        if(resource_p.getContents().get(0) instanceof CommonPatternInstanceSet){
          return (CommonPatternInstanceSet) resource_p.getContents().get(0);
        }
      }else{
        IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
        if(env!=null && env.isModelResource(resource_p)){
          result = (CommonPatternInstanceSet) env.getOrCreateInstanceSetForModelResource(resource_p);
        }
      }
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.support.contributions.basic.DefaultPatternSupport#storeOwnInstance(org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance, java.lang.Object)
   */
  @Override
  protected boolean storeOwnInstance(CommonPatternInstance instance_p, Object context_p) {
    CommonPatternInstanceSet instanceSet = getCreateInstanceSet(context_p);
    if (instanceSet != null) {
      instanceSet.getOwnedInstances().add(instance_p);
//      try {
//        instanceSet.eResource().save(null);
//      } catch (IOException e) {
//        e.printStackTrace();
//        return false;
//      }
      return true;
    }
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.support.contributions.basic.DefaultPatternSupport#getResourceForStorage(java.lang.Object)
   */
  @Override
  protected Resource getResourceForStorage(Object context_p) {
    Resource modelResource = null;
    if (context_p instanceof EObject)
      modelResource = EcoreUtil.getRootContainer((EObject)context_p).eResource();
    else if (context_p instanceof Resource)
      modelResource = (Resource)context_p;
    IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
    if(env!=null && env.isModelResource(modelResource)){
      return ((CommonPatternInstanceSet)(env.getOrCreateInstanceSetForModelResource(modelResource))).eResource();
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.support.contributions.basic.DefaultPatternSupport#isApplicableTo(org.eclipse.emf.ecore.EObject)
   */
  @Override
  public boolean isApplicableTo(EObject element_p) {
    IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
    if(env != null){
      return element_p instanceof CommonPatternInstance ||
          env.isModelElement(element_p);
    }
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.support.contributions.basic.DefaultPatternSupport#isApplicableTo(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   */
  @Override
  public boolean isApplicableTo(IPatternApplication application_p) {
    Collection<IAtomicLocation> locations = getAtomicLocations(application_p);
    for (IAtomicLocation location : locations) {
      if (location instanceof IElementRelativeLocation) {
        IElementRelativeLocation castedLocation = (IElementRelativeLocation)location;
        if (isApplicableTo(castedLocation.getElement()))
          return true;
      }
    }
    return false;
  }
  
  /**
   * By default, we assume that the resource(s) containing the model and the resource containing the pattern instances 
   * are in the same resource set. If this is not the case, this method must be redefined. 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#getModelResource(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker)
   */
  public Resource getModelResource(IPatternInstanceMarker instancesEncoder_p) {
    CommonPatternInstanceSet set = null;
    if(instancesEncoder_p instanceof CommonPatternInstanceSet){
      set = (CommonPatternInstanceSet)instancesEncoder_p;
    }else if(instancesEncoder_p instanceof CommonPatternInstance){
      set = (CommonPatternInstanceSet)((CommonPatternInstance)instancesEncoder_p).eContainer();
    }
    if(set != null){
      IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
      if(env != null){
        return env.getModelResourceFromInstanceSet(set);   
      }
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#getPatternInstanceEncodingModel(org.eclipse.emf.ecore.EObject)
   */
  public IPatternInstanceMarker getPatternInstanceEncodingModel(
      EObject context_p) {
    return getPatternInstanceEncodingModel(context_p.eResource());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#getPatternInstanceEncodingModel(org.eclipse.emf.ecore.resource.Resource)
   */
  public IPatternInstanceMarker getPatternInstanceEncodingModel(
      Resource context_p) {
    IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
    if(env != null){
      return env.getOrCreateInstanceSetForModelResource(context_p);   
    }
    return null;
  }
  
}
