/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.engine.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;


/**
 * A provider of business-specific logics for consistently manipulating models.
 * The default implementation is metamodel-agnostic.
 * Any class that inherits from this one has to provide a parameterless default constructor.
 * For viewpoints, isMainModel() must return false. Only the main contributing plug-in should
 * have isMainModel() return true.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class ModellerSemanticRuleProvider implements ISemanticRuleProvider {

  /**
   * Default constructor
   */
  public ModellerSemanticRuleProvider(){
    // Nothing needed
  }

  /**
   * Derive the ownership of the given element, if applicable
   * @param element_p a non-null element
   * @param context_p a non-null context object, typically resource or model element
   * @return whether the operation succeeded
   */
  public boolean deriveOwnership(EObject element_p, Object context_p) {
    boolean result = false;
    if (element_p instanceof IPatternInstance) {
      IPatternSupport support = CorePatternsPlugin.getDefault().getPatternSupportFor(element_p);
      if (support != null)
        result = support.storeInstance((IPatternInstance)element_p, context_p);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getNameAttribute(org.eclipse.emf.ecore.EObject)
   */
  public EAttribute getNameAttribute(EObject element_p) {
    if(element_p != null){
      for (EAttribute attribute : element_p.eClass().getEAllAttributes()) {
        if (NamingUtil.isName(attribute))
          return attribute;
      }
    }
    return null;
  }

  /**
   * Return all possible containers for the given elements among the
   * given elements and all its children
   * Postcondition: roots_p is not modified
   * @param roots_p a non-null, potentially empty collection
   * @param toStore_p the non-null, non-empty set of elements to store
   * @return a non-null, potentially empty, unmodifiable list
   */
  public List<EObject> getPossibleContainersIn(
      Collection<? extends EObject> roots_p, Collection<? extends EObject> toStore_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    for (EObject root : roots_p) {
      result.addAll(getPossibleContainersIn(root, toStore_p));
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getPossibleContainersInContext(java.lang.Object, java.util.Collection)
   */
  public List<EObject> getPossibleContainersInContext(
      Object context_p, Collection<? extends EObject> toStore_p) {
    Collection<EObject> roots = getRootsForContainerRetrieval(context_p);
    List<EObject> result;
    if (roots == null || roots.isEmpty())
      result = Collections.emptyList();
    else
      result = getPossibleContainersIn(roots, toStore_p);
    return result;
  }

  /**
   * Return all possible containers for the given elements among the
   * given context element and all its children
   * @param context_p a non-null element
   * @param toStore_p the non-null, non-empty set of elements to store
   * @return a non-null, potentially empty, unmodifiable list
   */
  public List<EObject> getPossibleContainersIn(EObject context_p,
      Collection<? extends EObject> toStore_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    if (isPossibleContainerFor(context_p, toStore_p))
      result.add(context_p);
    Iterator<EObject> it = context_p.eAllContents();
    while (it.hasNext()) {
      EObject current = it.next();
      if (isPossibleContainerFor(current, toStore_p))
        result.add(current);
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the root elements to consider for container retrieval,
   * given a certain context object
   * @param context_p a potentially null object
   * @return a non-null, potentially empty, unmodifiable list
   */
  public List<EObject> getRootsForContainerRetrieval(Object context_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    if (context_p instanceof CommonPatternInstance) {
      IPatternSupport support = CorePatternsPlugin.getDefault().getPatternSupportFor((EObject)context_p);
      Resource modelResource = support.getModelResource((CommonPatternInstance)context_p);
      if(modelResource!= null && !modelResource.getContents().isEmpty()){
        result.add(modelResource.getContents().get(0));
      }
    } else if (context_p instanceof EObject) {
      result.add(EcoreUtil.getRootContainer((EObject)context_p));
    } else if (context_p instanceof Resource) {
      result.addAll(((Resource)context_p).getContents());
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return whether the given container element may contain the given elements
   * @param container_p a non-null element
   * @param toStore_p the non-null, non-empty set of elements to store
   */
  public boolean isPossibleContainerFor(EObject container_p,
      Collection<? extends EObject> toStore_p) {
    EClass type = ModelsUtil.getCommonType(toStore_p);
    for (EReference containment : getReferencesForAddition(container_p, type, true, true)) {
      if (supportsAdditionOf(container_p, containment, toStore_p, true))
        return true;
    }
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getOwnershipDerivationLevel(org.eclipse.emf.ecore.EObject)
   */
  public int getOwnershipDerivationLevel(EObject element_p) {
    return (element_p instanceof IPatternInstance)? 1: 0;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#supportsAdditionOf(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EObject, boolean)
   */
  public boolean supportsAdditionOf(EObject element_p, EReference reference_p,
      EObject value_p, boolean nonErasing_p) {
    return supportsAdditionOf(element_p, reference_p, value_p.eClass(), nonErasing_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#supportsAdditionOf(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, java.util.Collection, boolean)
   */
  public boolean supportsAdditionOf(EObject element_p, EReference reference_p,
      Collection<? extends EObject> values_p, boolean nonErasing_p) {
    for (EObject value : values_p) {
      if (!supportsAdditionOf(element_p, reference_p, value, nonErasing_p))
        return false;
    }
    return true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getReferencesForAddition(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EClass, boolean, boolean)
   */
  public List<EReference> getReferencesForAddition(EObject element_p,
      EClass valueType_p, boolean nonErasing_p, boolean containmentOnly_p) {
    List<EReference> result = new ArrayList<EReference>();
    List<EReference> candidates;
    if(element_p != null){
      if (containmentOnly_p)
        candidates = element_p.eClass().getEAllContainments();
      else
        candidates = element_p.eClass().getEAllReferences();
      for (EReference candidate : candidates) {
        if (supportsAdditionOf(element_p, candidate, valueType_p, nonErasing_p))
          result.add(candidate);
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return whether the given reference supports the setting of values of the
   * given type
   * @param reference_p a non-null reference
   * @param valueType_p a non-null type
   */
  protected boolean supportsSettingOf(EReference reference_p, EClass valueType_p) {
    if(reference_p != null && valueType_p != null && reference_p.getEReferenceType() != null){
      return
          !reference_p.isDerived() && reference_p.isChangeable() &&
          reference_p.getEReferenceType().isSuperTypeOf(valueType_p);
    }
    return false;
  }

  /**
   * Return whether the given element supports the addition of a value of the
   * given type via the given reference based on business criteria
   * @param element_p a non-null element
   * @param reference_p a non-null reference theoretically applying to element_p
   *          and supporting the addition of elements of type valueType_p
   * @param valueType_p a non-null type
   * @param nonErasing_p whether the removal of existing values is allowed
   */
  protected boolean supportsAdditionOf(EObject element_p,EReference reference_p, 
      EClass valueType_p, boolean nonErasing_p) {
    boolean result = false;
    if(element_p != null){
      result = element_p.eClass().getEAllReferences().contains(reference_p) &&
          supportsSettingOf(reference_p, valueType_p);
      if (result && nonErasing_p && !FeatureMapUtil.isMany(element_p, reference_p)) {
        Object currentValue = element_p.eGet(reference_p);
        result = currentValue == null;
      } 
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#hasNotInScopeDependencies(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope)
   */
  public boolean hasNotInScopeDependencies(EObject sourceElement_p, ITreeDataScope<EObject> scope_p) {
    if(sourceElement_p != null){
      for (FeatureIterator<EObject> featureIterator =
          (FeatureIterator<EObject>)sourceElement_p.eCrossReferences().iterator();
          featureIterator.hasNext(); ) {
        EObject referenced = featureIterator.next();
        EReference reference = (EReference)featureIterator.feature();
        if (isDependency(reference) && !scope_p.covers(referenced))
          return true;
      } 
    }
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isApplicableTo(org.eclipse.emf.ecore.EObject)
   */
  public abstract boolean isApplicableTo(EObject obj_p);

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getDependencies(org.eclipse.emf.ecore.EObject)
   */
  public List<EObject> getDependencies(EObject object_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    if(object_p != null){
      for (FeatureIterator<EObject> featureIterator =
          (FeatureIterator<EObject>)object_p.eCrossReferences().iterator();
          featureIterator.hasNext(); ) {
        EObject referenced = featureIterator.next();
        EReference reference = (EReference)featureIterator.feature();
        if (isDependency(reference))
          result.add(referenced);
      }
    } 
    return result;
  }

  /**
   * Return whether the given reference must be considered when analyzing dependencies
   * between model elements
   * @param reference_p a non-null reference
   */
  public abstract boolean isDependency(EReference reference_p);

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isMainModel()
   */
  public boolean isMainModel(){
    return true;
  }

}
