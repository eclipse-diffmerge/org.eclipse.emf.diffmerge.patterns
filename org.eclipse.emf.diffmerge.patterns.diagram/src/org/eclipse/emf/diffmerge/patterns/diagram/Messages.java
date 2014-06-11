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
package org.eclipse.emf.diffmerge.patterns.diagram;

import org.eclipse.osgi.util.NLS;

/**
 * Utility class for the externalization mechanism
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.diagram.messages"; //$NON-NLS-1$
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Nothing
  }


  public static String AbstractViewpointWrappingOperation_Refresh;
  public static String CreatePatternAndInstanceOperation_Name;
  public static String DeletePatternOperation_Name;
  public static String HighlightOperation_Name;

//  public static String HighlightAllPatternsInstances_NoOpenRepository;
//  public static String HighlightAllPatternsInstances_NoDiagramElementSelected;
//  public static String HighlightAllPatternsInstances_DialogTitle;
//  public static String HighlightAllPatternsInstances_DialogMessage;
//  public static String HighlightAllPatternsInstances_DialogColumnHeaderInstance;
//  public static String HighlightAllPatternsInstances_DialogColumnHeaderPattern;
//  public static String HighlightAllPatternsInstances_SelectOneContainer;
//  public static String HighlightAllPatternsInstances_NoInstanceLayoutAndStyleInformationAvailable;
//  public static String HighlightAllPatternsInstances_ConsiderOpeningPatternCatalogs;
//  public static String HighlightAllPatternsInstancesAction_NoElementInInstance;

  public static String LayoutReuseOperation_Name;
  public static String RestoreOperation_Name;

//  public static String UIUtil_CatalogPrompt;
//  public static String UIUtil_ContainerRole;
//  public static String UIUtil_ContainerRoles;
//  public static String UIUtil_FileExists;
//  public static String UIUtil_MergedRole;
//  public static String UIUtil_MergedRoles;
//  public static String UIUtil_NewCatalogPrompt;
  public static String PatternsDiagramsUtil_NotLoaded;
//  public static String UIUtil_OpeningFailure;
//  public static String UIUtil_OpeningRequiresMigration;
//  public static String UIUtil_OperationError;
//  public static String UIUtil_SuccessfulOperation;
//  public static String UIUtil_UnsupportedOperation;
  public static String UpdatePatternInCatalogOperation_Name;
  public static String ViewpointDisplayOperation_Name;

}
