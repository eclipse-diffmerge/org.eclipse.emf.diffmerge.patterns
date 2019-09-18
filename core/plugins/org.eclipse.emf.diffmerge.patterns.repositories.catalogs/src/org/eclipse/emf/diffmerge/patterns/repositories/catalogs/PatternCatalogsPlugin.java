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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class for this plug-in.
 * @author Olivier Constant
 */
public class PatternCatalogsPlugin extends Plugin {

	/** The shared instance */
	private static PatternCatalogsPlugin __plugin;
	
	/** The default accessor for pattern catalogs */
	private final PatternCatalogAccessor _accessor;
	
	
	/**
	 * Constructor
	 */
	public PatternCatalogsPlugin() {
    _accessor = new PatternCatalogAccessor();
	}
	
  /**
   * Return the shared instance of the activator
   */
  public static PatternCatalogsPlugin getDefault() {
    return __plugin;
  }
  
  /**
   * Return the default accessor for pattern catalogs
   * @return a non-null accessor
   */
  public PatternCatalogAccessor getAccessor() {
    return _accessor;
  }
  
  /**
   * Return the ID of this plug-in according to MANIFEST.MF
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
		__plugin = this;
	}
  
	/**
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		__plugin = null;
		super.stop(context);
	}
	
}
