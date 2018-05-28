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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.provider;


import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.provider.AbstractPatternRoleItemProvider;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplatePatternRoleItemProvider
	extends AbstractPatternRoleItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatePatternRoleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addAdditionKindPropertyDescriptor(object);
			addExclusivePropertyDescriptor(object);
			addPreferredContainmentPropertyDescriptor(object);
			addTemplateElementsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Addition Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdditionKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TemplatePatternRole_additionKind_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TemplatePatternRole_additionKind_feature", "_UI_TemplatePatternRole_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__ADDITION_KIND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Exclusive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExclusivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TemplatePatternRole_exclusive_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TemplatePatternRole_exclusive_feature", "_UI_TemplatePatternRole_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__EXCLUSIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Preferred Containment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPreferredContainmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TemplatePatternRole_preferredContainment_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TemplatePatternRole_preferredContainment_feature", "_UI_TemplatePatternRole_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__PREFERRED_CONTAINMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Template Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplateElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TemplatePatternRole_templateElements_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TemplatePatternRole_templateElements_feature", "_UI_TemplatePatternRole_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__TEMPLATE_ELEMENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__CONSTRAINTS);
			childrenFeatures.add(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE);
			childrenFeatures.add(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns TemplatePatternRole.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TemplatePatternRole")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((TemplatePatternRole)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_TemplatePatternRole_type") : //$NON-NLS-1$
			getString("_UI_TemplatePatternRole_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TemplatePatternRole.class)) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_KIND:
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__EXCLUSIVE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__CONSTRAINTS:
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE:
			case TemplatepatternsPackage.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__CONSTRAINTS,
				 TemplatepatternsFactory.eINSTANCE.createTextualRoleConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE,
				 TemplatepatternsFactory.eINSTANCE.createIdBasedDerivationRule()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE,
				 TemplatepatternsFactory.eINSTANCE.createQNameBasedDerivationRule()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE,
				 TemplatepatternsFactory.eINSTANCE.createTextualRoleDerivationRule()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE,
				 TemplatepatternsFactory.eINSTANCE.createIdBasedDerivationRule()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE,
				 TemplatepatternsFactory.eINSTANCE.createQNameBasedDerivationRule()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE,
				 TemplatepatternsFactory.eINSTANCE.createTextualRoleDerivationRule()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__ADDITION_DERIVATION_RULE ||
			childFeature == TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_ROLE__MERGE_DERIVATION_RULE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TemplatePatternsEditPlugin.INSTANCE;
	}

}
