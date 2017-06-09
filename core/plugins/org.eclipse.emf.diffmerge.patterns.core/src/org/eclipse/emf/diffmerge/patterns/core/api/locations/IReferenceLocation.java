/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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

import org.eclipse.emf.ecore.EReference;

/**
 * A location which is relative to a specific reference setting.
 * @author Olivier Constant
 */
public interface IReferenceLocation extends IElementRelativeLocation {
  
  /**
   * Return the reference to which this location is relative
   * @return a potentially null reference, where null means ill-formed
   */
  EReference getReference();
  
}
