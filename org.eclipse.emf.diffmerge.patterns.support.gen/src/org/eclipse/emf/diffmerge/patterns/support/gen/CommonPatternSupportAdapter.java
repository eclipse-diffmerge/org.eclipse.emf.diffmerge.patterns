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
package org.eclipse.emf.diffmerge.patterns.support.gen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AbstractIDBasedAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.AttributeLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportFactory;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.ResourceLocation;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.PatternsCoreGenAdapter;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsFactory;

/**
 * A class which converts elements from the Patterns API to equivalent ones which
 * are suitable for usage and storage with eMDE pattern support.
 * @author O. CONSTANT
 */
public class CommonPatternSupportAdapter extends PatternsCoreGenAdapter {
  
  /** The shared instance **/
  public static final CommonPatternSupportAdapter COMMON_PATTERN_SUPPORT_ADAPTER =
    new CommonPatternSupportAdapter();
  
  /**
   * Constructor
   */
  protected CommonPatternSupportAdapter() {
    // Cannot be called from outside class hierarchy
  }
  
  /**
   * Convert the given location
   * @param location_p a non-null location
   * @param pattern_p a non-null pattern the location is for
   * @return a non-null location for usage with eMDE pattern support
   */
  public AbstractLocation adapt(ILocation location_p, IPattern pattern_p) {
    AbstractLocation result;
    if (location_p instanceof ICompositeLocation)
      result = adapt((ICompositeLocation)location_p, pattern_p);
    else if (location_p instanceof IElementLocation)
      result = adapt((IElementLocation)location_p);
    else if (location_p instanceof IElementMappingLocation)
      result = adapt((IElementMappingLocation)location_p, pattern_p);
    else if (location_p instanceof IAttributeLocation)
      result = adapt((IAttributeLocation)location_p);
    else if (location_p instanceof IReferenceLocation)
      result = adapt((IReferenceLocation)location_p);
    else
      result = adapt((IResourceLocation)location_p);
    return result;
  }
  
  /**
   * Convert the given location
   * @param location_p a non-null location
   * @param pattern_p a non-null pattern the location is for
   * @return a non-null location for usage with eMDE pattern support
   */
  private CompositeLocation adapt(ICompositeLocation location_p, IPattern pattern_p) {
    CompositeLocation result = CorepatternsFactory.eINSTANCE.createCompositeLocation();
    for (IAtomicLocation subLocation : location_p.getAtomicContents()) {
      AbstractIDBasedAtomicLocation adapted = (AbstractIDBasedAtomicLocation)adapt(subLocation, pattern_p);
      result.getOwnedLocations().add(adapted);
    }
    return result;
  }
  
  /**
   * Convert the given location
   * @param location_p a non-null location
   * @return a non-null location for usage with eMDE pattern support
   */
  private ResourceLocation adapt(IResourceLocation location_p) {
    ResourceLocation result = CommonpatternsupportFactory.eINSTANCE.createResourceLocation();
    setElementId(result, location_p.getResource());
    return result;
  }
  
  /**
   * Convert the given location
   * @param location_p a non-null location
   * @return a non-null location for usage with eMDE pattern support
   */
  private ElementLocation adapt(IElementLocation location_p) {
    ElementLocation result = CommonpatternsupportFactory.eINSTANCE.createElementLocation();
    setElementId(result, location_p.getElement());
    return result;
  }
  
  /**
   * Convert the given location
   * @param location_p a non-null location
   * @param pattern_p a non-null pattern the location is for
   * @return a non-null location for usage with eMDE pattern support
   */
  private ElementMappingLocation adapt(IElementMappingLocation location_p, IPattern pattern_p) {
    ElementMappingLocation result = CommonpatternsupportFactory.eINSTANCE.createElementMappingLocation();
    EditingDomain pedt = AdapterFactoryEditingDomain.getEditingDomainFor(pattern_p);
    for (EObject patternElement : location_p.getPatternElements(pattern_p)) {
      EObject mapped = location_p.getElement(patternElement);
      EditingDomain medt = AdapterFactoryEditingDomain.getEditingDomainFor(mapped);
      String mappedId = CorePatternsPlugin.getDefault().getIdProvider().getId(mapped, medt);
      String patternElementId = CorePatternsPlugin.getDefault().getIdProvider().getId(patternElement, pedt);
      if (patternElementId != null && mappedId != null) {
        ElementLocation mappedLocation = CommonpatternsupportFactory.eINSTANCE.createElementLocation();
        mappedLocation.setElementId(mappedId);
        result.getMapping().put(patternElementId, mappedLocation);
      }
    }
    return result;
  }
  
  /**
   * Convert the given location
   * @param location_p a non-null location
   * @return a non-null location for usage with eMDE pattern support
   */
  private AttributeLocation adapt(IAttributeLocation location_p) {
    AttributeLocation result = CommonpatternsupportFactory.eINSTANCE.createAttributeLocation();
    setElementId(result, location_p.getElement());
    result.setAttribute(location_p.getAttribute());
    return result;
  }
  
  /**
   * Convert the given location
   * @param location_p a non-null location
   * @return a non-null location for usage with eMDE pattern support
   */
  private ReferenceLocation adapt(IReferenceLocation location_p) {
    ReferenceLocation result = CommonpatternsupportFactory.eINSTANCE.createReferenceLocation();
    setElementId(result, location_p.getElement());
    result.setReference(location_p.getReference());
    return result;
  }
  
  /**
   * Set the elementId attribute of the given location according to the given
   * element
   * @param location_p a non-null location
   * @param element_p a potentially null element
   */
  private void setElementId(AbstractIDBasedAtomicLocation location_p,
      EObject element_p) {
    location_p.setElementId(CorePatternsPlugin.getDefault().getIdProvider().getId(element_p, 
        AdapterFactoryEditingDomain.getEditingDomainFor(element_p)));
  }
  
  /**
   * Set the elementId attribute of the given location according to the given
   * resource
   * @param location_p a non-null location
   * @param resource_p a potentially null resource
   */
  private void setElementId(AbstractIDBasedAtomicLocation location_p,
      Resource resource_p) {
    if (resource_p != null && resource_p.getURI() != null) {
      location_p.setElementId(resource_p.getURI().toString());
    }
  }
  
}
