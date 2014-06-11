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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.*;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage
 * @generated
 */
public class TemplatepatternsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TemplatepatternsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatepatternsSwitch() {
		if (modelPackage == null) {
			modelPackage = TemplatepatternsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN: {
				TemplatePattern templatePattern = (TemplatePattern)theEObject;
				T result = caseTemplatePattern(templatePattern);
				if (result == null) result = caseAbstractPattern(templatePattern);
				if (result == null) result = caseAbstractNamedElement(templatePattern);
				if (result == null) result = caseAbstractDescribedElement(templatePattern);
				if (result == null) result = caseAbstractVersionedElement(templatePattern);
				if (result == null) result = caseIPattern(templatePattern);
				if (result == null) result = caseAbstractIdentifiedElement(templatePattern);
				if (result == null) result = caseINamedElement(templatePattern);
				if (result == null) result = caseIDescribedElement(templatePattern);
				if (result == null) result = caseIVersionedElement(templatePattern);
				if (result == null) result = caseIIdentifiedElement(templatePattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA: {
				TemplatePatternData templatePatternData = (TemplatePatternData)theEObject;
				T result = caseTemplatePatternData(templatePatternData);
				if (result == null) result = caseAbstractPatternData(templatePatternData);
				if (result == null) result = caseIPatternBasedFunction(templatePatternData);
				if (result == null) result = caseAbstractIdentifiedElement(templatePatternData);
				if (result == null) result = caseIPatternData(templatePatternData);
				if (result == null) result = caseIPatternBasedBijection(templatePatternData);
				if (result == null) result = caseIIdentifiedElement(templatePatternData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE: {
				TemplatePatternRole templatePatternRole = (TemplatePatternRole)theEObject;
				T result = caseTemplatePatternRole(templatePatternRole);
				if (result == null) result = caseAbstractPatternRole(templatePatternRole);
				if (result == null) result = caseAbstractNamedElement(templatePatternRole);
				if (result == null) result = caseAbstractDescribedElement(templatePatternRole);
				if (result == null) result = caseIPatternRole(templatePatternRole);
				if (result == null) result = caseAbstractIdentifiedElement(templatePatternRole);
				if (result == null) result = caseINamedElement(templatePatternRole);
				if (result == null) result = caseIDescribedElement(templatePatternRole);
				if (result == null) result = caseIIdentifiedElement(templatePatternRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.ABSTRACT_ROLE_SPECIFICATION: {
				AbstractRoleSpecification abstractRoleSpecification = (AbstractRoleSpecification)theEObject;
				T result = caseAbstractRoleSpecification(abstractRoleSpecification);
				if (result == null) result = caseAbstractIdentifiedElement(abstractRoleSpecification);
				if (result == null) result = caseIIdentifiedElement(abstractRoleSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.ABSTRACT_ROLE_CONSTRAINT: {
				AbstractRoleConstraint abstractRoleConstraint = (AbstractRoleConstraint)theEObject;
				T result = caseAbstractRoleConstraint(abstractRoleConstraint);
				if (result == null) result = caseAbstractRoleSpecification(abstractRoleConstraint);
				if (result == null) result = caseAbstractIdentifiedElement(abstractRoleConstraint);
				if (result == null) result = caseIIdentifiedElement(abstractRoleConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.ABSTRACT_ROLE_DERIVATION_RULE: {
				AbstractRoleDerivationRule abstractRoleDerivationRule = (AbstractRoleDerivationRule)theEObject;
				T result = caseAbstractRoleDerivationRule(abstractRoleDerivationRule);
				if (result == null) result = caseAbstractRoleSpecification(abstractRoleDerivationRule);
				if (result == null) result = caseAbstractIdentifiedElement(abstractRoleDerivationRule);
				if (result == null) result = caseIIdentifiedElement(abstractRoleDerivationRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.ID_BASED_DERIVATION_RULE: {
				IdBasedDerivationRule idBasedDerivationRule = (IdBasedDerivationRule)theEObject;
				T result = caseIdBasedDerivationRule(idBasedDerivationRule);
				if (result == null) result = caseAbstractRoleDerivationRule(idBasedDerivationRule);
				if (result == null) result = caseAbstractRoleSpecification(idBasedDerivationRule);
				if (result == null) result = caseAbstractIdentifiedElement(idBasedDerivationRule);
				if (result == null) result = caseIIdentifiedElement(idBasedDerivationRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.QNAME_BASED_DERIVATION_RULE: {
				QNameBasedDerivationRule qNameBasedDerivationRule = (QNameBasedDerivationRule)theEObject;
				T result = caseQNameBasedDerivationRule(qNameBasedDerivationRule);
				if (result == null) result = caseAbstractRoleDerivationRule(qNameBasedDerivationRule);
				if (result == null) result = caseAbstractRoleSpecification(qNameBasedDerivationRule);
				if (result == null) result = caseAbstractIdentifiedElement(qNameBasedDerivationRule);
				if (result == null) result = caseIIdentifiedElement(qNameBasedDerivationRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.ABSTRACT_TEXTUAL_QUERY: {
				AbstractTextualQuery abstractTextualQuery = (AbstractTextualQuery)theEObject;
				T result = caseAbstractTextualQuery(abstractTextualQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.TEXTUAL_ROLE_DERIVATION_RULE: {
				TextualRoleDerivationRule textualRoleDerivationRule = (TextualRoleDerivationRule)theEObject;
				T result = caseTextualRoleDerivationRule(textualRoleDerivationRule);
				if (result == null) result = caseAbstractTextualQuery(textualRoleDerivationRule);
				if (result == null) result = caseAbstractRoleDerivationRule(textualRoleDerivationRule);
				if (result == null) result = caseAbstractRoleSpecification(textualRoleDerivationRule);
				if (result == null) result = caseAbstractIdentifiedElement(textualRoleDerivationRule);
				if (result == null) result = caseIIdentifiedElement(textualRoleDerivationRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT: {
				TextualRoleConstraint textualRoleConstraint = (TextualRoleConstraint)theEObject;
				T result = caseTextualRoleConstraint(textualRoleConstraint);
				if (result == null) result = caseAbstractTextualQuery(textualRoleConstraint);
				if (result == null) result = caseAbstractRoleConstraint(textualRoleConstraint);
				if (result == null) result = caseAbstractRoleSpecification(textualRoleConstraint);
				if (result == null) result = caseAbstractIdentifiedElement(textualRoleConstraint);
				if (result == null) result = caseIIdentifiedElement(textualRoleConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.INSTANCE_COUNTERPART: {
				InstanceCounterpart instanceCounterpart = (InstanceCounterpart)theEObject;
				T result = caseInstanceCounterpart(instanceCounterpart);
				if (result == null) result = caseAbstractIdentifiedElement(instanceCounterpart);
				if (result == null) result = caseIIdentifiedElement(instanceCounterpart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.INSTANCE_ID_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, InstanceCounterpart> instanceIdEntry = (Map.Entry<String, InstanceCounterpart>)theEObject;
				T result = caseInstanceIdEntry(instanceIdEntry);
				if (result == null) result = caseAbstractIdentifiedElement((AbstractIdentifiedElement)instanceIdEntry);
				if (result == null) result = caseIIdentifiedElement((IIdentifiedElement)instanceIdEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.TEMPLATE_ID_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, TemplateCounterpart> templateIdEntry = (Map.Entry<String, TemplateCounterpart>)theEObject;
				T result = caseTemplateIdEntry(templateIdEntry);
				if (result == null) result = caseAbstractIdentifiedElement((AbstractIdentifiedElement)templateIdEntry);
				if (result == null) result = caseIIdentifiedElement((IIdentifiedElement)templateIdEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.TEMPLATE_COUNTERPART: {
				TemplateCounterpart templateCounterpart = (TemplateCounterpart)theEObject;
				T result = caseTemplateCounterpart(templateCounterpart);
				if (result == null) result = caseAbstractIdentifiedElement(templateCounterpart);
				if (result == null) result = caseIIdentifiedElement(templateCounterpart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.INSTANCE_PART: {
				@SuppressWarnings("unchecked") Map.Entry<String, String> instancePart = (Map.Entry<String, String>)theEObject;
				T result = caseInstancePart(instancePart);
				if (result == null) result = caseAbstractIdentifiedElement((AbstractIdentifiedElement)instancePart);
				if (result == null) result = caseIIdentifiedElement((IIdentifiedElement)instancePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.IMAGE_SPECIFICATION: {
				ImageSpecification imageSpecification = (ImageSpecification)theEObject;
				T result = caseImageSpecification(imageSpecification);
				if (result == null) result = caseAbstractIdentifiedElement(imageSpecification);
				if (result == null) result = caseIIdentifiedElement(imageSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.LAYOUT_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<EObject, Layout> layoutEntry = (Map.Entry<EObject, Layout>)theEObject;
				T result = caseLayoutEntry(layoutEntry);
				if (result == null) result = caseAbstractIdentifiedElement((AbstractIdentifiedElement)layoutEntry);
				if (result == null) result = caseIIdentifiedElement((IIdentifiedElement)layoutEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.LAYOUT: {
				Layout layout = (Layout)theEObject;
				T result = caseLayout(layout);
				if (result == null) result = caseAbstractIdentifiedElement(layout);
				if (result == null) result = caseIIdentifiedElement(layout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.NODE_LAYOUT: {
				NodeLayout nodeLayout = (NodeLayout)theEObject;
				T result = caseNodeLayout(nodeLayout);
				if (result == null) result = caseShapeLayout(nodeLayout);
				if (result == null) result = caseLayout(nodeLayout);
				if (result == null) result = caseAbstractIdentifiedElement(nodeLayout);
				if (result == null) result = caseIIdentifiedElement(nodeLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.EDGE_LAYOUT: {
				EdgeLayout edgeLayout = (EdgeLayout)theEObject;
				T result = caseEdgeLayout(edgeLayout);
				if (result == null) result = caseShapeLayout(edgeLayout);
				if (result == null) result = caseLayout(edgeLayout);
				if (result == null) result = caseAbstractIdentifiedElement(edgeLayout);
				if (result == null) result = caseIIdentifiedElement(edgeLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.EDGE_BENDPOINT: {
				EdgeBendpoint edgeBendpoint = (EdgeBendpoint)theEObject;
				T result = caseEdgeBendpoint(edgeBendpoint);
				if (result == null) result = caseAbstractIdentifiedElement(edgeBendpoint);
				if (result == null) result = caseIIdentifiedElement(edgeBendpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.SHAPE_LAYOUT: {
				ShapeLayout shapeLayout = (ShapeLayout)theEObject;
				T result = caseShapeLayout(shapeLayout);
				if (result == null) result = caseLayout(shapeLayout);
				if (result == null) result = caseAbstractIdentifiedElement(shapeLayout);
				if (result == null) result = caseIIdentifiedElement(shapeLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE: {
				TemplateFontStyle templateFontStyle = (TemplateFontStyle)theEObject;
				T result = caseTemplateFontStyle(templateFontStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.STYLE: {
				Style style = (Style)theEObject;
				T result = caseStyle(style);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.NODE_STYLE: {
				NodeStyle nodeStyle = (NodeStyle)theEObject;
				T result = caseNodeStyle(nodeStyle);
				if (result == null) result = caseStyle(nodeStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TemplatepatternsPackage.EDGE_STYLE: {
				EdgeStyle edgeStyle = (EdgeStyle)theEObject;
				T result = caseEdgeStyle(edgeStyle);
				if (result == null) result = caseStyle(edgeStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplatePattern(TemplatePattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Pattern Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Pattern Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplatePatternData(TemplatePatternData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Pattern Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Pattern Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplatePatternRole(TemplatePatternRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Role Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Role Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRoleSpecification(AbstractRoleSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Role Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Role Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRoleConstraint(AbstractRoleConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Role Derivation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Role Derivation Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRoleDerivationRule(AbstractRoleDerivationRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Based Derivation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Based Derivation Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdBasedDerivationRule(IdBasedDerivationRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QName Based Derivation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QName Based Derivation Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQNameBasedDerivationRule(QNameBasedDerivationRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Textual Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Textual Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTextualQuery(AbstractTextualQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Textual Role Derivation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Textual Role Derivation Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextualRoleDerivationRule(TextualRoleDerivationRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Textual Role Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Textual Role Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextualRoleConstraint(TextualRoleConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Counterpart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Counterpart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceCounterpart(InstanceCounterpart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Id Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Id Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceIdEntry(Map.Entry<String, InstanceCounterpart> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Id Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Id Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateIdEntry(Map.Entry<String, TemplateCounterpart> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Counterpart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Counterpart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateCounterpart(TemplateCounterpart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePart(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageSpecification(ImageSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayoutEntry(Map.Entry<EObject, Layout> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayout(Layout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeLayout(NodeLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeLayout(EdgeLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Bendpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Bendpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeBendpoint(EdgeBendpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shape Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shape Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShapeLayout(ShapeLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Font Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Font Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateFontStyle(TemplateFontStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyle(Style object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeStyle(NodeStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeStyle(EdgeStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IIdentified Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IIdentified Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIIdentifiedElement(IIdentifiedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Identified Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Identified Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractIdentifiedElement(AbstractIdentifiedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseINamedElement(INamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNamedElement(AbstractNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IDescribed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IDescribed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDescribedElement(IDescribedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Described Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Described Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDescribedElement(AbstractDescribedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVersioned Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVersioned Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIVersionedElement(IVersionedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Versioned Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Versioned Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractVersionedElement(AbstractVersionedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPattern(IPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPattern(AbstractPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Based Bijection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Based Bijection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternBasedBijection(IPatternBasedBijection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Based Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Based Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternBasedFunction(IPatternBasedFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternRole(IPatternRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPatternRole(AbstractPatternRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPattern Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPattern Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPatternData(IPatternData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pattern Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pattern Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPatternData(AbstractPatternData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //TemplatepatternsSwitch
