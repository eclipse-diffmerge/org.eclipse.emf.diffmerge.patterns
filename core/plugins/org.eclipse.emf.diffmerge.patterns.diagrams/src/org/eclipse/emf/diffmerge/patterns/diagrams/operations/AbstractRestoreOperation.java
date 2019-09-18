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

/**
 * An abstract operation for restoring diagram elements based on specific criteria on semantic elements.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractRestoreOperation 
extends AbstractGraphicalUpdateOperation{

  /** The name of the operation */
  private static final String NAME = Messages.RestoreOperation_Name;

  
  /**
   * Getter
   */
  public static String getName() {
    return NAME;
  }

  
}
