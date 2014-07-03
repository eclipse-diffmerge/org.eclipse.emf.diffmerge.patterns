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

import org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.InstancePanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.application.AbstractPatternApplicationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.creation.AbstractPatternCreationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateCreationWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateUsageWizard;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.update.AbstractPatternUpdateWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternCreationSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;

/**
 * A factory that will instantiate the proper dialogs and wizards depending on the design environment
 * @author Skander TURKI
 *
 */
public interface IPatternDialogAndWizardFactory<DiagramElementType, DiagramType> {



  HighlightAllPatternsInstancesPanelDialog<DiagramType, DiagramElementType> 
  instantiateHighlightAllPatternsInstancesPanelDialog(
      Set<IPatternInstance> instances_p, List<Object> selection_p, DiagramType diagram_p, Shell shell_p, String dialogTitle_p, String dialogMessage_p);

  InstancePanelDialog<DiagramElementType, DiagramType> 
  instantiateInstancePanelDialog(List<IPatternInstance> instances_p, EObject referenceElement_p, 
      DiagramType diagram_p, List<Object> graphicalContext_p, Shell shell_p);

  AbstractPatternApplicationWizard<DiagramElementType, DiagramType>
  instantiatePatternApplicationWizard(List<Object> selection_p, DiagramType diagram_p);


  AbstractPatternBrowsingWizard<DiagramElementType, DiagramType>
  instantiatePatternBrowsingWizard(EObject context_p, TemplatePattern pattern_p);

  AbstractPatternBrowsingWizard<DiagramElementType, DiagramType>
  instantiatePatternBrowsingWizard(EObject context_p, IPatternRepository repository_p);

  AbstractPatternBrowsingWizard<DiagramElementType, DiagramType>
  instantiatePatternBrowsingWizard(Object context_p, IPatternRepository repository_p);

  AbstractPatternBrowsingWizard<DiagramElementType, DiagramType>
  instantiatePatternBrowsingWizard(ResourceSet rset_p, IPatternRepository repository_p);

  AbstractTemplateCreationWizard<DiagramElementType, DiagramType>
  instantiateTemplateCreationWizard(List<Object> selection_p, List<Object> graphicalContext_p);

  AbstractPatternUpdateWizard<DiagramElementType, DiagramType>
  instantiatePatternUpdateWizard(
      IPatternInstance instance_p, EObject referenceElement_p,
      List<Object> graphicalContext_p,
      List<EStructuralFeature> featuresToIgnore_p);

  PatternWizardDialog instantiatePatternWizardDialog(Shell shell_p, 
      AbstractPatternCreationWizard<DiagramElementType, DiagramType> _wizard);

  AbstractPatternCreationWizard<DiagramElementType, DiagramType>
  instantiatePatternCreationWizard(
      List<Object> selection_p, List<Object> graphicalContext_p,
      TemplatePatternCreationSpecification patternCreationSpecification_p,
      boolean createNextBackButtons_p);

  AbstractTemplateUsageWizard<DiagramElementType, DiagramType>
  instantiateTemplateUsageWizard(
      AbstractModifiableTemplatePatternSpecification data_p);

}
