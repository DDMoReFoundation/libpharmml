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
package eu.ddmore.libpharmml.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.IValidationError;
import eu.ddmore.libpharmml.IValidationReport;

public class ValidationReportFactory implements IErrorHandler {
	private static final String SCHEMA_ERR_CODE = "SCHEMA";

	private final List<IValidationError> errors;
	
	public ValidationReportFactory(){
		this.errors = new ArrayList<IValidationError>();
	}
	
	@Override
	public void handleWarning(String exception)  {
	}

	@Override
	public void handleError(String exception) {
		this.errors.add(new ValidationErrorImpl(SCHEMA_ERR_CODE, exception));			
	}

	public IValidationReport createReport(){
		return new IValidationReport() {
			
			@Override
			public int numErrors() {
				return errors.size();
			}
			
			@Override
			public boolean isValid() {
				return errors.isEmpty();
			}
			
			@Override
			public IValidationError getError(int errNum) {
				return errors.get(errNum-1);
			}
			
			@Override
			public Iterator<IValidationError> errorIterator() {
				return errors.iterator();
			}
		};
	}
	
	public boolean addError(IValidationError error){
		return errors.add(error);
	}

}
