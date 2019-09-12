/*********************************************************************
 * Copyright (c) 2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/

package org.eclipse.emf.diffmerge.patterns.diagrams.util;


/**
 * A basic structure for immutable RGB values (independent from SWT or Sirius).
 */
public class BasicRGB {
  
  /** The (positive) R */
  public final int red;
  /** The (positive) G */
  public final int green;
  /** The (positive) B */
  public final int blue;
  
  /**
   * Default constructor (black)
   */
  public BasicRGB() {
    this(0, 0, 0);
  }
  
  /**
   * Full-fledged constructor
   * @param red_p a positive int
   * @param green_p a positive int
   * @param blue_p a positive int
   */
  public BasicRGB(int red_p, int green_p, int blue_p) {
    red = red_p;
    green = green_p;
    blue = blue_p;
  }
  
  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + blue;
    result = prime * result + green;
    result = prime * result + red;
    return result;
  }
  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj_p) {
    if (this == obj_p) {
      return true;
    }
    if (obj_p == null) {
      return false;
    }
    if (!(obj_p instanceof BasicRGB)) {
      return false;
    }
    BasicRGB other = (BasicRGB) obj_p;
    if (blue != other.blue) {
      return false;
    }
    if (green != other.green) {
      return false;
    }
    if (red != other.red) {
      return false;
    }
    return true;
  }
  
}
