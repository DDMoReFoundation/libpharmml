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
		if(v == null){
			return null;
		} else {
			return (Scalar) v.getValue();
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
