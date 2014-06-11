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
package org.eclipse.emf.diffmerge.patterns.diagram;

import org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping;
import org.eclipse.emf.diffmerge.patterns.diagram.factories.IPatternOperationFactory;
import org.eclipse.emf.diffmerge.patterns.diagram.util.AbstractDiagramUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.eclipse.emf.diffmerge.patterns.core.SingletonContributionDiscoverer;

public class PatternCoreDiagramPlugin implements BundleActivator {

  // The shared instance
  private static PatternCoreDiagramPlugin plugin;
  
	private static BundleContext context;

  // The plug-in ID
  public static final String PLUGIN_ID = "org.eclipse.emf.diffmerge.patterns.diagram"; //$NON-NLS-1$
	
  /** The current diagram utility class (may not be null) */
  private AbstractDiagramUtil<?, ?, ?> _diagramUtil;

  /** IDs related to the diagram utility extension point */
  private static final String DIAGRAM_UTIL_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.diagram.diagramUtil"; //$NON-NLS-1$
  private static final String DIAGRAM_UTIL_POINT_PROPERTY = "class"; //$NON-NLS-1$
	
  
  /** The current semantic mapping (may be null) */
  private ISemanticMapping<?, ?, ?, ?> _semanticMapping;

  /** IDs related to the SemanticMapping extension point */
  private static final String SEMANTIC_MAPPING_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.diagram.semanticMapping"; //$NON-NLS-1$
  private static final String SEMANTIC_MAPPING_EXTENSION_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  

  /** The current Operation Factory (may not be null) */
  private IPatternOperationFactory<?, ?, ?, ?, ?, ?> _patternOperationFactory;

  /** IDs related to the Operation Factory extension point */
  private static final String OPERATION_FACTORY_EXTENSION_POINT =
      "org.eclipse.emf.diffmerge.patterns.diagram.operationFactory"; //$NON-NLS-1$
  private static final String OPERATION_FACTORY_POINT_PROPERTY = "class"; //$NON-NLS-1$
  
  /**
   * The constructor
   */
  public PatternCoreDiagramPlugin(){
    _semanticMapping = null;
  }
  
	static BundleContext getContext() {
		return context;
	}
	
  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static PatternCoreDiagramPlugin getDefault() {
    return plugin;
  }

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		PatternCoreDiagramPlugin.context = bundleContext;
    plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		PatternCoreDiagramPlugin.context = null;
	}

  /**
   * Return the diagram utility class registered in the platform
   * @return a non-null AbstractDiagramUtil
   */
  public AbstractDiagramUtil<?, ?, ?> getDiagramUtilityClass() {
    if(_diagramUtil == null){
      SingletonContributionDiscoverer<AbstractDiagramUtil<?, ?, ?>> d = 
          new SingletonContributionDiscoverer<AbstractDiagramUtil<?, ?, ?>>(AbstractDiagramUtil.class,
              DIAGRAM_UTIL_EXTENSION_POINT, DIAGRAM_UTIL_POINT_PROPERTY); 
      _diagramUtil = d.getContributedSingleton();
    }
    return _diagramUtil;
  }
  
  /**
   * Return the semantic mapping registered in the platform
   * @return a non-null semantic mapping
   */
  public ISemanticMapping<?, ?, ?, ?> getSemanticMapping() {
    if (_semanticMapping == null){
      SingletonContributionDiscoverer<ISemanticMapping<?, ?, ?, ?>> d = 
          new SingletonContributionDiscoverer<ISemanticMapping<?, ?, ?, ?>>(ISemanticMapping.class,
              SEMANTIC_MAPPING_EXTENSION_POINT, SEMANTIC_MAPPING_EXTENSION_POINT_PROPERTY); 
      _semanticMapping = d.getContributedSingleton();
    }
    return _semanticMapping;
  }
	
  
  /**
   * Return the Operation Factory registered in the platform
   * @return a non-null IPatternOperationFactory
   */
  public IPatternOperationFactory<?, ?, ?, ?, ?, ?> getOperationFactory() {
    if(_patternOperationFactory == null){
      SingletonContributionDiscoverer<IPatternOperationFactory<?, ?, ?, ?, ?, ?>> d = 
          new SingletonContributionDiscoverer<IPatternOperationFactory<?, ?, ?, ?, ?, ?>>(IPatternOperationFactory.class,
              OPERATION_FACTORY_EXTENSION_POINT, OPERATION_FACTORY_POINT_PROPERTY); 
      _patternOperationFactory = d.getContributedSingleton();
    }
    return _patternOperationFactory;
  }
  
}
