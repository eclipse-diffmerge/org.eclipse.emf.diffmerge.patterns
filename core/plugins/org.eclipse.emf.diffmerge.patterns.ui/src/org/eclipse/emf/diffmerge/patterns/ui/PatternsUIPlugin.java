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
package org.eclipse.emf.diffmerge.patterns.ui;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.diffmerge.patterns.core.SingletonContributionDiscoverer;
import org.eclipse.emf.diffmerge.patterns.ui.environment.DefaultModelEnvironmentUI;
import org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.misc.PersistentSelection;
import org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 * @author Olivier Constant
 * @author Skander Turki
 */
public class PatternsUIPlugin extends AbstractUIPlugin {

  /** The plug-in ID */
  public static final String PLUGIN_ID = "org.eclipse.emf.diffmerge.patterns.ui"; //$NON-NLS-1$

  /** The shared instance */
  private static PatternsUIPlugin plugin;

  /** ID related to the Model Environment UI extension point */
  private static final String MODEL_ENVIRONMENT_UI_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.modelenvironmentui"; //$NON-NLS-1$
  /** ID related to the Model Environment UI extension point */
  private static final String MODEL_ENVIRONMENT_UI_POINT_PROPERTY = "class"; //$NON-NLS-1$

  
  /** The current Job Factory (may not be null) */
  private IPatternJobFactory _patternJobFactory;

  /** ID related to the Job Factory extension point */
  private static final String JOB_FACTORY_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.jobFactory"; //$NON-NLS-1$
  /** ID related to the Job Factory extension point */
  private static final String JOB_FACTORY_POINT_PROPERTY = "class"; //$NON-NLS-1$


  /** The current Dialog and Wizard Factory (may not be null) */
  private IPatternDialogAndWizardFactory _patternDialogAndWizardFactory;

  /** ID related to the DialogAndWizard Factory extension point */
  private static final String DIALOG_AND_WIZARD_FACTORY_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.dialogAndWizardFactory"; //$NON-NLS-1$
  /** ID related to the DialogAndWizard Factory extension point */
  private static final String DIALOG_AND_WIZARD_FACTORY_POINT_PROPERTY = "class"; //$NON-NLS-1$

  
  /** The current UIExtender (may not be null) */
  private IUIExtender _uiExtender;

  /** ID related to the UIExtender extension point */
  private static final String UI_EXTENDER_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.uiextender"; //$NON-NLS-1$
  /** ID related to the UIExtender extension point */
  private static final String UI_EXTENDER_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  

  /** The path to the icons **/
  private static final String ICON_PATH = "icons/full/"; //$NON-NLS-1$

  /** Identifiers for UI images */
  public static enum ImageID {
    /** The catalog image */
    CATALOG,
    /** The pattern image */
    PATTERN,
    /** The instance image */
    INSTANCE,
    /** The "collapse all" image */
    COLLAPSEALL,
    /** The "expand all" image */
    EXPANDALL,
    /** The refresh image */
    REFRESH,
    /** The sort image */
    SORT
  }

  /** The current model environment UI services provider (may be null) */
  private IModelEnvironmentUI _modelEnvironmentUI;


  /** The non-null process for defining a pattern application */
  private final PersistentSelection _persistentSelection;

