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
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner.helper;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * A utility class that provides services related to the structure of the UML meta-model in the context
 * of the patterns framework.
 * @author Skander Turki
 */
@SuppressWarnings("nls")
public class UMLMetamodelHelper {
  
  /** The set of references that must not be considered for dependencies */
  public static final List<EReference> NON_DEPENDENCY_REFERENCES = Arrays.asList(
      UMLPackage.eINSTANCE.getClassifier_Generalization(),
      UMLPackage.eINSTANCE.getProperty_Class()
      );
  
  public static final String UML_JAVA_PRIMITIVE_TYPES_RESOURCE_URI = "pathmap://UML_LIBRARIES/JavaPrimitiveTypes.library.uml";
  
  /** The list of UML JAVA library primitive types names */
  private static final List<String> UML_JAVA_PRIMITIVE_TYPE_NAMES = Arrays.asList(
      "boolean", "byte", "char", "double", "float", "int", "long", "short");
  
  public static final String UML_BASIC_LIBRARY_PRIMITIVE_TYPES_RESOURCE_URI = "pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml";
  
  /** The list of UML basic library primitive types names */
  private static final List<String> UML_BASIC_LIBRARY_PRIMITIVE_TYPE_NAMES = Arrays.asList(
      "Boolean", "String", "Integer", "Real", "UnlimitedNatural");
  
  /**
   * Returns if the element_p is a UML library primitive type.
   * @param element_p a potentially null Object
   */
  public static boolean isUMLLibraryPrimitiveType(Object element_p){
    if(element_p instanceof PrimitiveType){
      PrimitiveType type = (PrimitiveType)element_p;
      return UML_BASIC_LIBRARY_PRIMITIVE_TYPE_NAMES.contains(type.getName()) || UML_JAVA_PRIMITIVE_TYPE_NAMES.contains(type.getName());
    }
    return false;
  }
  
  /**
   * Returns if the element_p is a UML basic library primitive type.
   * @param element_p a non-null Object
   */
  public static boolean isUMLBasicLibraryPrimitiveType(Object element_p){
    if(element_p instanceof PrimitiveType){
      PrimitiveType type = (PrimitiveType)element_p;
      return UML_BASIC_LIBRARY_PRIMITIVE_TYPE_NAMES.contains(type.getName());
    }
    return false;
  }
  
  /**
   * Returns if the element_p is a UML JAVA library primitive type.
   * @param element_p a non-null Object
   */
  public static boolean isUMLJavaPrimitiveType(Object element_p){
    if(element_p instanceof PrimitiveType){
      PrimitiveType type = (PrimitiveType)element_p;
      return UML_JAVA_PRIMITIVE_TYPE_NAMES.contains(type.getName());
    }
    return false;
  }
  
  /**
   * 
   * @param element_p
   * @param context_p
   * @return
   */
  public static boolean deriveOwnership(EObject element_p, Object context_p) {
    boolean result = false;
    EObject container = null;
    EReference containment = null;
    //TODO: not the eContainer but the eContainer of the counterpart!
    //like in :
//    if (element_p instanceof ActivityEdge) {
//      ActivityEdge casted = (ActivityEdge)element_p;
//      if (casted.getSource() != null && casted.getTarget() != null) {
//        container = deriveLinkContainer(casted.getSource(), casted.getTarget());
//        if (container instanceof AbstractFunction)
//          containment = FaPackage.eINSTANCE.getAbstractFunction_OwnedFunctionalExchanges();
//      }
//    }
    // DirectedRelationship
    if (element_p instanceof DirectedRelationship) {
      DirectedRelationship casted = (DirectedRelationship)element_p;
      deriveDirectedRelationshipOwnership(casted, context_p, container, containment);
    }
    // Association
    else if (element_p instanceof Association) {
      Association casted = (Association)element_p;
      casted.getMemberEnds();
      if(casted.getMembers().get(0) != null && casted.getMembers().get(1)!= null){
        if(casted.getMembers().get(0) instanceof Property && casted.getMembers().get(1) instanceof Property){
          
          container = deriveLinkContainer(((Property)casted.getMembers().get(0)).getType(),((Property)casted.getMembers().get(1)).getType());
          if (container instanceof Model){ // test which Class is it!
            //containment = UMLPackage.eINSTANCE.getCl;
          }
        }
       
      }
    }
    // Classifier
    else if (element_p instanceof Classifier) {
      Classifier casted = (Classifier)element_p;
      container = casted.eContainer();
    }
    // PhysicalLinks
    else if (element_p instanceof DataType) {
      DataType casted = (DataType)element_p;
      container = casted.eContainer();
    }
//    if (null != container && null != containment) {
//      IReferenceLocation location =
//          new BasicReferenceLocation(container, containment);
//      try {
//        LocationsUtil.add(location, element_p);
//        result = true;
//      } catch (RuntimeException e) {
//        // Failure: will return false
//      }
//    }
    return result;
  }
  
