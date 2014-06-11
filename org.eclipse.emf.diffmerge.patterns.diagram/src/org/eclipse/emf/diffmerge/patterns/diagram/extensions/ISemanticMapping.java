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
package org.eclipse.emf.diffmerge.patterns.diagram.extensions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;


/**
 * A semantic mapping provides information about the relationship between diagrammatic
 * and semantic elements and their representation for a given modeling tool.
 * @author Olivier Constant
 * @param <ContainerType> Refers to the type of the graphical container of the mapping of the involved semantic elements
 * @param <MappingType> the type of the mapping to test again the involved semantic element
 * @param <DiagramType> The type of the diagram involved
 * @param <SemanticDecoratorType> The common super-type of the graphical nodes involved
 */
public interface ISemanticMapping<ContainerType, MappingType, DiagramType, SemanticDecoratorType> {
  
  /**
   * Return whether the given element conforms to the given mapping's requirements.
   * In addition to standard Viewpoint mechanisms, this method may involve business criteria.
   * @see SiriusUtil#conformsToMapping(EObject, AbstractNodeMapping, boolean, boolean, EObject)
   * @param semanticElt_p the semantic element to test against the given mapping
   * @param mapping_p the mapping to test again the given semantic element
   * @param considerPrecondition_p whether the precondition of the mapping must be tested
   * @param considerCandidates_p whether the semantic candidates expression of the mapping
   *        must be taken into account
   * @param containerView_p the (optional) expected graphical container of the node that
   *        would be created by instantiation of the given mapping on the given semantic
   *        element
   */
  boolean conformsToMapping(EObject semanticElt_p, MappingType mapping_p,
      boolean considerPrecondition_p, boolean considerCandidates_p,
      ContainerType containerView_p);
    
 
  /**
   * Return the semantic elements represented by the given semantic decorator when
   * considered as a user selection in a diagram.
   * @param decorator_p a non-null semantic decorator
   * @return a non-null, non-empty, unmodifiable set
   */
  Collection<EObject> getSemanticSelection(SemanticDecoratorType decorator_p);
  
  /**
   * Return the set of semantic elements whose representation might be a
   * container for the representation of the given semantic element
   * @param element_p a non-null element
   * @param diagram_p a non-null diagram
   * @return a non-null, potentially empty collection
   */
  Collection<EObject> getSemanticCandidatesForGraphicalStorage(
      EObject element_p, DiagramType diagram_p);
  
  /**
   * Return the semantic element represented by the given semantic decorator when
   * considered as a container for storage.
   * The storage element may be different from the semantic element being represented,
   * e.g., creating a node in the diagram background means adding a sibling (not
   * a child) of the semantic element represented by the diagram.
   * @param decorator_p a non-null semantic decorator
   * @return a non-null semantic element
   */
  EObject getSemanticStorage(SemanticDecoratorType decorator_p);
  

  
}
