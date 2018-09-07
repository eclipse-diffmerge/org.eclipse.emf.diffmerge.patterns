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
package org.eclipse.emf.diffmerge.patterns.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * A wizard page which allows visualizing the roles of a template pattern. 
 * @author Olivier Constant
 */
public abstract class AbstractRoleBasedPage<T extends ITemplatePatternBasedSpecification>
extends AbstractPatternPage<T> {
  
  /**
   * A label provider which delegates to an inner label provider and provides additional functionality
   */
  protected class RoleViewerLabelProvider implements ILabelProvider, IFontProvider, IColorProvider {
    
    /** The non-null inner label provider to which to delegate */
    private final ILabelProvider _innerLabelProvider;
    
    /**
     * Constructor
     * @param innerLabelProvider_p a non-null label provider to which to delegate
     */
    public RoleViewerLabelProvider(ILabelProvider innerLabelProvider_p) {
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
      String defaultText = _innerLabelProvider.getText(element_p);
      String result = null;
      if (element_p instanceof TemplatePatternRole)
        result = AbstractRoleBasedPage.this.getTextForRole(
            (TemplatePatternRole)element_p, defaultText);
      if (result == null)
        result = defaultText;
      return result;
    }
    /**
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
     */
    public boolean isLabelProperty(Object element_p, String property_p) {
      return isLabelProperty(element_p, property_p);
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
      Font defaultFont = _rolesViewer.getControl().getFont();
      if (element_p instanceof TemplatePatternRole) {
         result = AbstractRoleBasedPage.this.getFontForRole(
             (TemplatePatternRole)element_p, defaultFont);
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
      Color defaultColor = _rolesViewer.getControl().getBackground();
      if (element_p instanceof TemplatePatternRole)
        result = AbstractRoleBasedPage.this.getBackgroundColorForRole(
            (TemplatePatternRole)element_p, defaultColor);
      if (result == null)
        result = defaultColor;
      return result;
    }
    /**
     * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
     */
    public Color getForeground(Object element_p) {
      Color result = null;
      Color defaultColor = _rolesViewer.getControl().getForeground();
      if (element_p instanceof TemplatePatternRole)
        result = AbstractRoleBasedPage.this.getForegroundColorForRole(
            (TemplatePatternRole)element_p, defaultColor);
      if (result == null)
        result = defaultColor;
      return result;
    }
  }
  
  
  /** A potentially null viewer on roles */
  protected ListViewer _rolesViewer;
  
  /**
   * Constructor
   * @param pageName_p the non-null name of the page
   * @param pageTitle_p the optional title of the page
   * @param defaultMessage_p a non-null default message for the page
   * @param data_p the non-null data under construction
   * @param isBlocking_p whether the page must be completed before the Next button can be clicked
   */
  public AbstractRoleBasedPage(String pageName_p, String pageTitle_p,
      String defaultMessage_p, T data_p, boolean isBlocking_p) {
    super(pageName_p, pageTitle_p, defaultMessage_p, data_p, isBlocking_p);
     _rolesViewer = null;
  }
  
  /**
   * Return all the roles of the current pattern
   * @return a non-null, potentially empty, modifiable list
   */
  protected final List<TemplatePatternRole> getRoles() {
    List<TemplatePatternRole> result;
    TemplatePattern pattern = getData().getPattern();
    if (pattern != null)
      result = pattern.getRoles();
    else
      result = new ArrayList<TemplatePatternRole>();
    return result;
  }
  
  /**
   * Return the viewer on roles
   * @return a non-null viewer
   */
  public ListViewer getRolesViewer() {
    return _rolesViewer;
  }
  
  /**
   * Return a new default grid data for a button
   * @return a non-null grid data
   */
  protected GridData createButtonLayoutData() {
    GridData result = new GridData();
    result.grabExcessHorizontalSpace = false;
    result.grabExcessVerticalSpace = false;
    result.horizontalAlignment = SWT.FILL;
    result.verticalAlignment = SWT.TOP;
    return result;
  }
  
  /**
   * Return the background color for representing the given role, or null for default
   * @param role_p a non-null role
   * @param defaultColor_p the default color when null is returned
   * @return a potentially null color, where null stands for default
   */
  protected Color getBackgroundColorForRole(TemplatePatternRole role_p,
      Color defaultColor_p) {
    return null;
  }
  
  /**
   * Return a font for displaying the given element
   * @param role_p a non-null role
   * @param defaultFont_p the non-null default font
   * @return a potentially null font, where null stands for default
   */
  protected Font getFontForRole(TemplatePatternRole role_p, Font defaultFont_p) {
    return null;
  }
  
  /**
   * Return the foreground color for representing the given role, or null for default
   * @param role_p a non-null role
   * @param defaultColor_p the default color when null is returned
   * @return a potentially null color, where null stands for default
   */
  protected Color getForegroundColorForRole(TemplatePatternRole role_p,
      Color defaultColor_p) {
    return null;
  }
  
  /**
   * Return the label for representing the given role, or null for default
   * @param role_p a non-null role
   * @param defaultLabel_p the default label when null is returned
   * @return a potentially null string, where null stands for default
   */
  protected String getTextForRole(TemplatePatternRole role_p, String defaultLabel_p) {
    String result = defaultLabel_p;
    if (role_p.isDerivable(true) || role_p.isDerivable(false))
      result = UIUtil.markAsDerivableRole(result);
    if (role_p.getTemplateElements().isEmpty())
      result = UIUtil.markAsFreeRole(result);
    return result;
  }
  
}
