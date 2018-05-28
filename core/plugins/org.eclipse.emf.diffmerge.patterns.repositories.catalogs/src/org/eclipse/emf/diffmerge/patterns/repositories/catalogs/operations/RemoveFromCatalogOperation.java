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

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.Messages;


/**
 * A model operation that consists in removing a pattern from its catalog.
 * @author Olivier Constant
 * @auhtor Skander Turki
 */
public class RemoveFromCatalogOperation 
extends AbstractModelOperation<Boolean> {

  /** The non-null pattern */
  private final AbstractPattern _pattern;

  /**
   * Constructor
   * @param pattern_p the non-null pattern to remove
   */
  public RemoveFromCatalogOperation(AbstractPattern pattern_p, Object targetContext_p) {
    super(Messages.RemoveFromCatalogOperation_Name, null, false, false, false, targetContext_p, null);
    _pattern = pattern_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected Boolean run() {
    Boolean result = Boolean.FALSE;
    IPatternRepository repository = _pattern.getRepository();
    if (repository instanceof PatternRepository) {
      PatternRepository catalog = (PatternRepository)repository;
      catalog.getPatterns().remove(_pattern);
      result = call(new UpdateCatalogOperation(catalog, getTargetContext()));
      if (!result.booleanValue() && getModelEnvironment() != null)
        getModelEnvironment().abortOperation();
    }
    return result;
  }

}
