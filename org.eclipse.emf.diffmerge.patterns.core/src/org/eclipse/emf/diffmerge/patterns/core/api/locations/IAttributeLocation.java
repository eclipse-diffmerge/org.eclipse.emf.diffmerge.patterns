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

import org.eclipse.emf.ecore.EAttribute;

/**
 * A location which is relative to a specific attribute setting.
 * @author Olivier Constant
 */
public interface IAttributeLocation extends IElementRelativeLocation {
  
  /**
   * Return the attribute to which this location is relative
   * @return a potentially null attribute, where null means ill-formed
   */
  EAttribute getAttribute();
  
}
