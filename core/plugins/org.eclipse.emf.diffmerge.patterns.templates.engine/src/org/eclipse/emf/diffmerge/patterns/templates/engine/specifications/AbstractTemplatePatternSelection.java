/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationScope;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter;
import org.eclipse.emf.ecore.EObject;


/**
 * An straightforward implementation of ITemplatePatternSelection.
 * @author Olivier Constant
 */
public abstract class AbstractTemplatePatternSelection extends AbstractRepositorySelection
implements ITemplatePatternSelection {
  
  /** A filter for instance-related data */
  public static final IElementFilter INSTANCE_FILTER =
    new TemplatePatternApplicationScope.PatternInstanceMarkerFilter();
  
  /** The potentially null pattern which is selected */
  private TemplatePattern _selectedPattern;
  
  /** The observers */
  private final Collection<IPatternChangedListener> _listeners;
  
  
  /**
   * Constructor
   */
  public AbstractTemplatePatternSelection() {
    _selectedPattern = null;
    _listeners = new HashSet<IPatternChangedListener>();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection#addSelectedPatternListener(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener)
   */
  public void addSelectedPatternListener(IPatternChangedListener listener_p) {
    _listeners.add(listener_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection#getPattern()
   */
  public TemplatePattern getPattern() {
    return _selectedPattern;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#isInstanceRelated(org.eclipse.emf.ecore.EObject)
   */
  public boolean isInstanceRelated(EObject element_p) {
    return !INSTANCE_FILTER.accepts(element_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection#setPattern(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
   */
  public void setPattern(TemplatePattern pattern_p) {
    _selectedPattern = pattern_p;
    for (IPatternChangedListener listener : _listeners)
      listener.patternChanged(pattern_p);
  }
  
}
