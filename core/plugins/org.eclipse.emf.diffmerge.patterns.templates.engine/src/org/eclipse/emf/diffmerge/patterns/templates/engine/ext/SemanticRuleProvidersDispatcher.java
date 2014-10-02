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
package org.eclipse.emf.diffmerge.patterns.templates.engine.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * A dispatcher of semantic rule providers. 
 * It delegates semantic rule provision to the appropriate semantic rule provider for each model element.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SemanticRuleProvidersDispatcher implements ISemanticRuleProvider{

  /** List of all contributing rule providers */
  private List<ISemanticRuleProvider> _semanticRuleProviders;

  /** IDs related to the SemanticRuleProvider extension point */
  private static final String SEMANTIC_RULE_PROVIDER_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.templates.engine.semanticRuleProvider"; //$NON-NLS-1$
  private static final String SEMANTIC_RULE_PROVIDER_EXTENSION_POINT_PROPERTY = "class"; //$NON-NLS-1$


  /**
   * Constructor.
   */
  public SemanticRuleProvidersDispatcher(){
    _semanticRuleProviders = discoverRegisteredSemanticRuleProviders();
  }

  /**
   * Discover the semantic rule providers which are registered through the dedicated
   * extension point, if any
   * @return a non-null, non-empty, unmodifiable list
   */
  private List<ISemanticRuleProvider> discoverRegisteredSemanticRuleProviders() {
    ISemanticRuleProvider mainRuleProvider = null;
    List<ISemanticRuleProvider> result = new ArrayList<ISemanticRuleProvider>();
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        SEMANTIC_RULE_PROVIDER_EXTENSION_POINT);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(
            SEMANTIC_RULE_PROVIDER_EXTENSION_POINT_PROPERTY);
        if (o instanceof ISemanticRuleProvider)
          if(!((ISemanticRuleProvider)o).isMainModel()){
            result.add((ISemanticRuleProvider)o);
          }else{
            mainRuleProvider = (ISemanticRuleProvider)o;
          }
      } catch (CoreException ex) {
        //Nothing
      } catch (Exception iex) {
        System.out.println(iex.getMessage());
      }
    }
    if(mainRuleProvider != null){
      result.add(0, mainRuleProvider);
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getElementsToRename(java.util.Collection)
   */
  public Collection<EObject> getElementsToRename(
      Collection<? extends EObject> elements_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      Collection<EObject> elems = provider.getElementsToRename(elements_p);
      if(elems != null)result.addAll(elems);
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getReferencesForAddition(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EClass, boolean, boolean)
   */
  public List<EReference> getReferencesForAddition(EObject element_p,
      EClass type, boolean b, boolean c) {
    List<EReference> result = new FOrderedSet<EReference>();
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      if(provider.isApplicableTo(element_p)){
        List<EReference> refs = provider.getReferencesForAddition(element_p, type, b, c);
        if(refs != null) result.addAll(refs);
      }
    }
    return result;
  }


  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#supportsAdditionOf(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, java.util.Collection, boolean)
   */
  public boolean supportsAdditionOf(EObject element_p, EReference reference_p,
      Collection<? extends EObject> values_p, boolean nonErasing_p) {
    boolean result = false;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.supportsAdditionOf(element_p, reference_p, values_p, nonErasing_p);
      if(result == true) return result;
    }
    return result;
  }


  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#supportsAdditionOf(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EObject, boolean)
   */
  public boolean supportsAdditionOf(EObject element_p, EReference reference_p,
      EObject value_p, boolean nonErasing_p) {
    boolean result = false;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.supportsAdditionOf(element_p, reference_p, value_p, nonErasing_p);
      if(result == true) return result;
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#ownershipMightBeDerived(org.eclipse.emf.ecore.EObject)
   */
  public boolean ownershipMightBeDerived(EObject root) {
    boolean result = false;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.ownershipMightBeDerived(root);
      if(result == true) return result;
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getOptionalMergeFeatures()
   */
  public Collection<? extends EStructuralFeature> getOptionalMergeFeatures() {
    List<EStructuralFeature> result = new FOrderedSet<EStructuralFeature>();
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      Collection<? extends EStructuralFeature> feats = provider.getOptionalMergeFeatures();
      if(feats != null) result.addAll(feats);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getDefaultOptionalMergeFeatures()
   */
  public List<EStructuralFeature> getDefaultOptionalMergeFeatures() {
    List<EStructuralFeature> result = new FOrderedSet<EStructuralFeature>();
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      List<EStructuralFeature> feats = provider.getDefaultOptionalMergeFeatures();
      if(feats != null) result.addAll(feats);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getNameAttribute(org.eclipse.emf.ecore.EObject)
   */
  public EAttribute getNameAttribute(EObject element_p) {
    EAttribute result = null;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.getNameAttribute(element_p);
      if(result != null) return result;
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#enforceOwnership(java.util.Collection, java.lang.Object)
   */
  public Boolean enforceOwnership(Collection<? extends EObject> roots_p, Object context_p) {
    Collection<EObject> enforcedRoots = new ArrayList<EObject>();
    ISemanticRuleProvider mainProvider = null;
    for(EObject root : roots_p) {
      Boolean rootSuccess = Boolean.FALSE;
      Collection<EObject> singleton = new ArrayList<EObject>();
      singleton.add(root);
      for (ISemanticRuleProvider provider : _semanticRuleProviders) {
        if (provider.isMainModel()) {
          mainProvider = provider;
        } else {
          if (provider.isApplicableTo(root))
            rootSuccess = provider.enforceOwnership(singleton, context_p);
          if (rootSuccess != null && rootSuccess.booleanValue())
            break;
        }
      }
      if (mainProvider != null && rootSuccess != null && !rootSuccess.booleanValue() &&
          mainProvider.isApplicableTo(root)) {
        rootSuccess = mainProvider.enforceOwnership(singleton, context_p);
        if (rootSuccess == null)
          return null; // Canceled
      }
      if (rootSuccess != null && rootSuccess.booleanValue())
        enforcedRoots.add(root);
    }
    return Boolean.valueOf(enforcedRoots.size() == roots_p.size());
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getRootsForPatternInclusion(org.eclipse.emf.ecore.EObject)
   */
  public Collection<EObject> getRootsForPatternInclusion(EObject context_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      Collection<EObject> objs = provider.getRootsForPatternInclusion(context_p);
      if(objs != null) result.addAll(objs);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#adjustScope(org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope, boolean)
   */
  public void adjustScope(FilteredModelScope scope_p, boolean extend_p) {
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      provider.adjustScope(scope_p, extend_p);
    }
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#initializeScope(org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope)
   */
  public void initializeTargetScope(IFeaturedModelScope referenceScope_p,
      IFeaturedModelScope targetScope_p){
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      provider.initializeTargetScope(referenceScope_p, targetScope_p);
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getPossibleContainersInContext(java.lang.Object, java.util.Collection)
   */
  public List<EObject> getPossibleContainersInContext(Object context_p,
      Collection<? extends EObject> toStore_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      List<EObject> objs = provider.getPossibleContainersInContext(context_p, toStore_p);
      if(objs != null) result.addAll(objs);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getDependencies(org.eclipse.emf.ecore.EObject)
   */
  public List<EObject> getDependencies(EObject object_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      List<EObject> dependencies = provider.getDependencies(object_p);
      if(dependencies != null) result.addAll(dependencies);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#hasDependencies(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.api.scopes.IModelScope)
   */
  public boolean hasNotInScopeDependencies(EObject sourceElement_p, IModelScope scope_p) {
    boolean result = false;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.hasNotInScopeDependencies(sourceElement_p, scope_p);
      if(result == true) return result;
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isPatternApplicable(org.eclipse.emf.ecore.EObject)
   */
  public boolean isApplicableTo(EObject obj_p){
    boolean result = false;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.isApplicableTo(obj_p);
      if(result == true) return result;
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isMergeDependency(org.eclipse.emf.ecore.EObject)
   */
  public boolean isMergeDependency(EObject element) {
    boolean result = false;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.isMergeDependency(element);
      if(result == true) return result;
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#canBeAutomaticallyMerged(org.eclipse.emf.ecore.EObject)
   */
  public boolean canBeAutomaticallyMerged(EObject element_p) {
    boolean result = false;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      result = provider.canBeAutomaticallyMerged(element_p);
      if(result == true) return result;
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getAutomaticMergeTarget(org.eclipse.emf.ecore.EObject)
   */
  public EObject getAutomaticMergeTarget(EObject element_p, Object targetScope_p) {
    EObject result = null;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      if(provider.isApplicableTo(element_p)){
        result = provider.getAutomaticMergeTarget(element_p, targetScope_p);
        if(result != null) return result;
      }
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isMainModel()
   */
  public boolean isMainModel() {
    return false;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isAllowedToBeRoot(org.eclipse.emf.ecore.EObject)
   */
  public boolean isAllowedToBeRoot(EObject obj_p){
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      if(provider.isApplicableTo(obj_p)){
        return(provider.isAllowedToBeRoot(obj_p));
      }
    }
    return false;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getPrefixText(org.eclipse.emf.ecore.EObject)
   */
  public String getPrefixText(EObject element_p) {
    ISemanticRuleProvider mainProvider = null;
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      if(provider.isMainModel()){
        mainProvider = provider;
      }else{
        if(provider.isApplicableTo(element_p)){
          return provider.getPrefixText(element_p);
        }
      }
    }
    if(mainProvider != null){
      if(mainProvider.isApplicableTo(element_p)){
        return mainProvider.getPrefixText(element_p);
      }
    }
    return "???"; //$NON-NLS-1$
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#reset()
   */
  public void reset() {
    for (ISemanticRuleProvider provider : _semanticRuleProviders){
      provider.reset();
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#postPatternApplication(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication, java.util.Collection, java.util.Collection)
   */
  public void postPatternApplication(IPatternApplication _application,
      Collection<EObject> additions, Collection<IDifference> merges) {
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      provider.postPatternApplication(_application, additions, merges);
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isAutomaticallyUpdatedDiagram(java.lang.Object)
   */
  public boolean isAutomaticallyUpdatedDiagram(Object diagram_p) {
    for(ISemanticRuleProvider provider : _semanticRuleProviders){
      if(provider.isMainModel()){
        return provider.isAutomaticallyUpdatedDiagram(diagram_p);
      }
    }
    return false;
  }


}
