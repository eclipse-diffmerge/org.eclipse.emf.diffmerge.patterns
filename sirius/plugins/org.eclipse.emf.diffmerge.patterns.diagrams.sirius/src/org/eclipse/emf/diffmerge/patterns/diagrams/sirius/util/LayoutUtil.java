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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedImage.Point;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.sirius.business.api.metamodel.helper.FontFormatHelper;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.BeginLabelStyle;
import org.eclipse.sirius.diagram.BorderedStyle;
import org.eclipse.sirius.diagram.BundledImage;
import org.eclipse.sirius.diagram.CenterLabelStyle;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DNodeList;
import org.eclipse.sirius.diagram.DiagramFactory;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.diagram.Dot;
import org.eclipse.sirius.diagram.EdgeArrows;
import org.eclipse.sirius.diagram.EdgeRouting;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.Ellipse;
import org.eclipse.sirius.diagram.EndLabelStyle;
import org.eclipse.sirius.diagram.FlatContainerStyle;
import org.eclipse.sirius.diagram.LineStyle;
import org.eclipse.sirius.diagram.Lozenge;
import org.eclipse.sirius.diagram.Note;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.diagram.tools.api.command.view.RefreshSiriusElement;
import org.eclipse.sirius.viewpoint.BasicLabelStyle;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.DStylizable;
import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.viewpoint.Style;
import org.eclipse.sirius.viewpoint.ViewpointPackage;


/**
 * Utility class providing simple services related to layouts, both dependent on and independent from
 * graphical model frameworks.
 * @author Olivier Constant
 * @author Skander Turki
 */
public final class LayoutUtil {

  /** Style constant for color custom feature */
  public static final String COLOR_CUSTOM_FEATURE = "color"; //$NON-NLS-1$
  /** Style constant for default font style name */
  private static final String DEFAULT_FONT_STYLE_NAME = "default"; //$NON-NLS-1$

  /**
   * Constructor
   */
  private LayoutUtil() {
    // Forbids instantiation
  }

  /**
   * Apply the given layout to the given edge
   * @param edge_p a non-null edge
   * @param edgeLayout_p a non-null edge layout
   */
  public static void applyEdgeLayout(Edge edge_p, EdgeLayout edgeLayout_p) {
    if (!edgeLayout_p.getBendpoints().isEmpty()) {
      RelativeBendpoints gmfBendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
      edgeLayoutToBendpoints(edgeLayout_p, gmfBendpoints);
      edge_p.setBendpoints(gmfBendpoints);
    }
  }

