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
package org.eclipse.emf.diffmerge.patterns.core.api.locations;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * A location which is relative to a specific resource.
 * @author Olivier Constant
 */
public interface IResourceLocation extends IAtomicLocation {
  
  /**
   * Return the resource to which this location is relative
   * @return a potentially null resource, where null means ill-formed
   */
  Resource getResource();
  
}
