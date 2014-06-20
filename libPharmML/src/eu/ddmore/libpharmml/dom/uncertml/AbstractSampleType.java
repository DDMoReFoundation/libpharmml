/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.uncertml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AbstractSampleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractSampleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.uncertml.org/3.0}AbstractUncertaintyType">
 *       &lt;sequence>
 *         &lt;element name="samplingMethodDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSampleType", propOrder = {
    "samplingMethodDescription"
})
@XmlSeeAlso({
    SystematicSampleType.class,
    UnknownSampleType.class,
    RandomSampleType.class
})
public abstract class AbstractSampleType
    extends AbstractUncertaintyType
{

    protected java.lang.String samplingMethodDescription;
    
    @XmlTransient
    public static java.lang.String DEFINITION_CATEGORY_URL = "samples/";
    
    @Override
    protected java.lang.String getDefinitionCategoryURI() {
    	return DEFINITION_CATEGORY_URL;
    };

    /**
     * Gets the value of the samplingMethodDescription property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSamplingMethodDescription() {
        return samplingMethodDescription;
    }

    /**
     * Sets the value of the samplingMethodDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSamplingMethodDescription(java.lang.String value) {
        this.samplingMethodDescription = value;
    }

}
