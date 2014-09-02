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
package org.eclipse.emf.diffmerge.patterns.ui.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.INamedElement;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IEvaluationStatus;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.PatternsDiagramsUtil;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.PatternCatalogResourceHelper;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.ResourcesUtil;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.OpenCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.AbstractTemplatePatternSelection;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


/**
 * Utility class for UI-related issues
 * @author Olivier Constant
 */
public final class UIUtil {
  
  /** The suffix to apply for naming elements which are not loaded */
  private static final String NOT_LOADED_SUFFIX = Messages.UIUtil_NotLoaded;
  
  /** Whether the bold-italic font has been initialized */
  private static boolean __fontInitialized = false;
  
  /**
   * Constructor
   */
	private UIUtil() {
	  //Forbid instantiation
	}
	
	/**
	 * Concatenate the names of the given elements using the given separator and 
	 * the given left and right "encapsulators" for each element
	 * @param elements_p a non-null iterable
	 * @param separator_p an optional string
	 * @param leftEncapsulator_p an optional string
	 * @param rightEncapsulator_p an optional string
	 * @return a non-null string
	 */
  public static String buildStringWith(Iterable<? extends INamedElement> elements_p,
      String separator_p, String leftEncapsulator_p, String rightEncapsulator_p) {
    StringBuilder builder = new StringBuilder();
    Iterator<? extends INamedElement> it = elements_p.iterator();
    while (it.hasNext()) {
      INamedElement element = it.next();
      if (null != leftEncapsulator_p) builder.append(leftEncapsulator_p);
      builder.append(element.getName());
      if (null != rightEncapsulator_p) builder.append(rightEncapsulator_p);
      if (null != separator_p && it.hasNext()) //element is not the last one
        builder.append(separator_p);
    }
    return builder.toString();
  }
  
  /**
   * Center the given shell graphically
   */
  public static void centerShell(Shell shell_p) {
    Rectangle pbounds = shell_p.getDisplay().getBounds();
    Rectangle bounds = shell_p.getBounds();
    shell_p.setBounds(
        pbounds.x + (pbounds.width-bounds.width)/2,
        pbounds.y + (pbounds.height-bounds.height)/2,
        bounds.width,
        bounds.height);
  }
  
  
  /**
   * Return the size of the given image when bounded by the given height and width
   * @param imageData_p a non-null image data
   * @param maxWidth_p an int such that negative values mean no max width
   * @param maxHeight_p an int such that negative values mean no max height
   * @return a non-null point
   */
  public static Point getBoundedImageSize(ImageData imageData_p,
      int maxWidth_p, int maxHeight_p) {
    Point result;
    if (maxWidth_p > 0 || maxHeight_p > 0) {
      float widthFactor = maxWidth_p / (float)imageData_p.width;
      float heightFactor = maxHeight_p / (float)imageData_p.height;
      float minFactor;
      if (widthFactor <= 0)
        minFactor = heightFactor;
      else if (heightFactor <= 0)
        minFactor = widthFactor;
      else
        minFactor = Math.min(widthFactor, heightFactor);
      int newWidth = (int)(imageData_p.width * minFactor);
      int newHeight = (int)(imageData_p.height * minFactor);
      result = new Point(newWidth, newHeight);
    } else {
      result = new Point(imageData_p.width, imageData_p.height);
    }
    return result;
  }
  
  /**
   * Return the bold variant of the given font
   * @param font_p a non-null font
   * @return a non-null font
   */
  public static Font getBold(Font font_p) {
    FontData data = font_p.getFontData()[0];
    Font result = JFaceResources.getFontRegistry().getBold(data.getName());
    return result;
  }
  
  /**
   * Return the bold and italic variant of the given font.
   * The first call to this method actually determines which font is associated
   * with the bold-italic style.
   * @param font_p a non-null font
   * @return a non-null font
   */
  public static Font getBoldItalic(Font font_p) {
    final String ITALIC_BOLD_FONT = "patterns-italic-bold"; //$NON-NLS-1$
    FontRegistry registry = JFaceResources.getFontRegistry();
    if (!__fontInitialized) {
      FontData data = font_p.getFontData()[0];
      FontData newData = new FontData(data.toString());
      newData.setStyle(SWT.ITALIC | SWT.BOLD);
      registry.put(ITALIC_BOLD_FONT, new FontData[]{newData});
      __fontInitialized = true;
    }
    Font result = registry.get(ITALIC_BOLD_FONT);
    return result;
  }
  
