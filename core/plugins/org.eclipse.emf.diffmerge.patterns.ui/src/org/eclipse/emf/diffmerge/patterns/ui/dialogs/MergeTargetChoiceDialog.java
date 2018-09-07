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

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementLocation;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Shell;

/**
 * This class defines a dialog which requires the user to choose a target
 * for merge.
 * @author Olivier Constant
 */
public class MergeTargetChoiceDialog extends
AbstractElementSelectionDialog<IElementLocation> {

  /** The non-null type of the element to merge */
  protected final EClass _valueType;


  /**
   * Constructor.
   * @param parentShell_p the non-null shell for this dialog
   * @param message_p an optional prompt message to display (default if null)
   * @param context_p a non-null element belonging to the model to cover
   * @param targetType_p the non-null value type for the elements to merge
   */
  public MergeTargetChoiceDialog(Shell parentShell_p, String message_p,
      EObject context_p, final EClass targetType_p) {
    this(
        parentShell_p,
        enforceTypeMessage(message_p, targetType_p),
        ModelsUtil.getAllContents(
            EcoreUtil.getRootContainer(context_p), true, new IElementFilter() {
              /**
               * @see org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter#accepts(org.eclipse.emf.ecore.EObject)
               */
              public boolean accepts(EObject element_p) {
                return element_p.eClass() == targetType_p;
              }
            }),
            targetType_p);
  }

  /**
   * Constructor.
   * @param parentShell_p the non-null shell for this dialog
   * @param message_p the non-null prompt message to display
   * @param proposed_p the non-null set of proposed elements
   * @param valueType_p the non-null type of the element to merge
   */
  public MergeTargetChoiceDialog(Shell parentShell_p, String message_p,
      List<? extends EObject> proposed_p, EClass valueType_p) {
    super(parentShell_p, message_p, proposed_p);
    _valueType = valueType_p;
  }

  /**
   * Return the given message if not null, otherwise a message applicable to the given type
   * @param message_p a potentially null string
   * @param valueType_p a non-null meta-class
   * @return a non-null string
   */
  protected static String enforceTypeMessage(String message_p, EClass valueType_p) {
    String result = message_p;
    if (result == null) {
      String name = valueType_p.getName();
      result = String.format(Messages.MergeTargetChoiceDialog_Prompt, name);
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#getChoice()
   */
  @Override
  public IElementLocation getChoice() {
    EObject selected = _viewer.getChoice();
    IElementLocation result = null;
    if (selected != null)
      result = new BasicElementLocation(selected);
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#isEligible(org.eclipse.emf.ecore.EObject)
   */
  @Override
  protected boolean isEligible(EObject element_p) {
    return element_p.eClass() == _valueType;
  }

}
