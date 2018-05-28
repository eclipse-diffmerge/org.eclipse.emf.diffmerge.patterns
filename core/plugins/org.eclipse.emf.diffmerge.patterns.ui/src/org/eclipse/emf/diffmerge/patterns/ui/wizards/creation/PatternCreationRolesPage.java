/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.creation;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A wizard page for specifying the characteristics of pattern roles.
 * @author Olivier Constant
 */
public class PatternCreationRolesPage
extends AbstractRoleSpecificationPage<TemplatePatternCreationSpecification> {
  
  /**
   * Constructor
   * @param creationData_p the specification of the pattern
   */
  public PatternCreationRolesPage(TemplatePatternCreationSpecification creationData_p) {
    super(Messages.PatternCreationRolesPage_Name,
        Messages.PatternCreationRolesPage_Message,
        creationData_p, false);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage#getPreferredContainment(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole)
   */
  @Override
  protected EReference getPreferredContainment(TemplatePatternRole role_p) {
    return getData().getCommonContainment(role_p);
  }
  
}
