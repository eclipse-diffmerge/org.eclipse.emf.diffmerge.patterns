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
package org.eclipse.emf.diffmerge.patterns.templates.engine;

import org.eclipse.osgi.util.NLS;


/**
 * Utility class for the externalization mechanism
 * @author O. CONSTANT
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.templates.engine.messages"; //$NON-NLS-1$
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Nothing
  }

  public static String AbstractModifiableTemplatePatternSpecification_RoleNameFromType;
  public static String AbstractModifiableTemplatePatternSpecification_SpecialRoleNameFromType;
  public static String CreateTemplatePatternOperation_Name;
  public static String RenameTemplateInstanceOperation_Name;
  public static String TemplatePatternComparison_FailureAnnouncement;
  public static String TemplatePatternEngine_AlreadyConforms;
  public static String TemplatePatternEngine_FoldNotNeeded;
  public static String TemplatePatternEngine_NoInterpreter;
  public static String TemplatePatternEngine_WrongTypeForAddition;
  public static String TemplatePatternEngine_WrongTypeForMerge;

}
