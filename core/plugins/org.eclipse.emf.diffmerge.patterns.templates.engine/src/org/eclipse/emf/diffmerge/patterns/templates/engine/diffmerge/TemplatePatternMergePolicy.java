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

import org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope;
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
   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#copyOutOfScopeCrossReferences(org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope, org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope)
   */
  @Override
  public boolean copyOutOfScopeCrossReferences(
      IFeaturedModelScope sourceScope_p, IFeaturedModelScope targetScope_p) {
    return false; // Ensure pattern/model decoupling
  }

  /**
   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#getNewIntrinsicID(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope)
   */
  @Override
  protected String getNewIntrinsicID(EObject element_p, IFeaturedModelScope scope_p) {
    String id = CorePatternsPlugin.getDefault().getIdProvider().getNewIdFor(element_p);
    return id;
  }

    /**
     * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#requiresNewIntrinsicID(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope)
     */
    @Override
    protected boolean requiresNewIntrinsicID(EObject element_p, IFeaturedModelScope scope_p) {
      IIdProvider idProvider = CorePatternsPlugin.getDefault().getIdProvider();
      if(idProvider != null){
        return idProvider.requiresNewIntrinsicID(element_p, scope_p);
      }
      return super.requiresNewIntrinsicID(element_p, scope_p);
    }

  //  /**
  //   * @see org.eclipse.emf.diffmerge.api.IMergePolicy#copyPhysicalIds()
  //   */
  //  @Override
  //  public boolean copyPhysicalIds() {
  //    return false;
  //  }
  //
  //  /**
  //   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#getNewIdFor(org.eclipse.emf.ecore.EObject)
  //   */
  //  @Override
  //  public String getNewIdFor(EObject element_p) {
  //    String id = CorePatternsPlugin.getDefault().getIdProvider().getNewIdFor(element_p);
  //    return id;
  //  }
  //
  //  /**
  //   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#useNewEcoreIds
  //   */
  //  @Override
  //  public boolean useNewEcoreIds() {
  //    return true;
  //  }
  //
  //  /**
  //   * 
  //   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultMergePolicy#copyId(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
  //   */
  //  @Override
  //  public void copyId(EObject source_p, EObject target_p) {
  //    if (useNewEcoreIds()) {
  //      String newId = CorePatternsPlugin.getDefault().getIdProvider().getNewIdFor(target_p);
  //      if (newId != null)
  //        ModelImplUtil.setEcoreId(target_p, newId);
  //    }
  //  }

}
