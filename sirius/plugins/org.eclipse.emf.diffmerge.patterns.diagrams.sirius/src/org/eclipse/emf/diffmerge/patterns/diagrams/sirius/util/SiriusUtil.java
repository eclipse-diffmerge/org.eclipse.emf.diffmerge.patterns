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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.business.api.componentization.DiagramComponentizationManager;
import org.eclipse.sirius.diagram.business.internal.metamodel.description.operations.SiriusElementMappingSpecOperations;
import org.eclipse.sirius.diagram.business.internal.metamodel.helper.DiagramElementMappingHelper;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.ContainerMappingImport;
import org.eclipse.sirius.diagram.description.DescriptionPackage;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.description.NodeMappingImport;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessorsRegistry;
import org.eclipse.sirius.tools.api.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.AbstractMappingImport;
import org.eclipse.sirius.viewpoint.description.Viewpoint;


/**
 * Utility class providing services related to Viewpoint concepts
 * @author Olivier Constant
 */
@SuppressWarnings("restriction")
public final class SiriusUtil {
  
  /**
   * Constructor
   */
	private SiriusUtil() {
	  //Forbids instantiation
	}
  
  /**
   * Return whether the given element conforms to the given mapping's requirements.
   * Criteria: domain class, precondition expression, semantic candidates expression.
   * For precondition and semantic candidates to be considered, the target semantic
   * element must belong to the model of the semantic target of the container view.
   * @param semanticElt_p the semantic element to test against the given mapping
   * @param mapping_p the mapping to test again the given semantic element
   * @param considerPrecondition_p whether the precondition of the mapping must be tested
   * @param considerCandidates_p whether the semantic candidates expression of the mapping
   *        must be taken into account
   * @param graphicalContainer_p the (optional) expected graphical container of: the node
   *        which would be created by instantiation of the given mapping on the given
   *        semantic element
   */
  public static boolean conformsToMapping(EObject semanticElt_p, AbstractNodeMapping mapping_p,
      boolean considerPrecondition_p, boolean considerCandidates_p, Object graphicalContainer_p) {
    boolean result = false;
    if((graphicalContainer_p instanceof DDiagram) || (graphicalContainer_p instanceof DDiagramElementContainer) ){
    	EObject container = (EObject) graphicalContainer_p;
      //ModelAccessorsRegistry reg = ViewpointPlugin.getDefault().getModelAccessorRegistry();
      ModelAccessorsRegistry reg = SiriusPlugin.getDefault().getModelAccessorRegistry();
      ModelAccessor accessor = reg.getModelAccessor(semanticElt_p);
      // Check domain class
      if (null != accessor) {
        String domainClass = mapping_p.getDomainClass();
        result = accessor.eInstanceOf(semanticElt_p, domainClass);
        EObject semanticOfGraphicalContainer = SiriusLayersUtil.getSemanticElement(container);
        // Check precondition
        if (result && considerPrecondition_p) {
          result = SiriusElementMappingSpecOperations.checkPrecondition(
              mapping_p, semanticElt_p, semanticOfGraphicalContainer, container);
        }
        // Check semantic candidates
        if (result && considerCandidates_p) {
          if (mapping_p instanceof NodeMapping || mapping_p instanceof ContainerMapping) {
            DDiagram diagram = graphicalContainer_p instanceof DDiagram ? (DDiagram) graphicalContainer_p : ((DDiagramElementContainer) graphicalContainer_p).getParentDiagram();
            Iterator<EObject> iterator = DiagramElementMappingHelper.getSemanticIterator(mapping_p, semanticOfGraphicalContainer, diagram);
            if (iterator != null) {
              return streamIterator(iterator).anyMatch(x -> x.equals(semanticElt_p));
            }
          }
        }
      }
    }
    return result;
  }
  
  static <T> Stream<T> streamIterator(final Iterator<T> iterator) {
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
  }
  
  /**
   * Get all mappings which are directly applicable within the given graphical context
   * @param graphicalContainer_p a non-null graphical container
   * @return a non-null, potentially empty, unmodifiable set
   */
  public static UniqueEList<AbstractNodeMapping> getApplicableMappingsIn(
		  EObject graphicalContainer_p) {
    UniqueEList<AbstractNodeMapping> result = null;
    if (graphicalContainer_p instanceof DDiagram)
      result = getApplicableMappingsInDiagram((DDiagram)graphicalContainer_p);
    else if (graphicalContainer_p instanceof DNodeContainer)
      result = getApplicableMappingsInContainer((DNodeContainer)graphicalContainer_p);
    else
      result = new UniqueEList<AbstractNodeMapping>();
    return result;
  }
  
