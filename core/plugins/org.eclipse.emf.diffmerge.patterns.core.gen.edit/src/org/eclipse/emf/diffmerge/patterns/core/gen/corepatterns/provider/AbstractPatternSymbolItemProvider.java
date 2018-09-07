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

import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternSymbol} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractPatternSymbolItemProvider
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
	public AbstractPatternSymbolItemProvider(AdapterFactory adapterFactory) {
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

			addRepositoryIdPropertyDescriptor(object);
			addPatternIdPropertyDescriptor(object);
			addLastPathPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Repository Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPatternSymbol_repositoryId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPatternSymbol_repositoryId_feature", "_UI_AbstractPatternSymbol_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pattern Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPatternIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPatternSymbol_patternId_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPatternSymbol_patternId_feature", "_UI_AbstractPatternSymbol_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_PATTERN_SYMBOL__PATTERN_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractPatternSymbol_lastPath_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractPatternSymbol_lastPath_feature", "_UI_AbstractPatternSymbol_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CorepatternsPackage.Literals.ABSTRACT_PATTERN_SYMBOL__LAST_PATH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
		String label = ((AbstractPatternSymbol)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractPatternSymbol_type") : //$NON-NLS-1$
			getString("_UI_AbstractPatternSymbol_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

		switch (notification.getFeatureID(AbstractPatternSymbol.class)) {
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__REPOSITORY_ID:
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__PATTERN_ID:
			case CorepatternsPackage.ABSTRACT_PATTERN_SYMBOL__LAST_PATH:
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
