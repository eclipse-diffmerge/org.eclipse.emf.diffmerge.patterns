/**
 * <copyright>
 * 
 * Copyright (c) 2010-2016 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.diagrams.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Point;
 
/**
 * An abstract utility class for services related to diagram template types
 * @author Skander Turki
 */
public abstract class AbstractDiagramUtil {

  /**
   * Returns a list of diagram elements in the given diagram
   * @param diagram_p a potentially null object
   * @return a non-null, potentially empty list
   */
  public abstract List<?> getDiagramElements(Object diagram_p);

  /**
   * Returns a list of the semantic elements represented by the given diagram element
   * @param diagramElement_p a potentially null object
   * @return a non-null, potentially empty list
   */
  public abstract List<EObject> getSemanticElementsFor(Object diagramElement_p);

  /**
   * Return the location of the given diagram element
   * @param diagramElement_p a potentially null DiagramElementType
   * @return a non-null Point, (0,0) by default
   */
  public abstract Point getLocation(Object diagramElement_p);

  /**
   * Return the technical container of the given diagram element in the diagram model
   * @param diagramElement_p a potentially null DiagramElementType
   * @return a non-null EObject
   */
  public abstract EObject getTechnicalContainerFor(Object diagramElement_p);

  /**
   * Return the objects represented by the given selected object when considered
   * as a selection.
   * @param selected_p a non-null object
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public abstract Collection<?> toActualSelection(Object selected_p);

  /**
   * Return the current diagram, if any
   * @param selection_p a potentially null selection
   * @return a potentially null diagram
   */
  public abstract Object getDiagramFromSelection(IStructuredSelection selection_p);
  
  /**
   * Export the given GEF edit parts to a string representation of an SVG image.
   * @param gefElements_p a non-null, non-empty collection of edit parts which all belong to the same diagram
   * @return a potentially null string
   */
  public abstract String exportToSVG(final List<Object> gefElements_p);

  /**
   * Returns the target semantic object referenced by the given semantic decorator.
   * @param semanticDecorator_p a non-null semantic decorator.
   * @return a potentially null semantic EObject.
   */
  public abstract EObject getSemanticRepresentationTypeTarget(Object semanticDecorator_p);

  
  /**
   * Returns the owned diagram elements of a node container
   * @param semanticDecorator_p a non-null node container
   * @return a potentially empty collection
   */
  public abstract Collection<?> getOwnedDiagramElements(Object semanticDecorator_p);

  /**
   * Return whether the "show instance" option should be available for the given diagram
   */
  public abstract boolean isShowInstanceEnabled(Object diagram_p);
  
  /**
   * Sort the given set of user-selected diagram elements for later usage
   * @param elements_p a non-null, potentially empty list
   * @return a non-null list
   */
  public abstract List<Object> sortElements(Collection<?> elements_p);
  
}
