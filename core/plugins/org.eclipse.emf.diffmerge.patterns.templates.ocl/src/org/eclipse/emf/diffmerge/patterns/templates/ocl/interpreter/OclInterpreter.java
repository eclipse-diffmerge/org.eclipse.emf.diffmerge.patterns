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
package org.eclipse.emf.diffmerge.patterns.templates.ocl.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.templates.ocl.IOclEnvironmentCustomizer;
import org.eclipse.emf.diffmerge.patterns.templates.ocl.OclPatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.ocl.IOclEnvironmentCustomizer.VariableSpecification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.types.OCLStandardLibrary;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * An easy-to-use OCL interpreter which is a simple facade on the Eclipse OCL engine
 * @author Olivier Constant
 */
public class OclInterpreter {
  
  /** The default context object for OCL queries */
  private static final Object DEFAULT_CONTEXT = new Object();
  
  /** The specific environment factory */
  private static final PatternEnvironmentFactory ENVIRONMENT_FACTORY =
    new PatternEnvironmentFactory();
  
  /** A potentially null reference OCL which is identical to those which are created by default */
  private static OCL __referenceOcl = null;
  
  /**
   * Return a reference OCL which is identical to those which are created by default
   * @return a non-null OCL
   */
  private static OCL getReferenceOcl() {
    if (__referenceOcl == null)
      __referenceOcl = createOCL();
    return __referenceOcl;
  }
  
  
	/**
	 * Constructor
	 */
	public OclInterpreter() {
	  // Nothing specific
	}
	
  /**
   * Add a new variable to the given environment with the given name and type
   * @param env_p a non-null environment
   * @param name_p a non-null name
   * @param type_p a non-null type
   */
  protected void addVariable(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
      EEnumLiteral, EParameter, EObject, ?, ?, ?, EClass, EObject> env_p, String name_p, EClassifier type_p) {
    Variable variable = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVariable();
    variable.setName(name_p);
    variable.setType(type_p);
    env_p.addElement(name_p, variable, true);
  }
  
  /**
   * Return a variant of the given name which can be used as an OCL identifier
   * @param name_p a potentially null string
   * @return a potentially null string
   */
  private String asOclIdentifier(String name_p) {
    String result = name_p.replaceAll(" ", "");  //$NON-NLS-1$//$NON-NLS-2$
    result = result.replaceAll(":", "_");  //$NON-NLS-1$//$NON-NLS-2$
    return result;
  }
  
	/**
	 * Check the given boolean query on the given context element
	 * @param booleanQuery_p a non-null textual OCL query of type boolean
	 * @param context_p an optional element
	 * @return whether the context complies to the constraint given by the boolean query
	 */
	public boolean check(String booleanQuery_p, EObject context_p) throws ParserException {
    OCL.Query query = createQuery(booleanQuery_p, context_p == null? null: context_p.eClass());
    boolean result = query.check(context_p);
    return result;
	}
	
  /**
   * Check the given boolean query on the given context element
   * @param booleanQuery_p a non-null textual OCL query of type boolean
   * @param context_p an optional element
   * @param roleContext_p a non-null pattern role
   * @return whether the context complies to the constraint given by the boolean query
   */
  public boolean check(String booleanQuery_p, EObject context_p, TemplatePatternRole roleContext_p)
  throws ParserException {
    OCL.Query query = createQuery(booleanQuery_p, roleContext_p, context_p);
    boolean result = query.check(context_p);
    return result;
  }
  
	/**
	 * Create and return an OCL query corresponding to the given textual specification for the
	 * given parsing context
	 * @param query_p a non-null string
	 * @param parsingContext_p an optional meta-type
	 * @return a non-null OCL query
	 */
	private OCL.Query createQuery(String query_p, EClassifier parsingContext_p) throws ParserException {
	  OCL ocl = createOCL();
	  OCLExpression parsed = parse(ocl, query_p, parsingContext_p);
	  OCL.Query result = ocl.createQuery(parsed);
	  return result;
	}
	
  /**
   * Create and return an OCL query corresponding to the given textual specification for the
   * given role parsing context
   * @param query_p a non-null string
   * @param roleContext_p a non-null pattern role
   * @param context_p a potentially null context element
   * @return a non-null OCL query
   */
  private OCL.Query createQuery(String query_p, TemplatePatternRole roleContext_p,
      EObject context_p) throws ParserException {
    OCL ocl = createOCL(roleContext_p, context_p);
    OCLExpression parsed = parse(ocl, query_p, roleContext_p);
    OCL.Query result = ocl.createQuery(parsed);
    return result;
  }
  
  /**
   * Create and return an OCL
   * @return a non-null OCL
   */
  private static OCL createOCL() {
    OCL result = OCL.newInstance(ENVIRONMENT_FACTORY);
    result.setEvaluationTracingEnabled(false);
    return result;
  }
  
  /**
   * Create and return an OCL corresponding to the given role parsing context
   * and execution context
   * @param roleContext_p a non-null pattern role
   * @param context_p a potentially null context element
   * @return a non-null OCL
   */
  public OCL createOCL(TemplatePatternRole roleContext_p, EObject context_p) {
    OCL result = createOCL();
    setupEnvironment(result.getEnvironment(), roleContext_p, context_p);
    return result;
  }
  
