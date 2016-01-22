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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.uncertml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NegativeBinomialDistributionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NegativeBinomialDistributionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.uncertml.org/3.0}AbstractDiscreteUnivariateDistributionType">
 *       &lt;sequence>
 *         &lt;element name="numberOfFailures" type="{http://www.uncertml.org/3.0}NaturalNumberValueType"/>
 *         &lt;element name="probability" type="{http://www.uncertml.org/3.0}ProbabilityValueType"/>
 *         &lt;element name="truncationLowerInclusiveBound" type="{http://www.uncertml.org/3.0}NaturalNumberValueType" minOccurs="0"/>
 *         &lt;element name="truncationUpperInclusiveBound" type="{http://www.uncertml.org/3.0}NaturalNumberValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NegativeBinomialDistributionType", propOrder = {
    "numberOfFailures",
    "probability",
    "truncationLowerInclusiveBound",
    "truncationUpperInclusiveBound"
})
@XmlSeeAlso({
    NegativeBinomialDistribution.class
})
public class NegativeBinomialDistributionType
    extends AbstractDiscreteUnivariateDistributionType
{
	@XmlTransient
	public static java.lang.String DEFINITION_ELEMENT_URI = "negative-binomial";

	@Override
	protected java.lang.String getDefinitionElementURI() {
		return DEFINITION_ELEMENT_URI;
	}

    @XmlElement(required = true)
    protected NaturalNumberValueType numberOfFailures;
    @XmlElement(required = true)
    protected ProbabilityValueType probability;
    protected NaturalNumberValueType truncationLowerInclusiveBound;
    protected NaturalNumberValueType truncationUpperInclusiveBound;

    /**
     * Gets the value of the numberOfFailures property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalNumberValueType }
     *     
     */
    public NaturalNumberValueType getNumberOfFailures() {
        return numberOfFailures;
    }

    /**
     * Sets the value of the numberOfFailures property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalNumberValueType }
     *     
     */
    public void setNumberOfFailures(NaturalNumberValueType value) {
        this.numberOfFailures = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link ProbabilityValueType }
     *     
     */
    public ProbabilityValueType getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProbabilityValueType }
     *     
     */
    public void setProbability(ProbabilityValueType value) {
        this.probability = value;
    }

    /**
     * Gets the value of the truncationLowerInclusiveBound property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalNumberValueType }
     *     
     */
    public NaturalNumberValueType getTruncationLowerInclusiveBound() {
        return truncationLowerInclusiveBound;
    }

    /**
     * Sets the value of the truncationLowerInclusiveBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalNumberValueType }
     *     
     */
    public void setTruncationLowerInclusiveBound(NaturalNumberValueType value) {
        this.truncationLowerInclusiveBound = value;
    }

    /**
     * Gets the value of the truncationUpperInclusiveBound property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalNumberValueType }
     *     
     */
    public NaturalNumberValueType getTruncationUpperInclusiveBound() {
        return truncationUpperInclusiveBound;
    }

    /**
     * Sets the value of the truncationUpperInclusiveBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalNumberValueType }
     *     
     */
    public void setTruncationUpperInclusiveBound(NaturalNumberValueType value) {
        this.truncationUpperInclusiveBound = value;
    }

}
