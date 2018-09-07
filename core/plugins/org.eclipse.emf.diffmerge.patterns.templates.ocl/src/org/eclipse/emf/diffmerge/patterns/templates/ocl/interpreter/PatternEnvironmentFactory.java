/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.ocl.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.patterns.templates.ocl.OclPatternsPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;


/**
 * An extension of the Ecore environment factory for additional navigation facilities
 */
public class PatternEnvironmentFactory extends EcoreEnvironmentFactory {
  
  /** The custom operations, identified by signature */
  protected final Map<OperationSignature, CustomOperation> _additionalOperations;
  
  
  /**
   * Default constructor
   */
  public PatternEnvironmentFactory() {
    super();
    _additionalOperations = new HashMap<OperationSignature, CustomOperation>();
  }
  
  /**
   * Add custom operations in the given environment
   * @param env_p a non-null environment
   */
  protected void addCustomOperations(EcoreEnvironment env_p) {
    addEObjectOperations(env_p);
    addPatternOperations(env_p);
  }
  
  /**
   * Add a operations for EObjects in the given environment
   * @param env_p a non-null environment
   */
  protected void addEObjectOperations(EcoreEnvironment env_p) {
    EClassifier everyElement = env_p.getOCLStandardLibrary().getOclAny();
    OCLStandardLibrary<EClassifier> lib = env_p.getOCLStandardLibrary();
    // Container
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "oclOwner", everyElement, false) { //$NON-NLS-1$
      /**
       * @see org.eclipse.emf.diffmerge.patterns.templates.ocl.interpreter.CustomOperation#executeOn(java.lang.Object, java.util.List)
       */
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        return ((EObject)source_p).eContainer();
      }
    });
    // All containers
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "oclOwners", everyElement, true) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        List<EObject> result = new ArrayList<EObject>();
        EObject current = ((EObject)source_p).eContainer();
        while (current != null) {
          result.add(current);
          current = current.eContainer();
        }
        return result;
      }
    });
    // Contents
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "oclChildren", everyElement, true) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        return ((EObject)source_p).eContents();
      }
    });
    // All contents
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "oclAllChildren", everyElement, true) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        List<EObject> result = new ArrayList<EObject>();
        Iterator<EObject> it = ((EObject)source_p).eAllContents();
        while (it.hasNext()) {
          result.add(it.next());
        }
        return result;
      }
    });
    // Is leaf
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "oclIsLeaf", lib.getBoolean(), false) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        boolean result = ((EObject)source_p).eContents().isEmpty();
        return Boolean.valueOf(result);
      }
    });
    // Is root
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "oclIsRoot", lib.getBoolean(), false) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        boolean result = ((EObject)source_p).eContainer() == null;
        return Boolean.valueOf(result);
      }
    });
    // Type name
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "oclTypeName", lib.getString(), false) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        EClass type = ((EObject)source_p).eClass();
        EPackage epackage = type.getEPackage();
        return epackage.getName() + "::" + type.getName(); //$NON-NLS-1$
      }
    });
  }
  
  /**
   * Add pattern-related operations in the given environment
   * @param env_p a non-null environment
   */
  protected void addPatternOperations(final EcoreEnvironment env_p) {
    EClassifier everyElement = env_p.getOCLStandardLibrary().getOclAny();
    EClass instanceType = CorepatternsPackage.eINSTANCE.getAbstractPatternInstance();
    EClass patternType = CorepatternsPackage.eINSTANCE.getAbstractPattern();
    final Object INVALID = env_p.getOCLStandardLibrary().getInvalid();
    // Instances
    registerCustomOperation(env_p, new CustomOperation(
        everyElement, "patternInstances", instanceType, true) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        EList<AbstractPatternInstance> result = new BasicEList<AbstractPatternInstance>();
        EObject element = (EObject)source_p;
        IPatternSupport support = CorePatternsPlugin.getDefault().getPatternSupportFor(element);
        if (support != null) {
          List<IPatternInstance> instances = support.getRelatedInstances(element);
          for (IPatternInstance instance : instances) {
            if (instance instanceof AbstractPatternInstance)
              result.add((AbstractPatternInstance)instance);
          }
        }
        return result;
      }
    });
    // Patterns
    registerCustomOperation(env_p, new CustomOperation(
        instanceType, "pattern", patternType, false) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        Object result = INVALID;
        AbstractPatternInstance instance = (AbstractPatternInstance)source_p;
        IPattern pattern = instance.getPattern();
        if (pattern instanceof AbstractPattern)
          result = pattern;
        return result;
      }
    });
    // Instance -> Pattern element mapping
    Variable<EClassifier, EParameter> parameter = ExpressionsFactory.eINSTANCE.createVariable();
    parameter.setName("element"); //$NON-NLS-1$
    parameter.setType(everyElement);
    List<Variable<EClassifier, EParameter>> parameters = Collections.singletonList(parameter);
    registerCustomOperation(env_p, new CustomOperation(
        instanceType, "patternElement", everyElement, false, parameters) { //$NON-NLS-1$
      @Override
      public Object executeOn(Object source_p, List<Object> args_p) {
        Object result = INVALID;
        if (source_p instanceof AbstractPatternInstance && args_p != null && !args_p.isEmpty()) {
          Object first = args_p.get(0);
          if (first instanceof EObject) {
            EObject element = (EObject)first;
            AbstractPatternInstance instance = (AbstractPatternInstance)source_p;
            AbstractPatternData data = instance.getPatternData();
            if (data instanceof TemplatePatternData) {
              EObject patternElement = ((TemplatePatternData)data).getCounterpart(element, false);
              if (patternElement != null)
                result = patternElement;
            }
          }
        }
        return result;
      }
    });
  }
  
  /**
   * @see org.eclipse.ocl.ecore.EcoreEnvironmentFactory#createEnvironment()
   */
  @Override
  public EcoreEnvironment createEnvironment() {
    EcoreEnvironment result = (EcoreEnvironment)super.createEnvironment();
    addCustomOperations(result);
    return result;
  }
  
  /**
   * @see org.eclipse.ocl.ecore.EcoreEnvironmentFactory#createEvaluationEnvironment()
   */
  @Override
  public ExtendedEcoreEvaluationEnvironment createEvaluationEnvironment() {
    return new ExtendedEcoreEvaluationEnvironment();
  }
  
  /**
   * @see org.eclipse.ocl.ecore.EcoreEnvironmentFactory#createEvaluationEnvironment(org.eclipse.ocl.EvaluationEnvironment)
   */
  @Override
  public ExtendedEcoreEvaluationEnvironment createEvaluationEnvironment(
      EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
    return new ExtendedEcoreEvaluationEnvironment(parent);
  }
  
  /**
   * Register the given custom operation to make it executable
   * @param env_p a non-null environment
   * @param customOperation_p a non-null custom operation
   */
  protected void registerCustomOperation(EcoreEnvironment env_p, CustomOperation customOperation_p) {
    customOperation_p.defineIn(env_p);
    _additionalOperations.put(customOperation_p.getSignature(), customOperation_p);
  }
  
  
  /**
   * An extension of the Ecore evaluation environment for additional navigation facilities
   */
  private class ExtendedEcoreEvaluationEnvironment extends EcoreEvaluationEnvironment {
    /**
     * Default constructor
     */
    @SuppressWarnings("deprecation")
    public ExtendedEcoreEvaluationEnvironment() {
      super();
    }
    
    /**
     * Constructor
     */
    public ExtendedEcoreEvaluationEnvironment(
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent_p) {
      super(parent_p);
    }
    
    /**
     * @see org.eclipse.ocl.ecore.EcoreEvaluationEnvironment#callOperation(org.eclipse.emf.ecore.EOperation, int, java.lang.Object, java.lang.Object[])
     */
    @Override
    public Object callOperation(EOperation operation_p, int opcode_p, Object source_p, Object[] args_p)
    throws IllegalArgumentException {
      Object result = null;
      // Try custom operation
      OperationSignature signature = new OperationSignature(operation_p);
      CustomOperation customOperation = _additionalOperations.get(signature);
      if (customOperation != null)
        result = customOperation.executeOn(source_p, Arrays.asList(args_p));
      // Finish
      if (result != null)
        result = coerceValue(operation_p, result, false);
      else
        result = super.callOperation(operation_p, opcode_p, source_p, args_p);
      return result;
    }
    
    /**
     * Duplicated from superclass for compatibility reasons
     * @see EcoreEvaluationEnvironment#coerceValue(ETypedElement, Object, boolean)
     */
    @Override
    protected Object coerceValue(ETypedElement element_p, Object value_p, boolean copy_p) {
      CollectionKind kind = getCollectionKind2(element_p);
      if (kind != null) {
        if (value_p instanceof Collection<?>) {
          return copy_p ? CollectionUtil.createNewCollection(kind,
              (Collection<?>) value_p): value_p;
        }
        Collection<Object> result = CollectionUtil.createNewCollection(kind);
        result.add(value_p);
        return result;
      }
      if (value_p instanceof Collection<?>) {
        Collection<?> collection = (Collection<?>) value_p;
        return collection.isEmpty()? null: collection.iterator().next();
      }
      return value_p;
    }
    
    /**
     * Duplicated from superclass for compatibility reasons and adapted
     * @see EcoreEvaluationEnvironment#getCollectionKind(ETypedElement)
     */
    private CollectionKind getCollectionKind2(ETypedElement element) {
      CollectionKind result = null;
      OCLStandardLibrary<EClassifier> library =
        OclPatternsPlugin.getDefault().getInterpreter().getStandardLibrary();
      if (element.isMany()) {
        result = CollectionKind.getKind(element.isOrdered(), element.isUnique());
      } else if (element.getEType() == library.getOrderedSet()) {
        result = CollectionKind.ORDERED_SET_LITERAL;
      } else if (element.getEType() == library.getSequence()) {
        result = CollectionKind.SEQUENCE_LITERAL;
      } else if (element.getEType() == library.getSet()) {
        result = CollectionKind.SET_LITERAL;
      } else if (element.getEType() == library.getBag()) {
        result = CollectionKind.BAG_LITERAL;
      } else if (element.getEType() == library.getCollection()) {
        result = CollectionKind.COLLECTION_LITERAL;
      }
      return result;
    }
    
  }

}
