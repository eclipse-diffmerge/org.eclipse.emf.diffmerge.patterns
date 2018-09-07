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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.ecore.EObject;


/**
 * A partial implementation of IBijectiveTemplatePatternSpecification.
 * @author Olivier Constant
 */
public abstract class AbstractBijectiveTemplatePatternSpecification extends AbstractRoleSelection
implements IBijectiveTemplatePatternSpecification {
  
  /**
   * Constructor
   */
  public AbstractBijectiveTemplatePatternSpecification() {
    // Nothing specific
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection#covers(org.eclipse.emf.ecore.EObject, boolean)
   */
  public boolean covers(EObject sourceElement_p, boolean fromPattern_p) {
    return getCounterpart(sourceElement_p, fromPattern_p) != null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification#isAcceptable(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
   */
  public boolean isAcceptable(TemplatePattern pattern_p) {
    return true;
  }
  
  /**
   * Return whether the given string contains significant data
   * @param string_p a potentially null string
   * @return true iff string_p is not null and not empty
   */
  protected boolean isSignificant(String string_p) {
    return string_p != null && string_p.length() > 0;
  }
  
}
