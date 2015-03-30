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
package org.eclipse.emf.diffmerge.patterns.templates.engine;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.api.IMatch;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IDeleteOperationProvider;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IRoleApplicabilityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.operations.InstanceOperation;
import org.eclipse.emf.diffmerge.patterns.core.util.BasicModelUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternApplicationComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.diffmerge.TemplatePatternUpdateComparison;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ITextualLanguageInterpreterFacade;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplatePatternUpdateSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.AbstractRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;
import org.eclipse.emf.diffmerge.util.structures.FOrderedSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;


/**
 * An engine for template patterns which is based on the Melody Diff/Merge engine.
 * An instance of this class may be used several times on different instances.
 * @author Olivier Constant
 */
public class TemplatePatternEngine implements ITemplatePatternEngine {

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#checkAtomicAdditionApplicability(org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation, org.eclipse.emf.ecore.EObject)
   */
  public IRoleApplicabilityStatus checkAtomicAdditionApplicability(
      IAtomicLocation location_p, EObject rootTemplateElement_p) {
    IRoleApplicabilityStatus result;
    if (location_p instanceof IReferenceLocation) {
      IReferenceLocation containmentLocation = (IReferenceLocation)location_p;
      ISemanticRuleProvider ruleProvider =
          TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(
              containmentLocation.getElement());
      if (ruleProvider.supportsAdditionOf(containmentLocation.getElement(),
          containmentLocation.getReference(), rootTemplateElement_p, true))
        result = SimpleStatus.SUCCESS;
      else
        result = new SimpleStatus(false,
            Messages.TemplatePatternEngine_WrongTypeForAddition);
    } else {
      // Resource location
      result = SimpleStatus.SUCCESS;
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#checkAtomicMergeApplicability(org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation, org.eclipse.emf.ecore.EObject)
   */
  public IRoleApplicabilityStatus checkAtomicMergeApplicability(
      IElementRelativeLocation location_p, EObject rootTemplateElement_p) {
    IRoleApplicabilityStatus result;
    EObject modelRootElement = location_p.getElement();
    if (modelRootElement != null && rootTemplateElement_p != null && modelRootElement.eClass() == rootTemplateElement_p.eClass())
      result = SimpleStatus.SUCCESS;
    else
      result = new SimpleStatus(false,
          Messages.TemplatePatternEngine_WrongTypeForMerge);
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#checkConformance(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern, org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   */
  public IPatternConformityStatus checkConformance(TemplatePattern pattern_p,
      IPatternApplication application_p, List<EStructuralFeature> ignoredFeatures_p) {
    IPatternConformityStatus result =
        checkRoleConstraints(pattern_p, application_p);
    if (result.isOk()) {
      TemplatePatternApplicationComparison comparison =
          new TemplatePatternApplicationComparison(pattern_p, application_p, ignoredFeatures_p);
      result = comparison.checkConformity();
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#checkConstraint(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint, org.eclipse.emf.ecore.EObject)
   */
  public IPatternConformityStatus checkConstraint(TextualRoleConstraint constraint_p,
      EObject element_p) {
    ITextualLanguageInterpreterFacade facade =
        TemplatePatternsEnginePlugin.getDefault().getLanguageFacadeFor(constraint_p.getLanguage());
    IPatternConformityStatus result;
    if (facade != null) {
      result = facade.checkElement(constraint_p, element_p);
    } else {
      result = getNoInterpreterStatus(constraint_p.getLanguage());
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#checkConstraintOnCollection(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint, java.util.Collection)
   */
  public IPatternConformityStatus checkConstraintOnCollection(TextualRoleConstraint constraint_p,
      Collection<? extends EObject> elements_p) {
    IPatternConformityStatus result = SimpleStatus.SUCCESS;
    for (EObject element : elements_p) {
      result = checkConstraint(constraint_p, element);
      if (result == null || !result.isOk()) {
        String label = getText(element);
        if (label != null) {
          result = new SimpleStatus(false, result.getDescription() + " (" + label + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        break;
      }
    }
    return result;
  }

  /**
   * Check the constraints of the roles of the given pattern on the given application
   * @param pattern_p a non-null template pattern
   * @param application_p a non-null application of that pattern
   * @return a non-null status
   */
  private IPatternConformityStatus checkRoleConstraints(TemplatePattern pattern_p,
      IPatternApplication application_p) {
    for (TemplatePatternRole role : pattern_p.getRoles()) {
      ILocation location = null;
      if (application_p instanceof IPatternInstance &&
          ((IPatternInstance)application_p).getPatternData() instanceof TemplatePatternData) {
        TemplatePatternData data = (TemplatePatternData)((IPatternInstance)application_p).getPatternData();
        location = new BasicElementMappingLocation();
        for (EObject templateElement : role.getTemplateElements()) {
          EObject instanceElement = data.getCounterpart(templateElement, true);
          if (instanceElement != null)
            ((BasicElementMappingLocation)location).map(templateElement, instanceElement);
        }
      } else {
        location = application_p.getLocation(role);
      }
      for (AbstractRoleConstraint constraint : role.getConstraints()) {
        IPatternConformityStatus status = constraint.check(location);
        if (!status.isOk())
          return status;
      }
    }
    return SimpleStatus.SUCCESS;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#createPatternData(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance)
   */
  public TemplatePatternData createPatternData(TemplatePattern pattern_p,
      IPatternInstance instance_p, Object context_p) {
    // Create main data element
    TemplatePatternData result = TemplatepatternsFactory.eINSTANCE.createTemplatePatternData();
    if (instance_p instanceof AbstractPatternInstance)
      ((AbstractPatternInstance)instance_p).setPatternData(result);
    // Add complete trace information if available (pattern creation/update)
    IModifiableTemplatePatternSpecification traces =
        TemplatePatternsEnginePlugin.getDefault().getLastPatternCreationData();
    if (traces != null) {
      if (instance_p instanceof AbstractPatternInstance)
        ((AbstractPatternInstance)instance_p).setFolded(false);
      Iterator<EObject> it = traces.getModelScope().getAllContents();
      while (it.hasNext()) {
        EObject instanceElement = it.next();
        EObject templateElement = traces.getCounterpart(instanceElement, false);
        result.map(instanceElement, templateElement, getMainMultipart());
        if (!playsARole(templateElement, pattern_p))
          result.markAsUnfolded(instanceElement);
      }
      TemplatePatternsEnginePlugin.getDefault().clearTraces();
    } else {
      setupPatternDataFromApplication(instance_p, result, context_p);
    }
    result.setNamingRule(NamingUtil.getNeutralRenamingRule());
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#deriveCandidateElements(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule, org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   */
  public EList<EObject> deriveCandidateElements(TextualRoleDerivationRule rule_p,
      IPatternApplication context_p) {
    ITextualLanguageInterpreterFacade facade =
        TemplatePatternsEnginePlugin.getDefault().getLanguageFacadeFor(rule_p.getLanguage());
    EList<EObject> result;
    if (facade != null) {
      result = facade.deriveCandidateElements(rule_p, context_p);
    } else {
      result = null;
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#fold(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance)
   */
  public IModelTransformationStatus fold(TemplatePattern pattern_p,
      IPatternInstance instance_p) {
    IModelTransformationStatus result = SimpleStatus.SUCCESS;
    TemplatePatternData data = TemplatePatternsUtil.getPatternData(instance_p);
    if (data != null) {
      // Build the list of the elements to delete
      Collection<EObject> toDelete = new FOrderedSet<EObject>();
      for (EObject candidate : data.getInstanceElements()) {
        if (data.wasUnfolded(candidate))
          toDelete.add(candidate);
      }
      if (toDelete.isEmpty()) {
        result = new SimpleStatus(true, true, Messages.TemplatePatternEngine_FoldNotNeeded);
        data.clearUnfolded();
      } else {
        // Delete the elements
        IDeleteOperationProvider provider =
            CorePatternsPlugin.getDefault().getDeleteOperationProvider();
        IModelOperation<IModelTransformationStatus> deleteOperation =
            provider.getDeleteOperation(toDelete, false, false, data.getScopeElement());
        result = deleteOperation.run(null);
        if (result.isOk() && !result.hasWarnings())
          // Update pattern data
          data.clearUnfolded();
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#getMainMultipart()
   */
  public String getMainMultipart() {
    return "MAIN"; //$NON-NLS-1$
  }

  /**
   * Return a status representing failure due to inability to retrieve an interpreter
   * @param language_p a non-null language name
   * @return a non-null failed status
   */
  private SimpleStatus getNoInterpreterStatus(String language_p) {
    return new SimpleStatus(false,
        String.format(Messages.TemplatePatternEngine_NoInterpreter, language_p));
  }

  /**
   * Return a label for the given element
   * @param element_p a non-null element
   * @return a potentially null string
   */
  private String getText(EObject element_p) {
    String result = null;
    EditingDomain rawEditingDomain =
        CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain(element_p);
    if (rawEditingDomain instanceof AdapterFactoryEditingDomain) {
      AdapterFactoryEditingDomain editingDomain = (AdapterFactoryEditingDomain)rawEditingDomain;
      IItemLabelProvider provider = (IItemLabelProvider)editingDomain.getAdapterFactory().adapt(
          element_p, IItemLabelProvider.class);
      if (provider != null)
        result = provider.getText(element_p);
    }
    return result;
  }

  /**
   * Return whether the given naming rule is relevant for application onto unfolded elements
   * @param namingRule_p a potentially null string
   */
  private boolean isRelevantNamingRule(String namingRule_p) {
    return namingRule_p != null && namingRule_p.length() > 0 &&
        !NamingUtil.getNeutralRenamingRule().equals(namingRule_p);
  }

  /**
   * Return whether the given template element plays a role in the given pattern 
   * @param templateElement_p a non-null element
   * @param pattern_p a non-null pattern
   */
  private boolean playsARole(EObject templateElement_p, TemplatePattern pattern_p) {
    for (TemplatePatternRole role : pattern_p.getRoles()) {
      if (role.getTemplateElements().contains(templateElement_p))
        return true;
    }
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#unfold(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance)
   */
  public IModelTransformationStatus unfold(TemplatePattern pattern_p,
      IPatternInstance instance_p) {
    BasicModelUpdateSpecification specification = new BasicModelUpdateSpecification();
    ISemanticRuleProvider ruleProvider =
        TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(null);
    if (ruleProvider != null){
      List<EStructuralFeature> features = ruleProvider.getDefaultOptionalMergeFeatures();
      for(EStructuralFeature feature : features){
        specification.getFeaturesToIgnore().add(feature);
      }
    }
    return updateModel(pattern_p, instance_p, specification);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#updateModel(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern, org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, org.eclipse.emf.diffmerge.patterns.core.api.IPattern.IModelUpdateSpecification)
   */
  public IModelTransformationStatus updateModel(TemplatePattern pattern_p,
      IPatternInstance instance_p, IPattern.IModelUpdateSpecification specification_p) {
    TemplatePatternApplicationComparison comparison =
        new TemplatePatternApplicationComparison(pattern_p, instance_p, specification_p.getFeaturesToIgnore());
    IModelTransformationStatus result = comparison.updateApplication(specification_p.isDestructive());
    if (result.isOk()) {
      // Version
      IPatternVersion instanceVersion = instance_p.getPatternVersion();
      if (instanceVersion instanceof PatternVersion) {
        ((PatternVersion)instanceVersion).setVersion(pattern_p.getVersion());
      }
      // Naming rule
      String namingRule = null;
      TemplatePatternData data = TemplatePatternsUtil.getPatternData(instance_p);
      if (data != null)
        namingRule = (data.getNamingRule());
      if (isRelevantNamingRule(namingRule))
        renameElements(instance_p, result.getAddedElements(), namingRule, false);
    }
    return result;
  }

  /**
   * Setup the given template pattern data according to the locations of the given application
   * @param application_p a non-null application
   * @param data_p a non-null template pattern data
   */
  private void setupPatternDataFromApplication(IPatternApplication application_p,
      TemplatePatternData data_p, Object context_p) {
    // Just use the role mapping (simple pattern application)
    IPattern pattern = application_p.getPattern();
    if(pattern != null){
      EditingDomain medt = AdapterFactoryEditingDomain.getEditingDomainFor(context_p);
      for (IPatternRole pRole : pattern.getRoles()) {
        if (pRole instanceof TemplatePatternRole) {
          TemplatePatternRole role = (TemplatePatternRole)pRole;
          ILocation location = application_p.getLocation(role);
          if (location != null) {
            List<? extends IAtomicLocation> atomicLocations = location.getAtomicContents();
            for (IAtomicLocation atomicLocation : atomicLocations) {
              if (atomicLocation instanceof IElementLocation) {
                EObject modelElement = ((IElementLocation)atomicLocation).getElement(context_p);
                EObject templateElement = role.getTemplateElements().get(0);
                String multipart = getMainMultipart();
                if (atomicLocations.size() > 1)
                  multipart = CorePatternsPlugin.getDefault().getIdProvider().getId(modelElement, medt);
                data_p.map(modelElement, templateElement, multipart);
              } else if (atomicLocation instanceof IElementMappingLocation) {
                IElementMappingLocation mappingLocation = (IElementMappingLocation)atomicLocation;
                final String multipart = getMainMultipart();
                for (EObject patternElement : mappingLocation.getPatternElements(pattern)) {
                  EObject modelElement = mappingLocation.getElement(patternElement);
                  if (modelElement != null)
                    data_p.map(modelElement, patternElement, multipart);
                }
              }
            }
          }
        }
      }
    }
  }

  /**
   * Update a pattern according to the given specification
   * @param specification_p a non-null specification of the update operation
   * @return a non-null comparison from the copy pattern of the update specification to the real pattern
   */
  public TemplatePatternUpdateComparison updatePattern(final TemplatePatternUpdateSpecification specification_p) {
    final TemplatePatternUpdateComparison comparison =
        new TemplatePatternUpdateComparison(specification_p);
    IStatus status = comparison.updatePattern();
    if (status.isOK()) {
      // Pattern version of instance
      InstanceOperation updateInstanceOperation = new InstanceOperation(specification_p.getInstance(), null, null, 
          specification_p.getInstance(), null){
        /**
         * @see org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation#run()
         */
        @Override
        protected IEvaluationStatus run() {
          extendPatternData();
          IPatternVersion instanceVersion = specification_p.getInstance().getPatternVersion();
          if (instanceVersion instanceof PatternVersion) {
            ((PatternVersion)instanceVersion).setVersion(
                specification_p.getOriginalPattern().getVersion());
            return new SimpleStatus(true, "Instance version updated"); //$NON-NLS-1$
          }
          return new SimpleStatus(false, "Couldn't update instance version"); //$NON-NLS-1$;
        }
        
        /**
         * Incrementally update the data of the instance according to the current mapping
         */
        @SuppressWarnings("static-access")
        private void extendPatternData() {
          TemplatePatternApplicationComparison applicationComparison =
              specification_p.getComparison();
          TemplatePatternData data = applicationComparison.getPatternData();
          Role applicationRole = TemplatePatternApplicationComparison.getApplicationRole();
          if (data != null) {
            Collection<IMatch> updatedMatches = applicationComparison.getUpdatedMatches();
            for (IMatch match : updatedMatches) {
              EObject instanceElement = match.get(applicationRole);
              EObject intermediateTemplateElement = match.get(comparison.getPatternRole());
              IMatch patternMatch = comparison.getMapping().getMatchFor(intermediateTemplateElement, applicationRole);
              if (patternMatch != null) {
                EObject templateElement = patternMatch.get(comparison.getPatternRole());
                String mappingMultipart = applicationComparison.getMainMultipart();
                if (!comparison.getPattern().isUnique(templateElement) &&
                    applicationComparison.getCurrentMultipart() != null)
                  mappingMultipart = applicationComparison.getCurrentMultipart();
                data.map(instanceElement, templateElement, mappingMultipart);
                data.markAsUnfolded(instanceElement);
              }
            }
          }
        }
      };
      IEvaluationStatus result = CorePatternsPlugin.getDefault().getModelEnvironment().execute(updateInstanceOperation);
      if (result.isOk()){
        //TODO : inform user?
      }
    }
    return comparison;
  }
  


  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.gen.ITemplatePatternEngine#renameElements(org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance, java.lang.String, boolean)
   */
  public void renameElements(IPatternInstance instance_p, String newNamingRule_p,
      boolean keepUserNames_p) {
    renameElements(instance_p, instance_p.getElements(), newNamingRule_p, keepUserNames_p);
  }

  /**
   * 
   * @param instance_p a non-null instance
   * @param elementsToRename_p a non-null, potentially empty collection
   * @param newNamingRule_p a potentially null string
   * @param keepUserNames_p whether non-conforming names must be preserved
   */
  private void renameElements(IPatternInstance instance_p,
      Collection<EObject> elementsToRename_p, String newNamingRule_p,
      boolean keepUserNames_p) {
    TemplatePatternData data = TemplatePatternsUtil.getPatternData(instance_p);
    if (data != null) {
      ISemanticRuleProvider ruleProvider =
          TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(instance_p.getScopeElement());
      Collection<EObject> toRename = ruleProvider.getElementsToRename(elementsToRename_p);
      if(toRename != null){
        for (EObject instanceElement : toRename) {
          String defaultName = null;
          if (instance_p.getPattern() != null) {
            EObject templateElement = data.getCounterpart(instanceElement, false);
            if (templateElement != null)
              defaultName = NamingUtil.getName(templateElement);
          }
          NamingUtil.applyRenamingRule(
              instanceElement, newNamingRule_p, keepUserNames_p, data.getNamingRule(), defaultName);
        }
      }
      data.setNamingRule(newNamingRule_p);
    }
  }

}
