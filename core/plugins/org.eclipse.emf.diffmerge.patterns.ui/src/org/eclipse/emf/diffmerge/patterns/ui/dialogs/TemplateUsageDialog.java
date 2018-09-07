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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternApplication;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRole;
import org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation;
import org.eclipse.emf.diffmerge.patterns.core.util.LocationsUtil;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplateUsageSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A dialog that allows users to confirm the usage of a template for creating/updating a pattern.
 * @author Olivier Constant
 */
public class TemplateUsageDialog extends MessageDialog {
	
  /**
   * The data for this dialog.
   */
  public static class DetailedTemplateUsageSpecification {
    /** The property that represents a change in the application */
    private static final String PROPERTY_APPLICATION = "property_application"; //$NON-NLS-1$
    /** The non-null usage specification */
    private final TemplateUsageSpecification _data;
    /** The initially null application of the template */
    private IPatternApplication _application;
    /** Whether children of collected elements must be included */
    private boolean _includeChildren;
    /** Whether existing roles must be deleted */
    private boolean _deleteRoles;
    /** Whether existing pattern elements must be excluded */
    private boolean _excludeElements;
    /** Whether to override the name of the primary role */
    private boolean _overridePrimaryName;
    /** Whether to override the description of the primary role */
    private boolean _overridePrimaryDescription;
    /** Whether empty template roles must be included */
    private boolean _includeEmptyRoles;
    /** Whether template collection rules must be converted to pattern target derivation rules */
    private boolean _includeTargetDerivationRules;
    /** The non-null, potentially empty set of listeners */
    private final Set<IPropertyChangeListener> _listeners;
    /**
     * Constructor
     * @param data_p the non-null usage specification
     */
    public DetailedTemplateUsageSpecification(TemplateUsageSpecification data_p) {
      _data = data_p;
      _application = null;
      setIncludeChildren(true);
      _deleteRoles = true;
      _excludeElements = true;
      _overridePrimaryName = true;
      _overridePrimaryDescription = true;
      _includeEmptyRoles = false;
      _includeTargetDerivationRules = false;
      _listeners = new HashSet<IPropertyChangeListener>();
    }
    /**
     * Register the given listener
     * @param listener_p a non-null listener
     */
    public void addPropertyChangeListener(IPropertyChangeListener listener_p) {
      _listeners.add(listener_p);
    }
    /**
     * @see TemplateUsageSpecification#computeApplication()
     */
    public void computeApplication() {
      _application = _data.computeApplication();
      notify(PROPERTY_APPLICATION);
    }
    /**
     * Execute template usage according to this specification
     * Precondition: isComplete()
     */
    public void execute() {
      if (isComplete()) {
        _data.execute(_application, _includeChildren, _deleteRoles, _excludeElements,
            _overridePrimaryName, _overridePrimaryDescription, _includeEmptyRoles,
            _includeTargetDerivationRules);
      }
    }
    /**
     * Return the application of the template
     * @return a potentially null application of the template
     */
    public IPatternApplication getApplication() {
      return _application;
    }
    /**
     * Return whether this specification is complete and correct
     */
    public boolean isComplete() {
      boolean result = _application != null;
      if (result) {
        boolean first = true;
        result = false;
        for (IPatternRole role : _application.getPattern().getRoles()) {
          if (first) {
            first = false;
          } else {
            ILocation location = _application.getLocation(role);
            if (location != null) {
              result = true;
              break;
            }
          }
        }
      }
      return result;
    }
    /**
     * Return 
     */
    public boolean isIncludeChildren() {
      return _includeChildren;
    }
    /**
     * Set 
     * @param includeChildren_p the new value
     */
    public void setIncludeChildren(boolean includeChildren_p) {
      _includeChildren = includeChildren_p;
    }
    /**
     * Return 
     */
    public boolean isDeleteRoles() {
      return _deleteRoles;
    }
    /**
     * Set 
     * @param deleteRoles_p the new value
     */
    public void setDeleteRoles(boolean deleteRoles_p) {
      _deleteRoles = deleteRoles_p;
    }
    /**
     * Return 
     */
    public boolean isExcludeElements() {
      return _excludeElements;
    }
    /**
     * Set 
     * @param excludeElements_p the new value
     */
    public void setExcludeElements(boolean excludeElements_p) {
      _excludeElements = excludeElements_p;
    }
    /**
     * Return 
     */
    public boolean isOverridePrimaryName() {
      return _overridePrimaryName;
    }
    /**
     * Set 
     * @param overridePrimaryName_p the new value
     */
    public void setOverridePrimaryName(boolean overridePrimaryName_p) {
      _overridePrimaryName = overridePrimaryName_p;
    }
    /**
     * Return 
     */
    public boolean isOverridePrimaryDescription() {
      return _overridePrimaryDescription;
    }
    /**
     * Set 
     * @param overridePrimaryDescription_p the new value
     */
    public void setOverridePrimaryDescription(boolean overridePrimaryDescription_p) {
      _overridePrimaryDescription = overridePrimaryDescription_p;
    }
    /**
     * Return 
     */
    public boolean isIncludeEmptyRoles() {
      return _includeEmptyRoles;
    }
    /**
     * Set 
     * @param includeEmptyRoles_p the new value
     */
    public void setIncludeEmptyRoles(boolean includeEmptyRoles_p) {
      _includeEmptyRoles = includeEmptyRoles_p;
    }
    /**
     * Return 
     */
    public boolean isIncludeTargetDerivationRules() {
      return _includeTargetDerivationRules;
    }
    /**
     * Set 
     * @param includeTargetDerivationRules_p the new value
     */
    public void setIncludeTargetDerivationRules(boolean includeTargetDerivationRules_p) {
      _includeTargetDerivationRules = includeTargetDerivationRules_p;
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

  }
  
  
  /** An object representing a failure on a role in the usage of a template */
  public static final Object FAILURE_ELEMENT = new Object();
  
