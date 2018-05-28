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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IDeleteOperationProvider;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternDataImpl;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine;
import org.eclipse.emf.diffmerge.patterns.templates.gen.TemplatePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.InstanceCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplateCounterpart;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Pattern Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl#getNamingRule <em>Naming Rule</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl#getInstanceIds <em>Instance Ids</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl#getTemplateIds <em>Template Ids</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.impl.TemplatePatternDataImpl#getUnfoldedIds <em>Unfolded Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplatePatternDataImpl extends AbstractPatternDataImpl implements TemplatePatternData {
	/**
	 * The default value of the '{@link #getNamingRule() <em>Naming Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamingRule()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMING_RULE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getNamingRule() <em>Naming Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamingRule()
	 * @generated
	 * @ordered
	 */
	protected String namingRule = NAMING_RULE_EDEFAULT;
	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int MULTIPLICITY_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int multiplicity = MULTIPLICITY_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInstanceIds() <em>Instance Ids</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceIds()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, InstanceCounterpart> instanceIds;
	/**
	 * The cached value of the '{@link #getTemplateIds() <em>Template Ids</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateIds()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, TemplateCounterpart> templateIds;
	/**
	 * The cached value of the '{@link #getUnfoldedIds() <em>Unfolded Ids</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnfoldedIds()
	 * @generated
	 * @ordered
	 */
	protected EList<String> unfoldedIds;
	
	/**
   * A cache for instance elements
	 * @generated NOT
	 */
	private transient Map<String, EObject> _instanceIdsToElements = null;
	
	/**
	 * Whether the cache for instance elements has been initialized
	 * @generated NOT
	 */
	private transient boolean _initialized = false;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplatePatternDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatepatternsPackage.Literals.TEMPLATE_PATTERN_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, InstanceCounterpart> getInstanceIds() {
		if (instanceIds == null) {
			instanceIds = new EcoreEMap<String,InstanceCounterpart>(TemplatepatternsPackage.Literals.INSTANCE_ID_ENTRY, InstanceIdEntryImpl.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__INSTANCE_IDS);
		}
		return instanceIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamingRule() {
		return namingRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamingRule(String newNamingRule) {
		String oldNamingRule = namingRule;
		namingRule = newNamingRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__NAMING_RULE, oldNamingRule, namingRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(int newMultiplicity) {
		int oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, TemplateCounterpart> getTemplateIds() {
		if (templateIds == null) {
			templateIds = new EcoreEMap<String,TemplateCounterpart>(TemplatepatternsPackage.Literals.TEMPLATE_ID_ENTRY, TemplateIdEntryImpl.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__TEMPLATE_IDS);
		}
		return templateIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUnfoldedIds() {
		if (unfoldedIds == null) {
			unfoldedIds = new EDataTypeUniqueEList<String>(String.class, this, TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__UNFOLDED_IDS);
		}
		return unfoldedIds;
	}
	
  /**
   * Ensure that the <instance ID, instance element> map is in sync with the model
   * @return the non-null list of the instance elements
   * @generated NOT
   */
  private EList<EObject> checkInstanceElements() {
    EList<EObject> result = checkInstanceElementsInitialized();
    if (result == null) {
      // Map was already initialized: check it
      result = new ModelsUtil.RList<EObject>();
      Map<String, EObject> clone = new LinkedHashMap<String, EObject>(_instanceIdsToElements); 
      for (Map.Entry<String, EObject> entry : clone.entrySet()) {
        EObject instanceElement = entry.getValue();
        if (isInModel(instanceElement))
          result.add(instanceElement);
        else
          removeInstanceId(entry.getKey());
      }
    }
    return ECollections.unmodifiableEList(result);
  }
  
  /**
   * Ensure that the <instance ID, instance element> map has been initialized
   * @return the non-null list of the instance elements, or null if initialization has already been carried out
   * @generated NOT
   */
  private EList<EObject> checkInstanceElementsInitialized() {
    EList<EObject> result = null;
    boolean needsInitialization = !_initialized ||
      _instanceIdsToElements.size() != getInstanceIds().size();
    if (needsInitialization) {
      // Map has not been initialized
      result = new ModelsUtil.RList<EObject>();
      _instanceIdsToElements = new LinkedHashMap<String, EObject>();
      for (String instanceId : new HashSet<String>(getInstanceIds().keySet())) {
        if(instanceId != null){
          EObject instanceElement = resolveInstanceId(instanceId);
          if (instanceElement != null && isInModel(instanceElement)) {
            _instanceIdsToElements.put(instanceId, instanceElement);
            result.add(instanceElement);
          } else {
            removeInstanceId(instanceId);
          }
        }else{
          removeInstanceId(instanceId);
        }
        
      }
      _initialized = true;
    }
    return result;
  }
  
  /**
	 * Clear the content of the the receiver in terms of covered elements
	 * @generated NOT
	 */
	public void clear() {
    getInstanceIds().clear();
    getTemplateIds().clear();
    getUnfoldedIds().clear();
    if (_initialized)
      _instanceIdsToElements.clear();
	}
	
  /**
   * Reset the given pattern data so that only information about non-unfolded elements
   * be preserved
   * @generated NOT
   */
	public void clearUnfolded() {
    for (String instanceId : new ArrayList<String>(getUnfoldedIds())) {
      removeInstanceId(instanceId);
    }
  }
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection#covers(org.eclipse.emf.ecore.EObject, boolean)
   * @generated NOT
   */
  public boolean covers(EObject element, boolean fromPattern) {
    boolean result = false;
    String elementId = getId(element);
    if (elementId != null) {
      if (fromPattern)
        result = getTemplateIds().keySet().contains(elementId);
      else
        result = getInstanceIds().keySet().contains(elementId);
    }
    return result;
  }
  
  /**
   * Return the counterpart of the given element in the main multipart, if any
   * @param element a non-null element
   * @param fromPattern whether the given element is on the pattern side
   * @return a potentially null element
   * @generated NOT
   */
  public EObject getCounterpart(EObject element, boolean fromPattern) {
    EObject result = null;
    String elementId = getId(element);
    if (elementId != null) {
      if (fromPattern) {
        String instanceId = getInstanceId(elementId, getMainMultipart());
        checkInstanceElementsInitialized();
        EObject instanceElement = _instanceIdsToElements.get(instanceId);
        if (instanceElement != null) {
          if (isInModel(instanceElement))
            result = instanceElement;
          else
            removeInstanceId(instanceId);
        }
      } else {
        String templateId = getTemplateId(elementId);
        result = resolveTemplateId(templateId);
      }
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedFunction#getCounterparts(org.eclipse.emf.ecore.EObject)
   * @generated NOT
   */
  public List<EObject> getCounterparts(EObject templateElement_p) {
    List<EObject> result = new ModelsUtil.ROrderedSet<EObject>();
    String templateId = getId(templateElement_p);
    if (templateId != null) {
      List<String> counterpartInstanceIds = getInstanceIds(templateId);
      checkInstanceElementsInitialized();
      for (String instanceId : counterpartInstanceIds) {
        EObject instanceElement = _instanceIdsToElements.get(instanceId);
        if (instanceElement != null) {
          if (isInModel(instanceElement))
            result.add(instanceElement);
          else
            removeInstanceId(instanceId);
        }
      }
    }
    return result;
  }
  
  /**
   * Return the ID of the given element
   * @param element_p a potentially null element
   * @return a potentially null string
   * @generated NOT
   */
  private String getId(EObject element_p) {
    return CorePatternsPlugin.getDefault().getIdProvider().getId(element_p, null);
  }
  
	/**
	 * Return the set of elements covered
	 * @return a non-null, potentially empty, unmodifiable collection
	 * @generated NOT
	 */
	public EList<EObject> getInstanceElements() {
	  EList<EObject> result = checkInstanceElements();
	  return result;
	}
	
  /**
   * Return the ID of the instance element corresponding to the template element
   * of the given ID for the given multipart ID
   * @param templateId a non-null string
   * @param multipart a potentially null string
   * @return a potentially null string
   * @generated NOT
   */
  private String getInstanceId(String templateId, String multipart) {
    String result = null;
    TemplateCounterpart templateCounterpart = getTemplateIds().get(templateId);
    if (templateCounterpart != null)
      result = templateCounterpart.getInstanceParts().get(multipart);
    return result;
  }
  
  /**
   * Return the IDs of the instance elements corresponding to the template element
   * of the given ID
   * @param templateId a non-null string
   * @return a non-null, potentially empty, unmodifiable list
   * @generated NOT
   */
  private List<String> getInstanceIds(String templateId) {
    List<String> result = new ArrayList<String>();
    TemplateCounterpart templateCounterpart = getTemplateIds().get(templateId);
    if (templateCounterpart != null)
      result.addAll(templateCounterpart.getInstanceParts().values());
    return Collections.unmodifiableList(result);
	}
  
  /**
   * Return the identifier for the main multi-part in instances 
   * @return a potentially null string
   * @generated NOT
   */
  private String getMainMultipart() {
    String result = null;
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine != null)
      result = engine.getMainMultipart();
    return result;
  }
  
  /**
   * Return the ID of the multipart to which the given instance element strictly belongs, if any
   * @param element a non-null element
   * @return a potentially null string
   * @generated NOT
   */
  public String getMultipartOf(EObject element) {
    String result = null;
    String instanceId = getId(element);
    InstanceCounterpart instanceCounterpart = getInstanceIds().get(instanceId);
    if (instanceCounterpart != null)
      result = instanceCounterpart.getMultipart();
    return result;
  }
  
  /**
   * Return the set of non-main multipart symbols for the instance
   * @return a non-null, unmodifiable set
   * @generated NOT
   */
  public EList<String> getMultiparts() {
    Set<String> result = new HashSet<String>();
    // Multiparts found in template counterparts
    for (TemplateCounterpart templateCounterpart : getTemplateIds().values()) {
      result.addAll(templateCounterpart.getInstanceParts().keySet());
    }
    // Multiparts defined by multiplicity
    if (getMultiplicity() > 1) {
      for (int i = 1; i <= getMultiplicity(); i++) {
        result.add(String.valueOf(i));
      }
    }
    result.remove(getMainMultipart());
    return ECollections.unmodifiableEList(new BasicEList<String>(result));
  }
  
	/**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider#getPattern()
   * @generated NOT
   */
  public TemplatePattern getPattern() {
    TemplatePattern result = null;
    IPatternInstance instance = getInstance();
    if (instance != null)
      result = (TemplatePattern)instance.getPattern();
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData#getRolesOf(org.eclipse.emf.ecore.EObject)
   * @generated NOT
   */
  public EList<TemplatePatternRole> getRolesOf(EObject instanceElement_p) {
    EList<TemplatePatternRole> result = new ModelsUtil.ROrderedSet<TemplatePatternRole>();
    EObject templateElement = getCounterpart(instanceElement_p, false);
    if (templateElement != null && getPattern() != null) {
      for (TemplatePatternRole role : getPattern().getRoles()) {
        if (role.getTemplateElements().contains(templateElement))
          result.add(role);
      }
    }
    return ECollections.unmodifiableEList(result);
  }
  
	/**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IUserScopeProvider#getScopeElement()
   * @generated NOT
   */
  public Object getScopeElement() {
    return this;
  }
  
	/**
   * Return the ID of the template element corresponding to the instance element
   * of the give ID
   * @param instanceId a non-null string
   * @return a potentially null string
   * @generated NOT
   */
	private String getTemplateId(String instanceId) {
		String result = null;
		InstanceCounterpart found = getInstanceIds().get(instanceId);
		if (found != null)
		  result = found.getTemplateId();
		return result;
	}
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedSpecification#isComplete()
   * @generated NOT
   */
  public boolean isComplete() {
    return !getInstanceIds().isEmpty();
  }
  
  /**
   * @see IDeleteOperationProvider#isInModel(EObject)
   * @generated NOT
   */
  private boolean isInModel(EObject instanceElement) {
    return CorePatternsPlugin.getDefault().getDeleteOperationProvider().isInModel(instanceElement);
  }
  
  /**
   * Return whether the given element strictly belongs to the multipart of the given ID
   * @param element a non-null element
   * @param multipart a potentially null multipart ID
   * @generated NOT
   */
  public boolean isInMultipart(EObject element, String multipart) {
    String elementMultipart = getMultipartOf(element);
    return
      multipart == null && elementMultipart == null ||
      multipart != null && multipart.equals(elementMultipart);
  }
  
  /**
   * Return whether the given element belongs to another multipart than that the given ID,
   * main multipart excluded
   * - if found multipart is null, then false
   * - if multipart is main, then true iff found multipart is not main
   * - if multipart is not main, then true iff found multipart is not main neither multipart
   * @param element a non-null element
   * @param multipart a non-null multipart ID
   * @generated NOT
   */
  public boolean isInOtherMultipart(EObject element, String multipart) {
    String elementMultipart = getMultipartOf(element);
    boolean result;
    if (elementMultipart == null)
      result = false;
    else if (getMainMultipart().equals(multipart))
      result = !getMainMultipart().equals(elementMultipart);
    else
      result = !elementMultipart.equals(multipart) &&
        !getMainMultipart().equals(elementMultipart);
    return result;
  }
  
  /**
   * Map the given instance and template elements
   * @param instanceElement a non-null instance element
   * @param templateElement a non-null template element
   * @param multipart an optional multipart ID
   * @generated NOT
   */
  public void map(EObject instanceElement, EObject templateElement, String multipart) {
    String instanceId = getId(instanceElement);
    String templateId = getId(templateElement);
    checkInstanceElementsInitialized();
    // Instance ID side
    InstanceCounterpart instanceCounterpart = getInstanceIds().get(instanceId);
    if (instanceCounterpart == null) {
      instanceCounterpart = TemplatepatternsFactory.eINSTANCE.createInstanceCounterpart();
      getInstanceIds().put(instanceId, instanceCounterpart);
    }
    instanceCounterpart.setTemplateId(templateId);
    instanceCounterpart.setMultipart(multipart);
    // Template ID side
    TemplateCounterpart templateCounterpart = getTemplateIds().get(templateId);
    if (templateCounterpart == null) {
      templateCounterpart = TemplatepatternsFactory.eINSTANCE.createTemplateCounterpart();
      getTemplateIds().put(templateId, templateCounterpart);
    }
    templateCounterpart.getInstanceParts().put(multipart, instanceId);
    // Cache
    _instanceIdsToElements.put(instanceId, instanceElement);
  }
  
  /**
   * Remember that the given instance element was created during unfolding
   * @param instanceElement a non-null element
   * @generated NOT
   */
  public void markAsUnfolded(EObject instanceElement) {
    String instanceId = getId(instanceElement);
    getUnfoldedIds().add(instanceId);
  }
  
  /**
   * Unregister the given ID of an instance element as well as its mapping to the
   * template counterpart
   * @param instanceId a non-null string
   * @generated NOT
   */
  private void removeInstanceId(String instanceId) {
    try {
      InstanceCounterpart instanceCounterpart = getInstanceIds().removeKey(instanceId);
      if (instanceCounterpart != null)
        getTemplateIds().removeKey(instanceCounterpart.getTemplateId());
      getUnfoldedIds().remove(instanceId);
      if (_initialized)
        _instanceIdsToElements.remove(instanceId);
    } catch(IllegalStateException e) {
      // Not in a write transaction: keep out-dated value (no harm)
    }
  }
  
  /**
   * Rename the instance based on the given new naming rule
   * @param newNamingRule a potentially null string
   * @param keepUserNames whether non-conforming names must be preserved
   * @generated NOT
   */
  public void rename(String newNamingRule, boolean keepUserNames) {
    ITemplatePatternEngine engine = TemplatePatternsPlugin.getDefault().getEngine();
    if (engine != null) {
      engine.renameElements(getInstance(), newNamingRule, keepUserNames);
    }
  }
  
  /**
   * Resolve the given instance ID into an instance element
   * @param instanceId_p a potentially null string
   * @return a potentially null element of the instance
   * @generated NOT
   */
  private EObject resolveInstanceId(String instanceId_p) {
    return CorePatternsPlugin.getDefault().getIdProvider().getByIdInContext(instanceId_p, getInstance());
  }
  
  /**
   * Resolve the given template ID into a template element
   * @param templateId_p a potentially null string
   * @return a potentially null template element of the pattern
   * @generated NOT
   */
  private EObject resolveTemplateId(String templateId_p) {
    EObject result = null;
    IPattern pattern = getInstance().getPattern();
    if (pattern instanceof EObject)
      result = CorePatternsPlugin.getDefault().getIdProvider().getByIdInResource(templateId_p, (EObject)pattern);
    return result;
  }
	
	/**
   * Return whether the given instance element was created by unfolding
   * @param instanceElement a potentially null element
   * @generated NOT
   */
  public boolean wasUnfolded(EObject instanceElement) {
    boolean result = false;
    String instanceId = getId(instanceElement);
    if (instanceId != null)
      result = getUnfoldedIds().contains(instanceId);
    return result;
  }
  
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__INSTANCE_IDS:
				return ((InternalEList<?>)getInstanceIds()).basicRemove(otherEnd, msgs);
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__TEMPLATE_IDS:
				return ((InternalEList<?>)getTemplateIds()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("boxing")
  @Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__NAMING_RULE:
				return getNamingRule();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__MULTIPLICITY:
				return getMultiplicity();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__INSTANCE_IDS:
				if (coreType) return getInstanceIds();
				else return getInstanceIds().map();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__TEMPLATE_IDS:
				if (coreType) return getTemplateIds();
				else return getTemplateIds().map();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__UNFOLDED_IDS:
				return getUnfoldedIds();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "boxing" })
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__NAMING_RULE:
				setNamingRule((String)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__MULTIPLICITY:
				setMultiplicity((Integer)newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__INSTANCE_IDS:
				((EStructuralFeature.Setting)getInstanceIds()).set(newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__TEMPLATE_IDS:
				((EStructuralFeature.Setting)getTemplateIds()).set(newValue);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__UNFOLDED_IDS:
				getUnfoldedIds().clear();
				getUnfoldedIds().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__NAMING_RULE:
				setNamingRule(NAMING_RULE_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__INSTANCE_IDS:
				getInstanceIds().clear();
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__TEMPLATE_IDS:
				getTemplateIds().clear();
				return;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__UNFOLDED_IDS:
				getUnfoldedIds().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__NAMING_RULE:
				return NAMING_RULE_EDEFAULT == null ? namingRule != null : !NAMING_RULE_EDEFAULT.equals(namingRule);
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__MULTIPLICITY:
				return multiplicity != MULTIPLICITY_EDEFAULT;
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__INSTANCE_IDS:
				return instanceIds != null && !instanceIds.isEmpty();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__TEMPLATE_IDS:
				return templateIds != null && !templateIds.isEmpty();
			case TemplatepatternsPackage.TEMPLATE_PATTERN_DATA__UNFOLDED_IDS:
				return unfoldedIds != null && !unfoldedIds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (namingRule: "); //$NON-NLS-1$
		result.append(namingRule);
		result.append(", multiplicity: "); //$NON-NLS-1$
		result.append(multiplicity);
		result.append(", unfoldedIds: "); //$NON-NLS-1$
		result.append(unfoldedIds);
		result.append(')');
		return result.toString();
	}
	
} //TemplatePatternDataImpl
