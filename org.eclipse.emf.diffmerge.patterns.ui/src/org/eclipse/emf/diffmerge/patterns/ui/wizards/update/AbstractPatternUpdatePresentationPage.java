/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.wizards.update;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * A wizard page for creating a new pattern
 * @author O. CONSTANT
 */
public abstract class AbstractPatternUpdatePresentationPage<DiagramElementType, DiagramType, GraphicalContainerType>
extends AbstractPatternPresentationPage<DiagramElementType, DiagramType, GraphicalContainerType, TemplatePatternUpdateSpecification> {

  /**
   * Constructor
   * @param creationData_p the non-null data for template pattern creation
   */
  public AbstractPatternUpdatePresentationPage(TemplatePatternUpdateSpecification creationData_p) {
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
