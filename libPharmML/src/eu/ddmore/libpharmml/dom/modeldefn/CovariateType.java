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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CovariateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CovariateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="timeDependent"/>
 *     &lt;enumeration value="occasionDependent"/>
 *     &lt;enumeration value="constant"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.8
 */
@XmlType(name = "CovariateType")
@XmlEnum
public enum CovariateType {


    /**
     * Time-dependent covariate (regressor).
     * 
     */
    @XmlEnumValue("timeDependent")
    TIME_DEPENDENT("timeDependent"),

    /**
     * Occasion-dependent covariate.
     * 
     */
    @XmlEnumValue("occasionDependent")
    OCCASION_DEPENDENT("occasionDependent"),

    /**
     * Constant covariate..
     * 
     */
    @XmlEnumValue("constant")
    CONSTANT("constant");
    private final String value;

    CovariateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CovariateType fromValue(String v) {
        for (CovariateType c: CovariateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
