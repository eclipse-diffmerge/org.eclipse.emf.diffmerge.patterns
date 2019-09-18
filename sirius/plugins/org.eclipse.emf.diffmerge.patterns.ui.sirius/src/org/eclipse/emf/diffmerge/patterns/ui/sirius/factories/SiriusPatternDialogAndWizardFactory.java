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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.factories;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.dialogs.SiriusHighlightAllPatternsInstancesPanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.wizards.browsing.SiriusPatternBrowsingWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Shell;


/**
 * A Sirius-specific factory that will instantiate the proper dialogs and wizards depending on
 * the design environment.
 * @author Skander Turki
 */
public class SiriusPatternDialogAndWizardFactory implements IPatternDialogAndWizardFactory{
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiateHighlightAllPatternsInstancesPanelDialog(java.util.Set, java.util.List, java.lang.Object, org.eclipse.swt.widgets.Shell, java.lang.String, java.lang.String)
   */
  public SiriusHighlightAllPatternsInstancesPanelDialog instantiateHighlightAllPatternsInstancesPanelDialog(
      Set<IPatternInstance> instances_p, List<Object> selection_p, Object diagram_p, Shell shell_p, 
      String dialogTitle_p, String dialogMessage_p) {
    return   new SiriusHighlightAllPatternsInstancesPanelDialog(instances_p, diagram_p, shell_p, 
        dialogTitle_p, dialogMessage_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
   */
  public AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(EObject context_p, TemplatePattern pattern_p) {
    return new SiriusPatternBrowsingWizard(context_p, pattern_p) ;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(org.eclipse.emf.ecore.EObject, org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
   */
  public AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(
      EObject context_p, IPatternRepository repository_p) {
    return new SiriusPatternBrowsingWizard(context_p, repository_p) ;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(java.lang.Object, org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
   */
  public AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(
      Object context_p, IPatternRepository repository_p) {
    return new SiriusPatternBrowsingWizard(context_p, repository_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory#instantiatePatternBrowsingWizard(org.eclipse.emf.ecore.resource.ResourceSet, org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
   */
  public AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(
      ResourceSet rset_p, IPatternRepository repository_p) {
    return new SiriusPatternBrowsingWizard(rset_p, repository_p);
  }
  
}
