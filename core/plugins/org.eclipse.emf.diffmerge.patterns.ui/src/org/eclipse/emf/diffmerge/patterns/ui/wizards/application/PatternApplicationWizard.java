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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.application;

import static org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind.DIAGRAM;
import static org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind.INSTANCE;
import static org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind.NONE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.CompoundModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractFilteredGraphicalUpdateOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractGraphicalWrappingInstanceOperation.RefreshRequestKind;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.engine.operations.ApplyTemplatePatternOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Point;


/**
 * A wizard for applying an existing pattern.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class PatternApplicationWizard extends AbstractPatternWizard<TemplatePatternApplicationSpecification> {

  /** An optional diagram to refresh eventually */
  protected final Object _diagramToRefresh;

  /** The graphical offset for multi-instantiation */
  protected static final int MULTI_INSTANCE_OFFSET = 10;

  
  /**
   * Constructor
   * @param sources_p the elements from which the pattern must be created
   * @param diagram_p an optional diagram where application occurs
   */
  public PatternApplicationWizard(List<? extends Object> sources_p, Object diagram_p) {
    super(new TemplatePatternApplicationSpecification(sources_p));
    _diagramToRefresh = diagram_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doAddPages()
   */
  @Override
  public void doAddPages() {
    addPage(new PatternApplicationPresentationPage(getData()));
    addPage(new PatternApplicationAssociationPage(getData(), _diagramToRefresh));
    setWindowTitle(Messages.PatternApplicationWizard_Header);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#doPerformFinish()
   */
  @Override
  protected boolean doPerformFinish() {
    Map<Object, Point> elementsLocationsMap = new Hashtable<Object, Point>();
    Map<Object, Object> elementsContainersMap = new Hashtable<Object, Object>();
    if(_diagramToRefresh != null){
      // Save current diagram elements locations
      for (Object diagramElement : _diagramUtil.getDiagramElements(_diagramToRefresh)) {
        if(_genericTypeUtil.isInstanceOfDiagramElementType(diagramElement)){
          elementsLocationsMap.put(diagramElement, _diagramUtil.getLocation(diagramElement));
        }
      }
      // Save diagram elements containers
      for (Object diagramElement: _diagramUtil.getDiagramElements(_diagramToRefresh)) {
        if(_genericTypeUtil.isInstanceOfDiagramElementType(diagramElement)){
          EObject container = _diagramUtil.getTechnicalContainerFor(diagramElement);
          if (_genericTypeUtil.isInstanceOfGraphicalContainerType(container)) {
            elementsContainersMap.put(diagramElement, container);
          } 
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
      Object globalTargetContext;
      if (_diagramToRefresh != null) {
        globalTargetContext = _diagramToRefresh;
      } else {
        globalTargetContext = applyOperations.get(0).getTargetContext();
      }
      AbstractGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>> mainOperation =
          instantiateGraphicalWrappingInstanceOperation(
              applyAllOperation, globalTargetContext, refreshRequest);
      List<? extends IPatternInstance> instances = execute(mainOperation);
      result = instances != null && !instances.isEmpty();
      // After execution of the main operation because the GMF/Doremi
      // synchronization happens in post-commit listeners
      ISemanticRuleProvider ruleProvider = null;
      ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(_diagramToRefresh);
      if (result && getData().mustReuseLayout() 
          && _diagramToRefresh != null
          && ! ruleProvider.isAutomaticallyUpdatedDiagram(_diagramToRefresh)) {
        @SuppressWarnings("null")
        List<AbstractFilteredGraphicalUpdateOperation> layoutOperations =
            new ArrayList<AbstractFilteredGraphicalUpdateOperation>(instances.size());
        final int xOffset = MULTI_INSTANCE_OFFSET, yOffset = MULTI_INSTANCE_OFFSET;
        int currentVx = 0, currentVy = 0;
        for (IPatternInstance instance : instances) {
          AbstractFilteredGraphicalUpdateOperation layoutOperation = instantiateLayoutReuseOperation(_diagramToRefresh, instance, elementsLocationsMap,
              elementsContainersMap, currentVx, currentVy, true, true, getData().getScopeElement());
          layoutOperations.add(layoutOperation);
          currentVx += xOffset;
          currentVy += yOffset;
        }
        execute(new CompoundModelOperation<Collection<Object>>(
            layoutOperations.get(0).getName(), layoutOperations, null, 
            layoutOperations.get(0).getTargetContext(), layoutOperations.get(0).getSourceContext()));
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.util.List, boolean)
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternApplicationSpecification> wizard_p,  
      List<Object> context_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, context_p, updatePattern_p);
    }
    return null;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard#instantiatePatternImageBuilderJob(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard, java.lang.String, boolean)
   */
  @Override
  protected Job instantiatePatternImageBuilderJob(AbstractPatternWizard<TemplatePatternApplicationSpecification> wizard_p,  
      String imageSpecification_p, boolean updatePattern_p){
    IPatternJobFactory factory = PatternsUIPlugin.getDefault().getJobFactory();
    if(factory != null){
      return factory.instantiatePatternImageBuilderJob(wizard_p, imageSpecification_p, updatePattern_p);
    }
    return null;
  }

  /**
   * Instantiates an operation that is responsible of representing a given set of semantic elements in a given diagram.
   */
  protected AbstractFilteredGraphicalUpdateOperation
  instantiateLayoutReuseOperation(Object diagram_p, IPatternInstance instance_p, Map<Object, Point> initialElementsLocationsMap_p,
      Map<Object, Object> elementsContainersMap_p, 
      int vx_p, int vy_p, boolean updateLayout_p, boolean updateStyle_p
      ,Object modelSideContext_p)
      {
    IPatternOperationFactory factory = PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    if(factory != null){
      return factory.instantiateLayoutReuseOperation(diagram_p, instance_p, initialElementsLocationsMap_p, elementsContainersMap_p, vx_p, vy_p, updateLayout_p, updateStyle_p, modelSideContext_p);
    }
    return null;
      }

  /**
   * Instantiates a concrete AbstractGraphicalWrappingInstanceOperation
   */
  protected  AbstractGraphicalWrappingInstanceOperation<List<? extends IPatternInstance>> 
  instantiateGraphicalWrappingInstanceOperation(IModelOperation<List<IPatternInstance>> operation_p, Object diagram_p, RefreshRequestKind refreshRequest_p){
    IPatternOperationFactory factory = PatternCoreDiagramPlugin.getDefault().getOperationFactory();
    if(factory != null){
      return factory.instantiateGraphicalWrappingInstanceOperation(operation_p, diagram_p, refreshRequest_p, true);
    }
    return null; 
  }

}
