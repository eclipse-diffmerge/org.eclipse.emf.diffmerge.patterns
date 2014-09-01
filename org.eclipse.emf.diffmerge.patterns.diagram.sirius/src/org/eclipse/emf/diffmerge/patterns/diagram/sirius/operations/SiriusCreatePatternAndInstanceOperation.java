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

import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.operations.CreateInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractCreatePatternAndInstanceLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractPatternWithLayoutOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.AddToCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.ecore.EObject;


/**
 * A model operation that consists in creating a template pattern, storing it in a repository
 * and returning an instance of this new pattern based on the original elements
 * @author Olivier Constant
 * @author Skander TURKI
 */
public class SiriusCreatePatternAndInstanceOperation
extends SiriusAbstractPatternWithLayoutOperation<IPatternInstance> {

  /**
   * Constructor
   * @param creationData_p a non-null specification for pattern creation
   * @param graphicalContext_p a non-null, potentially empty list of GEF elements
   */
  public SiriusCreatePatternAndInstanceOperation(
      TemplatePatternCreationSpecification creationData_p,
      List<Object> graphicalContext_p, Object patternContext_p) {
    super(AbstractCreatePatternAndInstanceLayoutOperation.getName(), creationData_p, 
        graphicalContext_p, patternContext_p);
    _innerPatternLayoutOperation = new InnerCreatePatternAndInstanceOperation();
  }

  /**
   * @see AbstractPatternWithLayoutOperation#getData()
   */
  @Override
  public TemplatePatternCreationSpecification getData() {
    return (TemplatePatternCreationSpecification)super.getData();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected IPatternInstance run() {
    return ((InnerCreatePatternAndInstanceOperation)_innerPatternLayoutOperation).execute();
  }

  /**
   * Setup the layout data of the given pattern based on the given GEF elements
   * @param pattern_p a non-null pattern
   */
  protected void setupLayoutData(TemplatePattern pattern_p) {
    ((InnerCreatePatternAndInstanceOperation)_innerPatternLayoutOperation).setupLayoutData(pattern_p);
  }

  /**
   * Inner class, simulates multiple inheritance of SiriusCreatePatternAndInstanceOperation --> (AbstractCreatePatternAndInstanceLayoutOperation, SiriusAbstractPatternWithLayoutOperation)
   * @author Skander TURKI
   */
  protected class InnerCreatePatternAndInstanceOperation 
  extends AbstractCreatePatternAndInstanceLayoutOperation{

    /**
     * Constructor
     */
    public InnerCreatePatternAndInstanceOperation() {
      super();
    }

    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractCreatePatternAndInstanceLayoutOperation#setupLayoutData(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
     */
    @Override
    protected void setupLayoutData(TemplatePattern pattern_p) {
      EMap<EObject, Layout> layoutData = buildLayoutData();
      pattern_p.getLayoutData().putAll(layoutData);
    }

    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractOperation#execute()
     */
    @Override
    protected IPatternInstance execute() {
      TemplatePattern pattern = getData().getPattern();
      // Pattern layout definition
      if (getData().includeLayoutData())
        setupLayoutData(pattern);
      // Pattern storage
      AddToCatalogOperation storeOperation = new AddToCatalogOperation(
          (PatternRepository)getData().getRepository(), pattern, pattern);
      call(storeOperation);
      // Instance creation from original elements
      IPatternApplication application = getData().toPatternApplication();
      CreateInstanceOperation instanceOperation = new CreateInstanceOperation(application, 
          getData().getRepository(), getData().getScopeElement());
      Object result = CorePatternsPlugin.getDefault().getModelEnvironment().execute(instanceOperation);
      return (IPatternInstance)result;
    }

  }


}
