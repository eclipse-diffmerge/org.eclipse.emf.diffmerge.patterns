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


import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternUpdateComparison;
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
   * @param interPatternComparison_p the non-null result of the update of the pattern
   */
  protected abstract void updateLayoutData(TemplatePattern pattern_p,
      TemplatePatternUpdateComparison interPatternComparison_p);
    
  /**
   * Getter
   */
  public static String getName() {
    return NAME;
  }
}
