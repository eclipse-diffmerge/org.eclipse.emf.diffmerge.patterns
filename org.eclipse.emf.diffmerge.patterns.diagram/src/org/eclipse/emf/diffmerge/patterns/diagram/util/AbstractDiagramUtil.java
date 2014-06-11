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
package org.eclipse.emf.diffmerge.patterns.diagram.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Point;
 
/**
 * An abstract utility class for services related to diagram template types
 * @author Skander TURKI
 *
 * @param <DiagramElementType>
 * @param <DiagramType>
 */
public abstract class AbstractDiagramUtil<DiagramElementType, DiagramType, GraphicalPartType> {

  /**
   * Returns a list of diagram elements in the given diagram
   * @param diagram_p
   * @return
   */
  public abstract List<DiagramElementType> getDiagramElements(DiagramType diagram_p);

  /**
   * Returns a list of the semantic elements represented by the given diagram element
   * @param diagramElement_p
   * @return
   */
  public abstract List<EObject> getSemanticElementsFor(DiagramElementType diagramElement_p);

  /**
   * Return the location of the given diagram element
   * @param diagramElement_p a potentially null DiagramElementType
   * @return a non-null Point, (0,0) by default
   */
  public abstract Point getLocation(DiagramElementType diagramElement_p);

  /**
   * Return the technical container of the given diagram element in the diagram model
   * @param diagramElement_p a potentially null DiagramElementType
   * @return a non-null EObject
   */
  public abstract EObject getTechnicalContainerFor(DiagramElementType diagramElement_p);

  /**
   * Return the objects represented by the given selected object when considered
   * as a selection.
   * @param selected_p a non-null object
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public abstract Collection<?> toActualSelection(Object selected_p);

  /**
   * Return the current diagram, if any
   * @return a potentially null diagram
   */
  public abstract DiagramType getDiagramFromSelection(IStructuredSelection selection_p);
  
  /**
   * Export the given GEF edit parts to a string representation of an SVG image.
   * @param gefElements_p a non-null, non-empty collection of edit parts which all belong to the same diagram
   * @return a potentially null string
   */
  public abstract String exportToSVG(final List<? extends GraphicalPartType> gefElements_p);
  
}
