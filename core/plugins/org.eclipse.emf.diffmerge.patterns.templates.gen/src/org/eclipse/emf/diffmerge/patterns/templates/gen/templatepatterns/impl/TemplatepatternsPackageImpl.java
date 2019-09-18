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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.PredefinedPackage;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractTextualQuery;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AdditionKind;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Layout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ShapeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.Style;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplatepatternsPackageImpl extends EPackageImpl implements TemplatepatternsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templatePatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templatePatternDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templatePatternRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRoleSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRoleConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRoleDerivationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idBasedDerivationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qNameBasedDerivationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTextualQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textualRoleDerivationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textualRoleConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateCounterpartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instancePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeBendpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shapeLayoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateFontStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass styleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceCounterpartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceIdEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateIdEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum additionKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TemplatepatternsPackageImpl() {
		super(eNS_URI, TemplatepatternsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TemplatepatternsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TemplatepatternsPackage init() {
		if (isInited) return (TemplatepatternsPackage)EPackage.Registry.INSTANCE.getEPackage(TemplatepatternsPackage.eNS_URI);

		// Obtain or create and register package
		TemplatepatternsPackageImpl theTemplatepatternsPackage = (TemplatepatternsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TemplatepatternsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TemplatepatternsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorepatternsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTemplatepatternsPackage.createPackageContents();

		// Initialize created meta-data
		theTemplatepatternsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTemplatepatternsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TemplatepatternsPackage.eNS_URI, theTemplatepatternsPackage);
		return theTemplatepatternsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplatePattern() {
		return templatePatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePattern_Image() {
		return (EReference)templatePatternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePattern_LayoutData() {
		return (EReference)templatePatternEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePattern_Roles() {
		return (EReference)templatePatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePattern_TemplateElements() {
		return (EReference)templatePatternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePattern_MultiElements() {
		return (EReference)templatePatternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplatePatternData() {
		return templatePatternDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternData_InstanceIds() {
		return (EReference)templatePatternDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplatePatternData_NamingRule() {
		return (EAttribute)templatePatternDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplatePatternData_Multiplicity() {
		return (EAttribute)templatePatternDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternData_TemplateIds() {
		return (EReference)templatePatternDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplatePatternData_UnfoldedIds() {
		return (EAttribute)templatePatternDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplatePatternRole() {
		return templatePatternRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplatePatternRole_AdditionKind() {
		return (EAttribute)templatePatternRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternRole_Pattern() {
		return (EReference)templatePatternRoleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternRole_AdditionDerivationRule() {
		return (EReference)templatePatternRoleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternRole_MergeDerivationRule() {
		return (EReference)templatePatternRoleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternRole_PreferredContainment() {
		return (EReference)templatePatternRoleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternRole_TemplateElements() {
		return (EReference)templatePatternRoleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRoleSpecification() {
		return abstractRoleSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplatePatternRole_Exclusive() {
		return (EAttribute)templatePatternRoleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePatternRole_Constraints() {
		return (EReference)templatePatternRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRoleConstraint() {
		return abstractRoleConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractRoleConstraint_Role() {
		return (EReference)abstractRoleConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRoleDerivationRule() {
		return abstractRoleDerivationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdBasedDerivationRule() {
		return idBasedDerivationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdBasedDerivationRule_ElementId() {
		return (EAttribute)idBasedDerivationRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQNameBasedDerivationRule() {
		return qNameBasedDerivationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQNameBasedDerivationRule_Names() {
		return (EAttribute)qNameBasedDerivationRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTextualQuery() {
		return abstractTextualQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTextualQuery_Specification() {
		return (EAttribute)abstractTextualQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTextualQuery_Language() {
		return (EAttribute)abstractTextualQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextualRoleDerivationRule() {
		return textualRoleDerivationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextualRoleConstraint() {
		return textualRoleConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateCounterpart() {
		return templateCounterpartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateCounterpart_InstanceParts() {
		return (EReference)templateCounterpartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstancePart() {
		return instancePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstancePart_Key() {
		return (EAttribute)instancePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstancePart_Value() {
		return (EAttribute)instancePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageSpecification() {
		return imageSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageSpecification_Contents() {
		return (EAttribute)imageSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayoutEntry() {
		return layoutEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutEntry_Key() {
		return (EReference)layoutEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutEntry_Value() {
		return (EReference)layoutEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayout() {
		return layoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeLayout() {
		return nodeLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeLayout_X() {
		return (EAttribute)nodeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeLayout_Y() {
		return (EAttribute)nodeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeLayout_Height() {
		return (EAttribute)nodeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeLayout_Width() {
		return (EAttribute)nodeLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeLayout_ContainedFontStyles() {
		return (EReference)nodeLayoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeLayout_OwnedStyle() {
		return (EReference)nodeLayoutEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeLayout() {
		return edgeLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeLayout_Bendpoints() {
		return (EReference)edgeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeLayout_Linewidth() {
		return (EAttribute)edgeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeLayout_Linecolor() {
		return (EAttribute)edgeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeLayout_OwnedStyle() {
		return (EReference)edgeLayoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeLayout_BeginFontStyle() {
		return (EReference)edgeLayoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeLayout_EndFontStyle() {
		return (EReference)edgeLayoutEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeLayout_CenterFontStyle() {
		return (EReference)edgeLayoutEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeBendpoint() {
		return edgeBendpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeBendpoint_SourceX() {
		return (EAttribute)edgeBendpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeBendpoint_SourceY() {
		return (EAttribute)edgeBendpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeBendpoint_TargetX() {
		return (EAttribute)edgeBendpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeBendpoint_TargetY() {
		return (EAttribute)edgeBendpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShapeLayout() {
		return shapeLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShapeLayout_FontStyle() {
		return (EReference)shapeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateFontStyle() {
		return templateFontStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateFontStyle_Color() {
		return (EAttribute)templateFontStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateFontStyle_Name() {
		return (EAttribute)templateFontStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateFontStyle_Height() {
		return (EAttribute)templateFontStyleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateFontStyle_Bold() {
		return (EAttribute)templateFontStyleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateFontStyle_Italic() {
		return (EAttribute)templateFontStyleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateFontStyle_Underline() {
		return (EAttribute)templateFontStyleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateFontStyle_Strikethrough() {
		return (EAttribute)templateFontStyleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStyle() {
		return styleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeStyle() {
		return nodeStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeStyle_Bordercolor() {
		return (EAttribute)nodeStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeStyle_Bordersize() {
		return (EAttribute)nodeStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeStyle_Shapecolor() {
		return (EAttribute)nodeStyleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeStyle_Transparency() {
		return (EAttribute)nodeStyleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeStyle_Backgroundcolor() {
		return (EAttribute)nodeStyleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeStyle_Foregroundcolor() {
		return (EAttribute)nodeStyleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeStyle() {
		return edgeStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeStyle_Linestyle() {
		return (EAttribute)edgeStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeStyle_Routingstyle() {
		return (EAttribute)edgeStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeStyle_Targetarrow() {
		return (EAttribute)edgeStyleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEdgeStyle_Sourcearrow() {
		return (EAttribute)edgeStyleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceCounterpart() {
		return instanceCounterpartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceCounterpart_TemplateId() {
		return (EAttribute)instanceCounterpartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceCounterpart_Multipart() {
		return (EAttribute)instanceCounterpartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceIdEntry() {
		return instanceIdEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceIdEntry_Key() {
		return (EAttribute)instanceIdEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceIdEntry_Value() {
		return (EReference)instanceIdEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateIdEntry() {
		return templateIdEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateIdEntry_Key() {
		return (EAttribute)templateIdEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateIdEntry_Value() {
		return (EReference)templateIdEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAdditionKind() {
		return additionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatepatternsFactory getTemplatepatternsFactory() {
		return (TemplatepatternsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		templatePatternEClass = createEClass(TEMPLATE_PATTERN);
		createEReference(templatePatternEClass, TEMPLATE_PATTERN__ROLES);
		createEReference(templatePatternEClass, TEMPLATE_PATTERN__TEMPLATE_ELEMENTS);
		createEReference(templatePatternEClass, TEMPLATE_PATTERN__MULTI_ELEMENTS);
		createEReference(templatePatternEClass, TEMPLATE_PATTERN__IMAGE);
		createEReference(templatePatternEClass, TEMPLATE_PATTERN__LAYOUT_DATA);

		templatePatternDataEClass = createEClass(TEMPLATE_PATTERN_DATA);
		createEAttribute(templatePatternDataEClass, TEMPLATE_PATTERN_DATA__NAMING_RULE);
		createEAttribute(templatePatternDataEClass, TEMPLATE_PATTERN_DATA__MULTIPLICITY);
		createEReference(templatePatternDataEClass, TEMPLATE_PATTERN_DATA__INSTANCE_IDS);
		createEReference(templatePatternDataEClass, TEMPLATE_PATTERN_DATA__TEMPLATE_IDS);
		createEAttribute(templatePatternDataEClass, TEMPLATE_PATTERN_DATA__UNFOLDED_IDS);

		templatePatternRoleEClass = createEClass(TEMPLATE_PATTERN_ROLE);
		createEAttribute(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__ADDITION_KIND);
		createEReference(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__CONSTRAINTS);
		createEAttribute(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__EXCLUSIVE);
		createEReference(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__PATTERN);
		createEReference(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE);
		createEReference(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE);
		createEReference(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT);
		createEReference(templatePatternRoleEClass, TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS);

		abstractRoleSpecificationEClass = createEClass(ABSTRACT_ROLE_SPECIFICATION);

		abstractRoleConstraintEClass = createEClass(ABSTRACT_ROLE_CONSTRAINT);
		createEReference(abstractRoleConstraintEClass, ABSTRACT_ROLE_CONSTRAINT__ROLE);

		abstractRoleDerivationRuleEClass = createEClass(ABSTRACT_ROLE_DERIVATION_RULE);

		idBasedDerivationRuleEClass = createEClass(ID_BASED_DERIVATION_RULE);
		createEAttribute(idBasedDerivationRuleEClass, ID_BASED_DERIVATION_RULE__ELEMENT_ID);

		qNameBasedDerivationRuleEClass = createEClass(QNAME_BASED_DERIVATION_RULE);
		createEAttribute(qNameBasedDerivationRuleEClass, QNAME_BASED_DERIVATION_RULE__NAMES);

		abstractTextualQueryEClass = createEClass(ABSTRACT_TEXTUAL_QUERY);
		createEAttribute(abstractTextualQueryEClass, ABSTRACT_TEXTUAL_QUERY__SPECIFICATION);
		createEAttribute(abstractTextualQueryEClass, ABSTRACT_TEXTUAL_QUERY__LANGUAGE);

		textualRoleDerivationRuleEClass = createEClass(TEXTUAL_ROLE_DERIVATION_RULE);

		textualRoleConstraintEClass = createEClass(TEXTUAL_ROLE_CONSTRAINT);

		instanceCounterpartEClass = createEClass(INSTANCE_COUNTERPART);
		createEAttribute(instanceCounterpartEClass, INSTANCE_COUNTERPART__TEMPLATE_ID);
		createEAttribute(instanceCounterpartEClass, INSTANCE_COUNTERPART__MULTIPART);

		instanceIdEntryEClass = createEClass(INSTANCE_ID_ENTRY);
		createEAttribute(instanceIdEntryEClass, INSTANCE_ID_ENTRY__KEY);
		createEReference(instanceIdEntryEClass, INSTANCE_ID_ENTRY__VALUE);

		templateIdEntryEClass = createEClass(TEMPLATE_ID_ENTRY);
		createEAttribute(templateIdEntryEClass, TEMPLATE_ID_ENTRY__KEY);
		createEReference(templateIdEntryEClass, TEMPLATE_ID_ENTRY__VALUE);

		templateCounterpartEClass = createEClass(TEMPLATE_COUNTERPART);
		createEReference(templateCounterpartEClass, TEMPLATE_COUNTERPART__INSTANCE_PARTS);

		instancePartEClass = createEClass(INSTANCE_PART);
		createEAttribute(instancePartEClass, INSTANCE_PART__KEY);
		createEAttribute(instancePartEClass, INSTANCE_PART__VALUE);

		imageSpecificationEClass = createEClass(IMAGE_SPECIFICATION);
		createEAttribute(imageSpecificationEClass, IMAGE_SPECIFICATION__CONTENTS);

		layoutEntryEClass = createEClass(LAYOUT_ENTRY);
		createEReference(layoutEntryEClass, LAYOUT_ENTRY__KEY);
		createEReference(layoutEntryEClass, LAYOUT_ENTRY__VALUE);

		layoutEClass = createEClass(LAYOUT);

		nodeLayoutEClass = createEClass(NODE_LAYOUT);
		createEAttribute(nodeLayoutEClass, NODE_LAYOUT__X);
		createEAttribute(nodeLayoutEClass, NODE_LAYOUT__Y);
		createEAttribute(nodeLayoutEClass, NODE_LAYOUT__HEIGHT);
		createEAttribute(nodeLayoutEClass, NODE_LAYOUT__WIDTH);
		createEReference(nodeLayoutEClass, NODE_LAYOUT__CONTAINED_FONT_STYLES);
		createEReference(nodeLayoutEClass, NODE_LAYOUT__OWNED_STYLE);

		edgeLayoutEClass = createEClass(EDGE_LAYOUT);
		createEReference(edgeLayoutEClass, EDGE_LAYOUT__BENDPOINTS);
		createEAttribute(edgeLayoutEClass, EDGE_LAYOUT__LINEWIDTH);
		createEAttribute(edgeLayoutEClass, EDGE_LAYOUT__LINECOLOR);
		createEReference(edgeLayoutEClass, EDGE_LAYOUT__OWNED_STYLE);
		createEReference(edgeLayoutEClass, EDGE_LAYOUT__BEGIN_FONT_STYLE);
		createEReference(edgeLayoutEClass, EDGE_LAYOUT__END_FONT_STYLE);
		createEReference(edgeLayoutEClass, EDGE_LAYOUT__CENTER_FONT_STYLE);

		edgeBendpointEClass = createEClass(EDGE_BENDPOINT);
		createEAttribute(edgeBendpointEClass, EDGE_BENDPOINT__SOURCE_X);
		createEAttribute(edgeBendpointEClass, EDGE_BENDPOINT__SOURCE_Y);
		createEAttribute(edgeBendpointEClass, EDGE_BENDPOINT__TARGET_X);
		createEAttribute(edgeBendpointEClass, EDGE_BENDPOINT__TARGET_Y);

		shapeLayoutEClass = createEClass(SHAPE_LAYOUT);
		createEReference(shapeLayoutEClass, SHAPE_LAYOUT__FONT_STYLE);

		templateFontStyleEClass = createEClass(TEMPLATE_FONT_STYLE);
		createEAttribute(templateFontStyleEClass, TEMPLATE_FONT_STYLE__COLOR);
		createEAttribute(templateFontStyleEClass, TEMPLATE_FONT_STYLE__NAME);
		createEAttribute(templateFontStyleEClass, TEMPLATE_FONT_STYLE__HEIGHT);
		createEAttribute(templateFontStyleEClass, TEMPLATE_FONT_STYLE__BOLD);
		createEAttribute(templateFontStyleEClass, TEMPLATE_FONT_STYLE__ITALIC);
		createEAttribute(templateFontStyleEClass, TEMPLATE_FONT_STYLE__UNDERLINE);
		createEAttribute(templateFontStyleEClass, TEMPLATE_FONT_STYLE__STRIKETHROUGH);

		styleEClass = createEClass(STYLE);

		nodeStyleEClass = createEClass(NODE_STYLE);
		createEAttribute(nodeStyleEClass, NODE_STYLE__BORDERCOLOR);
		createEAttribute(nodeStyleEClass, NODE_STYLE__BORDERSIZE);
		createEAttribute(nodeStyleEClass, NODE_STYLE__SHAPECOLOR);
		createEAttribute(nodeStyleEClass, NODE_STYLE__TRANSPARENCY);
		createEAttribute(nodeStyleEClass, NODE_STYLE__BACKGROUNDCOLOR);
		createEAttribute(nodeStyleEClass, NODE_STYLE__FOREGROUNDCOLOR);

		edgeStyleEClass = createEClass(EDGE_STYLE);
		createEAttribute(edgeStyleEClass, EDGE_STYLE__LINESTYLE);
		createEAttribute(edgeStyleEClass, EDGE_STYLE__ROUTINGSTYLE);
		createEAttribute(edgeStyleEClass, EDGE_STYLE__TARGETARROW);
		createEAttribute(edgeStyleEClass, EDGE_STYLE__SOURCEARROW);

		// Create enums
		additionKindEEnum = createEEnum(ADDITION_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorepatternsPackage theCorepatternsPackage = (CorepatternsPackage)EPackage.Registry.INSTANCE.getEPackage(CorepatternsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		PredefinedPackage thePredefinedPackage = (PredefinedPackage)EPackage.Registry.INSTANCE.getEPackage(PredefinedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		templatePatternEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractPattern());
		templatePatternDataEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractPatternData());
		templatePatternDataEClass.getESuperTypes().add(thePredefinedPackage.getIPatternBasedFunction());
		templatePatternRoleEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractPatternRole());
		abstractRoleSpecificationEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		abstractRoleConstraintEClass.getESuperTypes().add(this.getAbstractRoleSpecification());
		abstractRoleDerivationRuleEClass.getESuperTypes().add(this.getAbstractRoleSpecification());
		idBasedDerivationRuleEClass.getESuperTypes().add(this.getAbstractRoleDerivationRule());
		qNameBasedDerivationRuleEClass.getESuperTypes().add(this.getAbstractRoleDerivationRule());
		textualRoleDerivationRuleEClass.getESuperTypes().add(this.getAbstractTextualQuery());
		textualRoleDerivationRuleEClass.getESuperTypes().add(this.getAbstractRoleDerivationRule());
		textualRoleConstraintEClass.getESuperTypes().add(this.getAbstractTextualQuery());
		textualRoleConstraintEClass.getESuperTypes().add(this.getAbstractRoleConstraint());
		instanceCounterpartEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		instanceIdEntryEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		templateIdEntryEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		templateCounterpartEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		instancePartEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		imageSpecificationEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		layoutEntryEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		layoutEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		nodeLayoutEClass.getESuperTypes().add(this.getShapeLayout());
		edgeLayoutEClass.getESuperTypes().add(this.getLayout());
		edgeLayoutEClass.getESuperTypes().add(this.getShapeLayout());
		edgeBendpointEClass.getESuperTypes().add(theCorepatternsPackage.getAbstractIdentifiedElement());
		shapeLayoutEClass.getESuperTypes().add(this.getLayout());
		nodeStyleEClass.getESuperTypes().add(this.getStyle());
		edgeStyleEClass.getESuperTypes().add(this.getStyle());

		// Initialize classes and features; add operations and parameters
		initEClass(templatePatternEClass, TemplatePattern.class, "TemplatePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplatePattern_Roles(), this.getTemplatePatternRole(), this.getTemplatePatternRole_Pattern(), "roles", null, 1, -1, TemplatePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePattern_TemplateElements(), theEcorePackage.getEObject(), null, "templateElements", null, 0, -1, TemplatePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePattern_MultiElements(), theEcorePackage.getEObject(), null, "multiElements", null, 0, -1, TemplatePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePattern_Image(), this.getImageSpecification(), null, "image", null, 0, 1, TemplatePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePattern_LayoutData(), this.getLayoutEntry(), null, "layoutData", null, 0, -1, TemplatePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(templatePatternEClass, theEcorePackage.getEBoolean(), "isUnique", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(templatePatternDataEClass, TemplatePatternData.class, "TemplatePatternData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTemplatePatternData_NamingRule(), theEcorePackage.getEString(), "namingRule", null, 0, 1, TemplatePatternData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplatePatternData_Multiplicity(), theEcorePackage.getEInt(), "multiplicity", null, 1, 1, TemplatePatternData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePatternData_InstanceIds(), this.getInstanceIdEntry(), null, "instanceIds", null, 0, -1, TemplatePatternData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePatternData_TemplateIds(), this.getTemplateIdEntry(), null, "templateIds", null, 0, -1, TemplatePatternData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplatePatternData_UnfoldedIds(), theEcorePackage.getEString(), "unfoldedIds", null, 0, -1, TemplatePatternData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternDataEClass, null, "clear", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternDataEClass, null, "clearUnfolded", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternDataEClass, theEcorePackage.getEObject(), "getInstanceElements", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternDataEClass, theEcorePackage.getEString(), "getMultiparts", 1, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, theEcorePackage.getEString(), "getMultipartOf", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, this.getTemplatePatternRole(), "getRolesOf", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "instanceElement_p", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, theEcorePackage.getEBoolean(), "isInMultipart", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "multipart", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, theEcorePackage.getEBoolean(), "isInOtherMultipart", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "element", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "multipart", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, null, "map", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "instanceElement", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "templateElement", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "multipart", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, null, "markAsUnfolded", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "instanceElement", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, null, "rename", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "newNamingRule", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEBoolean(), "keepUserNames", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternDataEClass, theEcorePackage.getEBoolean(), "wasUnfolded", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEObject(), "instanceElement", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(templatePatternRoleEClass, TemplatePatternRole.class, "TemplatePatternRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTemplatePatternRole_AdditionKind(), this.getAdditionKind(), "additionKind", null, 1, 1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePatternRole_Constraints(), this.getAbstractRoleConstraint(), this.getAbstractRoleConstraint_Role(), "constraints", null, 0, -1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplatePatternRole_Exclusive(), theEcorePackage.getEBoolean(), "exclusive", "", 1, 1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getTemplatePatternRole_Pattern(), this.getTemplatePattern(), this.getTemplatePattern_Roles(), "pattern", null, 1, 1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePatternRole_AdditionDerivationRule(), this.getAbstractRoleDerivationRule(), null, "additionDerivationRule", null, 0, 1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePatternRole_MergeDerivationRule(), this.getAbstractRoleDerivationRule(), null, "mergeDerivationRule", null, 0, 1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePatternRole_PreferredContainment(), theEcorePackage.getEReference(), null, "preferredContainment", null, 0, 1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplatePatternRole_TemplateElements(), theEcorePackage.getEObject(), null, "templateElements", null, 0, -1, TemplatePatternRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternRoleEClass, theEcorePackage.getEBoolean(), "acceptsAddition", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternRoleEClass, theEcorePackage.getEBoolean(), "acceptsMerge", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternRoleEClass, thePredefinedPackage.getIPatternConformityStatus(), "checkConstraints", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePredefinedPackage.getILocation(), "location", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(templatePatternRoleEClass, theEcorePackage.getEBoolean(), "isDerivable", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEBoolean(), "forMerge", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternRoleEClass, theEcorePackage.getEBoolean(), "isMany", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(templatePatternRoleEClass, theEcorePackage.getEBoolean(), "isUniLocation", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractRoleSpecificationEClass, AbstractRoleSpecification.class, "AbstractRoleSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(abstractRoleSpecificationEClass, this.getTemplatePatternRole(), "getRole", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractRoleConstraintEClass, AbstractRoleConstraint.class, "AbstractRoleConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAbstractRoleConstraint_Role(), this.getTemplatePatternRole(), this.getTemplatePatternRole_Constraints(), "role", null, 0, 1, AbstractRoleConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(abstractRoleConstraintEClass, thePredefinedPackage.getIPatternConformityStatus(), "check", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePredefinedPackage.getILocation(), "location", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractRoleDerivationRuleEClass, AbstractRoleDerivationRule.class, "AbstractRoleDerivationRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(abstractRoleDerivationRuleEClass, theEcorePackage.getEObject(), "deriveCandidateElements", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, thePredefinedPackage.getIPatternApplication(), "context", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(idBasedDerivationRuleEClass, IdBasedDerivationRule.class, "IdBasedDerivationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIdBasedDerivationRule_ElementId(), theEcorePackage.getEString(), "elementId", null, 1, 1, IdBasedDerivationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(qNameBasedDerivationRuleEClass, QNameBasedDerivationRule.class, "QNameBasedDerivationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getQNameBasedDerivationRule_Names(), theEcorePackage.getEString(), "names", null, 1, -1, QNameBasedDerivationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(abstractTextualQueryEClass, AbstractTextualQuery.class, "AbstractTextualQuery", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractTextualQuery_Specification(), theEcorePackage.getEString(), "specification", null, 1, 1, AbstractTextualQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractTextualQuery_Language(), theEcorePackage.getEString(), "language", null, 1, 1, AbstractTextualQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(textualRoleDerivationRuleEClass, TextualRoleDerivationRule.class, "TextualRoleDerivationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(textualRoleConstraintEClass, TextualRoleConstraint.class, "TextualRoleConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(instanceCounterpartEClass, InstanceCounterpart.class, "InstanceCounterpart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getInstanceCounterpart_TemplateId(), theEcorePackage.getEString(), "templateId", null, 1, 1, InstanceCounterpart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstanceCounterpart_Multipart(), theEcorePackage.getEString(), "multipart", null, 1, 1, InstanceCounterpart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(instanceIdEntryEClass, Map.Entry.class, "InstanceIdEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getInstanceIdEntry_Key(), theEcorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstanceIdEntry_Value(), this.getInstanceCounterpart(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateIdEntryEClass, Map.Entry.class, "TemplateIdEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTemplateIdEntry_Key(), theEcorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplateIdEntry_Value(), this.getTemplateCounterpart(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateCounterpartEClass, TemplateCounterpart.class, "TemplateCounterpart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateCounterpart_InstanceParts(), this.getInstancePart(), null, "instanceParts", null, 0, -1, TemplateCounterpart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(instancePartEClass, Map.Entry.class, "InstancePart", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getInstancePart_Key(), theEcorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstancePart_Value(), theEcorePackage.getEString(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(imageSpecificationEClass, ImageSpecification.class, "ImageSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getImageSpecification_Contents(), theEcorePackage.getEString(), "contents", null, 1, 1, ImageSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(layoutEntryEClass, Map.Entry.class, "LayoutEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLayoutEntry_Key(), theEcorePackage.getEObject(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLayoutEntry_Value(), this.getLayout(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(layoutEClass, Layout.class, "Layout", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nodeLayoutEClass, NodeLayout.class, "NodeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNodeLayout_X(), theEcorePackage.getEInt(), "x", null, 1, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeLayout_Y(), theEcorePackage.getEInt(), "y", null, 1, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeLayout_Height(), theEcorePackage.getEInt(), "height", null, 1, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeLayout_Width(), theEcorePackage.getEInt(), "width", null, 1, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNodeLayout_ContainedFontStyles(), this.getTemplateFontStyle(), null, "containedFontStyles", null, 0, -1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNodeLayout_OwnedStyle(), this.getNodeStyle(), null, "ownedStyle", null, 0, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(edgeLayoutEClass, EdgeLayout.class, "EdgeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEdgeLayout_Bendpoints(), this.getEdgeBendpoint(), null, "bendpoints", null, 0, -1, EdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeLayout_Linewidth(), theEcorePackage.getEInt(), "linewidth", null, 0, 1, EdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeLayout_Linecolor(), theEcorePackage.getEInt(), "linecolor", null, 0, 1, EdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEdgeLayout_OwnedStyle(), this.getEdgeStyle(), null, "ownedStyle", null, 0, 1, EdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEdgeLayout_BeginFontStyle(), this.getTemplateFontStyle(), null, "beginFontStyle", null, 0, 1, EdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEdgeLayout_EndFontStyle(), this.getTemplateFontStyle(), null, "endFontStyle", null, 0, 1, EdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getEdgeLayout_CenterFontStyle(), this.getTemplateFontStyle(), null, "centerFontStyle", null, 0, 1, EdgeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(edgeBendpointEClass, EdgeBendpoint.class, "EdgeBendpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEdgeBendpoint_SourceX(), theEcorePackage.getEInt(), "sourceX", null, 1, 1, EdgeBendpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeBendpoint_SourceY(), theEcorePackage.getEInt(), "sourceY", null, 1, 1, EdgeBendpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeBendpoint_TargetX(), theEcorePackage.getEInt(), "targetX", null, 1, 1, EdgeBendpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeBendpoint_TargetY(), theEcorePackage.getEInt(), "targetY", null, 1, 1, EdgeBendpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shapeLayoutEClass, ShapeLayout.class, "ShapeLayout", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getShapeLayout_FontStyle(), this.getTemplateFontStyle(), null, "fontStyle", null, 0, 1, ShapeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateFontStyleEClass, TemplateFontStyle.class, "TemplateFontStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTemplateFontStyle_Color(), theEcorePackage.getEInt(), "color", null, 0, 1, TemplateFontStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplateFontStyle_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TemplateFontStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplateFontStyle_Height(), theEcorePackage.getEInt(), "height", null, 0, 1, TemplateFontStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplateFontStyle_Bold(), theEcorePackage.getEBoolean(), "bold", null, 0, 1, TemplateFontStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplateFontStyle_Italic(), theEcorePackage.getEBoolean(), "italic", null, 0, 1, TemplateFontStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplateFontStyle_Underline(), theEcorePackage.getEBoolean(), "underline", null, 0, 1, TemplateFontStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTemplateFontStyle_Strikethrough(), theEcorePackage.getEBoolean(), "strikethrough", null, 0, 1, TemplateFontStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(styleEClass, Style.class, "Style", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nodeStyleEClass, NodeStyle.class, "NodeStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNodeStyle_Bordercolor(), theEcorePackage.getEInt(), "bordercolor", null, 0, 1, NodeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeStyle_Bordersize(), theEcorePackage.getEInt(), "bordersize", null, 0, 1, NodeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeStyle_Shapecolor(), theEcorePackage.getEInt(), "shapecolor", null, 0, 1, NodeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeStyle_Transparency(), theEcorePackage.getEInt(), "transparency", null, 0, 1, NodeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeStyle_Backgroundcolor(), theEcorePackage.getEInt(), "backgroundcolor", null, 0, 1, NodeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNodeStyle_Foregroundcolor(), theEcorePackage.getEInt(), "foregroundcolor", null, 0, 1, NodeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(edgeStyleEClass, EdgeStyle.class, "EdgeStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEdgeStyle_Linestyle(), theEcorePackage.getEString(), "linestyle", null, 0, 1, EdgeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeStyle_Routingstyle(), theEcorePackage.getEString(), "routingstyle", null, 0, 1, EdgeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeStyle_Targetarrow(), theEcorePackage.getEString(), "targetarrow", null, 0, 1, EdgeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEdgeStyle_Sourcearrow(), theEcorePackage.getEString(), "sourcearrow", null, 0, 1, EdgeStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(additionKindEEnum, AdditionKind.class, "AdditionKind"); //$NON-NLS-1$
		addEEnumLiteral(additionKindEEnum, AdditionKind.FORBIDDEN);
		addEEnumLiteral(additionKindEEnum, AdditionKind.PREFERRED_CONTAINMENT);
		addEEnumLiteral(additionKindEEnum, AdditionKind.ANY_CONTAINMENT);
		addEEnumLiteral(additionKindEEnum, AdditionKind.ANY_STORAGE);

		// Create resource
		createResource(eNS_URI);
	}

} //TemplatepatternsPackageImpl
