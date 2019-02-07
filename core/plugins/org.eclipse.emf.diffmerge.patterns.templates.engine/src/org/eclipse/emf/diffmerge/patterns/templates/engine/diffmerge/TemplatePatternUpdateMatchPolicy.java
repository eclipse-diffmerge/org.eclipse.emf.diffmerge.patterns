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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope;
import org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.templates.engine.resources.PatternVirtualResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A match policy that uses the PatternVirtualResource to trace back copies to original elements in order to get ids for them.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class TemplatePatternUpdateMatchPolicy extends DefaultMatchPolicy{


  /** The non-null update comparison */
  private final TemplatePatternUpdateComparison _updateComparison;

  /** Editing domain of the pattern */
  private EditingDomain _referenceEditingDomain;

  /** Editing domain of the instances */
  private EditingDomain _targetEditingDomain;

  /**
   * Constructor
   * @param updateComparison_p a non-null update comparison
   * @param referenceEditingDomain_p a non-null EditingDomain
   * @param targetEditingDomain_p a non-null EditingDomain
   */
  public TemplatePatternUpdateMatchPolicy(
      TemplatePatternUpdateComparison updateComparison_p,
      EditingDomain referenceEditingDomain_p,
      EditingDomain targetEditingDomain_p) {
    _updateComparison = updateComparison_p;
    _referenceEditingDomain = referenceEditingDomain_p;
    _targetEditingDomain = targetEditingDomain_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMatchPolicy#getMatchID(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope)
   */
  @Override
  public Object getMatchID(EObject element_p, ITreeDataScope<EObject> scope_p) {
    EditingDomain currentEditingDomain = null;
    IIdProvider idProvider = CorePatternsPlugin.getDefault().getIdProvider();
    Comparable<?> result = null;

    if(element_p instanceof AbstractIdentifiedElement){
      result = EcoreUtil.getID(element_p);
      return result;
    }

    if (_updateComparison != null){
      if(scope_p == _updateComparison.getReferenceScope()){
        currentEditingDomain = _referenceEditingDomain;
        return idProvider.getId(element_p, currentEditingDomain);
      }else if(scope_p == _updateComparison.getTargetScope()){
        currentEditingDomain = _targetEditingDomain;
        if(element_p.eResource() instanceof PatternVirtualResource){
          PatternVirtualResource res = (PatternVirtualResource)element_p.eResource();
          return res.getID(element_p);
        }
      }
    }
   
    return result;
  }

}
