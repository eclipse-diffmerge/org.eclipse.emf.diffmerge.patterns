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
 * A symbol which non-ambiguously identifies a role of a pattern
 * @author Olivier Constant
 */
public interface IPatternRoleSymbol extends IPatternSymbol {
  
  /**
   * Return the ID of the role, unique within the pattern
   * @return a non-null ID
   */
  String getRoleId();
  
}
