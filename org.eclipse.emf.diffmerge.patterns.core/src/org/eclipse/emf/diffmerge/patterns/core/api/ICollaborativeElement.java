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
