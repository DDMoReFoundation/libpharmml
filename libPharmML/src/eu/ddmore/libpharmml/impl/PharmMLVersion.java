/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
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
	V0_2_1("0.2.1","MarshallerImpl.xmlCatalogLocation.0.2.1",1),
	/**
	 * PharmML 0.3
	 */
	V0_3("0.3","MarshallerImpl.xmlCatalogLocation.0.3",2),
	/**
	 * PharmML 0.3.1
	 */
	V0_3_1("0.3.1","MarshallerImpl.xmlCatalogLocation.0.3.1",3),
	/**
	 * PharmML 0.4
	 */
	V0_4("0.4","MarshallerImpl.xmlCatalogLocation.0.4",4),
	/**
	 * PharmML 0.4.1
	 */
	V0_4_1("0.4.1","MarshallerImpl.xmlCatalogLocation.0.4.1",5),
	/**
	 * PharmML 0.5
	 */
	V0_5("0.5","MarshallerImpl.xmlCatalogLocation.0.5",6),
	/**
	 * PharmML 0.5.1
	 */
	V0_5_1("0.5.1","MarshallerImpl.xmlCatalogLocation.0.5.1",7);
	
	/**
	 * The latest version of PharmML. Current is 0.5.1.
	 */
	public static final PharmMLVersion DEFAULT = PharmMLVersion.V0_5_1;
	
	private String version;
	private String catalogLocation;
	private int index;
	
	private PharmMLVersion(String version,String catalogMessage,int index) {
		this.version = version;
		this.catalogLocation = Messages.getString(catalogMessage);
		this.index = index;
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
	 * Catalog location in the messages.properties file. This method should not be needed for
	 * the majority of times.
	 * @return Catalog location
	 */
	public String getCatalogLocation(){
		return catalogLocation;
	}
	
	/**
	 * Contruct a {@link PharmMLVersion} object based on the provided version as string.
	 * If the version does not exist, this method returns null.
	 * @param version the version as a string in "x.x(.x)" format.
	 */
	public static PharmMLVersion getEnum(String version){
		if(version.equals("0.2.1")){
			return PharmMLVersion.V0_2_1;
		} else if(version.equals("0.3")){
			return PharmMLVersion.V0_3;
		} else if(version.equals("0.3.1")){
			return PharmMLVersion.V0_3_1;
		} else if(version.equals("0.4")){
			return PharmMLVersion.V0_4;
		} else if(version.equals("0.4.1")){
			return PharmMLVersion.V0_4_1;
		} else if(version.equals("0.5")){
			return PharmMLVersion.V0_5;
		} else if(version.equals("0.5.1")){
			return PharmMLVersion.V0_5_1;
		} else {
			return null;
		}
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
