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
package org.eclipse.emf.diffmerge.patterns.core;

import org.eclipse.osgi.util.NLS;


/**
 * Utility class for the externalization mechanism.
 * @author Olivier Constant
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.core.messages"; //$NON-NLS-1$
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
    // Nothing
  }

  public static String AbstractModelOperation_DefaultName;
  public static String BasicStatus_Failure;
  public static String BasicStatus_FoldedInstance;
  public static String BasicStatus_NoPattern;
  public static String BasicStatus_Success;
  public static String BasicStatus_Warnings;
  public static String CreateInstanceOperation_Name;
  public static String DeleteOperation_Failure;
  public static String DeleteOperation_Name;
  public static String InstanceOperation_Name;
  public static String GetInstancesOperation_Name;
  public static String PatternConformityStatus_ConformityExtra;
  public static String PatternConformityStatus_Conforms;
  public static String PatternConformityStatus_NonConformityDetails;
  public static String PatternsCorePlugin_Label;
}
