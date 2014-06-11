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

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage
 * @generated
 */
public class TemplatepatternsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TemplatepatternsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatepatternsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TemplatepatternsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatepatternsSwitch<Adapter> modelSwitch =
		new TemplatepatternsSwitch<Adapter>() {
			@Override
			public Adapter caseTemplatePattern(TemplatePattern object) {
				return createTemplatePatternAdapter();
			}
			@Override
			public Adapter caseTemplatePatternData(TemplatePatternData object) {
				return createTemplatePatternDataAdapter();
			}
			@Override
			public Adapter caseTemplatePatternRole(TemplatePatternRole object) {
				return createTemplatePatternRoleAdapter();
			}
			@Override
			public Adapter caseAbstractRoleSpecification(AbstractRoleSpecification object) {
				return createAbstractRoleSpecificationAdapter();
			}
			@Override
			public Adapter caseAbstractRoleConstraint(AbstractRoleConstraint object) {
				return createAbstractRoleConstraintAdapter();
			}
			@Override
			public Adapter caseAbstractRoleDerivationRule(AbstractRoleDerivationRule object) {
				return createAbstractRoleDerivationRuleAdapter();
			}
			@Override
			public Adapter caseIdBasedDerivationRule(IdBasedDerivationRule object) {
				return createIdBasedDerivationRuleAdapter();
			}
			@Override
			public Adapter caseQNameBasedDerivationRule(QNameBasedDerivationRule object) {
				return createQNameBasedDerivationRuleAdapter();
			}
			@Override
			public Adapter caseAbstractTextualQuery(AbstractTextualQuery object) {
				return createAbstractTextualQueryAdapter();
			}
			@Override
			public Adapter caseTextualRoleDerivationRule(TextualRoleDerivationRule object) {
				return createTextualRoleDerivationRuleAdapter();
			}
			@Override
			public Adapter caseTextualRoleConstraint(TextualRoleConstraint object) {
				return createTextualRoleConstraintAdapter();
			}
			@Override
			public Adapter caseInstanceCounterpart(InstanceCounterpart object) {
				return createInstanceCounterpartAdapter();
			}
			@Override
			public Adapter caseInstanceIdEntry(Map.Entry<String, InstanceCounterpart> object) {
				return createInstanceIdEntryAdapter();
			}
			@Override
			public Adapter caseTemplateIdEntry(Map.Entry<String, TemplateCounterpart> object) {
				return createTemplateIdEntryAdapter();
			}
			@Override
			public Adapter caseTemplateCounterpart(TemplateCounterpart object) {
				return createTemplateCounterpartAdapter();
			}
			@Override
			public Adapter caseInstancePart(Map.Entry<String, String> object) {
				return createInstancePartAdapter();
			}
			@Override
			public Adapter caseImageSpecification(ImageSpecification object) {
				return createImageSpecificationAdapter();
			}
			@Override
			public Adapter caseLayoutEntry(Map.Entry<EObject, Layout> object) {
				return createLayoutEntryAdapter();
			}
			@Override
			public Adapter caseLayout(Layout object) {
				return createLayoutAdapter();
			}
			@Override
			public Adapter caseNodeLayout(NodeLayout object) {
				return createNodeLayoutAdapter();
			}
			@Override
			public Adapter caseEdgeLayout(EdgeLayout object) {
				return createEdgeLayoutAdapter();
			}
			@Override
			public Adapter caseEdgeBendpoint(EdgeBendpoint object) {
				return createEdgeBendpointAdapter();
			}
			@Override
			public Adapter caseShapeLayout(ShapeLayout object) {
				return createShapeLayoutAdapter();
			}
			@Override
			public Adapter caseTemplateFontStyle(TemplateFontStyle object) {
				return createTemplateFontStyleAdapter();
			}
			@Override
			public Adapter caseStyle(Style object) {
				return createStyleAdapter();
			}
			@Override
			public Adapter caseNodeStyle(NodeStyle object) {
				return createNodeStyleAdapter();
			}
			@Override
			public Adapter caseEdgeStyle(EdgeStyle object) {
				return createEdgeStyleAdapter();
			}
			@Override
			public Adapter caseIIdentifiedElement(IIdentifiedElement object) {
				return createIIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseAbstractIdentifiedElement(AbstractIdentifiedElement object) {
				return createAbstractIdentifiedElementAdapter();
			}
			@Override
			public Adapter caseINamedElement(INamedElement object) {
				return createINamedElementAdapter();
			}
			@Override
			public Adapter caseAbstractNamedElement(AbstractNamedElement object) {
				return createAbstractNamedElementAdapter();
			}
			@Override
			public Adapter caseIDescribedElement(IDescribedElement object) {
				return createIDescribedElementAdapter();
			}
			@Override
			public Adapter caseAbstractDescribedElement(AbstractDescribedElement object) {
				return createAbstractDescribedElementAdapter();
			}
			@Override
			public Adapter caseIVersionedElement(IVersionedElement object) {
				return createIVersionedElementAdapter();
			}
			@Override
			public Adapter caseAbstractVersionedElement(AbstractVersionedElement object) {
				return createAbstractVersionedElementAdapter();
			}
			@Override
			public Adapter caseIPattern(IPattern object) {
				return createIPatternAdapter();
			}
			@Override
			public Adapter caseAbstractPattern(AbstractPattern object) {
				return createAbstractPatternAdapter();
			}
			@Override
			public Adapter caseIPatternData(IPatternData object) {
				return createIPatternDataAdapter();
			}
			@Override
			public Adapter caseAbstractPatternData(AbstractPatternData object) {
				return createAbstractPatternDataAdapter();
			}
			@Override
			public Adapter caseIPatternBasedBijection(IPatternBasedBijection object) {
				return createIPatternBasedBijectionAdapter();
			}
			@Override
			public Adapter caseIPatternBasedFunction(IPatternBasedFunction object) {
				return createIPatternBasedFunctionAdapter();
			}
			@Override
			public Adapter caseIPatternRole(IPatternRole object) {
				return createIPatternRoleAdapter();
			}
			@Override
			public Adapter caseAbstractPatternRole(AbstractPatternRole object) {
				return createAbstractPatternRoleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern <em>Template Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern
	 * @generated
	 */
	public Adapter createTemplatePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData <em>Template Pattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData
	 * @generated
	 */
	public Adapter createTemplatePatternDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole <em>Template Pattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole
	 * @generated
	 */
	public Adapter createTemplatePatternRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification <em>Abstract Role Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification
	 * @generated
	 */
	public Adapter createAbstractRoleSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint <em>Abstract Role Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint
	 * @generated
	 */
	public Adapter createAbstractRoleConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule <em>Abstract Role Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule
	 * @generated
	 */
	public Adapter createAbstractRoleDerivationRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule <em>Id Based Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule
	 * @generated
	 */
	public Adapter createIdBasedDerivationRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule <em>QName Based Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule
	 * @generated
	 */
	public Adapter createQNameBasedDerivationRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery <em>Abstract Textual Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery
	 * @generated
	 */
	public Adapter createAbstractTextualQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule <em>Textual Role Derivation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule
	 * @generated
	 */
	public Adapter createTextualRoleDerivationRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint <em>Textual Role Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint
	 * @generated
	 */
	public Adapter createTextualRoleConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart <em>Template Counterpart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart
	 * @generated
	 */
	public Adapter createTemplateCounterpartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Instance Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createInstancePartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification <em>Image Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification
	 * @generated
	 */
	public Adapter createImageSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Layout Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createLayoutEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout
	 * @generated
	 */
	public Adapter createLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout <em>Node Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout
	 * @generated
	 */
	public Adapter createNodeLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout <em>Edge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout
	 * @generated
	 */
	public Adapter createEdgeLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint <em>Edge Bendpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint
	 * @generated
	 */
	public Adapter createEdgeBendpointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout <em>Shape Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout
	 * @generated
	 */
	public Adapter createShapeLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle <em>Template Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle
	 * @generated
	 */
	public Adapter createTemplateFontStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Style
	 * @generated
	 */
	public Adapter createStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle <em>Node Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle
	 * @generated
	 */
	public Adapter createNodeStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle <em>Edge Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle
	 * @generated
	 */
	public Adapter createEdgeStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart <em>Instance Counterpart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart
	 * @generated
	 */
	public Adapter createInstanceCounterpartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Instance Id Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createInstanceIdEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Template Id Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createTemplateIdEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement <em>IIdentified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IIdentifiedElement
	 * @generated
	 */
	public Adapter createIIdentifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement <em>Abstract Identified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement
	 * @generated
	 */
	public Adapter createAbstractIdentifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.INamedElement <em>INamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.INamedElement
	 * @generated
	 */
	public Adapter createINamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement <em>Abstract Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractNamedElement
	 * @generated
	 */
	public Adapter createAbstractNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement <em>IDescribed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IDescribedElement
	 * @generated
	 */
	public Adapter createIDescribedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement <em>Abstract Described Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractDescribedElement
	 * @generated
	 */
	public Adapter createAbstractDescribedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement <em>IVersioned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement
	 * @generated
	 */
	public Adapter createIVersionedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement <em>Abstract Versioned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement
	 * @generated
	 */
	public Adapter createAbstractVersionedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPattern <em>IPattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPattern
	 * @generated
	 */
	public Adapter createIPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern <em>Abstract Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern
	 * @generated
	 */
	public Adapter createAbstractPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection <em>IPattern Based Bijection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection
	 * @generated
	 */
	public Adapter createIPatternBasedBijectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction <em>IPattern Based Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction
	 * @generated
	 */
	public Adapter createIPatternBasedFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole <em>IPattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole
	 * @generated
	 */
	public Adapter createIPatternRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole <em>Abstract Pattern Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternRole
	 * @generated
	 */
	public Adapter createAbstractPatternRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.api.IPatternData <em>IPattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternData
	 * @generated
	 */
	public Adapter createIPatternDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData <em>Abstract Pattern Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData
	 * @generated
	 */
	public Adapter createAbstractPatternDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TemplatepatternsAdapterFactory
