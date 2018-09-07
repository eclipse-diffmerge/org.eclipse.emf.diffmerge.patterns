/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard;
import org.eclipse.swt.graphics.Image;

import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;

/**
 * A job for computing the image of a pattern and notifying for completion
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractPatternImageBuilderJob extends Job  {

  /** The name of the job */
  private static final String NAME = Messages.AbstractPatternWizard_ComputationJobName;
  
  /** A non-null wizard */
  private final AbstractPatternWizard<?> _wizard;
  
  /** The non-null pattern the image is built for */
  private final TemplatePattern _pattern;
  
  /** A potentially null, unmodifiable list of GEF elements */
  private final List<Object> _graphicalContext;
  
  /** A potentially null image specification */
  private String _imageSpecifiation;
  
  /** Whether the pattern must be updated with the new image in the end */
  private final boolean _updatePattern;
  
  
  /**
   * Constructor
   * @param wizard_p a non-null wizard
   * @param graphicalContext_p a potentially null list of contextual GEF elements
   * @param updatePattern_p whether the pattern must be updated with the new image
   */
  public AbstractPatternImageBuilderJob(AbstractPatternWizard<?> wizard_p,
      List<Object> graphicalContext_p, boolean updatePattern_p) {
    super(NAME);
    _wizard = wizard_p;
    _graphicalContext = Collections.unmodifiableList(graphicalContext_p);
    _imageSpecifiation = null;
    _pattern = wizard_p.getData().getPattern();
    _updatePattern = updatePattern_p;
  }
  
  /**
   * Constructor
   * @param wizard_p a non-null wizard
   * @param imageSpecification_p a potentially null image specification
   * @param updatePattern_p whether the pattern must be updated with the new image
   */
  public AbstractPatternImageBuilderJob(AbstractPatternWizard<?> wizard_p,
      String imageSpecification_p, boolean updatePattern_p) {
    super(NAME);
    _wizard = wizard_p;
    _graphicalContext = null;
    _imageSpecifiation = imageSpecification_p;
    _pattern = wizard_p.getData().getPattern();
    _updatePattern = updatePattern_p;
  }
  
  /**
   * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected IStatus run(IProgressMonitor monitor_p) {
    IStatus result = Status.OK_STATUS;
    if (_graphicalContext != null)
      _imageSpecifiation = exportToSVG(_graphicalContext);
    Image image = null;
    if (_imageSpecifiation != null && _imageSpecifiation.length() > 0)
      image = UIUtil.renderSVG(_imageSpecifiation);
    _wizard.setPatternImage(
        _pattern, _imageSpecifiation, image, _updatePattern);
    return result;
  }
  
  /**
   * Export the given objects to a SVG definition
   * @param graphicalContext_p a non-null set of graphical objects
   * @return a potentially null string
   */
  protected abstract String exportToSVG(List<Object> graphicalContext_p) ;
  
}
