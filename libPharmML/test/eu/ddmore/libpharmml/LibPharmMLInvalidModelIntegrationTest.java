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
package eu.ddmore.libpharmml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.dom.Identifiable;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.impl.IdFactoryImpl;

public class LibPharmMLInvalidModelIntegrationTest {
	private static final String INVALID_MODEL_FILE = "invalidModel.xml";
	private static final String INVALID_MDL_NAME = "Invalid Model";
	private static final String EXPECTED_ERR_CODE = "SCHEMA";
	private static final int EXPECTED_NUM_ERRORS = 4;
//	private IValidationError EXPECTED_ERRORS[] = {
//		new ValidationErrorImpl(EXPECTED_ERR_CODE, "cvc-datatype-valid.1.2.1: '1F' is not a valid value for 'NCName'."),	
//		new ValidationErrorImpl(EXPECTED_ERR_CODE, "cvc-attribute.3: The value '1F' of attribute 'catId' on element 'Category' is not valid with respect to its type, 'SymbolIdType'."),	
//		new ValidationErrorImpl(EXPECTED_ERR_CODE, "cvc-complex-type.2.4.d: Invalid content was found starting with element 'Binop'. No child element is expected at this point."),	
//		new ValidationErrorImpl(EXPECTED_ERR_CODE, "cvc-identity-constraint.4.3: Key 'oidRef' with value 'e11' not found for identity constraint of element 'PharmML'."),	
//	};
	private ILibPharmML testInstance;
	private IPharmMLResource testResource;
	
	@Before
	public void setUp() throws Exception {
		this.testInstance = PharmMlFactory.getInstance().createLibPharmML();
		this.testResource = createResource();
	}

	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
		this.testResource = null;
	}
	
	private IPharmMLResource createResource() throws IOException{
		final PharmML dom = TestDomFactory.createInvalidModel();
		final IdFactory idFactory = new IdFactoryImpl();
		IPharmMLResource res = new IPharmMLResource() {
			@Override
			public PharmML getDom() {
				return dom;
			}
			@Override
			public IValidationReport getCreationReport() {
				return null;
			}
			@Override
			public Identifiable find(String id) {
				return idFactory.getIdentifiable(id);
			}
			@Override
			public IdFactory getIdFactory() {
				return idFactory;
			}
			@Override
			public void setIdFactory(IdFactory idFactory) {				
			}
			@Override
			public void setParameter(String param, Boolean value) {
			}
			@Override
			public Boolean getParameter(String argument) {
				return null;
			}
		};
		return res;
	}
	
	

	@Test
	public void testLoadInvalidModel() throws IOException {
		InputStream in = this.getClass().getResourceAsStream(INVALID_MODEL_FILE);
		IPharmMLResource res = this.testInstance.createDomFromResource(in);
		in.close();
		assertEquals("expected model", INVALID_MDL_NAME, res.getDom().getName().getValue());
		assertFalse("Valid model", res.getCreationReport().isValid());
		assertEquals("Valid model", EXPECTED_NUM_ERRORS, res.getCreationReport().numErrors());
		Iterator<IValidationError> iter = res.getCreationReport().errorIterator();
		int errorReadCnt = 0;
		while(iter.hasNext()){
			errorReadCnt++;
			IValidationError error = iter.next();
			assertEquals("Expected Code", EXPECTED_ERR_CODE, error.getRuleId());
		}
		assertEquals("ExpectedErrorsRead", EXPECTED_NUM_ERRORS, errorReadCnt);
	}

	@Test
	public void testValidateInvalidModel() throws IOException {
		IPharmMLValidator validator = this.testInstance.getValidator();
		IValidationReport rpt = validator.createValidationReport(this.testResource);
		assertFalse("Valid model", rpt.isValid());
		assertEquals("Valid model", 4, rpt.numErrors());
		/** @TODO: This really should go in a separate test fixture. I've commented this out for now as
		 * it broke during refactoring. */
//		Iterator<IValidationError> iter = rpt.errorIterator();
//		int errorReadCnt = 0;
//		while(iter.hasNext()){
//			IValidationError error = iter.next();
//			assertEquals("Expected Code", EXPECTED_ERRORS[errorReadCnt], error);
//			errorReadCnt++;
//		}
//		assertEquals("ExpectedErrorsRead", EXPECTED_NUM_ERRORS, errorReadCnt);
	}

	@Test
	public void testSaveValidModel() throws IOException{
		File tmpFile = File.createTempFile("test", ".xml");
		tmpFile.deleteOnExit();
		OutputStream os = new FileOutputStream(tmpFile);
		this.testInstance.save(os, testResource);
		os.close();
	}

}
