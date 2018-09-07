/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.engine.operations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.Messages;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation.InstanceOperationKind;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;


/**
 * A model operation that consists in applying a template pattern multiple times and unfolding the
 * resulting instances
 * @author Olivier Constant
 * @author Skander Turki
 */
public class ApplyNTimesTemplatePatternOperation extends AbstractModelOperation<Collection<IPatternInstance>> {

  /** The non-null pattern application */
  private final IPatternApplication _application;

  /** An optional naming rule for the unfolded elements */
  private final String _namingRule;

  /** Whether the instance must be unfolded after being created */
  private final boolean _unfold;
  
  /** The number of instances */
  private final int _numberOfApplications;

  /** The initial multiplicity of each instance */
  private final int _multiplicity;
  
  
  /**
   * Constructor
   * @param application_p a non-null pattern application
   * @param unfold_p whether to unfold
   * @param namingRule_p an optional naming rule
   * @param numberOfApplications_p the number of instances
   * @param multiplicity_p the initial multiplicity of each instance
   * @param targetContext_p an optional context object for the target side of the operation
   * @param sourceContext_p an optional context object for the source side of the operation
   */
  public ApplyNTimesTemplatePatternOperation(IPatternApplication application_p,
      boolean unfold_p, String namingRule_p, int numberOfApplications_p, int multiplicity_p, 
      Object targetContext_p, Object sourceContext_p) {
    super(Messages.CreateInstanceOperation_Name, null, false, false, true, 
        targetContext_p, sourceContext_p);
    _application = application_p;
    _namingRule = namingRule_p;
    _unfold = unfold_p;
    _numberOfApplications = numberOfApplications_p;
    _multiplicity = multiplicity_p;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected Collection<IPatternInstance> run() {
    Collection<IPatternInstance> result = new ArrayList<IPatternInstance>(); 
    IPatternSupport patternSupport = CorePatternsPlugin.getDefault().getPatternSupportFor(_application);
    if (patternSupport != null) {
      for(int i = 1; i <= _numberOfApplications; i++){
        IPatternInstance currentInstance = patternSupport.createInstance(_application);
        result.add(createIndexedInstance(currentInstance, i));
      }
    }
    return result;
  }

  /**
   * Creates an instance at the specified index
   * @param instance_p a potentially null IPatternInstance
   * @param index_p an int
   * @return a potentially null IPatternInstance
   */
  protected IPatternInstance createIndexedInstance(IPatternInstance instance_p, int index_p) {
    // Instance naming rule
    if (instance_p != null && instance_p.getPatternData() instanceof TemplatePatternData) {
      TemplatePatternData data = (TemplatePatternData)instance_p.getPatternData();
      String finalNamingRule = _namingRule;
      if (finalNamingRule != null)
        finalNamingRule = NamingUtil.substituteIndex(finalNamingRule, index_p);
      data.setNamingRule(finalNamingRule);
      data.setMultiplicity(_multiplicity);
    }
    // Instance unfolding
    if (instance_p != null && _unfold) {
      //IEvaluationStatus unfoldStatus = result.unfold();
      InstanceOperation unfoldOperation = new InstanceOperation(instance_p, InstanceOperationKind.UNFOLD, null, 
          getTargetContext(), getSourceContext());
      IEvaluationStatus unfoldStatus = call(unfoldOperation);
      if (unfoldStatus instanceof IModelTransformationStatus &&
          ((IModelTransformationStatus)unfoldStatus).isAborted())
        // Unfolding aborted: abort all
        abort();
      else{
        try {
          if(instance_p instanceof CommonPatternInstance){
            ((CommonPatternInstance)instance_p).eResource().save(null);
          }         
        } catch (IOException e) {
          e.printStackTrace();
          return instance_p;
        }
      }
    }
    return instance_p;
  }

}
