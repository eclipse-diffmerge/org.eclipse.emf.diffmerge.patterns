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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs;

import org.eclipse.osgi.util.NLS;


/**
 * Utility class for the externalization mechanism
 * @author O. CONSTANT
 */
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
