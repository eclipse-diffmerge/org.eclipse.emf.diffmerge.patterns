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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.provider;


import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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
 * This is the item provider adapter for a {@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractPatternItemProvider
	extends AbstractNamedElementItemProvider
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
	public AbstractPatternItemProvider(AdapterFactory adapterFactory) {
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

			addDescriptionPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addAuthorsPropertyDescriptor(object);
			addLastModificationStampPropertyDescriptor(object);
			addExecutionEnvironmentsPropertyDescriptor(object);
			addTemplatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractDescribedElement_description_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractDescribedElement_description_feature", "_UI_AbstractDescribedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_DESCRIBED_ELEMENT__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractVersionedElement_version_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractVersionedElement_version_feature", "_UI_AbstractVersionedElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_VERSIONED_ELEMENT__VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Authors feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAuthorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPattern_authors_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPattern_authors_feature", "_UI_AbstractPattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_PATTERN__AUTHORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Modification Stamp feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastModificationStampPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPattern_lastModificationStamp_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPattern_lastModificationStamp_feature", "_UI_AbstractPattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Execution Environments feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExecutionEnvironmentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPattern_executionEnvironments_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPattern_executionEnvironments_feature", "_UI_AbstractPattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPattern_template_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPattern_template_feature", "_UI_AbstractPattern_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_PATTERN__TEMPLATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AbstractPattern)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractPattern_type") : //$NON-NLS-1$
			getString("_UI_AbstractPattern_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(AbstractPattern.class)) {
			case CorepatternsPackage.ABSTRACT_PATTERN__DESCRIPTION:
			case CorepatternsPackage.ABSTRACT_PATTERN__VERSION:
			case CorepatternsPackage.ABSTRACT_PATTERN__AUTHORS:
			case CorepatternsPackage.ABSTRACT_PATTERN__LAST_MODIFICATION_STAMP:
			case CorepatternsPackage.ABSTRACT_PATTERN__EXECUTION_ENVIRONMENTS:
			case CorepatternsPackage.ABSTRACT_PATTERN__TEMPLATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
