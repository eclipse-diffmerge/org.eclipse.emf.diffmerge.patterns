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

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.extensions.ISiriusSemanticMapping;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramSVGGenerator;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.diagram.EdgeArrows;
import org.eclipse.sirius.diagram.EdgeRouting;
import org.eclipse.sirius.diagram.LineStyle;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;



/**
 * A Sirius-specific utility class for services related to diagram template types
 * @author Olivier Constant
 * @author Skander TURKI
 */
public class SiriusDiagramUtil extends AbstractDiagramUtil<DDiagramElement, DDiagram, IGraphicalEditPart>{

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil#getDiagramElements(java.lang.Object)
   */
  @Override
  public List<DDiagramElement> getDiagramElements(DDiagram diagram_p) {
    return diagram_p.getDiagramElements();
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil#getSemanticElementsFor(java.lang.Object)
   */
  @Override
  public List<EObject> getSemanticElementsFor(DDiagramElement diagramElement_p) {
    return diagramElement_p.getSemanticElements();
  }

  /**
   * 
   * @param diagramElement_p
   * @return
   */
  @Override
  public Point getLocation(DDiagramElement diagramElement_p) {
    Point vector = new Point(0, 0);
    // Get position vector
    if(diagramElement_p != null){
      List<View> views = SiriusLayersUtil.upViewpointToGmf(diagramElement_p);
      if (!views.isEmpty() && (views.get(0) instanceof Node)) {
        Node node = (Node) views.get(0);
        LayoutConstraint constraint = node.getLayoutConstraint();
        if (constraint instanceof Bounds) {
          Bounds bounds = (Bounds) constraint;
          vector.x = bounds.getX();
          vector.y = bounds.getY();
        }
      }
    }
    return vector;
  }

  @Override
  public EObject getTechnicalContainerFor(DDiagramElement diagramElement_p) {
    return diagramElement_p.eContainer();
  }


  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil#toActualSelection(java.lang.Object)
   */
  @Override
  public Collection<?> toActualSelection(Object selected_p) {
    Collection<EObject> result = new FOrderedSet<EObject>();
    EObject viewpointElement = SiriusLayersUtil.getViewpointElement(selected_p);
    if (viewpointElement instanceof DSemanticDecorator) {
      ISemanticMapping<?, ?, ?, ?> mapping = PatternCoreDiagramPlugin.getDefault().getSemanticMapping();
      if(mapping instanceof ISiriusSemanticMapping){
        result.addAll(((ISiriusSemanticMapping)mapping).getSemanticSelection(
            (DSemanticDecorator)viewpointElement));
      }
    } else if (viewpointElement != null) {
      result.add(viewpointElement);
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil#getDiagramFromSelection(org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  public DDiagram getDiagramFromSelection(IStructuredSelection selection_p) {
    if (selection_p != null) {
      Iterator<?> it = selection_p.iterator();
      while (it.hasNext()) {
        Object current = it.next();
        EObject viewpointElement = SiriusLayersUtil.getViewpointElement(current);
        DDiagram diagram = SiriusUtil.getDiagram(viewpointElement);
        if (diagram != null)
          return diagram;
      }
    }
    return null;
  }

  /**
   * Export the given GEF edit parts to a string representation of an SVG image.
   * @param gefElements_p a non-null, non-empty collection of edit parts which all belong to the same diagram
   * @return a potentially null string
   */
  @Override
  public String exportToSVG(final List<? extends IGraphicalEditPart> gefElements_p) {
    String result = null;
    if (!gefElements_p.isEmpty()) {
      DiagramEditPart diagramEditPart = getDiagramEditPart(gefElements_p.get(0));
      final DiagramSVGGenerator gen = new DiagramSVGGenerator(diagramEditPart);
      if (gefElements_p.contains(diagramEditPart)) {
        Display.getDefault().syncExec(new Runnable() {
          /**
           * @see java.lang.Runnable#run()
           */
          public void run() {
            gen.createSWTImageDescriptorForDiagram();
          }
        });
      } else {
        Display.getDefault().syncExec(new Runnable() {
          /**
           * @see java.lang.Runnable#run()
           */
          public void run() {
            gen.createSWTImageDescriptorForParts(gefElements_p);
          }
        });
      }
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      try {
        gen.stream(outStream);
        outStream.close();
        result = outStream.toString("UTF-8"); //$NON-NLS-1$
      } catch (Exception e) {
        // Failure: return null
      }
    }
    return result;
  }

  /**
   * Return the GEF diagram edit part corresponding to the given edit part
   * @param editPart_p a non-null edit part
   * @return a potentially null diagram edit part
   */
  public static DiagramEditPart getDiagramEditPart(IGraphicalEditPart editPart_p) {
    DiagramEditPart result = null;
    RootEditPart root = editPart_p.getRoot();
    if (root != null) {
      EditPart rootContents = root.getContents();
      if (rootContents instanceof DiagramEditPart)
        result = (DiagramEditPart)rootContents;
    }
    return result;
  }


  /**
   * A structure for holding node style data
   * @author S. TURKI
   */
  public static class LocalNodeStyle {
    public int selectedNSBorderColor = -1;
    public int selectedNSBorderSize = -1;
    public int selectedNSShapeColor = -1;
    public int selectedNSTransparency = -1;
    public int selectedNSForegroundColor = -1;
    public int selectedNSBackgroundColor = -1;
  }

  /**
   * A structure for holding font style data
   * @author S. TURKI
   */
  public static class LocalFontStyle {
    public int selectedFontColor = -1;
    public String selectedFontName = "default"; //$NON-NLS-1$
    public int selectedFontHeight = -1;
    public boolean selectedIsBold = false;
    public boolean selectedIsItalic = false;
    public boolean selectedIsStrikeThrough = false;
    public boolean selectedIsUnderline = false;
  }

  /**
   * A structure for holding edge style data
   * @author S. TURKI
   */
  public static class LocalEdgeStyle {
    public int selectedLineColor = -1;
    public int selectedLineWidth = -1;
    public LineStyle selectedLineStyle = null;
    public EdgeRouting selectedEdgeRouting = null;
    public EdgeArrows selectedTargetArrow = null;
    public EdgeArrows selectedSourceArrow = null;
  }

}
