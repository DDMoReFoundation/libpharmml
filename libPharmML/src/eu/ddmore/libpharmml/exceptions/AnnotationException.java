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
package eu.ddmore.libpharmml.exceptions;

public class AnnotationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3294003744250401849L;
	private String message;
	
	public AnnotationException(Object o, String message){
		this.message = "Element "+o+ " has an incorrect annotation: "+message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
}
