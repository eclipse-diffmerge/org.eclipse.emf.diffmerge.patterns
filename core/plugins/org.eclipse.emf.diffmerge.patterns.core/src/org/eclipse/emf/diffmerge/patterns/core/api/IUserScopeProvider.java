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
