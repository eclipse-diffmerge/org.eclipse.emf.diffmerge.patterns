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
package org.eclipse.emf.diffmerge.patterns.diagram.operations;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.Messages;


/**
 * An operation for applying the graphical layout defined in a pattern on an instance.
 * @author O. CONSTANT
 * @author S. TURKI
 */
public abstract class AbstractLayoutReuseOperation<DiagramType, SemanticRepresentationType> 
  extends AbstractGraphicalUpdateOperation<DiagramType, SemanticRepresentationType>
{

  /** The name of the operation */
  private static final String NAME = Messages.LayoutReuseOperation_Name;

  /** The non-null pattern instance whose representation must be updated */
  private final IPatternInstance _instance;

  /** The vector to apply (default is (0,0)) */
  private int _vectorX, _vectorY;

  /**
   * This boolean says whether the layout should be updated
   */
  private final boolean _updateLayout;

  /**
   * This boolean says whether the style should be updated
   */
  private final boolean _updateStyle;

  /**
   * Constructor
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
  public int get_vectorX() {
    return _vectorX;
  }

  /**
   * Setter
   */
  public void set_vectorX(int vectorX_p) {
    this._vectorX = vectorX_p;
  }

  /**
   * Getter
   */
  public int get_vectorY() {
    return _vectorY;
  }

  /**
   * Setter
   */
  public void set_vectorY(int vectorY_p) {
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
  public IPatternInstance get_instance() {
    return _instance;
  }

  /**
   * Getter
   */
  public boolean is_updateLayout() {
    return _updateLayout;
  }

  /**
   * Getter
   */
  public boolean is_updateStyle() {
    return _updateStyle;
  }

}
