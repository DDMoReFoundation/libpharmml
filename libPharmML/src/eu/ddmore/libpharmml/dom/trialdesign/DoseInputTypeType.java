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
// Generated on: 2014.03.24 at 10:08:07 AM GMT 
//


package eu.ddmore.libpharmml.dom.trialdesign;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoseInputTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoseInputTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="dose"/>
 *     &lt;enumeration value="target"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @deprecated Since PharmML 0.3. Use {@link DoseInputTarget} instead.
 */
@XmlType(name = "DoseInputTypeType")
@XmlEnum
@Deprecated
public enum DoseInputTypeType {


    /**
     * 
     *                         Dose is assigned to a dosing variable.
     *                     
     * 
     */
    @XmlEnumValue("dose")
    DOSE("dose"),

    /**
     * 
     *                         Dose is an input to a system of ODEs. 
     *                     
     * 
     */
    @XmlEnumValue("target")
    TARGET("target");
    private final String value;

    DoseInputTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoseInputTypeType fromValue(String v) {
        for (DoseInputTypeType c: DoseInputTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
