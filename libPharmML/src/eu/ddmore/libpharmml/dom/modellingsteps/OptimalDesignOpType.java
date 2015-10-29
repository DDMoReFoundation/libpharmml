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
package eu.ddmore.libpharmml.dom.modellingsteps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Enumeration of the possible optimal design operation types: evaluation or optimisation.
 * @author F. Yvon
 */
@XmlType(name = "OptimalDesignOpTypeType")
@XmlEnum
public enum OptimalDesignOpType {
	
	@XmlEnumValue("evaluation")
	EVALUATION("evaluation"),
	@XmlEnumValue("optimization")
	OPTIMISATION("optimization");
	
	private final String value;
	
	OptimalDesignOpType(String value){
		this.value = value;
	}
	
	/**
	 * @return The {@link String} value in PharmML of this enum.
	 */
	public String value() {
        return value;
    }

    public static OptimalDesignOpType fromValue(String v) {
        for (OptimalDesignOpType c: OptimalDesignOpType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
    
}
