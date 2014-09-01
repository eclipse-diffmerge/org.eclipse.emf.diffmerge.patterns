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
package org.eclipse.emf.diffmerge.patterns.diagram.sirius.extensions;

import org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;


/**
 * A Sirius-specific semantic mapping that provides information about the relationship between diagrammatic
 * and semantic elements and their representation for a given modeling tool.
 * @author Skander TURKI
 */
public interface ISiriusSemanticMapping extends ISemanticMapping<AbstractNodeMapping>{

  //Nothing: Specifies generic types
}
