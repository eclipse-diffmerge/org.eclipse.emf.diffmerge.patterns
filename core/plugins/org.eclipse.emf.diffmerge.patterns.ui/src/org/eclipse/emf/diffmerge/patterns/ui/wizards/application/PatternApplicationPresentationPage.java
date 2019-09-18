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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.application;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;


/**
 * A wizard page for creating a new pattern
 * @author Olivier Constant
 */
public class PatternApplicationPresentationPage
extends AbstractPatternPresentationPage<TemplatePatternApplicationSpecification> {

  
  
  /**
   * Constructor
   * @param data_p the non-null data for template pattern application
   */
  public PatternApplicationPresentationPage(TemplatePatternApplicationSpecification data_p) {
    super("MainPage", Messages.PatternApplicationPresentationPage_Header, //$NON-NLS-1$
        Messages.PatternApplicationPresentationPage_Message,
        data_p, true, PatternSelectionKind.SELECTABLE, false);
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#getValidationMessage()
   */
  @Override
  protected String getValidationMessage() {
    String result = null;
    if (getData().getRepository() == null)
      result = Messages.PatternApplicationPresentationPage_ConstraintCatalog;
    else if (getData().getPattern() == null)
      result = Messages.PatternApplicationPresentationPage_ConstraintPattern;
    return result;
  }

}
