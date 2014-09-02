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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.ITemplatePatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage.IPageValidatedListener;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;


/**
 * A wizard page which may contain other wizard pages via a SWT TabFolder.
 * @author Olivier Constant
 */
public class CompositeWizardPage<T extends ITemplatePatternBasedSpecification> extends AbstractPatternPage<T>
implements IPageValidatedListener {

  /** The non-null list of pages */
  private final List<AbstractPatternPage<? extends T>> _subPages;

  /** The non-null list of pages whose warning may be displayed */
  private final List<AbstractPatternPage<?>> _warningPages;

  /**
   * Constructor
   * @param title_p a non-null title for the page
   * @param defaultMessage_p an optional message for the page
   * @param data_p the non-null data under construction
   * @param isBlocking_p whether the page must be completed before the Next button can be clicked
   * @param pages_p a non-null, non-empty list of sub-pages
   */
  public CompositeWizardPage(String pageName_p, String title_p, String defaultMessage_p,
      T data_p, boolean isBlocking_p, List<? extends AbstractPatternPage<? extends T>> pages_p) {
    super(pageName_p, title_p, defaultMessage_p, data_p, isBlocking_p);
    _subPages = new ArrayList<AbstractPatternPage<? extends T>>(pages_p);
    _warningPages = new ArrayList<AbstractPatternPage<?>>();
  }

  /**
   * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
   */
  public void createControl(Composite parent_p) {
    final TabFolder tabFolder = new TabFolder(parent_p, SWT.NONE);
    setControl(tabFolder);
    tabFolder.setLayout(new GridLayout());
    setDefaultMessage();
    for (AbstractPatternPage<? extends T> page : _subPages) {
      TabItem item = new TabItem(tabFolder, SWT.NONE);
      item.setText(page.getTitle());
      Composite itemComposite = new Composite(tabFolder, SWT.NONE);
      GridData itemData = new GridData(SWT.FILL, SWT.FILL, true, true);
      itemData.heightHint = 130;
      itemComposite.setLayoutData(itemData);
      itemComposite.setLayout(new FillLayout());
      item.setControl(itemComposite);
      page.addValidationListener(this);
      page.createControl(itemComposite);
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#getValidationMessage()
   */
  @Override
  protected String getValidationMessage() {
    for (AbstractPatternPage<? extends T> page : _subPages) {
      String msg = page.getValidationMessage();
      if (msg != null)
        return msg;
    }
    return null;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage.IPageValidatedListener#messageUpdated(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage, java.lang.String, int)
   */
  public void messageUpdated(AbstractPatternPage<?> page_p, String newMessage_p, int newType_p) {
    boolean firstWarningPageChanged = false;
    if (newType_p == IMessageProvider.INFORMATION || newType_p == IMessageProvider.NONE) {
      firstWarningPageChanged = _warningPages.indexOf(page_p) == 0;
      _warningPages.remove(page_p);
    } else if (newType_p == IMessageProvider.WARNING) {
      firstWarningPageChanged = _warningPages.isEmpty();
      if (!_warningPages.contains(page_p))
        _warningPages.add(page_p);
    }
    if (firstWarningPageChanged) {
      if (!_warningPages.isEmpty()) {
        AbstractPatternPage<?> warningPage = _warningPages.get(0);
        setMessage(warningPage.getMessage(), IMessageProvider.WARNING);
      } else {
        setDefaultMessage();
      }
    }
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage.IPageValidatedListener#pageValidated(org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage, java.lang.String)
   */
  public void pageValidated(AbstractPatternPage<?> page_p, String validationMessage_p) {
    validate();
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#setWizard(org.eclipse.jface.wizard.IWizard)
   */
  @Override
  public void setWizard(IWizard wizard_p) {
    super.setWizard(wizard_p);
    for (AbstractPatternPage<? extends T> page : _subPages) {
      page.setWizard(wizard_p);
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#validate()
   */
  @Override
  public final void validate() {
    super.validate();
    if (getErrorMessage() == null && !_warningPages.isEmpty()) {
      AbstractPatternPage<?> warningPage = _warningPages.get(0);
      setMessage(warningPage.getMessage(), IMessageProvider.WARNING);
    }
  }


}
