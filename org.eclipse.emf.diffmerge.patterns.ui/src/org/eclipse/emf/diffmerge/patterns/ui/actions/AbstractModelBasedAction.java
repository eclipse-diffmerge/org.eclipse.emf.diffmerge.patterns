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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * An abstract action on model elements for patterns.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public abstract class AbstractModelBasedAction<DiagramElementType, DiagramType> 
extends AbstractContextualAction<EObject> {
  
	/**
	 * Constructor
	 */
	protected AbstractModelBasedAction() {
	  super(EObject.class);
	}
		  
  /**
   * Display a "No pattern support" error message 
   */
  protected void informNoPatternSupport() {
    MessageDialog.openError(getShell(), CorePatternsPlugin.getDefault().getLabel(),
        Messages.AbstractModelBasedAction_MissingPatternSupport);
  }
  
/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractContextualAction#toActualSelection(java.lang.Object)
 */
  @Override
  protected Collection<?> toActualSelection(Object selected_p){
    AbstractDiagramUtil<DiagramElementType, DiagramType> diagramUtil = (AbstractDiagramUtil<DiagramElementType, DiagramType>) PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    return diagramUtil.toActualSelection(selected_p);
  }
    
}
