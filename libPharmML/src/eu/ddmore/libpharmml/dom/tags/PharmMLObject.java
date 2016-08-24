/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
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
package eu.ddmore.libpharmml.dom.tags;

import eu.ddmore.libpharmml.dom.PharmMLNode;
import eu.ddmore.libpharmml.dom.commontypes.OidRef;

/**
 * Interface for all the PharmML elements thats can be identified as a
 * conceptual object. Those objects has a oid attribute, and can be
 * referred via a {@link OidRef} element.
 */
public interface PharmMLObject extends PharmMLNode {
	
	/**
     * Gets the value of the oid property. This property can be used to refer
     * to this object via a {@link OidRef} element. The context of the 
     * {@link OidRef} element must be compatible with the type of this object.
     * 
     * @see OidRef
     * 
     * @return
     *     The oid property as a {@link String}.
     *     
     */
    public String getOid();

    /**
     * Sets the value of the oid property. The value of this property must be
     * unique within the whole PharmML document.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value);

}
