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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A match policy for template pattern comparison.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class TemplatePatternMatchPolicy extends DefaultMatchPolicy {

  /** The optional application comparison */
  private final TemplatePatternApplicationComparison _applicationComparison;
  
  /** The optional editing domain of the pattern */
  private EditingDomain _referenceEditingDomain;
  
  /** The optional editing domain of the instance */
  private EditingDomain _targetEditingDomain;
  
  /**
   * Constructor
   * @param applicationComparison_p an optional application comparison
   * @param referenceEditingDomain_p the optional editing domain of the pattern
   * @param targetEditingDomain_p the optional editing domain of the instance
   */
  public TemplatePatternMatchPolicy(
      TemplatePatternApplicationComparison applicationComparison_p,
      EditingDomain referenceEditingDomain_p, EditingDomain targetEditingDomain_p) {
    _applicationComparison = applicationComparison_p;
    _referenceEditingDomain = referenceEditingDomain_p;
    _targetEditingDomain = targetEditingDomain_p;
  }

  /**
   * Return the current multipart of the comparison, if any
   * @return a potentially null string
   */
  private String getCurrentMultipart() {
    String result = null;
    if (_applicationComparison != null)
      result = _applicationComparison.getCurrentMultipart();
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy#getMatchID(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.api.scopes.IModelScope)
   */
  @Override
  public Object getMatchID(EObject element_p, IModelScope scope_p) {
    EditingDomain currentEditingDomain = null;
    if (EcoreUtil.getRootContainer(element_p) instanceof AbstractIdentifiedElement)
      currentEditingDomain = _referenceEditingDomain;
    if (currentEditingDomain == null)
      currentEditingDomain = _targetEditingDomain;
    IIdProvider idProvider = CorePatternsPlugin.getDefault().getIdProvider();
    Comparable<?> result = idProvider.getId(element_p, currentEditingDomain);
    TemplatePatternData data = null;
    if (_applicationComparison != null)
      data = _applicationComparison.getPatternData();
    if (data != null) {
      ISemanticRuleProvider ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(element_p);
      TemplateCounterpart templateCounterpart = data.getTemplateIds().get(result);
      // Element belongs to a pattern: retrieve the ID of the related instance element, if any
      if (templateCounterpart != null) {
        String instanceId = null;
        String multipart = getCurrentMultipart();
        if (multipart != null)
          // First try in current multipart
          instanceId = templateCounterpart.getInstanceParts().get(multipart);
        if (instanceId == null)
          // Then try in main multipart
          instanceId = templateCounterpart.getInstanceParts().get(
              _applicationComparison.getMainMultipart());
        if (instanceId != null) {
          result = instanceId;
        } else if (ruleProvider.canBeAutomaticallyMerged(element_p)) {
          EObject instanceElement = ruleProvider.getAutomaticMergeTarget(element_p, currentEditingDomain);
          if (instanceElement != null)
            result = idProvider.getId(instanceElement, currentEditingDomain);
        }
      } else if (ruleProvider.canBeAutomaticallyMerged(element_p)) {
        EObject instanceElement = ruleProvider.getAutomaticMergeTarget(
            element_p, _targetEditingDomain);
        if (instanceElement != null)
          result = idProvider.getId(instanceElement, _targetEditingDomain);
      }
    }
   return result;
  }

}
