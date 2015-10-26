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
 * <p>Java class for builtInFIMfctType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="builtInFIMfctType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="det"/>
 *     &lt;enumeration value="logDet"/>
 *     &lt;enumeration value="trInv"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlType(name = "builtInFIMfctType")
@XmlEnum
public enum BuiltInFIMfct {

    @XmlEnumValue("det")
    DET("det"),
    @XmlEnumValue("logDet")
    LOG_DET("logDet"),
    @XmlEnumValue("trInv")
    TR_INV("trInv");
    private final String value;

    BuiltInFIMfct(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BuiltInFIMfct fromValue(String v) {
        for (BuiltInFIMfct c: BuiltInFIMfct.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
