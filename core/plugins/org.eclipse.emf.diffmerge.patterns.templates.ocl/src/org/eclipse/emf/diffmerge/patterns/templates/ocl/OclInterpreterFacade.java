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
package org.eclipse.emf.diffmerge.patterns.templates.ocl;

import java.util.Collection;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.patterns.templates.ocl.interpreter.OclInterpreter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.ocl.ParserException;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IPatternConformityStatus;
import org.eclipse.emf.diffmerge.patterns.core.api.status.SimpleStatus;
import org.eclipse.emf.diffmerge.patterns.core.util.ModelsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ITextualLanguageInterpreterFacade;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule;


/**
 * An OCL interpreter for textual specifications in the context of a template pattern.
 * @author Olivier Constant
 */
public class OclInterpreterFacade implements ITextualLanguageInterpreterFacade {
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ITextualLanguageInterpreterFacade#checkElement(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleConstraint, org.eclipse.emf.ecore.EObject)
   */
  public IPatternConformityStatus checkElement(TextualRoleConstraint constraint_p, EObject element_p) {
    IPatternConformityStatus result = SimpleStatus.SUCCESS;
    try {
      OclInterpreter interpreter = OclPatternsPlugin.getDefault().getInterpreter();
      boolean satisfied = interpreter.check(constraint_p.getSpecification(), element_p, constraint_p.getRole());
      if (satisfied) {
        result = new SimpleStatus(true, constraint_p.getSpecification());
      } else {
        String name = constraint_p.getRole().getName();
        String details = constraint_p.getRole().getDescription();
        if (details == null || details.length() == 0)
          details = constraint_p.getSpecification();
        result = new SimpleStatus(false,
            String.format(Messages.OclInterpreterFacade_ConstraintViolation, name, details));
      }
    } catch (ParserException e) {
      result = new SimpleStatus(false, Messages.OclFacade_ParsingError + constraint_p.getSpecification());
    } catch (Exception e) {
      // Keep default status
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ITextualLanguageInterpreterFacade#deriveCandidateElements(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TextualRoleDerivationRule, org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication)
   */
  public EList<EObject> deriveCandidateElements(TextualRoleDerivationRule rule_p,
      IPatternApplication context_p) {
    EList<EObject> result = null;
    try {
      OclInterpreter interpreter = OclPatternsPlugin.getDefault().getInterpreter();
      EObject context;
      if (context_p.getScopeElement() instanceof EObject)
        context = (EObject)context_p.getScopeElement();
      else
        context = null;
      Object eval = interpreter.evaluate(
          rule_p.getSpecification(), context, rule_p.getRole(), context_p);
      if (eval != null) {
        result = new ModelsUtil.ROrderedSet<EObject>();
        Collection<Object> evalCollection = new ModelsUtil.ROrderedSet<Object>();
        if (eval instanceof Collection<?>)
          evalCollection.addAll((Collection<?>)eval);
        else
          evalCollection.add(eval);
        for (Object obj : evalCollection) {
          if (obj instanceof EObject && !(obj instanceof DynamicEObjectImpl))
            result.add((EObject)obj);
        }
        result = ECollections.unmodifiableEList(result);
      }
    } catch (Exception e) {
      // Keep default result
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ITextualLanguageInterpreterFacade#getLanguage()
   */
  public String getLanguage() {
    return OclPatternsPlugin.getDefault().getLanguage();
  }
  
}
