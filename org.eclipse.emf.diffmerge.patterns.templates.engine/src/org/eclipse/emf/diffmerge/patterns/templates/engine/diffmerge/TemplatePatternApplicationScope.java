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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter;
import org.eclipse.emf.diffmerge.util.structures.FHashSet;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstanceMarker;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;


/**
 * This class defines a model scope covering the full containment tree,
 * when available, of the root elements of a pattern application.
 * @author Olivier Constant
 */
public class TemplatePatternApplicationScope extends FilteredModelScope {
  
  /**
   * A filter for pattern instance markers (stateless)
   */
  public static class PatternInstanceMarkerFilter implements IElementFilter {
    /**
     * @see org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.FilteredModelScope.IElementFilter#accepts(org.eclipse.emf.ecore.EObject)
     */
    public boolean accepts(EObject element_p) {
      return !(element_p instanceof IPatternInstanceMarker);
    }
  }
  
  /**
   * A filter for this scope based on instance multiparts
   */
  private class TemplatePatternApplicationFilter extends PatternInstanceMarkerFilter {
    /** The optional pattern data for this application */
    private final TemplatePatternData _data;
    /**
     * Constructor
     */
    public TemplatePatternApplicationFilter() {
      super();
      _data = TemplatePatternsUtil.getPatternData(getApplication());
    }
    /**
     * @see org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationScope.PatternInstanceMarkerFilter#accepts(org.eclipse.emf.ecore.EObject)
     */
    @Override
    public boolean accepts(EObject element_p) {
      boolean result = super.accepts(element_p);
      String multipart = getMultipart();
      if (result && _data != null && multipart != null)
        result = _data.getMultipartOf(element_p) == null ||
          !_data.isInOtherMultipart(element_p, multipart);
      return result;
    }
  }
  
  
  /** The non-null pattern application which defines the scope */
  private final IPatternApplication _application;
  
  /** The non-null set of deleted elements */
  private final Collection<EObject> _deletedElements;
  
  /** An optional multipart ID */
  private String _multipart; 
  
  /** The filter for this scope */
  private final IElementFilter _filter;
  
  /**
   * Constructor
   * @param application_p the non-null pattern application which defines the scope
   * @param multipart_p an optional multipart ID for the application as an instance
   */
  public TemplatePatternApplicationScope(IPatternApplication application_p,
      String multipart_p) {
    super(TemplatePatternsUtil.getApplicationRoots(application_p));
    _application = application_p;
    _filter = new TemplatePatternApplicationFilter();
    _deletedElements = new FHashSet<EObject>();
    setMultipart(multipart_p);
  }
  
/**
 * 
 * @see org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope#build(org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter)
 */
  @Override
  public void build(IElementFilter filter_p) {
    super.build(filter_p);
    TemplatePatternsUtil.adjust(this);
  }
  
  /**
   * Return the pattern application on which this model scope is defined
   * @return a non-null pattern application
   */
  public IPatternApplication getApplication() {
    return _application;
  }
  
  /**
   * Return the complete set of elements which have been deleted on this scope
   * @return a non-null, potentially empty, unmodifiable collection
   */
  public Collection<EObject> getDeletedElements() {
    return Collections.unmodifiableCollection(_deletedElements);
  }
  
  /**
   * Return the instance multipart ID covered by this scope, if any
   * @return a potentially null string
   */
  public String getMultipart() {
    return _multipart;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope#remove(org.eclipse.emf.ecore.EObject)
   */
  @Override
  public boolean remove(EObject element_p) {
    boolean result = _roots.remove(element_p);
    removeFromScope(element_p, true);
    _deletedElements.add(element_p);
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.impl.scopes.AbstractModelScope#remove(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EObject)
   */
  @Override
  public boolean remove(EObject source_p, EReference reference_p, EObject value_p) {
    boolean result;
    if (reference_p.isContainment()) {
      result = _deletedElements.add(value_p);
    } else {
      result = super.remove(source_p, reference_p, value_p);
    }
    return result;
  }
  
  /**
   * Set the instance multipart covered by this scope
   * @param multipart_p a potentially null string
   */
  public void setMultipart(String multipart_p) {
    _multipart = multipart_p;
    build(_filter);
  }
  
}
