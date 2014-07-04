package org.eclipse.emf.diffmerge.patterns.ui.sirius.util;

import org.eclipse.emf.diffmerge.patterns.ui.sirius.views.SiriusInstanceExplorerView;
import org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender;
import org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer;
import org.eclipse.swt.widgets.Menu;

public class SiriusUIExtender implements IUIExtender{

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender#createNavigationItems(org.eclipse.swt.widgets.Menu, org.eclipse.emf.diffmerge.patterns.ui.viewers.ModelSubsetViewer)
   */
    public boolean createNavigationItems(Menu menu_p, ModelSubsetViewer viewer_p) {
      return false;
    }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.util.IUIExtender#getInstanceExplorerViewID()
   */
    public String getInstanceExplorerViewID() {
      return SiriusInstanceExplorerView.getID();
    }
  
}
