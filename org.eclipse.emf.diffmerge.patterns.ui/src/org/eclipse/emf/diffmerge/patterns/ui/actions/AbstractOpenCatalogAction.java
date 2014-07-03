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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.OpenCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.ui.PatternsUIPlugin;
import org.eclipse.emf.diffmerge.patterns.ui.factories.IPatternDialogAndWizardFactory;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.browsing.AbstractPatternBrowsingWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;



/**
 * An action for opening catalogs.
 * @author O. CONSTANT
 * @author Skander TURKI
 */
public abstract class AbstractOpenCatalogAction<DiagramElementType, DiagramType, GraphicalContainerType, 
GraphicalNodeType> 
extends AbstractContextualAction<IFile> {

  /** Dialog and Wizard factory */
  private IPatternDialogAndWizardFactory<DiagramElementType, DiagramType, GraphicalContainerType, 
  GraphicalNodeType> _factory = (IPatternDialogAndWizardFactory<DiagramElementType, DiagramType, GraphicalContainerType, 
      GraphicalNodeType>)PatternsUIPlugin.getDefault().getDialogAndWizardFactory();


  /**
   * Constructor
   */
  public AbstractOpenCatalogAction() {
    super(IFile.class);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    if (!selection_p.isEmpty()) {
      Object context = selection_p.get(0);
      EditingDomain domain = null;
      if(context instanceof IFile){
        domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((IFile)context);
      }else if(context instanceof EObject){
        domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((EObject)context);
      }
     
      if (domain instanceof TransactionalEditingDomain) {
        Collection<PatternRepository> repositories = new ArrayList<PatternRepository>();
        Iterator<Object> it = selection_p.iterator();
        while(it.hasNext()){
          Object current = it.next();
          OpenCatalogOperation operation =
              new OpenCatalogOperation(current, (TransactionalEditingDomain)domain);
          Collection<PatternRepository> result = executeOperation(operation);
          if(result != null && !result.isEmpty()){
            repositories.add(result.iterator().next()); 
          }
          if (!operation.getErrors().isEmpty()) {
            UIUtil.informRepositoryOpeningError(getShell(), operation.getErrors());
            return;
          }
        }
        PatternRepository repository = repositories.isEmpty()? null: repositories.iterator().next();
        if (repository != null) {
          PatternWizardDialog dialog = new PatternWizardDialog(getShell(),
              instantiatePatternBrowsingWizard(domain.getResourceSet(), repository), true, null);
          dialog.open();
        }
      }
    }
  }

  
  /**
   * Instantiates a PatternBrowsingWizard
   * @param rset_p a potentially null ResourceSet
   * @param repository_p a potentially null IPatternRepository
   * @return a potentially null PatternBrowsingWizard
   */
  protected AbstractPatternBrowsingWizard<DiagramElementType, 
  DiagramType, GraphicalContainerType, GraphicalNodeType>
  instantiatePatternBrowsingWizard(ResourceSet rset_p, IPatternRepository repository_p){
    if(_factory != null){
      return _factory.instantiatePatternBrowsingWizard(rset_p, repository_p);
    }
    return null;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractContextualAction#mustBeEnabled()
   */
  @Override
  protected boolean mustBeEnabled() {
    return true; //TODO refine
  }

}
