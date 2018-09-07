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
package org.eclipse.emf.diffmerge.patterns.core.api;

/**
 * A symbol which non-ambiguously identifies a pattern
 * @author Olivier Constant
 */
public interface IPatternSymbol extends IPatternInstanceMarker, INamedElement {
  
  /**
   * Return the content of the last URI for the pattern
   * @return a potentially null string
   */
  String getLastPath();
  
  /**
   * Return the ID of the pattern, unique within its repository
   * @return a non-null ID
   */
  String getPatternId();
  
  /**
   * Return the ID of the repository, unique within the platform
   * @return a non-null ID
   */
  String getRepositoryId();
  
}
