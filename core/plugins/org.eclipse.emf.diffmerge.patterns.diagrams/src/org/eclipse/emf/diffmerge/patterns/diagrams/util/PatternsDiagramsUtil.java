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

package org.eclipse.emf.diffmerge.patterns.diagrams.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.diffmerge.patterns.core.util.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogResourceHelper;
import org.eclipse.emf.ecore.resource.Resource;

/**
 *
 * @author Skander Turki
 */
public class PatternsDiagramsUtil {

  /** The suffix to apply for naming elements which are not loaded */
  public static final String NOT_LOADED_SUFFIX = Messages.PatternsDiagramsUtil_NotLoaded;
  
  /**
   * Return a variant of the given repository/pattern path
   * @param path_p a potentially null string
   * @return a string which is null iff path_p is null
   */
  public static String getPath(String path_p) {
    String result = path_p;
    if (result != null) {
      result = result.replaceAll("platform:/resource/", "");  //$NON-NLS-1$//$NON-NLS-2$
      int pos = result.lastIndexOf('#');
      if (pos >= 0) {
        result = result.substring(0, pos);
      }
    }
    return result;
  }
  
  /**
   *  From a given model resource, propose a corresponding default catalog file
   *  @param resource_p a non-null resource
   *  @return a potentially null file path
   */
  public static IPath getDefaultCatalogPathFor(Resource resource_p) {
    IPath result = null;
    IFile file = ResourcesUtil.getFileForResource(resource_p);
    if (file != null) {
      result = file.getFullPath();
      if (result != null) {
        result = result.removeFileExtension();
        result = result.addFileExtension(
            PatternCatalogResourceHelper.getPatternCatalogFileExtension());
      }
    }
    return result;
  }
    
}
