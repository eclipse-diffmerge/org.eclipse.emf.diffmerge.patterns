/*********************************************************************
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.ext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.diffdata.EElementRelativePresence;
import org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.helper.UMLMetamodelHelper;
import org.eclipse.emf.diffmerge.patterns.support.gen.commonpatternsupport.CommonPatternInstance;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationScope;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.MultiStorageChoiceDialog;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.MultiStorageChoiceDialog.MultiStorageKind;
import org.eclipse.emf.diffmerge.structures.common.FArrayList;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.diagram.sequence.SequenceDDiagram;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * A provider of business-specific UML Designer logics for consistently manipulating models.
 * @author Skander Turki
 */
public class UMLDesignerRuleProvider extends ModellerSemanticRuleProvider{

  /** Saves storage by prompt locations when "Apply for all Similar Elements" is selected */
  private final Map<EClass, IReferenceLocation> _perTypeLocations;

  /** Saves storage by prompt locations when "Apply for all Compatible Elements" is selected */
  private final Collection<IReferenceLocation> _predefinedLocations;

  /** The set of references that must not be considered for dependencies */
  protected static final List<EReference> NON_DEPENDENCY_REFERENCES = 
      UMLMetamodelHelper.NON_DEPENDENCY_REFERENCES;

  /** Libraries to add to the target model in a post-pattern application computation */
  private List<String> _libaryImportsToAdd = new ArrayList<String>();


