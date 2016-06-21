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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


/**
 * An abstract action which provides generic facilities.
 * @param <ObjectType> the type of the elements on which the action is applicable
 * @author Olivier Constant
 */
public abstract class AbstractContextualAction<ObjectType> implements IObjectActionDelegate {

  /** The current selection */
  private IStructuredSelection _selection;

  /** The current shell */
  private Shell _shell;

  /** The class of the elements on which the action is applicable */
  private Class<ObjectType> _applicabilityClass;

  /** The part from which the action is called */
  private IWorkbenchPart _part;
  
  /** Utility class instance used to call type-related services from the graphical framework (Sirius for example) */
  protected AbstractGenericTypeUtil _genericTypeUtil;
  
  /** Utility class instance used to call diagram-related services from the graphical framework (Sirius for example) */
  protected AbstractDiagramUtil _diagramUtil;

  /** Dialog and Wizard factory */
  protected IPatternDialogAndWizardFactory _dialogAndWizardFactory;

  /**
   * Constructor
   * @param applicabilityClass_p the non-null class of the elements on which the action is applicable
   */
  protected AbstractContextualAction(Class<ObjectType> applicabilityClass_p) {
    _genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
    _diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    _dialogAndWizardFactory = PatternsUIPlugin.getDefault().getDialogAndWizardFactory();
    _applicabilityClass = applicabilityClass_p;
    _selection = null;
    _shell = null;
  }

  /**
   * A convenient run method that takes the relevant selected elements as parameters
   * @param selection_p a non-null, potentially empty, unmodifiable list
   */
  protected abstract void coreRun(List<Object> selection_p);
  
  /**
   * Execute the given model operation using the registered model accessor
   * @param operation_p a non-null operation
   * @return the result of the execution
   */
  protected final <E> E executeOperation(final IModelOperation<E> operation_p) {
    Display display = getShell() != null? getShell().getDisplay(): Display.getCurrent();
    final List<E> wrapper = new ArrayList<E>(1);
    BusyIndicator.showWhile(display, new Runnable() {
      public void run() {
        E result =
            CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation_p);
        wrapper.add(result);
      }
    });
    return wrapper.get(0);
  }

  /**
   * Filter and return the selection as a list
   * @param acceptedType_p the type the elements must conform to
   * @return a non-null, potentially empty, unmodifiable list
   */
  @SuppressWarnings("unchecked")
  protected final <U> List<U> getFilteredSelection(Class<U> acceptedType_p) {
    List<U> result = new FOrderedSet<U>();
    if (_selection != null) {
      Iterator<?> it = _selection.iterator();
      while (it.hasNext()) {
        Object current = it.next();
        if (acceptedType_p.isInstance(current))
          result.add((U)current);
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the current shell
   */
  protected IWorkbenchPart getPart() {
    return _part;
  }

  /**
   * Return the relevant elements within the current selection
   * @return a non-null, potentially empty, unmodifiable list
   */
  protected final List<Object> getSelectedElements() {
    List<Object> result = new FOrderedSet<Object>();
    if (_selection != null) {
      @SuppressWarnings("unchecked")
      
      List<Object> orderedElements = sortElements(_selection.toList());
      Iterator<Object> it = orderedElements.iterator();
      
      while (it.hasNext()) {
        Object current = it.next();
        Collection<?> allRefined = toActualSelection(current);
        for (Object refined : allRefined) {
          if (_applicabilityClass.isInstance(refined))
            result.add(_applicabilityClass.cast(refined));
        }
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Sort the list of elements according to criteria contributed via the Diagram Util extension point
   * @return a sorted list
   */
  private List<Object> sortElements(List<Object> elementsToSort) {
    AbstractDiagramUtil diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    return diagramUtil.sortElements(elementsToSort);
  }

  /**
   * Return the current shell
   */
  protected Shell getShell() {
    return _shell;
  }

  /**
   * Return the current raw selection
   * @return a potentially null selection
   */
  protected IStructuredSelection getSelection() {
    return _selection;
  }

  /**
   * Return whether the action must be enabled
   */
  protected boolean mustBeEnabled() {
    // Redefine if needed
    return true;
  }

  /**
   * @see IActionDelegate#run(IAction)
   */
  public final void run(IAction action_p) {
    boolean foundFile = false;
    if (_selection != null) {
      @SuppressWarnings("unchecked")
      Iterator<Object> it = _selection.iterator();
      List<Object> files = new ArrayList<Object>();
      while (it.hasNext()) {
        Object current = it.next();
        if(current instanceof IFile){
          files.add(current);
          foundFile = true;
        }
      }
      if(foundFile)
        coreRun(files);
    }
    if(!foundFile){
      List<Object> selectedElements = getSelectedElements();
      coreRun(selectedElements);
    }
  }

  /**
   * @see IActionDelegate#selectionChanged(IAction, ISelection)
   */
  public void selectionChanged(IAction action_p, ISelection selection_p) {
    if (selection_p instanceof IStructuredSelection) {
      _selection = (IStructuredSelection) selection_p;
    } else {
      _selection = null;
    }
    if (action_p != null)
      action_p.setEnabled(mustBeEnabled());
  }

  /**
   * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
   */
  public void setActivePart(IAction action_p, IWorkbenchPart targetPart_p) {
    _shell = targetPart_p.getSite().getShell();
    _part = targetPart_p;
  }

  /**
   * Return the objects represented by the given selected object when considered
   * as a selection. Redefine if needed.
   * @param selected_p a non-null object
   * @return a non-null, potentially empty, unmodifiable collection
   */
  protected Collection<?> toActualSelection(Object selected_p) {
    return Collections.singleton(selected_p);
  }

}
