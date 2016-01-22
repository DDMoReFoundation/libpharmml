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
package eu.ddmore.libpharmml.dom.modellingsteps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComputeAlgoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComputeAlgoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="FO"/>
 *     &lt;enumeration value="FOCE"/>
 *     &lt;enumeration value="FOCEI"/>
 *     &lt;enumeration value="FOI"/>
 *     &lt;enumeration value="LAPLACE"/>
 *     &lt;enumeration value="GQ"/>
 *     &lt;enumeration value="AGQ"/>
 *     &lt;enumeration value="MCMC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlType(name = "ComputeAlgoType")
@XmlEnum
public enum ComputeAlgo {

    FO,
    FOCE,
    FOCEI,
    FOI,
    LAPLACE,
    GQ,
    AGQ,
    MCMC;

    public String value() {
        return name();
    }

    public static ComputeAlgo fromValue(String v) {
        return valueOf(v);
    }

}
