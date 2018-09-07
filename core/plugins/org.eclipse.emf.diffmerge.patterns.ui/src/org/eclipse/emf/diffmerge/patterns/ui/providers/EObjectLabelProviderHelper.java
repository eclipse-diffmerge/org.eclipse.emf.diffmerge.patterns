/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * @author Olivier Constant
 */
public class EObjectLabelProviderHelper {
  
  /**
   * Return the generated item provider for given element
   * @param element_p a potentially null element
   * @return<code>null</code> if one of parameters is <code>null</code> or if no provider is found.
   */
  protected static IItemLabelProvider getItemLabelProvider(EObject element_p) {
    // Precondition.
    if (null == element_p) {
      return null;
    }
    AdapterFactoryEditingDomain editingDomain =
        (AdapterFactoryEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(element_p);
    // Precondition.
    if (null == editingDomain) {
      return null;
    }
    return (IItemLabelProvider) editingDomain.getAdapterFactory().adapt(element_p, IItemLabelProvider.class);
  }

  /**
   * Get the label for given element based on the generated item provider
   * @param element_p a non-null element
   * @return<code>null</code> if one of parameters is <code>null</code> or if no label is found.
   */
  public static String getText(EObject element_p) {
    String label = ""; //$NON-NLS-1$
    IItemLabelProvider provider = getItemLabelProvider(element_p);
    if (null != provider) {
      label = provider.getText(element_p);
    }
    return label;
  }

  /**
   * Get the image for given element based on the generated item provider
   * @param element_p a non-null elemnt
   * @return<code>null</code> if one of parameters is <code>null</code> or if no image is found.
   */
  public static Image getImage(EObject element_p) {
    Object image = null;

    IItemLabelProvider provider = getItemLabelProvider(element_p);
    if (null != provider) {
      image = provider.getImage(element_p);
    }
    return (null != image) ? getImageFromObject(image) : null;
  }

  /**
   * Return an image from a object representation of it
   * @param image_p a non-null object
   * @return <code>null</code> if image creation fails.
   */
  public static Image getImageFromObject(Object image_p) {
    return ExtendedImageRegistry.getInstance().getImage(image_p);
  }
 
}
