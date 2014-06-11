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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationScope;
import org.eclipse.emf.diffmerge.patterns.templates.engine.resources.PatternVirtualResource;
import org.eclipse.emf.diffmerge.patterns.templates.gen.TemplatePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;


/**
 * A data structure which contains all useful data for updating a template pattern
 * from an existing instance.
 * @author O. CONSTANT
 */
public class TemplatePatternUpdateSpecification extends AbstractModifiableTemplatePatternSpecification {
  
  /** The instance from which to update */
  private final IPatternInstance _instance;
  
  /** The non-null set of features to ignore */
  private final List<EStructuralFeature> _ignoredFeatures;
  
  /** A non-merged variant of getComparison() for differences visualization */
  private TemplatePatternApplicationComparison _visualizationComparison;
  
  /**
   * Constructor
   * @param instance_p a non-null instance of the template pattern to update
   * @param referenceElement_p an optional element to use as a reference for multipart
   */
  public TemplatePatternUpdateSpecification(IPatternInstance instance_p, EObject referenceElement_p, List<EStructuralFeature> featuresToIgnore_p) {
    super(false, true, getDefaultScopeElement(instance_p));
    _instance = instance_p;
    _ignoredFeatures = featuresToIgnore_p;
    TemplatePattern originalPattern = (TemplatePattern)instance_p.getPattern();
    @SuppressWarnings("cast") // Keep cast for upward compatibility
    EditingDomain originalPatternEditingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(originalPattern);
    Copier copier = new Copier();
    TemplatePattern copy = (TemplatePattern) copier.copy(originalPattern);
    copier.copyReferences();
    //Set a virtual Resource for the copy
    Resource vres = new PatternVirtualResource(copier, originalPatternEditingDomain);
    vres.getContents().add(copy);

    setPattern(copy);
    copy.setVersion(getNewVersion(copy));
    setRepository(originalPattern.getRepository());
    initializeComparison(instance_p, referenceElement_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification#getAllElements()
   */
  @Override
  public Collection<EObject> getAllElements() {
    Collection<EObject> result = new FOrderedSet<EObject>();
    result.addAll(super.getAllElements());
    // Include elements which are only present in pattern
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification#getComparison()
   */
  @Override
  public TemplatePatternApplicationComparison getComparison() {
    return (TemplatePatternApplicationComparison)super.getComparison();
  }
  
  /**
   * Return a default scope element for the given instance
   * @param instance_p a non-null instance
   * @return a potentially null element
   */
  private static EObject getDefaultScopeElement(IPatternInstance instance_p) {
    EObject result = null;
    List<EObject> elements = instance_p.getElements();
    if (!elements.isEmpty())
      result = elements.get(0);
    else if (instance_p instanceof EObject)
      result = (EObject)instance_p;
    else if (instance_p.getScopeElement() instanceof EObject)
      result = (EObject)instance_p.getScopeElement();
    return result;
  }
  
  /**
   * Return the set of features to ignore
   * @return a non-null collection
   */
  public List<EStructuralFeature> getIgnoredFeatures() {
    return _ignoredFeatures;
  }
  
  /**
   * Return the instance on which update is based
   * @return a non-null pattern instance
   */
  public IPatternInstance getInstance() {
    return _instance;
  }
  
  /**
   * Return the non-null multipart associated with the given element for the given instance
   * @param referenceElement_p an optional element to use as a reference for multipart
   * @param instance_p a non-null instance of the template pattern to update
   * @return a non-null string
   */
  private String getMultipart(EObject referenceElement_p, IPatternInstance instance_p) {
    String result = null;
    final String mainMultipart =
      TemplatePatternsPlugin.getDefault().getEngine().getMainMultipart(); 
    TemplatePatternData data = TemplatePatternsUtil.getPatternData(instance_p);
    if (data != null) {
      if (referenceElement_p != null)
        result = data.getMultipartOf(referenceElement_p);
      if (result == null ||
          mainMultipart.equals(result)) {
        Collection<String> multiparts = data.getMultiparts();
        if (!multiparts.isEmpty())
          result = multiparts.iterator().next();
      }
    }
    if (result == null)
      result = mainMultipart;
    return result;
  }
  
  /**
   * Return a new version, if possible, for the given pattern
   * @param pattern_p a non-null pattern
   * @return a non-null string
   */
  private String getNewVersion(TemplatePattern pattern_p) {
    String result = pattern_p.getVersion();
    String[] lines = result.split(VERSION_SEPARATOR_REGEX);
    if (lines.length > 0) {
      try {
        // Increment suffix
        String suffix = lines[lines.length-1];
        int suffixNb = Integer.parseInt(suffix);
        String newSuffix = String.valueOf(suffixNb + 1);
        // Reconstruct version with new suffix
        StringBuilder builder = new StringBuilder();
        for (int i=0; i < lines.length-1; i++) {
          builder.append(lines[i]);
          builder.append(VERSION_SEPARATOR);
        }
        builder.append(newSuffix);
        result = builder.toString();
      } catch (NumberFormatException e) {
        // Give up
      }
    }
    return result;
  }
  
  /**
   * Return the pattern to update
   * @return a non-null pattern
   */
  public TemplatePattern getOriginalPattern() {
    return (TemplatePattern)getInstance().getPattern();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification#getInstancesToIgnore()
   */
  @Override
  protected Collection<IPatternInstance> getInstancesToIgnore() {
    Collection<IPatternInstance> result = super.getInstancesToIgnore();
    result.add(_instance); // Remove current instance from those that can be included
    return result;
  }
  
  /**
   * Return the comparison for visualizing the differences in the update
   * @return a non-null comparison
   */
  public TemplatePatternApplicationComparison getVisualizationComparison() {
    return _visualizationComparison;
  }
  
  /**
   * Initialize the comparison between source elements and template elements
   * @param instance_p a non-null instance of the template pattern to update
   * @param referenceElement_p an optional element to use as a reference for multipart
   */
  private void initializeComparison(IPatternInstance instance_p, EObject referenceElement_p) {
    // Determine the non-null multipart
    String multipart = getMultipart(referenceElement_p, instance_p);
    TemplatePatternApplicationScope applicationScope =
      new TemplatePatternApplicationScope(instance_p, multipart);
    EditingDomain originalPatternEditingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(instance_p.getPattern());
    // Visualization comparison
    Copier copier = new Copier();
    EObject result = copier.copy(getPattern());
    copier.copyReferences();
    @SuppressWarnings("unchecked") TemplatePattern patternCopy = (TemplatePattern) result;
    //Set a virtual Resource for the copy
    Resource vres = new PatternVirtualResource(copier, originalPatternEditingDomain);
    vres.getContents().add(patternCopy);
    _visualizationComparison =
      new TemplatePatternApplicationComparison(
          patternCopy, applicationScope, getIgnoredFeatures());
    _visualizationComparison.compute();
    // Main comparison
    TemplatePatternApplicationComparison comparison =
      new TemplatePatternApplicationComparison(
          getPattern(), applicationScope, getIgnoredFeatures());
    newComparison(comparison);
    comparison.compute();
    mergeDifferences();
    registerRoleElements();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification#isComplete()
   */
  @Override
  public boolean isComplete() {
    return super.isComplete() &&
      !getPattern().getVersion().equals(getOriginalPattern().getVersion());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification#updateComparison()
   */
  @Override
  public void updateComparison() {
    getVisualizationComparison().update(null);
    super.updateComparison();
  }
  
}
