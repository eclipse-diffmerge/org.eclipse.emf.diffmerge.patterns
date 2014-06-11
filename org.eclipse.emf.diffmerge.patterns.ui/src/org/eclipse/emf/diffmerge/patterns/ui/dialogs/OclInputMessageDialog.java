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
package org.eclipse.emf.diffmerge.patterns.ui.dialogs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedBijection;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.diffmerge.patterns.templates.ocl.OclPatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.templates.ocl.interpreter.OclInterpreter;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.ocl.examples.interpreter.OCLExamplePlugin;
import org.eclipse.ocl.examples.interpreter.console.IOCLFactory;
import org.eclipse.ocl.examples.interpreter.console.ModelingLevel;
import org.eclipse.ocl.examples.interpreter.console.TargetMetamodel;
import org.eclipse.ocl.examples.interpreter.console.text.ColorManager;
import org.eclipse.ocl.examples.interpreter.console.text.OCLDocument;
import org.eclipse.ocl.examples.interpreter.console.text.OCLSourceViewer;
import org.eclipse.ocl.examples.interpreter.internal.l10n.OCLInterpreterMessages;
//import org.eclipse.emf.ocl.examples.interpreter.OCLExamplePlugin;
//import org.eclipse.emf.ocl.examples.interpreter.console.IOCLFactory;
//import org.eclipse.emf.ocl.examples.interpreter.console.ModelingLevel;
//import org.eclipse.emf.ocl.examples.interpreter.console.TargetMetamodel;
//import org.eclipse.emf.ocl.examples.interpreter.console.text.ColorManager;
//import org.eclipse.emf.ocl.examples.interpreter.console.text.OCLDocument;
//import org.eclipse.emf.ocl.examples.interpreter.console.text.OCLSourceViewer;
//import org.eclipse.emf.ocl.examples.interpreter.internal.l10n.OCLInterpreterMessages;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;



/**
 * A message dialog which prompts for OCL input
 * Copied and adapted from org.eclipse.emf.ocl.examples.interpreter.OCLConsolePage
 * @author O. CONSTANT
 */
public class OclInputMessageDialog extends MessageDialog {
  
  /** The root widget */
  private Composite _composite;
  
  /** The text viewer for output */
  private ITextViewer _output;

  /** The text viewer for input */
  protected OCLSourceViewer _input;
  
  /** The in-memory input document */
  protected OCLDocument _document;
  
  /** A registry of color resources */
  private ColorManager _colorManager;
  
  /** The last successfully parsed OCL expression */
  private String _lastOCLExpression;
  
  /** Whether the Finish button may be enabled */
  private final boolean _mayConfirm;
  
  /** The non-null context (self) */
  protected Object _context;
  
  /** The non-null role for generating contextual variables */
  protected final TemplatePatternRole _contextRole;
  
  /** The optional (pattern, model) mapping */
  protected final IPatternBasedBijection _valueMapping;
  
  /** Label provision */
  protected IItemLabelProvider _tupleTypeLabelProvider = new TupleTypeItemLabelProvider();
  private static final AdapterFactory _reflectiveAdapterFactory =
    new ReflectiveItemProviderAdapterFactory();
  
  
  /**
   * Constructor
   * @param parentShell_p the shell for this dialog
   * @param dialogTitle_p the dialog title
   * @param dialogMessage_p the dialog message
   * @param context_p an optional context element for defining "self"
   * @param role_p a non-null role for additional context variables
   * @param mapping_p an optional (pattern, model) mapping
   * @param initialBody_p an optional initial OCL expression
   * @param mayConfirm_p whether the user may click the finish button when legitimate
   */
  public OclInputMessageDialog(Shell parentShell_p, String dialogTitle_p, String dialogMessage_p,
      EObject context_p, TemplatePatternRole role_p, IPatternBasedBijection mapping_p,
      String initialBody_p, boolean mayConfirm_p) {
    super(parentShell_p, dialogTitle_p, null, dialogMessage_p, MessageDialog.QUESTION,
        new String[] {IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL}, 0);
    setShellStyle(getShellStyle() | SWT.RESIZE);
    _context = context_p != null? context_p: new Object();
    _lastOCLExpression = initialBody_p != null? initialBody_p: ""; //$NON-NLS-1$
    _contextRole = role_p;
    _valueMapping = mapping_p;
    _mayConfirm = mayConfirm_p;
  }
  
