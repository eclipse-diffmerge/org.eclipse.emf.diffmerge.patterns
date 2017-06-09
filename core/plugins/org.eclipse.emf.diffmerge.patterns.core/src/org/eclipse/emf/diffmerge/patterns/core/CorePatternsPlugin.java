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
package org.eclipse.emf.diffmerge.patterns.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IDeleteOperationProvider;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IIdProvider;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.emf.diffmerge.patterns.core.environment.IdProviderDispatcher;
import org.eclipse.emf.diffmerge.patterns.core.operations.DeleteOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.BundleContext;


/**
 * The activator class for this plug-in.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class CorePatternsPlugin extends Plugin {
  
  /** The shared instance */
  private static CorePatternsPlugin __plugin;
  
  
  /** The default delete operation provider */
  private static final IDeleteOperationProvider DEFAULT_DELETE_OPERATION_PROVIDER =
    new IDeleteOperationProvider() {
    /**
     * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IDeleteOperationProvider#getDeleteOperation(java.util.Collection, boolean, boolean, java.lang.Object)
     */
    public DeleteOperation getDeleteOperation(Collection<? extends EObject> toDelete_p,
        boolean skipConfirmation_p, boolean isExpensive_p,
        Object context_p) {
      return new DeleteOperation(toDelete_p, isExpensive_p, context_p);
    }
    /**
     * @see org.eclipse.emf.diffmerge.patterns.core.api.ext.IDeleteOperationProvider#isInModel(org.eclipse.emf.ecore.EObject)
     */
    public boolean isInModel(EObject element_p) {
      return element_p.eResource() != null;
    }
  };
  
  /** ID related to the PatternSupport extension point */
  private static final String PATTERN_SUPPORT_EXTENSION_POINT =
    "org.eclipse.emf.diffmerge.patterns.core.patternSupport"; //$NON-NLS-1$
  /** ID related to the PatternSupport extension point */
  private static final String PATTERN_SUPPORT_EXTENSION_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  /** ID related to the ModelEnvironment extension point */
  private static final String MODEL_ENVIRONMENT_EXTENSION_POINT =
    "org.eclipse.emf.diffmerge.patterns.core.modelEnvironment"; //$NON-NLS-1$
  /** ID related to the ModelEnvironment extension point */
  private static final String MODEL_ENVIRONMENT_EXTENSION_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  /** ID related to the DeleteOperationProvider extension point */
  private static final String DELETE_PROVIDER_EXTENSION_POINT =
    "org.eclipse.emf.diffmerge.patterns.core.deleteOperationProvider"; //$NON-NLS-1$
  /** ID related to the DeleteOperationProvider extension point */
  private static final String DELETE_PROVIDER_EXTENSION_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  
  /** The non-null registry of pattern repositories */
  private final RepositoryRegistry _repositoryRegistry;
  
  /** The pattern supports registered via the dedicated extension point */
  private List<IPatternSupport> _cachedPatternSupports;
  
  /** The current delete operation provider (may be null) */
  private IDeleteOperationProvider _deleteOperationProvider;
  
  /** The current ID provider (may be null) */
  private IIdProvider _idProvider;
  
  /** The current model environment (may be null) */
  private IModelEnvironment _modelEnvironment;
  
  /** The current generic type checker utility class (may not be null) */
  private AbstractGenericTypeUtil _genericTypeUtil;
  
  /** ID related to the generic type checker utility extension point */
  private static final String GENERIC_TYPE_UTIL_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.core.genericTypeUtil"; //$NON-NLS-1$
  /** ID related to the generic type checker utility extension point */
  private static final String GENERIC_TYPE_UTIL_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  
  /**
   * Constructor
   */
  public CorePatternsPlugin() {
    _cachedPatternSupports = null;
    _idProvider = null;
    _repositoryRegistry = new RepositoryRegistry();
  }
  
  /**
   * Return the shared instance of the activator
   */
  public static CorePatternsPlugin getDefault() {
    return __plugin;
  }
  
  /**
   * Discover the delete operation provider which is registered through the dedicated
   * extension point, if any
   * @return a potentially null delete operation
   */
  private IDeleteOperationProvider discoverRegisteredDeleteOperationProvider() {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        DELETE_PROVIDER_EXTENSION_POINT);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(DELETE_PROVIDER_EXTENSION_POINT_PROPERTY);
        if (o instanceof IDeleteOperationProvider)
          return (IDeleteOperationProvider)o;
      } catch (CoreException ex) {
        // Proceed
      }
    }
    return null;
  }
  
  /**
   * Discover the model accessor which is registered through the dedicated
   * extension point, if any
   * @return a potentially null model environment
   */
  private IModelEnvironment discoverRegisteredModelEnvironment() {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        MODEL_ENVIRONMENT_EXTENSION_POINT);
    List<IModelEnvironment> environments = new ArrayList<IModelEnvironment>();
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(MODEL_ENVIRONMENT_EXTENSION_POINT_PROPERTY);
        if (o instanceof IModelEnvironment){
          environments.add((IModelEnvironment) o);
        }  
      } catch (CoreException ex) {
        // Proceed
      }
    }
    //Reduce by override
    Collection<IModelEnvironment> reducedEnvs = reduceByOverride(environments);
    if(reducedEnvs!= null && !reducedEnvs.isEmpty()){
      return (IModelEnvironment) reducedEnvs.toArray()[0];  
    }
    return null;
  }

  /**
   * Reduce the given list according to mutual overriding between IModelEnvironments.
   * @param environments_p a non-null, potentially empty list
   * @return a non-null, potentially empty list
   */
  protected Collection<IModelEnvironment> reduceByOverride(List<IModelEnvironment> environments_p) {
    List<IModelEnvironment> result = new ArrayList<IModelEnvironment>(environments_p);
    for (IModelEnvironment env : environments_p) {
      for (Class<?> overridenClass : env.getOverridenClasses()) {
        List<IModelEnvironment> resultCopy = new ArrayList<IModelEnvironment>(result);
        for(IModelEnvironment cur: resultCopy){
          if(cur.getClass().equals(overridenClass)){
            result.remove(cur);
          }
        }
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Discover the pattern supports which are registered through the dedicated
   * extension point by actually querying the platform
   * @return a non-null, possibly empty, unmodifiable list
   */
  private List<IPatternSupport> discoverRegisteredPatternSupports() {
    List<IPatternSupport> result = new ArrayList<IPatternSupport>();
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        PATTERN_SUPPORT_EXTENSION_POINT);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(PATTERN_SUPPORT_EXTENSION_POINT_PROPERTY);
        if (o instanceof IPatternSupport)
          if(getModelEnvironment().isAppropriatePatternSupport((IPatternSupport)o))
            result.add((IPatternSupport)o);
      } catch (CoreException ex) {
        // Proceed
      }
    }

    return Collections.unmodifiableList(result);
  }
  
  /**
   * Return the delete operation registered in the platform
   * @return a non-null delete operation
   */
  public IDeleteOperationProvider getDeleteOperationProvider() {
    if (_deleteOperationProvider == null)
      _deleteOperationProvider = discoverRegisteredDeleteOperationProvider();
    if (_deleteOperationProvider == null)
      _deleteOperationProvider = DEFAULT_DELETE_OPERATION_PROVIDER;
    return _deleteOperationProvider;
  }
  
  /**
   * Return the ID provider for identified elements in the pattern framework
   * @return a non-null ID provider
   */
  public IIdProvider getIdProvider() {
    if (_idProvider == null)
      _idProvider = new IdProviderDispatcher();
    return _idProvider;
  }
  
  /**
   * Return a label for UIs which represents the set of pattern-related features 
   * @return a non-null string
   */
  public String getLabel() {
    return Messages.PatternsCorePlugin_Label;
  }
  
  /**
   * Return the model accessor which is registered in the platform
   * @return a non-null model accessor
   */
  public IModelEnvironment getModelEnvironment() {
    if (_modelEnvironment == null)
      _modelEnvironment = discoverRegisteredModelEnvironment();
    return _modelEnvironment;
  }
  
  /**
   * Return a pattern support which is applicable to the given element
   * @param element_p a non-null model element
   * @return a potentially null pattern support
   */
  public IPatternSupport getPatternSupportFor(EObject element_p) {
    for (IPatternSupport support : getRegisteredPatternSupports()) {
      if (support.isApplicableTo(element_p))
        return support;
    }
    return null;
  }
  
  /**
   * Return a pattern support which is applicable to the given pattern application
   * @param application_p a non-null pattern application
   * @return a potentially null pattern support
   */
  public IPatternSupport getPatternSupportFor(IPatternApplication application_p) {
    for (IPatternSupport support : getRegisteredPatternSupports()) {
      if (support.isApplicableTo(application_p))
        return support;
    }
    return null;
  }
  
  /**
   * Return the ID of this plug-in according to MANIFEST.MF
   */
  public String getPluginId() {
    return getBundle().getSymbolicName();
  }
  
  /**
   * Return the pattern supports which are registered through the dedicated
   * extension point
   * @return a non-null, possibly empty, unmodifiable list
   */
  private List<IPatternSupport> getRegisteredPatternSupports() {
    if (_cachedPatternSupports == null)
      _cachedPatternSupports = discoverRegisteredPatternSupports();
    return _cachedPatternSupports;
  }
  
  /**
   * Return the unique registry of pattern repositories
   * @return a non-null registry
   */
  public RepositoryRegistry getRepositoryRegistry() {
    return _repositoryRegistry;
  }
  
  /**
   * Set a new ID according to the ID provider that is registered in the platform
   * @param element_p a non-null element whose ID must be set
   */
  public void setNewId(EObject element_p) {
    EcoreUtil.setID(element_p, getIdProvider().getNewIdFor(element_p));
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
  
  /**
   * Return the genetic type utility class registered in the platform
   * @return a non-null AbstractGenericTypeUtil
   */
  public AbstractGenericTypeUtil getGenericTypeUtil() {
    if(_genericTypeUtil == null){
      SingletonContributionDiscoverer<AbstractGenericTypeUtil> d = 
          new SingletonContributionDiscoverer<AbstractGenericTypeUtil>(AbstractGenericTypeUtil.class,
              GENERIC_TYPE_UTIL_EXTENSION_POINT, GENERIC_TYPE_UTIL_POINT_PROPERTY); 
      _genericTypeUtil = d.getContributedSingleton();
    }
    return _genericTypeUtil;
  }
  
}
