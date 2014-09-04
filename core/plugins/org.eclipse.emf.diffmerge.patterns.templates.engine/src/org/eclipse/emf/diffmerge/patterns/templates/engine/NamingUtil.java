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
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAtomicLocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.IReferenceLocation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.ext.ISemanticRuleProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;


/**
 * A utility class related to the structure of models
 * @author Olivier Constant
 */
public final class NamingUtil {
  
  /** The neutral element of the renaming operation */
  private static final String NAMING_RULE_NEUTRAL = "$name$"; //$NON-NLS-1$
  
  /** The regular expression for matching the neutral element */
  private static final String NAMING_RULE_NEUTRAL_REGEX =
    java.util.regex.Pattern.quote(NAMING_RULE_NEUTRAL);
  
  /** The symbolic string representation of the index */
  private static final String INDEX_SYMBOL = "$nb$"; //$NON-NLS-1$
  
  /** The regular expression for matching the index symbol */
  private static final String INDEX_REGEX =
    java.util.regex.Pattern.quote(INDEX_SYMBOL);
  
  /** A default separator for suffixes */
  private static final String SUFFIX_SEP = "_"; //$NON-NLS-1$
  
  
  /**
   * Constructor
   */
  private NamingUtil() {
    // Forbids instantiation
  }
  
  /**
   * Return a variant of the given name which has been suffixed with the given int
   * @param name_p a non-null string
   * @param index_p any int
   * @return a non-null string
   */
  private static String appendIndexSuffix(String name_p, int index_p) {
    return name_p + SUFFIX_SEP + String.valueOf(index_p);
  }
  
  /**
   * Apply the given renaming rule on the given element
   * @param element_p a non-null element
   * @param renamingRule_p a non-null string
   * @return whether the operation succeeded
   */
  public static boolean applyRenamingRule(EObject element_p, String renamingRule_p) {
    boolean result = false;
    try {
      EAttribute nameAttribute = getNameAttribute(element_p);
      if (nameAttribute != null && element_p.eIsSet(nameAttribute)) {
        Object value = element_p.eGet(nameAttribute);
        if (value != null) {
          String formerName = String.valueOf(value);
          String newName = applyRenamingRule(formerName, renamingRule_p);
          element_p.eSet(nameAttribute, newName);
        }
      }
    } catch (Exception e) {
      // Failure: proceed
    }
    return result;
  }
  
  /**
   * Return an attribute of the given element which can be considered as a name, if any
   * @param element_p a potentially null element
   * @return a potentially null attribute
   */
  private static EAttribute getNameAttribute(EObject element_p) {
    EAttribute result = null;
    if (element_p != null) {
      ISemanticRuleProvider provider =
        TemplatePatternsEnginePlugin.getDefault().getSemanticRuleProviderFor(element_p);
      result = provider.getNameAttribute(element_p);
    }
    return result;
  }
  
  /**
   * Apply the given renaming rule on the given element
   * @param element_p a non-null element
   * @param renamingRule_p a non-null string
   * @param keepUserNames_p whether the name should only be changed if it conforms to the former rule
   * @param formerRenamingRule_p a potentially null string
   * @param defaultName_p the optional name to use if the current one does not conform
   *        to the former rule
   * @return whether the operation succeeded
   */
  public static boolean applyRenamingRule(EObject element_p, String renamingRule_p,
      boolean keepUserNames_p, String formerRenamingRule_p, String defaultName_p) {
    boolean result = true;
    try {
      EAttribute nameAttribute = getNameAttribute(element_p);
      if (nameAttribute != null && element_p.eIsSet(nameAttribute)) {
        Object value = element_p.eGet(nameAttribute);
        if (value != null) {
          String formerName = String.valueOf(value);
          String coreName = null;
          if (defaultName_p != null && formerRenamingRule_p != null) {
            String expectedFormerName =
              applyRenamingRule(defaultName_p, formerRenamingRule_p);
            if (!keepUserNames_p || formerName.equals(expectedFormerName))
              coreName = defaultName_p;
          } else {
            String prefix = getPrefix(formerRenamingRule_p);
            String suffix = getSuffix(formerRenamingRule_p);
            coreName = unapplyRenamingRule(formerName, prefix, suffix);
            if (coreName == null)
              coreName = defaultName_p;
          }
          if (coreName != null) {
            String newName = applyRenamingRule(coreName, renamingRule_p);
            element_p.eSet(nameAttribute, newName);
          }
        }
      }
    } catch (Exception e) {
      // Failure: proceed
    }
    return result;
  }
  
