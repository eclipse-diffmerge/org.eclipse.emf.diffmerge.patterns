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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.emf.diffmerge.util.structures.FArrayList;
import org.eclipse.emf.diffmerge.util.structures.FHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.core.util.locations.BasicElementMappingLocation;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A dialog that allows users to map template elements of a given role and certain model elements.
 * @author Olivier Constant
 */
public class ElementMappingDialog extends MessageDialog {

  /**
   * The data for this dialog.
   */
  protected static class ElementMappingSpecification {
    /** The property for changes in the mapping */
    private static final String PROPERTY_MAPPING = "mapping_property"; //$NON-NLS-1$
    /** The property for changes in the mapping */
    private static final String PROPERTY_PATTERN_SELECTION = "pattern_selection_property"; //$NON-NLS-1$
    /** The property for changes in the mapping */
    private static final String PROPERTY_MODEL_SELECTION = "model_selection_property"; //$NON-NLS-1$
    /** The non-null list of model elements */
    private final List<EObject> _modelElements;
    /** The non-null list of pattern elements */
    private final List<EObject> _patternElements;
    /** The non-null, potentially empty <pattern element, model element> map */
    private final EMap<EObject, EObject> _patternToModel;
    /** The non-null, potentially empty <model element, pattern element> map */
    private final EMap<EObject, EObject> _modelToPattern;
    /** The non-null, potentially empty, unmodifiable list of pattern elements currently selected */
    private List<EObject> _patternSelection;
    /** The non-null, potentially empty, unmodifiable list of model elements currently selected */
    private List<EObject> _modelSelection;
    /** Whether the active selection is on the pattern side */
    private boolean _activeSelectionInPattern;
    /** The non-null, potentially empty set of listeners */
    private final Set<IPropertyChangeListener> _listeners;

    /**
     * Constructor
     * @param patternElements_p the non-null set of pattern elements to map
     * @param modelElements_p the non-null set of model elements to map
     */
    public ElementMappingSpecification(Collection<? extends EObject> patternElements_p,
        Collection<? extends EObject> modelElements_p) {
      _patternElements = Collections.unmodifiableList(new FArrayList<EObject>(patternElements_p, null));
      _modelElements = Collections.unmodifiableList(new FArrayList<EObject>(modelElements_p, null));
      _patternToModel = new FHashMap<EObject, EObject>();
      _modelToPattern = new FHashMap<EObject, EObject>();
      _listeners = new HashSet<IPropertyChangeListener>();
      _patternSelection = new FArrayList<EObject>();
      _modelSelection = new FArrayList<EObject>();
      _patternSelection = Collections.emptyList();
      _modelSelection = Collections.emptyList();
      _activeSelectionInPattern = true;
    }
    /**
     * Register the given listener
     * @param listener_p a non-null listener
     */
    public void addPropertyChangeListener(IPropertyChangeListener listener_p) {
      _listeners.add(listener_p);
    }
    /**
     * Unmap the given element, whatever its side, and return whether it had any effect
     * @param element_p a non-null element
     */
    protected boolean doUnmap(EObject element_p) {
      EObject removedPattern = _modelToPattern.removeKey(element_p);
      if (removedPattern != null)
        _patternToModel.removeKey(removedPattern);
      EObject removedModel = _patternToModel.removeKey(element_p);
      if (removedModel != null)
        _modelToPattern.removeKey(removedModel);
      return removedModel != null || removedPattern != null;
    }
    /**
     * Return the set of model elements to map
     * @return a non-null, potentially empty, unmodifiable list
     */
    public List<EObject> getModelElements() {
      return _modelElements;
    }
    /**
     * Return the model selection
     * @return a non-null, potentially empty, unmodifiable list
     */
    public List<EObject> getModelSelection() {
      return Collections.unmodifiableList(_modelSelection);
    }
    /**
     * Return the <model element, pattern element> map
     * @return a non-null, potentially empty, unmodifiable map
     */
    public EMap<EObject, EObject> getModelToPatternMap() {
      return ECollections.unmodifiableEMap(_modelToPattern);
    }
    /**
     * Return the set of pattern elements to map
     * @return a non-null, potentially empty, unmodifiable list
     */
    public List<EObject> getPatternElements() {
      return _patternElements;
    }
    /**
     * Return the pattern selection
     * @return a non-null, potentially empty, unmodifiable list
     */
    public List<EObject> getPatternSelection() {
      return Collections.unmodifiableList(_patternSelection);
    }
    /**
     * Return the <pattern element, model element> map
     * @return a non-null, potentially empty, unmodifiable map
     */
    public EMap<EObject, EObject> getPatternToModelMap() {
      return ECollections.unmodifiableEMap(_patternToModel);
    }
    /**
     * Return whether the active selection is on the pattern side
     */
    public boolean isActiveSelectionInPattern() {
      return _activeSelectionInPattern;
    }
    /**
     * Return whether the given element from the given side is mapped
     * @param element_p a non-null element
     * @param fromPattern_p whether the element belongs to the pattern side
     */
    public boolean isMapped(EObject element_p, boolean fromPattern_p) {
      boolean result;
      if (fromPattern_p)
        result = _patternToModel.get(element_p) != null;
      else
        result = _modelToPattern.get(element_p) != null;
      return result;
    }
    /**
     * Map the given elements
     * @param patternElement_p a non-null element
     * @param modelElement_p a non-null element
     */
    public void map(EObject patternElement_p, EObject modelElement_p) {
      doUnmap(patternElement_p);
      doUnmap(modelElement_p);
      _patternToModel.put(patternElement_p, modelElement_p);
      _modelToPattern.put(modelElement_p, patternElement_p);
      notify(PROPERTY_MAPPING);
    }
    /**
     * Notify the listeners of an event on the given property
     * @param property_p a non-null property
     */
    protected void notify(String property_p) {
      PropertyChangeEvent event = new PropertyChangeEvent(this, property_p, null, null);
      for (IPropertyChangeListener listener : _listeners) {
        listener.propertyChange(event);
      }
    }