  /**
   * 
   * @param element_p
   * @param context_p
   * @return
   */
  private static void deriveDirectedRelationshipOwnership(DirectedRelationship element_p, 
      Object context_p, EObject container_o, EReference containment_o) {
    // Dependency
//    if (element_p instanceof Dependency) {
//      Dependency casted = (Dependency)element_p;
//      container_o = casted.eContainer();
//      //if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // ElementImport
//    if (element_p instanceof ElementImport) {
//      ElementImport casted = (ElementImport)element_p;
//      container_o = casted.eContainer();
//      //if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // Extend
//    if (element_p instanceof Extend) {
//      Extend casted = (Extend)element_p;
//      container_o = casted.eContainer();
//      //if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // Generalization
//    if (element_p instanceof Generalization) {
//      Generalization casted = (Generalization)element_p;
//      container_o = casted.eContainer();
//      //if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // Include
//    if (element_p instanceof Include) {
//      Include casted = (Include)element_p;
//      container_o = casted.eContainer();
//     // if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // InformationFlow
//    if (element_p instanceof InformationFlow) {
//      InformationFlow casted = (InformationFlow)element_p;
//      container_o = casted.eContainer();
//     // if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // PackageImport
//    if (element_p instanceof PackageImport) {
//      PackageImport casted = (PackageImport)element_p;
//      container_o = casted.eContainer();
//      //if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // PackageMerge
//    if (element_p instanceof PackageMerge) {
//      PackageMerge casted = (PackageMerge)element_p;
//      container_o = casted.eContainer();
//     // if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // ProfileApplication
//    if (element_p instanceof ProfileApplication) {
//      ProfileApplication casted = (ProfileApplication)element_p;
//      container_o = casted.eContainer();
//     // if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // ProtocolConformance
//    if (element_p instanceof ProtocolConformance) {
//      ProtocolConformance casted = (ProtocolConformance)element_p;
//      container_o = casted.eContainer();
//      //if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }
//    // TemplateBinding
//    if (element_p instanceof TemplateBinding) {
//      TemplateBinding casted = (TemplateBinding)element_p;
//      container_o = casted.eContainer();
//      //if (container_o instanceof Object)
//        //containment_o = UMLPackage.eINSTANCE.getCl);
//    }     
  }
  
  /**
   * Helper method for deriveOwnership: case where container is derived from the ends
   * of a link/exchange
   * @param source_p a non-null element which is the end of a link/exchange
   * @param target_p a non-null element which is the end of a link/exchange
   * @return the computed container, if any
   */
  private static EObject deriveLinkContainer(EObject source_p, EObject target_p) {
    EObject result = null;
    //EObject sourceElement = getLinkDerivationReferenceElement(source_p);
    //EObject targetElement = getLinkDerivationReferenceElement(target_p);
    if (source_p != null && target_p != null)
      result = ModelsUtil.getCommonAncestor(source_p, target_p);
    return result;
  }
  
  /**
   * From the given non-null end of a link, return the associated element which
   * must be used for deriving a storage for the link
   * @param element_p the non-null end of a link/exchange
   * @return a non-null element
   */
  @SuppressWarnings("unused")
  private static EObject getLinkDerivationReferenceElement(EObject element_p) {
//    EObject result;
//    if (element_p instanceof ComponentExchangeEnd) {
//      ComponentExchangeEnd end = (ComponentExchangeEnd)element_p;
//      if (end.getPart() != null)
//        result = end.getPart();
//      else
//        result = end.getPort();
//    } else if (element_p instanceof PhysicalLinkEnd) {
//      PhysicalLinkEnd end = (PhysicalLinkEnd)element_p;
//      if (end.getPart() != null)
//        result = end.getPart();
//      else
//        result = end.getPort();
//    } else {
//      result = element_p;
//    }
    return element_p.eContainer().eContainer();
  }
  
}
