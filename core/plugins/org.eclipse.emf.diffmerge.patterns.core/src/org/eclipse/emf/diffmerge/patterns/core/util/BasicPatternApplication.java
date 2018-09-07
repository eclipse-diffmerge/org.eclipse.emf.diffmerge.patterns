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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ICompositeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IResourceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicCompositeLocation;


/**
 * A simple implementation of IPatternApplication.
 * @author Olivier Constant
 */
public class BasicPatternApplication implements IPatternApplication {
  
  /** The pattern */
  private final IPattern _pattern;
  
  /** The (role, location) mapping */
  private final Map<IPatternRole, ILocation> _roleToLocation;
  
  /** An optional scope element (typically element, resource) */
  private final Object _scopeElement;
  
  
  /**
   * Constructor
   * @param pattern_p a non-null pattern
   */
  public BasicPatternApplication(IPattern pattern_p) {
    this(pattern_p, null);
  }
  
  /**
   * Constructor
   * @param pattern_p a non-null pattern
   * @param scopeElement_p an optional scope element
   */
  public BasicPatternApplication(IPattern pattern_p, Object scopeElement_p) {
    _pattern = pattern_p;
    _roleToLocation = new HashMap<IPatternRole, ILocation>();
    _scopeElement = scopeElement_p;
  }
  
