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
package org.eclipse.emf.diffmerge.patterns.core.api;


/**
 * A provider of an object defining a scope in a user model.
 * @author Olivier Constant
 */
public interface IUserScopeProvider {
  
  /**
   * Return a model element, resource or resource set defining a context in a user model.
   * @return an object which is normally not null
   */
  Object getScopeElement();
  
}
