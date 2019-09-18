/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.util.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.notification.CatalogResourceChangeHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * This class provides features for handling pattern catalogs, enforcing consistency
 * between the model layer and the physical (file-based) layer
 * @author Olivier Constant
 * @author Skander Turki
 */
public class PatternCatalogAccessor {

  /** A catalog change handler */
  private static CatalogResourceChangeHandler _catalogNotifier;

  /**
   * Default constructor
   */
  protected PatternCatalogAccessor() {
    // Nothing needed
  }

  /**
   * Unregister and unload the given pattern repository using the given
   * editing domain
   * @param repository_p a non-null catalog
   */
  public void closeCatalog(PatternRepository repository_p) {
    CorePatternsPlugin.getDefault().getRepositoryRegistry().unregister(repository_p);
    Resource repositoryResource = repository_p.eResource();
    if (repositoryResource != null) {
      ResourceSet resourceSet = repositoryResource.getResourceSet();
      repositoryResource.unload();
      resourceSet.getResources().remove(repositoryResource);
    }
  }

  /**
   * Load, register and return the pattern repository at the given URI using
   * the given editing domain
   * @param uri_p a non-null URI
   * @param resourceSet_p a non-null resource set
   * @return a potentially null pattern repository
   */
  public PatternRepository createCatalog(URI uri_p, ResourceSet resourceSet_p) {
    String name = uri_p.trimFileExtension().lastSegment();
    Resource resource = ResourcesUtil.getCreateResourceForUri(uri_p, resourceSet_p);
    PatternRepository result = createCatalogIn(resource, name);
    boolean saved = saveCatalog(result);
    if (saved)
      CorePatternsPlugin.getDefault().getRepositoryRegistry().register(result);
    else
      result = null;
    return result;
  }

  /**
   * Create and return a pattern catalog with the given name in the given resource
   * @param resource_p a non-null resource
   * @param name_p a non-null name
   * @return a non-null pattern catalog
   */
  private PatternRepository createCatalogIn(Resource resource_p, String name_p) {
    PatternRepository result = CorepatternsFactory.eINSTANCE.createPatternRepository();
    result.setName(name_p);
    resource_p.getContents().add(result);
    //Add change handler to PatternRepository
    set_catalogNotifier(new CatalogResourceChangeHandler(result));
    return result;
  }

  /**
   * Return the pattern repository in the given resource, if any.
   * The pattern repository must be a root of the resource.
   * @param resource_p a non-null resource
   * @return a potentially null pattern repository
   */
  public PatternRepository getCatalogInResource(Resource resource_p) {
    for (EObject root : resource_p.getContents()) {
      if (root instanceof PatternRepository)
        return (PatternRepository)root;
    }
    return null;
  }

  /**
   * Load, register and return the pattern repository at the given URI using
   * the given editing domain
   * @param uri_p a non-null URI
   * @param resourceSet_p a non-null resource set
   * @return a potentially null pattern repository
   * @throws IOException if loading failed
   */
  public PatternRepository openCatalog(URI uri_p, ResourceSet resourceSet_p)
      throws IOException {
    PatternRepository result = null;
    if (ResourcesUtil.isPersistent(uri_p)) {
      Resource resource = ResourcesUtil.getCreateResourceForUri(uri_p, resourceSet_p);
      if (resource != null) {
        resource.load(null);
        result = getCatalogInResource(resource);
      }
    }
    if (result != null){
      CorePatternsPlugin.getDefault().getRepositoryRegistry().register(result);
      //Add change handler to PatternRepository
      set_catalogNotifier(new CatalogResourceChangeHandler(result));
    }

    return result;
  }

  /**
   * Save the current state of the given catalog
   * @return whether the operation succeeded
   */
  public boolean saveCatalog(PatternRepository repository_p) {
    return ResourcesUtil.makePersistent(repository_p.eResource());
  }

  /**
   * Getter for catalog handler
   * @return a potentially-null CatalogResourceChangeNotifier
   */
  public static CatalogResourceChangeHandler get_catalogNotifier() {
    return _catalogNotifier;
  }

  /**
   * Setter for catalog handler
   * @param catalogNotifier_p a potentially null CatalogResourceChangeNotifier
   */
  protected static void set_catalogNotifier(CatalogResourceChangeHandler catalogNotifier_p) {
    _catalogNotifier = catalogNotifier_p;
  }

}
