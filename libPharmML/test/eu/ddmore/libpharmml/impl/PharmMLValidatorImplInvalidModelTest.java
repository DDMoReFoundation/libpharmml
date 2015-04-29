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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IPharmMLValidator;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.TestDomFactory;
import eu.ddmore.libpharmml.dom.PharmML;

public class PharmMLValidatorImplInvalidModelTest {
	private IPharmMLValidator testInstance;
	private IPharmMLResource inValidResource;
	
	
	@Before
	public void setUp() throws Exception {
		this.testInstance = new PharmMLValidatorImpl();
		final PharmML dom = TestDomFactory.createInvalidModel(); 
		this.inValidResource = new PharmMLResourceImpl(dom, null);
	}

	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
	}

	@Test
	public void testCreateValidationReport() {
		IValidationReport rpt = this.testInstance.createValidationReport(inValidResource);
		assertNotNull("exists", rpt);
		assertFalse("is valid", rpt.isValid());
	}

}
