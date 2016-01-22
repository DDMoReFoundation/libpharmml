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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;


/**
 * <p>Java class for HeaderDefnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderDefnType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="headerType" use="required" type="{http://www.pharmml.org/pharmml/0.7/Dataset}HeaderTypeType" />
 *       &lt;attribute name="rowNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderDefnType")
public class HeaderDefinition
    extends PharmMLRootType
{

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "headerType", required = true)
    protected String headerType;
    @XmlAttribute(name = "rowNumber", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected Integer rowNumber;
    
    /**
     * Empty constructor.
     */
    public HeaderDefinition(){}
    
    public HeaderDefinition(String name, HeaderType headerType, Integer rowNumber){
    	this.name = name;
    	this.headerType = headerType.value();
    	this.rowNumber = rowNumber;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the headerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeaderType() {
        return headerType;
    }

    /**
     * Sets the value of the headerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeaderType(String value) {
        this.headerType = value;
    }

    /**
     * Gets the value of the rowNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRowNumber() {
        return rowNumber;
    }

    /**
     * Sets the value of the rowNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRowNumber(Integer value) {
        this.rowNumber = value;
    }

}
