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
package org.eclipse.emf.diffmerge.patterns.core.api.ext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;

/**
 * A definition of the embedding of pattern instances into models.
 * Concrete implementers must have a parameterless constructor.
 * @author Olivier Constant
 * @author Skander Turki
 */
public interface IPatternSupport {
  
  /**
   * Return whether this pattern support is applicable to the given element,
   * i.e., whether it is able to make the element belong to a pattern instance
   * @param element_p a non-null model element
   */
  boolean isApplicableTo(EObject element_p);
  
  /**
   * Return whether this pattern support is applicable to the given pattern application,
   * i.e., whether it is able to turn the pattern application to a pattern instance
   * @param application_p a non-null pattern application
   */
  boolean isApplicableTo(IPatternApplication application_p);
  
  /**
   * Create an instance of a pattern according to the given pattern application
   * and store it
   * Precondition: isApplicableTo(application_p)
   * @param application_p a non-null application of the pattern
   * @return a non-null instance
   */
  IPatternInstance createInstance(IPatternApplication application_p);
  
  /**
   * Return the instances which are present in the model defined by the given context
   * @param context_p a non-null object to use as context
   * @return a non-null, potentially empty, unmodifiable list of instances
   */
  List<IPatternInstance> getAllInstances(Object context_p);
  
  /**
   * Return the instances in which the given element is involved, if any
   * @param element_p a non-null element
   * @return a non-null, potentially empty, unmodifiable list of instances
   */
  List<IPatternInstance> getRelatedInstances(EObject element_p);
  
  /**
   * Return whether the given element is involved in an instance
   * @param element_p a non-null element
   */
  boolean hasRelatedInstances(EObject element_p);
  
  /**
   * Store the given pattern instance previously created by this pattern support
   * in the context of the given pattern application
   * Precondition: isApplicableTo(instance_p)
   * @param instance_p a non-null pattern instance
   * @param context_p a non-null object to use as context
   * @return whether the operation succeeded
   */
  boolean storeInstance(IPatternInstance instance_p, Object context_p);
  
  /**
   * Returns the resource in which the semantic model referenced by the given IPatternInstanceMarker is. 
   * The IPatternInstanceMarker encodes the semantic model's pattern instances
   * @param instancesEncoder_p a non-null IPatternInstanceMarker containing pattern instances
   * @return a potentially-null resource
   */
  Resource getModelResource(IPatternInstanceMarker instancesEncoder_p);
  
  /**
   * Returns the root element containing the pattern instances related to the model of the given context.
   * @param context_p a non-null EObject 
   * @return a potentially-null IPatternInstanceMarker
   */
  IPatternInstanceMarker getPatternInstanceEncodingModel(EObject context_p);
  
  /**
   * Returns the root element containing the pattern instances related to the model of the given context.
   * @param context_p a non-null Resource 
   * @return a potentially-null IPatternInstanceMarker
   */
  IPatternInstanceMarker getPatternInstanceEncodingModel(Resource context_p);

}
