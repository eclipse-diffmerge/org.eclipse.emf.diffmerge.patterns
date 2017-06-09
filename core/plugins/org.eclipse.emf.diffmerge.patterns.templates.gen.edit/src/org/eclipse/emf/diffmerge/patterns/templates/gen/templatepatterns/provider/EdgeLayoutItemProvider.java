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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.provider;


import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

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
 * This is the item provider adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EdgeLayoutItemProvider
	extends LayoutItemProvider
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
	public EdgeLayoutItemProvider(AdapterFactory adapterFactory) {
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

			addLinewidthPropertyDescriptor(object);
			addLinecolorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Linewidth feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinewidthPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EdgeLayout_linewidth_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EdgeLayout_linewidth_feature", "_UI_EdgeLayout_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TemplatepatternsPackage.Literals.EDGE_LAYOUT__LINEWIDTH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Linecolor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinecolorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EdgeLayout_linecolor_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_EdgeLayout_linecolor_feature", "_UI_EdgeLayout_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 TemplatepatternsPackage.Literals.EDGE_LAYOUT__LINECOLOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(TemplatepatternsPackage.Literals.SHAPE_LAYOUT__FONT_STYLE);
			childrenFeatures.add(TemplatepatternsPackage.Literals.EDGE_LAYOUT__BENDPOINTS);
			childrenFeatures.add(TemplatepatternsPackage.Literals.EDGE_LAYOUT__OWNED_STYLE);
			childrenFeatures.add(TemplatepatternsPackage.Literals.EDGE_LAYOUT__BEGIN_FONT_STYLE);
			childrenFeatures.add(TemplatepatternsPackage.Literals.EDGE_LAYOUT__END_FONT_STYLE);
			childrenFeatures.add(TemplatepatternsPackage.Literals.EDGE_LAYOUT__CENTER_FONT_STYLE);
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
	 * This returns EdgeLayout.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EdgeLayout")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((EdgeLayout)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_EdgeLayout_type") : //$NON-NLS-1$
			getString("_UI_EdgeLayout_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(EdgeLayout.class)) {
			case TemplatepatternsPackage.EDGE_LAYOUT__LINEWIDTH:
			case TemplatepatternsPackage.EDGE_LAYOUT__LINECOLOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TemplatepatternsPackage.EDGE_LAYOUT__FONT_STYLE:
			case TemplatepatternsPackage.EDGE_LAYOUT__BENDPOINTS:
			case TemplatepatternsPackage.EDGE_LAYOUT__OWNED_STYLE:
			case TemplatepatternsPackage.EDGE_LAYOUT__BEGIN_FONT_STYLE:
			case TemplatepatternsPackage.EDGE_LAYOUT__END_FONT_STYLE:
			case TemplatepatternsPackage.EDGE_LAYOUT__CENTER_FONT_STYLE:
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
				(TemplatepatternsPackage.Literals.SHAPE_LAYOUT__FONT_STYLE,
				 TemplatepatternsFactory.eINSTANCE.createTemplateFontStyle()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.EDGE_LAYOUT__BENDPOINTS,
				 TemplatepatternsFactory.eINSTANCE.createEdgeBendpoint()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.EDGE_LAYOUT__OWNED_STYLE,
				 TemplatepatternsFactory.eINSTANCE.createEdgeStyle()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.EDGE_LAYOUT__BEGIN_FONT_STYLE,
				 TemplatepatternsFactory.eINSTANCE.createTemplateFontStyle()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.EDGE_LAYOUT__END_FONT_STYLE,
				 TemplatepatternsFactory.eINSTANCE.createTemplateFontStyle()));

		newChildDescriptors.add
			(createChildParameter
				(TemplatepatternsPackage.Literals.EDGE_LAYOUT__CENTER_FONT_STYLE,
				 TemplatepatternsFactory.eINSTANCE.createTemplateFontStyle()));
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
			childFeature == TemplatepatternsPackage.Literals.SHAPE_LAYOUT__FONT_STYLE ||
			childFeature == TemplatepatternsPackage.Literals.EDGE_LAYOUT__BEGIN_FONT_STYLE ||
			childFeature == TemplatepatternsPackage.Literals.EDGE_LAYOUT__END_FONT_STYLE ||
			childFeature == TemplatepatternsPackage.Literals.EDGE_LAYOUT__CENTER_FONT_STYLE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
