/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractHighlightOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.SiriusUtil;
import org.eclipse.sirius.diagram.BeginLabelStyle;
import org.eclipse.sirius.diagram.BorderedStyle;
import org.eclipse.sirius.diagram.CenterLabelStyle;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DNodeList;
import org.eclipse.sirius.diagram.DiagramFactory;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.EndLabelStyle;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.viewpoint.BasicLabelStyle;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.graphics.RGB;


/**
 * An operation for highlighting diagram elements based on specific criteria on semantic elements.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SiriusHighlightOperation extends SiriusFilteredGraphicalUpdateOperation {

  /**
   * Constructor
   * @param diagram_p the diagram to update
   * @param instance_p the non-null instance whose elements must be highlighted
   * @param color_p a non-null color for highlighting
   * @param coverEdges_p whether edges must be highlighted
   * @param coverNodes_p whether nodes must be highlighted
   * @param coverPorts_p whether ports must be highlighted
   */
  public SiriusHighlightOperation(Object diagram_p, IPatternInstance instance_p, RGB color_p,
      int borderSize_p, boolean coverEdges_p, boolean coverNodes_p, boolean coverPorts_p) {
    this(diagram_p, Collections.singleton(instance_p), color_p, borderSize_p, coverEdges_p, coverNodes_p, coverPorts_p);
    _innerGraphicalOperation = new InnerHighlightOperation(diagram_p, instance_p, color_p, borderSize_p, coverEdges_p, coverNodes_p,
        coverPorts_p);
  }

  /**
   * Constructor
   * @param diagram_p the diagram to update
   * @param instances_p the non-null collection of instances whose elements must be highlighted
   * @param color_p a non-null color for highlighting
   * @param coverEdges_p whether edges must be highlighted
   * @param coverNodes_p whether nodes must be highlighted
   * @param coverPorts_p whether ports must be highlighted
   */
  public SiriusHighlightOperation(Object diagram_p, Collection<? extends IPatternInstance> instances_p, RGB color_p, int borderSize_p, boolean coverEdges_p,
      boolean coverNodes_p, boolean coverPorts_p) {
    super(AbstractHighlightOperation.getName(), diagram_p, instances_p, true, instances_p);
    _innerGraphicalOperation = new InnerHighlightOperation(diagram_p, instances_p, color_p, borderSize_p, coverEdges_p, coverNodes_p, coverPorts_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation#update(java.lang.Object, boolean)
   */
  @Override
  protected void update(Object decorator_p, boolean isMerged) {
    _innerGraphicalOperation.update(decorator_p, isMerged);
  }


  /**
   * Inner class, simulates multiple inheritance of SiriusHighlightOperation --> (AbstractHighlightOperation, SiriusFilteredGraphicalUpdateOperation)
   * @author Skander Turki
   *
   */
  protected class InnerHighlightOperation extends AbstractHighlightOperation{

    /** Casted innerGraphicalOperation */
    private InnerHighlightOperation _innerHighlightOperation;

    /**
     * Constructor
     */
    public InnerHighlightOperation(Object diagram_p, IPatternInstance instance_p, RGB color_p, int borderSize_p, boolean coverEdges_p, boolean coverNodes_p,
        boolean coverPorts_p) {
      super(diagram_p, instance_p, color_p, borderSize_p, coverEdges_p, coverNodes_p, coverPorts_p);
    }

    /**
     * Constructor
     */
    public InnerHighlightOperation(Object diagram_p, Collection<? extends IPatternInstance> instances_p, RGB color_p, int borderSize_p, boolean coverEdges_p,
        boolean coverNodes_p, boolean coverPorts_p) {
      super(diagram_p, instances_p, color_p, borderSize_p, coverEdges_p, coverNodes_p, coverPorts_p);
    }

    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalUpdateOperation#update(java.lang.Object, boolean)
     */
    @SuppressWarnings("synthetic-access")
    @Override
    public void update(Object decorator_p, boolean isMerged) {
      if(decorator_p instanceof DSemanticDecorator){
        _innerHighlightOperation = (InnerHighlightOperation) _innerGraphicalOperation;
        if ((decorator_p instanceof DEdge) && _innerHighlightOperation.is_coverEdges()) {
          updateEdge((DEdge) decorator_p);
        } else if (decorator_p instanceof DNode) {
          DNode node = (DNode) decorator_p;
          if (SiriusUtil.isBorderedNode(node)) {
            if (_innerHighlightOperation.is_coverPorts()) {
              updateNode(node);
            }
          } else if (_innerHighlightOperation.is_coverNodes()) {
            updateNode(node);
          }
        } else if ((decorator_p instanceof DNodeContainer) && _innerHighlightOperation.is_coverNodes()) {
          updateContainer((DNodeContainer) decorator_p);
        } else if ((decorator_p instanceof DNodeList) && _innerHighlightOperation.is_coverNodes()) {
          updateList((DNodeList) decorator_p);
        }  
      }

    }

    /**
     * Update the given container
     * @param container_p a non-null container
     */
    private void updateContainer(DNodeContainer container_p) {
      if (container_p.getStyle() instanceof BorderedStyle) {
        BorderedStyle style = (BorderedStyle) container_p.getStyle();
        RGBValues highlightColor = highlightColor();
        style.setBorderColor(highlightColor);

        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderColor().getName());
        style.setBorderSize(_innerHighlightOperation.get_borderSize());
        style.setBorderSizeComputationExpression(_innerHighlightOperation.get_borderSize().toString());
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSize().getName());
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSizeComputationExpression().getName());
        style.refresh();
      }
    }

    /**
     * Update the given edge
     * @param edge_p a non-null edge
     */
    private void updateEdge(DEdge edge_p) {
      if (edge_p.getStyle() instanceof EdgeStyle) {
        EdgeStyle style = (EdgeStyle) edge_p.getStyle();
        if (style.getStrokeColor() != null) {
          RGBValues highlightColor = highlightColor();
          style.setStrokeColor(highlightColor);
          style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_StrokeColor().getName());
        }
        style.setSize(Integer.valueOf(3));
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_Size().getName());
        CenterLabelStyle centerlabelStyle = style.getCenterLabelStyle();
        if (centerlabelStyle != null){
          updateBasicLabelStyle(centerlabelStyle);
        } else {
          CenterLabelStyle newLabelStyle = DiagramFactory.eINSTANCE.createCenterLabelStyle();
          highlightBasicLabelStyle(newLabelStyle);
          style.setCenterLabelStyle(newLabelStyle);
        }
        BeginLabelStyle beginlabelStyle = style.getBeginLabelStyle();
        if(beginlabelStyle != null){
          updateBasicLabelStyle(beginlabelStyle);
        }else{
          BeginLabelStyle newLabelStyle = DiagramFactory.eINSTANCE.createBeginLabelStyle();
          highlightBasicLabelStyle(newLabelStyle);
          style.setBeginLabelStyle(newLabelStyle);
        }   
        EndLabelStyle endlabelStyle = style.getEndLabelStyle();
        if(endlabelStyle != null){
          updateBasicLabelStyle(endlabelStyle);
        } else {
          EndLabelStyle newLabelStyle = DiagramFactory.eINSTANCE.createEndLabelStyle();
          highlightBasicLabelStyle(newLabelStyle);
          style.setEndLabelStyle(newLabelStyle);
        }
        style.getCustomFeatures().add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName());
        style.refresh();
      }
    }

    /**
     * Update the given label style with highlighting color and adds appropriate custom features
     * @param labelStyle_p a potentially null label style
     */
    private void updateBasicLabelStyle(BasicLabelStyle labelStyle_p) {
      RGBValues highlightColor = highlightColor();
      labelStyle_p.setLabelColor(highlightColor);
      labelStyle_p.getCustomFeatures().add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName());
    }

    /**
     * Update the given node
     * @param node_p a non-null node
     */
    private void updateNode(DNode node_p) {
      if (node_p.getOwnedStyle() instanceof Square) {
        Square style = (Square) node_p.getStyle();
        RGBValues highlightColor = highlightColor();
        style.setLabelColor(highlightColor);
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderColor().getName());
        // not stable with a diagram refresh
        style.setBorderSize(_innerHighlightOperation.get_borderSize());
        style.setBorderSizeComputationExpression(_innerHighlightOperation.get_borderSize().toString());
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSize().getName());
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSizeComputationExpression().getName());
        style.refresh();
      }
    }

    /**
     * Turn the given color to the highlight color
     * @param color_p a potentially null color in RGB format
     */
    private RGBValues highlightColor() {
      RGBValues color_p= RGBValues.create(
          _innerHighlightOperation.get_color().red,
          _innerHighlightOperation.get_color().green,
          _innerHighlightOperation.get_color().blue);
      return color_p;
    }

    /**
     * Highlight the label color of the given label style with appropriate custom features
     * @param newLabelStyle a non-null BasicLabelStyle
     */
    private void highlightBasicLabelStyle(BasicLabelStyle newLabelStyle) {
      RGBValues highlightColor = highlightColor();
      newLabelStyle.setLabelColor(highlightColor);
      newLabelStyle.getCustomFeatures().add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName());
    }

    /**
     * Update the given list container
     * @param list_p a non-null list container
     */
    private void updateList(DNodeList list_p) {
      if (list_p.getStyle() instanceof BorderedStyle) {
        BorderedStyle style = (BorderedStyle) list_p.getStyle();
        RGBValues highlightColor = highlightColor();
        style.setBorderColor(highlightColor);

        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderColor().getName());
        // not stable with a diagram refresh
        style.setBorderSize(_innerHighlightOperation.get_borderSize());
        style.setBorderSizeComputationExpression(_innerHighlightOperation.get_borderSize().toString());
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSize().getName());
        style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderSizeComputationExpression().getName());
        //
        style.refresh();
      }
    }
  }
}
