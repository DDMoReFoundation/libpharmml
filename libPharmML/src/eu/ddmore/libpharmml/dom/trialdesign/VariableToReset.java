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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.RealValue;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Varible to be reset with options specification.
 *             
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VariableToResetType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element name="FullReset" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;sequence>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef"/>
 *           &lt;element name="ResetValue" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}RealValueType" minOccurs="0"/>
 *           &lt;element name="ResetTime" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}RealValueType" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableToResetType", propOrder = {
    "fullReset",
    "symbRef",
    "resetValue",
    "resetTime"
})
public class VariableToReset
    extends PharmMLRootType
{

    @XmlElement(name = "FullReset")
    protected FullReset fullReset;
    @XmlElement(name = "SymbRef", namespace = XMLFilter.NS_DEFAULT_CT)
    protected SymbolRef symbRef;
    @XmlElement(name = "ResetValue")
    protected RealValue resetValue;
    @XmlElement(name = "ResetTime")
    protected RealValue resetTime;
    
    /**
     * Checks if this reset concerns all the variables in the model. 
     * <p>This attributes works differently from the others in the way it is mapped to XML. 
     * This methods return true if the XML element <code>&lt;td:FullReset/></code> is present.
     * @return true/false
     */
    public boolean isFullReset(){
    	return fullReset != null;
    }
    
    /**
     * Sets if this reset concerns all the variables in the model.
     * <p>Setting true will create a <code>&lt;td:FullReset/></code> element in the XML, while
     * setting false will remove it.
     * @param fullReset True for a full reset of the variables. The default value is false.
     */
    public void setFullReset(boolean fullReset){
    	if(fullReset){
    		this.fullReset = new FullReset();
    	} else {
    		this.fullReset = null;
    	}
    }

    /**
     * Gets the value of the symbRef property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     */
    public SymbolRef getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }

    /**
     * Gets the value of the resetValue property.
     * 
     * @return
     *     possible object is
     *     {@link RealValue }
     *     
     */
    public RealValue getResetValue() {
        return resetValue;
    }

    /**
     * Sets the value of the resetValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealValue }
     *     
     */
    public void setResetValue(RealValue value) {
        this.resetValue = value;
    }

    /**
     * Gets the value of the resetTime property.
     * 
     * @return
     *     possible object is
     *     {@link RealValueType }
     *     
     */
    public RealValue getResetTime() {
        return resetTime;
    }

    /**
     * Sets the value of the resetTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealValueType }
     *     
     */
    public void setResetTime(RealValue value) {
        this.resetTime = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>()
    			.addIfNotNull(symbRef)
    			.addIfNotNull(resetValue)
    			.addIfNotNull(resetTime);
    }
    
    /**
     * Creates a new empty {@link SymbolRef} symbRef element, adds it to the current object and returns it.
     * @return The created {@link SymbolRef} object.
     */
    public SymbolRef createSymbRef(){
            SymbolRef el = new SymbolRef();
            this.symbRef = el;
            return el;
    }
    
    /**
     * Creates a new {@link SymbolRef} symbRef element, adds it to the current object and returns it.
     * @param symbId symbId of the referred symbol.
     * @return The created {@link SymbolRef} object.
     */
    public SymbolRef createSymbRef(String symbId){
            SymbolRef el = new SymbolRef();
            el.setSymbIdRef(symbId);
            this.symbRef = el;
            return el;
    }
    
    /**
     * Creates a new {@link SymbolRef} symbRef element, adds it to the current object and returns it.
     * @param symbId symbId of the referred symbol.
     * @param blkId The block identifier where the referred symbol is located.
     * @return The created {@link SymbolRef} object.
     */
    public SymbolRef createSymbRef(String symbId, String blkId){
            SymbolRef el = new SymbolRef();
            el.setSymbIdRef(symbId);
            el.setBlkIdRef(blkId);
            this.symbRef = el;
            return el;
    }

    /**
     * Creates a new empty {@link RealValue} resetValue element, adds it to the current object and returns it.
     * @return The created {@link RealValue} object.
     */
    public RealValue createResetValue(){
            RealValue el = new RealValue();
            this.resetValue = el;
            return el;
    }
    
    /**
     * Creates a new {@link RealValue} resetValue element, adds it to the current object and returns it.
     * @param value
     * @return The created {@link RealValue} object.
     */
    public RealValue createResetValue(Double value){
            RealValue el = new RealValue();
            el.setValue(value);
            this.resetValue = el;
            return el;
    }

    /**
     * Creates a new empty {@link RealValue} resetTime element, adds it to the current object and returns it.
     * @return The created {@link RealValue} object.
     */
    public RealValue createResetTime(){
            RealValue el = new RealValue();
            this.resetTime = el;
            return el;
    }
    
    /**
     * Creates a new empty {@link RealValue} resetTime element, adds it to the current object and returns it.
     * @param value
     * @return The created {@link RealValue} object.
     */
    public RealValue createResetTime(Double value){
            RealValue el = new RealValue();
            el.setValue(value);
            this.resetTime = el;
            return el;
    }
    
    @Override
    public String toString() {
    	if(isFullReset()){
    		return super.toString()+" -fullReset";
    	} else {
    		return super.toString();
    	}
    }
    
    /**
     * Class only used at the bottom layer to map the XML to the boolean attribute.
     */
    @XmlRootElement(name = "FullReset")
    protected static class FullReset {
    	
    }

}
