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

import eu.ddmore.libpharmml.IValidationError;

public class ValidationErrorImpl implements IValidationError {
	private final String ruleId;
	private final String msg;
	
	public ValidationErrorImpl(String ruleId, String msg){
		this.ruleId = ruleId;
		this.msg = msg;
	}
	
	@Override
	public String getRuleId() {
		return this.ruleId;
	}

	@Override
	public String getErrorMsg() {
		return this.msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((ruleId == null) ? 0 : ruleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationErrorImpl other = (ValidationErrorImpl) obj;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (ruleId == null) {
			if (other.ruleId != null)
				return false;
		} else if (!ruleId.equals(other.ruleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ValidationErrorImpl [ruleId=" + ruleId + ", msg=" + msg + "]";
	}

}
