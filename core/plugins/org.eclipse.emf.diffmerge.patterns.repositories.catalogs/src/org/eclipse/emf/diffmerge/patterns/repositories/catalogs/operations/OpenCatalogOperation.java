/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.diffmerge.patterns.core.util.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.Messages;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogsPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


/**
 * A model operation that consists in opening a catalog.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class OpenCatalogOperation 
extends AbstractModelOperation<Collection<PatternRepository>> {

  /** The URI of the catalog file to open */
  private URI _file;

  /** A non-null, potentially empty set of instances whose pattern path must be updated */
  private final Collection<IPatternInstance> _instancesToUpdate;

  /** A non-null, potentially empty map of throwables which have been thrown
   * when trying to open the catalog at the corresponding URI*/
  private final Map<URI, Throwable> _throwables;


  /**
   * Constructor
   * @param instance_p a non-null pattern instance
   * @param resourceSet_p the non-null resource set into which the catalog must be loaded
   */
  public OpenCatalogOperation(IPatternInstance instance_p, ResourceSet resourceSet_p) {
    this(getLastCatalogPath(instance_p), resourceSet_p);
  }
  
  /**
   * Constructor
   * @param instance_p a non-null pattern instance
   * @param domain_p the non-null transactional editing domain into which the catalog must be loaded
   */
  public OpenCatalogOperation(IPatternInstance instance_p, TransactionalEditingDomain domain_p) {
    this(getLastCatalogPath(instance_p), domain_p);
  }

  /**
   * Constructor
   * @param file_p a non-null catalog file, IFile, URI or URI string
   * @param resourceSet_p the non-null resource set into which the catalog must be loaded
   */
  public OpenCatalogOperation(Object file_p, ResourceSet resourceSet_p) {
    this(file_p, resourceSet_p, Collections.<IPatternInstance>emptyList());
  }
  
  /**
   * Constructor
   * @param file_p a non-null catalog file, IFile, URI or URI string
   * @param domain_p the non-null transactional editing domain into which the catalog must be loaded
   */
  public OpenCatalogOperation(Object file_p, TransactionalEditingDomain domain_p) {
    this(file_p, domain_p, Collections.<IPatternInstance>emptyList());
  }
  
  /**
   * Constructor
   * @param file_p a non-null catalog file, IFile, URI or URI string
   * @param domain_p the non-null transactional editing domain into which the catalog must be loaded
   * @param instancesToUpdate_p a non-null, potentially empty set of instances whose
   *        last path must be updated if the pattern corresponds
   */
  public OpenCatalogOperation(Object file_p, TransactionalEditingDomain domain_p,
      Collection<? extends IPatternInstance> instancesToUpdate_p) {
    super(Messages.OpenCatalogOperation_Name, domain_p.getResourceSet(),
        !instancesToUpdate_p.isEmpty(), false, true, domain_p, instancesToUpdate_p);
    _throwables = new HashMap<URI, Throwable>();
    _instancesToUpdate =
        new ModelsUtil.ROrderedSet<IPatternInstance>(instancesToUpdate_p);
    _file = null;
    if (file_p instanceof URI)
      _file = (URI)file_p;
    else if (file_p instanceof IFile)
      _file = ResourcesUtil.getUriForFile((IFile)file_p);
    else if (file_p instanceof String)
      _file = URI.createURI((String)file_p);
  }

  /**
   * Constructor
   * @param file_p a non-null catalog file, IFile, URI or URI string
   * @param resourceSet_p the non-null resource set into which the catalog must be loaded
   * @param instancesToUpdate_p a non-null, potentially empty set of instances whose
   *        last path must be updated if the pattern corresponds
   */
  public OpenCatalogOperation(Object file_p, ResourceSet resourceSet_p,
      Collection<? extends IPatternInstance> instancesToUpdate_p) {
    super(Messages.OpenCatalogOperation_Name, resourceSet_p,
        !instancesToUpdate_p.isEmpty(), false, true, resourceSet_p, instancesToUpdate_p);
    _throwables = new HashMap<URI, Throwable>();
    _instancesToUpdate =
        new ModelsUtil.ROrderedSet<IPatternInstance>(instancesToUpdate_p);
    _file = null;
    if (file_p instanceof URI)
      _file = (URI)file_p;
    else if (file_p instanceof IFile)
      _file = ResourcesUtil.getUriForFile((IFile)file_p);
    else if (file_p instanceof String)
      _file = URI.createURI((String)file_p);
  }

  /**
   * Return the last catalog path for the pattern of the given instance
   * @param instance_p a non-null instance
   * @return a potentially null URI
   */
  private static URI getLastCatalogPath(IPatternInstance instance_p) {
    URI result = null;
    IPatternVersion version = instance_p.getPatternVersion();
    if (version != null) {
      IPatternSymbol symbol = version.getPatternSymbol();
      if (symbol != null) {
        String stringPath = symbol.getLastPath();
        if (stringPath != null) {
          result = URI.createURI(stringPath);
          result = result.trimFragment();
        }
      }
    }
    return result;
  }

  /**
   * Return a map containing the errors that occurred when trying to open a catalog
   * and the associated catalog URI
   * @return a non-null, potentially empty, unmodifiable map
   */
  public Map<URI, Throwable> getErrors() {
    return Collections.unmodifiableMap(_throwables);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected Collection<PatternRepository> run() {
    List<PatternRepository> result = new ArrayList<PatternRepository>();
    PatternRepository catalog = null;
    try {
      catalog = PatternCatalogsPlugin.getDefault().getAccessor().openCatalog(
          _file, getResourceSet());
    } catch (IOException e) {
      _throwables.put(_file, e);
    }
    if (catalog != null)
      result.add(catalog);
    updateLastPathOfInstances(_instancesToUpdate, result);
    return result;
  }

  /**
   * Update the last path of the given instances if relevant
   * @param instancesToUpdate_p a non-null, potentially empty set of instances
   * @param loadedRepositories_p a non-null, potentially empty set of repositories
   */
  private void updateLastPathOfInstances(Collection<IPatternInstance> instancesToUpdate_p,
      List<PatternRepository> loadedRepositories_p) {
    // Collecting resources for ID retrieval scope
    Set<Resource> resources = new HashSet<Resource>(loadedRepositories_p.size());
    for (PatternRepository repository : loadedRepositories_p) {
      if (repository.eResource() != null)
        resources.add(repository.eResource());
    }
    // Actually updating last path in pattern symbols of instances
    for (IPatternInstance instance : instancesToUpdate_p) {
      IPatternSymbol iSymbol = instance.getPatternVersion().getPatternSymbol();
      if (iSymbol instanceof PatternSymbol) {
        final PatternSymbol symbol = (PatternSymbol)iSymbol;
        String id = symbol.getPatternId();
        EObject pattern = CorePatternsPlugin.getDefault().getIdProvider().getById(id, resources);
        if (pattern != null) {
          // Pattern found in one of the resources: update last path
          URI uri = EcoreUtil.getURI(pattern);
          if (uri != null) {
            final String newPath = uri.toString();
            if (!newPath.equals(symbol.getLastPath())) {
              EditingDomain ed =
                  CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(
                      EcoreUtil.getRootContainer(symbol));
              if (ed != null) {
                ChangeCommand cmd = new ChangeCommand(ed.getResourceSet()) {
                  {
                    label = OpenCatalogOperation.this.getName();
                  }
                  /**
                   * @see org.eclipse.emf.edit.command.ChangeCommand#doExecute()
                   */
                  @Override
                  protected void doExecute() {
                    symbol.setLastPath(newPath);
                  }
                };
                ed.getCommandStack().execute(cmd);
              }
            }
          }
        }
      }
    }
  }

}
