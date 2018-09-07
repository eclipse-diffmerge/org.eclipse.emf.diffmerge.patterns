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
package org.eclipse.emf.diffmerge.patterns.ui.sirius;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class SiriusPatternsUIPlugin extends AbstractUIPlugin {

  /** The shared instance */
  private static SiriusPatternsUIPlugin __plugin;
  
	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.emf.diffmerge.patterns.ui.sirius"; //$NON-NLS-1$
	
	
  /**
   * Constructor
   */
  public SiriusPatternsUIPlugin() {
    // Nothing needed
  }
  
	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
  public void start(BundleContext context) throws Exception {
		super.start(context);
		__plugin = this;
	}
	
	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
  public void stop(BundleContext context) throws Exception {
		__plugin = null;
		super.stop(context);
	}
	
	/**
	 * Return the shared instance
	 * @return the shared instance
	 */
	public static SiriusPatternsUIPlugin getDefault() {
		return __plugin;
	}
	
}
