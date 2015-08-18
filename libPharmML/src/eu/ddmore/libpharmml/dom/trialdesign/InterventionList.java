/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 * 
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 * 
 *  		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 ******************************************************************************/
package eu.ddmore.libpharmml.dom.trialdesign;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.tags.ReferenceContainer;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.validation.SymbolResolver;


/**
 * 
 *                     Type defining a treatment list of the study.  
 *                 
 * 
 * <p>Java class for InterventionListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterventionListType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="InterventionRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterventionListType", propOrder = {
    "listOfInterventionRef"
})
public class InterventionList
    extends PharmMLRootType implements ReferenceContainer
{

    @XmlElement(name = "InterventionRef", required = true)
    protected List<OidRef> listOfInterventionRef;

    /**
     * Gets the value of the interventionRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interventionRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfInterventionRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OidRef }
     * 
     * 
     */
    public List<OidRef> getListOfInterventionRef() {
        if (listOfInterventionRef == null) {
        	listOfInterventionRef = new ArrayList<OidRef>();
        }
        return this.listOfInterventionRef;
    }
    
    /**
     * Creates a new empty {@link OidRef} intervention reference element, adds it to the current object and returns it.
     * @return The created {@link OidRef} object.
     */
    public OidRef createInterventionRef(){
            OidRef el = new OidRef();
            getListOfInterventionRef().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link OidRef} intervention reference element, adds it to the current object and returns it.
     * @param oidRef Object identifier of the referred intervention.
     * @return The created {@link OidRef} object.
     */
    public OidRef createInterventionRef(String oidRef){
            OidRef el = new OidRef();
            el.setOidRef(oidRef);
            getListOfInterventionRef().add(el);
            return el;
    }


	@Override
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(listOfInterventionRef);
	}

}
