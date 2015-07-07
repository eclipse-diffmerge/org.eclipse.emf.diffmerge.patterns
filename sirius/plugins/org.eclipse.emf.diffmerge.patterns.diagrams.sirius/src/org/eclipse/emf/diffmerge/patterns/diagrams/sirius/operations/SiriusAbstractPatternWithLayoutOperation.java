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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractPatternWithLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.ColorUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.LayerNavigator;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.LayoutUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.SiriusDiagramUtil.LocalEdgeStyle;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.SiriusDiagramUtil.LocalFontStyle;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.SiriusDiagramUtil.LocalNodeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle;
import org.eclipse.emf.diffmerge.util.structures.FHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.viewpoint.BasicLabelStyle;
import org.eclipse.sirius.diagram.ContainerStyle;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.FlatContainerStyle;
import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.diagram.Square;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * A Sirius-specific model operation which is concerned with the definition 
 * of patterns with graphical layouts.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class SiriusAbstractPatternWithLayoutOperation<T> 
extends AbstractPatternWithLayoutOperation<T>{

  public SiriusAbstractPatternWithLayoutOperation(String name_p,
      AbstractModifiableTemplatePatternSpecification data_p,
      List<Object> graphicalContext_p, Object patternSideContext_p) {
    super(name_p, data_p, graphicalContext_p, patternSideContext_p);
  }

  /**
   * Builds and returns a map from semantic elements to the layout and style of their representation
   * @return a non-null, potentially empty, unmodifiable map
   */
  @Override
  public EMap<EObject, Layout> buildLayoutData() {
    EMap<EObject, Layout> resultMap = new FHashMap<EObject, Layout>();
    //notIncludedSemanticElementsViews is used by the loop that computes layoutData for includedElementsViews not to compute twice the same data
    List<EObject> notIncludedSemanticElementsViews = new ArrayList<EObject>();
    for (Object obj : _graphicalContext) {
      if(obj instanceof IGraphicalEditPart){
        Object gefModel = ((IGraphicalEditPart)obj).getModel();
        if (gefModel instanceof View) {
          // GMF level
          View view = (View)gefModel;
          getViewLayoutData(view, resultMap);
          notIncludedSemanticElementsViews.add(view);
        }
      }
    }
    //Included elements layouts
    List<View> allElementsViews = addIncludedElementsGMFLayout();
    for(View view : allElementsViews){
      if(!notIncludedSemanticElementsViews.contains(view)){
        getViewLayoutData(view, resultMap);
      }
    }
    return ECollections.unmodifiableEMap(resultMap);
  }

  /**
   * Build and return layout and style data for the given GMF node
   * @param edge_p a non-null edge
   * @return a non-null layout object
   */
  private EdgeLayout buildLayoutDataForEdge(Edge edge_p) {
    EdgeLayout result = null;
    // Edge line style, font style, label styles
    LocalEdgeStyle localEdgeStyle = new LocalEdgeStyle();
    LocalFontStyle localEdgeFontStyle = new LocalFontStyle();
    LocalFontStyle localCenterEdgeFontStyle = new LocalFontStyle();
    LocalFontStyle localEndEdgeFontStyle = new LocalFontStyle();
    LocalFontStyle localBeginEdgeFontStyle = new LocalFontStyle();
    // Iterating over GMF edge styles
    List<String> edgeCustomFeatures = LayoutUtil.getEdgeCustomSpecification(edge_p);
    @SuppressWarnings("unchecked")
    EList<Style> styles = edge_p.getStyles();
    for (Style style : styles) {
      if (style instanceof FontStyle) {
        // Edge font
        FontStyle fontstyle = (FontStyle) style;
        if (edge_p.getElement() instanceof DEdge) {
          DEdge dedge = (DEdge) edge_p.getElement();
          EdgeStyle edgestyle = dedge.getOwnedStyle();
          getLocalFontStyleDataFromFont(localEdgeFontStyle, fontstyle);
          if (edgestyle.getCenterLabelStyle() != null)
            getLocalFontStyleData(localCenterEdgeFontStyle, edgestyle.getCenterLabelStyle());
          if (edgestyle.getEndLabelStyle() != null)
            getLocalFontStyleData(localEndEdgeFontStyle, edgestyle.getEndLabelStyle());
          if (edgestyle.getBeginLabelStyle() != null)
            getLocalFontStyleData(localBeginEdgeFontStyle, edgestyle.getBeginLabelStyle());
        }
        // edge layout
      } else if (style instanceof ConnectorStyle) {
        ConnectorStyle connectorStyle = (ConnectorStyle) style;
        getLocalEdgeStyleDataFromConnector(localEdgeStyle, connectorStyle, edgeCustomFeatures);
      }
    }
    Bendpoints bendpoints = edge_p.getBendpoints();
    if (bendpoints != null) {
      EObject doremiElement = edge_p.getElement();
      if (doremiElement instanceof DEdge) {
        DEdge dedge = (DEdge) doremiElement;
        EdgeStyle edgestyle = dedge.getOwnedStyle();
        getLocalEdgeStyleData(localEdgeStyle, edgestyle, edgestyle.getCustomFeatures());
        // build the appropriate TemplateFontStyle
        TemplateFontStyle templateFontStyle = LayoutUtil.toTemplateFontStyle(
            localEdgeFontStyle.selectedFontColor,
            localEdgeFontStyle.selectedFontName,
            localEdgeFontStyle.selectedFontHeight,
            localEdgeFontStyle.selectedIsBold,
            localEdgeFontStyle.selectedIsItalic,
            localEdgeFontStyle.selectedIsUnderline,
            localEdgeFontStyle.selectedIsStrikeThrough);
        LayoutUtil.adjustTemplateFontStyleWithDoremiElement(templateFontStyle, dedge);
        // build the center TemplateFontStyle
        TemplateFontStyle centerEdgeFontStyle = LayoutUtil.toTemplateFontStyle(
            localCenterEdgeFontStyle.selectedFontColor,
            localCenterEdgeFontStyle.selectedFontName,
            localCenterEdgeFontStyle.selectedFontHeight,
            localCenterEdgeFontStyle.selectedIsBold,
            localCenterEdgeFontStyle.selectedIsItalic,
            localCenterEdgeFontStyle.selectedIsUnderline,
            localCenterEdgeFontStyle.selectedIsStrikeThrough);
        // build the end TemplateFontStyle
        TemplateFontStyle endEdgeFontStyle = LayoutUtil.toTemplateFontStyle(
            localEndEdgeFontStyle.selectedFontColor,
            localEndEdgeFontStyle.selectedFontName,
            localEndEdgeFontStyle.selectedFontHeight,
            localEndEdgeFontStyle.selectedIsBold,
            localEndEdgeFontStyle.selectedIsItalic,
            localEndEdgeFontStyle.selectedIsUnderline,
            localEndEdgeFontStyle.selectedIsStrikeThrough);
        // build the begin TemplateFontStyle
        TemplateFontStyle beginEdgeFontStyle = LayoutUtil.toTemplateFontStyle(
            localBeginEdgeFontStyle.selectedFontColor,
            localBeginEdgeFontStyle.selectedFontName,
            localBeginEdgeFontStyle.selectedFontHeight,
            localBeginEdgeFontStyle.selectedIsBold,
            localBeginEdgeFontStyle.selectedIsItalic,
            localBeginEdgeFontStyle.selectedIsUnderline,
            localBeginEdgeFontStyle.selectedIsStrikeThrough);
        // build the edge layout
        result = LayoutUtil.toEdgeLayout(
            bendpoints,
            localEdgeStyle.selectedLineColor,
            localEdgeStyle.selectedLineWidth,
            localEdgeStyle.selectedLineStyle,
            localEdgeStyle.selectedEdgeRouting,
            localEdgeStyle.selectedTargetArrow,
            localEdgeStyle.selectedSourceArrow);
        result.setFontStyle(templateFontStyle);
        result.setCenterFontStyle(centerEdgeFontStyle);
        result.setEndFontStyle(endEdgeFontStyle);
        result.setBeginFontStyle(beginEdgeFontStyle);
      }
    }
    return result;
  }

  /**
   * Return into the given local edge style all the edge style info from the given Edge Style
   * @param localEdgeStyle_p non-null Local Edge Style struct
   * @param edgeStyle_p non-null Edge Style
   * @param customFeatures_p non-null list of strings
   */
  @SuppressWarnings("boxing")
  private void getLocalEdgeStyleData(LocalEdgeStyle localEdgeStyle_p,
      EdgeStyle edgeStyle_p, EList<String> customFeatures_p) {
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_StrokeColor().getName())) {
      localEdgeStyle_p.selectedLineColor =
          ColorUtil.convertRGBValuesToIntColor(edgeStyle_p.getStrokeColor());
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_Size().getName())) {
      localEdgeStyle_p.selectedLineWidth = edgeStyle_p.getSize();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_LineStyle().getName())) {
      localEdgeStyle_p.selectedLineStyle = edgeStyle_p.getLineStyle();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_RoutingStyle().getName())) {
      localEdgeStyle_p.selectedEdgeRouting = edgeStyle_p.getRoutingStyle();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_TargetArrow().getName())) {
      localEdgeStyle_p.selectedTargetArrow = edgeStyle_p.getTargetArrow();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_SourceArrow().getName())) {
      localEdgeStyle_p.selectedSourceArrow = edgeStyle_p.getSourceArrow();
    }

  }

  /**
   * Return into a local font style all the font style info from the Font Style
   * @param localfontstyle_p non-null Local Font Style struct
   * @param shapestyle_p A non-null GMF Font Style
   * @param nodeCustomFeatures_p a non-null list of strings
   */
  private void getLocalFontStyleData(LocalFontStyle localfontstyle_p, BasicLabelStyle style_p) {
    List<String> customFeatures = style_p.getCustomFeatures();
    if (customFeatures.contains(
        ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName())) {
      localfontstyle_p.selectedFontColor =
          ColorUtil.convertRGBValuesToIntColor(style_p.getLabelColor());
    }
    if (customFeatures.contains(
        ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName())) {
      List<FontFormat> format = style_p.getLabelFormat();
      localfontstyle_p.selectedIsBold = false;
      localfontstyle_p.selectedIsItalic = false;
      localfontstyle_p.selectedIsStrikeThrough = false;
      localfontstyle_p.selectedIsUnderline = false;

      for (FontFormat fontFormat : format) {
//    	  BOLD_LITERAL
//    	  ITALIC_LITERAL
//    	  STRIKE_THROUGH_LITERAL
//    	  UNDERLINE_LITERAL
    	  if (FontFormat.BOLD_LITERAL == fontFormat) {
    		  localfontstyle_p.selectedIsBold = true;
    	  } else if (FontFormat.ITALIC_LITERAL == fontFormat) {
    		  localfontstyle_p.selectedIsItalic = true;
    	  } else if (format.equals(FontFormat.STRIKE_THROUGH_LITERAL)) {
    		  localfontstyle_p.selectedIsStrikeThrough = true;
    	  } else if (format.equals(FontFormat.UNDERLINE_LITERAL)) {
    		  localfontstyle_p.selectedIsUnderline = true;
    	  }
      }
    }
    if (customFeatures.contains(
        ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelSize().getName())) {
      localfontstyle_p.selectedFontHeight = style_p.getLabelSize();
    }

  }

  /**
   * Return into a local font style all the font style info from the Font Style
   * @param localfontstyle_p non-null Local Font Style struct
   * @param shapestyle_p A non-null GMF Font Style
   * @param nodeCustomFeatures_p a non-null list of strings
   */
  private void getLocalFontStyleDataFromFont(LocalFontStyle localfontstyle_p, FontStyle style_p) {
    localfontstyle_p.selectedFontName = style_p.getFontName();
    localfontstyle_p.selectedFontColor = style_p.getFontColor();
    localfontstyle_p.selectedIsBold = style_p.isBold();
    localfontstyle_p.selectedIsItalic = style_p.isItalic();
    localfontstyle_p.selectedIsStrikeThrough = style_p.isStrikeThrough();
    localfontstyle_p.selectedIsUnderline = style_p.isUnderline();
    localfontstyle_p.selectedFontHeight = style_p.getFontHeight();
  }

  /**
   * Return into the given local edge style all the edge style info from the given
   * GMF Connector Style
   * @param localEdgeStyle_p non-null Local Edge Style struct
   * @param connectorStyle_p non-null Connector Style
   * @param edgeCustomFeatures_p non-null list of strings
   */
  private void getLocalEdgeStyleDataFromConnector(LocalEdgeStyle localEdgeStyle_p,
      ConnectorStyle connectorStyle_p, List<String> customFeatures_p) {
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_StrokeColor().getName())) {
      localEdgeStyle_p.selectedLineColor = connectorStyle_p.getLineColor();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getEdgeStyle_Size().getName())) {
      localEdgeStyle_p.selectedLineWidth = connectorStyle_p.getLineWidth();
    }
  }

  /**
   * Adds in the resultMap_p Map the layout and style of the representation of the View
   * @param view_p a non-null View
   * @param resultMap_p a non-null EMap of EObject to Layout objects
   */
  private void getViewLayoutData(View view_p, EMap<EObject, Layout> resultMap_p) {
    EObject doremiElement = view_p.getElement();
    if (doremiElement instanceof DSemanticDecorator) {
      // Doremi level
      EObject semanticElement = ((DSemanticDecorator) doremiElement).getTarget();
      if (semanticElement != null) {
        // Semantic level
        EObject counterpart = getData().getCounterpart(semanticElement, false);
        if (counterpart != null && !resultMap_p.containsKey(counterpart)) {
          Layout layout = null;
          if (view_p instanceof Node) {
            // Node
            Node node = (Node) view_p;
            layout = buildLayoutDataForNode(node);
          } else if (view_p instanceof Edge) {
            // Edge
            Edge edge = (Edge) view_p;
            layout = buildLayoutDataForEdge(edge);
          }
          if (layout != null)
            resultMap_p.put(counterpart, layout);
        }
      }
    }
  }

  /**
   * Returns the GMF layouts of included elements
   * @return a non-null ArrayList of View objects
   */
  private List<View> addIncludedElementsGMFLayout() {
    List<View> includedElementsViews = new ArrayList<View>();
    DDiagramEditor diagramEditor = getDiagramEditor();
    for(EObject obj : getData().getAllElements()){
      LayerNavigator navigator = new LayerNavigator(obj, diagramEditor);
      View gmfElement = navigator.getUpGmfElement(navigator.getUpDoremiElement(obj));
      if(gmfElement != null){
        if(!includedElementsViews.contains(gmfElement)){
          includedElementsViews.add(gmfElement);
        }
      }
    }
    return includedElementsViews;
  }


  /**
   * Returns the current DDiagramEditor
   * @return a potentially null DDiagramEditor
   */
  private DDiagramEditor getDiagramEditor() {
    DDiagramEditor diagramEditor = null;
    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    if(window != null){
      IWorkbenchPage page = window.getActivePage();
      if(page != null){
        IEditorPart editor = page.getActiveEditor();
        if(editor instanceof DDiagramEditor){
          diagramEditor = (DDiagramEditor) editor;
        }
      }  
    }
    return diagramEditor;
  }

  /**
   * Build and return layout and style data for the given GMF node
   * @param node_p a non-null node
   * @return a non-null layout object
   */
  private NodeLayout buildLayoutDataForNode(Node node_p) {
    NodeLayout result = null;
    LayoutConstraint constraint = node_p.getLayoutConstraint();
    if (constraint instanceof Bounds) {
      Bounds bounds = (Bounds) constraint;
      List<String> nodeCustomFeatures = LayoutUtil.getNodeCustomSpecification(node_p);
      // Node and font style to fill
      LocalNodeStyle localNodeStyle = new LocalNodeStyle();
      LocalFontStyle localFontStyle = new LocalFontStyle();
      // Iterate over GMF styles
      @SuppressWarnings("unchecked")
      EList<Style> styles = node_p.getStyles();
      for (Style style : styles) {
        if (style instanceof ShapeStyle) {
          ShapeStyle shapestyle = (ShapeStyle) style;
          // get the node style
          getLocalNodeStyle(localNodeStyle, shapestyle, node_p.getElement(), nodeCustomFeatures);
          // get the node's font style
          getLocalFontStyleData(localFontStyle, shapestyle, nodeCustomFeatures);
        } else if (style instanceof FontStyle) {
          FontStyle fontstyle = (FontStyle) style;
          getLocalFontStyleDataFromFontStyle(localFontStyle, fontstyle);
        }
      }
      // Build the appropriate NodeStyle
      NodeStyle templateNodeStyle = LayoutUtil.toTemplateNodeStyle(
          localNodeStyle.selectedNSBorderColor,
          localNodeStyle.selectedNSBorderSize,
          localNodeStyle.selectedNSShapeColor,
          localNodeStyle.selectedNSTransparency,
          localNodeStyle.selectedNSForegroundColor,
          localNodeStyle.selectedNSBackgroundColor);
      // Build the appropriate TemplateFontStyle
      TemplateFontStyle templateFontStyle = LayoutUtil.toTemplateFontStyle(
          localFontStyle.selectedFontColor,
          localFontStyle.selectedFontName,
          localFontStyle.selectedFontHeight,
          localFontStyle.selectedIsBold,
          localFontStyle.selectedIsItalic,
          localFontStyle.selectedIsUnderline,
          localFontStyle.selectedIsStrikeThrough);
      result = LayoutUtil.toNodeLayout(bounds, templateNodeStyle, templateFontStyle);
    }
    return result;
  }



  /**
   * Return into the given local font style all the given GMF font style info
   * @param localFontStyle_p non-null Local Font Style struct
   * @param fontStyle_p non-null GMF Font Style
   */
  private void getLocalFontStyleDataFromFontStyle(LocalFontStyle localFontStyle_p,
      FontStyle fontStyle_p) {
    localFontStyle_p.selectedFontColor = fontStyle_p.getFontColor();
    localFontStyle_p.selectedFontHeight = fontStyle_p.getFontHeight();
    localFontStyle_p.selectedFontName = fontStyle_p.getFontName();

  }

  /**
   * Return into the given local node style all the node style info from the given GMF Shape Style
   * @param localNodeStyle_p non-null Local Node Style struct
   * @param shapeStyle_p non-null GMF Shape Style
   * @param nodeElement_p non-null node's Melody element
   * @param nodeCustomFeatures_p non-null list of strings
   */
  private void getLocalNodeStyle(LocalNodeStyle localNodeStyle_p, ShapeStyle shapeStyle_p,
      EObject nodeElement_p, List<String> customFeatures_p) {
    localNodeStyle_p.selectedNSTransparency = shapeStyle_p.getTransparency();
    // node style
    if (customFeatures_p.contains(LayoutUtil.COLOR_CUSTOM_FEATURE)) {
      localNodeStyle_p.selectedNSShapeColor = shapeStyle_p.getFillColor();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getFlatContainerStyle_ForegroundColor().getName()) &&
        customFeatures_p.contains(
            DiagramPackage.eINSTANCE.getFlatContainerStyle_BackgroundColor().getName())) {
      localNodeStyle_p.selectedNSShapeColor = shapeStyle_p.getFillColor();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getBorderedStyle_BorderColor().getName())) {
      localNodeStyle_p.selectedNSBorderColor = shapeStyle_p.getLineColor();
    }
    if (customFeatures_p.contains(
        DiagramPackage.eINSTANCE.getBorderedStyle_BorderSize().getName())) {
      localNodeStyle_p.selectedNSBorderSize = shapeStyle_p.getLineWidth();
    }
    if (nodeElement_p instanceof DDiagramElementContainer) {
      DDiagramElementContainer container = (DDiagramElementContainer) nodeElement_p;
      ContainerStyle containerstyle = container.getOwnedStyle();
      if (customFeatures_p.contains(
          DiagramPackage.eINSTANCE.getBorderedStyle_BorderSizeComputationExpression().getName())) {
        localNodeStyle_p.selectedNSBorderSize = containerstyle.getBorderSize().intValue();
      }
      if (containerstyle instanceof FlatContainerStyle) {
        FlatContainerStyle flatcontainerstyle = (FlatContainerStyle) containerstyle;
        if (customFeatures_p.contains(
            DiagramPackage.eINSTANCE.getFlatContainerStyle_ForegroundColor().getName())) {
          localNodeStyle_p.selectedNSForegroundColor =
              ColorUtil.convertRGBValuesToIntColor(flatcontainerstyle.getForegroundColor());
        }
        if (customFeatures_p.contains(
            DiagramPackage.eINSTANCE.getFlatContainerStyle_BackgroundColor().getName())) {
          localNodeStyle_p.selectedNSBackgroundColor =
              ColorUtil.convertRGBValuesToIntColor(flatcontainerstyle.getBackgroundColor());
        }
      }
    } else if (nodeElement_p instanceof DDiagramElement) {
      DDiagramElement diagelement = (DDiagramElement) nodeElement_p;
      org.eclipse.sirius.viewpoint.Style elementstyle = diagelement.getStyle();
      if (elementstyle instanceof Square) {
        Square squareelementstyle = (Square) elementstyle;
        if (customFeatures_p.contains(
            DiagramPackage.eINSTANCE.getBorderedStyle_BorderSizeComputationExpression().getName())) {
          localNodeStyle_p.selectedNSBorderSize = squareelementstyle.getBorderSize().intValue();
        }
        if (customFeatures_p.contains(
            DiagramPackage.eINSTANCE.getFlatContainerStyle_ForegroundColor().getName())) {
          localNodeStyle_p.selectedNSForegroundColor =
              ColorUtil.convertRGBValuesToIntColor(squareelementstyle.getColor());
        }
        if (customFeatures_p.contains(
            DiagramPackage.eINSTANCE.getFlatContainerStyle_BackgroundColor().getName())) {
          localNodeStyle_p.selectedNSBackgroundColor =
              ColorUtil.convertRGBValuesToIntColor(squareelementstyle.getColor());
        }
      }
    }
  }

  /**
   * Return into a local font style all the font style info from the Font Style
   * @param localfontstyle_p non-null Local Font Style struct
   * @param shapestyle_p A non-null GMF Font Style
   * @param nodeCustomFeatures_p a non-null list of strings
   */
  private void getLocalFontStyleData(LocalFontStyle localfontstyle_p, FontStyle fontstyle_p, List<String> customFeatures_p) {
    localfontstyle_p.selectedFontName = fontstyle_p.getFontName();
    localfontstyle_p.selectedIsStrikeThrough = fontstyle_p.isStrikeThrough();
    localfontstyle_p.selectedIsUnderline = fontstyle_p.isUnderline();
    if (customFeatures_p.contains(
        ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelColor().getName())) {
      localfontstyle_p.selectedFontColor = fontstyle_p.getFontColor();
    }
    if (customFeatures_p.contains(
        ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelFormat().getName())) {
      localfontstyle_p.selectedIsBold = fontstyle_p.isBold();
      localfontstyle_p.selectedIsItalic = fontstyle_p.isItalic();
    }
    if (customFeatures_p.contains(
        ViewpointPackage.eINSTANCE.getBasicLabelStyle_LabelSize().getName())) {
      localfontstyle_p.selectedFontHeight = fontstyle_p.getFontHeight();
    }

  }

}
