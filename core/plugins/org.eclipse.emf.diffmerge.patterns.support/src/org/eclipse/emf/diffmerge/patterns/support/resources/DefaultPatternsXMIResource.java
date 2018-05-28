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
package org.eclipse.emf.diffmerge.patterns.support.resources;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;


/**
 * An XMI resource that handles not yet serialized IDs of pattern elements
 * @author Skander Turki
 */
public class DefaultPatternsXMIResource extends XMIResourceImpl{

  /** A map of EObject to IDs before first save */
  protected Map<EObject, String> _newEObjectToIDMap;

  /**
   * Constructor
   * @param uri_p a non-null uri
   */
  public DefaultPatternsXMIResource(URI uri_p) {
    super(uri_p);
    _newEObjectToIDMap = new HashMap<EObject, String>();
  }

  /**
   * 
   * @see org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl#createXMLSave()
   */
  @Override
  protected XMLSave createXMLSave()
  {
    return new PatternCatalogXMISaveImpl(createXMLHelper());
  }

  /**
   * 
   * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#getID(org.eclipse.emf.ecore.EObject)
   */
  @Override
  public String getID(EObject eObject)
  {
    String result = null;
    if (eObjectToIDMap != null)
    {
      result = eObjectToIDMap.get(eObject);
    }
    if(result == null){
      result = _newEObjectToIDMap.get(eObject);
    }
    if(result == null && EcoreUtil.getID(eObject) == null){
      result = EcoreUtil.generateUUID();
      _newEObjectToIDMap.put(eObject, result);
    }

    return result;
  }


  /**
   * 
   * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#setID(org.eclipse.emf.ecore.EObject, java.lang.String)
   */
  @Override
  public void setID(EObject eObject, String id)
  {
    Object oldID = id != null ? getEObjectToIDMap().put(eObject, id) : getEObjectToIDMap().remove(eObject);

    if (oldID != null)
    {
      getIDToEObjectMap().remove(oldID);
    }

    if (id != null)
    {
      getIDToEObjectMap().put(id, eObject);
    }
  }


  /**
   * An XMI Save that handles not yet serialized IDs of pattern elements
   * @author Skander Turki
   *
   */
  public class PatternCatalogXMISaveImpl extends XMISaveImpl{

    /**
     * Constructor
     */
    public PatternCatalogXMISaveImpl(XMLHelper helper_p)
    {
      super(helper_p);
    }

    /**
     * Constructor
     */
    public PatternCatalogXMISaveImpl(Map<?, ?> options_p, XMLHelper helper_p, String encoding_p)
    {
      super(options_p, helper_p, encoding_p);
    }

    /**
     * Constructor
     */
    public PatternCatalogXMISaveImpl(Map<?, ?> options_p, XMLHelper helper_p, String encoding_p, String xmlVersion_p)
    {
      super(options_p, helper_p, encoding_p, xmlVersion_p);
    }

    /**
     * 
     * @see org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl#saveElementID(org.eclipse.emf.ecore.EObject)
     */
    @Override
    protected void saveElementID(EObject o)
    {
      String id = helper.getID(o);
      if(id == null && EcoreUtil.getID(o) == null){
        id = _newEObjectToIDMap.get(o);
        if(id == null){
          id = EcoreUtil.generateUUID();
          _newEObjectToIDMap.put(o, id);
        }
      }
      if (id != null)
      {
        if (!toDOM)
        {
          doc.addAttribute(idAttributeName, id);
        }
        else
        {
          Attr attr = document.createAttributeNS(idAttributeNS, idAttributeName);
          attr.setNodeValue(id);      
          ((Element)currentNode).setAttributeNodeNS(attr);
          handler.recordValues(attr, o, null, o);
        }
      }
      saveFeatures(o);
    }

  }

}
