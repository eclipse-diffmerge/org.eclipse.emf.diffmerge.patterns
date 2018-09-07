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
package org.eclipse.emf.diffmerge.patterns.ui.providers;

import org.eclipse.jface.viewers.LabelProvider;

import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;


/**
 * A trivial label provider for named/identified pattern-related elements
 * @author Olivier Constant
 */
public class NameBasedLabelProvider extends LabelProvider {
  
  /** The shared instance */
  private static NameBasedLabelProvider __instance;
  
  /**
   * Getter for singleton pattern
   */
  public static NameBasedLabelProvider getInstance() {
    if (null == __instance)
      __instance = new NameBasedLabelProvider();
    return __instance;
  }
  
  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getText(Object)
   */
  @Override
  public String getText(Object element_p) {
    String result = null;
    if (element_p instanceof INamedElement)
      result = ((INamedElement)element_p).getName();
    else if (element_p instanceof IIdentifiedElement)
      result = ((IIdentifiedElement)element_p).getId();
    else
      result = super.getText(element_p);
    if (result != null)
      result = result.replaceAll("%20", " "); //$NON-NLS-1$ //$NON-NLS-2$
    return result;
  }
  
}
