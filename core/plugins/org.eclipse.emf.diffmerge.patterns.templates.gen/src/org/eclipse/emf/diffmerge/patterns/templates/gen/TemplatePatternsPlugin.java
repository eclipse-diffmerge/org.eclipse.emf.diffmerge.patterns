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
package org.eclipse.emf.diffmerge.patterns.templates.gen;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;


/**
 * The activator class for this plug-in
 * @author Olivier Constant
 */
public class TemplatePatternsPlugin extends Plugin {

	/** The shared instance */
	private static TemplatePatternsPlugin __plugin;
	
  /** ID related to the templatePatternsEngine extension point */
  private static final String ENGINE_EXTENSION_POINT =
    "org.eclipse.emf.diffmerge.patterns.templates.gen.templatePatternsEngine"; //$NON-NLS-1$
  /** ID related to the templatePatternsEngine extension point */
  private static final String ENGINE_EXTENSION_POINT_PROPERTY =
    "class"; //$NON-NLS-1$
  
  /** A status representing failure due to inability to retrieve an engine */
  private static final SimpleStatus NO_ENGINE = new SimpleStatus(
      false, Messages.TemplatePatternsPlugin_NoEngine);
  
  /** The template pattern engine which has been discovered last */
  private ITemplatePatternEngine _cachedEngine;
  
	/**
	 * Constructor
	 */
	public TemplatePatternsPlugin() {
	  _cachedEngine = null;
	}
	
  /**
   * Discover the engine for template patterns which is registered in the platform
   * @return a potentially null template pattern engine
   */
  private ITemplatePatternEngine discoverRegisteredEngine() {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        ENGINE_EXTENSION_POINT);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(ENGINE_EXTENSION_POINT_PROPERTY);
        if (o instanceof ITemplatePatternEngine)
          return (ITemplatePatternEngine)o;
      } catch (CoreException ex) {
        // Proceed
      }
    }
    return null;
  }
  
  /**
   * Return the shared instance of the activator
   */
  public static TemplatePatternsPlugin getDefault() {
    return __plugin;
  }
  
  /**
   * Return the engine for template patterns which is registered in the platform
   * @return a potentially null template pattern engine
   */
  public ITemplatePatternEngine getEngine() {
    if (_cachedEngine == null)
      _cachedEngine = discoverRegisteredEngine();
    return _cachedEngine;
  }
  
  /**
   * Return a status that represents the absence of a registered engine for
   * template patterns
   * @return a non-null status
   */
  public SimpleStatus getNoEngineStatus() {
    return NO_ENGINE;
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
