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
package org.eclipse.emf.diffmerge.patterns.ui.umldesigner.ext;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.environment.DefaultModelEnvironmentUI;
import org.eclipse.emf.diffmerge.patterns.ui.providers.EObjectLabelProviderHelper;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;


/**
 * A model environment UI for UMLDesigner.
 * @author Skander Turki
 */
public class UMLDesignerModelEnvironmentUI extends DefaultModelEnvironmentUI{

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.environment.DefaultModelEnvironmentUI#getText(java.lang.Object)
   */
  @Override
  public String getText(Object element_p) { 
    if(!(element_p instanceof EObject)){
      return element_p.toString();
    }
    EObject eobj = (EObject)element_p;
    // Centralize dependency to common.ui.services
    String result = EObjectLabelProviderHelper.getText(eobj);
    if (!UIUtil.isSignificant(result) || result.equals("-") || result.equals("+")) { //$NON-NLS-1$ //$NON-NLS-2$
      // Try and get a label based on the main editing domain
      EditingDomain rawEditingDomain =
          CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(eobj);
      if (rawEditingDomain instanceof AdapterFactoryEditingDomain) {
        AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain)rawEditingDomain;
        IItemLabelProvider provider = (IItemLabelProvider)editingDomain.getAdapterFactory().adapt(
            eobj, IItemLabelProvider.class);
        if (provider != null)
          result = provider.getText(eobj);
      }
    }
    return result;
  }
  
}
