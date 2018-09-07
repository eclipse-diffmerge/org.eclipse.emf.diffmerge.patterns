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
