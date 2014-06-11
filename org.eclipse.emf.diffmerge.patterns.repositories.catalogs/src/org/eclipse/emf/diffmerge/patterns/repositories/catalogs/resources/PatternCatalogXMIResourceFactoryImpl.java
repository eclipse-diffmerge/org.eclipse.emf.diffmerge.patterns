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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * A factory for an appropriate Resource for a Pattern Catalog, 
 * Is registered as a replacement of the default XMIResourceFactoryImpl for pattern instances models
 * @author Skander TURKI
 */
public class PatternCatalogXMIResourceFactoryImpl extends XMIResourceFactoryImpl{

  /**
   * 
   * @see org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl#createResource(org.eclipse.emf.common.util.URI)
   */
  @Override
  public Resource createResource(URI uri)
  {
    IModelEnvironment env = CorePatternsPlugin.getDefault().getModelEnvironment();
    if(env != null){
      return env.createPatternCatalogResource(uri);
    }
    return null;
  }
  
}
