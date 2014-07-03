/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagram.operations;


import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;

/**
 * A model operation that consists in creating a template pattern, storing it in a repository
 * and returning an instance of this new pattern based on the original elements
 * @author O. CONSTANT
 * @author Skander TURKI
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
