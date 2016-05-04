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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.StandardOptionalAssignable;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Optimise on type.
 * 
 * <p>Java class for OptimiseOnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptimiseOnType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ArmSize" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element name="DoseAmount" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element name="DosingTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element name="Duration" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element name="NumberArms" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element name="NumberSamples" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element name="NumberTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element name="ObservationTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardExtAssignType" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbRef" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptimiseOnType", propOrder = {
    "armSize",
    "doseAmount",
    "dosingTimes",
    "duration",
    "numberArms",
    "numberSamples",
    "numberTimes",
    "observationTimes",
    "listOfSymbRef"
})
public class OptimiseOn
    extends PharmMLRootType
{

    @XmlElement(name = "ArmSize")
    protected StandardOptionalAssignable armSize;
    @XmlElement(name = "DoseAmount")
    protected StandardOptionalAssignable doseAmount;
    @XmlElement(name = "DosingTimes")
    protected StandardOptionalAssignable dosingTimes;
    @XmlElement(name = "Duration")
    protected StandardOptionalAssignable duration;
    @XmlElement(name = "NumberArms")
    protected StandardOptionalAssignable numberArms;
    @XmlElement(name = "NumberSamples")
    protected StandardOptionalAssignable numberSamples;
    @XmlElement(name = "NumberTimes")
    protected StandardOptionalAssignable numberTimes;
    @XmlElement(name = "ObservationTimes")
    protected StandardOptionalAssignable observationTimes;
    @XmlElement(name = "SymbRef", namespace = NS_DEFAULT_CT)
    protected List<SymbolRef> listOfSymbRef;

    /**
     * Gets the value of the armSize property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getArmSize() {
        return armSize;
    }

    /**
     * Sets the value of the armSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setArmSize(StandardOptionalAssignable value) {
        this.armSize = value;
    }

    /**
     * Gets the value of the doseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getDoseAmount() {
        return doseAmount;
    }

    /**
     * Sets the value of the doseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setDoseAmount(StandardOptionalAssignable value) {
        this.doseAmount = value;
    }

    /**
     * Gets the value of the dosingTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getDosingTimes() {
        return dosingTimes;
    }

    /**
     * Sets the value of the dosingTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setDosingTimes(StandardOptionalAssignable value) {
        this.dosingTimes = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setDuration(StandardOptionalAssignable value) {
        this.duration = value;
    }

    /**
     * Gets the value of the numberArms property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getNumberArms() {
        return numberArms;
    }

    /**
     * Sets the value of the numberArms property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setNumberArms(StandardOptionalAssignable value) {
        this.numberArms = value;
    }

    /**
     * Gets the value of the numberSamples property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getNumberSamples() {
        return numberSamples;
    }

    /**
     * Sets the value of the numberSamples property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setNumberSamples(StandardOptionalAssignable value) {
        this.numberSamples = value;
    }

    /**
     * Gets the value of the numberTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getNumberTimes() {
        return numberTimes;
    }

    /**
     * Sets the value of the numberTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setNumberTimes(StandardOptionalAssignable value) {
        this.numberTimes = value;
    }

    /**
     * Gets the value of the observationTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public StandardOptionalAssignable getObservationTimes() {
        return observationTimes;
    }

    /**
     * Sets the value of the observationTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardOptionalAssignable }
     *     
     */
    public void setObservationTimes(StandardOptionalAssignable value) {
        this.observationTimes = value;
    }

    /**
     * Gets the value of the symbRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfSymbRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SymbolRef }
     * 
     * 
     */
    public List<SymbolRef> getListOfSymbRef() {
        if (listOfSymbRef == null) {
        	listOfSymbRef = new ArrayList<SymbolRef>();
        }
        return this.listOfSymbRef;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(armSize)
    			.addIfNotNull(doseAmount)
    			.addIfNotNull(dosingTimes)
    			.addIfNotNull(duration)
    			.addIfNotNull(numberArms)
    			.addIfNotNull(numberSamples)
    			.addIfNotNull(numberTimes)
    			.addIfNotNull(observationTimes)
    			.addIfNotNull(listOfSymbRef);
    }
    
    /**                                                         
     * Creates a new empty {@link StandardOptionalAssignable} armSize element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.                                                       
     */                                                                                                                     
    public StandardOptionalAssignable createArmSize(){                                                                      
            StandardOptionalAssignable el = new StandardOptionalAssignable();                                               
            this.armSize = el;                                                                                              
            return el;                                                                                                      
    }                                                                                                                       

    /**
     * Creates a new empty {@link StandardOptionalAssignable} doseAmount element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.                                                          
     */                                                                                                                        
    public StandardOptionalAssignable createDoseAmount(){                                                                      
            StandardOptionalAssignable el = new StandardOptionalAssignable();                                                  
            this.doseAmount = el;                                                                                              
            return el;                                                                                                         
    }                                                                                                                          

    /**
     * Creates a new empty {@link StandardOptionalAssignable} dosingTimes element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.                                                           
     */                                                                                                                         
    public StandardOptionalAssignable createDosingTimes(){                                                                      
            StandardOptionalAssignable el = new StandardOptionalAssignable();                                                   
            this.dosingTimes = el;                                                                                              
            return el;                                                                                                          
    }                                                                                                                           

    /**
     * Creates a new empty {@link StandardOptionalAssignable} duration element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.                                                        
     */                                                                                                                      
    public StandardOptionalAssignable createDuration(){                                                                      
            StandardOptionalAssignable el = new StandardOptionalAssignable();                                                
            this.duration = el;                                                                                              
            return el;                                                                                                       
    }                                                                                                                        

    /**
     * Creates a new empty {@link StandardOptionalAssignable} numberArms element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.                                                          
     */                                                                                                                        
    public StandardOptionalAssignable createNumberArms(){                                                                      
            StandardOptionalAssignable el = new StandardOptionalAssignable();                                                  
            this.numberArms = el;                                                                                              
            return el;                                                                                                         
    }                                                                                                                          

    /**
     * Creates a new empty {@link StandardOptionalAssignable} numberSamples element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.                                                             
     */                                                                                                                           
    public StandardOptionalAssignable createNumberSamples(){                                                                      
            StandardOptionalAssignable el = new StandardOptionalAssignable();                                                     
            this.numberSamples = el;
            return el;
    }

    /**
     * Creates a new empty {@link StandardOptionalAssignable} numberTimes element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.
     */
    public StandardOptionalAssignable createNumberTimes(){
            StandardOptionalAssignable el = new StandardOptionalAssignable();
            this.numberTimes = el;
            return el;
    }

    /**
     * Creates a new empty {@link StandardOptionalAssignable} observationTimes element, adds it to the current object and returns it.
     * @return The created {@link StandardOptionalAssignable} object.
     */
    public StandardOptionalAssignable createObservationTimes(){
            StandardOptionalAssignable el = new StandardOptionalAssignable();
            this.observationTimes = el;
            return el;
    }

    /**
    * Creates a new empty {@link SymbolRef} SymbRef element, adds it to the current object and returns it.
    * @return The created {@link SymbolRef} object.
    */
    public SymbolRef createSymbRef(){
        SymbolRef el = new SymbolRef();
        getListOfSymbRef().add(el);
        return el;
    }

    /**
    * Creates a empty {@link SymbolRef} SymbRef element, adds it to the current object and returns it.
    * @param symbId symbId of the referred symbol.
    * @return The created {@link SymbolRef} object.
    */
    public SymbolRef createSymbRef(String symbId){
        SymbolRef el = new SymbolRef();
        el.setSymbIdRef(symbId);
        getListOfSymbRef().add(el);
        return el;
    }

    /**
    * Creates a empty {@link SymbolRef} SymbRef element, adds it to the current object and returns it.
    * @param symbId symbId of the referred symbol.
    * @param blkId The block identifier where the referred symbol is located.
    * @return The created {@link SymbolRef} object.
    */
    public SymbolRef createSymbRef(String symbId, String blkId){
        SymbolRef el = new SymbolRef();
        el.setSymbIdRef(symbId);
        el.setBlkIdRef(blkId);
        getListOfSymbRef().add(el);
        return el;
    }


}
