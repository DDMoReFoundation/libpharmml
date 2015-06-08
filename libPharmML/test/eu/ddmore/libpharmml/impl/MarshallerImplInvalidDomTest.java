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
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.ValidationEventLocator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.TestDomFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.AbstractTreeNode;

public class MarshallerImplInvalidDomTest {
	private static final String INVALID_MODEL_FILE = "invalidModel.xml";
	private MarshallerImpl testInstance;
	private PharmML invalidDom;
	protected boolean warningOccurred;
	protected boolean errorOccurred;
	

	@Before
	public void setUp() throws Exception {
		this.testInstance = new MarshallerImpl();
		this.warningOccurred = false;
		this.errorOccurred = false;
		invalidDom = TestDomFactory.createInvalidModel(); 
	}

	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
		this.invalidDom = null;
	}

	@Test
	public void testMarshall() throws IOException {
		File tmpFile = File.createTempFile("tst", "xml");
		OutputStream os = new FileOutputStream(tmpFile);
		this.testInstance.setErrorHandler(new IErrorHandler() {
			@Override
			public void handleWarning(String warnMsg) {
				warningOccurred = true;
			}
			@Override
			public void handleError(String errMsg) {
				errorOccurred = true;
			}
			@Override
			public void handleError(String id, String errMsg) {
				errorOccurred = true;
			}
			@Override
			public void handleError(String id, String errMsg, ValidationEventLocator locator) {
				errorOccurred = true;
			}
			@Override
			public void handleError(String id, String errMsg, AbstractTreeNode invalidObject) {
				errorOccurred = true;
			}
		});
		this.testInstance.marshall(invalidDom, os);
		assertFalse("No error reported", errorOccurred);
		assertFalse("No warning reported", warningOccurred);
		tmpFile.deleteOnExit();
	}

	@Test
	public void testUnmarshall() {
		InputStream is = this.getClass().getResourceAsStream(INVALID_MODEL_FILE);
		this.testInstance.setErrorHandler(new IErrorHandler() {
			@Override
			public void handleWarning(String warnMsg) {
				warningOccurred = true;
			}
			@Override
			public void handleError(String errMsg) {
				errorOccurred = true;
			}
			@Override
			public void handleError(String id, String errMsg) {
				errorOccurred = true;
			}
			@Override
			public void handleError(String id, String errMsg, ValidationEventLocator locator) {
				errorOccurred = true;
			}
			@Override
			public void handleError(String id, String errMsg, AbstractTreeNode invalidObject) {
				errorOccurred = true;
			}
		});
		PharmML dom = this.testInstance.unmarshall(is);
		assertTrue("Errors reported", errorOccurred);
		assertNotNull("dom created", dom);
	}

}