    /**
     * Unmap the given set of elements, whatever their side
     * @param elements_p a non-null, potentially empty collection
     */
    public void unmap(Collection<EObject> elements_p) {
      boolean modified = false;
      for (EObject element : elements_p) {
        modified = modified || doUnmap(element);
      }
      if (modified)
        notify(PROPERTY_MAPPING);
    }
    /**
     * Update the model selection according to the give selection
     * @param selection_p a potentially null selection
     */
    @SuppressWarnings("unchecked")
    public void updateModelSelection(IStructuredSelection selection_p) {
      if (selection_p == null)
        _modelSelection = Collections.emptyList();
      else
        _modelSelection = selection_p.toList();
      _activeSelectionInPattern = false;
      notify(PROPERTY_MODEL_SELECTION);
    }
    /**
     * Update the pattern selection according to the give selection
     * @param selection_p a potentially null selection
     */
    @SuppressWarnings("unchecked")
    public void updatePatternSelection(IStructuredSelection selection_p) {
      if (selection_p == null)
        _patternSelection = Collections.emptyList();
      else
        _patternSelection = selection_p.toList();
      _activeSelectionInPattern = true;
      notify(PROPERTY_PATTERN_SELECTION);
    }
  }


  /** The data */
  protected final ElementMappingSpecification _data;


  /**
   * Constructor
   * @param parentShell_p the shell for this dialog
   * @param role_p a non-null role
   * @param elements_p the non-null list of elements to choose from
   */
  public ElementMappingDialog(Shell parentShell_p, TemplatePatternRole role_p,
      Collection<? extends EObject> elements_p) {
    super(parentShell_p, Messages.ElementMappingDialog_Title,
        null, getDialogMessage(role_p), MessageDialog.NONE, 
        new String[] {IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL}, 0);
    _data = new ElementMappingSpecification(role_p.getTemplateElements(), elements_p);
    setShellStyle(getShellStyle() | SWT.RESIZE);
  }

  /**
   * Return a message for this dialog based on the given role
   * @param role_p a non-null role
   * @return a non-null string
   */
  private static String getDialogMessage(TemplatePatternRole role_p) {
    return String.format(Messages.ElementMappingDialog_Message, role_p.getName());
  }

