/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.util;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.ui.sirius.views.SiriusInstanceExplorerView;
import org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.swt.widgets.Menu;


/**
 * An implementation of IUIExtender for Sirius.
 * @author Skander Turki
 */
public class SiriusUIExtender implements IUIExtender{
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender#createNavigationItems(org.eclipse.swt.widgets.Menu, org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer)
   */
  public boolean createNavigationItems(Menu menu_p, ModelSubsetViewer viewer_p) {
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender#getInstanceExplorerViewID()
   */
  public String getInstanceExplorerViewID() {
    return SiriusInstanceExplorerView.getID();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender#getOverridenClasses()
   */
  public Collection<? extends Class<? extends IUIExtender>> getOverridenClasses() {
    return Collections.emptySet();
  }
  
}
