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
package eu.ddmore.libpharmml.dom.trialdesign;

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

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.dom.tags.ReferenceContainer;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.validation.SymbolResolver;


/**
 * 
 *                 Type defining an arm of the study.  
 *             
 * 
 * <p>Java class for ArmDefnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArmDefnType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ArmRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" minOccurs="0"/>
 *         &lt;element name="ArmSize" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="NumberSamples" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="NumberTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="SameTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="InterventionSequence" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}InterventionSequenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ObservationSequence" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ObservationSequenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OccasionSequence" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}OccasionSequenceType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ArmDefnType", propOrder = {
    "armRef",
    "armSize",
    "numberSamples",
    "numberTimes",
    "sameTimes",
    "listOfInterventionSequence",
    "listOfObservationSequence",
    "listOfOccasionSequence"
})
public class ArmDefinition
    extends PharmMLRootType implements PharmMLObject, ReferenceContainer
{
	
	@XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;

	// PharmML 0.7
    @XmlElement(name = "ArmRef")
    protected OidRef armRef;
    @XmlElement(name = "ArmSize")
    protected StandardAssignable armSize;
    @XmlElement(name = "NumberSamples")
    protected StandardAssignable numberSamples;
    @XmlElement(name = "NumberTimes")
    protected StandardAssignable numberTimes;
    @XmlElement(name = "SameTimes")
    protected StandardAssignable sameTimes;
    @XmlElement(name = "InterventionSequence")
    protected List<InterventionSequence> listOfInterventionSequence;
    @XmlElement(name = "ObservationSequence")
    protected List<ObservationSequence> listOfObservationSequence;
    @XmlElement(name = "OccasionSequence")
    protected List<OccasionSequence> listOfOccasionSequence;


    /**
     * Gets the value of the armRef property.
     * 
     * @return
     *     possible object is
     *     {@link OidRef }
     *   
     * @since PharmML 0.7
     */
    public OidRef getArmRef() {
        return armRef;
    }

    /**
     * Sets the value of the armRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OidRef }
     * 
     * @since PharmML 0.7
     */
    public void setArmRef(OidRef value) {
        this.armRef = value;
    }

    /**
     * Gets the value of the armSize property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     * 
     * @since PharmML 0.7
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
     * @since PharmML 0.7    
     */
    public void setArmSize(StandardAssignable value) {
        this.armSize = value;
    }

    /**
     * Gets the value of the numberSamples property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     * 
     * @since PharmML 0.7    
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
     * @since PharmML 0.7    
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
     * @since PharmML 0.7    
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
     * @since PharmML 0.7    
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
     * @since PharmML 0.7    
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
     * @since PharmML 0.7    
     */
    public void setSameTimes(StandardAssignable value) {
        this.sameTimes = value;
    }

    /**
     * Gets the value of the interventionSequence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interventionSequence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfInterventionSequence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterventionSequence }
     * 
     * 
     * @since PharmML 0.7
     */
    public List<InterventionSequence> getListOfInterventionSequence() {
        if (listOfInterventionSequence == null) {
        	listOfInterventionSequence = new ArrayList<InterventionSequence>();
        }
        return this.listOfInterventionSequence;
    }

    /**
     * Gets the value of the observationSequence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the observationSequence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfObservationSequence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObservationSequence }
     * 
     * 
     * @since PharmML 0.7
     */
    public List<ObservationSequence> getListOfObservationSequence() {
        if (listOfObservationSequence == null) {
        	listOfObservationSequence = new ArrayList<ObservationSequence>();
        }
        return this.listOfObservationSequence;
    }

    /**
     * Gets the value of the occasionSequence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the occasionSequence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfOccasionSequence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OccasionSequence }
     * 
     * 
     * @since PharmML 0.7
     */
    public List<OccasionSequence> getListOfOccasionSequence() {
        if (listOfOccasionSequence == null) {
        	listOfOccasionSequence = new ArrayList<OccasionSequence>();
        }
        return this.listOfOccasionSequence;
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
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(armRef)
				.addIfNotNull(armSize)
				.addIfNotNull(numberSamples)
				.addIfNotNull(numberTimes)
				.addIfNotNull(sameTimes)
				.addIfNotNull(listOfInterventionSequence)
				.addIfNotNull(listOfObservationSequence)
				.addIfNotNull(listOfOccasionSequence);
	}

}