  /**
   * Apply the given renaming rule on the given name
   * @param name_p a non-null string
   * @param renamingRule_p a non-null string
   * @return a non-null string
   */
  private static String applyRenamingRule(String name_p, String renamingRule_p) {
    String result = renamingRule_p.replaceAll(NAMING_RULE_NEUTRAL_REGEX, name_p);
    return result;
  }
  
  /**
   * Return the string representation of the index symbol (multiple instantiations)
   * @return a non-null string
   */
  public static String getIndexSymbol() {
    return INDEX_SYMBOL;
  }
  
  /**
   * Return the name of the given element, whatever its meta-class
   * @param element_p a non-null element
   * @return a potentially null string
   */
  public static String getName(EObject element_p) {
    String result = null;
    EAttribute nameAttribute = getNameAttribute(element_p);
    if (nameAttribute != null && element_p.eIsSet(nameAttribute)) {
      Object value = element_p.eGet(nameAttribute);
      if (value != null)
        result = String.valueOf(value);
    }
    return result;
  }
  
  /**
   * Return a renaming rule which leaves names unchanged
   * @return a non-null string
   */
  public static String getNeutralRenamingRule() {
    return NAMING_RULE_NEUTRAL;
  }
  
  /**
   * Return the prefix of the given naming rule, if any
   * @param namingRule_p a potentially null string
   * @return a potentially null, non-empty string
   */
  private static String getPrefix(String namingRule_p) {
    String result = null;
    if (namingRule_p != null) {
      int start = namingRule_p.indexOf(NAMING_RULE_NEUTRAL);
      if (start > -1)
        result = namingRule_p.substring(0, start);
    }
    return result;
  }
  
  /**
   * Return the suffix of the given naming rule, if any
   * @param namingRule_p a potentially null string
   * @return a potentially null, non-empty string
   */
  private static String getSuffix(String namingRule_p) {
    String result = null;
    if (namingRule_p != null) {
      int start = namingRule_p.lastIndexOf(NAMING_RULE_NEUTRAL);
      int suffixStart = start + NAMING_RULE_NEUTRAL.length();
      if (suffixStart < namingRule_p.length())
        result = namingRule_p.substring(suffixStart, namingRule_p.length());
    }
    return result;
  }
  
  /**
   * Return the neutral naming rule suffixed with the index symbol
   * @return a non-null string
   */
  public static String getSymbolicIndexedName() {
    return NAMING_RULE_NEUTRAL + getSymbolicSuffix();
  }
  
  /**
   * Return the index symbol suffix
   * @return a non-null string
   */
  private static String getSymbolicSuffix() {
    return SUFFIX_SEP + INDEX_SYMBOL;
  }
  
  /**
   * Return whether every of the given elements has a unique name among the elements
   * (false if any of the names is null)
   * Postcondition: elements_p is not modified
   * @param elements_p a non-null, potentially empty collection
   */
  public static boolean haveUniqueNames(Collection<? extends INamedElement> elements_p) {
    Set<String> names = new HashSet<String>();
    for (INamedElement element : elements_p) {
      if (element.getName() == null)
        return false;
      names.add(element.getName());
    }
    return names.size() == elements_p.size();
  }
  
  /**
   * Return whether the given feature is likely to represent a name
   * @param feature_p a non-null feature
   */
  public static boolean isName(EStructuralFeature feature_p) {
    boolean result = false;
    if (feature_p instanceof EAttribute && feature_p.getName() != null) {
      result = "name".equals(feature_p.getName().toLowerCase()) && //$NON-NLS-1$
        feature_p.getEType() == EcorePackage.eINSTANCE.getEString();
    }
    return result;
  }
  
