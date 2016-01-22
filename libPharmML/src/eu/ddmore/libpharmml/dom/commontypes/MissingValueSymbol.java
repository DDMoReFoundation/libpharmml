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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Enumeration of the possible symbols used as missing value in datasets.
 * 
 * @since PharmML 0.7
 */
@XmlTransient
public enum MissingValueSymbol {
	
	NaN,
	ALQ,
	PLUSINF,
	MINUSINF,
	BLQ,
	NA;
	
	/**
	 * Gets the {@link String} representation of this enum value, as it would be written in PharmML
	 * @return The PharmML value of this enum.
	 */
	public String value(){
		ObjectFactory of = ObjectFactory.getInstance();
		switch (this) {
		case ALQ:
			return of.createALQ(null).getName().getLocalPart();
		case BLQ:
			return of.createBLQ(null).getName().getLocalPart();
		case MINUSINF:
			return of.createMinusInf(null).getName().getLocalPart();
		case NA:
			return of.createNA(null).getName().getLocalPart();
		case NaN:
			return of.createNaN(null).getName().getLocalPart();
		case PLUSINF:
			return of.createPlusInf(null).getName().getLocalPart();
		default:
			return null;
		}
	}

}
