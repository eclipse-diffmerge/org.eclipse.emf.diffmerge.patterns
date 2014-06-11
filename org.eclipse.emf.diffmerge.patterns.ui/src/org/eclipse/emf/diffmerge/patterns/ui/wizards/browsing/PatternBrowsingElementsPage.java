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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * A wizard page for updating a new pattern
 * @author O. CONSTANT
 */
public class PatternBrowsingElementsPage
extends AbstractTemplateElementsPage<AbstractBijectiveTemplatePatternSpecification> {

  /**
   * Constructor
   * @param browsingData_p the non-null data for template pattern creation
   */
  public PatternBrowsingElementsPage(AbstractBijectiveTemplatePatternSpecification browsingData_p) {
    super(Messages.PatternBrowsingElementsPage_Name,
        Messages.PatternBrowsingElementsPage_Message, browsingData_p);
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#showParentsCheckbox()
   */
  @Override
  public boolean showParentsCheckbox() {
    return false;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractTemplateElementsPage#createModelViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected ModelSubsetViewer createModelViewer(Composite parent_p) {
    final ModelSubsetViewer resultViewer = super.createModelViewer(parent_p);
    getData().addSelectedPatternListener(new IPatternChangedListener() {
      public void patternChanged(TemplatePattern newPattern_p) {
        resultViewer.setInput(getData());
      }
    });
    return resultViewer;
  }

}
