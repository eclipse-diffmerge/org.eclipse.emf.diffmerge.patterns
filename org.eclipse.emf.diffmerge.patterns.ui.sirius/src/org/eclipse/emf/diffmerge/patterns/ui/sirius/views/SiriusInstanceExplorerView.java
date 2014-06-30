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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.SiriusLayersUtil;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.SiriusUtil;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.InstancePanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.sirius.dialogs.SiriusInstancePanelDialog;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.AbstractInstanceExplorerView;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * A View for exploring pattern instances.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusInstanceExplorerView 
extends AbstractInstanceExplorerView<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
DSemanticDecorator, AbstractDNode> {

  /** The view ID */
  public static String ID =
      "org.eclipse.emf.diffmerge.patterns.ui.sirius.views.siriusinstanceexplorerview"; //$NON-NLS-1$

  /** The non-null, potentially empty, unmodifiable list of contextual GEF elements */
  protected final List<IGraphicalEditPart> _graphicalContext;



  /** The session which are being monitored */
  protected Map<Session, ClosingSessionListener> _monitoredSessions;

  /**
   * Constructor
   */
  public SiriusInstanceExplorerView() {
    super();
    _graphicalContext = new FOrderedSet<IGraphicalEditPart>();
    _monitoredSessions = new HashMap<Session, ClosingSessionListener>(1);
  }

  /**
   * Returns the view's ID
   * @return a String
   */
  public static String getID(){
    return ID;
  }

  /**
   * Build and return a selection containing all the paths to the given object or
   * the given objects if it is a collection
   * @param object_p a potentially null object
   * @return a non-null tree selection
   */
  @SuppressWarnings("unchecked")
  private TreeSelection buildSelectionTo(Object object_p) {
    if (object_p == null)
      return new TreeSelection();
    // Identifying elements
    Collection<Object> elements;
    if (object_p instanceof Collection<?>)
      elements = (Collection<Object>)object_p;
    else
      elements = Collections.singleton(object_p);
    List<LinkedList<Object>> paths = new ArrayList<LinkedList<Object>>();
    // LinkedLists are used to prepend elements
    for (Object element : elements) {
      LinkedList<Object> start = new LinkedList<Object>();
      start.add(element);
      List<LinkedList<Object>> localPaths = buildSelectionRec(start);
      paths.addAll(localPaths);
    }
    // Convert to tree selection
    List<TreePath> result = new ArrayList<TreePath>(paths.size());
    for (List<Object> path : paths) {
      result.add(new TreePath(path.toArray()));
    }
    return new TreeSelection(result.toArray(new TreePath[result.size()]));
  }

  /**
   * Recursive helper method for buildSelectionTo
   * @param path_p a non-null, non-empty list
   * @return a non-null, non-empty list of lists
   */
  private List<LinkedList<Object>> buildSelectionRec(LinkedList<Object> path_p) {
    List<LinkedList<Object>> result = new ArrayList<LinkedList<Object>>();
    List<Object> parents = buildSelectionParents(path_p.getFirst());
    if (parents.isEmpty()) {
      // Stable: stop recursion
      result.add(path_p);
    } else {
      // Parents found: go on with recursion
      for (Object parent : parents) {
        LinkedList<Object> extendedPath = new LinkedList<Object>(path_p);
        extendedPath.addFirst(parent);
        result.addAll(buildSelectionRec(extendedPath));
      }
    }
    return result;
  }

  /**
   * Return the parents for the given object
   * @param object_p a non-null object
   * @return a non-null, potentially empty, unmodifiable list
   */
  private List<Object> buildSelectionParents(Object object_p) {
    List<Object> result = Collections.emptyList();
    Object parent = getContentProvider().getParent(object_p);
    if (parent != null) {
      // Single parent as defined by content provider
      result = Collections.singletonList(parent);
    } else if (object_p instanceof EObject) {
      // Maybe multiple parents
      Collection<IPatternInstance> instances = getAllRelatedInstances((EObject)object_p);
      result = Collections.unmodifiableList(new ArrayList<Object>(instances));
    }
    return result;
  }

  /**
   * Clean the viewer
   */
  public void clean() {
    _graphicalContext.clear();
    _initialSelection.clear();
    _instanceList.clear();
    _referenceElement = null;
    _contextElement = null;
  }



  /**
   * Return the diagram currently shown in the active editor, if any
   * @return a potentially null diagram
   */
  protected DDiagram getCurrentDiagram() {
    DDiagram result = null;
    IWorkbench workbench = PlatformUI.getWorkbench();
    if (workbench != null && !workbench.isClosing()) {
      IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
      if (window != null) {
        IWorkbenchPage page = window.getActivePage();
        if (page != null) {
          IEditorPart editorPart = page.getActiveEditor();
          if (editorPart instanceof DDiagramEditor) {
            DDiagramEditor diagramEditor = (DDiagramEditor)editorPart;
            DRepresentation representation = diagramEditor.getRepresentation();
            if (representation instanceof DDiagram)
              result = (DDiagram)representation;
          }
        }
      }
    }
    return result;
  }

  /**
   * Open the Manage Instance dialog on the selected instances
   */
  @Override
  protected void manageSelectedInstances() {
    List<IPatternInstance> instances = getSelectionAsInstances();
    if (!instances.isEmpty()) {
      DDiagram diagram = getCurrentDiagram();
      InstancePanelDialog<RGBValues, DDiagramElement, DDiagram, DContainer, IGraphicalEditPart, 
      DSemanticDecorator, AbstractDNode> dialog = new SiriusInstancePanelDialog(
          getShell(), _referenceElement, instances, diagram, _graphicalContext);
      dialog.open();
    }
  }


  /**
   * @see org.eclipse.ui.part.WorkbenchPart#dispose()
   */
  @Override
  public void dispose() {
    // Unregister monitored sessions
    Iterator<Entry<Session, ClosingSessionListener>> iterator =
        _monitoredSessions.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Session, ClosingSessionListener> entry = iterator.next();
      entry.getKey().removeListener(entry.getValue());
    }
    _monitoredSessions.clear();
    clean();
    super.dispose();
  }



  /**
   * Return the diagram for the given object
   * @param object_p an object
   * @return a diagram which may be non-null if the given object belongs to a layer
   *         equal to or above Viewpoint
   */
  private DDiagram getDiagramFor(Object object_p) {
    EObject viewpointElement = SiriusLayersUtil.getViewpointElement(object_p);
    return SiriusUtil.getDiagram(viewpointElement);
  }

  /**
   * Monitor the session that holds the specified element
   * @param element_p a non-null element
   */
  protected void monitorSessionClosingEvent(EObject element_p) {
    Session session = SessionManager.INSTANCE.getSession(element_p);
    if (null != session && !_monitoredSessions.containsKey(session)) {
      ClosingSessionListener listener = new ClosingSessionListener(session);
      session.addListener(listener);
      _monitoredSessions.put(session, listener);
    }
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.AbstractInstanceExplorerView#setInput(org.eclipse.jface.viewers.ISelection)
   */
  @Override
  public void setInput(ISelection selection_p) {
    Collection<IPatternInstance> instances = Collections.emptySet();
    EObject referenceElement = null;
    DDiagram diagram = null;
    List<IPatternInstance> initialSelection =
        new FOrderedSet<IPatternInstance>();
    List<IGraphicalEditPart> graphicalContext =
        new FOrderedSet<IGraphicalEditPart>();
    if (selection_p instanceof IStructuredSelection) {
      for (Object selected : ((IStructuredSelection)selection_p).toArray()) {
        if (diagram == null)
          diagram = getDiagramFor(selected);
        if (selected instanceof IGraphicalEditPart)
          graphicalContext.add((IGraphicalEditPart)selected);
        if (selected instanceof IPatternInstance)
          initialSelection.add((IPatternInstance)selected);
        if (referenceElement == null) {
          Collection<?> localSelection = toActualSelection(selected);
          if (!localSelection.isEmpty()){
            Object current = localSelection.iterator().next();
            if(current instanceof EObject)
              referenceElement = (EObject)current;
          }
        }
      }
      if (referenceElement != null)
        instances = getAllInstances(referenceElement);
    }
    setInput(instances, initialSelection, referenceElement, graphicalContext);
  }

  /**
   * Set the current input of this view
   * @param instances_p the non-null, potentially empty collection of instances to represent
   * @param initialSelection_p the non-null, potentially empty initial selection
   * @param referenceElement_p the optional element to use as a reference for displaying roles
   * @param graphicalContext_p a non-null, potentially empty list of GEF elements
   */
  public void setInput(Collection<? extends IPatternInstance> instances_p,
      Collection<? extends IPatternInstance> initialSelection_p,
      EObject referenceElement_p,
      List<? extends IGraphicalEditPart> graphicalContext_p) {
    clean();
    _instanceList.addAll(instances_p);
    _initialSelection.addAll(initialSelection_p);
    _referenceElement = referenceElement_p;
    _graphicalContext.addAll(graphicalContext_p);
    _viewer.setInput(_instanceList);
    // Session monitoring
    EObject sessionElement = _referenceElement;
    if (sessionElement == null && !_instanceList.isEmpty() &&
        _instanceList.get(0) instanceof EObject)
      sessionElement = (EObject)_instanceList.get(0);
    if (sessionElement != null)
      monitorSessionClosingEvent(sessionElement);
    registerContext(sessionElement);
    updateHeader();
    // Initial selection
    Object forSelection = _initialSelection;
    if (_initialSelection.isEmpty())
      forSelection = _referenceElement;
    TreeSelection newSelection = buildSelectionTo(forSelection);
    if (newSelection.isEmpty()) {
      _viewer.collapseAll();
    } else {
      boolean singleSelection = newSelection.getPaths().length == 1;
      _viewer.getTree().setRedraw(false);
      _viewer.expandAll();
      if (singleSelection)
        _viewer.collapseAll();
      _viewer.getTree().setRedraw(true);
      _viewer.setSelection(newSelection, singleSelection);
    }
  }

  /**
   * @param context_p a potentially null element
   */
  private void registerContext(EObject context_p) {
    if (context_p == null) {
      _contextElement = null;
    } else {
      EObject root = EcoreUtil.getRootContainer(context_p);
      _contextElement = root;
    }
  }

  /**
   * A listener for closing sessions.
   */
  protected class ClosingSessionListener implements SessionListener {
    /** The monitored session */
    private final Session _monitoredSession;
    /**
     * Constructor.
     * @param session_p a non-null session
     */
    public ClosingSessionListener(Session session_p) {
      _monitoredSession = session_p;
    }
    /**
     * Return the session which is monitored by this listener
     * @return a non-null session
     */
    public Session getMonitoredSession() {
      return _monitoredSession;
    }
    /**
     * React to the closing of a session
     * @param monitoredSession_p
     */
    @SuppressWarnings("rawtypes")
    private void handleClosingSession(Session monitoredSession_p) {
      Object currentInput = getViewer().getInput();
      if (currentInput instanceof Collection<?> && !((Collection)currentInput).isEmpty())
        currentInput = ((Collection)currentInput).iterator().next();
      if (currentInput instanceof EObject) {
        // Get the session of current displayed object.
        Session session = SessionManager.INSTANCE.getSession((EObject)currentInput);
        if (monitoredSession_p.equals(session))
          setInput(null);
      }
    }
    /**
     * @see fr.obeo.dsl.viewpoint.business.api.session.SessionListener#notify(int)
     */
    public void notify(int changeKind_p) {
      switch (changeKind_p) {
      case SessionListener.CLOSING:
        handleClosingSession(_monitoredSession);
        break;
      case SessionListener.CLOSED:
        // Nothing
        break;
      }
    }
  }


}
