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
package eu.ddmore.libpharmml.impl;

import java.util.Hashtable;
import java.util.Map;

import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.IdFactory;
import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.dom.PharmML;

public class PharmMLResourceImpl implements IPharmMLResource {
	
	private final PharmML dom;
	private final IValidationReport creationReport;
	private IdFactory idFactory;
	
	private final Map<String,Boolean> parameters;
	
	PharmMLResourceImpl(PharmML dom, IValidationReport creationReport, IdFactory idFactory) {
		this.dom = dom;
		this.creationReport = creationReport;
		this.idFactory = idFactory;
		
		// Options
		parameters = new Hashtable<String, Boolean>();
		parameters.put(IPharmMLResource.AUTOSET_ID, Boolean.TRUE);
	}

	@Override
	public PharmML getDom() {
		return dom;
	}

	@Override
	public IValidationReport getCreationReport() {
		return creationReport;
	}

	@Override
	public Identifiable find(String id) {
		if(idFactory != null){
			return idFactory.getIdentifiable(id);
		} else {
			return Utils.findById(dom, id);
		}
	}

	@Override
	public IdFactory getIdFactory() {
		return idFactory;
	}

	@Override
	public void setIdFactory(IdFactory idFactory) {
		this.idFactory = idFactory;
	}

	@Override
	public void setParameter(String param, Boolean value) {
		parameters.put(param, value);
	}

	@Override
	public Boolean getParameter(String argument) {
		return parameters.get(argument);
	}

}
