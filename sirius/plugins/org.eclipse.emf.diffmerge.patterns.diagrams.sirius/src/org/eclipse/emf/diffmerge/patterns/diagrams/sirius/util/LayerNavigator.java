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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;


/**
 * Class providing services related to layers navigation (GEF, Doremi, GMF).
 * @author Olivier Constant
 * @author Skander Turki
 */
public class LayerNavigator {

  /** Cross Referencer */
  private ECrossReferenceAdapter _referencer;
  
  /** Current Diagram Editor */
  private DDiagramEditor _diagramEditor;
  
  /**
   * Constructor
   * @param element_p
   */
  public LayerNavigator(EObject element_p, DDiagramEditor diagramEditor_p){
    IModelEnvironment accessor = CorePatternsPlugin.getDefault().getModelEnvironment();
    if(accessor != null){
      _referencer = accessor.getInverseCrossReferencer(element_p);
    }
    _diagramEditor = diagramEditor_p;
  }
  
  /**
   * Returns diagram editor used in construction
   */
  public DDiagramEditor getDiagramEditor(){
    return _diagramEditor;
  }
  
  /**
   * Tells if the class was correctly initialized
   * @return a boolean
   */
  protected boolean isOperational(){
    if(_referencer != null)
      return true;
    return false;
  }
  
 /**
  * Convenience method for a specific case of getOpposites where the reference
  * is known to be injective, i.e., there exists at most one referencing element
  * @param element_p a non-null EObject
  * @param ref_p a non-null EReference
  * @return a potentially null EObject
  */
 public EObject getOppositeInDiagram(EObject element_p, EReference ref_p, DDiagramEditor diagramEditor_p) {
   EObject result = null;
   if(isOperational()){
     Set<EObject> opposites = getOpposites(element_p, ref_p);
     if (!opposites.isEmpty())
       for(EObject obj : opposites){
         if(isContainedInDiagram(obj, diagramEditor_p)){
           result = obj;
         }
       }
   }
   return result;
 }
 
 /**
  * Returns true when a representation of the given obj exists in the given diagram editor
  * @param obj a potentially-null EObject
  * @param diagram_p a potentially-null DDiagramEditor
  * @return a boolean
  */
 private boolean isContainedInDiagram(EObject obj, DDiagramEditor diagramEditor_p) {
   if(diagramEditor_p != null && obj != null){
     DRepresentation rep = diagramEditor_p.getRepresentation();
     if(rep != null){
       if(rep.getRepresentationElements().contains(obj)){
         return true;
       }
     }
   }
  return false;
}

/**
  * Navigate the non-navigable opposite of a reference
  * @param element_p a non-null EObject
  * @param ref_p a non-null EReference
  * @return a non-null Set of EObjects
  */
 public Set<EObject> getOpposites(EObject element_p, EReference ref_p) {
   Set<EObject> result = new HashSet<EObject>();
   
   if(isOperational()) {
     Collection<Setting> settings =
       _referencer.getNonNavigableInverseReferences(element_p);
     for (Setting setting : settings) {
       if (ref_p.equals(setting.getEStructuralFeature()))
         result.add(setting.getEObject());
     }
   }
   return result;
 }
 
 /**
  * Convenience method for a specific case of getOpposites where the reference
  * is known to be injective, i.e., there exists at most one referencing element
  * @param element_p a non-null EObject
  * @param ref_p a non-null EReference
  * @return a potentially null EObject
  */
 public EObject getOpposite(EObject element_p, EReference ref_p) {
   EObject result = null;
   if(isOperational()){
     Set<EObject> opposites = getOpposites(element_p, ref_p);
     if (!opposites.isEmpty())
       result = opposites.iterator().next();
   }
   return result;
 }
 
 
 /**
  * Returns the GMF representation of the Doremi element
  * @param doremiElement_p a non-null DSemanticDecorator
  * @return a potentially null EObject
  */
 public View getUpGmfElement(DSemanticDecorator doremiElement_p) {
   EObject result = null;
   if(isOperational()){
     result = getOpposite(doremiElement_p,
         NotationPackage.eINSTANCE.getView_Element());
   }
   if(result instanceof View){
     return (View)result;
   }
   return null;
 }

 /**
  * Returns the Doremi representation of the semantic element
  * @param semanticElement_p a non-null EObject
  * @return a potentially null DSemanticDecorator
  */
 // Warning: use only if the given semantic element has at most one representation
 // in the current session
 public DSemanticDecorator getUpDoremiElement(EObject semanticElement_p) {
   EObject result = null;
   if(isOperational()){
     result = getOppositeInDiagram(semanticElement_p,
         ViewpointPackage.eINSTANCE.getDRepresentationElement_SemanticElements(), getDiagramEditor());
   }
   if(result instanceof DSemanticDecorator){
     return (DSemanticDecorator)result;
   }
   return null;
 }
 
}
