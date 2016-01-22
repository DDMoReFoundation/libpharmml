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
package eu.ddmore.libpharmml.impl;

import javax.xml.bind.ValidationEventLocator;

import eu.ddmore.libpharmml.IValidationError;
import eu.ddmore.libpharmml.dom.AbstractTreeNode;

public class ValidationErrorImpl implements IValidationError {
	private final String ruleId;
	private final String msg;
	private final AbstractTreeNode invalidObject;
	private final Integer lineNumber;
	
	public ValidationErrorImpl(String ruleId, String msg){
		this.ruleId = ruleId;
		this.msg = msg;
		this.invalidObject = null;
		this.lineNumber = null;
	}
	
	public ValidationErrorImpl(String ruleId, String msg, ValidationEventLocator locator){
		this.ruleId = ruleId;
		this.msg = msg;
		this.invalidObject = null;
		this.lineNumber = locator.getLineNumber();
	}
	
	public ValidationErrorImpl(String ruleId, String msg, AbstractTreeNode invalidObject) {
		this.ruleId = ruleId;
		this.msg = msg;
		this.invalidObject = invalidObject;
		this.lineNumber = null;
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
	public AbstractTreeNode getInvalidObject() {
		return this.invalidObject;
	};

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
		if(invalidObject != null){
			return "ValidationErrorImpl [ruleId=" + ruleId + ", msg=\"" + msg + "\", object="+invalidObject+"]";
		} else if(lineNumber != null){
			return "ValidationErrorImpl [ruleId=" + ruleId + ", msg=\"" + msg + "\", line="+lineNumber+"]";
		} else {
			return "ValidationErrorImpl [ruleId=" + ruleId + ", msg=\"" + msg + "\"]";
		}
	}

	@Override
	public Integer getLineNumber() {
		return lineNumber;
	}

}
