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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

import eu.ddmore.libpharmml.dom.AbstractTreeNode;
import eu.ddmore.libpharmml.impl.PharmMLVersion;
import eu.ddmore.libpharmml.impl.XMLFilter;


/**
 * Abstract class for all PharmML-binded elements. Any XML element from PharmML must inherit from
 * this class.
 * @since libPharmML 0.3
 */
@XmlTransient
public abstract class PharmMLElement extends AbstractTreeNode {
	
	@XmlTransient
	protected static final String NS_DEFAULT_CT = XMLFilter.NS_DEFAULT_CT;
	@XmlTransient
	protected static final String NS_DEFAULT_DS = XMLFilter.NS_DEFAULT_DS;
	@XmlTransient
	protected static final String NS_DEFAULT_MATH = XMLFilter.NS_DEFAULT_MATH;
	@XmlTransient
	protected static final String NS_DEFAULT_MDEF = XMLFilter.NS_DEFAULT_MDEF;
	@XmlTransient
	protected static final String NS_DEFAULT_MML = XMLFilter.NS_DEFAULT_MML;
	@XmlTransient
	protected static final String NS_DEFAULT_MSTEPS = XMLFilter.NS_DEFAULT_MSTEPS;
	@XmlTransient
	protected static final String NS_DEFAULT_PROBONTO = XMLFilter.NS_DEFAULT_PROBONTO;
	@XmlTransient
	protected static final String NS_DEFAULT_TD = XMLFilter.NS_DEFAULT_TD;
	@XmlTransient
	protected static final String NS_DEFAULT_UNCERTML = XMLFilter.NS_DEFAULT_UNCERTML;
	
	@XmlTransient
    private PharmMLVersion unmarshalVersion = null;
	
	/**
	 * Marshal version may be used by adapters to dynamically change the name or namespace of some
	 * elements depending on the PharmML version.
	 */
	@XmlTransient
	private PharmMLVersion marshalVersion = null;
	
	/**
	 * Each unmarshalled element has the version of PharmML that was used to encode the model.
	 * If the element has not been unmarshalled, this method returns null.
	 * @return the version on the PharmML document of which this element has been unmarshalled.
	 */
	@XmlTransient
	public final PharmMLVersion getUnmarshalVersion(){
    	return this.unmarshalVersion;
    }
	
	/**
	 * Sets the PharmML version used in the model where this element comes from. This method is called
	 * during the unmarshalling process and should never be used by the client.
	 * @param version The {@link PharmMLVersion} used in the read model.
	 */
    public final void setUnmarshalVersion(PharmMLVersion version){
    	this.unmarshalVersion = version;
    }
    
    /**
     * Gets the version of PharmML used to marshal this element. If this element has never been marshalled,
     * this method returns null. The version is updated every time a marshal process is performed.
     * @return The {@link PharmMLVersion} value used to marshal this element in the last performed marshalling.
     */
    @XmlTransient
    public final PharmMLVersion getMarshalVersion(){
    	return marshalVersion;
    }
    
    /**
     * Sets the PharmML version used to marshal this object. This method is used during the marshalling process
     * to update the version and should never be used by the client.
     * @param version The {@link PharmMLVersion} used for marshalling.
     */
    public final void setMarshalVersion(PharmMLVersion version){
    	this.marshalVersion = version;
    }

}
