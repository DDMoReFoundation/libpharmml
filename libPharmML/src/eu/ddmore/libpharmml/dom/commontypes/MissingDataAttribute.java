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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MissingDataAttributeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MissingDataAttributeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="NaN"/>
 *     &lt;enumeration value="minusInf"/>
 *     &lt;enumeration value="plusInf"/>
 *     &lt;enumeration value="ALQ"/>
 *     &lt;enumeration value="BLQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlType(name = "MissingDataAttributeType")
@XmlEnum
public enum MissingDataAttribute {

    NA("NA"),
    @XmlEnumValue("NaN")
    NA_N("NaN"),
    @XmlEnumValue("minusInf")
    MINUS_INF("minusInf"),
    @XmlEnumValue("plusInf")
    PLUS_INF("plusInf"),
    ALQ("ALQ"),
    BLQ("BLQ");
    private final String value;

    MissingDataAttribute(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MissingDataAttribute fromValue(String v) {
        for (MissingDataAttribute c: MissingDataAttribute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
