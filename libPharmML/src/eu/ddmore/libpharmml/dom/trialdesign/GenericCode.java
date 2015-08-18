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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.util.annotations.HasElementRenamed;
import eu.ddmore.libpharmml.util.annotations.HasElementsRenamed;
import eu.ddmore.libpharmml.util.annotations.RenamedElement;


/**
 * 
 * Defines the target tool CDATA code injection containing element.
 *             
 * 
 * <p>Java class for GenericCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenericCodeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Symbol" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}TargetToolSymbolType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericCodeType", propOrder = {
    "msteps_listOfSymbol",
    "design_listOfSymbol",
    "msteps_code",
    "design_code"
})
@HasElementsRenamed({
	@HasElementRenamed(mappedFields = { 
			@RenamedElement(field = "msteps_listOfSymbol"),
			@RenamedElement(field = "design_listOfSymbol", since = PharmMLVersion.V0_7_1)},
			transientField = "listOfSymbol"),
	@HasElementRenamed(mappedFields = { 
			@RenamedElement(field = "msteps_code"),
			@RenamedElement(field = "design_code", since = PharmMLVersion.V0_7_1)},
			transientField = "code")
})
public class GenericCode
    extends PharmMLRootType
{

    @XmlElement(name = "Symbol", namespace = XMLFilter.NS_DEFAULT_MSTEPS)
    protected List<TargetToolSymbol> msteps_listOfSymbol;
    @XmlElement(name = "Symbol", namespace = XMLFilter.NS_DEFAULT_TD)
    protected List<TargetToolSymbol> design_listOfSymbol;
    @XmlTransient
    protected List<TargetToolSymbol> listOfSymbol;
    
    @XmlElement(name = "Code", namespace = XMLFilter.NS_DEFAULT_MSTEPS)
    protected String msteps_code;
    @XmlElement(name = "Code", namespace = XMLFilter.NS_DEFAULT_TD, required = true)
    protected String design_code;
    @XmlTransient
    protected String code;

    /**
     * Gets the value of the symbol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfSymbol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetToolSymbol }
     * 
     * 
     */
    public List<TargetToolSymbol> getListOfSymbol() {
        if (listOfSymbol == null) {
        	listOfSymbol = new ArrayList<TargetToolSymbol>();
        }
        return this.listOfSymbol;
    }

    /**
     * Original target tool code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the original target tool code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfSymbol);
    }

}
