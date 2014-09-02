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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.update;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;


/**
 * A wizard page for updating the characteristics of pattern roles.
 * @author Olivier Constant
 */
public class PatternUpdateRolesPage
extends AbstractRoleSpecificationPage<TemplatePatternUpdateSpecification> {
  
  /**
   * Constructor
   * @param updateData_p the specification of the pattern
   */
  public PatternUpdateRolesPage(TemplatePatternUpdateSpecification updateData_p) {
    super(Messages.PatternUpdateRolesPage_Name,
        Messages.PatternUpdateRolesPage_Message,
        updateData_p, false);
  }
  
}
