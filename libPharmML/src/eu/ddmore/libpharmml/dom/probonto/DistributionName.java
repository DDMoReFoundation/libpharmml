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

import java.util.HashSet;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import eu.ddmore.libpharmml.impl.LoggerWrapper;


/**
 * <p>Java class for DistroNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistroNameType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *     &lt;enumeration value="Bernoulli1"/>
 *     &lt;enumeration value="BetaBinomial1"/>
 *     &lt;enumeration value="Binomial1"/>
 *     &lt;enumeration value="CategoricalOrdered1"/>
 *     &lt;enumeration value="CategoricalNonordered1"/>
 *     &lt;enumeration value="CategoricalOrdered1"/>
 *     &lt;enumeration value="ConwayMaxwellPoisson1"/>
 *     &lt;enumeration value="DoublePoisson1"/>
 *     &lt;enumeration value="GeneralizedNegativeBinomial1"/>
 *     &lt;enumeration value="GeneralizedPoisson1"/>
 *     &lt;enumeration value="GeneralizedPoisson2"/>
 *     &lt;enumeration value="GeneralizedPoisson3"/>
 *     &lt;enumeration value="Geometric1"/>
 *     &lt;enumeration value="Hypergeometric1"/>
 *     &lt;enumeration value="InverseBinomial1"/>
 *     &lt;enumeration value="NegativeBinomial1"/>
 *     &lt;enumeration value="NegativeBinomial2"/>
 *     &lt;enumeration value="NegativeBinomial3"/>
 *     &lt;enumeration value="NegativeBinomial4"/>
 *     &lt;enumeration value="NegativeBinomial5"/>
 *     &lt;enumeration value="Poisson1"/>
 *     &lt;enumeration value="UniformDiscrete1"/>
 *     &lt;enumeration value="UniformDiscrete2"/>
 *     &lt;enumeration value="ZeroInflatedNegativeBinomial1"/>
 *     &lt;enumeration value="ZeroInflatedGeneralizedPoisson1"/>
 *     &lt;enumeration value="ZeroInflatedPoisson1"/>
 *     &lt;enumeration value="Beta1"/>
 *     &lt;enumeration value="BirnbaumSaunders1"/>
 *     &lt;enumeration value="Cauchy1"/>
 *     &lt;enumeration value="ChiSquared1"/>
 *     &lt;enumeration value="Erlang1"/>
 *     &lt;enumeration value="Exponential1"/>
 *     &lt;enumeration value="Exponential2"/>
 *     &lt;enumeration value="F1"/>
 *     &lt;enumeration value="F2"/>
 *     &lt;enumeration value="Gamma1"/>
 *     &lt;enumeration value="Gamma2"/>
 *     &lt;enumeration value="GeneralizedGamma1"/>
 *     &lt;enumeration value="GeneralizedGamma2"/>
 *     &lt;enumeration value="GeneralizedGamma3"/>
 *     &lt;enumeration value="Gompertz1"/>
 *     &lt;enumeration value="Gumbel1"/>
 *     &lt;enumeration value="HalfNormal1"/>
 *     &lt;enumeration value="InverseGamma1"/>
 *     &lt;enumeration value="InverseGaussian1"/>
 *     &lt;enumeration value="Laplace1"/>
 *     &lt;enumeration value="Laplace2"/>
 *     &lt;enumeration value="Logistic1"/>
 *     &lt;enumeration value="Logistic2"/>
 *     &lt;enumeration value="LogLogistic1"/>
 *     &lt;enumeration value="LogLogistic2"/>
 *     &lt;enumeration value="LogNormal1"/>
 *     &lt;enumeration value="LogNormal2"/>
 *     &lt;enumeration value="LogNormal3"/>
 *     &lt;enumeration value="LogNormal4"/>
 *     &lt;enumeration value="LogNormal5"/>
 *     &lt;enumeration value="LogNormal6"/>
 *     &lt;enumeration value="LogUniform1"/>
 *     &lt;enumeration value="Nakagami1"/>
 *     &lt;enumeration value="Normal1"/>
 *     &lt;enumeration value="Normal2"/>
 *     &lt;enumeration value="Normal3"/>
 *     &lt;enumeration value="NormalInverseGamma1"/>
 *     &lt;enumeration value="Pareto1"/>
 *     &lt;enumeration value="Rayleigh1"/>
 *     &lt;enumeration value="StandardNormal1"/>
 *     &lt;enumeration value="StandardUniform1"/>
 *     &lt;enumeration value="StudentT1"/>
 *     &lt;enumeration value="StudentT2"/>
 *     &lt;enumeration value="Triangular1"/>
 *     &lt;enumeration value="TruncatedNormal1"/>
 *     &lt;enumeration value="Uniform1"/>
 *     &lt;enumeration value="Weibull1"/>
 *     &lt;enumeration value="Weibull2"/>
 *     &lt;enumeration value="Multinomial1"/>
 *     &lt;enumeration value="Dirichlet1"/>
 *     &lt;enumeration value="InverseWishart1"/>
 *     &lt;enumeration value="MultivariateNormal1"/>
 *     &lt;enumeration value="MultivariateNormal2"/>
 *     &lt;enumeration value="MultivariateStudentT1"/>
 *     &lt;enumeration value="MultivariateStudentT2"/>
 *     &lt;enumeration value="Wishart1"/>
 *     &lt;enumeration value="Wishart2"/>
 *     &lt;enumeration value="MixtureDistribution"/>
 *     &lt;enumeration value="RandomSample"/>
 *     &lt;enumeration value="StatisticalSample"/>
 *     &lt;enumeration value="UnknownSample"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlType(name = "DistroNameType")
@XmlEnum
public enum DistributionName {

    @XmlEnumValue("Bernoulli1")
    BERNOULLI_1("Bernoulli1"),
    @XmlEnumValue("BetaBinomial1")
    BETA_BINOMIAL_1("BetaBinomial1"),
    @XmlEnumValue("Binomial1")
    BINOMIAL_1("Binomial1"),
    @XmlEnumValue("CategoricalOrdered1")
    CATEGORICAL_ORDERED_1("CategoricalOrdered1"),
    @XmlEnumValue("CategoricalNonordered1")
    CATEGORICAL_NONORDERED_1("CategoricalNonordered1"),
    @XmlEnumValue("ConwayMaxwellPoisson1")
    CONWAY_MAXWELL_POISSON_1("ConwayMaxwellPoisson1"),
    @XmlEnumValue("DoublePoisson1")
    DOUBLE_POISSON_1("DoublePoisson1"),
    @XmlEnumValue("GeneralizedNegativeBinomial1")
    GENERALIZED_NEGATIVE_BINOMIAL_1("GeneralizedNegativeBinomial1"),
    @XmlEnumValue("GeneralizedPoisson1")
    GENERALIZED_POISSON_1("GeneralizedPoisson1"),
    @XmlEnumValue("GeneralizedPoisson2")
    GENERALIZED_POISSON_2("GeneralizedPoisson2"),
    @XmlEnumValue("GeneralizedPoisson3")
    GENERALIZED_POISSON_3("GeneralizedPoisson3"),
    @XmlEnumValue("Geometric1")
    GEOMETRIC_1("Geometric1"),
    @XmlEnumValue("Hypergeometric1")
    HYPERGEOMETRIC_1("Hypergeometric1"),
    @XmlEnumValue("InverseBinomial1")
    INVERSE_BINOMIAL_1("InverseBinomial1"),
    @XmlEnumValue("NegativeBinomial1")
    NEGATIVE_BINOMIAL_1("NegativeBinomial1"),
    @XmlEnumValue("NegativeBinomial2")
    NEGATIVE_BINOMIAL_2("NegativeBinomial2"),
    @XmlEnumValue("NegativeBinomial3")
    NEGATIVE_BINOMIAL_3("NegativeBinomial3"),
    @XmlEnumValue("NegativeBinomial4")
    NEGATIVE_BINOMIAL_4("NegativeBinomial4"),
    @XmlEnumValue("NegativeBinomial5")
    NEGATIVE_BINOMIAL_5("NegativeBinomial5"),
    @XmlEnumValue("Poisson1")
    POISSON_1("Poisson1"),
    @XmlEnumValue("UniformDiscrete1")
    UNIFORM_DISCRETE_1("UniformDiscrete1"),
    @XmlEnumValue("UniformDiscrete2")
    UNIFORM_DISCRETE_2("UniformDiscrete2"),
    @XmlEnumValue("ZeroInflatedNegativeBinomial1")
    ZERO_INFLATED_NEGATIVE_BINOMIAL_1("ZeroInflatedNegativeBinomial1"),
    @XmlEnumValue("ZeroInflatedGeneralizedPoisson1")
    ZERO_INFLATED_GENERALIZED_POISSON_1("ZeroInflatedGeneralizedPoisson1"),
    @XmlEnumValue("ZeroInflatedPoisson1")
    ZERO_INFLATED_POISSON_1("ZeroInflatedPoisson1"),
    @XmlEnumValue("Beta1")
    BETA_1("Beta1"),
    @XmlEnumValue("BirnbaumSaunders1")
    BIRNBAUM_SAUNDERS_1("BirnbaumSaunders1"),
    @XmlEnumValue("Cauchy1")
    CAUCHY_1("Cauchy1"),
    @XmlEnumValue("ChiSquared1")
    CHI_SQUARED_1("ChiSquared1"),
    @XmlEnumValue("Erlang1")
    ERLANG_1("Erlang1"),
    @XmlEnumValue("Exponential1")
    EXPONENTIAL_1("Exponential1"),
    @XmlEnumValue("Exponential2")
    EXPONENTIAL_2("Exponential2"),
    @XmlEnumValue("F1")
    F_1("F1"),
    @XmlEnumValue("F2")
    F_2("F2"),
    @XmlEnumValue("Gamma1")
    GAMMA_1("Gamma1"),
    @XmlEnumValue("Gamma2")
    GAMMA_2("Gamma2"),
    @XmlEnumValue("GeneralizedGamma1")
    GENERALIZED_GAMMA_1("GeneralizedGamma1"),
    @XmlEnumValue("GeneralizedGamma2")
    GENERALIZED_GAMMA_2("GeneralizedGamma2"),
    @XmlEnumValue("GeneralizedGamma3")
    GENERALIZED_GAMMA_3("GeneralizedGamma3"),
    @XmlEnumValue("Gompertz1")
    GOMPERTZ_1("Gompertz1"),
    @XmlEnumValue("Gumbel1")
    GUMBEL_1("Gumbel1"),
    @XmlEnumValue("HalfNormal1")
    HALF_NORMAL_1("HalfNormal1"),
    @XmlEnumValue("InverseGamma1")
    INVERSE_GAMMA_1("InverseGamma1"),
    @XmlEnumValue("InverseGaussian1")
    INVERSE_GAUSSIAN_1("InverseGaussian1"),
    @XmlEnumValue("Laplace1")
    LAPLACE_1("Laplace1"),
    @XmlEnumValue("Laplace2")
    LAPLACE_2("Laplace2"),
    @XmlEnumValue("Logistic1")
    LOGISTIC_1("Logistic1"),
    @XmlEnumValue("Logistic2")
    LOGISTIC_2("Logistic2"),
    @XmlEnumValue("LogLogistic1")
    LOG_LOGISTIC_1("LogLogistic1"),
    @XmlEnumValue("LogLogistic2")
    LOG_LOGISTIC_2("LogLogistic2"),
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
    @XmlEnumValue("LogNormal6")
    LOG_NORMAL_6("LogNormal6"),
    @XmlEnumValue("LogUniform1")
    LOG_UNIFORM_1("LogUniform1"),
    @XmlEnumValue("Nakagami1")
    NAKAGAMI_1("Nakagami1"),
    @XmlEnumValue("Normal1")
    NORMAL_1("Normal1"),
    @XmlEnumValue("Normal2")
    NORMAL_2("Normal2"),
    @XmlEnumValue("Normal3")
    NORMAL_3("Normal3"),
    @XmlEnumValue("NormalInverseGamma1")
    NORMAL_INVERSE_GAMMA_1("NormalInverseGamma1"),
    @XmlEnumValue("Pareto1")
    PARETO_1("Pareto1"),
    @XmlEnumValue("Rayleigh1")
    RAYLEIGH_1("Rayleigh1"),
    @XmlEnumValue("StandardNormal1")
    STANDARD_NORMAL_1("StandardNormal1"),
    @XmlEnumValue("StandardUniform1")
    STANDARD_UNIFORM_1("StandardUniform1"),
    @XmlEnumValue("StudentT1")
    STUDENT_T_1("StudentT1"),
    @XmlEnumValue("StudentT2")
    STUDENT_T_2("StudentT2"),
    @XmlEnumValue("Triangular1")
    TRIANGULAR_1("Triangular1"),
    @XmlEnumValue("TruncatedNormal1")
    TRUNCATED_NORMAL_1("TruncatedNormal1"),
    @XmlEnumValue("Uniform1")
    UNIFORM_1("Uniform1"),
    @XmlEnumValue("Weibull1")
    WEIBULL_1("Weibull1"),
    @XmlEnumValue("Weibull2")
    WEIBULL_2("Weibull2"),
    @XmlEnumValue("Multinomial1")
    MULTINOMIAL_1("Multinomial1"),
    @XmlEnumValue("Dirichlet1")
    DIRICHLET_1("Dirichlet1"),
    @XmlEnumValue("InverseWishart1")
    INVERSE_WISHART_1("InverseWishart1"),
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
    MIXTURE_DISTRIBUTION("MixtureDistribution"),
    @XmlEnumValue("RandomSample")
    RANDOM_SAMPLE("RandomSample"),
    @XmlEnumValue("StatisticalSample")
    STATISTICAL_SAMPLE("StatisticalSample"),
    @XmlEnumValue("UnknownSample")
    UNKNOWN_SAMPLE("UnknownSample");
    private final String value;
    
//    private final ParameterName[] requiredParameters;
    
    private final static String PROPERTIES_PREFIX = "eu.ddmore.libpharmml.dom.probonto.distribution.";
    
    private final static Pattern OPTIONAL_PARAM_PATTERN = Pattern.compile("\\(([a-zA-Z0-9]+)\\)");
    private Set<ParameterName> allowedParameters;
    private Set<ParameterName> requiredParameters;

    DistributionName(String v) {
        value = v;
//        requiredParameters = resolveRequiredParameters(v);
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
    
    /**
     * Get the list of the parameters required for this distribution.
     * @return An array of {@link ParameterName} values required for this distribution.
     */
    public ParameterName[] requiredParameters(){
    	if(requiredParameters == null){
    		resolveRequiredParameters(value);
    	}
    	return requiredParameters.toArray(new ParameterName[requiredParameters.size()]);
    }
    
    public Set<ParameterName> allowedParameters(){
    	if(allowedParameters == null){
    		resolveRequiredParameters(value);
    	}
    	return allowedParameters;
    }
    
    private void resolveRequiredParameters(String distribution){
    	requiredParameters = new HashSet<ParameterName>();
    	allowedParameters = new HashSet<ParameterName>();
    	String parametersRaw = Properties.getString(PROPERTIES_PREFIX+distribution);
    	if(parametersRaw == null){
    		LoggerWrapper.getLogger().info("Distribution "+distribution+" is not defined in parameters.properties.");
    	} else {
    		String[] parametersArray = parametersRaw.trim().split(",");
        	for(int i=0;i<parametersArray.length;i++){
        		try {
        			String rawParamName = parametersArray[i];
        			Matcher m = OPTIONAL_PARAM_PATTERN.matcher(rawParamName);
        			String actualParamName;
        			if(m.find()){ // it's optional
        				actualParamName = m.group(1);
        			} else { // it's required
        				actualParamName = rawParamName;
        				requiredParameters.add(ParameterName.fromValue(actualParamName));
        			}
        			allowedParameters.add(ParameterName.fromValue(actualParamName));
        		} catch (IllegalArgumentException e) {
        			throw new RuntimeException("Parameter \""+parametersArray[i]+"\" doesn't exist.");
        		}
        	}
    	}
    }
    
    static class Properties {
    	private static final String BUNDLE_NAME = "eu.ddmore.libpharmml.dom.probonto.parameters";

    	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
    			.getBundle(BUNDLE_NAME);

    	private Properties() {
    	}

    	public static String getString(String key) {
    		try {
    			return RESOURCE_BUNDLE.getString(key);
    		} catch (MissingResourceException e) {
    			return null;
    		}
    	}
    }

}
