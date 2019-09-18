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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;


/**
 * A data structure which contains all useful data for browsing pattern repositories.
 * @author Olivier Constant
 */
public class TemplatePatternBrowsingSpecification extends AbstractBijectiveTemplatePatternSpecification {
  
  /** A non-null object to use as a context */
  private final Object _context;
  
  /**
   * Constructor
   * @param context_p a non-null object to use as context
   */
  public TemplatePatternBrowsingSpecification(Object context_p) {
    super();
    _context = context_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IBijectiveTemplatePatternSpecification#getAllElements()
   */
  public Collection<EObject> getAllElements() {
    Collection<EObject> result;
    if (getPattern() != null)
      result = Collections.unmodifiableList(ModelsUtil.getAllContents(
          getPattern().getTemplateElements(), true, null));
    else
      result = Collections.<EObject>emptySet();
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection#getCounterpart(org.eclipse.emf.ecore.EObject, boolean)
   */
  public EObject getCounterpart(EObject element_p, boolean fromPattern_p) {
    return element_p;
  }
  
  /**
  * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#getRolesOf(org.eclipse.emf.ecore.EObject)
  */
  public List<TemplatePatternRole> getRolesOf(EObject modelElement_p) {
    List<TemplatePatternRole> result = new FOrderedSet<TemplatePatternRole>();
    if (getPattern() != null) {
      for (TemplatePatternRole role : getPattern().getRoles()) {
        if (role.getTemplateElements().contains(modelElement_p))
          result.add(role);
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IUserScopeProvider#getScopeElement()
   */
  public Object getScopeElement() {
    return _context;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IBijectiveTemplatePatternSpecification#isComplete()
   */
  public boolean isComplete() {
    return true;
  }
  
}
