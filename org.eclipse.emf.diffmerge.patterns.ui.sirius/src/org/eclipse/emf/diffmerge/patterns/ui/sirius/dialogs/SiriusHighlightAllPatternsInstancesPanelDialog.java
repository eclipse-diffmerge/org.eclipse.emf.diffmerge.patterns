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
package org.eclipse.emf.diffmerge.patterns.ui.sirius.dialogs;

import java.util.Set;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternInstance;
import org.eclipse.emf.diffmerge.patterns.diagram.sirius.util.ColorUtil;
import org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.viewpoint.DContainer;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Shell;


/**
 * A Sirius-specific dialog that is used to highlight pattern instances in the current diagram
 * @author Olivier Constant
 * @author Skander TURKI
 */
public class SiriusHighlightAllPatternsInstancesPanelDialog 
extends HighlightAllPatternsInstancesPanelDialog<DDiagram, DDiagramElement, DContainer>{

  /**
   * Constructor
   */
  public SiriusHighlightAllPatternsInstancesPanelDialog(
      Set<IPatternInstance> instances_p, DDiagram diagram_p,
      Shell parentShell_p, String dialogTitle_p, String dialogMessage_p) {
    super(instances_p, diagram_p, parentShell_p, dialogTitle_p, dialogMessage_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog#instantiateColorObject(int, int, int)
   */
  @Override
  protected RGBValues instantiateColorObject(int R, int G, int B) {
    return ColorUtil.getRGBColor(255, 0, 0);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog#convertSWTRGBToColor(org.eclipse.swt.graphics.RGB)
   */
  @Override
  protected RGBValues convertSWTRGBToColor(RGB swtColor_p) {
    return ColorUtil.convertRGBToRGBValues(swtColor_p);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog#convertColorToSWTRGB(java.lang.Object)
   */
  @Override
  protected RGB convertColorToSWTRGB(Object color_p) {
    if(color_p instanceof RGBValues)
      return ColorUtil.convertRGBValuesToRGB((RGBValues)color_p);
    return null;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog#colorRed(java.lang.Object)
   */
  @Override
  protected int colorRed(Object color_p) {
    if(color_p instanceof RGBValues)
      return ((RGBValues)color_p).getRed();
    return 0;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog#colorGreen(java.lang.Object)
   */
  @Override
  protected int colorGreen(Object color_p) {
    if(color_p instanceof RGBValues)
      return ((RGBValues)color_p).getGreen();
    return 0;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.dialogs.HighlightAllPatternsInstancesPanelDialog#colorBlue(java.lang.Object)
   */
  @Override
  protected int colorBlue(Object color_p) {
    if(color_p instanceof RGBValues)
      return ((RGBValues)color_p).getBlue();
    return 0;
  }


}
