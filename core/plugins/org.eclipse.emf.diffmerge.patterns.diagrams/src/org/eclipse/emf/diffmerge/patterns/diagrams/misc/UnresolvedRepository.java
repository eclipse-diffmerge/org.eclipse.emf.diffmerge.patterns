/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.diagrams.misc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.PatternsDiagramsUtil;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogResourceHelper;


/**
 * A representation of a repository which is not loaded
 * @author Olivier Constant
 * @author Skander Turki
 */
public class UnresolvedRepository implements UnresolvedElement {
  /** The non-null path to the repository */
  private final String _path;
  /** The non-null ID of the repository */
  private final String _id;
  /** The non-null, modifiable, potentially empty list of unresolved "patterns" */
  private final List<UnresolvedPattern> _unresolvedPatterns;
  /**
   * Constructor
   */
  public UnresolvedRepository(String path_p, String id_p) {
    _path = path_p;
    _id = id_p;
    _unresolvedPatterns = new ArrayList<UnresolvedPattern>();
  }
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object object_p) {
    boolean result = false;
    if (object_p instanceof UnresolvedRepository) {
      UnresolvedRepository peer = (UnresolvedRepository)object_p;
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
    String result = getPath();
    int endPos = result.lastIndexOf(
        "." + PatternCatalogResourceHelper.getPatternCatalogFileExtension()); //$NON-NLS-1$
    if (endPos < 0) endPos = result.length();
    int startPos = result.lastIndexOf(IPath.SEPARATOR) + 1;
    result = result.substring(startPos, endPos);
    return result;
  }
  /**
   * Return the path of the repository
   * @return a non-null string
   */
  public String getPath() {
    return _path;
  }
  /**
   * Return the list of "patterns" which are supposed to belong to this repository
   * @return a non-null, modifiable, potentially empty list
   */
  public List<UnresolvedPattern> getUnresolvedPatterns() {
    return _unresolvedPatterns;
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
    return getName() + " " + PatternsDiagramsUtil.NOT_LOADED_SUFFIX + //$NON-NLS-1$
      "  [" + PatternsDiagramsUtil.getPath(getPath()) + "]"; //$NON-NLS-1$ //$NON-NLS-2$
  }
}
