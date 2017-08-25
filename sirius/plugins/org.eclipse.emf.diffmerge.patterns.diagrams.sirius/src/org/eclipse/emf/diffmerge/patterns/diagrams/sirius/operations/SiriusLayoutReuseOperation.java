/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractLayoutReuseOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.LayoutUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.SiriusLayersUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.tools.api.layout.PinHelper;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.graphics.Point;


/**
 * An operation for applying the graphical layout defined in a pattern on an instance.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SiriusLayoutReuseOperation extends SiriusFilteredGraphicalUpdateOperation {

  /** The non-null behaviour for pinning graphical elements */
  protected final PinHelper _pinHelper;

  /** A non-null map of initial locations of diagram elements */
  private final Map<Object, Point> _initialElementsLocationsMap;

  /** A non-null map of initial diagram elements containers */
  private final Map<Object, Object> _initialElementsContainersMap;

  /** Casted innerGraphicalOperation */
  private InnerLayoutReuseOperation _innerLayoutReuseOperation;

  /** The roots diagram elements */
  protected Collection<DDiagramElement> _roots;

  /**
   * Constructor
   * @param diagram_p the non-null diagram to update
   * @param instance_p the non-null instance whose elements must be highlighted
   */
  public SiriusLayoutReuseOperation(Object diagram_p, IPatternInstance instance_p, Map<Object, Point> initialElementsLocationsMap_p,
      Map<Object, Object> elementsContainersMap_p, int vx_p, int vy_p, boolean updateLayout_p, boolean updateStyle_p, 
      Object sourceContext_p) {
    super(AbstractLayoutReuseOperation.getName(), diagram_p, instance_p, true, sourceContext_p);
    _pinHelper = new PinHelper();
    _initialElementsLocationsMap = initialElementsLocationsMap_p;
    _initialElementsContainersMap = elementsContainersMap_p;
    _innerGraphicalOperation = new InnerLayoutReuseOperation(instance_p, updateLayout_p, updateStyle_p);
    _innerLayoutReuseOperation = (InnerLayoutReuseOperation) _innerGraphicalOperation;
    setVector(vx_p, vy_p);
  }

  /**
   * Constructor
   * @param diagramElements_p the non-null, potentially empty set of diagram elements to update
   * @param instance_p the non-null instance whose elements must be highlighted
   */
  public SiriusLayoutReuseOperation(Collection<Object> diagramElements_p, IPatternInstance instance_p,
      Map<Object, Point> initialElementsLocationsMap_p, Map<Object, Object> elementsContainersMap_p, 
      int vx_p, int vy_p,
      boolean updateLayout_p, boolean updateStyle_p, 
      Object sourceContext_p) {
    super(AbstractLayoutReuseOperation.getName(), diagramElements_p, false, sourceContext_p);
    _pinHelper = new PinHelper();
    _initialElementsLocationsMap = initialElementsLocationsMap_p;
    _initialElementsContainersMap = elementsContainersMap_p;
    _innerGraphicalOperation = new InnerLayoutReuseOperation(instance_p, updateLayout_p, updateStyle_p);
    _innerLayoutReuseOperation = (InnerLayoutReuseOperation) _innerGraphicalOperation;
    setVector(vx_p, vy_p);
  }

  /**
   * Set the vector to apply to the layout
   */
  public void setVector(int vx_p, int vy_p) {
    _innerLayoutReuseOperation.setVectorX(vx_p);
    _innerLayoutReuseOperation.setVectorY(vy_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation#update(java.lang.Object, boolean)
   */
  @Override
  protected void update(Object decorator_p, boolean isMerged) {
    _innerLayoutReuseOperation.update(decorator_p, isMerged); 
  }
  
  /**
   * Return whether the given element represents a merged semantic element
   * @param target_p a potentially null element
   */
  private boolean isMerged(EObject target_p) {
    List<EObject> mergedElements = LocationsUtil.getMergeTargets(_innerLayoutReuseOperation.getInstance());
    if (target_p instanceof DSemanticDecorator) {
      DSemanticDecorator decorator = (DSemanticDecorator) target_p;
      if (mergedElements.contains(decorator.getTarget())) {
        return true;
      }
    }
    return false;
  }


  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  public Collection<Object> run() {  
    Collection<Object> result = new FOrderedSet<Object>();
    boolean updated = false;
    // Get diagram elements that should be updated
    Collection<DDiagramElement> toUpdate = getDiagramElementsToUpdate();    
    // Get higher hierarchical level elements from toUpdate list
    _roots = getHigherHierachicalElements(toUpdate);
    // Get merged elements list : They should not be moved
    List<DDiagramElement> mergedElements = getMergedElementsFromList(toUpdate);
    // Get reference element from (roots U mergedElements) if it is not empty, which should never happen
    DDiagramElement referenceElement = null;
    if(!_roots.isEmpty()){
      referenceElement = getReferenceElementFromList(_roots, mergedElements);
    }else{
      // Should never enter here
      assert(!toUpdate.isEmpty());
      if( toUpdate.iterator().hasNext())
        referenceElement = toUpdate.iterator().next();
    }

    // Start the update
    // Diagram
    if (_diagram instanceof DSemanticDecorator) {
      updated = checkUpdate(_diagram, false);
      if (updated) {
        result.add(_diagram);
      }
    }
    // Diagram elements
    for (DDiagramElement diagramElement : toUpdate) {
      updated = checkUpdate(diagramElement, isMerged(diagramElement));
      if (updated) {
        result.add(diagramElement);
      }
    }

    //Calculate translation vector: depends on whether the refenceElmeent is a merged element or not
    // At this point referenceElement should never be null
    Point translationVector = new Point(0, 0);
    if(isMerged(referenceElement) && !_initialElementsLocationsMap.isEmpty()){
      if(_diagramUtil != null ){
        Point initialRefElemLocation = _initialElementsLocationsMap.get(referenceElement);
        Point currentRefElemLocation = _diagramUtil.getLocation(referenceElement);
        if ((initialRefElemLocation != null) && (currentRefElemLocation != null)) {
          translationVector = new Point(initialRefElemLocation.x - currentRefElemLocation.x, initialRefElemLocation.y - currentRefElemLocation.y);
        }
      }

      ////////////////////////////////

      // reset all merged elements locations
      List<DDiagramElement> finalPosElementsList = new ArrayList<DDiagramElement>();
      for (DDiagramElement diagramElement : mergedElements) {
        // reset all merged elements locations if their container did not change
        if (diagramElement.eContainer() == _initialElementsContainersMap.get(diagramElement)) {
          LayoutUtil.setLocation(diagramElement, _initialElementsLocationsMap.get(diagramElement));
        } else {
          LayoutUtil.setLocation(diagramElement, new Point(10, 10));
          if (diagramElement.eContainer() instanceof DDiagramElement) {
            LayoutUtil.setLocation((DDiagramElement) diagramElement.eContainer(), _initialElementsLocationsMap.get(diagramElement));
            finalPosElementsList.add((DDiagramElement) diagramElement.eContainer());
          }
        }
      }
      // rearrange non-merged elements locations
      for (DDiagramElement diagramElement : toUpdate) {
        if (LayoutUtil.isInstanceParticipant(diagramElement, _innerLayoutReuseOperation.getInstance().getElements())) {
          if (!isMerged(diagramElement) && !finalPosElementsList.contains(diagramElement)) {
            if (_roots.contains(diagramElement)) {
              // is a higher level element
              DDiagramElement localRefElement = LayoutUtil.getLocalReferenceLocation(diagramElement, mergedElements);
              if (localRefElement == null) {
                Point newPosition = _diagramUtil.getLocation(diagramElement);
                newPosition.x += translationVector.x;
                newPosition.y += translationVector.y;
                LayoutUtil.setLocation(diagramElement, newPosition);
              } else {
                Point newPosition = _diagramUtil.getLocation(diagramElement);
                Point initialLocalRefElemLocation = _initialElementsLocationsMap.get(localRefElement);
                Point currentLocalRefElemLocation = _diagramUtil.getLocation(localRefElement);
                // translationVector = new Point(initialRefElemLocation.x - currentRefElemLocation.x, initialRefElemLocation.y - currentRefElemLocation.y);
                if ((initialLocalRefElemLocation != null) && (currentLocalRefElemLocation != null)) {
                  translationVector =
                      new Point(initialLocalRefElemLocation.x - currentLocalRefElemLocation.x, initialLocalRefElemLocation.y - currentLocalRefElemLocation.y);
                }
                newPosition.x += translationVector.x;
                newPosition.y += translationVector.y;
                LayoutUtil.setLocation(diagramElement, newPosition);
              }
            }
          }
        } else {
          if (diagramElement instanceof AbstractDNode) {
            AbstractDNode dnode = (AbstractDNode) diagramElement;
            LayoutUtil.setLocation(dnode, _initialElementsLocationsMap.get(dnode));
          }
        }
      }      
    }
    return Collections.unmodifiableCollection(result);
  }

  /**
   * Returns a new list containing merged elements among given list
   * @param list_p
   * @return
   */
  private List<DDiagramElement> getMergedElementsFromList(
      Collection<DDiagramElement> list_p) {
    List<DDiagramElement> mergedElements = new ArrayList<DDiagramElement>();
    for (DDiagramElement diagramElement : list_p) {
      if (isMerged(diagramElement)) {
        mergedElements.add(diagramElement);
      }
    }
    return mergedElements;
  }

  /**
   * Returns a reference element from the mergedElements or roots lists. Merged Node elements are chosen in priority. 
   * Among them, nodes are given priority.
   * Then priority is given to the first one.
   * @param roots a non-empty list
   * @return a non-null DDiagramElement
   */
  private DDiagramElement getReferenceElementFromList(Collection<DDiagramElement> roots_p
      , Collection<DDiagramElement> mergedElements_p) {
    DDiagramElement result = null;
    //equalPriorityElements is the list in which we will add all the elements 
    // that are final candidates with equal priority (see Javadoc above)
    Collection<DDiagramElement> equalPriorityElements = new ArrayList<DDiagramElement>();
    //Two cases: We have found merged elements or no
    if(!mergedElements_p.isEmpty()){
      // Give priority to nodes
      Collection<DDiagramElement> mergedNodes = new ArrayList<DDiagramElement>();
      for(DDiagramElement mergedElement: mergedElements_p){
        if(mergedElement instanceof AbstractDNode){
          mergedNodes.add(mergedElement);
        }
      }
      //Two cases: We have found merged nodes or no
      if(!mergedNodes.isEmpty()){
        equalPriorityElements.addAll(mergedNodes);
      }else{
        //Nothing
      }
    }else{
      Collection<DDiagramElement> nonMergedNodes = new ArrayList<DDiagramElement>();
      for(DDiagramElement nonMergedElement: roots_p){
        if(nonMergedElement instanceof AbstractDNode){
          nonMergedNodes.add(nonMergedElement);
        }
      }
      //Two cases: We have found non merged root nodes or no
      if(!nonMergedNodes.isEmpty()){
        equalPriorityElements.addAll(nonMergedNodes);
      }else{
        equalPriorityElements.addAll(roots_p);
      }
    }
    //Finally : choose from the equalPriorityElements the first one.
    result = (DDiagramElement)equalPriorityElements.toArray()[0];
    return result;
  }

  /**
   * Returns the elements of the instance that are at the higher hierarchical level
   * @return a non-null List of diagram elements
   */
  private Collection<DDiagramElement> getHigherHierachicalElements(Collection<DDiagramElement> inputList_p) {
    Collection<DDiagramElement> result = new ArrayList<DDiagramElement>();
    //filter list
    Iterator<DDiagramElement> it = inputList_p.iterator();
    while(it.hasNext()){
      DDiagramElement current = it.next();
      if(LayoutUtil.isHigherLevelDiagramElementInList(current, inputList_p)){
        result.add(current);
      }
    }
    return result;
  }

  /**
   * Returns the diagram elements whose layout should be updated
   * @return a non-null List of diagram elements
   */
  private Collection<DDiagramElement> getDiagramElementsToUpdate() {
    List<DDiagramElement> result = new ArrayList<DDiagramElement>();
    List<?> initial = _diagramElements != null ? getAllDiagramElements(_diagramElements) : _diagramUtil.getDiagramElements(_diagram);
    //filter list
    Iterator<?> it = initial.iterator();
    while(it.hasNext()){
      Object current = it.next();
      if(current instanceof DDiagramElement){ 
        if(LayoutUtil.isInstanceParticipant((DDiagramElement)current, _innerLayoutReuseOperation.getInstance().getElements())){
          result.add((DDiagramElement)current);
        }
      }
    }
    return result;
  }

  /**
   * Inner class, simulates multiple inheritance of SiriusLayoutReuseOperation --> (AbstractLayoutReuseOperation, SiriusFilteredGraphicalUpdateOperation)
   * @author Skander Turki
   *
   */
  protected class InnerLayoutReuseOperation extends AbstractLayoutReuseOperation{
    /**
     * Constructor
     * @param instance_p a non-null instance
     * @param updateLayout_p whether the layout must be updated
     * @param updateStyle_p whether the style must be updated
     */
    public InnerLayoutReuseOperation(IPatternInstance instance_p,
        boolean updateLayout_p, boolean updateStyle_p) {
      super(instance_p, updateLayout_p, updateStyle_p);
      //      //      //Fix: reload instance when eResource is null
      //      if(get_instance() instanceof AbstractPatternInstance){
      //        AbstractPatternInstance inst = (AbstractPatternInstance)get_instance();
      //        if(inst.eResource() == null){
      //          EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(getModelSideContext());
      //          if(domain != null)
      //            CorePatternsPlugin.getDefault().getIdProvider().getById(inst.getId(), domain.getResourceSet().getResources());
      //        }
      //      }
    }
    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalUpdateOperation#update(java.lang.Object, boolean)
     */
    @Override
    public void update(Object object_p, boolean isMerged) {
      if(object_p instanceof DSemanticDecorator){
        DSemanticDecorator decorator = (DSemanticDecorator)object_p;
        // Apply the update
        if ((getInstance().getPattern() instanceof TemplatePattern) && (getInstance().getPatternData() instanceof TemplatePatternData)) {
          TemplatePattern pattern = (TemplatePattern) getInstance().getPattern();
          if (!pattern.getLayoutData().isEmpty()) {
            TemplatePatternData data = (TemplatePatternData) getInstance().getPatternData();
            EObject semanticElement = SiriusLayersUtil.downViewpointToSemantic(decorator);
            if (semanticElement != null) {
              EObject templateElement = data.getCounterpart(semanticElement, false);
              Layout layout = pattern.getLayoutData().get(templateElement);
              if (layout instanceof NodeLayout) {
                NodeLayout nodeLayout = (NodeLayout) layout;
                List<View> views = SiriusLayersUtil.upViewpointToGmf(decorator);
                if (!views.isEmpty() && (views.get(0) instanceof Node)) {
                  Node node = (Node) views.get(0);
                  LayoutConstraint constraint = node.getLayoutConstraint();
                  if (isUpdateStyle()) {
                    // Apply font style
                    if (nodeLayout.getFontStyle() != null) {
                      LayoutUtil.applyAbstractDNodePatternFontStyle(nodeLayout.getFontStyle(), node);
                    }

                    // Apply node style
                    if (nodeLayout.getOwnedStyle() != null) {
                      LayoutUtil.applyNodePatternStyleToDNode(nodeLayout.getOwnedStyle(), node);
                    }
                  }
                  if (isUpdateLayout()) {
                    if (constraint instanceof Bounds) {
                      Bounds bounds = (Bounds) constraint;
                      LayoutUtil.nodeLayoutToBounds(nodeLayout, bounds);
                      if (_roots.contains(decorator)) {
                        LayoutUtil.applyVector(bounds, getVectorX(), getVectorY());
                      }else{
                        LayoutUtil.applyVector(bounds, 0, 0);
                      }
                      if (decorator instanceof DDiagramElement) {
                        _pinHelper.markAsPinned((DDiagramElement) decorator);
                      }
                    }
                  }
                }
              } else if (layout instanceof EdgeLayout) {
                EdgeLayout edgeLayout = (EdgeLayout) layout;
                List<View> views = SiriusLayersUtil.upViewpointToGmf(decorator);
                if (!views.isEmpty() && (views.get(0) instanceof Edge)) {
                  Edge edge = (Edge) views.get(0);
                  // Apply Layout to Edge
                  LayoutUtil.applyEdgeLayout(edge, edgeLayout);
                  // Apply edge style
                  if (isUpdateStyle()) {
                    LayoutUtil.applyEdgeStyle(edge, edgeLayout);
                  }

                  if (decorator instanceof DDiagramElement) {
                    _pinHelper.markAsPinned((DDiagramElement) decorator);
                  }
                }
              }
            }
          }
        }
      }
  
    }
  }


}
