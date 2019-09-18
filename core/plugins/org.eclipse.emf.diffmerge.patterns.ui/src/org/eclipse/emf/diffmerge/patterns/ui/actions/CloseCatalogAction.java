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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.RepositoryRegistry;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.CloseCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;


/**
 * An action for closing catalogs.
 * @author Olivier Constant
 */
public class CloseCatalogAction extends AbstractContextualAction<IFile> {

  /**
   * Constructor
   */
  public CloseCatalogAction() {
    super(IFile.class);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractContextualAction#coreRun(java.util.List)
   */
  @SuppressWarnings("boxing")
  @Override
  protected void coreRun(List<Object> selection_p) {
    if (!selection_p.isEmpty()) {
      Integer nbClosed = Integer.valueOf(0);
      RepositoryRegistry registry = CorePatternsPlugin.getDefault().getRepositoryRegistry();
      Object context = selection_p.get(0);
      EditingDomain domain = null;
      if(context instanceof IFile){
        domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((IFile)context);
      }else if(context instanceof EObject){
        domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((EObject)context);
      }
      if (!registry.getRepositories().isEmpty() && domain != null) {
        Iterator<Object> it = selection_p.iterator();
        while(it.hasNext()){
          Object current = it.next();
          if(current instanceof IFile){
            CloseCatalogOperation operation = new CloseCatalogOperation((IFile)current, domain.getResourceSet());
            Integer toAdd = executeOperation(operation);
            if (toAdd != null)
              nbClosed =  nbClosed + toAdd;
          }
        }
      }
      String msg = String.format(Messages.CloseCatalogAction_Done, nbClosed);
      MessageDialog.openInformation(getShell(), CorePatternsPlugin.getDefault().getLabel(), msg);
    }
  }
 
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractContextualAction#mustBeEnabled()
   */
  @Override
  protected boolean mustBeEnabled() {
    return true; //TODO refine
  }

}
