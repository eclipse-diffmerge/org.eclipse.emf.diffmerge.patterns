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
package org.eclipse.emf.diffmerge.patterns.core.api;

/**
 * An element which has a unique ID.
 * @author Olivier Constant
 */
public interface IIdentifiedElement {
  
  /**
   * Return the ID of the element, unique within the scope of the element
   * @return a non-null String
   */
  String getId();
  
}
