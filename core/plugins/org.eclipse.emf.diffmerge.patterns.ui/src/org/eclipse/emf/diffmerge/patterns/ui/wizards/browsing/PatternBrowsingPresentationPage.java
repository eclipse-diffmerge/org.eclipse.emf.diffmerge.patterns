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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;


/**
 * A wizard page for creating a new pattern
 * @author Olivier Constant
 */
public class PatternBrowsingPresentationPage
extends AbstractPatternPresentationPage<AbstractBijectiveTemplatePatternSpecification> {
  
  /**
   * Constructor
   * @param browsingData_p the non-null data for template pattern creation
   */
  public PatternBrowsingPresentationPage(AbstractBijectiveTemplatePatternSpecification browsingData_p) {
    super("MainPage", Messages.PatternBrowsingPresentationPage_Name, //$NON-NLS-1$
        Messages.PatternBrowsingPresentationPage_Message,
        browsingData_p, true, PatternSelectionKind.SELECTABLE_WITH_DELETE, false);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#blockWithoutErrorMessages()
   */
  @Override
  protected boolean blockWithoutErrorMessages() {
    return getData().getPattern() == null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createControl(Composite parent_p) {
    super.createControl(parent_p);
    validate();
  }
  
}
