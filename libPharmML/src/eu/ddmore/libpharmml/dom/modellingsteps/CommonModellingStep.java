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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.VariableAssignment;
import eu.ddmore.libpharmml.dom.dataset.ExternalFile;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.dom.trialdesign.ExternalDataSet;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Abstract type specifying the common features of a modelling step.                 
 *             
 * 
 * <p>Java class for CommonModellingStepType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonModellingStepType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="TargetToolReference" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}TargetToolReferenceType" minOccurs="0"/>
 *         &lt;element name="ExternalDataSetReference" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}ExternalDataSetReferenceType" minOccurs="0"/>
 *         &lt;element name="InterventionsReference" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}InterventionsReferenceType" minOccurs="0"/>
 *         &lt;element name="ObservationsReference" type="{http://www.pharmml.org/pharmml/0.7/ModellingSteps}ObservationsReferenceType" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}VariableAssignment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonModellingStepType", propOrder = {
	"listOfSoftwareSettings",
	"listOfOutputFile",
    "targetToolReference",
    "externalDataSetReference",
    "monoliXdataSetReference",
    "nonmeMdataSetReference",
    "interventionsReference",
    "observationsReference",
    "variableAssignment"
})
@XmlSeeAlso({
    Simulation.class,
    Estimation.class
})
public abstract class CommonModellingStep
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement(name = "TargetToolReference")
    protected TargetToolReference targetToolReference;
    
    @SuppressWarnings("deprecation")
	@XmlElement(name = "MONOLIXdataSetReference")
    protected MONOLIXdataSetReference monoliXdataSetReference;
    @SuppressWarnings("deprecation")
	@XmlElement(name = "NONMEMdataSetReference")
    protected NONMEMdataSetReference nonmeMdataSetReference;
    
    @XmlElement(name = "ExternalDataSetReference")
    protected ExternalDataSetReference externalDataSetReference;
    
    // PharmML 0.7 ---------------------------------
    @XmlElement(name = "InterventionsReference")
    protected InterventionsReference interventionsReference;
    @XmlElement(name = "ObservationsReference")
    protected ObservationsReference observationsReference;
    // ---------------------------------------------
    
    @XmlElement(name = "VariableAssignment", namespace = NS_DEFAULT_CT)
    protected List<VariableAssignment> variableAssignment;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;
    
    // PharmML 0.8.1
    @XmlElement(name = "SoftwareSettings")
    protected List<SoftwareSettings> listOfSoftwareSettings;
    @XmlElement(name = "OutputFile")
    protected List<ExternalFile> listOfOutputFile;
    
    /**
     * Gets the value of the softwareSettings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the softwareSettings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfSoftwareSettings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoftwareSettings }
     * 
     * @since PharmML 0.8.1
     */
    public List<SoftwareSettings> getListOfSoftwareSettings() {
        if (listOfSoftwareSettings == null) {
        	listOfSoftwareSettings = new ArrayList<SoftwareSettings>();
        }
        return this.listOfSoftwareSettings;
    }

    /**
     * Gets the value of the outputFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfOutputFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalFile }
     * 
     * @since PharmML 0.8.1
     */
    public List<ExternalFile> getListOfOutputFile() {
        if (listOfOutputFile == null) {
        	listOfOutputFile = new ArrayList<ExternalFile>();
        }
        return this.listOfOutputFile;
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
     * Gets the value of the externalDataSetReference property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalDataSetReference }
     *     
     */
    public ExternalDataSetReference getExternalDataSetReference() {
        return externalDataSetReference;
    }

    /**
     * Sets the value of the externalDataSetReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalDataSetReference }
     *     
     */
    public void setExternalDataSetReference(ExternalDataSetReference value) {
        this.externalDataSetReference = value;
    }

    /**
     * Gets the value of the monoliXdataSetReference property.
     * 
     * @return
     *     possible object is
     *     {@link MONOLIXdataSetReference }
     *     
     * @deprecated Use {@link #getExternalDataSetReference()}.
     */
    @Deprecated
    public MONOLIXdataSetReference getMONOLIXdataSetReference() {
        return monoliXdataSetReference;
    }

    /**
     * Sets the value of the monoliXdataSetReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link MONOLIXdataSetReference }
     * 
     * @deprecated Use {@link #setExternalDataSetReference(ExternalDataSetReference)} instead.
     */
    @Deprecated
    public void setMONOLIXdataSetReference(MONOLIXdataSetReference value) {
        this.monoliXdataSetReference = value;
    }

    /**
     * Gets the value of the nonmeMdataSetReference property.
     * 
     * @return
     *     possible object is
     *     {@link NONMEMdataSetReference }
     *  
     * @deprecated Use {@link #getExternalDataSetReference()}.
     */
    @Deprecated
    public NONMEMdataSetReference getNONMEMdataSetReference() {
        return nonmeMdataSetReference;
    }

    /**
     * Sets the value of the nonmeMdataSetReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link NONMEMdataSetReference }
     *  
     * @deprecated Use {@link #setExternalDataSetReference(ExternalDataSetReference)} instead.
     */
    @Deprecated
    public void setNONMEMdataSetReference(NONMEMdataSetReference value) {
        this.nonmeMdataSetReference = value;
    }
    
    /**
     * Gets the value of the interventionsReference property.
     * 
     * @return
     *     possible object is
     *     {@link InterventionsReference }
     *     
     */
    public InterventionsReference getInterventionsReference() {
        return interventionsReference;
    }

    /**
     * Sets the value of the interventionsReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterventionsReference }
     *     
     */
    public void setInterventionsReference(InterventionsReference value) {
        this.interventionsReference = value;
    }

    /**
     * Gets the value of the observationsReference property.
     * 
     * @return
     *     possible object is
     *     {@link ObservationsReference }
     *     
     */
    public ObservationsReference getObservationsReference() {
        return observationsReference;
    }

    /**
     * Sets the value of the observationsReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObservationsReference }
     *     
     */
    public void setObservationsReference(ObservationsReference value) {
        this.observationsReference = value;
    }

    /**
     * Gets the value of the variableAssignment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variableAssignment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfVariableAssignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableAssignment }
     * 
     * 
     */
    public List<VariableAssignment> getListOfVariableAssignment() {
        if (variableAssignment == null) {
            variableAssignment = new ArrayList<VariableAssignment>();
        }
        return this.variableAssignment;
    }
    
    /**
     * @deprecated Use {@link #getListOfVariableAssignment()}.
     */
    @Deprecated
    public List<VariableAssignment> getVariableAssignment() {
        return getListOfVariableAssignment();
    }

    /**
     * Gets the value of the oid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
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
    @Override
	public void setOid(String value) {
        this.oid = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(listOfSoftwareSettings)
    			.addIfNotNull(listOfOutputFile)
    			.addIfNotNull(targetToolReference)
    			.addIfNotNull(monoliXdataSetReference)
    			.addIfNotNull(nonmeMdataSetReference)
    			.addIfNotNull(externalDataSetReference)
    			.addIfNotNull(interventionsReference)
    			.addIfNotNull(observationsReference)
    			.addIfNotNull(variableAssignment);
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
     * @param oidRef Object id of the referred {@link TargetTool}.
     * @return The created {@link TargetToolReference} object.
     */
    public TargetToolReference createTargetToolReference(String oidRef){
    	TargetToolReference el = new TargetToolReference();
    	el.setOidRef(new OidRef(oidRef));
    	this.targetToolReference = el;
    	return el;
    }
    
    /**
     * Creates a new {@link TargetToolReference} targetToolReference element, adds it to the current object and returns it.
     * @param targetTool Referred {@link TargetTool}.
     * @return The created {@link TargetToolReference} object.
     */
    public TargetToolReference createTargetToolReference(TargetTool targetTool){
    	TargetToolReference el = new TargetToolReference();
    	el.setOidRef(new OidRef(targetTool));
    	this.targetToolReference = el;
    	return el;
    }

    /**
     * Creates a new {@link ExternalDataSetReference} externalDataSetReference element, adds it to the current object and returns it.
     * @return The created {@link ExternalDataSetReference} object.
     */
    public ExternalDataSetReference createExternalDataSetReference(){
    	ExternalDataSetReference el = new ExternalDataSetReference();
    	this.externalDataSetReference = el;
    	return el;
    }
    
    /**
     * Creates a new {@link ExternalDataSetReference} externalDataSetReference element, adds it to the current object and returns it.
     * @param oidRef Object id of the referred {@link ExternalDataSet}.
     * @return The created {@link ExternalDataSetReference} object.
     */
    public ExternalDataSetReference createExternalDataSetReference(String oidRef){
    	ExternalDataSetReference el = new ExternalDataSetReference(oidRef);
    	this.externalDataSetReference = el;
    	return el;
    }
    
    /**
     * Creates a new {@link ExternalDataSetReference} externalDataSetReference element, adds it to the current object and returns it.
     * @param externalDataset Referred {@link ExternalDataSet}.
     * @return The created {@link ExternalDataSetReference} object.
     */
    public ExternalDataSetReference createExternalDataSetReference(ExternalDataSet externalDataset){
    	ExternalDataSetReference el = new ExternalDataSetReference(externalDataset);
    	this.externalDataSetReference = el;
    	return el;
    }

    /**
     * Creates a new empty {@link InterventionsReference} interventionsReference element, adds it to the current object and returns it.
     * @return The created {@link InterventionsReference} object.
     */
    public InterventionsReference createInterventionsReference(){
    	InterventionsReference el = new InterventionsReference();
    	this.interventionsReference = el;
    	return el;
    }

    /**
     * Creates a new empty {@link ObservationsReference} observationsReference element, adds it to the current object and returns it.
     * @return The created {@link ObservationsReference} object.
     */
    public ObservationsReference createObservationsReference(){
    	ObservationsReference el = new ObservationsReference();
    	this.observationsReference = el;
    	return el;
    }

    /**
     * Creates a new empty {@link VariableAssignment} variableAssignment element, adds it to the current object and returns it.
     * @return The created {@link VariableAssignment} object.
     */
    public VariableAssignment createVariableAssignment(){
    	VariableAssignment el = new VariableAssignment();
    	getListOfVariableAssignment().add(el);
    	return el;
    }

    /**
     * Creates a new empty {@link SoftwareSettings} SoftwareSettings element, adds it to the current object and returns it.
     * @return The created {@link SoftwareSettings} object.
     */
    public SoftwareSettings createSoftwareSettings(){
    	SoftwareSettings el = new SoftwareSettings();
    	getListOfSoftwareSettings().add(el);
    	return el;
    }

    /**
     * Creates a new empty {@link ExternalFile} OutputFile element, adds it to the current object and returns it.
     * @return The created {@link ExternalFile} object.
     */
    public ExternalFile createOutputFile(){
    	ExternalFile el = new ExternalFile();
    	getListOfOutputFile().add(el);
    	return el;
    }


}
