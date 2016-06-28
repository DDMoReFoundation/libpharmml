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
package eu.ddmore.libpharmml.dom.tags;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.PharmMLNode;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;
import eu.ddmore.libpharmml.validation.PharmMLValidator;
import eu.ddmore.libpharmml.validation.SymbolResolver;

/**
 * Interface implemented by object that contain references to other elements in
 * the model, like {@link OidRef}. As validation needs to know the name of the 
 * element rather than the class, the validation process is performed within
 * the implementing class and partially within the {@link PharmMLValidator}
 * class.
 */
public interface ReferenceContainer extends PharmMLNode {
	
	/**
	 * Attempt to validate the references within this object.
	 * @param sr The {@link SymbolResolver} built from the current DOM.
	 * @param errorHandler {@link IErrorHandler} to catch any potential error.
	 */
	public void validateReferences(SymbolResolver sr, IErrorHandler errorHandler);

}
