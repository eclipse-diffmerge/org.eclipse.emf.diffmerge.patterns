/**
 * <copyright>
 * 
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.patterns.ui.viewers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPattern;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternSymbol;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IPatternSupport;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.misc.UnresolvedElement;
import org.eclipse.emf.diffmerge.patterns.diagrams.misc.UnresolvedPattern;
import org.eclipse.emf.diffmerge.patterns.diagrams.misc.UnresolvedRepository;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin.ImageID;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.providers.NameBasedLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil.LabelBasedComparator;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;
import org.eclipse.emf.diffmerge.structures.common.FArrayList;
import org.eclipse.emf.diffmerge.structures.common.FHashMap;
import org.eclipse.emf.diffmerge.structures.common.FOrderedSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * A View for exploring pattern instances.
 * @author Olivier Constant
 */
public abstract class AbstractInstanceExplorerView extends ViewPart{

  /** The viewer for the central tree */
  protected TreeViewer _viewer;

  /** The header widget, non-null after initialization */
  protected TabbedPropertyTitle _header;

  /** The default title of the view */
  private static final String DEFAULT_TITLE = Messages.InstanceExplorerView_NotAvailable;

  /** The non-null, potentially empty set of pattern instances to represent */
  protected List<IPatternInstance> _instanceList;

  /** The non-null, potentially empty initial selection */
  protected List<IPatternInstance> _initialSelection;

  /** An optional reference element for roles identification */
  protected EObject _referenceElement;

  /** An optional element for instance scope */
  protected EObject _contextElement;

  /** Dialog and Wizard factory */
  protected IPatternDialogAndWizardFactory _dialogAndWizardFactory;

  /** Utility class instance used to call diagram-related services from the graphical framework (Sirius for example) */
  protected AbstractDiagramUtil _diagramUtil;

  /**
   * Constructor
   */
  public AbstractInstanceExplorerView(){
    super();
    _dialogAndWizardFactory = PatternsUIPlugin.getDefault().getDialogAndWizardFactory();
    _diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    _instanceList = new FOrderedSet<IPatternInstance>();
    _initialSelection = new FOrderedSet<IPatternInstance>();
    _referenceElement = null;
    _contextElement = null;
  }
  
  /**
   * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createPartControl(Composite parent_p) {
    // Parent layout
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    layout.verticalSpacing = 0;
    layout.horizontalSpacing = 0;
    parent_p.setLayout(layout);
    // Header
    _header = new TabbedPropertyTitle(parent_p, new TabbedPropertySheetWidgetFactory());
    GridData titleLayoutData = new GridData(GridData.FILL_HORIZONTAL);
    titleLayoutData.grabExcessVerticalSpace = false;
    _header.setLayoutData(titleLayoutData);
    _header.setTitle(DEFAULT_TITLE, null);
    // Main viewer
    _viewer = new TreeViewer(parent_p);
    _viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    _viewer.setLabelProvider(getLabelProvider());
    _viewer.setContentProvider(new InstanceExplorerContentProvider());
    // Menu context
    createContextMenu(_viewer);
    // Initialization
    createMouseActions(_viewer.getTree());
    createToolbarActions();
    getViewSite().setSelectionProvider(_viewer);

  }

  /**
   * Set the current input of this view
   * @param selection_p a potentially null selection
   */
  public abstract void setInput(ISelection selection_p);

  /**
   * Create the actions available in the toolbar of the view
   */
  private void createToolbarActions() {
    IActionBars actionBars = getViewSite().getActionBars();
    IToolBarManager toolbarManager = actionBars.getToolBarManager();
    toolbarManager.add(
        new Action(Messages.InstanceExplorerView_Refresh,
            PatternsUIPlugin.getDefault().getImageDescriptor(ImageID.REFRESH)) {
          /**
           * @see org.eclipse.jface.action.Action#run()
           */
          @Override
          public void run() {
            refreshCurrent();
          }
        });
  }

  /**
   * Refresh the viewer by rebuilding the tree entirely
   */
  public void refreshCurrent() {
    if (_contextElement != null) {
      Collection<IPatternInstance> instances = getAllInstances(_contextElement);
      _instanceList.clear();
      _instanceList.addAll(instances);
      _viewer.setInput(_instanceList);
    } else {
      _viewer.setInput(_viewer.getInput());
    }
  }

