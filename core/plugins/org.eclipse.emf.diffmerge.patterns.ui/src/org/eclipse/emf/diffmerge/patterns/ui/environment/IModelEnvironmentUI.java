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
package org.eclipse.emf.diffmerge.patterns.ui.environment;

import java.util.List;

import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.graphics.Image;


/**
 * A model environment UI services provider.
 * @author Olivier Constant
 * @author Skander Turki
 */
public interface IModelEnvironmentUI {

  /** Sorting methods for model elements */
  enum SortingMethod {
    /** No sorting */
    NONE,
    /** By name */
    BY_NAME,
    /** By type then name */
    BY_TYPE_AND_NAME
  }
  
  /**
   * Return a description of the modeling tools for which this semantic mapping is defined
   * @return a non-null, unmodifiable, potentially empty list
   */
  List<String> getEnvironments();
  
  /**
   * Return a sorter that enforces the given sorting method
   * @param method_p a non-null sorting method
   * @return a potentially null sorter
   */
  ViewerComparator getSorter(SortingMethod method_p);
  
  /**
   * Return a specific label for the given element if applicable
   * @param element_p a non-null object
   * @return a potentially null string
   */
  String getText(Object element_p);
  
  /**
   * Return an image for the given object
   * @param element_p a non-null element
   * @return a potentially null Image
   */
  Image getImage(Object element_p);
  
}
