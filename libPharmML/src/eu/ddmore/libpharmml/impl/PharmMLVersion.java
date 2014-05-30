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

public enum PharmMLVersion {
	/**
	 * PharmML 0.2.1
	 */
	V0_2_1("0.2.1","MarshallerImpl.xmlCatalogLocation.0.2.1"),
	/**
	 * PharmML 0.3
	 */
	V0_3("0.3","MarshallerImpl.xmlCatalogLocation.0.3"),
	/**
	 * PharmML 0.3.1
	 */
	V0_3_1("0.3.1","MarshallerImpl.xmlCatalogLocation.0.3.1");
	
	/**
	 * The latest version of PharmML. Current is 0.3.1.
	 */
	public static final PharmMLVersion DEFAULT = PharmMLVersion.V0_3_1;
	
	private String version;
	private String catalogLocation;
	
	private PharmMLVersion(String version,String catalogMessage) {
		this.version = version;
		this.catalogLocation = Messages.getString(catalogMessage);
	}
	
	public String getValue(){
		return version;
	}
	
	String getCatalogLocation(){
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
		} else {
			return null;
		}
	}
	
	@Override
	public String toString(){
		return getValue();
	}
	
}
