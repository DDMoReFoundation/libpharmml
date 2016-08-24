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
package eu.ddmore.libpharmml.dom.probonto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistroType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistroType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;enumeration value="univariate"/>
 *     &lt;enumeration value="multivariate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DistroType")
@XmlEnum
public enum DistributionType {

    @XmlEnumValue("univariate")
    UNIVARIATE("univariate"),
    @XmlEnumValue("multivariate")
    MULTIVARIATE("multivariate");
    private final String value;

    DistributionType(String v) {
        value = v;
    }

    /**
     * Returns the {@link String} representation of this enum as written in PharmML.
     * @return The {@link String} representation of this enum as written in PharmML.
     */
    public String value() {
        return value;
    }

    public static DistributionType fromValue(String v) {
        for (DistributionType c: DistributionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
    
    @Override
    public String toString() {
    	return value;
    }

}
