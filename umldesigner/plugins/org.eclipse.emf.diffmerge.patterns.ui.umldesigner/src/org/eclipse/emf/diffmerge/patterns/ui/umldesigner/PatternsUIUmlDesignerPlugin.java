/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.umldesigner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/**
 * The activator class for this plug-in.
 * @author Skander Turki
 */
public class PatternsUIUmlDesignerPlugin implements BundleActivator {
  
  /** The bundle context, non-null after activation */
	private static BundleContext context;
	
  /**
   * Return the bundle context
   * @return a bundle context which is not null after activation
   */
	static BundleContext getContext() {
		return context;
	}
	
	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		PatternsUIUmlDesignerPlugin.context = bundleContext;
	}
	
	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		PatternsUIUmlDesignerPlugin.context = null;
	}
	
}
