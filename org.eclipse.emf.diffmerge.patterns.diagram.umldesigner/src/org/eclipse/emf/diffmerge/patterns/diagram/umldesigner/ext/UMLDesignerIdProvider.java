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
package org.eclipse.emf.diffmerge.patterns.diagram.umldesigner.ext;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.resources.DefaultPatternsXMIResource;
import org.eclipse.emf.diffmerge.patterns.templates.engine.resources.PatternVirtualResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.resource.UMLResource;


/**
 * An ID provider for UML Designer.
 * @author Skander Turki
 */
public class UMLDesignerIdProvider implements IIdProvider{

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#isMainModel()
   */
  public boolean isMainModel() {
    return true;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getNewIdFor(org.eclipse.emf.ecore.EObject)
   */
  public String getNewIdFor(EObject element_p) {
    return EcoreUtil.generateUUID();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getId(org.eclipse.emf.ecore.EObject)
   */
  public String getId(EObject element_p, EditingDomain editingDomain_p) {
    String result = null;
    if (element_p != null){
      Resource res = element_p.eResource();
      if(res == null){
        //Fix: Reload
        EObject container = EcoreUtil.getRootContainer(element_p);
        if(container instanceof AbstractIdentifiedElement && editingDomain_p != null){
          CorePatternsPlugin.getDefault().getIdProvider().getById(((AbstractIdentifiedElement)container).getId(), editingDomain_p.getResourceSet().getResources());
        }
      }

      if(res instanceof UMLResource){
        UMLResource umlres = (UMLResource)res;
        return umlres.getID(element_p);
      }
      else if(res instanceof DefaultPatternsXMIResource){
        DefaultPatternsXMIResource xmlres = (DefaultPatternsXMIResource)res;
        result = xmlres.getID(element_p);
        if(result == null){
          //The element has just been created, look in the cache map

        }
      }
      else if(res instanceof PatternVirtualResource){
        PatternVirtualResource vres = (PatternVirtualResource)res;
        result = vres.getID(element_p);
      }
      else
        result = EcoreUtil.getID(element_p);     
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getById(java.lang.String, java.util.Collection)
   */
  public EObject getById(String id_p, Collection<? extends Resource> scope_p) {
    if (id_p != null) {
      for (Resource currentResource : scope_p) {
        EObject result = currentResource.getEObject(id_p);
        if (result != null)
          return result;
      }
    }
    return null;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getByIdInContext(java.lang.String, java.lang.Object)
   */
  public EObject getByIdInContext(String id_p, Object context_p) {
    Collection<Resource> resources = ModelsUtil.getRelatedResources(context_p);
    return getById(id_p, resources);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#getByIdInResource(java.lang.String, org.eclipse.emf.ecore.EObject)
   */
  public EObject getByIdInResource(String id_p, EObject context_p) {
    EObject result = null;
    if (id_p != null && context_p != null) {
      Resource resource = context_p.eResource();
      if (resource != null) {
        Collection<Resource> resources = Collections.singleton(resource);
        result = getById(id_p, resources);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#isApplicableTo(org.eclipse.emf.ecore.EObject)
   */
  public boolean isApplicableTo(EObject element_p) {
    if (element_p instanceof CommonPatternInstance ||
        element_p instanceof Element)
      return true;
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider#requiresNewIntrinsicID(org.eclipse.emf.ecore.EObject, java.lang.Object)
   */
  public boolean requiresNewIntrinsicID(EObject element_p, Object scope_p) {
    return false;
  }

}
