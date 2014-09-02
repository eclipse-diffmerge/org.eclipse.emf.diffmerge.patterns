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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl;

import static org.eclipse.emf.diffmerge.patterns.core.gen.PatternsCoreGenAdapter.GEN_ADAPTER;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternData;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractLocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternData;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleBinding;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicPatternRoleSymbol;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Pattern Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl#isFolded <em>Folded</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl#getRoleBindings <em>Role Bindings</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl#getPatternVersion <em>Pattern Version</em>}</li>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.impl.AbstractPatternInstanceImpl#getPatternData <em>Pattern Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractPatternInstanceImpl extends AbstractIdentifiedElementImpl implements AbstractPatternInstance {
	/**
	 * The default value of the '{@link #isFolded() <em>Folded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFolded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOLDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFolded() <em>Folded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFolded()
	 * @generated
	 * @ordered
	 */
	protected boolean folded = FOLDED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoleBindings() <em>Role Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<PatternRoleBinding> roleBindings;

	/**
	 * The cached value of the '{@link #getPatternVersion() <em>Pattern Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternVersion()
	 * @generated
	 * @ordered
	 */
	protected PatternVersion patternVersion;

	/**
	 * The cached value of the '{@link #getPatternData() <em>Pattern Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternData()
	 * @generated
	 * @ordered
	 */
	protected AbstractPatternData patternData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractPatternInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorepatternsPackage.Literals.ABSTRACT_PATTERN_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PatternRoleBinding> getRoleBindings() {
		if (roleBindings == null) {
			roleBindings = new EObjectContainmentEList<PatternRoleBinding>(PatternRoleBinding.class, this, CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS);
		}
		return roleBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternVersion getPatternVersion() {
		return patternVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPatternVersion(PatternVersion newPatternVersion, NotificationChain msgs) {
		PatternVersion oldPatternVersion = patternVersion;
		patternVersion = newPatternVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION, oldPatternVersion, newPatternVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternVersion(PatternVersion newPatternVersion) {
		if (newPatternVersion != patternVersion) {
			NotificationChain msgs = null;
			if (patternVersion != null)
				msgs = ((InternalEObject)patternVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION, null, msgs);
			if (newPatternVersion != null)
				msgs = ((InternalEObject)newPatternVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION, null, msgs);
			msgs = basicSetPatternVersion(newPatternVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION, newPatternVersion, newPatternVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFolded() {
		return folded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFolded(boolean newFolded) {
		boolean oldFolded = folded;
		folded = newFolded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__FOLDED, oldFolded, folded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractPatternData getPatternData() {
		return patternData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPatternData(AbstractPatternData newPatternData, NotificationChain msgs) {
		AbstractPatternData oldPatternData = patternData;
		patternData = newPatternData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA, oldPatternData, newPatternData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternData(AbstractPatternData newPatternData) {
		if (newPatternData != patternData) {
			NotificationChain msgs = null;
			if (patternData != null)
				msgs = ((InternalEObject)patternData).eInverseRemove(this, CorepatternsPackage.ABSTRACT_PATTERN_DATA__INSTANCE, AbstractPatternData.class, msgs);
			if (newPatternData != null)
				msgs = ((InternalEObject)newPatternData).eInverseAdd(this, CorepatternsPackage.ABSTRACT_PATTERN_DATA__INSTANCE, AbstractPatternData.class, msgs);
			msgs = basicSetPatternData(newPatternData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA, newPatternData, newPatternData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS:
				return ((InternalEList<?>)getRoleBindings()).basicRemove(otherEnd, msgs);
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION:
				return basicSetPatternVersion(null, msgs);
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA:
				return basicSetPatternData(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__FOLDED:
				return isFolded();
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS:
				return getRoleBindings();
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION:
				return getPatternVersion();
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA:
				return getPatternData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__FOLDED:
				setFolded((Boolean)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS:
				getRoleBindings().clear();
				getRoleBindings().addAll((Collection<? extends PatternRoleBinding>)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION:
				setPatternVersion((PatternVersion)newValue);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA:
				setPatternData((AbstractPatternData)newValue);
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
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__FOLDED:
				setFolded(FOLDED_EDEFAULT);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS:
				getRoleBindings().clear();
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION:
				setPatternVersion((PatternVersion)null);
				return;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA:
				setPatternData((AbstractPatternData)null);
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
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__FOLDED:
				return folded != FOLDED_EDEFAULT;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__ROLE_BINDINGS:
				return roleBindings != null && !roleBindings.isEmpty();
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_VERSION:
				return patternVersion != null;
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA:
				return patternData != null;
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
		result.append(" (folded: "); //$NON-NLS-1$
		result.append(folded);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance#fold()
	 * @generated NOT
	 */
	public IModelTransformationStatus fold() {
	  IModelTransformationStatus result;
	  IPattern pattern = getPattern();
	  if (pattern == null)
	    result = SimpleStatus.NO_PATTERN_FAILURE;
	  else
	    result = pattern.fold(this);
	  if (result.isOk())
	    setFolded(true);
	  return result;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance#unfold()
	 * @generated NOT
	 */
	public IModelTransformationStatus unfold() {
	  IModelTransformationStatus result;
	  IPattern pattern = getPattern();
	  if (pattern == null)
	    result = SimpleStatus.NO_PATTERN_FAILURE;
	  else
	    result = pattern.unfold(this);
	  if (result.isOk() && !result.hasWarnings())
	    setFolded(false);
	  return result;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance#update(IModelUpdateSpecification)
	 * @generated NOT
	 */
	public IModelTransformationStatus update(IModelUpdateSpecification specification_p) {
	  IPattern pattern = getPattern();
	  if (pattern == null)
	    return SimpleStatus.NO_PATTERN_FAILURE;
	  return pattern.updateModel(this, specification_p);
	}

	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#checkConformance(java.util.List)
	 * @generated NOT
	 */
	public IPatternConformityStatus checkConformance(List<EStructuralFeature> ignoredFeatures_p) {
	  IPattern pattern = getPattern();
	  if (pattern == null)
	    return SimpleStatus.NO_PATTERN_FAILURE;
	  return pattern.checkConformance(this, ignoredFeatures_p);
	}

	/**
	 * Return the binding which corresponds to the given role, if any
	 * @param role_p a non-null role
	 * @return a potentially null binding
	 * @generated NOT
	 */
	protected PatternRoleBinding getBindingFor(IPatternRole role_p) {
	  IPatternRoleSymbol symbol = role_p.getSymbol();
	  if (symbol == null)
	    return null;
	  return getBindingFor(symbol);
	}

	/**
	 * Return the binding which corresponds to the given role symbol, if any
	 * @param role_p a non-null role symbol
	 * @return a potentially null binding
	 * @generated NOT
	 */
	protected PatternRoleBinding getBindingFor(IPatternRoleSymbol symbol_p) {
	  for (PatternRoleBinding binding : getRoleBindings()) {
	    if (BasicPatternRoleSymbol.areEqual(symbol_p, binding.getRoleSymbol()))
	      return binding;
	  }
	  return null;
	}
	
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance#getElements()
   * @generated NOT
   */
  public List<EObject> getElements() {
    List<EObject> result;
    IPatternData data = getPatternData();
    if (data == null)
      result = LocationsUtil.getMergeTargets(this);
    else
      result = data.getInstanceElements();
    return result;
  }
  
	/**
	 * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getLocation(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole)
	 * @generated NOT
	 */
	public ILocation getLocation(IPatternRole role_p) {
	  PatternRoleBinding binding = getBindingFor(role_p);
	  if (binding == null)
	    return null;
    return binding.getLocation();
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getLocations()
   * @generated NOT
   */
  public Collection<? extends ILocation> getLocations() {
    Collection<ILocation> result = new ArrayList<ILocation>();
    for (PatternRoleBinding binding : getRoleBindings()) {
      ILocation location = binding.getLocation();
      if (location != null)
        result.add(location);
    }
    return Collections.unmodifiableCollection(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getPattern()
   * @generated NOT
   */
  public IPattern getPattern() {
    IPattern result = null;
    PatternVersion version = getPatternVersion();
    PatternSymbol symbol = version != null? version.getPatternSymbol(): null;
    if (symbol != null)
      result = CorePatternsPlugin.getDefault().getRepositoryRegistry().getPattern(symbol);
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#getRolesOf(org.eclipse.emf.ecore.EObject)
   * @generated NOT
   */
  public List<IPatternRole> getRolesOf(EObject element_p) {
    List<IPatternRole> result = new ArrayList<IPatternRole>();
    if (getPattern() != null) {
      for (IPatternRole role : getPattern().getRoles()) {
        ILocation location = getLocation(role);
        if (location != null) {
          for (IAtomicLocation atomicLocation : location.getAtomicContents()) {
            if (atomicLocation instanceof IElementRelativeLocation) {
              EObject element = ((IElementRelativeLocation)atomicLocation).getElement();
              if (element == element_p) {
                result.add(role);
                break;
              }
            } else if (atomicLocation instanceof IElementMappingLocation) {
              IElementMappingLocation mappingLocation = (IElementMappingLocation)atomicLocation;
              for (EObject patternElement : mappingLocation.getPatternElements(getPattern())) {
                EObject modelElement = mappingLocation.getElement(patternElement);
                if (modelElement == element_p) {
                  result.add(role);
                  break; // An IElementMappingLocation defines a bijection
                }
              }
            }
          }
        }
      }
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IUserScopeProvider#getScopeElement()
   * @generated NOT
   */
  public Object getScopeElement() {
    return this;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#isComplete()
   * @generated NOT
   */
  public boolean isComplete() {
    for (IPatternRole role : getPattern().getRoles()) {
      if (!isCompleteOn(role))
        return false;
    }
    return true;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#isCompleteOn(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole)
   * @generated NOT
   */
  public boolean isCompleteOn(IPatternRole role_p) {
    return role_p.checkApplicability(getLocation(role_p), this).isOk();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication#isEmpty()
   * @generated NOT
   */
  public boolean isEmpty() {
    if (getPattern() == null)
      return true;
    for (IPatternRole role : getPattern().getRoles()) {
      if (isCompleteOn(role))
        return false;
    }
    return true;
  }
  
  /**
   * Associate the given location to the given role, removing any existing
   * location associated to the same role
   * @param role_p a non-null role
   * @param location_p a potentially null location
   * @generated NOT
   */
  public void setLocation(IPatternRole role_p, AbstractLocation location_p) {
    PatternRoleBinding binding = getBindingFor(role_p);
    if (binding == null) {
      binding = CorepatternsFactory.eINSTANCE.createPatternRoleBinding();
      PatternRoleSymbol symbol = GEN_ADAPTER.adapt(role_p.getSymbol());
      binding.setRoleSymbol(symbol);
      getRoleBindings().add(binding);
    }
    binding.setLocation(location_p);
  }

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA:
				if (patternData != null)
					msgs = ((InternalEObject)patternData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorepatternsPackage.ABSTRACT_PATTERN_INSTANCE__PATTERN_DATA, null, msgs);
				return basicSetPatternData((AbstractPatternData)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}
  
} //AbstractPatternInstanceImpl
