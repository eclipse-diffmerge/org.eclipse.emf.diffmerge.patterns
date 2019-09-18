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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;


import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;

/**
 * A model operation that consists in creating a template pattern, storing it in a repository
 * and returning an instance of this new pattern based on the original elements
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractCreatePatternAndInstanceLayoutOperation 
  extends AbstractOperation<IPatternInstance> {

  /** The name of the operation */
  private static final String NAME = Messages.CreatePatternAndInstanceOperation_Name;
  
  /**
   * Constructor
   */
  public AbstractCreatePatternAndInstanceLayoutOperation() {
  }


  /**
   * Setup the layout data of the given pattern based on the given GEF elements
   * @param pattern_p a non-null pattern
   */
  protected abstract void setupLayoutData(TemplatePattern pattern_p);

  /**
   * Getter
   */
  public static String getName() {
    return NAME;
  }

}
