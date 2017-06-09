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
package org.eclipse.emf.diffmerge.patterns.diagrams;

import org.eclipse.osgi.util.NLS;


/**
 * Utility class for the externalization mechanism
 * @author Olivier Constant
 * @author Skander Turki
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.diagrams.messages"; //$NON-NLS-1$
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

  public static String LayoutReuseOperation_Name;
  public static String RestoreOperation_Name;

  public static String PatternsDiagramsUtil_NotLoaded;

  public static String UpdatePatternInCatalogOperation_Name;
  public static String ViewpointDisplayOperation_Name;

}
