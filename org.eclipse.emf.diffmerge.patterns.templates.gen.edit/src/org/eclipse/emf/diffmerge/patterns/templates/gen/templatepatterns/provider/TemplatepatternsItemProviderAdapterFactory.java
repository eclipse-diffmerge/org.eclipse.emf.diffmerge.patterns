/**
 * <copyright>
 * 
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
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

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.util.TemplatepatternsAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TemplatepatternsItemProviderAdapterFactory extends TemplatepatternsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplatepatternsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePatternItemProvider templatePatternItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTemplatePatternAdapter() {
		if (templatePatternItemProvider == null) {
			templatePatternItemProvider = new TemplatePatternItemProvider(this);
		}

		return templatePatternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePatternDataItemProvider templatePatternDataItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTemplatePatternDataAdapter() {
		if (templatePatternDataItemProvider == null) {
			templatePatternDataItemProvider = new TemplatePatternDataItemProvider(this);
		}

		return templatePatternDataItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePatternRoleItemProvider templatePatternRoleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTemplatePatternRoleAdapter() {
		if (templatePatternRoleItemProvider == null) {
			templatePatternRoleItemProvider = new TemplatePatternRoleItemProvider(this);
		}

		return templatePatternRoleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdBasedDerivationRuleItemProvider idBasedDerivationRuleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.IdBasedDerivationRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIdBasedDerivationRuleAdapter() {
		if (idBasedDerivationRuleItemProvider == null) {
			idBasedDerivationRuleItemProvider = new IdBasedDerivationRuleItemProvider(this);
		}

		return idBasedDerivationRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QNameBasedDerivationRuleItemProvider qNameBasedDerivationRuleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.QNameBasedDerivationRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createQNameBasedDerivationRuleAdapter() {
		if (qNameBasedDerivationRuleItemProvider == null) {
			qNameBasedDerivationRuleItemProvider = new QNameBasedDerivationRuleItemProvider(this);
		}

		return qNameBasedDerivationRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextualRoleDerivationRuleItemProvider textualRoleDerivationRuleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTextualRoleDerivationRuleAdapter() {
		if (textualRoleDerivationRuleItemProvider == null) {
			textualRoleDerivationRuleItemProvider = new TextualRoleDerivationRuleItemProvider(this);
		}

		return textualRoleDerivationRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextualRoleConstraintItemProvider textualRoleConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTextualRoleConstraintAdapter() {
		if (textualRoleConstraintItemProvider == null) {
			textualRoleConstraintItemProvider = new TextualRoleConstraintItemProvider(this);
		}

		return textualRoleConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceCounterpartItemProvider instanceCounterpartItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceCounterpartAdapter() {
		if (instanceCounterpartItemProvider == null) {
			instanceCounterpartItemProvider = new InstanceCounterpartItemProvider(this);
		}

		return instanceCounterpartItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceIdEntryItemProvider instanceIdEntryItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceIdEntryAdapter() {
		if (instanceIdEntryItemProvider == null) {
			instanceIdEntryItemProvider = new InstanceIdEntryItemProvider(this);
		}

		return instanceIdEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateIdEntryItemProvider templateIdEntryItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTemplateIdEntryAdapter() {
		if (templateIdEntryItemProvider == null) {
			templateIdEntryItemProvider = new TemplateIdEntryItemProvider(this);
		}

		return templateIdEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateCounterpartItemProvider templateCounterpartItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTemplateCounterpartAdapter() {
		if (templateCounterpartItemProvider == null) {
			templateCounterpartItemProvider = new TemplateCounterpartItemProvider(this);
		}

		return templateCounterpartItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePartItemProvider instancePartItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstancePartAdapter() {
		if (instancePartItemProvider == null) {
			instancePartItemProvider = new InstancePartItemProvider(this);
		}

		return instancePartItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageSpecificationItemProvider imageSpecificationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImageSpecificationAdapter() {
		if (imageSpecificationItemProvider == null) {
			imageSpecificationItemProvider = new ImageSpecificationItemProvider(this);
		}

		return imageSpecificationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayoutEntryItemProvider layoutEntryItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLayoutEntryAdapter() {
		if (layoutEntryItemProvider == null) {
			layoutEntryItemProvider = new LayoutEntryItemProvider(this);
		}

		return layoutEntryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeLayoutItemProvider nodeLayoutItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeLayoutAdapter() {
		if (nodeLayoutItemProvider == null) {
			nodeLayoutItemProvider = new NodeLayoutItemProvider(this);
		}

		return nodeLayoutItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeLayoutItemProvider edgeLayoutItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEdgeLayoutAdapter() {
		if (edgeLayoutItemProvider == null) {
			edgeLayoutItemProvider = new EdgeLayoutItemProvider(this);
		}

		return edgeLayoutItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeBendpointItemProvider edgeBendpointItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeBendpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEdgeBendpointAdapter() {
		if (edgeBendpointItemProvider == null) {
			edgeBendpointItemProvider = new EdgeBendpointItemProvider(this);
		}

		return edgeBendpointItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateFontStyleItemProvider templateFontStyleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateFontStyle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTemplateFontStyleAdapter() {
		if (templateFontStyleItemProvider == null) {
			templateFontStyleItemProvider = new TemplateFontStyleItemProvider(this);
		}

		return templateFontStyleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeStyleItemProvider nodeStyleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.NodeStyle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeStyleAdapter() {
		if (nodeStyleItemProvider == null) {
			nodeStyleItemProvider = new NodeStyleItemProvider(this);
		}

		return nodeStyleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeStyleItemProvider edgeStyleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.EdgeStyle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEdgeStyleAdapter() {
		if (edgeStyleItemProvider == null) {
			edgeStyleItemProvider = new EdgeStyleItemProvider(this);
		}

		return edgeStyleItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (templatePatternItemProvider != null) templatePatternItemProvider.dispose();
		if (templatePatternDataItemProvider != null) templatePatternDataItemProvider.dispose();
		if (templatePatternRoleItemProvider != null) templatePatternRoleItemProvider.dispose();
		if (idBasedDerivationRuleItemProvider != null) idBasedDerivationRuleItemProvider.dispose();
		if (qNameBasedDerivationRuleItemProvider != null) qNameBasedDerivationRuleItemProvider.dispose();
		if (textualRoleDerivationRuleItemProvider != null) textualRoleDerivationRuleItemProvider.dispose();
		if (textualRoleConstraintItemProvider != null) textualRoleConstraintItemProvider.dispose();
		if (instanceCounterpartItemProvider != null) instanceCounterpartItemProvider.dispose();
		if (instanceIdEntryItemProvider != null) instanceIdEntryItemProvider.dispose();
		if (templateIdEntryItemProvider != null) templateIdEntryItemProvider.dispose();
		if (templateCounterpartItemProvider != null) templateCounterpartItemProvider.dispose();
		if (instancePartItemProvider != null) instancePartItemProvider.dispose();
		if (imageSpecificationItemProvider != null) imageSpecificationItemProvider.dispose();
		if (layoutEntryItemProvider != null) layoutEntryItemProvider.dispose();
		if (nodeLayoutItemProvider != null) nodeLayoutItemProvider.dispose();
		if (edgeLayoutItemProvider != null) edgeLayoutItemProvider.dispose();
		if (edgeBendpointItemProvider != null) edgeBendpointItemProvider.dispose();
		if (templateFontStyleItemProvider != null) templateFontStyleItemProvider.dispose();
		if (nodeStyleItemProvider != null) nodeStyleItemProvider.dispose();
		if (edgeStyleItemProvider != null) edgeStyleItemProvider.dispose();
	}

}
