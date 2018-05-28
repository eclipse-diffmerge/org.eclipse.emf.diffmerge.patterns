/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.RemoveFromCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;


/**
 * A model operation that consists in deleting a pattern and optionally a set
 * of instances of the pattern.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class DeletePatternOperation
extends AbstractModelOperation<List<IPatternInstance>> {

  /** The non-null pattern to delete */
  protected final TemplatePattern _pattern;

  /** The non-null, potentially empty set of instances to delete */
  protected final List<IPatternInstance> _instances;

  /**
   * Constructor
   * @param pattern_p a non-null pattern to delete
   * @param instances_p a non-null, potentially empty set of instances to delete
   */
  public DeletePatternOperation(TemplatePattern pattern_p,
      List<? extends IPatternInstance> instances_p, Object targetContext_p) {
    super(Messages.DeletePatternOperation_Name, null, !instances_p.isEmpty(), false, false, 
        targetContext_p, null);
    _pattern = pattern_p;
    _instances = new ArrayList<IPatternInstance>(instances_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
   */
  @Override
  protected List<IPatternInstance> run() {
    List<IPatternInstance> result = null;
    RemoveFromCatalogOperation remove = new RemoveFromCatalogOperation(_pattern, getTargetContext());
    Boolean removed = call(remove);
    if (removed.booleanValue()) {
      result = new ArrayList<IPatternInstance>(_instances.size());
      for (IPatternInstance instance : _instances) {
        IModelTransformationStatus status = instance.delete(true);
        if (status.isOk())
          result.add(instance);
      }
    }
    return Collections.unmodifiableList(result);
  }

}
