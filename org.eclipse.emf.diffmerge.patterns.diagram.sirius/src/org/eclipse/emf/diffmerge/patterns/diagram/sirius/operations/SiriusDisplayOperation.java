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
package org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractDisplayOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.extensions.ISiriusSemanticMapping;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.SiriusLayersUtil;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.SiriusUtil;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.diffmerge.util.structures.FHashMap;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.diagram.ui.tools.api.layout.PinHelper;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.diagram.business.internal.metamodel.description.extensions.IContainerMappingExt;
import org.eclipse.sirius.diagram.business.internal.metamodel.helper.ContainerMappingHelper;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;

/**
 * A Sirius-specific operation for representing a given set of semantic elements in a given Melody diagram.
 * @author Olivier Constant
 * @author Skander TURKI
 */
@SuppressWarnings("restriction")
public class SiriusDisplayOperation extends AbstractDisplayOperation{

  /** The non-null behaviour for pinning graphical elements */
  private final PinHelper _pinHelper;
  
  /**
   * Constructor
   * @param semanticElements_p
   * @param diagram_p
   * @param refresh_p
   */
  public SiriusDisplayOperation(
      Collection<? extends EObject> semanticElements_p, Object diagram_p,
      boolean refresh_p) {
    super(semanticElements_p, diagram_p, refresh_p);
    _pinHelper = new PinHelper();
  }


  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractDisplayOperation#updateDiagram(java.lang.Object)
   */
  @Override
  protected Collection<Object> updateDiagram(Object objectDiagram_p) {
    if(objectDiagram_p instanceof DDiagram){
      DDiagram diagram_p = (DDiagram)objectDiagram_p;
      // Initialization: find existing nodes
      List<EObject> rootsAndContainers = new FOrderedSet<EObject>();
      rootsAndContainers.addAll(get_semanticRoots());
      ISiriusSemanticMapping sMapping = null;
      ISemanticMapping<?> mapping =
          PatternCoreDiagramPlugin.getDefault().getSemanticMapping();
      if(mapping instanceof ISiriusSemanticMapping){
        sMapping = (ISiriusSemanticMapping)mapping;
      }
      for (EObject root : get_semanticRoots()) {
        Collection<EObject> candidates =
            sMapping.getSemanticCandidatesForGraphicalStorage(root, diagram_p);
        rootsAndContainers.addAll(candidates);
      }
      EMap<EObject, DSemanticDecorator> rootsToNodes =
          getExistingDecorators(rootsAndContainers, (DDiagram)get_diagram());
      Collection<EObject> remainingElements =
          ModelsUtil.getAllContents(get_semanticRoots(), false, null);
      remainingElements.removeAll(rootsToNodes.keySet());
      // Ignore semantic elements which are visible in the diagram
      Collection<EObject> remainingElementsCopy =
          new FOrderedSet<EObject>(remainingElements);
      for (EObject remainingElement : remainingElementsCopy) {
        if (!getNodesInDiagram(remainingElement, diagram_p).isEmpty())
          remainingElements.remove(remainingElement);
      }
      // Phase 1: use existing nodes
      LinkedList<DContainer> containers = new LinkedList<DContainer>(
          filter(rootsToNodes.values(), DContainer.class));
      Collection<Object> createdNodes =
          new FOrderedSet<Object>();
      showAllInContainers(containers, remainingElements, createdNodes);
      // Phase 2: start from diagram if relevant
      if (!rootsToNodes.values().contains(get_diagram()))
        showAllInContainer(diagram_p, remainingElements, createdNodes);
      return Collections.unmodifiableCollection(createdNodes); 
    }
   return Collections.emptyList();
  }



  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractDisplayOperation#refreshDiagram()
   */
  @Override
  protected void refreshDiagram() {
    SiriusUtil.refreshDiagram((DDiagram)get_diagram()); // For displaying arcs
  }
  
  /**
   * Try and display as many semantic elements as possible among the given ones in the
   * given container, recursively
   * @param container_p a non-null graphical container
   * @param remainingElements_p a non-null, modifiable ordered set of semantic elements to display
   * @param createdNodes_p a non-null, modifiable set of nodes that have been created
   */
  private void showAllInContainer(DContainer container_p, Collection<EObject> remainingElements_p,
      Collection<Object> createdNodes_p) {
    LinkedList<DContainer> containers = new LinkedList<DContainer>();
    containers.add(container_p);
    showAllInContainers(containers, remainingElements_p, createdNodes_p);
  }
  
  /**
   * Try and display as many semantic elements as possible among the given ones within the
   * graphical context of the given containers, recursively and in the order specified
   * @param containers_p a non-null, modifiable queue of containers to consider
   * @param remainingElements_p a non-null, modifiable ordered set of semantic elements to display
   * @param createdNodes_p a non-null, modifiable set of nodes that have been created
   */
  private void showAllInContainers(LinkedList<DContainer> containers_p,
      Collection<EObject> remainingElements_p, Collection<Object> createdNodes_p) {
    while (!containers_p.isEmpty() && !remainingElements_p.isEmpty()) {
      DContainer nodeContainer = containers_p.poll();
      Collection<AbstractDNode> allCreated =
          showInContainer(nodeContainer, remainingElements_p);
      createdNodes_p.addAll(allCreated);
      containers_p.addAll(filter(allCreated, DNodeContainer.class));
    }
  }
  
