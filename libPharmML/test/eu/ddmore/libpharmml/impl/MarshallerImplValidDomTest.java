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
import static eu.ddmore.libpharmml.impl.LoggerWrapper.getLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import javax.xml.bind.ValidationEventLocator;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.PharmMLVersionFactory;
import eu.ddmore.libpharmml.TestDomFactory;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.commontypes.AbstractTreeNode;

@RunWith(Parameterized.class)
public class MarshallerImplValidDomTest{
	private static final String VALID_MODEL_FILE = "example1.xml";
	private String exampleDir;
	private MarshallerImpl testInstance;
	private PharmML validDom;
	protected boolean warningOccurred;
	protected boolean errorOccurred;
	private PharmMLVersion version;

	public MarshallerImplValidDomTest(PharmMLVersion version){
		this.testInstance = new MarshallerImpl();
		this.warningOccurred = false;
		this.errorOccurred = false;
		this.validDom = TestDomFactory.createValidModel(version);
		this.exampleDir = PharmMLVersionFactory.getExampleDir(version);
		this.version = version;
	}
	
	@Parameters
	public static Collection<PharmMLVersion[]> parameters(){
		return PharmMLVersionFactory.getParameterizedVersions();
	}
	
//	@Before
//	public void setUp() throws Exception {
//		this.testInstance = new MarshallerImpl();
//		this.warningOccurred = false;
//		this.errorOccurred = false;
//		validDom = TestDomFactory.createValidModel(PharmMLVersion.V0_2_1); 
//	}

	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
		this.validDom = null;
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
		this.testInstance.marshall(validDom, os);
		assertFalse("No error reported", errorOccurred);
		assertFalse("No warning reported", warningOccurred);
		tmpFile.deleteOnExit();
	}

	@Test
	public void testUnmarshall() throws IOException {
		InputStream is = new FileInputStream(exampleDir+"/"+VALID_MODEL_FILE);
		IErrorHandler errorHandler = new IErrorHandler() {
			@Override
			public void handleWarning(String warnMsg) {
				getLogger().severe(warnMsg);
				warningOccurred = true;
			}
			@Override
			public void handleError(String errMsg) {
				getLogger().severe(errMsg);
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
		};
		this.testInstance.setErrorHandler(errorHandler);
		PharmML dom = this.testInstance.unmarshall(is,version,new UnmarshalListener(version, new IdFactoryImpl(),errorHandler));
		assertFalse("No errors reported", errorOccurred);
		assertNotNull("dom created", dom);
	}

}
