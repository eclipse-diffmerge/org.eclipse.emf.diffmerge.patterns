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
package org.eclipse.emf.diffmerge.patterns.core.operations;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.Messages;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;


/**
 * A model operation that consists in creating an instance of a pattern from a
 * given application of the pattern.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class CreateInstanceOperation extends AbstractModelOperation<IPatternInstance> {

  /** The non-null pattern application */
  private final IPatternApplication _application;


  /**
   * Constructor
   * @param application_p the non-null application from which the instance must be created
   */
  public CreateInstanceOperation(IPatternApplication application_p, 
      Object patternContext_p, Object targetContext_p) {
    super(Messages.CreateInstanceOperation_Name, null, true, false, true, 
        targetContext_p, patternContext_p);
    _application = application_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected IPatternInstance run() {
    IPatternInstance result = null;
    IPatternSupport patternSupport =
        CorePatternsPlugin.getDefault().getPatternSupportFor(_application);
    if (patternSupport != null) {
      result = patternSupport.createInstance(_application);
    }
    return result;
  }

}
