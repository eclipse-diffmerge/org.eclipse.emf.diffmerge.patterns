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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.impl.scopes.RootedModelScope;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * This class defines a model scope covering the template elements of a template pattern.
 * Direct modifications of the pattern may not affect the scope (roots), whereas modifications
 * of the scope always affect the pattern.
 * @author Olivier Constant
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
   * @see org.eclipse.emf.diffmerge.impl.scopes.AbstractModelScope#get(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, boolean)
   */
  @Override
  protected List<EObject> get(EObject source_p, EReference reference_p,
      boolean resolveProxies_p) {
    List<EObject> defaultResult = super.get(source_p, reference_p, resolveProxies_p);
    // Handling the exceptional case where the pattern catalog contains duplicate IDs
    List<EObject> result = new ArrayList<EObject>(defaultResult.size());
    TemplatePattern expectedPattern = getPattern();
    for (EObject value : defaultResult) {
      TemplatePattern valuePattern = getContainingPattern(value);
      if (valuePattern != null && valuePattern != expectedPattern) {
        EObject expectedElement = getExpectedElement(value, expectedPattern);
        if (expectedElement != null)
          value = expectedElement;
      }
      result.add(value);
    }
    return result;
  }
  
  /**
   * Return the pattern that contains the given element, if any
   * @param element_p a non-null element
   * @return a potentially null object
   */
  protected TemplatePattern getContainingPattern(EObject element_p) {
    EObject container = element_p.eContainer();
    while (container != null && !(container instanceof TemplatePattern)) {
      container = container.eContainer();
    }
    TemplatePattern result = container instanceof TemplatePattern? (TemplatePattern)container: null;
    return result;
  }
  
  /**
   * Return the element that corresponds to the given one within the given pattern, if any
   * @param element_p a non-null element
   * @param expectedPattern_p a non-null pattern
   * @return a potentially null element
   */
  protected EObject getExpectedElement(EObject element_p, TemplatePattern expectedPattern_p) {
    String id = EcoreUtil.getID(element_p);
    if (id != null) {
      Iterator<EObject> it = expectedPattern_p.eAllContents();
      while (it.hasNext()) {
        EObject current = it.next();
        String currentId = EcoreUtil.getID(current);
        if (id.equals(currentId))
          return current;
      }
    }
    return null;
  }
  
  /**
   * Return the template pattern on which this model scope is defined
   * @return a non-null template pattern
   */
  public TemplatePattern getPattern() {
    return _pattern;
  }
  
}
