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
package eu.ddmore.libpharmml.dom.probonto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterNameType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;enumeration value="alpha"/>
 *     &lt;enumeration value="beta"/>
 *     &lt;enumeration value="categoryProb"/>
 *     &lt;enumeration value="coefVar"/>
 *     &lt;enumeration value="concentration"/>
 *     &lt;enumeration value="covarianceMatrix"/>
 *     &lt;enumeration value="degreesOfFreedom"/>
 *     &lt;enumeration value="denominator"/>
 *     &lt;enumeration value="dispersion"/>
 *     &lt;enumeration value="inverseScaleMatrix"/>
 *     &lt;enumeration value="lambda"/>
 *     &lt;enumeration value="location"/>
 *     &lt;enumeration value="maximum"/>
 *     &lt;enumeration value="mean"/>
 *     &lt;enumeration value="meanLog"/>
 *     &lt;enumeration value="median"/>
 *     &lt;enumeration value="minimum"/>
 *     &lt;enumeration value="numberOfFailures"/>
 *     &lt;enumeration value="numberOfSuccesses"/>
 *     &lt;enumeration value="numberOfTrials"/>
 *     &lt;enumeration value="numberOfValues"/>
 *     &lt;enumeration value="numerator"/>
 *     &lt;enumeration value="overdispersion"/>
 *     &lt;enumeration value="populationSize"/>
 *     &lt;enumeration value="precision"/>
 *     &lt;enumeration value="precisionMatrix"/>
 *     &lt;enumeration value="probability"/>
 *     &lt;enumeration value="probabilityOfSuccess"/>
 *     &lt;enumeration value="probabilityOfZero"/>
 *     &lt;enumeration value="rate"/>
 *     &lt;enumeration value="scale"/>
 *     &lt;enumeration value="scaleMatrix"/>
 *     &lt;enumeration value="shape"/>
 *     &lt;enumeration value="shape1"/>
 *     &lt;enumeration value="shape2"/>
 *     &lt;enumeration value="sizeParameter"/>
 *     &lt;enumeration value="stdev"/>
 *     &lt;enumeration value="stdevLog"/>
 *     &lt;enumeration value="tau"/>
 *     &lt;enumeration value="var"/>
 *     &lt;enumeration value="varLog"/>
 *     &lt;enumeration value="weight"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlType(name = "ParameterNameType")
@XmlEnum
public enum ParameterName {

    @XmlEnumValue("alpha")
    ALPHA("alpha"),
    @XmlEnumValue("beta")
    BETA("beta"),
    @XmlEnumValue("categoryProb")
    CATEGORY_PROB("categoryProb"),
    @XmlEnumValue("coefVar")
    COEF_VAR("coefVar"),
    @XmlEnumValue("concentration")
    CONCENTRATION("concentration"),
    @XmlEnumValue("covarianceMatrix")
    COVARIANCE_MATRIX("covarianceMatrix"),
    @XmlEnumValue("degreesOfFreedom")
    DEGREES_OF_FREEDOM("degreesOfFreedom"),
    @XmlEnumValue("denominator")
    DENOMINATOR("denominator"),
    @XmlEnumValue("dispersion")
    DISPERSION("dispersion"),
    @XmlEnumValue("inverseScaleMatrix")
    INVERSE_SCALE_MATRIX("inverseScaleMatrix"),
    @XmlEnumValue("lambda")
    LAMBDA("lambda"),
    @XmlEnumValue("location")
    LOCATION("location"),
    @XmlEnumValue("maximum")
    MAXIMUM("maximum"),
    @XmlEnumValue("mean")
    MEAN("mean"),
    @XmlEnumValue("meanLog")
    MEAN_LOG("meanLog"),
    @XmlEnumValue("median")
    MEDIAN("median"),
    @XmlEnumValue("minimum")
    MINIMUM("minimum"),
    @XmlEnumValue("numberOfFailures")
    NUMBER_OF_FAILURES("numberOfFailures"),
    @XmlEnumValue("numberOfSuccesses")
    NUMBER_OF_SUCCESSES("numberOfSuccesses"),
    @XmlEnumValue("numberOfTrials")
    NUMBER_OF_TRIALS("numberOfTrials"),
    @XmlEnumValue("numberOfValues")
    NUMBER_OF_VALUES("numberOfValues"),
    @XmlEnumValue("numerator")
    NUMERATOR("numerator"),
    @XmlEnumValue("overdispersion")
    OVERDISPERSION("overdispersion"),
    @XmlEnumValue("populationSize")
    POPULATION_SIZE("populationSize"),
    @XmlEnumValue("precision")
    PRECISION("precision"),
    @XmlEnumValue("precisionMatrix")
    PRECISION_MATRIX("precisionMatrix"),
    @XmlEnumValue("probability")
    PROBABILITY("probability"),
    @XmlEnumValue("probabilityOfSuccess")
    PROBABILITY_OF_SUCCESS("probabilityOfSuccess"),
    @XmlEnumValue("probabilityOfZero")
    PROBABILITY_OF_ZERO("probabilityOfZero"),
    @XmlEnumValue("rate")
    RATE("rate"),
    @XmlEnumValue("scale")
    SCALE("scale"),
    @XmlEnumValue("scaleMatrix")
    SCALE_MATRIX("scaleMatrix"),
    @XmlEnumValue("shape")
    SHAPE("shape"),
    @XmlEnumValue("shape1")
    SHAPE_1("shape1"),
    @XmlEnumValue("shape2")
    SHAPE_2("shape2"),
    @XmlEnumValue("sizeParameter")
    SIZE_PARAMETER("sizeParameter"),
    @XmlEnumValue("stdev")
    STDEV("stdev"),
    @XmlEnumValue("stdevLog")
    STDEV_LOG("stdevLog"),
    @XmlEnumValue("tau")
    TAU("tau"),
    @XmlEnumValue("var")
    VAR("var"),
    @XmlEnumValue("varLog")
    VAR_LOG("varLog"),
    @XmlEnumValue("weight")
    WEIGHT("weight");
    private final String value;

    ParameterName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParameterName fromValue(String v) {
        for (ParameterName c: ParameterName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
