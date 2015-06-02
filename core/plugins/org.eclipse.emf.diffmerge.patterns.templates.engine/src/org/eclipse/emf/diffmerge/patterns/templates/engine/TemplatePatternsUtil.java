/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.templates.engine;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;


/**
 * A utility class related to template patterns
 * @author Olivier Constant
 */
public final class TemplatePatternsUtil {
  
  /**
   * Constructor
   */
  private TemplatePatternsUtil() {
    // Forbids instantiation
  }
  
  /**
   * Adjust the given scope elements based on business criteria
   * @param scope_p a non-null scope
   */
  public static void adjust(FilteredModelScope scope_p) {
    adjust(scope_p, true);
    adjust(scope_p, false);
  }
  
  /**
   * Adjust the given scope elements based on business criteria
   * @param scope_p a non-null scope
   * @param extend_p whether the scope should be extended or reduced
   */
  public static void adjust(FilteredModelScope scope_p, boolean extend_p) {
    List<EObject> roots = scope_p.getContents();
    if (!roots.isEmpty()) {
      ISemanticRuleProvider ruleProvider =
        TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(roots.get(0));
      if (ruleProvider != null) {
        ruleProvider.adjustScope(scope_p, extend_p);
      }
    }
  }
  
  /**
   * Return an ordered set of the roots of the given application
   * @param application_p a non-null pattern application
   * @return a non-null, unmodifiable list
   */
  public static List<EObject> getApplicationRoots(IPatternApplication application_p) {
    List<EObject> result;
    if (application_p instanceof IPatternInstance &&
        ((IPatternInstance)application_p).getPatternData() instanceof TemplatePatternData) {
      TemplatePatternData data =
        (TemplatePatternData)((IPatternInstance)application_p).getPatternData();
      result = data.getInstanceElements();
    } else {
      result = LocationsUtil.getRoleElements(application_p);
    }
    result = ModelsUtil.getRoots(result);
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Return the template pattern data of the given application, if any
   * @param application_p a potentially null application
   * @return potentially null data
   */
  public static TemplatePatternData getPatternData(IPatternApplication application_p) {
    TemplatePatternData result = null;
    if (application_p instanceof IPatternInstance) {
      IPatternInstance instance = (IPatternInstance)application_p;
      if (instance.getPatternData() instanceof TemplatePatternData)
        result = (TemplatePatternData)instance.getPatternData();
    }
    return result;
  }
  
  /**
   * Update the time stamp that corresponds to the last modification of the given pattern
   * to the current date and time
   * @param pattern_p a non-null pattern
   */
  public static void updateLastModificationStamp(TemplatePattern pattern_p) {
    pattern_p.setLastModificationStamp(Calendar.getInstance().getTime().toString());
  }
  
}
