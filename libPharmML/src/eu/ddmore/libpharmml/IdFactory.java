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
package eu.ddmore.libpharmml;

import java.util.Set;

import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.validation.exceptions.DuplicateIdentifierException;

public interface IdFactory {
	
	/**
	 * Stores the given identifiable element, which must have a defined id.
	 * @param element The element to store.
	 * @throws DuplicateIdentifierException If a identifiable element has already been
	 * stored with the same id.
	 */
	public void storeIdentifiable(Identifiable element) throws DuplicateIdentifierException;
	
	/**
	 * Stores the given element by generating its identifier automatically. The generated id will be
	 * "iX", X being the last index+1 of the stored identifiers that follow this format.
	 * @param element The element to be stored and identified.
	 * @return The value of the generated identifier.
	 */
	public String generateAndStoreIdentifiable(Identifiable element);
	
	/**
	 * Gets the identifiable element with the given identifier. Can only be found the elements
	 * that has been stored previously using {@link #storeIdentifiable(Identifiable)} or
	 * {@link #generateAndStoreIdentifiable(Identifiable)}.
	 * @param id The identifier of the wanted element.
	 * @return The found element. If the element does not exist or is not stored, this method
	 * returns null.
	 */
	public Identifiable getIdentifiable(String id);
	
	/**
	 * Checks if the provided identifier has already been given to a stored object.
	 * @param id The identifier to check.
	 * @return true if the identifier is found, else false.
	 */
	public boolean exists(String id);
	
	/**
	 * Gets the list of all registered identifiable elements within the resource.
	 * @return A {@link Set} of identifiable elements.
	 */
	public Set<Identifiable> getListOfIdentifiable();

}
