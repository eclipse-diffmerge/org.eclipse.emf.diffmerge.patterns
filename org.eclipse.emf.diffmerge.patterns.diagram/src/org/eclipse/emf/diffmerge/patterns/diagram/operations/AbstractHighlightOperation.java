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
package org.eclipse.emf.diffmerge.patterns.diagram.operations;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.Messages;

/**
 * An operation for highlighting diagram elements
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractHighlightOperation extends AbstractGraphicalUpdateOperation{

  /** The name of the operation */
  private static final String NAME = Messages.HighlightOperation_Name;

  /** The highlighting color */
  protected final RGB _color;

  /** The highlighting size */
  protected final Integer _borderSize;

  /** Whether edges must be highlighted */
  protected final boolean _coverEdges;

  /** Whether nodes must be highlighted */
  protected final boolean _coverNodes;

  /** Whether bordered nodes must be highlighted */
  protected final boolean _coverPorts;

  /**
   * Constructor
   * @param diagram_p the diagram to update
   * @param instance_p the non-null instance whose elements must be highlighted
   * @param color_p a non-null color for highlighting
   * @param coverEdges_p whether edges must be highlighted
   * @param coverContainers_p whether containers must be highlighted
   * @param coverNodes_p whether nodes must be highlighted
   * @param coverPorts_p whether ports must be highlighted
   */
  public AbstractHighlightOperation(Object diagram_p, IPatternInstance instance_p, RGB color_p, int borderSize_p, boolean coverEdges_p, boolean coverNodes_p,
      boolean coverPorts_p) {
    this(diagram_p, Collections.singleton(instance_p), color_p, borderSize_p, coverEdges_p, coverNodes_p, coverPorts_p);
  }

  /**
   * Constructor
   * @param diagram_p the diagram to update
   * @param instances_p the non-null collection of instances whose elements must be highlighted
   * @param color_p a non-null color for highlighting
   * @param coverEdges_p whether edges must be highlighted
   * @param coverContainers_p whether containers must be highlighted
   * @param coverNodes_p whether nodes must be highlighted
   * @param coverPorts_p whether ports must be highlighted
   */
  @SuppressWarnings("boxing")
  public AbstractHighlightOperation(Object diagram_p, Collection<? extends IPatternInstance> instances_p, RGB color_p, int borderSize_p, boolean coverEdges_p,
      boolean coverNodes_p, boolean coverPorts_p) {
    _color = color_p;
    _coverEdges = coverEdges_p;
    _coverNodes = coverNodes_p;
    _coverPorts = coverPorts_p;
    _borderSize = borderSize_p;
  }

  /**
   * Getter
   */
  public static String getName() {
    return NAME;
  }

  /**
   * Getter
   */
  public RGB get_color() {
    return _color;
  }

  /**
   * Getter
   */
  public Integer get_borderSize() {
    return _borderSize;
  }

  /**
   * Getter
   */
  public boolean is_coverEdges() {
    return _coverEdges;
  }

  /**
   * Getter
   */
  public boolean is_coverNodes() {
    return _coverNodes;
  }

  /**
   * Getter
   */
  public boolean is_coverPorts() {
    return _coverPorts;
  }

}
