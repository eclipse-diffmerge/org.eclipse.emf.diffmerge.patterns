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

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;


/**
 * A model operation that consists in applying a naming rule to a given pattern instance.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class RenameTemplateInstanceOperation 
  extends AbstractModelOperation<IPatternInstance> {
  
  /** The non-null instance */
  private final IPatternInstance _instance;
  
  /** The potentially null naming rule */
  private final String _newNamingRule;
  
  /** Whether non-conforming names must be preserved */
  private final boolean _keepUserNames;
  
	/**
	 * Constructor
	 * @param instance_p a non-null instance
	 * @param newNamingRule_p the potentially null naming rule
   * @param keepUserNames_p whether non-conforming name must be preserved
	 */
	public RenameTemplateInstanceOperation(IPatternInstance instance_p,
	    String newNamingRule_p, boolean keepUserNames_p, Object targetContext_p) {
	  super(Messages.RenameTemplateInstanceOperation_Name, null, true, false, false, targetContext_p, null);
    _instance = instance_p;
    _newNamingRule = newNamingRule_p;
    _keepUserNames = keepUserNames_p;
	}
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected IPatternInstance run() {
    TemplatePatternData data = TemplatePatternsUtil.getPatternData(_instance);
    if (data != null)
      data.rename(_newNamingRule, _keepUserNames);
    return _instance;
  }
  
}
