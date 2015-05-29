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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.impl.IdFactoryImpl;
import eu.ddmore.libpharmml.impl.Messages;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.UnmarshalListener;
import eu.ddmore.libpharmml.impl.ValidationReportFactory;
import eu.ddmore.libpharmml.impl.XMLFilter;

public class TestDomFactory {
	private static final String CONTEXT_NAME = Messages.getString("MarshallerImpl.contextDefn"); //$NON-NLS-1$

	public static PharmML createInvalidModel(){
		eu.ddmore.libpharmml.dom.ObjectFactory fact = new eu.ddmore.libpharmml.dom.ObjectFactory();
		PharmML dom = fact.createPharmML();
		dom.setWrittenVersion(PharmMLVersion.DEFAULT.getValue());
		eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory mdefnFact = new eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory();
		ModelDefinition mdt = mdefnFact.createModelDefinitionType();
		StructuralModel stm = mdefnFact.createStructuralModelType();
		stm.setBlkId("main");
		mdt.getListOfStructuralModel().add(stm);
		mdefnFact.createModelDefinition(mdt);
		dom.setModelDefinition(mdt);
		return dom;
	}
	
	public static PharmML createValidModel(final PharmMLVersion version){
		// TODO: include schema validation
		try {
//			Schema mySchema = PharmMLSchemaFactory.getInstance().createPharmMlSchema(version);
			String exampleDir = PharmMLVersionFactory.getExampleDir(version);
			File file = new File(exampleDir+"/example1.xml");
		InputStream is = new FileInputStream(file);
//		String packageName = PharmML.class.getPackage().getName();
		JAXBContext context = JAXBContext.newInstance(CONTEXT_NAME);
		Unmarshaller u = context.createUnmarshaller();
//		u.setSchema(mySchema);
		// Store version info into each element
//		Listener listener = new Listener() {
//			@Override
//			public void beforeUnmarshal(Object target, Object parent) {
//				if(target instanceof PharmMLElement){
//					((PharmMLElement)target).setUnmarshalVersion(version);
//				}
//			}
//		};
		u.setListener(new UnmarshalListener(version, new IdFactoryImpl(), new ValidationReportFactory()));
		
		XMLStreamReader xmlsr = new XMLFilter(version).getXMLStreamReader(is);
		
		PharmML doc = (PharmML)u.unmarshal(xmlsr);
		return doc;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (JAXBException e) {
			throw new RuntimeException(e.getMessage(), e);
        } catch (XMLStreamException e) {
        	throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
