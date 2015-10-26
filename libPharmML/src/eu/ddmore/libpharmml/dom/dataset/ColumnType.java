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
 *     &lt;enumeration value="cmt"/>
 *     &lt;enumeration value="covariate"/>
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
 *     &lt;enumeration value="indivParameter"/>
 *     &lt;enumeration value="popParameter"/>
 *     &lt;enumeration value="randEffect"/>
 *     &lt;enumeration value="residual"/>
 *     &lt;enumeration value="statPrecision"/>
 *     &lt;enumeration value="strataVariable"/>
 *     &lt;enumeration value="structParameter"/>
 *     &lt;enumeration value="varParameter_var"/>
 *     &lt;enumeration value="varParameter_stdev"/>
 *     &lt;enumeration value="varParameter_cov"/>
 *     &lt;enumeration value="varParameter_corr"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ColumnTypeType")
@XmlEnum
public enum ColumnType {

    @XmlEnumValue("addl")
    ADDL("addl"),
    @XmlEnumValue("adm")
    ADM("adm"),
    @XmlEnumValue("arm")
    ARM("arm"),
    @XmlEnumValue("censoring")
    CENSORING("censoring"),
    @XmlEnumValue("cmt")
    CMT("cmt"),
    @XmlEnumValue("covariate")
    COVARIATE("covariate"),
    @Deprecated
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
    UNDEFINED("undefined"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("indivParameter")
    INDIV_PARAMETER("indivParameter"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("popParameter")
    POP_PARAMETER("popParameter"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("randEffect")
    RAND_EFFECT("randEffect"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("residual")
    RESIDUAL("residual"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("statPrecision")
    STAT_PRECISION("statPrecision"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("strataVariable")
    STRATA_VARIABLE("strataVariable"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("structParameter")
    STRUCT_PARAMETER("structParameter"),
    /**
     * @since PharmML 0.7
     */
    @XmlEnumValue("varParameter")
    @Deprecated
    VAR_PARAMETER("varParameter"),
    
    /**
     * @since PharmML 0.7.3
     */
    @XmlEnumValue("varParameter_var")
    VAR_PARAMETER_VAR("varParameter_var"),
    /**
     * @since PharmML 0.7.3
     */
    @XmlEnumValue("varParameter_stdev")
    VAR_PARAMETER_STDEV("varParameter_stdev"),
    /**
     * @since PharmML 0.7.3
     */
    @XmlEnumValue("varParameter_cov")
    VAR_PARAMETER_COV("varParameter_cov"),
    /**
     * @since PharmML 0.7.3
     */
    @XmlEnumValue("varParameter_corr")
    VAR_PARAMETER_CORR("varParameter_corr");
    private final String value;

    ColumnType(String v) {
        value = v;
    }

    /**
     * Gets the string representation of this enum as it is written in PharmML.
     * @return The {@link String} value of the enum.
     */
    public String value() {
        return value;
    }

    public static ColumnType fromValue(String v) {
        for (ColumnType c: ColumnType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
