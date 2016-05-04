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

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.commontypes.AnnotationType;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.dom.tags.ReferenceContainer;
import eu.ddmore.libpharmml.util.ChainedList;
import eu.ddmore.libpharmml.validation.SymbolResolver;


/**
 * Type defines a category in a categorical covariate.
 * 
 * <p>Java class for CategoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Name" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Description" minOccurs="0"/>
 *         &lt;element name="Probability" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}ScalarRhs" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="InterventionRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" minOccurs="0"/>
 *           &lt;element name="InterventionSequence" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}InterventionSequenceType" minOccurs="0"/>
 *           &lt;element name="OccasionRef" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}OidRefType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="catId" use="required" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}CatIdType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryType", propOrder = {
	"name",
    "description",
    "probability",
    "interventionRef",
    "interventionSequence",
    "occasionRef"
})
public class Category extends PharmMLElement implements ReferenceContainer {

    @XmlElement(name = "Name", namespace = NS_DEFAULT_CT)
    protected Name name;
    @XmlElement(name = "Description", namespace = NS_DEFAULT_CT)
    protected AnnotationType description;
    @XmlElement(name = "Probability")
    protected Rhs probability;
    
    // PharmML 0.7 -----------------------------
    @XmlElement(name = "InterventionRef")
    protected OidRef interventionRef;
    @XmlElement(name = "InterventionSequence")
    protected InterventionSequence interventionSequence;
    @XmlElement(name = "OccasionRef")
    protected OidRef occasionRef;
    // -----------------------------------------
    
    @XmlAttribute(name = "catId", required = true)
    protected String catId;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationType }
     *     
     */
    public AnnotationType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationType }
     *     
     */
    public void setDescription(AnnotationType value) {
        this.description = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setProbability(Rhs value) {
        this.probability = value;
    }
    
    /**
     * Refers to one(!) intervention which will be treated as covariate. 
     * 
     * @return
     *     possible object is
     *     {@link OidRef }
     *     
     * @since PharmML 0.7
     */
    public OidRef getInterventionRef() {
        return interventionRef;
    }

    /**
     * Refers to one(!) intervention which will be treated as covariate. 
     * 
     * @param value
     *     allowed object is
     *     {@link OidRef }
     *     
     * @since PharmML 0.7
     */
    public void setInterventionRef(OidRef value) {
        this.interventionRef = value;
    }

    /**
     * Gets the value of the interventionSequence property.
     * 
     * @return
     *     possible object is
     *     {@link InterventionSequence }
     *     
     * @since PharmML 0.7
     */
    public InterventionSequence getInterventionSequence() {
        return interventionSequence;
    }

    /**
     * Sets the value of the interventionSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterventionSequence }
     *     
     * @since PharmML 0.7
     */
    public void setInterventionSequence(InterventionSequence value) {
        this.interventionSequence = value;
    }

    /**
     * Refers to the occasion which will be treated as covariate.
     * 
     * @return
     *     possible object is
     *     {@link OidRef }
     *     
     * @since PharmML 0.7
     */
    public OidRef getOccasionRef() {
        return occasionRef;
    }

    /**
     * Refers to the occasion which will be treated as covariate.
     * 
     * @param value
     *     allowed object is
     *     {@link OidRef }
     *     
     * @since PharmML 0.7
     */
    public void setOccasionRef(OidRef value) {
        this.occasionRef = value;
    }

    /**
     * The identifier of the category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatId() {
        return catId;
    }

    /**
     * The identifier of the category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatId(String value) {
        this.catId = value;
    }

	@Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(name)
				.addIfNotNull(description)
				.addIfNotNull(probability)
				.addIfNotNull(interventionRef)
				.addIfNotNull(interventionSequence)
				.addIfNotNull(occasionRef);
	}

	@Override
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PharmMLElement clone() {
		return clone(Category.class, this);
	}

}
