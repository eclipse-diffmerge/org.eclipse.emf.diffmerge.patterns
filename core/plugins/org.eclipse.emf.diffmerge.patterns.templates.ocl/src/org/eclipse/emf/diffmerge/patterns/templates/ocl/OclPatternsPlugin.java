/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.templates.ocl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.diffmerge.patterns.templates.ocl.interpreter.OclInterpreter;
import org.osgi.framework.BundleContext;


/**
 * The activator class for this plug-in
 * @author Olivier Constant
 */
public class OclPatternsPlugin extends Plugin {

	/** The shared instance */
	private static OclPatternsPlugin __plugin;
	
  /** The name of the language supported */
  private static final String LANGUAGE_NAME = "ocl"; //$NON-NLS-1$
  
  /** ID related to the OclEnvironmentCustomizer extension point */
  private static final String OCL_ENVIRONMENT_CUSTOMIZER_EXTENSION_POINT =
    "org.eclipse.emf.diffmerge.patterns.templates.ocl.oclEnvironmentCustomizer"; //$NON-NLS-1$
  /** ID related to the OclEnvironmentCustomizer extension point */
  private static final String OCL_ENVIRONMENT_CUSTOMIZER_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
	/** The OCL interpreter */
	private final OclInterpreter _interpreter;
	
	/**
	 * Constructor
	 */
	public OclPatternsPlugin() {
	  _interpreter = new OclInterpreter();
	}
	
  /**
   * Discover the customizer which is registered through the dedicated
   * extension point, if any
   * @return a potentially null customizer
   */
  private IOclEnvironmentCustomizer discoverRegisteredOclEnvironmentCustomizer() {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        OCL_ENVIRONMENT_CUSTOMIZER_EXTENSION_POINT);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(OCL_ENVIRONMENT_CUSTOMIZER_POINT_PROPERTY);
        if (o instanceof IOclEnvironmentCustomizer)
          return (IOclEnvironmentCustomizer)o;
      } catch (CoreException ex) {
        // Proceed
      }
    }
    return null;
  }
  
  /**
   * Return the shared instance of the activator
   */
  public static OclPatternsPlugin getDefault() {
    return __plugin;
  }
  
  /**
   * Return an easy-to-use OCL interpreter
   * @return a non-null OCL interpreter
   */
  public OclInterpreter getInterpreter() {
    return _interpreter;
  }
  
  /**
   * Return the name of the supported language
   * @return a non-null string
   */
  public String getLanguage() {
    return LANGUAGE_NAME;
  }
  
  /**
   * Return the customizer which is registered in the platform, if any
   * @return a potentially null customizer
   */
  public IOclEnvironmentCustomizer getOclEnvironmentCustomizer() {
    return discoverRegisteredOclEnvironmentCustomizer();
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
