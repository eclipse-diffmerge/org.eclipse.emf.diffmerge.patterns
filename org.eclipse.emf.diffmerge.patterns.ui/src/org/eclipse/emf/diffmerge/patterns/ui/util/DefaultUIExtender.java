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
package org.eclipse.emf.diffmerge.patterns.ui.util;

import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.swt.widgets.Menu;


/**
 * A straightforward implementation of ISemanticUIUtil involving no business logic.
 * @author Olivier Constant
 */
public class DefaultUIExtender implements IUIExtender {

/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender#createNavigationItems(org.eclipse.swt.widgets.Menu, org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer)
 */
  public boolean createNavigationItems(Menu menu_p, ModelSubsetViewer viewer_p) {
    return false;
  }

}
