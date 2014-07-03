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
package org.eclipse.emf.diffmerge.patterns.diagram.sirius.operations;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractUpdatePatternLayoutInCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.UpdateCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternEngine;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;


/**
 * A model operation that consists in updating a template pattern and making this update
 * persistent in its repository, which is assumed to be a catalog.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public class SiriusUpdatePatternInCatalogOperation
extends SiriusAbstractPatternWithLayoutOperation<TemplatePattern>{

  /**
   * Constructor
   * @param updateData_p a non-null specification for pattern update
   * @param graphicalContext_p a non-null, potentially empty list of GEF elements
   */
  public SiriusUpdatePatternInCatalogOperation(
      TemplatePatternUpdateSpecification updateData_p,
      List<Object> graphicalContext_p, Object patternSideContext_p) {
    super(AbstractUpdatePatternLayoutInCatalogOperation.getName(), updateData_p, graphicalContext_p,
        patternSideContext_p);
    _innerPatternLayoutOperation = new InnerUpdatePatternInCatalogOperation();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractPatternWithLayoutOperation#getData()
   */
  @Override
  public TemplatePatternUpdateSpecification getData() {
    return (TemplatePatternUpdateSpecification)super.getData();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected TemplatePattern run() {
    return ((InnerUpdatePatternInCatalogOperation)_innerPatternLayoutOperation).execute();
  }

  /**
   * Update the layout data of the given pattern from the given GEF elements
   * @param pattern_p a non-null pattern
   */
  protected void updateLayoutData(TemplatePattern pattern_p) {
    ((InnerUpdatePatternInCatalogOperation)_innerPatternLayoutOperation).updateLayoutData(pattern_p);
  }

  /**
   * Inner class, simulates multiple inheritance of SiriusCreatePatternAndInstanceOperation --> (AbstractCreatePatternAndInstanceLayoutOperation, SiriusAbstractPatternWithLayoutOperation)
   * @author Skander TURKI
   *
   */
  protected class InnerUpdatePatternInCatalogOperation extends AbstractUpdatePatternLayoutInCatalogOperation{

    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractUpdatePatternLayoutInCatalogOperation#updateLayoutData(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
     */
    @Override
    protected void updateLayoutData(TemplatePattern pattern_p) {
      Resource resource = pattern_p.eResource();
      if (resource != null) {
        EMap<EObject, Layout> layoutData = buildLayoutData();
        pattern_p.getLayoutData().clear();
        for (Entry<EObject, Layout> entry : layoutData.entrySet()) {
          String id = CorePatternsPlugin.getDefault().getIdProvider().getId(entry.getKey(), null);
          EObject updatedElement = CorePatternsPlugin.getDefault().getIdProvider().getById(id, Collections.singleton(resource));
          if (updatedElement != null)
            pattern_p.getLayoutData().put(updatedElement, entry.getValue());
        }
      }
    }

    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagram.operations.AbstractOperation#execute()
     */
    @Override
    protected TemplatePattern execute() {
      // In-memory pattern update
      new TemplatePatternEngine().updatePattern(getData());
      if (getData().includeLayoutData())
        updateLayoutData(getData().getOriginalPattern());
      // Persistent catalog update
      PatternRepository catalog =
          (PatternRepository)getData().getOriginalPattern().getRepository();
      UpdateCatalogOperation catalogOperation = new UpdateCatalogOperation(catalog, getPatternSideContext());
      Boolean success = call(catalogOperation);
      if (!success.booleanValue() && getModelEnvironment() != null)
        getModelEnvironment().abortOperation();
      return getData().getOriginalPattern();
    }
  }

}