  /**
   * Apply the given layout to the given edge
   * @param edge_p a non-null edge
   * @param edgeLayout_p a non-null edge layout
   */
  @SuppressWarnings({ "boxing" })
  public static void applyEdgeStyle(Edge edge_p, EdgeLayout edgeLayout_p) {
    ConnectorStyle connectorstyle = null;
    if (edge_p.getElement() != null) {
      EObject siriusElement = edge_p.getElement();
      if (siriusElement instanceof DStylizable) {
        Style style = ((DStylizable) siriusElement).getStyle();
        if (style != null) {
          RefreshSiriusElement.refresh(style);
        }
        if (style instanceof EdgeStyle) {
          EdgeStyle edgestyle = (EdgeStyle) style;
          if (edgeLayout_p.getLinecolor() != -1) {
            edgestyle.setStrokeColor(ColorUtil.convertIntColorToRGBValues(edgeLayout_p.getLinecolor()));
            style.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_StrokeColor().getName());
          }
        }
      }
    }
    // Apply the edge font style
    if (edgeLayout_p.getFontStyle() != null) {
      for (Object style : edge_p.getStyles()) {
        if (style instanceof FontStyle) {
          FontStyle fontstyle = (FontStyle) style;
          applyFontStyleToEdge(fontstyle, edgeLayout_p, edge_p.getElement());
        } else if (style instanceof ConnectorStyle) {
          connectorstyle = (ConnectorStyle) style;
          if (edgeLayout_p.getLinecolor() != -1) {
            connectorstyle.setLineColor(edgeLayout_p.getLinecolor());
          }
          if (edgeLayout_p.getLinewidth() != -1) {
            connectorstyle.setLineWidth(edgeLayout_p.getLinewidth());
          }
        }
      }
    }
    if (edgeLayout_p.getOwnedStyle() != null) {
      EObject element = edge_p.getElement();
      org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle edgestyle = edgeLayout_p.getOwnedStyle();
      if (element instanceof DEdge) {
        DEdge dedge = (DEdge) element;
        EdgeStyle ownedstyle = dedge.getOwnedStyle();
        // set size
        if (edgeLayout_p.getLinewidth() != -1) {
          ownedstyle.setSize(edgeLayout_p.getLinewidth());
          ownedstyle.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_Size().getName());
        }
        // set line style
        if (edgestyle.getLinestyle() != null) {
          setEdgeLineStyle(edgestyle.getLinestyle(), ownedstyle);
          ownedstyle.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_LineStyle().getName());
        }
        // set routing style
        if (edgestyle.getRoutingstyle() != null) {
          setEdgeRoutingStyle(edgestyle.getRoutingstyle(), ownedstyle);
          ownedstyle.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_RoutingStyle().getName());
          if (connectorstyle != null) {
            if ("straight".equals(edgestyle.getRoutingstyle())) { //$NON-NLS-1$
              connectorstyle.setRouting(Routing.MANUAL_LITERAL);
            } else if ("manhattan".equals(edgestyle.getRoutingstyle())) { //$NON-NLS-1$
              connectorstyle.setRouting(Routing.RECTILINEAR_LITERAL);
            } else if ("tree".equals(edgestyle.getRoutingstyle())) { //$NON-NLS-1$
              connectorstyle.setRouting(Routing.TREE_LITERAL);
            }
          }
        }
        // set source arrow
        if (edgestyle.getSourcearrow() != null) {
          setEdgeSourceArrowStyle(edgestyle.getSourcearrow(), ownedstyle);
          ownedstyle.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_SourceArrow().getName());
        }
        // set target arrow
        if (edgestyle.getTargetarrow() != null) {
          setEdgeTargetArrowStyle(edgestyle.getTargetarrow(), ownedstyle);
          ownedstyle.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_TargetArrow().getName());
        }
      }
    }
  }

  /**
   * edgelayout_p from the patterns model is applied to fontstyle_p, appropriate customfeatures strings are added to element_p style
   * @param fontstyle_p a non-null GMF Font Style to which the style is applied
   * @param edgelayout_p a non-null patterns font style that is applied to the GMF Font Style
   * @param element_p the non-null Sirius element to which the style is applied
   */
  public static void applyFontStyleToEdge(FontStyle fontstyle_p, EdgeLayout edgelayout_p, EObject element_p) {
    CenterLabelStyle centerlabelstyle = null;
    EndLabelStyle endlabelstyle = null;
    BeginLabelStyle beginlabelstyle = null;
    List<String> customfeatures = new ArrayList<String>();
    if (element_p instanceof DEdge) {
      DEdge edge = (DEdge) element_p;
      if (edge.getOwnedStyle() != null) {
        EdgeStyle edgestyle = edge.getOwnedStyle();
        // BUILD the appropriate center label style after this point
        if (edgelayout_p.getCenterFontStyle() != null) {
          CenterLabelStyle newcenterstyle = DiagramFactory.eINSTANCE.createCenterLabelStyle();
          edgestyle.setCenterLabelStyle(newcenterstyle);
          centerlabelstyle = edgestyle.getCenterLabelStyle();
          applyLabelStyleToEdge(edgelayout_p.getCenterFontStyle(), centerlabelstyle);
        }
        // BUILD the appropriate end label style after this point
        if (edgelayout_p.getEndFontStyle() != null) {
          EndLabelStyle newendstyle = DiagramFactory.eINSTANCE.createEndLabelStyle();
          edgestyle.setEndLabelStyle(newendstyle);
          endlabelstyle = edgestyle.getEndLabelStyle();
          applyLabelStyleToEdge(edgelayout_p.getEndFontStyle(), endlabelstyle);
        }
        // BUILD the appropriate begin label style after this point
        if (edgelayout_p.getBeginFontStyle() != null) {
          BeginLabelStyle newbeginstyle = DiagramFactory.eINSTANCE.createBeginLabelStyle();
          edgestyle.setBeginLabelStyle(newbeginstyle);
          beginlabelstyle = edgestyle.getBeginLabelStyle();
          applyLabelStyleToEdge(edgelayout_p.getBeginFontStyle(), beginlabelstyle);
        }
      }
    }
    TemplateFontStyle edgefontstyle = edgelayout_p.getFontStyle();
    if (!"default".equals(edgefontstyle.getName())) { //$NON-NLS-1$
      fontstyle_p.setFontName(edgefontstyle.getName());
    }
    if (edgefontstyle.isStrikethrough()) {
      fontstyle_p.setStrikeThrough(edgefontstyle.isStrikethrough());
    }
    if (edgefontstyle.isUnderline()) {
      fontstyle_p.setUnderline(edgefontstyle.isUnderline());
    }
    if (edgefontstyle.isBold()) {
      fontstyle_p.setBold(edgefontstyle.isBold());
      customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
    }
    if (edgefontstyle.isItalic()) {
      fontstyle_p.setItalic(edgefontstyle.isItalic());
      customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
    }
    if (edgefontstyle.getColor() != -1) {
      fontstyle_p.setFontColor(edgefontstyle.getColor());
      customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName());
    }
    if (edgefontstyle.getHeight() != -1) {
      fontstyle_p.setFontHeight(edgefontstyle.getHeight());
      customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelSize().getName());
    }

    if (element_p instanceof EdgeStyle) {
      EdgeStyle edgestyle = (EdgeStyle) element_p;
      edgestyle.getCustomFeatures().add(DiagramPackage.eINSTANCE.getEdgeStyle_StrokeColor().getName());
      edgestyle.setStrokeColor(null);
      edgestyle.getCenterLabelStyle().setLabelColor(ColorUtil.convertIntColorToRGBValues(edgefontstyle.getColor()));
      edgestyle.getCenterLabelStyle().setLabelSize(edgefontstyle.getHeight());
      if (edgefontstyle.isBold()) {
        FontFormatHelper.setFontFormat(edgestyle.getCenterLabelStyle().getLabelFormat(), FontFormat.BOLD_LITERAL);
        customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
      } else if (edgefontstyle.isItalic()) {
          FontFormatHelper.setFontFormat(edgestyle.getCenterLabelStyle().getLabelFormat(), FontFormat.ITALIC_LITERAL);
        customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
      } else if (edgefontstyle.isStrikethrough()) {
          FontFormatHelper.setFontFormat(edgestyle.getCenterLabelStyle().getLabelFormat(), FontFormat.STRIKE_THROUGH_LITERAL);
        customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
      } else if (edgefontstyle.isUnderline()) {
          FontFormatHelper.setFontFormat(edgestyle.getCenterLabelStyle().getLabelFormat(), FontFormat.UNDERLINE_LITERAL);
        customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
      }

    }

  }

  /**
   * Apply the given style from a pattern to the given style of an edge
   * @param fontStyle_p a non-null TemplateFontStyle
   * @param basicLabelStyle_p a non-null BasicLabelStyle
   */
  public static void applyLabelStyleToEdge(TemplateFontStyle fontStyle_p,
      BasicLabelStyle basicLabelStyle_p) {
    List<String> customFeatures = basicLabelStyle_p.getCustomFeatures();
    if (fontStyle_p.getColor() != -1) {
      basicLabelStyle_p.setLabelColor(ColorUtil.convertIntColorToRGBValues(fontStyle_p.getColor()));
      customFeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName());
    }
    if (fontStyle_p.getHeight() != -1) {
      basicLabelStyle_p.setLabelSize(fontStyle_p.getHeight());
      customFeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelSize().getName());
    }
    if (fontStyle_p.isItalic()) {
    	FontFormatHelper.setFontFormat(basicLabelStyle_p.getLabelFormat(), FontFormat.ITALIC_LITERAL);
      customFeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
    } else if (fontStyle_p.isBold()) {
    	FontFormatHelper.setFontFormat(basicLabelStyle_p.getLabelFormat(), FontFormat.BOLD_LITERAL);
      customFeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
    } else if (fontStyle_p.isStrikethrough()) {
    	FontFormatHelper.setFontFormat(basicLabelStyle_p.getLabelFormat(), FontFormat.STRIKE_THROUGH_LITERAL);
      customFeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
    }  else if (fontStyle_p.isUnderline()) {
    	FontFormatHelper.setFontFormat(basicLabelStyle_p.getLabelFormat(), FontFormat.UNDERLINE_LITERAL);
        customFeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
      }
  }

  /**
   * Apply a string representing the line style to an Edge Style
   * @param edgeLineStyle_p a string representing the line style to apply
   * @param edgeStyle_p non-null Edge Style to which the line style is applied
   */
  public static void setEdgeLineStyle(String edgeLineStyle_p, EdgeStyle edgeStyle_p) {
    if (LineStyle.DASH_LITERAL.getLiteral().equals(edgeLineStyle_p)) {
      edgeStyle_p.setLineStyle(LineStyle.DASH_LITERAL);
    } else if (LineStyle.DASH_DOT_LITERAL.getLiteral().equals(edgeLineStyle_p)) {
      edgeStyle_p.setLineStyle(LineStyle.DASH_DOT_LITERAL);
    } else if (LineStyle.DOT_LITERAL.getLiteral().equals(edgeLineStyle_p)) {
      edgeStyle_p.setLineStyle(LineStyle.DOT_LITERAL);
    } else if (LineStyle.SOLID_LITERAL.getLiteral().equals(edgeLineStyle_p)) {
      edgeStyle_p.setLineStyle(LineStyle.SOLID_LITERAL);
    }
  }

  /**
   * Applies a routing style to an edge style
   * @param edgeRouting_p a String representing the routing style literal
   * @param edgeStyle_p a non-null EdgeStyle
   */
  public static void setEdgeRoutingStyle(String edgeRouting_p, EdgeStyle edgeStyle_p) {
    if (EdgeRouting.MANHATTAN_LITERAL.getLiteral().equals(edgeRouting_p)) {
      edgeStyle_p.setRoutingStyle(EdgeRouting.MANHATTAN_LITERAL);
    } else if (EdgeRouting.STRAIGHT_LITERAL.getLiteral().equals(edgeRouting_p)) {
      edgeStyle_p.setRoutingStyle(EdgeRouting.STRAIGHT_LITERAL);
    } else if (EdgeRouting.TREE_LITERAL.getLiteral().equals(edgeRouting_p)) {
      edgeStyle_p.setRoutingStyle(EdgeRouting.TREE_LITERAL);
    }
  }

  /**
   * Applies an arrow type to the target arrow of an edge style
   * @param arrowType a String representing the arrow type literal
   * @param edgeStyle_p a non-null EdgeStyle
   */
  public static void setEdgeTargetArrowStyle(String arrowType, EdgeStyle edgeStyle_p) {
    if (EdgeArrows.FILL_DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.FILL_DIAMOND_LITERAL);
    } else if (EdgeArrows.DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.DIAMOND_LITERAL);
    } else if (EdgeArrows.INPUT_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.INPUT_ARROW_LITERAL);
    } else if (EdgeArrows.INPUT_ARROW_WITH_DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.INPUT_ARROW_WITH_DIAMOND_LITERAL);
    } else if (EdgeArrows.INPUT_ARROW_WITH_FILL_DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.INPUT_ARROW_WITH_FILL_DIAMOND_LITERAL);
    } else if (EdgeArrows.INPUT_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.INPUT_CLOSED_ARROW_LITERAL);
    } else if (EdgeArrows.INPUT_FILL_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.INPUT_FILL_CLOSED_ARROW_LITERAL);
    } else if (EdgeArrows.NO_DECORATION_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.NO_DECORATION_LITERAL);
    } else if (EdgeArrows.OUTPUT_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.OUTPUT_ARROW_LITERAL);
    } else if (EdgeArrows.OUTPUT_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.OUTPUT_CLOSED_ARROW_LITERAL);
    } else if (EdgeArrows.OUTPUT_FILL_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setTargetArrow(EdgeArrows.OUTPUT_FILL_CLOSED_ARROW_LITERAL);
    }
  }

  /**
   * Applies an arrow type to the source arrow of an edge style
   * @param arrowType  a String representing the arrow type literal
   * @param edgeStyle_p a non-null EdgeStyle
   */
  public static void setEdgeSourceArrowStyle(String arrowType, EdgeStyle edgeStyle_p) {
    if (EdgeArrows.FILL_DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.FILL_DIAMOND_LITERAL);
    } else if (EdgeArrows.DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.DIAMOND_LITERAL);
    } else if (EdgeArrows.INPUT_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.INPUT_ARROW_LITERAL);
    } else if (EdgeArrows.INPUT_ARROW_WITH_DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.INPUT_ARROW_WITH_DIAMOND_LITERAL);
    } else if (EdgeArrows.INPUT_ARROW_WITH_FILL_DIAMOND_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.INPUT_ARROW_WITH_FILL_DIAMOND_LITERAL);
    } else if (EdgeArrows.INPUT_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.INPUT_CLOSED_ARROW_LITERAL);
    } else if (EdgeArrows.INPUT_FILL_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.INPUT_FILL_CLOSED_ARROW_LITERAL);
    } else if (EdgeArrows.NO_DECORATION_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.NO_DECORATION_LITERAL);
    } else if (EdgeArrows.OUTPUT_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.OUTPUT_ARROW_LITERAL);
    } else if (EdgeArrows.OUTPUT_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.OUTPUT_CLOSED_ARROW_LITERAL);
    } else if (EdgeArrows.OUTPUT_FILL_CLOSED_ARROW_LITERAL.getLiteral().equals(arrowType)) {
      edgeStyle_p.setSourceArrow(EdgeArrows.OUTPUT_FILL_CLOSED_ARROW_LITERAL);
    }
  }

  /**
   * Apply the given vector to the given location
   * @param location_p a non-null location
   * @param vx_p the X value of the vector
   * @param vy_p the Y value of the vector
   */
  public static void applyVector(Location location_p, int vx_p, int vy_p) {
    location_p.setX(location_p.getX() + vx_p);
    location_p.setY(location_p.getY() + vy_p);
  }

  /**
   * Copy the characteristics of the given edge layout to the given GMF bendpoints
   * @param edgeLayout_p a non-null edge layout
   * @param bendpoints_p a non-null bendpoints object
   */
  public static void edgeLayoutToBendpoints(EdgeLayout edgeLayout_p, Bendpoints bendpoints_p) {
    if (!edgeLayout_p.getBendpoints().isEmpty() && (bendpoints_p instanceof RelativeBendpoints)) {
      RelativeBendpoints target = (RelativeBendpoints) bendpoints_p;
      List<RelativeBendpoint> newBendpoints = new ArrayList<RelativeBendpoint>(edgeLayout_p.getBendpoints().size());
      for (EdgeBendpoint neutralBendpoint : edgeLayout_p.getBendpoints()) {
        RelativeBendpoint targetBendpoint = toGMFBendpoint(neutralBendpoint);
        newBendpoints.add(targetBendpoint);
      }
      target.setPoints(newBendpoints);
    }
  }

  /**
   * Copy the characteristics of the given node layout to the given GMF bounds
   * @param nodeLayout_p a non-null node layout
   * @param bounds_p a non-null bounds object
   */
  public static void nodeLayoutToBounds(NodeLayout nodeLayout_p, Bounds bounds_p) {
    bounds_p.setX(nodeLayout_p.getX());
    bounds_p.setY(nodeLayout_p.getY());
    bounds_p.setHeight(nodeLayout_p.getHeight());
    bounds_p.setWidth(nodeLayout_p.getWidth());
  }

  /**
   * Convert the given GMF bendpoint to a framework-neutral bendpoint
   * @param gmfBendpoint_p a non-null GMF bendpoint
   * @return a non-null bendpoint
   */
  public static EdgeBendpoint toEdgeBendpoint(RelativeBendpoint gmfBendpoint_p) {
    EdgeBendpoint result = TemplatepatternsFactory.eINSTANCE.createEdgeBendpoint();
    result.setSourceX(gmfBendpoint_p.getSourceX());
    result.setSourceY(gmfBendpoint_p.getSourceY());
    result.setTargetX(gmfBendpoint_p.getTargetX());
    result.setTargetY(gmfBendpoint_p.getTargetY());
    return result;
  }

  /**
   * Convert the given GMF edge layout constraint to framework-neutral layout data
   * @param bendpoints_p a non-null GMF bendpoints object
   * @param selectedLineColor_p the line color
   * @param selectedLineWidth_p the line width
   * @param selectedLineStyle_p the line style
   * @param selectedEdgeRouting_p the edge routing
   * @param selectedTargetArrow_p the target arrow style
   * @param selectedSourceArrow_p the source arrow style
   * @return a non-null edge layout
   */
  public static EdgeLayout toEdgeLayout(Bendpoints bendpoints_p, int selectedLineColor_p,
      int selectedLineWidth_p, LineStyle selectedLineStyle_p,
      EdgeRouting selectedEdgeRouting_p, EdgeArrows selectedTargetArrow_p,
      EdgeArrows selectedSourceArrow_p) {
    EdgeLayout result = TemplatepatternsFactory.eINSTANCE.createEdgeLayout();
    if (bendpoints_p instanceof RelativeBendpoints) {
      @SuppressWarnings("unchecked")
      List<RelativeBendpoint> gmfBendpoints = ((RelativeBendpoints) bendpoints_p).getPoints();
      for (RelativeBendpoint gmfBendpoint : gmfBendpoints) {
        EdgeBendpoint resultPoint = toEdgeBendpoint(gmfBendpoint);
        result.getBendpoints().add(resultPoint);
      }
    }
    result.setLinecolor(selectedLineColor_p);
    result.setLinewidth(selectedLineWidth_p);
    // create the corresponding EdgeStyle
    org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle edgestyle =
        TemplatepatternsFactory.eINSTANCE.createEdgeStyle();
    if (selectedLineStyle_p != null)
      edgestyle.setLinestyle(selectedLineStyle_p.toString());
    if (selectedEdgeRouting_p != null)
      edgestyle.setRoutingstyle(selectedEdgeRouting_p.toString());
    if (selectedSourceArrow_p != null)
      edgestyle.setSourcearrow(selectedSourceArrow_p.toString());
    if (selectedTargetArrow_p != null)
      edgestyle.setTargetarrow(selectedTargetArrow_p.toString());
    result.setOwnedStyle(edgestyle);
    return result;
  }

  /**
   * Returns a TemplateFontStyle object out of the input parameters
   * @param selectedFontColor_p the font color
   * @param selectedFontName_p the font name
   * @param selectedFontHeight_p the font height
   * @param isBold_p whether the font is bold
   * @param isItalic_p whether the font is italic
   * @param isUnderline_p whether the font is underlined
   * @param isStrikeThrough_p whether the font is "strike through"
   * @return a non-null TemplateFontStyle object
   */
  public static TemplateFontStyle toTemplateFontStyle(int selectedFontColor_p,
      String selectedFontName_p, int selectedFontHeight_p, boolean isBold_p,
      boolean isItalic_p, boolean isUnderline_p, boolean isStrikeThrough_p) {
    TemplateFontStyle result = TemplatepatternsFactory.eINSTANCE.createTemplateFontStyle();
    result.setColor(selectedFontColor_p);
    result.setName(selectedFontName_p);
    result.setHeight(selectedFontHeight_p);
    result.setBold(isBold_p);
    result.setItalic(isItalic_p);
    result.setUnderline(isUnderline_p);
    result.setStrikethrough(isStrikeThrough_p);
    return result;
  }

  /**
   * Convert the given bendpoint to a GMF bendpoint
   * @param bendpoint_p a non-null bendpoint
   * @return a non-null GMF bendpoint
   */
  public static RelativeBendpoint toGMFBendpoint(EdgeBendpoint bendpoint_p) {
    RelativeBendpoint result = new RelativeBendpoint(
        bendpoint_p.getSourceX(), bendpoint_p.getSourceY(),
        bendpoint_p.getTargetX(), bendpoint_p.getTargetY());
    return result;
  }

  /**
   * Convert the given GMF layout constraint to framework-neutral layout data
   * @param bounds_p a non-null GMF node layout constraint
   * @param nodestyle_p a non-null GMF fill style of node
   * @param templatefontstyle_p a font style
   * @return a non-null node layout
   */
  public static NodeLayout toNodeLayout(Bounds bounds_p, NodeStyle nodestyle_p,
      TemplateFontStyle templatefontstyle_p) {
    NodeLayout result = TemplatepatternsFactory.eINSTANCE.createNodeLayout();
    result.setX(bounds_p.getX());
    result.setY(bounds_p.getY());
    result.setHeight(bounds_p.getHeight());
    result.setWidth(bounds_p.getWidth());
    result.setFontStyle(templatefontstyle_p);
    result.setOwnedStyle(nodestyle_p);
    return result;
  }

  /**
   * Return a NodeStyle object corresponding to the given parameters
   * @param borderColor_p the border color
   * @param borderSize_p the border size
   * @param shapeColor_p the shape color
   * @param transparency_p the transparency
   * @param foregroundColor_p the foreground color
   * @param backgroundColor_p the background color
   * @return a non-null Node Style object
   */
  public static NodeStyle toTemplateNodeStyle(int borderColor_p, int borderSize_p,
      int shapeColor_p, int transparency_p, int foregroundColor_p, int backgroundColor_p) {
    NodeStyle nodestyle = TemplatepatternsFactory.eINSTANCE.createNodeStyle();
    nodestyle.setBackgroundcolor(backgroundColor_p);
    nodestyle.setBordercolor(borderColor_p);
    nodestyle.setBordersize(borderSize_p);
    nodestyle.setForegroundcolor(foregroundColor_p);
    nodestyle.setTransparency(transparency_p);
    nodestyle.setShapecolor(shapeColor_p);
    return nodestyle;
  }

  /**
   * Return a list of the custom features of the node
   * @param node a non-null Node
   * @return a non-null list of strings containing all custom (not default) features of the node
   */
  public static List<String> getNodeCustomSpecification(Node node) {
    if (node.getElement() instanceof DNode) {
      DNode dnode = (DNode) node.getElement();
      return (new ArrayList<String>(dnode.getOwnedStyle().getCustomFeatures()));
    } 
    else if (node.getElement() instanceof DNodeContainer) {
      DNodeContainer dnodecontainer = (DNodeContainer) node.getElement();
      return (new ArrayList<String>(dnodecontainer.getOwnedStyle().getCustomFeatures()));
    }
    else if (node.getElement() instanceof DNodeList) {
      DNodeList dnodelist = (DNodeList) node.getElement();
      return (new ArrayList<String>(dnodelist.getOwnedStyle().getCustomFeatures()));
    }
    return (new ArrayList<String>());
  }

  /**
   * Return a list of the custom features of an Edge
   * @param edge a non-null Edge
   * @return a non-null list of strings with all custom (not default) features of the edge
   */
  public static List<String> getEdgeCustomSpecification(Edge edge) {
    if (edge.getElement() instanceof DEdge) {
      DEdge dedge = (DEdge) edge.getElement();
      return (new ArrayList<String>(dedge.getOwnedStyle().getCustomFeatures()));
    }
    return (new ArrayList<String>());
  }

  /**
   * Apply node style information the node (bordercolor, bordersize, foreground and backgroud colors)
   * @param sourcenodestyle_p non-null Node Style to apply to the Node
   * @param dnode_p non-null DNode/DNodeContainer to which the style is applied
   */
  @SuppressWarnings({ "boxing" })
  public static void applyNodePatternStyleToDNode(NodeStyle sourcenodestyle_p, Node dnode_p) {
    List<String> customfeatures = new ArrayList<String>();

    if (!dnode_p.getStyles().isEmpty()) {
      Object targetstyle = dnode_p.getStyles().get(0);
      if (targetstyle instanceof ShapeStyle) {
        ShapeStyle targetshapestyle = (ShapeStyle) targetstyle;
        // set shape style
        if (sourcenodestyle_p.getBordercolor() != -1) {
          targetshapestyle.setLineColor(sourcenodestyle_p.getBordercolor());
          customfeatures.add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderColor().getName());
        }
        if (sourcenodestyle_p.getBordersize() != -1) {
          targetshapestyle.setLineWidth(sourcenodestyle_p.getBordersize());
        }
        if (sourcenodestyle_p.getShapecolor() != -1) {
          targetshapestyle.setFillColor(sourcenodestyle_p.getShapecolor());
          customfeatures.add(COLOR_CUSTOM_FEATURE );
          // customfeatures.add(ViewpointPackage.eINSTANCE.getFlatContainerStyle_ForegroundColor().getName());
          // customfeatures.add(ViewpointPackage.eINSTANCE.getFlatContainerStyle_BackgroundColor().getName());
        }
        if (sourcenodestyle_p.getTransparency() != -1) {
          // targetshapestyle.setTransparency(0);
        }
      }
      // //
      if (dnode_p.getElement() instanceof DStylizable) {
        DStylizable dstylizable = (DStylizable) (dnode_p.getElement());
        Style targetelementstyle = dstylizable.getStyle();
        customfeatures = targetelementstyle.getCustomFeatures();
        if (targetelementstyle instanceof BorderedStyle) {
          BorderedStyle targetborderedstyle = (BorderedStyle) targetelementstyle;
          if (sourcenodestyle_p.getBordercolor() != -1) {
            targetborderedstyle.setBorderColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getBordercolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getBorderedStyle_BorderColor().getName());
          }
          if (sourcenodestyle_p.getBordersize() != -1) {
            targetborderedstyle.setBorderSize(sourcenodestyle_p.getBordersize());
            customfeatures.add("borderSizeComputationExpression"); //$NON-NLS-1$
          }

        }
        if (targetelementstyle instanceof FillStyle) {
          FillStyle targetfillstyle = (FillStyle) targetelementstyle;
          if (sourcenodestyle_p.getShapecolor() != -1) {
            targetfillstyle.setFillColor(sourcenodestyle_p.getShapecolor());
            customfeatures.add(DiagramPackage.eINSTANCE.getFlatContainerStyle_ForegroundColor().getName());
            customfeatures.add(DiagramPackage.eINSTANCE.getFlatContainerStyle_BackgroundColor().getName());
          }
          if (sourcenodestyle_p.getTransparency() != -1) {
            targetfillstyle.setTransparency(sourcenodestyle_p.getTransparency());
          }
        }
        if (targetelementstyle instanceof Square) {
          Square targetsquare = (Square) targetelementstyle;
          if (sourcenodestyle_p.getShapecolor() != -1) {
            targetsquare.setColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getShapecolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getSquare_Color().getName());
          }
        }
        if (targetelementstyle instanceof Ellipse) {
          Ellipse targetellipse = (Ellipse) targetelementstyle;
          if (sourcenodestyle_p.getShapecolor() != -1) {
            targetellipse.setColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getShapecolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getEllipse_Color().getName());
          }
        }
        if (targetelementstyle instanceof Note) {
          Note targetnote = (Note) targetelementstyle;
          if (sourcenodestyle_p.getShapecolor() != -1) {
            targetnote.setColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getShapecolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getNote_Color().getName());
          }
        }
        if (targetelementstyle instanceof Lozenge) {
          Lozenge targetlozange = (Lozenge) targetelementstyle;
          if (sourcenodestyle_p.getShapecolor() != -1) {
            targetlozange.setColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getShapecolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getLozenge_Color().getName());
          }
        }
        if (targetelementstyle instanceof BundledImage) {
          BundledImage targetimage = (BundledImage) targetelementstyle;
          if (sourcenodestyle_p.getShapecolor() != -1) {
            targetimage.setColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getShapecolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getBundledImage_Color().getName());
          }
        }
        if (targetelementstyle instanceof Dot) {
          Dot targetdot = (Dot) targetelementstyle;
          if (sourcenodestyle_p.getShapecolor() != -1) {
            targetdot.setBackgroundColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getShapecolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getDot_BackgroundColor().getName());
          }
        }
        if (targetelementstyle instanceof FlatContainerStyle) {
          FlatContainerStyle targetflatcontainerstyle = (FlatContainerStyle) targetelementstyle;
          if (sourcenodestyle_p.getBackgroundcolor() != -1) {
            targetflatcontainerstyle.setBackgroundColor(ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getBackgroundcolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getFlatContainerStyle_BackgroundColor().getName());
          } else {
            targetflatcontainerstyle.setBackgroundColor(null);
          }
          if (sourcenodestyle_p.getForegroundcolor() != -1) {
            targetflatcontainerstyle.setForegroundColor(
                ColorUtil.convertIntColorToRGBValues(sourcenodestyle_p.getForegroundcolor()));
            customfeatures.add(DiagramPackage.eINSTANCE.getFlatContainerStyle_ForegroundColor().getName());
            // NOTE : Here we add both the background and the foreground color tags into custom features, it looks non-logical
            // but this is how it should be done in order to obtain the same behavior as the "appearance" tab color picker of diagram editors
            customfeatures.add(DiagramPackage.eINSTANCE.getFlatContainerStyle_BackgroundColor().getName());
          }
        }
        RefreshSiriusElement.refresh(targetelementstyle);
      }
    }
  }

  /**
   * The font style is applied to the node on two different layers, the first is the ownedstyle property of the node element and the second is the first element
   * of the styles[] list of the node itself.
   * @param sourcefontstyle_p source font style to apply to the node. It can be null, in that case nothing changes in the node.
   * @param dnode_p the layout is applied to this non-null node.
   */
  public static void applyAbstractDNodePatternFontStyle(TemplateFontStyle sourcefontstyle_p, Node dnode_p) {
    Style ownedstyle = null;
    FontStyle style = null;
    List<String> customfeatures = new ArrayList<String>();

    if (dnode_p.getElement() instanceof DNode) {
      DNode nodeelement = (DNode) dnode_p.getElement();
      ownedstyle = nodeelement.getOwnedStyle();
      customfeatures = ownedstyle.getCustomFeatures();
    } else if (dnode_p.getElement() instanceof DNodeContainer) {
      DNodeContainer nodeelement = (DNodeContainer) dnode_p.getElement();
      ownedstyle = nodeelement.getOwnedStyle();
      customfeatures = ownedstyle.getCustomFeatures();
    }else if (dnode_p.getElement() instanceof DNodeList) {
      DNodeList nodeelement = (DNodeList) dnode_p.getElement();
      ownedstyle = nodeelement.getOwnedStyle();
      customfeatures = ownedstyle.getCustomFeatures();
    }
    if (!dnode_p.getStyles().isEmpty()) {
      Object mystyleobject = dnode_p.getStyles().get(0);
      if (mystyleobject instanceof FontStyle) {
        style = (FontStyle) mystyleobject;

      }
    }

    if ((ownedstyle != null)) {
      if (ownedstyle instanceof BasicLabelStyle) {
        // Shape style
        BasicLabelStyle basiclabelownedstyle = (BasicLabelStyle) ownedstyle;
        // Label format
        if (sourcefontstyle_p != null) {
          if (sourcefontstyle_p.isBold()) {
            customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
            FontFormatHelper.setFontFormat(basiclabelownedstyle.getLabelFormat(), FontFormat.BOLD_LITERAL);
          } else if (sourcefontstyle_p.isItalic()) {
            customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
            FontFormatHelper.setFontFormat(basiclabelownedstyle.getLabelFormat(), FontFormat.ITALIC_LITERAL);
          } else if (sourcefontstyle_p.isStrikethrough()) {
            customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
            FontFormatHelper.setFontFormat(basiclabelownedstyle.getLabelFormat(), FontFormat.STRIKE_THROUGH_LITERAL);
          } else if (sourcefontstyle_p.isUnderline()) {
              customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
              FontFormatHelper.setFontFormat(basiclabelownedstyle.getLabelFormat(), FontFormat.UNDERLINE_LITERAL);
            }

          if (sourcefontstyle_p.getColor() != -1) {
            basiclabelownedstyle.setLabelColor(ColorUtil.convertIntColorToRGBValues(sourcefontstyle_p.getColor()));
            customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName());

          }
          if (sourcefontstyle_p.getHeight() != -1) {
            basiclabelownedstyle.setLabelSize(sourcefontstyle_p.getHeight());
            customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelSize().getName());
          }
        }
      }
    }
    if (style != null) {
      FontStyle fontstyle = style;
      if (sourcefontstyle_p != null) {
        if (sourcefontstyle_p.isBold()) {
          customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
          fontstyle.setBold(true);
        }
        if (sourcefontstyle_p.isItalic()) {
          customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName());
          fontstyle.setItalic(true);
        }
        if (sourcefontstyle_p.isStrikethrough())
          fontstyle.setStrikeThrough(true);
        if (sourcefontstyle_p.isUnderline())
          fontstyle.setUnderline(true);
        if (sourcefontstyle_p.getColor() != -1) {
          fontstyle.setFontColor(sourcefontstyle_p.getColor());
          customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName());
        }
        if (sourcefontstyle_p.getHeight() != -1) {
          fontstyle.setFontHeight(sourcefontstyle_p.getHeight());
          customfeatures.add(ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelSize().getName());
        }
        if (sourcefontstyle_p.getName() != DEFAULT_FONT_STYLE_NAME)
          fontstyle.setFontName(sourcefontstyle_p.getName());
      }
    }
  }

  /**
   * Adjust the given font data according to the Sirius element's owned style
   * @param templateFontStyle_p  a non-null object
   * @param siriusElement_p a non-null sirius element
   */
  public static void adjustTemplateFontStyleWithSiriusElement(
      TemplateFontStyle templateFontStyle_p, DSemanticDecorator siriusElement_p) {
    if (siriusElement_p instanceof DEdge) {
      DEdge edge = (DEdge) siriusElement_p;
      EdgeStyle edgeStyle = edge.getOwnedStyle();
      CenterLabelStyle centerLabelStyle = edgeStyle.getCenterLabelStyle();
      if(centerLabelStyle != null){
        templateFontStyle_p.setColor(ColorUtil.convertRGBValuesToIntColor(centerLabelStyle.getLabelColor()));
        templateFontStyle_p.setHeight(centerLabelStyle.getLabelSize());
        
        templateFontStyle_p.setBold(centerLabelStyle.getLabelFormat().contains(FontFormat.BOLD_LITERAL));
        templateFontStyle_p.setItalic(centerLabelStyle.getLabelFormat().contains(FontFormat.ITALIC_LITERAL));
        templateFontStyle_p.setItalic(centerLabelStyle.getLabelFormat().contains(FontFormat.STRIKE_THROUGH_LITERAL));
        templateFontStyle_p.setUnderline(centerLabelStyle.getLabelFormat().contains(FontFormat.UNDERLINE_LITERAL));
    
      }
    }
  }

  /**
   * Set the location of the given diagram element according to the given location
   * if both parameters are non-null
   * @param diagramElement_p a potentially null diagram element
   * @param location a potentially null Point object
   */
  public static void setLocation(DDiagramElement diagramElement_p, Point location) {
    if (diagramElement_p != null && location != null){
      List<View> views = SiriusLayersUtil.upViewpointToGmf(diagramElement_p);
      if (!views.isEmpty() && (views.get(0) instanceof Node)) {
        Node node = (Node) views.get(0);
        LayoutConstraint constraint = node.getLayoutConstraint();
        if (constraint instanceof Bounds) {
          Bounds bounds = (Bounds) constraint;
          bounds.setX(location.x);
          bounds.setY(location.y);
        }
      }  
    } 
  }

  /**
   * Return the hierarchical level of the given diagram element in its diagram
   * @param diagramElement_p a potentially null diagram element
   * @return an int corresponding to the hierarchical level
   */
  public static int getHierarchyLevel(DDiagramElement diagramElement_p) {
    int level = 100;
    if(diagramElement_p != null){
      DDiagram myDiagram = diagramElement_p.getParentDiagram();
      List<DDiagramElement> directDiagramElements = myDiagram.getOwnedDiagramElements();
      if (directDiagramElements.contains(diagramElement_p)) {
        return 1;
      }
      for (DDiagramElement element : directDiagramElements) {
        int found = -1;
        if (element instanceof DNodeContainer) {
          DNodeContainer container = (DNodeContainer) element;
          found = (1 + getRelativeHierarchyLevel(diagramElement_p, container));
        }
        if (found > 0) {
          return found;
        }
      }	
    }  
    return level;
  }

  /**
   * Return the hierarchical level of the given diagram element inside the given container
   * (0 if the container is null)
   * @param diagramElement_p a potentially null diagram element
   * @param container_p a potentially null DNodeContainer
   * @return (-1) if the diagram element is null, else (0) if the container is null, else
   *  the relative hierarchy
   */
  public static int getRelativeHierarchyLevel(DDiagramElement diagramElement_p,
      DNodeContainer container_p) {
    int level = -1;
    if(diagramElement_p != null){
      if(container_p != null){
        List<DDiagramElement> directDiagramElements = container_p.getOwnedDiagramElements();
        if (directDiagramElements.contains(diagramElement_p))
          return 1;
        int found = 0;
        for (DDiagramElement element : directDiagramElements) {
          if (element instanceof DNodeContainer) {
            DNodeContainer container = (DNodeContainer) element;
            found = getRelativeHierarchyLevel(diagramElement_p, container);
          }
          if (found != 0)
            break;
        }
        if (found > 0)
          level = 1 + found;
      } else {
        return 0;
      }
    }
    return level;
  }

  /**
   * Return whether the given diagram element represents one of the given elements
   * @param diagramElement_p a potentially null diagram element
   * @param elements_p a potentially null list
   */
  public static boolean isInstanceParticipant(DDiagramElement diagramElement_p,
      Collection<EObject> elements_p) {
    if (diagramElement_p != null && elements_p != null){
      if (diagramElement_p.getTarget() != null &&
          elements_p.contains(diagramElement_p.getTarget()))
        return true;
    }
    return false;
  }

  /**
   * Return whether the given diagram element is a node that is a top-level element
   * inside instance participant containers from elementsList_p
   * @param diagramElement_p a potentially null DDiagramElement
   * @param elementsList_p a potentially null collection of DDiagramElmeents
   * @param instanceElementsList_p a potentially null collection of EObjects
   */
  public static boolean isHigherLevelNode(DDiagramElement diagramElement_p,
      Collection<? extends DDiagramElement> elementsList_p,
      Collection<EObject> instanceElementsList_p) {
    if(diagramElement_p != null && elementsList_p != null && instanceElementsList_p != null){
      if (diagramElement_p instanceof AbstractDNode) {
        for (DDiagramElement element : elementsList_p) {
          if (isInstanceParticipant(element, instanceElementsList_p)) {
            if (element instanceof DNodeContainer) {
              DNodeContainer dnode = (DNodeContainer) element;
              if (diagramElement_p.eContainer() == dnode)
                return false;
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  /**
   * Return whether the given diagram element is a top-level element among the given list
   * inside instance participant containers from elementsList_p
   * @param diagramElement_p a potentially null DDiagramElement
   * @param elementsList_p a potentially null collection of DDiagramElmeents
   */
  public static boolean isHigherLevelDiagramElementInList(DDiagramElement diagramElement_p,
      Collection<? extends DDiagramElement> elementsList_p) {
    if(diagramElement_p != null && elementsList_p != null){
          if(!elementsList_p.contains(diagramElement_p.eContainer())){
            return true;
          }
    }
    return false;
  }

  /**
   * Return the first merged element that is found. It is considered to be the local
   * reference element.
   * If the element is contained in a hierarchy of containers it will be the same
   * reference for all those containers.
   * @param diagramElement_p a potentially null DDiagramElement
   * @param mergedElementsList_p a potentially null list of DDiagramElements
   * @return a potentially null diagram element
   */
  public static DDiagramElement getLocalReferenceLocation(DDiagramElement diagramElement_p,
      List<DDiagramElement> mergedElementsList_p) {
    if(diagramElement_p != null && mergedElementsList_p != null){
      if (diagramElement_p instanceof DNodeContainer) {
        DNodeContainer container = (DNodeContainer) diagramElement_p;
        for (DDiagramElement element : mergedElementsList_p) {
          if (container.getElements().contains(element)) {
            // The first contained merged element is picked as the local reference element
            return element;
          }
        }
      }
    }
    return null;
  }

}
