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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.application;

import static org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind.DIAGRAM;
import static org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind.INSTANCE;
import static org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind.NONE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.emf.diffmerge.patterns.core.operations.CompoundModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.operations.ApplyTemplatePatternOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternPageFactory;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Point;

/**
 * A wizard for applying an existing pattern.
 * @author O. CONSTANT
 */
public abstract class AbstractPatternApplicationWizard<ColorType, DiagramElementType, 
DiagramType, GraphicalContainerType, GraphicalPartType, SemanticRepresentationType, GraphicalNodeType> 
extends AbstractPatternWizard<TemplatePatternApplicationSpecification, GraphicalPartType> {


  /** An optional diagram to refresh eventually */
  protected final DiagramType _diagramToRefresh;

  /** The graphical offset for multi-instantiation */
  protected static final int MULTI_INSTANCE_OFFSET = 10;

  /**
   * Constructor
   * @param sources_p the elements from which the pattern must be created
   * @param diagram_p an optional diagram where application occurs
   */
  public AbstractPatternApplicationWizard(List<? extends Object> sources_p, DiagramType diagram_p) {
    super(new TemplatePatternApplicationSpecification(sources_p));
    _diagramToRefresh = diagram_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doAddPages()
   */
  @Override
  public void doAddPages() {
    addPage(instantiatePatternApplicationPresentationPage(getData()));
    addPage(instantiatePatternApplicationAssociationPage());
    setWindowTitle(Messages.PatternApplicationWizard_Header);
  }

//  /**
//   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doPerformFinish()
//   */
//  @SuppressWarnings("unchecked")
//  protected boolean doPerformFinish2() {
//    Map<DiagramElementType, Point> elementsLocationsMap = new Hashtable<DiagramElementType, Point>();
//    Map<DiagramElementType, GraphicalContainerType> elementsContainersMap = new Hashtable<DiagramElementType, GraphicalContainerType>();
//    AbstractDiagramUtil<DiagramElementType, DiagramType, GraphicalPartType> diagramUtil = (AbstractDiagramUtil<DiagramElementType, DiagramType, GraphicalPartType>) PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
//    AbstractGenericTypeUtil genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
//    if(_diagramToRefresh != null && genericTypeUtil != null && diagramUtil != null){
//      // Save current diagram elements locations
//      for (DiagramElementType diagramElement : diagramUtil.getDiagramElements(_diagramToRefresh)) {
//        elementsLocationsMap.put(diagramElement, diagramUtil.getLocation(diagramElement));
//      }
//      // Save diagram elements containers
//      for (DiagramElementType diagramElement : diagramUtil.getDiagramElements(_diagramToRefresh)) {
//        EObject container = diagramUtil.getTechnicalContainerFor(diagramElement);
//        if (genericTypeUtil.isInstanceOfGraphicalContainerType(container)) {
//          elementsContainersMap.put(diagramElement, (GraphicalContainerType) container);
//        }
//      }
//    }
//    boolean result = false;
//    IPatternApplication application = getData().getApplication();
//    boolean unfold = getData().mustUnfoldWhenDone();
//    boolean display = getData().mustDisplayWhenDone();
//    RefreshRequestKind refreshRequest = display ? INSTANCE : unfold ? DIAGRAM : NONE;
//    // Create all instances before showing them all because of Doremi cache
//    // for candidate elements of mappings
//    IModelOperation applyNTimesOperation = new ApplyNTimesTemplatePatternOperation(application, unfold, getData().getNamingRule(), getData().getNumberOfApplications(), getData().getMultiplicity(), getData().getPattern(), getData().getScopeElement());
//    AbstractGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>, DiagramType, DiagramElementType, GraphicalNodeType> mainOperation =
//        instantiateGraphicalWrappingInstanceOperation(applyNTimesOperation, _diagramToRefresh, refreshRequest);
//    List<IPatternInstance> instances = (List<IPatternInstance>) execute(mainOperation);
//
//    //ReuseLayout
//    result = !instances.isEmpty();
//    if (result && (getData().mustReuseLayout() || getData().mustReuseStyle()) && (_diagramToRefresh != null)) {
//      reuseLayout(instances, elementsLocationsMap, elementsContainersMap);
//    }
//    return result;
//  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doPerformFinish()
   */
  @Override
  @SuppressWarnings("unchecked")
  protected boolean doPerformFinish() {
    Map<DiagramElementType, Point> elementsLocationsMap = new Hashtable<DiagramElementType, Point>();
    Map<DiagramElementType, GraphicalContainerType> elementsContainersMap = new Hashtable<DiagramElementType, GraphicalContainerType>();
    AbstractDiagramUtil<DiagramElementType, DiagramType, GraphicalPartType> diagramUtil = (AbstractDiagramUtil<DiagramElementType, DiagramType, GraphicalPartType>) PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    AbstractGenericTypeUtil genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
    if(_diagramToRefresh != null && genericTypeUtil != null && diagramUtil != null){
      // Save current diagram elements locations
      for (DiagramElementType diagramElement : diagramUtil.getDiagramElements(_diagramToRefresh)) {
        elementsLocationsMap.put(diagramElement, diagramUtil.getLocation(diagramElement));
      }
      // Save diagram elements containers
      for (DiagramElementType diagramElement : diagramUtil.getDiagramElements(_diagramToRefresh)) {
        EObject container = diagramUtil.getTechnicalContainerFor(diagramElement);
        if (genericTypeUtil.isInstanceOfGraphicalContainerType(container)) {
          elementsContainersMap.put(diagramElement, (GraphicalContainerType) container);
        }
      }
    }
    boolean result = false;
    IPatternApplication application = getData().getApplication();
    boolean unfold = getData().mustUnfoldWhenDone();
    boolean display = getData().mustDisplayWhenDone();
    RefreshRequestKind refreshRequest = display ? INSTANCE : unfold ? DIAGRAM : NONE;
    final int NB = getData().getNumberOfApplications();
    // Create all instances before showing them all because of Doremi cache
    // for candidate elements of mappings
    List<IModelOperation<IPatternInstance>> applyOperations =
        new ArrayList<IModelOperation<IPatternInstance>>(NB);
      for (int i = 1; i <= NB; i++) {
        IModelOperation<IPatternInstance> mainOperation =
          new ApplyTemplatePatternOperation(
              application, unfold, getData().getNamingRule(), i, getData().getMultiplicity()
              , getData().getPattern(), getData().getScopeElement());
        applyOperations.add(mainOperation);
      }
      if (!applyOperations.isEmpty()) {
        IModelOperation<List<IPatternInstance>> applyAllOperation =
          new CompoundModelOperation<IPatternInstance>(
            applyOperations.get(0).getName(), applyOperations, null,
            applyOperations.get(0).getTargetContext(), applyOperations.get(0).getSourceContext());
        AbstractGraphicalWrappingInstanceOperation mainOperation =
            instantiateGraphicalWrappingInstanceOperation(
              applyAllOperation, _diagramToRefresh, refreshRequest);
        List<IPatternInstance> instances = execute(mainOperation);
        result = instances != null && !instances.isEmpty();
        if (result && getData().mustReuseLayout() && _diagramToRefresh != null) {
          // After execution of the main operation because the GMF/Doremi
          // synchronization happens in post-commit listeners
          List<AbstractFilteredGraphicalUpdateOperation> layoutOperations =
            new ArrayList<AbstractFilteredGraphicalUpdateOperation>(instances.size());
          final int xOffset = MULTI_INSTANCE_OFFSET, yOffset = MULTI_INSTANCE_OFFSET;
          int currentVx = 0, currentVy = 0;
          for (IPatternInstance instance : instances) {
            AbstractFilteredGraphicalUpdateOperation<SemanticRepresentationType, DiagramType, DiagramElementType> layoutOperation = instantiateLayoutReuseOperation(_diagramToRefresh, instance, elementsLocationsMap,
                elementsContainersMap, currentVx, currentVy, true, true, getData().getScopeElement());
            layoutOperations.add(layoutOperation);
            currentVx += xOffset;
            currentVy += yOffset;
          }
          execute(new CompoundModelOperation<Collection<SemanticRepresentationType>>(
              layoutOperations.get(0).getName(), (List<? extends IModelOperation<? extends Collection<SemanticRepresentationType>>>) layoutOperations
              , null, layoutOperations.get(0).getTargetContext(), layoutOperations.get(0).getSourceContext()));
        }
      }
      return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.util.List, boolean)
   */
  @SuppressWarnings("unchecked")
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternApplicationSpecification, GraphicalPartType> wizard_p,  
      List<? extends GraphicalPartType> context_p, boolean updatePattern_p){
    IPatternJobFactory<GraphicalPartType> factory = 
        (IPatternJobFactory<GraphicalPartType>) PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, context_p, updatePattern_p);
    }
    return null;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.lang.String, boolean)
   */
  @SuppressWarnings("unchecked")
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternApplicationSpecification, GraphicalPartType> wizard_p,  
      String imageSpecification_p, boolean updatePattern_p){
    IPatternJobFactory<GraphicalPartType> factory = 
        (IPatternJobFactory<GraphicalPartType>) PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, imageSpecification_p, updatePattern_p);
    }
    return null;
  }

  /**
   * Instantiates an operation that is responsible of representing a given set of semantic elements in a given diagram.
   */
  protected AbstractFilteredGraphicalUpdateOperation<SemanticRepresentationType, DiagramType, DiagramElementType> 
  instantiateLayoutReuseOperation(DiagramType diagram_p, IPatternInstance instance_p, Map<DiagramElementType, Point> initialElementsLocationsMap_p,
      Map<DiagramElementType, GraphicalContainerType> elementsContainersMap_p, 
      int vx_p, int vy_p, boolean updateLayout_p, boolean updateStyle_p
      ,Object modelSideContext_p)
      {
    @SuppressWarnings("unchecked")
    IPatternOperationFactory<GraphicalPartType, GraphicalNodeType, DiagramElementType, DiagramType, GraphicalContainerType, SemanticRepresentationType> factory = 
    (IPatternOperationFactory<GraphicalPartType, GraphicalNodeType, DiagramElementType, DiagramType, GraphicalContainerType, SemanticRepresentationType>) PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    if(factory != null){
      return factory.instantiateLayoutReuseOperation(diagram_p, instance_p, initialElementsLocationsMap_p, elementsContainersMap_p, vx_p, vy_p, updateLayout_p, updateStyle_p, modelSideContext_p);
    }
    return null;
      }

  /**
   * Instantiates a concrete AbstractGraphicalWrappingInstanceOperation
   */
  protected  AbstractGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>, DiagramType, DiagramElementType, GraphicalNodeType> 
  instantiateGraphicalWrappingInstanceOperation(IModelOperation<List<IPatternInstance>> operation_p, DiagramType diagram_p, RefreshRequestKind refreshRequest_p){
    @SuppressWarnings("unchecked")
    IPatternOperationFactory<GraphicalPartType, GraphicalNodeType, DiagramElementType, DiagramType, GraphicalContainerType, SemanticRepresentationType> factory =
    (IPatternOperationFactory<GraphicalPartType, GraphicalNodeType, DiagramElementType, DiagramType, GraphicalContainerType, SemanticRepresentationType>)  PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    if(factory != null){
      return factory.instantiateGraphicalWrappingInstanceOperation(operation_p, diagram_p, refreshRequest_p, true);
    }
    return null; 
  }

  /**
   * Instantiates a PatternApplicationPresentationPage
   */
  protected AbstractPatternApplicationPresentationPage<ColorType, DiagramElementType, 
  DiagramType, GraphicalContainerType, GraphicalPartType, SemanticRepresentationType, GraphicalNodeType>
  instantiatePatternApplicationPresentationPage(TemplatePatternApplicationSpecification data_p){
    AbstractPatternPageFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, GraphicalPartType, SemanticRepresentationType, GraphicalNodeType>
    factory = PatternsUIPlugin.getDefault().getPageFactory();
    if(factory != null){
      return factory.instantiatePatternApplicationPresentationPage(data_p);
    }
    return null;
  }

  /**
   * Returns a concrete PatternApplicationAssociationPage
   * @return a non-null AbstractPatternApplicationAssociationPage
   */
  protected AbstractPatternApplicationAssociationPage<DiagramType> 
  instantiatePatternApplicationAssociationPage(){
    AbstractPatternPageFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, GraphicalPartType, SemanticRepresentationType, GraphicalNodeType>
    factory = PatternsUIPlugin.getDefault().getPageFactory();
    if(factory != null){
      return factory.instantiatePatternApplicationAssociationPage(getData(), _diagramToRefresh);
    }
    return null;
  }



}
