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
package org.eclipse.emf.diffmerge.patterns.diagram.umldesigner.ext;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.diagram.sirius.extensions.DefaultSemanticMapping;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.SiriusUtil;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.internal.metamodel.description.spec.ContainerMappingSpec;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.uml2.uml.Association;


/**
 * A semantic mapping for UML Designer.
 * @author Skander Turki
 */
@SuppressWarnings("restriction")
public class UMLDesignerSemanticMapping extends DefaultSemanticMapping{

  public UMLDesignerSemanticMapping(){
    super();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.sirius.extensions.DefaultSemanticMapping#getSemanticStorage(fr.obeo.dsl.viewpoint.DSemanticDecorator)
   */
  @Override
  public EObject getSemanticStorage(Object decorator_p) {
    // Semantic element by default
    if(decorator_p instanceof DSemanticDecorator){
      EObject result = super.getSemanticStorage(decorator_p);

      if (decorator_p instanceof DSemanticDiagram) {
        DSemanticDiagram diagram = (DSemanticDiagram)decorator_p;
        if (diagramTargetIsExplicitlyRepresented(diagram)) { 
          result = result.eContainer();
        }
      }
      return result; 
    }
    return null;
  }
  
  /**
   * Return whether the semantic element of the given diagram is explicitly
   * represented as a node in the diagram
   * @param diagram_p a non-null diagram
   */
  private boolean diagramTargetIsExplicitlyRepresented(DSemanticDiagram diagram_p) {
    final EObject diagramTarget = diagram_p.getTarget();
    if (diagramTarget == null) return false;
    Collection<AbstractDNode> subNodes = new ArrayList<AbstractDNode>();
    subNodes.addAll(diagram_p.getContainers());
    subNodes.addAll(diagram_p.getNodeListElements());
    subNodes.addAll(diagram_p.getNodes());
    for (AbstractDNode currentNode : subNodes) {
      if (diagramTarget == currentNode.getTarget())
        return true;
    }
    return false;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.sirius.extensions.DefaultSemanticMapping#getSemanticCandidatesForGraphicalStorage(org.eclipse.emf.ecore.EObject, org.eclipse.sirius.diagram.DDiagram)
   */
  @Override
  public Collection<EObject> getSemanticCandidatesForGraphicalStorage(EObject element_p, Object diagram_p) {
    Collection<EObject> result =
        super.getSemanticCandidatesForGraphicalStorage(element_p, diagram_p);
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.sirius.extensions.DefaultSemanticMapping#getSemanticSelection(org.eclipse.sirius.viewpoint.DSemanticDecorator)
   */
  @Override
  public Collection<EObject> getSemanticSelection(Object decorator_p) {
    Collection<EObject> result = new FOrderedSet<EObject>();
    result.addAll(super.getSemanticSelection(decorator_p));
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping#conformsToMapping(org.eclipse.emf.ecore.EObject, fr.obeo.dsl.viewpoint.description.AbstractNodeMapping, boolean, boolean, fr.obeo.dsl.viewpoint.DContainer)
   */
  @Override
  public boolean conformsToMapping(EObject semanticElt_p, AbstractNodeMapping mapping_p,
      boolean considerPrecondition_p, boolean considerCandidates_p, Object containerView_p) {
    if(semanticElt_p instanceof Association && mapping_p instanceof ContainerMappingSpec)
      return false;
    return SiriusUtil.conformsToMapping(
        semanticElt_p, mapping_p, considerPrecondition_p, considerCandidates_p, containerView_p);
  }
  
}
