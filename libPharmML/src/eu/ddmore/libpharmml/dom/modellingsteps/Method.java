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
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * Method type.
 * 
 * <p>Java class for MethodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MethodType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="Criterion" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}CriterionDefType" minOccurs="0"/>
 *         &lt;element name="FIMfunction" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}FIMfunctionType" minOccurs="0"/>
 *         &lt;element name="ComputeFIM" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}ComputeFIMType" minOccurs="0"/>
 *         &lt;element name="ApproximateFIM" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}ApproximateFIMType" minOccurs="0"/>
 *         &lt;element name="TypeFIM" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}TypeFIMType" minOccurs="0"/>
 *         &lt;element name="DesignType" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}DesignTypeType" minOccurs="0"/>
 *         &lt;element name="OptimizationAlgorithm" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}OptimizationAlgorithmType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodType", propOrder = {
    "criterion",
    "fiMfunction",
    "computeFIM",
    "approximateFIM",
    "typeFIM",
    "designType",
    "optimisationAlgorithm"
})
public class Method
    extends PharmMLRootType
{

    @XmlElement(name = "Criterion")
    protected CriterionDef criterion;
    @XmlElement(name = "FIMfunction")
    protected FIMfunction fiMfunction;
    @XmlElement(name = "ComputeFIM")
    protected ComputeFIM computeFIM;
    @XmlElement(name = "ApproximateFIM")
    protected ApproximateFIM approximateFIM;
    @XmlElement(name = "TypeFIM")
    protected TypeFIM typeFIM;
    @XmlElement(name = "DesignType")
    protected DesignType designType;
    @XmlElement(name = "OptimizationAlgorithm")
    protected OptimisationAlgorithm optimisationAlgorithm;

    /**
     * Gets the value of the criterion property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionDef }
     *     
     */
    public CriterionDef getCriterion() {
        return criterion;
    }

    /**
     * Sets the value of the criterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionDef }
     *     
     */
    public void setCriterion(CriterionDef value) {
        this.criterion = value;
    }

    /**
     * Gets the value of the fiMfunction property.
     * 
     * @return
     *     possible object is
     *     {@link FIMfunction }
     *     
     */
    public FIMfunction getFIMfunction() {
        return fiMfunction;
    }

    /**
     * Sets the value of the fiMfunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIMfunction }
     *     
     */
    public void setFIMfunction(FIMfunction value) {
        this.fiMfunction = value;
    }

    /**
     * Gets the value of the computeFIM property.
     * 
     * @return
     *     possible object is
     *     {@link ComputeFIM }
     *     
     */
    public ComputeFIM getComputeFIM() {
        return computeFIM;
    }

    /**
     * Sets the value of the computeFIM property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComputeFIM }
     *     
     */
    public void setComputeFIM(ComputeFIM value) {
        this.computeFIM = value;
    }

    /**
     * Gets the value of the approximateFIM property.
     * 
     * @return
     *     possible object is
     *     {@link ApproximateFIM }
     *     
     */
    public ApproximateFIM getApproximateFIM() {
        return approximateFIM;
    }

    /**
     * Sets the value of the approximateFIM property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApproximateFIM }
     *     
     */
    public void setApproximateFIM(ApproximateFIM value) {
        this.approximateFIM = value;
    }

    /**
     * Gets the value of the typeFIM property.
     * 
     * @return
     *     possible object is
     *     {@link TypeFIM }
     *     
     */
    public TypeFIM getTypeFIM() {
        return typeFIM;
    }

    /**
     * Sets the value of the typeFIM property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeFIM }
     *     
     */
    public void setTypeFIM(TypeFIM value) {
        this.typeFIM = value;
    }

    /**
     * Gets the value of the designType property.
     * 
     * @return
     *     possible object is
     *     {@link DesignType }
     *     
     */
    public DesignType getDesignType() {
        return designType;
    }

    /**
     * Sets the value of the designType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DesignType }
     *     
     */
    public void setDesignType(DesignType value) {
        this.designType = value;
    }

    /**
     * Gets the value of the optimisationAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link OptimisationAlgorithm }
     *     
     */
    public OptimisationAlgorithm getOptimizationAlgorithm() {
        return optimisationAlgorithm;
    }

    /**
     * Sets the value of the optimisationAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptimisationAlgorithm }
     *     
     */
    public void setOptimisationAlgorithm(OptimisationAlgorithm value) {
        this.optimisationAlgorithm = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(criterion)
    			.addIfNotNull(fiMfunction)
    			.addIfNotNull(computeFIM)
    			.addIfNotNull(approximateFIM)
    			.addIfNotNull(typeFIM)
    			.addIfNotNull(designType)
    			.addIfNotNull(optimisationAlgorithm);
    }
    
    /**
     * Creates a new empty {@link CriterionDef} criterion element, adds it to the current object and returns it.
     * @return The created {@link CriterionDef} object.
     */
    public CriterionDef createCriterion(){
    	CriterionDef el = new CriterionDef();
    	this.criterion = el;
    	return el;
    }
    
    /**
     * Creates a new {@link CriterionDef} criterion element, adds it to the current object and returns it.
     * @param criterion
     * @return The created {@link CriterionDef} object.
     */
    public CriterionDef createCriterion(Criterion criterion){
    	CriterionDef el = new CriterionDef(criterion);
    	this.criterion = el;
    	return el;
    }

    /**
     * Creates a new empty {@link FIMfunction} fiMfunction element, adds it to the current object and returns it.
     * @return The created {@link FIMfunction} object.
     */
    public FIMfunction createFiMfunction(){
    	FIMfunction el = new FIMfunction();
    	this.fiMfunction = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link FIMfunction} fiMfunction element, adds it to the current object and returns it.
     * @param fct
     * @return The created {@link FIMfunction} object.
     */
    public FIMfunction createFiMfunction(BuiltInFIMfct fct){
    	FIMfunction el = new FIMfunction(fct);
    	this.fiMfunction = el;
    	return el;
    }

    /**
     * Creates a new empty {@link ComputeFIM} computeFIM element, adds it to the current object and returns it.
     * @return The created {@link ComputeFIM} object.
     */
    public ComputeFIM createComputeFIM(){
    	ComputeFIM el = new ComputeFIM();
    	this.computeFIM = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link ComputeFIM} computeFIM element, adds it to the current object and returns it.
     * @param algo
     * @return The created {@link ComputeFIM} object.
     */
    public ComputeFIM createComputeFIM(ComputeAlgo algo){
    	ComputeFIM el = new ComputeFIM(algo);
    	this.computeFIM = el;
    	return el;
    }

    /**
     * Creates a new empty {@link ApproximateFIM} approximateFIM element, adds it to the current object and returns it.
     * @return The created {@link ApproximateFIM} object.
     */
    public ApproximateFIM createApproximateFIM(){
    	ApproximateFIM el = new ApproximateFIM();
    	this.approximateFIM = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link ApproximateFIM} approximateFIM element, adds it to the current object and returns it.
     * @param algo
     * @return The created {@link ApproximateFIM} object.
     */
    public ApproximateFIM createApproximateFIM(ApproxAlgo algo){
    	ApproximateFIM el = new ApproximateFIM(algo);
    	this.approximateFIM = el;
    	return el;
    }

    /**
     * Creates a new empty {@link TypeFIM} typeFIM element, adds it to the current object and returns it.
     * @return The created {@link TypeFIM} object.
     */
    public TypeFIM createTypeFIM(){
    	TypeFIM el = new TypeFIM();
    	this.typeFIM = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link TypeFIM} typeFIM element, adds it to the current object and returns it.
     * @param type
     * @return The created {@link TypeFIM} object.
     */
    public TypeFIM createTypeFIM(TypeFIMType type){
    	TypeFIM el = new TypeFIM(type);
    	this.typeFIM = el;
    	return el;
    }

    /**
     * Creates a new empty {@link DesignType} designType element, adds it to the current object and returns it.
     * @return The created {@link DesignType} object.
     */
    public DesignType createDesignType(){
    	DesignType el = new DesignType();
    	this.designType = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link DesignType} designType element, adds it to the current object and returns it.
     * @param optimisation
     * @return The created {@link DesignType} object.
     */
    public DesignType createDesignType(Optimisation optimisation){
    	DesignType el = new DesignType(optimisation);
    	this.designType = el;
    	return el;
    }

    /**
     * Creates a new empty {@link OptimisationAlgorithm} optimisationAlgorithm element, adds it to the current object and returns it.
     * @return The created {@link OptimisationAlgorithm} object.
     */
    public OptimisationAlgorithm createOptimisationAlgorithm(){
    	OptimisationAlgorithm el = new OptimisationAlgorithm();
    	this.optimisationAlgorithm = el;
    	return el;
    }

    /**
     * Creates a new empty {@link OptimisationAlgorithm} optimisationAlgorithm element, adds it to the current object and returns it.
     * @param algo
     * @return The created {@link OptimisationAlgorithm} object.
     */
    public OptimisationAlgorithm createOptimisationAlgorithm(OptimAlgo algo){
    	OptimisationAlgorithm el = new OptimisationAlgorithm(algo);
    	this.optimisationAlgorithm = el;
    	return el;
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
    
}
