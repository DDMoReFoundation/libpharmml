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
package eu.ddmore.libpharmml.dom.commontypes;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class IntValue extends IntValueType {
	
	public IntValue(BigInteger integer){
		this.value = integer;
	}
	
	public IntValue(Integer integer){
		this.value = BigInteger.valueOf(integer);
	}

}