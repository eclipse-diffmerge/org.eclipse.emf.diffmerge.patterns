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
