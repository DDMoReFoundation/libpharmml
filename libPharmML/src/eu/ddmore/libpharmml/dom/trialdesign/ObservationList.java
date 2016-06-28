/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
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
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 * Type defining a sampling list of the study.  
 *                 
 * 
 * <p>Java class for ObservationListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObservationListType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ObservationRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObservationListType", propOrder = {
    "listOfObservationRef"
})
public class ObservationList
    extends PharmMLRootType implements ReferenceContainer
{

    @XmlElement(name = "ObservationRef", required = true)
    protected List<OidRef> listOfObservationRef;

    /**
     * Gets the value of the observationRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the observationRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfObservationRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OidRef }
     * 
     * 
     */
    public List<OidRef> getListOfObservationRef() {
        if (listOfObservationRef == null) {
        	listOfObservationRef = new ArrayList<OidRef>();
        }
        return this.listOfObservationRef;
    }

	@Override
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler) {
		// TODO
	}
	
	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>(super.listChildren())
				.addIfNotNull(listOfObservationRef);
	}
	
	/**
	 * Creates a new empty {@link OidRef} ObservationRef element, adds it to the current object and returns it.
	 * @return The created {@link OidRef} object.
	 */
	public OidRef createObservationRef(){
	        OidRef el = new OidRef();
	        getListOfObservationRef().add(el);
	        return el;
	}

	/**
	 * Creates a new empty {@link OidRef} ObservationRef, adds it to the current object and returns it.
	 * @param oidRef Reference to the intervention.
	 * @return The created {@link OidRef} object.
	 */
	public OidRef createObservationRef(String oidRef){
	        OidRef el = new OidRef();
	        el.setOidRef(oidRef);
	        getListOfObservationRef().add(el);
	        return el;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}



}