  /**
   * @see org.eclipse.jface.dialogs.IconAndMessageDialog#createContents(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createContents(Composite parent_p) {
    Control result = super.createContents(parent_p);
    getFinishButton().setEnabled(false);
    return result;
  }
  
  /**
   * @see org.eclipse.jface.dialogs.MessageDialog#createCustomArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public Control createCustomArea(Composite parent) {
    _composite = new SashForm(parent, SWT.VERTICAL | SWT.LEFT_TO_RIGHT);
    //Output
    _output = new TextViewer(_composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
    _output.getTextWidget().setLayoutData(new GridData(GridData.FILL_BOTH));
    _output.getTextWidget().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
    _output.setEditable(false);
    _output.setDocument(new Document());
    // Input
    _colorManager = new ColorManager();
    _document = new EcoreOclDocument();
    _input = new OCLSourceViewer(_composite, _colorManager, SWT.BORDER | SWT.MULTI);
    _input.setDocument(_document);
    _input.getTextWidget().addKeyListener(new InputKeyListener());
    setContext(_context);
    // Main
    ((SashForm) _composite).setWeights(new int[] {2, 1});
    GridData data = new GridData(GridData.FILL_BOTH);
    data.heightHint = 200;
    _composite.setLayoutData(data);
    _document.set(_lastOCLExpression);
    _input.getTextWidget().setFocus();
    return _composite;
  }
  
  /**
   * @see org.eclipse.jface.dialogs.Dialog#close()
   */
  @Override
  public boolean close() {
    _colorManager.dispose();
    return super.close();
  }
  
  /**
   * Set the context of the expression (self)
   * @param context_p a potentially null element
   */
  protected void setContext(Object context_p) {
    _context = context_p;
    if (_context instanceof EObject)
      _document.setOCLContext((EObject)_context);
  }
  
  /**
   * Evaluates an OCL expression using the OCL Interpreter's {@link OCLHelper}
   * API.
   * 
   * @param rawExpression an OCL expression
   * 
   * @return <code>true</code> on successful evaluation; <code>false</code>
   *    if the expression failed to parse or evaluate
   */
  protected boolean evaluate(String rawExpression) {
    boolean result = true;
    if (_context == null) {
      result = false;
      error(OCLInterpreterMessages.console_noContext);
    } else {
      try {
        IDocument doc = getDocument();
        Color outputDefault = _colorManager.getColor(ColorManager.DEFAULT);
        Color outputResults = _colorManager.getColor(ColorManager.OUTPUT_RESULTS);
        if (doc.getLength() > 0)
          append("", outputDefault, false); //$NON-NLS-1$
        print(OCLInterpreterMessages.console_evaluating, outputDefault, true);
        print(rawExpression, outputDefault, false);
        print(OCLInterpreterMessages.console_results, outputDefault, true);
        // Evaluate the query
        EObject context = _context instanceof EObject? (EObject)_context: null;
        OCLExpression parsed = getInterpreter().parse(rawExpression, _contextRole, context);
        Object evaluationResult = getInterpreter().evaluate(
            rawExpression, context, _contextRole, _valueMapping);
        print(evaluationResult, outputResults, false);
        // Store the successfully parsed expression
        _lastOCLExpression = rawExpression;
        if (_mayConfirm)
          getFinishButton().setEnabled(isValid(parsed, evaluationResult));
      } catch (Exception e) {
        result = false;
        error(e.getLocalizedMessage());
        getFinishButton().setEnabled(false);
      }
    }
    return result;
  }
  
  /**
   * Return the document in the output viewer.
   * @return the output document
   */
  private IDocument getDocument() {
    return _output.getDocument();
  }
  
  /**
   * Return the last successfully evaluated expression
   * @return a potentially null string
   */
  public String getExpression() {
    return _lastOCLExpression;
  }
  
  /**
   * Return the OCL interpreter of the current environment
   * @return a non-null OCL interpreter
   */
  protected OclInterpreter getInterpreter() {
    return OclPatternsPlugin.getDefault().getInterpreter();
  }
  
