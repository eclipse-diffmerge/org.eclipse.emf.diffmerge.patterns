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
package org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IDeleteOperationProvider;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.ModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonpatternsupportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Pattern Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CommonPatternInstanceImpl extends AbstractPatternInstanceImpl implements CommonPatternInstance {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CommonPatternInstanceImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return CommonpatternsupportPackage.Literals.COMMON_PATTERN_INSTANCE;
	}

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance#delete(boolean)
   * @generated NOT
   */
  public IModelTransformationStatus delete(boolean keepElements_p) {
    IModelTransformationStatus result = SimpleStatus.SUCCESS;
    if (!keepElements_p) {
      List<EObject> instanceElements = getElements();
      if (!instanceElements.isEmpty()) {
        IDeleteOperationProvider deleteProvider =
            CorePatternsPlugin.getDefault().getDeleteOperationProvider();
        IModelOperation<IModelTransformationStatus> op =
            deleteProvider.getDeleteOperation(instanceElements, false, true, instanceElements);
        result = CorePatternsPlugin.getDefault().getModelEnvironment().execute(op);
      }
    }
    if (result == null)
      result = new ModelTransformationStatus(false, false, null);
    if (result.isOk()) {
      try {
        // Remove instance from container; no other reference to or from the instance
        //Fix: for EResource that is null after last transaction is committed
        boolean reloaded = false;
        Resource res = this.eResource();
        if(res == null){
          reloaded = true;
          EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(this);
          EObject found = CorePatternsPlugin.getDefault().getIdProvider().getById(this.getId(), domain.getResourceSet().getResources());
          if(found instanceof IPatternInstance){
            EcoreUtil.remove(found);
          }
        }
        if(!reloaded)
          res = this.eResource();
          EcoreUtil.remove(this);
         // res.save(null);
      } catch (RuntimeException e) {
        result = new SimpleStatus(false, "Unable to delete instance."); //$NON-NLS-1$
      } 
        //catch (IOException e) {
//        result = new SimpleStatus(false, e.getMessage());
//      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance#isDeleted()
   * @generated NOT
   */
  public boolean isDeleted() {
    return eContainer() == null;
  }

} //CommonPatternInstanceImpl