  /** An object representing an empty mapping to a role in the usage of a template */
  public static final Object EMPTY_ELEMENT = new Object();
  
	/** The data */
	private final DetailedTemplateUsageSpecification _data;
	
	
  /**
   * Constructor
   * @param parentShell_p the shell for this dialog
   * @param data_p a non-null specification of template usage
   */
  public TemplateUsageDialog(Shell parentShell_p, TemplateUsageSpecification data_p) {
    super(parentShell_p, Messages.TemplateUsageDialog_Title,
      null, getDialogMessage(data_p), MessageDialog.NONE, 
      new String[] {IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL}, 0);
    _data = new DetailedTemplateUsageSpecification(data_p);
    setShellStyle(getShellStyle() | SWT.RESIZE);
  }
  
  /**
   * Return a message for this dialog based on the data
   * @param data_p a non-null object
   * @return a non-null string
   */
	private static String getDialogMessage(TemplateUsageSpecification data_p) {
    return String.format(
        Messages.TemplateUsageDialog_Message,
        data_p.getPattern().getName(),
        DiscriminatingLabelProvider.getInstance().getText(data_p.getTargetElement()));
  }
	
	/**
	 * @see org.eclipse.jface.dialogs.Dialog#create()
	 */
	@Override
  public void create() {
    super.create();
    try {
      PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
        /**
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        public void run(IProgressMonitor monitor) throws InvocationTargetException,
        InterruptedException {
          getData().computeApplication();
        }
      });
    } catch(Exception e) {
      // Proceed
    }
  }
  
  /**
   * Create the area that shows the application of the template
   * @param parent_p a non-null composite
   */
  protected void createApplicationArea(Composite parent_p) {
    final TreeViewer treeViewer = new TreeViewer(parent_p);
    treeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    treeViewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
    treeViewer.setContentProvider(new ITreeContentProvider() {
      private IPatternApplication _application;
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
       */
      public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
        _application = (IPatternApplication)newInput_p;
      }
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#dispose()
       */
      public void dispose() {
        _application = null;
      }
      /**
       * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
       */
      public boolean hasChildren(Object element_p) {
        return getChildren(element_p).length > 0;
      }
      /**
       * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
       */
      public Object getParent(Object element_p) {
        return null;
      }
      /**
       * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
       */
      public Object[] getElements(Object inputElement_p) {
        Object[] result = new Object[0];
        if (inputElement_p instanceof IPatternApplication)
          result = ((IPatternApplication)inputElement_p).getPattern().getRoles().toArray();
        return result;
      }
      /**
       * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
       */
      public Object[] getChildren(Object parentElement_p) {
        Object[] result = new Object[0];
        if (parentElement_p instanceof TemplatePatternRole) {
          TemplatePatternRole role = (TemplatePatternRole)parentElement_p;
          ILocation location = _application.getLocation(role);
          if (location == null) {
            result = new Object[] { FAILURE_ELEMENT };
          } else {
            result = LocationsUtil.getMergeTargets(location).toArray();
            if (result.length == 0)
              result = new Object[] { EMPTY_ELEMENT };
          }
        }
        return result;
      }
    });
    treeViewer.setLabelProvider(DiscriminatingLabelProvider.getInstance());
    _data.addPropertyChangeListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event_p) {
        if (DetailedTemplateUsageSpecification.PROPERTY_APPLICATION.equals(
            event_p.getProperty())) {
          getShell().getDisplay().syncExec(new Runnable() {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run() {
              treeViewer.setInput(getData().getApplication());
            }
          });
        }
      }
    });
  }
  
  /**
   * Create the area where the controls for altering the configuration are located
   * @param parent_p a non-null composite
   */
  protected void createConfigurationArea(Composite parent_p) {
    // Composite
    Composite composite = new Composite(parent_p, SWT.NONE);
    GridLayout layout = new GridLayout(2, true);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    composite.setLayout(layout);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    // Check boxes
    createIncludeChildrenCheckBox(composite);
    final Button excludeButton = createExcludeElementsCheckBox(composite);
    final Button deleteRolesButton = createDeleteRolesCheckBox(composite);
    excludeButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        boolean excludeElements = excludeButton.getSelection();
        deleteRolesButton.setEnabled(!excludeElements);
        deleteRolesButton.setSelection(excludeElements || getData().isDeleteRoles());
      }
    });
    createOverridePrimaryCheckBox(composite);
    createIncludeEmptyRolesCheckBox(composite);
    createIncludeDerivationRulesCheckBox(composite);
  }
  
  /**
	 * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
	 */
  @Override
  protected Control createCustomArea(Composite parent_p) {
    Composite result = new Composite(parent_p, SWT.NONE);
    GridData resultLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
    resultLayoutData.heightHint = 400;
    resultLayoutData.widthHint = 300;
    result.setLayoutData(resultLayoutData);
    result.setLayout(new GridLayout(1, false));
    createApplicationArea(result);
    createConfigurationArea(result);
    return result;
  }
  
  /**
   * @see org.eclipse.jface.dialogs.IconAndMessageDialog#createContents(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createContents(Composite parent_p) {
    Control result = super.createContents(parent_p);
    final Button okButton = getButton(OK);
    okButton.setEnabled(false);
    _data.addPropertyChangeListener(new IPropertyChangeListener() {
      /**
       * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
       */
      public void propertyChange(PropertyChangeEvent event_p) {
        if (DetailedTemplateUsageSpecification.PROPERTY_APPLICATION.equals(event_p.getProperty()))
          getShell().getDisplay().syncExec(new Runnable() {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run() {
              boolean ok = getData().isComplete();
              okButton.setEnabled(ok);
            }
          });
      }
    });
    return result;
  }
  
  /**
   * Create and return the corresponding check box
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createDeleteRolesCheckBox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.TemplateUsageDialog_DeleteRoles);
    result.setSelection(getData().isExcludeElements() || getData().isDeleteRoles());
    result.setEnabled(!getData().isExcludeElements());
    // Behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().setDeleteRoles(!getData().isDeleteRoles());
      }
    });
    return result;
  }
  
  /**
   * Create and return the corresponding check box
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createExcludeElementsCheckBox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.TemplateUsageDialog_ExcludeElements);
    result.setSelection(getData().isExcludeElements());
    // Behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().setExcludeElements(!getData().isExcludeElements());
      }
    });
    return result;
  }
  
  /**
   * Create and return the corresponding check box
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createIncludeChildrenCheckBox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.TemplateUsageDialog_IncludeChildren);
    result.setSelection(getData().isIncludeChildren());
    // Behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().setIncludeChildren(!getData().isIncludeChildren());
      }
    });
    return result;
  }
  
  /**
   * Create and return the corresponding check box
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createIncludeEmptyRolesCheckBox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.TemplateUsageDialog_KeepEmptyRoles);
    result.setSelection(getData().isIncludeEmptyRoles());
    // Behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().setIncludeEmptyRoles(!getData().isIncludeEmptyRoles());
      }
    });
    return result;
  }
  
  /**
   * Create and return the corresponding check box
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createIncludeDerivationRulesCheckBox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.TemplateUsageDialog_KeepRules);
    result.setSelection(getData().isIncludeTargetDerivationRules());
    // Behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().setIncludeTargetDerivationRules(!getData().isIncludeTargetDerivationRules());
      }
    });
    return result;
  }
  
  /**
   * Create and return the corresponding check box
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createOverridePrimaryCheckBox(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.CHECK);
    result.setText(Messages.TemplateUsageDialog_OverrideMainRole);
    result.setSelection(getData().isOverridePrimaryName() && getData().isOverridePrimaryDescription());
    // Behavior
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().setOverridePrimaryName(!getData().isOverridePrimaryName());
        getData().setOverridePrimaryDescription(!getData().isOverridePrimaryDescription());
      }
    });
    return result;
  }
  
  /**
   * Return the resulting specification
   * @return a non-null object
   */
  public DetailedTemplateUsageSpecification getData() {
    return _data;
  }
  
}
