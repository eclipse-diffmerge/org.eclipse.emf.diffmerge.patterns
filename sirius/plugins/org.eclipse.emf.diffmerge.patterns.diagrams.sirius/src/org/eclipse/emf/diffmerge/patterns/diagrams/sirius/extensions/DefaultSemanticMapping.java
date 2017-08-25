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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.extensions;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util.SiriusUtil;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;


/**
 * A straightforward implementation of ISemanticMapping involving no business logics.
 * @author Olivier Constant
 */
public class DefaultSemanticMapping implements ISiriusSemanticMapping {
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.extensions.ISemanticMapping#conformsToMapping(org.eclipse.emf.ecore.EObject, java.lang.Object, boolean, boolean, java.lang.Object)
   */
  public boolean conformsToMapping(EObject semanticElt_p, AbstractNodeMapping mapping_p,
      boolean considerPrecondition_p, boolean considerCandidates_p, Object containerView_p) {
    return SiriusUtil.conformsToMapping(
        semanticElt_p, mapping_p, considerPrecondition_p, considerCandidates_p, containerView_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.extensions.ISemanticMapping#getSemanticCandidatesForGraphicalStorage(org.eclipse.emf.ecore.EObject, java.lang.Object)
   */
  public Collection<EObject> getSemanticCandidatesForGraphicalStorage(
      EObject element_p, Object diagram_p) {
    Collection<EObject> result = new FOrderedSet<EObject>();
    EObject container = element_p.eContainer();
    if (container != null)
      result.add(container);
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.extensions.ISemanticMapping#getSemanticSelection(java.lang.Object)
   */
  public Collection<EObject> getSemanticSelection(Object decorator_p) {
    if(decorator_p instanceof DSemanticDecorator)
      return Collections.singleton(((DSemanticDecorator)decorator_p).getTarget());
    return Collections.emptyList();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.extensions.ISemanticMapping#getSemanticStorage(java.lang.Object)
   */
  public EObject getSemanticStorage(Object decorator_p) {
    if(decorator_p instanceof DSemanticDecorator)
      return ((DSemanticDecorator)decorator_p).getTarget();
    return null;
  }
  
}
