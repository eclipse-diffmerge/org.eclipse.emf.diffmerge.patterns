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
