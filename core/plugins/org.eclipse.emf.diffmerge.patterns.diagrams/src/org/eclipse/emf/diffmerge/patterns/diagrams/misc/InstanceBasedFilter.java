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
package org.eclipse.emf.diffmerge.patterns.diagrams.misc;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;


/**
 * A filter that only accepts elements of given pattern instances.
 * @author Olivier Constant
 */
public class InstanceBasedFilter implements IElementFilter {
  /** The non-null, potentially empty, unmodifiable collection of instances of the filter */
  private final Collection<IPatternInstance> _instances;
  /** The (originally null) set of instance elements */
  private Collection<EObject> _instanceElements;

  /**
   * Constructor
   * @param instance_p a non-null pattern instance
   */
  public InstanceBasedFilter(IPatternInstance instance_p) {
    this(Collections.singleton(instance_p));
  }

  /**
   * Constructor
   * @param instances_p a non-null collection of pattern instances
   */
  public InstanceBasedFilter(Collection<? extends IPatternInstance> instances_p) {
    _instances = Collections.unmodifiableCollection(new FOrderedSet<IPatternInstance>(instances_p));
    _instanceElements = null;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.util.ModelsUtil.IElementFilter#accepts(org.eclipse.emf.ecore.EObject)
   */
  public boolean accepts(EObject element_p) {
    if (_instanceElements == null) {
      initialize();
    }
    return _instanceElements.contains(element_p);
  }

  /**
   * Initialize the filter with the current content of the pattern instance
   */
  private void initialize() {
    _instanceElements = new FOrderedSet<EObject>();
    for (IPatternInstance instance : _instances) {
      if (instance.getPatternData() instanceof TemplatePatternData) {
        TemplatePatternData data = (TemplatePatternData) instance.getPatternData();
        _instanceElements.addAll(data.getInstanceElements());
      } else {
        _instanceElements.addAll(LocationsUtil.getMergeTargets(instance));
      }
    }
  }
}
