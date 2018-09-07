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
package org.eclipse.emf.diffmerge.patterns.ui.util;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;

/**
 * A utility class that provides general reusable services for patterns and their instances
 * @author Olivier Constant
 * @author Skander Turki
 */
public final class PatternsInstancesUIUtil {

  /**
   * Private constructor that forbids instantiation
   */
  private PatternsInstancesUIUtil() {
    // Nothing needed
  }
  
  /**
   * Return a description of the pattern of the given instance
   * @param instance_p a non-null instance
   * @return a non-null string
   */
  public static String getInstanceAsText(IPatternInstance instance_p) {
    StringBuilder builder = new StringBuilder();
    IPattern pattern = instance_p.getPattern();
    boolean notLoaded = pattern == null;
    builder.append("Involving : "); //$NON-NLS-1$
    for (EObject obj : instance_p.getElements()) {
      EList<EAttribute> attrs = obj.eClass().getEAllAttributes();
      for (EAttribute attr : attrs) {
        if ("name".equals(attr.getName())) { //$NON-NLS-1$
          builder.append("# " + ((String) obj.eGet(attr))); //$NON-NLS-1$
        }
      }
    }
    String result = builder.toString();
    if (notLoaded) {
      result = UIUtil.markAsNotLoaded(result);
    }
    return result;
  }
  
  /**
   * Return a description of the pattern of the given instance
   * @param instance_p a non-null instance
   * @return a non-null string
   */
  public static String getPatternAsText(IPatternInstance instance_p) {
    StringBuilder builder = new StringBuilder();
    IPattern pattern = instance_p.getPattern();
    boolean notLoaded = pattern == null;
    String patternName;
    if (notLoaded) {
      if(instance_p.getPatternVersion() != null)
        patternName = instance_p.getPatternVersion().getPatternSymbol().getName();
      else 
        patternName = null;
    } else {
      patternName = DiscriminatingLabelProvider.getInstance().getText(pattern);
    }
    if(patternName != null){
      builder.append(patternName);
      builder.append("  (v"); //$NON-NLS-1$
      builder.append(instance_p.getPatternVersion().getVersion());
      builder.append(')');
    }
    String result = null;
    if (patternName == null)
      result = "Pattern Not Found"; //$NON-NLS-1$
    else {
      result = builder.toString();
      if (notLoaded)
        result = UIUtil.markAsNotLoaded(result);
    }
    return result;
  }
  
  /**
   * Return a description of the roles played by the reference element in the given instance
   * @param instance_p a non-null instance
   * @param referenceElement_p a potentially null EObject
   * @param unknownMessage_p default non-null text
   * @param noRoleMessage_p default non-null "role not found" text
   * @return a non-null string
   */
  public static String getRolesAsText(IPatternInstance instance_p, EObject referenceElement_p,
      String unknownMessage_p, String noRoleMessage_p) {
    String result = unknownMessage_p;
    if ((referenceElement_p != null) && (instance_p.getPattern() != null)) {
      Collection<? extends IPatternRole> roles;
      if (instance_p.getPatternData() instanceof TemplatePatternData) {
        roles = ((TemplatePatternData) instance_p.getPatternData()).getRolesOf(referenceElement_p);
      } else {
        roles = instance_p.getRolesOf(referenceElement_p);
      }
      if (!roles.isEmpty()) {
        result = UIUtil.buildStringWith(roles, ", ", null, null); //$NON-NLS-1$
      } else {
        result = noRoleMessage_p;
      }
    }
    return result;
  }
  
  /**
   * Display a "No pattern support" error message
   */
  public static void informNoPatternSupport(Shell shell_p) {
    MessageDialog.openError(shell_p, CorePatternsPlugin.getDefault().getLabel(),
        org.eclipse.emf.diffmerge.patterns.ui.Messages.AbstractModelBasedAction_MissingPatternSupport);
  }
  
}
