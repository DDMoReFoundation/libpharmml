/*******************************************************************************
 * Copyright (c) 2013 European Molecular Biology Laboratory,
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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

@RunWith(Parameterized.class)
public class LibPharmMLValidIntegrationTest {
	private static final String VALID_MODEL_FILE = "example4.xml";
	private String exampleDir;
	private static final String VALID_MDL_NAME = "Example 4 - estimation with IOV1 and with covariates";
	private ILibPharmML testInstance;
	private IPharmMLResource testResource;
	
	public LibPharmMLValidIntegrationTest(PharmMLVersion version) throws IOException {
		this.testInstance = PharmMlFactory.getInstance().createLibPharmML();
		this.testResource = createValidResource(version);
		this.exampleDir = PharmMLVersionFactory.getExampleDir(version);
	}
	
	@Parameters
	public static Collection<PharmMLVersion[]> parameters(){
		return PharmMLVersionFactory.getParameterizedVersions();
	}

	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
		this.testResource = null;
	}

	private IPharmMLResource createValidResource(PharmMLVersion version) throws IOException{
		final PharmML dom = TestDomFactory.createValidModel(version);
		final List<IValidationError> errList = Collections.emptyList();
		IPharmMLResource res = new IPharmMLResource() {
			@Override
			public PharmML getDom() {
				return dom;
			}
			@Override
			public IValidationReport getCreationReport() {
				return new IValidationReport() {
					@Override
					public int numErrors() {
						return errList.size();
					}
					@Override
					public boolean isValid() {
						return errList.isEmpty();
					}
					@Override
					public IValidationError getError(int errNum) {
						return errList.get(errNum-1);
					}
					@Override
					public Iterator<IValidationError> errorIterator() {
						return errList.iterator();
					}
				};
			}
		};
		return res;
	}
	
	
	@Test
	public void testLoadValidModel() throws IOException {
		InputStream in = new FileInputStream(exampleDir+"/"+VALID_MODEL_FILE);
		IPharmMLResource res = this.testInstance.createDomFromResource(in);
		in.close();
		assertEquals("expected model", VALID_MDL_NAME, res.getDom().getName().getValue());
		assertTrue("Valid model", res.getCreationReport().isValid());
		assertEquals("Valid model", 0, res.getCreationReport().numErrors());
	}

	@Test
	public void testValidateValidModel() throws IOException{
		IPharmMLValidator validator = this.testInstance.getValidator();
		IValidationReport rpt = validator.createValidationReport(testResource);
		assertTrue("Valid model", rpt.isValid());
		assertEquals("Valid model", 0, rpt.numErrors());
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
