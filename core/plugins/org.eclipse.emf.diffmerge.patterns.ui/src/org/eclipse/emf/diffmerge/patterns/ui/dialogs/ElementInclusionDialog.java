/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationScope.PatternInstanceMarkerFilter;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.structures.common.FArrayList;
import org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;


/**
 * This class defines a dialog which allows the user to select model elements for
 * addition into a given model scope.
 * @author Olivier Constant
 */
public class ElementInclusionDialog extends
AbstractElementSelectionDialog<Collection<EObject>> {
	
	/** The non-null type of the element to merge */
	protected final IModelScope _scope;
	
	/** The initial selection */
	protected final Collection<? extends EObject> _initialSelection;
	
	
  /**
   * Constructor.
   * @param parentShell_p the non-null shell for this dialog
   * @param message_p a optional prompt message to display (default if null)
   * @param context_p a non-null element belonging to the model to cover
   * @param initialSelection_p the non-null, potentially empty initial selection
   * @param scope_p a non-null model scope for restricting eligibility
   */
  public ElementInclusionDialog(Shell parentShell_p, String message_p, EObject context_p,
      Collection<? extends EObject> initialSelection_p, IModelScope scope_p) {
    this(parentShell_p, message_p, getRelevantElements(context_p),
        initialSelection_p, scope_p);
  }
  
  /**
   * Return the relevant candidate elements from the given context element
   * @param context_p a non-null element belonging to the model to cover
   * @return a non-null, potentially empty collection
   */
  protected static List<EObject> getRelevantElements(EObject context_p) {
    List<EObject> result = new FArrayList<EObject>();
    Collection<EObject> roots;
    ISemanticRuleProvider ruleProvider =
      TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(context_p);
    if (ruleProvider == null)
      roots = Collections.singleton(EcoreUtil.getRootContainer(context_p));
    else
      roots = ruleProvider.getRootsForPatternInclusion(context_p);
    IElementFilter filter = new PatternInstanceMarkerFilter();
    if(roots != null){
    	for (EObject root : roots) {
    		if (filter.accepts(root)) {
    			result.add(root);
    	        TreeIterator<EObject> it = root.eAllContents();
    	        while (it.hasNext()) {
    	        	EObject current = it.next();
    	        	if (filter.accepts(current))
    	        		result.add(current);
    	        	else
    	        		it.prune();
    	      	}
    	 	}
    	}	
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Constructor.
   * @param parentShell_p the non-null shell for this dialog
   * @param message_p a optional prompt message to display (default if null)
   * @param candidates_p a non-null, potentially empty set of elements
   * @param initialSelection_p the non-null, potentially empty initial selection
   * @param scope_p a non-null model scope for restricting eligibility
   */
  public ElementInclusionDialog(Shell parentShell_p, String message_p,
      Collection<? extends EObject> candidates_p,
      Collection<? extends EObject> initialSelection_p, IModelScope scope_p) {
    super(parentShell_p, message_p == null? Messages.ElementInclusionDialog_Prompt: message_p,
        candidates_p);
    _initialSelection = initialSelection_p;
    _scope = scope_p;
  }
  
  /**
   * @see org.eclipse.jface.dialogs.IconAndMessageDialog#createContents(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createContents(Composite parent_p) {
    Control result = super.createContents(parent_p);
    _viewer.select(_initialSelection.toArray());
    return result;
  }
  
/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#getChoice()
 */
	@Override
	public Collection<EObject> getChoice() {
	  return _viewer.getChoices();
	}
	
/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#getChoiceViewer(org.eclipse.swt.widgets.Composite)
 */
	@Override
  protected ModelSubsetViewer getChoiceViewer(Composite parent_p) {
	  ModelSubsetViewer result = new ModelSubsetViewer(parent_p, true, true);
	  result.setInput(_candidates);
	  return result;
  }
  
/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#initiallySelectFirst()
 */
	@Override
  protected boolean initiallySelectFirst() {
    return false;
  }
  
/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#isEligible(org.eclipse.emf.ecore.EObject)
 */
  @Override
  protected boolean isEligible(EObject element_p) {
    return !_scope.covers(element_p);
  }
  
}
