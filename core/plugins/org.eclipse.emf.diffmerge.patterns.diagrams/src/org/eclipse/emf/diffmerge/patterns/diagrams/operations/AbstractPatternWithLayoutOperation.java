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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.ecore.EObject;


/**
 * A model operation which is concerned with the definition of patterns with graphical layouts.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractPatternWithLayoutOperation<T> 
extends AbstractModelOperation<T> {

  /** A non-null specification for the pattern operation */
  protected final AbstractModifiableTemplatePatternSpecification _data;

  /** A non-null, potentially empty, unmodifiable list of graphical elements */
  protected final List<Object> _graphicalContext;

  /** Instance of inner class used to simulate multiple inheritance for leaf operations*/
  protected AbstractOperation<?> _innerPatternLayoutOperation;
  

  /** Context of operation, used to navigate up to the pattern's editing domain */
  private final Object _patternSideContext;

  /** Context of operation, used to navigate up to the model's editing domain */
  private final Object _modelSideContext;

  /**
   * Constructor
   * @param name_p a non-null name for the operation
   * @param data_p a non-null pattern specification
   * @param graphicalContext_p a non-null, potentially empty list of graphical elements
   * @param patternSideContext_p a non-null Object
   */
  public AbstractPatternWithLayoutOperation(String name_p, AbstractModifiableTemplatePatternSpecification data_p,
      List<Object> graphicalContext_p, Object patternSideContext_p) {
    super(name_p, null, true, false, true, patternSideContext_p, graphicalContext_p);
    _data = data_p;
    _graphicalContext = Collections.unmodifiableList(graphicalContext_p);
    _patternSideContext = patternSideContext_p;
    _modelSideContext = graphicalContext_p;
  }


  /**
   * Builds and returns a map from semantic elements to the layout and style of their representation
   * @return a non-null, potentially empty, unmodifiable map
   */
  public abstract EMap<EObject, Layout> buildLayoutData();

  /**
   * Return the specification of the pattern operation
   * @return a non-null object
   */
  public AbstractModifiableTemplatePatternSpecification getData() {
    return _data;
  }
  
  /**
   * Returns the _patternSideContext Object. 
   * It should be an object from which the pattern's editing domain can be navigated to.
   * @return a potentially null Object
   */
  public Object getPatternSideContext(){
    return _patternSideContext;
  }

  /**
   * Returns the _modelSideContext Object. 
   * It should be an object from which the model's editing domain can be navigated to.
   * @return a potentially null Object
   */
  public Object getModelSideContext(){
    return _modelSideContext;
  }

}
