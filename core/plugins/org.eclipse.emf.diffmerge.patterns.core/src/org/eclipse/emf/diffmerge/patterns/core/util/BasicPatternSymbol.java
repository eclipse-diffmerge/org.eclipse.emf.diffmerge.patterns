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
package org.eclipse.emf.diffmerge.patterns.core.util;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;


/**
 * A simple implementation of IPatternSymbol.
 * @author Olivier Constant
 */
public class BasicPatternSymbol extends AbstractPatternSymbol {
  
  /**
   * Constructor
   * @param repositoryId_p a non-null repository ID
   * @param patternId_p a non-null pattern ID
   * @param lastPatternName_p the non-null last name of the pattern
   * @param lastPath_p a potentially null URI as string
   */
  public BasicPatternSymbol(String repositoryId_p, String patternId_p,
      String lastPatternName_p, String lastPath_p) {
    super(repositoryId_p, patternId_p, lastPatternName_p, lastPath_p);
  }
  
  /**
   * Return whether the given pattern symbols represent the same pattern
   * @param symbol1_p a potentially null pattern symbol
   * @param symbol2_p a potentially null pattern symbol
   * @return true iff both symbols are null or they contain the same IDs
   */
  public static boolean areEqual(IPatternSymbol symbol1_p, IPatternSymbol symbol2_p) {
    return
      symbol1_p == null && symbol2_p == null ||
      symbol1_p != null && symbol2_p != null &&
      symbol1_p.getRepositoryId().equals(symbol2_p.getRepositoryId()) &&
      symbol1_p.getPatternId().equals(symbol2_p.getPatternId());
  }
  
}