  /**
   * Return the background color for identifying the elements bound to the current role
   * @param font_p a non-null font
   * @return a non-null font
   */
  public static Font getBoundElementFont(Font font_p) {
    return getBoldItalic(font_p);
  }
  
  /**
   * Return the color corresponding to the given code
   * @param code_p one of the SWT.COLOR_... constants
   * @return a non-null color (black by default)
   */
  public static final Color getColor(int code_p) {
    return Display.getDefault().getSystemColor(code_p);
  }
	
	/**
	 * Inform the user that the given set of catalog URIs have led to the corresponding
	 * errors when trying to open them as repositories
	 * @param errors_p a non-null, potentially empty, unmodifiable map
	 */
	public static void informRepositoryOpeningError(Shell shell_p, Map<URI, Throwable> errors_p) {
	  StringBuilder builder = new StringBuilder();
	  builder.append(Messages.UIUtil_OpeningFailure);
	  for (URI uri : errors_p.keySet()) {
	    builder.append("\n- "); //$NON-NLS-1$
	    builder.append(uri.lastSegment());
	  }
    builder.append('\n');
    builder.append(Messages.UIUtil_OpeningRequiresMigration);
	  MessageDialog.openError(shell_p, CorePatternsPlugin.getDefault().getLabel(), builder.toString());
	}
	
  /**
   * Display a basic error message
   * @param shell_p an optional shell
   */
  public static void informError(Shell shell_p) {
    Shell shell = shell_p;
    if (shell == null)
      shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    MessageDialog.openError(shell_p, CorePatternsPlugin.getDefault().getLabel(),
        Messages.UIUtil_OperationError);
  }
  
  /**
   * Display a message according to the given status
   * @param status_p a non-null status
   * @param shell_p an optional shell
   */
  public static void informFromStatus(IEvaluationStatus status_p, Shell shell_p) {
    Shell shell = shell_p;
    if (shell == null)
      shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    if (status_p == null || status_p.getDescription().length() == 0 && !status_p.isOk())
      UIUtil.informError(shell);
    else {
      String message = status_p.getDescription();
      String title = CorePatternsPlugin.getDefault().getLabel();
      if (status_p.isOk())
        if (status_p.hasWarnings())
          MessageDialog.openWarning(shell, title, message);
        else
          MessageDialog.openInformation(shell, title, message);
      else
        MessageDialog.openError(shell, title, message);
    }
  }
  
  /**
   * Display an "Operation successful" message 
   * @param shell_p an optional shell
   */
  public static void informSuccess(Shell shell_p) {
    Shell shell = shell_p;
    if (shell == null)
      shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    MessageDialog.openInformation(shell_p, CorePatternsPlugin.getDefault().getLabel(),
        Messages.UIUtil_SuccessfulOperation);
  }
  
  /**
   * Return whether all the given strings contain significant data from a GUI perspective
   * @param strings_p a potentially null string
   * @return true iff all strings are not null and not empty
   */
  public static boolean isSignificant(String... strings_p) {
    for (String string : strings_p) {
      if (!isSignificantHelper(string))
        return false;
    }
    return true;
  }
  
  /**
   * Return whether the given string contains significant data
   * @param string_p a potentially null string
   * @return true iff string_p is not null and not empty
   */
  private static boolean isSignificantHelper(String string_p) {
    return string_p != null && string_p.length() > 0;
  }
  
