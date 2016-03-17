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

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Type defining the optimal design operation.
 *             
 * 
 * <p>Java class for OptimalDesignOperationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptimalDesignOperationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Name" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}Property" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Algorithm" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}AlgorithmType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="order" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="opType" use="required" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}OptimalDesignOpTypeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptimalDesignOperationType", propOrder = {
    "name",
    "listOfProperty",
    "algorithm"
})
public class OptimalDesignOperation
    extends PharmMLRootType
{

    @XmlElement(name = "Name", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Name name;
    @XmlElement(name = "Property")
    protected List<OperationProperty> listOfProperty;
    @XmlElement(name = "Algorithm")
    protected Algorithm algorithm;
    @XmlAttribute(name = "order", required = true) //TODO: must be positive
    protected Integer order;
    @XmlAttribute(name = "opType", required = true)
    protected OptimalDesignOpType opType;
    
    public OptimalDesignOperation(){}
    
    public OptimalDesignOperation(Integer order, OptimalDesignOpType opType){
    	this.order = order;
    	this.opType = opType;
    }
    
    public OptimalDesignOperation(Integer order, OptimalDesignOpType opType, Name name){
    	this.order = order;
    	this.opType = opType;
    	this.name = name;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * 
     *                                 Specifies a property of the operation.
     *                             Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationProperty }
     * 
     * 
     */
    public List<OperationProperty> getListOfProperty() {
        if (listOfProperty == null) {
            listOfProperty = new ArrayList<OperationProperty>();
        }
        return this.listOfProperty;
    }

    /**
     * Specifies the information about the algorithms used.
     * 
     * @return
     *     possible object is
     *     {@link Algorithm }
     *     
     */
    public Algorithm getAlgorithm() {
        return algorithm;
    }

    /**
     * Specifies the information about the algorithms used.
     * 
     * @param value
     *     allowed object is
     *     {@link Algorithm }
     *     
     */
    public void setAlgorithm(Algorithm value) {
        this.algorithm = value;
    }

    /**
     * Specifies the order of the operation.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Specifies the order of the operation.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    /**
     * Specifies the type of optimal design.
     * 
     * @return
     *     possible object is
     *     {@link OptimalDesignOpType }
     *     
     */
    public OptimalDesignOpType getOpType() {
        return opType;
    }

    /**
     * Specifies the type of optimal design.
     * 
     * @param value
     *     allowed object is
     *     {@link OptimalDesignOpType }
     *     
     */
    public void setOpType(OptimalDesignOpType value) {
        this.opType = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(name)
    			.addIfNotNull(listOfProperty)
    			.addIfNotNull(algorithm);
    }
    
    /**
     * Creates a new empty {@link Name} name element, adds it to the current object and returns it.
     * @return The created {@link Name} object.
     */
    public Name createName(){
    	Name el = new Name();
    	this.name = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link Name} name element, adds it to the current object and returns it.
     * @param name
     * @return The created {@link Name} object.
     */
    public Name createName(String name){
    	Name el = new Name(name);
    	this.name = el;
    	return el;
    }

    /**
     * Creates a new empty {@link OperationProperty} Property element, adds it to the current object and returns it.
     * @return The created {@link OperationProperty} object.
     */
    public OperationProperty createProperty(){
    	OperationProperty el = new OperationProperty();
    	getListOfProperty().add(el);
    	return el;
    }
    
    /**
     * Creates a new empty {@link OperationProperty} Property element, adds it to the current object and returns it.
     * @param name
     * @return The created {@link OperationProperty} object.
     */
    public OperationProperty createProperty(String name){
    	OperationProperty el = new OperationProperty(name);
    	getListOfProperty().add(el);
    	return el;
    }

    /**
     * Creates a new empty {@link Algorithm} algorithm element, adds it to the current object and returns it.
     * @return The created {@link Algorithm} object.
     */
    public Algorithm createAlgorithm(){
    	Algorithm el = new Algorithm();
    	this.algorithm = el;
    	return el;
    }


}
