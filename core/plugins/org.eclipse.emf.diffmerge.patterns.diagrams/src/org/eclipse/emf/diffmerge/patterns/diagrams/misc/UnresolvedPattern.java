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
package org.eclipse.emf.diffmerge.patterns.diagrams.misc;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.PatternsDiagramsUtil;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;


/**
 * A representation of a pattern which is not loaded.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class UnresolvedPattern implements UnresolvedElement {
  /** The non-null name of the pattern */
  private final String _name;
  /** The non-null ID of the pattern */
  private final String _id;
  /** The non-null unresolved repository to which this pattern is supposed to belong */
  private final UnresolvedRepository _unresolvedRepository;
  /** The non-null, modifiable, potentially empty list of referring instances */
  private final List<IPatternInstance> _referringInstances;
  /**
   * Constructor
   */
  public UnresolvedPattern(String name_p, String id_p,
      UnresolvedRepository unresolvedRepository_p) {
    _name = name_p;
    _id = id_p;
    _unresolvedRepository = unresolvedRepository_p;
    _referringInstances = new FOrderedSet<IPatternInstance>();
  }
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object_p) {
    boolean result = false;
    if (object_p instanceof UnresolvedPattern) {
      UnresolvedPattern peer = (UnresolvedPattern)object_p;
      result = getId().equals(peer.getId());
    }
    return result;
  }
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement#getId()
   */
  public String getId() {
    return _id;
  }
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement#getName()
   */
  public String getName() {
    return _name;
  }
  /**
   * Return the list of instances that refer to this pattern
   * @return a non-null, modifiable, potentially empty list
   */
  public List<IPatternInstance> getReferringInstances() {
    return _referringInstances;
  }
  /**
   * Return the unresolved repository this pattern is suppoed to belong to
   * @return a non-null unresolved repopsitory
   */
  public UnresolvedRepository getUnresolvedRepository() {
    return _unresolvedRepository;
  }
  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return getId().hashCode();
  }
  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return getName() + " " + PatternsDiagramsUtil.NOT_LOADED_SUFFIX; //$NON-NLS-1$
  }
}