  /**
   * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createCustomArea(Composite parent_p) {
    Composite result = new Composite(parent_p, SWT.NONE);
    GridData resultLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
    resultLayoutData.heightHint = 300;
    resultLayoutData.widthHint = 700;
    result.setLayoutData(resultLayoutData);
    result.setLayout(new GridLayout(3, false));
    // Left
    Group leftGroup = new Group(result, SWT.NONE);
    leftGroup.setText(Messages.ElementMappingDialog_PatternElements);
    leftGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    leftGroup.setLayout(new GridLayout());
    ModelSubsetViewer leftViewer = createPatternViewer(leftGroup);
    // Center
    Composite buttonComposite = new Composite(result, SWT.NONE);
    buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true));
    GridLayout buttonCompositeLayout = new GridLayout();
    buttonCompositeLayout.marginHeight = 0;
    buttonCompositeLayout.marginWidth = 0;
    buttonComposite.setLayout(buttonCompositeLayout);
    Button mapButton = createMapButton(buttonComposite);
    mapButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    Button unmapButton = createUnmapButton(buttonComposite);
    unmapButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    // Right
    Group rightGroup = new Group(result, SWT.NONE);
    rightGroup.setText(Messages.ElementMappingDialog_ModelElements);
    rightGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    rightGroup.setLayout(new GridLayout());
    createModelViewer(rightGroup);
    if (_data.getModelElements().size() == 1 && _data.getPatternElements().size() == 1)
      _data.map(_data.getPatternElements().get(0), _data.getModelElements().get(0));
    leftViewer.getControl().setFocus();
    return result;
  }

  /**
   * Create and return the viewer for the model part
   * @param parent_p a non-null composite
   * @return a non-null viewer
   */
  protected ModelSubsetViewer createModelViewer(Composite parent_p) {
    final ModelSubsetViewer result = new ModelSubsetViewer(
        parent_p, true, false) {
      /**
       * 
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getSorter()
       */
      @Override
      protected ViewerSorter getSorter() {
        return new ViewerSorter() {
          private static final int MAPPED_CATEGORY = 0;
          private static final int UNMAPPED_CATEGORY = 1;
          /**
           * @see org.eclipse.jface.viewers.ViewerComparator#category(java.lang.Object)
           */
          @Override
          public int category(Object element_p) {
            int localResult;
            if (element_p instanceof EObject) {
              boolean isMapped = _data.isMapped((EObject)element_p, false) ||
                  _data.isMapped((EObject)element_p, true); // 2nd operand is necessary for method compare(...)
              localResult = isMapped? MAPPED_CATEGORY: UNMAPPED_CATEGORY;
            } else {
              localResult = super.category(element_p);
            }
            return localResult;
          }
          /**
           * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
           */
          @Override
          public int compare(Viewer viewer_p, Object e1_p, Object e2_p) {
            int localResult;
            if (category(e1_p) == MAPPED_CATEGORY && category(e2_p) == MAPPED_CATEGORY) {
              EObject modelElement1 = (EObject)e1_p;
              EObject modelElement2 = (EObject)e2_p;
              EObject patternElement1 = _data.getModelToPatternMap().get(modelElement1);
              EObject patternElement2 = _data.getModelToPatternMap().get(modelElement2);
              localResult = super.compare(viewer_p, patternElement1, patternElement2);
            } else {
              localResult = super.compare(viewer_p, e1_p, e2_p);
            }
            return localResult;
          }
        };
      }
      /**
       * 
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getText(org.eclipse.emf.ecore.EObject, java.lang.String)
       */
      @Override
      protected String getText(EObject element_p, String defaultText_p) {
        String localResult = defaultText_p;
        if (_data.getModelElements().contains(element_p) && !_data.isMapped(element_p, false))
          localResult = getUnmappedLabel(localResult);
        return localResult;
      }
      /**
       * 
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        return ModelSubsetViewer.SHOW_PARENTS | ModelSubsetViewer.EXPAND |
            ModelSubsetViewer.COLLAPSE;
      }
    };
    result.setInput(_data.getModelElements());
    // Update data on selection
    result.addSelectionListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        _data.updateModelSelection((IStructuredSelection)event_p.getSelection());
      }
    });
    // Refresh on mapping change
    _data.addPropertyChangeListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event) {
        if (ElementMappingSpecification.PROPERTY_MAPPING.equals(event.getProperty()))
          result.refresh();
      }
    });
    return result;
  }

  /**
   * Return a variant of the given element label that shows the fact that the element
   * is not mapped
   * @param defaultLabel_p a non-null string
   * @return a non-null string
   */
  protected String getUnmappedLabel(String defaultLabel_p) {
    return "> " + defaultLabel_p; //$NON-NLS-1$
  }

  /**
   * Create and return the viewer for the pattern part
   * @param parent_p a non-null composite
   * @return a non-null viewer
   */
  protected ModelSubsetViewer createPatternViewer(Composite parent_p) {
    final ModelSubsetViewer result = new ModelSubsetViewer(
        parent_p, true, false) {
      /**
       * 
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getSorter()
       */
      @Override
      protected ViewerSorter getSorter() {
        return new ViewerSorter() {
          /**
           * @see org.eclipse.jface.viewers.ViewerComparator#category(java.lang.Object)
           */
          @Override
          public int category(Object element_p) {
            int localResult;
            if (element_p instanceof EObject) {
              boolean isMapped = _data.isMapped((EObject)element_p, true);
              localResult = isMapped? 0: 1;
            } else {
              localResult = super.category(element_p);
            }
            return localResult;
          }
        };
      }
      /**
       * 
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getText(org.eclipse.emf.ecore.EObject, java.lang.String)
       */
      @Override
      protected String getText(EObject element_p, String defaultText_p) {
        String localResult = defaultText_p;
        if (_data.getPatternElements().contains(element_p) && !_data.isMapped(element_p, true))
          localResult = getUnmappedLabel(localResult);
        return localResult;
      }
      /**
       * 
       * @see org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer#getControlWidgetConfiguration()
       */
      @Override
      protected int getControlWidgetConfiguration() {
        return ModelSubsetViewer.SHOW_PARENTS | ModelSubsetViewer.EXPAND |
            ModelSubsetViewer.COLLAPSE;
      }
    };
    result.setInput(_data.getPatternElements());
    // Update data on selection
    result.addSelectionListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        _data.updatePatternSelection((IStructuredSelection)event_p.getSelection());
      }
    });
    // Refresh on mapping change
    _data.addPropertyChangeListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event) {
        if (ElementMappingSpecification.PROPERTY_MAPPING.equals(event.getProperty()))
          result.refresh();
      }
    });
    return result;
  }

  /**
   * Create and return the "map" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createMapButton(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.ElementMappingDialog_Map);
    // Enabled state
    result.setEnabled(false);
    _data.addPropertyChangeListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event_p) {
        if (ElementMappingSpecification.PROPERTY_MODEL_SELECTION.equals(event_p.getProperty()) ||
            ElementMappingSpecification.PROPERTY_PATTERN_SELECTION.equals(event_p.getProperty())) {
          boolean enable = _data.getPatternSelection().size() == 1 &&
              _data.getModelSelection().size() == 1 &&
              _data.getPatternSelection().get(0).eClass() == _data.getModelSelection().get(0).eClass();
          result.setEnabled(enable);
        }
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        if (_data.getPatternSelection().size() == 1 &&
            _data.getModelSelection().size() == 1) {
          _data.map(_data.getPatternSelection().get(0), _data.getModelSelection().get(0));
        }
      }
    });
    return result;
  }

  /**
   * Create and return the "map" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createUnmapButton(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.ElementMappingDialog_Unmap);
    // Enabled state
    result.setEnabled(false);
    _data.addPropertyChangeListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event_p) {
        boolean enable = false;
        if (ElementMappingSpecification.PROPERTY_PATTERN_SELECTION.equals(event_p.getProperty()) ||
            ElementMappingSpecification.PROPERTY_MAPPING.equals(event_p.getProperty()))
          enable = enable || !_data.getPatternSelection().isEmpty() &&
          oneIsMapped(_data.getPatternSelection(), true);
        if (ElementMappingSpecification.PROPERTY_MODEL_SELECTION.equals(event_p.getProperty()) ||
            ElementMappingSpecification.PROPERTY_MAPPING.equals(event_p.getProperty()))
          enable = enable || !_data.getModelSelection().isEmpty() &&
          oneIsMapped(_data.getModelSelection(), false);
        result.setEnabled(enable);
      }
      /**
       * Return whether at least one of the given elements from the given side is mapped
       * @param elements_p a non-null, non-empty list
       * @param fromPattern_p whether the side is pattern or model
       */
      private boolean oneIsMapped(List<EObject> elements_p, boolean fromPattern_p) {
        for (EObject element : elements_p) {
          if (_data.isMapped(element, fromPattern_p))
            return true;
        }
        return false;
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent event_p) {
        List<EObject> toUnmap = _data.isActiveSelectionInPattern()? _data.getPatternSelection():
          _data.getModelSelection();
        _data.unmap(toUnmap);
      }
    });
    return result;
  }

  /**
   * Return the resulting location
   * @return a non-null location
   */
  public IElementMappingLocation getResult() {
    BasicElementMappingLocation result = new BasicElementMappingLocation();
    EMap<EObject, EObject> map = _data.getPatternToModelMap();
    for (Map.Entry<EObject, EObject> entry : map.entrySet()) {
      EObject templateElement = entry.getKey();
      EObject modelElement = entry.getValue();
      result.map(templateElement, modelElement);
    }
    return result;
  }

}
