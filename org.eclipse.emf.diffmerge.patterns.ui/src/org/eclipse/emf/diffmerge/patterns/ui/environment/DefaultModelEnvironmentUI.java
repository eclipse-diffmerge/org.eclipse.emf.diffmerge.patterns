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
package org.eclipse.emf.diffmerge.patterns.ui.environment;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.providers.EObjectLabelProviderHelper;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

/**
 * The default model environment UI services provider
 * @author O. CONSTANT
 * @author S. TURKI
 */
public class DefaultModelEnvironmentUI implements IModelEnvironmentUI{

/**
 * 
 * @see org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI#getEnvironments()
 */
    public List<String> getEnvironments() {
      List<String> result = Collections.emptyList();
      String currentProductLabel = null;
      IProduct product = Platform.getProduct();
      if (product != null) {
        currentProductLabel = product.getName();
        if (currentProductLabel != null) {
          Bundle mainBundle = Platform.getProduct().getDefiningBundle();
          if (mainBundle != null) {
            Version version = mainBundle.getVersion();
            if (version != null) {
              currentProductLabel = currentProductLabel + ' ' + version.getMajor() +
                  '.' + version.getMinor() + '.' + 'x';
            }
          }
        }
      }
      if (currentProductLabel != null)
        result = Collections.singletonList(currentProductLabel);
      return result;
    }
  
  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI#getSorter(org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI.SortingMethod)
   */
  public ViewerSorter getSorter(SortingMethod method_p) {
    ViewerSorter result;
    if (method_p == null || method_p == SortingMethod.NONE)
      result = null;
    else
      result = new NameTypeViewerSorter(method_p);
    return result;
  }

  /**
   * A viewer sorter that can sort by name or name and type
   */
  public static class NameTypeViewerSorter extends ViewerSorter {
    /** The non-null sorting method: BY_NAME or BY_NAME_AND_TYPE */
    private final SortingMethod _sortingMethod;
    /**
     * Constructor
     * @param method_p the non-null sorting method to apply, either BY_NAME or BY_NAME_AND_TYPE
     */
    public NameTypeViewerSorter(SortingMethod method_p) {
      _sortingMethod = method_p;
    }
    /**
     * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Viewer viewer_p, Object e1_p, Object e2_p) {
      int result;
      if (_sortingMethod == SortingMethod.BY_NAME ||
          !(e1_p instanceof EObject && e2_p instanceof EObject)) {
        // Sort by name
        result = super.compare(viewer_p, e1_p, e2_p);
      } else {
        // Sort by type name...
        EObject element1 = (EObject)e1_p;
        EObject element2 = (EObject)e2_p;
        String typeName1 = element1.eClass().getName();
        if (typeName1 == null)
          typeName1 = ""; //$NON-NLS-1$
        String typeName2 = element2.eClass().getName();
        if (typeName2 == null)
          typeName2 = ""; //$NON-NLS-1$
        @SuppressWarnings("unchecked")
        int onTypes = getComparator().compare(typeName1, typeName2);
        if (onTypes != 0) {
          result = onTypes;
        } else {
          // ... then by name
          result = super.compare(viewer_p, e1_p, e2_p);
        }
      }
      return result;
    }

  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI#getText(org.eclipse.emf.ecore.EObject)
   */
  public String getText(Object element_p) {
    if(!(element_p instanceof EObject)){
      return element_p.toString();
    }
    EObject eobj = (EObject)element_p;
    // Centralize dependency to common.ui.services
    String result = EObjectLabelProviderHelper.getText(eobj);
    if (!UIUtil.isSignificant(result)) {
      // Try and get a label based on the main Melody editing domain
      EditingDomain rawEditingDomain =
          CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(eobj);
      if (rawEditingDomain instanceof AdapterFactoryEditingDomain) {
        AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain)rawEditingDomain;
        IItemLabelProvider provider = (IItemLabelProvider)editingDomain.getAdapterFactory().adapt(
            eobj, IItemLabelProvider.class);
        if (provider != null)
          result = provider.getText(eobj);
      }
    }
    return result;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI#getImage(java.lang.Object)
   */
  public Image getImage(Object element_p) {
    if(!(element_p instanceof EObject)){
      return null;
    }
    EObject eobj = (EObject)element_p;
    // Centralize dependency to common.ui.services
    Image result = EObjectLabelProviderHelper.getImage(eobj);
    if (result == null) {
      // Try and get an image
      EditingDomain rawEditingDomain =
          CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(eobj);
      if (rawEditingDomain instanceof AdapterFactoryEditingDomain) {
        AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain)rawEditingDomain;
        IItemLabelProvider provider = (IItemLabelProvider)editingDomain.getAdapterFactory().adapt(
            eobj, IItemLabelProvider.class);
        if (provider != null) {
          Object rawImage = provider.getImage(eobj);
          if (rawImage != null)
            result = ExtendedImageRegistry.getInstance().getImage(rawImage);
        }
      }
    }
    return result;
  }

}
