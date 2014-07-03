/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui;

import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.diffmerge.patterns.ui.environment.DefaultModelEnvironmentUI;
import org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI;
import org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternActionFactory;
import org.eclipse.emf.diffmerge.patterns.ui.factories.AbstractPatternPageFactory;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternJobFactory;
import org.eclipse.emf.diffmerge.patterns.ui.misc.PersistentSelection;
import org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import org.eclipse.emf.diffmerge.patterns.core.SingletonContributionDiscoverer;

/**
 * The activator class controls the plug-in life cycle
 * @author Olivier Constant
 * @author Skander TURKI
 */
public class PatternsUIPlugin extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.eclipse.emf.diffmerge.patterns.ui"; //$NON-NLS-1$

  // The shared instance
  private static PatternsUIPlugin plugin;

  /** IDs related to the Model Environment UI extension point */
  private static final String MODEL_ENVIRONMENT_UI_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.modelenvironmentui"; //$NON-NLS-1$
  private static final String MODEL_ENVIRONMENT_UI_POINT_PROPERTY = "class"; //$NON-NLS-1$


 




  /** The current Operation Factory (may not be null) */
  private AbstractPatternActionFactory<?, ?, ?, ? ,? ,?, ?> _patternActionFactory;

  /** IDs related to the Operation Factory extension point */
  private static final String ACTION_FACTORY_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.actionFactory"; //$NON-NLS-1$
  private static final String ACTION_FACTORY_POINT_PROPERTY = "class"; //$NON-NLS-1$

  
  /** The current Job Factory (may not be null) */
  private IPatternJobFactory _patternJobFactory;

  /** IDs related to the Job Factory extension point */
  private static final String JOB_FACTORY_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.jobFactory"; //$NON-NLS-1$
  private static final String JOB_FACTORY_POINT_PROPERTY = "class"; //$NON-NLS-1$

  
  /** The current Page Factory (may not be null) */
  private AbstractPatternPageFactory _patternPageFactory;

  /** IDs related to the Page Factory extension point */
  private static final String PAGE_FACTORY_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.pageFactory"; //$NON-NLS-1$
  private static final String PAGE_FACTORY_POINT_PROPERTY = "class"; //$NON-NLS-1$
  

  /** The current Dialog and Wizard Factory (may not be null) */
  private IPatternDialogAndWizardFactory<?, ?, ? ,? ,?, ?> _patternDialogAndWizardFactory;

  /** IDs related to the DialogAndWizard Factory extension point */
  private static final String DIALOG_AND_WIZARD_FACTORY_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.dialogAndWizardFactory"; //$NON-NLS-1$
  private static final String DIALOG_AND_WIZARD_FACTORY_POINT_PROPERTY = "class"; //$NON-NLS-1$

  
  /** The current UIExtender (may not be null) */
  private IUIExtender _uiExtender;

  /** IDs related to the UIExtender extension point */
  private static final String UI_EXTENDER_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.ui.uiExtender"; //$NON-NLS-1$
  private static final String UI_EXTENDER_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  

  /** The path to the icons **/
  private static final String ICON_PATH = "icons/full/"; //$NON-NLS-1$

  /** Identifiers for UI images */
  public static enum ImageID {
    CATALOG, PATTERN, INSTANCE, COLLAPSEALL, EXPANDALL, REFRESH, SORT }

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

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    initializeIcons();
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
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
   * Return the action Factory registered in the platform
   * @return a non-null AbstractPatternActionFactory
   */
  public AbstractPatternActionFactory<?, ?, ? ,? ,?, ?, ?> getActionFactory() {
    if(_patternActionFactory == null){
      SingletonContributionDiscoverer<AbstractPatternActionFactory<?, ?, ?, ? ,? ,?, ?>> d = 
          new SingletonContributionDiscoverer<AbstractPatternActionFactory<?, ?, ?, ? ,? ,?, ?>>(AbstractPatternActionFactory.class,
              ACTION_FACTORY_EXTENSION_POINT, ACTION_FACTORY_POINT_PROPERTY); 
      _patternActionFactory = d.getContributedSingleton();
    }
    return _patternActionFactory;
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
  public IPatternDialogAndWizardFactory<?, ?, ?, ?, ?, ?> getDialogAndWizardFactory() {
    if(_patternDialogAndWizardFactory == null){
      SingletonContributionDiscoverer<IPatternDialogAndWizardFactory<?, ?, ?, ?, ?, ?>> d = 
          new SingletonContributionDiscoverer<IPatternDialogAndWizardFactory<?, ?, ?, ?, ?, ?>>(IPatternDialogAndWizardFactory.class,
              DIALOG_AND_WIZARD_FACTORY_EXTENSION_POINT, DIALOG_AND_WIZARD_FACTORY_POINT_PROPERTY); 
      _patternDialogAndWizardFactory = d.getContributedSingleton();
    }
    return _patternDialogAndWizardFactory;
  }

  /**
   * Return the Page Factory registered in the platform
   * @return a non-null AbstractPatternPageFactory
   */
  public AbstractPatternPageFactory getPageFactory() {
    if(_patternPageFactory == null){
      SingletonContributionDiscoverer<AbstractPatternPageFactory> d = 
          new SingletonContributionDiscoverer<AbstractPatternPageFactory>(AbstractPatternPageFactory.class,
              PAGE_FACTORY_EXTENSION_POINT, PAGE_FACTORY_POINT_PROPERTY); 
      _patternPageFactory = d.getContributedSingleton();
    }
    return _patternPageFactory;
  }
  
  /**
   * Return the Page Factory registered in the platform
   * @return a non-null AbstractPatternPageFactory
   */
  public IUIExtender getSemanticUIUtil() {
    if(_uiExtender == null){
      SingletonContributionDiscoverer<IUIExtender> d = 
          new SingletonContributionDiscoverer<IUIExtender>(IUIExtender.class,
              UI_EXTENDER_EXTENSION_POINT, UI_EXTENDER_POINT_PROPERTY); 
      _uiExtender = d.getContributedSingleton();
    }
    return _uiExtender;
  }
 
}
