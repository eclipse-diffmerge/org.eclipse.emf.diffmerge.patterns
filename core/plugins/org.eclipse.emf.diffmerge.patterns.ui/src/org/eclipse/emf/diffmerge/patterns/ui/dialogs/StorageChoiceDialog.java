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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractTableChoiceDialog.SelectionKind;
import org.eclipse.emf.diffmerge.structures.common.FArrayList;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;


/**
 * This class defines a dialog which requires the user to choose a location
 * (model element + containment) among a set of predefined ones in order to
 * store an element.
 * The locations are presented within their model tree. An additional dialog
 * is being used when necessary to disambiguate the containment.
 * @author Olivier Constant
 */
public class StorageChoiceDialog
extends AbstractElementSelectionDialog<IReferenceLocation> {

	/** The non-null, non-empty set of elements to store */
	protected final Collection<EObject> _toStore;

	/** The non-null type of the element(s) to store */
	protected final EClass _valueType;


	/**
	 * Constructor.
	 * @param parentShell_p the non-null shell for this dialog
	 * @param message_p the non-null prompt message to display
	 * @param proposed_p the non-null set of proposed containers
	 * @param toStore_p the non-null, non-empty set of elements to store
	 */
	public StorageChoiceDialog(Shell parentShell_p, String message_p,
			List<? extends EObject> proposed_p, Collection<? extends EObject> toStore_p) {
		super(parentShell_p, enforceTypeMessage(message_p, toStore_p), proposed_p);
		_toStore = new FArrayList<EObject>(toStore_p, null);
		_valueType = ModelsUtil.getCommonType(_toStore);
	}

	/**
	 * Return the given message if not null, otherwise a message applicable to the given type
	 * @param message_p a potentially null string
	 * @param values_p a the non-null, non-empty set of elements to store
	 * @return a non-null string
	 */
	protected static String enforceTypeMessage(String message_p,
			Collection<? extends EObject> values_p) {
		String result = message_p;
		if (result == null) {
			String name = "Unnamed"; //$NON-NLS-1$
			if(values_p != null){
				if(values_p.iterator().hasNext()){
					EObject obj = values_p.iterator().next();
					//Correction
                    ISemanticRuleProvider ruleProvider =
                                TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(obj);
                    EAttribute nameattr = ruleProvider.getNameAttribute(obj);
                    Object ename = (nameattr != null? obj.eGet(nameattr) : null);
                    name = (ename instanceof String? (String)ename : name);

				}
			}
			EClass type = ModelsUtil.getCommonType(values_p);
			String typeName = type != null? type.getName(): ""; //$NON-NLS-1$
			result = String.format(Messages.StorageChoiceDialog_PromptMulti, name,typeName);
		}
		return result;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#getChoice()
	 */
	@Override
	public IReferenceLocation getChoice() {
		IReferenceLocation result = null;
		EObject selected = _viewer.getChoice();
		if (selected != null) {
			ISemanticRuleProvider ruleProvider =
				TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(selected);
			List<EReference> candidates =
				ruleProvider.getReferencesForAddition(selected, _valueType, true, true);
			if(candidates != null){
				if (candidates.size() > 0) {
					result = new BasicReferenceLocation(selected, candidates.get(0));
				} else {
					AbstractTableChoiceDialog<EReference> dialog =
						new AbstractTableChoiceDialog<EReference>(getShell(),
								CorePatternsPlugin.getDefault().getLabel(),
								Messages.StorageChoiceDialog_PromptContainment, candidates, SelectionKind.SINGLE) {
						@Override
						protected List<String> getColumnHeaders() {
							return Arrays.asList(
									Messages.StorageChoiceDialog_Containment, Messages.StorageChoiceDialog_Origin);
						}
						@Override
						protected String getColumnText(EReference reference_p, int columnIndex_p) {
							switch(columnIndex_p) {
							case 0: return reference_p.getName();
							case 1: return reference_p.getEContainingClass().getName();
							default: return ""; //$NON-NLS-1$
							}
						}
						@Override
						protected int getColumnWidth(int columnNb_p) {
							return 200;
						}
					};
					int answer = dialog.open();
					if (Window.OK == answer) {
						result = new BasicReferenceLocation(selected, dialog.getChoice());
					}
				}
			}

		}
		return result;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.AbstractElementSelectionDialog#isEligible(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected boolean isEligible(EObject element_p) {
		ISemanticRuleProvider ruleProvider =
			TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(element_p);
		List<EReference> references = ruleProvider.getReferencesForAddition(
				element_p, _valueType, true, true);
		if(references != null){
			return !references.isEmpty();
		}
		return false;
	}

}
