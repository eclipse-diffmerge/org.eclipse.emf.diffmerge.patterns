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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * An observable object dealing with the selection of a template pattern.
 * @author Olivier Constant
 */
public interface ITemplatePatternSelection extends IRepositorySelection, IPatternProvider {
  
  /**
   * An interface for observers which are concerned with the pattern currently selected
   */
  public static interface IPatternChangedListener {
    /**
     * Notifies that the selected pattern changed from the given old one to the given new one
     * @param newPattern_p a potentially null pattern
     */
    void patternChanged(TemplatePattern newPattern_p);
  }
  
  
  /**
   * Add a listener on the selected pattern
   * @param listener_p a non-null listener
   */
  void addSelectedPatternListener(IPatternChangedListener listener_p);
  
  /**
   * Refinement by covariance of IPatternProvider.getPattern()
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider#getPattern()
   */
  TemplatePattern getPattern();
  
  /**
   * Set the selected pattern
   * @param pattern_p a potentially null pattern
   */
  void setPattern(TemplatePattern pattern_p);
  
}
