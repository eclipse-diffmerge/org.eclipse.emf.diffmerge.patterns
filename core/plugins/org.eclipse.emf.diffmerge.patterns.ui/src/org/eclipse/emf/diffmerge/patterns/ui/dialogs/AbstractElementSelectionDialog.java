/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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

import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;


/**
 * This dialog requires the user to choose a model element among a set of
 * predefined ones. The elements are presented within their model tree.
 * @param <T> the type of the expected result after the user clicked OK
 * @author Olivier Constant
 */
public abstract class AbstractElementSelectionDialog<T> extends MessageDialog {
	
  /** The non-null set of elements the user may select */
	protected final Collection<? extends EObject> _candidates;
	
	/** The viewer for the locations */
	protected ModelSubsetViewer _viewer;
	
	/**
	 * Constructor.
	 * @param parentShell_p the non-null shell for this dialog
	 * @param message_p the non-null prompt message to display
	 * @param proposed_p the non-null set of elements the user may select 
	 */
	public AbstractElementSelectionDialog(Shell parentShell_p, String message_p,
	    Collection<? extends EObject> proposed_p) {
		super(parentShell_p, CorePatternsPlugin.getDefault().getLabel(), null,
		    message_p, MessageDialog.QUESTION, 
				new String[] {IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL}, 0);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		_candidates = new FOrderedSet<EObject>(proposed_p);
	}
	
	/**
	 * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(Composite)
	 */
	@Override
  protected Control createCustomArea(Composite parent_p) {
    _viewer = getChoiceViewer(parent_p);
    getShell().setSize(600, 600);
    UIUtil.centerShell(getShell());
    if (initiallySelectFirst())
      _viewer.selectFirst();
    _viewer.addSelectionListener(new ISelectionChangedListener() {
      /**
       * Whenever selection changes, update the enabled state of the OK button
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent e_p) {
        boolean okEnabled = false;
        if (e_p.getSelection() instanceof ITreeSelection) {
          ITreeSelection sel = (ITreeSelection)e_p.getSelection();
          if (!sel.isEmpty()) {
            TreePath[] paths = sel.getPaths();
            okEnabled = true;
            for (int i=0; i<paths.length; i++) {
              TreePath path = paths[i];
              Object last = path.getLastSegment();
              if (last instanceof EObject) {
                EObject elt = (EObject)last;
                okEnabled = _viewer.isValid(elt) && isEligible(elt);
                if (!okEnabled) break;
              }
            }
          }
        }
        getOkButton().setEnabled(okEnabled);
      }
    });
    return _viewer.getControl();
  }
	
	/**
	 * Return the viewer for this dialog.
	 * Override if needed.
	 */
	protected ModelSubsetViewer getChoiceViewer(Composite parent_p) {
	  ModelSubsetViewer result = new ModelSubsetViewer(parent_p, false, true);
	  result.setInput(_candidates);
	  return result;
	}
	
	/**
	 * Return the result of the user's choice
	 */
	public abstract T getChoice();
	
	/**
	 * Return the OK button of the dialog
	 * @return a non-null button
	 */
	protected Button getOkButton() {
	  return getButton(0);
	}
	
  /**
   * Return whether the first eligible element must be used as initial selection
   */
  protected boolean initiallySelectFirst() {
    return true;
  }
  
	/**
	 * Return whether the "OK button" must be enabled when the given element
	 * is being selected
	 * @param element_p a non-null element
	 */
	protected boolean isEligible(EObject element_p) {
	  return true;
	}
	
}
