/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import org.eclipse.emf.diffmerge.impl.scopes.RootedModelScope;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * This class defines a model scope covering the template elements of a template pattern.
 * Direct modifications of the pattern may not affect the scope (roots), whereas modifications
 * of the scope always affect the pattern.
 * @author O. CONSTANT
 */
public class TemplatePatternContentScope extends RootedModelScope {
  
  /** The non-null template pattern which defines the scope */
  private final TemplatePattern _pattern;
  
  /**
   * Constructor
   * @param pattern_p the non-null pattern whose template elements define the scope
   */
  public TemplatePatternContentScope(TemplatePattern pattern_p) {
    super(pattern_p.getTemplateElements(), true);
    _pattern = pattern_p;
  }
  
  /**
   * Return the template pattern on which this model scope is defined
   * @return a non-null template pattern
   */
  public TemplatePattern getPattern() {
    return _pattern;
  }
  
}
