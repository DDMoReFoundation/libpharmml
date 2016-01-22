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
package eu.ddmore.libpharmml.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

/**
 * And extended {@link ArrayList} that provides the possibility
 * of method chaining.

 * @param <T> Class of the content of the list.
 */
public class ChainedList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7322317602466355646L;
	
	public ChainedList(){}
	
	public ChainedList(List<? extends T> list){
		addIfNotNull(list);
	}

	public ChainedList<T> addIfNotNull(T element){
		if(element != null){
			add(element);
		}
		return this;
	}
	
	public ChainedList<T> addJAXBIfNotNull(JAXBElement<? extends T> jaxbEl){
		if(jaxbEl != null && jaxbEl.getValue() != null){
			add(jaxbEl.getValue());
		}
		return this;
	}
	
	public ChainedList<T> addIfNotNull(List<? extends T> element){
		if(element != null){
			addAll(element);
		}
		return this;
	}

}
