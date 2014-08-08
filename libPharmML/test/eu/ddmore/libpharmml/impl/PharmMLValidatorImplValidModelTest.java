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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import eu.ddmore.libpharmml.IPharmMLResource;
import eu.ddmore.libpharmml.IPharmMLValidator;
import eu.ddmore.libpharmml.IValidationReport;
import eu.ddmore.libpharmml.PharmMLVersionFactory;
import eu.ddmore.libpharmml.TestDomFactory;
import eu.ddmore.libpharmml.dom.PharmML;

@RunWith(Parameterized.class)
public class PharmMLValidatorImplValidModelTest {
	private IPharmMLValidator testInstance;
	private IPharmMLResource validResource;
	
	
	public PharmMLValidatorImplValidModelTest(PharmMLVersion version){
		this.testInstance = new PharmMLValidatorImpl();
		final PharmML dom = TestDomFactory.createValidModel(version); 
		this.validResource = new IPharmMLResource() {
			
			@Override
			public PharmML getDom() {
				return dom;
			}
			
			@Override
			public IValidationReport getCreationReport() {
				return null;
			}
		};
	}
	
	@Parameters
	public static Collection<PharmMLVersion[]> parameters(){
		return PharmMLVersionFactory.getParameterizedVersions();
	}

	@After
	public void tearDown() throws Exception {
		this.testInstance = null;
	}

	@Test
	public void testCreateValidationReport() {
		IValidationReport rpt = this.testInstance.createValidationReport(validResource);
		assertNotNull("exists", rpt);
		assertTrue("is valid", rpt.isValid());
	}

}
