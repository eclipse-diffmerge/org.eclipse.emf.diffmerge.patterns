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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.templates;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractModifiableTemplateElementsPage;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;


/**
 * A wizard page for specifying the contents of a new template.
 * @author Olivier Constant
 */
public class TemplateCreationElementsPage
extends AbstractModifiableTemplateElementsPage<TemplatePatternCreationSpecification> {
  
  /**
   * Constructor
   * @param creationData_p the non-null data for template pattern creation
   */
  public TemplateCreationElementsPage(TemplatePatternCreationSpecification creationData_p) {
    super(Messages.PatternCreationElementsPage_Name,
        Messages.TemplateCreationElementsPage_Message,
        creationData_p);
  }
  
}
