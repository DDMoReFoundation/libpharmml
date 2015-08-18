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
 *                     Type defining an occasion sequence of the study.  
 *                 
 * 
 * <p>Java class for OccasionSequenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OccasionSequenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="OccasionList" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}OccasionListType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OccasionSequenceType", propOrder = {
    "occasionList"
})
public class OccasionSequence
    extends PharmMLRootType
{

    @XmlElement(name = "OccasionList", required = true)
    protected OccasionList occasionList;

    /**
     * Gets the value of the occasionList property.
     * 
     * @return
     *     possible object is
     *     {@link OccasionList }
     *     
     */
    public OccasionList getOccasionList() {
        return occasionList;
    }

    /**
     * Sets the value of the occasionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link OccasionList }
     *     
     */
    public void setOccasionList(OccasionList value) {
        this.occasionList = value;
    }

    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>()
    			.addIfNotNull(occasionList);
    }
    
    /**
     * Creates a new empty {@link OccasionList} occasionList element, adds it to the current object and returns it.
     * @return The created {@link OccasionList} object.
     */
    public OccasionList createOccasionList(){
            OccasionList el = new OccasionList();
            this.occasionList = el;
            return el;
    }
    
}
