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

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.VariableAssignment;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.impl.XMLFilter;
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
    
    @XmlElement(name = "VariableAssignment", namespace = XMLFilter.NS_DEFAULT_CT)
    protected List<VariableAssignment> variableAssignment;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;

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
     *    getVariableAssignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableAssignment }
     * 
     * 
     */
    public List<VariableAssignment> getVariableAssignment() {
        if (variableAssignment == null) {
            variableAssignment = new ArrayList<VariableAssignment>();
        }
        return this.variableAssignment;
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
    			.addIfNotNull(monoliXdataSetReference)
    			.addIfNotNull(nonmeMdataSetReference)
    			.addIfNotNull(externalDataSetReference)
    			.addIfNotNull(interventionsReference)
    			.addIfNotNull(observationsReference)
    			.addIfNotNull(variableAssignment);
    }

}
