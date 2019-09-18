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
  private String _singletonContributionExtensionPoint;
  
  /** Property related to the Contributed Singleton extension point */
  private String _singletonContributionProperty;
  
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
    _singletonContributionExtensionPoint = factoryExtensionPointID_p;
    _singletonContributionProperty = factoryProperty_p;
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
        _singletonContributionExtensionPoint);
    for (IConfigurationElement e : config) {
      try {
        Object o = e.createExecutableExtension(_singletonContributionProperty);
        if (_type.cast(o)!=null)
          return (SingletonContributionType)o;
      } catch (Exception ex) {
        // Proceed
      }
    }
    return null;
  }
  
}
