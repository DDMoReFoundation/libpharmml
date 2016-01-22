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
package eu.ddmore.libpharmml.validation;

import eu.ddmore.libpharmml.IErrorHandler;

/**
 * Interface implemented by each validatable element.
 * 
 * During the validation process, the DOM tree is browsed. If a node implements this
 * interface, then the method {@link #validate(IErrorHandler)} is executed.
 * 
 * @author F. Yvon
 *
 */
public interface Validatable {

	/**
	 * Tries to validate the current element following the PharmML specification. 
	 * Each validation error is handled by the given {@link IErrorHandler} implementation.
	 * @param errorHandler An implementation of {@link IErrorHandler}.
	 */
	void validate(IErrorHandler errorHandler);
	
}
