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
 * 
 * @author Olivier Constant
 */
import java.util.List;

/**
 * An element which is subject to collaborative work.
 * @author Olivier Constant
 */
public interface ICollaborativeElement extends IVersionedElement {
  
  /**
   * Return the last modification stamp (time representation) of the element
   * @return a non-null String
   */
  String getLastModificationStamp();
  
  /**
   * Return the list of authors of the element
   * @return a non-null, non-empty array of non-null Strings
   */
  List<String> getAuthors();
  
}
