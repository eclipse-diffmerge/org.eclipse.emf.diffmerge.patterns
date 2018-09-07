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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * An abstract action on model elements for patterns.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractModelBasedAction extends AbstractContextualAction<EObject> {
  
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
    AbstractDiagramUtil diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    return diagramUtil.toActualSelection(selected_p);
  }
    
}
