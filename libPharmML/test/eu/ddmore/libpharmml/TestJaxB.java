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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.xerces.util.XMLCatalogResolver;
import org.xml.sax.SAXException;

import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.modeldefn.ModelDefinitionType;
import eu.ddmore.libpharmml.impl.PharmMLVersion;

public class TestJaxB {

	public void writeOut() throws JAXBException, IOException, SAXException{
		PharmML dom = createStub();
		JAXBContext context = JAXBContext.newInstance(dom.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(dom, new FileOutputStream("test_output.xml"));
	}
	
	private PharmML createStub(){
		eu.ddmore.libpharmml.dom.ObjectFactory fact = new eu.ddmore.libpharmml.dom.ObjectFactory();
		PharmML dom = fact.createPharmML();
		eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory mdefnFact = new eu.ddmore.libpharmml.dom.modeldefn.ObjectFactory();
		ModelDefinitionType mdt = mdefnFact.createModelDefinitionType();
		mdefnFact.createModelDefinition(mdt);
		dom.setModelDefinition(mdt);
		return dom;
	}
	
	public void validateDom() throws IOException, JAXBException, SAXException{
		PharmML dom = createStub();
		JAXBContext jc = JAXBContext.newInstance(PharmML.class);
		JAXBSource source = new JAXBSource(jc, dom);
	 
		String[] catalogs = {
                "schemas/xmlCatalog.xml"    
        };
        XMLCatalogResolver resolver = new XMLCatalogResolver();
        resolver.setCatalogList(catalogs);
        String val = resolver.resolveSystem("http://www.pharmml.org/2013/03/PharmML");
        StreamSource src = new StreamSource(val);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		sf.setResourceResolver(resolver);
		Schema schema = sf.newSchema(new StreamSource[]{src});
	 
	    Validator validator = schema.newValidator();
	    validator.setErrorHandler(new TestErrorHandler());
	    validator.validate(source);
	}
	
	
	private PharmML readIn() throws JAXBException, IOException, SAXException {
		String[] catalogs = {
                "schemas/xmlCatalog.xml"    
        };
        XMLCatalogResolver resolver = new XMLCatalogResolver();
        resolver.setCatalogList(catalogs);
        String val = resolver.resolveSystem("http://www.pharmml.org/2013/03/PharmML");
        StreamSource src = new StreamSource(val);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		sf.setResourceResolver(resolver);
		Schema mySchema = sf.newSchema(new StreamSource[]{src});
		InputStream is = new FileInputStream(new File(PharmMLVersionFactory.getExampleDir(PharmMLVersion.DEFAULT)+"/example1.xml"));
		String packageName = PharmML.class.getPackage().getName();
		JAXBContext context = JAXBContext.newInstance(packageName);
		Unmarshaller u = context.createUnmarshaller();
		u.setSchema(mySchema);
		PharmML doc = (PharmML)u.unmarshal(is);
		return doc;
	}

	public static void main(String[] args) throws JAXBException, IOException, SAXException {
		TestJaxB test = new TestJaxB();
		test.writeOut();
		test.readIn();
		test.validateDom();
	}
}
