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

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.Messages;


/**
 * A model operation that consists in adding a pattern to a catalog.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class AddToCatalogOperation 
  extends AbstractModelOperation<Boolean>{
  
  /** The non-null catalog */
  private final PatternRepository _catalog;
  
  /** The non-null pattern */
  private final AbstractPattern _pattern;
  
	/**
	 * Constructor
	 * @param catalog_p the non-null catalog where the pattern must be stored
	 * @param pattern_p the non-null pattern to store
	 */
	public AddToCatalogOperation(PatternRepository catalog_p, AbstractPattern pattern_p, Object patternSideContext_p) {
    super(Messages.AddToCatalogOperation_Name, null, false, false, false, patternSideContext_p, pattern_p);
    _catalog = catalog_p;
    _pattern = pattern_p;
	}
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected Boolean run() {  
    _catalog.getPatterns().add(_pattern);
    Boolean result = call(new UpdateCatalogOperation(_catalog, getTargetContext()));
    if (!result.booleanValue() && getModelEnvironment() != null)
       getModelEnvironment().abortOperation();
    return result;
  }
  
}
