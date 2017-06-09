/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * Helper for identifying resources that represent pattern catalog.
 * @author Olivier Constant
 */
public final class PatternCatalogResourceHelper {
  
  /** The file extension for pattern catalogs */
	public static final String PATTERN_CATALOG_FILE_EXTENSION = "patterns"; //$NON-NLS-1$
	
  /** All possible file extensions for pattern catalogs */
  private static final Collection<String> PATTERN_CATALOG_FILE_EXTENSIONS =
    Arrays.asList(PATTERN_CATALOG_FILE_EXTENSION, "templatepatterns"); //$NON-NLS-1$
  
  
	/**
	 * Constructor
	 */
  private PatternCatalogResourceHelper() {
	  // Forbids instantiation
	}
  
  /**
   * Return the default file extension for pattern catalogs
   * @return a non-null string
   */
  public static String getPatternCatalogFileExtension() {
    return PATTERN_CATALOG_FILE_EXTENSION;
  }
  
  /**
   * Return whether the given resource is a pattern catalog.
   * @param resource_p the given resource
   * @see #PATTERN_CATALOG_FILE_EXTENSION
   */
  public static boolean isPatternCatalogResource(Resource resource_p) {
    return isPatternCatalogResource(resource_p.getURI());
  }
  
  /**
   * Return whether the given URI refers to a pattern catalog.
   * @param uri_p the given URI
   * @see #PATTERN_CATALOG_FILE_EXTENSION
   */
  public static boolean isPatternCatalogResource(URI uri_p) {
    return PATTERN_CATALOG_FILE_EXTENSIONS.contains(uri_p.fileExtension());
  }
	
  /**
   * Return whether the given file is a pattern catalog.
   * @param file_p the given file
   * @see #PATTERN_CATALOG_FILE_EXTENSION
   */
  public static boolean isPatternCatalogResource(IResource file_p) {
    return PATTERN_CATALOG_FILE_EXTENSIONS.contains(file_p.getFileExtension());
  }
  
}
