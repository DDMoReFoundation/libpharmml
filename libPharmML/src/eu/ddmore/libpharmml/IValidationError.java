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
package eu.ddmore.libpharmml;


public interface IValidationError {

	/**
	 * Gets the rule identifier of the error.
	 * 
	 * <p>If the identifier is "SCHEMA", the errors come from the schema-based validation, generally meaning 
	 * that a required value is missing. Otherwise, the identifier refers to thr list of rules from the PharmML
	 * specification. Please refer to this document for an explanation of each rule.
	 * @return The rule identifier as a {@link String}.
	 */
	String getRuleId();
	
	/**
	 * Gets the message of the error. The message is either the one from the schema validation directly, or
	 * an explanation if the error comes from a rule that is defined in the PharmML specification.
	 * @return The message error as {@link String}.
	 */
	String getErrorMsg();
	
	/**
	 * Gets the object that is concerned by the validation error. If the error is schema-based,
	 * it returns null.
	 * @return The invalid object.
	 */
	Object getInvalidObject();
	
	/**
	 * Gets the line number of the error if available.
	 * @return The line number as {@link Integer}, or null if not available.
	 */
	Integer getLineNumber();
	
}
