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
package org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IDeleteOperationProvider;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.ModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.PatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.Messages;
import org.eclipse.emf.diffmerge.patterns.templates.engine.NamingUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsEnginePlugin;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.TemplatePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelImplUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;


/**
 * A comparison specifically tailored for comparing template patterns and
 * their applications in models. It supports multi-merge.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class TemplatePatternApplicationComparison extends TemplatePatternComparison {

  /** The non-null pattern application to compare */
  private final IPatternApplication _application;

  /** The non-null match policy */
  private TemplatePatternMatchPolicy _matchPolicy;

  /** The non-null diff policy */
  private final TemplatePatternDiffPolicy _diffPolicy;

  /** The non-null merge policy */
  private final TemplatePatternMergePolicy _mergePolicy;

  /** The set of non-main multiparts */
  private List<String> _multiparts;

  /** An iterator on the multiparts */
  private Iterator<String> _multipartsIterator;

  /** The optional current multipart */
  private String _currentMultipart;

  /**
   * Constructor
   * @param pattern_p a non-null template pattern
   * @param application_p a non-null pattern application
   * @param ignoredFeatures_p a non-null set of features to ignore
   */
  public TemplatePatternApplicationComparison(TemplatePattern pattern_p,
      IPatternApplication application_p,
      List<EStructuralFeature> ignoredFeatures_p) {
    this(pattern_p, application_p, ignoredFeatures_p, null);
  }

  /**
   * Constructor
   * @param pattern_p a non-null template pattern
   * @param application_p a non-null pattern application
   * @param ignoredFeatures_p a non-null set of features to ignore
   * @param multipart_p an optional multipart ID
   */
  public TemplatePatternApplicationComparison(TemplatePattern pattern_p,
      IPatternApplication application_p,
      List<EStructuralFeature> ignoredFeatures_p,
      String multipart_p) {
    this(pattern_p,
        new TemplatePatternApplicationScope(application_p, multipart_p),
        ignoredFeatures_p);
  }

  /**
   * Constructor
   * @param pattern_p a non-null template pattern
   * @param applicationScope_p a non-null pattern application scope
   * @param ignoredFeatures_p a non-null set of features to ignore
   */
  public TemplatePatternApplicationComparison(TemplatePattern pattern_p,
      TemplatePatternApplicationScope applicationScope_p,
      List<EStructuralFeature> ignoredFeatures_p) {
    super(pattern_p, new TemplatePatternContentScope(pattern_p),
        applicationScope_p);
    _application = applicationScope_p.getApplication();
    _matchPolicy = new TemplatePatternMatchPolicy(this, AdapterFactoryEditingDomain.getEditingDomainFor(pattern_p),
        AdapterFactoryEditingDomain.getEditingDomainFor(applicationScope_p.getApplication().getScopeElement()));
    _diffPolicy = new TemplatePatternDiffPolicy(ignoredFeatures_p);
    _mergePolicy = new TemplatePatternMergePolicy();
    _currentMultipart = applicationScope_p.getMultipart();
    _multiparts = null;
    _multipartsIterator = null;
    TemplatePatternData data = getPatternData();
    if (_currentMultipart == null && data != null) {
      _multiparts = new UniqueEList<String>(data.getMultiparts());
      _multipartsIterator = _multiparts.iterator();
    }
    ISemanticRuleProvider ruleProvider =  
        TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(
            _application.getScopeElement());
    ruleProvider.initializeTargetScope(
        getScope(getPatternRole()), getScope(getApplicationRole()));
  }

  /**
   * Return a status about the conformity of the application w.r.t. its pattern,
   * based on a match/diff method
   * @return a non-null status
   */
  public IPatternConformityStatus checkConformity() {
    IStatus status = null;
    PatternConformityStatus result = new PatternConformityStatus(0, 0);
    do {
      if (hasMultiparts())
        setCurrentMultipart(_multipartsIterator.next());
      status = compute();
      int allPresences = getRemainingDifferences().size();
      int patternPresences = getPresencesInPattern().size();
      result.addMissingValues(patternPresences);
      result.addExtraValues(allPresences - patternPresences);
    } while (hasNextMultipart() && (status == null || status.isOK()));
    result.freeze();
    return result;
  }

  /**
   * Compute differences according to match/diff/merge rules for template patterns,
   * only on the current part for multi-part comparison
   * @return a non-null status
   */
  public IStatus compute() {
    IStatus result = compute(_matchPolicy, _diffPolicy, _mergePolicy, null);
    return result;
  }

  /**
   * Return a failure status with a convenient message built from the given Eclipse status
   * @param status_p a non-null Eclipse status
   * @return a non-null status
   */
  private SimpleStatus createFailureStatus(IStatus status_p) {
    return new SimpleStatus(false,
        Messages.TemplatePatternComparison_FailureAnnouncement + status_p.getMessage());
  }

  /**
   * Incrementally update the data of the application according to the current mapping,
   * if applicable
   */
  public void extendPatternData() {
    TemplatePatternData data = getPatternData();
    if (data != null) {
      // Only take the last changes because we can be multipart
      Collection<IMatch> updatedMatches = getLastUpdatedMatches();
      for (IMatch match : updatedMatches) {
        EObject instanceElement = match.get(getApplicationRole());
        EObject templateElement = match.get(getPatternRole());
        String mappingMultipart = getMainMultipart();
        if (!getPattern().isUnique(templateElement) && getCurrentMultipart() != null)
          mappingMultipart = getCurrentMultipart();
        data.map(instanceElement, templateElement, mappingMultipart);
        data.markAsUnfolded(instanceElement);
      }
    }
  }

  /**
   * Return the comparison role corresponding to the application
   * @return a non-null role
   */
  public static Role getApplicationRole() {
    return getPatternRole().opposite();
  }

  /**
   * Return the application scope
   * @return a non-null scope
   */
  protected TemplatePatternApplicationScope getApplicationScope() {
    return (TemplatePatternApplicationScope)getScope(getApplicationRole());
  }

  /**
   * Return the multipart ID being currently considered
   * @return a potentially null string
   */
  public String getCurrentMultipart() {
    return _currentMultipart;
  }

  /**
   * Return the ID of the main multipart
   * @return a non-null string
   */
  public String getMainMultipart() {
    return TemplatePatternsPlugin.getDefault().getEngine().getMainMultipart();
  }

  /**
   * Return a suffix for naming elements added in the context of the current multipart, if any
   * @return a potentially null string
   */
  private String getMultipartSuffix() {
    String result = null;
    String multipart = getCurrentMultipart();
    if (multipart != null && !getMainMultipart().equals(multipart)) {
      int position = _multiparts.indexOf(multipart) + 1;
      result = " " + String.valueOf(position); //$NON-NLS-1$
    }
    return result;
  }

  /**
   * Return the pattern data of the application, if any
   * @return potentially null data
   */
  public TemplatePatternData getPatternData() {
    return TemplatePatternsUtil.getPatternData(_application);
  }

  /**
   * Return the differences corresponding to an unmatched presence on the pattern side
   * @return a non-null, potentially empty, unmodifiable list
   */
  private List<IDifference> getPresencesInPattern() {
    return getDifferences(getPatternRole());
  }

  /**
   * Return the first role whose root template elements contain the given element
   * @param element_p a potentially null element
   * @return a potentially null role
   */
  private TemplatePatternRole getRoleOf(EObject element_p) {
    if (element_p != null) {
      for (TemplatePatternRole role : getPattern().getRoles()) {
        if (role.getTemplateElements().contains(element_p))
          return role;
      }
    }
    return null;
  }

  /**
   * Return whether this comparison is multi-merge
   */
  public boolean hasMultiparts() {
    return _multipartsIterator != null && !_multiparts.isEmpty();
  }

  /**
   * Set the current multipart of the comparison
   * @param multipart_p a potentially null string
   */
  public void setCurrentMultipart(String multipart_p) {
    clear();
    _currentMultipart = multipart_p;
    getApplicationScope().setMultipart(_currentMultipart);
  }

  /**
   * Set a storage for the given root element of the application scope,
   * if specified by the role binding
   * @param root_p a non-null root of the application scope
   */
  private void storeRootWithRole(EObject root_p) {
    IMatch match = getMapping().getMatchFor(root_p, getApplicationRole());
    EObject original = match.get(getPatternRole());
    TemplatePatternRole role = getRoleOf(original);
    if (role != null && role.acceptsAddition()) {
      ILocation location = _application.getLocation(role);
      if (location instanceof IReferenceLocation) {
        IReferenceLocation refLocation = (IReferenceLocation)location;
        if (refLocation.getReference().isContainment()) {
          LocationsUtil.add(refLocation, root_p);
        }
      }
    }
  }

  /**
   * Update the application so that it conforms to its pattern
   * @param destructive_p whether elements and values can be deleted
   * @return a non-null status
   */
  public IModelTransformationStatus updateApplication(boolean destructive_p) {
    IStatus status = null;
    boolean hadDifferences = false;
    Collection<EObject> additions = new FOrderedSet<EObject>();
    Collection<IDifference> merges = new FOrderedSet<IDifference>();
    int nbCandidateChanges = 0;
    int nbChangesMade = 0;
    // Updating application, one step per multipart
    do {
      if (hasMultiparts())
        setCurrentMultipart(_multipartsIterator.next());
      status = compute();
      Collection<IDifference> presencesInPattern = destructive_p? getRemainingDifferences():
        getPresencesInPattern();
      if (!presencesInPattern.isEmpty()) {
        hadDifferences = true;
        merges.clear();
        nbCandidateChanges += getNbDifferences();
        boolean stepSuccessful = updateModelStep(destructive_p, additions, merges);
        nbChangesMade += merges.size();
        if (stepSuccessful)
          extendPatternData();
        else
          status = Status.CANCEL_STATUS;
      }
    } while (hasNextMultipart() && (status == null || status.isOK()));
    // Using business delete command for removing deleted elements
    Collection<EObject> toDelete = getApplicationScope().getDeletedElements();
    if (!toDelete.isEmpty()) {
      IDeleteOperationProvider deleteProvider =
          CorePatternsPlugin.getDefault().getDeleteOperationProvider();
      IModelOperation<IModelTransformationStatus> op =
          deleteProvider.getDeleteOperation(toDelete, true, true, toDelete);
      CorePatternsPlugin.getDefault().getModelEnvironment().execute(op);
    }
    //Post addition treatment(for example, for UMLDesigner, add library imports)
    ISemanticRuleProvider ruleProvider = null;
    if(_application.getScopeElement()!= null){
      ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(_application.getScopeElement());
      ruleProvider.postPatternApplication(_application, additions, merges);
    }
    // Making detailed status
    IModelTransformationStatus result;
    if (status.isOK()) {
      if (hadDifferences) {
        ModelTransformationStatus mts = new ModelTransformationStatus(true, false, "", true); //$NON-NLS-1$
        mts.getAddedElements().addAll(additions);
        mts.getDeletedElements().addAll(getApplicationScope().getDeletedElements());
        mts.setNbCandidateChanges(nbCandidateChanges);
        mts.setNbChangesMade(nbChangesMade);
        mts.freeze();
        result = mts;
      } else {
        result = new SimpleStatus(true, Messages.TemplatePatternEngine_AlreadyConforms);
      }
    } else if (status.matches(IStatus.CANCEL)) {
      ModelTransformationStatus mtStatus = new ModelTransformationStatus(false, false, "", true); //$NON-NLS-1$
      mtStatus.setAborted(true);
      mtStatus.freeze();
      result = mtStatus;
    } else {
      result = createFailureStatus(status);
    }
    return result;
  }

  /**
   * Return whether this comparison has remaining multiparts
   */
  private boolean hasNextMultipart() {
    return _multipartsIterator != null && _multipartsIterator.hasNext();
  }

  /**
   * Update the application by merge based on the current mapping
   * @param destructive_p whether elements and values can be deleted
   * @param additions_p a modifiable collection where added elements have to be stored
   * @param merges_p a modifiable collection where merged differences have to be stored
   * @return whether the operation succeeded
   */
  private boolean updateModelStep(boolean destructive_p, Collection<EObject> additions_p,
      Collection<IDifference> merges_p) {
    boolean result = true;
    Collection<IDifference> initialDifferences =
        destructive_p? getRemainingDifferences(): getPresencesInPattern();
        Collection<IDifference> mergedDifferences =
            merge(initialDifferences, getApplicationRole(), true, null);
        merges_p.addAll(mergedDifferences);
        // Store elements added according to addition roles and semantic rules
        List<EObject> unstored = new FOrderedSet<EObject>();
        ISemanticRuleProvider ruleProvider = null;
        if(_application.getScopeElement()!= null)
          ruleProvider = TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(_application.getScopeElement());

        for (EObject root : getScope(getApplicationRole()).getContents()) {
          if (ruleProvider != null && !ruleProvider.isAllowedToBeRoot(root)) {
            // First attempt: use role
            if (root.eContainer() == null)
              storeRootWithRole(root);
            // Second check: remember to store later
            if (root.eContainer() == null)
              unstored.add(root);
          }
        }
        if (!unstored.isEmpty()) {
          Object context = _application.getScopeElement();
          ISemanticRuleProvider semanticRuleProvider =
              TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(context);
          Boolean enforcementResult = semanticRuleProvider.enforceOwnership(unstored, context);
          result = enforcementResult != null && enforcementResult.booleanValue();
        }
        if (result) {
          String suffix = getMultipartSuffix();
          for (IMatch addMatch : getMapping().getCompletedMatches(getApplicationRole())) {
            EObject added = addMatch.get(getApplicationRole());
            // Enforce ID registration (MelodymodellerResourceImpl overrides getEObjectByID(String)!)
            ModelImplUtil.setXMLID(added, EcoreUtil.getID(added));
            additions_p.add(added);
            if (suffix != null) {
              String name = NamingUtil.getName(added);
              if (name != null)
                NamingUtil.setName(added, name + suffix);
            }
          }
        }
        return result;
  }

}
