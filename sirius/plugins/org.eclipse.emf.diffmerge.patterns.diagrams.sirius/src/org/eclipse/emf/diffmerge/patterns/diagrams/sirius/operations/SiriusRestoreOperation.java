/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractRestoreOperation;
import org.eclipse.sirius.diagram.BorderedStyle;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.DStylizable;
import org.eclipse.sirius.viewpoint.Style;


/**
 * An operation for restoring diagram elements based on specific criteria on semantic elements.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SiriusRestoreOperation extends SiriusFilteredGraphicalUpdateOperation {

  /**
   * Constructor
   * @param diagram_p the diagram to update
   * @param instance_p the non-null instance whose elements must be highlighted
   */
  public SiriusRestoreOperation(Object diagram_p, IPatternInstance instance_p) {
    this(diagram_p, Collections.singleton(instance_p));
  }

  /**
   * Constructor.
   * @param diagram_p the diagram to update
   * @param instances_p the non-null, non-empty collection of instances whose elements must be highlighted
   */
  public SiriusRestoreOperation(Object diagram_p, Collection<? extends IPatternInstance> instances_p) {
    super(AbstractRestoreOperation.getName(), diagram_p, instances_p, true, instances_p);
    _innerGraphicalOperation = new InnerRestoreOperation();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation#update(java.lang.Object, boolean)
   */
  @Override
  protected void update(Object decorator_p, boolean isMerged) {
    _innerGraphicalOperation.update(decorator_p, isMerged);
  }

  /**
   * Inner class, simulates multiple inheritance of SiriusRestoreOperation --> (AbstractRestoreOperation, SiriusFilteredGraphicalUpdateOperation)
   * @author Skander Turki
   */
  protected class InnerRestoreOperation extends AbstractRestoreOperation{

    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalUpdateOperation#update(java.lang.Object, boolean)
     */
    @SuppressWarnings({ "boxing" })
    @Override
    public void update(Object object_p, boolean isMerged) {
      if(object_p instanceof DSemanticDecorator){
        DSemanticDecorator decorator_p = (DSemanticDecorator)object_p;
        if (decorator_p instanceof DEdge) {
          DEdge edge = (DEdge) decorator_p;
          Style style = edge.getStyle();
          if (style instanceof EdgeStyle) {
            EdgeStyle edgeStyle = (EdgeStyle) style;
            if (edgeStyle.getCenterLabelStyle() != null) {
              edgeStyle.getCenterLabelStyle().getCustomFeatures().clear();
            }
            if (edgeStyle.getBeginLabelStyle() != null) {
              edgeStyle.getBeginLabelStyle().getCustomFeatures().clear();
            }
            if (edgeStyle.getEndLabelStyle() != null) {
              edgeStyle.getEndLabelStyle().getCustomFeatures().clear();
            }
            // not stable with a diagram refresh
            edgeStyle.setSize(1);
            edgeStyle.getCustomFeatures().remove(DiagramPackage.eINSTANCE.getEdgeStyle_Size().getName());
          }
        }
        if (decorator_p instanceof DStylizable) {
          DStylizable stylizable = (DStylizable) decorator_p;
          stylizable.getStyle().getCustomFeatures().remove(DiagramPackage.eINSTANCE.getBorderedStyle_BorderColor().getName());
          stylizable.getStyle().getCustomFeatures().remove(DiagramPackage.eINSTANCE.getEdgeStyle_StrokeColor().getName());
          stylizable.getStyle().refresh();
          if (stylizable.getStyle() instanceof BorderedStyle) {
            BorderedStyle style = (BorderedStyle) stylizable.getStyle();
            // not stable with a diagram refresh
            style.setBorderSize(1);
            style.setBorderSizeComputationExpression("0"); //$NON-NLS-1$
            style.getCustomFeatures().remove(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSize().getName());
            style.getCustomFeatures().remove(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSizeComputationExpression().getName());
          }
        }
      }

    }   
  }


}
