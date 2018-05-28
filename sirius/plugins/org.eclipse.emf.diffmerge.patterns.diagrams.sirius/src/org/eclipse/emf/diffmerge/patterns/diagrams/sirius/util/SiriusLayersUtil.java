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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;


/**
 * Utility class for inter-layer model navigation (GEF / GMF / Sirius / Semantic)
 * @author Olivier Constant
 */
public final class SiriusLayersUtil { 
  
  /**
   * Constructor
   */
  private SiriusLayersUtil() {
    // Forbids instantiation
  }
  
  /**
   * Return the GMF element represented by the given GEF element
   * @param editPart_p a potentially null GEF EditPart
   * @return a potentially null GMF View
   */
  public static View downGefToGmf(EditPart editPart_p) {
    View result = null;
    if (editPart_p != null) {
      Object modelElement = editPart_p.getModel();
      if (modelElement instanceof View)
        result = (View)modelElement;
    }
    return result;
  }
  
  /**
   * Return the Viewpoint element represented by the given GMF element
   * @param view_p a potentially null GMF View
   * @return a potentially null Viewpoint DSemanticDecorator
   */
  public static DSemanticDecorator downGmfToViewpoint(View view_p) {
    DSemanticDecorator result = null;
    if (view_p != null) {
      EObject representedElement = view_p.getElement();
      if (representedElement instanceof DSemanticDecorator)
        result = (DSemanticDecorator)representedElement;
    }
    return result;
  }
  
  /**
   * Return the semantic element represented by the given Viewpoint element
   * @param decorator_p a potentially null Viewpoint DSemanticDecorator
   * @return a potentially null element
   */
  public static EObject downViewpointToSemantic(DSemanticDecorator decorator_p) {
    EObject result = null;
    if (decorator_p != null)
      result = decorator_p.getTarget();
    return result;
  }
  
  /**
   * Retrieve a cross referencer which covers all domain layers: Semantic, Viewpoint, GMF
   * @param elementInSession_p a potentially null element belonging to the desired session
   * @return a potentially null cross referencer (always null if elementInSession_p is null)
   */
  private static ECrossReferenceAdapter getGlobalReferencer(EObject elementInSession_p) {
    ECrossReferenceAdapter result = null;
    EObject semanticElement = getSemanticElement(elementInSession_p);
    if (semanticElement != null) {
      Session session = SessionManager.INSTANCE.getSession(semanticElement);
      if (session != null) {
        result = session.getSemanticCrossReferencer();
      }
    }
    return result;
  }
  
  /**
   * Navigate the non-navigable opposite of a reference
   * @param element_p a potentially null element
   * @param ref_p a non-null reference
   * @return a non-null, potentially empty, unmodifiable ordered set
   */
  private static List<EObject> getOpposites(EObject element_p, EReference ref_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    ECrossReferenceAdapter referencer = getGlobalReferencer(element_p);
    if (referencer != null) {
      Collection<Setting> settings =
        referencer.getNonNavigableInverseReferences(element_p);
      for (Setting setting : settings) {
        if (ref_p.equals(setting.getEStructuralFeature()))
          result.add(setting.getEObject());
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Return the semantic element which is represented by the given object belonging to
   * any of the representation-related layers (GEF, GMF, Viewpoint, semantic)
   * @param element_p a potentially null object
   * @return a potentially null element which can be element_p
   */
  public static EObject getSemanticElement(Object element_p) {
    EObject result = getViewpointElement(element_p);
    if (result instanceof DSemanticDecorator)
      result = downViewpointToSemantic((DSemanticDecorator)result);
    return result;
  }
  
  /**
   * Return the Viewpoint element which is represented by the given object belonging to
   * any of the top representation-related layers (GEF, GMF)
   * @param element_p a potentially null object which is a GEF EditPart or a GMF View
   * @return a non-null element
   */
  public static EObject getViewpointElement(Object element_p) {
    EObject result = null;
    Object current = element_p;
    if (current instanceof EditPart)
      current = downGefToGmf((EditPart)current);
    if (current instanceof View)
      current = downGmfToViewpoint((View)current);
    if (current instanceof EObject)
      result = (EObject)current;
    return result;
  }
  
  /**
   * Return the Viewpoint elements which represent the given semantic element in its session
   * @param semanticElement_p a potentially null element
   * @return a non-null, potentially empty, unmodifiable ordered set
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static List<DSemanticDecorator> upSemanticToViewpoint(EObject semanticElement_p) {
    return (List)getOpposites(semanticElement_p,
        ViewpointPackage.eINSTANCE.getDSemanticDecorator_Target());
  }
  
  /**
   * Return the GMF elements which represent the given Viewpoint element in its session
   * @param decorator_p a potentially null element
   * @return a non-null, potentially empty, unmodifiable ordered set
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static List<View> upViewpointToGmf(DSemanticDecorator decorator_p) {
    return (List)getOpposites(decorator_p,
        NotationPackage.eINSTANCE.getView_Element());
  }
  
}
