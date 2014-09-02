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
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.Messages;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogsPlugin;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.ResourcesUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


/**
 * A model operation that consists in creating a new catalog.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class CreateCatalogOperation 
  extends AbstractModelOperation<PatternRepository> {
  
  /** The file in which to create the catalog */
  private final IFile _file;
	
	 /**
   * Constructor
   * @param file_p a non-null file for storing the catalog
   * @param domain_p the non-null transactional editing domain into which the catalog must be loaded
   */
  public CreateCatalogOperation(IFile file_p, TransactionalEditingDomain domain_p, Object sourceContext_p) {
    super(Messages.CreateCatalogOperation_Name, domain_p.getResourceSet(), false, false, false, domain_p, sourceContext_p);
    _file = file_p;
  }
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected PatternRepository run() {
    return PatternCatalogsPlugin.getDefault().getAccessor().createCatalog(
        ResourcesUtil.getUriForFile(_file), getResourceSet());
  }
	
}
