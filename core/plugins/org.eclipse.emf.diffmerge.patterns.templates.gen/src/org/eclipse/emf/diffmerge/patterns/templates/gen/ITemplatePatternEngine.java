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
package org.eclipse.emf.diffmerge.patterns.templates.gen;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IRoleApplicabilityStatus;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;


/**
 * An engine which realizes the features of template patterns.
 * @author Olivier Constant
 */
public interface ITemplatePatternEngine {
  
  /**
   * Check the given constraint on the given element
   * @param constraint_p a non-null constraint
   * @param element_p a non-null element
   * @see AbstractRoleConstraint#check(ILocation)
   */
  IPatternConformityStatus checkConstraint(TextualRoleConstraint constraint_p, EObject element_p);
  
  /**
   * Check the given constraint on the given elements
   * @param constraint_p a non-null constraint
   * @param elements_p a non-null, potentially empty collection
   * @see AbstractRoleConstraint#check(ILocation)
   */
  IPatternConformityStatus checkConstraintOnCollection(TextualRoleConstraint constraint_p,
      Collection<? extends EObject> elements_p);
  
  /**
   * Check applicability of a single root template element on an atomic location
   * in the perspective of adding the template element.
   * Precondition: location_p.supportsAddition()
   * @param location_p a non-null atomic location which supports addition
   * @param rootTemplateElement_p a non-null element
   * @return a non-null status
   */
  IRoleApplicabilityStatus checkAtomicAdditionApplicability(
      IAtomicLocation location_p, EObject rootTemplateElement_p);
  
  /**
   * Check applicability of a single root template element on an atomic location
   * in the respective of merging the template element
   * @param location_p a non-null atomic location which supports merge
   * @param rootTemplateElement_p a non-null element
   * @return a non-null status
   */
  IRoleApplicabilityStatus checkAtomicMergeApplicability(
      IElementRelativeLocation location_p, EObject rootTemplateElement_p);
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#checkConformance(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication, java.util.List)
   */
  IPatternConformityStatus checkConformance(TemplatePattern pattern_p,
      IPatternApplication application_p, List<EStructuralFeature> ignoredFeatures_p);
  
  /**
   * This method is called every time an instance of a template pattern is created.
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#createDataFor(IPatternInstance, Object)
   */
  IPatternData createPatternData(TemplatePattern pattern_p, IPatternInstance instance_p, Object context_p);
  
  /**
   * @see AbstractRoleDerivationRule#deriveCandidateElements(IPatternApplication)
   */
  EList<EObject> deriveCandidateElements(TextualRoleDerivationRule rule_p, IPatternApplication context_p);
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#fold(IPatternInstance)
   */
  IModelTransformationStatus fold(TemplatePattern pattern_p, IPatternInstance instance_p);
  
  /**
   * Return the identifier for the main multi-part in instances 
   * @return a non-null string
   */
  String getMainMultipart();
  
  /**
   * Rename the instance elements based on the given naming rule
   * @param instance_p a non-null instance
   * @param newNamingRule a potentially null string
   * @param keepUserNames whether non-conforming names must be preserved
   */
  void renameElements(IPatternInstance instance_p, String newNamingRule, boolean keepUserNames);
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#unfold(IPatternInstance)
   */
  IModelTransformationStatus unfold(TemplatePattern pattern_p, IPatternInstance instance_p);
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern#updateModel(IPatternInstance, org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification)
   */
  IModelTransformationStatus updateModel(TemplatePattern pattern_p, IPatternInstance instance_p,
      IPattern.IModelUpdateSpecification specification_p);
  
}
