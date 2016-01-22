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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                 Type defining the sampling timepoints.
 *             
 * 
 * <p>Java class for ObservationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObservationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ObservationRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" minOccurs="0"/>
 *         &lt;element name="NumberTimes" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType" minOccurs="0"/>
 *         &lt;element name="ObservationTimes" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}TimepointsType" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Continuous" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ContinuousObservationType"/>
 *           &lt;element name="Discrete" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}DiscreteObservationType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidDefnGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObservationType", propOrder = {
    "observationRef",
    "numberTimes",
    "observationTimes",
    "continuous",
    "discrete"
})
public class Observation
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement(name = "ObservationRef")
    protected OidRef observationRef;
    @XmlElement(name = "NumberTimes")
    protected StandardAssignable numberTimes;
    @XmlElement(name = "ObservationTimes")
    protected StandardAssignable observationTimes;
    @XmlElement(name = "Continuous")
    protected ContinuousObservation continuous;
    @XmlElement(name = "Discrete")
    protected DiscreteObservation discrete;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;

    /**
     * Gets the value of the observationRef property.
     * 
     * @return
     *     possible object is
     *     {@link OidRef }
     *     
     */
    public OidRef getObservationRef() {
        return observationRef;
    }

    /**
     * Sets the value of the observationRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OidRef }
     *     
     */
    public void setObservationRef(OidRef value) {
        this.observationRef = value;
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
     * Gets the value of the observationTimes property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getObservationTimes() {
        return observationTimes;
    }

    /**
     * Sets the value of the observationTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setObservationTimes(StandardAssignable value) {
        this.observationTimes = value;
    }

    /**
     * Gets the value of the continuous property.
     * 
     * @return
     *     possible object is
     *     {@link ContinuousObservation }
     *     
     */
    public ContinuousObservation getContinuous() {
        return continuous;
    }

    /**
     * Sets the value of the continuous property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinuousObservation }
     *     
     */
    public void setContinuous(ContinuousObservation value) {
        this.continuous = value;
    }

    /**
     * Gets the value of the discrete property.
     * 
     * @return
     *     possible object is
     *     {@link DiscreteObservation }
     *     
     */
    public DiscreteObservation getDiscrete() {
        return discrete;
    }

    /**
     * Sets the value of the discrete property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscreteObservation }
     *     
     */
    public void setDiscrete(DiscreteObservation value) {
        this.discrete = value;
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
    
    /**                                                              
     * Creates a new empty {@link OidRef} observationRef element, adds it to the current object and returns it.
     * @return The created {@link OidRef} object.                                                              
     */                                                                                                        
    public OidRef createObservationRef(){                                                                      
            OidRef el = new OidRef();                                                                          
            this.observationRef = el;                                                               
            return el;                                                                                         
    }                                                                                                          

    /**
     * Creates a new empty {@link OidRef} observationRef, adds it to the current object and returns it.
     * @param oidRef Reference to the intervention.
     * @return The created {@link OidRef} object.
     */
    public OidRef createObservationRef(String oidRef){
            OidRef el = new OidRef();
            el.setOidRef(oidRef);
            this.observationRef = el;
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
     * Creates a new empty {@link StandardAssignable} observationTimes element, adds it to the current object and returns it.
     * @return The created {@link StandardAssignable} object.
     */
    public StandardAssignable createObservationTimes(){
    	StandardAssignable el = new StandardAssignable();
            this.observationTimes = el;
            return el;
    }

    /**
     * Creates a new empty {@link ContinuousObservation} continuous element, adds it to the current object and returns it.
     * @return The created {@link ContinuousObservation} object.
     */
    public ContinuousObservation createContinuous(){
            ContinuousObservation el = new ContinuousObservation();
            this.continuous = el;
            return el;
    }

    /**
     * Creates a new empty {@link DiscreteObservation} discrete element, adds it to the current object and returns it.
     * @return The created {@link DiscreteObservation} object.
     */
    public DiscreteObservation createDiscrete(){
            DiscreteObservation el = new DiscreteObservation();
            this.discrete = el;
            return el;
    }

    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(observationRef)
    			.addIfNotNull(numberTimes)
    			.addIfNotNull(observationTimes)
    			.addIfNotNull(continuous)
    			.addIfNotNull(discrete);
    }

}
