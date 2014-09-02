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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * Utility class providing facilities related to file-based storage of
 * EMF resources
 * @author Olivier Constant
 */
public final class ResourcesUtil {

  /**
   * Constructor
   */
  private ResourcesUtil() {
    // Prevents instantiation
  }

  /**
   * Return, or create if necessary, the resource of the given URI in the given
   * resource set
   * @param uri_p a non-null EMF URI
   * @param resourceSet_p a non-null resource set
   * @return a non-null resource
   */
  public static Resource getCreateResourceForUri(URI uri_p, ResourceSet resourceSet_p) {
    Resource result = getResourceForUri(uri_p, resourceSet_p);
    if (result == null)
      result = resourceSet_p.createResource(uri_p);
    return result;
  }

  /**
   * Convert the given Eclipse path to an Eclipse file if applicable
   * @param path_p a non-null Eclipse path
   * @return a potentially null Eclipse file
   */
  public static IFile getFileForPath(IPath path_p) {
    return ResourcesPlugin.getWorkspace().getRoot().getFile(path_p);
  }

  /**
   * Return the Eclipse file which is the physical storage of the given resource
   * @param resource_p a potentially-null resource
   * @return an Eclipse file which exists physically, or null
   */
  public static IFile getFileForResource(Resource resource_p) {
    if(resource_p != null)
      return getFileForUri(resource_p.getURI());
    return null;
  }

  /**
   * Convert the given EMF URI to an Eclipse file, if applicable
   * @param uri_p a non-null EMF URI
   * @return a potentially null Eclipse file
   */
  public static IFile getFileForUri(URI uri_p) {
    IFile result = null;
    if (uri_p.isPlatformResource()) {
      String platformString = uri_p.toPlatformString(true);
      result = (IFile)ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
    }
    return result;
  }

  /**
   * Return, if any, the resource of the given URI using the given resource set
   * @param uri_p a non-null EMF URI
   * @param resourceSet_p a non-null resource set
   * @return a potentially null resource
   */
  public static Resource getResourceForUri(URI uri_p, ResourceSet resourceSet_p) {
    for (Resource resource : resourceSet_p.getResources()) {
      if (uri_p.equals(resource.getURI()))
        return resource;
    }
    return null;
  }

  /**
   * Convert the given Eclipse file to a platform-relative EMF URI, if applicable
   * @param file_p a non-null Eclipse file
   * @return a potentially null URI
   */
  public static URI getUriForFile(IFile file_p) {
    String stringPath = file_p.getFullPath().toString();
    URI result= URI.createPlatformResourceURI(stringPath, true);
    return result;
  }

  /**
   * Return whether the given resource exists physically
   * @param resource_p a non-null resource
   */
  public static boolean isPersistent(Resource resource_p) {
    boolean result = false;
    URI uri = resource_p.getURI();
    if (uri != null)
      result = isPersistent(uri);
    return result;
  }

  /**
   * Return whether a file at the given EMF URI exists physically
   * @param uri_p a non-null EMF URI
   */
  public static boolean isPersistent(URI uri_p) {
    boolean result = false;
    IResource eclipseResource = null;
    try {
      eclipseResource = ResourcesPlugin.getWorkspace().getRoot().findMember(
          uri_p.toPlatformString(true));
    } catch(Exception e) {
      // Cannot retrieve in workspace
    }
    result = eclipseResource instanceof IFile;
    return result;
  }

  /**
   * Ensure that the given resource becomes persistent and save its contents
   * @param resource_p a non-null resource
   * @return whether the operation succeeded
   */
  public static boolean makePersistent(Resource resource_p) {
    boolean result = false;
    final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
    saveOptions.put(
        Resource.OPTION_SAVE_ONLY_IF_CHANGED,
        Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
    try {
      resource_p.save(saveOptions);
      result = true;
    } catch(IOException e) {
      // Just return false
    }
    return result;
  }

}
