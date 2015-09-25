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
package org.eclipse.emf.diffmerge.patterns.ui.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


/**
 * Data content provider
 * @author Skander Turki
 */
public class CollectionAsTreeContentProvider implements ITreeContentProvider{

  /** Handle data input */
  private Collection<EObject> _dataInput;

  /** Viewer */
  private AbstractTreeViewer _viewer;

  /** Should we expand the tree to reveal newly added content?  */
  private boolean expandAddedContent = false;

  /**
   * Constructor.
   */
  public CollectionAsTreeContentProvider() {
    // Nothing
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object element_p) {
    HashSet<EObject> elements = new HashSet<EObject>();
    if(element_p instanceof EObject){
      EObject current = (EObject)element_p;
      for(EObject obj : current.eContents()){
        if(_dataInput.contains(obj)){
          elements.add(obj);
        }
      }
      return elements.toArray();
    }
    return new Object[0];
  }

  /**
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object element_p) {
    HashSet<EObject> elements = new HashSet<EObject>();
    Iterator<EObject> it = _dataInput.iterator();
    while(it.hasNext()){
      EObject obj = it.next();
      if(getParent(obj) == null){
        elements.add(obj);
      }
    }
    return elements.toArray();
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
   */
  public Object getParent(Object element_p) {
    if(element_p != null && element_p instanceof EObject){
      if(_dataInput.contains(((EObject)element_p).eContainer())){
        return ((EObject)element_p).eContainer();
      }
    }
    return null;
  }

  /**
   * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
   */
  public boolean hasChildren(Object element_p) {
    return getChildren(element_p).length > 0;
  }

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
   */
  public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
    if (null == _viewer) {
      // Initial case.
      if (newInput_p instanceof Collection) {
        _viewer = (AbstractTreeViewer) viewer_p;
        HashSet<EObject> elements = new HashSet<EObject>();
        Iterator<?> it = ((Collection<?>)newInput_p).iterator();
        while(it.hasNext()){
          Object obj = it.next();
          if(obj != null && obj instanceof EObject){
            elements.add((EObject) obj);
          }
        }
        _dataInput = elements;
      }
    } else {
      // Cases due to add / remove operations.
      boolean shouldRefresh = false;
      boolean addedContent = false;
      if (newInput_p instanceof Collection) {
        // handle Add element in the viewer.
        HashSet<EObject> elements = new HashSet<EObject>();
        Iterator<?> it = ((Collection<?>)newInput_p).iterator();
        while(it.hasNext()){
          Object obj = it.next();
          if(obj != null && obj instanceof EObject){
            elements.add((EObject) obj);
          }
        }
        _dataInput = elements;
        shouldRefresh = true;
        addedContent = true;
      } else if (oldInput_p instanceof Collection && newInput_p != null) {
        // Handle remove element in the viewer.
        HashSet<EObject> elements = new HashSet<EObject>(_dataInput);
        Iterator<?> it = ((Collection<?>)oldInput_p).iterator();
        while(it.hasNext()){
          Object obj = it.next();
          elements.remove(obj);
        }    
        _dataInput = elements;
        shouldRefresh = true;
      }
      if (shouldRefresh) {
        _viewer.refresh();
        if (addedContent && isExpandingNewContent()){
          for (Object o : (Object[]) newInput_p){
            _viewer.expandToLevel(o, 0);
          }
        }
      }
    }
  }

  /**
   * Should newly added content be revealed by expanding
   * the tree to the required level? For compatibility
   * reasons, this value is false by default. Use
   * setExpandingNewContent() to true to enable this 
   * feature.
   */
  public boolean isExpandingNewContent() {
    return expandAddedContent;
  }

  /**
   * Control whether newly added content will be revealed
   * by expanding the tree to the required level
   * @param expand_p whether to expand
   */
  public void setExpandingNewContent(boolean expand_p){
    expandAddedContent = expand_p;
  }

  /**
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {
    _dataInput = null;
  }

}