  /**
   * Add variables for easier navigation
   * @param env_p a non-null environment
   * @param context_p an optional context element
   */
  private void enhanceEnvironment(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
      EEnumLiteral, EParameter, EObject, ?, ?, ?, EClass, EObject> env_p, EObject context_p) {
    Collection<VariableSpecification> specs = getAdditionalVariables(context_p);
    for (VariableSpecification spec : specs) {
      addVariable(env_p, spec.getName(), spec.getType());
    }
  }
  
  /**
   * Add variables for easier navigation
   * @param env_p a non-null environment
   * @param context_p an optional context element
   */
  private void enhanceEvaluationEnvironment(
      EvaluationEnvironment<EClassifier, ?, ?, EClass, EObject> env_p, EObject context_p) {
    Collection<VariableSpecification> specs = getAdditionalVariables(context_p);
    for (VariableSpecification spec : specs) {
      env_p.add(spec.getName(), spec.getValue());
    }
  }
  
  /**
   * Evaluate the given query on the given context element
   * @param query_p a non-null textual OCL query
   * @param context_p a potentially null element
   * @return a potentially null object being the result of the evaluation
   */
  public Object evaluate(String query_p, EObject context_p) throws ParserException {
    OCL.Query query = createQuery(query_p, context_p == null? null: context_p.eClass());
    Object result = query.evaluate(nonNull(context_p));
    return result;
  }
  
  /**
   * Evaluate the given query on the given context element in the additional context of a given
   * role and a given application of the same pattern
   * @param query_p a non-null textual OCL query
   * @param context_p a potentially null element
   * @param roleContext_p a non-null role
   * @param applicationContext_p a non-null application of the pattern of the given role
   * @return a potentially null object being the result of the evaluation
   */
  public Object evaluate(String query_p, EObject context_p, TemplatePatternRole roleContext_p,
      IPatternApplication applicationContext_p) throws ParserException {
    OCL.Query query = createQuery(query_p, roleContext_p, context_p);
    setupEvaluationEnvironment(query.getEvaluationEnvironment(), roleContext_p, applicationContext_p);
    Object result = query.evaluate(nonNull(context_p));
    return result;
  }
  
  /**
   * Evaluate the given query on the given context element in the additional context of a given
   * pattern role and (pattern, model) mapping
   * @param query_p a non-null textual OCL query
   * @param context_p a potentially null element
   * @param roleContext_p a non-null role
   * @param mapping_p a non-null (pattern, model) mapping
   * @return a potentially null object being the result of the evaluation
   */
  public Object evaluate(String query_p, EObject context_p, TemplatePatternRole roleContext_p,
      IPatternBasedBijection mapping_p) throws ParserException {
    OCL.Query query = createQuery(query_p, roleContext_p, context_p);
    setupEvaluationEnvironment(query.getEvaluationEnvironment(), roleContext_p, mapping_p);
    Object result = query.evaluate(nonNull(context_p));
    return result;
  }
  
  /**
   * Return specifications of additional variables for the environment
   * @param context_p a potentially null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  private Collection<VariableSpecification> getAdditionalVariables(EObject context_p) {
    Collection<VariableSpecification> result;
    IOclEnvironmentCustomizer customizer =
      OclPatternsPlugin.getDefault().getOclEnvironmentCustomizer();
    if (customizer != null)
      result = customizer.getVariables(context_p);
    else
      result = Collections.emptyList();
    return result;
  }
  
  /**
   * Return the parsing context meta-class for the given role
   * @param role_p a non-null role
   * @return a meta-class which is null iff role_p has no template elements
   */
  public EClassifier getParsingContextFor(TemplatePatternRole role_p) {
    EClassifier result;
    List<EObject> templateElements = role_p.getTemplateElements();
    if (templateElements.isEmpty())
      // Empty
      result = getStandardLibrary().getOclVoid();
    else if (templateElements.size() == 1)
      // Single element
      result = templateElements.get(0).eClass();
    else {
      // Collection
      EClass elementType = ModelsUtil.getCommonType(templateElements);
      OrderedSetType collectionType = EcoreFactory.eINSTANCE.createOrderedSetType();
      collectionType.setElementType(elementType);
      result = collectionType;
    }
    return result;
  }
  
  /**
   * Return the OCL standard library
   * @return a non-null OCL standard library
   */
  public OCLStandardLibrary<EClassifier> getStandardLibrary() {
    return getReferenceOcl().getEnvironment().getOCLStandardLibrary();
  }
  
  /**
   * The identity function extended with null |-> default object
   * @param object_p a potentially null object
   * @return a non-null object which is object_p if not null
   */
  private Object nonNull(Object object_p) {
    return object_p == null? DEFAULT_CONTEXT: object_p;
  }
  
