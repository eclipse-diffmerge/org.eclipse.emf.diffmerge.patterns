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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.presentation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.provider.CorePatternsEditPlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

/**
 * This is the central singleton for the TemplatePatterns editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class TemplatePatternsEditorPlugin extends EMFPlugin {
  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final TemplatePatternsEditorPlugin INSTANCE = new TemplatePatternsEditorPlugin();
  
  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplatePatternsEditorPlugin() {
    super
      (new ResourceLocator [] {
        CorePatternsEditPlugin.INSTANCE,
        EcoreEditPlugin.INSTANCE,
      });
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  @Override
  public ResourceLocator getPluginResourceLocator() {
    return plugin;
  }
  
  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin() {
    return plugin;
  }
  
  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static class Implementation extends EclipseUIPlugin {
    /**
     * Creates an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("synthetic-access")
    public Implementation() {
      super();
  
      // Remember the static instance.
      //
      plugin = this;
    }
  }

}