  /**
   * Return whether the given parsed expression is valid for this dialog.
   * Override if relevant.
   * @param parsedExpression_p a non-null expression
   * @param evaluationResult_p a potentially null result of the evaluation of parsedExpression_p
   */
  protected boolean isValid(OCLExpression parsedExpression_p, Object evaluationResult_p) {
    return true;
  }
  
  /**
   * Prints the specified <code>object</code> to the output viewer.  The
   * object is converted to a string using the best matching EMF label
   * provider adapter if it is an {@link EObject}; otherwise, just use
   * {@link String#valueOf(java.lang.Object)} on it.  If the
   * <code>object</code> is a collection or an array, then we print each
   * element on a separate line.
   * 
   * @param object the object or collection to print
   * @param color the color to print the <code>object</code> with
   * @param bold whether to display it in bold text
   */
  private void print(Object object, Color color, boolean bold) {
    Collection<?> toPrint;
    if (object == null) {
      toPrint = Collections.EMPTY_SET;
    } else if (object instanceof Collection<?>) {
      toPrint = (Collection<?>) object;
    } else if (object.getClass().isArray()) {
      toPrint = Arrays.asList((Object[]) object);
    } else {
      toPrint = Collections.singleton(object);
    }
    for (Iterator<?> iter = toPrint.iterator(); iter.hasNext();) {
      append(toString(iter.next()), color, bold);
    }
    scrollText();
  }
  
  /**
   * Converts a single object to a string, according to the rules described
   * for the {@link #print(Object, Color, boolean)} method.
   * 
   * @param object the object to print (not a collection type)
   * @return the string form of the <code>object</code>
   * 
   * @see #print(Object, Color, boolean)
   */
  protected String toString(Object object) {
    if (object instanceof EObject) {
      EObject eObject = (EObject) object;
      IItemLabelProvider labeler =
        (IItemLabelProvider) EcoreUtil.getRegisteredAdapter(
            eObject,
            IItemLabelProvider.class);
      if (labeler == null) {
        if (eObject.eClass() instanceof TupleType<?, ?>) {
          labeler = _tupleTypeLabelProvider;
        } else {
          labeler = (IItemLabelProvider) _reflectiveAdapterFactory.adapt(
              eObject, IItemLabelProvider.class);
        }
      }
      if (labeler != null) {
        return labeler.getText(object);
      }
    }
    return String.valueOf(object);
  }
  
  /**
   * Prints an error message to the output viewer, in red text.
   * 
   * @param message the error message to print
   */
  private void error(String message_p) {
    append(message_p, _colorManager.getColor(ColorManager.OUTPUT_ERROR), false);
    scrollText();
  }
  
  /**
   * @see org.eclipse.jface.dialogs.Dialog#getOKButton()
   */
  protected Button getFinishButton() {
    return getButton(IDialogConstants.OK_ID);
  }
  
  /**
   * Ensures that the last text printed to the output viewer is shown.
   */
  private void scrollText() {
    _output.revealRange(getDocument().getLength(), 0);
  }
  
