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
package org.eclipse.emf.diffmerge.patterns.templates.ocl.interpreter;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.Variable;


/**
 * A specification of an OCL operation (signature and semantics)
 */
public abstract class CustomOperation {
  
  /** The non-null signature of the operation */
  private final OperationSignature _signature;
  
  /**
   * Constructor
   * @param owner_p a non-null classifier on which the operation is applicable
   * @param name_p a non-null string
   * @param type_p a non-null classifier for the return type of the operation
   * @param isMany_p whether the operation may return more than one element
   */
  public CustomOperation(EClassifier owner_p, String name_p, EClassifier type_p,
      boolean isMany_p) {
    _signature = new OperationSignature(owner_p, name_p, type_p, isMany_p);
  }
  
  /**
   * Constructor
   * @param owner_p a non-null classifier on which the operation is applicable
   * @param name_p a non-null string
   * @param type_p a non-null classifier for the return type of the operation
   * @param isMany_p whether the operation may return more than one element
   * @param parameters_p a non-null, potentially empty list
   */
  public CustomOperation(EClassifier owner_p, String name_p, EClassifier type_p,
      boolean isMany_p, List<Variable<EClassifier, EParameter>> parameters_p) {
    _signature = new OperationSignature(owner_p, name_p, type_p, isMany_p, parameters_p);
  }
  
  /**
   * Define the operation in the given environment
   * @param env_p a non-null environment
   */
  public void defineIn(EcoreEnvironment env_p) {
    _signature.defineIn(env_p);
  }
  
  /**
   * Execute the operation of the given receiver
   * @param source_p a non-null object
   * @param args_p a non-null, potentially empty list
   * @return a potentially null object
   */
  public abstract Object executeOn(Object source_p, List<Object> args_p);
  
  /**
   * Return the signature of the custom operation
   * @return a non-null operation signature
   */
  public OperationSignature getSignature() {
    return _signature;
  }
  
}
