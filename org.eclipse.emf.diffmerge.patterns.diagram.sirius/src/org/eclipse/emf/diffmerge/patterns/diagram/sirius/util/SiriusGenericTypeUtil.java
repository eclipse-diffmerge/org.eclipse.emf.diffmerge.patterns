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
package org.eclipse.emf.diffmerge.patterns.diagram.sirius.util;

import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.viewpoint.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.viewpoint.DDiagram;
import org.eclipse.sirius.viewpoint.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;




/**
 * This is a Sirius-specific utility class that provides "instanceof" checking for generic types. 
 * @author Skander TURKI
 */
public class SiriusGenericTypeUtil 
extends AbstractGenericTypeUtil{

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfColorType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfColorType(Object object_p) {
    return object_p instanceof RGBValues;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfDiagramElementType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfDiagramElementType(Object object_p) {
    return object_p instanceof DDiagramElement;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfDiagramType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfDiagramType(Object object_p) {
    return object_p instanceof DDiagram;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfGraphicalNodeType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfGraphicalNodeType(Object object_p) {
    return object_p instanceof AbstractDNode;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfGraphicalPartType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfGraphicalPartType(Object object_p) {
    return object_p instanceof IGraphicalEditPart;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfGraphicalContainerType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfGraphicalContainerType(Object object_p) {
    return object_p instanceof DContainer;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfSemanticRepresentationType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfSemanticRepresentationType(Object object_p) {
    return object_p instanceof DSemanticDecorator;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getColorTypeClass()
   */
  @Override
  public  Class<?> getColorTypeClass() {
    return RGBValues.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getDiagramElementTypeClass()
   */
  @Override
  public Class<?> getDiagramElementTypeClass() {
    return DDiagramElement.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getDiagramTypeClass()
   */
  @Override
  public Class<?> getDiagramTypeClass() {
    return DDiagram.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getGraphicalNodeTypeClass()
   */
  @Override
  public Class<?> getGraphicalNodeTypeClass() {
    return AbstractDNode.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getGraphicalPartTypeClass()
   */
  @Override
  public Class<?> getGraphicalPartTypeClass() {
    return IGraphicalEditPart.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getGraphicalContainerTypeClass()
   */
  @Override
  public Class<?> getGraphicalContainerTypeClass() {
    return DContainer.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getSemanticRepresentationTypeClass()
   */
  @Override
  public Class<?> getSemanticRepresentationTypeClass() {
    return DSemanticDecorator.class
        ;
  }


}
