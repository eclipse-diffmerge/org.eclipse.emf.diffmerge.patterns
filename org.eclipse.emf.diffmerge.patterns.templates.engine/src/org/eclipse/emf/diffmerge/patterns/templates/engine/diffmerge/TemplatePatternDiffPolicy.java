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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.impl.policies.DefaultDiffPolicy;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * A diff policy for template pattern comparison.
 * @author Olivier Constant
 */
public class TemplatePatternDiffPolicy extends DefaultDiffPolicy {

  /** The non-null set of ignored features */
  private List<EStructuralFeature> _ignoredFeatures;



  /**
   * Constructor
   */
  public TemplatePatternDiffPolicy() {
    this(Collections.<EStructuralFeature>emptyList());
  }

  /**
   * Constructor
   * @param ignoredFeatures_p a non-null set of features to ignore
   */
  public TemplatePatternDiffPolicy(
      List<EStructuralFeature> ignoredFeatures_p) {
    super();
    _ignoredFeatures = ignoredFeatures_p;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultDiffPolicy#coverFeature(org.eclipse.emf.ecore.EStructuralFeature)
   */
  @Override
  public boolean coverFeature(EStructuralFeature feature_p) {
    if(_ignoredFeatures != null){
      return super.coverFeature(feature_p) &&
          !_ignoredFeatures.contains(feature_p);
    }
    return super.coverFeature(feature_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.api.IDiffPolicy#coverMatch(IMatch)
   */
  @Override
  public boolean coverMatch(IMatch match_p) {
    EObject obj;
    if(match_p.getUncoveredRole() != null)
      obj = match_p.get(match_p.getUncoveredRole().opposite());
    else
      obj = match_p.get(Role.TARGET);
    ISemanticRuleProvider ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(obj);
    if(ruleProvider.isMergeDependency(obj.eContainer())){
      return  false;
    }
    return match_p.coversRole(Role.TARGET) || match_p.coversRole(Role.REFERENCE);
  }
  
}

