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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection;


/**
 * A specification of a template pattern via a bijection from elements to
 * elements of the pattern.
 * @author Olivier Constant
 */
public interface IBijectiveTemplatePatternSpecification extends IRoleBasedSpecification,
IPatternBasedBijection {
  
  // Nothing specific
  
}
