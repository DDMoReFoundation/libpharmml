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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.modellingsteps;

import java.math.BigInteger;
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
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Type defining the estimation operation.
 *             
 * 
 * <p>Java class for EstimationOperationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstimationOperationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Name" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/ModellingSteps}Property" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Algorithm" type="{http://www.pharmml.org/2013/03/ModellingSteps}AlgorithmType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="order" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="opType" use="required" type="{http://www.pharmml.org/2013/03/ModellingSteps}EstimationOpTypeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstimationOperationType", propOrder = {
    "name",
    "property",
    "algorithm"
})
public class EstimationOperation
    extends PharmMLRootType
{

    @XmlElement(name = "Name", namespace = NS_DEFAULT_CT)
    protected Name name;
    @XmlElement(name = "Property")
    protected List<OperationProperty> property;
    @XmlElement(name = "Algorithm")
    protected Algorithm algorithm;
    @XmlAttribute(name = "order", required = true)
    protected Integer order;
    @XmlAttribute(name = "opType", required = true)
    protected String opType;

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
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OperationProperty }
     * 
     * 
     */
    public List<OperationProperty> getProperty() {
        if (property == null) {
            property = new ArrayList<OperationProperty>();
        }
        return this.property;
    }

    /**
     * Gets the value of the algorithm property.
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
     * Sets the value of the algorithm property.
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
     * Gets the value of the order property.
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
     * Sets the value of the order property.
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
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     * @deprecated PharmML now uses xs:int values. Use {@link #setOrder(Integer)}.
     */
    public void setOrder(BigInteger value) {
        this.order = value.intValue();
    }

    /**
     * Gets the value of the opType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpType() {
        return opType;
    }

    /**
     * Sets the value of the opType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpType(String value) {
        this.opType = value;
    }
    
    /**
     * Sets the value of the opType property.
     * 
     * @param value
     *     
     */
    public void setOpType(EstimationOpType value){
    	if(value == null){
    		this.opType = null;
    	} else {
    		this.opType = value.value();
    	}
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(name)
				.addIfNotNull(property)
				.addIfNotNull(algorithm);
	}

}
