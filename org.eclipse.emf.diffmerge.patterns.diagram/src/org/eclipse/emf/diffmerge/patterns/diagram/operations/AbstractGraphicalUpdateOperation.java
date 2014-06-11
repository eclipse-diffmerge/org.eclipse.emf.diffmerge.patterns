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


/**
 * A graphical update operation
 * @author O. CONSTANT
 * @author S. TURKI
 *
 * @param <DiagramType>
 * @param <SemanticRepresentationType>
 */
public abstract class AbstractGraphicalUpdateOperation<DiagramType, SemanticRepresentationType> {

  /**
   * Update the given representation
   * @param decorator_p a non-null SemanticRepresentationType
   */
  public abstract void update(SemanticRepresentationType decorator_p, boolean isMerged);
  
}