	/**
	 * Propose a unique file from a given path for resource creation,
	 * adding suffixes to the default name if needed
	 * @param original_p a non-null path
	 * @return a non-null path
	 */
	private static IPath makePathUnique(IPath original_p) {
		IPath result = original_p;
		int i = 1;
		while (ResourcesUtil.getFileForPath(result).exists() && i < 20) {
			result = original_p.removeLastSegments(1).append(
					original_p.removeFileExtension().lastSegment() +
						"(" + i + ")." + //$NON-NLS-1$ //$NON-NLS-2$
						original_p.getFileExtension());
			i++;
		}
		return result;
	}
	
  /**
   * Transform the given element label so that it exhibits the fact that it is bound
   * to the given roles and optionally the given roles for addition
   * @param label_p a non-null label
   * @param roles_p a non-null, potentially empty collection
   * @param additionRoles_p a non-null, potentially empty collection
   * @return a non-null label
   */
  public static String markAsBoundElement(String label_p,
      Collection<? extends TemplatePatternRole> roles_p,
      Collection<? extends TemplatePatternRole> additionRoles_p) {
    StringBuilder result = new StringBuilder(label_p);
    Collection<TemplatePatternRole> mergeRoles = new ArrayList<TemplatePatternRole>(roles_p);
    mergeRoles.removeAll(additionRoles_p);
    if (!mergeRoles.isEmpty()) {
      if (mergeRoles.size() > 1)
        result.append("  (" + Messages.UIUtil_MergedRoles); //$NON-NLS-1$
      else
        result.append("  (" + Messages.UIUtil_MergedRole); //$NON-NLS-1$
      result.append(buildStringWith(mergeRoles, ", ", null, null)); //$NON-NLS-1$
      result.append(')');
    }
    if (!additionRoles_p.isEmpty()) {
      if (additionRoles_p.size() > 1)
        result.append("  (" + Messages.UIUtil_ContainerRoles); //$NON-NLS-1$
      else
        result.append("  (" + Messages.UIUtil_ContainerRole); //$NON-NLS-1$
      result.append(buildStringWith(additionRoles_p, ", ", null, null)); //$NON-NLS-1$
      result.append(')');
    }
    return result.toString();
  }
  
  /**
   * Transform the given element label so that it exhibits the fact that it is multiple
   * (marked as not unique in its pattern) 
   * @param label_p a non-null label
   * @return a non-null label
   */
  public static String markAsMultipleElement(String label_p) {
    return label_p + " [*]"; //$NON-NLS-1$
  }
  
