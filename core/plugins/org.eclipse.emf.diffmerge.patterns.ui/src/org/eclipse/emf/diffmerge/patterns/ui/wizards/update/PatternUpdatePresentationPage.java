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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.update;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * A wizard page for creating a new pattern
 * @author Olivier Constant
 */
public class PatternUpdatePresentationPage extends AbstractPatternPresentationPage<TemplatePatternUpdateSpecification> {

  /**
   * Constructor
   * @param creationData_p the non-null data for template pattern creation
   */
  public PatternUpdatePresentationPage(TemplatePatternUpdateSpecification creationData_p) {
    super("MainPage", Messages.PatternUpdatePresentationPage_Name, //$NON-NLS-1$
        Messages.PatternUpdatePresentationPage_Message, creationData_p, false,
        PatternSelectionKind.FIXED, true);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage#createPatternPresentation(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPatternPresentation(Composite parent_p) {
    super.createPatternPresentation(parent_p);
    selectTextContent(_versionWidget);
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
      result = Messages.PatternUpdatePresentationPage_ConstraintCatalog;
    else if (!UIUtil.isSignificant(pattern.getName()))
      result = Messages.PatternUpdatePresentationPage_ConstraintPatternName;
    else if (!UIUtil.isSignificant(pattern.getVersion()) ||
        pattern.getVersion().equals(getData().getOriginalPattern().getVersion()))
      result = Messages.PatternUpdatePresentationPage_ConstraintPatternVersion;
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage#setPatternImageToDefault()
   */
  @Override
  protected void setPatternImageToDefault() {
    TemplatePattern originalPattern = getData().getOriginalPattern();
    String originalSpecification = null;
    if (originalPattern.getImage() != null)
      originalSpecification = originalPattern.getImage().getContents();
    getWizard().computePatternImageFromSpecification(originalSpecification, true);
  }

}
