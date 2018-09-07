/*********************************************************************
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.delete;

import java.util.Collection;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.diffmerge.patterns.core.operations.DeleteOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A delete command that is specific to UMLDesigner and to the implementation 
 * of patterns and pattern instances that is specified by the current UMLDesignerModelEnvironment.
 * @author Skander Turki
 */
public class UMLDesignerDeleteCommand extends AbstractCommand{
  
  /** The selection of elements to delete */
  private Collection<?> _selection;
  
  /** The potentially null editing domain */
  private EditingDomain _editingDomain;
  
  
  /**
   * Constructor
   * @param editingDomain_p a potentially null editing domain
   * @param selection_p a non null collection
   */
  public UMLDesignerDeleteCommand(EditingDomain editingDomain_p, Collection<?> selection_p) {
    _editingDomain = editingDomain_p;
    _selection = selection_p;
  }
  
  /**
   * @see org.eclipse.emf.common.command.Command#execute()
   */
  public void execute() {
    try {
      @SuppressWarnings("unchecked")
      DeleteOperation op = new DeleteOperation(
          (Collection<? extends EObject>) _selection, false, _editingDomain);
      op.run(null);
    } catch(Exception ex){
      //Nothing
    }
  }
  
  /**
   * @see org.eclipse.emf.common.command.Command#redo()
   */
  public void redo() {
    // TODO Auto-generated method stub
    
  }
  
}
