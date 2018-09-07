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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs;

import org.eclipse.osgi.util.NLS;


/**
 * Utility class for the externalization mechanism.
 * @author Olivier Constant
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.repositories.catalogs.messages"; //$NON-NLS-1$
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Nothing
  }

  public static String AddToCatalogOperation_Name;
  public static String CloseCatalogOperation_Name;
  public static String CreateCatalogOperation_Name;
  public static String OpenCatalogOperation_Name;
  public static String RemoveFromCatalogOperation_Name;
  public static String UpdateCatalogOperation_Name;

}
