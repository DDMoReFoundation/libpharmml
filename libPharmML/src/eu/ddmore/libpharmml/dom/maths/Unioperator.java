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
package eu.ddmore.libpharmml.dom.maths;

import eu.ddmore.libpharmml.impl.LoggerWrapper;

/**
 * Enumeration for handling operators within {@link Uniop} elements.
 * 
 * @author F. Yvon
 *
 */
public enum Unioperator {

	ABS("abs"),
	EXP("exp"),
	FACTORIAL("factorial"),
	FACTLN("factln"),
	GAMMALN("gammaln"),
	LOG("log"),
	LOG2("log2"),
	LOG10("log10"),
	LOGISTIC("logistic"),
	LOGIT("logit"),
	NORMCDF("normcdf"),
	PROBIT("probit"),
	MINUS("minus"),
	SQRT("sqrt"),
	HEAVISIDE("heaviside"),
	SIGN("sign"),
	SIN("sin"),
	COS("cos"),
	TAN("tan"),
	COT("cot"),
	/**
	 * @deprecated Since PharmML 0.5.1, moved to {@link Binoperator}.
	 */
	ATAN2("atan2"),
	SEC("sec"),
	CSC("csc"),
	SINH("sinh"),
	COSH("cosh"),
	TANH("tanh"),
	SECH("sech"),
	CSCH("csch"),
	COTH("coth"),
	ARCSIN("arcsin"),
	ARCCOS("arccos"),
	ARCTAN("arctan"),
	ARCSEC("arcsec"),
	ARCCSC("arccsc"),
	ARCCOT("arccot"),
	ARCSINH("arcsinh"),
	ARCCOSH("arccosh"),
	ARCTANH("arctanh"),
	ARCSECH("arcsech"),
	ARCCSCH("arccsch"),
	ARCCOTH("arccoth"),
	FLOOR("floor"),
	CEILING("ceiling");
	
	private String operator;
	
	private Unioperator(String op){
		this.operator = op;
	}
	
	/**
	 * Gets the operator as it is written in the PharmML document.
	 * @return The operator as {@link String}.
	 */
	public String getOperator(){
		return operator;
	}
	
	public String value(){
		return operator;
	}
	
	/**
	 * Converts a string representation of a unioperator to a {@link Unioperator} object. If the operator string
	 * is unknown, this method returns null. The allowed input values are described in the following PharmML XSD
	 * snippet:<br>
	 * <pre>
	 *             &lt;enumeration value="abs"/>
	 *             &lt;enumeration value="exp"/>
	 *             &lt;enumeration value="factorial"/>
	 *             &lt;enumeration value="factln"/>
	 *             &lt;enumeration value="gammaln"/>
	 *             &lt;enumeration value="ln"/>
	 *             &lt;enumeration value="log"/>
	 *             &lt;enumeration value="logistic"/>
	 *             &lt;enumeration value="logit"/>
	 *             &lt;enumeration value="normcdf"/>
	 *             &lt;enumeration value="probit"/>
	 *             &lt;enumeration value="minus"/>
	 *             &lt;enumeration value="sqrt"/>
	 *             &lt;enumeration value="sin"/>
	 *             &lt;enumeration value="cos"/>
	 *             &lt;enumeration value="tan"/>
	 *             &lt;enumeration value="sec"/>
	 *             &lt;enumeration value="csc"/>
	 *             &lt;enumeration value="cot"/>
	 *             &lt;enumeration value="sinh"/>
	 *             &lt;enumeration value="cosh"/>
	 *             &lt;enumeration value="tanh"/>
	 *             &lt;enumeration value="sech"/>
	 *             &lt;enumeration value="csch"/>
	 *             &lt;enumeration value="coth"/>
	 *             &lt;enumeration value="arcsin"/>
	 *             &lt;enumeration value="arccos"/>
	 *             &lt;enumeration value="arctan"/>
	 *             &lt;enumeration value="arcsec"/>
	 *             &lt;enumeration value="arccsc"/>
	 *             &lt;enumeration value="arccot"/>
	 *             &lt;enumeration value="arcsinh"/>
	 *             &lt;enumeration value="arccosh"/>
	 *             &lt;enumeration value="arctanh"/>
	 *             &lt;enumeration value="arcsech"/>
	 *             &lt;enumeration value="arccsch"/>
	 *             &lt;enumeration value="arccoth"/>
	 *             &lt;enumeration value="floor"/>
	 *             &lt;enumeration value="ceiling"/>
	 *             </pre>
	 * @param operator The operator as {@link String}, as it is written in a PharmML document.
	 * @return The corresponding {@link Unioperator} object. null if the operator does not exist.
	 */
	public static Unioperator fromString(String operator){
		if(operator != null){
			for(Unioperator enu : values()){
				if(operator.equals(enu.value())){
					return enu;
				}
			}
			if(operator.equals("ln")){ // BC, ln = log in PharmML
				LoggerWrapper.getLogger().info("ln enum string value used as Unioperator.LOG");
				return Unioperator.LOG;
			}
		}
		return null;
	}
	
}
