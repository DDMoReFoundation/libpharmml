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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import eu.ddmore.libpharmml.IMarshaller;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IPharmMLValidator;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.impl.PharmMLSchemaFactory.NamespaceType;
import eu.ddmore.libpharmml.validation.PharmMLValidator;

public class PharmMLValidatorImpl implements IPharmMLValidator {
//	private static final String CONTEXT_NAME = Messages.getString("MarshallerImpl.contextDefn"); //$NON-NLS-1$

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

			// Marshalling into a byte array for validation
			// This step is necessary as it may need namespace transformation prior to
			// schema validation.
			
//			JAXBContext jc = JAXBContext.newInstance(CONTEXT_NAME);
//			JAXBSource source = new JAXBSource(jc, dom);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IMarshaller m = new MarshallerImpl();
			MarshalListener ml = new MarshalListener(docVersion, new IdFactoryImpl());
			ml.autosetId(false);
			m.marshall(dom, baos, ml);
			Source source = new StreamSource(new ByteArrayInputStream(baos.toByteArray()));
			
	 
			Schema schema = PharmMLSchemaFactory.getInstance().createPharmMlSchema(docVersion,NamespaceType.OLD);
			Validator schemaValidator = schema.newValidator();
			final ValidationReportFactory rptFact = new ValidationReportFactory();
			schemaValidator.setErrorHandler(new ErrorHandler() {
				
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					rptFact.handleWarning(exception.getMessage()+"["+exception.getLineNumber()+","+exception.getColumnNumber()+"].");
				}
				
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					rptFact.handleError(ValidationReportFactory.SCHEMA_ERR_CODE, exception.getMessage()+"["+exception.getLineNumber()+","+exception.getColumnNumber()+"].");
				}
				
				@Override
				public void error(SAXParseException exception) throws SAXException {
					rptFact.handleError(ValidationReportFactory.SCHEMA_ERR_CODE, exception.getMessage()+"["+exception.getLineNumber()+","+exception.getColumnNumber()+"].");
				}
			});
			schemaValidator.validate(source);
			
			// symbol resolution
			// TODO: re-enable symbol resolution. Need to be fixed
//			SymbolResolver resolver = new SymbolResolver(dom);
//			List<IValidationError> resolvErrors = resolver.resolveSymbols();
//			for(IValidationError error : resolvErrors){
//				rptFact.addError(error);
//			}
//			List<IValidationError> unicityErrors = resolver.checkUnicity();
//			for(IValidationError error : unicityErrors){
//				rptFact.addError(error);
//			}
			
			if(docVersion.isEqualOrLaterThan(PharmMLVersion.V0_6)){
				PharmMLValidator pharmmlValidator = new PharmMLValidator(dom);
				pharmmlValidator.validate(rptFact);
			} else {
				LoggerWrapper.getLogger().info("Version is below "+PharmMLVersion.V0_6+", no complex validation performed.");
			}
			
			
			return rptFact.createReport();
		}
		catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
//		} catch (JAXBException e) {
//			throw new RuntimeException(e.getMessage(), e);
        } catch (SAXException e) {
			throw new RuntimeException(e.getMessage(), e);
        }
	}

}