  /**
   * Create the context menu
   * @param viewer_p a non-null viewer
   */
  private void createContextMenu(final TreeViewer viewer_p) {
    Menu treeMenu = new Menu(getShell());
    createMenuItems(treeMenu);
    final MenuManager menuManager = new MenuManager(Messages.InstanceExplorerView_General, null);
    viewer_p.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        boolean enable = true;
        List<Object> selection = getSelection();
        for (Object selected : selection) {
          if (!(selected instanceof EObject)) {
            enable = false;
            break;
          }
        }
        menuManager.getMenu().getParentItem().setEnabled(enable);
      }
    });
    getSite().registerContextMenu(menuManager, viewer_p);
    menuManager.fill(treeMenu, -1);
    viewer_p.getTree().setMenu(treeMenu);
  }

  /**
   * Create the menu items of the tree
   * @param menu_p a non-null menu
   */
  private void createMenuItems(Menu menu_p) {
    createOpenBrowseMenuItem(menu_p);
    createManageInstancesMenuItem(menu_p);
  }

  /**
   * Create and return the "open catalog" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createOpenBrowseMenuItem(Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.InstanceExplorerView_OpenBrowse);
    // Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        if (selectionContainsUnresolved()) {
          result.setEnabled(true);
        } else {
          boolean enable = false;
          List<Object> selection = getSelection();
          if (selection.size() == 1) {
            Object selected = selection.get(0);
            enable = selected instanceof TemplatePattern ||
                selected instanceof IPatternRepository;
          }
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
      public void widgetSelected(SelectionEvent e_p) {
        List<Object> selection = getSelection();
        if (!selection.isEmpty()) {
          Object selected = selection.get(0);
          if (selectionContainsUnresolved()) {
            // Unresolved elements
            resolveSelection();
          } else if (selected instanceof IPatternRepository) {
            // Pattern repository
            browseRepository((IPatternRepository)selected);
          } else if (selected instanceof TemplatePattern) {
            // Pattern repository
            browsePattern((TemplatePattern)selected);
          }
        }
      }
    });
    return result;
  }

  /**
   * Browse the given pattern
   * @param pattern_p a potentially null pattern
   */
  protected void browsePattern(TemplatePattern pattern_p) {
    IPatternInstance first = _instanceList.isEmpty()? null: _instanceList.get(0);
    EObject context = first instanceof EObject? (EObject)first: null;
    AbstractPatternBrowsingWizard wizard = instantiatePatternBrowsingWizard(context, pattern_p);
    PatternWizardDialog dialog = new PatternWizardDialog(
        getShell(), wizard, true, null);
    dialog.open();
    if (wizard.repositoryRegistryChanged())
      refreshCurrent();
  }

  /**
   * Browse the given repository
   * @param repository_p a potentially null repository
   */
  protected void browseRepository(IPatternRepository repository_p) {
    IPatternInstance first = _instanceList.isEmpty()? null: _instanceList.get(0);
    EObject context = first instanceof EObject? (EObject)first: null;
    AbstractPatternBrowsingWizard wizard = instantiatePatternBrowsingWizard(context, repository_p);
    PatternWizardDialog dialog = new PatternWizardDialog(
        getShell(), wizard, true, null);
    dialog.open();
    if (wizard.repositoryRegistryChanged())
      refreshCurrent();
  }

  /**
   * Return the pattern browsing wizard
   * @param context_p a non-null context element
   * @param pattern_p a non-null pattern
   * @return a non-null object
   */
  protected AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(EObject context_p, TemplatePattern pattern_p){
    return _dialogAndWizardFactory.instantiatePatternBrowsingWizard(context_p, pattern_p);
  }

  /**
   * Return the pattern browsing wizard
   * @param context_p a non-null context element
   * @param repository_p a non-null pattern repository
   * @return a non-null object
   */
  protected AbstractPatternBrowsingWizard instantiatePatternBrowsingWizard(EObject context_p,
      IPatternRepository repository_p){
    return _dialogAndWizardFactory.instantiatePatternBrowsingWizard(context_p, repository_p);
  }

  /**
   * Return whether the current selection contains an unresolved element
   */
  protected boolean selectionContainsUnresolved() {
    Collection<Object> selection = getSelection();
    for (Object selected : selection) {
      if (selected instanceof UnresolvedElement)
        return true;
    }
    return false;
  }

  /**
   * Resolve the repositories corresponding to the selection
   */
  protected void resolveSelection() {
    List<IPatternInstance> instances = getSelectionAsInstances();
    if (!instances.isEmpty()) {
      boolean ok = UIUtil.resolvePatternWithUser(getShell(), instances);
      if (ok)
        refreshCurrent();
    }
  }

  /**
   * Interpret and return the current selection as instances
   * @return a non-null, potentially empty, unmodifiable list
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  protected List<IPatternInstance> getSelectionAsInstances() {
    List<IPatternInstance> result = new FOrderedSet<IPatternInstance>();
    InstanceExplorerContentProvider provider = getContentProvider();
    for (Object selected : getSelection()) {
      if (selected instanceof IPatternRepository ||
          selected instanceof UnresolvedRepository) {
        // Repository
        Object[] patterns = provider.getChildren(selected);
        for (Object pattern : patterns) {
          List<Object> instances = Arrays.asList(provider.getChildren(pattern));
          result.addAll((List)instances);
        }
      } else if (selected instanceof IPattern ||
          selected instanceof UnresolvedPattern) {
        // Pattern
        List<Object> instances = Arrays.asList(provider.getChildren(selected));
        result.addAll((List)instances);
      } else if (selected instanceof IPatternInstance) {
        // Instance
        result.add((IPatternInstance)selected);
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the label provider for the viewer
   * @return a non-null label provider
   */
  protected InstanceExplorerContentProvider getContentProvider() {
    return (InstanceExplorerContentProvider)_viewer.getContentProvider();
  }

  /**
   * Create and return the "manage instances" menu item
   * @param menu_p a non-null menu
   * @return a non-null menu item
   */
  private MenuItem createManageInstancesMenuItem(Menu menu_p) {
    final MenuItem result = new MenuItem(menu_p, SWT.NONE);
    result.setText(Messages.InstanceExplorerView_ManageInstances);
    // Enabled state
    _viewer.addSelectionChangedListener(new ISelectionChangedListener() {
      /**
       * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
       */
      public void selectionChanged(SelectionChangedEvent event_p) {
        List<Object> selection = getSelection();
        boolean enable = !selection.isEmpty();
        if (enable) {
          enable = false;
          for (Object selected : selection) {
            if (selected instanceof UnresolvedElement ||
                selected instanceof IPatternRepository ||
                selected instanceof IPattern ||
                selected instanceof IPatternInstance) {
              enable = true;
              break;
            }
          }
        }
        result.setEnabled(enable);
      }
    });
    // Execution
    result.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        manageSelectedInstances();
      }
    });
    return result;
  }

  /**
   * Open the Manage Instance dialog on the selected instances
   */
  protected abstract void manageSelectedInstances();

  /**
   * Setup mouse-based interactions on the given tree
   * @param tree_p a non-null tree
   */
  private void createMouseActions(Tree tree_p) {
    tree_p.addMouseListener(new MouseListener() {
      /**
       * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
       */
      public void mouseUp(MouseEvent e_p) {
        // Nothing to do
      }
      /**
       * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
       */
      public void mouseDown(MouseEvent e_p) {
        // Nothing to do
      }
      /**
       * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
       */
      public void mouseDoubleClick(MouseEvent e_p) {
        List<Object> selection = getSelection();
        if (selection.size() == 1) {
          Object selected = selection.get(0);
          if (selected instanceof UnresolvedElement) {
            // Unresolved element
            resolveSelection();
          } else if (selected instanceof IPatternRepository) {
            // Pattern repository
            browseRepository((IPatternRepository)selected);
          } else if (selected instanceof TemplatePattern) {
            // Pattern repository
            browsePattern((TemplatePattern)selected);
          } else if (selected instanceof IPatternInstance) {
            // Instance
            manageSelectedInstances();
          }
        }
      }
    });
  }

  /**
   * Return all the pattern instances which can be found for the given context
   * @param context_p a non-null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  protected static Collection<IPatternInstance> getAllInstances(EObject context_p) {
    Collection<IPatternInstance> result;
    IPatternSupport support =
        CorePatternsPlugin.getDefault().getPatternSupportFor(context_p);
    if (support == null) {
      result = Collections.emptySet();
    } else {
      result = support.getAllInstances(context_p);
    }
    return result;
  }



  /**
   * Return all the pattern instances to which the given element is related
   * @param context_p a non-null element
   * @return a non-null, potentially empty, unmodifiable collection
   */
  protected static Collection<IPatternInstance> getAllRelatedInstances(EObject context_p) {
    Collection<IPatternInstance> result;
    IPatternSupport support =
        CorePatternsPlugin.getDefault().getPatternSupportFor(context_p);
    if (support == null) {
      result = Collections.emptySet();
    } else {
      result = support.getRelatedInstances(context_p);
    }
    return result;
  }

  /**
   * Return the shell for this view
   * @return a non-null shell
   */
  protected Shell getShell() {
    return getSite().getShell();
  }

  /**
   * 
   * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
   */
  @Override
  public void setFocus() {
    _viewer.getControl().setFocus();
  }

  /**
   * Return a label provider for the viewer
   * @return a non-null label provider
   */
  protected ILabelProvider getLabelProvider() {
    return DiscriminatingLabelProvider.getInstance();
  }

  /**
   * Return the current user selection
   * @return a non-null, potentially empty, unmodifiable list
   */
  @SuppressWarnings("unchecked")
  protected List<Object> getSelection() {
    return ((IStructuredSelection)_viewer.getSelection()).toList();
  }

  /**
   * Set the header of the view
   */
  protected void updateHeader() {
    String newHeader = DEFAULT_TITLE;
    if (_contextElement != null && _contextElement.eResource() != null) {
      URI uri = _contextElement.eResource().getURI();
      if (uri != null) {
        newHeader = Messages.InstanceExplorerView_Instances +
          '[' + URI.decode(uri.lastSegment()) + ']';
      }
    }
    _header.setTitle(newHeader, null);
  }


  /**
   * The content provider for the graphical tree
   */
  protected class InstanceExplorerContentProvider implements ITreeContentProvider {
    /** A non-null map from repositories to the patterns actually used in the model */
    private final EMap<IPatternRepository, List<IPattern>> _repositoriesToPatterns;
    /** A non-null map from the patterns actually used in the model to the corresponding instances */
    private final EMap<IPattern, List<IPatternInstance>> _patternsToInstances;
    /** A non-null map from instances to unresolved patterns */
    private final EMap<IPatternInstance, UnresolvedPattern> _instancesToUnresolvedPatterns;
    /** A non-null set of virtual "unresolved repositories" */
    private final UniqueEList<UnresolvedRepository> _unresolvedRepositories;
    /**
     * Default constructor
     */
    public InstanceExplorerContentProvider() {
      _repositoriesToPatterns = new FHashMap<IPatternRepository, List<IPattern>>();
      _patternsToInstances = new FHashMap<IPattern, List<IPatternInstance>>();
      _unresolvedRepositories = new UniqueEList<UnresolvedRepository>();
      _instancesToUnresolvedPatterns = new FHashMap<IPatternInstance, UnresolvedPattern>();
    }
    /**
     * Clear the computed data
     */
    private void clear() {
      _repositoriesToPatterns.clear();
      _patternsToInstances.clear();
      _instancesToUnresolvedPatterns.clear();
      _unresolvedRepositories.clear();
    }
    /**
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose() {
      clear();
    }
    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object parentElement_p) {
      List<?> result = null;
      if (parentElement_p instanceof IPatternRepository) {
        result = _repositoriesToPatterns.get(parentElement_p);
      } else if (parentElement_p instanceof IPattern) {
        result = _patternsToInstances.get(parentElement_p);
      } else if (parentElement_p instanceof UnresolvedRepository) {
        result = ((UnresolvedRepository)parentElement_p).getUnresolvedPatterns();
      } else if (parentElement_p instanceof UnresolvedPattern) {
        result = ((UnresolvedPattern)parentElement_p).getReferringInstances();
      } else if (parentElement_p instanceof IPatternInstance) {
        List<EObject> allInstanceElements = ((IPatternInstance)parentElement_p).getElements();
        result = ModelsUtil.getRoots(allInstanceElements);
      }
      // Sort result alphabetically
      if (result != null) {
        LabelBasedComparator comparator = new LabelBasedComparator(getLabelProvider());
        result = new FArrayList<Object>(result, null);
        Collections.sort(result, comparator);
      }
      return result != null? result.toArray(): new Object[0];
    }
    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement_p) {
      List<Object> result = new FArrayList<Object>();
      result.addAll(_repositoriesToPatterns.keySet());
      result.addAll(_unresolvedRepositories);
      // Sort repositories alphabetically
      LabelBasedComparator comparator = new LabelBasedComparator(
          NameBasedLabelProvider.getInstance());
      Collections.sort(result, comparator);
      // Add
      return result.toArray();
    }
    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element_p) {
      Object result;
      if (element_p instanceof IPatternRepository || element_p instanceof UnresolvedRepository) {
        result = null;
      } else if (element_p instanceof IPattern) {
        result = ((IPattern)element_p).getRepository();
      } else if (element_p instanceof UnresolvedPattern) {
        result = ((UnresolvedPattern)element_p).getUnresolvedRepository();
      } else if (element_p instanceof IPatternInstance) {
        result = ((IPatternInstance)element_p).getPattern();
        if (result == null)
          result = _instancesToUnresolvedPatterns.get(element_p);
      } else {
        result = null;
      }
      return result;
    }
    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element_p) {
      boolean result =
          element_p instanceof UnresolvedRepository ||
          element_p instanceof UnresolvedPattern ||
          element_p instanceof IPatternRepository ||
          element_p instanceof IPattern ||
          element_p instanceof IPatternInstance;
      return result;
    }
    /**
     * Initialize instance variables which are derived from the initial set of instances
     */
    private void initializeData(Collection<?> input_p) {
      for (Object inputElement : input_p) {
        if (inputElement instanceof IPatternInstance)
          initializeDataFromInstance((IPatternInstance)inputElement);
      }
    }
    /**
     * Initialize instance variables which are derived from given instances
     */
    private void initializeDataFromInstance(IPatternInstance instance_p) {
      IPattern pattern = instance_p.getPattern();
      if (pattern != null) {
        // Register instance on loaded pattern
        List<IPatternInstance> instances = _patternsToInstances.get(pattern);
        if (instances == null) {
          instances = new FOrderedSet<IPatternInstance>();
          _patternsToInstances.put(pattern, instances);
        }
        instances.add(instance_p);
        // Register loaded pattern on loaded repository
        IPatternRepository repository = pattern.getRepository();
        assert repository != null;
        List<IPattern> patterns = _repositoriesToPatterns.get(repository);
        if (patterns == null) {
          patterns = new FOrderedSet<IPattern>();
          _repositoriesToPatterns.put(repository, patterns);
        }
        patterns.add(pattern);
      } else {
        // Get/create unresolved repository
        IPatternSymbol symbol = instance_p.getPatternVersion().getPatternSymbol();
        UnresolvedRepository uRepository = new UnresolvedRepository(
            symbol.getLastPath(), symbol.getRepositoryId());
        int pos = _unresolvedRepositories.indexOf(uRepository);
        if (pos >= 0)
          uRepository = _unresolvedRepositories.get(pos);
        else
          _unresolvedRepositories.add(uRepository);
        // Get/create unresolved pattern
        UnresolvedPattern uPattern = new UnresolvedPattern(
            symbol.getName(), symbol.getPatternId(), uRepository);
        pos = uRepository.getUnresolvedPatterns().indexOf(uPattern);
        if (pos >= 0)
          uPattern = uRepository.getUnresolvedPatterns().get(pos);
        else
          uRepository.getUnresolvedPatterns().add(uPattern);
        uPattern.getReferringInstances().add(instance_p);
        _instancesToUnresolvedPatterns.put(instance_p, uPattern);
      }
    }
    /**
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    public void inputChanged(Viewer viewer_p, Object oldInput_p, Object newInput_p) {
      clear();
      if (newInput_p instanceof Collection<?>)
        initializeData((Collection<?>)newInput_p);
    }
  }


  /**
   * This class is identical to org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyTitle.
   * Duplicated here because of access restrictions.
   */
  public class TabbedPropertyTitle
  extends Composite {
    /** A non-null label */
    protected CLabel label;
    /** A potentially null image */
    protected Image image = null;
    /** A potentially null text */
    protected String text = null;
    /** The blank string */
    private static final String BLANK = ""; //$NON-NLS-1$
    /** An identifier for the dedicated font */
    private static final String TITLE_FONT = "org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyTitle"; //$NON-NLS-1$
    /** The widget factory for the tabbed property sheet */
    private TabbedPropertySheetWidgetFactory factory;
    /**
     * Constructor for TabbedPropertyTitle.
     * @param parent_p the parent composite.
     * @param factory_p the widget factory for the tabbed property sheet
     */
    public TabbedPropertyTitle(Composite parent_p,
        TabbedPropertySheetWidgetFactory factory_p) {
      super(parent_p, SWT.NO_FOCUS);
      this.factory = factory_p;
      this.addPaintListener(new PaintListener() {
        public void paintControl(PaintEvent e) {
          if (image == null && (text == null || text.equals(BLANK))) {
            label.setVisible(false);
          } else {
            label.setVisible(true);
            drawTitleBackground(e);
          }
        }
      });
      factory_p.getColors().initializeSectionToolBarColors();
      setBackground(factory_p.getColors().getBackground());
      setForeground(factory_p.getColors().getForeground());
      FormLayout layout = new FormLayout();
      layout.marginWidth = 1;
      layout.marginHeight = 2;
      setLayout(layout);
      Font font;
      if (! JFaceResources.getFontRegistry().hasValueFor(TITLE_FONT)) {
        FontData[] fontData = JFaceResources.getHeaderFont().getFontData();
        fontData[0].setHeight(10);
        JFaceResources.getFontRegistry().put(TITLE_FONT, fontData);
      }
      font = JFaceResources.getFont(TITLE_FONT);
      label = factory_p.createCLabel(this, BLANK);
      label.setBackground(new Color[] {
          factory_p.getColors().getColor(IFormColors.H_GRADIENT_END),
          factory_p.getColors().getColor(IFormColors.H_GRADIENT_START) },
          new int[] { 100 }, true);
      label.setFont(font);
      label.setForeground(factory_p.getColors().getColor(IFormColors.TITLE));
      FormData data = new FormData();
      data.left = new FormAttachment(0, 0);
      data.top = new FormAttachment(0, 0);
      data.right = new FormAttachment(100, 0);
      data.bottom = new FormAttachment(100, 0);
      label.setLayoutData(data);
    }
    /**
     * Draw the background of the title.
     * @param e a paint event
     */
    protected void drawTitleBackground(PaintEvent e) {
      Rectangle bounds = getClientArea();
      label.setBackground(new Color[] {
          factory.getColors().getColor(IFormColors.H_GRADIENT_END),
          factory.getColors().getColor(IFormColors.H_GRADIENT_START) },
          new int[] { 100 }, true);
      Color bg = factory.getColors().getColor(IFormColors.H_GRADIENT_END);
      Color gbg = factory.getColors().getColor(IFormColors.H_GRADIENT_START);
      GC gc = e.gc;
      gc.setForeground(bg);
      gc.setBackground(gbg);
      gc.fillGradientRectangle(bounds.x, bounds.y, bounds.width,
          bounds.height, true);
      // background bottom separator
      gc.setForeground(factory.getColors().getColor(
          IFormColors.H_BOTTOM_KEYLINE1));
      gc.drawLine(bounds.x, bounds.height - 2, bounds.x + bounds.width - 1,
          bounds.height - 2);
      gc.setForeground(factory.getColors().getColor(
          IFormColors.H_BOTTOM_KEYLINE2));
      gc.drawLine(bounds.x, bounds.height - 1, bounds.x + bounds.width - 1,
          bounds.height - 1);
    }
    /**
     * Set the text label.
     * @param text_p the text label.
     * @param image_p the image for the label.
     */
    public void setTitle(String text_p, Image image_p) {
      this.text = text_p;
      this.image = image_p;
      if (text_p != null) {
        label.setText(text_p);
      } else {
        label.setText(BLANK); 
      }
      label.setImage(image_p);
      redraw();
    }
  }


  /**
   * Return the main viewer of the view
   * @return a tree viewer which is not null after initialization
   */
  public TreeViewer getViewer() {
    return _viewer;
  }

  /**
   * Return the objects represented by the given selected object when considered
   * as a selection
   * @param selected_p a non-null object
   * @return a non-null, potentially empty, unmodifiable collection
   */
  protected Collection<?> toActualSelection(Object selected_p){
    return _diagramUtil.toActualSelection(selected_p);
  }

}
