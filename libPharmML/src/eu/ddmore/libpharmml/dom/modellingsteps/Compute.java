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
package eu.ddmore.libpharmml.dom.modellingsteps;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining the computation detailes.
 * 
 * <p>Java class for ComputeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComputeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="GraphOnly" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="PowerComparison" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="NSubjectComparison" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="PowerEquivalence" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="NSubjectEquivalence" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="EquivalenceRange" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="TypeIError" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="TypeIIError" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputeType", propOrder = {
    "graphOnly",
    "powerComparison",
    "nSubjectComparison",
    "powerEquivalence",
    "nSubjectEquivalence",
    "equivalenceRange",
    "typeIError",
    "typeIIError"
})
public class Compute
    extends PharmMLRootType
{

    @XmlElement(name = "GraphOnly")
    protected StandardAssignable graphOnly;
    @XmlElement(name = "PowerComparison")
    protected StandardAssignable powerComparison;
    @XmlElement(name = "NSubjectComparison")
    protected StandardAssignable nSubjectComparison;
    @XmlElement(name = "PowerEquivalence")
    protected StandardAssignable powerEquivalence;
    @XmlElement(name = "NSubjectEquivalence")
    protected StandardAssignable nSubjectEquivalence;
    @XmlElement(name = "EquivalenceRange")
    protected StandardAssignable equivalenceRange;
    @XmlElement(name = "TypeIError")
    protected StandardAssignable typeIError;
    @XmlElement(name = "TypeIIError")
    protected StandardAssignable typeIIError;

    /**
     * Gets the value of the graphOnly property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getGraphOnly() {
        return graphOnly;
    }

    /**
     * Sets the value of the graphOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setGraphOnly(StandardAssignable value) {
        this.graphOnly = value;
    }

    /**
     * Gets the value of the powerComparison property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getPowerComparison() {
        return powerComparison;
    }

    /**
     * Sets the value of the powerComparison property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setPowerComparison(StandardAssignable value) {
        this.powerComparison = value;
    }

    /**
     * Gets the value of the nSubjectComparison property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNSubjectComparison() {
        return nSubjectComparison;
    }

    /**
     * Sets the value of the nSubjectComparison property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNSubjectComparison(StandardAssignable value) {
        this.nSubjectComparison = value;
    }

    /**
     * Gets the value of the powerEquivalence property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getPowerEquivalence() {
        return powerEquivalence;
    }

    /**
     * Sets the value of the powerEquivalence property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setPowerEquivalence(StandardAssignable value) {
        this.powerEquivalence = value;
    }

    /**
     * Gets the value of the nSubjectEquivalence property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNSubjectEquivalence() {
        return nSubjectEquivalence;
    }

    /**
     * Sets the value of the nSubjectEquivalence property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNSubjectEquivalence(StandardAssignable value) {
        this.nSubjectEquivalence = value;
    }

    /**
     * Gets the value of the equivalenceRange property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getEquivalenceRange() {
        return equivalenceRange;
    }

    /**
     * Sets the value of the equivalenceRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setEquivalenceRange(StandardAssignable value) {
        this.equivalenceRange = value;
    }

    /**
     * Gets the value of the typeIError property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getTypeIError() {
        return typeIError;
    }

    /**
     * Sets the value of the typeIError property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setTypeIError(StandardAssignable value) {
        this.typeIError = value;
    }

    /**
     * Gets the value of the typeIIError property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getTypeIIError() {
        return typeIIError;
    }

    /**
     * Sets the value of the typeIIError property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setTypeIIError(StandardAssignable value) {
        this.typeIIError = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(graphOnly)
    			.addIfNotNull(powerComparison)
    			.addIfNotNull(nSubjectComparison)
    			.addIfNotNull(powerEquivalence)
    			.addIfNotNull(nSubjectEquivalence)
    			.addIfNotNull(equivalenceRange)
    			.addIfNotNull(typeIError)
    			.addIfNotNull(typeIIError);
    }
    
    /**
     * Creates a new empty {@link StandardAssignable} graphOnly element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createGraphOnly(){
    	StandardAssignable el = new StandardAssignable();
    	this.graphOnly = el;
    	return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} powerComparison element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createPowerComparison(){
    	StandardAssignable el = new StandardAssignable();
    	this.powerComparison = el;
    	return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} nSubjectComparison element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createNSubjectComparison(){
    	StandardAssignable el = new StandardAssignable();
    	this.nSubjectComparison = el;
    	return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} powerEquivalence element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createPowerEquivalence(){
    	StandardAssignable el = new StandardAssignable();
    	this.powerEquivalence = el;
    	return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} nSubjectEquivalence element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createNSubjectEquivalence(){
    	StandardAssignable el = new StandardAssignable();
    	this.nSubjectEquivalence = el;
    	return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} equivalenceRange element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createEquivalenceRange(){
    	StandardAssignable el = new StandardAssignable();
    	this.equivalenceRange = el;
    	return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} typeIError element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createTypeIError(){
    	StandardAssignable el = new StandardAssignable();
    	this.typeIError = el;
    	return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} typeIIError element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createTypeIIError(){
    	StandardAssignable el = new StandardAssignable();
    	this.typeIIError = el;
    	return el;
    }


}
