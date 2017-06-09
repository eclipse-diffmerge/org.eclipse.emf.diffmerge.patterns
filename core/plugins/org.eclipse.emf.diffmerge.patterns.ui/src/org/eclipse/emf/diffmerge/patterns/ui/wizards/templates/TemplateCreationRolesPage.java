/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractBijectiveTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A wizard page for specifying the characteristics of template roles.
 * @author Olivier Constant
 */
public class TemplateCreationRolesPage
extends AbstractRoleSpecificationPage<AbstractBijectiveTemplatePatternSpecification> {

  /**
   * Constructor
   * @param data_p the specification of the template
   */
  public TemplateCreationRolesPage(AbstractBijectiveTemplatePatternSpecification data_p) {
    super(Messages.PatternCreationRolesPage_Name,
        Messages.TemplateCreationRolesPage_Message,
        data_p, false);
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSpecificationPage#createMergeGroup(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createMergeGroup(final Composite parent_p) {
    final Composite mergeComposite = createGroup(
        parent_p, Messages.TemplateCreationRolesPage_MergeGroup, true, 3);
    fillLineWith(mergeComposite);
    // Target derivation rule
    createTargetDerivationLine(mergeComposite, Messages.TemplateCreationRolesPage_MergeLine);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractRoleSelectionPage#getValidationMessage()
   */
  @Override
  protected String getValidationMessage() {
    String result = super.getValidationMessage();
    if (result == null) {
      TemplatePattern pattern = getData().getPattern();
      if (pattern != null && !pattern.getRoles().isEmpty()) {
        boolean first = true;
        for (TemplatePatternRole role : pattern.getRoles()) {
          if (first) {
            first = false;
            result = getFirstRoleValidationMessage(role);
          } else {
            result = getSecondaryRoleValidationMessage(role);
          }
          if (result != null)
            break;
        }
      }
    }
    return result;
  }

  /**
   * Return the validation message for the given first role, or null if validation passes
   * @param role_p a non-null role
   * @return a potentially empty string
   */
  protected String getFirstRoleValidationMessage(TemplatePatternRole role_p) {
    String result = null;
    if (role_p.getMergeDerivationRule() != null)
      result = Messages.TemplateCreationRolesPage_FirstRoleNoCollectionRule;
    else if (role_p.getTemplateElements().size() != 1)
      result = Messages.TemplateCreationRolesPage_FirstRoleSingleElement;
    return result;
  }

  /**
   * Return the validation message for the given secondary role, or null if validation passes
   * @param role_p a non-null role
   * @return a potentially empty string
   */
  protected String getSecondaryRoleValidationMessage(TemplatePatternRole role_p) {
    String result = null;
    if (role_p.getMergeDerivationRule() == null)
      result = String.format(
          Messages.TemplateCreationRolesPage_SecondaryRoleCollectionRule, role_p.getName());
    return result;
  }

}
