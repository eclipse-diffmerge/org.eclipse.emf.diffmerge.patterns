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
package org.eclipse.emf.diffmerge.patterns.core.util;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;


/**
 * A partial implementation of IPatternRepository
 * @author Olivier Constant
 */
public abstract class AbstractPatternRepository implements IPatternRepository {
  
  /** The ID of the repository, unique within the scope of the repository registry */
  private final String _id;
  
  /**
   * Constructor
   * @param id_p the non-null ID of this repository
   */
  protected AbstractPatternRepository(String id_p) {
    assert id_p != null;
    _id = id_p;
  }
  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object o_p) {
    return o_p instanceof AbstractPatternRepository &&
      getId().equals(((AbstractPatternRepository)o_p).getId());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement#getId()
   */
  public final String getId() {
    return _id;
  }
  
  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return getId().hashCode();
  }
  
}
