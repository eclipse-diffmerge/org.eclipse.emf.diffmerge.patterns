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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.ui.util.PatternsInstancesUIUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Shell;

/**
 * A Sirius-specific utility class for services related to pattern instances in diagrams
 * @author Olivier Constant
 * @author Skander TURKI
 */
public class SiriusPatternsInstancesUtil {


/**
 * Returns a set of IPatternInstance objects present in the given graphical context 
 * @param graphicalContext_p a potentially null DDiagram
 * @param element_p a potentially null EObject
 * @param shell_p 
 * @return a non-null HashSet of IPatternInstance objects
 */
  public static Set<IPatternInstance> getPresentInstances(Object graphicalContext_p, EObject element_p, Shell shell_p) {
    Set<IPatternInstance> instances = new HashSet<IPatternInstance>();
    IPatternSupport support = null;
    if(graphicalContext_p instanceof DDiagram){
      if (element_p != null) {
        support = CorePatternsPlugin.getDefault().getPatternSupportFor(element_p);
      }
      if (support == null) {
        PatternsInstancesUIUtil.informNoPatternSupport(shell_p);
      } else if (graphicalContext_p instanceof DSemanticDecorator) {
          instances.addAll(getIncludedPatternInstances(support, (DSemanticDecorator) graphicalContext_p));
        }
    }
    return instances;
  }

  
  /**
   * Returns pattern instances included in the semantic decorator
   * @param support_p a non-null IPatternSupport
   * @param semanticDecorator_p a non-null DSemanticDecorator
   * @return a non-null HashSet of IPatternInstance objects
   */
    private static Set<IPatternInstance> getIncludedPatternInstances(IPatternSupport support_p,
        DSemanticDecorator semanticDecorator_p) {
      Set<IPatternInstance> res = new HashSet<IPatternInstance>();
      List<IPatternInstance> currentElementInstances = support_p.getRelatedInstances(semanticDecorator_p.getTarget());
      if (!currentElementInstances.isEmpty()) {
        res.addAll(currentElementInstances);
      }
      if (semanticDecorator_p instanceof DDiagram) {
        DDiagram diagram = (DDiagram) semanticDecorator_p;
        for (DDiagramElement part : diagram.getDiagramElements()) {
          res.addAll(getIncludedPatternInstances(support_p, part));
        }
      } else if (semanticDecorator_p instanceof DNodeContainer) {
        for (DDiagramElement part : ((DNodeContainer) semanticDecorator_p).getOwnedDiagramElements()) {
          res.addAll(getIncludedPatternInstances(support_p, part));
        }
      }

      return res;
    } 
  
}
