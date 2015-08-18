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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                     Type defining a sampling sequence of the study.  
 *                 
 * 
 * <p>Java class for ObservationSequenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObservationSequenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="ObservationList" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}ObservationListType"/>
 *         &lt;element name="Start" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}TimepointsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObservationSequenceType", propOrder = {
    "observationList",
    "start"
})
public class ObservationSequence
    extends PharmMLRootType
{

    @XmlElement(name = "ObservationList", required = true)
    protected ObservationList observationList;
    @XmlElement(name = "Start")
    protected Timepoints start;

    /**
     * Gets the value of the observationList property.
     * 
     * @return
     *     possible object is
     *     {@link ObservationList }
     *     
     */
    public ObservationList getObservationList() {
        return observationList;
    }

    /**
     * Sets the value of the observationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObservationList }
     *     
     */
    public void setObservationList(ObservationList value) {
        this.observationList = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Timepoints }
     *     
     */
    public Timepoints getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timepoints }
     *     
     */
    public void setStart(Timepoints value) {
        this.start = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(observationList)
    			.addIfNotNull(start);
    }
    
    /**
     * Creates a new empty {@link ObservationList} observationList element, adds it to the current object and returns it.
     * @return The created {@link ObservationList} object.
     */
    public ObservationList createObservationList(){
            ObservationList el = new ObservationList();
            this.observationList = el;
            return el;
    }

    /**
     * Creates a new empty {@link Timepoints} start element, adds it to the current object and returns it.
     * @return The created {@link Timepoints} object.
     */
    public Timepoints createStart(){
            Timepoints el = new Timepoints();
            this.start = el;
            return el;
    }

}
