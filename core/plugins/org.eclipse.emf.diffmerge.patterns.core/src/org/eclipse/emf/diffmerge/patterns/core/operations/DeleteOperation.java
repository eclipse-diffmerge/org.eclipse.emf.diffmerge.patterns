/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.core.operations;

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.core.Messages;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.ModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * A model operation that consists in removing a given set of model elements from
 * their resources and deleting cross-references to these elements in the relevant scope.
 * Extend for specific modelers and scopes.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class DeleteOperation extends AbstractModelOperation<IModelTransformationStatus> {
  
  /** The non-null, potentially empty set of elements to delete */
  private final Collection<EObject> _toDelete;
  
	/**
	 * Constructor
	 * @param toDelete_p a non-null, potentially empty collection of the elements to delete
	 * @param isExpensive_p whether the operation should be considered as expensive
	 */
	public DeleteOperation(Collection<? extends EObject> toDelete_p, boolean isExpensive_p, 
      Object targetContext_p) {
    super(Messages.DeleteOperation_Name, null, true, false, isExpensive_p, 
        targetContext_p, null);
    _toDelete = new ModelsUtil.ROrderedSet<EObject>(toDelete_p);
	}
	
	/**
	 * Return the elements to delete
	 * @return a non-null, potentially empty collection
	 */
	protected Collection<EObject> getElementsToDelete() {
	  return _toDelete;
	}
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected IModelTransformationStatus run() {
    boolean failed = false;
    for (EObject element : getElementsToDelete()) {
      try {
        delete(element);
      } catch (RuntimeException e) {
        failed = true; // Still proceed
      }
    }
    return failed? new ModelTransformationStatus(false, Messages.DeleteOperation_Failure):
      SimpleStatus.SUCCESS;
  }
  
  /**
   * Delete the given element (in the sense of EcoreUtil.delete) and all its children,
   * recursively, starting with the leaves of the containment tree
   * @param element_p the element to delete
   */
  protected void delete(EObject element_p) {
    for (EObject child : element_p.eContents())
      delete(child);
    EcoreUtil.delete(element_p);
  }

}
