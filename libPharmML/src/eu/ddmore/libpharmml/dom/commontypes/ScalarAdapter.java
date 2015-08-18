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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;
import eu.ddmore.libpharmml.impl.LoggerWrapper;

/**
 * Adapter for converting scalar elements to JAXBElements.
 * 
 * @author F. Yvon
 *
 */
public class ScalarAdapter extends XmlAdapter<JAXBElement<?>, Scalar>{
	
	@Override
	public Scalar unmarshal(JAXBElement<?> v) throws Exception {
		if(v == null){
			return null;
		} else {
			Scalar value = (Scalar) v.getValue();
			if(value instanceof MissingValue){
				String name = v.getName().getLocalPart(); //TODO: control on namespace too
				if(name.equals("NaN")){
					((MissingValue) value).setSymbol(MissingValueSymbol.NaN);
				} else if (name.equals("ALQ")){
					((MissingValue) value).setSymbol(MissingValueSymbol.ALQ);
				} else if (name.equals("plusInf")){
					((MissingValue) value).setSymbol(MissingValueSymbol.PLUSINF);
				} else if (name.equals("minusInf")){
					((MissingValue) value).setSymbol(MissingValueSymbol.MINUSINF);
				} else if (name.equals("BLQ")){
					((MissingValue) value).setSymbol(MissingValueSymbol.BLQ);
				} else if (name.equals("NA")){
					((MissingValue) value).setSymbol(MissingValueSymbol.NA);
				} else {
					LoggerWrapper.getLogger().severe("Unknown name ("+v.getName()+")for missing value.");
				}
			}
			return value;
		}
	}

	@Override
	public JAXBElement<?> marshal(Scalar v) throws Exception {
		if(v == null){
			return null;
		} else {
			return MasterObjectFactory.createScalar(v);
		}
	}

	
}
