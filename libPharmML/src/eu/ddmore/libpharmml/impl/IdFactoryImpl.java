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
package eu.ddmore.libpharmml.impl;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eu.ddmore.libpharmml.IdFactory;
import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.validation.exceptions.DuplicateIdentifierException;

/**
 * Class handling the generation and storing of identifiers.
 */
public class IdFactoryImpl implements IdFactory {
	
	private final Map<String,Identifiable> table;
	
	private AtomicInteger lastIndex;
	private static final String patternString = "^i(\\d+)$";
	private static final Pattern idPattern = Pattern.compile(patternString);
	
	public IdFactoryImpl(){
		table = new Hashtable<String,Identifiable>();
		lastIndex = new AtomicInteger(0);
	}
	
	/**
	 * Stores the given identifiable element, which must have a defined id.
	 * If the given element is already stored, nothing will be done.
	 * @param element The element to store.
	 * @throws DuplicateIdentifierException If a different identifiable element has already been
	 * stored with the same id.
	 */
	public void storeIdentifiable(Identifiable element) throws DuplicateIdentifierException{
		String id = element.getId();
		if(table.containsKey(id) && !table.get(id).equals(element)){
			throw new DuplicateIdentifierException(table.get(id));
		}
		Matcher matcher = idPattern.matcher(id);
		if(matcher.matches()){
			String indexString = matcher.group(1);
			Integer index = Integer.valueOf(indexString);
			if(index > lastIndex.intValue()){
				lastIndex.set(index);
			}
		}
		table.put(id, element);
	}
	
	/**
	 * Stores the given element by generating its identifier automatically. The generated id will be
	 * "iX", X being the last index+1 of the stored identifiers that follow this format.
	 * @param element The element to be stored and identified.
	 * @return The value of the generated identifier.
	 */
	public String generateAndStoreIdentifiable(Identifiable element){
		element.setId("i"+lastIndex.incrementAndGet());
		return element.getId();
	}
	
	/**
	 * Gets the identifiable element with the given identifier. Can only be found the elements
	 * that has been stored previously using {@link #storeIdentifiable(Identifiable)} or
	 * {@link #generateAndStoreIdentifiable(Identifiable)}.
	 * @param id The identifier of the wanted element.
	 * @return The found element. If the element does not exist or is not stored, this method
	 * returns null.
	 */
	public Identifiable getIdentifiable(String id){
		if(table.containsKey(id)){
			return table.get(id);
		} else {
			return null;
		}
	}
	
	/**
	 * Checks if the provided identifier has already been given to a stored object.
	 * @param id The identifier to check.
	 * @return true if the identifier is found, else false.
	 */
	public boolean exists(String id){
		return table.containsKey(id);
	}

	@Override
	public Set<Identifiable> getListOfIdentifiable() {
		return new HashSet<Identifiable>(table.values());
	}
	
}
