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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.util.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.Messages;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogAccessor;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogsPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * A model operation that consists in closing a catalog.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class CloseCatalogOperation  extends AbstractModelOperation<Integer> {

  /** The non-null catalog to close */
  private PatternRepository _catalog;

  /**
   * Constructor
   * @param catalog_p the non-null catalog to close
   */
  public CloseCatalogOperation(PatternRepository catalog_p) {
    super(Messages.CloseCatalogOperation_Name, null, false, false, false, catalog_p, null);
    _catalog = catalog_p;
  }

  /**
   * Constructor
   * @param catalogFile_p the non-null catalog file to close
   * @param resourceSet_p a non-null resource set where the catalog file has been loaded
   */
  public CloseCatalogOperation(IFile catalogFile_p, ResourceSet resourceSet_p) {
    super(Messages.CloseCatalogOperation_Name, resourceSet_p, false, false, false, resourceSet_p, null);
    PatternCatalogAccessor accessor = PatternCatalogsPlugin.getDefault().getAccessor();
    _catalog = null;
    URI uri = ResourcesUtil.getUriForFile(catalogFile_p);
    if (uri != null) {
      Resource resource = ResourcesUtil.getResourceForUri(uri, resourceSet_p);
      if (resource != null) {
        _catalog = accessor.getCatalogInResource(resource);
      }
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @SuppressWarnings("boxing")
  @Override
  protected Integer run() {
    PatternCatalogsPlugin.getDefault().getAccessor().closeCatalog(_catalog);
    return _catalog != null? 1 : 0;
  }

}
