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
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Type defining the design cost specification.
 * 
 * <p>Java class for CostType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CostType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="TotalCost" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="CostFunction" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}CostFunctionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CostType", propOrder = {
    "totalCost",
    "costFunction"
})
public class Cost
    extends PharmMLRootType
{

    @XmlElement(name = "TotalCost")
    protected StandardAssignable totalCost;
    @XmlElement(name = "CostFunction")
    protected CostFunction costFunction;

    /**
     * Gets the value of the totalCost property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setTotalCost(StandardAssignable value) {
        this.totalCost = value;
    }

    /**
     * Gets the value of the costFunction property.
     * 
     * @return
     *     possible object is
     *     {@link CostFunction }
     *     
     */
    public CostFunction getCostFunction() {
        return costFunction;
    }

    /**
     * Sets the value of the costFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostFunction }
     *     
     */
    public void setCostFunction(CostFunction value) {
        this.costFunction = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(totalCost)
    			.addIfNotNull(costFunction);
    }
    
    /**
     * Creates a new empty {@link StandardAssignable} totalCost element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createTotalCost(){
    	StandardAssignable el = new StandardAssignable();
    	this.totalCost = el;
    	return el;
    }

    /**
     * Creates a new empty {@link CostFunction} costFunction element, adds it to the current object and returns it.
     * @return The created {@link CostFunction} object.
     */
    public CostFunction createCostFunction(){
    	CostFunction el = new CostFunction();
    	this.costFunction = el;
    	return el;
    }

    /**
     * Creates a new empty {@link CostFunction} costFunction element, adds it to the current object and returns it.
     * @param costList
     * @return The created {@link CostFunction} object.
     */
    public CostFunction createCostFunction(CostList costList){
    	CostFunction el = new CostFunction(costList);
    	this.costFunction = el;
    	return el;
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
    
}
