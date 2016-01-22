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

/**
 * Possible values for {@link MatrixUniOp} operators.
 * 
 * <p>Available operators:
 * <ul>
 * <li>determinant</li>
 * <li>inverse</li>
 * <li>trace</li>
 * <li>transpose</li>
 * </ul>
 */
@XmlEnum
public enum MatrixUnioperator {
	
	@XmlEnumValue("determinant")
	DETERMINANT("determinant"),
	@XmlEnumValue("inverse")
	INVERSE("inverse"),
	@XmlEnumValue("trace")
	TRACE("trace"),
	@XmlEnumValue("transpose")
	TRANSPOSE("transpose");
	
	private String value;
	
	private MatrixUnioperator(String value){
		this.value = value;
	}
	
	/**
	 * Gets a string representation of the operator, as it is written in PharmML.
	 * @return The enum value as {@link String}.
	 */
	public String value(){
		return value;
	}

}
