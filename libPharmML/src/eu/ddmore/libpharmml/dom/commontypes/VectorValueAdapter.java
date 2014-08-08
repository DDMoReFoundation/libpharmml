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

import eu.ddmore.libpharmml.exceptions.UndeclaredInterfaceImplementer;

public class VectorValueAdapter extends XmlAdapter<JAXBElement<?>, VectorValue>{
	
	private static ObjectFactory of = new ObjectFactory();

	@Override
	public VectorValue unmarshal(JAXBElement<?> v) throws Exception {
		return (VectorValue) v.getValue();
	}

	@Override
	public JAXBElement<?> marshal(VectorValue v) throws Exception {
		if(v instanceof VectorCellValue){
			return new VectorCellValueAdapter().marshal((VectorCellValue) v);
		} else if (v instanceof SequenceType){
			return of.createSequence((SequenceType) v);
		} else {
			throw new UndeclaredInterfaceImplementer(this, v);
		}
	}

}
