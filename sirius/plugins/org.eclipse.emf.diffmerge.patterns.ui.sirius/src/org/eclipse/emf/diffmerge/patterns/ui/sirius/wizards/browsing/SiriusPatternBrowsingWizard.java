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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.browsing;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;


/**
 * A Sirius-specific wizard for browsing pattern repositories.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SiriusPatternBrowsingWizard extends AbstractPatternBrowsingWizard{
  
  /**
   * Constructor
   * @param context_p a non-null object to use as context
   * @param pattern_p a potentially null pattern to browse first
   */
  public SiriusPatternBrowsingWizard(Object context_p, TemplatePattern pattern_p) {
    this(context_p, pattern_p != null? pattern_p.getRepository(): null);
    getData().setPattern(pattern_p);
  }
  
  /**
   * Constructor
   * @param context_p a non-null object to use as context
   * @param repository_p a potentially null repository to browse first
   */
  public SiriusPatternBrowsingWizard(Object context_p, IPatternRepository repository_p) {
    super(context_p);
    getData().setRepository(repository_p);
  }
  
}