  /**
   * Associate the given location to the given role, keeping all locations
   * already associated to the same role
   * @param role_p a non-null role
   * @param location_p a non-null location
   */
  public void addLocation(IPatternRole role_p, ILocation location_p) {
    ILocation existing = _roleToLocation.get(role_p);
    if (existing instanceof ICompositeLocation) {
      // Add atomic contents to existing composite location
      ((ICompositeLocation)existing).getOwnedLocations().addAll(
          location_p.getAtomicContents());
    } else if (location_p instanceof ICompositeLocation && existing != null) {
      // Use passed composite and update its contents with existing location
      ICompositeLocation composite = (ICompositeLocation)location_p;
      List<IAtomicLocation> contentsCopy = new ArrayList<IAtomicLocation>(
          composite.getOwnedLocations());
      composite.getOwnedLocations().clear();
      composite.getOwnedLocations().addAll(existing.getAtomicContents());
      composite.getOwnedLocations().addAll(contentsCopy);
      setLocation(role_p, composite);
    } else if (existing instanceof IAtomicLocation &&
        location_p instanceof IAtomicLocation) {
      // Merge 2 atomic locations
      ICompositeLocation composite = new BasicCompositeLocation();
      composite.getOwnedLocations().add((IAtomicLocation)existing);
      composite.getOwnedLocations().add((IAtomicLocation)location_p);
      setLocation(role_p, composite);
    } else {
      // New role
      setLocation(role_p, location_p);
    }
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#checkConformance(java.util.List)
   */
  public IPatternConformityStatus checkConformance(List<EStructuralFeature> ignoredFeatures_p) {
    return _pattern.checkConformance(this, ignoredFeatures_p);
  }
  
  /**
   * Return the roles that the given element is bound to for addition
   * @param element_p a non-null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public List<IPatternRole> getAdditionRolesOf(EObject element_p) {
    List<IPatternRole> result = new ArrayList<IPatternRole>();
    for (IPatternRole role : getPattern().getRoles()) {
      ILocation location = getLocation(role);
      if (location != null) {
        for (IAtomicLocation atomicLocation : location.getAtomicContents()) {
          if (atomicLocation instanceof IReferenceLocation) {
            EObject element = ((IElementRelativeLocation)atomicLocation).getElement();
            if (element == element_p) {
              result.add(role);
              break;
            }
          }
        }
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getLocation(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole)
   */
  public ILocation getLocation(IPatternRole role_p) {
    return _roleToLocation.get(role_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getLocations()
   */
  public Collection<ILocation> getLocations() {
    Collection<ILocation> result = new ModelsUtil.ROrderedSet<ILocation>();
    for (ILocation loc : _roleToLocation.values()) {
      if (loc != null)
        result.add(loc);
    }
    return Collections.unmodifiableCollection(result);
  }
  
  /**
   * Return the roles that the given element is bound to for merge
   * @param element_p a non-null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public List<IPatternRole> getMergeRolesOf(EObject element_p) {
    List<IPatternRole> result = new ArrayList<IPatternRole>();
    for (IPatternRole role : getPattern().getRoles()) {
      ILocation location = getLocation(role);
      if (location != null) {
        List<EObject> mergeTargets = LocationsUtil.getMergeTargets(location);
        if (mergeTargets.contains(element_p))
          result.add(role);
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getPattern()
   */
  public IPattern getPattern() {
    return _pattern;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getRolesOf(org.eclipse.emf.ecore.EObject)
   */
  public List<IPatternRole> getRolesOf(EObject element_p) {
    List<IPatternRole> result = new ArrayList<IPatternRole>();
    for (IPatternRole role : getPattern().getRoles()) {
      ILocation location = getLocation(role);
      if (location != null) {
        for (IAtomicLocation atomicLocation : location.getAtomicContents()) {
          if (atomicLocation instanceof IElementRelativeLocation) {
            EObject element = ((IElementRelativeLocation)atomicLocation).getElement();
            if (element == element_p) {
              result.add(role);
              break; // Assumes an element is not mapped to several roles
            }
          } else if (atomicLocation instanceof IElementMappingLocation) {
            IElementMappingLocation mappingLocation = (IElementMappingLocation)atomicLocation;
            for (EObject patternElement : mappingLocation.getPatternElements(getPattern())) {
              EObject modelElement = mappingLocation.getElement(patternElement);
              if (modelElement == element_p) {
                result.add(role);
                break; // An IElementMappingLocation defines a bijection
              }
            }
          }
        }
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IUserScopeProvider#getScopeElement()
   */
  public Object getScopeElement() {
    if (_scopeElement != null)
      return _scopeElement;
    for (ILocation location : getLocations()) {
      for (IAtomicLocation atomicLocation : location.getAtomicContents()) {
        if (atomicLocation instanceof IElementRelativeLocation)
          return ((IElementRelativeLocation)atomicLocation).getElement();
        else if (atomicLocation instanceof IResourceLocation)
          return ((IResourceLocation)atomicLocation).getResource();
      }
    }
    return null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#isComplete()
   */
  public boolean isComplete() {
    for (IPatternRole role : getPattern().getRoles()) {
      if (!role.checkCompleteApplicability(getLocation(role), this).isOk())
        return false;
    }
    return true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#isCompleteOn(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole)
   */
  public boolean isCompleteOn(IPatternRole role_p) {
    return role_p.checkCompleteApplicability(getLocation(role_p), this).isOk();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#isEmpty()
   */
  public boolean isEmpty() {
    if (getPattern() == null)
      return true;
    for (IPatternRole role : getPattern().getRoles()) {
      if (isCompleteOn(role))
        return false;
    }
    return true;
  }
  
  /**
   * Remove the given location for the given role
   * @param role_p a non-null role
   * @param location_p a non-null location
   */
  public void removeLocation(IPatternRole role_p, ILocation location_p) {
    ILocation existing = _roleToLocation.get(role_p);
    if (existing == location_p) {
      setLocation(role_p, null);
    } else if (existing instanceof ICompositeLocation) {
      ICompositeLocation composite = (ICompositeLocation)existing;
      composite.getOwnedLocations().remove(location_p);
      if (composite.getOwnedLocations().isEmpty())
        setLocation(role_p, null);
    }
  }
  
  /**
   * Associate the given location to the given role, removing any existing
   * location associated to the same role
   * @param role_p a non-null role
   * @param location_p a potentially null location
   */
  public void setLocation(IPatternRole role_p, ILocation location_p) {
    _roleToLocation.put(role_p, location_p);
  }
  
}
