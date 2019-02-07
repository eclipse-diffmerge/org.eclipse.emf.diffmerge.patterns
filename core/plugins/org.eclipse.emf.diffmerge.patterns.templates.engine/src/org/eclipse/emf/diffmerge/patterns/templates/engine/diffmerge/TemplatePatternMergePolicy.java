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
import org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;
import org.eclipse.emf.ecore.EObject;


/**
 * A merge policy for template pattern comparison.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class TemplatePatternMergePolicy extends DefaultMergePolicy {

  /**
   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#copyOutOfScopeCrossReferences(org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope, org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope)
   */
  @Override
  public boolean copyOutOfScopeCrossReferences(
      ITreeDataScope<EObject> sourceScope_p, ITreeDataScope<EObject> targetScope_p) {
    return false; // Ensure pattern/model decoupling
  }

  /**
   * @see org.eclipse.emf.diffmerge.generic.impl.policies.DefaultMergePolicy#getNewIntrinsicID(java.lang.Object, org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope)
   */
  @Override
  protected String getNewIntrinsicID(EObject element_p, ITreeDataScope<EObject> scope_p) {
    String id = CorePatternsPlugin.getDefault().getIdProvider().getNewIdFor(element_p);
    return id;
  }

  /**
   * @see org.eclipse.emf.diffmerge.generic.impl.policies.DefaultMergePolicy#requiresNewIntrinsicID(java.lang.Object, org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope)
   */
  @Override
  protected boolean requiresNewIntrinsicID(EObject element_p, ITreeDataScope<EObject> scope_p) {
    IIdProvider idProvider = CorePatternsPlugin.getDefault().getIdProvider();
    if(idProvider != null){
      return idProvider.requiresNewIntrinsicID(element_p, scope_p);
    }
    return super.requiresNewIntrinsicID(element_p, scope_p);
  }

}
