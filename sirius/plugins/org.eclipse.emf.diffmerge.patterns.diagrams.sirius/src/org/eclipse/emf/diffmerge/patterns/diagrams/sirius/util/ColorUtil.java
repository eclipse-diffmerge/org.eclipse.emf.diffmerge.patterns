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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util;

import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.sirius.viewpoint.ViewpointFactory;
import org.eclipse.swt.graphics.RGB;


/**
 * A utility class that provides color helpers (colors in int, doremi RGBValues or SWT RGB format)
 * @author Skander Turki
 */
public class ColorUtil {

  /**
   * A private constructor
   */
  private ColorUtil() {
    // Forbids Instantiation
  }

  /**
   * Returns an RGBValues object built out of a red, blue and green int values. When the creation of the object fails a black color object is returned.
   * @return a non-null RGBValues object.
   */
//  public static RGBValues getRGBColor(int red, int green, int blue) {
//    ViewpointFactory fact = ViewpointFactory.eINSTANCE;
//    RGBValues rgbValues = fact.createRGBValues();
//    if (rgbValues != null) {
//      rgbValues.setRed(red);
//      rgbValues.setGreen(green);
//      rgbValues.setBlue(blue);
//      return rgbValues;
//    }
//    return getRGBColor(0, 0, 0);
//  }

  /**
   * Converts a doremi RGBValues color to an SWT RGB object If the conversion fails, the a black RGB object is returned
   * @param rgbValuesObject_p
   * @return
   */
  public static RGB convertRGBValuesToRGB(RGBValues rgbValuesObject_p) {
    if (rgbValuesObject_p != null) {
      return new RGB(rgbValuesObject_p.getRed(), rgbValuesObject_p.getGreen(), rgbValuesObject_p.getBlue());
    }
    return new RGB(0, 0, 0);
  }

  /**
   * Converts an SWT RGB object to a doremi RGBValues color If the conversion fails, the a black RGBValues object is returned
   * @param rgbObject_p a potentially-null SWT RGB object.
   * @return a non-null Doremi RGBValues color
   */
  public static RGBValues convertRGBToRGBValues(RGB rgbObject_p) {
    if (rgbObject_p != null) {
      return RGBValues.create(rgbObject_p.red, rgbObject_p.green, rgbObject_p.blue);
    }
    return RGBValues.create(0, 0, 0);
  }

  /**
   * Converts a doremi RGBValues object to an int
   * @param rgbValues_p a potentially null RGBValues object
   * @return an int
   */
  public static int convertRGBValuesToIntColor(RGBValues rgbValues_p) {
    if (rgbValues_p == null) {
      return -1;
    }
    return (rgbValues_p.getRed() + rgbValues_p.getGreen() * 256 + rgbValues_p.getBlue() * 65536);
  }

  /**
   * @param color_p an integer that represents a coding of the values of R, G and B
   * @return a non-null RGBValues object
   */
  public static RGBValues convertIntColorToRGBValues(int color_p) {
    int redpart = color_p % 256;
    int greenpart = (color_p - redpart) / 256;
    int green = greenpart % 256;
    
    return RGBValues.create(redpart, green, (greenpart - green) / 256);
  }

}
