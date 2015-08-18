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
package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Class defining the limit of an {@link Interval}. The endpoints can be closed (default) or open.    
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndpointType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}StandardAssignType">
 *       &lt;attribute name="type" default="closed">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="closed"/>
 *             &lt;enumeration value="open"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndpointType")
public class Endpoint
    extends StandardAssignable
{

    @XmlAttribute(name = "type")
    protected EndpointType type;
    
    /**
     * Empty constructor.
     */
    public Endpoint(){}
    
    public Endpoint(EndpointType type){
    	this.type = type;
    }

    /**
     * Gets the type of this endpoint: closed (default) or open.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public EndpointType getType() {
    	if(type == null){
    		return EndpointType.CLOSED;
    	} else {
            return type;
    	}
    }

    /**
     * Sets the type of this endpoint (closed or open).
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointType }
     *     
     */
    public void setType(EndpointType value) {
        this.type = value;
    }

}
