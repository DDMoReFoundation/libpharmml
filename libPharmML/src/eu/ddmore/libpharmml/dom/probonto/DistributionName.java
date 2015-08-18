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
 * <p>Java class for DistroNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistroNameType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;enumeration value="Bernoulli"/>
 *     &lt;enumeration value="Binomial"/>
 *     &lt;enumeration value="CategoricalOrdered"/>
 *     &lt;enumeration value="CategoricalNonordered"/>
 *     &lt;enumeration value="GeneralizedPoisson"/>
 *     &lt;enumeration value="Geometric"/>
 *     &lt;enumeration value="Hypergeometric"/>
 *     &lt;enumeration value="NegativeBinomial1"/>
 *     &lt;enumeration value="NegativeBinomial2"/>
 *     &lt;enumeration value="Poisson"/>
 *     &lt;enumeration value="UniformDiscrete1"/>
 *     &lt;enumeration value="UniformDiscrete2"/>
 *     &lt;enumeration value="ZeroInflatedNegativeBinomial"/>
 *     &lt;enumeration value="ZeroInflatedPoisson"/>
 *     &lt;enumeration value="Beta"/>
 *     &lt;enumeration value="Cauchy"/>
 *     &lt;enumeration value="ChiSquared"/>
 *     &lt;enumeration value="Exponential"/>
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="Gamma"/>
 *     &lt;enumeration value="GeneralizedGamma"/>
 *     &lt;enumeration value="Gompertz"/>
 *     &lt;enumeration value="Gumbel"/>
 *     &lt;enumeration value="InverseGamma"/>
 *     &lt;enumeration value="Laplace1"/>
 *     &lt;enumeration value="Laplace2"/>
 *     &lt;enumeration value="LogNormal1"/>
 *     &lt;enumeration value="LogNormal2"/>
 *     &lt;enumeration value="LogNormal3"/>
 *     &lt;enumeration value="LogNormal4"/>
 *     &lt;enumeration value="LogNormal5"/>
 *     &lt;enumeration value="Logistic"/>
 *     &lt;enumeration value="Normal1"/>
 *     &lt;enumeration value="Normal2"/>
 *     &lt;enumeration value="Normal3"/>
 *     &lt;enumeration value="NormalInverseGamma"/>
 *     &lt;enumeration value="Pareto"/>
 *     &lt;enumeration value="Rayleigh"/>
 *     &lt;enumeration value="StandardNormal"/>
 *     &lt;enumeration value="StandardUniform"/>
 *     &lt;enumeration value="StudentT"/>
 *     &lt;enumeration value="Uniform"/>
 *     &lt;enumeration value="Weibull1"/>
 *     &lt;enumeration value="Weibull2"/>
 *     &lt;enumeration value="Multinomial"/>
 *     &lt;enumeration value="Dirichlet"/>
 *     &lt;enumeration value="InverseWishart"/>
 *     &lt;enumeration value="MultivariateNormal1"/>
 *     &lt;enumeration value="MultivariateNormal2"/>
 *     &lt;enumeration value="MultivariateStudentT1"/>
 *     &lt;enumeration value="MultivariateStudentT2"/>
 *     &lt;enumeration value="Wishart1"/>
 *     &lt;enumeration value="Wishart2"/>
 *     &lt;enumeration value="MixtureDistribution"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlType(name = "DistroNameType")
@XmlEnum
public enum DistributionName {