  /**
   * Appends the specified text to the output viewer.
   * 
   * @param text the text to append
   * @param color the color to print the text with
   * @param bold whether to print the text bold
   */
  private void append(String text_p, Color color, boolean bold) {
    String text = text_p;
    IDocument doc = getDocument();
    try {
      int offset = doc.getLength();
      int length = text.length();
      text = text + '\n';
      if (offset > 0) {
        doc.replace(offset, 0, text);
      } else {
        doc.set(text);
      }
      StyleRange style = new StyleRange();
      style.start = offset;
      style.length = length;
      style.foreground = color;
      if (bold) {
        style.fontStyle = SWT.BOLD;
      }
      _output.getTextWidget().setStyleRange(style);
    } catch (BadLocationException e) {
      IStatus status = new Status(
          IStatus.ERROR,
          OCLExamplePlugin.getPluginId(),
          1,
          OCLInterpreterMessages.console_outputExc,
          e);
      OCLExamplePlugin.getDefault().getLog().log(status);
    }
  }
  
  
  /**
   * A key listener that listens for the Enter key to evaluate the OCL
   * expression
   */
  private class InputKeyListener implements KeyListener {
    /**
     * Constructor
     */
    public InputKeyListener() {
      super();
    }
    public void keyPressed(KeyEvent e) {
      switch (e.keyCode) {
        // Return pressed: evaluate expression
        case SWT.CR :
          if (!_input.isContentAssistActive()
              && (e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {
            String text = _document.get();
            evaluate(text);
          }
          break;
      }
    }
    public void keyReleased(KeyEvent e) {
      switch (e.keyCode) {
        // Space released: activate content assistance
        case ' ':
          if ((e.stateMask & SWT.CTRL) == SWT.CTRL) {
            _input.getContentAssistant().showPossibleCompletions();
          }
      }
    }
  }
  
  
  /**
   * In-memory document
   */
  private class EcoreOclDocument extends OCLDocument {
    /**
     * Constructor
     */
    public EcoreOclDocument() {
      super();
      setOCLFactory(new EcoreOCLFactory());
      setModelingLevel(ModelingLevel.M2);
    }
  }
  
  
  /**
   * An OCL factory for Ecore
   */
  private class EcoreOCLFactory implements IOCLFactory<Object> {
    /**
     * Constructor
     */
    public EcoreOCLFactory() {
      super();
    }
    /**
     * @see org.eclipse.emf.ocl.examples.interpreter.console.IOCLFactory#getTargetMetamodel()
     */
    public TargetMetamodel getTargetMetamodel() {
      return TargetMetamodel.Ecore;
    }
    /**
     * @see org.eclipse.emf.ocl.examples.interpreter.console.IOCLFactory#createOCL()
     */
    @SuppressWarnings("unchecked")
    public OCL createOCL() {
      EObject context = _context instanceof EObject? (EObject)_context: null;
      OCL result = getInterpreter().createOCL(_contextRole, context);
      return result;
    }
    /**
     * @see org.eclipse.emf.ocl.examples.interpreter.console.IOCLFactory#createOCL(org.eclipse.emf.ecore.resource.Resource)
     */
    @SuppressWarnings("unchecked")
    public OCL createOCL(Resource res) {
      return null;
    }
    /**
     * @see org.eclipse.emf.ocl.examples.interpreter.console.IOCLFactory#getContextClassifier(org.eclipse.emf.ecore.EObject)
     */
    public Object getContextClassifier(EObject object) {
      return _context instanceof EObject? ((EObject)_context).eClass(): null;
    }
    /**
     * @see org.eclipse.emf.ocl.examples.interpreter.console.IOCLFactory#getName(java.lang.Object)
     */
    public String getName(Object modelElement) {
      return ((ENamedElement) modelElement).getName();
    }
    public <PK, O, P, EL, PM, S, COA, SSA, CT, CLS, E> org.eclipse.ocl.OCL<PK, Object, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCL(
        ModelingLevel level) {
      // TODO Auto-generated method stub
      return null;
    }
    public <PK, O, P, EL, PM, S, COA, SSA, CT, CLS, E> org.eclipse.ocl.OCL<PK, Object, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCL(
        ModelingLevel level, Resource res) {
      // TODO Auto-generated method stub
      return null;
    }

  }
  
  
  /**
   * A label provider for tuple types
   */
  private class TupleTypeItemLabelProvider implements IItemLabelProvider {
    /**
     * Constructor
     */
    public TupleTypeItemLabelProvider() {
      super();
    }
    /**
     * @see org.eclipse.emf.edit.provider.IItemLabelProvider#getImage(java.lang.Object)
     */
    public Object getImage(Object object) {
      return null;
    }
    /**
     * @see org.eclipse.emf.edit.provider.IItemLabelProvider#getText(java.lang.Object)
     */
    public String getText(Object object) {
      @SuppressWarnings("unchecked")
      Tuple<?, Object> tuple = (Tuple<?, Object>) object;
      TupleType<?, ?> tupleType = tuple.getTupleType();
      StringBuffer result = new StringBuffer();
      result.append("Tuple{");//$NON-NLS-1$
      for (Iterator<?> iter = tupleType.oclProperties().iterator();
      iter.hasNext();) {
        Object next = iter.next();
        result.append(((ENamedElement)next).getName());
        result.append(" = "); //$NON-NLS-1$
        result.append(OclInputMessageDialog.this.toString(tuple.getValue(next)));
        if (iter.hasNext())
          result.append(", "); //$NON-NLS-1$
      }
      result.append('}');
      return result.toString();
    }
  }
  
}
