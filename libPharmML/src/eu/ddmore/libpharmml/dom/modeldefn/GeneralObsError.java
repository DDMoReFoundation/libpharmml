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

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.dom.commontypes.LevelReference;
import eu.ddmore.libpharmml.dom.commontypes.Rhs;
import eu.ddmore.libpharmml.impl.XMLFilter;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * The general and distribution tyeps of observation errors.
 * 
 * <p>Type 2. General model<br>
 * No VariabilityReference required, LHS optional<br>
 * h(y) = H(f, xi, eps)               
 *                 
 * <p>Type 3. Distribution type model (eps-free notation)<br>     
 * VariabilityReference required, LHS optional<br>
 * u(y) ~ distribution(parameter1, parameter2, ...) e.g. log(y) ~ N(log(f), sigma)
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralObsError">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/ModelDefinition}ObservationErrorType">
 *       &lt;sequence>
 *         &lt;element name="Transformation" type="{http://www.pharmml.org/2013/03/ModelDefinition}LhsTransformationType" minOccurs="0"/>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}Assign"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Assign"/>
 *           &lt;sequence>
 *             &lt;element name="LHSTransformation" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}LHSTransformationType" minOccurs="0"/>
 *             &lt;element name="Distribution" type="{http://www.pharmml.org/pharmml/0.7/ModelDefinition}DistributionType"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralObsError", propOrder = {
    "transformation",
    "listOfVariabilityReference",
    "assign",
    "lhsTransformation",
    "distribution"
})
public class GeneralObsError
    extends ObservationError
{

	// Before PharmML 0.7
	@Deprecated
    @XmlElement(name = "Transformation")
    protected LhsTransformation transformation;
    
    @XmlElement(name = "VariabilityReference", namespace = XMLFilter.NS_DEFAULT_CT)
    protected List<LevelReference> listOfVariabilityReference;
    @XmlElement(name = "Assign", namespace = XMLFilter.NS_DEFAULT_CT)
    protected Rhs assign;
    @XmlElement(name = "LHSTransformation")
    protected LHSTransformationType lhsTransformation;
    @XmlElement(name = "Distribution")
    protected Distribution distribution;

    /**
     * Gets the value of the transformation property.
     * 
     * @return
     *     possible object is
     *     {@link LhsTransformation }
     * 
     * @deprecated Since PharmML 0.7, the transformation is defined via {@link #getLHSTransformation()}.
     */
    @Deprecated
    public LhsTransformation getTransformation() {
        return transformation;
    }

    /**
     * Sets the value of the transformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LhsTransformation }
     *     
     * @deprecated Since PharmML 0.7, the transformation is set via {@link #setLHSTransformation(LHSTransformationType)}.
     */
    @Deprecated
    public void setTransformation(LhsTransformation value) {
        this.transformation = value;
    }
    
    /**
     * The level of random variability and its connection
     * to variance/stdev as defined when using the distribution.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variabilityReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfVariabilityReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LevelReference }
     * 
     * 
     */
    public List<LevelReference> getListOfVariabilityReference() {
        if (listOfVariabilityReference == null) {
        	listOfVariabilityReference = new ArrayList<LevelReference>();
        }
        return this.listOfVariabilityReference;
    }

    /**
     * This assignment defines the RHS of the residual error.
     * 
     * @return
     *     possible object is
     *     {@link Rhs }
     *     
     */
    public Rhs getAssign() {
        return assign;
    }

    /**
     * This assignment defines the RHS of the residual error.
     * 
     * @param value
     *     allowed object is
     *     {@link Rhs }
     *     
     */
    public void setAssign(Rhs value) {
        this.assign = value;
    }
    
    /**
     * Defines a left-hand-side transformation.
     * 
     * @return
     *     possible object is
     *     {@link LHSTransformationType }
     *     
     * @since PharmML 0.7
     */
    public LHSTransformationType getLHSTransformation() {
        return lhsTransformation;
    }

    /**
     * Sets a left-hand-side transformation.
     * 
     * @param value
     *     allowed object is
     *     {@link LHSTransformationType }
     *    
     * @since PharmML 0.7
     */
    public void setLHSTransformation(LHSTransformationType value) {
        this.lhsTransformation = value;
    }

    /**
     * Gets the value of the distribution property.
     * 
     * @return
     *     possible object is
     *     {@link Distribution }
     *    
     * @since PharmML 0.7
     */
    public Distribution getDistribution() {
        return distribution;
    }

    /**
     * Sets the value of the distribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Distribution }
     *     
     * @since PharmML 0.7
     */
    public void setDistribution(Distribution value) {
        this.distribution = value;
    }
    
    @Override
	protected List<TreeNode> listChildren() {
		return new ChainedList<TreeNode>()
				.addIfNotNull(super.listChildren())
				.addIfNotNull(listOfVariabilityReference)
				.addIfNotNull(assign)
				.addIfNotNull(lhsTransformation)
				.addIfNotNull(distribution);
	}

}
