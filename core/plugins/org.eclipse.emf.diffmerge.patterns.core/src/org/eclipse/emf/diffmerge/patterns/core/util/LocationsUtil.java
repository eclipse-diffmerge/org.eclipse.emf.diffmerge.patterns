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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;


/**
 * A utility class related to the usage of locations.
 * @author Olivier Constant
 */
public final class LocationsUtil {

  /**
   * Constructor
   */
  private LocationsUtil() {
    // Forbids instantiation
  }

  /**
   * Add the given element at the given reference location.
   * Precondition: supportsSettingOf(location_p.getReference(), element_p.eClass())
   * @param location_p a non-null reference location
   * @param element_p a non-null element
   * @return the element which was removed from the reference as a side effect of this
   *         operation, or null if no such element exists
   */
  public static EObject add(IReferenceLocation location_p, EObject element_p) {
    EObject result = null;
    EObject source = location_p.getElement();
    EReference reference = location_p.getReference();
    Object originalValue = source.eGet(reference);
    if (FeatureMapUtil.isMany(source, reference)) {
      @SuppressWarnings("unchecked")
      List<EObject> values = (List<EObject>)originalValue;
      if(!values.contains(element_p)){
        values.add(element_p);
      }

    } else {
      source.eSet(reference, element_p);
      if (originalValue instanceof EObject)
        result = (EObject)originalValue;
    }
    return result;
  }

  /**
   * Return the elements involved in the given location, either for addition or for merge
   * @param location_p a potentially null location
   * @return a non-null, potentially empty, unmodifiable ordered set
   */
  public static List<EObject> getInvolvedElements(ILocation location_p) {
    List<EObject> result = new ModelsUtil.ROrderedSet<EObject>();
    if (location_p != null) {
      for (IAtomicLocation atomicLocation : location_p.getAtomicContents()) {
        if (atomicLocation instanceof IElementRelativeLocation) {
          EObject element = ((IElementRelativeLocation)atomicLocation).getElement();
          if (element != null)
            result.add(element);
        }
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the elements directly referenced as element locations within the given location
   * @param location_p a potentially null location
   * @return a non-null, potentially empty, unmodifiable ordered set
   */
  public static List<EObject> getMergeTargets(ILocation location_p) {
    List<EObject> result = new ModelsUtil.ROrderedSet<EObject>();
    if (location_p != null) {
      for (IAtomicLocation atomicLocation : location_p.getAtomicContents()) {
        if (atomicLocation.supportsMerge()) {
          if (atomicLocation instanceof IElementLocation) {
            EObject element = ((IElementLocation)atomicLocation).getElement();
            if (element != null)
              result.add(element);
          } else if (atomicLocation instanceof IElementMappingLocation) {
            IElementMappingLocation mappingLocation = (IElementMappingLocation)atomicLocation;
            result.addAll(mappingLocation.getModelElements());
          }
        }
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return an ordered set of the elements merged with a role root in the given application
   * @param application_p a non-null pattern application
   * @return a non-null, unmodifiable ordered set
   */
  public static List<EObject> getMergeTargets(IPatternApplication application_p) {
    List<EObject> result = new ModelsUtil.ROrderedSet<EObject>();
    if (application_p.getPattern() != null) {
      for (ILocation location : application_p.getLocations()) {
        List<EObject> roleElements = getMergeTargets(location);
        result.addAll(roleElements);
      }
    }
    return result;
  }

  /**
   * Return an ordered set of the elements playing roles in the given application
   * @param application_p a non-null pattern application
   * @return a non-null, unmodifiable ordered set
   */
  public static List<EObject> getRoleElements(IPatternApplication application_p) {
    List<EObject> result = new ModelsUtil.ROrderedSet<EObject>();
    for (ILocation location : application_p.getLocations()) {
      List<EObject> roleElements = getInvolvedElements(location);
      result.addAll(roleElements);
    }
    return result;
  }

}
