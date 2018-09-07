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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.Messages;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogsPlugin;


/**
 * A model operation that consists in updating a catalog with the contents it currently has
 * in memory.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class UpdateCatalogOperation 
extends AbstractModelOperation<Boolean> {

  /** The non-null catalog to update */
  private final PatternRepository _catalog;

  /**
   * Constructor
   * @param catalog_p the non-null catalog to update
   */
  public UpdateCatalogOperation(PatternRepository catalog_p, Object targetContext_p) {
    super(Messages.UpdateCatalogOperation_Name, null, true, false, false, targetContext_p, null);
    _catalog = catalog_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected Boolean run() {
    boolean ok = PatternCatalogsPlugin.getDefault().getAccessor().saveCatalog(_catalog);
    return Boolean.valueOf(ok);
  }

}
