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
import javax.xml.bind.JAXBElement;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.trialdesign.ExternalDataSet;
import eu.ddmore.libpharmml.impl.XMLFilter;
//import eu.ddmore.libpharmml.dom.commontypes.ToolName;
//import eu.ddmore.libpharmml.impl.LoggerWrapper;
//import eu.ddmore.libpharmml.impl.MarshalListener;
//import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 A type defining the modelling steps section.                 
 *             
 * 
 * <p>Java class for ModellingStepsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModellingStepsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.6/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="TargetTool" type="{http://www.pharmml.org/pharmml/0.6/ModellingSteps}TargetToolType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}CommonModellingStep" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.6/ModellingSteps}CommonModellingStep" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StepDependencies" type="{http://www.pharmml.org/pharmml/0.6/ModellingSteps}StepDependencyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModellingStepsType", propOrder = {
	"listOfExternalDataset",
    "listOfMonolixDataset",
    "listOfNonmemDataset",
    "targetTool",
    "commonModellingStep",
    "listOfOptimalDesignStep",
    "stepDependencies"
})
@SuppressWarnings("deprecation")
public class ModellingSteps
    extends PharmMLRootType
{

	// Dataset bundle, see afterUnmarshal and beforeMarshal
    @XmlElement(name = "MONOLIXdataSet")
    private List<MONOLIXdataSet> listOfMonolixDataset;
    @XmlElement(name = "NONMEMdataSet")
    private List<NONMEMdataSet> listOfNonmemDataset;
    
    @XmlElement(name = "ExternalDataSet", namespace = XMLFilter.NS_DEFAULT_MSTEPS) // NS < PharmML0.7
    @Deprecated
    protected List<ExternalDataSet> listOfExternalDataset;
    // --------------
    
    @XmlElement(name = "TargetTool")
    protected List<TargetTool> targetTool;
    @XmlElementRef(name = "CommonModellingStep", namespace = XMLFilter.NS_DEFAULT_MSTEPS, type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends CommonModellingStep>> commonModellingStep;
    @XmlElement(name = "OptimalDesignStep")
    protected List<OptimalDesignStep> listOfOptimalDesignStep;
    @XmlElement(name = "StepDependencies")
    protected StepDependency stepDependencies;

    /**
     * Gets the value of the monoliXdataSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the monoliXdataSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMONOLIXdataSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MONOLIXdataSet }
     * 
     * @deprecated Since PharmML 0.6, external datasets are available via {@link #getListOfExternalDataSet()}.
     */
    @Deprecated
    public List<MONOLIXdataSet> getListOfMONOLIXdataSet() {
        if (listOfMonolixDataset == null) {
        	listOfMonolixDataset = new ArrayList<MONOLIXdataSet>();
        }
        return this.listOfMonolixDataset;
    }

    /**
     * Gets the value of the nonmeMdataSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonmeMdataSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNONMEMdataSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NONMEMdataSet }
     * 
     * @since PharmML 0.3
     * @deprecated Since PharmML 0.6, external datasets are available via {@link #getListOfExternalDataSet()}.
     */
    @Deprecated
    public List<NONMEMdataSet> getNONMEMdataSet() {
        if (listOfNonmemDataset == null) {
        	listOfNonmemDataset = new ArrayList<NONMEMdataSet>();
        }
        return this.listOfNonmemDataset;
    }
    
    /**
     * Gets the value of the externalDataSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalDataSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalDataSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalDataSet }
     * 
     * @deprecated Since PharmML 0.7
     */
    @Deprecated
    public List<ExternalDataSet> getListOfExternalDataSet() {
        if (listOfExternalDataset == null) {
            listOfExternalDataset = new ArrayList<ExternalDataSet>();
        }
        return this.listOfExternalDataset;
    }

    /**
     * Gets the value of the targetTool property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetTool property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetTool().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetTool }
     * 
     * @since PharmML 0.3
     */
    public List<TargetTool> getTargetTool() {
        if (targetTool == null) {
            targetTool = new ArrayList<TargetTool>();
        }
        return this.targetTool;
    }

    /**
     * 
     *                                 A modelling step.                
     *                             Gets the value of the commonModellingStep property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commonModellingStep property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommonModellingStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CommonModellingStep }{@code >}
     * {@link JAXBElement }{@code <}{@link Simulation }{@code >}
     * {@link JAXBElement }{@code <}{@link Estimation }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends CommonModellingStep>> getCommonModellingStep() {
        if (commonModellingStep == null) {
            commonModellingStep = new ArrayList<JAXBElement<? extends CommonModellingStep>>();
        }
        return this.commonModellingStep;
    }

    /**
     * Gets the value of the optimalDesignStep property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optimalDesignStep property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfOptimalDesignStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptimalDesignStep }
     * 
     * 
     */
    public List<OptimalDesignStep> getListOfOptimalDesignStep() {
        if (listOfOptimalDesignStep == null) {
        	listOfOptimalDesignStep = new ArrayList<OptimalDesignStep>();
        }
        return this.listOfOptimalDesignStep;
    }

    /**
     * Gets the value of the stepDependencies property.
     * 
     * @return
     *     possible object is
     *     {@link StepDependency }
     *     
     */
    public StepDependency getStepDependencies() {
        return stepDependencies;
    }

    /**
     * Sets the value of the stepDependencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link StepDependency }
     *     
     */
    public void setStepDependencies(StepDependency value) {
        this.stepDependencies = value;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		ChainedList<TreeNode> list = new ChainedList<TreeNode>()
				.addIfNotNull(listOfExternalDataset)
				.addIfNotNull(targetTool);
		for(JAXBElement<? extends CommonModellingStep> el : getCommonModellingStep()){
			list.add(el.getValue());
		}
		list.addIfNotNull(listOfOptimalDesignStep).addIfNotNull(stepDependencies);
		return list;
	}
    
    /**
     * Creates a new empty {@link TargetTool} targetTool element, adds it to the current object and returns it.
     * @return The created {@link TargetTool} object.
     */
    public TargetTool createTargetTool(){
    	TargetTool el = new TargetTool();
    	targetTool.add(el);
    	return el;
    }
    
    /**
     * Creates a new empty {@link TargetTool} targetTool element, adds it to the current object and returns it.
     * @param oid
     * @param targetToolName
     * @return The created {@link TargetTool} object.
     */
    public TargetTool createTargetTool(String oid, String targetToolName){
    	TargetTool el = new TargetTool();
    	el.setOid(oid);
    	el.setTargetToolName(targetToolName);
    	targetTool.add(el);
    	return el;
    }
    
    /**
     * Creates a new empty {@link OptimalDesignStep} OptimalDesignStep element, adds it to the current object and returns it.
     * @return The created {@link OptimalDesignStep} object.
     */
    public OptimalDesignStep createOptimalDesignStep(){
    	OptimalDesignStep el = new OptimalDesignStep();
    	getListOfOptimalDesignStep().add(el);
    	return el;
    }
    
    /**
     * Creates a new empty {@link OptimalDesignStep} OptimalDesignStep element, adds it to the current object and returns it.
     * @param oid
     * @return The created {@link OptimalDesignStep} object.
     */
    public OptimalDesignStep createOptimalDesignStep(String oid){
    	OptimalDesignStep el = new OptimalDesignStep(oid);
    	getListOfOptimalDesignStep().add(el);
    	return el;
    }

    /**
     * Creates a new empty {@link StepDependency} stepDependencies element, adds it to the current object and returns it.
     * @return The created {@link StepDependency} object.
     */
    public StepDependency createStepDependencies(){
    	StepDependency el = new StepDependency();
    	this.stepDependencies = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link Estimation} step and adds it to this {@link ModellingSteps} object.
     * @return The created {@link Estimation} object.
     */
    public Estimation createEstimation(){
    	Estimation estimation = new Estimation();
    	getCommonModellingStep().add(MasterObjectFactory.MODELLINGSTEPS_OF.createEstimationStep(estimation));
    	return estimation;
    }
    
    /**
     * Creates a new {@link Estimation} step and adds it to this {@link ModellingSteps} object.
     * @param oid Object identifier of the estimation.
     * @return The created {@link Estimation} object.
     */
    public Estimation createEstimation(String oid){
    	Estimation estimation = new Estimation();
    	estimation.setOid(oid);
    	getCommonModellingStep().add(MasterObjectFactory.MODELLINGSTEPS_OF.createEstimationStep(estimation));
    	return estimation;
    }
    
    /**
     * Creates a new empty {@link Simulation} step and adds it to this {@link ModellingSteps} object.
     * @return The created {@link Simulation} object.
     */
    public Simulation createSimulation(){
    	Simulation simulation = new Simulation();
    	getCommonModellingStep().add(MasterObjectFactory.MODELLINGSTEPS_OF.createSimulationStep(simulation));
    	return simulation;
    }
    
    /**
     * Creates a new {@link Simulation} step and adds it to this {@link ModellingSteps} object.
     * @param oid Object identifier of the simulation.
     * @return The created {@link Simulation} object.
     */
    public Simulation createSimulation(String oid){
    	Simulation simulation = new Simulation();
    	simulation.setOid(oid);
    	getCommonModellingStep().add(MasterObjectFactory.MODELLINGSTEPS_OF.createSimulationStep(simulation));
    	return simulation;
    }

}