    @XmlEnumValue("Bernoulli")
    BERNOULLI("Bernoulli"),
    @XmlEnumValue("Binomial")
    BINOMIAL("Binomial"),
    @XmlEnumValue("CategoricalOrdered")
    CATEGORICAL_ORDERED("CategoricalOrdered"),
    @XmlEnumValue("CategoricalNonordered")
    CATEGORICAL_NONORDERED("CategoricalNonordered"),
    @XmlEnumValue("GeneralizedPoisson")
    GENERALIZED_POISSON("GeneralizedPoisson"),
    @XmlEnumValue("Geometric")
    GEOMETRIC("Geometric"),
    @XmlEnumValue("Hypergeometric")
    HYPERGEOMETRIC("Hypergeometric"),
    @XmlEnumValue("NegativeBinomial1")
    NEGATIVE_BINOMIAL_1("NegativeBinomial1"),
    @XmlEnumValue("NegativeBinomial2")
    NEGATIVE_BINOMIAL_2("NegativeBinomial2"),
    @XmlEnumValue("Poisson")
    POISSON("Poisson"),
    @XmlEnumValue("UniformDiscrete1")
    UNIFORM_DISCRETE_1("UniformDiscrete1"),
    @XmlEnumValue("UniformDiscrete2")
    UNIFORM_DISCRETE_2("UniformDiscrete2"),
    @XmlEnumValue("ZeroInflatedNegativeBinomial")
    ZERO_INFLATED_NEGATIVE_BINOMIAL("ZeroInflatedNegativeBinomial"),
    @XmlEnumValue("ZeroInflatedPoisson")
    ZERO_INFLATED_POISSON("ZeroInflatedPoisson"),
    @XmlEnumValue("Beta")
    BETA("Beta"),
    @XmlEnumValue("Cauchy")
    CAUCHY("Cauchy"),
    @XmlEnumValue("ChiSquared")
    CHI_SQUARED("ChiSquared"),
    @XmlEnumValue("Exponential")
    EXPONENTIAL("Exponential"),
    F("F"),
    @XmlEnumValue("Gamma")
    GAMMA("Gamma"),
    @XmlEnumValue("GeneralizedGamma")
    GENERALIZED_GAMMA("GeneralizedGamma"),
    @XmlEnumValue("Gompertz")
    GOMPERTZ("Gompertz"),
    @XmlEnumValue("Gumbel")
    GUMBEL("Gumbel"),
    @XmlEnumValue("InverseGamma")
    INVERSE_GAMMA("InverseGamma"),
    @XmlEnumValue("Laplace1")
    LAPLACE_1("Laplace1"),
    @XmlEnumValue("Laplace2")
    LAPLACE_2("Laplace2"),
    @XmlEnumValue("LogNormal1")
    LOG_NORMAL_1("LogNormal1"),
    @XmlEnumValue("LogNormal2")
    LOG_NORMAL_2("LogNormal2"),
    @XmlEnumValue("LogNormal3")
    LOG_NORMAL_3("LogNormal3"),
    @XmlEnumValue("LogNormal4")
    LOG_NORMAL_4("LogNormal4"),
    @XmlEnumValue("LogNormal5")
    LOG_NORMAL_5("LogNormal5"),
    @XmlEnumValue("Logistic")
    LOGISTIC("Logistic"),
    @XmlEnumValue("Normal1")
    NORMAL_1("Normal1"),
    @XmlEnumValue("Normal2")
    NORMAL_2("Normal2"),
    @XmlEnumValue("Normal3")
    NORMAL_3("Normal3"),
    @XmlEnumValue("NormalInverseGamma")
    NORMAL_INVERSE_GAMMA("NormalInverseGamma"),
    @XmlEnumValue("Pareto")
    PARETO("Pareto"),
    @XmlEnumValue("Rayleigh")
    RAYLEIGH("Rayleigh"),
    @XmlEnumValue("StandardNormal")
    STANDARD_NORMAL("StandardNormal"),
    @XmlEnumValue("StandardUniform")
    STANDARD_UNIFORM("StandardUniform"),
    @XmlEnumValue("StudentT")
    STUDENT_T("StudentT"),
    @XmlEnumValue("Uniform")
    UNIFORM("Uniform"),
    @XmlEnumValue("Weibull1")
    WEIBULL_1("Weibull1"),
    @XmlEnumValue("Weibull2")
    WEIBULL_2("Weibull2"),
    @XmlEnumValue("Multinomial")
    MULTINOMIAL("Multinomial"),
    @XmlEnumValue("Dirichlet")
    DIRICHLET("Dirichlet"),
    @XmlEnumValue("InverseWishart")
    INVERSE_WISHART("InverseWishart"),
    @XmlEnumValue("MultivariateNormal1")
    MULTIVARIATE_NORMAL_1("MultivariateNormal1"),
    @XmlEnumValue("MultivariateNormal2")
    MULTIVARIATE_NORMAL_2("MultivariateNormal2"),
    @XmlEnumValue("MultivariateStudentT1")
    MULTIVARIATE_STUDENT_T_1("MultivariateStudentT1"),
    @XmlEnumValue("MultivariateStudentT2")
    MULTIVARIATE_STUDENT_T_2("MultivariateStudentT2"),
    @XmlEnumValue("Wishart1")
    WISHART_1("Wishart1"),
    @XmlEnumValue("Wishart2")
    WISHART_2("Wishart2"),
    @XmlEnumValue("MixtureDistribution")
    MIXTURE_DISTRIBUTION("MixtureDistribution");
    private final String value;

    DistributionName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DistributionName fromValue(String v) {
        for (DistributionName c: DistributionName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
