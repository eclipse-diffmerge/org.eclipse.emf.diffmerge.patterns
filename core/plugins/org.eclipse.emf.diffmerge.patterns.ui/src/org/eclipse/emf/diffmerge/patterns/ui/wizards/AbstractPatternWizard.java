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
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.ImageSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatepatternsFactory;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


/**
 * A wizard dedicated to handling template patterns.
 * All pages must be of type AbstractPatternPage.
 * @author Olivier Constant
 */
public abstract class AbstractPatternWizard<T extends ITemplatePatternBasedSpecification>
extends Wizard {
  
  /** The specification being constructed by this wizard */
  private final T _data;
  
  /** Whether the wizard completed successfully */
  private boolean _isSuccessful;
  
  /** Whether the wizard has been disposed */
  private boolean _isDisposed;
  
  /** A non-null, potentially empty, unmodifiable list of GEF elements */
  private final List<Object> _graphicalContext;
  
  /** A potentially null image for the pattern */
  private Image _image;
  
  /** The potentially null pattern the image was computed for, if any */
  protected TemplatePattern _patternForImage;
  
  /** Whether pattern images must be generated when the pattern changes */
  private final boolean _generatePatternImage;
  
  /** The non-null, potentially empty, modifiable set of pattern image listeners */
  private final Collection<IPatternImageChangedListener> _listeners;
  
  /** Whether the usage of the wizard modified the repository registry */
  private boolean _modifiedRepositoryRegistry;
  
  /** Utility class instance used to call type-related services from the graphical framework (Sirius for example) */
  protected AbstractGenericTypeUtil _genericTypeUtil;
  
  /** Utility class instance used to call diagram-related services from the graphical framework (Sirius for example) */
  protected AbstractDiagramUtil _diagramUtil;
  
	/**
	 * Constructor
	 * @param data_p a non-null initial specification
	 */
	public AbstractPatternWizard(T data_p) {
	  this(data_p, Collections.emptyList(), true);
	  _modifiedRepositoryRegistry = false;
	}
	
  /**
   * Constructor
   * @param data_p a non-null initial specification
   * @param graphicalContext_p a non-null, potentially empty list of GEF elements
   * @param generatePatternImage_p whether pattern images must be automatically computed
   */
  public AbstractPatternWizard(T data_p,
      List<Object> graphicalContext_p,
      boolean generatePatternImage_p) {
    super();
    _genericTypeUtil = CorePatternsPlugin.getDefault().getGenericTypeUtil();
    _diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    _data = data_p;
    _isSuccessful = false;
    _isDisposed = false;
    _graphicalContext = Collections.unmodifiableList(graphicalContext_p);
    _image = null;
    _patternForImage = null;
    _generatePatternImage = generatePatternImage_p;
    _listeners = new HashSet<IPatternImageChangedListener>();
  }
  
  /**
   * @see org.eclipse.jface.wizard.Wizard#addPages()
   */
  @Override
  public final void addPages() {
    super.addPages();
    doAddPages();
    if (_generatePatternImage && getData() instanceof ITemplatePatternSelection) {
      final boolean modifiablePattern =
        getData() instanceof IModifiableTemplatePatternSpecification;
      if (getData().getPattern() != null) {
        TemplatePattern currentPattern = getData().getPattern();
        if (currentPattern.getImage() != null && getPatternImage() == null)
          computePatternImageFromSpecification(
              currentPattern.getImage().getContents(), modifiablePattern);
      }
      ((ITemplatePatternSelection)getData()).addSelectedPatternListener(
          new ITemplatePatternSelection.IPatternChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
             */
            public void patternChanged(TemplatePattern newPattern_p) {
              if (_patternForImage != newPattern_p) {
                // Requires image computation
                String imageSpecification = null;
                if (newPattern_p != null && newPattern_p.getImage() != null)
                  imageSpecification = newPattern_p.getImage().getContents();
                computePatternImageFromSpecification(imageSpecification, modifiablePattern);
              }
            }
          });
    }
  }
  
  /**
   * Add a listener on the pattern image
   * @param listener_p a non-null listener
   */
  public void addSelectedPatternListener(IPatternImageChangedListener listener_p) {
    _listeners.add(listener_p);
  }
  
  /**
   * Add pages to this wizard.
   * @see AbstractPatternWizard#addPages()
   */
  protected abstract void doAddPages();
  
  /**
   * @see org.eclipse.jface.wizard.Wizard#canFinish()
   */
  @Override
  public boolean canFinish() {
    return getData().isComplete();
  }
  
  /**
   * Asynchronously set the pattern image from the given image specification
   * @param imageSpecification_p a potentially null image specification
   * @param updatePattern_p whether the pattern must be updated with the new image
   */
  public void computePatternImageFromSpecification(String imageSpecification_p,
      boolean updatePattern_p) {
    Job job = instantiatePatternImageBuilderJob(this, imageSpecification_p, updatePattern_p);
    job.schedule();
  }
  
  /**
   * Asynchronously set the pattern image from the original graphical context
   * @param updatePattern_p whether the pattern must be updated with the new image
   */
  public void computePatternImageFromGraphicalContext(boolean updatePattern_p) {
    Job job = instantiatePatternImageBuilderJob(this, _graphicalContext, updatePattern_p);
    job.schedule();
  }
  
  /**
   * @see org.eclipse.jface.wizard.Wizard#dispose()
   */
  @Override
  public synchronized void dispose() {
    super.dispose();
    if (_image != null)
      _image.dispose();
    _isDisposed = true;
  }
  
	/**
	 * A redefinition of performFinish in order to enforce additional behavior
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	protected abstract boolean doPerformFinish();
	
	/**
	 * Execute the given model operation
	 * @param operation_p a non-null model operation of type E
	 * @return a potentially null object of type E
	 */
	protected <E> E execute(final IModelOperation<E> operation_p) {
	  final LinkedList<E> wrapper = new LinkedList<E>();
	  BusyIndicator.showWhile(getShell().getDisplay(), new Runnable() {
      public void run() {
        wrapper.add(CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation_p));
      }
    });
	  return wrapper.get(0);
	}
	
	/**
	 * Return the specification being constructed by this wizard
	 * @return a non-null object
	 */
	public T getData() {
	  return _data;
	}
	
	
	/**
	 * Return the GEF elements which define the graphical context of the wizard, if any
	 * @return a non-null, potentially empty, unmodifiable list
	 */
	protected List<Object> getGraphicalContext() {
	  return Collections.unmodifiableList(_graphicalContext);
	}
	
	/**
	 * Return the image of the pattern
	 * @return a potentially null image
	 */
	public synchronized Image getPatternImage() {
	  return _image;
	}
	
  /**
   * Return whether the wizard has been disposed
   */
  public synchronized boolean isDisposed() {
    return _isDisposed;
  }
  
	/**
	 * Return whether the wizard completed successfully
	 */
	public boolean isSuccessful() {
	  return _isSuccessful;
	}
	
  /**
   * Return whether the pattern may have an image
   */
  public boolean mayHaveImage() {
    return !_graphicalContext.isEmpty();
  }
  
	/**
	 * Notify that the repository registry was modified
	 */
	protected void notifyRepositoryRegistryChanged() {
	  _modifiedRepositoryRegistry = true;
	}
	
	/**
	 * Notify all listeners that the pattern image has changed
	 */
	protected void patternImageChanged() {
	  for (IPatternImageChangedListener listener : _listeners) {
	    listener.patternImageChanged(_image);
	  }
	}
	
  /**
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public final boolean performFinish() {
    final List<Boolean> resultWrapper = new ArrayList<Boolean>(1);
    try {
      PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
        /**
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor monitor) throws InvocationTargetException,
        InterruptedException {
          getShell().getDisplay().syncExec(new Runnable() {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run() {
              boolean result = doPerformFinish();
              resultWrapper.add(Boolean.valueOf(result));
            }
          });
        }
      });
    } catch(Exception e) {
      // Proceed
    }
    _isSuccessful = !resultWrapper.isEmpty() && resultWrapper.get(0).booleanValue();
    return _isSuccessful;
  }
  
  /**
   * Return whether the usage of the wizard modified the repository registry
   */
  public boolean repositoryRegistryChanged() {
    return _modifiedRepositoryRegistry;
  }
  
  /**
   * Set the image of the pattern
   * @param pattern_p the non-null pattern the image is for
   * @param imageSpecifiation_p the potentially null specification of the image
   * @param image_p the potentially null image
   * @param updatePattern_p whether the pattern must be updated with the image
   */
  public final synchronized void setPatternImage(final TemplatePattern pattern_p,
      final String imageSpecifiation_p, final Image image_p, final boolean updatePattern_p) {
    if (_image != null)
      _image.dispose();
    if (AbstractPatternWizard.this.isDisposed()) {
      // Too late: just dispose the image
      if (image_p != null)
        image_p.dispose();
    } else {
      _image = image_p;
      _patternForImage = pattern_p;
      Display.getDefault().asyncExec(new Runnable() {
        /**
         * @see java.lang.Runnable#run()
         */
        public void run() {
          if (getData().getPattern() == pattern_p) {
            if (updatePattern_p) {
              ImageSpecification image = null;
              if (imageSpecifiation_p != null) {
                image = TemplatepatternsFactory.eINSTANCE.createImageSpecification();
                image.setContents(imageSpecifiation_p);
              }
              pattern_p.setImage(image);
            }
            patternImageChanged();
          } // Otherwise, image is deprecated
        }
      });
    }
  }
  
  
  /**
   * An interface for observers which are concerned with the computation of pattern images
   */
  public static interface IPatternImageChangedListener {
    /**
     * Notifies that a pattern image has been built
     * @param newImage_p a potentially null image
     */
    void patternImageChanged(Image newImage_p);
  }

  /**
   * Instantiates a Job
   * @param wizard_p
   * @param context_p
   * @param updatePattern_p
   * @return
   */
  protected abstract Job instantiatePatternImageBuilderJob(AbstractPatternWizard<T> wizard_p,  List<Object> context_p, boolean updatePattern_p);
  
  /**
   * Instantiates a Job
   * @param wizard_p
   * @param imageSpecification_p
   * @param updatePattern_p
   * @return
   */
  protected abstract Job instantiatePatternImageBuilderJob(AbstractPatternWizard<T> wizard_p,  String imageSpecification_p, boolean updatePattern_p);

 
}
