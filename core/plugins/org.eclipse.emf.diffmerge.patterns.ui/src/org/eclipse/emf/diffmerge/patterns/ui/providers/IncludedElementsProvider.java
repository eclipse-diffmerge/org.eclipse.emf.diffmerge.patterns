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
package org.eclipse.emf.diffmerge.patterns.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

/**
 * This class tracks the state of the Reset Inclusions menu
 * @author Olivier Constant
 * @author Skander Turki
 */
public class IncludedElementsProvider extends AbstractSourceProvider{

  /**
   * The INCLUDED_ELEMENTS_STATE (visible or not) variable.
   */
  public static final String INCLUDED_ELEMENTS_STATE = "org.eclipse.emf.diffmerge.patterns.ui.actions.includedElementsVariable"; //$NON-NLS-1$

  /**
   * The visible state for the INCLUDED_ELEMENTS_STATE variable.
   */
  private static final String INCLUDED_ELEMENTS_VISIBLE = "visible"; //$NON-NLS-1$

  /**
   * The not visible state for the INCLUDED_ELEMENTS_STATE variable.
   */
  private static final String INCLUDED_ELEMENTS_NOT_VISIBLE = "notVisible"; //$NON-NLS-1$

  /**
   * The visibility of the Reset Inclusions Menu.
   */
  private boolean isVisible = false;
  
  /**
   * 
   * @see org.eclipse.ui.ISourceProvider#dispose()
   */
  public void dispose() {
    // TODO Auto-generated method stub
  }

  public Map< String, String > getCurrentState() {
    Map < String, String > currentState = new HashMap < String, String >(1);
    String state;
    if (isVisible) {
        state = INCLUDED_ELEMENTS_VISIBLE;
    } else {
        state = INCLUDED_ELEMENTS_NOT_VISIBLE;
    }
    currentState.put(INCLUDED_ELEMENTS_STATE, state);
    return currentState;
  }

  public String[] getProvidedSourceNames() {
    return new String[] { INCLUDED_ELEMENTS_STATE };
  }

  
  /**
   * @param aVisibleState the visibility of the Reset Inclusions Menu.
   */
  public void setVisibility(final boolean aVisibleState) {
      if (isVisible == aVisibleState) {
          return;
      }
      isVisible = aVisibleState;
      String currentState;
      if (isVisible) {
          currentState = INCLUDED_ELEMENTS_VISIBLE;
      } else {
          currentState = INCLUDED_ELEMENTS_NOT_VISIBLE;
      }
      fireSourceChanged(ISources.WORKBENCH, INCLUDED_ELEMENTS_STATE, currentState);
  }


}
