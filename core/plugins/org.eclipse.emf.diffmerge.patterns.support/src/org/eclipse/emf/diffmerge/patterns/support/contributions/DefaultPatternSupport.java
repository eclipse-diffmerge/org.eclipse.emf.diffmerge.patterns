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
package org.eclipse.emf.diffmerge.patterns.support.contributions;

import static org.eclipse.emf.diffmerge.patterns.support.gen.CommonPatternSupportAdapter.COMMON_PATTERN_SUPPORT_ADAPTER;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.diffmerge.patterns.support.environment.DefaultModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstanceSet;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;


/**
 * A default pattern support that provides a partial implementation of IPatternSupport.
 * Methods related to how the instance model is stored aren't implemented.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class DefaultPatternSupport implements IPatternSupport {

  /**
   * Return the instance set in which instances would be stored in the given resource,
   * creating it if required and needed
   * @param resource_p a non-null resource
   * @param createIfAbsent_p whether the instance set should be created if absent
   * @return a pattern instance set extension, non-null if createIfAbsent is true
   */
  protected abstract CommonPatternInstanceSet getInstanceSet(
      Resource resource_p, boolean createIfAbsent_p);

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#isApplicableTo(org.eclipse.emf.ecore.EObject)
   */
  public boolean isApplicableTo(EObject element_p) {
    IModelEnvironment environment = new DefaultModelEnvironment();
    return (element_p instanceof CommonPatternInstance ||
        environment.isModelElement(element_p));
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#isApplicableTo(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   */
  public boolean isApplicableTo(IPatternApplication application_p) {
    Collection<IAtomicLocation> locations = getAtomicLocations(application_p);
    for (IAtomicLocation location : locations) {
      if (location instanceof IElementRelativeLocation) {
        IElementRelativeLocation castedLocation = (IElementRelativeLocation)location;
        if (isApplicableTo(castedLocation.getElement()))
          return true;
      }
    }
    if(application_p.getScopeElement() instanceof EObject)
      if (isApplicableTo((EObject)application_p.getScopeElement()))
        return true;
    return false;
  }


  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#createInstance(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   */
  public CommonPatternInstance createInstance(IPatternApplication application_p) {
    CommonPatternInstance result =
        CommonpatternsupportFactory.eINSTANCE.createCommonPatternInstance();
    result.setFolded(true);
    IPattern pattern = application_p.getPattern();
    // Pattern version
    PatternSymbol patternSymbol = COMMON_PATTERN_SUPPORT_ADAPTER.adapt(pattern.getSymbol());
    PatternVersion patternVersion = CorepatternsFactory.eINSTANCE.createPatternVersion();
    patternVersion.setPatternSymbol(patternSymbol);
    patternVersion.setVersion(pattern.getVersion());
    result.setPatternVersion(patternVersion);
    // Role bindings
    for (IPatternRole role : pattern.getRoles()) {
      ILocation location = application_p.getLocation(role);
      setLocation(role, result, location);
    }
    // Storage
    storeOwnInstance(result, application_p.getScopeElement());
    // Pattern data
    pattern.createDataFor(result, application_p.getScopeElement());
    return result;
  }

  /**
   * Return the instance set which corresponds to the scope of the given contextual object
   * @param context_p a non-null object
   * @return a non-null pattern instance set extension
   */
  protected CommonPatternInstanceSet getCreateInstanceSet(
      Object context_p) {
    Resource resource = getResourceForStorage(context_p);
    assert resource != null; // Otherwise pattern instance is ill-formed
    return getInstanceSet(resource, true);
  }

  /**
   * Return the resource in which the instance set for the given context should be stored
   * @param context_p a non-null object (Resource or EObject)
   * @return a non-null resource if context_p is related to a resource
   */
  protected Resource getResourceForStorage(Object context_p) {
    Resource result = null;
    if (context_p instanceof EObject)
      result = EcoreUtil.getRootContainer((EObject)context_p).eResource();
    else if (context_p instanceof Resource)
      result = (Resource)context_p;
    return result;
  }

  /**
   * Return the resource in which an instance encompassing the given element would
   * be stored
   * @param element_p a non-null element
   * @return a resource, which is non-null if the element has a resource
   *  and this pattern support is applicable to the element
   */
  protected Resource getResourceForStorageFromElement(EObject element_p) {
    Resource result = null;
    if (isApplicableTo(element_p)) {
      EObject root = EcoreUtil.getRootContainer(element_p);
      result = root.eResource();
    }
    return result;
  }


  /**
   * Store a fully built, well-formed pattern instance
   * @param instance_p a non-null pattern instance
   * @param context_p a non-null object
   * @return whether the operation succeeded
   */
  protected boolean storeOwnInstance(CommonPatternInstance instance_p, Object context_p) {
    boolean result = false;
    CommonPatternInstanceSet instanceSet = getCreateInstanceSet(context_p);
    if (instanceSet != null) {
      instanceSet.getOwnedInstances().add(instance_p);
      result = true;
    }
    return result;
  }


  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#getAllInstances(java.lang.Object)
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<IPatternInstance> getAllInstances(Object context_p) {
    List<IPatternInstance> result = Collections.emptyList();
    Resource resource = getResourceForStorage(context_p);
    if (resource != null) {
      CommonPatternInstanceSet instanceSet = getInstanceSet(resource, false);
      if (instanceSet != null) {
        result = (List)instanceSet.getOwnedInstances();
        result = Collections.unmodifiableList(result);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#getRelatedInstances(org.eclipse.emf.ecore.EObject)
   */
  public List<IPatternInstance> getRelatedInstances(EObject element_p) {
    List<IPatternInstance> result = getRelatedInstancesFromElement(element_p);
    return result;
  }

  /**
   * Return the set of instances in which the given element is involved
   * @param element_p a non-null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  protected List<IPatternInstance> getRelatedInstancesFromElement(EObject element_p) {
    List<IPatternInstance> result = new ArrayList<IPatternInstance>();
    Resource storageResource = getResourceForStorageFromElement(element_p);
    if (storageResource != null) {
      CommonPatternInstanceSet instanceSet = getInstanceSet(storageResource, false);
      if (instanceSet != null) {
        for (IPatternInstance instance : instanceSet.getOwnedInstances()) {
          // Search by role
          if (LocationsUtil.getRoleElements(instance).contains(element_p)) {
            result.add(instance);
          } else {
            // Search by pattern data
            IPatternData data = instance.getPatternData();
            if (data instanceof IPatternBasedBijection) {
              IPatternBasedBijection bijection = (IPatternBasedBijection)data;
              if (bijection.covers(element_p, false))
                result.add(instance);
            }
          }
        }
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#hasRelatedInstances(org.eclipse.emf.ecore.EObject)
   */
  public boolean hasRelatedInstances(EObject element_p) {
    Resource storageResource = getResourceForStorageFromElement(element_p);
    if (storageResource != null) {
      CommonPatternInstanceSet instanceSet = getInstanceSet(storageResource, false);
      if (instanceSet != null) {
        for (IPatternInstance instance : instanceSet.getOwnedInstances()) {
          // Search by role
          if (LocationsUtil.getRoleElements(instance).contains(element_p))
            return true;
          // Search by pattern data
          IPatternData data = instance.getPatternData();
          if (data instanceof IPatternBasedBijection) {
            IPatternBasedBijection bijection = (IPatternBasedBijection)data;
            if (bijection.covers(element_p, false))
              return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport#storeInstance(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.lang.Object)
   */
  public boolean storeInstance(IPatternInstance instance_p, Object context_p) {
    boolean result = false;
    if (instance_p instanceof CommonPatternInstance)
      result = storeOwnInstance((CommonPatternInstance)instance_p, context_p);
    return result;
  }



  /**
   * Return the atomic locations bound by the given pattern application
   * @param application_p a non-null pattern application
   * @return a non-null, potentially empty, unmodifiable collection
   */
  protected Collection<IAtomicLocation> getAtomicLocations(IPatternApplication application_p) {
    Collection<IAtomicLocation> result = new ArrayList<IAtomicLocation>();
    Collection<? extends ILocation> locations = application_p.getLocations();
    for (ILocation location : locations) {
      result.addAll(location.getAtomicContents());
    }
    return Collections.unmodifiableCollection(result);
  }

  /**
   * Set the given location for the given role to the given instance
   * @param role_p a non-null role
   * @param instance_p a non-null pattern instance
   * @param location_p a potentially null location
   */
  protected void setLocation(IPatternRole role_p, CommonPatternInstance instance_p,
      ILocation location_p) {
    if (location_p != null) {
      AbstractLocation mdeLocation = COMMON_PATTERN_SUPPORT_ADAPTER.adapt(location_p, role_p.getPattern());
      instance_p.setLocation(role_p, mdeLocation);
    }
  }

}
