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

import org.eclipse.emf.diffmerge.patterns.diagram.Messages;

/**
 * An abstract operation for restoring diagram elements based on specific criteria on semantic elements.
 * @author O. CONSTANT
 * @author S. TURKI
 *
 * @param <DiagramType>
 * @param <SemanticRepresentationType>
 */
public abstract class AbstractRestoreOperation<DiagramType, SemanticRepresentationType> 
extends AbstractGraphicalUpdateOperation<DiagramType, SemanticRepresentationType>{

  /** The name of the operation */
  private static final String NAME = Messages.RestoreOperation_Name;

  
  /**
   * Getter
   */
  public static String getName() {
    return NAME;
  }

  
}
