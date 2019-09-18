/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.gen;

import org.eclipse.osgi.util.NLS;

/**
 * Utility class for the externalization mechanism
 * @author Olivier Constant
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.templates.gen.messages"; //$NON-NLS-1$
  public static String TemplatePatternRoleImpl_UnsuitableLocation;
  public static String TemplatePatternRoleImpl_WrongNumberOfLocations;
  public static String TemplatePatternsPlugin_NoEngine;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}
