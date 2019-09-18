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
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;


/**
 * A wizard page for browsing the characteristics of pattern roles.
 * @author Olivier Constant
 */
public class PatternBrowsingRolesPage
extends AbstractRoleSpecificationPage<AbstractBijectiveTemplatePatternSpecification> {
  
  /**
   * Constructor
   * @param data_p the specification of the pattern
   */
  public PatternBrowsingRolesPage(AbstractBijectiveTemplatePatternSpecification data_p) {
    super(Messages.PatternBrowsingRolesPage_Name,
        Messages.PatternBrowsingRolesPage_Message,
        data_p, false);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage#isReadOnly()
   */
  @Override
  protected boolean isReadOnly() {
    return true;
  }
  
}
