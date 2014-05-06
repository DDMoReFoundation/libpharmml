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

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IPharmMLValidator;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.dom.PharmML;

public class PharmMLValidatorImpl implements IPharmMLValidator {
	private static final String CONTEXT_NAME = Messages.getString("MarshallerImpl.contextDefn"); //$NON-NLS-1$

	@Override
	public IValidationReport createValidationReport(IPharmMLResource resource) {
		try{
			PharmML dom = resource.getDom();
			
			String writtenVersion = dom.getWrittenVersion();
			PharmMLVersion docVersion = null;
			if(writtenVersion != null){
				docVersion = PharmMLVersion.getEnum(writtenVersion);
			}
			if(docVersion == null){
				docVersion = PharmMLVersion.DEFAULT;
				LoggerWrapper.getLogger().warning("Missing or unknown writtenVersion of PharmML document. Using default version ("+docVersion.getValue()+").");
			}

			JAXBContext jc = JAXBContext.newInstance(CONTEXT_NAME);
			JAXBSource source = new JAXBSource(jc, dom);
	 
			Schema schema = PharmMLSchemaFactory.getInstance().createPharmMlSchema(docVersion);
			Validator validator = schema.newValidator();
			final ValidationReportFactory rptFact = new ValidationReportFactory();
			validator.setErrorHandler(new ErrorHandler() {
				
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					rptFact.handleWarning(exception.getMessage());
				}
				
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					rptFact.handleError(exception.getMessage());
				}
				
				@Override
				public void error(SAXParseException exception) throws SAXException {
					rptFact.handleError(exception.getMessage());
				}
			});
			validator.validate(source);
			return rptFact.createReport();
		}
		catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage(), e);
        } catch (SAXException e) {
			throw new RuntimeException(e.getMessage(), e);
        }
	}

}
