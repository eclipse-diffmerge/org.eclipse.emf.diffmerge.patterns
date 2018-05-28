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
package org.eclipse.emf.diffmerge.patterns.templates.engine.resources;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A virtual resource to keep the trace of copied pattern objects to original ones.
 * This solves the cases where some pattern objects do not have technical ids, the eResource()
 * of copies being null, we need to trace back to original objects to recover ids.
 * @author Skander Turki
 *
 */
public class PatternVirtualResource extends ResourceImpl{
  
  /** A map that holds the trace of copies to original objects */
  private Map<EObject, EObject> _copiedToOriginalMap;
  
  /** Original elements' editing domain */
  private EditingDomain _originalEditingDomain;
  
  
  /**
   * Constructor
   * @param copiedToOriginalMap_p a non-null Map
   * @param originalEditingDomain_p an editing domain
   */
  public PatternVirtualResource(Map<EObject, EObject> copiedToOriginalMap_p, 
      EditingDomain originalEditingDomain_p){
    _copiedToOriginalMap = copiedToOriginalMap_p;
    _originalEditingDomain = originalEditingDomain_p;
    Iterator<EObject> it = copiedToOriginalMap_p.values().iterator();
    while(it.hasNext()){
      EObject cur = it.next();
      if(cur instanceof IPattern)
        getContents().add(cur);
    }
  }
  
  /**
   * Returns the id of the original element of the given copy
   * @param eObject a non null EObject
   * @return a potentially null String
   */
  public String getID(EObject eObject) {
    String result = null;
    IIdProvider idProvider = CorePatternsPlugin.getDefault().getIdProvider();
    if (_copiedToOriginalMap != null && idProvider != null)
    {
      EObject original = getKeyForValue(_copiedToOriginalMap, eObject);
      result = idProvider.getId(original, _originalEditingDomain);
    }
    return result;
  }
  
  /**
   * Having the value object, we need to trace back to the key object in the given map
   * @return a potentially null element
   */
  private EObject getKeyForValue(Map<EObject, EObject> map_p, EObject value_p){
    EObject result = null;
    Set<EObject> kset = map_p.keySet();
    Iterator<EObject> it = kset.iterator();
    while(it.hasNext()){
      EObject current = it.next();
      if(map_p.get(current) == value_p){
        return current;
      }
    }
    return result;
  }
  
  /**
   * Adds a mapping to the member _copiedToOriginalMap if the keyObject parameter isn't already mapped.
   * @param keyObject a potentially null EObject
   * @param valueObject a potentially null EObject
   * @param replaceMapping if set to true and an old mapping already exists for the keyObject, it is replaced.
   * @return true if the key Object doesn't already exist in the map, otherwise it returns false. 
   */
  public boolean map(EObject keyObject, EObject valueObject, boolean replaceMapping){
    boolean result = true;
    if(keyObject != null){
      if(_copiedToOriginalMap.get(keyObject) != null){
        result = false;
        if(replaceMapping){
          _copiedToOriginalMap.remove(keyObject);
          _copiedToOriginalMap.put(keyObject, valueObject);
        }else{
          return result;
        }
      }else{
        _copiedToOriginalMap.put(keyObject, valueObject);
      }
    }
    return result;
  }
  
  /**
   * Getter for the editing domain.
   */
  public EditingDomain getEditingDomain(){
    return _originalEditingDomain;
  }

  //  /**
  //   * Returns a text representing the given EObject.
  //   * @param obj_p a potentially null EObject.
  //   * @return a potentially-null String.
  //   */
  //  public String getText(EObject obj_p){
  //    EObject original = getKeyForValue(_copiedToOriginalMap, obj_p);
  //    if(_originalEditingDomain instanceof AdapterFactoryEditingDomain){
  //      IItemLabelProvider provider = (IItemLabelProvider) ((AdapterFactoryEditingDomain)_originalEditingDomain).getAdapterFactory().adapt(original, IItemLabelProvider.class);
  //      if(provider != null)
  //        return provider.getText(original);
  //    }
  //    return ""; //$NON-NLS-1$
  //  }

}
