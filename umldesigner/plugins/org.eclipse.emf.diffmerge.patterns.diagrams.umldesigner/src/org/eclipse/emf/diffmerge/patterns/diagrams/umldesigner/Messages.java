/*********************************************************************
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner;

import org.eclipse.osgi.util.NLS;


/**
 * Messages for UML Designer extension.
 * @author Skander Turki
 */
@SuppressWarnings("javadoc")
public class Messages extends NLS{
  
  private static final String BUNDLE_NAME = "org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.messages"; //$NON-NLS-1$
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }
  
  private Messages() {
    // Nothing
  }
  
  public static String UMLDesignerDeleteCommand_Label;
  
}
