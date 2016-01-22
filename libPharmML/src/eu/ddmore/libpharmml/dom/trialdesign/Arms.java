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

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.modeldefn.DesignParameter;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type for the definition of arms and their properties.
 * 
 * <p>Java class for ArmsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArmsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DesignParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ArmSize" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="CostFunction" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="NumberArms" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="NumberSamples" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="NumberTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="SameTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="TotalCost" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="TotalSize" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="Arm" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ArmDefnType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArmsType", propOrder = {
    "listOfDesignParameter",
    "armSize",
    "costFunction",
    "numberArms",
    "numberSamples",
    "numberTimes",
    "sameTimes",
    "totalCost",
    "totalSize",
    "listOfArm"
})
public class Arms
    extends PharmMLRootType
{

    @XmlElement(name = "DesignParameter", namespace = XMLFilter.NS_DEFAULT_MDEF)
    protected List<DesignParameter> listOfDesignParameter;
    @XmlElement(name = "ArmSize")
    protected StandardAssignable armSize;
    @XmlElement(name = "CostFunction")
    protected StandardAssignable costFunction;
    @XmlElement(name = "NumberArms")
    protected StandardAssignable numberArms;
    @XmlElement(name = "NumberSamples")
    protected StandardAssignable numberSamples;
    @XmlElement(name = "NumberTimes")
    protected StandardAssignable numberTimes;
    @XmlElement(name = "SameTimes")
    protected StandardAssignable sameTimes;
    @XmlElement(name = "TotalCost")
    protected StandardAssignable totalCost;
    @XmlElement(name = "TotalSize")
    protected StandardAssignable totalSize;
    @XmlElement(name = "Arm", required = true)
    protected List<ArmDefinition> listOfArm;

    /**
     * A parameter definition.Gets the value of the designParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the designParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfDesignParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DesignParameter }
     * 
     * 
     */
    public List<DesignParameter> getListOfDesignParameter() {
        if (listOfDesignParameter == null) {
        	listOfDesignParameter = new ArrayList<DesignParameter>();
        }
        return this.listOfDesignParameter;
    }

    /**
     * Gets the value of the armSize property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getArmSize() {
        return armSize;
    }

    /**
     * Sets the value of the armSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setArmSize(StandardAssignable value) {
        this.armSize = value;
    }

    /**
     * Gets the value of the costFunction property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getCostFunction() {
        return costFunction;
    }

    /**
     * Sets the value of the costFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setCostFunction(StandardAssignable value) {
        this.costFunction = value;
    }

    /**
     * Gets the value of the numberArms property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNumberArms() {
        return numberArms;
    }

    /**
     * Sets the value of the numberArms property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNumberArms(StandardAssignable value) {
        this.numberArms = value;
    }

    /**
     * Gets the value of the numberSamples property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNumberSamples() {
        return numberSamples;
    }

    /**
     * Sets the value of the numberSamples property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNumberSamples(StandardAssignable value) {
        this.numberSamples = value;
    }

    /**
     * Gets the value of the numberTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getNumberTimes() {
        return numberTimes;
    }

    /**
     * Sets the value of the numberTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setNumberTimes(StandardAssignable value) {
        this.numberTimes = value;
    }

    /**
     * Gets the value of the sameTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getSameTimes() {
        return sameTimes;
    }

    /**
     * Sets the value of the sameTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setSameTimes(StandardAssignable value) {
        this.sameTimes = value;
    }

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
     * Gets the value of the totalSize property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getTotalSize() {
        return totalSize;
    }

    /**
     * Sets the value of the totalSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setTotalSize(StandardAssignable value) {
        this.totalSize = value;
    }

    /**
     * Gets the value of the arm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfArm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArmDefinition }
     * 
     * 
     */
    public List<ArmDefinition> getListOfArm() {
        if (listOfArm == null) {
        	listOfArm = new ArrayList<ArmDefinition>();
        }
        return this.listOfArm;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfDesignParameter)
    			.addIfNotNull(armSize)
    			.addIfNotNull(costFunction)
    			.addIfNotNull(numberArms)
    			.addIfNotNull(numberSamples)
    			.addIfNotNull(numberTimes)
    			.addIfNotNull(sameTimes)
    			.addIfNotNull(totalCost)
    			.addIfNotNull(totalSize)
    			.addIfNotNull(listOfArm);
    }
    
    /**                                                              
     * Creates a new empty {@link DesignParameter} element, adds it to the current object and returns it.
     * @return The created {@link DesignParameter} object.                                                                     
     */                                                                                                                        
    public DesignParameter createDesignParameter(){                                                                      
            DesignParameter el = new DesignParameter();                                                                        
            getListOfDesignParameter().add(el);                                                                          
            return el;                                                                                                         
    }    
    
    /**                                                              
     * Creates a new empty {@link DesignParameter} element, adds it to the current object and returns it.
     * @param symbId The symbol id of the parameter.
     * @return The created {@link DesignParameter} object.                                                                     
     */                                                                                                                        
    public DesignParameter createDesignParameter(String symbId){                                                                      
            DesignParameter el = new DesignParameter();  
            el.setSymbId(symbId);
            getListOfDesignParameter().add(el);                                                                          
            return el;                                                                                                         
    }   

    /**
     * Creates a new empty {@link StandardAssignable} armSize element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.                                                       
     */                                                                                                             
    public StandardAssignable createArmSize(){                                                                      
            StandardAssignable el = new StandardAssignable();                                                       
            this.armSize = el;                                                                                      
            return el;                                                                                              
    }                                                                                                               

    /**
     * Creates a new empty {@link StandardAssignable} costFunction element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.                                                            
     */                                                                                                                  
    public StandardAssignable createCostFunction(){                                                                      
            StandardAssignable el = new StandardAssignable();                                                            
            this.costFunction = el;                                                                                      
            return el;                                                                                                   
    }                                                                                                                    

    /**
     * Creates a new empty {@link StandardAssignable} numberArms element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.                                                          
     */                                                                                                                
    public StandardAssignable createNumberArms(){                                                                      
            StandardAssignable el = new StandardAssignable();                                                          
            this.numberArms = el;                                                                                      
            return el;                                                                                                 
    }                                                                                                                  

    /**
     * Creates a new empty {@link StandardAssignable} numberSamples element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.                                                             
     */                                                                                                                   
    public StandardAssignable createNumberSamples(){                                                                      
            StandardAssignable el = new StandardAssignable();                                                             
            this.numberSamples = el;                                                                                      
            return el;                                                                                                    
    }

    /**
     * Creates a new empty {@link StandardAssignable} numberTimes element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createNumberTimes(){
            StandardAssignable el = new StandardAssignable();
            this.numberTimes = el;
            return el;
    }

    /**
     * Creates a new empty {@link StandardAssignable} sameTimes element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createSameTimes(){
            StandardAssignable el = new StandardAssignable();
            this.sameTimes = el;
            return el;
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
     * Creates a new empty {@link StandardAssignable} totalSize element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createTotalSize(){
            StandardAssignable el = new StandardAssignable();
            this.totalSize = el;
            return el;
    }

    /**
     * Creates a new empty {@link ArmDefinition} arm element, adds it to the current object and returns it.
     * @return The created {@link ArmDefinition} object.
     */
    public ArmDefinition createArm(){
            ArmDefinition el = new ArmDefinition();
            getListOfArm().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link ArmDefinition} arm element, adds it to the current object and returns it.
     * @param oid Object identifier of the arm definition. For references.
     * @return The created {@link ArmDefinition} object.
     */
    public ArmDefinition createArm(String oid){
            ArmDefinition el = new ArmDefinition();
            el.setOid(oid);
            getListOfArm().add(el);
            return el;
    }


}
