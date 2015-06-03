/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

import eu.ddmore.libpharmml.impl.PharmMLVersion;


/**
 * Abstract class for all XML-binded elements
 * @author F. Yvon
 * @since libPharmML 0.3
 */
@XmlTransient
public abstract class PharmMLElement extends AbstractTreeNode {
	
	@XmlTransient
    private PharmMLVersion unmarshalVersion = null;

	
	/**
	 * Each unmarshalled element has the version of PharmML that was used to encode the model.
	 * If the element has not been unmarshalled, this method returns null.
	 * @return the version on the PharmML document of which this element has been unmarshalled.
	 */
	@XmlTransient
	public final PharmMLVersion getUnmarshalVersion(){
    	return this.unmarshalVersion;
    }
    public final void setUnmarshalVersion(PharmMLVersion version){
    	this.unmarshalVersion = version;
    }
    
}
