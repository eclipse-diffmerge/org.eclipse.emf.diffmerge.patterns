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
package org.eclipse.emf.diffmerge.patterns.templates.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ITextualLanguageInterpreterFacade;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.SemanticRuleProvidersDispatcher;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.osgi.framework.BundleContext;

 
/**
 * The activator class for this plug-in
 * @author Olivier Constant
 * @author Skander Turki
 */
public class TemplatePatternsEnginePlugin extends Plugin {

  /** The shared instance */
  private static TemplatePatternsEnginePlugin __plugin;

  /** ID related to the textualLanguageFacade extension point */
  private static final String LANGUAGE_EXTENSION_POINT =
    "org.eclipse.emf.diffmerge.patterns.templates.engine.textualLanguageInterpreterFacade"; //$NON-NLS-1$
  /** ID related to the textualLanguageFacade extension point */
  private static final String LANGUAGE_EXTENSION_POINT_PROPERTY =
    "class"; //$NON-NLS-1$

  /** The (language name, language facade) map of the registered textual languages */
  private Map<String, ITextualLanguageInterpreterFacade> _languages;

  /** The semantic rule provider dispatcher is used to find the appropriate rule provider for each scope element */
  protected SemanticRuleProvidersDispatcher _semanticRuleProvidersDispatcher;

  /** The data lastly used for pattern creation (potentially null) */
  private TemplatePatternCreationSpecification _creationSpecification;

  /**
   * Constructor
   */
  public TemplatePatternsEnginePlugin() {
    _languages = null;
    _creationSpecification = null;
    _semanticRuleProvidersDispatcher = new SemanticRuleProvidersDispatcher();
  }

  /**
   * Clear the last data used for pattern creation/update
   */
  public void clearTraces() {
    _creationSpecification = null;
  }

  /**
   * Discover the language interpreter facades for template patterns which are registered in the platform
   * @return a non-null, potentially empty, unmodifiable list
   */
  private List<ITextualLanguageInterpreterFacade> discoverRegisteredInterpreterFacades() {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        LANGUAGE_EXTENSION_POINT);
    List<ITextualLanguageInterpreterFacade> result = new ArrayList<ITextualLanguageInterpreterFacade>();
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(LANGUAGE_EXTENSION_POINT_PROPERTY);
        if (o instanceof ITextualLanguageInterpreterFacade)
          result.add((ITextualLanguageInterpreterFacade)o);
      } catch (CoreException ex) {
        // Proceed
      }
    }
    return result;
  }


  /**
   * Return the shared instance of the activator
   */
  public static TemplatePatternsEnginePlugin getDefault() {
    return __plugin;
  }

  /**
   * Return the textual language facade for template patterns which is registered for the given language
   * @param languageName_p a non-null string
   * @return a potentially null language facade
   */
  public ITextualLanguageInterpreterFacade getLanguageFacadeFor(String languageName_p) {
    if (_languages == null) {
      List<ITextualLanguageInterpreterFacade> facades = discoverRegisteredInterpreterFacades();
      _languages = new HashMap<String, ITextualLanguageInterpreterFacade>();
      for (ITextualLanguageInterpreterFacade facade : facades) {
        _languages.put(facade.getLanguage(), facade);
      }
    }
    return _languages.get(languageName_p);
  }

  /**
   * Return the last data used for pattern creation/update
   * @return a potentially null comparison
   */
  public TemplatePatternCreationSpecification getLastPatternCreationData() {
    return _creationSpecification;
  }

  /**
   * Return the ID of this plug-in according to MANIFEST.MF
   */
  public String getPluginId() {
    return getBundle().getSymbolicName();
  }

  /**
   * Return the semantic rule provider dispatcher for the given contextual object
   * @return a non-null semantic rule provider
   */
  public ISemanticRuleProvider getSemanticRuleProviderFor(Object context_p) {
    return _semanticRuleProvidersDispatcher;
  }
  
  /**
   * Return fresh data for pattern creation
   * @param isTemplate_p whether the pattern is a template
   * @param sources_p the elements from which the pattern must be created
   * @param currentEnvironments_p a non-null, potentially empty list
   */
  public TemplatePatternCreationSpecification newPatternCreationData(
      boolean isTemplate_p, List<? extends Object> sources_p,
      List<String> currentEnvironments_p) {
    _creationSpecification =
      new TemplatePatternCreationSpecification(isTemplate_p, sources_p, currentEnvironments_p);
    return _creationSpecification;
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
