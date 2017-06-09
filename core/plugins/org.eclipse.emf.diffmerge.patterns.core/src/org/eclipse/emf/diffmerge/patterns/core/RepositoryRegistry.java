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
package org.eclipse.emf.diffmerge.patterns.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;

/**
 * A registry of pattern repositories
 * @author Olivier Constant
 */
public class RepositoryRegistry {
  
  /** The registered repositories and their IDs */
  private Map<String, IPatternRepository> _repositories;
  
  /**
   * Constructor
   */
  public RepositoryRegistry() {
    _repositories = new HashMap<String, IPatternRepository>();
  }
  
  /**
   * Clear the registry from all repositories
   */
  public void clear() {
    _repositories.clear();
  }
  
  /**
   * Return the pattern identified by the given symbol
   * @param symbol_p a non-null pattern symbol
   * @return a pattern or null if no such pattern can be found
   */
  public IPattern getPattern(IPatternSymbol symbol_p) {
    IPattern result = null;
    IPatternRepository repository = getRepository(symbol_p.getRepositoryId());
    if (repository != null)
      result = repository.getPattern(symbol_p);
    return result;
  }
  
  /**
   * Return all patterns from the registered repositories
   * @return a non-null, potentially empty, unmodifiable list
   */
  public List<IPattern> getPatterns() {
    List<IPattern> result = new ArrayList<IPattern>();
    for (IPatternRepository repository : getRepositories()) {
      result.addAll(repository.getPatterns());
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Return all the registered repositories
   * @return a non-null, unmodifiable collection
   */
  public Collection<IPatternRepository> getRepositories() {
    return Collections.unmodifiableCollection(_repositories.values());
  }
  
  /**
   * Return a repository from the given repository ID
   * @param id_p a non-null ID
   * @return a potentially null repository
   */
  public IPatternRepository getRepository(String id_p) {
    return _repositories.get(id_p);
  }
  
  /**
   * Register the given repository
   * @param repository_p a non-null repository
   */
  public void register(IPatternRepository repository_p) {
    _repositories.put(repository_p.getId(), repository_p);
  }
  
  /**
   * Unregister the given repository
   * @param repository_p a non-null repository
   */
  public void unregister(IPatternRepository repository_p) {
    _repositories.remove(repository_p.getId());
  }
  
}
