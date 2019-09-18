/*********************************************************************
 * Copyright (c) 2010-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.misc;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;


/**
 * A "virtual" selection which can be built from different views
 * @author Olivier Constant
 */
public class PersistentSelection {

	/** The potentially null pattern application under construction */
	private EList<Object> _elements;
	
	/**
	 * Constructor
	 */
	public PersistentSelection() {
    _elements = new FOrderedSet<Object>();
	}
	
	/**
	 * Add the given elements to the persistent selection
	 * @param newElements_p a non-null collection
	 */
	public void addElements(Collection<?> newElements_p) {
	  _elements.addAll(newElements_p);
	}
	
	/**
	 * Return the contents of the persistent selection
	 * @return a non-null, potentially empty, unmodifiable list
	 */
	public List<Object> getElements() {
	  return ECollections.unmodifiableEList(_elements);
	}
	
	/**
	 * Return whether the persistent selection is empty
	 */
	public boolean isEmpty() {
	  return _elements.isEmpty();
	}
	
  /**
   * Reset the persistent selection
   */
  public void reset() {
    _elements.clear();
  }
	
}
