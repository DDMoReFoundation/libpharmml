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
package eu.ddmore.libpharmml.dom.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import eu.ddmore.libpharmml.dom.commontypes.MissingDataAttribute;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;


/**
 * <p>Java class for MissingDataMapType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MissingDataMapType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="dataCode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="missingDataType" use="required" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}MissingDataAttributeType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MissingDataMapType")
public class MissingDataMap
    extends PharmMLRootType
{

    @XmlAttribute(name = "dataCode", required = true)
    protected String dataCode;
    @XmlAttribute(name = "missingDataType", required = true)
    protected MissingDataAttribute missingDataType;
    
    /**
     * Empty constructor.
     */
    public MissingDataMap(){}
    
    /**
     * Constructs a {@link MissingDataMap} with the given data code and missing data attribute.
     * @param dataCode Symbol used in the dataset.
     * @param missingData Allowed missing data categories.
     */
    public MissingDataMap(String dataCode, MissingDataAttribute missingData){
    	this.dataCode = dataCode;
    	this.missingDataType = missingData;
    }

    /**
     * Symbol used in the dataset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCode() {
        return dataCode;
    }

    /**
     * Symbol used in the dataset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCode(String value) {
        this.dataCode = value;
    }

    /**
     * Gets the value of the missingDataType property.
     * 
     * @return
     *     possible object is
     *     {@link MissingDataAttribute }
     *     
     */
    public MissingDataAttribute getMissingDataType() {
        return missingDataType;
    }

    /**
     * Sets the value of the missingDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MissingDataAttribute }
     *     
     */
    public void setMissingDataType(MissingDataAttribute value) {
        this.missingDataType = value;
    }

}
