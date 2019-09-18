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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.extensions;

import org.eclipse.emf.diffmerge.patterns.diagrams.extensions.ISemanticMapping;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;


/**
 * A Sirius-specific semantic mapping that provides information about the relationship between diagrammatic
 * and semantic elements and their representation for a given modeling tool.
 * @author Skander Turki
 */
public interface ISiriusSemanticMapping extends ISemanticMapping<AbstractNodeMapping>{

  //Nothing: Specifies generic types
}
