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
package eu.ddmore.libpharmml.dom.modellingsteps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApproxAlgoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ApproxAlgoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="full"/>
 *     &lt;enumeration value="fullParamaterised"/>
 *     &lt;enumeration value="block"/>
 *     &lt;enumeration value="reduced"/>
 *     &lt;enumeration value="reducedWithDerivative"/>
 *     &lt;enumeration value="reducedParamaterised"/>
 *     &lt;enumeration value="locModels"/>
 *     &lt;enumeration value="switchModels"/>
 *     &lt;enumeration value="weightedModel"/>
 *     &lt;enumeration value="MCMC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlType(name = "ApproxAlgoType")
@XmlEnum
public enum ApproxAlgo {

    @XmlEnumValue("full")
    FULL("full"),
    @XmlEnumValue("fullParamaterised")
    FULL_PARAMATERISED("fullParamaterised"),
    @XmlEnumValue("block")
    BLOCK("block"),
    @XmlEnumValue("reduced")
    REDUCED("reduced"),
    @XmlEnumValue("reducedWithDerivative")
    REDUCED_WITH_DERIVATIVE("reducedWithDerivative"),
    @XmlEnumValue("reducedParamaterised")
    REDUCED_PARAMATERISED("reducedParamaterised"),
    @XmlEnumValue("locModels")
    LOC_MODELS("locModels"),
    @XmlEnumValue("switchModels")
    SWITCH_MODELS("switchModels"),
    @XmlEnumValue("weightedModel")
    WEIGHTED_MODEL("weightedModel"),
    MCMC("MCMC");
    private final String value;

    ApproxAlgo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ApproxAlgo fromValue(String v) {
        for (ApproxAlgo c: ApproxAlgo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
