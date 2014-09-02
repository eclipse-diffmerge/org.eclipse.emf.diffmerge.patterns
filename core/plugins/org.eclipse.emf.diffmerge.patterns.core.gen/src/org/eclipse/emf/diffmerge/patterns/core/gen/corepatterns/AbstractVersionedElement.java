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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns;

import org.eclipse.emf.diffmerge.patterns.core.api.IVersionedElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Versioned Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractVersionedElement()
 * @model abstract="true" superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractIdentifiedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IVersionedElement"
 * @generated
 */
public interface AbstractVersionedElement extends AbstractIdentifiedElement, IVersionedElement {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getAbstractVersionedElement_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // AbstractVersionedElement
