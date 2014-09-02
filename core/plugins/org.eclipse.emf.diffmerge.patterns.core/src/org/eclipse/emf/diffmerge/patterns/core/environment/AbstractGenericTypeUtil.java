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
package org.eclipse.emf.diffmerge.patterns.core.environment;


/**
 * This is a utility class that provides "instanceof" checking for generic types. 
 * Must be sub-classed by the designing environment to provide both static 
 * and run-time type checking for generics.
 * (consequence of erasure implementation of generics in Java).
 * @author Skander Turki
 */
public abstract class AbstractGenericTypeUtil {
  
  /**
   * Run-time type checker for ColorType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfColorType(Object object_p);
  
  /**
   * Run-time type getter for ColorType.
   */
  public abstract Class<?> getColorTypeClass();
  
  /**
   * Run-time type checker for DiagramElementType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfDiagramElementType(Object object_p);
  
  /**
   * Run-time type getter for DiagramElementType.
   */
  public abstract Class<?> getDiagramElementTypeClass();
  
  /**
   * Run-time type checker for DiagramType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfDiagramType(Object object_p);
  
  /**
   * Run-time type getter for DiagramType.
   */
  public abstract Class<?> getDiagramTypeClass();
  
  /**
   * Run-time type checker for GraphicalNodeType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfGraphicalNodeType(Object object_p);
  
  /**
   * Run-time type getter for GraphicalNodeType.
   */
  public abstract Class<?> getGraphicalNodeTypeClass();
  
  /**
   * Run-time type checker for GraphicalPartType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfGraphicalPartType(Object object_p);
  
  /**
   * Run-time type getter for GraphicalPartType.
   */
  public abstract Class<?> getGraphicalPartTypeClass();
  
  /**
   * Run-time type checker for GraphicalContainerType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfGraphicalContainerType(Object object_p);
  
  /**
   * Run-time type getter for GraphicalContainerType.
   */
  public abstract Class<?> getGraphicalContainerTypeClass();
  
  /**
   * Run-time type checker for GraphicalNodeContainerType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfGraphicalNodeContainerType(Object object_p);
  
  /**
   * Run-time type getter for GraphicalNodeContainerType.
   */
  public abstract Class<?> getGraphicalNodeContainerTypeClass();
  
  /**
   * Run-time type checker for SemanticRepresentationType.
   * @param object_p any Object
   */
  public abstract boolean isInstanceOfSemanticRepresentationType(Object object_p);
  
  /**
   * Run-time type getter for SemanticRepresentationType.
   */
  public abstract Class<?> getSemanticRepresentationTypeClass();
  
}
