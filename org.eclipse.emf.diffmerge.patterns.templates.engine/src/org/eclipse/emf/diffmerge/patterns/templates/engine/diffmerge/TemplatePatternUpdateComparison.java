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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.IMergePolicy;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A comparison specifically tailored for updating a pattern by merge.
 * The comparison is between the original pattern to update (pattern role) and the copy used for defining
 * the update (opposite role).
 * @author Olivier Constant
 */
public class TemplatePatternUpdateComparison extends TemplatePatternComparison {
  
  /** The non-null update specification */
  private final TemplatePatternUpdateSpecification _specification;
  
  /**
   * Constructor
   * @param pattern_p a non-null template pattern
   * @param application_p a non-null pattern application
   */
  public TemplatePatternUpdateComparison(TemplatePatternUpdateSpecification specification_p) {
    super(specification_p.getOriginalPattern(),
        new TemplatePatternScope(specification_p.getOriginalPattern()),
        new TemplatePatternScope(specification_p.getPattern()));
    _specification = specification_p;
  }
  
  /**
   * Incrementally update the data of the instance according to the current mapping
   */
  private void extendPatternData() {
    TemplatePatternApplicationComparison applicationComparison =
      getSpecification().getComparison();
    TemplatePatternData data = applicationComparison.getPatternData();
    Role applicationRole = TemplatePatternApplicationComparison.getApplicationRole();
    if (data != null) {
      Collection<IMatch> updatedMatches = applicationComparison.getUpdatedMatches();
      for (IMatch match : updatedMatches) {
        EObject instanceElement = match.get(applicationRole);
        EObject intermediateTemplateElement = match.get(getPatternRole());
        IMatch patternMatch = getMapping().getMatchFor(intermediateTemplateElement, applicationRole);
        if (patternMatch != null) {
          EObject templateElement = patternMatch.get(getPatternRole());
          String mappingMultipart = applicationComparison.getMainMultipart();
          if (!getPattern().isUnique(templateElement) &&
              applicationComparison.getCurrentMultipart() != null)
            mappingMultipart = applicationComparison.getCurrentMultipart();
          data.map(instanceElement, templateElement, mappingMultipart);
          data.markAsUnfolded(instanceElement);
        }
      }
    }
  }
  
  /**
   * Return the update specification of this comparison
   * @return a non-null update specification
   */
  public TemplatePatternUpdateSpecification getSpecification() {
    return _specification;
  }
  
  /**
   * Perform the update of the original pattern
   * @return a non-null status
   */
  public IStatus updatePattern() {
    IMergePolicy mergePolicy = new TemplatePatternMergePolicy() {
      /**
       * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#useNewEcoreIds
       */
//      @Override
//      public boolean useNewEcoreIds() {
//        return false;
//      }
    };
    IStatus result = compute(new TemplatePatternUpdateMatchPolicy(this, 
        AdapterFactoryEditingDomain.getEditingDomainFor(getReferenceScope().getContents().get(0)),
        AdapterFactoryEditingDomain.getEditingDomainFor(getTargetScope().getContents().get(0))),
        new TemplatePatternDiffPolicy(_specification.getIgnoredFeatures()),
        mergePolicy, null);
    if (result.isOK()) {
      // Update original pattern
      merge(getPatternRole(), true, null);
      updateRoleOrder();
      // Update pattern data in instance
      extendPatternData();
    }
    return result;
  }
  
  /**
   * Update the order of the roles in the original pattern after merge
   */
  private void updateRoleOrder() {
    EList<TemplatePatternRole> sourceRoles = _specification.getPattern().getRoles();
    EList<TemplatePatternRole> targetRoles = _specification.getOriginalPattern().getRoles();
    assert sourceRoles.size() == targetRoles.size(); // Because merge has been performed
    for (int i=0; i<sourceRoles.size(); i++) {
      TemplatePatternRole sourceRole = sourceRoles.get(i);
      IMatch match = getMapping().getMatchFor(sourceRole, getPatternRole().opposite());
      assert match != null;
      TemplatePatternRole targetRole = (TemplatePatternRole)match.get(getPatternRole());
      assert targetRole != null;
      targetRoles.move(i, targetRole);
    }
  }
  
}
