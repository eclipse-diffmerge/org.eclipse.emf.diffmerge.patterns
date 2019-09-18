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


/**
 * A repository of patterns
 * @author Olivier Constant
 */
public interface IPatternRepository extends IIdentifiedElement {
  
  /**
   * Return the pattern identified by the given symbol
   * @param symbol_p a non-null symbol of a pattern
   * @return a potentially null pattern
   */
  IPattern getPattern(IPatternSymbol symbol_p);
  
  /**
   * Return all the patterns in this repository
   * @return a non-null, potentially empty, unmodifiable list
   */
  List<? extends IPattern> getPatterns();
  
}
