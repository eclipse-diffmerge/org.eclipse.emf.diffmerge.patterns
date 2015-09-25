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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;


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