  /**
   * Constructor
   */
  public UMLDesignerRuleProvider(){
    _perTypeLocations = new HashMap<EClass, IReferenceLocation>();
    _predefinedLocations = new HashSet<IReferenceLocation>(); 
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#adjustScope(org.eclipse.emf.diffmerge.impl.scopes.FilteredModelScope, boolean)
   */
  public void adjustScope(FilteredModelScope scope_p, boolean extend_p) {
    boolean changed;
    do {
      changed = adjustScopeNonRec(scope_p, extend_p);
    } while (changed); // Reach fix point

  }

  /**
   * Non-recursive core behavior of adjustScope (may not reach a fix point)
   * @param scope_p a non-null scope
   * @return whether the scope was modified
   */
  private boolean adjustScopeNonRec(FilteredModelScope scope_p,
      boolean extend_p) {
    return extend_p? extendScopeNonRec(scope_p): reduceScopeNonRec(scope_p);
  }

  /**
   * Behavior of adjustScopeNonRec in the extend case
   * @param scope_p a non-null scope
   * @return whether the scope was modified
   */
  private boolean extendScopeNonRec(FilteredModelScope scope_p) {
    List<EObject> toAdd = new FOrderedSet<EObject>();
    for (EObject root : scope_p.getContents()) {
      if(!canBeAutomaticallyMerged(root)){
        toAdd.addAll(getAdditionalRelevantElements(root, scope_p));
        Iterator<EObject> it = scope_p.getAllContents(root);
        while (it.hasNext()) {
          EObject current = it.next();
          toAdd.addAll(getAdditionalRelevantElements(current, scope_p));
        }
      }

    }
    boolean result = false;
    for (EObject rootToAdd : toAdd) {
      if (!scope_p.covers(rootToAdd)) {
        scope_p.add(rootToAdd, true);
        result = true;
      }
    }
    return result;
  }

  /**
   * Behavior of adjustScopeNonRec in the reduction case
   * @param elements_p a non-null, potentially empty, unmodifiable set of roots
   *        of disjoint containment trees
   * @return whether the scope was modified
   */
  private boolean reduceScopeNonRec(FilteredModelScope scope_p) {
    List<EObject> toDelete = new FOrderedSet<EObject>();
    for (EObject root : scope_p.getContents()) {
      // Always keep roots
      TreeIterator<EObject> it = scope_p.getAllContents(root);
      while (it.hasNext()) {
        EObject current = it.next();
        if (!isMeaningfulWithin(current, scope_p)) {
          toDelete.add(current);
          it.prune();
        }
      }
    }
    for (EObject rootToDelete : ModelsUtil.getRoots(toDelete)) {
      scope_p.removeFromScope(rootToDelete, true);
    }
    return !toDelete.isEmpty();
  }

  /**
   * Return whether the given element is meaningful when considered within
   * the given scope only, i.e., when separated from anything outside the scope
   * @param element_p a non-null element
   * @param scope_p a non-null scope
   */
  private boolean isMeaningfulWithin(EObject element_p, IModelScope scope_p) {
    if (element_p instanceof EnumerationLiteral)
      return false;
    // Other cases
    Collection<EObject> mustBeIncluded = new FOrderedSet<EObject>();
    //Stereotypes
    if (element_p instanceof Element) {
      Element casted = (Element)element_p;
      mustBeIncluded.addAll(casted.getAppliedStereotypes());
    }
    //Typed Element: Type
    else if (element_p instanceof TypedElement) {
      TypedElement casted = (TypedElement)element_p;
      mustBeIncluded.add(casted.getType());
    }
    // DirectedRealtionship: requires sources and targets
    else if (element_p instanceof DirectedRelationship) {
      DirectedRelationship casted = (DirectedRelationship)element_p;
      mustBeIncluded.addAll(casted.getSources());
      mustBeIncluded.addAll(casted.getTargets());
    }
    // Association: Members
    else if (element_p instanceof Association) {
      Association casted = (Association)element_p;
      mustBeIncluded.addAll(casted.getMemberEnds());
    }
    // Property: 
    else if (element_p instanceof Property) {
      Property casted = (Property)element_p;
      mustBeIncluded.addAll(casted.getOwnedElements());
    }
    for (EObject current : mustBeIncluded) {
      if (current == null || !scope_p.covers(current))
        return false;
    }
    return true;
  }

  /**
   * Return the set of elements which should be present in the given scope for the
   * given element to make sense 
   * @param element_p a non-null element
   * @param scope_p a non-null scope
   * @return a non-null, potentially empty, unmodifiable collection
   */
  private Collection<? extends EObject> getAdditionalRelevantElements(EObject element_p,
      IModelScope scope_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    // Element: stereotypes
    if (element_p instanceof Element) {
      Element casted = (Element)element_p;
      if (casted.getAppliedStereotypes() != null)
        result.addAll(casted.getAppliedStereotypes());
    }
    // TypedElement: type
    if (element_p instanceof TypedElement) {
      TypedElement casted = (TypedElement)element_p;
      if (casted.getType() != null )//&& !UMLMetamodelHelper.isUMLLibraryPrimitiveType(casted.getType()))
        result.add(casted.getType());
    }
    // Allocation: target element
    if (element_p instanceof DirectedRelationship) {
      DirectedRelationship casted = (DirectedRelationship)element_p;
      if (casted.getSources() != null)
        result.addAll(casted.getSources());
    }
    // Association: navigable members
    if (element_p instanceof Association) {
      Association casted = (Association)element_p;
      result.addAll(casted.getMembers());
    }

    return Collections.unmodifiableList(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#initializeTargetScope(org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope, org.eclipse.emf.diffmerge.api.scopes.IFeaturedModelScope)
   */
  public void initializeTargetScope(IFeaturedModelScope referenceScope_p,
      IFeaturedModelScope targetScope_p) {
    _libaryImportsToAdd = new ArrayList<String>();
    Iterator<EObject> it = referenceScope_p.getContents().iterator();
    while(it.hasNext()){
      Object current = it.next();
      if(UMLMetamodelHelper.isUMLBasicLibraryPrimitiveType(current)){
        EObject obj = getAutomaticMergeTarget((EObject)current, targetScope_p);
        ((TemplatePatternApplicationScope)targetScope_p).add(obj);
        addLibraryImport(UMLMetamodelHelper.UML_BASIC_LIBRARY_PRIMITIVE_TYPES_RESOURCE_URI, (TemplatePatternApplicationScope)targetScope_p);
      }else if(UMLMetamodelHelper.isUMLJavaPrimitiveType(current)){
        EObject obj = getAutomaticMergeTarget((EObject)current, targetScope_p);
        ((TemplatePatternApplicationScope)targetScope_p).add(obj);
        addLibraryImport(UMLMetamodelHelper.UML_JAVA_PRIMITIVE_TYPES_RESOURCE_URI, (TemplatePatternApplicationScope)targetScope_p);
      }
    }
  }

  /**
   * The library import has to be done "manually"
   */
  private void addLibraryImport(String uri_p, TemplatePatternApplicationScope targetScope_p) {
    EObject obj = targetScope_p.getContents().get(0);
    boolean found = false;
    if(obj != null){
      EObject root = EcoreUtil.getRootContainer(obj);
      if(root instanceof Model){
        for(PackageImport imp : ((Model)root).getPackageImports()){
          if(imp.getImportedPackage().getURI().toString().equals(uri_p)){
            found = true;
            break;
          }
        }
        if(!found){
          Resource res = root.eResource();
          if(res != null){
            //Resource libRes = res.getResourceSet().getResource(URI.createURI(uri_p), true);
            _libaryImportsToAdd.add(uri_p);
          }     
        }
      }
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#enforceOwnership(java.util.Collection, java.lang.Object)
   */
  public Boolean enforceOwnership(Collection<? extends EObject> roots_p,
      Object context_p) {
    EList<EObject> derivables = new FOrderedSet<EObject>();
    // Prompt for ownership of non-derivables, remember derivables
    for (EObject root : roots_p) {
      if (root.eContainer() == null) {
        if (ownershipMightBeDerived(root))
          derivables.add(root);
        else {
          Boolean success = enforceOwnershipByPrompt(
              root, context_p, true, _perTypeLocations, _predefinedLocations);
          if (!Boolean.TRUE.equals(success)) return success;
        }
      }
    }
    // Try and derive ownerships
    for (EObject derivable : derivables) {
      boolean derived = deriveOwnership(derivable, context_p);
      if (!derived) {
        Boolean success = enforceOwnershipByPrompt(
            derivable, context_p, true, _perTypeLocations, _predefinedLocations);
        if (!Boolean.TRUE.equals(success)) return success;
      }
    }
    return Boolean.TRUE;
  }
  
  /**
   * Enforce ownership of the given element by prompting the user or using former prompts
   * @param element_p a non-null element
   * @param context_p a non-null object, typically resource or model element
   * @param allowCancel_p whether cancellation by the user is allowed
   * @param perTypeLocations_p a non-null, modifiable map that registers reference locations for given types
   * @param predefinedLocations_p a non-null, modifiable collection of reference locations to be tried
   * @return whether the operation succeeded, or null for canceled
   */
  private Boolean enforceOwnershipByPrompt(EObject element_p, Object context_p, boolean allowCancel_p,
      Map<EClass, IReferenceLocation> perTypeLocations_p,
      Collection<IReferenceLocation> predefinedLocations_p) {
    Boolean result = Boolean.TRUE;
    boolean done = false;
    // Trying predefined per-type locations
    IReferenceLocation registeredLocation = perTypeLocations_p.get(element_p.eClass());
    if (registeredLocation != null && supportsAdditionOf(registeredLocation, element_p)) {
      LocationsUtil.add(registeredLocation, element_p);
      done = true;
    } else {
      // Trying predefined general locations
      Iterator<IReferenceLocation> it = predefinedLocations_p.iterator();
      while (it.hasNext() && !done) {
        IReferenceLocation predefinedLocation = it.next();
        if (supportsAdditionOf(predefinedLocation, element_p)) {
          LocationsUtil.add(predefinedLocation, element_p);
          done = true;
        }
      }
    }
    // Trying by prompt
    while (!done) {
      IReferenceLocation location = null;
      boolean proceed = true;
      MultiStorageKind storageKind = MultiStorageKind.CURRENT_ONLY;
      List<EObject> candidateContainers = getPossibleContainersInContext(
          context_p, Collections.singleton(element_p));
      if (candidateContainers.size() == 1) {
        EObject container = candidateContainers.get(0);
        List<EReference> containments =
            getReferencesForElementAddition(container, element_p, true, true);
        if (containments.size() == 1) {
          EReference containment = containments.get(0);
          location = new BasicReferenceLocation(container, containment);
        }
      }
      if (location == null) {
        MultiStorageChoiceDialog dialog = new MultiStorageChoiceDialog(
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
            null, candidateContainers, element_p);
        int answer = dialog.open();
        proceed = Window.OK == answer;
        if (proceed) {
          location = dialog.getChoice();
          storageKind = dialog.getStorageKind();
        }
      }
      if (proceed) {
        if (location != null) {
          LocationsUtil.add(location, element_p);
          done = true;
          switch (storageKind) {
          case ALL_SIMILAR:
            perTypeLocations_p.put(element_p.eClass(), location); break;
          case ALL_COMPATIBLE:
            predefinedLocations_p.add(location); break;
          default: // Nothing
          }
        }
      } else {
        // Canceled
        if (allowCancel_p)
          return null;
      }
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider#ownershipMightBeDerived(org.eclipse.emf.ecore.EObject)
   */
  @Override
  public boolean ownershipMightBeDerived(EObject element_p) {
    return super.ownershipMightBeDerived(element_p)
        //UMLMetamodelHelper.ownershipMightBeDerived(element_p)
        ;
  }


  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider#deriveOwnership(org.eclipse.emf.ecore.EObject, java.lang.Object)
   */
  @Override
  public boolean deriveOwnership(EObject element_p, Object context_p) {
    return UMLMetamodelHelper.deriveOwnership(element_p, context_p);
  }

  /**
   * Return whether the given reference location supports the addition of the given value
   * @param location_p a non-null, well-formed reference location
   * @param value_p a non-null element
   */
  private boolean supportsAdditionOf(IReferenceLocation location_p, EObject value_p) {
    return supportsAdditionOf(location_p.getElement(), location_p.getReference(), value_p, true);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider#supportsAdditionOf(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EClass, boolean)
   */
  @Override
  protected boolean supportsAdditionOf(EObject element_p, EReference reference_p,
      EClass valueType_p, boolean nonErasing_p) {
    boolean result = super.supportsAdditionOf(element_p, reference_p, valueType_p, nonErasing_p);
    return result;
  }

  /**
   * Return the references which support the addition of the given value
   * on the given element
   * @param element_p a non-null element
   * @param value_p a non-null element
   * @param nonErasing_p whether the removal of existing values is allowed
   * @param containmentOnly_p whether only containment references must be considered
   * @return a non-null, potentially empty, unmodifiable list
   */
  private List<EReference> getReferencesForElementAddition(EObject element_p,
      EObject value_p, boolean nonErasing_p, boolean containmentOnly_p) {
    List<EReference> result = new ArrayList<EReference>();
    List<EReference> candidates;
    if (containmentOnly_p)
      candidates = element_p.eClass().getEAllContainments();
    else
      candidates = element_p.eClass().getEAllReferences();
    for (EReference candidate : candidates) {
      if (supportsAdditionOf(element_p, candidate, value_p, nonErasing_p))
        result.add(candidate);
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getDefaultOptionalMergeFeatures()
   */
  public List<EStructuralFeature> getDefaultOptionalMergeFeatures() {
    ArrayList<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
    result.add(UMLPackage.eINSTANCE.getNamedElement_Name());
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getElementsToRename(java.util.Collection)
   */
  public Collection<EObject> getElementsToRename(
      Collection<? extends EObject> elements_p) {
    Collection<EObject> candidates =Collections.unmodifiableCollection(elements_p);
    List<EObject> result = new FOrderedSet<EObject>(candidates, null);
    return Collections.unmodifiableCollection(result);
  }

  /** 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getOptionalMergeFeatures()
   */
  public Collection<? extends EStructuralFeature> getOptionalMergeFeatures() {
    return Arrays.<EStructuralFeature>asList(UMLPackage.eINSTANCE.getNamedElement_Name(),
        UMLPackage.eINSTANCE.getNamedElement_QualifiedName());
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getRootsForPatternInclusion(org.eclipse.emf.ecore.EObject)
   */
  public Collection<EObject> getRootsForPatternInclusion(EObject context_p) {
    List<EObject> result = new FArrayList<EObject>();
    EObject root = EcoreUtil.getRootContainer(context_p);
    if (root instanceof Model)
      result.addAll(((Model)root).getOwnedElements());
    else
      result.add(root);
    return Collections.unmodifiableCollection(result);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider#getDependencies(org.eclipse.emf.ecore.EObject)
   */
  @Override
  public List<EObject> getDependencies(EObject object_p) {
    List<EObject> result = new FOrderedSet<EObject>();
    if(object_p != null){
      for (FeatureIterator<EObject> featureIterator =
          (FeatureIterator<EObject>)object_p.eCrossReferences().iterator();
          featureIterator.hasNext(); ) {
        EObject referenced = featureIterator.next();
        EReference reference = (EReference)featureIterator.feature();
        if (isDependency(reference))
          result.add(referenced);
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider#isDependency(org.eclipse.emf.ecore.EReference)
   */
  @Override
  public boolean isDependency(EReference reference_p) {
    return !reference_p.isDerived() && !NON_DEPENDENCY_REFERENCES.contains(reference_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isMergeDependency(org.eclipse.emf.ecore.EObject)
   */
  public boolean isMergeDependency(EObject element_p) {
    //    if(element_p.eResource() != null){
    //      return element_p.eResource().getURI().toString().equals("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml") //$NON-NLS-1$
    //          || UMLMetamodelHelper.isUMLLibraryPrimitiveType(element_p);
    //    }
    return UMLMetamodelHelper.isUMLLibraryPrimitiveType(element_p);
  }

  /** 
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#canBeAutomaticallyMerged(org.eclipse.emf.ecore.EObject)
   */
  public boolean canBeAutomaticallyMerged(EObject element_p) {
    //    if(element_p.eResource() != null){
    //      return element_p.eResource().getURI().toString().equals("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml") //$NON-NLS-1$
    //          || UMLMetamodelHelper.isUMLLibraryPrimitiveType(element_p);
    //    }
    return UMLMetamodelHelper.isUMLLibraryPrimitiveType(element_p);

  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getAutomaticMergeTarget(org.eclipse.emf.ecore.EObject, java.lang.Object)
   */
  public EObject getAutomaticMergeTarget(EObject element_p, Object targetScope_p) {
    EditingDomain domain = null;
    String name = null;
    if(element_p instanceof PrimitiveType){
      name = ((PrimitiveType)element_p).getName();
    }
    if(targetScope_p instanceof TemplatePatternApplicationScope){
      if(((TemplatePatternApplicationScope)targetScope_p).getApplication() != null)
        domain = AdapterFactoryEditingDomain.getEditingDomainFor(((TemplatePatternApplicationScope)targetScope_p).getApplication().getScopeElement());
    }else if(targetScope_p instanceof EditingDomain){
      domain = (EditingDomain)targetScope_p;
    }else if (targetScope_p instanceof Collection){
      if(((Collection<?>)targetScope_p).iterator().hasNext()){
        domain = AdapterFactoryEditingDomain.getEditingDomainFor(
            ((Collection<?>)targetScope_p).iterator().next());
      }
    }else
      domain = AdapterFactoryEditingDomain.getEditingDomainFor(targetScope_p);
    if (domain != null) {
      if(UMLMetamodelHelper.isUMLBasicLibraryPrimitiveType(element_p)){
        Resource res = domain.getResourceSet().getResource(URI.createURI(UMLMetamodelHelper.UML_BASIC_LIBRARY_PRIMITIVE_TYPES_RESOURCE_URI), true);   
        return res.getEObject(name);
      }else if(UMLMetamodelHelper.isUMLJavaPrimitiveType(element_p)){
        Resource res = domain.getResourceSet().getResource(URI.createURI(UMLMetamodelHelper.UML_JAVA_PRIMITIVE_TYPES_RESOURCE_URI), true);   
        return res.getEObject(name);
      }
    }
    return null;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#isAllowedToBeRoot(org.eclipse.emf.ecore.EObject)
   */
  public boolean isAllowedToBeRoot(EObject obj_p) {
    if(obj_p instanceof Model)
      return true;
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#getPrefixText(org.eclipse.emf.ecore.EObject)
   */
  public String getPrefixText(EObject element_p) {
    return ""; //$NON-NLS-1$
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#reset()
   */
  public void reset() {
    _perTypeLocations.clear();
    _predefinedLocations.clear(); 
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider#isApplicableTo(org.eclipse.emf.ecore.EObject)
   */
  @Override
  public boolean isApplicableTo(EObject obj_p) {
    if (obj_p instanceof CommonPatternInstance ||
        obj_p instanceof Element)
      return true;
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ModellerSemanticRuleProvider#getNameAttribute(org.eclipse.emf.ecore.EObject)
   */
  @Override
  public EAttribute getNameAttribute(EObject element_p) {
    if(element_p != null){
      for (EAttribute attribute : element_p.eClass().getEAllAttributes()) {
        if (attribute.equals(UMLPackage.eINSTANCE.getNamedElement_Name()))
          return attribute;
      }
    }
    return null;
  }

  /**
   * In UMLDesigner, we need to add PackageImports of UML libraries after a pattern application
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider#postPatternApplication(org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication, java.util.Collection, java.util.Collection)
   */
  public void postPatternApplication(IPatternApplication _application,
      Collection<EObject> additions, Collection<IDifference> merges) {
    int nb = 0;
    for(EObject added : additions){
      EObject model = EcoreUtil.getRootContainer(added);
      if(model instanceof Model){
        for(String packURI :_libaryImportsToAdd){
          Package libPack = getLibraryPackage((Model)model, packURI);
          if(libPack != null && !hasPackageImport((Model)model, libPack)){       
            ((Model)model).createPackageImport(libPack);
            nb++;
          }
        }
      }
    }
    if(nb == _libaryImportsToAdd.size())
      return;
    for(IDifference merge : merges){
      if(merge instanceof EElementRelativePresence){
        EObject target = ((EElementRelativePresence)merge).getElementMatch().getTarget();
        EObject model = EcoreUtil.getRootContainer(target);
        if(model instanceof Model){
          for(String packURI :_libaryImportsToAdd){
            Package libPack = getLibraryPackage((Model)model, packURI);
            if(libPack != null && !hasPackageImport((Model)model, libPack)){
              ((Model)model).createPackageImport(libPack);
              nb++;
            }
          }
        }
      }     
    }
  }

  /**
   * Search for the library package in the model's resourceset by the given URI
   * @param model a non-null model
   * @param packURI a non-null String
   * @return a potentially null Package
   */
  private Package getLibraryPackage(Model model, String packURI_p) {
    Resource res = model.eResource().getResourceSet().getResource(URI.createURI(packURI_p), true);
    EObject obj = res.getContents().get(0);
    if(obj instanceof Package)
      return (Package)obj;
    return null;
  }

  /**
   * Returns true when the given package import is already imported by the given model.
   * @param model_p a non-null Model
   * @param pack_p a non-null String
   */
  private boolean hasPackageImport(Model model_p, Package pack_p) {
    Iterator<Package> it = model_p.getImportedPackages().iterator();
    while(it.hasNext()){
      Package pack = it.next();
      if(pack.getURI().toString().equals(pack_p.getURI().toString())){
        return true;
      }
    }
    return false;
  }

  /**
   * Says if the given diagram is of a type that is automatically redrawn. 
   */
  public boolean isAutomaticallyUpdatedDiagram(Object diagram_p) {
    if(diagram_p instanceof SequenceDDiagram)
      return true;
    return false;
  }

}
