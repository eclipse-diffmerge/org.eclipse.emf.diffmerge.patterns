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
package org.eclipse.emf.diffmerge.patterns.core.api;

import java.util.List;

import org.eclipse.emf.ecore.EObject;


/**
 * Pattern data are specific information stored by a pattern in its instances.
 * These data are used by patterns to carry out instance operations such as fold,
 * unfold or update.
 * @author Olivier Constant
 */
public interface IPatternData extends IPatternInstanceMarker {
  
  /**
   * Return the pattern instance that owns the pattern data
   * @return a non-null pattern instance
   */
  IPatternInstance getInstance();
  
  /**
   * Return the elements that belong to the instance
   * @return a non-null, potentially empty, unmodifiable list
   */
  List<EObject> getInstanceElements();
  
}
