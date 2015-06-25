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
package eu.ddmore.libpharmml.validation.exceptions;

import eu.ddmore.libpharmml.dom.Identifiable;

/**
 * Exception thrown during an attempt to store an {@link Identifiable} with an already
 * given identifier.
 */
public class DuplicateIdentifierException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4961201589224567621L;
	
	private final Identifiable duplicate;
	
	/**
	 * Minimal constructor.
	 * @param duplicate The {@link Identifiable} object that already exists.
	 */
	public DuplicateIdentifierException(Identifiable duplicate){
		this.duplicate = duplicate;
	}
	
	/**
	 * Gets the object that has existed first with the given identifier.
	 * @return The duplicate {@link Identifiable} object.
	 */
	public Identifiable getDuplicate(){
		return duplicate;
	}

}
