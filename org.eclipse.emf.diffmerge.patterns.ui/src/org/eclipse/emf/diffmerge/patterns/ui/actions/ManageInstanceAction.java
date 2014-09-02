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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.InstancePanelDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;


/**
 * An action which opens the dialog for managing pattern instances.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class ManageInstanceAction extends AbstractModelBasedAction {

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractContextualAction#coreRun(java.util.List)
   */
  @SuppressWarnings("unchecked")
  @Override
  protected void coreRun(List<Object> selection_p) {
    if (!selection_p.isEmpty()) {
      Object element = selection_p.get(0);
      if(element instanceof EObject){
        EObject casted = (EObject)element;
        IPatternSupport support = CorePatternsPlugin.getDefault().getPatternSupportFor(casted);
        if (support == null) {
          informNoPatternSupport();
        } else {
          List<IPatternInstance> instances = Collections.emptyList();
          Iterator<Object> it = selection_p.iterator();
          while (instances.isEmpty() && it.hasNext()) {
            Object obj = it.next();
            if(obj instanceof EObject){
              instances = support.getRelatedInstances((EObject)obj);
            }
          }
          if (instances.isEmpty()) {
            MessageDialog.openInformation(getShell(), CorePatternsPlugin.getDefault().getLabel(),
                Messages.ManageInstanceAction_NotInInstance);
          } else {
            InstancePanelDialog dialog = new InstancePanelDialog(getShell(), casted,  instances,
                _diagramUtil.getDiagramFromSelection(getSelection()),
                (List<Object>)getFilteredSelection(_genericTypeUtil.getGraphicalPartTypeClass()));
            dialog.open();
          }
        }
      }
    }
  }
  
}
