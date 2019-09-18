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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import static org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternComparison.getPatternRole;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.structures.common.FArrayList;
import org.eclipse.emf.diffmerge.structures.common.FHashMap;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * A partial implementation of IModifiableTemplatePatternSpecification.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractModifiableTemplatePatternSpecification
extends AbstractBijectiveTemplatePatternSpecification implements IModifiableTemplatePatternSpecification {

  /**
   * An interface for observers which are concerned with the template elements of the pattern
   */
  public static interface ITemplateElementsChangedListener {
    /**
     * Notifies that the contents of the pattern in terms of template elements
     * have changed
     */
    void templateElementsChanged();
  }


  /** The separator for numbers in pattern version */
  protected static final String VERSION_SEPARATOR = "."; //$NON-NLS-1$

  /** The separator as a regular expression */
  protected static final String VERSION_SEPARATOR_REGEX =
      java.util.regex.Pattern.quote(VERSION_SEPARATOR);

  /** Whether the pattern image can be changed */
  private boolean _acceptNewPatternImage;

  /** Whether layout data must be included */
  private boolean _includeLayout;

  /** The comparison between model elements and the template elements within the pattern */
  private TemplatePatternComparison _comparison;

  /** The mapping from source elements to roles */
  private final EMap<EObject, TemplatePatternRole> _sourceElementToRole;

  /** The observers on template elements */
  private final Collection<ITemplateElementsChangedListener> _listeners;

  /** A default scope element */
  private final WeakReference<EObject> _defaultScopeElement;

  /** A map for elements with no semantic IDs to their originals */
  protected LinkedHashMap<EObject, EObject> _noIdsMap;

  /**
   * Constructor
   * @param acceptNewPatternImage_p whether the pattern image can be changed
   * @param includeLayout_p whether layout data must be included
   * @param scopeElement_p a potentially null scope element
   */
  public AbstractModifiableTemplatePatternSpecification(boolean acceptNewPatternImage_p,
      boolean includeLayout_p, EObject scopeElement_p) {
    _sourceElementToRole = new FHashMap<EObject, TemplatePatternRole>();
    _listeners = new HashSet<ITemplateElementsChangedListener>();
    _acceptNewPatternImage = acceptNewPatternImage_p;
    _includeLayout = includeLayout_p;
    _defaultScopeElement = new WeakReference<EObject>(scopeElement_p);
    _noIdsMap = new LinkedHashMap<EObject, EObject>();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification#acceptNewPatternImage()
   */
  public boolean acceptNewPatternImage() {
    return _acceptNewPatternImage;
  }

  /**
   * Add the given elements to the pattern
   * @param elements_p a non-null set
   * @param includeChildren_p whether children must be included too, recursively
   * @param asDependencies_p whether the elements must be added as dependencies
   */
  public void addElements(Collection<? extends EObject> elements_p,
      boolean includeChildren_p, boolean asDependencies_p) {
    if (!elements_p.isEmpty()) {
      FilteredModelScope sourceScope = (FilteredModelScope)getModelScope();
      for (EObject toAdd : elements_p)
        sourceScope.add(toAdd, includeChildren_p);
      updateComparison();
      if (asDependencies_p)
        updateRolesFor(elements_p);
    }
  }

  /**
   * Add a listener on the template elements
   * @param listener_p a non-null listener
   */
  public void addTemplateElementsChangedListener(ITemplateElementsChangedListener listener_p) {
    _listeners.add(listener_p);
  }

  /**
   * Merge the differences of the current comparison to the pattern side
   */
  protected void mergeDifferences() {
    getComparison().merge(TemplatePatternComparison.getPatternRole(), true, null);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification#addRole(java.lang.String)
   */
  public TemplatePatternRole addRole(String roleName_p) {
    TemplatePatternRole result =
        TemplatepatternsFactory.eINSTANCE.createTemplatePatternRole();
    result.setName(roleName_p);
    result.setDescription(""); //$NON-NLS-1$
    result.setAdditionKind(AdditionKind.ANY_CONTAINMENT);
    result.setExclusive(true);
    getPattern().getRoles().add(result);
    return result;
  }

  /**
   * Create and return a new role on the given original element in the pattern being constructed
   * @param sourceElement_p a non-null original element to use as template
   * @return a non-null role
   */
  protected TemplatePatternRole addRoleFor(EObject sourceElement_p) {
    String defaultName = getText(sourceElement_p);
    TemplatePatternRole result = addRole(defaultName);
    //    result.setPreferredContainment(sourceElement_p.eContainmentFeature());
    mapToRole(result, sourceElement_p);
    return result;
  }

  /**
   * Create and return a new role on the given original elements in the pattern being constructed
   * @param roleName_p an optional role name
   * @param sourceElements_p a non-null, non-empty set of original elements to use as templates
   * @return a non-null role
   */
  public TemplatePatternRole addRoleFor(String roleName_p, Collection<EObject> sourceElements_p) {
    String roleName = roleName_p;
    if (roleName == null) {
      if (sourceElements_p.size() > 1) {
        EClass commonType = ModelsUtil.getCommonType(sourceElements_p);
        roleName = getRoleNameForType(commonType);
      }
      if (roleName == null)
        roleName = getText(sourceElements_p.iterator().next());
    }
    TemplatePatternRole result = addRole(roleName_p);
    for (EObject sourceElement : sourceElements_p) {
      mapToRole(result, sourceElement);
    }
    return result;
  }

  /**
   * Create and return a new role on the given original elements in the pattern
   * being constructed, based on the given location
   * @param sourceElements_p a non-null, non-empty set of original elements
   * @param origin_p a non-null reference location applicable to the given elements
   * @return a non-null role
   */
  protected TemplatePatternRole addRoleFor(Collection<EObject> sourceElements_p,
      IReferenceLocation origin_p) {
    TemplatePatternRole result;
    if (sourceElements_p.size() == 1) {
      result = addRoleFor(sourceElements_p.iterator().next());
    } else {
      EClass commonType = ModelsUtil.getCommonType(sourceElements_p);
      String defaultName = commonType != null? getRoleNameForType(commonType): null;
      if (defaultName == null || collidesWithRoleName(defaultName))
        defaultName = getText(origin_p.getElement());
      if (collidesWithRoleName(defaultName))
        defaultName = defaultName + "::" + origin_p.getReference().getName(); //$NON-NLS-1$
      result = addRole(defaultName);
      //      result.setPreferredContainment(origin_p.getReference());
      for (EObject sourceElement : sourceElements_p) {
        mapToRole(result, sourceElement);
      }
    }
    return result;
  }

  /**
   * Return whether the given string collides with the name of an existing role
   * @param name_p a potentially null string
   */
  protected boolean collidesWithRoleName(String name_p) {
    if (name_p == null || getPattern() == null)
      return false;
    for (IPatternRole role : getPattern().getRoles()) {
      if (name_p.equals(role.getName()))
        return true;
    }
    return false;
  }

  /**
   * Return a list of elements resulting from the filtering of elements outside the model scope
   * within the given collection
   * @param elements_p a non-null collection
   * @return a non-null, potentially empty, modifiable list
   */
  public List<EObject> filterNonModelElements(Collection<? extends EObject> elements_p) {
    List<EObject> result = new FArrayList<EObject>();
    for (EObject element : elements_p) {
      if (isInModelScope(element))
        result.add(element);
    }
    return result;
  }

  /**
   * Return a list of elements resulting from the filtering of elements outside the model scope
   * or related to instances within the given collection
   * @param elements_p a non-null collection
   * @return a non-null, potentially empty, modifiable list
   */
  public List<EObject> filterNonModelNonInstanceElements(Collection<? extends EObject> elements_p) {
    List<EObject> result = new FArrayList<EObject>();
    for (EObject element : elements_p) {
      if (isInModelScope(element) && !isInstanceRelated(element))
        result.add(element);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IBijectiveTemplatePatternSpecification#getAllElements()
   */
  public Collection<EObject> getAllElements() {
    return getModelScope().getAllContentsAsSet();
  }

  /**
   * Return the comparison between model elements and the template elements within the pattern
   * @return a potentially null comparison
   */
  public TemplatePatternComparison getComparison() {
    return _comparison;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection#getCounterpart(org.eclipse.emf.ecore.EObject, boolean)
   */
  public EObject getCounterpart(EObject element_p, boolean fromPattern_p) {
    Role elementRole = fromPattern_p? getPatternRole(): getPatternRole().opposite();
    IMatch match = _comparison.getMapping().getMatchFor(element_p, elementRole);
    EObject result = match != null? match.get(elementRole.opposite()): null;
    return result;
  }

  /**
   * Return the direct dependencies of the model scope
   * @return a non-null, potentially empty, unmodifiable set of elements
   */
  public Collection<EObject> getDependencies() {
    List<EObject> result = new FOrderedSet<EObject>();
    if (getComparison() != null) {
      IModelScope sourceScope = getModelScope();
      TreeIterator<EObject> it = sourceScope.getAllContents();
      while (it.hasNext()) {
        EObject sourceElement = it.next();
        if (INSTANCE_FILTER.accepts(sourceElement)) {
          result.addAll(getDependencies(sourceElement));
        } else {
          it.prune();
          if (sourceElement == sourceScope.getContents().get(sourceScope.getContents().size()-1))
            break; // For EDM bug 412378 fixed 05/07/2013
        }
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the direct dependencies of the given elements from the model scope
   * @param sourceElements_p a non-null, potentially empty set of elements from the model scope
   * @return a non-null, potentially empty, unmodifiable set of elements
   */
  public Collection<EObject> getDependencies(Collection<? extends EObject> sourceElements_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    if (getComparison() != null) {
      for (EObject sourceElement : sourceElements_p) {
        if (INSTANCE_FILTER.accepts(sourceElement))
          result.addAll(getDependencies(sourceElement));
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the direct dependencies of the given element from the model scope
   * @param sourceElement_p a non-null element from the model scope
   * @return a non-null, potentially empty, unmodifiable set of elements
   */
  public Collection<EObject> getDependencies(EObject sourceElement_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    if (getComparison() != null && INSTANCE_FILTER.accepts(sourceElement_p) &&
        isInModelScope(sourceElement_p)) {
      IModelScope sourceScope = getModelScope();
      ISemanticRuleProvider ruleProvider = getSemanticRuleProvider();
      List<EObject> candidates = ruleProvider.getDependencies(sourceElement_p);
      for (EObject candidate : candidates) {
        if (!sourceScope.covers(candidate))
          result.add(candidate);
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the set of instances which are currently included
   * @return a non-null, potentially empty, modifiable collection
   */
  protected Collection<IPatternInstance> getIncludedInstances() {
    List<IPatternInstance> result = new FArrayList<IPatternInstance>();
    for (EObject root : getModelScope().getContents()) {
      if (root instanceof IPatternInstance)
        result.add((IPatternInstance)root);
    }
    return result;
  }

  /**
   * Return the set of instances must be ignored for inclusion
   * @return a non-null, potentially empty, modifiable collection
   */
  protected Collection<IPatternInstance> getInstancesToIgnore() {
    return getIncludedInstances();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification#getModelScope()
   */
  public IModelScope getModelScope() {
    return _comparison.getScope(getPatternRole().opposite());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification#getPatternScope()
   */
  public IModelScope getPatternScope() {
    return _comparison.getScope(getPatternRole());
  }

  /**
   * Return all instances in which elements from the model scope are involved
   * @return a non-null, potentially empty, modifiable set of pattern instances
   */
  public Collection<AbstractPatternInstance> getRelatedInstances() {
    List<AbstractPatternInstance> result = new FOrderedSet<AbstractPatternInstance>();
    if (getComparison() != null) {
      IModelScope sourceScope = getModelScope();
      TreeIterator<EObject> it = sourceScope.getAllContents();
      while (it.hasNext()) {
        EObject sourceElement = it.next();
        result.addAll(getRelatedInstances(sourceElement));
      }
    }
    return result;
  }

  /**
   * Return the instances in which the given elements from the model scope are involved
   * @param sourceElements_p a non-null, potentially empty set of elements from the model scope
   * @return a non-null, potentially empty, modifiable set of pattern instances
   */
  public Collection<AbstractPatternInstance> getRelatedInstances(
      Collection<? extends EObject> sourceElements_p) {
    List<AbstractPatternInstance> result = new FOrderedSet<AbstractPatternInstance>();
    if (getComparison() != null) {
      for (EObject sourceElement : sourceElements_p) {
        result.addAll(getRelatedInstances(sourceElement));
      }
    }
    return result;
  }

  /**
   * Return the instances in which the given element from the model scope is involved
   * @param sourceElement_p a non-null element from the model scope
   * @return a non-null, potentially empty, modifiable set of pattern instances
   */
  public Collection<AbstractPatternInstance> getRelatedInstances(EObject sourceElement_p) {
    List<AbstractPatternInstance> result = new FOrderedSet<AbstractPatternInstance>();
    Collection<IPatternInstance> toIgnore = getInstancesToIgnore();
    IPatternSupport support =
        CorePatternsPlugin.getDefault().getPatternSupportFor(sourceElement_p);
    if (support != null) {
      List<IPatternInstance> instances = support.getRelatedInstances(sourceElement_p);
      for (IPatternInstance instance : instances) {
        if (instance instanceof AbstractPatternInstance &&
            !toIgnore.contains(instance))
          result.add((AbstractPatternInstance)instance);
      }
    }
    return result;
  }

  /**
   * Return a role name for elements of the given type
   * @param type_p a non-null type
   * @return a non-null string
   */
  public String getRoleNameForType(EClass type_p) {
    // Add an 's' for English plural form
    String result;
    String typeName = type_p.getName();
    if (typeName.endsWith("s") || typeName.endsWith("x")) //$NON-NLS-1$ //$NON-NLS-2$
      result = String.format(
          Messages.AbstractModifiableTemplatePatternSpecification_SpecialRoleNameFromType,
          type_p.getName());
    else
      result = String.format(
          Messages.AbstractModifiableTemplatePatternSpecification_RoleNameFromType, type_p.getName());
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#getRolesOf(org.eclipse.emf.ecore.EObject)
   */
  public List<TemplatePatternRole> getRolesOf(EObject sourceElement_p) {
    List<TemplatePatternRole> result;
    TemplatePatternRole role = _sourceElementToRole.get(sourceElement_p);
    if (role == null)
      result = Collections.emptyList();
    else
      result = Collections.singletonList(role);
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IUserScopeProvider#getScopeElement()
   */
  public EObject getScopeElement() {
    EObject result = null;
    List<EObject> contents = getModelScope().getContents();
    if (!contents.isEmpty())
      result = contents.get(0);
    else
      result = _defaultScopeElement.get();
    return result;
  }

  /**
   * Return a semantic rule provider for template and source elements
   * @return a non-null semantic rule provider
   */
  protected ISemanticRuleProvider getSemanticRuleProvider() {
    ISemanticRuleProvider result =
        TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(getScopeElement());
    return result;
  }

  /**
   * Return a label for the given element
   * @param element_p a non-null element
   * @return a non-null string
   */
  public String getText(EObject element_p) {
    String result = element_p.toString(); // Default value
    EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(element_p);
    if (domain != null) {
      IItemLabelProvider labelProvider = (IItemLabelProvider)
          ((AdapterFactoryEditingDomain)domain).getAdapterFactory().adapt(
              element_p, IItemLabelProvider.class);
      if (labelProvider != null)
        result = labelProvider.getText(element_p);
    }
    return result;
  }

  /**
   * Return whether the template elements have cross-references outside of the pattern
   */
  public boolean hasDependencies() {
    if (getComparison() != null) {
      IModelScope sourceScope = getModelScope();
      TreeIterator<EObject> it = sourceScope.getAllContents();
      while (it.hasNext()) {
        EObject sourceElement = it.next();
        if (INSTANCE_FILTER.accepts(sourceElement)) {
          if (hasDependencies(sourceElement))
            return true;
        } else {
          it.prune();
          if (sourceElement == sourceScope.getContents().get(sourceScope.getContents().size()-1))
            break; // For EDM bug 412378 fixed 05/07/2013
        }
      }
    }
    return false;
  }

  /**
   * Return whether the given elements from the model scope have direct dependencies
   * @param sourceElements_p a non-null, potentially empty set of elements from the model scope
   */
  public boolean hasDependencies(Collection<? extends EObject> sourceElements_p) {
    if (getComparison() != null) {
      for (EObject sourceElement : sourceElements_p) {
        if (hasDependencies(sourceElement))
          return true;
      }
    }
    return false;
  }

  /**
   * Return whether the given element is in the model scope and has direct dependencies
   * @param sourceElement_p a non-null element
   */
  public boolean hasDependencies(EObject sourceElement_p) {
    if (getComparison() != null && isInModelScope(sourceElement_p)) {
      IModelScope sourceScope = getModelScope();
      ISemanticRuleProvider ruleProvider = getSemanticRuleProvider();
      return ruleProvider.hasNotInScopeDependencies(sourceElement_p, sourceScope);
    }
    return false;
  }

  /**
   * Return whether the template elements are involved in pattern instances
   */
  public boolean hasRelatedInstances() {
    if (getComparison() != null) {
      IPatternSupport support =
          CorePatternsPlugin.getDefault().getPatternSupportFor(getScopeElement());
      if (support != null) {
        Collection<? extends IPatternInstance> instancesToIgnore = getInstancesToIgnore();
        IModelScope sourceScope = getModelScope();
        TreeIterator<EObject> it = sourceScope.getAllContents();
        while (it.hasNext()) {
          EObject sourceElement = it.next();
          if (hasRelatedInstances(sourceElement, support, instancesToIgnore))
            return true;
        }
      }
    }
    return false;
  }

  /**
   * Return whether the given element is in the model scope and is involved in pattern instances
   * @param sourceElement_p a non-null element
   */
  protected boolean hasRelatedInstances(EObject sourceElement_p, IPatternSupport support_p,
      Collection<? extends IPatternInstance> instancesToIgnore_p) {
    boolean result = false;
    if (getComparison() != null && isInModelScope(sourceElement_p)) {
      List<IPatternInstance> relatedInstances = support_p.getRelatedInstances(sourceElement_p);
      List<IPatternInstance> copy = new ArrayList<IPatternInstance>(relatedInstances);
      copy.removeAll(instancesToIgnore_p);
      result = !copy.isEmpty();
    }
    return result;
  }

  /**
   * Return whether the pattern contains elements which are not mapped to a role
   */
  public boolean hasUnmappedElements() {
    Iterator<EObject> it = getModelScope().getAllContents();
    while (it.hasNext()) {
      EObject sourceElement = it.next();
      if (getRolesOf(sourceElement).isEmpty())
        return true;
    }
    return false;
  }

  /**
   * @see IModifiableTemplatePatternSpecification#includeLayoutData()
   */
  public boolean includeLayoutData() {
    return _includeLayout;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedSpecification#isComplete()
   */
  public boolean isComplete() {
    TemplatePattern pattern = getPattern();
    boolean result = isSignificant(pattern.getName()) &&
        isSignificant(pattern.getVersion()) &&
        !pattern.getRoles().isEmpty() &&
        NamingUtil.haveUniqueNames(pattern.getRoles());
    if (result) {
      for (TemplatePatternRole role : pattern.getRoles()) {
        if (role.getTemplateElements().isEmpty()) {
          result = false;
          break;
        }
      }
    }
    return result;
  }

  /**
   * Return whether the specified pattern is a template
   */
  public boolean isTemplate() {
    return getPattern() != null && getPattern().isTemplate();
  }

  /**
   * Return whether the given element belongs to the model scope.
   * This typically excludes elements representing deletions in the update process.
   * @param element_p a non-null element
   */
  public boolean isInModelScope(EObject element_p) {
    IMatch match =
        getComparison().getMapping().getMatchFor(element_p, getPatternRole().opposite());
    boolean result = match != null;
    return result;
  }

  /**
   * Map the counterpart of the given element to the given role
   * @param role_p a non-null role of the pattern being constructed
   * @param sourceElement_p a non-null element within the source scope
   */
  public void mapToRole(TemplatePatternRole role_p, EObject sourceElement_p) {
    EObject templateElement = getCounterpart(sourceElement_p, false);
    if (templateElement != null) {
      removeFromRole(sourceElement_p);
      role_p.getTemplateElements().add(templateElement);
      _sourceElementToRole.put(sourceElement_p, role_p);
      roleUpdated();
    }
  }

  /**
   * Set the current comparison between model elements and template elements
   * @param comparison_p a potentially null comparison
   */
  protected void newComparison(TemplatePatternComparison comparison_p) {
    _comparison = comparison_p;
  }

  /**
   * Remember the template elements associated to the roles for later retrieval,
   * assuming that the comparison has already been computed
   */
  protected void registerRoleElements() {
    if (getPattern() != null) {
      for (TemplatePatternRole role : getPattern().getRoles()) {
        for (EObject templateElement : role.getTemplateElements()) {
          EObject sourceElement = getCounterpart(templateElement, true);
          if (sourceElement != null)
            _sourceElementToRole.put(sourceElement, role);
        }
      }
    }
  }

  /**
   * Remove the given elements from the pattern
   * @param elements_p a non-null set
   * @param removeChildren_p whether children must be included too, recursively
   */
  public void removeElements(Collection<? extends EObject> elements_p,
      boolean removeChildren_p) {
    for (EObject selectedElement : elements_p) {
      boolean removeChildren = removeChildren_p ||
          isInstanceRelated(selectedElement);
      ((FilteredModelScope)getModelScope()).removeFromScope(
          selectedElement, removeChildren);
      removeFromRole(selectedElement);
      if (removeChildren_p) {
        TreeIterator<EObject> technicalIterator = selectedElement.eAllContents();
        while (technicalIterator.hasNext()) {
          EObject child = technicalIterator.next();
          removeFromRole(child);
        }
      }
    }
    updateComparison();
  }

  /**
   * Remove the counterpart of the given element from its role
   * @param sourceElement_p a non-null element within the source scope
   */
  public void removeFromRole(EObject sourceElement_p) {
    TemplatePatternRole role = _sourceElementToRole.get(sourceElement_p);
    if (role != null) {
      EObject templateElement = getCounterpart(sourceElement_p, false);
      if (templateElement != null) {
        role.getTemplateElements().remove(templateElement);
        _sourceElementToRole.removeKey(sourceElement_p);
        roleUpdated();
      }
    }
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification#removeRole(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
   */
  public void removeRole(TemplatePatternRole role_p) {
    getPattern().getRoles().remove(role_p);
    for (Map.Entry<EObject, TemplatePatternRole> entry : 
      new HashSet<Map.Entry<EObject, TemplatePatternRole>>(_sourceElementToRole.entrySet())) {
      if (entry.getValue() == role_p)
        _sourceElementToRole.remove(entry);
    }
    roleUpdated();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification#setAcceptNewPatternImage(boolean)
   */
  public void setAcceptNewPatternImage(boolean accept_p) {
    _acceptNewPatternImage = accept_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification#setIncludeLayoutData(boolean)
   */
  public void setIncludeLayoutData(boolean include_p) {
    _includeLayout = include_p;
  }

  /**
   * Update and merge the comparison according to a change in the model scope
   */
  public void updateComparison() {
    getComparison().update(_noIdsMap);
    //Merge
    mergeDifferences();
    //Store completed matches (added elements) ids 
    Collection<IMatch> completedMatches = getComparison().getMapping().getCompletedMatches(Role.REFERENCE);
    for(IMatch match : completedMatches){
      EObject ref = match.get(Role.REFERENCE);
      if(ref != null){
        _noIdsMap.put(ref, match.get(Role.TARGET));
      }
    }
    for (ITemplateElementsChangedListener listener : _listeners) {
      listener.templateElementsChanged();
    }
  }

  /**
   * Update the roles of the pattern according to the given new source elements
   * @param newSourceElements_p a non-null set of elements
   */
  protected void updateRolesFor(Collection<? extends EObject> newSourceElements_p) {
    boolean rolesUpdated = false;
    ISemanticRuleProvider ruleProvider = getSemanticRuleProvider();
    for (EObject element : newSourceElements_p) {
      if (getModelScope().getContents().contains(element) &&
          getModelScope().getContents(element).isEmpty() &&
          ruleProvider.isMergeDependency(element) &&
          !ruleProvider.canBeAutomaticallyMerged(element)) {
        // Empty root in scope and can be considered as a merge dependency
        TemplatePatternRole role = addRoleFor(element);
        role.setAdditionKind(AdditionKind.FORBIDDEN);
        rolesUpdated = true;
      }
    }
    if (rolesUpdated)
      roleUpdated();
  }

}