  /**
   * Parse the given OCL query and return the corresponding syntax tree
   * @param ocl_p a non-null OCL
   * @param query_p a non-null textual OCL query
   * @param roleContext_p a non-null role
   * @return a non-null OCL expression
   */
  private OCLExpression parse(OCL ocl_p, String query_p, TemplatePatternRole roleContext_p)
  throws ParserException {
    OCLExpression result = parse(ocl_p, query_p, getParsingContextFor(roleContext_p));
    return result;
  }
  
  /**
   * Parse the given OCL query and return the corresponding syntax tree
   * @param ocl_p a non-null OCL
   * @param query_p a non-null textual OCL query
   * @param parsingContext_p a non-null role
   * @return a non-null OCL expression
   */
  private OCLExpression parse(OCL ocl_p, String query_p, EClassifier parsingContext_p)
  throws ParserException {
    OCL.Helper helper = ocl_p.createOCLHelper();
    helper.setContext(parsingContext_p);
    OCLExpression parsed = helper.createQuery(query_p);
    return parsed;
  }
  
  /**
   * Parse the given OCL query and return the corresponding syntax tree
   * @param query_p a non-null textual OCL query
   * @param roleContext_p a non-null role
   * @param context_p an optional context element for global model-relative variables
   * @return a non-null OCL expression
   */
  public OCLExpression parse(String query_p, TemplatePatternRole roleContext_p,
      EObject context_p) throws ParserException {
    OCL ocl = createOCL(roleContext_p, context_p);
    OCLExpression parsed = parse(ocl, query_p, roleContext_p);
    return parsed;
  }
  
  /**
   * Set up the given environment for the context of the given pattern role
   * @param env_p a non-null environment
   * @param roleContext_p a non-null role
   * @param context_p an optional context element for global model-relative variables
   */
  public void setupEnvironment(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
      EEnumLiteral, EParameter, EObject, ?, ?, ?, EClass, EObject> env_p,
      TemplatePatternRole roleContext_p, EObject context_p) {
    Iterator<TemplatePatternRole> it = roleContext_p.getPattern().getRoles().iterator();
    if (it.hasNext()) {
      TemplatePatternRole currentRole = it.next();
      while (it.hasNext() && currentRole != roleContext_p) {
        String identifier = asOclIdentifier(currentRole.getName());
        EClassifier variableType = getParsingContextFor(currentRole);
        addVariable(env_p, identifier, variableType);
        currentRole = it.next();
      }
    }
    enhanceEnvironment(env_p, context_p);
  }
  
  /**
   * Set up the given evaluation environment for the given role and application context of a pattern
   * @param env_p a non-null evaluation environment
   * @param roleContext_p a non-null role
   * @param applicationContext_p a non-null application of the pattern of the given role
   */
  public void setupEvaluationEnvironment(EvaluationEnvironment<EClassifier, ?, ?, EClass, EObject> env_p,
      TemplatePatternRole roleContext_p, IPatternApplication applicationContext_p) {
    Iterator<TemplatePatternRole> it = roleContext_p.getPattern().getRoles().iterator();
    if (it.hasNext()) {
      TemplatePatternRole currentRole = it.next();
      while (it.hasNext() && currentRole != roleContext_p) {
        ILocation location = applicationContext_p.getLocation(currentRole);
        List<EObject> mergeTargets = LocationsUtil.getMergeTargets(location);
        Object target = (mergeTargets.size() == 1 || !currentRole.isGeneric())? mergeTargets.get(0):
          mergeTargets;
        env_p.add(asOclIdentifier(currentRole.getName()), target);
        currentRole = it.next();
      }
    }
    Object scopeElement = applicationContext_p.getScopeElement();
    EObject contextElement = scopeElement instanceof EObject? (EObject)scopeElement: null;
    enhanceEvaluationEnvironment(env_p, contextElement);
  }
  
  /**
   * Set up the given evaluation environment for the given role and (pattern, model) mapping
   * @param env_p a non-null evaluation environment
   * @param roleContext_p a non-null role
   * @param mapping_p a non-null (pattern, model) mapping
   */
  public void setupEvaluationEnvironment(EvaluationEnvironment<EClassifier, ?, ?, EClass, EObject> env_p,
      TemplatePatternRole roleContext_p, IPatternBasedBijection mapping_p) {
    Iterator<TemplatePatternRole> it = roleContext_p.getPattern().getRoles().iterator();
    if (it.hasNext()) {
      TemplatePatternRole currentRole = it.next();
      while (it.hasNext() && currentRole != roleContext_p) {
        List<EObject> modelElements = new ModelsUtil.RList<EObject>();
        for (EObject templateElement : currentRole.getTemplateElements()) {
          EObject modelElement = mapping_p.getCounterpart(templateElement, true);
          if (modelElement != null)
            modelElements.add(modelElement);
        }
        String identifier = asOclIdentifier(currentRole.getName());
        env_p.add(identifier, modelElements.size() == 1? modelElements.get(0): modelElements);
        currentRole = it.next();
      }
    }
    Object scopeElement = mapping_p.getScopeElement();
    EObject contextElement = scopeElement instanceof EObject? (EObject)scopeElement: null;
    enhanceEvaluationEnvironment(env_p, contextElement);
  }
  
}
