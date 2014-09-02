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
      // Try and get a label based on the main Melody editing domain
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
