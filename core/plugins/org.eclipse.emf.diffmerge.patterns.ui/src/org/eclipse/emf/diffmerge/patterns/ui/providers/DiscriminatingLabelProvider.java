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
package org.eclipse.emf.diffmerge.patterns.ui.providers;

import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementRelativeLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.diagrams.misc.UnresolvedPattern;
import org.eclipse.emf.diffmerge.patterns.diagrams.misc.UnresolvedRepository;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.PatternsDiagramsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.TemplatePatternsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternData;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin.ImageID;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.TemplateUsageDialog;
import org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


/**
 * A simple label provider which, if no label can be found, provides a basic
 * label guaranteeing that label is not null and discriminating w.r.t. other elements.
 * @author Olivier Constant
 */
public class DiscriminatingLabelProvider extends LabelProvider {
  
  /** The shared instance */
  private static DiscriminatingLabelProvider __instance;
  
  /**
   * Getter for singleton pattern
   */
  public static DiscriminatingLabelProvider getInstance() {
    if (null == __instance)
      __instance = new DiscriminatingLabelProvider();
    return __instance;
  }
  
  /**
   * Return a label for the given pattern
   * @param pattern_p a non-null pattern
   * @return a non-null string
   */
  private String getPatternText(IPattern pattern_p) {
    return (pattern_p.isTemplate()? Messages.DiscriminatingLabelProvider_Template: "") +  //$NON-NLS-1$
      pattern_p.getName();
  }
  
  /**
   * Return a label for the given pattern instance
   * @param instance_p a non-null pattern instance
   * @return a non-null string
   */
  private String getPatternInstanceText(IPatternInstance instance_p) {
    StringBuilder builder = new StringBuilder();
    builder.append(Messages.DiscriminatingLabelProvider_Instance);
    IPatternVersion version = instance_p.getPatternVersion();
    if (version != null) {
      String versionText = version.getVersion();
      if (versionText != null) {
        builder.append(" v"); //$NON-NLS-1$
        builder.append(versionText);
      }
    }
    builder.append(" ("); //$NON-NLS-1$
    List<EObject> mergeTargets = new FOrderedSet<EObject>();
    List<EObject> additionTargets = new FOrderedSet<EObject>();
    // Gathering role elements
    for (ILocation location : instance_p.getLocations()) {
      for (IAtomicLocation atomicLocation : location.getAtomicContents()) {
        if (atomicLocation instanceof IElementRelativeLocation) {
          EObject element = ((IElementRelativeLocation)atomicLocation).getElement();
          if (element != null) {
            if (atomicLocation.supportsMerge())
              mergeTargets.add(element);
            else
              additionTargets.add(element);
          }
        }
      }
    }
    if (mergeTargets.isEmpty()) {
      // Gathering instance elements
      TemplatePatternData data = TemplatePatternsUtil.getPatternData(instance_p);
      if (data != null)
        mergeTargets = ModelsUtil.getRoots(data.getInstanceElements());
    }
    // Building description from elements
    if (!mergeTargets.isEmpty()) {
      builder.append(getText(mergeTargets.iterator().next()));
      if (mergeTargets.size() > 1)
        builder.append(", ..."); //$NON-NLS-1$
    } else if (!additionTargets.isEmpty()) {
      builder.append(Messages.DiscriminatingLabelProvider_In);
      builder.append(' ');
      builder.append(getText(additionTargets.iterator().next()));
      if (additionTargets.size() > 1)
        builder.append(", ..."); //$NON-NLS-1$
    }
    builder.append(')');
    return builder.toString();
  }
  
  /**
   * Return a label for the given pattern repository
   * @param repository_p a non-null pattern repository
   * @return a non-null string
   */
  private String getPatternRepositoryText(IPatternRepository repository_p) {
    StringBuilder builder = new StringBuilder();
    if (repository_p instanceof PatternRepository) {
      builder.append(((PatternRepository)repository_p).getName());
      builder.append("  ["); //$NON-NLS-1$
      builder.append(
          PatternsDiagramsUtil.getPath(((PatternRepository)repository_p).getPath()));
      builder.append("]"); //$NON-NLS-1$
    } else {
      builder.append(Messages.DiscriminatingLabelProvider_Catalog);
      builder.append(' ');
      builder.append(repository_p.getId());
    }
    return builder.toString();
  }
  
  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getText(Object)
   */
  @Override
  public String getText(Object element_p) {
    String result = null;
    if (element_p == TemplateUsageDialog.EMPTY_ELEMENT)
      result = Messages.DiscriminatingLabelProvider_Empty;
    else if (element_p == TemplateUsageDialog.FAILURE_ELEMENT)
      result = Messages.DiscriminatingLabelProvider_Failure;
    else if (element_p instanceof IPattern)
      result = getPatternText((IPattern)element_p);
    else if (element_p instanceof IPatternInstance)
      result = getPatternInstanceText((IPatternInstance)element_p);
    else if (element_p instanceof IPatternRepository)
      result = getPatternRepositoryText((IPatternRepository)element_p);
    else if (element_p instanceof EObject){
      IModelEnvironmentUI me = PatternsUIPlugin.getDefault().getModelEnvironmentUI();
      result = me.getText(element_p);
    }if (result == null || result.length() == 0)
      result = element_p.toString();
    if (result != null)
      result = result.replaceAll("%20", " ");  //$NON-NLS-1$//$NON-NLS-2$
    return result;
  }
  
  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getImage(Object)
   */
  @Override
  public Image getImage(Object element_p) {
    Image result = null;
    if (element_p == TemplateUsageDialog.FAILURE_ELEMENT)
      result = PlatformUI.getWorkbench().getSharedImages().getImage(
          ISharedImages.IMG_TOOL_DELETE);
    else if (element_p instanceof IPatternRepository ||
        element_p instanceof UnresolvedRepository)
      result = PatternsUIPlugin.getDefault().getImage(ImageID.CATALOG);
    else if (element_p instanceof IPattern ||
        element_p instanceof UnresolvedPattern)
      result = PatternsUIPlugin.getDefault().getImage(ImageID.PATTERN);
    else if (element_p instanceof IPatternInstance)
      result = PatternsUIPlugin.getDefault().getImage(ImageID.INSTANCE);
    else if (element_p instanceof EObject){
      IModelEnvironmentUI me = PatternsUIPlugin.getDefault().getModelEnvironmentUI();
      result = me.getImage(element_p);
    }
    return result;
  }

}
