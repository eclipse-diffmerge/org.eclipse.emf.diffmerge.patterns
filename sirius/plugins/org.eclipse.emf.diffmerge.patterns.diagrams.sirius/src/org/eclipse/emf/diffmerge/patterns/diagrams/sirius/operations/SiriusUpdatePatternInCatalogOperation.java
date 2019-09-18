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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.operations;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractUpdatePatternLayoutInCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.UpdateCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternEngine;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternUpdateComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * A model operation that consists in updating a template pattern and making this update
 * persistent in its repository, which is assumed to be a catalog.
 * @author Olivier Constant
 * @author Skander Turki
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
   * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractPatternWithLayoutOperation#getData()
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
   * @param interPatternComparison_p the non-null result of the update of the pattern
   */
  protected void updateLayoutData(TemplatePattern pattern_p,
      TemplatePatternUpdateComparison interPatternComparison_p) {
    ((InnerUpdatePatternInCatalogOperation)_innerPatternLayoutOperation).updateLayoutData(
        pattern_p, interPatternComparison_p);
  }

  /**
   * Inner class, simulates multiple inheritance of SiriusCreatePatternAndInstanceOperation --> (AbstractCreatePatternAndInstanceLayoutOperation, SiriusAbstractPatternWithLayoutOperation)
   * @author Skander Turki
   *
   */
  protected class InnerUpdatePatternInCatalogOperation extends AbstractUpdatePatternLayoutInCatalogOperation{
    
    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractUpdatePatternLayoutInCatalogOperation#updateLayoutData(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern, org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternUpdateComparison)
     */
    @Override
    protected void updateLayoutData(TemplatePattern pattern_p,
        TemplatePatternUpdateComparison interPatternComparison_p) {
      Resource resource = pattern_p.eResource();
      if (resource != null) {
        EMap<EObject, Layout> layoutData = buildLayoutData();
        pattern_p.getLayoutData().clear();
        for (Entry<EObject, Layout> entry : layoutData.entrySet()) {
          EObject sourcePatternElement = entry.getKey();
          IMatch match = interPatternComparison_p.getMapping().getMatchFor(sourcePatternElement,
              TemplatePatternComparison.getPatternRole().opposite());
          if (match != null) {
            EObject updatedElement = match.get(TemplatePatternComparison.getPatternRole());
            if (updatedElement != null && EcoreUtil.isAncestor(pattern_p, updatedElement))
              pattern_p.getLayoutData().put(updatedElement, entry.getValue());
          }
        }
      }
    }

    /**
     * @see org.eclipse.emf.diffmerge.patterns.diagrams.operations.AbstractOperation#execute()
     */
    @Override
    protected TemplatePattern execute() {
      // In-memory pattern update
      TemplatePatternUpdateComparison patternComparison =
          new TemplatePatternEngine().updatePattern(getData());
      TemplatePatternsUtil.updateLastModificationStamp(getData().getOriginalPattern());
      if (getData().includeLayoutData())
        updateLayoutData(getData().getOriginalPattern(), patternComparison);
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
