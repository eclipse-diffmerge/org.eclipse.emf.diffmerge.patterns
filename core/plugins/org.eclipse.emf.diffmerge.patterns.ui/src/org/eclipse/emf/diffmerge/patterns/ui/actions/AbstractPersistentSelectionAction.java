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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;


/**
 * An abstract action which is based on an selection extended with a "persistent selection"
 * that can be modified by other actions
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractPersistentSelectionAction extends AbstractModelBasedAction {
  
  /**
   * Constructor
   */
  protected AbstractPersistentSelectionAction() {
    super();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
   */
  @Override
  public void selectionChanged(IAction action_p, ISelection selection_p) {
    // Enhance selection with persistent selection
    ISelection newSelection = selection_p;
    if (selection_p instanceof IStructuredSelection) {
      List<?> originalElements = ((IStructuredSelection)selection_p).toList();
      List<Object> newElements = new FOrderedSet<Object>(originalElements, null);
      newElements.addAll(PatternsUIPlugin.getDefault().getPersistentSelection().getElements());
      newSelection = new StructuredSelection(newElements);
    }
    super.selectionChanged(action_p, newSelection);
  }
  
}
