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

import java.util.List;


/**
 * A location which is composed of atomic locations.
 * @author Olivier Constant
 */
public interface ICompositeLocation extends ILocation {
  
  /**
   * Return the locations that this location is composed of
   * @return a non-null, potentially empty, modifiable list of atomic locations
   */
  List<IAtomicLocation> getOwnedLocations();
  
}
