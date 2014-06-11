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
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;


/**
 * A wizard page for browsing the characteristics of pattern roles.
 * @author O. CONSTANT
 */
public class PatternBrowsingRolesPage
extends AbstractRoleSpecificationPage<AbstractBijectiveTemplatePatternSpecification> {
  
  /**
   * Constructor
   * @param creationData_p the specification of the pattern
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
