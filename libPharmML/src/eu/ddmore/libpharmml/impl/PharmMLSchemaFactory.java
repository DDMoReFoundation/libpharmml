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

import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.xerces.util.XMLCatalogResolver;
import org.xml.sax.SAXException;

public class PharmMLSchemaFactory {
	private static PharmMLSchemaFactory anInstance = null;

//	private static final String DEFINITIONS_XML_CATALOG_XML = Messages.getString("MarshallerImpl.xmlCatalogLocation"); //$NON-NLS-1$
//	private static final String PHARML_URI = Messages.getString("MarshallerImpl.PharmMLURI");
	
	
	public static PharmMLSchemaFactory getInstance(){
		if(anInstance == null){
			anInstance = new PharmMLSchemaFactory();
		}
		return anInstance;
	}
	
	/**
	 * Creates schema instance for given PharmML version.
	 * @param version the version of the schema
	 * @return 		a {@link Schema} instance of PharmML
	 */
	public Schema createPharmMlSchema(PharmMLVersion version){
		try {
			URL url = getClass().getResource(version.getCatalogLocation());
			String[] catalogs = { url.toExternalForm() };
			XMLCatalogResolver resolver = new XMLCatalogResolver();
			resolver.setCatalogList(catalogs);
			XMLFilter filter = new XMLFilter(version);
			String val = resolver.resolveSystem(filter.NS_DOC_MML); 
			StreamSource src = new StreamSource(val);
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			sf.setResourceResolver(resolver);
			Schema mySchema = sf.newSchema(new StreamSource[] { src });

			return mySchema;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (SAXException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * @deprecated
	 * Since version 0.3, libPharmML handles multiple versions of PharmML schemas. Replaced by {@link #createPharmMlSchema(PharmMLVersion)}.
	 * @return
	 * 		{@link Schema} for version 0.2 of PharmML
	 */
	@Deprecated
	public Schema createPharmMlSchema(){
		return createPharmMlSchema(PharmMLVersion.V0_2_1);
	}
	
}
