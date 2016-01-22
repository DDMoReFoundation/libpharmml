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
 *                 Type that defines the target tool code injection.
 *             
 * 
 * <p>Java class for CodeInjectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CodeInjectionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="SymbolMapping" type="{http://www.pharmml.org/2013/03/ModellingSteps}SymbolMappingType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TargetCode" type="{http://www.pharmml.org/2013/03/ModellingSteps}GenericCodeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodeInjectionType", propOrder = {
    "msteps_listOfSymbolMapping",
    "design_listOfSymbolMapping",
    "msteps_targetCode",
    "design_targetCode"
})
@HasElementsRenamed({
	@HasElementRenamed(mappedFields = { 
			@RenamedElement(field = "msteps_listOfSymbolMapping"),
			@RenamedElement(field = "design_listOfSymbolMapping", since = PharmMLVersion.V0_7_3)}, 
			transientField = "listOfSymbolMapping"),
	@HasElementRenamed(mappedFields = { 
			@RenamedElement(field = "msteps_targetCode"),
			@RenamedElement(field = "design_targetCode", since = PharmMLVersion.V0_7_3)},
			transientField = "targetCode")		
})
public class CodeInjection
    extends PharmMLRootType
{

    @XmlElement(name = "SymbolMapping", namespace = XMLFilter.NS_DEFAULT_MSTEPS)
    protected List<SymbolMapping> msteps_listOfSymbolMapping;
    @XmlElement(name = "SymbolMapping", namespace = XMLFilter.NS_DEFAULT_TD)
    protected List<SymbolMapping> design_listOfSymbolMapping;
    @XmlTransient
    protected List<SymbolMapping> listOfSymbolMapping;
    
    
    @XmlElement(name = "TargetCode", namespace = XMLFilter.NS_DEFAULT_MSTEPS)
    protected GenericCode msteps_targetCode;
    @XmlElement(name = "TargetCode", namespace = XMLFilter.NS_DEFAULT_TD, required = true)
    protected GenericCode design_targetCode;
    @XmlTransient
    protected GenericCode targetCode;

    /**
     * Gets the value of the symbolMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbolMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSymbolMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SymbolMapping }
     * 
     * 
     */
    public List<SymbolMapping> getListOfSymbolMapping() {
        if (listOfSymbolMapping == null) {
        	listOfSymbolMapping = new ArrayList<SymbolMapping>();
        }
        return this.listOfSymbolMapping;
    }
    
    /**
     * @deprecated Use {@link #getListOfSymbolMapping()}.
     */
    public List<SymbolMapping> getSymbolMapping() {
        return getListOfSymbolMapping();
    }

    /**
     * Gets the value of the targetCode property.
     * 
     * @return
     *     possible object is
     *     {@link GenericCode }
     *     
     */
    public GenericCode getTargetCode() {
        return targetCode;
    }

    /**
     * Sets the value of the targetCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericCode }
     *     
     */
    public void setTargetCode(GenericCode value) {
        this.targetCode = value;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(listOfSymbolMapping)
				.addIfNotNull(targetCode);
	}
    
    /**
     * Creates a new empty {@link SymbolMapping} element, adds it to the current object and returns it.
     * @return The created {@link SymbolMapping} object.
     */
    public SymbolMapping createSymbolMapping(){
            SymbolMapping el = new SymbolMapping();
            getListOfSymbolMapping().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link GenericCode} target code element, adds it to the current object 
     * and returns it.
     * @return The created {@link GenericCode} object.
     */
    public GenericCode createTargetCode(){
            GenericCode el = new GenericCode();
            this.targetCode = el;
            return el;
    }


}
