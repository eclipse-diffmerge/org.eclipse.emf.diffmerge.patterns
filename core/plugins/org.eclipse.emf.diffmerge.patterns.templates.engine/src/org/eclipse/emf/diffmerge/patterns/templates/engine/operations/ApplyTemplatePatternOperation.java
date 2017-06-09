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
package org.eclipse.emf.diffmerge.patterns.templates.engine.operations;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.operations.CreateInstanceOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation.InstanceOperationKind;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;


/**
 * A model operation that consists in applying a template pattern and unfolding the
 * resulting instance
 * @author Olivier Constant
 * @author Skander Turki
 */
public class ApplyTemplatePatternOperation extends CreateInstanceOperation {

  /** An optional naming rule for the unfolded elements */
  private final String _namingRule;

  /** An index for naming rules in multiple instantiations (default is 1) */
  private final int _index;

  /** Whether the instance must be unfolded after being created */
  private final boolean _unfold;

  /** The initial multiplicity of the instance */
  private final int _multiplicity;

  /**
   * Constructor
   * @param application_p a non-null application of the pattern
   * @param unfold_p whether the instance must be unfolded
   * @param namingRule_p an optional naming rule for the unfolded elements
   * @param index_p an index for naming rules in multiple instantiations (default is 1)
   * @param multiplicity_p the initial multiplicity of the instance
   */
  public ApplyTemplatePatternOperation(IPatternApplication application_p,
      boolean unfold_p, String namingRule_p, int index_p, int multiplicity_p, 
      Object patternSideContext_p, Object modelSideContext_p) {
    super(application_p, patternSideContext_p, modelSideContext_p);
    _namingRule = namingRule_p;
    _index = index_p;
    _unfold = unfold_p;
    _multiplicity = multiplicity_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected IPatternInstance run() {
    // Pattern application
    IPatternInstance result = super.run();
    // Instance naming rule
    if (result != null && result.getPatternData() instanceof TemplatePatternData) {
      TemplatePatternData data = (TemplatePatternData)result.getPatternData();
      String finalNamingRule = _namingRule;
      if (finalNamingRule != null)
        finalNamingRule = NamingUtil.substituteIndex(finalNamingRule, _index);
      data.setNamingRule(finalNamingRule);
      data.setMultiplicity(_multiplicity);
    }
    // Instance unfolding
    if (result != null && _unfold) {
      InstanceOperation unfoldOperation = new InstanceOperation(result, InstanceOperationKind.UNFOLD, null, 
          getTargetContext(), getSourceContext());
      IEvaluationStatus unfoldStatus = call(unfoldOperation);
      if (unfoldStatus instanceof IModelTransformationStatus &&
          ((IModelTransformationStatus)unfoldStatus).isAborted())
        // Unfolding aborted: abort all
        abort();
    }
    return result;
  }

}
