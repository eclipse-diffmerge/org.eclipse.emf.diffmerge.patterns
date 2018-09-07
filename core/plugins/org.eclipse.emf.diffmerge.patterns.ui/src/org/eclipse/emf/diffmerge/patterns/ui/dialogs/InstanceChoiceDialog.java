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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.util.PatternsInstancesUIUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;

/**
 * A dialog that displays a list of pattern instances and allows the user to select one and perform actions on it.
 * @author Olivier Constant
 */
public class InstanceChoiceDialog extends AbstractTableChoiceDialog<IPatternInstance> {

  /** The optional reference element for roles */
  protected final EObject _referenceElement;

  /** The text to display for elements playing no role */
  private static final String NO_ROLE_TEXT = Messages.InstanceChoiceDialog_NoRole;

  /** The text to display for elements playing unknown roles */
  private static final String UNKNOWN_ROLE_TEXT = Messages.InstanceChoiceDialog_UnknownRole;

  /**
   * Constructor
   * @param parentShell_p the shell for this dialog
   * @param dialogTitle_p the optional dialog title
   * @param dialogMessage_p the dialog message
   * @param iconKind_p the code for the icon (e.g., {@link MessageDialog#QUESTION})
   * @param referenceElement_p the optional element to use as a reference for displaying roles
   * @param instances_p the set of instances to choose from
   * @param selectionKind_p the kind of selection
   * @param canConfirm_p whether an OK button must b present
   */
  public InstanceChoiceDialog(Shell parentShell_p, String dialogTitle_p, String dialogMessage_p, int iconKind_p, EObject referenceElement_p,
      List<? extends IPatternInstance> instances_p, SelectionKind selectionKind_p, boolean canConfirm_p) {
    super(parentShell_p, dialogTitle_p, extendWithReferenceElement(dialogMessage_p, referenceElement_p), iconKind_p, instances_p, selectionKind_p, canConfirm_p);
    _referenceElement = referenceElement_p;
  }

  /**
   * @param initialMessage_p a non-null string
   * @return a non-null string
   */
  private static String extendWithReferenceElement(String initialMessage_p, EObject referenceElement_p) {
    String name = DiscriminatingLabelProvider.getInstance().getText(referenceElement_p);
    StringBuilder builder = new StringBuilder();
    builder.append(initialMessage_p);
    builder.append(' ');
    builder.append(Messages.InstanceChoiceDialog_InitialSelection);
    builder.append(" '"); //$NON-NLS-1$
    builder.append(name);
    builder.append("'."); //$NON-NLS-1$
    return builder.toString();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#getColumnText(java.lang.Object, int)
   */
  @Override
  protected String getColumnText(IPatternInstance instance_p, int columnIndex_p) {
    switch (columnIndex_p) {
      case 0:
        return PatternsInstancesUIUtil.getPatternAsText(instance_p);
      case 1:
        return PatternsInstancesUIUtil.getRolesAsText(instance_p, _referenceElement, UNKNOWN_ROLE_TEXT, NO_ROLE_TEXT);
      default:
        return ""; //$NON-NLS-1$
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog#getColumnHeaders()
   */
  @Override
  protected List<String> getColumnHeaders() {
    return Arrays.asList(Messages.InstanceChoiceDialog_InstanceOf, Messages.InstanceChoiceDialog_RolePlayed);
  }

}
