/*******************************************************************************
 * Copyright (c) 2013, 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
package eu.ddmore.libpharmml;

import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;

public interface IPharmMLResource {

	/**
	 * Gets the Domain Object Model of the PharmML resource.
	 * @return The DOM as a {@link PharmML} root element.
	 */
	PharmML getDom();
	
	/**
	 * Gets the creation report of the PharmML resource. This report contains the potential
	 * errors in the PharmML document before the unmarshalling process. This means that elements
	 * that are not unmarshalled into the DOM because of the lack of mapped Java class (i.e. unknown
	 * in the schema definitions) will be highlighted within this report.
	 * @return
	 */
	IValidationReport getCreationReport();
	
	/**
	 * Browses the whole DOM tree of this PharmML resource and tries to find the element
	 * with the provided identifier. The identifier corresponds to the "id" attribute,
	 * accessible though {@link PharmMLRootType#getId()}. If the searched id is duplicated,
	 * only the first occurence will be returned. The validity of the PharmML resource should
	 * be checked before.
	 * @param id The identifier of the wanted element.
	 * @return The object that matches the provided id. Returns <b>null</b> if the provided id is not 
	 * found.
	 */
	Object find(String id);
	
	/**
	 * Gets the id factory that is used by this resource.
	 * @return An {@link IdFactory} implementation.
	 */
	IdFactory getIdFactory();
	
	/**
	 * Sets the id factory used by this resource.
	 * @param idFactory An {@link IdFactory} implementation.
	 */
	void setIdFactory(IdFactory idFactory);
	
}
