/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.RepositoryRegistry;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractPattern;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.diagram.operations.DeletePatternOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.CloseCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.CreateCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.OpenCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IModifiableTemplatePatternSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection.IRepositoryChangedListener;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplateUsageSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.TemplateUsageDialog;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.providers.NameBasedLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard.IPatternImageChangedListener;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.templates.AbstractTemplateUsageWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;


/**
 * A wizard page for presenting a pattern.
 * @author O. CONSTANT
 */
public abstract class AbstractPatternPresentationPage<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
SemanticRepresentationType, GraphicalNodeType, T extends ITemplatePatternBasedSpecification>
extends AbstractPatternPage<T> {

  /** An enumeration for specifying how a pattern is determined */
  public static enum PatternSelectionKind {
    FIXED, // Predefined pattern
    NEW, // New pattern
    SELECTABLE, // Existing pattern to select
    SELECTABLE_WITH_DELETE // Existing pattern to select or delete
  }

  /** How the current pattern is determined */
  protected final PatternSelectionKind _patternSelection;

  /** Whether the current pattern can be edited */
  protected final boolean _patternIsEditable;

  /** The viewer representing the repository, non-null after control creation phase
   * iff the repository can be selected */
  protected ComboViewer _repositoryViewer;

  /** The combo viewer representing the pattern, non-null after control creation phase
   * iff the pattern is editable */
  protected ComboViewer _patternViewer;

  /** The widget representing the version, non-null after control creation phase */
  protected Text _versionWidget;


  /** Dialog and Wizard factory */
  private IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
  SemanticRepresentationType, GraphicalNodeType> _factory = (IPatternDialogAndWizardFactory<ColorType, DiagramElementType, DiagramType, GraphicalContainerType, 
      SemanticRepresentationType, GraphicalNodeType>)PatternsUIPlugin.getDefault().getDialogAndWizardFactory();


  /**
   * Constructor
   * @param pageName_p the non-null name of the page
   * @param pageTitle_p the optional title of the page
   * @param defaultMessage_p a non-null message for the page
   * @param data_p the non-null data under construction
   * @param isBlocking_p whether the page must be completed before the Next button can be clicked
   * @param patternSelection_p how the pattern is determined
   * @param patternIsEditable_p whether the pattern can be edited
   */
  public AbstractPatternPresentationPage(String pageName_p, String pageTitle_p,
      String defaultMessage_p, T data_p, boolean isBlocking_p,
      PatternSelectionKind patternSelection_p, boolean patternIsEditable_p) {
    super(pageName_p, pageTitle_p, defaultMessage_p, data_p, isBlocking_p);
    _patternSelection = patternSelection_p;
    _patternIsEditable = patternIsEditable_p;
    _repositoryViewer = null;
    _patternViewer = null;
    _versionWidget = null;
  }

  /**
   * Create the row dedicated to pattern authors in the given composite
   * @param parent_p a non-null composite
   */
  protected void createAuthorsRow(Composite parent_p) {
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractPatternPresentationPage_Authors);
    final Text text = new Text(parent_p,
        SWT.MULTI | SWT.BORDER);
    if (getData().getPattern() != null)
      text.setText(getMultiEntryString(getData().getPattern().getAuthors()));
    final int MIN_HEIGHT = 1;
    GridData data = new GridData();
    data.verticalSpan = MIN_HEIGHT;
    data.verticalAlignment = SWT.FILL;
    data.horizontalSpan = getGridColumnsNb() - 1;
    data.horizontalAlignment = SWT.FILL;
    data.grabExcessHorizontalSpace = true;
    text.setLayoutData(data);
    for (int i=0; i<MIN_HEIGHT-1; i++)
      addEmptyControl(parent_p);
    text.setEditable(_patternIsEditable);
    // Edit
    if (_patternIsEditable) {
      text.addModifyListener(new ModifyListener() {
        /**
         * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
         */
        public void modifyText(ModifyEvent e_p) {
          String value = text.getText();
          getData().getPattern().getAuthors().clear();
          getData().getPattern().getAuthors().addAll(UIUtil.parseCommaSeparatedString(value));
        }
      });
    }
    // Update
    if (getData() instanceof ITemplatePatternSelection) {
      ((ITemplatePatternSelection)getData()).addSelectedPatternListener(
          new ITemplatePatternSelection.IPatternChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
             */
            public void patternChanged(TemplatePattern newPattern_p) {
              String newText = newPattern_p == null? "": getMultiEntryString(newPattern_p.getAuthors()); //$NON-NLS-1$
              text.setText(newText);
            }
          });
    }
  }

  /**
   * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  public void createControl(Composite parent_p) {
    Composite composite = new Composite(parent_p, SWT.NONE);
    setControl(composite);
    setDefaultMessage();
    createPatternPresentation(composite);
    // Initial selection: repository
    IPatternRepository initialRepository = getData().getRepository();
    if (initialRepository == null) {
      RepositoryRegistry registry =
          CorePatternsPlugin.getDefault().getRepositoryRegistry();
      if (!registry.getRepositories().isEmpty() && _repositoryViewer != null)
        _repositoryViewer.setSelection(new StructuredSelection(
            registry.getRepositories().iterator().next()));
    }
    TemplatePattern initialPattern = getData().getPattern();
    if (initialRepository != null && _repositoryViewer != null)
      _repositoryViewer.setSelection(new StructuredSelection(initialRepository));
    // Initial selection: pattern
    if (initialPattern != null && _patternViewer != null)
      _patternViewer.setSelection(new StructuredSelection(initialPattern));
  }

  /**
   * Create a row for altering the filtering of patterns
   * @param parent_p
   */
  protected void createPatternFilterRow(Composite parent_p) {
    // Nothing by default
  }

  /**
   * Create all pattern presentation controls in the given composite
   * @param parent_p a non-null composite
   */
  protected void createPatternPresentation(Composite parent_p) {
    Layout mainCompositeLayout = new GridLayout(getGridColumnsNb(), false);
    parent_p.setLayout(mainCompositeLayout);
    _repositoryViewer = createRepositoryRow(parent_p);
    createPatternFilterRow(parent_p);
    _patternViewer = createPatternRow(parent_p);
    _versionWidget = createVersionRow(parent_p);
    createEnvironmentsRow(parent_p);
    createAuthorsRow(parent_p);
    createDescriptionRow(parent_p);
    createImageRow(parent_p);
    if (_patternIsEditable) {
      createLayoutRow(parent_p);
      createTemplateButton(parent_p);
    }
  }

  /**
   * Create and return the "Delete pattern" button
   * @param parent_p a non-null composite
   */
  protected Button createDeletePatternButton(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    // Set size so that it looks like the button above
    result.setText(Messages.AbstractPatternPresentationPage_Open);
    Point size = result.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
    result.setText(Messages.AbstractPatternPresentationPage_DeleteButton);
    GridData deleteGridData = new GridData(SWT.FILL, SWT.FILL, false, false);
    deleteGridData.widthHint = size.x;
    result.setLayoutData(deleteGridData);
    // Selection
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        deletePattern();
      }
    });
    // Update
    result.setEnabled(getData().getPattern() != null);
    if (getData() instanceof ITemplatePatternSelection) {
      ((ITemplatePatternSelection)getData()).addSelectedPatternListener(
          new ITemplatePatternSelection.IPatternChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(TemplatePattern)
             */
            public void patternChanged(TemplatePattern newPattern_p) {
              result.setEnabled(newPattern_p != null);
            }
          });
    }
    return result;
  }

  /**
   * Create the row dedicated to pattern description in the given composite
   * @param parent_p a non-null composite
   */
  protected void createDescriptionRow(Composite parent_p) {
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractPatternPresentationPage_Description);
    final Text text = new Text(parent_p,
        SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
    if (getData().getPattern() != null)
      text.setText(nonNull(getData().getPattern().getDescription()));
    final int MIN_HEIGHT = 4;
    GridData data = new GridData(
        SWT.FILL, SWT.FILL, true, false, getGridColumnsNb() - 1, MIN_HEIGHT);
    text.setLayoutData(data);
    for (int i=0; i<MIN_HEIGHT-1; i++)
      addEmptyControl(parent_p);
    text.setEditable(_patternIsEditable);
    // Edit
    if (_patternIsEditable) {
      text.addModifyListener(new ModifyListener() {
        /**
         * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
         */
        public void modifyText(ModifyEvent e_p) {
          String value = text.getText();
          ((AbstractPattern)getData().getPattern()).setDescription(value);
        }
      });
    }
    // Update
    if (getData() instanceof ITemplatePatternSelection) {
      ((ITemplatePatternSelection)getData()).addSelectedPatternListener(
          new ITemplatePatternSelection.IPatternChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
             */
            public void patternChanged(TemplatePattern newPattern_p) {
              String newText = newPattern_p == null? "": nonNull(newPattern_p.getDescription()); //$NON-NLS-1$
              text.setText(newText);
            }
          });
    }
  }

  /**
   * Create the row dedicated to pattern environments in the given composite
   * @param parent_p a non-null composite
   */
  protected void createEnvironmentsRow(Composite parent_p) {
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractPatternPresentationPage_Environments);
    final Text text = new Text(parent_p, SWT.MULTI | SWT.BORDER);
    if (getData().getPattern() != null)
      text.setText(getMultiEntryString(getData().getPattern().getExecutionEnvironments()));
    final int MIN_HEIGHT = 1;
    GridData data = new GridData();
    data.verticalSpan = MIN_HEIGHT;
    data.verticalAlignment = SWT.FILL;
    data.horizontalSpan = getGridColumnsNb() - 1;
    data.horizontalAlignment = SWT.FILL;
    data.grabExcessHorizontalSpace = true;
    text.setLayoutData(data);
    for (int i=0; i<MIN_HEIGHT-1; i++)
      addEmptyControl(parent_p);
    text.setEditable(_patternIsEditable);
    // Edit
    if (_patternIsEditable) {
      text.addModifyListener(new ModifyListener() {
        /**
         * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
         */
        public void modifyText(ModifyEvent e_p) {
          String value = text.getText();
          getData().getPattern().getExecutionEnvironments().clear();
          getData().getPattern().getExecutionEnvironments().addAll(
              UIUtil.parseCommaSeparatedString(value));
        }
      });
    }
    // Update
    if (getData() instanceof ITemplatePatternSelection) {
      ((ITemplatePatternSelection)getData()).addSelectedPatternListener(
          new ITemplatePatternSelection.IPatternChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
             */
            public void patternChanged(TemplatePattern newPattern_p) {
              String newText = newPattern_p == null? "": //$NON-NLS-1$
                getMultiEntryString(newPattern_p.getExecutionEnvironments());
              text.setText(newText);
            }
          });
    }
  }

  /**
   * Create the row dedicated to pattern image in the given composite
   * @param parent_p a non-null composite
   */
  protected void createImageRow(Composite parent_p) {
    // Left control ("image:")
    final Control leftControl;
    final String leftControlText = Messages.AbstractPatternPresentationPage_Image;
    if (_patternIsEditable) {
      final IModifiableTemplatePatternSpecification modifiableData =
          (IModifiableTemplatePatternSpecification)getData();
      final Button checkButton = new Button(parent_p, SWT.CHECK);
      checkButton.setText(leftControlText);
      checkButton.setSelection(modifiableData.acceptNewPatternImage());
      checkButton.addSelectionListener(new SelectionAdapter() {
        /**
         * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        @Override
        public void widgetSelected(SelectionEvent e) {
          boolean selected = checkButton.getSelection();
          modifiableData.setAcceptNewPatternImage(selected);
          if (selected)
            getWizard().computePatternImageFromGraphicalContext(true);
          else
            setPatternImageToDefault();
        }
      });
      checkButton.setEnabled(getWizard().mayHaveImage());
      leftControl = checkButton;
    } else {
      leftControl = new Label(parent_p, SWT.NONE);
      ((Label)leftControl).setText(leftControlText);
    }
    GridData gd = new GridData(SWT.LEFT, SWT.TOP, false, false);
    leftControl.setLayoutData(gd);
    // Canvas for image
    final Canvas canvas = new Canvas(parent_p, SWT.BORDER);
    final int MIN_HEIGHT = 1;
    GridData data = new GridData(
        SWT.FILL, SWT.FILL, true, true, getGridColumnsNb() - 1, MIN_HEIGHT);
    canvas.setLayoutData(data);
    for (int i=0; i<MIN_HEIGHT-1; i++)
      addEmptyControl(parent_p);
    canvas.addPaintListener(new PaintListener() {
      /**
       * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
       */
      public void paintControl(PaintEvent e_p) {
        Image image = getWizard().getPatternImage();
        if (image != null) {
          int maxWidth = canvas.getBounds().width;
          int maxHeight = canvas.getBounds().height;
          ImageData imageData = null;
          try {
            imageData = image.getImageData();
            Point newSize = UIUtil.getBoundedImageSize(imageData, maxWidth, maxHeight);
            e_p.gc.drawImage(image, 0, 0, imageData.width, imageData.height, 0, 0, newSize.x, newSize.y);
          } catch (Exception e) {
            // Do not repaint
          }
        }
      }
    });
    // Update
    getWizard().addSelectedPatternListener(new IPatternImageChangedListener() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternWizard.IPatternImageChangedListener#patternImageChanged(org.eclipse.swt.graphics.Image)
       */
      public void patternImageChanged(Image newImage_p) {
        if (!canvas.isDisposed())
          canvas.redraw();
      }
    });
  }

  /**
   * Create the row dedicated to pattern layout
   * @param parent_p a non-null composite
   */
  protected void createLayoutRow(Composite parent_p) {
    // Precondition: _patternIsEditable
    final Button includeLayoutButton = new Button(parent_p, SWT.CHECK);
    includeLayoutButton.setText(Messages.AbstractPatternPresentationPage_IncludeLayoutAndStyle);
    final IModifiableTemplatePatternSpecification modifiableData =
        (IModifiableTemplatePatternSpecification)getData();
    includeLayoutButton.setSelection(
        getWizard().mayHaveImage() && modifiableData.includeLayoutData());
    includeLayoutButton.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        boolean selected = includeLayoutButton.getSelection();
        modifiableData.setIncludeLayoutData(selected);
      }
    });
    includeLayoutButton.setEnabled(getWizard().mayHaveImage());
    GridData gd = new GridData(
        SWT.LEFT, SWT.TOP, false, false, getGridColumnsNb(), 1);
    includeLayoutButton.setLayoutData(gd);
  }

  /**
   * Create the row dedicated to pattern selection in the given composite
   * @param parent_p a non-null composite
   * @return a combo viewer representing the pattern if non editable, null otherwise
   */
  protected ComboViewer createPatternRow(Composite parent_p) {
    ComboViewer result;
    if (_patternIsEditable) {
      createEditablePatternRow(parent_p);
      result = null;
    } else {
      result = createExistingPatternRow(parent_p);
    }
    return result;
  }

  /**
   * Create the row dedicated to an existing pattern in the given composite
   * @param parent_p a non-null composite
   * @return a non-null combo viewer
   */
  protected ComboViewer createExistingPatternRow(Composite parent_p) {
    // Label
    new Label(parent_p, SWT.NONE).setText(getExistingPatternRowLabel());
    // Main group
    Composite group = new Composite(parent_p, SWT.NONE);
    GridData groupData = new GridData(SWT.FILL, SWT.FILL, true, false);
    GridLayout groupLayout = new GridLayout(2, false);
    groupLayout.marginHeight = 0;
    groupLayout.marginWidth = 0;
    group.setLayoutData(groupData);
    group.setLayout(groupLayout);
    // Combo
    final Combo combo = new Combo(group, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
    GridData gd = new GridData();
    gd.horizontalAlignment = GridData.FILL;
    gd.grabExcessHorizontalSpace = true;
    combo.setLayoutData(gd);
    // Viewer for combo
    final ComboViewer comboViewer = new ComboViewer(combo);
    comboViewer.setLabelProvider(DiscriminatingLabelProvider.getInstance());
    comboViewer.addFilter(new ViewerFilter() {
      /**
       * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
       */
      @Override
      public boolean select(Viewer viewer_p, Object parentElement_p, Object element_p) {
        boolean result = false;
        if (element_p instanceof TemplatePattern)
          result = getData().isAcceptable((TemplatePattern)element_p);
        return result;
      }
    });
    comboViewer.setContentProvider(new IStructuredContentProvider() {
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
       */
      public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
        // Nothing needed
      }
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#dispose()
       */
      public void dispose() {
        // No proper data
      }
      /**
       * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
       */
      public Object[] getElements(Object inputElement_p) {
        Object[] result = new Object[0];
        if (inputElement_p instanceof IPatternRepository) {
          IPatternRepository repository = (IPatternRepository)inputElement_p;
          result = repository.getPatterns().toArray();
        }
        return result;
      }
    });
    comboViewer.setSorter(new ViewerSorter());
    if (getData() instanceof IRepositorySelection)
      comboViewer.setInput(((IRepositorySelection)getData()).getRepository());
    // Combo viewer: Selection
    comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        IStructuredSelection selection = (IStructuredSelection)comboViewer.getSelection();
        Object selected = selection.getFirstElement();
        if (selected instanceof TemplatePattern && getData() instanceof ITemplatePatternSelection) {
          ((ITemplatePatternSelection)getData()).setPattern((TemplatePattern)selected);
          validate();
        }
      }
    });
    // Combo viewer: Update
    if (getData() instanceof IRepositorySelection)
      ((IRepositorySelection)getData()).addSelectedRepositoryListener(
          new IRepositorySelection.IRepositoryChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection.IRepositoryChangedListener#repositoryChanged(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
             */
            public void repositoryChanged(IPatternRepository newRepository_p) {
              comboViewer.setInput(newRepository_p);
              TemplatePattern defaultPattern = null;
              if (newRepository_p != null) {
                for (IPattern pattern : newRepository_p.getPatterns()) {
                  if (pattern instanceof TemplatePattern) {
                    TemplatePattern current = (TemplatePattern)newRepository_p.getPatterns().get(0);
                    if (getData().isAcceptable(current)) {
                      defaultPattern = current;
                      break;
                    }
                  }
                }
              }
              comboViewer.setSelection(NonUserSelection.newInstance(defaultPattern));
              if (getData() instanceof ITemplatePatternSelection) {
                ((ITemplatePatternSelection)getData()).setPattern(defaultPattern);
                validate();
              }
            }
          });
    // Delete button
    if (_patternSelection == PatternSelectionKind.SELECTABLE_WITH_DELETE)
      createDeletePatternButton(group);
    // End of line
    finishRow(parent_p, true);
    return comboViewer;
  }

  /**
   * Create the row dedicated to new pattern name in the given composite
   * @param parent_p a non-null composite
   * @return a non-null text widget
   */
  protected Text createEditablePatternRow(Composite parent_p) {
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractPatternPresentationPage_Name);
    final Text result = new Text(parent_p, SWT.SINGLE | SWT.BORDER);
    if (getData().getPattern() != null)
      result.setText(getData().getPattern().getName());
    result.addModifyListener(new ModifyListener() {
      /**
       * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
       */
      public void modifyText(ModifyEvent e_p) {
        String value = result.getText();
        ((AbstractPattern)getData().getPattern()).setName(value);
        validate();
      }
    });
    finishRow(parent_p, true);
    selectTextContent(result);
    return result;
  }

  /**
   * Create the row dedicated to pattern repository in the given composite
   * @param parent_p a non-null composite
   * @return a viewer for the repository, non-null iff repository can be changed
   */
  protected ComboViewer createRepositoryRow(Composite parent_p) {
    ComboViewer result = null;
    // Label
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractPatternPresentationPage_Catalog);
    if (_patternSelection == PatternSelectionKind.FIXED) {
      // Fixed repository
      final Text text = new Text(parent_p, SWT.BORDER);
      PatternRepository repository = (PatternRepository)getData().getRepository();
      text.setText(NameBasedLabelProvider.getInstance().getText(repository));
      text.setEditable(false);
      // Layout
      GridData gd = new GridData(GridData.FILL, GridData.FILL, true, false, 3, 1);
      text.setLayoutData(gd);
    } else {
      // Selectable repository
      result = createRepositorySelectionRow(parent_p);
    }
    finishRow(parent_p, false);
    return result;
  }

  /**
   * Create the row end dedicated to repository selection
   * @param parent_p a non-null composite
   * @return a non-null viewer for the repository
   */
  protected ComboViewer createRepositorySelectionRow(Composite parent_p)  {
    // Repository choice viewer
    ComboViewer result = createRepositoryChoiceViewer(parent_p);
    // Buttons group
    Composite buttonsGroup = new Composite(parent_p, SWT.NONE);
    int nbButtons = _patternSelection == PatternSelectionKind.NEW? 3: 2;
    buttonsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
    GridLayout buttonsGroupLayout = new GridLayout(nbButtons, true);
    buttonsGroupLayout.marginHeight = 0;
    buttonsGroupLayout.marginWidth = 0;
    buttonsGroup.setLayout(buttonsGroupLayout);
    // Open catalog button
    createRepositoryOpenButton(buttonsGroup, result);
    // Close catalog button
    createRepositoryCloseButton(buttonsGroup, result);
    // New catalog button
    if (_patternSelection == PatternSelectionKind.NEW)
      createRepositoryNewButton(buttonsGroup, result);
    // Initialization
    RepositoryRegistry registry =
        CorePatternsPlugin.getDefault().getRepositoryRegistry();
    result.setInput(registry);
    return result;
  }

  /**
   * Create and return the viewer for repository selection
   * @param parent_p a non-null composite
   * @return a non-null viewer
   */
  protected ComboViewer createRepositoryChoiceViewer(Composite parent_p) {
    // Combo
    final Combo combo = new Combo(parent_p, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
    GridData gd = new GridData();
    gd.horizontalAlignment = GridData.FILL;
    gd.grabExcessHorizontalSpace = true;
    combo.setLayoutData(gd);
    // Viewer
    final ComboViewer result = new ComboViewer(combo);
    result.setLabelProvider(NameBasedLabelProvider.getInstance());
    result.setContentProvider(new IStructuredContentProvider() {
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
       */
      public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
        // Nothing needed
      }
      /**
       * @see org.eclipse.jface.viewers.IContentProvider#dispose()
       */
      public void dispose() {
        // No owned data
      }
      /**
       * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
       */
      public Object[] getElements(Object inputElement_p) {
        Object[] elements = new Object[0];
        if (inputElement_p instanceof RepositoryRegistry) {
          RepositoryRegistry registry = (RepositoryRegistry)inputElement_p;
          elements = registry.getRepositories().toArray();
        }
        return elements;
      }
    });
    // Combo selection
    result.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        IStructuredSelection selection = (IStructuredSelection)result.getSelection();
        if (getData() instanceof IRepositorySelection) {
          IPatternRepository selected = null;
          if (!selection.isEmpty())
            selected = (IPatternRepository)selection.getFirstElement();
          ((IRepositorySelection)getData()).setRepository(selected);
          validate();
        }
      }
    });
    result.setSorter(new ViewerSorter());
    return result;
  }

  /**
   * Create and return the "close repository" button
   * @param parent_p a non-null composite
   * @param repositoryViewer_p a non-null viewer
   * @return a non-null button
   */
  protected Button createRepositoryCloseButton(Composite parent_p,
      final ComboViewer repositoryViewer_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractPatternPresentationPage_Close);
    result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
    result.setEnabled(false);
    if (getData() instanceof IRepositorySelection) {
      ((IRepositorySelection)getData()).addSelectedRepositoryListener(
          new IRepositoryChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection.IRepositoryChangedListener#repositoryChanged(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
             */
            public void repositoryChanged(IPatternRepository newRepository_p) {
              result.setEnabled(newRepository_p != null);
            }
          });
    }
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        IStructuredSelection selection = (IStructuredSelection)repositoryViewer_p.getSelection();
        if (!selection.isEmpty()) {
          int selectionIndex = repositoryViewer_p.getCombo().getSelectionIndex();
          IPatternRepository repository = (IPatternRepository)selection.getFirstElement();
          CloseCatalogOperation operation = new CloseCatalogOperation((PatternRepository)repository);
          CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
          getWizard().notifyRepositoryRegistryChanged();
          repositoryViewer_p.refresh(false);
          // Update selection
          IPatternRepository atSamePosition = (IPatternRepository)repositoryViewer_p.getElementAt(
              selectionIndex);
          if (atSamePosition == null)
            atSamePosition = (IPatternRepository)repositoryViewer_p.getElementAt(
                selectionIndex-1);
          IStructuredSelection newSelection;
          if (atSamePosition == null)
            newSelection = new StructuredSelection();
          else
            newSelection = new StructuredSelection(atSamePosition);
          repositoryViewer_p.setSelection(newSelection);
        }
      }
    });
    return result;
  }

  /**
   * Create and return the "new repository" button
   * @param parent_p a non-null composite
   * @param repositoryViewer_p a non-null viewer
   * @return a non-null button
   */
  protected Button createRepositoryNewButton(Composite parent_p,
      final StructuredViewer repositoryViewer_p) {
    Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractPatternPresentationPage_New);
    result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        Object scopeElement = getData().getScopeElement();
        TransactionalEditingDomain domain = CorePatternsPlugin.getDefault().getModelEnvironment().getCommonCatalogEditingDomain();
        Resource resource = scopeElement instanceof EObject? ((EObject)scopeElement).eResource():
          (Resource)scopeElement;
        if(domain != null){
          ResourceSet rset = domain.getResourceSet();
          IFile file = UIUtil.promptForNewCatalogFile(getShell(), resource, rset);
          if (file != null) {
            CreateCatalogOperation operation = new CreateCatalogOperation(
                file, domain, scopeElement);
            IPatternRepository created =
                CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
            if (created != null) {
              repositoryViewer_p.refresh(false);
              repositoryViewer_p.setSelection(new StructuredSelection(created));
            }
          }
        }
      }   
    });
    return result;
  }

  /**
   * Create and return the "open repository" button
   * @param parent_p a non-null composite
   * @param repositoryViewer_p a non-null viewer
   * @return a non-null button
   */
  protected Button createRepositoryOpenButton(Composite parent_p,
      final StructuredViewer repositoryViewer_p) {
    Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractPatternPresentationPage_Open);
    result.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        Object scopeElement = getData().getScopeElement();
        TransactionalEditingDomain domain = CorePatternsPlugin.getDefault().getModelEnvironment().getCommonCatalogEditingDomain();
        Resource resource = scopeElement instanceof EObject? ((EObject)scopeElement).eResource():
          (scopeElement instanceof Resource? (Resource)scopeElement: null);
       if(domain != null){
          ResourceSet rset = domain.getResourceSet();
          List<IFile> files = UIUtil.promptForExistingCatalogs(getShell(), resource, rset);
          if (!files.isEmpty()) {
            Iterator<IFile> it = files.iterator();
            Collection<PatternRepository> opened = new ArrayList<PatternRepository>();
            while(it.hasNext()){
              IFile current = it.next();
              OpenCatalogOperation operation = new OpenCatalogOperation(current, domain);
              opened.addAll(CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation));
              if (!operation.getErrors().isEmpty()){
                UIUtil.informRepositoryOpeningError(getShell(), operation.getErrors());
                return;
              }
            }
            if (!opened.isEmpty()) {
              getWizard().notifyRepositoryRegistryChanged();
              repositoryViewer_p.refresh(false);
              IPatternRepository toSelect = opened.iterator().next();
              repositoryViewer_p.setSelection(new StructuredSelection(toSelect));
            }
          }
        }
      }
    });
    return result;
  }

  /**
   * Create and return the "use template" button
   * @param parent_p a non-null composite
   * @return a non-null button
   */
  protected Button createTemplateButton(Composite parent_p) {
    final Button result = new Button(parent_p, SWT.PUSH);
    result.setText(Messages.AbstractPatternPresentationPage_UseTemplate);
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        if (getData().getPattern() != null &&
            TemplateUsageSpecification.isReadyForTemplateUsage(getData().getPattern())) {
          final int VECTOR = 50;
          Point location = getShell().getLocation();
          Point newLocation = new Point(location.x + VECTOR, location.y + VECTOR);
          AbstractTemplateUsageWizard<ColorType, DiagramElementType, 
          DiagramType, GraphicalContainerType, SemanticRepresentationType, GraphicalNodeType>
          wizard = instantiateTemplateUsageWizard((AbstractModifiableTemplatePatternSpecification)getData());
          //new AbstractTemplateUsageWizard((AbstractModifiableTemplatePatternSpecification)getData());
          PatternWizardDialog dialog = new PatternWizardDialog(
              getShell(), wizard, false, newLocation);
          int answer = dialog.open();
          if (wizard.repositoryRegistryChanged())
            _repositoryViewer.refresh(false);
          if (Window.OK == answer) {
            useTemplate(wizard.getData());
          }
        } else {
          String message = (getData().getPattern() == null || !getData().getPattern().isTemplate())?
              Messages.AbstractPatternPresentationPage_TemplateApplicability:
                Messages.AbstractPatternPresentationPage_TemplateApplicabilityOnTemplate;
          MessageDialog.openError(
              getShell(), CorePatternsPlugin.getDefault().getLabel(), message);
        }
      }
    });
    return result;
  }

  protected AbstractTemplateUsageWizard<ColorType, DiagramElementType, 
  DiagramType, GraphicalContainerType, SemanticRepresentationType, GraphicalNodeType>
  instantiateTemplateUsageWizard(AbstractModifiableTemplatePatternSpecification data_p){
    if(_factory != null){
      return _factory.instantiateTemplateUsageWizard(data_p);
    }
    return null;
  }

  /**
   * Create the row dedicated to pattern version in the given composite
   * @param parent_p a non-null composite
   * @return a non-null text widget representing the version
   */
  protected Text createVersionRow(Composite parent_p) {
    new Label(parent_p, SWT.NONE).setText(Messages.AbstractPatternPresentationPage_Version);
    final Text result = new Text(parent_p, SWT.SINGLE | SWT.BORDER);
    if (getData().getPattern() != null)
      result.setText(nonNull(getData().getPattern().getVersion()));
    finishRow(parent_p, true);
    result.setEditable(_patternIsEditable);
    // Edit
    if (_patternIsEditable) {
      result.addModifyListener(new ModifyListener() {
        /**
         * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
         */
        public void modifyText(ModifyEvent e_p) {
          String value = result.getText();
          ((AbstractPattern)getData().getPattern()).setVersion(value);
          validate();
        }
      });
    }
    // Update
    if (getData() instanceof ITemplatePatternSelection) {
      ((ITemplatePatternSelection)getData()).addSelectedPatternListener(
          new ITemplatePatternSelection.IPatternChangedListener() {
            /**
             * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternSelection.IPatternChangedListener#patternChanged(org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern)
             */
            public void patternChanged(TemplatePattern newPattern_p) {
              String newText = newPattern_p == null? "": nonNull(newPattern_p.getVersion()); //$NON-NLS-1$
              result.setText(newText);
            }
          });
    }
    return result;
  }

  /**
   * Delete the selected pattern, involving an interaction with the user
   */
  protected void deletePattern() {
    final TemplatePattern pattern = getData().getPattern();
    final List<IPatternInstance> instances = new ArrayList<IPatternInstance>();
    Object context = getData().getScopeElement();
    if (context instanceof EObject) {
      IPatternSupport support =
          CorePatternsPlugin.getDefault().getPatternSupportFor((EObject)context);
      if (support != null) {
        List<IPatternInstance> allInstances = support.getAllInstances(context);
        for (IPatternInstance instance : allInstances) {
          if (instance.getPattern() == pattern)
            instances.add(instance);
        }
      }
    }
    final boolean instancesDetected = !instances.isEmpty();
    final Collection<Object> emptyIfInstancesUntouched =
        new ArrayList<Object>(1);
    final Object flag = new Object();
    if (instancesDetected)
      emptyIfInstancesUntouched.add(flag);
    String message = String.format(
        Messages.AbstractPatternPresentationPage_ConfirmPatternDeletion, pattern.getName());
    MessageDialog confirmationDialog = new MessageDialog(
        getShell(), Messages.AbstractPatternPresentationPage_TitlePatternDeletion,
        null, message, MessageDialog.CONFIRM,
        new String[] { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL },
        0) {
      /**
       * @see MessageDialog#createCustomArea(Composite)
       */
      @Override
      protected Control createCustomArea(Composite parent_p) {
        Group result = new Group(parent_p, SWT.NONE);
        result.setText(Messages.AbstractPatternPresentationPage_InstancesDeletionGroup);
        result.setLayout(new GridLayout(1, true));
        new Label(result, SWT.NONE).setText(
            String.format(Messages.AbstractPatternPresentationPage_DetectedInstances,
                Integer.valueOf(instances.size())));
        final Button checkbox = new Button(result, SWT.CHECK);
        checkbox.setEnabled(instancesDetected);
        checkbox.setSelection(!emptyIfInstancesUntouched.isEmpty());
        checkbox.setText(Messages.AbstractPatternPresentationPage_DeleteInstancesWithPattern);
        checkbox.addSelectionListener(new SelectionAdapter() {
          /**
           * @see SelectionAdapter#widgetSelected(SelectionEvent)
           */
          @Override
          public void widgetSelected(SelectionEvent e) {
            if (emptyIfInstancesUntouched.isEmpty())
              emptyIfInstancesUntouched.add(flag);
            else
              emptyIfInstancesUntouched.clear();
          }
        });
        return result;
      }
    };
    boolean confirmed = confirmationDialog.open() == 0;
    if (confirmed) {
      DeletePatternOperation operation = new DeletePatternOperation(pattern, instances, getData().getScopeElement());
      List<IPatternInstance> deleted =
          CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
      if (deleted == null) {
        MessageDialog.openError(getShell(),
            Messages.AbstractPatternPresentationPage_TitlePatternDeletion,
            Messages.AbstractPatternPresentationPage_Failure);
      } else {
        if (getData() instanceof IRepositorySelection) {
          IRepositorySelection data = (IRepositorySelection)getData();
          data.setRepository(data.getRepository());
        }
      }
    }
  }

  /**
   * Return the number of columns in the grid layout of the main composite
   */
  protected int getGridColumnsNb() {
    return 4;
  }

  /**
   * Return a text for the SWT label of the "existing pattern" row
   * @return a non-null string
   */
  protected String getExistingPatternRowLabel() {
    return Messages.AbstractPatternPresentationPage_Pattern;
  }

  /**
   * Set the pattern image to the default one, i.e., to the "no change" state
   */
  protected void setPatternImageToDefault() {
    // Nothing by default; redefine if needed
  }

  /**
   * Use a template as specified by the given data
   * @param data_p a non-null object
   */
  protected void useTemplate(TemplateUsageSpecification data_p) {
    final TemplateUsageDialog dialog = new TemplateUsageDialog(getShell(), data_p);
    int answer = dialog.open();
    if (Window.OK == answer) {
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
                dialog.getData().execute();
              }
            });
          }
        });
      } catch(Exception e) {
        // Proceed
      }
    }
  }

}
