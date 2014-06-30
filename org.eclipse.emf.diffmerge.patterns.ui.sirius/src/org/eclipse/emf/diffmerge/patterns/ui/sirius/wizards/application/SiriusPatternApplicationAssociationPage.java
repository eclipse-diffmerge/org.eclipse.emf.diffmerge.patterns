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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.application;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternApplicationSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationAssociationPage;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.Layer;

/**
 * A Sirius-specific wizard page for applying an existing pattern.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusPatternApplicationAssociationPage extends AbstractPatternApplicationAssociationPage<DDiagram>{

  public SiriusPatternApplicationAssociationPage(
      TemplatePatternApplicationSpecification data_p, DDiagram diagram_p) {
    super(data_p, diagram_p);
  }

  /**
   * Return whether the "show instance" option should be available
   */
  @Override
  protected boolean isShowInstanceEnabled() {
    boolean result = _diagram != null;
    if (result) {
      DiagramDescription description = _diagram.getDescription();
      if (description != null) {
        // Return false iff all available mappings are synchronized
        Collection<DiagramElementMapping> allMappings = new FOrderedSet<DiagramElementMapping>();
        for (Layer activeLayer : _diagram.getActivatedLayers()) {
          allMappings.addAll(activeLayer.getContainerMappings());
          allMappings.addAll(activeLayer.getNodeMappings());
          allMappings.addAll(activeLayer.getEdgeMappings());
        }
        Iterator<DiagramElementMapping> it = allMappings.iterator();
        result = false;
        while (!result && it.hasNext()) {
          DiagramElementMapping current = it.next();
          result = !current.isSynchronizationLock();
        }
      }
    }
    return result;
  }
  
}
