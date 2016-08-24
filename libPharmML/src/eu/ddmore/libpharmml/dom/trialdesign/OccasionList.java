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

import eu.ddmore.libpharmml.dom.commontypes.LevelReference;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.tags.PharmMLObject;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * 
 *                     Type defining an occasion list of the study.  
 *                 
 * 
 * <p>Java class for OccasionListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OccasionListType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}VariabilityReference" minOccurs="0"/>
 *         &lt;element name="Occasion" type="{http://www.pharmml.org/pharmml/0.7/TrialDesign}OccasionType" maxOccurs="unbounded"/>
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
@XmlType(name = "OccasionListType", propOrder = {
    "variabilityReference",
    "listOfOccasion"
})
public class OccasionList
    extends PharmMLRootType implements PharmMLObject
{

    @XmlElement(name = "VariabilityReference", namespace = NS_DEFAULT_CT)
    protected LevelReference variabilityReference;
    @XmlElement(name = "Occasion", required = true)
    protected List<Occasion> listOfOccasion;
    @XmlAttribute(name = "oid", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String oid;

    /**
     * Gets the value of the variabilityReference property.
     * 
     * @return
     *     possible object is
     *     {@link LevelReference }
     *     
     */
    public LevelReference getVariabilityReference() {
        return variabilityReference;
    }

    /**
     * Sets the value of the variabilityReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelReference }
     *     
     */
    public void setVariabilityReference(LevelReference value) {
        this.variabilityReference = value;
    }

    /**
     * Gets the value of the occasion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the occasion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfOccasion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Occasion }
     * 
     * 
     */
    public List<Occasion> getListOfOccasion() {
        if (listOfOccasion == null) {
        	listOfOccasion = new ArrayList<Occasion>();
        }
        return this.listOfOccasion;
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
    	return new ChainedList<TreeNode>()
    			.addIfNotNull(variabilityReference)
    			.addIfNotNull(listOfOccasion);
    }
    
    /**
     * Creates a new empty {@link LevelReference} variabilityReference element, adds it to the current object and returns it.
     * @return The created {@link LevelReference} object.
     */
    public LevelReference createVariabilityReference(){
            LevelReference el = new LevelReference();
            this.variabilityReference = el;
            return el;
    }

    /**
     * Creates a new empty {@link Occasion} Occasion element, adds it to the current object and returns it.
     * @return The created {@link Occasion} object.
     */
    public Occasion createOccasion(){
            Occasion el = new Occasion();
            getListOfOccasion().add(el);
            return el;
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
