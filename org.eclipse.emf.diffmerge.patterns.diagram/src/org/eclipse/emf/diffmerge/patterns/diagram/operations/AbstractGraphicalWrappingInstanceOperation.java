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
package org.eclipse.emf.diffmerge.patterns.diagram.operations;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.util.structures.FArrayList;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;


/**
 * A model operation that wraps an operation on a pattern instance and may perform different
 * kinds of refresh on a diagram to reflect the effect of the wrapped operation.
 * @author O. CONSTANT
 * @author S. TURKI
 */
public abstract class AbstractGraphicalWrappingInstanceOperation<F, DiagramType, DiagramElementType>
extends AbstractGraphicalWrappingOperation<F, F, DiagramType> {

  /** Kinds of graphical refresh to perform */
  public static enum RefreshRequestKind { NONE, DIAGRAM, INSTANCE }

  /** The non-null, potentially empty collection of pattern instances to refresh */
  private final Collection<IPatternInstance> _instances;

  /** The kind of refresh to perform in the end */
  private final RefreshRequestKind _refreshRequest;

  /** The non-null, potentially empty set of graphical elements created */
  private final Collection<DiagramElementType> _createdDiagramElements;


  /**
   * Constructor
   * @param operation_p a potentially null operation to wrap
   * @param diagram_p an optional diagram where refresh can happen
   * @param refreshRequest_p the non-null refresh request for this operation
   */
  public AbstractGraphicalWrappingInstanceOperation(IModelOperation<? extends F> operation_p,
      DiagramType diagram_p, RefreshRequestKind refreshRequest_p) {
    this(operation_p, null, diagram_p, refreshRequest_p);
  }

  /**
   * Constructor
   * @param operation_p a potentially null operation to wrap
   * @param instance_p an optional pattern instance to refresh
   * @param diagram_p an optional diagram where refresh can happen
   * @param refreshRequest_p the non-null refresh request for this operation
   */
  public AbstractGraphicalWrappingInstanceOperation(IModelOperation<? extends F> operation_p,
      IPatternInstance instance_p, DiagramType diagram_p, RefreshRequestKind refreshRequest_p) {
    super(operation_p, diagram_p);
    _instances = new FArrayList<IPatternInstance>();
    if (instance_p != null)
      _instances.add(instance_p);
    _refreshRequest = refreshRequest_p;
    _createdDiagramElements = new FOrderedSet<DiagramElementType>();
  }

  /**
   * Return the pattern instance to which is operation is relative
   * @return a potentially null pattern instance
   */
  public IPatternInstance getInstance() {
    return _instances.isEmpty()? null: _instances.iterator().next();
  }

  /**
   * Return the set of diagram elements created
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public Collection<DiagramElementType> getNewDiagramElements() {
    return Collections.unmodifiableCollection(_createdDiagramElements);
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  @SuppressWarnings({ "unchecked" })
  protected F run() {
    F result = null;
    if (getWrappedOperation() != null) {
      ISemanticRuleProvider semanticRuleProvider =
          TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(getTargetContext());
      semanticRuleProvider.reset();
      if (getWrappedOperation() instanceof AbstractModelOperation<?>)        
        ((AbstractModelOperation<?>)getWrappedOperation()).setModelEnvironment(getModelEnvironment());
      result = getWrappedOperation().run(getMonitor());
    }
    if (_instances.isEmpty()) {
      if (result instanceof IPatternInstance) {
        _instances.add((IPatternInstance)result);
      } else if (result instanceof Collection<?>) {
        for (Object o : (Collection<Object>)result) {
          if (o instanceof IPatternInstance)
            _instances.add((IPatternInstance)o);
        }
      }
    }
    List<EObject> roots = Collections.emptyList();
    if ((result != null || getWrappedOperation() == null) && getDiagram() != null) {
      switch(_refreshRequest) {
      case DIAGRAM:
        refreshDiagram();
        break;
      case INSTANCE:
        IPatternOperationFactory<? ,DiagramType> factory = 
        (IPatternOperationFactory<? ,DiagramType>) PatternCoreDiagramPlugin.getDefault().getOperationFactory();
        if(factory != null){
          for (IPatternInstance instance : _instances) {
            roots = TemplatePatternsUtil.getApplicationRoots(instance);
            AbstractDisplayOperation<DiagramType> displayOperation = factory.instantiateDisplayOperation(roots, getDiagram(), true);
            _createdDiagramElements.addAll((Collection<? extends DiagramElementType>) call(displayOperation));
          }
        }
        break;
      default:
      }
    }
    return result;
  }
  
  /**
   * Return the pattern instances
   * @return a non null collection of pattern instances
   */
  protected Collection<IPatternInstance> getInstances() {
    return _instances;
  }

  /**
   * Return the refresh request kind
   * @return a RefreshRequestKind
   */
  protected RefreshRequestKind getRefreshRequestkind(){
    return _refreshRequest;
  }
  
  /**
   * Return the created diagram elements
   * @return a non null collection of diagram elements
   */
  protected Collection<DiagramElementType> getCreatedDiagramElements() {
    return _createdDiagramElements;
  }
  
  /**
   * Refreshes diagram
   */
  protected abstract void refreshDiagram();

}
