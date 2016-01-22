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
package eu.ddmore.libpharmml.dom.maths;

/**
 * Enumeration for handling operators within {@link Binop} elements.
 * 
 * The possible values are the following:
 * <ul>
 * <li>PLUS ("plus")</li>
 * <li>MINUS ("minus")</li>
 * <li>TIMES ("times")</li>
 * <li>DIVIDE ("divide")</li>
 * <li>POWER ("power")</li>
 * <li>LOGX ("logx")</li>
 * <li>ROOT ("root")</li>
 * <li>MIN ("min")</li>
 * <li>MAX ("max")</li>
 * <li>REM ("rem")</li>
 * <li>ATAN2 ("atan2")</li>
 * </ul>
 * 
 * @author Florent Yvon
 */
public enum Binoperator {
	
	PLUS("plus"),
	MINUS("minus"),
	TIMES("times"),
	DIVIDE("divide"),
	POWER("power"),
	LOGX("logx"),
	ROOT("root"),
	MIN("min"),
	MAX("max"),
	REM("rem"),
	ATAN2("atan2");
	
	private String operator;
	
	private Binoperator(String operator){
		this.operator = operator;
	}
	
	/**
	 * Gets the PharmML string representation of the current operator.
	 * @return The operator as {@link String}, as it is written in the PharmML document.
	 */
	public String getOperator(){
		return operator;
	}
	
	/**
	 * Converts a string representation of a binoperator to a {@link Binoperator} object.
	 * @param operator The operator as {@link String}, as it is written in a PharmML document.
	 * @return The corresponding {@link Binoperator} object. null if the operator does not exist.
	 */
	public static Binoperator fromString(String operator){
		if(operator != null){
			if(operator.equals("plus")){
				return Binoperator.PLUS;
			} else if(operator.equals("minus")){
				return Binoperator.MINUS;
			} else if(operator.equals("times")){
				return Binoperator.TIMES;
			} else if(operator.equals("divide")){
				return Binoperator.DIVIDE;
			} else if(operator.equals("power")){
				return Binoperator.POWER;
			} else if(operator.equals("logx")){
				return Binoperator.LOGX;
			} else if(operator.equals("root")){
				return Binoperator.ROOT;
			} else if(operator.equals("min")){
				return Binoperator.MIN;
			} else if(operator.equals("max")){
				return Binoperator.MAX;
			} else if(operator.equals("rem")){
				return Binoperator.REM;
			} else if(operator.equals("atan2")){
				return Binoperator.ATAN2;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
