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
package org.eclipse.emf.diffmerge.patterns.support;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class for this plug-in.
 * @author Olivier Constant
 */
public class PatternSupportPlugin extends Plugin {
  
	/** The shared instance */
	private static PatternSupportPlugin plugin;
	
	
	/**
	 * The constructor
	 */
	public PatternSupportPlugin() {
	  // Nothing to add
	}
	
  /**
   * Return the ID of this plug-in according to MANIFEST.MF
   * @return a non-null string
   */
  public String getPluginId() {
    return getBundle().getSymbolicName();
  }
  
  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
	@Override
  public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	/**
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
  public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	/**
	 * Return the shared instance
	 * @return the shared instance
	 */
	public static PatternSupportPlugin getDefault() {
		return plugin;
	}
	
}
