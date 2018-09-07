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
package org.eclipse.emf.diffmerge.patterns.core.gen;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol;


/**
 * A class which converts elements from the EMF-independent Patterns API to
 * equivalent ones which are suitable for usage and storage with Patterns.Gen.
 * @author Olivier Constant
 */
public class PatternsCoreGenAdapter {
  
  /** The shared instance **/
  public static final PatternsCoreGenAdapter GEN_ADAPTER =
    new PatternsCoreGenAdapter();
  
  /**
   * Constructor
   */
  protected PatternsCoreGenAdapter() {
    // Cannot be called from outside class hierarchy
  }
  
  /**
   * Convert the given pattern symbol
   * @param symbol_p a non-null pattern symbol
   * @return a non-null pattern symbol for usage with eMDE pattern support
   */
  public PatternSymbol adapt(IPatternSymbol symbol_p) {
    PatternSymbol result = CorepatternsFactory.eINSTANCE.createPatternSymbol();
    result.setRepositoryId(symbol_p.getRepositoryId());
    result.setPatternId(symbol_p.getPatternId());
    result.setName(symbol_p.getName());
    result.setLastPath(symbol_p.getLastPath());
    return result;
  }
  
  /**
   * Convert the given pattern role symbol
   * @param symbol_p a non-null pattern role symbol
   * @return a non-null pattern role symbol for usage with eMDE pattern support
   */
  public PatternRoleSymbol adapt(IPatternRoleSymbol symbol_p) {
    PatternRoleSymbol result = CorepatternsFactory.eINSTANCE.createPatternRoleSymbol();
    result.setRepositoryId(symbol_p.getRepositoryId());
    result.setPatternId(symbol_p.getPatternId());
    result.setRoleId(symbol_p.getRoleId());
    result.setName(symbol_p.getName());
    result.setLastPath(symbol_p.getLastPath());
    return result;
  }
  
}
