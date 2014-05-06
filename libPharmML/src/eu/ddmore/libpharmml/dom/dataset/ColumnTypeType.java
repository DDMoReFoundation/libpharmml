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


package eu.ddmore.libpharmml.dom.dataset;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ColumnTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ColumnTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;enumeration value="addl"/>
 *     &lt;enumeration value="adm"/>
 *     &lt;enumeration value="arm"/>
 *     &lt;enumeration value="censoring"/>
 *     &lt;enumeration value="covariate"/>
 *     &lt;enumeration value="demographic"/>
 *     &lt;enumeration value="dose"/>
 *     &lt;enumeration value="duration"/>
 *     &lt;enumeration value="dv"/>
 *     &lt;enumeration value="dvid"/>
 *     &lt;enumeration value="epoch"/>
 *     &lt;enumeration value="evid"/>
 *     &lt;enumeration value="id"/>
 *     &lt;enumeration value="idv"/>
 *     &lt;enumeration value="ii"/>
 *     &lt;enumeration value="limit"/>
 *     &lt;enumeration value="mdv"/>
 *     &lt;enumeration value="occasion"/>
 *     &lt;enumeration value="rate"/>
 *     &lt;enumeration value="reg"/>
 *     &lt;enumeration value="replicate"/>
 *     &lt;enumeration value="ss"/>
 *     &lt;enumeration value="ssEndTime"/>
 *     &lt;enumeration value="ssPeriod"/>
 *     &lt;enumeration value="time"/>
 *     &lt;enumeration value="undefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ColumnTypeType")
@XmlEnum
public enum ColumnTypeType {

    @XmlEnumValue("addl")
    ADDL("addl"),
    @XmlEnumValue("adm")
    ADM("adm"),
    @XmlEnumValue("arm")
    ARM("arm"),
    @XmlEnumValue("censoring")
    CENSORING("censoring"),
    @XmlEnumValue("covariate")
    COVARIATE("covariate"),
    @XmlEnumValue("demographic")
    DEMOGRAPHIC("demographic"),
    @XmlEnumValue("dose")
    DOSE("dose"),
    @XmlEnumValue("duration")
    DURATION("duration"),
    @XmlEnumValue("dv")
    DV("dv"),
    @XmlEnumValue("dvid")
    DVID("dvid"),
    @XmlEnumValue("epoch")
    EPOCH("epoch"),
    @XmlEnumValue("evid")
    EVID("evid"),
    @XmlEnumValue("id")
    ID("id"),
    @XmlEnumValue("idv")
    IDV("idv"),
    @XmlEnumValue("ii")
    II("ii"),
    @XmlEnumValue("limit")
    LIMIT("limit"),
    @XmlEnumValue("mdv")
    MDV("mdv"),
    @XmlEnumValue("occasion")
    OCCASION("occasion"),
    @XmlEnumValue("rate")
    RATE("rate"),
    @XmlEnumValue("reg")
    REG("reg"),
    @XmlEnumValue("replicate")
    REPLICATE("replicate"),
    @XmlEnumValue("ss")
    SS("ss"),
    @XmlEnumValue("ssEndTime")
    SS_END_TIME("ssEndTime"),
    @XmlEnumValue("ssPeriod")
    SS_PERIOD("ssPeriod"),
    @XmlEnumValue("time")
    TIME("time"),
    @XmlEnumValue("undefined")
    UNDEFINED("undefined");
    private final String value;

    ColumnTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ColumnTypeType fromValue(String v) {
        for (ColumnTypeType c: ColumnTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
