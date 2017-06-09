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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;


/**
 * An observable object dealing with the selection of a pattern repository.
 * @author Olivier Constant
 */
public interface IRepositorySelection {
  
  /**
   * An interface for observers which are concerned with the repository currently selected
   */
  public static interface IRepositoryChangedListener {
    /**
     * Notifies that the selected repository changed from the given old one to the given new one
     * @param newRepository_p a potentially null repository
     */
    void repositoryChanged(IPatternRepository newRepository_p);
  }
  
  
  /**
   * Add a listener on the selected repository
   * @param listener_p a non-null listener
   */
  void addSelectedRepositoryListener(IRepositoryChangedListener listener_p);
  
  /**
   * Return the selected repository
   * @return a potentially null repository
   */
  IPatternRepository getRepository();
  
  /**
   * Set the selected repository
   * @param repository_p a potentially null repository
   */
  void setRepository(IPatternRepository repository_p);
  
}