	/**
	 * Transform the given role label so that it exhibits the fact that the role is derivable
	 * @param roleLabel_p a non-null label
	 * @return a non-null label
	 */
	public static String markAsDerivableRole(String roleLabel_p) {
	  return "(" + roleLabel_p + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
  /**
   * Transform the given element label so that it exhibits the fact that it has dependencies
   * @param label_p a non-null label
   * @return a non-null label
   */
  public static String markAsDependentElement(String label_p) {
    return "~" + label_p; //$NON-NLS-1$
  }
  
  /**
   * Transform the given role label so that it exhibits the fact that the role must be mapped
   * @param roleLabel_p a non-null label
   * @return a non-null label
   */
  public static String markAsFreeRole(String roleLabel_p) {
    return "> " + roleLabel_p; //$NON-NLS-1$
  }
  
  /**
   * Transform the given name so that it appears as "not loaded"
   * @param name_p a potentially null string
   * @return a non-null string
   */
  public static String markAsNotLoaded(String name_p) {
    String result;
    if (name_p != null)
      result = name_p + " " + NOT_LOADED_SUFFIX; //$NON-NLS-1$
    else
      result = NOT_LOADED_SUFFIX;
    return result;
  }
  
	/**
	 * Prompt the user for a new catalog file
	 * @param shell_p a non-null shell
   * @param resource_p an optional resource for providing a default path
	 * @param rset_p a non-null ResourceSet for catalogs
	 * @return a potentially null file
	 */
	public static IFile promptForNewCatalogFile(Shell shell_p, Resource resource_p, ResourceSet rset_p) {
	  IFile result = null;
	  IPath suggestedFile = PatternsDiagramsUtil.getDefaultCatalogPathFor(resource_p);
	  if (suggestedFile != null)
	    suggestedFile = UIUtil.makePathUnique(suggestedFile);
	  boolean confirmed = false;
	  while (!confirmed) {
	    result = WorkspaceResourceDialog.openNewFile(shell_p,
	        CorePatternsPlugin.getDefault().getLabel(),
	        Messages.UIUtil_NewCatalogPrompt,
	        suggestedFile, null);
	    if (result == null) //Cancel pressed
	      confirmed = true;
	    else { //Check whether file already exists
	      String catalogExtension = PatternCatalogResourceHelper.getPatternCatalogFileExtension();
	      if (!catalogExtension.equals(result.getFileExtension())) {
	        result = ResourcesPlugin.getWorkspace().getRoot().getFile(
	            result.getFullPath().removeFileExtension().addFileExtension(catalogExtension));
	      }
	      if (result.exists())
	        confirmed = MessageDialog.openQuestion(shell_p,
	            CorePatternsPlugin.getDefault().getLabel(),
	        Messages.UIUtil_FileExists);
	      else
	        confirmed = true;
	    }
	  }
	  return result;
	}
	
  /**
   * Return a list of comma- or semicolon-separated strings within the given multi-line string
   * @param string_p a potentially null string
   * @return a non-null, potentially empty, unmodifiable list
   */
  public static List<String> parseCommaSeparatedString(String string_p) {
    List<String> rawResult = new LinkedList<String>();
    List<String> lines = parseMultilineString(string_p);
    for (String line : lines) {
      String[] elements = line.split("(,|;)"); //$NON-NLS-1$
      rawResult.addAll(Arrays.asList(elements));
    }
    List<String> result = new LinkedList<String>();
    for (String element : rawResult) {
      String newElement = element.trim();
      if (newElement.length() > 0)
        result.add(newElement);
    }
    return Collections.unmodifiableList(result);
  }
  
  /**
   * Return a list of the lines in the given multi-line string
   * @param string_p a potentially null string
   * @return a non-null, potentially empty, unmodifiable list
   */
  public static List<String> parseMultilineString(String string_p) {
    List<String> result = Collections.emptyList();
    if (string_p != null) {
      String text = string_p.replace("\r", "");  //$NON-NLS-1$//$NON-NLS-2$
      String[] lines = text.split("\n"); //$NON-NLS-1$
      result = Arrays.asList(lines);
    }
    return result;
  }
  
	/**
	 * Prompt the user for catalog resources in the workspace, starting with a catalog
	 * being currently used if any
   * @param shell_p a non-null shell
   * @param resource_p an optional resource for providing a default path
   * @return a non-null, potentially empty, unmodifiable list
	 */
	public static List<IFile> promptForExistingCatalogs(Shell shell_p, Resource resource_p, ResourceSet rset_p) {
	  IResource defaultSelection = null;
	  if (rset_p != null) {
	    IPath path = PatternsDiagramsUtil.getDefaultCatalogPathFor(resource_p);
	    if (path != null) {
	      IFile suggestion = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	      defaultSelection = (suggestion.exists())? suggestion: suggestion.getParent();
	    }
	  }
	  List<ViewerFilter> filters = new LinkedList<ViewerFilter>();
	  filters.add(new CatalogFileFilter());
	  IFile[] selected = WorkspaceResourceDialog.openFileSelection(
	      shell_p, CorePatternsPlugin.getDefault().getLabel(),
	      Messages.UIUtil_CatalogPrompt, true,
	      (defaultSelection==null)? new Object[]{}: new Object[]{defaultSelection},
	      filters);
		return Arrays.asList(selected);
	}
	
	/**
	 * Create an SWT image from the given SVG specification
	 * @param svgData_p a non-null string
	 * @return a potentially null image
	 */
	public static Image renderSVG(String svgData_p) {
	  Image result = null;
	  Transcoder transcoder = new PNGTranscoder();
	  StringReader reader = new StringReader(svgData_p);
	  TranscoderInput input = new TranscoderInput(reader);
	  ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	  TranscoderOutput output = new TranscoderOutput(outStream);
	  try {
	    transcoder.transcode(input, output);
	    ByteArrayInputStream inStream = new ByteArrayInputStream(outStream.toByteArray());
	    ImageData imageData = new ImageData(inStream);
	    inStream.close();
	    outStream.close();
	    result = new Image(PlatformUI.getWorkbench().getDisplay(), imageData);
	  } catch (Exception e) {
	    // Failure: return null
	  }
	  return result;
	}
	
	/**
	 * Try and resolve the pattern of the given instances with the help of the user if needed
	 * @param shell_p a non-null shell
	 * @param instances_p a non-null, non-empty collection
	 * @return whether the operation succeeded, at least partially
	 */
	public static boolean resolvePatternWithUser(Shell shell_p,
	    Collection<? extends IPatternInstance> instances_p) {
	  boolean result = false;
	  assert !instances_p.isEmpty();
	  IPatternInstance defaultInstance = instances_p.iterator().next();
    Resource resource = defaultInstance instanceof EObject? ((EObject)defaultInstance).eResource():
      null;
	  TransactionalEditingDomain catalogDomain = CorePatternsPlugin.getDefault().getModelEnvironment().getCommonCatalogEditingDomain();
	  if(catalogDomain != null){
	    ResourceSet rs = catalogDomain.getResourceSet();
	    if (rs != null) {
	      for (IPatternInstance instance : instances_p) {
	        if (instance.getPattern() == null) {
	          OpenCatalogOperation operation = new OpenCatalogOperation(instance, catalogDomain);
	          Collection<? extends IPatternRepository> loaded =
	            CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
	          if(loaded == null){
	            //Couldn't load pattern catalog
	            System.out.println("Couldn't load pattern catalog."); //$NON-NLS-1$
	          }else{
	            if (!operation.getErrors().isEmpty())
	              UIUtil.informRepositoryOpeningError(shell_p, operation.getErrors());
	            result = !loaded.isEmpty() && instance.getPattern() != null;
	            if (!result) {
	              List<IFile> userSelected = promptForExistingCatalogs(shell_p, resource, rs);
	              if (userSelected.isEmpty())
	                return true;
	              operation = new OpenCatalogOperation(userSelected, catalogDomain, instances_p);
	              loaded =
	                CorePatternsPlugin.getDefault().getModelEnvironment().execute(operation);
	              result = result || !loaded.isEmpty();
	            }
	          }    
	        }
	      }
	    }
	  }
	  return result;
	}
	
	/**
	 * A filter class for catalog resources in the workspace
	 */
	public static class CatalogFileFilter extends ViewerFilter {
	  /**
	   * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	   */
	  @Override
	  public boolean select(Viewer viewer_p, Object parentElement_p, Object element_p) {
	    if (!(element_p instanceof IFile))
	      return true;
	    return PatternCatalogResourceHelper.isPatternCatalogResource((IFile)element_p);
	  }
	}
	
	/**
	 * A viewer filter that excludes children of instance-related elements
	 */
	public static final ViewerFilter INSTANCE_VIEWER_FILTER = new ViewerFilter() {
	  /**
	   * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	   */
    @Override
    public boolean select(Viewer viewer_p, Object parentElement_p, Object element_p) {
      boolean result = true;
      if (parentElement_p instanceof EObject)
        result = AbstractTemplatePatternSelection.INSTANCE_FILTER.accepts(
            (EObject)parentElement_p);
      return result;
    }
	};
	
  /**
   * A comparator based on labels of objects
   */
  public static class LabelBasedComparator implements Comparator<Object> {
    /** The label provider whose labels define the ordering */
    private final ILabelProvider _labelProvider;
    
    /**
     * Constructor
     * @param labelProvider_p the non-null label provider whose labels define the ordering
     */
    public LabelBasedComparator(ILabelProvider labelProvider_p) {
      _labelProvider = labelProvider_p;
    }
    
    /**
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Object o1_p, Object o2_p) {
      String label1 = _labelProvider.getText(o1_p);
      if (label1 == null) label1 = o1_p.toString();
      String label2 = _labelProvider.getText(o2_p);
      if (label2 == null) label2 = o2_p.toString();
      return label1.compareTo(label2);
    }
  }
  
}
