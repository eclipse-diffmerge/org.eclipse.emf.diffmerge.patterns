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
package org.eclipse.emf.diffmerge.patterns.ui.util;

import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.swt.widgets.Menu;

/**
 * A semantic/UI utility interface about the relationship between ui
 * and semantic elements.
 * @author Olivier Constant
 * @author Skander Turki
 */
public interface IUIExtender{
  
  /**
   * Create menu items in the given menu for showing properties of the elements selected
   * in the given viewer
   * @param menu_p a non-null menu
   * @param viewer_p a non-null viewer
   * @return whether any menu item has been created
   */
  boolean createNavigationItems(Menu menu_p, ModelSubsetViewer viewer_p);
 

  /**
   * Returns the ID of the modeller's instance explorer view.
   * @return
   */
  public String getInstanceExplorerViewID();
  
}
