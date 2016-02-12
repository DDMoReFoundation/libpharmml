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

import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.dom.PharmML;

public interface IPharmMLResource {
	
	/**
	 * Autosetting identifiers during marshalling. Default value is true.
	 */
	public final static String AUTOSET_ID = "pharmmlresource.param.autoset_id";
	
	/**
	 * Generates a description for the variables and parameters. Default value is false.
	 */
	public final static String DESCRIBE_VARIABLES = "pharmmlresource.param.describe_variables";

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
	 * @return The creation report as {@link IValidationReport} implementation.
	 */
	IValidationReport getCreationReport();
	
	/**
	 * Gets the element with the given identifier, i.e. the element which the value of the 
	 * id attribute matches the provided one. Can only be found the elements that are stored
	 * in the id factory of the resource. It means that elements needs to be either unmarshalled,
	 * marshalled or explicitely stored in the id factory in order to be found.
	 * 
	 * <p>The 3rd option can be achieved as follows:
	 * <pre>
	 * {@code
	 * identifiable.setId("i1");
	 * resource.getIdFactory().storeIdentifiable(identifiable);
	 * }
	 * </pre>
	 * 
	 * <p>If the id can't be found, this method returns null. If more than 1 element has the given id,
	 * the first occurence that was stored will be returned. Be careful to have a valid model while
	 * using this method.
	 * 
	 * <p>If the resource does not have any id factory, the DOM tree will be browsed entirely, which can
	 * be slow. This situation should never happen though.
	 * 
	 * @param id The identifier of the wanted element.
	 * @return The found element. null if it does not exist.
	 */
	Identifiable find(String id);
	
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
	
	/**
	 * Sets a value to the given parameter for this resource.
	 * @param param The parameter name.
	 * @param value The value as a {@link Boolean}.
	 */
	void setParameter(String param, Boolean value);
	
	/**
	 * Gets the value of the given parameter.
	 * @param argument The name of the argument.
	 * @return The value of the parameter as a {@link Boolean}.
	 */
	Boolean getParameter(String argument);
	
}
