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
