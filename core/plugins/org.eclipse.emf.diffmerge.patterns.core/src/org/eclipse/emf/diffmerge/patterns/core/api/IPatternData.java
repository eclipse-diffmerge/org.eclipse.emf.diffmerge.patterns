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