  /**
   * Get all mappings which are directly applicable within a diagram
   * @param diagram_p a non-null diagram
   * @return a non-null, potentially empty, unmodifiable set
   */
  private static UniqueEList<AbstractNodeMapping> getApplicableMappingsInDiagram(
      DDiagram diagram_p) {
    UniqueEList<AbstractNodeMapping> result = new UniqueEList<AbstractNodeMapping>();
    DiagramDescription desc = diagram_p.getDescription();
    result.addAll(desc.getContainerMappings());
    result.addAll(desc.getNodeMappings());
    for(DiagramElementMapping reusedMapping : desc.getReusedMappings()) {
      if (reusedMapping instanceof AbstractNodeMapping) {
        result.add((AbstractNodeMapping)reusedMapping);
      }
    }
    // For all layers of the DiagramDescription, get all
    // AbstractNodeMappings which deal with the root of diagrams
    Session session = SessionManager.INSTANCE.getSession(diagram_p); // Must be non-null in this context
    Collection<Viewpoint> selectedViewpoints = session.getSelectedViewpoints(false);
    EList<Layer> layers = new DiagramComponentizationManager().getAllLayers(
        selectedViewpoints, diagram_p.getDescription());
    for(Layer layer : layers) {
      result.addAll(layer.getContainerMappings());
      result.addAll(layer.getNodeMappings());
      for(DiagramElementMapping reusedMapping : layer.getReusedMappings()) {
        if (reusedMapping instanceof AbstractNodeMapping) {
          result.add((AbstractNodeMapping)reusedMapping);
        }
      }
    }
    return result;
  }
  
  /**
   * Return the set of diagram elements recursively contained in the given
   * initial set
   * @param roots_p a non-null, potentially empty set of diagram elements
   * @return a non-null, potentially empty set of diagram elements
   */
  public static List<Object> getAllDiagramElements(Collection<Object> roots_p) {
    List<Object> result = new LinkedList<Object>(roots_p);
    for (Object root : roots_p) {
      if(root instanceof DDiagramElement){
        getAllDiagramElementsRec((DDiagramElement)root, result);
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Add in the given collection the diagram elements recusrively contained
   * in the given diagram element
   * @param root_p a non-null diagram element
   * @param result_p a non-null, modifiable list
   */
  private static void getAllDiagramElementsRec(DDiagramElement root_p,
      List<Object> result_p) {
    if (root_p instanceof AbstractDNode) {
      AbstractDNode aNode = (AbstractDNode)root_p;
      result_p.addAll(aNode.getOwnedBorderedNodes());
      if (aNode instanceof DDiagramElementContainer) {
        DDiagramElementContainer container = (DDiagramElementContainer)aNode;
        result_p.addAll(container.getNodes());
        List<DDiagramElementContainer> subContainers = container.getContainers();
        result_p.addAll(subContainers);
        for (DDiagramElementContainer subContainer : subContainers)
          getAllDiagramElementsRec(subContainer, result_p);
      }
    }
  }
  
  /**
   * Get all mappings which are directly applicable within a DNodeContainer
   * @param nodeContainer_p a non-null node container
   * @return a non-null, potentially empty, unmodifiable set
   */
  private static UniqueEList<AbstractNodeMapping> getApplicableMappingsInContainer(
      DNodeContainer nodeContainer_p) {
    UniqueEList<AbstractNodeMapping> result = new UniqueEList<AbstractNodeMapping>();
    ContainerMapping mapping = nodeContainer_p.getActualMapping();
    result.addAll(mapping.getReusedNodeMappings());
    result.addAll(mapping.getSubNodeMappings());
    result.addAll(mapping.getReusedContainerMappings());
    result.addAll(mapping.getSubContainerMappings());
    return result;
  }
  
  /**
   * Return the DDiagram which is the parent of the given Viewpoint element, or the
   * Viewpoint element itself if it is a DDiagram
   * @param context_p a potentially null element
   * @return a potentially null diagram
   */
  public static DDiagram getDiagram(EObject context_p) {
    DDiagram result = null;
    if (context_p instanceof DDiagram) {
      result = (DDiagram)context_p;
    } else if (context_p instanceof DDiagramElement) {
      result = ((DDiagramElement)context_p).getParentDiagram();
    }
    return result;
  }
  
  /**
   * Return whether the given Viewpoint node is a bordered node
   * @param node_p a non-null node
   */
  public static boolean isBorderedNode(DNode node_p) {
    boolean result = false;
    NodeMapping mapping = node_p.getActualMapping();
    if (mapping != null)
      result = mapping.eContainmentFeature() ==
          DescriptionPackage.eINSTANCE.getAbstractNodeMapping_BorderedNodeMappings();
    return result;
  }
  
  /**
   * Reduce a set of mappings to the set of its leaves regarding the import hierarchy
   * @param mappings_p a non-null set of mappings
   * @return a non-null set of mappings
   */
  public static UniqueEList<AbstractNodeMapping> reduceByImport(
      Collection<AbstractNodeMapping> mappings_p) {
    UniqueEList<AbstractNodeMapping> result =
      new UniqueEList<AbstractNodeMapping>(mappings_p);
    for(AbstractNodeMapping mapping : mappings_p) {
      if (mapping instanceof AbstractMappingImport) {
        AbstractMappingImport importMapping = (AbstractMappingImport)mapping;
        AbstractNodeMapping imported = null;
        if (importMapping instanceof NodeMappingImport)
          imported = ((NodeMappingImport)importMapping).getImportedMapping();
        else if (importMapping instanceof ContainerMappingImport)
          imported = ((ContainerMappingImport)importMapping).getImportedMapping();
        if (null != imported) result.remove(imported);
      }
    }
    return result;
  }
   
  /**
   * Refresh the given diagram
   */
  public static boolean refreshDiagram(DDiagram diagram_p) {
    boolean result = false;
    if (diagram_p != null) {
      DialectManager.INSTANCE.refresh(diagram_p, new NullProgressMonitor());
      result = true;
    }
    return result;
  }
    
}