  /**
   * Return a naming rule such that all instance elements would have unique names when
   * the given application is unfolded
   * @param application_p a non-null pattern application
   * @return a potentially null string
   */
  public static String proposeNamingRule(IPatternApplication application_p) {
    String result = null;
    if (application_p.getPattern() instanceof TemplatePattern) {
      TemplatePattern pattern = (TemplatePattern)application_p.getPattern();
      int suffixIndex = 0;
      for (TemplatePatternRole role : pattern.getRoles()) {
        ILocation location = application_p.getLocation(role);
        if (location != null) {
          for (IAtomicLocation atomicLocation : location.getAtomicContents()) {
            if (atomicLocation instanceof IReferenceLocation) {
              IReferenceLocation referenceLocation = (IReferenceLocation)atomicLocation;
              EObject container = referenceLocation.getElement();
              if (container != null) {
                // Building the set of names of expected siblings
                Set<String> siblingNames = new HashSet<String>();
                for (EObject sibling : container.eContents()) {
                  String siblingName = getName(sibling);
                  if (siblingName != null)
                    siblingNames.add(siblingName);
                }
                // Checking each template element
                for (EObject templateElement : role.getTemplateElements()) {
                  String name = getName(templateElement);
                  if (name != null) {
                    String candidateName = suffixIndex == 0? name:
                      appendIndexSuffix(name, suffixIndex);
                    while (siblingNames.contains(candidateName)) {
                      suffixIndex++;
                      candidateName = appendIndexSuffix(name, suffixIndex);
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (suffixIndex > 0)
        result = appendIndexSuffix(getNeutralRenamingRule(), suffixIndex);
    }
    return result;
  }
  
  /**
   * Return a variant of the given name with the symbolic index suffix removed
   * @param name_p a non-null string
   * @return a non-null string
   */
  public static String removeSymbolicIndexSuffix(String name_p) {
    String result = name_p.replaceAll(
        java.util.regex.Pattern.quote(getSymbolicSuffix()), ""); //$NON-NLS-1$
    return result;
  }
  
  /**
   * Set the name of the given element, whatever its meta-class
   * @param element_p a non-null element
   * @param name_p a potentially null string
   * @return whether the operation succeeded
   */
  public static boolean setName(EObject element_p, String name_p) {
    boolean result = false;
    EAttribute nameAttribute = getNameAttribute(element_p);
    if (nameAttribute != null) {
      try {
        element_p.eSet(nameAttribute, name_p);
        result = true;
      } catch (Exception e) {
        // Failure
      }
    }
    return result;
  }
  
  /**
   * Substitute the index symbol with the given index value in the given string
   * @param name_p a non-null string
   * @param index_p an arbitrary int
   * @return a non-null string
   */
  public static String substituteIndex(String name_p, int index_p) {
    String replacement = String.valueOf(index_p);
    String result = name_p.replaceAll(INDEX_REGEX, replacement);
    return result;
  }
  
  /**
   * Un-apply the renaming rule consisting of the given prefix and suffix on the
   * given name and return the remaining name if the original name conforms to the rule
   * @param name_p a potentially null string
   * @param prefix_p a potentially null string
   * @param suffix_p a potentially null string
   * @return a potentially null string
   */
  private static String unapplyRenamingRule(String name_p, String prefix_p,
      String suffix_p) {
    String result = null;
    if (name_p != null && name_p.length() > 0) {
      boolean conforms = true;
      String current = name_p;
      // Remove prefix
      if (prefix_p != null && prefix_p.length() > 0) {
        int originalSize = current.length();
        current = current.replaceFirst(Pattern.quote(prefix_p), ""); //$NON-NLS-1$
        conforms = originalSize != current.length();
      }
      // Remove suffix
      if (conforms && suffix_p != null && suffix_p.length() > 0) {
        int start = current.lastIndexOf(suffix_p);
        if (start < 0 || name_p.length() > start + suffix_p.length()) {
          conforms = false;
        } else {
          current = current.substring(0, start);
        }
      }
      if (conforms)
        result = current;
    }
    return result;
  }
  
}
