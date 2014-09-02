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
package org.eclipse.emf.diffmerge.patterns.core.util;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;


/**
 * A simple abstract implementation of IPatternSymbol.
 * @author Olivier Constant
 */
public class AbstractPatternSymbol implements IPatternSymbol {
  
  /** The repository ID */
  private final String _repositoryId;
  
  /** The pattern ID */
  private final String _patternId;
  
  /** The non-null last name of the pattern */
  private final String _lastPatternName;
  
  /** The non-null content of the last URI of the pattern */
  private final String _lastPath;
  
  
  /**
   * Constructor
   * @param repositoryId_p a non-null repository ID
   * @param patternId_p a non-null pattern ID
   * @param lastPatternName_p the non-null last name of the pattern
   * @param lastPath_p the non-null last URI of the pattern as string
   */
  public AbstractPatternSymbol(String repositoryId_p, String patternId_p,
      String lastPatternName_p, String lastPath_p) {
    _repositoryId = repositoryId_p;
    _patternId = patternId_p;
    _lastPatternName = lastPatternName_p;
    _lastPath = lastPath_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement#getName()
   */
  public String getName() {
    return _lastPatternName;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol#getLastPath()
   */
  public String getLastPath() {
    return _lastPath;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol#getPatternId()
   */
  public String getPatternId() {
    return _patternId;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol#getRepositoryId()
   */
  public String getRepositoryId() {
    return _repositoryId;
  }
  
}
