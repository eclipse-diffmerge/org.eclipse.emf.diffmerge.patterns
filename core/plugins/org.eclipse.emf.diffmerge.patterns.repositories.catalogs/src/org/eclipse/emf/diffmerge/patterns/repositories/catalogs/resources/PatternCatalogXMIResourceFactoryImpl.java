/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelEnvironment;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


/**
 * A factory for an appropriate Resource for a Pattern Catalog, 
 * Is registered as a replacement of the default XMIResourceFactoryImpl for pattern instances models.
 * @author Skander Turki
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
