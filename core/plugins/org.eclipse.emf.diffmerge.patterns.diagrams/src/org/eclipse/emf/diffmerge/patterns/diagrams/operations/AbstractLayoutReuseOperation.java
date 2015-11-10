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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;


/**
 * An operation for applying the graphical layout defined in a pattern on an instance.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractLayoutReuseOperation 
  extends AbstractGraphicalUpdateOperation
{

  /** The name of the operation */
  private static final String NAME = Messages.LayoutReuseOperation_Name;

  /** The non-null pattern instance whose representation must be updated */
  private final IPatternInstance _instance;

  /** The vector X to apply (default is (0,0)) */
  private int _vectorX;
  /** The vector Y to apply (default is (0,0)) */
  private int _vectorY;

  /** Whether the layout should be updated */
  private final boolean _updateLayout;

  /** Whether the style should be updated */
  private final boolean _updateStyle;
  
  
  /**
   * Constructor
   * @param instance_p a non-null instance
   * @param updateLayout_p whether the layout must be updated
   * @param updateStyle_p whether the style must be updated
   */
  public AbstractLayoutReuseOperation(IPatternInstance instance_p, boolean updateLayout_p, boolean updateStyle_p) {
    _instance = instance_p;
    _updateLayout = updateLayout_p;
    _updateStyle = updateStyle_p;
    _vectorX = 0;
    _vectorY = 0;
  }


  /**
   * Getter
   */
  public int getVectorX() {
    return _vectorX;
  }

  /**
   * Setter
   */
  public void setVectorX(int vectorX_p) {
    this._vectorX = vectorX_p;
  }

  /**
   * Getter
   */
  public int getVectorY() {
    return _vectorY;
  }

  /**
   * Setter
   */
  public void setVectorY(int vectorY_p) {
    this._vectorY = vectorY_p;
  }

  /**
   * Getter
   */
  public static String getName() {
    return NAME;
  }

  /**
   * Getter
   */
  public IPatternInstance getInstance() {
    return _instance;
  }

  /**
   * Getter
   */
  public boolean isUpdateLayout() {
    return _updateLayout;
  }

  /**
   * Getter
   */
  public boolean isUpdateStyle() {
    return _updateStyle;
  }

}
