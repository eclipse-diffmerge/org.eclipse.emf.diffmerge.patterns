/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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
