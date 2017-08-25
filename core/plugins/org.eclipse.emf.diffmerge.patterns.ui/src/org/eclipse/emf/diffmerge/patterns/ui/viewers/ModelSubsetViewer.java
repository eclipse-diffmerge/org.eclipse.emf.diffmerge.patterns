/**
 * <copyright>
 * 
 * Copyright (c) 2010-2017 Thales Global Services S.A.S.
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin.ImageID;
import org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI;
import org.eclipse.emf.diffmerge.patterns.ui.environment.IModelEnvironmentUI.SortingMethod;
import org.eclipse.emf.diffmerge.patterns.ui.providers.CollectionAsTreeContentProvider;
import org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.structures.common.FHashSet;
import org.eclipse.emf.diffmerge.util.ModelsUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

/**
 * A viewer for an arbitrary model subset, classically represented as a tree.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class ModelSubsetViewer extends Viewer {

  /** The different configurations for control widgets */
  /** Nothing specific */
  public static int NONE = 0;
  /** The name filter */
  public static int NAME_FILTER = 1 << 0;
  /** The "show parents" check box */
  public static int SHOW_PARENTS = 1 << 1;
  /** The sorting feature */
  public static int SORT = 1 << 2;
  /** The expand button */
  public static int EXPAND = 1 << 3;
  /** The collapse button */
  public static int COLLAPSE = 1 << 4;

  /** The non-null shell */
  protected final Shell _shell;

  /** The data structure of this viewer */
  protected Collection<EObject> _vdata;

  /** Whether the parents of the valid elements must be graphically shown */
  protected boolean _showParents;

  /** The optional sorting method */
  private SortingMethod _sortingMethod;

  /** The current selection */
  protected ITreeSelection _selection;

  /** The potentially null "show parents" check box */
  protected Button _showParentsButton;
  
  /** The internal composite */
  private Composite _composite;
  
  /** The multiple selection option */
  protected boolean _isMultipleSelection;
  
  /** The sub-viewer */
  protected TreeViewer _treeViewer;
  
  /** Data content provider for the client viewer */
  private ITreeContentProvider _dataProvider;
  
  
  /**
   * Constructor
   * @param parent_p the non-null graphical owner
   * @param multipleSelection_p whether multiple selection is allowed
   * @param showParents_p whether the "show parents" check box must be checked initially
   */
  public ModelSubsetViewer(Composite parent_p, boolean multipleSelection_p,
      boolean showParents_p) {
    _isMultipleSelection = multipleSelection_p;
    initialize(parent_p);
    _shell = parent_p.getShell();
    _selection = null;
    _showParents = showParents_p;
    ModelSubsetLabelProvider labelProvider = new ModelSubsetLabelProvider(getInternalLabelProvider());
    // Set up tree viewer
    _dataProvider = new CollectionAsTreeContentProvider();
    _treeViewer.setContentProvider(_dataProvider); //TODO: ITreeContentProvider
    _treeViewer.setLabelProvider(labelProvider);
    _sortingMethod = null;
    ViewerComparator sorter = getSorter();
    if (sorter != null)
      _treeViewer.setComparator(sorter);
    else
      setSortingMethod(SortingMethod.BY_TYPE_AND_NAME);
    if (_showParentsButton != null) {
      _showParentsButton.setSelection(showParents_p);
    }
  }

  /**
   * Adds the given filter to this viewer
   * @param filter_p a viewer filter
   */
  public void addFilter(ViewerFilter filter_p) {
    Viewer clientViewer = _treeViewer;
    // Don't add twice internal filter.
    if (clientViewer instanceof StructuredViewer) {
      ((StructuredViewer) clientViewer).addFilter(filter_p);
    }
  }

  /**
   * Initialize this viewer
   * @param parent_p a non-null composite
   */
  protected void initialize(Composite parent_p) {
    _composite = new Composite(parent_p, SWT.NONE);
    createControl(_composite);
  }

  /**
   * Create the control of the viewer
   * @param parent_p a non-null composite
   */
  protected void createControl(Composite parent_p) {
    // Set a layout.
    GridLayout layout = new GridLayout(1, true);
    parent_p.setLayout(layout);
    // Creates the client viewer.
    _treeViewer = createTreeViewer(parent_p);
    // Layouts the client area.
    if (null != _treeViewer) {
      GridData gdData = new GridData();
      gdData.verticalAlignment = SWT.FILL;
      gdData.horizontalAlignment = SWT.FILL;
      gdData.grabExcessHorizontalSpace = true;
      gdData.grabExcessVerticalSpace = true;
      _treeViewer.getControl().setLayoutData(gdData);
    }
  }

  /**
   * Set a selection listener on this viewer (delegated to the tree viewer)
   * @param listener_p a non-null object
   */
  public void addSelectionListener(ISelectionChangedListener listener_p) {
    _treeViewer.addSelectionChangedListener(listener_p);
  }

  /**
   * Create control widgets as required
   * @param parent_p a non-null composite
   */
  protected void createControlWidgets(Composite parent_p) {
    int configuration = getControlWidgetConfiguration();
    boolean none = !(((configuration & SORT) == SORT) ||
        ((configuration & EXPAND) == EXPAND) ||
        ((configuration & COLLAPSE) == COLLAPSE) ||
        ((configuration & SHOW_PARENTS) == SHOW_PARENTS));
    if (none)
      return;
    // Composite
    Composite composite = new Composite(parent_p, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    GridLayout compositeLayout = new GridLayout(4, false);
    compositeLayout.marginHeight = 0;
    compositeLayout.marginWidth = 0;
    composite.setLayout(compositeLayout);
    if ((configuration & SORT) == SORT) {
      // "Sort" button
      final Button sortButton = new Button(composite, SWT.PUSH);
      sortButton.setImage(PatternsUIPlugin.getDefault().getImage(ImageID.SORT));
      sortButton.setToolTipText(Messages.ModelSubsetViewer_TooltipSort);
      sortButton.addSelectionListener(new SelectionAdapter() {
        private Menu _dropMenu = null;
        /**
         * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        @Override
        public void widgetSelected(SelectionEvent e_p) {
          if(_dropMenu == null) {
            _dropMenu = new Menu(_shell, SWT.POP_UP);
            _shell.setMenu(_dropMenu);
            // Sort by name
            final MenuItem nameSortingItem = new MenuItem(_dropMenu, SWT.RADIO);
            nameSortingItem.setText(Messages.ModelSubsetViewer_SortByName);
            nameSortingItem.setSelection(getSortingMethod() == SortingMethod.BY_NAME);
            nameSortingItem.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent e) {
                if (nameSortingItem.getSelection())
                  setSortingMethod(SortingMethod.BY_NAME);
              }
            });
            // Sort by name and type
            final MenuItem nameTypeSortingItem = new MenuItem(_dropMenu, SWT.RADIO);
            nameTypeSortingItem.setText(Messages.ModelSubsetViewer_SortByNameAndType);
            nameTypeSortingItem.setSelection(getSortingMethod() == SortingMethod.BY_TYPE_AND_NAME);
            nameTypeSortingItem.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent e) {
                if (nameTypeSortingItem.getSelection())
                  setSortingMethod(SortingMethod.BY_TYPE_AND_NAME);
              }
            });
          }
          // Align menu with button
          final Composite parent = sortButton.getParent();
          Rectangle bounds = sortButton.getBounds();
          Point point = parent.toDisplay(new Point(
              bounds.x + bounds.width - 1, bounds.y));
          _dropMenu.setLocation(point.x, point.y);
          _dropMenu.setVisible(true);
        }
      });
    }
    if ((configuration & EXPAND) == EXPAND) {
      // "Expand all" button
      final Button expandButton = new Button(composite, SWT.PUSH);
      expandButton.setImage(PatternsUIPlugin.getDefault().getImage(ImageID.EXPANDALL));
      expandButton.setToolTipText(Messages.ModelSubsetViewer_TooltipExpand);
      expandButton.addSelectionListener(new SelectionAdapter() {
        /**
         * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        @Override
        public void widgetSelected(SelectionEvent event_p) {
          BusyIndicator.showWhile(_shell.getDisplay(), new Runnable() {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run() {
              _treeViewer.expandAll();
            }
          });
        }
      });
    }
    if ((configuration & COLLAPSE) == COLLAPSE) {
      // "Collapse all" button
      final Button collapseButton = new Button(composite, SWT.PUSH);
      collapseButton.setImage(PatternsUIPlugin.getDefault().getImage(ImageID.COLLAPSEALL));
      collapseButton.setToolTipText(Messages.ModelSubsetViewer_TooltipCollapse);
      collapseButton.addSelectionListener(new SelectionAdapter() {
        /**
         * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        @Override
        public void widgetSelected(SelectionEvent event_p) {
          BusyIndicator.showWhile(_shell.getDisplay(), new Runnable() {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run() {
              _treeViewer.collapseAll();
            }
          });
        }
      });
    }
    if ((configuration & SHOW_PARENTS) == SHOW_PARENTS) {
      // "Show parents" check box
      _showParentsButton = new Button(composite, SWT.CHECK);
      _showParentsButton.setText(Messages.ModelSubsetViewer_ShowParents);
      _showParentsButton.addSelectionListener(new SelectionAdapter() {
        /**
         * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        @Override
        public void widgetSelected(SelectionEvent e) {
          boolean selected = _showParentsButton.getSelection();
          _showParents = selected;
          setInput(_vdata);
        }
      });
    }
  }

  /**
   * Create and return the sub-viewer
   * @param parent_p a non-null composite
   * @return a non-null viewer
   */
  protected TreeViewer createTreeViewer(Composite parent_p) {
    createControlWidgets(parent_p);
    TreeViewer result;
    if ((getControlWidgetConfiguration() & NAME_FILTER) == NAME_FILTER ) {  
      parent_p.setLayoutData(new GridData(GridData.FILL_BOTH));
      result = new TreeViewer(parent_p,  getTreeStyle());
      result.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
    } else {
      result = new TreeViewer(parent_p, getTreeStyle());
      Layout parentLayout = parent_p.getLayout();
      if (parentLayout instanceof GridLayout) {
        GridLayout gridLayout = (GridLayout)parentLayout;
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
      }
      parent_p.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }
    result.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        _selection = (ITreeSelection)event.getSelection();
      }
    });
    return result;
  }

  /**
   * Returns a collection containing all parents of obj_p
   * @param obj_p a non-null EObject
   * @return a potentially empty collection
   */
  protected Collection<Object> getAllParents(EObject obj_p) {
    Collection<Object> res = new FHashSet<Object>();
    Object parent = getParent(obj_p);
    if (parent != null){
      if (parent instanceof EObject && !(parent instanceof Resource)) { // CDOResource case
        res.add(parent);
        res.addAll(getAllParents((EObject)parent));
      }
    }
    return res;
  }

  /**
   * Return a background color for displaying the given element
   * @param element_p a non-null element
   * @param defaultColor_p the non-null default color
   * @return a potentially null color, where null stands for default
   */
  protected Color getBackgroundColor(EObject element_p, Color defaultColor_p) {
    return null;
  }

  /**
   * Return the first selected element, if any
   * @return a potentially null element
   */
  public EObject getChoice() {
    EObject result = null;
    List<EObject> choices = getChoices();
    if (!choices.isEmpty())
      result = choices.get(0);
    return result;
  }

  /**
   * Return the selected elements
   * @return a non-null, possibly empty, unmodifiable list
   */
  public List<EObject> getChoices() {
    List<EObject> result = new ArrayList<EObject>();
    IStructuredSelection selection = getSelection();
    if (selection != null) {
      @SuppressWarnings("unchecked")
      Iterator<EObject> it = selection.iterator();
      while (it.hasNext()) {
        EObject selected = it.next();
        result.add(selected);
      }
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * @see org.eclipse.jface.viewers.Viewer#getControl()
   */
  @Override
  public Composite getControl() {
    return _composite;
  }

  /**
   * Return what control widgets must be displayed
   */
  protected int getControlWidgetConfiguration() {
    return SHOW_PARENTS | SORT | EXPAND | COLLAPSE;
  }

  /**
   * Return the depth for initial tree expansion
   */
  protected int getExpandDepth() {
    // Use AbstractTreeViewer.ALL_LEVELS for complete unfolding
    return _showParents? ModelsUtil.getDepth(
        ModelsUtil.getRoots(_vdata), false): 0;
  }

  /**
   * Return a font for displaying the given element
   * @param element_p a non-null element
   * @param defaultFont_p the non-null default font
   * @return a potentially null font, where null stands for default
   */
  protected Font getFont(EObject element_p, Font defaultFont_p) {
    return null;
  }

  /**
   * Return a foreground color for displaying the given element
   * @param element_p a non-null element
   * @param defaultColor_p the non-null default color
   * @return a potentially null color, where null stands for default
   */
  protected Color getForegroundColor(EObject element_p, Color defaultColor_p) {
    Collection<? extends EObject> roots = _vdata;
    if (!EcoreUtil.isAncestor(roots, element_p))
      return UIUtil.getColor(SWT.COLOR_GRAY);
    return null;
  }

  /**
   * @see org.eclipse.jface.viewers.Viewer#getInput()
   */
  @Override
  public Object getInput() {
    return _treeViewer == null? null: _treeViewer.getInput();
  }

  /**
   * Return the base label provider for the tree viewer
   * @return a non-null label provider
   */
  protected ILabelProvider getInternalLabelProvider() {
    return new DiscriminatingLabelProvider() {
      /**
       * @see org.eclipse.emf.diffmerge.patterns.ui.providers.DiscriminatingLabelProvider#getText(java.lang.Object)
       */
      @Override
      public String getText(Object element_p) {
        String result = null;
        if (element_p instanceof EObject)
          result = PatternsUIPlugin.getDefault().getModelEnvironmentUI().getText(element_p);
        if (result == null)
          result = super.getText(element_p);
        return result;
      }
    };
  }

  /**
   * Return the item provider for the given element
   * @param element_p a non-null element
   * @return a potentially null item provider
   */
  protected IEditingDomainItemProvider getItemProvider(EObject element_p) {
    IEditingDomainItemProvider result = null;
    AdapterFactoryEditingDomain editingDomain =
        (AdapterFactoryEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(element_p);
    if (null != editingDomain) {
      result = (IEditingDomainItemProvider)editingDomain.getAdapterFactory().adapt(
          element_p, IEditingDomainItemProvider.class);
    }
    return result;
  }

  /**
   * Return the parent of the given element, or null for the default parent 
   * @param element_p a non-null object
   * @return a potentially null element
   */
  protected Object getParent(Object element_p) {
    Object parent = null;
    if (!(element_p instanceof EObject)) {
      return parent;
    }
    EObject element = (EObject) element_p;
    // Parent is computed from meta-model structure.
    IEditingDomainItemProvider provider = getItemProvider(element);
    if (null != provider) {
      parent = provider.getParent(element);
    } else {
      // Last chance based on containment.
      parent = element.eContainer();
    }
    return parent;
  }
  
  /**
   * @see org.eclipse.jface.viewers.Viewer#getSelection()
   */
  @Override
  public IStructuredSelection getSelection() {
    return _selection != null? _selection: new StructuredSelection();
  }

  /**
   * Return the current sorting method, if any
   * @return a potentially null object
   */
  protected SortingMethod getSortingMethod() {
    return _sortingMethod;
  }

  /**
   * Return a specific sorter for this viewer
   * @return a potentially null sorter
   */
  protected ViewerComparator getSorter() {
    return null;
  }

  /**
   * Return a label for the given element
   * @param element_p a non-null element
   * @param defaultText_p a potentially null default label
   * @return a potentially null label, where null stands for default
   */
  protected String getText(EObject element_p, String defaultText_p) {
    return defaultText_p;
  }

  /**
   * Return the sub-viewer that represents the contents of the model subset
   * @return a non-null object
   */
  public TreeViewer getTreeViewer() {
    return _treeViewer;
  }

  /**
   * Return the tree style to apply to the tree widget
   */
  protected int getTreeStyle() {
    return SWT.NONE | (_isMultipleSelection ? SWT.MULTI : SWT.SINGLE) | SWT.BORDER 
        | SWT.FULL_SELECTION | SWT.V_SCROLL;
  }

  /**
   * Return whether the given element is a valid element
   * @param element_p a non-null element
   */
  public boolean isValid(EObject element_p) {
    return _vdata.contains(element_p);
  }
  
  /**
   * @see org.eclipse.jface.viewers.Viewer#refresh()
   */
  @Override
  public void refresh() {
    _treeViewer.refresh();
  }

  /**
   * Try and select the given elements in the tree
   */
  public void select(Object... elements_p) {
    _treeViewer.setSelection(new StructuredSelection(elements_p), true);
  }

  /**
   * Try and select the first valid element in the tree, if any
   * @return whether such an element was found
   */
  public boolean selectFirst() {
    boolean result = false;
    if (!_vdata.isEmpty()) {
      Object firstValid = _vdata.toArray()[0];
      select(firstValid);
    }
    return result;
  }

  /**
   * Set the enabled state of this viewer
   * @param enabled_p whether to enable or disable
   */
  public void setEnabled(boolean enabled_p) {
    if ((null != _treeViewer) && !_treeViewer.getControl().isDisposed()) {
      _treeViewer.getControl().setEnabled(enabled_p);
    }
  }

  /**
   * @see org.eclipse.jface.viewers.Viewer#setInput(java.lang.Object)
   */
  @Override
  public void setInput(Object input_p) {
   if(_showParents)
     setInputWithParents(input_p);
   else
     setFlatInput(input_p);
  }
  
  /**
   * Sets or clears the input for this viewer.
   * @param input_p a potentially null object
   */
  protected void setFlatInput(Object input_p) {
    if (input_p instanceof Collection<?>) {
      HashSet<EObject> elements = new HashSet<EObject>();
      @SuppressWarnings("rawtypes")
      Iterator it = ((Collection<?>)input_p).iterator();
      while(it.hasNext()){
        Object obj = it.next();
        if(obj instanceof EObject)
          elements.add((EObject) obj);
      }
      _vdata = elements;
      _treeViewer.setAutoExpandLevel(getExpandDepth());
      _treeViewer.setInput(_vdata);
    } else {
      if (null != _treeViewer)
        _treeViewer.setInput(input_p);
    }
  }
  
  /**
   * Sets or clears the input for this viewer showing all the objects hierarchy.
   * @param input_p a potentially null object
   */
  protected void setInputWithParents(Object input_p) {
    if (input_p instanceof Collection<?>) {
      HashSet<EObject> elements = new HashSet<EObject>();
      HashSet<EObject> elementsAndParents = new HashSet<EObject>();
      @SuppressWarnings("rawtypes")
      Iterator it = ((Collection<?>)input_p).iterator();
      while(it.hasNext()){
        Object obj = it.next();
        if(obj instanceof EObject){
          EObject current = (EObject) obj;
          Collection<Object> parents = getAllParents(current);
          for (Object p : parents){
            if (p instanceof EObject)
              elementsAndParents.add((EObject) p);
          }
          elementsAndParents.add((EObject) obj);
          elements.add((EObject) obj);
        }
      }
      _vdata = elements;
      _treeViewer.setAutoExpandLevel(getExpandDepth());
      _treeViewer.setInput(elementsAndParents);
    } else {
      if (null != _treeViewer)
        _treeViewer.setInput(input_p);
    }
  }

  /**
   * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection, boolean)
   */
  @Override
  public void setSelection(ISelection selection_p, boolean reveal_p) {
    // Do nothing.
  }

  /**
   * Set the sorting method
   * @param newMethod_p the non-null new sorting method
   */
  protected void setSortingMethod(SortingMethod newMethod_p) {
    if (_sortingMethod != newMethod_p) {
      IModelEnvironmentUI me = PatternsUIPlugin.getDefault().getModelEnvironmentUI();
      if (me != null) {
        _sortingMethod = newMethod_p;
        ViewerComparator sorter = me.getSorter(newMethod_p);
        _treeViewer.setComparator(sorter);
      }
    }
  }

  
  /**
   * A label provider which delegates to an inner label provider and provides additional functionality
   */
  private class ModelSubsetLabelProvider implements ILabelProvider, IFontProvider, IColorProvider {
    /** The non-null inner label provider to which to delegate */
    private final ILabelProvider _innerLabelProvider;
    /**
     * Constructor
     * @param innerLabelProvider_p a non-null label provider to which to delegate
     */
    public ModelSubsetLabelProvider(ILabelProvider innerLabelProvider_p) {
      _innerLabelProvider = innerLabelProvider_p;
    }
    /**
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
     */
    public void addListener(ILabelProviderListener listener_p) {
      _innerLabelProvider.addListener(listener_p);
    }
    /**
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
     */
    public void dispose() {
      _innerLabelProvider.dispose();
    }
    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
     */
    public Image getImage(Object element_p) {
      return _innerLabelProvider.getImage(element_p);
    }
    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
     */
    public String getText(Object element_p) {
      String result = null;
      String defaultText = _innerLabelProvider.getText(element_p);
      if (element_p instanceof EObject)
        result = ModelSubsetViewer.this.getText((EObject)element_p, defaultText);
      if (result == null)
        result = defaultText;
      return result;
    }
    /**
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
     */
    public boolean isLabelProperty(Object element_p, String property_p) {
      return false;
    }
    /**
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
     */
    public void removeListener(ILabelProviderListener listener_p) {
      _innerLabelProvider.removeListener(listener_p);
    }
    /**
     * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
     */
    public Font getFont(Object element_p) {
      Font result = null;
      Font defaultFont = _treeViewer.getTree().getFont();
      if (element_p instanceof EObject) {
        result = ModelSubsetViewer.this.getFont((EObject)element_p, defaultFont);
      }
      if (result == null)
        result = defaultFont;
      return result;
    }
    /**
     * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
     */
    public Color getBackground(Object element_p) {
      Color result = null;
      Color defaultColor = _treeViewer.getTree().getBackground();
      if (element_p instanceof EObject)
        result = ModelSubsetViewer.this.getBackgroundColor((EObject)element_p, defaultColor);
      if (result == null)
        result = defaultColor;
      return result;
    }
    /**
     * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
     */
    public Color getForeground(Object element_p) {
      Color result = null;
      Color defaultColor = _treeViewer.getTree().getForeground();
      if (element_p instanceof EObject)
        result = ModelSubsetViewer.this.getForegroundColor((EObject)element_p, defaultColor);
      if (result == null)
        result = defaultColor;
      return result;
    }
  }
  
}
