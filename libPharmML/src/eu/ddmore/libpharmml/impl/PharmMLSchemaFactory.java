/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 * 
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 * 
 *  		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 ******************************************************************************/
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
	
	public enum NamespaceType {
		DEFAULT,
		OLD;
	}
	
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
	public Schema createPharmMlSchema(PharmMLVersion version, NamespaceType type){
		try {
			String[] locationData = resolveCatalogLocation(version, type);
			String catalogLocation = locationData[0];
			String systemURI = locationData[1];
			URL url = getClass().getResource(catalogLocation);
			String[] catalogs = { url.toExternalForm() };
			XMLCatalogResolver resolver = new XMLCatalogResolver();
			resolver.setCatalogList(catalogs);

			String val = resolver.resolveSystem(systemURI); 
			StreamSource src = new StreamSource(val);
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			sf.setResourceResolver(resolver);
			Schema mySchema;
			try {
				mySchema = sf.newSchema(new StreamSource[] { src });
			} catch (SAXException e) {
				LoggerWrapper.getLogger().severe("Could not find "+type+" schemas for version "+version.getValue());
				LoggerWrapper.getLogger().info("-src: "+src+" -catalogs: "+catalogs+ " -url: "+url+ " -catalogLocation: "+catalogLocation+" -systemURI: "+systemURI);
				throw new RuntimeException(e.getMessage(), e);
			}

			return mySchema;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
//		} catch (SAXException e) {
//			LoggerWrapper.getLogger().severe("Could not find "+type+" schemas for version "+version.getValue());
//			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Gets the right catalog location and system URI for the given PharmML version
	 * and the given namespace type.
	 * @param version The {@link PharmMLVersion} enum value.
	 * @param type {@link NamespaceType} enum value.
	 * @return An array of {@link String}, where the 1st value is the catalog location
	 * and the 2nd value is the system URI.
	 */
	public String[] resolveCatalogLocation(PharmMLVersion version, NamespaceType type){
		String catalogLocation;
		String systemURI;
		if(version.isEqualOrLaterThan(PharmMLVersion.V0_6)){ //FIXME: implement a better way to handle schemas and namespaces
			catalogLocation = version.getCatalogLocation();
			systemURI = XMLFilter.NS_DEFAULT_MML;
		} else {
			if(type.equals(NamespaceType.DEFAULT)){
				catalogLocation = version.getDefaultCatalogLocation();
				systemURI = XMLFilter.NS_DEFAULT_MML;
			} else {
				catalogLocation = version.getCatalogLocation();
				systemURI = new XMLFilter(version).getMMLNamespaceURI();
			}
		}
		return new String[] {catalogLocation, systemURI};
	}
	
	/**
	 * @deprecated
	 * Since version 0.3, libPharmML handles multiple versions of PharmML schemas. Replaced by {@link #createPharmMlSchema(PharmMLVersion, NamespaceType)}.
	 * @return
	 * 		{@link Schema} for version 0.2 of PharmML
	 */
	@Deprecated
	public Schema createPharmMlSchema(){
		return createPharmMlSchema(PharmMLVersion.V0_2_1,NamespaceType.DEFAULT);
	}
	
}
