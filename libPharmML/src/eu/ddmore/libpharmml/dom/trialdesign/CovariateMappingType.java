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
// Generated on: 2014.03.24 at 10:08:07 AM GMT 
//


package eu.ddmore.libpharmml.dom.trialdesign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import eu.ddmore.libpharmml.dom.commontypes.SymbolRef;


/**
 * 
 *                 A type defining the mapping of a covariate to the values sepcified in a column of the dataset.
 *             
 * 
 * <p>Java class for CovariateMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CovariateMappingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/TrialDesign}PopulationMappingType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.pharmml.org/2013/03/CommonTypes}SymbRef"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @deprecated Since PharmML 0.3.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovariateMappingType", propOrder = {
    "symbRef"
})
@Deprecated
public class CovariateMappingType
    extends PopulationMappingType
{

    @XmlElement(name = "SymbRef", namespace = "http://www.pharmml.org/2013/03/CommonTypes", required = true)
    protected SymbolRef symbRef;

    /**
     * Gets the value of the symbRef property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolRef }
     *     
     */
    public SymbolRef getSymbRef() {
        return symbRef;
    }

    /**
     * Sets the value of the symbRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolRef }
     *     
     */
    public void setSymbRef(SymbolRef value) {
        this.symbRef = value;
    }

}
