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

import eu.ddmore.libpharmml.visitor.Visitor;


/**
 * <p>Java class for InterquartileRangeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterquartileRangeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.uncertml.org/3.0}AbstractSummaryStatisticType">
 *       &lt;sequence>
 *         &lt;element name="lower" type="{http://www.uncertml.org/3.0}ContinuousValueType"/>
 *         &lt;element name="upper" type="{http://www.uncertml.org/3.0}ContinuousValueType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterquartileRangeType", propOrder = {
    "lower",
    "upper"
})
@XmlSeeAlso({
    InterquartileRange.class
})
public class InterquartileRangeType
    extends AbstractSummaryStatisticType
{
	@XmlTransient
	public static java.lang.String DEFINITION_ELEMENT_URI = "interquartile-range";

	@Override
	protected java.lang.String getDefinitionElementURI() {
		return DEFINITION_ELEMENT_URI;
	}

    @XmlElement(required = true)
    protected ContinuousValueType lower;
    @XmlElement(required = true)
    protected ContinuousValueType upper;

    /**
     * Gets the value of the lower property.
     * 
     * @return
     *     possible object is
     *     {@link ContinuousValueType }
     *     
     */
    public ContinuousValueType getLower() {
        return lower;
    }

    /**
     * Sets the value of the lower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinuousValueType }
     *     
     */
    public void setLower(ContinuousValueType value) {
        this.lower = value;
    }

    /**
     * Gets the value of the upper property.
     * 
     * @return
     *     possible object is
     *     {@link ContinuousValueType }
     *     
     */
    public ContinuousValueType getUpper() {
        return upper;
    }

    /**
     * Sets the value of the upper property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContinuousValueType }
     *     
     */
    public void setUpper(ContinuousValueType value) {
        this.upper = value;
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
