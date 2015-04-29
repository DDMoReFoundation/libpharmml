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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import eu.ddmore.libpharmml.ILibPharmML;
import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IPharmMLValidator;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.PharmMLVersionFactory;
import eu.ddmore.libpharmml.TestDomFactory;

@RunWith(Parameterized.class)
public class LibPharmMLImplTest {
	private ILibPharmML testInstance;
	private IPharmMLResource validResource;
	private IPharmMLResource invalidResource;
	private IPharmMLValidator validator;
	private PharmMLVersion version;

	public LibPharmMLImplTest(final PharmMLVersion version){
		this.testInstance = new LibPharmMLImpl();
		this.validator = new PharmMLValidatorImpl();
		this.testInstance.setValidator(validator);
		this.testInstance.setMarshaller(new MarshallerImpl());
		this.version = version;
		final ValidationReportFactory rptFact = new ValidationReportFactory();
		this.validResource = new PharmMLResourceImpl(
				TestDomFactory.createValidModel(version), rptFact.createReport(), new IdFactoryImpl());
		this.invalidResource = new PharmMLResourceImpl(
				TestDomFactory.createInvalidModel(), rptFact.createReport(), new IdFactoryImpl());
	}
	
	@Parameters
	public static Collection<PharmMLVersion[]> parameters(){
		return PharmMLVersionFactory.getParameterizedVersions();
	}

	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
		this.validResource = null;
	}

	@Test
	public void testSave() throws IOException, SAXException, ParserConfigurationException {
		File tmpFile = File.createTempFile("tst", "xml");
		tmpFile.deleteOnExit();
		OutputStream os = new FileOutputStream(tmpFile);
		this.testInstance.save(os, validResource);
		os.close();
		assertTrue("Valid doc", checkFileIsValid(tmpFile));
	}

	@Test
	public void testInvalidSave() throws IOException, SAXException, ParserConfigurationException {
		File tmpFile = File.createTempFile("tst", "xml");
		tmpFile.deleteOnExit();
		OutputStream os = new FileOutputStream(tmpFile);
		this.testInstance.save(os, invalidResource);
		os.close();
		assertFalse("Invalid doc", checkFileIsValid(tmpFile));
	}

	private boolean checkFileIsValid(File tmpFile) throws IOException, SAXException, ParserConfigurationException {
		Schema s = PharmMLSchemaFactory.getInstance().createPharmMlSchema(version);
		Validator v = s.newValidator();
		StreamSource instanceDocument = new StreamSource(tmpFile);
		ValidationErrorHander validnHandler = new ValidationErrorHander();
		v.setErrorHandler(validnHandler);
		v.validate(instanceDocument);
		return validnHandler.isValid();
	}

	@Test
	public void testCreateDomFromResource() {
		IPharmMLResource res = this.testInstance.createDom(version);
		assertNotNull("exists", res);
		assertNotNull("dom exists", res.getDom());
		assertNotNull("rept exists", res.getCreationReport());
		assertNotNull("valid rpt", res.getCreationReport().isValid());
		// the above may be hard coded so we'll check to make sure.
		IValidationReport rpt = this.validator.createValidationReport(res);
		assertTrue("stub dom is valid", rpt.isValid());
	}

	@Test
	public void testCreateDom() {
		IPharmMLResource res = this.testInstance.createDom(version);
		assertNotNull("exists", res);
		assertNotNull("dom exists", res.getDom());
		assertNotNull("rept exists", res.getCreationReport());
		assertNotNull("valid rpt", res.getCreationReport().isValid());
		// the above may be hard coded so we'll check to make sure.
		IValidationReport rpt = this.validator.createValidationReport(res);
		assertTrue("stub dom is valid", rpt.isValid());
	}

	public class ValidationErrorHander implements ErrorHandler {
		private boolean isValid = true;

		@Override
		public void warning(SAXParseException exception) throws SAXException {
		}

		@Override
		public void error(SAXParseException exception) throws SAXException {
			this.isValid = false;
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			this.isValid = false;
		}

		
		public boolean isValid(){
			return this.isValid;
		}
	}
}