  /**
   * Try and display as many semantic elements as possible among the given ones within the
   * given graphical context
   * Postcondition: remainingElements_p is modified according to the elements displayed
   * @param nodeContainer_p a non-null graphical container (DDiagram or DNodeContainer)
   * @param remainingElements_p a non-null, modifiable ordered set of semantic elements to display
   * @return a non-null, potentially empty, unmodifiable set of the nodes created
   */
  private Collection<AbstractDNode> showInContainer(DContainer graphicalContainer_p,
      Collection<EObject> remainingElements_p) {
    Collection<AbstractDNode> result = new FOrderedSet<AbstractDNode>();
    Collection<AbstractNodeMapping> innerMappings =
        SiriusUtil.getApplicableMappingsIn(graphicalContainer_p);
    Collection<AbstractNodeMapping> reducedInnerMappings =
        SiriusUtil.reduceByImport(innerMappings);
    for (EObject currentElement : new FOrderedSet<EObject>(remainingElements_p)) {
      AbstractDNode created = null;
      Iterator<AbstractNodeMapping> it = reducedInnerMappings.iterator();
      while (created == null && it.hasNext()) {
        AbstractNodeMapping mapping = it.next();
        created = showElement(mapping, currentElement, graphicalContainer_p);
      }
      if (created != null) {
        result.add(created);
        remainingElements_p.remove(currentElement);
      }
    }
    return Collections.unmodifiableCollection(result);
  }
  
  /**
   * Try and represent graphically the given semantic element using the given mapping
   * in the given graphical context
   * @param mapping_p the mapping to use
   * @param semanticTarget_p the semantic element to represent with the mapping
   * @param graphicalContainer_p the graphical container for the new diagram element
   *        (DNodeContainer or DDiagram)
   * @return the diagram element being created, or null if failure
   */
  private AbstractDNode showElement(AbstractNodeMapping mapping_p,
      EObject semanticTarget_p, DContainer graphicalContainer_p) {
    AbstractDNode result = null;
    DDiagram diagram = SiriusUtil.getDiagram(graphicalContainer_p);
    ISemanticMapping<?> mapping = PatternCoreDiagramPlugin.getDefault().getSemanticMapping();
    EObject target = null;
    if(mapping instanceof ISiriusSemanticMapping){
      target = ((ISiriusSemanticMapping)mapping).getSemanticStorage(
          (DSemanticDecorator)graphicalContainer_p);
      try {
        if (((ISiriusSemanticMapping)mapping).conformsToMapping(
            semanticTarget_p, mapping_p, true, true, graphicalContainer_p)) {
          if (mapping_p instanceof IContainerMappingExt) {
            IInterpreter interpreter = SiriusPlugin.getDefault().getInterpreterRegistry().getInterpreter(semanticTarget_p);
            ContainerMappingHelper cmh = new ContainerMappingHelper(interpreter);
            result = cmh.createContainer((IContainerMappingExt)mapping_p, semanticTarget_p, target, diagram);
          } else if (mapping_p instanceof NodeMapping) {
            NodeMapping nm = (NodeMapping)mapping_p;
            result = nm.createNode(semanticTarget_p, target, diagram);
          }
        }
      } catch (Exception e) {
        // Viewpoint problem: cannot create view, return null
      }
    } 

    if (null != result) {
      if (graphicalContainer_p instanceof DNodeContainer) {
        // If inside a graphical container, put result in it
        ((DNodeContainer)graphicalContainer_p).getOwnedDiagramElements().add(result);
      } else {
        // Otherwise, put result in diagram
        diagram.getOwnedDiagramElements().add(result);
      }
      _pinHelper.markAsPinned(result);
    }
    return result;
  }
  
  /**
   * Return a map from the given semantic elements to corresponding decorators present
   * in the given diagram (possibly including the diagram itself)
   * @param semanticElements_p a non-null, potentially empty collection
   * @param a non-null diagram
   * @return a non-null, potentially empty, modifiable map
   */
  private EMap<EObject, DSemanticDecorator> getExistingDecorators(
      Collection<? extends EObject> semanticElements_p, DDiagram diagram_p) {
    EMap<EObject, DSemanticDecorator> result =
        new FHashMap<EObject, DSemanticDecorator>();
    // First check the diagram itself
    if (diagram_p instanceof DSemanticDecorator) {
      DSemanticDecorator semanticDiagram = (DSemanticDecorator)diagram_p;
      EObject diagramTarget = semanticDiagram.getTarget();
      if (diagramTarget != null && semanticElements_p.contains(diagramTarget))
        result.put(diagramTarget, semanticDiagram);
    }
    // Then check every semantic element
    for (EObject root : semanticElements_p) {
      Collection<AbstractDNode> nodes = getNodesInDiagram(root, diagram_p);
      if (!nodes.isEmpty())
        // Warning! This line ignores the fact that elements may be represented
        // several times within the same diagram by different nodes
        result.put(root, nodes.iterator().next());
    }
    return result;
  }

  /**
   * Return the set of Viewpoint nodes which represent the given semantic element
   * within the given diagram
   * @param element_p a non-null semantic element
   * @param diagram_p a non-null diagram
   * @return a non-null, possibly empty, unmodifiable set
   */
  private Collection<AbstractDNode> getNodesInDiagram(EObject element_p, DDiagram diagram_p) {
    Collection<AbstractDNode> result =
        new FOrderedSet<AbstractDNode>();
    Collection<DSemanticDecorator> decorators =
        SiriusLayersUtil.upSemanticToViewpoint(element_p);
    for (DSemanticDecorator decorator : decorators) {
      if (decorator instanceof AbstractDNode &&
          diagram_p == SiriusUtil.getDiagram(decorator))
        result.add((AbstractDNode)decorator);
    }
    return Collections.unmodifiableCollection(result);
  }
}
