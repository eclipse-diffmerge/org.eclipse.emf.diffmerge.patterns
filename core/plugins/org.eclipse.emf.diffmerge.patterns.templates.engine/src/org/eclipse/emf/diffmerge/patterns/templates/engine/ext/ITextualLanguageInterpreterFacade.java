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
package org.eclipse.emf.diffmerge.patterns.templates.engine.ext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;
import org.eclipse.emf.ecore.EObject;


/**
 * An interpreter for a textual language used in the context of a template pattern.
 * @author Olivier Constant
 */
public interface ITextualLanguageInterpreterFacade {
  
  /**
   * Return the name of the language supported by this interpreter
   * @return a non-null string
   */
  String getLanguage();
  
  /**
   * Check whether the given element conforms to the given constraint
   * @param constraint_p a non-null constraint
   * @param element_p a non-null element
   * @return a non-null status
   */
  IPatternConformityStatus checkElement(TextualRoleConstraint constraint_p, EObject element_p);
  
  /**
   * Return the elements derived by the given rule in the context of the given pattern application context
   * @param rule_p a non-null rule
   * @param context_p a non-null object
   * @return a potentially empty, unmodifiable list, or null if failure
   */
  EList<EObject> deriveCandidateElements(TextualRoleDerivationRule rule_p,
      IPatternApplication context_p);
  
}
