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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import java.util.Collections;

import org.eclipse.emf.diffmerge.impl.scopes.RootedModelScope;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * This class defines a model scope which entirely covers a template pattern.
 * @author Olivier Constant
 */
public class TemplatePatternScope extends RootedModelScope {
  
  /** The non-null template pattern which defines the scope */
  private final TemplatePattern _pattern;
  
  /**
   * Constructor
   * @param pattern_p the non-null pattern which defines the scope
   */
  public TemplatePatternScope(TemplatePattern pattern_p) {
    super(Collections.<TemplatePattern>singletonList(pattern_p));
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
