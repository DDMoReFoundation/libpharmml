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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransitionMatrixAttrType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransitionMatrixAttrType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="leftStochastic"/>
 *     &lt;enumeration value="rightStochastic"/>
 *     &lt;enumeration value="doublyStochastic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.8
 */
@XmlType(name = "TransitionMatrixAttrType")
@XmlEnum
public enum TransitionMatrixAttrType {

    @XmlEnumValue("leftStochastic")
    LEFT_STOCHASTIC("leftStochastic"),
    @XmlEnumValue("rightStochastic")
    RIGHT_STOCHASTIC("rightStochastic"),
    @XmlEnumValue("doublyStochastic")
    DOUBLY_STOCHASTIC("doublyStochastic");
    private final String value;

    TransitionMatrixAttrType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
    
    @Override
    public String toString() {
    	return value;
    }

    public static TransitionMatrixAttrType fromValue(String v) {
        for (TransitionMatrixAttrType c: TransitionMatrixAttrType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
