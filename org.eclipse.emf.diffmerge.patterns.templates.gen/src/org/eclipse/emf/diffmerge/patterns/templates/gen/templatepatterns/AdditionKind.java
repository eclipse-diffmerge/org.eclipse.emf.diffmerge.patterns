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
package org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Addition Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsPackage#getAdditionKind()
 * @model
 * @generated
 */
public enum AdditionKind implements Enumerator {
	/**
	 * The '<em><b>FORBIDDEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORBIDDEN_VALUE
	 * @generated
	 * @ordered
	 */
	FORBIDDEN(0, "FORBIDDEN", "FORBIDDEN"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>PREFERRED CONTAINMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFERRED_CONTAINMENT_VALUE
	 * @generated
	 * @ordered
	 */
	PREFERRED_CONTAINMENT(0, "PREFERRED_CONTAINMENT", "PREFERRED_CONTAINMENT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ANY CONTAINMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANY_CONTAINMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ANY_CONTAINMENT(0, "ANY_CONTAINMENT", "ANY_CONTAINMENT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ANY STORAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANY_STORAGE_VALUE
	 * @generated
	 * @ordered
	 */
	ANY_STORAGE(0, "ANY_STORAGE", "ANY_STORAGE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>FORBIDDEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FORBIDDEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORBIDDEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FORBIDDEN_VALUE = 0;

	/**
	 * The '<em><b>PREFERRED CONTAINMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PREFERRED CONTAINMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREFERRED_CONTAINMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PREFERRED_CONTAINMENT_VALUE = 0;

	/**
	 * The '<em><b>ANY CONTAINMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANY CONTAINMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANY_CONTAINMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANY_CONTAINMENT_VALUE = 0;

	/**
	 * The '<em><b>ANY STORAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANY STORAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANY_STORAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANY_STORAGE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Addition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AdditionKind[] VALUES_ARRAY =
		new AdditionKind[] {
			FORBIDDEN,
			PREFERRED_CONTAINMENT,
			ANY_CONTAINMENT,
			ANY_STORAGE,
		};

	/**
	 * A public read-only list of all the '<em><b>Addition Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AdditionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Addition Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdditionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AdditionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Addition Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdditionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AdditionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Addition Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdditionKind get(int value) {
		switch (value) {
			case FORBIDDEN_VALUE: return FORBIDDEN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AdditionKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AdditionKind
