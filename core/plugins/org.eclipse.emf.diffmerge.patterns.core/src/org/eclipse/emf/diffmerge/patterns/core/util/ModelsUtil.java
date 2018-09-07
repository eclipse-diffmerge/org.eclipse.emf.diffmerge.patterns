/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A utility class related to operations on models.
 * @author Olivier Constant
 * @author Skander Turki
 */
public final class ModelsUtil {

  /**
   * An extension of BasicEList whose behavior is based on equality by object reference
   */
  public static class RList<E> extends BasicEList<E> {
    /** Serialization concern */
    private static final long serialVersionUID = -2025776878127790240L;
    /**
     * Constructor
     */
    public RList() {
      super();
    }
    /**
     * Constructor with initial contents
     */
    public RList(Collection<? extends E> collection_p) {
      super(collection_p);
    }
    /**
     * @see org.eclipse.emf.common.util.BasicEList#useEquals()
     */
    @Override
    protected boolean useEquals() {
      return false;
    }
  }

  /**
   * An extension of UniqueEList whose behavior is based on equality by object reference
   */
  public static class ROrderedSet<E> extends UniqueEList<E> {
    /** Serialization concern */
    private static final long serialVersionUID = 6139341754382438585L;
    /**
     * Constructor
     */
    public ROrderedSet() {
      super();
    }
    /**
     * Constructor with initial contents
     */
    public ROrderedSet(Collection<? extends E> collection_p) {
      super(collection_p);
    }
    /**
     * @see org.eclipse.emf.common.util.BasicEList#useEquals()
     */
    @Override
    protected boolean useEquals() {
      return false;
    }
  }

  /**
   * An extension of BasicEMap whose behavior is based on equality by object reference
   */
  public static class RMap<K, V> extends BasicEMap<K, V> {
    /** Serialization concern */
    private static final long serialVersionUID = -2157613781342541137L;
    /**
     * Constructor
     */
    public RMap() {
      super();
    }
    /**
     * Constructor with initial contents as Map
     */
    public RMap(Map<? extends K, ? extends V> map_p) {
      super(map_p);
    }
    /**
     * Constructor with initial contents as EMap
     */
    public RMap(EMap<? extends K, ? extends V> map_p) {
      super();
      for (Map.Entry<? extends K, ? extends V> entry : map_p.entrySet()) {
        put(entry.getKey(), entry.getValue());
      }
    }
    /**
     * @see org.eclipse.emf.common.util.BasicEMap#useEqualsForKey()
     */
    @Override
    protected boolean useEqualsForKey() {
      return false;
    }
    /**
     * @see org.eclipse.emf.common.util.BasicEMap#useEqualsForValue()
     */
    @Override
    protected boolean useEqualsForValue() {
      return false;
    }
  }


  /**
   * Constructor
   */
  private ModelsUtil() {
    // Forbids instantiation
  }

  /**
   * Return all resources of the highest possible scope that can be found from
   * the given context object. Result is not empty if the context object is:
   * a model element belonging to a resource, a resource or a resource set.
   * @param context_p a potentially null object
   * @return a non-null, potentially empty, unmodifiable set
   */
  public static Collection<Resource> getRelatedResources(Object context_p) {
    Collection<Resource> result = new ArrayList<Resource>();
    Object refinedContext = context_p;
    if (refinedContext instanceof EObject)
      refinedContext = ((EObject)refinedContext).eResource();
    if (refinedContext instanceof Resource) {
      ResourceSet rs = ((Resource)refinedContext).getResourceSet();
      if (rs == null)
        result.add((Resource)refinedContext);
      else
        refinedContext = rs;
    }
    if (refinedContext instanceof ResourceSet) {
      List<Resource> allResources = ((ResourceSet)refinedContext).getResources();
      IModelEnvironment accessor = CorePatternsPlugin.getDefault().getModelEnvironment();
      if (accessor == null) {
        result.addAll(allResources);
      } else {
        for (Resource resource : allResources) {
          if (accessor.isModelResource(resource))
            result.add(resource);
        }
      }
    }
    return Collections.unmodifiableCollection(result);
  }

  /**
   * Given a set of elements, find their lowest common meta-class
   * @param elements_p a non-null collection of model elements
   * @return a meta-class which is not null if elements_p is not empty
   */
  public static EClass getCommonType(Collection<? extends EObject> elements_p) {
    EClass result = null;
    if (!elements_p.isEmpty()) {
      List<EClass> common = new ArrayList<EClass>(
          getSuperTypes(elements_p.iterator().next().eClass()));
      for(EObject elt : elements_p) {
        common.retainAll(getSuperTypes(elt.eClass()));
      }
      if (!common.isEmpty()) {
        result = common.get(common.size()-1);
      }
    }
    return result;
  }

  /**
   * Return the super types of the given meta-class including the class itself,
   * ordered from higher to lower in the hierarchy
   * @param class_p a non-null meta-class
   * @return a non-null, non-empty, unmodifiable list
   */
  private static List<EClass> getSuperTypes(EClass class_p) {
    List<EClass> allButSelf = class_p.getEAllSuperTypes();
    List<EClass> result = new ArrayList<EClass>(allButSelf.size() + 1);
    result.addAll(allButSelf);
    result.add(class_p);
    return Collections.unmodifiableList(result);
  }

  /**
   * Returns the editing domain for the given element
   * @param element_p a non-null element
   * @return a potentially null editing domain
   */
  public static EditingDomain getEditingDomain(EObject element_p){
    IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
    if(env != null){
      return env.getEditingDomain(element_p);
    }
    return null;
  }
  
}
