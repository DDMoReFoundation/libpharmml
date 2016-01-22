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
package eu.ddmore.libpharmml.dom.modeldefn;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.DependanceAttribute;
import eu.ddmore.libpharmml.dom.commontypes.LinkFunction;
import eu.ddmore.libpharmml.dom.commontypes.PMFtransform;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining count data models.
 * 
 * <p>Java class for CountDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CountDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}CommonObservationModelType">
 *       &lt;sequence>
 *         &lt;element name="CountVariable" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}CommonDiscreteVariableType"/>
 *         &lt;element name="NumberCounts" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}CommonDiscreteVariableType" minOccurs="0"/>
 *         &lt;element name="PreviousCountVariable" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}CommonDiscreteVariableType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InitialCountVariable" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}CommonDiscreteVariableType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Dependance" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DependanceType" minOccurs="0"/>
 *         &lt;element name="IntensityParameter" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DiscreteDataParameterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DispersionParameter" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DiscreteDataParameterType" minOccurs="0"/>
 *         &lt;element name="OverDispersionParameter" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DiscreteDataParameterType" minOccurs="0"/>
 *         &lt;element name="ZeroProbabilityParameter" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DiscreteDataParameterType" minOccurs="0"/>
 *         &lt;element name="MixtureProbabilityParameter" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}DiscreteDataParameterType" minOccurs="0"/>
 *         &lt;element name="PMF" type="{http://www.pharmml.org/pharmml/0.8/ModelDefinition}CountPMFType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountDataType", propOrder = {
    "countVariable",
    "numberCounts",
    "previousCountVariable",
    "listOfInitialCountVariable",
    "dependance",
    "intensityParameter",
    "dispersionParameter",
    "overDispersionParameter",
    "zeroProbabilityParameter",
    "mixtureProbabilityParameter",
    "pmf"
})
public class CountData
    extends CommonObservationModel
{

    @XmlElement(name = "CountVariable", required = true)
    protected CommonDiscreteVariable countVariable;
    @XmlElement(name = "NumberCounts")
    protected CommonDiscreteVariable numberCounts; // PharmML 0.7
    @XmlElement(name = "PreviousCountVariable")
    protected List<CommonDiscreteVariable> previousCountVariable;
    @XmlElement(name = "InitialCountVariable")
    protected List<CommonDiscreteVariable> listOfInitialCountVariable; // PharmML 0.8
    @XmlElement(name = "Dependance")
    protected Dependance dependance;
    @XmlElement(name = "IntensityParameter")
    protected List<DiscreteDataParameter> intensityParameter;
    @XmlElement(name = "DispersionParameter")
    protected DiscreteDataParameter dispersionParameter;
    @XmlElement(name = "OverDispersionParameter")
    protected DiscreteDataParameter overDispersionParameter;
    @XmlElement(name = "ZeroProbabilityParameter")
    protected DiscreteDataParameter zeroProbabilityParameter;
    @XmlElement(name = "MixtureProbabilityParameter")
    protected DiscreteDataParameter mixtureProbabilityParameter;
    @XmlElement(name = "PMF", required = true)
    protected List<CountPMF> pmf;

    /**
     * Name of the count variable, usually Y.
     * 
     * @return
     *     possible object is
     *     {@link CommonDiscreteVariable }
     *     
     */
    public CommonDiscreteVariable getCountVariable() {
        return countVariable;
    }

    /**
     * Name of the count variable, usually Y.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonDiscreteVariable }
     *     
     */
    public void setCountVariable(CommonDiscreteVariable value) {
        this.countVariable = value;
    }
    
    /**
     * Symbol for the count number - usually 'k' in MLXTRAN and 'DV' in NMTRAN.
     * 
     * @return
     *     possible object is
     *     {@link CommonDiscreteVariable }
     *     
     * @since PharmML 0.7
     */
    public CommonDiscreteVariable getNumberCounts() {
        return numberCounts;
    }

    /**
     * Symbol for the count number - usually 'k' in MLXTRAN and 'DV' in NMTRAN.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonDiscreteVariable }
     *     
     * @since PharmML 0.7
     */
    public void setNumberCounts(CommonDiscreteVariable value) {
        this.numberCounts = value;
    }

    /**
     * Name of the previous count variable - used in models with Markov dependency.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the previousCountVariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreviousCountVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommonDiscreteVariable }
     * 
     * 
     */
    public List<CommonDiscreteVariable> getListOfPreviousCountVariable() {
        if (previousCountVariable == null) {
            previousCountVariable = new ArrayList<CommonDiscreteVariable>();
        }
        return this.previousCountVariable;
    }
    
    /**
     * Gets the value of the initialCountVariable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the initialCountVariable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInitialCountVariable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommonDiscreteVariable }
     * 
     * @since PharmML 0.8
     */
    public List<CommonDiscreteVariable> getListOfInitialCountVariable() {
        if (listOfInitialCountVariable == null) {
        	listOfInitialCountVariable = new ArrayList<CommonDiscreteVariable>();
        }
        return this.listOfInitialCountVariable;
    }

    /**
     * Type of dependency, discrete or continuous Markov.
     * 
     * @return
     *     possible object is
     *     {@link Dependance }
     *     
     */
    public Dependance getDependance() {
        return dependance;
    }

    /**
     * Type of dependency, discrete or continuous Markov.
     * 
     * @param value
     *     allowed object is
     *     {@link Dependance }
     *     
     */
    public void setDependance(Dependance value) {
        this.dependance = value;
    }

    /**
     * (Optional) Definition of 'Lambda' the Poisson intensity parameter
     * - can be defined more then once, for Markov dependency. Lambda can be defined
     * in the parameter model or as standard parameter in the observation model as well.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intensityParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntensityParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiscreteDataParameter }
     * 
     * 
     */
    public List<DiscreteDataParameter> getListOfIntensityParameter() {
        if (intensityParameter == null) {
            intensityParameter = new ArrayList<DiscreteDataParameter>();
        }
        return this.intensityParameter;
    }

    /**
     * (Optional) Definition of dispersion parameter, usualy 'tau', for NB models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @return
     *     possible object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public DiscreteDataParameter getDispersionParameter() {
        return dispersionParameter;
    }

    /**
     * (Optional) Definition of dispersion parameter, usualy 'tau', for NB models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public void setDispersionParameter(DiscreteDataParameter value) {
        this.dispersionParameter = value;
    }

    /**
     * (Optional) Definition of over-dispersion parameter, usualy 'delta', for GP models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @return
     *     possible object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public DiscreteDataParameter getOverDispersionParameter() {
        return overDispersionParameter;
    }

    /**
     * (Optional) Definition of over-dispersion parameter, usualy 'delta', for GP models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public void setOverDispersionParameter(DiscreteDataParameter value) {
        this.overDispersionParameter = value;
    }

    /**
     * (Optional) Definition of zero probability parameter, usualy 'p0', for ZIP models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @return
     *     possible object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public DiscreteDataParameter getZeroProbabilityParameter() {
        return zeroProbabilityParameter;
    }

    /**
     * (Optional) Definition of zero probability parameter, usualy 'p0', for ZIP models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public void setZeroProbabilityParameter(DiscreteDataParameter value) {
        this.zeroProbabilityParameter = value;
    }

    /**
     * (Optional) Definition of mixture probability parameter, usualy 'pi', for PMIX models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @return
     *     possible object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public DiscreteDataParameter getMixtureProbabilityParameter() {
        return mixtureProbabilityParameter;
    }

    /**
      * (Optional) Definition of mixture probability parameter, usualy 'pi', for PMIX models.
     * can be defined in the parameter model or as standard parameter in the observation model as well.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscreteDataParameter }
     *     
     */
    public void setMixtureProbabilityParameter(DiscreteDataParameter value) {
        this.mixtureProbabilityParameter = value;
    }

    /**
     * UncertML defined PMF for categories - it can be one of the discrete uni/multi-variate
     * or categorical uni/multi-variate PMFs as provided by UncertML.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pmf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfPMF().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CountPMF }
     * 
     * 
     */
    public List<CountPMF> getListOfPMF() {
        if (pmf == null) {
            pmf = new ArrayList<CountPMF>();
        }
        return this.pmf;
    }
    
    public CommonDiscreteVariable createCountVariable(){
    	this.countVariable = new CommonDiscreteVariable();
    	return this.countVariable;
    }
    public CommonDiscreteVariable createCountVariable(String symbId){
    	CommonDiscreteVariable cv = createCountVariable();
    	cv.setSymbId(symbId);
    	return cv;
    }
    public CommonDiscreteVariable createNumberCounts(){
    	this.numberCounts = new CommonDiscreteVariable();
    	return this.numberCounts;
    }
    public CommonDiscreteVariable createNumberCounts(String symbId){
    	CommonDiscreteVariable cv = createNumberCounts();
    	cv.setSymbId(symbId);
    	return cv;
    }
    public CommonDiscreteVariable createPreviousCountVariable(){
    	CommonDiscreteVariable cdv = new CommonDiscreteVariable();
    	getListOfPreviousCountVariable().add(cdv);
    	return cdv;
    }
    public CommonDiscreteVariable createPreviousCountVariable(String symbId){
    	CommonDiscreteVariable cdv = createPreviousCountVariable();
    	cdv.setSymbId(symbId);
    	return cdv;
    }
    public CommonDiscreteVariable createInitialCountVariable(){
    	CommonDiscreteVariable cdv = new CommonDiscreteVariable();
    	getListOfInitialCountVariable().add(cdv);
    	return cdv;
    }
    public CommonDiscreteVariable createInitialCountVariable(String symbId){
    	CommonDiscreteVariable cdv = createInitialCountVariable();
    	cdv.setSymbId(symbId);
    	return cdv;
    }
    public Dependance createDependance(DependanceAttribute dependance){
    	Dependance dep = new Dependance();
    	dep.setType(dependance);
    	this.dependance = dep;
    	return dep;
    }
    public DiscreteDataParameter createIntensityParameter(){
    	DiscreteDataParameter p = new DiscreteDataParameter();
    	getListOfIntensityParameter().add(p);
    	return p;
    }
    public DiscreteDataParameter createIntensityParamater(String symbId){
    	DiscreteDataParameter p = createIntensityParameter();
    	p.setSymbId(symbId);
    	return p;
    }
    public DiscreteDataParameter createIntensityParamater(String symbId, Rhs assign){
    	DiscreteDataParameter p = createIntensityParameter();
    	p.setSymbId(symbId);
    	p.setAssign(assign);
    	return p;
    }
    
    public DiscreteDataParameter createDispersionParameter(){
    	DiscreteDataParameter p = new DiscreteDataParameter();
    	this.dispersionParameter = p;
    	return p;
    }
    public DiscreteDataParameter createDispersionParameter(String symbId){
    	DiscreteDataParameter p = createDispersionParameter();
    	p.setSymbId(symbId);
    	return p;
    }
    public DiscreteDataParameter createDispersionParameter(String symbId, Rhs assign){
    	DiscreteDataParameter p = createDispersionParameter();
    	p.setSymbId(symbId);
    	p.setAssign(assign);
    	return p;
    }
    
    public DiscreteDataParameter createOverDispersionParameter(){
    	DiscreteDataParameter p = new DiscreteDataParameter();
    	this.overDispersionParameter = p;
    	return p;
    }
    public DiscreteDataParameter createOverDispersionParameter(String symbId){
    	DiscreteDataParameter p = createOverDispersionParameter();
    	p.setSymbId(symbId);
    	return p;
    }
    public DiscreteDataParameter createOverDispersionParameter(String symbId, Rhs assign){
    	DiscreteDataParameter p = createOverDispersionParameter();
    	p.setSymbId(symbId);
    	p.setAssign(assign);
    	return p;
    }
    
    public DiscreteDataParameter createZeroProbabilityParameter(){
    	DiscreteDataParameter p = new DiscreteDataParameter();
    	this.zeroProbabilityParameter = p;
    	return p;
    }
    public DiscreteDataParameter createZeroProbabilityParameter(String symbId){
    	DiscreteDataParameter p = createZeroProbabilityParameter();
    	p.setSymbId(symbId);
    	return p;
    }
    public DiscreteDataParameter createZeroProbabilityParameter(String symbId, Rhs assign){
    	DiscreteDataParameter p = createZeroProbabilityParameter();
    	p.setSymbId(symbId);
    	p.setAssign(assign);
    	return p;
    }
    
    public DiscreteDataParameter createMixtureProbabilityParameter(){
    	DiscreteDataParameter p = new DiscreteDataParameter();
    	this.mixtureProbabilityParameter = p;
    	return p;
    }
    public DiscreteDataParameter createMixtureProbabilityParameter(String symbId){
    	DiscreteDataParameter p = createMixtureProbabilityParameter();
    	p.setSymbId(symbId);
    	return p;
    }
    public DiscreteDataParameter createMixtureProbabilityParameter(String symbId, Rhs assign){
    	DiscreteDataParameter p = createMixtureProbabilityParameter();
    	p.setSymbId(symbId);
    	p.setAssign(assign);
    	return p;
    }
    
    public CountPMF createPMF(){
    	CountPMF pmf = new CountPMF();
    	getListOfPMF().add(pmf);
    	return pmf;
    }
    @Deprecated
    public CountPMF createPMF(LinkFunction linkFunction){
    	CountPMF pmf = createPMF();
    	pmf.setLinkFunction(linkFunction);
    	return pmf;
    }
    public CountPMF createPMF(PMFtransform transform){
    	CountPMF pmf = createPMF();
    	pmf.setTransform(transform);
    	return pmf;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(countVariable)
    			.addIfNotNull(numberCounts)
    			.addIfNotNull(previousCountVariable)
    			.addIfNotNull(listOfInitialCountVariable)
    			.addIfNotNull(dependance)
    			.addIfNotNull(intensityParameter)
    			.addIfNotNull(dispersionParameter)
    			.addIfNotNull(overDispersionParameter)
    			.addIfNotNull(zeroProbabilityParameter)
    			.addIfNotNull(mixtureProbabilityParameter)
    			.addIfNotNull(pmf);
    }
    
}
