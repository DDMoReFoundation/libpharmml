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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.uncertml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NaturalNumberArrayValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaturalNumberArrayValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.uncertml.org/3.0}arrayVar"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{http://www.uncertml.org/3.0}var"/>
 *           &lt;element ref="{http://www.uncertml.org/3.0}nVal"/>
 *         &lt;/choice>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.uncertml.org/3.0}HREFAttributeGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalNumberArrayValueType", propOrder = {
    "arrayVar",
    "varOrNVal"
})
public class NaturalNumberArrayValueType {

    protected ArrayVarRefType arrayVar;
    @XmlElements({
        @XmlElement(name = "var", type = VarRefType.class),
        @XmlElement(name = "nVal", type = BigInteger.class)
    })
    protected List<Object> varOrNVal;
    @XmlAttribute(name = "href")
    @XmlSchemaType(name = "anyURI")
    protected java.lang.String href;
    @XmlAttribute(name = "mimeType")
    protected java.lang.String mimeType;

    /**
     * Gets the value of the arrayVar property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayVarRefType }
     *     
     */
    public ArrayVarRefType getArrayVar() {
        return arrayVar;
    }

    /**
     * Sets the value of the arrayVar property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayVarRefType }
     *     
     */
    public void setArrayVar(ArrayVarRefType value) {
        this.arrayVar = value;
    }

    /**
     * Gets the value of the varOrNVal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the varOrNVal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVarOrNVal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VarRefType }
     * {@link BigInteger }
     * 
     * 
     */
    public List<Object> getVarOrNVal() {
        if (varOrNVal == null) {
            varOrNVal = new ArrayList<Object>();
        }
        return this.varOrNVal;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setHref(java.lang.String value) {
        this.href = value;
    }

    /**
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setMimeType(java.lang.String value) {
        this.mimeType = value;
    }

}
