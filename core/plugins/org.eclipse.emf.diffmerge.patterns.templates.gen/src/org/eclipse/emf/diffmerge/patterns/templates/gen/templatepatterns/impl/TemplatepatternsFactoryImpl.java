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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.*;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplatepatternsFactoryImpl extends EFactoryImpl implements TemplatepatternsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TemplatepatternsFactory init() {
		try {
			TemplatepatternsFactory theTemplatepatternsFactory = (TemplatepatternsFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.eclipse.com/emf/diffmerge/patterns/templates/1.0.0");  //$NON-NLS-1$
			if (theTemplatepatternsFactory != null) {
				return theTemplatepatternsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TemplatepatternsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatepatternsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN: return createTemplatePattern();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA: return createTemplatePatternData();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE: return createTemplatePatternRole();
			case TemplatepatternsPackage.ID_BASED_DERIVATION_RULE: return createIdBasedDerivationRule();
			case TemplatepatternsPackage.QNAME_BASED_DERIVATION_RULE: return createQNameBasedDerivationRule();
			case TemplatepatternsPackage.TEXTUAL_ROLE_DERIVATION_RULE: return createTextualRoleDerivationRule();
			case TemplatepatternsPackage.TEXTUAL_ROLE_CONSTRAINT: return createTextualRoleConstraint();
			case TemplatepatternsPackage.INSTANCE_COUNTERPART: return createInstanceCounterpart();
			case TemplatepatternsPackage.INSTANCE_ID_ENTRY: return (EObject)createInstanceIdEntry();
			case TemplatepatternsPackage.TEMPLATE_ID_ENTRY: return (EObject)createTemplateIdEntry();
			case TemplatepatternsPackage.TEMPLATE_COUNTERPART: return createTemplateCounterpart();
			case TemplatepatternsPackage.INSTANCE_PART: return (EObject)createInstancePart();
			case TemplatepatternsPackage.IMAGE_SPECIFICATION: return createImageSpecification();
			case TemplatepatternsPackage.LAYOUT_ENTRY: return (EObject)createLayoutEntry();
			case TemplatepatternsPackage.NODE_LAYOUT: return createNodeLayout();
			case TemplatepatternsPackage.EDGE_LAYOUT: return createEdgeLayout();
			case TemplatepatternsPackage.EDGE_BENDPOINT: return createEdgeBendpoint();
			case TemplatepatternsPackage.TEMPLATE_FONT_STYLE: return createTemplateFontStyle();
			case TemplatepatternsPackage.NODE_STYLE: return createNodeStyle();
			case TemplatepatternsPackage.EDGE_STYLE: return createEdgeStyle();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TemplatepatternsPackage.ADDITION_KIND:
				return createAdditionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TemplatepatternsPackage.ADDITION_KIND:
				return convertAdditionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatePattern createTemplatePattern() {
		TemplatePatternImpl templatePattern = new TemplatePatternImpl();
		return templatePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatePatternData createTemplatePatternData() {
		TemplatePatternDataImpl templatePatternData = new TemplatePatternDataImpl();
		return templatePatternData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatePatternRole createTemplatePatternRole() {
		TemplatePatternRoleImpl templatePatternRole = new TemplatePatternRoleImpl();
		return templatePatternRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdBasedDerivationRule createIdBasedDerivationRule() {
		IdBasedDerivationRuleImpl idBasedDerivationRule = new IdBasedDerivationRuleImpl();
		return idBasedDerivationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNameBasedDerivationRule createQNameBasedDerivationRule() {
		QNameBasedDerivationRuleImpl qNameBasedDerivationRule = new QNameBasedDerivationRuleImpl();
		return qNameBasedDerivationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextualRoleDerivationRule createTextualRoleDerivationRule() {
		TextualRoleDerivationRuleImpl textualRoleDerivationRule = new TextualRoleDerivationRuleImpl();
		return textualRoleDerivationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextualRoleConstraint createTextualRoleConstraint() {
		TextualRoleConstraintImpl textualRoleConstraint = new TextualRoleConstraintImpl();
		return textualRoleConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateCounterpart createTemplateCounterpart() {
		TemplateCounterpartImpl templateCounterpart = new TemplateCounterpartImpl();
		return templateCounterpart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createInstancePart() {
		InstancePartImpl instancePart = new InstancePartImpl();
		return instancePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageSpecification createImageSpecification() {
		ImageSpecificationImpl imageSpecification = new ImageSpecificationImpl();
		return imageSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EObject, Layout> createLayoutEntry() {
		LayoutEntryImpl layoutEntry = new LayoutEntryImpl();
		return layoutEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeLayout createNodeLayout() {
		NodeLayoutImpl nodeLayout = new NodeLayoutImpl();
		return nodeLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeLayout createEdgeLayout() {
		EdgeLayoutImpl edgeLayout = new EdgeLayoutImpl();
		return edgeLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeBendpoint createEdgeBendpoint() {
		EdgeBendpointImpl edgeBendpoint = new EdgeBendpointImpl();
		return edgeBendpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateFontStyle createTemplateFontStyle() {
		TemplateFontStyleImpl templateFontStyle = new TemplateFontStyleImpl();
		return templateFontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeStyle createNodeStyle() {
		NodeStyleImpl nodeStyle = new NodeStyleImpl();
		return nodeStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeStyle createEdgeStyle() {
		EdgeStyleImpl edgeStyle = new EdgeStyleImpl();
		return edgeStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceCounterpart createInstanceCounterpart() {
		InstanceCounterpartImpl instanceCounterpart = new InstanceCounterpartImpl();
		return instanceCounterpart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, InstanceCounterpart> createInstanceIdEntry() {
		InstanceIdEntryImpl instanceIdEntry = new InstanceIdEntryImpl();
		return instanceIdEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, TemplateCounterpart> createTemplateIdEntry() {
		TemplateIdEntryImpl templateIdEntry = new TemplateIdEntryImpl();
		return templateIdEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditionKind createAdditionKindFromString(EDataType eDataType, String initialValue) {
		AdditionKind result = AdditionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdditionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatepatternsPackage getTemplatepatternsPackage() {
		return (TemplatepatternsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@SuppressWarnings("javadoc")
  @Deprecated
	public static TemplatepatternsPackage getPackage() {
		return TemplatepatternsPackage.eINSTANCE;
	}

} //TemplatepatternsFactoryImpl
