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
import eu.ddmore.libpharmml.dom.commontypes.StandardAssignable;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * 
 *                     Type defining a treatment sequence of the study.  
 *                 
 * 
 * <p>Java class for InterventionSequenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterventionSequenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="InterventionList" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}InterventionListType"/>
 *         &lt;element name="Start" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}TimepointsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterventionSequenceType", propOrder = {
    "interventionList",
    "start"
})
public class InterventionSequence
    extends PharmMLRootType
{

    @XmlElement(name = "InterventionList", required = true)
    protected InterventionList interventionList;
    @XmlElement(name = "Start")
    protected StandardAssignable start;

    /**
     * Gets the value of the interventionList property.
     * 
     * @return
     *     possible object is
     *     {@link InterventionList }
     *     
     */
    public InterventionList getInterventionList() {
        return interventionList;
    }

    /**
     * Sets the value of the interventionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterventionList }
     *     
     */
    public void setInterventionList(InterventionList value) {
        this.interventionList = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link StandardAssignable }
     *     
     */
    public StandardAssignable getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardAssignable }
     *     
     */
    public void setStart(StandardAssignable value) {
        this.start = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(interventionList)
    			.addIfNotNull(start);
    }

}
