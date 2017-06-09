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
package org.eclipse.emf.diffmerge.patterns.templates.ocl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;


/**
 * This interface defines means to enhance the OCL environment dedicated to the definition
 * and usage of Template Patterns
 * @author Olivier Constant
 */
public interface IOclEnvironmentCustomizer {
  
  /**
   * Return specifications of additional variables for the OCL environment based on
   * the given contextual element
   * @param context_p a potentially null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  Collection<VariableSpecification> getVariables(EObject context_p);
  
  
  /**
   * A specification of a variable for an OCL environment
   */
  public static class VariableSpecification {
    /** The non-null name */
    private final String _name;
    /** The non-null type */
    private final EClassifier _type;
    /** The potentially null value */
    private final Object _value;
    /**
     * 
     * @param name_p the non-null name
     * @param type_p the non-null type
     * @param value_p the potentially null value
     */
    public VariableSpecification(String name_p, EClassifier type_p, Object value_p) {
      _name = name_p;
      _type = type_p;
      _value = value_p;
    }
    /**
     * Return the name of the specified variable
     * @return a non-null string
     */
    public String getName() { return _name; }
    /**
     * Return the type of the specified variable
     * @return a non-null classifier
     */
    public EClassifier getType() { return _type; }
    /**
     * Return the value of the specified variable
     * @return a potentially null object
     */
    public Object getValue() { return _value; }
  }
  
}