  /**
   * The constructor
   */
  public PatternsUIPlugin() {
    _persistentSelection = new PersistentSelection();
  }
  
  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    plugin = this;
    initializeIcons();
  }
  
  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {
    plugin = null;
    super.stop(context_p);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static PatternsUIPlugin getDefault() {
    return plugin;
  }

  /**
   * Return the image of the given ID
   * @param id_p a non-null image ID
   * @return a (normally) non-null image
   */
  public Image getImage(ImageID id_p) {
    return getImageRegistry().get(id_p.name());
  }

  /**
   * Return the image descriptor of the given ID
   * @param id_p a non-null image ID
   * @return a (normally) non-null image
   */
  public ImageDescriptor getImageDescriptor(ImageID id_p) {
    return getImageRegistry().getDescriptor(id_p.name());
  }

  /**
   * Initialize the icons
   */
  private void initializeIcons() {
    for (ImageID imageId : ImageID.values()) {
      registerLocalIcon(imageId);
    }
  }

  /**
   * Register and return the image descriptor obtained from the given ID of a local icon
   * @param imageID_p a non-null image ID
   * @return a potentially null image descriptor
   */
  private ImageDescriptor registerLocalIcon(ImageID imageID_p) {
    ImageDescriptor result = null;
    String path = ICON_PATH + imageID_p.name().toLowerCase() + ".gif"; //$NON-NLS-1$
    try {
      result = ImageDescriptor.createFromURL(FileLocator.toFileURL(
          getBundle().getEntry(path)));
    } catch (IOException e) {
      // Nothing needed
    }
    if (result != null)
      getImageRegistry().put(imageID_p.name(), result);
    return result;
  }

  /**
   * Return the persistent, cross-diagram selection
   * @return a non-null persistent selection
   */
  public PersistentSelection getPersistentSelection() {
    return _persistentSelection;
  }

  /**
   * Return the model environment contribution registered in the platform
   * @return a non-null IModelEnvironmentUI
   */
  public IModelEnvironmentUI getModelEnvironmentUI() {
    if (_modelEnvironmentUI == null){
      SingletonContributionDiscoverer<IModelEnvironmentUI> d = 
          new SingletonContributionDiscoverer<IModelEnvironmentUI>(IModelEnvironmentUI.class,
              MODEL_ENVIRONMENT_UI_EXTENSION_POINT, MODEL_ENVIRONMENT_UI_POINT_PROPERTY); 
      _modelEnvironmentUI = d.getContributedSingleton();
    }
    if (_modelEnvironmentUI == null)
      _modelEnvironmentUI = new DefaultModelEnvironmentUI();
    return _modelEnvironmentUI;
  }

  
  /**
   * Return the dialog and wizard Factory registered in the platform
   * @return a non-null IPatternDialogAndWizardFactory
   */
  public IPatternJobFactory getJobFactory() {
    if(_patternJobFactory == null){
      SingletonContributionDiscoverer<IPatternJobFactory> d = 
          new SingletonContributionDiscoverer<IPatternJobFactory>(IPatternJobFactory.class,
              JOB_FACTORY_EXTENSION_POINT, JOB_FACTORY_POINT_PROPERTY); 
      _patternJobFactory = d.getContributedSingleton();
    }
    return _patternJobFactory;
  }

  /**
   * Return the dialog and wizard Factory registered in the platform
   * @return a non-null IPatternDialogAndWizardFactory
   */
  public IPatternDialogAndWizardFactory getDialogAndWizardFactory() {
    if(_patternDialogAndWizardFactory == null){
      SingletonContributionDiscoverer<IPatternDialogAndWizardFactory> d = 
          new SingletonContributionDiscoverer<IPatternDialogAndWizardFactory>(IPatternDialogAndWizardFactory.class,
              DIALOG_AND_WIZARD_FACTORY_EXTENSION_POINT, DIALOG_AND_WIZARD_FACTORY_POINT_PROPERTY); 
      _patternDialogAndWizardFactory = d.getContributedSingleton();
    }
    return _patternDialogAndWizardFactory;
  }
 
  /**
   * Return the Page Factory registered in the platform
   * @return a non-null IUIExtender
   */
  public IUIExtender getSemanticUIUtil() {
    if(_uiExtender == null){
      IExtensionRegistry registry = Platform.getExtensionRegistry();
      IConfigurationElement[] config = registry.getConfigurationElementsFor(
          UI_EXTENDER_EXTENSION_POINT);
      Set<IUIExtender> extenders = new HashSet<IUIExtender>();
      // Discover all contributions
      for (IConfigurationElement e : config) {
        try {
          Object o = e.createExecutableExtension(UI_EXTENDER_POINT_PROPERTY);
          if (o instanceof IUIExtender)
            extenders.add((IUIExtender)o);
        } catch (CoreException ex) {
          // Proceed
        }
      }
      // Filtering out overridden ones
      Set<Class<? extends IUIExtender>> overriddenClasses = new HashSet<Class<? extends IUIExtender>>();
      for (IUIExtender extender : extenders) {
        overriddenClasses.addAll(extender.getOverridenClasses());
      }
      for (IUIExtender extender : new HashSet<IUIExtender>(extenders)) {
        for (Class<? extends IUIExtender> overriddenClass : overriddenClasses) {
          if (extender.getClass().equals(overriddenClass))
            extenders.remove(extender);
        }
      }
      if (!extenders.isEmpty())
        _uiExtender = extenders.iterator().next();
    }
    return _uiExtender;
  }
 
}
