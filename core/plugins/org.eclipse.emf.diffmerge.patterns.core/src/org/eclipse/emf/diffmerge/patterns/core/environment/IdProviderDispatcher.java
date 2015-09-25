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
package org.eclipse.emf.diffmerge.patterns.core.environment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A provider of ID-based services. 
 * The priority is always given to the viewpoint contributed services.
 * @author Skander Turki
 */
public class IdProviderDispatcher implements IIdProvider{
  
  /** List of all contributing ID providers */
  private List<IIdProvider> _IDProviders;
  
  /** ID related to the IdProvider extension point */
  private static final String ID_PROVIDER_EXTENSION_POINT =
    "org.eclipse.emf.diffmerge.patterns.core.idProvider"; //$NON-NLS-1$
  /** ID related to the IdProvider extension point */
  private static final String ID_PROVIDER_EXTENSION_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  
  /**
   * Constructor.
   */
  public IdProviderDispatcher(){
    _IDProviders = discoverRegisteredIDProviders();
  }
  
  /**
   * Discover the ID providers which are registered through the dedicated
   * extension point, if any
   * @return a non-null, non-empty, unmodifiable list
   */
  private List<IIdProvider> discoverRegisteredIDProviders() {
    List<IIdProvider> result = new ArrayList<IIdProvider>();
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        ID_PROVIDER_EXTENSION_POINT);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(
            ID_PROVIDER_EXTENSION_POINT_PROPERTY);
        if (o instanceof IIdProvider)
          result.add((IIdProvider)o);
      } catch (CoreException ex) {
        //Nothing
      } catch (Exception iex) {
        System.out.println(iex.getMessage());
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Return a default new unique ID for a model element
   * @return a non-null string
   */
  protected String getDefaultNewId() {
	  return EcoreUtil.generateUUID();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getNewIdFor(org.eclipse.emf.ecore.EObject)
   */
  public String getNewIdFor(EObject element_p) {
    String result;
    IIdProvider mainProvider = null;
    for(IIdProvider provider : _IDProviders){
      if(provider.isMainModel()){
        mainProvider = provider;
      }else{
        if(provider.isApplicableTo(element_p)){
          result = provider.getNewIdFor(element_p);
          if(result != null) return result;
        } 
      }
    }
    if(mainProvider != null){
      if(mainProvider.isApplicableTo(element_p)){
        result = mainProvider.getNewIdFor(element_p);
        if(result != null) return result;
      }   
    }
    return getDefaultNewId();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getId(org.eclipse.emf.ecore.EObject, org.eclipse.emf.edit.domain.EditingDomain)
   */
  public String getId(EObject element_p, EditingDomain editingDomain_p) {
    String result;
    IIdProvider mainProvider = null;
    for(IIdProvider provider : _IDProviders){
      if(provider.isMainModel()){
        mainProvider = provider;
      }else{
        if(provider.isApplicableTo(element_p)){
          result = provider.getId(element_p, editingDomain_p);
          if(result != null) return result;
        }
      }
    }
    if(mainProvider != null){
      if(mainProvider.isApplicableTo(element_p)){
        result = mainProvider.getId(element_p, editingDomain_p);
        return result;
      }
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getById(java.lang.String, java.util.Collection)
   */
  public EObject getById(String id_p, Collection<? extends Resource> scope_p) {
    EObject result;
    IIdProvider mainProvider = null;
    for(IIdProvider provider : _IDProviders){
      if(provider.isMainModel()){
        mainProvider = provider;
      }else{
        result = provider.getById(id_p, scope_p);
        if(result != null) return result;
      }
    }
    if(mainProvider != null){
      result = mainProvider.getById(id_p, scope_p);
      if(result != null) return result;
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getByIdInContext(java.lang.String, java.lang.Object)
   */
  public EObject getByIdInContext(String id_p, Object context_p) {
    EObject result;
    IIdProvider mainProvider = null;
    for(IIdProvider provider : _IDProviders){
      if(provider.isMainModel()){
        mainProvider = provider;
      }else{
        result = provider.getByIdInContext(id_p, context_p);
        if(result != null) return result;
      }
    }
    if(mainProvider != null){
      result = mainProvider.getByIdInContext(id_p, context_p);
      if(result != null) return result;
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getByIdInResource(java.lang.String, org.eclipse.emf.ecore.EObject)
   */
  public EObject getByIdInResource(String id_p, EObject context_p) {
    EObject result;
    IIdProvider mainProvider = null;
    for(IIdProvider provider : _IDProviders){
      if(provider.isMainModel()){
        mainProvider = provider;
      }else{
        result = provider.getByIdInResource(id_p, context_p);
        if(result != null) return result;
      }
    }
    if(mainProvider != null){
      result = mainProvider.getByIdInResource(id_p, context_p);
      if(result != null) return result;
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#isApplicableTo(org.eclipse.emf.ecore.EObject)
   */
  public boolean isApplicableTo(EObject element_p) {
    boolean result;
    for(IIdProvider provider : _IDProviders){
      result = provider.isApplicableTo(element_p);
      if(result == true) return result;
    }
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#isMainModel()
   */
  public boolean isMainModel() {
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#requiresNewIntrinsicID(org.eclipse.emf.ecore.EObject, java.lang.Object)
   */
  public boolean requiresNewIntrinsicID(EObject element_p, Object scope_p) {
    for(IIdProvider provider : _IDProviders){
      if(provider.isApplicableTo(element_p))
      return provider.requiresNewIntrinsicID(element_p, scope_p);
    }
    return false;
  }
  
}
