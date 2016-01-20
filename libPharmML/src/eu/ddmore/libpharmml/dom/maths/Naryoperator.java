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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Naryoperator {
	
	@XmlEnumValue("plus")
	PLUS("plus"),
	@XmlEnumValue("times")
	TIMES("times"),
	@XmlEnumValue("min")
	MIN("min"),
	@XmlEnumValue("max")
	MAX("max"),
	@XmlEnumValue("gcd")
	GCD("gcd"),
	@XmlEnumValue("lcm")
	LCM("lcm");
	
	private final String value;
	
	private Naryoperator(String value){
		this.value = value;
	}
	
	public String value(){
		return value;
	}
	
	public static Naryoperator fromValue(String value){
		for(Naryoperator naryoperator : Naryoperator.values()){
			if(value.equals(naryoperator.value())){
				return naryoperator;
			}
		}
		throw new IllegalArgumentException(value);
	}

}
