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
package eu.ddmore.libpharmml.dom.modellingsteps;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Evaluation task type.
 * 
 * <p>Java class for OptimalDesignStepType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptimalDesignStepType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="TargetToolReference" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}TargetToolReferenceType" minOccurs="0"/>
 *         &lt;element name="OptimiseOn" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}OptimiseOnType" minOccurs="0"/>
 *         &lt;element name="FIM" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}FIMType" minOccurs="0"/>
 *         &lt;element name="Method" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}MethodType" minOccurs="0"/>
 *         &lt;element name="Cost" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}CostType" minOccurs="0"/>
 *         &lt;element name="PriorInformation" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}PriorType" minOccurs="0"/>
 *         &lt;element name="Compute" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}ComputeType" minOccurs="0"/>
 *         &lt;element name="SoftwareSettings" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}SoftwareSettingsType" minOccurs="0"/>
 *         &lt;element name="Operation" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}OptimalDesignOperationType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptimalDesignStepType", propOrder = {
    "targetToolReference",
    "optimiseOn",
    "fim",
    "method",
    "cost",
    "priorInformation",
    "compute",
    "softwareSettings",
    "listOfOperation"
})
public class OptimalDesignStep
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement(name = "TargetToolReference")
    protected TargetToolReference targetToolReference;
    @XmlElement(name = "OptimiseOn")
    protected OptimiseOn optimiseOn;
    @XmlElement(name = "FIM")
    protected FIM fim;
    @XmlElement(name = "Method")
    protected Method method;
    @XmlElement(name = "Cost")
    protected Cost cost;
    @XmlElement(name = "PriorInformation")
    protected Prior priorInformation;
    @XmlElement(name = "Compute")
    protected Compute compute;
    @XmlElement(name = "SoftwareSettings")
    protected SoftwareSettings softwareSettings;
    @XmlElement(name = "Operation", required = true)
    protected List<OptimalDesignOperation> listOfOperation;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;
    
    /**
     * Empty constructor
     */
    public OptimalDesignStep(){}
    
    /**
     * Constructs a new optimal design step with the required object identifier.
     * @param oid The oid as {@link String}.
     */
    public OptimalDesignStep(String oid){
    	this.oid = oid;
    }

    /**
     * Gets the value of the targetToolReference property.
     * 
     * @return
     *     possible object is
     *     {@link TargetToolReference }
     *     
     */
    public TargetToolReference getTargetToolReference() {
        return targetToolReference;
    }

    /**
     * Sets the value of the targetToolReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetToolReference }
     *     
     */
    public void setTargetToolReference(TargetToolReference value) {
        this.targetToolReference = value;
    }

    /**
     * Item to be optimised on, overwrite design spaces.
     * 
     * @return
     *     possible object is
     *     {@link OptimiseOn }
     *     
     */
    public OptimiseOn getOptimiseOn() {
        return optimiseOn;
    }

    /**
     * Item to be optimised on, overwrite design spaces.
     * 
     * @param value
     *     allowed object is
     *     {@link OptimiseOn }
     *     
     */
    public void setOptimiseOn(OptimiseOn value) {
        this.optimiseOn = value;
    }

    /**
     * Fisher Information Matrix - either explicit or in file.
     * 
     * @return
     *     possible object is
     *     {@link FIM }
     *     
     */
    public FIM getFIM() {
        return fim;
    }

    /**
     * Fisher Information Matrix - either explicit or in file.
     * 
     * @param value
     *     allowed object is
     *     {@link FIM }
     *     
     */
    public void setFIM(FIM value) {
        this.fim = value;
    }

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link Method }
     *     
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link Method }
     *     
     */
    public void setMethod(Method value) {
        this.method = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link Cost }
     *     
     */
    public Cost getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cost }
     *     
     */
    public void setCost(Cost value) {
        this.cost = value;
    }

    /**
     * Gets the value of the priorInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Prior }
     *     
     */
    public Prior getPriorInformation() {
        return priorInformation;
    }

    /**
     * Sets the value of the priorInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prior }
     *     
     */
    public void setPriorInformation(Prior value) {
        this.priorInformation = value;
    }

    /**
     * Gets the value of the compute property.
     * 
     * @return
     *     possible object is
     *     {@link Compute }
     *     
     */
    public Compute getCompute() {
        return compute;
    }

    /**
     * Sets the value of the compute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Compute }
     *     
     */
    public void setCompute(Compute value) {
        this.compute = value;
    }

    /**
     * Gets the value of the softwareSettings property.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareSettings }
     *     
     */
    public SoftwareSettings getSoftwareSettings() {
        return softwareSettings;
    }

    /**
     * Sets the value of the softwareSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareSettings }
     *     
     */
    public void setSoftwareSettings(SoftwareSettings value) {
        this.softwareSettings = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptimalDesignOperation }
     * 
     * 
     */
    public List<OptimalDesignOperation> getListOfOperation() {
        if (listOfOperation == null) {
        	listOfOperation = new ArrayList<OptimalDesignOperation>();
        }
        return this.listOfOperation;
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value) {
        this.oid = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(targetToolReference)
    			.addIfNotNull(optimiseOn)
    			.addIfNotNull(fim)
    			.addIfNotNull(method)
    			.addIfNotNull(cost)
    			.addIfNotNull(priorInformation)
    			.addIfNotNull(compute)
    			.addIfNotNull(softwareSettings)
    			.addIfNotNull(listOfOperation);
    }
    
    /**                                                         
     * Creates a new empty {@link TargetToolReference} targetToolReference element, adds it to the current object and returns it.
     * @return The created {@link TargetToolReference} object.                                                                   
     */                                                                                                                          
    public TargetToolReference createTargetToolReference(){                                                                      
            TargetToolReference el = new TargetToolReference();
            this.targetToolReference = el;
            return el;
    }
    
    /**                                                         
     * Creates a new empty {@link TargetToolReference} targetToolReference element, adds it to the current object and returns it.
     * @param oidRef Object identifier of the referred target tool.
     * @return The created {@link TargetToolReference} object.                                                                   
     */                                                                                                                          
    public TargetToolReference createTargetToolReference(String oidRef){                                                                      
            TargetToolReference el = new TargetToolReference();
            el.setOidRef(new OidRef(oidRef));
            this.targetToolReference = el;                                                                                       
            return el;                                                                                                           
    }  

    /**
     * Creates a new empty {@link OptimiseOn} optimiseOn element, adds it to the current object and returns it.
     * @return The created {@link OptimiseOn} object.                                                          
     */                                                                                                        
    public OptimiseOn createOptimiseOn(){                                                                      
            OptimiseOn el = new OptimiseOn();                                                                  
            this.optimiseOn = el;                                                                              
            return el;                                                                                         
    }                                                                                                          

    /**
     * Creates a new empty {@link FIM} fim element, adds it to the current object and returns it.
     * @return The created {@link FIM} object.
     */
    public FIM createFim(){
            FIM el = new FIM();
            this.fim = el;
            return el;
    }
    
    /**
     * Creates a new empty {@link FIM} fim element, adds it to the current object and returns it.
     * @param symbId symbId of the FIM.
     * @return The created {@link FIM} object.
     */
    public FIM createFim(String symbId){
            FIM el = new FIM();
            el.setSymbId(symbId);
            this.fim = el;
            return el;
    }

    /**
     * Creates a new empty {@link Method} method element, adds it to the current object and returns it.
     * @return The created {@link Method} object.
     */
    public Method createMethod(){
            Method el = new Method();
            this.method = el;
            return el;
    }

    /**
     * Creates a new empty {@link Cost} cost element, adds it to the current object and returns it.
     * @return The created {@link Cost} object.
     */
    public Cost createCost(){
            Cost el = new Cost();
            this.cost = el;
            return el;
    }

    /**
     * Creates a new empty {@link Prior} priorInformation element, adds it to the current object and returns it.
     * @return The created {@link Prior} object.
     */
    public Prior createPriorInformation(){
            Prior el = new Prior();
            this.priorInformation = el;
            return el;
    }
    
    /**
     * Creates a new empty {@link Prior} priorInformation element, adds it to the current object and returns it.
     * @param symbId symbId of the prior element.
     * @return The created {@link Prior} object.
     */
    public Prior createPriorInformation(String symbId){
            Prior el = new Prior();
            el.setSymbId(symbId);
            this.priorInformation = el;
            return el;
    }

    /**
     * Creates a new empty {@link Compute} compute element, adds it to the current object and returns it.
     * @return The created {@link Compute} object.
     */
    public Compute createCompute(){
            Compute el = new Compute();
            this.compute = el;
            return el;
    }

    /**
     * Creates a new empty {@link SoftwareSettings} softwareSettings element, adds it to the current object and returns it.
     * @return The created {@link SoftwareSettings} object.
     */
    public SoftwareSettings createSoftwareSettings(){
            SoftwareSettings el = new SoftwareSettings();
            this.softwareSettings = el;
            return el;
    }

    /**
     * Creates a new empty {@link OptimalDesignOperation} Operation element, adds it to the current object and returns it.
     * @return The created {@link OptimalDesignOperation} object.
     */
    public OptimalDesignOperation createOperation(){
            OptimalDesignOperation el = new OptimalDesignOperation();
            getListOfOperation().add(el);
            return el;
    }

    /**
     * Creates a new empty {@link OptimalDesignOperation} Operation element, adds it to the current object and returns it.
     * @param order
     * @param opType
     * @return The created {@link OptimalDesignOperation} object.
     */
    public OptimalDesignOperation createOperation(Integer order, OptimalDesignOpType opType){
            OptimalDesignOperation el = new OptimalDesignOperation(order,opType);
            getListOfOperation().add(el);
            return el;
    }
    
    /**
     * Creates a new empty {@link OptimalDesignOperation} Operation element, adds it to the current object and returns it.
     * @param order
     * @param opType
     * @param name
     * @return The created {@link OptimalDesignOperation} object.
     */
    public OptimalDesignOperation createOperation(Integer order, OptimalDesignOpType opType, Name name){
            OptimalDesignOperation el = new OptimalDesignOperation(order,opType,name);
            getListOfOperation().add(el);
            return el;
    }

}
