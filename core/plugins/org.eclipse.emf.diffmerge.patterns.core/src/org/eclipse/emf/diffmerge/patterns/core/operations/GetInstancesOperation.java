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
package org.eclipse.emf.diffmerge.patterns.core.operations;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.Messages;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.ecore.EObject;


/**
 * A model operation that consists in retrieving the pattern instances that a given
 * model element belongs to.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class GetInstancesOperation extends AbstractModelOperation<List<IPatternInstance>> {
  
  /** The non-null element from which to retrieve pattern instances */
  private final EObject _element;
  
  
  /**
   * Constructor
   * @param element_p the non-null element from which to retrieve pattern instances
   */
  public GetInstancesOperation(EObject element_p, Object targetContext_p) {
    super(Messages.GetInstancesOperation_Name,
        element_p.eResource() != null? element_p.eResource().getResourceSet(): null,
            false, true, false, targetContext_p, targetContext_p);
    _element= element_p;
  }
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected List<IPatternInstance> run() {
    List<IPatternInstance> result = null;
    IPatternSupport patternSupport =
      CorePatternsPlugin.getDefault().getPatternSupportFor(_element);
    if (patternSupport != null) {
      result = patternSupport.getRelatedInstances(_element);
    }
    return result;
  }

}
