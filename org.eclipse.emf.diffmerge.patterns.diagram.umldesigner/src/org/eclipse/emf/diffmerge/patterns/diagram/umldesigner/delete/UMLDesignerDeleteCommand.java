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
package org.eclipse.emf.diffmerge.patterns.diagram.umldesigner.delete;

import java.util.Collection;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.diffmerge.patterns.core.operations.DeleteOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * A delete command that is specific to UMLDesigner and to the implementation 
 * of patterns and pattern instances that is specified by the current UMLDesignerModelEnvironment.
 * @author Skander TURKI
 *
 */
public class UMLDesignerDeleteCommand extends AbstractCommand{

  /** The selection of elements to delete */
  private Collection<?> _selection;
  
  /** Editing domain */
  private EditingDomain _editingDomain;
  

  /**
   * Constructor
   * @param editingDomain_p a potentially null editing domain
   * @param collection_p a non null collection
   */
  public UMLDesignerDeleteCommand(EditingDomain editingDomain_p, Collection<?> selection_p) {
    _editingDomain = editingDomain_p;
    _selection = selection_p;
  }
  
  /**
   * @see org.eclipse.emf.common.command.Command#execute()
   */
  public void execute() {
    try{
      DeleteOperation op = new DeleteOperation((Collection<? extends EObject>) _selection, false, _editingDomain);
      op.run(null);
    }catch(Exception ex){
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
