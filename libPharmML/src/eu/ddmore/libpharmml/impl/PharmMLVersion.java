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

/**
 * Enum for handling various PharmML versions.
 * 
 * @author F. Yvon
 */
public enum PharmMLVersion {
	/**
	 * PharmML 0.2.1
	 */
	V0_2_1("0.2.1",null,"MarshallerImpl.xmlCatalogLocation.0.2.1",1),
	/**
	 * PharmML 0.3
	 */
	V0_3("0.3",null,"MarshallerImpl.xmlCatalogLocation.0.3",2),
	/**
	 * PharmML 0.3.1
	 */
	V0_3_1("0.3.1",null,"MarshallerImpl.xmlCatalogLocation.0.3.1",3),
	/**
	 * PharmML 0.4
	 */
	V0_4("0.4",null,"MarshallerImpl.xmlCatalogLocation.0.4",4),
	/**
	 * PharmML 0.4.1
	 */
	V0_4_1("0.4.1",null,"MarshallerImpl.xmlCatalogLocation.0.4.1",5),
	/**
	 * PharmML 0.5
	 */
	V0_5("0.5",null,"MarshallerImpl.xmlCatalogLocation.0.5",6),
	/**
	 * PharmML 0.5.1
	 */
	V0_5_1("0.5.1",null,"MarshallerImpl.xmlCatalogLocation.0.5.1",7),
	/**
	 * PharmML 0.6
	 */
	V0_6("0.6","0.6","MarshallerImpl.xmlCatalogLocation.0.6",8),
	
	/**
	 * PharmML 0.6.1
	 */
	V0_6_1("0.6.1","0.6","MarshallerImpl.xmlCatalogLocation.0.6",9),
	
	/**
	 * PharmML 0.7
	 */
	V0_7_1("0.7.1","0.7","MarshallerImpl.xmlCatalogLocation.0.7.1",10);
	
	/**
	 * The latest version of PharmML. Current is 0.7.1.
	 */
	public static final PharmMLVersion DEFAULT = PharmMLVersion.V0_7_1;
	
	private final String version;
	private final String uriVersion;
	private final String catalogLocation;
	private final int index;
//	private final String pharmml_URI;
	
	private PharmMLVersion(String version,String uriVersion,String catalogMessage,int index) {
		this.version = version;
		this.uriVersion = uriVersion;
		this.catalogLocation = Messages.getString(catalogMessage);
		this.index = index;
//		if(index >= 8){
//			this.pharmml_URI = String.format(XMLFilter.NS_PATTERN_PHARMML, version);
//		} else {
//			this.pharmml_URI = Messages.getString("MarshallerImpl.PharmMLURI.old");
//		}
	}
	
	/**
	 * Gets a string representation of the version. For instance, for the enum value V0_5, this method
	 * returns "0.5".
	 * @return The string representation of this version.
	 */
	public String getValue(){
		return version;
	}
	
	/**
	 * Gets the version written in PharmML namespace URIs. Usually only the 2 first digits on the full
	 * version number. For versions older than 0.6, this method returns null.
	 * @return A {@link String}.
	 */
	public String getURIVersion(){
		return uriVersion;
	}
	
	/**
	 * Catalog location in the messages.properties file. This method should not be needed for
	 * the majority of times.
	 * @return Catalog location
	 */
	public String getCatalogLocation(){
		return catalogLocation;
	}
	
	/**
	 * Gets the catalog location for the schemas that have the default namespaces, i.e. the last
	 * PharmML version.
	 * @return Catalog location
	 */
	public String getDefaultCatalogLocation(){
		return catalogLocation.replace("/xmlCatalog.xml", "/default/xmlCatalog.xml");
	}
	
//	public String getPharmmlURI(){
//		return pharmml_URI;
//	}
//	
	/**
	 * Contruct a {@link PharmMLVersion} object based on the provided version as string.
	 * If the version does not exist, this method returns null.
	 * @param version the version as a string in "x.x(.x)" format.
	 */
	public static PharmMLVersion getEnum(String version){
		for(PharmMLVersion enumVersion : values()){
			if(version.equals(enumVersion.getValue())){
				return enumVersion;
			}
		}
		return null;
	}
	
	/**
	 * Gets a string representation of this instance. This methods is equivalent to {@link #getValue()}.
	 */
	@Override
	public String toString(){
		return getValue();
	}
	
	/**
	 * Tests if this instantiated version equals or is later than the provided one.
	 * @param version The version that the instantiated one is compared to.
	 * @return true if this version is superior or equal to the argument, else false.
	 */
	public boolean isEqualOrLaterThan(PharmMLVersion version){
		return (this.index >= version.index);
	}
	
}
