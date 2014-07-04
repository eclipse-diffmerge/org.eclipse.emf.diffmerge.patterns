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
 * A factory that will instantiate the proper dialogs and wizards depending on the design environment
 * @author Skander TURKI
 *
 */
public interface IPatternDialogAndWizardFactory {


  HighlightAllPatternsInstancesPanelDialog instantiateHighlightAllPatternsInstancesPanelDialog(
      Set<IPatternInstance> instances_p, List<Object> selection_p, Object diagram_p, 
      Shell shell_p, String dialogTitle_p, String dialogMessage_p);

  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(EObject context_p, TemplatePattern pattern_p);

  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(EObject context_p, IPatternRepository repository_p);

  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(Object context_p, IPatternRepository repository_p);

  AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(ResourceSet rset_p, IPatternRepository repository_p);

}
