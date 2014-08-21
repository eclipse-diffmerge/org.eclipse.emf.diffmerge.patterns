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
   * Get the generated item provider for given object.
   * @param object_p
   * @return<code>null</code> if one of parameters is <code>null</code> or if no provider is found.
   */
  protected static IItemLabelProvider getItemLabelProvider(EObject object_p) {
    // Precondition.
    if (null == object_p) {
      return null;
    }
    AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(object_p);
    // Precondition.
    if (null == editingDomain) {
      return null;
    }
    return (IItemLabelProvider) editingDomain.getAdapterFactory().adapt(object_p, IItemLabelProvider.class);
  }

  /**
   * Get the label for given object based on generated item provider.
   * @param object_p
   * @return<code>null</code> if one of parameters is <code>null</code> or if no label is found.
   */
  public static String getText(EObject object_p) {
    String label = ""; //$NON-NLS-1$
    IItemLabelProvider provider = getItemLabelProvider(object_p);
    if (null != provider) {
      label = provider.getText(object_p);
    }
    return label;
  }

  /**
   * Get the image for given object based on generated item provider.
   * @param object_p
   * @return<code>null</code> if one of parameters is <code>null</code> or if no image is found.
   */
  public static Image getImage(EObject object_p) {
    Object image = null;

    IItemLabelProvider provider = getItemLabelProvider(object_p);
    if (null != provider) {
      image = provider.getImage(object_p);
    }
    return (null != image) ? getImageFromObject(image) : null;
  }

  /**
   * Get Image from a object representation of it.
   * @param image_p
   * @return <code>null</code> if image creation fails.
   */
  public static Image getImageFromObject(Object image_p) {
    return ExtendedImageRegistry.getInstance().getImage(image_p);
  }
 
}
