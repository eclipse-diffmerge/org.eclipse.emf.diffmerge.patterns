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
package org.eclipse.emf.diffmerge.patterns.core.api;

import org.eclipse.emf.ecore.EObject;


/**
 * A specification of data related to a given pattern including a bijection from
 * model elements to elements of the pattern.
 * @author Olivier Constant
 */
public interface IPatternBasedBijection extends IPatternBasedSpecification {
  
  /**
   * Return whether the given element belongs to the domain/codomain of the bijection
   * @param element_p a non-null element
   * @param fromPattern_p whether the given element is on the pattern side
   */
  public boolean covers(EObject element_p, boolean fromPattern_p);
  
  /**
   * Return the counterpart of the given element
   * @param element_p a non-null element
   * @param fromPattern_p whether the given element is on the pattern side
   * @return a potentially null element
   */
  public EObject getCounterpart(EObject element_p, boolean fromPattern_p);
  
}
