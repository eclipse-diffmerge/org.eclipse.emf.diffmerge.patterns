/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.engine.ext;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * An abstract provider of business-specific logic for consistently manipulating models.
 * This class should be extended by any viewpoint that has to be included in patterns.
 * IMPORTANT: For viewpoints the constructor must set _isMainModel to false. Only the main contributing
 *            plugin should set this property to true.
 * @author Olivier Constant
 * @author S. TURKI
 */
public interface ISemanticRuleProvider {

  /**
   * Getter for _isMainModel
   * @return
   */
  public boolean isMainModel();

  /**
   * Adjust the given scope so that it makes sense by itself according to business criteria
   * @param scope_p a non-null scope
   * @param extend_p whether the scope should be extended or reduced
   */
  public  void adjustScope(FilteredModelScope scope_p, boolean extend_p);

  /**
   * This method is meant for viewpoints/library-users that might need to add references to external elements
   * in the target scope whenever an external element is referenced by the reference scope.
   * @param scope_p a non-null FilteredModelScope
   */
  public void initializeTargetScope(IFeaturedModelScope referenceScope_p,
      IFeaturedModelScope targetScope_p);

  /**
   * Returns the EObjects that should be included in a pattern when the given EObject is selected. 
   * @param object_p a non-null EObject
   * @return a non-null, potentially empty list
   */
  public List<EObject> getDependencies(EObject object_p);

  /**
   * Try and assign a container or a resource to all the given elements within the model
   * defined by the given contextual element.
   * Postcondition: roots_p is not modified
   * Postcondition: all elements in roots_p have a non-null container
   * @param roots_p a non-null, potentially empty collection
   * @param context_p a non-null context object, typically resource or model element
   * @return whether the attempt succeeded
   */
  public boolean enforceOwnership(Collection<? extends EObject> roots_p, Object context_p);

  /**
   * Return the structural features among those returned by getOptionalMergeFeatures()
   * which should be ignored by default
   * @return a non-null, potentially empty list
   */
  public List<EStructuralFeature> getDefaultOptionalMergeFeatures();

  /**
   * Given a collection of candidate elements to rename, return a subset of the
   * collection containing all the elements which should actually be renamed
   * @param elements_p a non-null collection
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public Collection<EObject> getElementsToRename(Collection<? extends EObject> elements_p);

  /**
   * Return an attribute of the given element which can be considered as a name, if any
   * @param element_p a non-null element
   * @return a potentially null attribute
   */
  public EAttribute getNameAttribute(EObject element_p);

  /**
   * Return the structural features that the user should be able to
   * include or not in synchronization mechanisms (instance/pattern update)
   * @return a non-null, potentially empty list
   */
  public Collection<? extends EStructuralFeature> getOptionalMergeFeatures();

  /**
   * Return all possible containers for the given elements within the
   * scope defined by the given context element
   * @param context_p a potentially null object
   * @param toStore_p the non-null, non-empty set of elements to store
   * @return a non-null, potentially empty, unmodifiable list
   */
  public List<EObject> getPossibleContainersInContext(
      Object context_p, Collection<? extends EObject> toStore_p);

  /**
   * Return the set of root elements that define the scope for element inclusion in patterns
   * from the given context element
   * @param context_p a non-null element
   * @return a non-null, potentially empty collection
   */
  public Collection<EObject> getRootsForPatternInclusion(EObject context_p);

  /**
   * Return whether the given element, if considered as a dependency, should
   * typically be associated to a merge role
   * @param element_p a non-null element
   */
  public boolean isMergeDependency(EObject element_p);


  /**
   * Says if an element can be automatically merged and then no role would be created for it.
   * Its inclusion in a pattern would be totally automatic/transparent to the user.
   * @param element_p
   * @return a boolean a non-null EObject
   */
  public boolean canBeAutomaticallyMerged(EObject element_p);  

  /**
   * If the element_p can be automatically merged, 
   * this method should return the target to which the element_p is to be merged. 
   * This target should be looked for in the given scope.
   * @param element_p a non-null EObject
   * @param targetScope_p a non-null Object
   * @return a potentially null target EObject
   */
  public EObject getAutomaticMergeTarget(EObject element_p, Object targetScope_p);

  /**
   * Return whether the ownership of the given element might be derived
   * @param element_p a non-null element
   */
  public boolean ownershipMightBeDerived(EObject root);

  /**
   * Return whether the given element is in the model scope and has direct dependencies
   * @param sourceElement_p
   * @return
   */
  public boolean hasNotInScopeDependencies(EObject sourceElement_p, IModelScope scope_p);

  /**
   * Return the references which support the addition of values of the given type
   * on the given element
   * @param element_p a non-null element
   * @param valueType_p a non-null type
   * @param nonErasing_p whether the removal of existing values is allowed
   * @param containmentOnly_p whether only containment references must be considered
   * @return a non-null, potentially empty, unmodifiable list
   */
  public List<EReference> getReferencesForAddition(EObject element_p,
      EClass valueType_p, boolean nonErasing_p, boolean containmentOnly_p);


  /**
   * Return whether the given element supports the addition of the given value via
   * the given reference
   * @param element_p a non-null element
   * @param reference_p a non-null reference
   * @param value_p a non-null element
   * @param nonErasing_p whether the removal of existing values is allowed
   */
  public boolean supportsAdditionOf(EObject element_p, EReference reference_p,
      EObject value_p, boolean nonErasing_p); 

  /**
   * Return whether the given element supports the addition of the given values via
   * the given reference
   * @param element_p a non-null element
   * @param reference_p a non-null reference
   * @param values_p a non-null, non-empty collection of elements
   * @param nonErasing_p whether the removal of existing values is allowed
   */
  public boolean supportsAdditionOf(EObject element_p, EReference reference_p,
      Collection<? extends EObject> values_p, boolean nonErasing_p);

  /**
   * Says if the EObject is supported by the rule provider
   * @param obj_p
   * @return
   */
  public boolean isApplicableTo(EObject obj_p);

  /**
   * Returns if the EObject can be a root element in his containing resource
   * @param obj_p a non-null EObject
   * @return
   */
  public boolean isAllowedToBeRoot(EObject obj_p);

  /**
   * Returns a prefix to be added when displaying the name of the element to the user
   * @param element_p a non-null EObject
   * @return a String (It should be of three to five characters)
   */
  public String getPrefixText(EObject element_p);

  
  /**
   * Resets rule provider for new use
   * The reset method should be called before each new pattern application's ownership enforcement
   * see {@link org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationComparison#updateModelStep}
   */
  public void reset();

  
  /**
   * Post-pattern application computation. May differ from a modeler to the other.
   * A typical use case is the need to add library imports to the model after a pattern application (see UMLDesigner case).
   * @param _application a non-null IPatternApplication
   * @param additions a potentially empty list of EObjects
   * @param merges a potentially empty list of EObjects
   */
  public void postPatternApplication(IPatternApplication _application,
      Collection<EObject> additions, Collection<IDifference> merges);
  
}
