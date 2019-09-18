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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.creation;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * A wizard page for creating a new pattern.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class PatternCreationPresentationPage extends AbstractPatternPresentationPage<TemplatePatternCreationSpecification> {

  /**
   * Constructor
   * @param creationData_p the non-null data for template pattern creation
   */
  public PatternCreationPresentationPage(TemplatePatternCreationSpecification creationData_p) {
    super("MainPage", Messages.PatternCreationPresentationPage_Name, //$NON-NLS-1$
        Messages.PatternCreationPresentationPage_Message,
        creationData_p, false, PatternSelectionKind.NEW, true);
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#getValidationMessage()
   */
  @Override
  protected String getValidationMessage() {
    String result = null;
    TemplatePattern pattern = getData().getPattern();
    if (getData().getRepository() == null)
      result = Messages.PatternCreationPresentationPage_ConstraintCatalog;
    else if (!UIUtil.isSignificant(pattern.getName()))
      result = Messages.PatternCreationPresentationPage_ConstraintPatternName;
    else if (!UIUtil.isSignificant(pattern.getVersion()))
      result = Messages.PatternCreationPresentationPage_ConstraintPatternVersion;
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage#setPatternImageToDefault()
   */
  @Override
  protected void setPatternImageToDefault() {
    getWizard().computePatternImageFromSpecification(null, true);
  }

}
