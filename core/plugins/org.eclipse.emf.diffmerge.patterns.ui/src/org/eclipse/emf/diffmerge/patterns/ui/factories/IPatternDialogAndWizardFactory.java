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
package org.eclipse.emf.diffmerge.patterns.ui.factories;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Shell;


/**
 * A factory that will instantiate the proper dialogs and wizards depending on the modeling environment.
 * @author Skander Turki
 */
public interface IPatternDialogAndWizardFactory {
  
  /**
   * Return the pattern browsing wizard
   * @param instances_p a non-null set
   * @param selection_p a non-null list
   * @param diagram_p a non-null diagram
   * @param shell_p a non-null shell
   * @param dialogTitle_p a non-null title
   * @param dialogMessage_p a non-null message
   * @return a non-null object
   */
  HighlightAllPatternsInstancesPanelDialog instantiateHighlightAllPatternsInstancesPanelDialog(
      Set<IPatternInstance> instances_p, List<Object> selection_p, Object diagram_p, 
      Shell shell_p, String dialogTitle_p, String dialogMessage_p);
  
  /**
   * Return the pattern browsing wizard
   * @param context_p a non-null context element
   * @param pattern_p a non-null pattern
   * @return a non-null object
   */
  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(EObject context_p, TemplatePattern pattern_p);
  
  /**
   * Return the pattern browsing wizard
   * @param context_p a non-null context element
   * @param repository_p a non-null pattern repository
   * @return a non-null object
   */
  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(EObject context_p, IPatternRepository repository_p);
  
  /**
   * Return the pattern browsing wizard
   * @param context_p a non-null context object
   * @param repository_p a non-null pattern repository
   * @return a non-null object
   */
  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(Object context_p, IPatternRepository repository_p);
  
  /**
   * Return the pattern browsing wizard
   * @param rset_p a non-null resource set
   * @param repository_p a non-null pattern repository
   * @return a non-null object
   */
  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(ResourceSet rset_p, IPatternRepository repository_p);
  
}
