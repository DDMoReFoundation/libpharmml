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

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBElement;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IMarshaller;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IPharmMLValidator;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.Name;
import eu.ddmore.libpharmml.dom.commontypes.SymbolType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.ParameterModelType;
import eu.ddmore.libpharmml.dom.modeldefn.SimpleParameterType;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModelType;
import eu.ddmore.libpharmml.validation.PharmMLElementWrapper;

public class LibPharmMLImpl implements ILibPharmML {
	private static final String DEFAULT_NAME = "Stub Model";
//	private static final String WRITTEN_VERSION = "0.1";
//	private static final String DEFAULT_IND_VAR = "t";
	private static final String DEFAULT_STRUCT_MDL_NAME = "main";
	private IMarshaller marshaller;
	private IPharmMLValidator validator;

	@Override
	public void save(OutputStream opStr, IPharmMLResource resource) {
		// Set the correct written version that we are compliant with.
//		resource.getDom().setWrittenVersion(WRITTEN_VERSION);
		this.marshaller.marshall(resource.getDom(), opStr);
	}

	@Override
	public IPharmMLResource createDomFromResource(InputStream inStr) {
		final ValidationReportFactory repFact = new ValidationReportFactory();
		this.marshaller.setErrorHandler(repFact);
		final PharmML dom = this.marshaller.unmarshall(inStr);
		IPharmMLResource retVal = new IPharmMLResource() {
			@Override
			public PharmML getDom() {
				return dom;
			}
			@Override
			public IValidationReport getCreationReport() {
				return repFact.createReport();
			}
			@Override
			public Object find(String id) {
				PharmMLElementWrapper wrappedDom = new PharmMLElementWrapper(getDom());
				PharmMLElementWrapper foundWrappedEl = Utils.findById(wrappedDom, id);
				if(foundWrappedEl != null){
					return foundWrappedEl.getElement();
				} else {
					return null;
				}
			}
		};
		return retVal;
	}

	@Override
	@Deprecated
	public IPharmMLResource createDom() {
		return createDom(PharmMLVersion.DEFAULT);
	}
	
	@Override
	public IPharmMLResource createDom(PharmMLVersion version) {
		eu.ddmore.libpharmml.dom.ObjectFactory fact = new eu.ddmore.libpharmml.dom.ObjectFactory();
		eu.ddmore.libpharmml.dom.commontypes.ObjectFactory commonFact = new eu.ddmore.libpharmml.dom.commontypes.ObjectFactory();
		final PharmML dom = fact.createPharmML();
		dom.setWrittenVersion(version.getValue());
		Name name = commonFact.createNameType();
		name.setValue(DEFAULT_NAME);
		dom.setName(name);
		eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory mdefnFact = new eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory();
		ModelDefinition mdt = mdefnFact.createModelDefinitionType();
		ParameterModelType pm = mdefnFact.createParameterModelType();
		pm.setBlkId("p1");
		SimpleParameterType spt = mdefnFact.createSimpleParameterType();
		spt.setSymbId("a");
		JAXBElement<SimpleParameterType> param1 = mdefnFact.createSimpleParameter(spt);
		pm.getCommonParameterElement().add(param1);
		StructuralModelType structModel = mdefnFact.createStructuralModelType();
		structModel.setBlkId(DEFAULT_STRUCT_MDL_NAME);
		VariableDefinition varType = commonFact.createVariableDefinitionType();
		varType.setSymbId("x");
		varType.setSymbolType(SymbolType.REAL);
		JAXBElement<VariableDefinition> var1 = commonFact.createVariable(varType);
		structModel.getCommonVariable().add(var1);
		mdt.getParameterModel().add(pm);
		mdt.getStructuralModel().add(structModel);
		mdefnFact.createModelDefinition(mdt);
		dom.setModelDefinition(mdt);
		final ValidationReportFactory repFact = new ValidationReportFactory();
		return new IPharmMLResource() {
			
			@Override
			public PharmML getDom() {
				return dom;
			}
			
			@Override
			public IValidationReport getCreationReport() {
				return repFact.createReport();
			}
			
			@Override
			public Object find(String id) {
				PharmMLElementWrapper wrappedDom = new PharmMLElementWrapper(getDom());
				PharmMLElementWrapper foundWrappedEl = Utils.findById(wrappedDom, id);
				if(foundWrappedEl != null){
					return foundWrappedEl.getElement();
				} else {
					return null;
				}
			}
		};
	}

	@Override
	public void setValidator(IPharmMLValidator validator) {
		this.validator = validator;
	}

	@Override
	public IPharmMLValidator getValidator() {
		return this.validator;
	}

	@Override
	public void setMarshaller(IMarshaller marshaller) {
		this.marshaller = marshaller;
	}

	@Override
	public IMarshaller getMarshaller() {
		return this.marshaller;
	}

}
