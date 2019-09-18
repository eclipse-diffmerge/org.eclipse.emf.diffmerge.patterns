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
package org.eclipse.emf.diffmerge.patterns.ui.util;

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.swt.widgets.Menu;

/**
 * A semantic/UI utility interface about the relationship between UI
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
   * Return the similar classes that this class overrides.
   * This "override" relation must be such that its transitive
   * closure is antisymmmetric (no "loops"). Only instances of the returned classes are
   * concerned, not instances of sub-classes.
   * @return a non-null, potentially empty collection
   */
  Collection<? extends Class<? extends IUIExtender>> getOverridenClasses();

  /**
   * Returns the ID of the modeller's instance explorer view.
   * @return a non-null string
   */
  public String getInstanceExplorerViewID();
  
}
