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
package org.eclipse.emf.diffmerge.patterns.core;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;


/**
 * A class that will discover the contribution singleton object contributed through the given extension point,
 * under the given extension point property and having the expected given type.
 * @author Skander Turki
 */
public class SingletonContributionDiscoverer<SingletonContributionType>{

  /** The current Contributed Singleton (may not null) */
  private SingletonContributionType _contributedSingleton;
  
  /** ID related to the Contributed Singleton extension point */
  private String SINGLETON_CONTRIBUTION_EXTENSION_POINT;
  
  /** Property related to the Contributed Singleton extension point */
  private String SINGLETON_CONTRIBUTION_PROPERTY;
  
  /** The expected type of the contributed object */
  private Class<?> _type;
  
  
  /**
   * Constructor
   * @param type the non-null expected type of the contributed object
   * @param factoryExtensionPointID_p the non-null ID related to the Contributed Singleton extension point
   * @param factoryProperty_p the non-null property related to the Contributed Singleton extension point
   */
  public SingletonContributionDiscoverer(Class<?> type, String factoryExtensionPointID_p, String factoryProperty_p){
    _type = type;
    SINGLETON_CONTRIBUTION_EXTENSION_POINT = factoryExtensionPointID_p;
    SINGLETON_CONTRIBUTION_PROPERTY = factoryProperty_p;
  }
  
  /**
   * Return the contributed object registered in the platform
   * @return a non-null SingletonContributionType
   */
  public SingletonContributionType getContributedSingleton() {
    if (_contributedSingleton == null)
      _contributedSingleton = discoverContributedSingleton();
    return _contributedSingleton;
  }
  
  /**
   * Discover the contributed singleton which is registered through the dedicated
   * extension point, if any
   * @return a potentially null SingletonContributionType
   */
  @SuppressWarnings("unchecked")
  private SingletonContributionType discoverContributedSingleton() {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] config = registry.getConfigurationElementsFor(
        SINGLETON_CONTRIBUTION_EXTENSION_POINT);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(SINGLETON_CONTRIBUTION_PROPERTY);
        if (_type.cast(o)!=null)
          return (SingletonContributionType)o;
      } catch (Exception ex) {
        // Proceed
      }
    }
    return null;
  }
  
}
