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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.SiriusUtil;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;


/**
 * A straightforward implementation of ISemanticMapping involving no business logics.
 * @author Olivier Constant
 */
public class DefaultSemanticMapping implements ISiriusSemanticMapping {

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping#conformsToMapping(org.eclipse.emf.ecore.EObject, fr.obeo.dsl.viewpoint.description.AbstractNodeMapping, boolean, boolean, fr.obeo.dsl.viewpoint.DContainer)
   */
  public boolean conformsToMapping(EObject semanticElt_p, AbstractNodeMapping mapping_p,
      boolean considerPrecondition_p, boolean considerCandidates_p, DContainer containerView_p) {
    return SiriusUtil.conformsToMapping(
        semanticElt_p, mapping_p, considerPrecondition_p, considerCandidates_p, containerView_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping#getSemanticCandidatesForGraphicalStorage(org.eclipse.emf.ecore.EObject, fr.obeo.dsl.viewpoint.DDiagram)
   */
  public Collection<EObject> getSemanticCandidatesForGraphicalStorage(
      EObject element_p, DDiagram diagram_p) {
    Collection<EObject> result = new FOrderedSet<EObject>();
    EObject container = element_p.eContainer();
    if (container != null)
      result.add(container);
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping#getSemanticSelection(fr.obeo.dsl.viewpoint.DSemanticDecorator)
   */
  public Collection<EObject> getSemanticSelection(DSemanticDecorator decorator_p) {
    return Collections.singleton(decorator_p.getTarget());
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.extensions.ISemanticMapping#getSemanticStorage(fr.obeo.dsl.viewpoint.DSemanticDecorator)
   */
  public EObject getSemanticStorage(DSemanticDecorator decorator_p) {
    return decorator_p.getTarget();
  }

}
