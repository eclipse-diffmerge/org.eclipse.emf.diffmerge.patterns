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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;


import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;

/**
 * A abstract model operation that consists in updating a template pattern and making this update
 * persistent in its repository, which is assumed to be a catalog.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractUpdatePatternLayoutInCatalogOperation extends AbstractOperation<TemplatePattern>{

  /** The name of the operation */
  private static final String NAME = Messages.UpdatePatternInCatalogOperation_Name;
  
  /**
   * Constructor
   */
  public AbstractUpdatePatternLayoutInCatalogOperation(){
  }
  
  /**
   * Update the layout data of the given pattern from the given GEF elements
   * @param pattern_p a non-null pattern
   */
  protected abstract void updateLayoutData(TemplatePattern pattern_p);
    
  /**
   * Getter
   */
  public static String getName() {
    return NAME;
  }
}
