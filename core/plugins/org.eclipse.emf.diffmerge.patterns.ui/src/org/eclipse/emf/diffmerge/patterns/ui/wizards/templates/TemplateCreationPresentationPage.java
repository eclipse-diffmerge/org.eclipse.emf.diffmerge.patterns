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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.templates;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * A wizard page for creating a new template.
 * @author Olivier Constant
 */
public class TemplateCreationPresentationPage
extends AbstractPatternPresentationPage<TemplatePatternCreationSpecification> {

  /**
   * Constructor
   * @param creationData_p the non-null data for template pattern creation
   */
  public TemplateCreationPresentationPage(TemplatePatternCreationSpecification creationData_p) {
    super("MainPage", Messages.PatternCreationPresentationPage_Name, //$NON-NLS-1$
        Messages.TemplateCreationPresentationPage_Message,
        creationData_p, false, PatternSelectionKind.NEW, true);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage#createLayoutRow(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createLayoutRow(Composite parent_p) {
    // Nothing
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
      result = Messages.TemplateCreationPresentationPage_ValidationName;
    else if (!UIUtil.isSignificant(pattern.getVersion()))
      result = Messages.TemplateCreationPresentationPage_ValidationVersion;
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
