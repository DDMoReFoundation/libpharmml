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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.ddmore.libpharmml.dom.MasterObjectFactory;

/**
 * Adapter for converting scalar elements to JAXBElements.
 * 
 * @author F. Yvon
 *
 */
public class ScalarAdapter extends XmlAdapter<JAXBElement<?>, Scalar>{
	
	@Override
	public Scalar unmarshal(JAXBElement<?> v) throws Exception {
		return (Scalar) v.getValue();
	}

	@Override
	public JAXBElement<?> marshal(Scalar v) throws Exception {
		if(v instanceof IntValueType){
			return MasterObjectFactory.COMMONTYPES_OF.createInt((IntValueType) v);
		} else if(v instanceof RealValueType){
			return MasterObjectFactory.COMMONTYPES_OF.createReal((RealValueType) v);
		} else if(v instanceof StringValueType){
			return MasterObjectFactory.COMMONTYPES_OF.createString((StringValueType) v);
		} else if(v instanceof IdValueType){
			return MasterObjectFactory.COMMONTYPES_OF.createId((IdValueType) v);
		} else if(v instanceof BooleanType){
			return MasterObjectFactory.COMMONTYPES_OF.createBoolean((BooleanType) v);
		} else {
			return MasterObjectFactory.COMMONTYPES_OF.createScalar(v);
		}
	}

	
}
